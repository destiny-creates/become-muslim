package com.facebook.react.modules.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReactDatabaseSupplier extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 1;
    public static String KEY_COLUMN = "key";
    public static int SLEEP_TIME_MS = 30;
    public static String TABLE_CATALYST = "catalystLocalStorage";
    public static String VALUE_COLUMN = "value";
    public static String VERSION_TABLE_CREATE;
    public static ReactDatabaseSupplier sReactDatabaseSupplierInstance;
    public String DATABASE_NAME = "RKStorage";
    public Context mContext;
    public SQLiteDatabase mDb;
    public long mMaximumDatabaseSize = 6291456;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(TABLE_CATALYST);
        stringBuilder.append(" (");
        stringBuilder.append(KEY_COLUMN);
        stringBuilder.append(" TEXT PRIMARY KEY, ");
        stringBuilder.append(VALUE_COLUMN);
        stringBuilder.append(" TEXT NOT NULL)");
        VERSION_TABLE_CREATE = stringBuilder.toString();
    }

    public static ReactDatabaseSupplier getInstance(Context context) {
        if (sReactDatabaseSupplierInstance == null) {
            sReactDatabaseSupplierInstance = new ReactDatabaseSupplier(context.getApplicationContext());
        }
        return sReactDatabaseSupplierInstance;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(VERSION_TABLE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            deleteDatabase();
            onCreate(sQLiteDatabase);
        }
    }

    synchronized boolean ensureDatabase() {
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
        r5 = this;
        monitor-enter(r5);
        r0 = r5.mDb;	 Catch:{ all -> 0x0043 }
        r1 = 1;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0010;	 Catch:{ all -> 0x0043 }
    L_0x0006:
        r0 = r5.mDb;	 Catch:{ all -> 0x0043 }
        r0 = r0.isOpen();	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r5);
        return r1;
    L_0x0010:
        r0 = 0;
        r2 = 0;
    L_0x0012:
        r3 = 2;
        if (r2 >= r3) goto L_0x0035;
    L_0x0015:
        if (r2 <= 0) goto L_0x001d;
    L_0x0017:
        r5.deleteDatabase();	 Catch:{ SQLiteException -> 0x001b }
        goto L_0x001d;	 Catch:{ SQLiteException -> 0x001b }
    L_0x001b:
        r0 = move-exception;	 Catch:{ SQLiteException -> 0x001b }
        goto L_0x0024;	 Catch:{ SQLiteException -> 0x001b }
    L_0x001d:
        r3 = r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x001b }
        r5.mDb = r3;	 Catch:{ SQLiteException -> 0x001b }
        goto L_0x0035;
    L_0x0024:
        r3 = SLEEP_TIME_MS;	 Catch:{ InterruptedException -> 0x002b }
        r3 = (long) r3;	 Catch:{ InterruptedException -> 0x002b }
        java.lang.Thread.sleep(r3);	 Catch:{ InterruptedException -> 0x002b }
        goto L_0x0032;
    L_0x002b:
        r3 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0043 }
        r3.interrupt();	 Catch:{ all -> 0x0043 }
    L_0x0032:
        r2 = r2 + 1;	 Catch:{ all -> 0x0043 }
        goto L_0x0012;	 Catch:{ all -> 0x0043 }
    L_0x0035:
        r2 = r5.mDb;	 Catch:{ all -> 0x0043 }
        if (r2 == 0) goto L_0x0042;	 Catch:{ all -> 0x0043 }
    L_0x0039:
        r0 = r5.mDb;	 Catch:{ all -> 0x0043 }
        r2 = r5.mMaximumDatabaseSize;	 Catch:{ all -> 0x0043 }
        r0.setMaximumSize(r2);	 Catch:{ all -> 0x0043 }
        monitor-exit(r5);
        return r1;
    L_0x0042:
        throw r0;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.ReactDatabaseSupplier.ensureDatabase():boolean");
    }

    public synchronized SQLiteDatabase get() {
        ensureDatabase();
        return this.mDb;
    }

    public synchronized void clearAndCloseDatabase() {
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
        monitor-enter(r3);
        r3.clear();	 Catch:{ Exception -> 0x0023 }
        r3.closeDatabase();	 Catch:{ Exception -> 0x0023 }
        r0 = "ReactNative";	 Catch:{ Exception -> 0x0023 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0023 }
        r1.<init>();	 Catch:{ Exception -> 0x0023 }
        r2 = "Cleaned ";	 Catch:{ Exception -> 0x0023 }
        r1.append(r2);	 Catch:{ Exception -> 0x0023 }
        r2 = r3.DATABASE_NAME;	 Catch:{ Exception -> 0x0023 }
        r1.append(r2);	 Catch:{ Exception -> 0x0023 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0023 }
        com.facebook.common.logging.FLog.m5662d(r0, r1);	 Catch:{ Exception -> 0x0023 }
        monitor-exit(r3);
        return;
    L_0x0021:
        r0 = move-exception;
        goto L_0x0061;
    L_0x0023:
        r0 = r3.deleteDatabase();	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0043;	 Catch:{ all -> 0x0021 }
    L_0x0029:
        r0 = "ReactNative";	 Catch:{ all -> 0x0021 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0021 }
        r1.<init>();	 Catch:{ all -> 0x0021 }
        r2 = "Deleted Local Database ";	 Catch:{ all -> 0x0021 }
        r1.append(r2);	 Catch:{ all -> 0x0021 }
        r2 = r3.DATABASE_NAME;	 Catch:{ all -> 0x0021 }
        r1.append(r2);	 Catch:{ all -> 0x0021 }
        r1 = r1.toString();	 Catch:{ all -> 0x0021 }
        com.facebook.common.logging.FLog.m5662d(r0, r1);	 Catch:{ all -> 0x0021 }
        monitor-exit(r3);
        return;
    L_0x0043:
        r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0021 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0021 }
        r1.<init>();	 Catch:{ all -> 0x0021 }
        r2 = "Clearing and deleting database ";	 Catch:{ all -> 0x0021 }
        r1.append(r2);	 Catch:{ all -> 0x0021 }
        r2 = r3.DATABASE_NAME;	 Catch:{ all -> 0x0021 }
        r1.append(r2);	 Catch:{ all -> 0x0021 }
        r2 = " failed";	 Catch:{ all -> 0x0021 }
        r1.append(r2);	 Catch:{ all -> 0x0021 }
        r1 = r1.toString();	 Catch:{ all -> 0x0021 }
        r0.<init>(r1);	 Catch:{ all -> 0x0021 }
        throw r0;	 Catch:{ all -> 0x0021 }
    L_0x0061:
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.ReactDatabaseSupplier.clearAndCloseDatabase():void");
    }

    synchronized void clear() {
        get().delete(TABLE_CATALYST, null, null);
    }

    public synchronized void setMaximumSize(long j) {
        this.mMaximumDatabaseSize = j;
        if (this.mDb != null) {
            this.mDb.setMaximumSize(this.mMaximumDatabaseSize);
        }
    }

    private synchronized boolean deleteDatabase() {
        closeDatabase();
        return this.mContext.deleteDatabase(this.DATABASE_NAME);
    }

    private synchronized void closeDatabase() {
        if (this.mDb != null && this.mDb.isOpen()) {
            this.mDb.close();
            this.mDb = null;
        }
    }

    public static void deleteInstance() {
        sReactDatabaseSupplierInstance = null;
    }

    public ReactDatabaseSupplier(Context context) {
        super(context, "RKStorage", null, DATABASE_VERSION);
        this.mContext = context;
        this.DATABASE_NAME = "RKStorage";
    }

    public ReactDatabaseSupplier(Context context, String str) {
        super(context, str, null, DATABASE_VERSION);
        this.mContext = context;
        this.DATABASE_NAME = str;
    }
}
