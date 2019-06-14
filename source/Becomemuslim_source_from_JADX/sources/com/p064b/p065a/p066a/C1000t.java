package com.p064b.p065a.p066a;

/* compiled from: SessionEventMetadata */
/* renamed from: com.b.a.a.t */
final class C1000t {
    /* renamed from: a */
    public final String f2789a;
    /* renamed from: b */
    public final String f2790b;
    /* renamed from: c */
    public final String f2791c;
    /* renamed from: d */
    public final String f2792d;
    /* renamed from: e */
    public final String f2793e;
    /* renamed from: f */
    public final Boolean f2794f;
    /* renamed from: g */
    public final String f2795g;
    /* renamed from: h */
    public final String f2796h;
    /* renamed from: i */
    public final String f2797i;
    /* renamed from: j */
    public final String f2798j;
    /* renamed from: k */
    public final String f2799k;
    /* renamed from: l */
    public final String f2800l;
    /* renamed from: m */
    private String f2801m;

    public C1000t(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f2789a = str;
        this.f2790b = str2;
        this.f2791c = str3;
        this.f2792d = str4;
        this.f2793e = str5;
        this.f2794f = bool;
        this.f2795g = str6;
        this.f2796h = str7;
        this.f2797i = str8;
        this.f2798j = str9;
        this.f2799k = str10;
        this.f2800l = str11;
    }

    public String toString() {
        if (this.f2801m == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("appBundleId=");
            stringBuilder.append(this.f2789a);
            stringBuilder.append(", executionId=");
            stringBuilder.append(this.f2790b);
            stringBuilder.append(", installationId=");
            stringBuilder.append(this.f2791c);
            stringBuilder.append(", androidId=");
            stringBuilder.append(this.f2792d);
            stringBuilder.append(", advertisingId=");
            stringBuilder.append(this.f2793e);
            stringBuilder.append(", limitAdTrackingEnabled=");
            stringBuilder.append(this.f2794f);
            stringBuilder.append(", betaDeviceToken=");
            stringBuilder.append(this.f2795g);
            stringBuilder.append(", buildId=");
            stringBuilder.append(this.f2796h);
            stringBuilder.append(", osVersion=");
            stringBuilder.append(this.f2797i);
            stringBuilder.append(", deviceModel=");
            stringBuilder.append(this.f2798j);
            stringBuilder.append(", appVersionCode=");
            stringBuilder.append(this.f2799k);
            stringBuilder.append(", appVersionName=");
            stringBuilder.append(this.f2800l);
            this.f2801m = stringBuilder.toString();
        }
        return this.f2801m;
    }
}
