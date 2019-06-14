package com.stripe.android.p284a;

/* compiled from: StripeException */
/* renamed from: com.stripe.android.a.h */
public abstract class C5711h extends Exception {
    protected static final long serialVersionUID = 1;
    /* renamed from: a */
    private String f19021a;
    /* renamed from: b */
    private Integer f19022b;

    public C5711h(String str, String str2, Integer num) {
        super(str, null);
        this.f19021a = str2;
        this.f19022b = num;
    }

    public C5711h(String str, String str2, Integer num, Throwable th) {
        super(str, th);
        this.f19022b = num;
        this.f19021a = str2;
    }

    /* renamed from: a */
    public String m24156a() {
        return this.f19021a;
    }

    /* renamed from: b */
    public Integer m24157b() {
        return this.f19022b;
    }

    public String toString() {
        String str = "";
        if (this.f19021a != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("; request-id: ");
            stringBuilder.append(this.f19021a);
            str = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(super.toString());
        stringBuilder2.append(str);
        return stringBuilder2.toString();
    }
}
