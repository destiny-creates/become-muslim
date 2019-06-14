package com.google.android.gms.internal.ads;

public final class aee extends afi<aee> {
    /* renamed from: a */
    public byte[] f28035a;
    /* renamed from: b */
    public byte[] f28036b;
    /* renamed from: c */
    public byte[] f28037c;
    /* renamed from: d */
    public byte[] f28038d;

    public aee() {
        this.f28035a = null;
        this.f28036b = null;
        this.f28037c = null;
        this.f28038d = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28035a != null) {
            a += afg.m18353b(1, this.f28035a);
        }
        if (this.f28036b != null) {
            a += afg.m18353b(2, this.f28036b);
        }
        if (this.f28037c != null) {
            a += afg.m18353b(3, this.f28037c);
        }
        return this.f28038d != null ? a + afg.m18353b(4, this.f28038d) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f28035a = afe.m18337f();
            } else if (a == 18) {
                this.f28036b = afe.m18337f();
            } else if (a == 26) {
                this.f28037c = afe.m18337f();
            } else if (a == 34) {
                this.f28038d = afe.m18337f();
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28035a != null) {
            afg.m18366a(1, this.f28035a);
        }
        if (this.f28036b != null) {
            afg.m18366a(2, this.f28036b);
        }
        if (this.f28037c != null) {
            afg.m18366a(3, this.f28037c);
        }
        if (this.f28038d != null) {
            afg.m18366a(4, this.f28038d);
        }
        super.mo3804a(afg);
    }
}
