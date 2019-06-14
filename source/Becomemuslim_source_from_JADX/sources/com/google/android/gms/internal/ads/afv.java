package com.google.android.gms.internal.ads;

public final class afv extends afi<afv> {
    /* renamed from: a */
    public afu[] f28064a;
    /* renamed from: b */
    private afw f28065b;
    /* renamed from: c */
    private byte[] f28066c;
    /* renamed from: d */
    private byte[] f28067d;
    /* renamed from: e */
    private Integer f28068e;

    public afv() {
        this.f28065b = null;
        this.f28064a = afu.m36753b();
        this.f28066c = null;
        this.f28067d = null;
        this.f28068e = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28065b != null) {
            a += afg.m18351b(1, this.f28065b);
        }
        if (this.f28064a != null && this.f28064a.length > 0) {
            for (afo afo : this.f28064a) {
                if (afo != null) {
                    a += afg.m18351b(2, afo);
                }
            }
        }
        if (this.f28066c != null) {
            a += afg.m18353b(3, this.f28066c);
        }
        if (this.f28067d != null) {
            a += afg.m18353b(4, this.f28067d);
        }
        return this.f28068e != null ? a + afg.m18350b(5, this.f28068e.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                if (this.f28065b == null) {
                    this.f28065b = new afw();
                }
                afe.m18326a(this.f28065b);
            } else if (a == 18) {
                a = afr.m18397a(afe, 18);
                int length = this.f28064a == null ? 0 : this.f28064a.length;
                Object obj = new afu[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f28064a, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new afu();
                    afe.m18326a(obj[length]);
                    afe.m18324a();
                    length++;
                }
                obj[length] = new afu();
                afe.m18326a(obj[length]);
                this.f28064a = obj;
            } else if (a == 26) {
                this.f28066c = afe.m18337f();
            } else if (a == 34) {
                this.f28067d = afe.m18337f();
            } else if (a == 40) {
                this.f28068e = Integer.valueOf(afe.m18331c());
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28065b != null) {
            afg.m18363a(1, this.f28065b);
        }
        if (this.f28064a != null && this.f28064a.length > 0) {
            for (afo afo : this.f28064a) {
                if (afo != null) {
                    afg.m18363a(2, afo);
                }
            }
        }
        if (this.f28066c != null) {
            afg.m18366a(3, this.f28066c);
        }
        if (this.f28067d != null) {
            afg.m18366a(4, this.f28067d);
        }
        if (this.f28068e != null) {
            afg.m18361a(5, this.f28068e.intValue());
        }
        super.mo3804a(afg);
    }
}
