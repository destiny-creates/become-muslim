package com.google.android.exoplayer2;

import java.util.HashSet;

/* compiled from: ExoPlayerLibraryInfo */
/* renamed from: com.google.android.exoplayer2.j */
public final class C2489j {
    /* renamed from: a */
    private static final HashSet<String> f6338a = new HashSet();
    /* renamed from: b */
    private static String f6339b = "goog.exo.core";

    /* renamed from: a */
    public static synchronized String m6938a() {
        String str;
        synchronized (C2489j.class) {
            str = f6339b;
        }
        return str;
    }

    /* renamed from: a */
    public static synchronized void m6939a(String str) {
        synchronized (C2489j.class) {
            if (f6338a.add(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(f6339b);
                stringBuilder.append(", ");
                stringBuilder.append(str);
                f6339b = stringBuilder.toString();
            }
        }
    }
}
