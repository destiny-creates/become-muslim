package com.raizlabs.android.dbflow.config;

import android.database.sqlite.SQLiteDatabase;
import com.raizlabs.android.dbflow.C5656a;
import com.raizlabs.android.dbflow.p276d.p279c.C5689a;
import com.raizlabs.android.dbflow.p281e.C5698h;
import com.raizlabs.android.dbflow.p281e.C8028c;
import com.raizlabs.android.dbflow.p281e.C8029d;
import com.raizlabs.android.dbflow.p281e.C8030i;
import com.raizlabs.android.dbflow.p281e.C8031j;
import com.raizlabs.android.dbflow.p281e.C8032k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BaseDatabaseDefinition */
/* renamed from: com.raizlabs.android.dbflow.config.a */
public abstract class C5675a {
    /* renamed from: a */
    final Map<Integer, List<C5689a>> f18956a = new HashMap();
    /* renamed from: b */
    final List<Class<? extends C5698h>> f18957b = new ArrayList();
    /* renamed from: c */
    final Map<Class<? extends C5698h>, C8030i> f18958c = new HashMap();
    /* renamed from: d */
    final Map<String, Class<? extends C5698h>> f18959d = new HashMap();
    /* renamed from: e */
    final Map<Class<? extends C5698h>, Object> f18960e = new HashMap();
    /* renamed from: f */
    final List<Class<? extends C8028c>> f18961f = new ArrayList();
    /* renamed from: g */
    final Map<Class<? extends C8028c>, C8031j> f18962g = new HashMap();
    /* renamed from: h */
    final Map<Class<? extends C8029d>, C8032k> f18963h = new HashMap();
    /* renamed from: i */
    protected final C5656a f18964i = new C71171(this);
    /* renamed from: j */
    private C5684g f18965j;
    /* renamed from: k */
    private C5656a f18966k;
    /* renamed from: l */
    private boolean f18967l = false;

    /* compiled from: BaseDatabaseDefinition */
    /* renamed from: com.raizlabs.android.dbflow.config.a$1 */
    class C71171 implements C5656a {
        /* renamed from: a */
        final /* synthetic */ C5675a f25256a;

        C71171(C5675a c5675a) {
            this.f25256a = c5675a;
        }

        /* renamed from: a */
        public void mo5049a(SQLiteDatabase sQLiteDatabase) {
            if (this.f25256a.f18966k != null) {
                this.f25256a.f18966k.mo5049a(sQLiteDatabase);
            }
        }

        /* renamed from: b */
        public void mo5051b(SQLiteDatabase sQLiteDatabase) {
            if (this.f25256a.f18966k != null) {
                this.f25256a.f18966k.mo5051b(sQLiteDatabase);
            }
        }

        /* renamed from: a */
        public void mo5050a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (this.f25256a.f18966k != null) {
                this.f25256a.f18966k.mo5050a(sQLiteDatabase, i, i2);
            }
        }
    }

    /* renamed from: g */
    public abstract String mo5052g();

    /* renamed from: i */
    public abstract int mo5053i();

    /* renamed from: j */
    public abstract boolean mo5054j();

    /* renamed from: k */
    public abstract boolean mo5055k();

    /* renamed from: l */
    public abstract boolean mo5056l();

    /* renamed from: a */
    List<C8030i> m24057a() {
        return new ArrayList(this.f18958c.values());
    }

    /* renamed from: a */
    C8030i m24056a(Class<? extends C5698h> cls) {
        return (C8030i) this.f18958c.get(cls);
    }

    /* renamed from: b */
    C8031j m24058b(Class<? extends C8028c> cls) {
        return (C8031j) this.f18962g.get(cls);
    }

    /* renamed from: b */
    List<C8031j> m24059b() {
        return new ArrayList(this.f18962g.values());
    }

    /* renamed from: c */
    C8032k m24060c(Class<? extends C8029d> cls) {
        return (C8032k) this.f18963h.get(cls);
    }

    /* renamed from: c */
    Map<Integer, List<C5689a>> m24061c() {
        return this.f18956a;
    }

    /* renamed from: d */
    C5684g m24062d() {
        if (this.f18965j == null) {
            this.f18965j = m24063e();
        }
        return this.f18965j;
    }

    /* renamed from: e */
    protected C5684g m24063e() {
        return new C5684g(this, this.f18964i);
    }

    /* renamed from: f */
    public SQLiteDatabase m24064f() {
        return m24062d().getWritableDatabase();
    }

    /* renamed from: h */
    public String m24066h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo5052g());
        stringBuilder.append(".db");
        return stringBuilder.toString();
    }
}
