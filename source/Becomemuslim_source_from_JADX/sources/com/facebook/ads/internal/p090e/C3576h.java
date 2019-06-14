package com.facebook.ads.internal.p090e;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.UUID;

/* renamed from: com.facebook.ads.internal.e.h */
public class C3576h extends C1376g {
    /* renamed from: a */
    public static final C1369b f9567a = new C1369b(0, "token_id", "TEXT PRIMARY KEY");
    /* renamed from: b */
    public static final C1369b f9568b = new C1369b(1, "token", "TEXT");
    /* renamed from: c */
    public static final C1369b[] f9569c = new C1369b[]{f9567a, f9568b};
    /* renamed from: d */
    private static final String f9570d = C3576h.class.getSimpleName();
    /* renamed from: e */
    private static final String f9571e = C1376g.m4702a("tokens", f9569c);
    /* renamed from: f */
    private static final String f9572f = C1376g.m4703a("tokens", f9569c, f9568b);
    /* renamed from: g */
    private static final String f9573g;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM tokens WHERE NOT EXISTS (SELECT 1 FROM events WHERE tokens.");
        stringBuilder.append(f9567a.f3972b);
        stringBuilder.append(" = ");
        stringBuilder.append("events");
        stringBuilder.append(".");
        stringBuilder.append(C3575c.f9557b.f3972b);
        stringBuilder.append(")");
        f9573g = stringBuilder.toString();
    }

    public C3576h(C1372d c1372d) {
        super(c1372d);
    }

    /* renamed from: a */
    public String mo938a() {
        return "tokens";
    }

    /* renamed from: a */
    String m11652a(String str) {
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid token.");
        }
        Cursor rawQuery;
        try {
            rawQuery = m4710f().rawQuery(f9572f, new String[]{str});
            try {
                Object string = rawQuery.moveToNext() ? rawQuery.getString(f9567a.f3971a) : null;
                if (TextUtils.isEmpty(string)) {
                    String uuid = UUID.randomUUID().toString();
                    ContentValues contentValues = new ContentValues(2);
                    contentValues.put(f9567a.f3972b, uuid);
                    contentValues.put(f9568b.f3972b, str);
                    m4710f().insertOrThrow("tokens", null, contentValues);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return uuid;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    public C1369b[] mo939b() {
        return f9569c;
    }

    /* renamed from: c */
    Cursor mo940c() {
        return m4710f().rawQuery(f9571e, null);
    }

    /* renamed from: d */
    public void m11655d() {
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
        r2 = this;
        r0 = r2.m4710f();	 Catch:{ SQLException -> 0x0009 }
        r1 = f9573g;	 Catch:{ SQLException -> 0x0009 }
        r0.execSQL(r1);	 Catch:{ SQLException -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.e.h.d():void");
    }
}
