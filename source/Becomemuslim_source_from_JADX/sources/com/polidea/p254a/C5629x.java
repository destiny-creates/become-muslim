package com.polidea.p254a;

import java.util.concurrent.TimeUnit;

/* compiled from: ConnectionSetup */
/* renamed from: com.polidea.a.x */
public class C5629x {
    /* renamed from: a */
    public final boolean f18805a;
    /* renamed from: b */
    public final boolean f18806b;
    /* renamed from: c */
    public final aj f18807c;

    /* compiled from: ConnectionSetup */
    /* renamed from: com.polidea.a.x$a */
    public static class C5628a {
        /* renamed from: a */
        private boolean f18802a = false;
        /* renamed from: b */
        private boolean f18803b = false;
        /* renamed from: c */
        private aj f18804c = new aj(30, TimeUnit.SECONDS);

        /* renamed from: a */
        public C5628a m23926a(boolean z) {
            this.f18802a = z;
            return this;
        }

        /* renamed from: b */
        public C5628a m23928b(boolean z) {
            this.f18803b = z;
            return this;
        }

        /* renamed from: a */
        public C5629x m23927a() {
            return new C5629x(this.f18802a, this.f18803b, this.f18804c);
        }
    }

    private C5629x(boolean z, boolean z2, aj ajVar) {
        this.f18805a = z;
        this.f18806b = z2;
        this.f18807c = ajVar;
    }
}
