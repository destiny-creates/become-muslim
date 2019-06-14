package com.facebook.ads.internal.protocol;

import android.text.TextUtils;

/* renamed from: com.facebook.ads.internal.protocol.a */
public class C1481a {
    /* renamed from: a */
    private final AdErrorType f4360a;
    /* renamed from: b */
    private final String f4361b;

    public C1481a(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C1481a(AdErrorType adErrorType, String str) {
        if (TextUtils.isEmpty(str)) {
            str = adErrorType.getDefaultErrorMessage();
        }
        this.f4360a = adErrorType;
        this.f4361b = str;
    }

    /* renamed from: a */
    public static C1481a m5241a(AdErrorType adErrorType, String str) {
        return new C1481a(adErrorType, str);
    }

    /* renamed from: a */
    public static C1481a m5242a(C1482b c1482b) {
        return new C1481a(c1482b.m5245a(), c1482b.m5246b());
    }

    /* renamed from: a */
    public AdErrorType m5243a() {
        return this.f4360a;
    }

    /* renamed from: b */
    public String m5244b() {
        return this.f4361b;
    }
}
