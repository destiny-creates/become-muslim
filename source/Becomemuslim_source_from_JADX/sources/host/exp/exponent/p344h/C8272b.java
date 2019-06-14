package host.exp.exponent.p344h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.raizlabs.android.dbflow.p276d.p277a.C8023b;
import com.raizlabs.android.dbflow.p276d.p277a.C8024c;
import com.raizlabs.android.dbflow.p276d.p278b.C7132g;
import com.raizlabs.android.dbflow.p281e.C5698h;
import com.raizlabs.android.dbflow.p281e.C8030i;

/* compiled from: ExperienceDBObject$Adapter */
/* renamed from: host.exp.exponent.h.b */
public final class C8272b extends C8030i<C8177a> {
    /* renamed from: c */
    public String mo6774c() {
        return "ExperienceDBObject";
    }

    /* renamed from: f */
    public String mo6777f() {
        return "id";
    }

    /* renamed from: g */
    public boolean mo6778g() {
        return true;
    }

    /* renamed from: h */
    public String mo6779h() {
        return "CREATE TABLE IF NOT EXISTS `ExperienceDBObject`(`id` TEXT, `manifestUrl` TEXT, `bundleUrl` TEXT, `manifest` TEXT, PRIMARY KEY(`id`));";
    }

    /* renamed from: i */
    protected final String mo6780i() {
        return "INSERT INTO `ExperienceDBObject` (`ID`, `MANIFESTURL`, `BUNDLEURL`, `MANIFEST`) VALUES (?, ?, ?, ?)";
    }

    /* renamed from: a */
    public /* synthetic */ C5698h mo6768a() {
        return m42899k();
    }

    /* renamed from: a */
    public /* synthetic */ Object mo6283a(C5698h c5698h) {
        return m42890b((C8177a) c5698h);
    }

    /* renamed from: e */
    public /* synthetic */ boolean mo6775e(C5698h c5698h) {
        return m42888a((C8177a) c5698h);
    }

    /* renamed from: f */
    public /* synthetic */ C8024c mo6776f(C5698h c5698h) {
        return m42891c((C8177a) c5698h);
    }

    /* renamed from: b */
    public Class<C8177a> mo6773b() {
        return C8177a.class;
    }

    /* renamed from: a */
    public void m42887a(SQLiteStatement sQLiteStatement, C8177a c8177a) {
        if (c8177a.f30370a != null) {
            sQLiteStatement.bindString(1, c8177a.f30370a);
        } else {
            sQLiteStatement.bindNull(1);
        }
        if (c8177a.f30371b != null) {
            sQLiteStatement.bindString(2, c8177a.f30371b);
        } else {
            sQLiteStatement.bindNull(2);
        }
        if (c8177a.f30372c != null) {
            sQLiteStatement.bindString(3, c8177a.f30372c);
        } else {
            sQLiteStatement.bindNull(3);
        }
        if (c8177a.f30373d != null) {
            sQLiteStatement.bindString(4, c8177a.f30373d);
        } else {
            sQLiteStatement.bindNull(4);
        }
    }

    /* renamed from: a */
    public void m42883a(ContentValues contentValues, C8177a c8177a) {
        if (c8177a.f30370a != null) {
            contentValues.put("id", c8177a.f30370a);
        } else {
            contentValues.putNull("id");
        }
        if (c8177a.f30371b != null) {
            contentValues.put("manifestUrl", c8177a.f30371b);
        } else {
            contentValues.putNull("manifestUrl");
        }
        if (c8177a.f30372c != null) {
            contentValues.put("bundleUrl", c8177a.f30372c);
        } else {
            contentValues.putNull("bundleUrl");
        }
        if (c8177a.f30373d != null) {
            contentValues.put("manifest", c8177a.f30373d);
        } else {
            contentValues.putNull("manifest");
        }
    }

    /* renamed from: a */
    public boolean m42888a(C8177a c8177a) {
        return new C7132g().m33176a(C8177a.class).m38892a(m42891c(c8177a)).m38908f();
    }

    /* renamed from: a */
    public void m42885a(Cursor cursor, C8177a c8177a) {
        int columnIndex = cursor.getColumnIndex("id");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8177a.f30370a = null;
            } else {
                c8177a.f30370a = cursor.getString(columnIndex);
            }
        }
        columnIndex = cursor.getColumnIndex("manifestUrl");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8177a.f30371b = null;
            } else {
                c8177a.f30371b = cursor.getString(columnIndex);
            }
        }
        columnIndex = cursor.getColumnIndex("bundleUrl");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8177a.f30372c = null;
            } else {
                c8177a.f30372c = cursor.getString(columnIndex);
            }
        }
        columnIndex = cursor.getColumnIndex("manifest");
        if (columnIndex == -1) {
            return;
        }
        if (cursor.isNull(columnIndex)) {
            c8177a.f30373d = null;
        } else {
            c8177a.f30373d = cursor.getString(columnIndex);
        }
    }

    /* renamed from: b */
    public Object m42890b(C8177a c8177a) {
        return c8177a.f30370a;
    }

    /* renamed from: a */
    public Object mo6769a(Cursor cursor, int i) {
        return cursor.getString(i);
    }

    /* renamed from: c */
    public C8024c<C8177a> m42891c(C8177a c8177a) {
        return new C8024c(C8177a.class, C8023b.m38874a("id").m38875a(c8177a.f30370a));
    }

    /* renamed from: k */
    public final C8177a m42899k() {
        return new C8177a();
    }
}
