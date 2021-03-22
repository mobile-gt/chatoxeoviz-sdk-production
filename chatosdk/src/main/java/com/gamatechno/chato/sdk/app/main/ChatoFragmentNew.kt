package com.gamatechno.chato.sdk.app.main

import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gamatechno.chato.sdk.R
import com.gamatechno.chato.sdk.app.chatroom.ChatRoomActivity
import com.gamatechno.chato.sdk.app.chatrooms.ChatRoomsFragmentNew
import com.gamatechno.chato.sdk.app.chatrooms.adapter.RoomAdapter.OnObrolanAdapter
import com.gamatechno.chato.sdk.app.chatrooms.uimodel.ChatRoomsUiModel
import com.gamatechno.chato.sdk.app.grouproomadd.addgroup.addmember.AddMemberDialog
import com.gamatechno.chato.sdk.app.grouproomadd.addgroup.addmember.AddMemberDialog.OnAddMember
import com.gamatechno.chato.sdk.app.grouproomadd.addgroup.detailgroup.AddDetailGroupDialog
import com.gamatechno.chato.sdk.app.grouproomadd.addgroup.detailgroup.AddDetailGroupDialog.OnAddDetailGroup
import com.gamatechno.chato.sdk.app.kontakchat.KontakChatDialog
import com.gamatechno.chato.sdk.app.kontakchat.KontakChatDialog.OnKontakChatDialog
import com.gamatechno.chato.sdk.app.kontakchat.KontakModel
import com.gamatechno.chato.sdk.app.main.searchlist.AdapterSearchList
import com.gamatechno.chato.sdk.app.main.searchlist.SearchChatroomModel
import com.gamatechno.chato.sdk.data.constant.StringConstant
import com.gamatechno.chato.sdk.module.dialogs.DialogImagePicker.DialogImagePicker
import com.gamatechno.chato.sdk.module.dialogs.DialogImagePicker.DialogImagePicker.OnDialogImagePicker
import com.gamatechno.chato.sdk.utils.ChatoUtils
import com.gamatechno.ggfw.Activity.Interfaces.PermissionResultInterface
import com.gamatechno.ggfw.easyphotopicker.DefaultCallback
import com.gamatechno.ggfw.easyphotopicker.EasyImage
import com.gamatechno.ggfw.easyphotopicker.EasyImage.ImageSource
import com.gamatechno.ggfw.utils.AlertDialogBuilder
import com.gamatechno.ggfw.utils.GGFWUtil
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.activity_chato_new.*
import kotlinx.android.synthetic.main.layout_helper.*
import java.io.File
import java.util.*

class ChatoFragmentNew : ChatRoomsFragmentNew(), ChatView.View, View.OnClickListener {
    var kontakChatDialog: KontakChatDialog? = null
    var presenter: ChatPresenter? = null
    var mSearch: MenuItem? = null
    var mSearchView: SearchView? = null
    var isObrolan = true

    var isSearchh = false

    var isPinnedRoom = true

    var list_searchlist: MutableList<SearchChatroomModel> = ArrayList()
    var adapterSearchList: AdapterSearchList? = null

    private val RequiredPermissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    var addMemberDialog: AddMemberDialog? = null
    var addDetailGroupDialog: AddDetailGroupDialog? = null

    var imagepicker_code = ""

    fun newInstance(): ChatoFragmentNew? {
        return ChatoFragmentNew()
    }

    private var timer = Timer()
    private val DELAY: Long = 1000 // milliseconds


    private var rootview: View? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: Tes here")
        //        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");
        initSearchChatroom()
        presenter = ChatPresenter(context!!, this)
        wrapper_top.setInOutAnimation(R.anim.pull_in_bottom, R.anim.push_out_top)
        toggle_fab.setInOutAnimation(R.anim.pull_in_top, R.anim.push_out_bottom)

//        toggle_fab.setInOutAnimation(R.anim.pull_in_top, R.anim.slide_out_bottom);
        viewModel!!.initBackPressed().observe(
            viewLifecycleOwner,
            Observer { isBackPressed ->
                if (isBackPressed != null && isBackPressed) {
                    if (isSearchh) {
                        viewModel!!.updateKeyword("")
                        showOrHideTopView(true, false)
                    } else {
                        viewModel!!.updateBackPressedUpdate(isSearchh)
                    }
                } else if (isBackPressed != null && !isBackPressed) {
                    showOrHideTopView(true, false)
                }
            })
        viewModel!!.initKeyword()
            .observe(viewLifecycleOwner, Observer { s ->
                if (s == "") {
                    edt_search.setText("")
                    //                    showOrHideTopView(true, true);
                    lay_searchlist.setVisibility(View.GONE)
                    list_searchlist.clear()
                    adapterSearchList!!.notifyDataSetChanged()

                    keyword = s
                    uncheckTheChatRoom(false)
                } else {
                    lay_searchlist.setVisibility(View.VISIBLE)
                    presenter!!.searchChat(s)
                }
            })
        viewModel!!.initChatRoomsLongPress().observe(
            viewLifecycleOwner,
            Observer { chatRoomUiModel ->
                if (chatRoomUiModel != null) {
                    if (chatRoomUiModel.is_checked) {
                        showOrHideTopView(false, false)
                        tv_action_title.setText(chatRoomUiModel.roomChat.room_name)
                        ll_search.setVisibility(View.GONE)
                        lay_appbar.setVisibility(View.VISIBLE)
                        isPinnedRoom = true
                        if (chatRoomUiModel.roomChat.is_pined == 0) {
                            img_pin.setImageResource(R.drawable.ic_pin_chat)
                        } else {
                            img_pin.setImageResource(R.drawable.ic_unpin_chat)
                        }
                    } else {
                        showOrHideTopView(true, false)
                    }
                }
            })
        fab_add.setOnClickListener(View.OnClickListener { initKontakDialog() })
        edt_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
                if (charSequence.toString() != "") {
                    img_clear_search.setVisibility(View.VISIBLE)
                } else {
                    img_clear_search.setVisibility(View.GONE)
                }
                if (isSearchh) {
                    timer.cancel()
                    timer = Timer()
                    timer.schedule(
                        object : TimerTask() {
                            override fun run() {
                                viewModel!!.updateKeyword(edt_search.getText().toString())
                            }
                        },
                        DELAY
                    )
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        img_back_search.setOnClickListener(this)
        img_pin.setOnClickListener(this)
        img_label.setOnClickListener(this)
        img_delete_chat.setOnClickListener(this)
        img_clear_search.setOnClickListener(this)
    }

    fun setViewOnClickEvent(view: View) {
        Log.d(TAG, "setViewOnClickEvent: " + view.id)
        val id = view.id
        if (id == R.id.img_back_search) {
            viewModel!!.updateKeyword("")
            showOrHideTopView(true, false)
        } else if (id == R.id.img_pin) {
            viewModel!!.updateRequestPin(isPinnedRoom)
            showOrHideTopView(true, false)
        } else if (id == R.id.img_delete_chat) {
            AlertDialogBuilder(
                context,
                "Apakah Anda yakin ingin menghapus obrolan ini?",
                "Ya",
                "Tidak",
                object : AlertDialogBuilder.OnAlertDialog {
                    override fun onPositiveButton(dialog: DialogInterface) {
                        viewModel!!.updateRequestDelete(isPinnedRoom)
                        showOrHideTopView(true, false)
                    }

                    override fun onNegativeButton(dialog: DialogInterface) {}
                })
        } else if (id == R.id.img_label) {
            viewModel!!.updateLabel(true)
        } else if (id == R.id.img_clear_search) {
            if (edt_search.getText().toString() == "") {
                showOrHideTopView(true, false)
            } else {
                edt_search.setText("")
            }
        }
    }

    private fun initSearchChatroom() {
        adapterSearchList =
            AdapterSearchList(context, list_searchlist, object : OnObrolanAdapter {
                override fun onClickObrolan(model: ChatRoomsUiModel) {
                    viewModel!!.updateChatRoomsClickFromSearch(model)
                }

                override fun onLongClick(model: ChatRoomsUiModel) {
                    viewModel!!.updateChatRoomsLongPressFromSearch(model)
                }
            })
        rv_searchlist.setLayoutManager(LinearLayoutManager(context))
        rv_searchlist.setAdapter(adapterSearchList)
    }

    private fun showOrHideTopView(
        isSHow: Boolean,
        isSearch: Boolean
    ) {
        isSearchh = isSearch
        if (isSHow) {
            wrapper_top.displaying(lay_top)
            wrapper_top.hide(lay_search)
            ChatoUtils.hideSoftKeyboard(context, edt_search)
        } else {
            if (isSearch) {
                ll_search.setVisibility(View.VISIBLE)
                lay_appbar.setVisibility(View.GONE)
                ChatoUtils.showKeyboard(context, edt_search)
            } else {
                ll_search.setVisibility(View.GONE)
                lay_appbar.setVisibility(View.VISIBLE)
            }
            if (!wrapper_top.isDisplaying(lay_search)) {
                wrapper_top.displaying(lay_search)
                wrapper_top.hide(lay_top)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.action_search) {
            showOrHideTopView(false, true)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSearchChat(list: MutableList<SearchChatroomModel>) {
        list_searchlist.clear()
        if (list.size > 0) {
            helper_nodata.setVisibility(View.GONE)
            list_searchlist.addAll(list)
        } else {
            helper_nodata.setVisibility(View.VISIBLE)
            tv_nodata.setText("Ruang obrolan tidak ditemukan")
        }
        adapterSearchList!!.notifyDataSetChanged()
    }

    override fun onFailedRequestChat() {
        list_searchlist.clear()
        adapterSearchList!!.notifyDataSetChanged()
    }

    override fun onClick(view: View) {
        setViewOnClickEvent(view)
    }

    private fun initSearch() {
        mSearch!!.setOnMenuItemClickListener { false }
        mSearchView = mSearch!!.actionView as SearchView
        mSearchView!!.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    private fun initKontakDialog() {
        if (kontakChatDialog == null) {
            kontakChatDialog =
                KontakChatDialog(context!!, true, false, object : OnKontakChatDialog {
                    override fun onClickKontak(model: KontakModel) {
                        val intent = Intent(
                            context,
                            ChatRoomActivity::class.java
                        )
                        intent.putExtra("data", model)
                        startActivity(intent)
                    }

                    override fun onAddGroup() {
                        addGroup()
                    }
                })
        } else {
            kontakChatDialog!!.show()
        }
    }

    private fun addGroup() {
        addMemberDialog = AddMemberDialog(context,
            OnAddMember { dialog, list ->
                addDetailGroupDialog =
                    AddDetailGroupDialog(context, list, object : OnAddDetailGroup {
                        override fun onImageClick() {
                            imagepicker_code =
                                StringConstant.imagepicker_addgroup
                            askCompactPermissions(
                                RequiredPermissions,
                                object : PermissionResultInterface {
                                    override fun permissionGranted() {
                                        DialogImagePicker(
                                            context,
                                            object : OnDialogImagePicker {
                                                override fun onCameraClick() {
                                                    EasyImage.openCamera(this@ChatoFragmentNew, 0)
                                                }

                                                override fun onFileManagerClick() {
                                                    EasyImage.openGallery(this@ChatoFragmentNew, 0)
                                                }

                                                override fun onVideoCameraClick() {}
                                            })
                                    }

                                    override fun permissionDenied() {
                                        GGFWUtil.ToastShort(
                                            context,
                                            "Anda perlu memberikan akses terlebih dahulu"
                                        )
                                    }
                                })
                        }

                        override fun onSuccessAddGroup() {
                            addMemberDialog!!.dismiss()
                            viewModel!!.updateRefreshRoom(true)
                        }

                        override fun onCancelAddDetailGroup() {
                            addMemberDialog!!.show()
                        }
                    })
            })
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater
    ) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK) {
                val resultUri = result.uri
                if (imagepicker_code == StringConstant.imagepicker_addgroup) {
                    addDetailGroupDialog!!.setImageGroup(
                        GGFWUtil.getBitmapFromUri(
                            context,
                            resultUri
                        ), resultUri
                    )
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error.toString()
                GGFWUtil.ToastShort(context, "" + error)
            }
        } else {
            EasyImage.handleActivityResult(
                requestCode,
                resultCode,
                data,
                activity,
                object : DefaultCallback() {
                    override fun onImagePickerError(
                        e: Exception,
                        source: ImageSource,
                        type: Int
                    ) {
                        e.printStackTrace()
                    }

                    override fun onImagesPicked(
                        imageFiles: List<File>,
                        source: ImageSource,
                        type: Int
                    ) {
                        Log.d(TAG, "onImagesPicked: $type")
                        startCropActivity(Uri.fromFile(imageFiles[0]))
                    }

                    override fun onCanceled(source: ImageSource, type: Int) {
                        //Cancel handling, you might wanna remove taken photo if it was canceled
                        if (source == ImageSource.CAMERA) {
                            val photoFile =
                                EasyImage.lastlyTakenButCanceledPhoto(context!!)
                            photoFile?.delete()
                        }
                    }
                })
        }
    }

    private fun startCropActivity(uri: Uri) {
        CropImage.activity(uri)
            .setCropShape(CropImageView.CropShape.RECTANGLE)
            .start(activity!!)
    }

}