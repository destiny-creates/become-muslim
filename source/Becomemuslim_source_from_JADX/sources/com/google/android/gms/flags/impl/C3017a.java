package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.flags.impl.p189a.C3016a;

/* renamed from: com.google.android.gms.flags.impl.a */
public abstract class C3017a<T> {

    /* renamed from: com.google.android.gms.flags.impl.a$a */
    public static class C4417a extends C3017a<Boolean> {
        /* renamed from: a */
        public static Boolean m14688a(SharedPreferences sharedPreferences, String str, Boolean bool) {
            try {
                return (Boolean) C3016a.m8866a(new C3019c(sharedPreferences, str, bool));
            } catch (Exception e) {
                str = "FlagDataUtils";
                String str2 = "Flag value not available, returning default: ";
                String valueOf = String.valueOf(e.getMessage());
                Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return bool;
            }
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a$b */
    public static class C4418b extends C3017a<Integer> {
        /* renamed from: a */
        public static Integer m14689a(SharedPreferences sharedPreferences, String str, Integer num) {
            try {
                return (Integer) C3016a.m8866a(new C3020d(sharedPreferences, str, num));
            } catch (Exception e) {
                str = "FlagDataUtils";
                String str2 = "Flag value not available, returning default: ";
                String valueOf = String.valueOf(e.getMessage());
                Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return num;
            }
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a$c */
    public static class C4419c extends C3017a<Long> {
        /* renamed from: a */
        public static Long m14690a(SharedPreferences sharedPreferences, String str, Long l) {
            try {
                return (Long) C3016a.m8866a(new C3021e(sharedPreferences, str, l));
            } catch (Exception e) {
                str = "FlagDataUtils";
                String str2 = "Flag value not available, returning default: ";
                String valueOf = String.valueOf(e.getMessage());
                Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return l;
            }
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a$d */
    public static class C4420d extends C3017a<String> {
        /* renamed from: a */
        public static String m14691a(SharedPreferences sharedPreferences, String str, String str2) {
            try {
                return (String) C3016a.m8866a(new C3022f(sharedPreferences, str, str2));
            } catch (Exception e) {
                str = "FlagDataUtils";
                String str3 = "Flag value not available, returning default: ";
                String valueOf = String.valueOf(e.getMessage());
                Log.w(str, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return str2;
            }
        }
    }
}
