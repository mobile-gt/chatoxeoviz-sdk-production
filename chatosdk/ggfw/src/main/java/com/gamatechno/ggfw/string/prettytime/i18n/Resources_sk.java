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
import com.gamatechno.ggfw.string.prettytime.units.Hour;
import com.gamatechno.ggfw.string.prettytime.units.Minute;
import com.gamatechno.ggfw.string.prettytime.units.Month;
import com.gamatechno.ggfw.string.prettytime.units.Week;
import com.gamatechno.ggfw.string.prettytime.units.Year;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author Michal Urs??ny & Stefan Kostelny based on cs variant by Martin Kouba
 */
public class Resources_sk extends ListResourceBundle implements TimeFormatProvider
{
   private static final Object[][] OBJECTS = new Object[][] {

            { "CenturyPattern", "%n %u" },
            { "CenturyFuturePrefix", "o " },
            { "CenturyFutureSuffix", "" },
            { "CenturyPastPrefix", "pred " },
            { "CenturyPastSuffix", "" },
            { "CenturySingularName", "storo??ie" },
            { "CenturyPluralName", "storo??ia" },
            { "CenturyPastSingularName", "storo????m" },
            { "CenturyPastPluralName", "storo??iami" },
            { "CenturyFutureSingularName", "storo????" },
            { "CenturyFuturePluralName", "storo??ia" },

            { "DayPattern", "%n %u" },
            { "DayFuturePrefix", "o " },
            { "DayFutureSuffix", "" },
            { "DayPastPrefix", "pred " },
            { "DayPastSuffix", "" },
            { "DaySingularName", "de??" },
            { "DayPluralName", "dni" },

            { "DecadePattern", "%n %u" },
            { "DecadeFuturePrefix", "o " },
            { "DecadeFutureSuffix", "" },
            { "DecadePastPrefix", "pred " },
            { "DecadePastSuffix", "" },
            { "DecadeSingularName", "desa??ro??ie" },
            { "DecadePluralName", "desa??ro??ia" },
            { "DecadePastSingularName", "desa??ro????m" },
            { "DecadePastPluralName", "desa??ro??iami" },
            { "DecadeFutureSingularName", "desa??ro????" },
            { "DecadeFuturePluralName", "desa??ro??ia" },

            { "HourPattern", "%n %u" },
            { "HourFuturePrefix", "o " },
            { "HourFutureSuffix", "" },
            { "HourPastPrefix", "pred" },
            { "HourPastSuffix", "" },
            { "HourSingularName", "hodina" },
            { "HourPluralName", "hodiny" },

            { "JustNowPattern", "%u" },
            { "JustNowFuturePrefix", "" },
            { "JustNowFutureSuffix", "o chv????u" },
            { "JustNowPastPrefix", "pred chv????ou" },
            { "JustNowPastSuffix", "" },
            { "JustNowSingularName", "" },
            { "JustNowPluralName", "" },

            { "MillenniumPattern", "%n %u" },
            { "MillenniumFuturePrefix", "o " },
            { "MillenniumFutureSuffix", "" },
            { "MillenniumPastPrefix", "pred " },
            { "MillenniumPastSuffix", "" },
            { "MillenniumSingularName", "t??s??cro??ie" },
            { "MillenniumPluralName", "tis??cro??ia" },

            { "MillisecondPattern", "%n %u" },
            { "MillisecondFuturePrefix", "o " },
            { "MillisecondFutureSuffix", "" },
            { "MillisecondPastPrefix", "pred " },
            { "MillisecondPastSuffix", "" },
            { "MillisecondSingularName", "milisekunda" },
            { "MillisecondPluralName", "milisekundy" },
            { "MillisecondPastSingularName", "milisekundou" },
            { "MillisecondPastPluralName", "milisekundami" },
            { "MillisecondFutureSingularName", "milisekundu" },
            { "MillisecondFuturePluralName", "milisek??nd" },

            { "MinutePattern", "%n %u" },
            { "MinuteFuturePrefix", "o " },
            { "MinuteFutureSuffix", "" },
            { "MinutePastPrefix", "pred " },
            { "MinutePastSuffix", "" },
            { "MinuteSingularName", "min??ta" },
            { "MinutePluralName", "min??ty" },

            { "MonthPattern", "%n %u" },
            { "MonthFuturePrefix", "o " },
            { "MonthFutureSuffix", "" },
            { "MonthPastPrefix", "pred " },
            { "MonthPastSuffix", "" },
            { "MonthSingularName", "mesiac" },
            { "MonthPluralName", "mesiace" },

            { "SecondPattern", "%n %u" },
            { "SecondFuturePrefix", "o " },
            { "SecondFutureSuffix", "" },
            { "SecondPastPrefix", "pred " },
            { "SecondPastSuffix", "" },
            { "SecondSingularName", "sekunda" },
            { "SecondPluralName", "sekundy" },

            { "WeekPattern", "%n %u" },
            { "WeekFuturePrefix", "o " },
            { "WeekFutureSuffix", "" },
            { "WeekPastPrefix", "pred " },
            { "WeekPastSuffix", "" },
            { "WeekSingularName", "t????de??" },
            { "WeekPluralName", "t????dne" },

            { "YearPattern", "%n %u" },
            { "YearFuturePrefix", "o " },
            { "YearFutureSuffix", "" },
            { "YearPastPrefix", "pred " },
            { "YearPastSuffix", "" },
            { "YearSingularName", "rok" },
            { "YearPluralName", "roky" },

            { "AbstractTimeUnitPattern", "" },
            { "AbstractTimeUnitFuturePrefix", "" },
            { "AbstractTimeUnitFutureSuffix", "" },
            { "AbstractTimeUnitPastPrefix", "" },
            { "AbstractTimeUnitPastSuffix", "" },
            { "AbstractTimeUnitSingularName", "" },
            { "AbstractTimeUnitPluralName", "" } };

   @Override
   public Object[][] getContents()
   {
      return OBJECTS;
   }

   @Override
   public TimeFormat getFormatFor(TimeUnit t)
   {
      if (t instanceof Minute) {
         return new CsTimeFormatBuilder("Minute")
                  .addFutureName("min??tu", 1)
                  .addFutureName("min??ty", 4)
                  .addFutureName("min??t", Long.MAX_VALUE)
                  .addPastName("min??tou", 1)
                  .addPastName("min??tami", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Hour) {
         return new CsTimeFormatBuilder("Hour")
                  .addFutureName("hodinu", 1)
                  .addFutureName("hodiny", 4)
                  .addFutureName("hod??n", Long.MAX_VALUE)
                  .addPastName("hodinou", 1)
                  .addPastName("hodinami", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Day) {
         return new CsTimeFormatBuilder("Day")
                  .addFutureName("de??", 1)
                  .addFutureName("dni", 4)
                  .addFutureName("dn??", Long.MAX_VALUE)
                  .addPastName("d??om", 1)
                  .addPastName("d??ami", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Week) {
         return new CsTimeFormatBuilder("Week")
                  .addFutureName("t????de??", 1)
                  .addFutureName("t????dne", 4)
                  .addFutureName("t????d??ov", Long.MAX_VALUE)
                  .addPastName("t????d??om", 1)
                  .addPastName("t????d??ami", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Month) {
         return new CsTimeFormatBuilder("Month")
                  .addFutureName("mesiac", 1)
                  .addFutureName("mesiace", 4)
                  .addFutureName("mesiacov", Long.MAX_VALUE)
                  .addPastName("mesiacom", 1)
                  .addPastName("mesiacmi", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Year) {
         return new CsTimeFormatBuilder("Year")
                  .addFutureName("rok", 1)
                  .addFutureName("roky", 4)
                  .addFutureName("rokov", Long.MAX_VALUE)
                  .addPastName("rokom", 1)
                  .addPastName("rokmi", Long.MAX_VALUE)
                  .build(this);
      }
      // Don't override format for other time units
      return null;
   }

   private static class CsTimeFormatBuilder
   {

      private List<CsName> names = new ArrayList<CsName>();

      private String resourceKeyPrefix;

      CsTimeFormatBuilder(String resourceKeyPrefix)
      {
         this.resourceKeyPrefix = resourceKeyPrefix;
      }

      CsTimeFormatBuilder addFutureName(String name, long limit)
      {
         return addName(true, name, limit);
      }

      CsTimeFormatBuilder addPastName(String name, long limit)
      {
         return addName(false, name, limit);
      }

      private CsTimeFormatBuilder addName(boolean isFuture, String name, long limit)
      {
         if (name == null) {
            throw new IllegalArgumentException();
         }
         names.add(new CsName(isFuture, name, limit));
         return this;
      }

      CsTimeFormat build(final ResourceBundle bundle)
      {
         return new CsTimeFormat(resourceKeyPrefix, bundle, names);
      }

   }

   private static class CsTimeFormat extends SimpleTimeFormat implements TimeFormat
   {

      private final List<CsName> futureNames = new ArrayList<CsName>();

      private final List<CsName> pastNames = new ArrayList<CsName>();

      public CsTimeFormat(String resourceKeyPrefix, ResourceBundle bundle, Collection<CsName> names)
      {
         setPattern(bundle.getString(resourceKeyPrefix + "Pattern"));
         setFuturePrefix(bundle.getString(resourceKeyPrefix + "FuturePrefix"));
         setFutureSuffix(bundle.getString(resourceKeyPrefix + "FutureSuffix"));
         setPastPrefix(bundle.getString(resourceKeyPrefix + "PastPrefix"));
         setPastSuffix(bundle.getString(resourceKeyPrefix + "PastSuffix"));
         setSingularName(bundle.getString(resourceKeyPrefix + "SingularName"));
         setPluralName(bundle.getString(resourceKeyPrefix + "PluralName"));

         try {
            setFuturePluralName(bundle.getString(resourceKeyPrefix + "FuturePluralName"));
         }
         catch (Exception e) {}
         try {
            setFutureSingularName((bundle.getString(resourceKeyPrefix + "FutureSingularName")));
         }
         catch (Exception e) {}
         try {
            setPastPluralName((bundle.getString(resourceKeyPrefix + "PastPluralName")));
         }
         catch (Exception e) {}
         try {
            setPastSingularName((bundle.getString(resourceKeyPrefix + "PastSingularName")));
         }
         catch (Exception e) {}

         for (CsName name : names) {
            if (name.isFuture()) {
               futureNames.add(name);
            }
            else {
               pastNames.add(name);
            }
         }
         Collections.sort(futureNames);
         Collections.sort(pastNames);
      }

      @Override
      protected String getGramaticallyCorrectName(Duration d, boolean round)
      {
         long quantity = Math.abs(getQuantity(d, round));
         if (d.isInFuture()) {
            return getGramaticallyCorrectName(quantity, futureNames);
         }
         return getGramaticallyCorrectName(quantity, pastNames);
      }

      private String getGramaticallyCorrectName(long quantity, List<CsName> names)
      {
         for (CsName name : names) {
            if (name.getThreshold() >= quantity) {
               return name.get();
            }
         }
         throw new IllegalStateException("Invalid resource bundle configuration");
      }

   }

   private static class CsName implements Comparable<CsName>
   {

      private final boolean isFuture;

      private final String value;

      private final Long threshold;

      public CsName(boolean isFuture, String value, Long threshold)
      {
         this.isFuture = isFuture;
         this.value = value;
         this.threshold = threshold;
      }

      public boolean isFuture()
      {
         return isFuture;
      }

      public String get()
      {
         return value;
      }

      public long getThreshold()
      {
         return threshold;
      }

      @Override
      public int compareTo(CsName o)
      {
         return threshold.compareTo(o.getThreshold());
      }

   }

}
