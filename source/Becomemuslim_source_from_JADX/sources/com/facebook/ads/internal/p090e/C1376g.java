package com.facebook.ads.internal.p090e;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.facebook.ads.internal.e.g */
public abstract class C1376g {
    /* renamed from: k */
    protected final C1372d f4003k;

    protected C1376g(C1372d c1372d) {
        this.f4003k = c1372d;
    }

    /* renamed from: a */
    public static String m4702a(String str, C1369b[] c1369bArr) {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        for (int i = 0; i < c1369bArr.length - 1; i++) {
            stringBuilder.append(c1369bArr[i].f3972b);
            stringBuilder.append(", ");
        }
        stringBuilder.append(c1369bArr[c1369bArr.length - 1].f3972b);
        stringBuilder.append(" FROM ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m4703a(String str, C1369b[] c1369bArr, C1369b c1369b) {
        StringBuilder stringBuilder = new StringBuilder(C1376g.m4702a(str, c1369bArr));
        stringBuilder.append(" WHERE ");
        stringBuilder.append(c1369b.f3972b);
        stringBuilder.append(" = ?");
        return stringBuilder.toString();
    }

    /* renamed from: c */
    private String mo940c() {
        C1369b[] b = mo939b();
        if (b.length < 1) {
            return null;
        }
        String str = "";
        for (int i = 0; i < b.length - 1; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(b[i].m4678a());
            stringBuilder.append(", ");
            str = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(b[b.length - 1].m4678a());
        return stringBuilder2.toString();
    }

    /* renamed from: a */
    public abstract String mo938a();

    /* renamed from: a */
    public void m4706a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(mo938a());
        stringBuilder.append(" (");
        stringBuilder.append(mo940c());
        stringBuilder.append(")");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    /* renamed from: b */
    public void m4707b(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DROP TABLE IF EXISTS ");
        stringBuilder.append(mo938a());
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    /* renamed from: b */
    public abstract C1369b[] mo939b();

    /* renamed from: e */
    public void m4709e() {
    }

    /* renamed from: f */
    protected SQLiteDatabase m4710f() {
        return this.f4003k.m4686a();
    }
}
