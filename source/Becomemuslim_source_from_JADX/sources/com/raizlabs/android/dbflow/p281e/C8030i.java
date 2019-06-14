package com.raizlabs.android.dbflow.p281e;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p271a.C5655b;
import com.raizlabs.android.dbflow.p276d.C5690c;

/* compiled from: ModelAdapter */
/* renamed from: com.raizlabs.android.dbflow.e.i */
public abstract class C8030i<ModelClass extends C5698h> implements C7140e<ModelClass, ModelClass>, C5696f<ModelClass, ModelClass> {
    /* renamed from: a */
    private SQLiteStatement f29814a;

    /* renamed from: a */
    public void mo6284a(ModelClass modelClass, long j) {
    }

    /* renamed from: g */
    public boolean mo6778g() {
        return false;
    }

    /* renamed from: h */
    public abstract String mo6779h();

    /* renamed from: i */
    protected abstract String mo6780i();

    /* renamed from: d */
    public SQLiteStatement m38920d() {
        if (this.f29814a == null) {
            this.f29814a = C5680f.m24086b(mo6773b()).m24064f().compileStatement(mo6780i());
        }
        return this.f29814a;
    }

    /* renamed from: b */
    public void m38917b(ModelClass modelClass) {
        C5690c.m24122a((C5698h) modelClass, (C5699l) this, this);
    }

    /* renamed from: c */
    public void m38918c(ModelClass modelClass) {
        C5690c.m24132d(modelClass, this, this);
    }

    /* renamed from: d */
    public long m38919d(ModelClass modelClass) {
        throw new C5697g(String.format("This method may have been called in error. The model class %1s must containa single primary key (if used in a ModelCache, this method may be called)", new Object[]{mo6773b()}));
    }

    /* renamed from: e */
    public String m38921e() {
        throw new C5697g(String.format("This method may have been called in error. The model class %1s must containan autoincrementing or single int/long primary key (if used in a ModelCache, this method may be called)", new Object[]{mo6773b()}));
    }

    /* renamed from: a */
    public Object mo6283a(ModelClass modelClass) {
        return Long.valueOf(m38919d(modelClass));
    }

    /* renamed from: f */
    public String mo6777f() {
        return m38921e();
    }

    /* renamed from: a */
    public Object mo6769a(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i));
    }

    /* renamed from: j */
    public C5655b m38926j() {
        return C5655b.ABORT;
    }
}
