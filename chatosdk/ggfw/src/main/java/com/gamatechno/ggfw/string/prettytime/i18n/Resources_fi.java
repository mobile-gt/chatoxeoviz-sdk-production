/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018. Shendy Aditya Syamsudin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.gamatechno.ggfw.string.prettytime.i18n;


import com.gamatechno.ggfw.string.prettytime.Duration;
import com.gamatechno.ggfw.string.prettytime.TimeFormat;
import com.gamatechno.ggfw.string.prettytime.TimeUnit;
import com.gamatechno.ggfw.string.prettytime.format.SimpleTimeFormat;
import com.gamatechno.ggfw.string.prettytime.impl.TimeFormatProvider;
import com.gamatechno.ggfw.string.prettytime.units.Day;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Resources_fi extends ListResourceBundle implements TimeFormatProvider
{

   private static final int tolerance = 50;

   private static Object[][] CONTENTS = new Object[][] {
            { "JustNowPattern", "%u" },
            { "JustNowPastSingularName", "hetki" },
            { "JustNowFutureSingularName", "hetken" },
            { "JustNowPastSuffix", "sitten" },
            { "JustNowFutureSuffix", "p????st??" },
            { "MillisecondPattern", "%u" },
            { "MillisecondPluralPattern", "%n %u" },
            { "MillisecondPastSingularName", "millisekunti" },
            { "MillisecondPastPluralName", "millisekuntia" },
            { "MillisecondFutureSingularName", "millisekunnin" },
            { "MillisecondPastSuffix", "sitten" },
            { "MillisecondFutureSuffix", "p????st??" },
            { "SecondPattern", "%u" },
            { "SecondPluralPattern", "%n %u" },
            { "SecondPastSingularName", "sekunti" },
            { "SecondPastPluralName", "sekuntia" },
            { "SecondFutureSingularName", "sekunnin" },
            { "SecondPastSuffix", "sitten" },
            { "SecondFutureSuffix", "p????st??" },
            { "MinutePattern", "%u" },
            { "MinutePluralPattern", "%n %u" },
            { "MinutePastSingularName", "minuutti" },
            { "MinutePastPluralName", "minuuttia" },
            { "MinuteFutureSingularName", "minuutin" },
            { "MinutePastSuffix", "sitten" },
            { "MinuteFutureSuffix", "p????st??" },
            { "HourPattern", "%u" },
            { "HourPluralPattern", "%n %u" },
            { "HourPastSingularName", "tunti" },
            { "HourPastPluralName", "tuntia" },
            { "HourFutureSingularName", "tunnin" },
            { "HourPastSuffix", "sitten" },
            { "HourFutureSuffix", "p????st??" },
            { "DayPattern", "%u" },
            { "DayPluralPattern", "%n %u" },
            { "DayPastSingularName", "eilen" },
            { "DayPastPluralName", "p??iv????" },
            { "DayFutureSingularName", "huomenna" },
            { "DayFuturePluralName", "p??iv??n" },
            { "DayPastSuffix", "sitten" },
            { "DayFutureSuffix", "p????st??" },
            { "WeekPattern", "%u" },
            { "WeekPluralPattern", "%n %u" },
            { "WeekPastSingularName", "viikko" },
            { "WeekPastPluralName", "viikkoa" },
            { "WeekFutureSingularName", "viikon" },
            { "WeekFuturePluralName", "viikon" },
            { "WeekPastSuffix", "sitten" },
            { "WeekFutureSuffix", "p????st??" },
            { "MonthPattern", "%u" },
            { "MonthPluralPattern", "%n %u" },
            { "MonthPastSingularName", "kuukausi" },
            { "MonthPastPluralName", "kuukautta" },
            { "MonthFutureSingularName", "kuukauden" },
            { "MonthPastSuffix", "sitten" },
            { "MonthFutureSuffix", "p????st??" },
            { "YearPattern", "%u" },
            { "YearPluralPattern", "%n %u" },
            { "YearPastSingularName", "vuosi" },
            { "YearPastPluralName", "vuotta" },
            { "YearFutureSingularName", "vuoden" },
            { "YearPastSuffix", "sitten" },
            { "YearFutureSuffix", "p????st??" },
            { "DecadePattern", "%u" },
            { "DecadePluralPattern", "%n %u" },
            { "DecadePastSingularName", "vuosikymmen" },
            { "DecadePastPluralName", "vuosikymment??" },
            { "DecadeFutureSingularName", "vuosikymmenen" },
            { "DecadePastSuffix", "sitten" },
            { "DecadeFutureSuffix", "p????st??" },
            { "CenturyPattern", "%u" },
            { "CenturyPluralPattern", "%n %u" },
            { "CenturyPastSingularName", "vuosisata" },
            { "CenturyPastPluralName", "vuosisataa" },
            { "CenturyFutureSingularName", "vuosisadan" },
            { "CenturyPastSuffix", "sitten" },
            { "CenturyFutureSuffix", "p????st??" },
            { "MillenniumPattern", "%u" },
            { "MillenniumPluralPattern", "%n %u" },
            { "MillenniumPastSingularName", "vuosituhat" },
            { "MillenniumPastPluralName", "vuosituhatta" },
            { "MillenniumFutureSingularName", "vuosituhannen" },
            { "MillenniumPastSuffix", "sitten" },
            { "MillenniumFutureSuffix", "p????st??" },
   };
   private volatile ConcurrentMap<TimeUnit, TimeFormat> formatMap = new ConcurrentHashMap<TimeUnit, TimeFormat>();

   public Resources_fi()
   {}

   @Override
   public TimeFormat getFormatFor(TimeUnit t)
   {
      if (!formatMap.containsKey(t)) {
         formatMap.putIfAbsent(t, new FiTimeFormat(this, t));
      }
      return formatMap.get(t);
   }

   @Override
   protected Object[][] getContents()
   {
      return CONTENTS;
   }

   private static class FiTimeFormat extends SimpleTimeFormat
   {
      private final ResourceBundle bundle;
      private String pastName = "";
      private String futureName = "";
      private String pastPluralName = "";
      private String futurePluralName = "";
      private String pluralPattern = "";

      public FiTimeFormat(final ResourceBundle rb, final TimeUnit unit)
      {
         super();
         this.bundle = rb;

         if (bundle.containsKey(getUnitName(unit) + "PastSingularName")) {
            this.setPastName(bundle.getString(getUnitName(unit) + "PastSingularName"))
                     .setFutureName(bundle.getString(getUnitName(unit) + "FutureSingularName"))
                     .setPastPluralName(bundle.getString(getUnitName(unit) + "PastSingularName"))
                     .setFuturePluralName(bundle.getString(getUnitName(unit) + "FutureSingularName"))
                     .setPluralPattern(bundle.getString(getUnitName(unit) + "Pattern"));

            if (bundle.containsKey(getUnitName(unit) + "PastPluralName")) {
               this.setPastPluralName(bundle.getString(getUnitName(unit) + "PastPluralName"));
            }

            if (bundle.containsKey(getUnitName(unit) + "FuturePluralName")) {
               this.setFuturePluralName(bundle.getString(getUnitName(unit) + "FuturePluralName"));
            }

            if (bundle.containsKey(getUnitName(unit) + "PluralPattern")) {
               this.setPluralPattern(bundle.getString(getUnitName(unit) + "PluralPattern"));
            }

            this.setPattern(bundle.getString(getUnitName(unit) + "Pattern"))
                     .setPastSuffix(bundle.getString(getUnitName(unit) + "PastSuffix"))
                     .setFutureSuffix(bundle.getString(getUnitName(unit) + "FutureSuffix"))
                     .setFuturePrefix("")
                     .setPastPrefix("")
                     .setSingularName("")
                     .setPluralName("");
         }
      }

      public String getPastName()
      {
         return pastName;
      }

      public String getFutureName()
      {
         return futureName;
      }

      public String getPastPluralName()
      {
         return pastPluralName;
      }

      public String getFuturePluralName()
      {
         return futurePluralName;
      }

      public String getPluralPattern()
      {
         return pluralPattern;
      }

      public FiTimeFormat setPastName(String pastName)
      {
         this.pastName = pastName;
         return this;
      }

      public FiTimeFormat setFutureName(String futureName)
      {
         this.futureName = futureName;
         return this;
      }

      public FiTimeFormat setPastPluralName(String pastName)
      {
         this.pastPluralName = pastName;
         return this;
      }

      public FiTimeFormat setFuturePluralName(String futureName)
      {
         this.futurePluralName = futureName;
         return this;
      }

      public FiTimeFormat setPluralPattern(String pattern)
      {
         this.pluralPattern = pattern;
         return this;
      }

      @Override
      protected String getGramaticallyCorrectName(Duration d, boolean round)
      {
         String result = d.isInPast() ? getPastName() : getFutureName();
         if ((Math.abs(getQuantity(d, round)) == 0) || (Math.abs(getQuantity(d, round)) > 1))
         {
            result = d.isInPast() ? getPastPluralName() : getFuturePluralName();
         }
         return result;
      }

      @Override
      protected String getPattern(long quantity)
      {
         if (Math.abs(quantity) == 1) {
            return getPattern();
         }
         return getPluralPattern();

      }

      @Override
      public String decorate(Duration duration, String time)
      {
         String result = "";
         if (duration.getUnit() instanceof Day && Math.abs(duration.getQuantityRounded(tolerance)) == 1) {
            result = time;
         }
         else {
            result = super.decorate(duration, time);
         }
         return result;
      }

      private String getUnitName(TimeUnit unit)
      {
         return unit.getClass().getSimpleName();
      }

   }

}
