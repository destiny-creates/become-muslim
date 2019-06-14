package com.onesignal;

import android.os.PersistableBundle;

/* compiled from: BundleCompat */
/* renamed from: com.onesignal.j */
class C6962j implements C5505g<PersistableBundle> {
    /* renamed from: a */
    private PersistableBundle f24838a;

    /* renamed from: a */
    public /* synthetic */ Object mo4961a() {
        return m32683b();
    }

    C6962j() {
        this.f24838a = new PersistableBundle();
    }

    C6962j(PersistableBundle persistableBundle) {
        this.f24838a = persistableBundle;
    }

    /* renamed from: a */
    public void mo4964a(String str, String str2) {
        this.f24838a.putString(str, str2);
    }

    /* renamed from: a */
    public void mo4963a(String str, Long l) {
        this.f24838a.putLong(str, l.longValue());
    }

    /* renamed from: a */
    public String mo4962a(String str) {
        return this.f24838a.getString(str);
    }

    /* renamed from: b */
    public Integer mo4966b(String str) {
        return Integer.valueOf(this.f24838a.getInt(str));
    }

    /* renamed from: c */
    public Long mo4967c(String str) {
        return Long.valueOf(this.f24838a.getLong(str));
    }

    /* renamed from: a */
    public boolean mo4965a(String str, boolean z) {
        return this.f24838a.getBoolean(str, z);
    }

    /* renamed from: d */
    public boolean mo4968d(String str) {
        return this.f24838a.containsKey(str);
    }

    /* renamed from: b */
    public PersistableBundle m32683b() {
        return this.f24838a;
    }
}
