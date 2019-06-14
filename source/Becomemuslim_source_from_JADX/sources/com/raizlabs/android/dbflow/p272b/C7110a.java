package com.raizlabs.android.dbflow.p272b;

/* compiled from: BooleanConverter */
/* renamed from: com.raizlabs.android.dbflow.b.a */
public class C7110a extends C5657e<Integer, Boolean> {
    /* renamed from: b */
    public /* synthetic */ Object mo5041b(Object obj) {
        return m33115a((Boolean) obj);
    }

    /* renamed from: a */
    public Integer m33115a(Boolean bool) {
        return bool == null ? null : Integer.valueOf(bool.booleanValue());
    }

    /* renamed from: a */
    public Boolean m33114a(Integer num) {
        if (num == null) {
            return null;
        }
        boolean z = true;
        if (num.intValue() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
