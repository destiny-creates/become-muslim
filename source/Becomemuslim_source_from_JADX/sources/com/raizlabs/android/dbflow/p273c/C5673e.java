package com.raizlabs.android.dbflow.p273c;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import com.raizlabs.android.dbflow.p273c.p274a.C5664b;
import com.raizlabs.android.dbflow.p281e.C5698h;

/* compiled from: TransactionManager */
/* renamed from: com.raizlabs.android.dbflow.c.e */
public class C5673e {
    /* renamed from: b */
    private static C5673e f18950b;
    /* renamed from: a */
    protected Handler f18951a = new Handler(Looper.getMainLooper());
    /* renamed from: c */
    private final boolean f18952c;
    /* renamed from: d */
    private C5669c f18953d;
    /* renamed from: e */
    private String f18954e;

    public C5673e(String str, boolean z) {
        this.f18954e = str;
        this.f18952c = z;
        C5674f.m24054a().add(this);
        m24048a();
    }

    /* renamed from: a */
    void m24048a() {
        if (!m24052b().isAlive()) {
            m24052b().start();
        }
    }

    /* renamed from: b */
    C5669c m24052b() {
        if (this.f18953d == null) {
            if (this.f18952c) {
                this.f18953d = new C5669c(this.f18954e, this);
            } else {
                this.f18953d = C5673e.m24047c().f18953d;
            }
        }
        return this.f18953d;
    }

    /* renamed from: c */
    public static C5673e m24047c() {
        if (f18950b == null) {
            f18950b = new C5673e(C5673e.class.getSimpleName(), true);
        }
        return f18950b;
    }

    /* renamed from: a */
    public static void m24046a(SQLiteDatabase sQLiteDatabase, Runnable runnable) {
        sQLiteDatabase.beginTransaction();
        try {
            runnable.run();
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    public synchronized void m24051a(Runnable runnable) {
        this.f18951a.post(runnable);
    }

    /* renamed from: a */
    public void m24049a(C5664b c5664b) {
        m24052b().m24040a(c5664b);
    }

    /* renamed from: a */
    public <ModelClass extends C5698h> void m24050a(ModelClass modelClass) {
        if (!m24053d().isAlive()) {
            m24053d().start();
        }
        m24053d().m24033a((C5698h) modelClass);
    }

    /* renamed from: d */
    public C5666a m24053d() {
        return C5666a.m24030a();
    }
}
