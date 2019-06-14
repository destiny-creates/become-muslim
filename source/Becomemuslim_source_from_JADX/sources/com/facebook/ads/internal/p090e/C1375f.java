package com.facebook.ads.internal.p090e;

import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.internal.e.f */
abstract class C1375f<T> {
    /* renamed from: a */
    private C1374a f4002a;

    /* renamed from: com.facebook.ads.internal.e.f$a */
    public enum C1374a {
        UNKNOWN(9000, "An unknown error has occurred."),
        DATABASE_SELECT(AdError.MEDIATION_ERROR_CODE, "Failed to read from database."),
        DATABASE_INSERT(3002, "Failed to insert row into database."),
        DATABASE_UPDATE(3003, "Failed to update row in database."),
        DATABASE_DELETE(3004, "Failed to delete row from database.");
        
        /* renamed from: f */
        private final int f4000f;
        /* renamed from: g */
        private final String f4001g;

        private C1374a(int i, String str) {
            this.f4000f = i;
            this.f4001g = str;
        }

        /* renamed from: a */
        public int m4697a() {
            return this.f4000f;
        }

        /* renamed from: b */
        public String m4698b() {
            return this.f4001g;
        }
    }

    C1375f() {
    }

    /* renamed from: a */
    protected void m4699a(C1374a c1374a) {
        this.f4002a = c1374a;
    }

    /* renamed from: b */
    abstract T mo2869b();

    /* renamed from: c */
    public C1374a m4701c() {
        return this.f4002a;
    }
}
