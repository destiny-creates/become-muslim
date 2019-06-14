package com.google.android.gms.p185e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.ads.AdError;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.e.cm */
final class cm implements bc {
    /* renamed from: a */
    private static final String f11654a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    /* renamed from: b */
    private final co f11655b;
    /* renamed from: c */
    private volatile aj f11656c;
    /* renamed from: d */
    private final bd f11657d;
    /* renamed from: e */
    private final Context f11658e;
    /* renamed from: f */
    private final String f11659f;
    /* renamed from: g */
    private long f11660g;
    /* renamed from: h */
    private C2895e f11661h;
    /* renamed from: i */
    private final int f11662i;

    cm(bd bdVar, Context context) {
        this(bdVar, context, "gtm_urls.db", AdError.SERVER_ERROR_CODE);
    }

    private cm(bd bdVar, Context context, String str, int i) {
        this.f11658e = context.getApplicationContext();
        this.f11659f = str;
        this.f11657d = bdVar;
        this.f11661h = C4376h.m14397d();
        this.f11655b = new co(this, this.f11658e, this.f11659f);
        this.f11656c = new ef(this.f11658e, new cn(this));
        this.f11660g = null;
        this.f11662i = AdError.SERVER_ERROR_CODE;
    }

    /* renamed from: a */
    public final void mo2541a(long r9, java.lang.String r11) {
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
        r8 = this;
        r0 = r8.f11661h;
        r0 = r0.mo2482a();
        r2 = r8.f11660g;
        r4 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r2 = r2 + r4;
        r4 = 1;
        r5 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0047;
    L_0x0013:
        r8.f11660g = r0;
        r0 = "Error opening database for deleteStaleHits.";
        r0 = r8.m14497a(r0);
        if (r0 != 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0047;
    L_0x001e:
        r1 = r8.f11661h;
        r1 = r1.mo2482a();
        r6 = 2592000000; // 0x9a7ec800 float:-5.2687528E-23 double:1.280618154E-314;
        r1 = r1 - r6;
        r3 = "gtm_hits";
        r6 = "HIT_TIME < ?";
        r7 = new java.lang.String[r4];
        r1 = java.lang.Long.toString(r1);
        r7[r5] = r1;
        r0.delete(r3, r6, r7);
        r0 = r8.f11657d;
        r1 = r8.m14508c();
        if (r1 != 0) goto L_0x0043;
    L_0x0041:
        r1 = 1;
        goto L_0x0044;
    L_0x0043:
        r1 = 0;
    L_0x0044:
        r0.mo2552a(r1);
    L_0x0047:
        r0 = r8.m14508c();
        r1 = r8.f11662i;
        r0 = r0 - r1;
        r0 = r0 + r4;
        if (r0 <= 0) goto L_0x007f;
    L_0x0051:
        r0 = r8.m14499a(r0);
        r1 = r0.size();
        r2 = 51;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Store full, deleting ";
        r3.append(r2);
        r3.append(r1);
        r1 = " hits to make room.";
        r3.append(r1);
        r1 = r3.toString();
        com.google.android.gms.p185e.bs.m8588e(r1);
        r1 = new java.lang.String[r5];
        r0 = r0.toArray(r1);
        r0 = (java.lang.String[]) r0;
        r8.m14504a(r0);
    L_0x007f:
        r0 = "Error opening database for putHit";
        r0 = r8.m14497a(r0);
        if (r0 == 0) goto L_0x00b4;
    L_0x0087:
        r1 = new android.content.ContentValues;
        r1.<init>();
        r2 = "hit_time";
        r9 = java.lang.Long.valueOf(r9);
        r1.put(r2, r9);
        r9 = "hit_url";
        r1.put(r9, r11);
        r9 = "hit_first_send_time";
        r10 = java.lang.Integer.valueOf(r5);
        r1.put(r9, r10);
        r9 = "gtm_hits";	 Catch:{ SQLiteException -> 0x00af }
        r10 = 0;	 Catch:{ SQLiteException -> 0x00af }
        r0.insert(r9, r10, r1);	 Catch:{ SQLiteException -> 0x00af }
        r9 = r8.f11657d;	 Catch:{ SQLiteException -> 0x00af }
        r9.mo2552a(r5);	 Catch:{ SQLiteException -> 0x00af }
        return;
    L_0x00af:
        r9 = "Error storing hit";
        com.google.android.gms.p185e.bs.m8584b(r9);
    L_0x00b4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.cm.a(long, java.lang.String):void");
    }

    /* renamed from: a */
    private final List<String> m14499a(int i) {
        String str;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bs.m8584b("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase a = m14497a("Error opening database for peekHitIds.");
        if (a == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            i = a.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (i.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(i.getLong(0)));
                    } while (i.moveToNext());
                }
                if (i != 0) {
                    i.close();
                }
            } catch (SQLiteException e) {
                SQLiteException sQLiteException = e;
                cursor = i;
                i = sQLiteException;
                try {
                    str = "Error in peekHits fetching hitIds: ";
                    i = String.valueOf(i.getMessage());
                    bs.m8584b(i.length() == 0 ? str.concat(i) : new String(str));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = i;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            i = e2;
            str = "Error in peekHits fetching hitIds: ";
            i = String.valueOf(i.getMessage());
            if (i.length() == 0) {
            }
            bs.m8584b(i.length() == 0 ? str.concat(i) : new String(str));
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final java.util.List<com.google.android.gms.p185e.aw> m14507b(int r17) {
        /*
        r16 = this;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0 = "Error opening database for peekHits";
        r2 = r16;
        r0 = r2.m14497a(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r12 = 0;
        r4 = "gtm_hits";
        r3 = "hit_id";
        r5 = "hit_time";
        r6 = "hit_first_send_time";
        r5 = new java.lang.String[]{r3, r5, r6};	 Catch:{ SQLiteException -> 0x014c }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r3 = "%s ASC";
        r13 = 1;
        r10 = new java.lang.Object[r13];	 Catch:{ SQLiteException -> 0x014c }
        r11 = "hit_id";
        r14 = 0;
        r10[r14] = r11;	 Catch:{ SQLiteException -> 0x014c }
        r10 = java.lang.String.format(r3, r10);	 Catch:{ SQLiteException -> 0x014c }
        r15 = 40;
        r11 = java.lang.Integer.toString(r15);	 Catch:{ SQLiteException -> 0x014c }
        r3 = r0;
        r11 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ SQLiteException -> 0x014c }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0146, all -> 0x0142 }
        r12.<init>();	 Catch:{ SQLiteException -> 0x0146, all -> 0x0142 }
        r1 = r11.moveToFirst();	 Catch:{ SQLiteException -> 0x013e, all -> 0x0142 }
        if (r1 == 0) goto L_0x006b;
    L_0x0045:
        r1 = new com.google.android.gms.e.aw;	 Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
        r4 = r11.getLong(r14);	 Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
        r6 = r11.getLong(r13);	 Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
        r3 = 2;
        r8 = r11.getLong(r3);	 Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
        r3 = r1;
        r3.<init>(r4, r6, r8);	 Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
        r12.add(r1);	 Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
        r1 = r11.moveToNext();	 Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
        if (r1 != 0) goto L_0x0045;
    L_0x0061:
        goto L_0x006b;
    L_0x0062:
        r0 = move-exception;
        r12 = r11;
        goto L_0x0170;
    L_0x0066:
        r0 = move-exception;
        r1 = r12;
        r12 = r11;
        goto L_0x014d;
    L_0x006b:
        if (r11 == 0) goto L_0x0070;
    L_0x006d:
        r11.close();
    L_0x0070:
        r4 = "gtm_hits";
        r1 = "hit_id";
        r3 = "hit_url";
        r5 = new java.lang.String[]{r1, r3};	 Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r1 = "%s ASC";
        r3 = new java.lang.Object[r13];	 Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
        r10 = "hit_id";
        r3[r14] = r10;	 Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
        r10 = java.lang.String.format(r1, r3);	 Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
        r1 = java.lang.Integer.toString(r15);	 Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
        r3 = r0;
        r15 = r11;
        r11 = r1;
        r11 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
        r0 = r11.moveToFirst();	 Catch:{ SQLiteException -> 0x00e0 }
        if (r0 == 0) goto L_0x00da;
    L_0x009b:
        r0 = 0;
    L_0x009c:
        r1 = r11;
        r1 = (android.database.sqlite.SQLiteCursor) r1;	 Catch:{ SQLiteException -> 0x00e0 }
        r1 = r1.getWindow();	 Catch:{ SQLiteException -> 0x00e0 }
        r1 = r1.getNumRows();	 Catch:{ SQLiteException -> 0x00e0 }
        if (r1 <= 0) goto L_0x00b7;
    L_0x00a9:
        r1 = r12.get(r0);	 Catch:{ SQLiteException -> 0x00e0 }
        r1 = (com.google.android.gms.p185e.aw) r1;	 Catch:{ SQLiteException -> 0x00e0 }
        r3 = r11.getString(r13);	 Catch:{ SQLiteException -> 0x00e0 }
        r1.m8561a(r3);	 Catch:{ SQLiteException -> 0x00e0 }
        goto L_0x00d2;
    L_0x00b7:
        r1 = "HitString for hitId %d too large.  Hit will be deleted.";
        r3 = new java.lang.Object[r13];	 Catch:{ SQLiteException -> 0x00e0 }
        r4 = r12.get(r0);	 Catch:{ SQLiteException -> 0x00e0 }
        r4 = (com.google.android.gms.p185e.aw) r4;	 Catch:{ SQLiteException -> 0x00e0 }
        r4 = r4.m8560a();	 Catch:{ SQLiteException -> 0x00e0 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x00e0 }
        r3[r14] = r4;	 Catch:{ SQLiteException -> 0x00e0 }
        r1 = java.lang.String.format(r1, r3);	 Catch:{ SQLiteException -> 0x00e0 }
        com.google.android.gms.p185e.bs.m8584b(r1);	 Catch:{ SQLiteException -> 0x00e0 }
    L_0x00d2:
        r0 = r0 + 1;
        r1 = r11.moveToNext();	 Catch:{ SQLiteException -> 0x00e0 }
        if (r1 != 0) goto L_0x009c;
    L_0x00da:
        if (r11 == 0) goto L_0x00df;
    L_0x00dc:
        r11.close();
    L_0x00df:
        return r12;
    L_0x00e0:
        r0 = move-exception;
        goto L_0x00ed;
    L_0x00e2:
        r0 = move-exception;
        r11 = r15;
        goto L_0x0138;
    L_0x00e5:
        r0 = move-exception;
        r11 = r15;
        goto L_0x00ed;
    L_0x00e8:
        r0 = move-exception;
        r15 = r11;
        goto L_0x0138;
    L_0x00eb:
        r0 = move-exception;
        r15 = r11;
    L_0x00ed:
        r1 = "Error in peekHits fetching hit url: ";
        r0 = r0.getMessage();	 Catch:{ all -> 0x0137 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0137 }
        r3 = r0.length();	 Catch:{ all -> 0x0137 }
        if (r3 == 0) goto L_0x0102;
    L_0x00fd:
        r0 = r1.concat(r0);	 Catch:{ all -> 0x0137 }
        goto L_0x0107;
    L_0x0102:
        r0 = new java.lang.String;	 Catch:{ all -> 0x0137 }
        r0.<init>(r1);	 Catch:{ all -> 0x0137 }
    L_0x0107:
        com.google.android.gms.p185e.bs.m8584b(r0);	 Catch:{ all -> 0x0137 }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0137 }
        r0.<init>();	 Catch:{ all -> 0x0137 }
        r12 = (java.util.ArrayList) r12;	 Catch:{ all -> 0x0137 }
        r1 = r12.size();	 Catch:{ all -> 0x0137 }
        r3 = 0;
    L_0x0116:
        if (r14 >= r1) goto L_0x0131;
    L_0x0118:
        r4 = r12.get(r14);	 Catch:{ all -> 0x0137 }
        r14 = r14 + 1;
        r4 = (com.google.android.gms.p185e.aw) r4;	 Catch:{ all -> 0x0137 }
        r5 = r4.m8563c();	 Catch:{ all -> 0x0137 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0137 }
        if (r5 == 0) goto L_0x012d;
    L_0x012a:
        if (r3 != 0) goto L_0x0131;
    L_0x012c:
        r3 = 1;
    L_0x012d:
        r0.add(r4);	 Catch:{ all -> 0x0137 }
        goto L_0x0116;
    L_0x0131:
        if (r11 == 0) goto L_0x0136;
    L_0x0133:
        r11.close();
    L_0x0136:
        return r0;
    L_0x0137:
        r0 = move-exception;
    L_0x0138:
        if (r11 == 0) goto L_0x013d;
    L_0x013a:
        r11.close();
    L_0x013d:
        throw r0;
    L_0x013e:
        r0 = move-exception;
        r15 = r11;
        r1 = r12;
        goto L_0x0148;
    L_0x0142:
        r0 = move-exception;
        r15 = r11;
        r12 = r15;
        goto L_0x0170;
    L_0x0146:
        r0 = move-exception;
        r15 = r11;
    L_0x0148:
        r12 = r15;
        goto L_0x014d;
    L_0x014a:
        r0 = move-exception;
        goto L_0x0170;
    L_0x014c:
        r0 = move-exception;
    L_0x014d:
        r3 = "Error in peekHits fetching hitIds: ";
        r0 = r0.getMessage();	 Catch:{ all -> 0x014a }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x014a }
        r4 = r0.length();	 Catch:{ all -> 0x014a }
        if (r4 == 0) goto L_0x0162;
    L_0x015d:
        r0 = r3.concat(r0);	 Catch:{ all -> 0x014a }
        goto L_0x0167;
    L_0x0162:
        r0 = new java.lang.String;	 Catch:{ all -> 0x014a }
        r0.<init>(r3);	 Catch:{ all -> 0x014a }
    L_0x0167:
        com.google.android.gms.p185e.bs.m8584b(r0);	 Catch:{ all -> 0x014a }
        if (r12 == 0) goto L_0x016f;
    L_0x016c:
        r12.close();
    L_0x016f:
        return r1;
    L_0x0170:
        if (r12 == 0) goto L_0x0175;
    L_0x0172:
        r12.close();
    L_0x0175:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.cm.b(int):java.util.List<com.google.android.gms.e.aw>");
    }

    /* renamed from: a */
    private final void m14504a(java.lang.String[] r8) {
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
        r7 = this;
        if (r8 == 0) goto L_0x0041;
    L_0x0002:
        r0 = r8.length;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        goto L_0x0041;
    L_0x0006:
        r0 = "Error opening database for deleteHits.";
        r0 = r7.m14497a(r0);
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r1 = "HIT_ID in (%s)";
        r2 = 1;
        r3 = new java.lang.Object[r2];
        r4 = ",";
        r5 = r8.length;
        r6 = "?";
        r5 = java.util.Collections.nCopies(r5, r6);
        r4 = android.text.TextUtils.join(r4, r5);
        r5 = 0;
        r3[r5] = r4;
        r1 = java.lang.String.format(r1, r3);
        r3 = "gtm_hits";	 Catch:{ SQLiteException -> 0x003b }
        r0.delete(r3, r1, r8);	 Catch:{ SQLiteException -> 0x003b }
        r8 = r7.f11657d;	 Catch:{ SQLiteException -> 0x003b }
        r0 = r7.m14508c();	 Catch:{ SQLiteException -> 0x003b }
        if (r0 != 0) goto L_0x0036;	 Catch:{ SQLiteException -> 0x003b }
    L_0x0035:
        goto L_0x0037;	 Catch:{ SQLiteException -> 0x003b }
    L_0x0036:
        r2 = 0;	 Catch:{ SQLiteException -> 0x003b }
    L_0x0037:
        r8.mo2552a(r2);	 Catch:{ SQLiteException -> 0x003b }
        return;
    L_0x003b:
        r8 = "Error deleting hits";
        com.google.android.gms.p185e.bs.m8584b(r8);
        return;
    L_0x0041:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.cm.a(java.lang.String[]):void");
    }

    /* renamed from: a */
    private final void m14500a(long j) {
        m14504a(new String[]{String.valueOf(j)});
    }

    /* renamed from: a */
    private final void m14501a(long r6, long r8) {
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
        r5 = this;
        r0 = "Error opening database for getNumStoredHits.";
        r0 = r5.m14497a(r0);
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = new android.content.ContentValues;
        r1.<init>();
        r2 = "hit_first_send_time";
        r8 = java.lang.Long.valueOf(r8);
        r1.put(r2, r8);
        r8 = "gtm_hits";	 Catch:{ SQLiteException -> 0x0029 }
        r9 = "hit_id=?";	 Catch:{ SQLiteException -> 0x0029 }
        r2 = 1;	 Catch:{ SQLiteException -> 0x0029 }
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x0029 }
        r3 = 0;	 Catch:{ SQLiteException -> 0x0029 }
        r4 = java.lang.String.valueOf(r6);	 Catch:{ SQLiteException -> 0x0029 }
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0029 }
        r0.update(r8, r1, r9, r2);	 Catch:{ SQLiteException -> 0x0029 }
        return;
    L_0x0029:
        r8 = 69;
        r9 = new java.lang.StringBuilder;
        r9.<init>(r8);
        r8 = "Error setting HIT_FIRST_DISPATCH_TIME for hitId: ";
        r9.append(r8);
        r9.append(r6);
        r8 = r9.toString();
        com.google.android.gms.p185e.bs.m8584b(r8);
        r5.m14500a(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.cm.a(long, long):void");
    }

    /* renamed from: c */
    private final int m14508c() {
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
        r4 = this;
        r0 = "Error opening database for getNumStoredHits.";
        r0 = r4.m14497a(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r2 = 0;
        r3 = "SELECT COUNT(*) from gtm_hits";	 Catch:{ SQLiteException -> 0x0029 }
        r0 = r0.rawQuery(r3, r2);	 Catch:{ SQLiteException -> 0x0029 }
        r2 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
        if (r2 == 0) goto L_0x001c;	 Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
    L_0x0017:
        r2 = r0.getLong(r1);	 Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
        r1 = (int) r2;
    L_0x001c:
        if (r0 == 0) goto L_0x0033;
    L_0x001e:
        r0.close();
        goto L_0x0033;
    L_0x0022:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0034;
    L_0x0025:
        r2 = r0;
        goto L_0x0029;
    L_0x0027:
        r1 = move-exception;
        goto L_0x0034;
    L_0x0029:
        r0 = "Error getting numStoredHits";	 Catch:{ all -> 0x0027 }
        com.google.android.gms.p185e.bs.m8584b(r0);	 Catch:{ all -> 0x0027 }
        if (r2 == 0) goto L_0x0033;
    L_0x0030:
        r2.close();
    L_0x0033:
        return r1;
    L_0x0034:
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.close();
    L_0x0039:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.cm.c():int");
    }

    /* renamed from: d */
    private final int m14510d() {
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
        r10 = this;
        r0 = "Error opening database for getNumStoredHits.";
        r1 = r10.m14497a(r0);
        r0 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r9 = 0;
        r2 = "gtm_hits";	 Catch:{ SQLiteException -> 0x0031 }
        r3 = "hit_id";	 Catch:{ SQLiteException -> 0x0031 }
        r4 = "hit_first_send_time";	 Catch:{ SQLiteException -> 0x0031 }
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0031 }
        r4 = "hit_first_send_time=0";	 Catch:{ SQLiteException -> 0x0031 }
        r5 = 0;	 Catch:{ SQLiteException -> 0x0031 }
        r6 = 0;	 Catch:{ SQLiteException -> 0x0031 }
        r7 = 0;	 Catch:{ SQLiteException -> 0x0031 }
        r8 = 0;	 Catch:{ SQLiteException -> 0x0031 }
        r1 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0031 }
        r2 = r1.getCount();	 Catch:{ SQLiteException -> 0x002d, all -> 0x002a }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r1.close();
    L_0x0028:
        r0 = r2;
        goto L_0x003b;
    L_0x002a:
        r0 = move-exception;
        r9 = r1;
        goto L_0x003c;
    L_0x002d:
        r9 = r1;
        goto L_0x0031;
    L_0x002f:
        r0 = move-exception;
        goto L_0x003c;
    L_0x0031:
        r1 = "Error getting num untried hits";	 Catch:{ all -> 0x002f }
        com.google.android.gms.p185e.bs.m8584b(r1);	 Catch:{ all -> 0x002f }
        if (r9 == 0) goto L_0x003b;
    L_0x0038:
        r9.close();
    L_0x003b:
        return r0;
    L_0x003c:
        if (r9 == 0) goto L_0x0041;
    L_0x003e:
        r9.close();
    L_0x0041:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.cm.d():int");
    }

    /* renamed from: a */
    public final void mo2540a() {
        bs.m8588e("GTM Dispatch running...");
        if (this.f11656c.mo2557a()) {
            List b = m14507b(40);
            if (b.isEmpty()) {
                bs.m8588e("...nothing to dispatch");
                this.f11657d.mo2552a(true);
                return;
            }
            this.f11656c.mo2556a(b);
            if (m14510d() > 0) {
                dy.m14545c().mo2549a();
            }
        }
    }

    /* renamed from: a */
    private final android.database.sqlite.SQLiteDatabase m14497a(java.lang.String r2) {
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
        r1 = this;
        r0 = r1.f11655b;	 Catch:{ SQLiteException -> 0x0007 }
        r0 = r0.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0007 }
        return r0;
    L_0x0007:
        com.google.android.gms.p185e.bs.m8584b(r2);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.cm.a(java.lang.String):android.database.sqlite.SQLiteDatabase");
    }
}
