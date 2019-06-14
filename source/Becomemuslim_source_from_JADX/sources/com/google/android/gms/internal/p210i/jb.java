package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.jb */
public abstract class jb<M extends jb<M>> extends jh {
    /* renamed from: m */
    protected jd f24537m;

    /* renamed from: a */
    protected int mo4621a() {
        if (this.f24537m == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f24537m.m20989a(); i2++) {
            i += this.f24537m.m20992b(i2).m20996a();
        }
        return i;
    }

    /* renamed from: a */
    public void mo4622a(iz izVar) {
        if (this.f24537m != null) {
            for (int i = 0; i < this.f24537m.m20989a(); i++) {
                this.f24537m.m20992b(i).m20998a(izVar);
            }
        }
    }

    /* renamed from: a */
    public final <T> T m31764a(jc<M, T> jcVar) {
        if (this.f24537m == null) {
            return null;
        }
        je a = this.f24537m.m20990a(jcVar.f16778b >>> 3);
        if (a == null) {
            return null;
        }
        return a.m20997a((jc) jcVar);
    }

    /* renamed from: a */
    protected final boolean m31766a(iy iyVar, int i) {
        int h = iyVar.m20954h();
        if (!iyVar.m20945b(i)) {
            return null;
        }
        int i2 = i >>> 3;
        jj jjVar = new jj(i, iyVar.m20942a(h, iyVar.m20954h() - h));
        iyVar = null;
        if (this.f24537m == 0) {
            this.f24537m = new jd();
        } else {
            iyVar = this.f24537m.m20990a(i2);
        }
        if (iyVar == null) {
            iyVar = new je();
            this.f24537m.m20991a(i2, iyVar);
        }
        iyVar.m20999a(jjVar);
        return true;
    }

    /* renamed from: c */
    public final /* synthetic */ jh mo4623c() {
        return (jb) clone();
    }

    public /* synthetic */ Object clone() {
        jb jbVar = (jb) super.mo4623c();
        jf.m21002a(this, jbVar);
        return jbVar;
    }
}
