package com.google.android.gms.p185e;

import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.internal.p210i.ct;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.e.ey */
final class ey {
    /* renamed from: a */
    static cj<ct> m8743a(cj<ct> cjVar, int... iArr) {
        for (int i : iArr) {
            if (!(eu.m8734f((ct) cjVar.m8619a()) instanceof String)) {
                bs.m8582a("Escaping can only be applied to strings.");
            } else if (i != 12) {
                StringBuilder stringBuilder = new StringBuilder(39);
                stringBuilder.append("Unsupported Value Escaping: ");
                stringBuilder.append(i);
                bs.m8582a(stringBuilder.toString());
            } else {
                cjVar = ey.m8742a((cj) cjVar);
            }
        }
        return cjVar;
    }

    /* renamed from: a */
    static String m8744a(String str) {
        return URLEncoder.encode(str, Utf8Charset.NAME).replaceAll("\\+", "%20");
    }

    /* renamed from: a */
    private static cj<ct> m8742a(cj<ct> cjVar) {
        try {
            return new cj(eu.m8716a(ey.m8744a(eu.m8719a((ct) cjVar.m8619a()))), cjVar.m8620b());
        } catch (Throwable e) {
            bs.m8583a("Escape URI: unsupported encoding", e);
            return cjVar;
        }
    }
}
