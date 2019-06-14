package com.google.p127a;

import com.google.p127a.p129b.C2147j;
import com.google.p127a.p132d.C2154c;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: JsonElement */
/* renamed from: com.google.a.l */
public abstract class C2162l {
    /* renamed from: g */
    public boolean m5998g() {
        return this instanceof C4049i;
    }

    /* renamed from: h */
    public boolean m5999h() {
        return this instanceof C4052o;
    }

    /* renamed from: i */
    public boolean m6000i() {
        return this instanceof C4053q;
    }

    /* renamed from: j */
    public boolean m6001j() {
        return this instanceof C4051n;
    }

    /* renamed from: k */
    public C4052o m6002k() {
        if (m5999h()) {
            return (C4052o) this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a JSON Object: ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: l */
    public C4049i m6003l() {
        if (m5998g()) {
            return (C4049i) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    /* renamed from: m */
    public C4053q m6004m() {
        if (m6000i()) {
            return (C4053q) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    /* renamed from: f */
    public boolean mo2036f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: n */
    Boolean mo2037n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: a */
    public Number mo2031a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: b */
    public String mo2032b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: c */
    public double mo2033c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: d */
    public long mo2034d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: e */
    public int mo2035e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            C2154c c2154c = new C2154c(stringWriter);
            c2154c.m5950b(true);
            C2147j.m5883a(this, c2154c);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
