package com.facebook.ads.internal.protocol;

/* renamed from: com.facebook.ads.internal.protocol.b */
public class C1482b extends Exception {
    /* renamed from: a */
    private final AdErrorType f4362a;
    /* renamed from: b */
    private final String f4363b;

    public C1482b(AdErrorType adErrorType, String str) {
        this(adErrorType, str, null);
    }

    public C1482b(AdErrorType adErrorType, String str, Throwable th) {
        super(str, th);
        this.f4362a = adErrorType;
        this.f4363b = str;
    }

    /* renamed from: a */
    public AdErrorType m5245a() {
        return this.f4362a;
    }

    /* renamed from: b */
    public String m5246b() {
        return this.f4363b;
    }
}
