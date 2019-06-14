package com.google.android.gms.internal.ads;

public final class anl extends afi<anl> {
    /* renamed from: a */
    private Integer f28147a;
    /* renamed from: b */
    private any f28148b;
    /* renamed from: c */
    private any f28149c;
    /* renamed from: d */
    private any f28150d;
    /* renamed from: e */
    private any[] f28151e;
    /* renamed from: f */
    private Integer f28152f;

    public anl() {
        this.f28147a = null;
        this.f28148b = null;
        this.f28149c = null;
        this.f28150d = null;
        this.f28151e = any.m36870b();
        this.f28152f = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28147a != null) {
            a += afg.m18350b(1, this.f28147a.intValue());
        }
        if (this.f28148b != null) {
            a += afg.m18351b(2, this.f28148b);
        }
        if (this.f28149c != null) {
            a += afg.m18351b(3, this.f28149c);
        }
        if (this.f28150d != null) {
            a += afg.m18351b(4, this.f28150d);
        }
        if (this.f28151e != null && this.f28151e.length > 0) {
            for (afo afo : this.f28151e) {
                if (afo != null) {
                    a += afg.m18351b(5, afo);
                }
            }
        }
        return this.f28152f != null ? a + afg.m18350b(6, this.f28152f.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a != 8) {
                afo afo;
                if (a == 18) {
                    if (this.f28148b == null) {
                        this.f28148b = new any();
                    }
                    afo = this.f28148b;
                } else if (a == 26) {
                    if (this.f28149c == null) {
                        this.f28149c = new any();
                    }
                    afo = this.f28149c;
                } else if (a == 34) {
                    if (this.f28150d == null) {
                        this.f28150d = new any();
                    }
                    afo = this.f28150d;
                } else if (a == 42) {
                    a = afr.m18397a(afe, 42);
                    int length = this.f28151e == null ? 0 : this.f28151e.length;
                    Object obj = new any[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28151e, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new any();
                        afe.m18326a(obj[length]);
                        afe.m18324a();
                        length++;
                    }
                    obj[length] = new any();
                    afe.m18326a(obj[length]);
                    this.f28151e = obj;
                } else if (a == 48) {
                    this.f28152f = Integer.valueOf(afe.m18338g());
                } else if (!super.m29903a(afe, a)) {
                    return this;
                }
                afe.m18326a(afo);
            } else {
                this.f28147a = Integer.valueOf(afe.m18338g());
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28147a != null) {
            afg.m18361a(1, this.f28147a.intValue());
        }
        if (this.f28148b != null) {
            afg.m18363a(2, this.f28148b);
        }
        if (this.f28149c != null) {
            afg.m18363a(3, this.f28149c);
        }
        if (this.f28150d != null) {
            afg.m18363a(4, this.f28150d);
        }
        if (this.f28151e != null && this.f28151e.length > 0) {
            for (afo afo : this.f28151e) {
                if (afo != null) {
                    afg.m18363a(5, afo);
                }
            }
        }
        if (this.f28152f != null) {
            afg.m18361a(6, this.f28152f.intValue());
        }
        super.mo3804a(afg);
    }
}
