package com.google.p127a.p129b.p130a;

import com.google.p127a.C2162l;
import com.google.p127a.C4049i;
import com.google.p127a.C4051n;
import com.google.p127a.C4052o;
import com.google.p127a.C4053q;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: JsonTreeReader */
/* renamed from: com.google.a.b.a.e */
public final class C3999e extends C2152a {
    /* renamed from: a */
    private static final Reader f10019a = new C21231();
    /* renamed from: b */
    private static final Object f10020b = new Object();
    /* renamed from: c */
    private final List<Object> f10021c = new ArrayList();

    /* compiled from: JsonTreeReader */
    /* renamed from: com.google.a.b.a.e$1 */
    static class C21231 extends Reader {
        C21231() {
        }

        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public void close() {
            throw new AssertionError();
        }
    }

    public C3999e(C2162l c2162l) {
        super(f10019a);
        this.f10021c.add(c2162l);
    }

    /* renamed from: a */
    public void mo1993a() {
        m12232a(C2153b.BEGIN_ARRAY);
        this.f10021c.add(((C4049i) m12233r()).iterator());
    }

    /* renamed from: b */
    public void mo1994b() {
        m12232a(C2153b.END_ARRAY);
        m12234s();
        m12234s();
    }

    /* renamed from: c */
    public void mo1995c() {
        m12232a(C2153b.BEGIN_OBJECT);
        this.f10021c.add(((C4052o) m12233r()).m12474o().iterator());
    }

    /* renamed from: d */
    public void mo1997d() {
        m12232a(C2153b.END_OBJECT);
        m12234s();
        m12234s();
    }

    /* renamed from: e */
    public boolean mo1998e() {
        C2153b f = mo1999f();
        return (f == C2153b.END_OBJECT || f == C2153b.END_ARRAY) ? false : true;
    }

    /* renamed from: f */
    public C2153b mo1999f() {
        if (this.f10021c.isEmpty()) {
            return C2153b.END_DOCUMENT;
        }
        Object r = m12233r();
        if (r instanceof Iterator) {
            boolean z = this.f10021c.get(this.f10021c.size() - 2) instanceof C4052o;
            Iterator it = (Iterator) r;
            if (!it.hasNext()) {
                return z ? C2153b.END_OBJECT : C2153b.END_ARRAY;
            } else if (z) {
                return C2153b.NAME;
            } else {
                this.f10021c.add(it.next());
                return mo1999f();
            }
        } else if (r instanceof C4052o) {
            return C2153b.BEGIN_OBJECT;
        } else {
            if (r instanceof C4049i) {
                return C2153b.BEGIN_ARRAY;
            }
            if (r instanceof C4053q) {
                C4053q c4053q = (C4053q) r;
                if (c4053q.m12487q()) {
                    return C2153b.STRING;
                }
                if (c4053q.m12485o()) {
                    return C2153b.BOOLEAN;
                }
                if (c4053q.m12486p()) {
                    return C2153b.NUMBER;
                }
                throw new AssertionError();
            } else if (r instanceof C4051n) {
                return C2153b.NULL;
            } else {
                if (r == f10020b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    /* renamed from: r */
    private Object m12233r() {
        return this.f10021c.get(this.f10021c.size() - 1);
    }

    /* renamed from: s */
    private Object m12234s() {
        return this.f10021c.remove(this.f10021c.size() - 1);
    }

    /* renamed from: a */
    private void m12232a(C2153b c2153b) {
        if (mo1999f() != c2153b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append(c2153b);
            stringBuilder.append(" but was ");
            stringBuilder.append(mo1999f());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: g */
    public String mo2000g() {
        m12232a(C2153b.NAME);
        Entry entry = (Entry) ((Iterator) m12233r()).next();
        this.f10021c.add(entry.getValue());
        return (String) entry.getKey();
    }

    /* renamed from: h */
    public String mo2001h() {
        C2153b f = mo1999f();
        if (f != C2153b.STRING) {
            if (f != C2153b.NUMBER) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected ");
                stringBuilder.append(C2153b.STRING);
                stringBuilder.append(" but was ");
                stringBuilder.append(f);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return ((C4053q) m12234s()).mo2032b();
    }

    /* renamed from: i */
    public boolean mo2002i() {
        m12232a(C2153b.BOOLEAN);
        return ((C4053q) m12234s()).mo2036f();
    }

    /* renamed from: j */
    public void mo2003j() {
        m12232a(C2153b.NULL);
        m12234s();
    }

    /* renamed from: k */
    public double mo2004k() {
        C2153b f = mo1999f();
        if (f != C2153b.NUMBER) {
            if (f != C2153b.STRING) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected ");
                stringBuilder.append(C2153b.NUMBER);
                stringBuilder.append(" but was ");
                stringBuilder.append(f);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        double c = ((C4053q) m12233r()).mo2033c();
        if (!m5932p()) {
            if (Double.isNaN(c) || Double.isInfinite(c)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("JSON forbids NaN and infinities: ");
                stringBuilder2.append(c);
                throw new NumberFormatException(stringBuilder2.toString());
            }
        }
        m12234s();
        return c;
    }

    /* renamed from: l */
    public long mo2005l() {
        C2153b f = mo1999f();
        if (f != C2153b.NUMBER) {
            if (f != C2153b.STRING) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected ");
                stringBuilder.append(C2153b.NUMBER);
                stringBuilder.append(" but was ");
                stringBuilder.append(f);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        long d = ((C4053q) m12233r()).mo2034d();
        m12234s();
        return d;
    }

    /* renamed from: m */
    public int mo2006m() {
        C2153b f = mo1999f();
        if (f != C2153b.NUMBER) {
            if (f != C2153b.STRING) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected ");
                stringBuilder.append(C2153b.NUMBER);
                stringBuilder.append(" but was ");
                stringBuilder.append(f);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        int e = ((C4053q) m12233r()).mo2035e();
        m12234s();
        return e;
    }

    public void close() {
        this.f10021c.clear();
        this.f10021c.add(f10020b);
    }

    /* renamed from: n */
    public void mo2007n() {
        if (mo1999f() == C2153b.NAME) {
            mo2000g();
        } else {
            m12234s();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* renamed from: o */
    public void mo2008o() {
        m12232a(C2153b.NAME);
        Entry entry = (Entry) ((Iterator) m12233r()).next();
        this.f10021c.add(entry.getValue());
        this.f10021c.add(new C4053q((String) entry.getKey()));
    }
}
