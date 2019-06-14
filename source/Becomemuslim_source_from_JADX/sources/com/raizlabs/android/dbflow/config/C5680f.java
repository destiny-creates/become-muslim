package com.raizlabs.android.dbflow.config;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import com.raizlabs.android.dbflow.config.C5679e.C5678a;
import com.raizlabs.android.dbflow.p272b.C5657e;
import com.raizlabs.android.dbflow.p281e.C5697g;
import com.raizlabs.android.dbflow.p281e.C5698h;
import com.raizlabs.android.dbflow.p281e.C7140e;
import com.raizlabs.android.dbflow.p281e.C8028c;
import com.raizlabs.android.dbflow.p281e.C8029d;
import com.raizlabs.android.dbflow.p281e.C8030i;
import com.raizlabs.android.dbflow.p281e.C8031j;
import com.raizlabs.android.dbflow.p281e.C8032k;

/* compiled from: FlowManager */
/* renamed from: com.raizlabs.android.dbflow.config.f */
public class C5680f {
    /* renamed from: a */
    private static Context f18980a;
    /* renamed from: b */
    private static C5676b f18981b;

    /* renamed from: a */
    public static String m24082a(Class<? extends C5698h> cls) {
        C8030i e = C5680f.m24089e(cls);
        if (e != null) {
            return e.mo6774c();
        }
        cls = C5680f.m24086b(cls).m24058b(cls);
        return cls != null ? cls.m38928c() : null;
    }

    /* renamed from: b */
    public static C5675a m24086b(Class<? extends C5698h> cls) {
        C5680f.m24081a();
        C5675a b = f18981b.m24073b(cls);
        if (b != null) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Table: ");
        stringBuilder.append(cls.getName());
        stringBuilder.append(" is not registered with a Database. ");
        stringBuilder.append("Did you forget the @Table annotation?");
        throw new C5697g(stringBuilder.toString());
    }

    /* renamed from: a */
    protected static C5676b m24081a() {
        if (f18981b == null) {
            try {
                f18981b = (C5676b) Class.forName("com.raizlabs.android.dbflow.config.GeneratedDatabaseHolder").newInstance();
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }
        return f18981b;
    }

    /* renamed from: b */
    public static Context m24085b() {
        if (f18980a != null) {
            return f18980a;
        }
        throw new IllegalStateException("Context cannot be null for FlowManager");
    }

    /* renamed from: a */
    public static void m24083a(Context context) {
        f18980a = context;
        C5680f.m24081a();
    }

    /* renamed from: c */
    public static C5657e m24087c(Class<?> cls) {
        return f18981b.m24071a(cls);
    }

    /* renamed from: d */
    public static C7140e m24088d(Class<? extends C5698h> cls) {
        C7140e e = C5680f.m24089e(cls);
        if (e != null) {
            return e;
        }
        if (C8028c.class.isAssignableFrom(cls)) {
            return C5680f.m24090f(cls);
        }
        return C8029d.class.isAssignableFrom(cls) ? C5680f.m24091g(cls) : e;
    }

    /* renamed from: e */
    public static <ModelClass extends C5698h> C8030i<ModelClass> m24089e(Class<ModelClass> cls) {
        return C5680f.m24086b(cls).m24056a((Class) cls);
    }

    /* renamed from: f */
    public static <ModelViewClass extends C8028c<? extends C5698h>> C8031j<? extends C5698h, ModelViewClass> m24090f(Class<ModelViewClass> cls) {
        return C5680f.m24086b(cls).m24058b(cls);
    }

    /* renamed from: g */
    public static <QueryModel extends C8029d> C8032k<QueryModel> m24091g(Class<QueryModel> cls) {
        return C5680f.m24086b(cls).m24060c(cls);
    }

    /* renamed from: a */
    public static boolean m24084a(SQLiteOpenHelper sQLiteOpenHelper) {
        Throwable th;
        try {
            sQLiteOpenHelper = sQLiteOpenHelper.getWritableDatabase().compileStatement("PRAGMA quick_check(1)");
            try {
                boolean z;
                String simpleQueryForString = sQLiteOpenHelper.simpleQueryForString();
                if (simpleQueryForString.equalsIgnoreCase("ok")) {
                    z = true;
                } else {
                    C5678a c5678a = C5678a.E;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("PRAGMA integrity_check on temp DB returned: ");
                    stringBuilder.append(simpleQueryForString);
                    C5679e.m24075a(c5678a, stringBuilder.toString());
                    z = false;
                }
                if (sQLiteOpenHelper != null) {
                    sQLiteOpenHelper.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteOpenHelper != null) {
                    sQLiteOpenHelper.close();
                }
                throw th;
            }
        } catch (SQLiteOpenHelper sQLiteOpenHelper2) {
            th = sQLiteOpenHelper2;
            sQLiteOpenHelper2 = null;
            if (sQLiteOpenHelper2 != null) {
                sQLiteOpenHelper2.close();
            }
            throw th;
        }
    }
}
