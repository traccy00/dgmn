package com.traccy.dgmn.config.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtils {
  public LogUtils(){

  }

  public static String printLogStackTrace(Exception e) {
    try {
      StringWriter errors = new StringWriter();
      e.printStackTrace(new PrintWriter(errors));
      return errors.toString();
    } catch (Exception var2) {
      return null;
    }
  }
}
