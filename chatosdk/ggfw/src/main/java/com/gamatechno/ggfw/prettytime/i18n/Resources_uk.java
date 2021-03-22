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
import com.gamatechno.ggfw.prettytime.impl.TimeFormatProvider;
import com.gamatechno.ggfw.prettytime.units.Century;
import com.gamatechno.ggfw.prettytime.units.Day;
import com.gamatechno.ggfw.prettytime.units.Decade;
import com.gamatechno.ggfw.prettytime.units.Hour;
import com.gamatechno.ggfw.prettytime.units.JustNow;
import com.gamatechno.ggfw.prettytime.units.Millennium;
import com.gamatechno.ggfw.prettytime.units.Millisecond;
import com.gamatechno.ggfw.prettytime.units.Minute;
import com.gamatechno.ggfw.prettytime.units.Month;
import com.gamatechno.ggfw.prettytime.units.Second;
import com.gamatechno.ggfw.prettytime.units.Week;
import com.gamatechno.ggfw.prettytime.units.Year;

import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA. User: Tumin Alexander Date: 2012-12-13 Time: 03:33
 * 
 * reedit to Ukrainian with Eclipse). User: Ihor Lavrynuk Date: 2013-01-06 Time: 15:04
 * 
 */
public class Resources_uk extends ListResourceBundle implements TimeFormatProvider
{
   private static final Object[][] OBJECTS = new Object[0][0];

   private static final int tolerance = 50;

   // see http://translate.sourceforge.net/wiki/l10n/pluralforms
   private static final int slavicPluralForms = 3;

   private static class TimeFormatAided implements TimeFormat
   {
      private final String[] pluarls;

      public TimeFormatAided(String... plurals)
      {
         if (plurals.length != slavicPluralForms) {
            throw new IllegalArgumentException("Wrong plural forms number for slavic language!");
         }
         this.pluarls = plurals;
      }

      @Override
      public String format(Duration duration)
      {
         long quantity = duration.getQuantityRounded(tolerance);
         StringBuilder result = new StringBuilder();
         result.append(quantity);
         return result.toString();
      }

      @Override
      public String formatUnrounded(Duration duration)
      {
         long quantity = duration.getQuantity();
         StringBuilder result = new StringBuilder();
         result.append(quantity);
         return result.toString();
      }

      @Override
      public String decorate(Duration duration, String time)
      {
         return performDecoration(
                  duration.isInPast(),
                  duration.isInFuture(),
                  duration.getQuantityRounded(tolerance),
                  time);
      }

      @Override
      public String decorateUnrounded(Duration duration, String time)
      {
         return performDecoration(
                  duration.isInPast(),
                  duration.isInFuture(),
                  duration.getQuantity(),
                  time);
      }

      private String performDecoration(boolean past, boolean future, long n, String time)
      {
         // a bit cryptic, yet well-tested
         // consider http://translate.sourceforge.net/wiki/l10n/pluralforms
         int pluralIdx = (n % 10 == 1 && n % 100 != 11 ? 0 : n % 10 >= 2 && n % 10 <= 4
                  && (n % 100 < 10 || n % 100 >= 20) ? 1 : 2);
         if (pluralIdx > slavicPluralForms) {
            // impossible happening
            throw new IllegalStateException("Wrong plural index was calculated somehow for slavic language");
         }

         StringBuilder result = new StringBuilder();

         if (future) {
            result.append("через ");
         }

         result.append(time);
         result.append(' ');
         result.append(pluarls[pluralIdx]);

         if (past) {
            result.append(" тому");
         }

         return result.toString();
      }
   }

   @Override
   public Object[][] getContents()
   {
      return OBJECTS;
   }

   @Override
   public TimeFormat getFormatFor(TimeUnit t)
   {
      if (t instanceof JustNow) {
         return new TimeFormat() {
            @Override
            public String format(Duration duration)
            {
               return performFormat(duration);
            }

            @Override
            public String formatUnrounded(Duration duration)
            {
               return performFormat(duration);
            }

            private String performFormat(Duration duration)
            {
               if (duration.isInFuture()) {
                  return "зараз";
               }
               if (duration.isInPast()) {
                  return "щойно";
               }
               return null;
            }

            @Override
            public String decorate(Duration duration, String time)
            {
               return time;
            }

            @Override
            public String decorateUnrounded(Duration duration, String time)
            {
               return time;
            }
         };
      }
      else if (t instanceof Century) {
         return new TimeFormatAided("століття", "століття", "столітть");
      }
      else if (t instanceof Day) {
         return new TimeFormatAided("день", "дні", "днів");
      }
      else if (t instanceof Decade) {
         return new TimeFormatAided("десятиліття", "десятиліття", "десятиліть");
      }
      else if (t instanceof Hour) {
         return new TimeFormatAided("годину", "години", "годин");
      }
      else if (t instanceof Millennium) {
         return new TimeFormatAided("тисячоліття", "тисячоліття", "тисячоліть");
      }
      else if (t instanceof Millisecond) {
         return new TimeFormatAided("мілісекунду", "мілісекунди", "мілісекунд");
      }
      else if (t instanceof Minute) {
         return new TimeFormatAided("хвилину", "хвилини", "хвилин");
      }
      else if (t instanceof Month) {
         return new TimeFormatAided("місяць", "місяці", "місяців");
      }
      else if (t instanceof Second) {
         return new TimeFormatAided("секунду", "секунди", "секунд");
      }
      else if (t instanceof Week) {
         return new TimeFormatAided("тиждень", "тижні", "тижнів");
      }
      else if (t instanceof Year) {
         return new TimeFormatAided("рік", "роки", "років");
      }
      return null; // error
   }
}
