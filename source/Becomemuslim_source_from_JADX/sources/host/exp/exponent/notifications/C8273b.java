package host.exp.exponent.notifications;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p276d.p277a.C8023b;
import com.raizlabs.android.dbflow.p276d.p277a.C8024c;
import com.raizlabs.android.dbflow.p276d.p278b.C7132g;
import com.raizlabs.android.dbflow.p281e.C5698h;
import com.raizlabs.android.dbflow.p281e.C8030i;

/* compiled from: ActionObject$Adapter */
/* renamed from: host.exp.exponent.notifications.b */
public final class C8273b extends C8030i<C8178a> {
    /* renamed from: c */
    public String mo6774c() {
        return "ActionObject";
    }

    /* renamed from: h */
    public String mo6779h() {
        return "CREATE TABLE IF NOT EXISTS `ActionObject`(`categoryId` TEXT, `actionId` TEXT, `buttonTitle` TEXT, `isDestructive` INTEGER, `isAuthenticationRequired` INTEGER, `submitButtonTitle` TEXT, `placeholder` TEXT, `shouldShowTextInput` INTEGER, `position` INTEGER, PRIMARY KEY(`actionId`));";
    }

    /* renamed from: i */
    protected final String mo6780i() {
        return "INSERT INTO `ActionObject` (`CATEGORYID`, `ACTIONID`, `BUTTONTITLE`, `ISDESTRUCTIVE`, `ISAUTHENTICATIONREQUIRED`, `SUBMITBUTTONTITLE`, `PLACEHOLDER`, `SHOULDSHOWTEXTINPUT`, `POSITION`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    /* renamed from: a */
    public /* synthetic */ C5698h mo6768a() {
        return m42915k();
    }

    /* renamed from: e */
    public /* synthetic */ boolean mo6775e(C5698h c5698h) {
        return m42907a((C8178a) c5698h);
    }

    /* renamed from: f */
    public /* synthetic */ C8024c mo6776f(C5698h c5698h) {
        return m42908b((C8178a) c5698h);
    }

    /* renamed from: b */
    public Class<C8178a> mo6773b() {
        return C8178a.class;
    }

    /* renamed from: a */
    public void m42906a(SQLiteStatement sQLiteStatement, C8178a c8178a) {
        if (c8178a.m39734i() != null) {
            sQLiteStatement.bindString(1, c8178a.m39734i());
        } else {
            sQLiteStatement.bindNull(1);
        }
        if (c8178a.m39727d() != null) {
            sQLiteStatement.bindString(2, c8178a.m39727d());
        } else {
            sQLiteStatement.bindNull(2);
        }
        if (c8178a.m39729e() != null) {
            sQLiteStatement.bindString(3, c8178a.m39729e());
        } else {
            sQLiteStatement.bindNull(3);
        }
        Object b = C5680f.m24087c(Boolean.class).mo5041b(c8178a.m39735j());
        if (b != null) {
            sQLiteStatement.bindLong(4, (long) ((Integer) b).intValue());
        } else {
            sQLiteStatement.bindNull(4);
        }
        b = C5680f.m24087c(Boolean.class).mo5041b(c8178a.m39736k());
        if (b != null) {
            sQLiteStatement.bindLong(5, (long) ((Integer) b).intValue());
        } else {
            sQLiteStatement.bindNull(5);
        }
        if (c8178a.m39733h() != null) {
            sQLiteStatement.bindString(6, c8178a.m39733h());
        } else {
            sQLiteStatement.bindNull(6);
        }
        if (c8178a.m39737l() != null) {
            sQLiteStatement.bindString(7, c8178a.m39737l());
        } else {
            sQLiteStatement.bindNull(7);
        }
        b = C5680f.m24087c(Boolean.class).mo5041b(Boolean.valueOf(c8178a.m39731f()));
        if (b != null) {
            sQLiteStatement.bindLong(8, (long) ((Integer) b).intValue());
        } else {
            sQLiteStatement.bindNull(8);
        }
        sQLiteStatement.bindLong(9, (long) c8178a.m39732g());
    }

    /* renamed from: a */
    public void m42902a(ContentValues contentValues, C8178a c8178a) {
        if (c8178a.m39734i() != null) {
            contentValues.put("categoryId", c8178a.m39734i());
        } else {
            contentValues.putNull("categoryId");
        }
        if (c8178a.m39727d() != null) {
            contentValues.put("actionId", c8178a.m39727d());
        } else {
            contentValues.putNull("actionId");
        }
        if (c8178a.m39729e() != null) {
            contentValues.put("buttonTitle", c8178a.m39729e());
        } else {
            contentValues.putNull("buttonTitle");
        }
        Object b = C5680f.m24087c(Boolean.class).mo5041b(c8178a.m39735j());
        if (b != null) {
            contentValues.put("isDestructive", (Integer) b);
        } else {
            contentValues.putNull("isDestructive");
        }
        b = C5680f.m24087c(Boolean.class).mo5041b(c8178a.m39736k());
        if (b != null) {
            contentValues.put("isAuthenticationRequired", (Integer) b);
        } else {
            contentValues.putNull("isAuthenticationRequired");
        }
        if (c8178a.m39733h() != null) {
            contentValues.put("submitButtonTitle", c8178a.m39733h());
        } else {
            contentValues.putNull("submitButtonTitle");
        }
        if (c8178a.m39737l() != null) {
            contentValues.put(ReactTextInputShadowNode.PROP_PLACEHOLDER, c8178a.m39737l());
        } else {
            contentValues.putNull(ReactTextInputShadowNode.PROP_PLACEHOLDER);
        }
        b = C5680f.m24087c(Boolean.class).mo5041b(Boolean.valueOf(c8178a.m39731f()));
        if (b != null) {
            contentValues.put("shouldShowTextInput", (Integer) b);
        } else {
            contentValues.putNull("shouldShowTextInput");
        }
        contentValues.put(ViewProps.POSITION, Integer.valueOf(c8178a.m39732g()));
    }

    /* renamed from: a */
    public boolean m42907a(C8178a c8178a) {
        return new C7132g().m33176a(C8178a.class).m38892a(m42908b(c8178a)).m38908f();
    }

    /* renamed from: a */
    public void m42904a(Cursor cursor, C8178a c8178a) {
        int columnIndex = cursor.getColumnIndex("categoryId");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8178a.m39726c(null);
            } else {
                c8178a.m39726c(cursor.getString(columnIndex));
            }
        }
        columnIndex = cursor.getColumnIndex("actionId");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8178a.m39722a(null);
            } else {
                c8178a.m39722a(cursor.getString(columnIndex));
            }
        }
        columnIndex = cursor.getColumnIndex("buttonTitle");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8178a.m39728d(null);
            } else {
                c8178a.m39728d(cursor.getString(columnIndex));
            }
        }
        columnIndex = cursor.getColumnIndex("isDestructive");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8178a.m39723b(null);
            } else {
                c8178a.m39723b((Boolean) C5680f.m24087c(Boolean.class).mo5040a(Integer.valueOf(cursor.getInt(columnIndex))));
            }
        }
        columnIndex = cursor.getColumnIndex("isAuthenticationRequired");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8178a.m39725c(null);
            } else {
                c8178a.m39725c((Boolean) C5680f.m24087c(Boolean.class).mo5040a(Integer.valueOf(cursor.getInt(columnIndex))));
            }
        }
        columnIndex = cursor.getColumnIndex("submitButtonTitle");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8178a.m39724b(null);
            } else {
                c8178a.m39724b(cursor.getString(columnIndex));
            }
        }
        columnIndex = cursor.getColumnIndex(ReactTextInputShadowNode.PROP_PLACEHOLDER);
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8178a.m39730e(null);
            } else {
                c8178a.m39730e(cursor.getString(columnIndex));
            }
        }
        columnIndex = cursor.getColumnIndex("shouldShowTextInput");
        if (columnIndex != -1) {
            if (cursor.isNull(columnIndex)) {
                c8178a.m39721a(null);
            } else {
                c8178a.m39721a((Boolean) C5680f.m24087c(Boolean.class).mo5040a(Integer.valueOf(cursor.getInt(columnIndex))));
            }
        }
        columnIndex = cursor.getColumnIndex(ViewProps.POSITION);
        if (columnIndex != -1) {
            c8178a.m39720a(cursor.getInt(columnIndex));
        }
    }

    /* renamed from: b */
    public C8024c<C8178a> m42908b(C8178a c8178a) {
        return new C8024c(C8178a.class, C8023b.m38874a("actionId").m38875a(c8178a.m39727d()));
    }

    /* renamed from: k */
    public final C8178a m42915k() {
        return new C8178a();
    }
}
