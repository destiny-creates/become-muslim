package com.facebook.ads.internal.p105q.p106a;

import java.util.Set;

/* renamed from: com.facebook.ads.internal.q.a.u */
public class C1521u {
    /* renamed from: a */
    public static String m5336a(Set<String> set, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : set) {
            stringBuilder.append(append);
            stringBuilder.append(str);
        }
        return stringBuilder.length() > 0 ? stringBuilder.substring(0, stringBuilder.length() - 1) : "";
    }
}
