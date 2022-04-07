package com.cpb.utils;
/*
  User: Yemao Luo
  Date: 2022/4/7
  Time: 8:56
*/

import com.cpb.domain.Bound;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetBoundUtil {

   public Bound getBound(String str) {
      Bound bound = new Bound();
      Pattern patternX = Pattern.compile("x=.*?,");
      Matcher mX = patternX.matcher(str);
      if (mX.find()) {
         bound.setX(Double.parseDouble(str.substring(mX.start() + 2, mX.end() - 1)));
      }
      Pattern patternY = Pattern.compile("y=.*?,");
      Matcher mY = patternY.matcher(str);
      if (mY.find()) {
         bound.setY(Double.parseDouble(str.substring(mY.start() + 2, mY.end() - 1)));
      }
      Pattern patternW = Pattern.compile("h=.*?,");
      Matcher mW = patternW.matcher(str);
      if (mW.find()) {
         bound.setWidth(Double.parseDouble(str.substring(mW.start() + 2, mW.end() - 1)));
      }
      Pattern patternH = Pattern.compile("t=.*?]");
      Matcher mH = patternH.matcher(str);
      if (mH.find()) {
         bound.setHeight(Double.parseDouble(str.substring(mH.start() + 2, mH.end() - 1)));
      }
      return bound;
   }
}
