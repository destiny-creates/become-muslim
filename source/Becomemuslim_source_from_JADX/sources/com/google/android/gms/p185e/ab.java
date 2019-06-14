package com.google.android.gms.p185e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.e.ab */
final class ab extends SQLiteOpenHelper {
    /* renamed from: a */
    private final /* synthetic */ C4404x f7453a;

    ab(C4404x c4404x, Context context, String str) {
        this.f7453a = c4404x;
        super(context, str, null, 1);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: a */
    private static boolean m8545a(java.lang.String r10, android.database.sqlite.SQLiteDatabase r11) {
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
        r0 = 0;
        r1 = 0;
        r3 = "SQLITE_MASTER";	 Catch:{ SQLiteException -> 0x002a }
        r2 = "name";	 Catch:{ SQLiteException -> 0x002a }
        r4 = new java.lang.String[]{r2};	 Catch:{ SQLiteException -> 0x002a }
        r5 = "name=?";	 Catch:{ SQLiteException -> 0x002a }
        r2 = 1;	 Catch:{ SQLiteException -> 0x002a }
        r6 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x002a }
        r6[r0] = r10;	 Catch:{ SQLiteException -> 0x002a }
        r7 = 0;	 Catch:{ SQLiteException -> 0x002a }
        r8 = 0;	 Catch:{ SQLiteException -> 0x002a }
        r9 = 0;	 Catch:{ SQLiteException -> 0x002a }
        r2 = r11;	 Catch:{ SQLiteException -> 0x002a }
        r11 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x002a }
        r1 = r11.moveToFirst();	 Catch:{ SQLiteException -> 0x0026, all -> 0x0023 }
        if (r11 == 0) goto L_0x0022;
    L_0x001f:
        r11.close();
    L_0x0022:
        return r1;
    L_0x0023:
        r10 = move-exception;
        r1 = r11;
        goto L_0x0049;
    L_0x0026:
        r1 = r11;
        goto L_0x002a;
    L_0x0028:
        r10 = move-exception;
        goto L_0x0049;
    L_0x002a:
        r11 = "Error querying for table ";	 Catch:{ all -> 0x0028 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ all -> 0x0028 }
        r2 = r10.length();	 Catch:{ all -> 0x0028 }
        if (r2 == 0) goto L_0x003b;	 Catch:{ all -> 0x0028 }
    L_0x0036:
        r10 = r11.concat(r10);	 Catch:{ all -> 0x0028 }
        goto L_0x0040;	 Catch:{ all -> 0x0028 }
    L_0x003b:
        r10 = new java.lang.String;	 Catch:{ all -> 0x0028 }
        r10.<init>(r11);	 Catch:{ all -> 0x0028 }
    L_0x0040:
        com.google.android.gms.p185e.bs.m8584b(r10);	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0048;
    L_0x0045:
        r1.close();
    L_0x0048:
        return r0;
    L_0x0049:
        if (r1 == 0) goto L_0x004e;
    L_0x004b:
        r1.close();
    L_0x004e:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.ab.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
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
        r2 = this;
        r0 = super.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0005 }
        goto L_0x0015;
    L_0x0005:
        r0 = r2.f7453a;
        r0 = r0.f11755c;
        r1 = "google_tagmanager.db";
        r0 = r0.getDatabasePath(r1);
        r0.delete();
        r0 = 0;
    L_0x0015:
        if (r0 != 0) goto L_0x001b;
    L_0x0017:
        r0 = super.getWritableDatabase();
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.ab.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
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
        if (ab.m8545a("datalayer", sQLiteDatabase)) {
            sQLiteDatabase = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = sQLiteDatabase.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("key") == null || hashSet.remove("value") == null || hashSet.remove("ID") == null || hashSet.remove("expires") == null) {
                    throw new SQLiteException("Database column missing");
                } else if (hashSet.isEmpty() == null) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                sQLiteDatabase.close();
            }
        } else {
            sQLiteDatabase.execSQL(C4404x.f11753a);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ar.m8559a(sQLiteDatabase.getPath());
    }
}
