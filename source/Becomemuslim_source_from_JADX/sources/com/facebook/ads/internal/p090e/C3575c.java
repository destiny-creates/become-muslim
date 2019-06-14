package com.facebook.ads.internal.p090e;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.e.c */
public class C3575c extends C1376g {
    /* renamed from: a */
    public static final C1369b f9556a = new C1369b(0, "event_id", "TEXT PRIMARY KEY");
    /* renamed from: b */
    public static final C1369b f9557b = new C1369b(1, "token_id", "TEXT REFERENCES tokens ON UPDATE CASCADE ON DELETE RESTRICT");
    /* renamed from: c */
    public static final C1369b f9558c = new C1369b(2, "priority", "INTEGER");
    /* renamed from: d */
    public static final C1369b f9559d = new C1369b(3, "type", "TEXT");
    /* renamed from: e */
    public static final C1369b f9560e = new C1369b(4, "time", "REAL");
    /* renamed from: f */
    public static final C1369b f9561f = new C1369b(5, "session_time", "REAL");
    /* renamed from: g */
    public static final C1369b f9562g = new C1369b(6, "session_id", "TEXT");
    /* renamed from: h */
    public static final C1369b f9563h = new C1369b(7, "data", "TEXT");
    /* renamed from: i */
    public static final C1369b f9564i = new C1369b(8, "attempt", "INTEGER");
    /* renamed from: j */
    public static final C1369b[] f9565j = new C1369b[]{f9556a, f9557b, f9558c, f9559d, f9560e, f9561f, f9562g, f9563h, f9564i};
    /* renamed from: l */
    private static final String f9566l = C1376g.m4702a("events", f9565j);

    public C3575c(C1372d c1372d) {
        super(c1372d);
    }

    /* renamed from: a */
    public String mo938a() {
        return "events";
    }

    /* renamed from: a */
    String m11646a(String str, int i, String str2, double d, double d2, String str3, Map<String, String> map) {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(9);
        contentValues.put(f9556a.f3972b, uuid);
        contentValues.put(f9557b.f3972b, str);
        contentValues.put(f9558c.f3972b, Integer.valueOf(i));
        contentValues.put(f9559d.f3972b, str2);
        contentValues.put(f9560e.f3972b, Double.valueOf(d));
        contentValues.put(f9561f.f3972b, Double.valueOf(d2));
        contentValues.put(f9562g.f3972b, str3);
        contentValues.put(f9563h.f3972b, map != null ? new JSONObject(map).toString() : null);
        contentValues.put(f9564i.f3972b, Integer.valueOf(0));
        m4710f().insertOrThrow("events", null, contentValues);
        return uuid;
    }

    /* renamed from: a */
    boolean m11647a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f9556a.f3972b);
        stringBuilder.append(" = ?");
        return m4710f().delete("events", stringBuilder.toString(), new String[]{str}) > 0;
    }

    /* renamed from: b */
    public C1369b[] mo939b() {
        return f9565j;
    }

    /* renamed from: c */
    Cursor mo940c() {
        return m4710f().rawQuery("SELECT count(*) FROM events", null);
    }

    /* renamed from: d */
    Cursor m11650d() {
        return m4710f().rawQuery(f9566l, null);
    }
}
