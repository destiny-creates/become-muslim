package com.google.android.gms.internal.ads;

public final class any extends afi<any> {
    /* renamed from: a */
    private static volatile any[] f28208a;
    /* renamed from: b */
    private Integer f28209b;
    /* renamed from: c */
    private Integer f28210c;

    public any() {
        this.f28209b = null;
        this.f28210c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    public static any[] m36870b() {
        if (f28208a == null) {
            synchronized (afm.f14429b) {
                if (f28208a == null) {
                    f28208a = new any[0];
                }
            }
        }
        return f28208a;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28209b != null) {
            a += afg.m18350b(1, this.f28209b.intValue());
        }
        return this.f28210c != null ? a + afg.m18350b(2, this.f28210c.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        while (true) {
            int a = afe.m18324a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28209b = Integer.valueOf(afe.m18338g());
            } else if (a == 16) {
                this.f28210c = Integer.valueOf(afe.m18338g());
            } else if (!super.m29903a(afe, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28209b != null) {
            afg.m18361a(1, this.f28209b.intValue());
        }
        if (this.f28210c != null) {
            afg.m18361a(2, this.f28210c.intValue());
        }
        super.mo3804a(afg);
    }
}
