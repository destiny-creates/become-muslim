package com.google.android.gms.common.api;

/* renamed from: com.google.android.gms.common.api.b */
public class C2782b extends Exception {
    /* renamed from: a */
    protected final Status f7103a;

    public C2782b(Status status) {
        int e = status.m16706e();
        String a = status.m16701a() != null ? status.m16701a() : "";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(a).length() + 13);
        stringBuilder.append(e);
        stringBuilder.append(": ");
        stringBuilder.append(a);
        super(stringBuilder.toString());
        this.f7103a = status;
    }

    /* renamed from: a */
    public int m7935a() {
        return this.f7103a.m16706e();
    }
}
