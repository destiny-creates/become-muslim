package com.google.android.gms.internal.p210i;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.analytics.C2710f;

@Deprecated
/* renamed from: com.google.android.gms.internal.i.bk */
public final class bk {
    /* renamed from: a */
    private static volatile C2710f f16424a = new at();

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: a */
    public static void m20333a(String str, Object obj) {
        C5006n b = bl.m37751b();
        if (b != null) {
            b.m21037e(str, obj);
        } else if (bk.m20334a(3)) {
            if (obj != null) {
                obj = String.valueOf(obj);
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(obj).length());
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(obj);
                obj = stringBuilder.toString();
            } else {
                obj = str;
            }
            Log.e((String) ba.f16383b.m20315a(), obj);
        }
        obj = f16424a;
        if (obj != null) {
            obj.c(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: a */
    public static void m20332a(String str) {
        C5006n b = bl.m37751b();
        if (b != null) {
            b.m21036e(str);
        } else if (bk.m20334a(0)) {
            Log.v((String) ba.f16383b.m20315a(), str);
        }
        C2710f c2710f = f16424a;
        if (c2710f != null) {
            c2710f.a(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: b */
    public static void m20335b(String str) {
        C5006n b = bl.m37751b();
        if (b != null) {
            b.m21040h(str);
        } else if (bk.m20334a(2)) {
            Log.w((String) ba.f16383b.m20315a(), str);
        }
        C2710f c2710f = f16424a;
        if (c2710f != null) {
            c2710f.b(str);
        }
    }

    /* renamed from: a */
    private static boolean m20334a(int i) {
        if (f16424a == null || f16424a.a() > i) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static void m20331a(C2710f c2710f) {
        f16424a = c2710f;
    }
}
