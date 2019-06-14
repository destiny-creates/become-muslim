package com.google.android.gms.internal.ads;

public final class aff extends afi<aff> {
    /* renamed from: a */
    public Long f28039a;
    /* renamed from: b */
    private String f28040b;
    /* renamed from: c */
    private byte[] f28041c;

    public aff() {
        this.f28039a = null;
        this.f28040b = null;
        this.f28041c = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28039a != null) {
            a += afg.m18358d(1, this.f28039a.longValue());
        }
        if (this.f28040b != null) {
            a += afg.m18352b(3, this.f28040b);
        }
        return this.f28041c != null ? a + afg.m18353b(4, this.f28041c) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28039a = Long.valueOf(afe.m18339h());
            } else if (a == 26) {
                this.f28040b = afe.m18335e();
            } else if (a == 34) {
                this.f28041c = afe.m18337f();
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28039a != null) {
            afg.m18367b(1, this.f28039a.longValue());
        }
        if (this.f28040b != null) {
            afg.m18364a(3, this.f28040b);
        }
        if (this.f28041c != null) {
            afg.m18366a(4, this.f28041c);
        }
        super.mo3804a(afg);
    }
}
