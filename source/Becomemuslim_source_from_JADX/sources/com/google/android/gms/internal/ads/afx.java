package com.google.android.gms.internal.ads;

public final class afx extends afi<afx> {
    /* renamed from: a */
    private afy f28072a;
    /* renamed from: b */
    private afu[] f28073b;
    /* renamed from: c */
    private byte[] f28074c;
    /* renamed from: d */
    private byte[] f28075d;
    /* renamed from: e */
    private Integer f28076e;
    /* renamed from: f */
    private byte[] f28077f;

    public afx() {
        this.f28072a = null;
        this.f28073b = afu.m36753b();
        this.f28074c = null;
        this.f28075d = null;
        this.f28076e = null;
        this.f28077f = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28072a != null) {
            a += afg.m18351b(1, this.f28072a);
        }
        if (this.f28073b != null && this.f28073b.length > 0) {
            for (afo afo : this.f28073b) {
                if (afo != null) {
                    a += afg.m18351b(2, afo);
                }
            }
        }
        if (this.f28074c != null) {
            a += afg.m18353b(3, this.f28074c);
        }
        if (this.f28075d != null) {
            a += afg.m18353b(4, this.f28075d);
        }
        if (this.f28076e != null) {
            a += afg.m18350b(5, this.f28076e.intValue());
        }
        return this.f28077f != null ? a + afg.m18353b(6, this.f28077f) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                if (this.f28072a == null) {
                    this.f28072a = new afy();
                }
                afe.m18326a(this.f28072a);
            } else if (a == 18) {
                a = afr.m18397a(afe, 18);
                int length = this.f28073b == null ? 0 : this.f28073b.length;
                Object obj = new afu[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f28073b, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new afu();
                    afe.m18326a(obj[length]);
                    afe.m18324a();
                    length++;
                }
                obj[length] = new afu();
                afe.m18326a(obj[length]);
                this.f28073b = obj;
            } else if (a == 26) {
                this.f28074c = afe.m18337f();
            } else if (a == 34) {
                this.f28075d = afe.m18337f();
            } else if (a == 40) {
                this.f28076e = Integer.valueOf(afe.m18331c());
            } else if (a == 50) {
                this.f28077f = afe.m18337f();
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28072a != null) {
            afg.m18363a(1, this.f28072a);
        }
        if (this.f28073b != null && this.f28073b.length > 0) {
            for (afo afo : this.f28073b) {
                if (afo != null) {
                    afg.m18363a(2, afo);
                }
            }
        }
        if (this.f28074c != null) {
            afg.m18366a(3, this.f28074c);
        }
        if (this.f28075d != null) {
            afg.m18366a(4, this.f28075d);
        }
        if (this.f28076e != null) {
            afg.m18361a(5, this.f28076e.intValue());
        }
        if (this.f28077f != null) {
            afg.m18366a(6, this.f28077f);
        }
        super.mo3804a(afg);
    }
}
