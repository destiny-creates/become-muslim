package com.google.android.gms.p185e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.e.co */
final class co extends SQLiteOpenHelper {
    /* renamed from: a */
    private boolean f7497a;
    /* renamed from: b */
    private long f7498b = null;
    /* renamed from: c */
    private final /* synthetic */ cm f7499c;

    co(cm cmVar, Context context, String str) {
        this.f7499c = cmVar;
        super(context, str, null, 1);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* renamed from: a */
    private static boolean m8621a(java.lang.String r10, android.database.sqlite.SQLiteDatabase r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.co.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
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
        r4 = this;
        r0 = r4.f7497a;
        if (r0 == 0) goto L_0x0021;
    L_0x0004:
        r0 = r4.f7498b;
        r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0 = r0 + r2;
        r2 = r4.f7499c;
        r2 = r2.f11661h;
        r2 = r2.mo2482a();
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x0019;
    L_0x0018:
        goto L_0x0021;
    L_0x0019:
        r0 = new android.database.sqlite.SQLiteException;
        r1 = "Database creation failed";
        r0.<init>(r1);
        throw r0;
    L_0x0021:
        r0 = 0;
        r1 = 1;
        r4.f7497a = r1;
        r1 = r4.f7499c;
        r1 = r1.f11661h;
        r1 = r1.mo2482a();
        r4.f7498b = r1;
        r1 = super.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0037 }
        r0 = r1;
        goto L_0x004a;
    L_0x0037:
        r1 = r4.f7499c;
        r1 = r1.f11658e;
        r2 = r4.f7499c;
        r2 = r2.f11659f;
        r1 = r1.getDatabasePath(r2);
        r1.delete();
    L_0x004a:
        if (r0 != 0) goto L_0x0050;
    L_0x004c:
        r0 = super.getWritableDatabase();
    L_0x0050:
        r1 = 0;
        r4.f7497a = r1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.co.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
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
        if (co.m8621a("gtm_hits", sQLiteDatabase)) {
            sQLiteDatabase = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = sQLiteDatabase.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("hit_id") == null || hashSet.remove("hit_url") == null || hashSet.remove("hit_time") == null || hashSet.remove("hit_first_send_time") == null) {
                    throw new SQLiteException("Database column missing");
                } else if (hashSet.isEmpty() == null) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                sQLiteDatabase.close();
            }
        } else {
            sQLiteDatabase.execSQL(cm.f11654a);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ar.m8559a(sQLiteDatabase.getPath());
    }
}
