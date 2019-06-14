package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.util.C2895e;

/* renamed from: com.google.android.gms.internal.l.ax */
public final class ax extends C8220s {
    /* renamed from: a */
    private final ay f32797a = new ay(this, mo4752n(), "google_app_measurement_local.db");
    /* renamed from: b */
    private boolean f32798b;

    ax(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: C */
    private final SQLiteDatabase m43985C() {
        if (this.f32798b) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f32797a.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f32798b = true;
        return null;
    }

    /* renamed from: a */
    private final boolean m43986a(int r18, byte[] r19) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r17 = this;
        r1 = r17;
        r17.mo6208b();
        r17.mo6210d();
        r0 = r1.f32798b;
        r2 = 0;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return r2;
    L_0x000e:
        r3 = new android.content.ContentValues;
        r3.<init>();
        r0 = "type";
        r4 = java.lang.Integer.valueOf(r18);
        r3.put(r0, r4);
        r0 = "entry";
        r4 = r19;
        r3.put(r0, r4);
        r4 = 5;
        r5 = 0;
        r6 = 5;
    L_0x0026:
        if (r5 >= r4) goto L_0x0130;
    L_0x0028:
        r7 = 0;
        r8 = 1;
        r9 = r17.m43985C();	 Catch:{ SQLiteFullException -> 0x0104, SQLiteDatabaseLockedException -> 0x00f2, SQLiteException -> 0x00c7, all -> 0x00c3 }
        if (r9 != 0) goto L_0x0040;
    L_0x0030:
        r1.f32798b = r8;	 Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x0038 }
        if (r9 == 0) goto L_0x0037;
    L_0x0034:
        r9.close();
    L_0x0037:
        return r2;
    L_0x0038:
        r0 = move-exception;
        r12 = r7;
    L_0x003a:
        r7 = r9;
        goto L_0x00c9;
    L_0x003d:
        r0 = move-exception;
        goto L_0x0106;
    L_0x0040:
        r9.beginTransaction();	 Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x0038 }
        r10 = 0;	 Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x0038 }
        r0 = "select count(1) from messages";	 Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x0038 }
        r12 = r9.rawQuery(r0, r7);	 Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x0038 }
        if (r12 == 0) goto L_0x0061;
    L_0x004d:
        r0 = r12.moveToFirst();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        if (r0 == 0) goto L_0x0061;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0053:
        r10 = r12.getLong(r2);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        goto L_0x0061;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0058:
        r0 = move-exception;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        goto L_0x0125;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x005b:
        r0 = move-exception;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        goto L_0x003a;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x005d:
        r0 = move-exception;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r7 = r12;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        goto L_0x0106;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0061:
        r13 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        if (r0 < 0) goto L_0x00ab;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0068:
        r0 = r17.mo4754r();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = r0.I_();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r15 = "Data loss, local db full";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0.m21307a(r15);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = 0;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r13 = r13 - r10;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r10 = 1;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r13 = r13 + r10;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = "messages";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r10 = "rowid in (select rowid from messages order by rowid asc limit ?)";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r11 = new java.lang.String[r8];	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r15 = java.lang.Long.toString(r13);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r11[r2] = r15;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = r9.delete(r0, r10, r11);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r10 = (long) r0;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        if (r0 == 0) goto L_0x00ab;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x008f:
        r0 = r17.mo4754r();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = r0.I_();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r15 = "Different delete count than expected in local db. expected, received, difference";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r4 = java.lang.Long.valueOf(r13);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r2 = java.lang.Long.valueOf(r10);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r16 = 0;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r13 = r13 - r10;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r10 = java.lang.Long.valueOf(r13);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r0.m21310a(r15, r4, r2, r10);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x00ab:
        r0 = "messages";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r9.insertOrThrow(r0, r7, r3);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r9.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        r9.endTransaction();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        if (r12 == 0) goto L_0x00bb;
    L_0x00b8:
        r12.close();
    L_0x00bb:
        if (r9 == 0) goto L_0x00c0;
    L_0x00bd:
        r9.close();
    L_0x00c0:
        return r8;
    L_0x00c1:
        r7 = r12;
        goto L_0x00f3;
    L_0x00c3:
        r0 = move-exception;
        r9 = r7;
        r12 = r9;
        goto L_0x0125;
    L_0x00c7:
        r0 = move-exception;
        r12 = r7;
    L_0x00c9:
        if (r7 == 0) goto L_0x00d8;
    L_0x00cb:
        r2 = r7.inTransaction();	 Catch:{ all -> 0x00d5 }
        if (r2 == 0) goto L_0x00d8;	 Catch:{ all -> 0x00d5 }
    L_0x00d1:
        r7.endTransaction();	 Catch:{ all -> 0x00d5 }
        goto L_0x00d8;	 Catch:{ all -> 0x00d5 }
    L_0x00d5:
        r0 = move-exception;	 Catch:{ all -> 0x00d5 }
        r9 = r7;	 Catch:{ all -> 0x00d5 }
        goto L_0x0125;	 Catch:{ all -> 0x00d5 }
    L_0x00d8:
        r2 = r17.mo4754r();	 Catch:{ all -> 0x00d5 }
        r2 = r2.I_();	 Catch:{ all -> 0x00d5 }
        r4 = "Error writing entry to local database";	 Catch:{ all -> 0x00d5 }
        r2.m21308a(r4, r0);	 Catch:{ all -> 0x00d5 }
        r1.f32798b = r8;	 Catch:{ all -> 0x00d5 }
        if (r12 == 0) goto L_0x00ec;
    L_0x00e9:
        r12.close();
    L_0x00ec:
        if (r7 == 0) goto L_0x011d;
    L_0x00ee:
        r7.close();
        goto L_0x011d;
    L_0x00f2:
        r9 = r7;
    L_0x00f3:
        r10 = (long) r6;
        android.os.SystemClock.sleep(r10);	 Catch:{ all -> 0x0123 }
        r6 = r6 + 20;
        if (r7 == 0) goto L_0x00fe;
    L_0x00fb:
        r7.close();
    L_0x00fe:
        if (r9 == 0) goto L_0x011d;
    L_0x0100:
        r9.close();
        goto L_0x011d;
    L_0x0104:
        r0 = move-exception;
        r9 = r7;
    L_0x0106:
        r2 = r17.mo4754r();	 Catch:{ all -> 0x0123 }
        r2 = r2.I_();	 Catch:{ all -> 0x0123 }
        r4 = "Error writing entry to local database";	 Catch:{ all -> 0x0123 }
        r2.m21308a(r4, r0);	 Catch:{ all -> 0x0123 }
        r1.f32798b = r8;	 Catch:{ all -> 0x0123 }
        if (r7 == 0) goto L_0x011a;
    L_0x0117:
        r7.close();
    L_0x011a:
        if (r9 == 0) goto L_0x011d;
    L_0x011c:
        goto L_0x0100;
    L_0x011d:
        r5 = r5 + 1;
        r2 = 0;
        r4 = 5;
        goto L_0x0026;
    L_0x0123:
        r0 = move-exception;
        r12 = r7;
    L_0x0125:
        if (r12 == 0) goto L_0x012a;
    L_0x0127:
        r12.close();
    L_0x012a:
        if (r9 == 0) goto L_0x012f;
    L_0x012c:
        r9.close();
    L_0x012f:
        throw r0;
    L_0x0130:
        r0 = r17.mo4754r();
        r0 = r0.m42565i();
        r2 = "Failed to write entry to local database";
        r0.m21307a(r2);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ax.a(int, byte[]):boolean");
    }

    /* renamed from: B */
    public final void m43987B() {
        mo6208b();
        mo6210d();
        try {
            int delete = m43985C().delete("messages", null, null) + 0;
            if (delete > 0) {
                mo4754r().m42579w().m21308a("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            mo4754r().I_().m21308a("Error resetting local analytics data. error", e);
        }
    }

    /* renamed from: a */
    public final java.util.List<com.google.android.gms.common.internal.p181a.C4363a> m43988a(int r19) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r18 = this;
        r1 = r18;
        r18.mo6210d();
        r18.mo6208b();
        r0 = r1.f32798b;
        r2 = 0;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return r2;
    L_0x000e:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = r18.mo4752n();
        r4 = "google_app_measurement_local.db";
        r0 = r0.getDatabasePath(r4);
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0024;
    L_0x0023:
        return r3;
    L_0x0024:
        r4 = 5;
        r5 = 0;
        r6 = 0;
        r7 = 5;
    L_0x0028:
        if (r6 >= r4) goto L_0x01e1;
    L_0x002a:
        r8 = 1;
        r15 = r18.m43985C();	 Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01a3, SQLiteException -> 0x017e, all -> 0x017a }
        if (r15 != 0) goto L_0x004b;
    L_0x0031:
        r1.f32798b = r8;	 Catch:{ SQLiteFullException -> 0x0046, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x003e, all -> 0x0039 }
        if (r15 == 0) goto L_0x0038;
    L_0x0035:
        r15.close();
    L_0x0038:
        return r2;
    L_0x0039:
        r0 = move-exception;
        r9 = r2;
        r4 = r15;
        goto L_0x01d6;
    L_0x003e:
        r0 = move-exception;
        r9 = r2;
        r4 = r15;
        goto L_0x0181;
    L_0x0043:
        r4 = r15;
        goto L_0x0174;
    L_0x0046:
        r0 = move-exception;
        r9 = r2;
        r4 = r15;
        goto L_0x01b9;
    L_0x004b:
        r15.beginTransaction();	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r10 = "messages";	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r0 = "rowid";	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r9 = "type";	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r11 = "entry";	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r11 = new java.lang.String[]{r0, r9, r11};	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r12 = 0;	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r13 = 0;	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r14 = 0;	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r0 = 0;	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r16 = "rowid asc";	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r9 = 100;	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r17 = java.lang.Integer.toString(r9);	 Catch:{ SQLiteFullException -> 0x0176, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0170, all -> 0x016b }
        r9 = r15;
        r4 = r15;
        r15 = r0;
        r9 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x0174, SQLiteException -> 0x0167, all -> 0x0165 }
        r10 = -1;
    L_0x006f:
        r0 = r9.moveToNext();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        if (r0 == 0) goto L_0x012c;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x0075:
        r10 = r9.getLong(r5);	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r9.getInt(r8);	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r12 = 2;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r13 = r9.getBlob(r12);	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        if (r0 != 0) goto L_0x00b7;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x0084:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r13.length;	 Catch:{ a -> 0x00a2 }
        r12.unmarshall(r13, r5, r0);	 Catch:{ a -> 0x00a2 }
        r12.setDataPosition(r5);	 Catch:{ a -> 0x00a2 }
        r0 = com.google.android.gms.internal.p213l.aq.CREATOR;	 Catch:{ a -> 0x00a2 }
        r0 = r0.createFromParcel(r12);	 Catch:{ a -> 0x00a2 }
        r0 = (com.google.android.gms.internal.p213l.aq) r0;	 Catch:{ a -> 0x00a2 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        if (r0 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x009c:
        r3.add(r0);	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        goto L_0x006f;
    L_0x00a0:
        r0 = move-exception;
        goto L_0x00b3;
    L_0x00a2:
        r0 = r18.mo4754r();	 Catch:{ all -> 0x00a0 }
        r0 = r0.I_();	 Catch:{ all -> 0x00a0 }
        r13 = "Failed to load event from local database";	 Catch:{ all -> 0x00a0 }
        r0.m21307a(r13);	 Catch:{ all -> 0x00a0 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x00b3:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        throw r0;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x00b7:
        if (r0 != r8) goto L_0x00ea;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x00b9:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r13.length;	 Catch:{ a -> 0x00d2 }
        r12.unmarshall(r13, r5, r0);	 Catch:{ a -> 0x00d2 }
        r12.setDataPosition(r5);	 Catch:{ a -> 0x00d2 }
        r0 = com.google.android.gms.internal.p213l.ft.CREATOR;	 Catch:{ a -> 0x00d2 }
        r0 = r0.createFromParcel(r12);	 Catch:{ a -> 0x00d2 }
        r0 = (com.google.android.gms.internal.p213l.ft) r0;	 Catch:{ a -> 0x00d2 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        goto L_0x00e3;
    L_0x00d0:
        r0 = move-exception;
        goto L_0x00e6;
    L_0x00d2:
        r0 = r18.mo4754r();	 Catch:{ all -> 0x00d0 }
        r0 = r0.I_();	 Catch:{ all -> 0x00d0 }
        r13 = "Failed to load user property from local database";	 Catch:{ all -> 0x00d0 }
        r0.m21307a(r13);	 Catch:{ all -> 0x00d0 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r2;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x00e3:
        if (r0 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x00e5:
        goto L_0x009c;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x00e6:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        throw r0;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x00ea:
        if (r0 != r12) goto L_0x011d;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x00ec:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r13.length;	 Catch:{ a -> 0x0105 }
        r12.unmarshall(r13, r5, r0);	 Catch:{ a -> 0x0105 }
        r12.setDataPosition(r5);	 Catch:{ a -> 0x0105 }
        r0 = com.google.android.gms.internal.p213l.C7827y.CREATOR;	 Catch:{ a -> 0x0105 }
        r0 = r0.createFromParcel(r12);	 Catch:{ a -> 0x0105 }
        r0 = (com.google.android.gms.internal.p213l.C7827y) r0;	 Catch:{ a -> 0x0105 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        goto L_0x0116;
    L_0x0103:
        r0 = move-exception;
        goto L_0x0119;
    L_0x0105:
        r0 = r18.mo4754r();	 Catch:{ all -> 0x0103 }
        r0 = r0.I_();	 Catch:{ all -> 0x0103 }
        r13 = "Failed to load user property from local database";	 Catch:{ all -> 0x0103 }
        r0.m21307a(r13);	 Catch:{ all -> 0x0103 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r2;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x0116:
        if (r0 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x0118:
        goto L_0x009c;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x0119:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        throw r0;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x011d:
        r0 = r18.mo4754r();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r0.I_();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r12 = "Unknown record type in local database";	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0.m21307a(r12);	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x012c:
        r0 = "messages";	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r12 = "rowid <= ?";	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r13 = new java.lang.String[r8];	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r10 = java.lang.Long.toString(r10);	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r13[r5] = r10;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r4.delete(r0, r12, r13);	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r10 = r3.size();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        if (r0 >= r10) goto L_0x014f;	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x0142:
        r0 = r18.mo4754r();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0 = r0.I_();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r10 = "Fewer entries removed from local database than expected";	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r0.m21307a(r10);	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
    L_0x014f:
        r4.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        r4.endTransaction();	 Catch:{ SQLiteFullException -> 0x0162, SQLiteDatabaseLockedException -> 0x01a5, SQLiteException -> 0x0160 }
        if (r9 == 0) goto L_0x015a;
    L_0x0157:
        r9.close();
    L_0x015a:
        if (r4 == 0) goto L_0x015f;
    L_0x015c:
        r4.close();
    L_0x015f:
        return r3;
    L_0x0160:
        r0 = move-exception;
        goto L_0x0181;
    L_0x0162:
        r0 = move-exception;
        goto L_0x01b9;
    L_0x0165:
        r0 = move-exception;
        goto L_0x016d;
    L_0x0167:
        r0 = move-exception;
        goto L_0x0172;
    L_0x0169:
        r0 = move-exception;
        goto L_0x0178;
    L_0x016b:
        r0 = move-exception;
        r4 = r15;
    L_0x016d:
        r9 = r2;
        goto L_0x01d6;
    L_0x0170:
        r0 = move-exception;
        r4 = r15;
    L_0x0172:
        r9 = r2;
        goto L_0x0181;
    L_0x0174:
        r9 = r2;
        goto L_0x01a5;
    L_0x0176:
        r0 = move-exception;
        r4 = r15;
    L_0x0178:
        r9 = r2;
        goto L_0x01b9;
    L_0x017a:
        r0 = move-exception;
        r4 = r2;
        r9 = r4;
        goto L_0x01d6;
    L_0x017e:
        r0 = move-exception;
        r4 = r2;
        r9 = r4;
    L_0x0181:
        if (r4 == 0) goto L_0x018c;
    L_0x0183:
        r10 = r4.inTransaction();	 Catch:{ all -> 0x01d5 }
        if (r10 == 0) goto L_0x018c;	 Catch:{ all -> 0x01d5 }
    L_0x0189:
        r4.endTransaction();	 Catch:{ all -> 0x01d5 }
    L_0x018c:
        r10 = r18.mo4754r();	 Catch:{ all -> 0x01d5 }
        r10 = r10.I_();	 Catch:{ all -> 0x01d5 }
        r11 = "Error reading entries from local database";	 Catch:{ all -> 0x01d5 }
        r10.m21308a(r11, r0);	 Catch:{ all -> 0x01d5 }
        r1.f32798b = r8;	 Catch:{ all -> 0x01d5 }
        if (r9 == 0) goto L_0x01a0;
    L_0x019d:
        r9.close();
    L_0x01a0:
        if (r4 == 0) goto L_0x01d0;
    L_0x01a2:
        goto L_0x01b2;
    L_0x01a3:
        r4 = r2;
        r9 = r4;
    L_0x01a5:
        r10 = (long) r7;
        android.os.SystemClock.sleep(r10);	 Catch:{ all -> 0x01d5 }
        r7 = r7 + 20;
        if (r9 == 0) goto L_0x01b0;
    L_0x01ad:
        r9.close();
    L_0x01b0:
        if (r4 == 0) goto L_0x01d0;
    L_0x01b2:
        r4.close();
        goto L_0x01d0;
    L_0x01b6:
        r0 = move-exception;
        r4 = r2;
        r9 = r4;
    L_0x01b9:
        r10 = r18.mo4754r();	 Catch:{ all -> 0x01d5 }
        r10 = r10.I_();	 Catch:{ all -> 0x01d5 }
        r11 = "Error reading entries from local database";	 Catch:{ all -> 0x01d5 }
        r10.m21308a(r11, r0);	 Catch:{ all -> 0x01d5 }
        r1.f32798b = r8;	 Catch:{ all -> 0x01d5 }
        if (r9 == 0) goto L_0x01cd;
    L_0x01ca:
        r9.close();
    L_0x01cd:
        if (r4 == 0) goto L_0x01d0;
    L_0x01cf:
        goto L_0x01b2;
    L_0x01d0:
        r6 = r6 + 1;
        r4 = 5;
        goto L_0x0028;
    L_0x01d5:
        r0 = move-exception;
    L_0x01d6:
        if (r9 == 0) goto L_0x01db;
    L_0x01d8:
        r9.close();
    L_0x01db:
        if (r4 == 0) goto L_0x01e0;
    L_0x01dd:
        r4.close();
    L_0x01e0:
        throw r0;
    L_0x01e1:
        r0 = r18.mo4754r();
        r0 = r0.m42565i();
        r3 = "Failed to read events from database in reasonable time";
        r0.m21307a(r3);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ax.a(int):java.util.List<com.google.android.gms.common.internal.a.a>");
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final boolean m43990a(aq aqVar) {
        Parcel obtain = Parcel.obtain();
        aqVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return m43986a(0, marshall);
        }
        mo4754r().m42565i().m21307a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    /* renamed from: a */
    public final boolean m43991a(ft ftVar) {
        Parcel obtain = Parcel.obtain();
        ftVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return m43986a(1, marshall);
        }
        mo4754r().m42565i().m21307a("User property too long for local database. Sending directly to service");
        return false;
    }

    /* renamed from: a */
    public final boolean m43992a(C7827y c7827y) {
        mo6213p();
        byte[] a = fw.m42645a((Parcelable) c7827y);
        if (a.length <= 131072) {
            return m43986a(2, a);
        }
        mo4754r().m42565i().m21307a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    public final /* bridge */ /* synthetic */ C8219n mo6741e() {
        return super.mo6741e();
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ df mo6742f() {
        return super.mo6742f();
    }

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ aw mo6743g() {
        return super.mo6743g();
    }

    /* renamed from: h */
    public final /* bridge */ /* synthetic */ ed mo6744h() {
        return super.mo6744h();
    }

    /* renamed from: i */
    public final /* bridge */ /* synthetic */ ea mo6745i() {
        return super.mo6745i();
    }

    /* renamed from: j */
    public final /* bridge */ /* synthetic */ ax mo6746j() {
        return super.mo6746j();
    }

    /* renamed from: k */
    public final /* bridge */ /* synthetic */ fc mo6747k() {
        return super.mo6747k();
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }

    /* renamed from: z */
    protected final boolean mo6852z() {
        return false;
    }
}
