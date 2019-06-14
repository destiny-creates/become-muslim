package com.facebook.ads.internal.p101p.p103b.p104a;

import android.text.TextUtils;
import com.facebook.ads.internal.p101p.p103b.C1478m;

/* renamed from: com.facebook.ads.internal.p.b.a.f */
public class C3603f implements C1456c {
    /* renamed from: b */
    private String m11746b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    /* renamed from: a */
    public String mo989a(String str) {
        Object b = m11746b(str);
        str = C1478m.m5233d(str);
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(b);
        return stringBuilder.toString();
    }
}
