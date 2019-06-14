package com.onesignal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.onesignal.am.C5464i;

/* compiled from: OneSignalDbHelper */
public class ao extends SQLiteOpenHelper {
    /* renamed from: a */
    private static final String[] f18427a = new String[]{"CREATE INDEX notification_notification_id_idx ON notification(notification_id); ", "CREATE INDEX notification_android_notification_id_idx ON notification(android_notification_id); ", "CREATE INDEX notification_group_id_idx ON notification(group_id); ", "CREATE INDEX notification_collapse_id_idx ON notification(collapse_id); ", "CREATE INDEX notification_created_time_idx ON notification(created_time); "};
    /* renamed from: b */
    private static ao f18428b;

    private ao(Context context) {
        super(context, "OneSignal.db", null, 2);
    }

    /* renamed from: a */
    public static synchronized ao m23264a(Context context) {
        synchronized (ao.class) {
            if (f18428b == null) {
                f18428b = new ao(context.getApplicationContext());
            }
            context = f18428b;
        }
        return context;
    }

    /* renamed from: a */
    synchronized SQLiteDatabase m23266a() {
        int i = 0;
        while (true) {
            try {
                break;
            } catch (Throwable th) {
                i++;
                if (i < 5) {
                    SystemClock.sleep((long) (i * 400));
                }
            }
        }
        return getWritableDatabase();
    }

    /* renamed from: b */
    synchronized SQLiteDatabase m23267b() {
        int i = 0;
        while (true) {
            try {
                break;
            } catch (Throwable th) {
                i++;
                if (i < 5) {
                    SystemClock.sleep((long) (i * 400));
                }
            }
        }
        return getReadableDatabase();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')));");
        for (String execSQL : f18427a) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            m23265a(sQLiteDatabase, i, i2);
        } catch (Throwable e) {
            am.m23161a(C5464i.ERROR, "Error in upgrade, migration may have already run! Skipping!", e);
        }
    }

    /* renamed from: a */
    private static void m23265a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            sQLiteDatabase.execSQL("ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
            sQLiteDatabase.execSQL("CREATE INDEX notification_group_id_idx ON notification(group_id); ");
        }
    }

    public void onDowngrade(android.database.sqlite.SQLiteDatabase r4, int r5, int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r5 = com.onesignal.am.C5464i.WARN;
        r6 = "SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.";
        com.onesignal.am.m23187b(r5, r6);
        r5 = "SELECT name FROM sqlite_master WHERE type='table'";
        r6 = 0;
        r5 = r4.rawQuery(r5, r6);
        r6 = new java.util.ArrayList;	 Catch:{ all -> 0x005b }
        r0 = r5.getCount();	 Catch:{ all -> 0x005b }
        r6.<init>(r0);	 Catch:{ all -> 0x005b }
    L_0x0017:
        r0 = r5.moveToNext();	 Catch:{ all -> 0x005b }
        if (r0 == 0) goto L_0x0026;	 Catch:{ all -> 0x005b }
    L_0x001d:
        r0 = 0;	 Catch:{ all -> 0x005b }
        r0 = r5.getString(r0);	 Catch:{ all -> 0x005b }
        r6.add(r0);	 Catch:{ all -> 0x005b }
        goto L_0x0017;	 Catch:{ all -> 0x005b }
    L_0x0026:
        r6 = r6.iterator();	 Catch:{ all -> 0x005b }
    L_0x002a:
        r0 = r6.hasNext();	 Catch:{ all -> 0x005b }
        if (r0 == 0) goto L_0x0054;	 Catch:{ all -> 0x005b }
    L_0x0030:
        r0 = r6.next();	 Catch:{ all -> 0x005b }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x005b }
        r1 = "sqlite_";	 Catch:{ all -> 0x005b }
        r1 = r0.startsWith(r1);	 Catch:{ all -> 0x005b }
        if (r1 == 0) goto L_0x003f;	 Catch:{ all -> 0x005b }
    L_0x003e:
        goto L_0x002a;	 Catch:{ all -> 0x005b }
    L_0x003f:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005b }
        r1.<init>();	 Catch:{ all -> 0x005b }
        r2 = "DROP TABLE IF EXISTS ";	 Catch:{ all -> 0x005b }
        r1.append(r2);	 Catch:{ all -> 0x005b }
        r1.append(r0);	 Catch:{ all -> 0x005b }
        r0 = r1.toString();	 Catch:{ all -> 0x005b }
        r4.execSQL(r0);	 Catch:{ all -> 0x005b }
        goto L_0x002a;
    L_0x0054:
        r5.close();
        r3.onCreate(r4);
        return;
    L_0x005b:
        r4 = move-exception;
        r5.close();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.ao.onDowngrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
