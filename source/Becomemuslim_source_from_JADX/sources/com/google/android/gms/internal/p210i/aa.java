package com.google.android.gms.internal.p210i;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.i.aa */
final class aa extends SQLiteOpenHelper {
    /* renamed from: a */
    private final /* synthetic */ C7819z f16285a;

    aa(C7819z c7819z, Context context, String str) {
        this.f16285a = c7819z;
        super(context, str, null, 1);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.f16285a;
        r0 = r0.f28924e;
        r1 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0 = r0.m20366a(r1);
        if (r0 == 0) goto L_0x004e;
    L_0x000f:
        r0 = super.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = r3.f16285a;
        r0 = r0.f28924e;
        r0.m20365a();
        r0 = r3.f16285a;
        r1 = "Opening the database failed, dropping the table and recreating it";
        r0.m21042i(r1);
        r0 = r3.f16285a;
        r0 = com.google.android.gms.internal.p210i.C7819z.m37990D();
        r1 = r3.f16285a;
        r1 = r1.m21044k();
        r0 = r1.getDatabasePath(r0);
        r0.delete();
        r0 = super.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0045 }
        r1 = r3.f16285a;	 Catch:{ SQLiteException -> 0x0045 }
        r1 = r1.f28924e;	 Catch:{ SQLiteException -> 0x0045 }
        r1.m20367b();	 Catch:{ SQLiteException -> 0x0045 }
        return r0;
    L_0x0045:
        r0 = move-exception;
        r1 = r3.f16285a;
        r2 = "Failed to open freshly created database";
        r1.m21037e(r2, r0);
        throw r0;
    L_0x004e:
        r0 = new android.database.sqlite.SQLiteException;
        r1 = "Database open failed";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.aa.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
    }

    /* renamed from: a */
    private final boolean m20276a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            sQLiteDatabase = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = sQLiteDatabase.moveToFirst();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return moveToFirst;
            } catch (SQLiteException e) {
                SQLiteException sQLiteException = e;
                cursor = sQLiteDatabase;
                sQLiteDatabase = sQLiteException;
                try {
                    this.f16285a.m21033c("Error querying for table", str, sQLiteDatabase);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                } catch (Throwable th) {
                    str = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                cursor = sQLiteDatabase;
                if (cursor != null) {
                    cursor.close();
                }
                throw str;
            }
        } catch (SQLiteException e2) {
            sQLiteDatabase = e2;
            this.f16285a.m21033c("Error querying for table", str, sQLiteDatabase);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
    }

    /* renamed from: b */
    private static Set<String> m20277b(SQLiteDatabase sQLiteDatabase, String str) {
        Set<String> hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 22);
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(str);
        stringBuilder.append(" LIMIT 0");
        sQLiteDatabase = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
        try {
            str = sQLiteDatabase.getColumnNames();
            for (Object add : str) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            sQLiteDatabase.close();
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        int i = 0;
        if (m20276a(sQLiteDatabase, "hits2")) {
            Set b = aa.m20277b(sQLiteDatabase, "hits2");
            String[] strArr = new String[]{"hit_id", "hit_string", "hit_time", "hit_url"};
            int i2 = 0;
            while (i2 < 4) {
                Object obj = strArr[i2];
                if (b.remove(obj)) {
                    i2++;
                } else {
                    String str = "Database hits2 is missing required column: ";
                    String valueOf = String.valueOf(obj);
                    throw new SQLiteException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            int remove = b.remove("hit_app_id") ^ 1;
            if (!b.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (remove != 0) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        } else {
            sQLiteDatabase.execSQL(C7819z.f28920a);
        }
        if (m20276a(sQLiteDatabase, "properties")) {
            sQLiteDatabase = aa.m20277b(sQLiteDatabase, "properties");
            String[] strArr2 = new String[]{"app_uid", "cid", "tid", NativeProtocol.WEB_DIALOG_PARAMS, "adid", "hits_count"};
            while (i < 6) {
                Object obj2 = strArr2[i];
                if (sQLiteDatabase.remove(obj2)) {
                    i++;
                } else {
                    str = "Database properties is missing required column: ";
                    valueOf = String.valueOf(obj2);
                    throw new SQLiteException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            if (sQLiteDatabase.isEmpty() == null) {
                throw new SQLiteException("Database properties table has extra columns");
            }
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase = sQLiteDatabase.getPath();
        if (az.m20309a() >= 9) {
            File file = new File(sQLiteDatabase);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }
}
