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
package com.gamatechno.ggfw.prettytime.i18n;

import com.gamatechno.ggfw.prettytime.Duration;
import com.gamatechno.ggfw.prettytime.TimeFormat;
import com.gamatechno.ggfw.prettytime.TimeUnit;
import com.gamatechno.ggfw.prettytime.format.SimpleTimeFormat;
import com.gamatechno.ggfw.prettytime.impl.TimeFormatProvider;
import com.gamatechno.ggfw.prettytime.units.Day;
import com.gamatechno.ggfw.prettytime.units.Hour;
import com.gamatechno.ggfw.prettytime.units.Minute;
import com.gamatechno.ggfw.prettytime.units.Month;
import com.gamatechno.ggfw.prettytime.units.Week;
import com.gamatechno.ggfw.prettytime.units.Year;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;


/**
 *
 * @author Martin Kouba
 */
public class Resources_cs extends ListResourceBundle implements TimeFormatProvider
{
   private static final Object[][] OBJECTS = new Object[][] {

            { "CenturyPattern", "%n %u" },
            { "CenturyFuturePrefix", "za " },
            { "CenturyFutureSuffix", "" },
            { "CenturyPastPrefix", "p??ed " },
            { "CenturyPastSuffix", "" },
            { "CenturySingularName", "stolet??" },
            { "CenturyPluralName", "stolet??" },
            { "CenturyPastSingularName", "stolet??m" },
            { "CenturyPastPluralName", "stolet??mi" },
            { "CenturyFutureSingularName", "stolet??" },
            { "CenturyFuturePluralName", "stolet??" },

            { "DayPattern", "%n %u" },
            { "DayFuturePrefix", "za " },
            { "DayFutureSuffix", "" },
            { "DayPastPrefix", "p??ed " },
            { "DayPastSuffix", "" },
            { "DaySingularName", "den" },
            { "DayPluralName", "dny" },

            { "DecadePattern", "%n %u" },
            { "DecadeFuturePrefix", "za " },
            { "DecadeFutureSuffix", "" },
            { "DecadePastPrefix", "p??ed " },
            { "DecadePastSuffix", "" },
            { "DecadeSingularName", "desetilet??" },
            { "DecadePluralName", "desetilet??" },
            { "DecadePastSingularName", "desetilet??m" },
            { "DecadePastPluralName", "desetilet??mi" },
            { "DecadeFutureSingularName", "desetilet??" },
            { "DecadeFuturePluralName", "desetilet??" },

            { "HourPattern", "%n %u" },
            { "HourFuturePrefix", "za " },
            { "HourFutureSuffix", "" },
            { "HourPastPrefix", "p??ed" },
            { "HourPastSuffix", "" },
            { "HourSingularName", "hodina" },
            { "HourPluralName", "hodiny" },

            { "JustNowPattern", "%u" },
            { "JustNowFuturePrefix", "" },
            { "JustNowFutureSuffix", "za chv??li" },
            { "JustNowPastPrefix", "p??ed chv??l??" },
            { "JustNowPastSuffix", "" },
            { "JustNowSingularName", "" },
            { "JustNowPluralName", "" },

            { "MillenniumPattern", "%n %u" },
            { "MillenniumFuturePrefix", "za " },
            { "MillenniumFutureSuffix", "" },
            { "MillenniumPastPrefix", "p??ed " },
            { "MillenniumPastSuffix", "" },
            { "MillenniumSingularName", "tis??cilet??" },
            { "MillenniumPluralName", "tis??cilet??" },

            { "MillisecondPattern", "%n %u" },
            { "MillisecondFuturePrefix", "za " },
            { "MillisecondFutureSuffix", "" },
            { "MillisecondPastPrefix", "p??ed " },
            { "MillisecondPastSuffix", "" },
            { "MillisecondSingularName", "milisekunda" },
            { "MillisecondPluralName", "milisekundy" },
            { "MillisecondPastSingularName", "milisekundou" },
            { "MillisecondPastPluralName", "milisekundami" },
            { "MillisecondFutureSingularName", "milisekundu" },
            { "MillisecondFuturePluralName", "milisekund" },

            { "MinutePattern", "%n %u" },
            { "MinuteFuturePrefix", "za " },
            { "MinuteFutureSuffix", "" },
            { "MinutePastPrefix", "p??ed " },
            { "MinutePastSuffix", "" },
            { "MinuteSingularName", "minuta" },
            { "MinutePluralName", "minuty" },

            { "MonthPattern", "%n %u" },
            { "MonthFuturePrefix", "za " },
            { "MonthFutureSuffix", "" },
            { "MonthPastPrefix", "p??ed " },
            { "MonthPastSuffix", "" },
            { "MonthSingularName", "m??s??c" },
            { "MonthPluralName", "m??s??ce" },

            { "SecondPattern", "%n %u" },
            { "SecondFuturePrefix", "za " },
            { "SecondFutureSuffix", "" },
            { "SecondPastPrefix", "p??ed " },
            { "SecondPastSuffix", "" },
            { "SecondSingularName", "sekunda" },
            { "SecondPluralName", "sekundy" },

            { "WeekPattern", "%n %u" },
            { "WeekFuturePrefix", "za " },
            { "WeekFutureSuffix", "" },
            { "WeekPastPrefix", "p??ed " },
            { "WeekPastSuffix", "" },
            { "WeekSingularName", "t??den" },
            { "WeekPluralName", "t??dny" },

            { "YearPattern", "%n %u" },
            { "YearFuturePrefix", "za " },
            { "YearFutureSuffix", "" },
            { "YearPastPrefix", "p??ed " },
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
                  .addFutureName("minutu", 1)
                  .addFutureName("minuty", 4)
                  .addFutureName("minut", Long.MAX_VALUE)
                  .addPastName("minutou", 1)
                  .addPastName("minutami", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Hour) {
         return new CsTimeFormatBuilder("Hour")
                  .addFutureName("hodinu", 1)
                  .addFutureName("hodiny", 4)
                  .addFutureName("hodin", Long.MAX_VALUE)
                  .addPastName("hodinou", 1)
                  .addPastName("hodinami", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Day) {
         return new CsTimeFormatBuilder("Day")
                  .addFutureName("den", 1)
                  .addFutureName("dny", 4)
                  .addFutureName("dn??", Long.MAX_VALUE)
                  .addPastName("dnem", 1)
                  .addPastName("dny", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Week) {
         return new CsTimeFormatBuilder("Week")
                  .addFutureName("t??den", 1)
                  .addFutureName("t??dny", 4)
                  .addFutureName("t??dn??", Long.MAX_VALUE)
                  .addPastName("t??dnem", 1)
                  .addPastName("t??dny", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Month) {
         return new CsTimeFormatBuilder("Month")
                  .addFutureName("m??s??c", 1)
                  .addFutureName("m??s??ce", 4)
                  .addFutureName("m??s??c??", Long.MAX_VALUE)
                  .addPastName("m??s??cem", 1)
                  .addPastName("m??s??ci", Long.MAX_VALUE)
                  .build(this);
      }
      else if (t instanceof Year) {
         return new CsTimeFormatBuilder("Year")
                  .addFutureName("rok", 1)
                  .addFutureName("roky", 4)
                  .addFutureName("let", Long.MAX_VALUE)
                  .addPastName("rokem", 1)
                  .addPastName("roky", Long.MAX_VALUE)
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
