package com.google.android.gms.p185e;

import android.os.Looper;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.e.fn */
final class fn implements C4391b {
    /* renamed from: a */
    private final Looper f13298a;
    /* renamed from: b */
    private C2929a f13299b;
    /* renamed from: c */
    private C2929a f13300c;
    /* renamed from: d */
    private Status f13301d;
    /* renamed from: e */
    private fp f13302e;
    /* renamed from: f */
    private fo f13303f;
    /* renamed from: g */
    private boolean f13304g;
    /* renamed from: h */
    private C2937d f13305h;

    public fn(Status status) {
        this.f13301d = status;
        this.f13298a = null;
    }

    public fn(C2937d c2937d, Looper looper, C2929a c2929a, fo foVar) {
        this.f13305h = c2937d;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.f13298a = looper;
        this.f13299b = c2929a;
        this.f13303f = foVar;
        this.f13301d = Status.f13151a;
        c2937d.m8634a(this);
    }

    /* renamed from: b */
    public final Status mo2360b() {
        return this.f13301d;
    }

    /* renamed from: c */
    public final synchronized C2929a mo3307c() {
        if (this.f13304g) {
            bs.m8582a("ContainerHolder is released.");
            return null;
        }
        if (this.f13300c != null) {
            this.f13299b = this.f13300c;
            this.f13300c = null;
        }
        return this.f13299b;
    }

    /* renamed from: a */
    public final synchronized void mo3299a() {
        if (this.f13304g) {
            bs.m8582a("Releasing a released ContainerHolder.");
            return;
        }
        this.f13304g = true;
        this.f13305h.m8639b(this);
        this.f13299b.m8543e();
        this.f13299b = null;
        this.f13300c = null;
        this.f13303f = null;
        this.f13302e = null;
    }

    /* renamed from: a */
    public final synchronized void m16909a(C2929a c2929a) {
        if (!this.f13304g) {
            this.f13300c = c2929a;
            m16907e();
        }
    }

    /* renamed from: a */
    public final synchronized void m16910a(String str) {
        if (!this.f13304g) {
            this.f13299b.m8544f(str);
        }
    }

    /* renamed from: d */
    final String m16913d() {
        if (!this.f13304g) {
            return this.f13299b.m8533a();
        }
        bs.m8582a("getContainerId called on a released ContainerHolder.");
        return "";
    }

    /* renamed from: e */
    private final void m16907e() {
        if (this.f13302e != null) {
            fp fpVar = this.f13302e;
            fpVar.sendMessage(fpVar.obtainMessage(1, this.f13300c.m8541d()));
        }
    }
}
