package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.internal.ads.j */
public final class C4930j {
    /* renamed from: a */
    private final boolean f15632a;
    /* renamed from: b */
    private final boolean f15633b;
    /* renamed from: c */
    private final boolean f15634c;
    /* renamed from: d */
    private final boolean f15635d;
    /* renamed from: e */
    private final boolean f15636e;

    private C4930j(C4932l c4932l) {
        this.f15632a = c4932l.f15743a;
        this.f15633b = c4932l.f15744b;
        this.f15634c = c4932l.f15745c;
        this.f15635d = c4932l.f15746d;
        this.f15636e = c4932l.f15747e;
    }

    /* renamed from: a */
    public final JSONObject m19585a() {
        try {
            return new JSONObject().put("sms", this.f15632a).put("tel", this.f15633b).put("calendar", this.f15634c).put("storePicture", this.f15635d).put("inlineVideo", this.f15636e);
        } catch (Throwable e) {
            mt.m19919b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
