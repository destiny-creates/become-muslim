package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.cs;
import com.google.android.gms.internal.p210i.ct;
import com.google.android.gms.internal.p210i.cx;
import com.google.android.gms.internal.p210i.db;
import com.google.android.gms.p185e.cr.C2935a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.e.a */
public class C2929a {
    /* renamed from: a */
    private final Context f7443a;
    /* renamed from: b */
    private final String f7444b;
    /* renamed from: c */
    private final C2934c f7445c;
    /* renamed from: d */
    private dm f7446d;
    /* renamed from: e */
    private Map<String, C2927a> f7447e = new HashMap();
    /* renamed from: f */
    private Map<String, C2928b> f7448f = new HashMap();
    /* renamed from: g */
    private volatile long f7449g;
    /* renamed from: h */
    private volatile String f7450h = "";

    /* renamed from: com.google.android.gms.e.a$a */
    public interface C2927a {
        /* renamed from: a */
        Object m8528a(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.e.a$b */
    public interface C2928b {
        /* renamed from: a */
        void m8529a(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.e.a$c */
    class C4389c implements C2943r {
        /* renamed from: a */
        private final /* synthetic */ C2929a f11600a;

        private C4389c(C2929a c2929a) {
            this.f11600a = c2929a;
        }

        /* renamed from: a */
        public final Object mo2495a(String str, Map<String, Object> map) {
            C2927a d = this.f11600a.m8540d(str);
            if (d == null) {
                return null;
            }
            return d.m8528a(str, map);
        }
    }

    /* renamed from: com.google.android.gms.e.a$d */
    class C4390d implements C2943r {
        /* renamed from: a */
        private final /* synthetic */ C2929a f11601a;

        private C4390d(C2929a c2929a) {
            this.f11601a = c2929a;
        }

        /* renamed from: a */
        public final Object mo2495a(String str, Map<String, Object> map) {
            C2928b e = this.f11601a.m8542e(str);
            if (e != null) {
                e.m8529a(str, map);
            }
            return eu.m8735f();
        }
    }

    C2929a(Context context, C2934c c2934c, String str, long j, db dbVar) {
        this.f7443a = context;
        this.f7445c = c2934c;
        this.f7444b = str;
        this.f7449g = null;
        m8531a(dbVar);
    }

    C2929a(Context context, C2934c c2934c, String str, long j, cs csVar) {
        this.f7443a = context;
        this.f7445c = c2934c;
        this.f7444b = str;
        this.f7449g = j;
        context = csVar.f28854b;
        if (context != null) {
            try {
                m8531a(cx.a(context));
            } catch (C2934c c2934c2) {
                context = String.valueOf(context);
                c2934c2 = c2934c2.toString();
                j = new StringBuilder((String.valueOf(context).length() + 46) + String.valueOf(c2934c2).length());
                j.append("Not loading resource: ");
                j.append(context);
                j.append(" because it is invalid: ");
                j.append(c2934c2);
                bs.m8582a(j.toString());
            }
            if (csVar.f28853a != null) {
                context = csVar.f28853a;
                List arrayList = new ArrayList();
                for (Object add : context) {
                    arrayList.add(add);
                }
                m8532f().m8669a(arrayList);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public String m8533a() {
        return this.f7444b;
    }

    /* renamed from: a */
    public boolean m8535a(String str) {
        dm f = m8532f();
        if (f == null) {
            bs.m8582a("getBoolean called for closed container.");
            return eu.m8728d().booleanValue();
        }
        try {
            return eu.m8731e((ct) f.m8670b(str).m8619a()).booleanValue();
        } catch (String str2) {
            str2 = str2.getMessage();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 66);
            stringBuilder.append("Calling getBoolean() threw an exception: ");
            stringBuilder.append(str2);
            stringBuilder.append(" Returning default value.");
            bs.m8582a(stringBuilder.toString());
            return eu.m8728d().booleanValue();
        }
    }

    /* renamed from: b */
    public double m8536b(String str) {
        dm f = m8532f();
        if (f == null) {
            bs.m8582a("getDouble called for closed container.");
            return eu.m8724c().doubleValue();
        }
        try {
            return eu.m8729d((ct) f.m8670b(str).m8619a()).doubleValue();
        } catch (String str2) {
            str2 = str2.getMessage();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 65);
            stringBuilder.append("Calling getDouble() threw an exception: ");
            stringBuilder.append(str2);
            stringBuilder.append(" Returning default value.");
            bs.m8582a(stringBuilder.toString());
            return eu.m8724c().doubleValue();
        }
    }

    /* renamed from: c */
    public String m8538c(String str) {
        dm f = m8532f();
        if (f == null) {
            bs.m8582a("getString called for closed container.");
            return eu.m8735f();
        }
        try {
            return eu.m8719a((ct) f.m8670b(str).m8619a());
        } catch (String str2) {
            str2 = str2.getMessage();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 65);
            stringBuilder.append("Calling getString() threw an exception: ");
            stringBuilder.append(str2);
            stringBuilder.append(" Returning default value.");
            bs.m8582a(stringBuilder.toString());
            return eu.m8735f();
        }
    }

    /* renamed from: b */
    public long m8537b() {
        return this.f7449g;
    }

    /* renamed from: c */
    public boolean m8539c() {
        return m8537b() == 0;
    }

    /* renamed from: d */
    final C2927a m8540d(String str) {
        C2927a c2927a;
        synchronized (this.f7447e) {
            c2927a = (C2927a) this.f7447e.get(str);
        }
        return c2927a;
    }

    /* renamed from: a */
    public void m8534a(String str, C2928b c2928b) {
        if (c2928b != null) {
            synchronized (this.f7448f) {
                this.f7448f.put(str, c2928b);
            }
            return;
        }
        throw new NullPointerException("Tag callback must be non-null");
    }

    /* renamed from: e */
    public final C2928b m8542e(String str) {
        C2928b c2928b;
        synchronized (this.f7448f) {
            c2928b = (C2928b) this.f7448f.get(str);
        }
        return c2928b;
    }

    /* renamed from: f */
    public final void m8544f(String str) {
        m8532f().m8668a(str);
    }

    /* renamed from: d */
    public final String m8541d() {
        return this.f7450h;
    }

    /* renamed from: a */
    private final void m8531a(db dbVar) {
        this.f7450h = dbVar.c();
        String str = this.f7450h;
        cr.m8622a().m8623b().equals(C2935a.CONTAINER_DEBUG);
        db dbVar2 = dbVar;
        m8530a(new dm(this.f7443a, dbVar2, this.f7445c, new C4389c(), new C4390d(), new ca()));
        if (m8535a("_gtm.loadEventEnabled") != null) {
            this.f7445c.m8616a("gtm.load", C2934c.m8604a("gtm.id", this.f7444b));
        }
    }

    /* renamed from: a */
    private final synchronized void m8530a(dm dmVar) {
        this.f7446d = dmVar;
    }

    /* renamed from: f */
    private final synchronized dm m8532f() {
        return this.f7446d;
    }

    /* renamed from: e */
    final void m8543e() {
        this.f7446d = null;
    }
}
