package com.google.p127a.p129b.p130a;

import com.google.p127a.C2162l;
import com.google.p127a.C4049i;
import com.google.p127a.C4051n;
import com.google.p127a.C4052o;
import com.google.p127a.C4053q;
import com.google.p127a.p132d.C2154c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter */
/* renamed from: com.google.a.b.a.f */
public final class C4000f extends C2154c {
    /* renamed from: a */
    private static final Writer f10022a = new C21241();
    /* renamed from: b */
    private static final C4053q f10023b = new C4053q("closed");
    /* renamed from: c */
    private final List<C2162l> f10024c = new ArrayList();
    /* renamed from: d */
    private String f10025d;
    /* renamed from: e */
    private C2162l f10026e = C4051n.f10123a;

    /* compiled from: JsonTreeWriter */
    /* renamed from: com.google.a.b.a.f$1 */
    static class C21241 extends Writer {
        C21241() {
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void close() {
            throw new AssertionError();
        }
    }

    public void flush() {
    }

    public C4000f() {
        super(f10022a);
    }

    /* renamed from: a */
    public C2162l mo2014a() {
        if (this.f10024c.isEmpty()) {
            return this.f10026e;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected one JSON element but was ");
        stringBuilder.append(this.f10024c);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: j */
    private C2162l m12251j() {
        return (C2162l) this.f10024c.get(this.f10024c.size() - 1);
    }

    /* renamed from: a */
    private void m12250a(C2162l c2162l) {
        if (this.f10025d != null) {
            if (!c2162l.m6001j() || m5960i()) {
                ((C4052o) m12251j()).m12473a(this.f10025d, c2162l);
            }
            this.f10025d = null;
        } else if (this.f10024c.isEmpty()) {
            this.f10026e = c2162l;
        } else {
            C2162l j = m12251j();
            if (j instanceof C4049i) {
                ((C4049i) j).m12466a(c2162l);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    public C2154c mo2015b() {
        C2162l c4049i = new C4049i();
        m12250a(c4049i);
        this.f10024c.add(c4049i);
        return this;
    }

    /* renamed from: c */
    public C2154c mo2017c() {
        if (this.f10024c.isEmpty() || this.f10025d != null) {
            throw new IllegalStateException();
        } else if (m12251j() instanceof C4049i) {
            this.f10024c.remove(this.f10024c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: d */
    public C2154c mo2019d() {
        C2162l c4052o = new C4052o();
        m12250a(c4052o);
        this.f10024c.add(c4052o);
        return this;
    }

    /* renamed from: e */
    public C2154c mo2020e() {
        if (this.f10024c.isEmpty() || this.f10025d != null) {
            throw new IllegalStateException();
        } else if (m12251j() instanceof C4052o) {
            this.f10024c.remove(this.f10024c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public C2154c mo2012a(String str) {
        if (this.f10024c.isEmpty() || this.f10025d != null) {
            throw new IllegalStateException();
        } else if (m12251j() instanceof C4052o) {
            this.f10025d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    public C2154c mo2016b(String str) {
        if (str == null) {
            return mo2021f();
        }
        m12250a(new C4053q(str));
        return this;
    }

    /* renamed from: f */
    public C2154c mo2021f() {
        m12250a(C4051n.f10123a);
        return this;
    }

    /* renamed from: a */
    public C2154c mo2013a(boolean z) {
        m12250a(new C4053q(Boolean.valueOf(z)));
        return this;
    }

    /* renamed from: a */
    public C2154c mo2010a(long j) {
        m12250a(new C4053q(Long.valueOf(j)));
        return this;
    }

    /* renamed from: a */
    public C2154c mo2011a(Number number) {
        if (number == null) {
            return mo2021f();
        }
        if (!m5958g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("JSON forbids NaN and infinities: ");
                stringBuilder.append(number);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        m12250a(new C4053q(number));
        return this;
    }

    public void close() {
        if (this.f10024c.isEmpty()) {
            this.f10024c.add(f10023b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
