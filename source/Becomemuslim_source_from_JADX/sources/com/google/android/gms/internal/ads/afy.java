package com.google.android.gms.internal.ads;

public final class afy extends afi<afy> {
    /* renamed from: a */
    private Integer f28078a;
    /* renamed from: b */
    private byte[] f28079b;
    /* renamed from: c */
    private byte[] f28080c;

    public afy() {
        this.f28078a = null;
        this.f28079b = null;
        this.f28080c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28078a != null) {
            a += afg.m18350b(1, this.f28078a.intValue());
        }
        if (this.f28079b != null) {
            a += afg.m18353b(2, this.f28079b);
        }
        return this.f28080c != null ? a + afg.m18353b(3, this.f28080c) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28078a = Integer.valueOf(afe.m18331c());
            } else if (a == 18) {
                this.f28079b = afe.m18337f();
            } else if (a == 26) {
                this.f28080c = afe.m18337f();
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28078a != null) {
            afg.m18361a(1, this.f28078a.intValue());
        }
        if (this.f28079b != null) {
            afg.m18366a(2, this.f28079b);
        }
        if (this.f28080c != null) {
            afg.m18366a(3, this.f28080c);
        }
        super.mo3804a(afg);
    }
}
