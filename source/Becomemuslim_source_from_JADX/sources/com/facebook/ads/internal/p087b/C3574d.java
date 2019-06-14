package com.facebook.ads.internal.p087b;

import android.os.Bundle;
import com.facebook.ads.internal.p105q.p106a.C1513p;

/* renamed from: com.facebook.ads.internal.b.d */
public class C3574d implements C1513p<Bundle> {
    /* renamed from: a */
    private C1349c f9550a;
    /* renamed from: b */
    private final C1349c f9551b;
    /* renamed from: c */
    private final C1347b f9552c;
    /* renamed from: d */
    private boolean f9553d = false;
    /* renamed from: e */
    private boolean f9554e = false;
    /* renamed from: f */
    private boolean f9555f = false;

    public C3574d(C1347b c1347b) {
        this.f9552c = c1347b;
        this.f9551b = new C1349c(c1347b.f3908b);
        this.f9550a = new C1349c(c1347b.f3908b);
    }

    public C3574d(C1347b c1347b, Bundle bundle) {
        this.f9552c = c1347b;
        this.f9551b = (C1349c) bundle.getSerializable("testStats");
        this.f9550a = (C1349c) bundle.getSerializable("viewableStats");
        this.f9553d = bundle.getBoolean("ended");
        this.f9554e = bundle.getBoolean("passed");
        this.f9555f = bundle.getBoolean("complete");
    }

    /* renamed from: b */
    private void m11639b() {
        this.f9554e = true;
        m11640c();
    }

    /* renamed from: c */
    private void m11640c() {
        this.f9555f = true;
        m11641d();
    }

    /* renamed from: d */
    private void m11641d() {
        this.f9553d = true;
        this.f9552c.mo932a(this.f9555f, this.f9554e, this.f9554e ? this.f9550a : this.f9551b);
    }

    /* renamed from: a */
    public void m11642a() {
        if (!this.f9553d) {
            this.f9550a.m4629b();
        }
    }

    /* renamed from: a */
    public void m11643a(double d, double d2) {
        if (!this.f9553d) {
            this.f9551b.m4628a(d, d2);
            this.f9550a.m4628a(d, d2);
            d = this.f9552c.f3911e ? this.f9550a.m4631c().m4626h() : this.f9550a.m4631c().m4625g();
            if (this.f9552c.f3909c < 0.0d || this.f9551b.m4631c().m4624f() <= this.f9552c.f3909c || d != 0.0d) {
                if (d >= this.f9552c.f3910d) {
                    m11639b();
                }
                return;
            }
            m11640c();
        }
    }

    /* renamed from: g */
    public Bundle mo937g() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewableStats", this.f9550a);
        bundle.putSerializable("testStats", this.f9551b);
        bundle.putBoolean("ended", this.f9553d);
        bundle.putBoolean("passed", this.f9554e);
        bundle.putBoolean("complete", this.f9555f);
        return bundle;
    }
}
