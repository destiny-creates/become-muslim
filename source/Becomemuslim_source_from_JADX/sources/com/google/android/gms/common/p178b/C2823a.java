package com.google.android.gms.common.p178b;

import android.util.Log;
import com.google.android.gms.common.internal.C2860m;
import java.util.Locale;

/* renamed from: com.google.android.gms.common.b.a */
public class C2823a {
    /* renamed from: a */
    private final String f7220a;
    /* renamed from: b */
    private final String f7221b;
    /* renamed from: c */
    private final C2860m f7222c;
    /* renamed from: d */
    private final int f7223d;

    public C2823a(String str, String... strArr) {
        String str2;
        if (strArr.length == 0) {
            str2 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            for (String str3 : strArr) {
                if (stringBuilder.length() > 1) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str3);
            }
            stringBuilder.append(93);
            stringBuilder.append(32);
            str2 = stringBuilder.toString();
        }
        this(str, str2);
    }

    private C2823a(String str, String str2) {
        this.f7221b = str2;
        this.f7220a = str;
        this.f7222c = new C2860m(str);
        str = 2;
        while (7 >= str && Log.isLoggable(this.f7220a, str) == null) {
            str++;
        }
        this.f7223d = str;
    }

    /* renamed from: a */
    public boolean m8114a(int i) {
        return this.f7223d <= i;
    }

    /* renamed from: a */
    public void m8113a(String str, Object... objArr) {
        if (m8114a(3)) {
            Log.d(this.f7220a, m8112e(str, objArr));
        }
    }

    /* renamed from: b */
    public void m8115b(String str, Object... objArr) {
        Log.i(this.f7220a, m8112e(str, objArr));
    }

    /* renamed from: c */
    public void m8116c(String str, Object... objArr) {
        Log.w(this.f7220a, m8112e(str, objArr));
    }

    /* renamed from: d */
    public void m8117d(String str, Object... objArr) {
        Log.e(this.f7220a, m8112e(str, objArr));
    }

    /* renamed from: e */
    private final String m8112e(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f7221b.concat(str);
    }
}
