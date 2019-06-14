package com.google.android.gms.p185e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.ads.AdError;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;
import com.google.android.gms.internal.p210i.cg;
import com.google.android.gms.internal.p210i.cj;
import com.google.android.gms.p185e.C2934c.C2931a;
import com.google.android.gms.p185e.C2934c.C2933c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.e.x */
final class C4404x implements C2933c {
    /* renamed from: a */
    private static final String f11753a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    /* renamed from: b */
    private final Executor f11754b;
    /* renamed from: c */
    private final Context f11755c;
    /* renamed from: d */
    private ab f11756d;
    /* renamed from: e */
    private C2895e f11757e;
    /* renamed from: f */
    private int f11758f;

    public C4404x(Context context) {
        Context context2 = context;
        this(context2, C4376h.m14397d(), "google_tagmanager.db", AdError.SERVER_ERROR_CODE, cg.a().a(cj.f16457a));
    }

    private C4404x(Context context, C2895e c2895e, String str, int i, Executor executor) {
        this.f11755c = context;
        this.f11757e = c2895e;
        this.f11758f = AdError.SERVER_ERROR_CODE;
        this.f11754b = executor;
        this.f11756d = new ab(this, this.f11755c, str);
    }

    /* renamed from: a */
    public final void mo2572a(List<C2931a> list, long j) {
        List arrayList = new ArrayList();
        for (C2931a c2931a : list) {
            arrayList.add(new ac(c2931a.f7484a, C4404x.m14626a(c2931a.f7485b)));
        }
        this.f11754b.execute(new C2946y(this, arrayList, j));
    }

    /* renamed from: a */
    public final void mo2570a(C2944u c2944u) {
        this.f11754b.execute(new C2947z(this, c2944u));
    }

    /* renamed from: a */
    public final void mo2571a(String str) {
        this.f11754b.execute(new aa(this, str));
    }

    /* renamed from: b */
    private final List<C2931a> m14628b() {
        try {
            m14623a(this.f11757e.mo2482a());
            List<ac> c = m14632c();
            List<C2931a> arrayList = new ArrayList();
            for (ac acVar : c) {
                arrayList.add(new C2931a(acVar.f7454a, C4404x.m14619a(acVar.f7455b)));
            }
            return arrayList;
        } finally {
            m14634e();
        }
    }

    /* renamed from: a */
    private static java.lang.Object m14619a(byte[] r4) {
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
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r4);
        r4 = 0;
        r1 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x001b }
        r1.<init>(r0);	 Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x001b }
        r2 = r1.readObject();	 Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x0026, all -> 0x0016 }
        r1.close();	 Catch:{ IOException -> 0x0015 }
        r0.close();	 Catch:{ IOException -> 0x0015 }
    L_0x0015:
        return r2;
    L_0x0016:
        r4 = move-exception;
        r3 = r1;
        r1 = r4;
        r4 = r3;
        goto L_0x001c;
    L_0x001b:
        r1 = move-exception;
    L_0x001c:
        if (r4 == 0) goto L_0x0021;
    L_0x001e:
        r4.close();	 Catch:{ IOException -> 0x0024 }
    L_0x0021:
        r0.close();	 Catch:{ IOException -> 0x0024 }
    L_0x0024:
        throw r1;
    L_0x0025:
        r1 = r4;
    L_0x0026:
        if (r1 == 0) goto L_0x002b;
    L_0x0028:
        r1.close();	 Catch:{ IOException -> 0x002e }
    L_0x002b:
        r0.close();	 Catch:{ IOException -> 0x002e }
    L_0x002e:
        return r4;
    L_0x002f:
        r1 = r4;
    L_0x0030:
        if (r1 == 0) goto L_0x0035;
    L_0x0032:
        r1.close();	 Catch:{ IOException -> 0x0038 }
    L_0x0035:
        r0.close();	 Catch:{ IOException -> 0x0038 }
    L_0x0038:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.x.a(byte[]):java.lang.Object");
    }

    /* renamed from: a */
    private static byte[] m14626a(java.lang.Object r3) {
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
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x0026, all -> 0x001c }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0026, all -> 0x001c }
        r2.writeObject(r3);	 Catch:{ IOException -> 0x0027, all -> 0x0019 }
        r3 = r0.toByteArray();	 Catch:{ IOException -> 0x0027, all -> 0x0019 }
        r2.close();	 Catch:{ IOException -> 0x0018 }
        r0.close();	 Catch:{ IOException -> 0x0018 }
    L_0x0018:
        return r3;
    L_0x0019:
        r3 = move-exception;
        r1 = r2;
        goto L_0x001d;
    L_0x001c:
        r3 = move-exception;
    L_0x001d:
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();	 Catch:{ IOException -> 0x0025 }
    L_0x0022:
        r0.close();	 Catch:{ IOException -> 0x0025 }
    L_0x0025:
        throw r3;
    L_0x0026:
        r2 = r1;
    L_0x0027:
        if (r2 == 0) goto L_0x002c;
    L_0x0029:
        r2.close();	 Catch:{ IOException -> 0x002f }
    L_0x002c:
        r0.close();	 Catch:{ IOException -> 0x002f }
    L_0x002f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.x.a(java.lang.Object):byte[]");
    }

    /* renamed from: b */
    private final synchronized void m14630b(java.util.List<com.google.android.gms.p185e.ac> r11, long r12) {
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
        monitor-enter(r10);
        r0 = r10.f11757e;	 Catch:{ all -> 0x00d4 }
        r0 = r0.mo2482a();	 Catch:{ all -> 0x00d4 }
        r10.m14623a(r0);	 Catch:{ all -> 0x00d4 }
        r2 = r11.size();	 Catch:{ all -> 0x00d4 }
        r3 = r10.m14633d();	 Catch:{ all -> 0x00d4 }
        r4 = r10.f11758f;	 Catch:{ all -> 0x00d4 }
        r3 = r3 - r4;	 Catch:{ all -> 0x00d4 }
        r3 = r3 + r2;	 Catch:{ all -> 0x00d4 }
        if (r3 <= 0) goto L_0x0092;	 Catch:{ all -> 0x00d4 }
    L_0x0018:
        r2 = r10.m14621a(r3);	 Catch:{ all -> 0x00d4 }
        r3 = r2.size();	 Catch:{ all -> 0x00d4 }
        r4 = 64;	 Catch:{ all -> 0x00d4 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d4 }
        r5.<init>(r4);	 Catch:{ all -> 0x00d4 }
        r4 = "DataLayer store full, deleting ";	 Catch:{ all -> 0x00d4 }
        r5.append(r4);	 Catch:{ all -> 0x00d4 }
        r5.append(r3);	 Catch:{ all -> 0x00d4 }
        r3 = " entries to make room.";	 Catch:{ all -> 0x00d4 }
        r5.append(r3);	 Catch:{ all -> 0x00d4 }
        r3 = r5.toString();	 Catch:{ all -> 0x00d4 }
        com.google.android.gms.p185e.bs.m8586c(r3);	 Catch:{ all -> 0x00d4 }
        r3 = 0;	 Catch:{ all -> 0x00d4 }
        r4 = new java.lang.String[r3];	 Catch:{ all -> 0x00d4 }
        r2 = r2.toArray(r4);	 Catch:{ all -> 0x00d4 }
        r2 = (java.lang.String[]) r2;	 Catch:{ all -> 0x00d4 }
        if (r2 == 0) goto L_0x0092;	 Catch:{ all -> 0x00d4 }
    L_0x0046:
        r4 = r2.length;	 Catch:{ all -> 0x00d4 }
        if (r4 != 0) goto L_0x004a;	 Catch:{ all -> 0x00d4 }
    L_0x0049:
        goto L_0x0092;	 Catch:{ all -> 0x00d4 }
    L_0x004a:
        r4 = "Error opening database for deleteEntries.";	 Catch:{ all -> 0x00d4 }
        r4 = r10.m14631c(r4);	 Catch:{ all -> 0x00d4 }
        if (r4 == 0) goto L_0x0092;	 Catch:{ all -> 0x00d4 }
    L_0x0052:
        r5 = "%s in (%s)";	 Catch:{ all -> 0x00d4 }
        r6 = 2;	 Catch:{ all -> 0x00d4 }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x00d4 }
        r7 = "ID";	 Catch:{ all -> 0x00d4 }
        r6[r3] = r7;	 Catch:{ all -> 0x00d4 }
        r3 = 1;	 Catch:{ all -> 0x00d4 }
        r7 = ",";	 Catch:{ all -> 0x00d4 }
        r8 = r2.length;	 Catch:{ all -> 0x00d4 }
        r9 = "?";	 Catch:{ all -> 0x00d4 }
        r8 = java.util.Collections.nCopies(r8, r9);	 Catch:{ all -> 0x00d4 }
        r7 = android.text.TextUtils.join(r7, r8);	 Catch:{ all -> 0x00d4 }
        r6[r3] = r7;	 Catch:{ all -> 0x00d4 }
        r3 = java.lang.String.format(r5, r6);	 Catch:{ all -> 0x00d4 }
        r5 = "datalayer";	 Catch:{ SQLiteException -> 0x0075 }
        r4.delete(r5, r3, r2);	 Catch:{ SQLiteException -> 0x0075 }
        goto L_0x0092;
    L_0x0075:
        r3 = "Error deleting entries ";	 Catch:{ all -> 0x00d4 }
        r2 = java.util.Arrays.toString(r2);	 Catch:{ all -> 0x00d4 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x00d4 }
        r4 = r2.length();	 Catch:{ all -> 0x00d4 }
        if (r4 == 0) goto L_0x008a;	 Catch:{ all -> 0x00d4 }
    L_0x0085:
        r2 = r3.concat(r2);	 Catch:{ all -> 0x00d4 }
        goto L_0x008f;	 Catch:{ all -> 0x00d4 }
    L_0x008a:
        r2 = new java.lang.String;	 Catch:{ all -> 0x00d4 }
        r2.<init>(r3);	 Catch:{ all -> 0x00d4 }
    L_0x008f:
        com.google.android.gms.p185e.bs.m8584b(r2);	 Catch:{ all -> 0x00d4 }
    L_0x0092:
        r2 = 0;	 Catch:{ all -> 0x00d4 }
        r0 = r0 + r12;	 Catch:{ all -> 0x00d4 }
        r12 = "Error opening database for writeEntryToDatabase.";	 Catch:{ all -> 0x00d4 }
        r12 = r10.m14631c(r12);	 Catch:{ all -> 0x00d4 }
        if (r12 == 0) goto L_0x00cf;	 Catch:{ all -> 0x00d4 }
    L_0x009c:
        r11 = r11.iterator();	 Catch:{ all -> 0x00d4 }
    L_0x00a0:
        r13 = r11.hasNext();	 Catch:{ all -> 0x00d4 }
        if (r13 == 0) goto L_0x00cf;	 Catch:{ all -> 0x00d4 }
    L_0x00a6:
        r13 = r11.next();	 Catch:{ all -> 0x00d4 }
        r13 = (com.google.android.gms.p185e.ac) r13;	 Catch:{ all -> 0x00d4 }
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x00d4 }
        r2.<init>();	 Catch:{ all -> 0x00d4 }
        r3 = "expires";	 Catch:{ all -> 0x00d4 }
        r4 = java.lang.Long.valueOf(r0);	 Catch:{ all -> 0x00d4 }
        r2.put(r3, r4);	 Catch:{ all -> 0x00d4 }
        r3 = "key";	 Catch:{ all -> 0x00d4 }
        r4 = r13.f7454a;	 Catch:{ all -> 0x00d4 }
        r2.put(r3, r4);	 Catch:{ all -> 0x00d4 }
        r3 = "value";	 Catch:{ all -> 0x00d4 }
        r13 = r13.f7455b;	 Catch:{ all -> 0x00d4 }
        r2.put(r3, r13);	 Catch:{ all -> 0x00d4 }
        r13 = "datalayer";	 Catch:{ all -> 0x00d4 }
        r3 = 0;	 Catch:{ all -> 0x00d4 }
        r12.insert(r13, r3, r2);	 Catch:{ all -> 0x00d4 }
        goto L_0x00a0;
    L_0x00cf:
        r10.m14634e();	 Catch:{ all -> 0x00d9 }
        monitor-exit(r10);
        return;
    L_0x00d4:
        r11 = move-exception;
        r10.m14634e();	 Catch:{ all -> 0x00d9 }
        throw r11;	 Catch:{ all -> 0x00d9 }
    L_0x00d9:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.x.b(java.util.List, long):void");
    }

    /* renamed from: c */
    private final List<ac> m14632c() {
        SQLiteDatabase c = m14631c("Error opening database for loadSerialized.");
        List<ac> arrayList = new ArrayList();
        if (c == null) {
            return arrayList;
        }
        Cursor query = c.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new ac(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private final void m14629b(String str) {
        StringBuilder stringBuilder;
        SQLiteDatabase c = m14631c("Error opening database for clearKeysWithPrefix.");
        if (c != null) {
            try {
                int delete = c.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")});
                stringBuilder = new StringBuilder(25);
                stringBuilder.append("Cleared ");
                stringBuilder.append(delete);
                stringBuilder.append(" items");
                bs.m8588e(stringBuilder.toString());
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                stringBuilder = new StringBuilder((String.valueOf(str).length() + 44) + String.valueOf(valueOf).length());
                stringBuilder.append("Error deleting entries with key prefix: ");
                stringBuilder.append(str);
                stringBuilder.append(" (");
                stringBuilder.append(valueOf);
                stringBuilder.append(").");
                bs.m8584b(stringBuilder.toString());
            } finally {
                m14634e();
            }
        }
    }

    /* renamed from: a */
    private final void m14623a(long r6) {
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
        r0 = "Error opening database for deleteOlderThan.";
        r0 = r5.m14631c(r0);
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = "datalayer";	 Catch:{ SQLiteException -> 0x0037 }
        r2 = "expires <= ?";	 Catch:{ SQLiteException -> 0x0037 }
        r3 = 1;	 Catch:{ SQLiteException -> 0x0037 }
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0037 }
        r4 = 0;	 Catch:{ SQLiteException -> 0x0037 }
        r6 = java.lang.Long.toString(r6);	 Catch:{ SQLiteException -> 0x0037 }
        r3[r4] = r6;	 Catch:{ SQLiteException -> 0x0037 }
        r6 = r0.delete(r1, r2, r3);	 Catch:{ SQLiteException -> 0x0037 }
        r7 = 33;	 Catch:{ SQLiteException -> 0x0037 }
        r0 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0037 }
        r0.<init>(r7);	 Catch:{ SQLiteException -> 0x0037 }
        r7 = "Deleted ";	 Catch:{ SQLiteException -> 0x0037 }
        r0.append(r7);	 Catch:{ SQLiteException -> 0x0037 }
        r0.append(r6);	 Catch:{ SQLiteException -> 0x0037 }
        r6 = " expired items";	 Catch:{ SQLiteException -> 0x0037 }
        r0.append(r6);	 Catch:{ SQLiteException -> 0x0037 }
        r6 = r0.toString();	 Catch:{ SQLiteException -> 0x0037 }
        com.google.android.gms.p185e.bs.m8588e(r6);	 Catch:{ SQLiteException -> 0x0037 }
        return;
    L_0x0037:
        r6 = "Error deleting old entries.";
        com.google.android.gms.p185e.bs.m8584b(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.x.a(long):void");
    }

    /* renamed from: a */
    private final List<String> m14621a(int i) {
        String str;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bs.m8584b("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase c = m14631c("Error opening database for peekEntryIds.");
        if (c == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            i = c.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
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
                    str = "Error in peekEntries fetching entryIds: ";
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
            str = "Error in peekEntries fetching entryIds: ";
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

    /* renamed from: d */
    private final int m14633d() {
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
        r0 = "Error opening database for getNumStoredEntries.";
        r0 = r4.m14631c(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r2 = 0;
        r3 = "SELECT COUNT(*) from datalayer";	 Catch:{ SQLiteException -> 0x0029 }
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
        r0 = "Error getting numStoredEntries";	 Catch:{ all -> 0x0027 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.x.d():int");
    }

    /* renamed from: c */
    private final android.database.sqlite.SQLiteDatabase m14631c(java.lang.String r2) {
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
        r0 = r1.f11756d;	 Catch:{ SQLiteException -> 0x0007 }
        r0 = r0.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0007 }
        return r0;
    L_0x0007:
        com.google.android.gms.p185e.bs.m8584b(r2);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.x.c(java.lang.String):android.database.sqlite.SQLiteDatabase");
    }

    /* renamed from: e */
    private final void m14634e() {
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
        r0 = r1.f11756d;	 Catch:{ SQLiteException -> 0x0006 }
        r0.close();	 Catch:{ SQLiteException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.x.e():void");
    }
}
