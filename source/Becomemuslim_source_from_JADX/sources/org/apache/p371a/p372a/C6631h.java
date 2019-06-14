package org.apache.p371a.p372a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Option */
/* renamed from: org.apache.a.a.h */
public class C6631h implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private String f21309a;
    /* renamed from: b */
    private String f21310b;
    /* renamed from: c */
    private String f21311c = "arg";
    /* renamed from: d */
    private String f21312d;
    /* renamed from: e */
    private boolean f21313e;
    /* renamed from: f */
    private boolean f21314f;
    /* renamed from: g */
    private int f21315g = -1;
    /* renamed from: h */
    private Object f21316h;
    /* renamed from: i */
    private List f21317i = new ArrayList();
    /* renamed from: j */
    private char f21318j;

    public C6631h(String str, String str2, boolean z, String str3) {
        C6633j.m27010a(str);
        this.f21309a = str;
        this.f21310b = str2;
        if (z) {
            this.f21315g = 1;
        }
        this.f21312d = str3;
    }

    /* renamed from: a */
    String m26990a() {
        if (this.f21309a == null) {
            return this.f21310b;
        }
        return this.f21309a;
    }

    /* renamed from: b */
    public String m26992b() {
        return this.f21309a;
    }

    /* renamed from: c */
    public String m26993c() {
        return this.f21310b;
    }

    /* renamed from: d */
    public boolean m26994d() {
        return this.f21314f;
    }

    /* renamed from: e */
    public boolean m26995e() {
        return this.f21310b != null;
    }

    /* renamed from: f */
    public boolean m26996f() {
        if (this.f21315g <= 0) {
            if (this.f21315g != -2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public String m26997g() {
        return this.f21312d;
    }

    /* renamed from: h */
    public boolean m26998h() {
        return this.f21313e;
    }

    /* renamed from: i */
    public String m26999i() {
        return this.f21311c;
    }

    /* renamed from: j */
    public boolean m27000j() {
        return this.f21311c != null && this.f21311c.length() > 0;
    }

    /* renamed from: k */
    public boolean m27001k() {
        if (this.f21315g <= 1) {
            return this.f21315g == -2;
        } else {
            return true;
        }
    }

    /* renamed from: l */
    public char m27002l() {
        return this.f21318j;
    }

    /* renamed from: m */
    public boolean m27003m() {
        return this.f21318j > '\u0000';
    }

    /* renamed from: a */
    void m26991a(String str) {
        if (this.f21315g != -1) {
            m26987b(str);
            return;
        }
        throw new RuntimeException("NO_ARGS_ALLOWED");
    }

    /* renamed from: b */
    private void m26987b(String str) {
        if (m27003m()) {
            char l = m27002l();
            int indexOf = str.indexOf(l);
            while (indexOf != -1) {
                if (this.f21317i.size() == this.f21315g - 1) {
                    break;
                }
                m26988c(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(l);
            }
        }
        m26988c(str);
    }

    /* renamed from: c */
    private void m26988c(String str) {
        if (this.f21315g > 0) {
            if (this.f21317i.size() > this.f21315g - 1) {
                throw new RuntimeException("Cannot add value, list full.");
            }
        }
        this.f21317i.add(str);
    }

    /* renamed from: n */
    public String[] m27004n() {
        return m26989p() ? null : (String[]) this.f21317i.toArray(new String[this.f21317i.size()]);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ option: ");
        stringBuffer.append(this.f21309a);
        if (this.f21310b != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f21310b);
        }
        stringBuffer.append(" ");
        if (m27001k()) {
            stringBuffer.append("[ARG...]");
        } else if (m26996f()) {
            stringBuffer.append(" [ARG]");
        }
        stringBuffer.append(" :: ");
        stringBuffer.append(this.f21312d);
        if (this.f21316h != null) {
            stringBuffer.append(" :: ");
            stringBuffer.append(this.f21316h);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    /* renamed from: p */
    private boolean m26989p() {
        return this.f21317i.isEmpty();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x003d;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x003d;
    L_0x0012:
        r5 = (org.apache.p371a.p372a.C6631h) r5;
        r2 = r4.f21309a;
        if (r2 == 0) goto L_0x0023;
    L_0x0018:
        r2 = r4.f21309a;
        r3 = r5.f21309a;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0028;
    L_0x0022:
        goto L_0x0027;
    L_0x0023:
        r2 = r5.f21309a;
        if (r2 == 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r2 = r4.f21310b;
        if (r2 == 0) goto L_0x0037;
    L_0x002c:
        r2 = r4.f21310b;
        r5 = r5.f21310b;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x003c;
    L_0x0036:
        goto L_0x003b;
    L_0x0037:
        r5 = r5.f21310b;
        if (r5 == 0) goto L_0x003c;
    L_0x003b:
        return r1;
    L_0x003c:
        return r0;
    L_0x003d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.a.a.h.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f21309a != null ? this.f21309a.hashCode() : 0) * 31;
        if (this.f21310b != null) {
            i = this.f21310b.hashCode();
        }
        return hashCode + i;
    }

    public Object clone() {
        try {
            C6631h c6631h = (C6631h) super.clone();
            c6631h.f21317i = new ArrayList(this.f21317i);
            return c6631h;
        } catch (CloneNotSupportedException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("A CloneNotSupportedException was thrown: ");
            stringBuffer.append(e.getMessage());
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    /* renamed from: o */
    void m27005o() {
        this.f21317i.clear();
    }
}
