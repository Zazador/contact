package com.rberidon.contact.android;

import android.util.Log;

public class Note {
    public static final String TAG = "Contact";
    public static final int LEVEL = 5;
    public static void d(String t) { if (LEVEL >= 5) Log.d(TAG, t); }
    public static void v(String t) { if (LEVEL >= 4) Log.v(TAG, t); }
    public static void w(String t) { if (LEVEL >= 3) Log.w(TAG, t); }
    public static void i(String t) { if (LEVEL >= 2) Log.i(TAG, t); }
    public static void e(String t) { if (LEVEL >= 1) Log.e(TAG, t); }
}
