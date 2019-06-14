package com.onesignal;

import android.os.Bundle;

/* compiled from: BundleCompat */
/* renamed from: com.onesignal.h */
class C6961h implements C5505g<Bundle> {
    /* renamed from: a */
    private Bundle f24837a;

    /* renamed from: a */
    public /* synthetic */ Object mo4961a() {
        return m32674b();
    }

    C6961h() {
        this.f24837a = new Bundle();
    }

    C6961h(Bundle bundle) {
        this.f24837a = bundle;
    }

    /* renamed from: a */
    public void mo4964a(String str, String str2) {
        this.f24837a.putString(str, str2);
    }

    /* renamed from: a */
    public void mo4963a(String str, Long l) {
        this.f24837a.putLong(str, l.longValue());
    }

    /* renamed from: a */
    public String mo4962a(String str) {
        return this.f24837a.getString(str);
    }

    /* renamed from: b */
    public Integer mo4966b(String str) {
        return Integer.valueOf(this.f24837a.getInt(str));
    }

    /* renamed from: c */
    public Long mo4967c(String str) {
        return Long.valueOf(this.f24837a.getLong(str));
    }

    /* renamed from: d */
    public boolean mo4968d(String str) {
        return this.f24837a.containsKey(str);
    }

    /* renamed from: b */
    public Bundle m32674b() {
        return this.f24837a;
    }

    /* renamed from: a */
    public boolean mo4965a(String str, boolean z) {
        return this.f24837a.getBoolean(str, z);
    }
}
