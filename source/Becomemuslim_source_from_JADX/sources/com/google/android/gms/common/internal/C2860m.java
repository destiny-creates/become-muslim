package com.google.android.gms.common.internal;

/* renamed from: com.google.android.gms.common.internal.m */
public final class C2860m {
    /* renamed from: a */
    private static final int f7327a = 15;
    /* renamed from: b */
    private static final String f7328b = null;
    /* renamed from: c */
    private final String f7329c;
    /* renamed from: d */
    private final String f7330d;

    public C2860m(String str, String str2) {
        C2872v.m8381a((Object) str, (Object) "log tag cannot be null");
        C2872v.m8392b(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.f7329c = str;
        if (str2 != null) {
            if (str2.length() > null) {
                this.f7330d = str2;
                return;
            }
        }
        this.f7330d = null;
    }

    public C2860m(String str) {
        this(str, null);
    }
}
