package com.raizlabs.android.dbflow.p276d;

/* compiled from: QueryBuilder */
/* renamed from: com.raizlabs.android.dbflow.d.b */
public class C7135b<QueryClass extends C7135b> implements C5687a {
    /* renamed from: a */
    protected StringBuilder f25284a = new StringBuilder();

    /* renamed from: c */
    protected QueryClass m33190c() {
        return this;
    }

    public C7135b(Object obj) {
        m33189b(obj);
    }

    /* renamed from: b */
    public QueryClass m33188b() {
        return m33189b((Object) " ");
    }

    /* renamed from: a */
    public QueryClass m33183a(Object obj) {
        return m33188b().m33189b(obj).m33188b();
    }

    /* renamed from: b */
    public QueryClass m33189b(Object obj) {
        this.f25284a.append(obj);
        return m33190c();
    }

    /* renamed from: a */
    public QueryClass m33186a(Object... objArr) {
        return m33189b(C7135b.m33181a((CharSequence) ", ", objArr));
    }

    /* renamed from: a */
    public QueryClass m33185a(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            if (str != null) {
                m33189b((Object) str);
            }
            m33183a((Object) str2);
        }
        return m33190c();
    }

    /* renamed from: a */
    public QueryClass m33184a(String str) {
        if (str.equals("*")) {
            return m33189b((Object) str);
        }
        m33189b((Object) "`").m33189b(str.replace(".", "`.`")).m33189b((Object) "`");
        return m33190c();
    }

    public String toString() {
        return mo5061a();
    }

    /* renamed from: a */
    public String mo5061a() {
        return this.f25284a.toString();
    }

    /* renamed from: b */
    public static String m33182b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("`");
        stringBuilder.append(str.replace(".", "`.`"));
        stringBuilder.append("`");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m33181a(CharSequence charSequence, Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object obj2 : objArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(charSequence);
            }
            stringBuilder.append(obj2);
        }
        return stringBuilder.toString();
    }
}
