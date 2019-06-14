package com.raizlabs.android.dbflow.p273c.p274a;

import com.raizlabs.android.dbflow.p273c.C5667b;

/* compiled from: BaseTransaction */
/* renamed from: com.raizlabs.android.dbflow.c.a.b */
public abstract class C5664b<TransactionResult> implements Comparable<C5664b> {
    /* renamed from: a */
    public static int f18920a = 0;
    /* renamed from: b */
    public static int f18921b = 1;
    /* renamed from: c */
    public static int f18922c = 2;
    /* renamed from: d */
    public static int f18923d = 5;
    /* renamed from: e */
    private C5667b f18924e;

    /* renamed from: a */
    public boolean mo5046a() {
        return true;
    }

    /* renamed from: a */
    public boolean mo5047a(TransactionResult transactionResult) {
        return false;
    }

    /* renamed from: b */
    public abstract TransactionResult mo6273b();

    /* renamed from: b */
    public void mo5048b(TransactionResult transactionResult) {
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m24021a((C5664b) obj);
    }

    public C5664b(C5667b c5667b) {
        this.f18924e = c5667b;
    }

    public C5664b() {
        this.f18924e = C5667b.m24035a();
    }

    /* renamed from: a */
    public int m24021a(C5664b c5664b) {
        return c5664b.f18924e.m24039c() - this.f18924e.m24039c();
    }
}
