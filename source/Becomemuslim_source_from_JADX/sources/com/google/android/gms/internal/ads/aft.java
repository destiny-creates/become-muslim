package com.google.android.gms.internal.ads;

public final class aft extends afi<aft> {
    /* renamed from: a */
    public String f28060a;

    public aft() {
        this.f28060a = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        return this.f28060a != null ? a + afg.m18352b(1, this.f28060a) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f28060a = afe.m18335e();
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28060a != null) {
            afg.m18364a(1, this.f28060a);
        }
        super.mo3804a(afg);
    }
}
