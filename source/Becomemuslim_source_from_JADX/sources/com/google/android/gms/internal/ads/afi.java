package com.google.android.gms.internal.ads;

public abstract class afi<M extends afi<M>> extends afo {
    /* renamed from: Y */
    protected afk f23569Y;

    /* renamed from: a */
    protected int mo3803a() {
        if (this.f23569Y == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f23569Y.m18373a(); i2++) {
            i += this.f23569Y.m18376b(i2).m18379a();
        }
        return i;
    }

    /* renamed from: a */
    public void mo3804a(afg afg) {
        if (this.f23569Y != null) {
            for (int i = 0; i < this.f23569Y.m18373a(); i++) {
                this.f23569Y.m18376b(i).m18380a(afg);
            }
        }
    }

    /* renamed from: a */
    protected final boolean m29903a(afe afe, int i) {
        int j = afe.m18341j();
        if (!afe.m18330b(i)) {
            return false;
        }
        int i2 = i >>> 3;
        afq afq = new afq(i, afe.m18327a(j, afe.m18341j() - j));
        afl afl = null;
        if (this.f23569Y == null) {
            this.f23569Y = new afk();
        } else {
            afl = this.f23569Y.m18374a(i2);
        }
        if (afl == null) {
            afl = new afl();
            this.f23569Y.m18375a(i2, afl);
        }
        afl.m18381a(afq);
        return true;
    }

    /* renamed from: c */
    public final /* synthetic */ afo mo3805c() {
        return (afi) clone();
    }

    public /* synthetic */ Object clone() {
        afi afi = (afi) super.mo3805c();
        afm.m18382a(this, afi);
        return afi;
    }
}
