package com.facebook.ads.internal.p090e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.facebook.ads.internal.e.e */
public class C1373e extends SQLiteOpenHelper {
    /* renamed from: a */
    private final C1372d f3993a;

    public C1373e(Context context, C1372d c1372d) {
        super(context, "ads.db", null, 4);
        if (c1372d != null) {
            this.f3993a = c1372d;
            return;
        }
        throw new IllegalArgumentException("AdDatabaseHelper can not be null");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (C1376g a : this.f3993a.m4692c()) {
            a.m4706a(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (C1376g c1376g : this.f3993a.m4692c()) {
            c1376g.m4707b(sQLiteDatabase);
            c1376g.m4706a(sQLiteDatabase);
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 2 && i2 >= 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crashes");
        }
        if (i <= 3 && i2 >= 4) {
            C1369b c1369b = C3575c.f9564i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ALTER TABLE events ADD COLUMN ");
            stringBuilder.append(c1369b.f3972b);
            stringBuilder.append(" ");
            stringBuilder.append(c1369b.f3973c);
            stringBuilder.append(" DEFAULT 0");
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }
    }
}
