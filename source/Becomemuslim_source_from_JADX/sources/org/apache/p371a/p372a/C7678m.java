package org.apache.p371a.p372a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

/* compiled from: Parser */
/* renamed from: org.apache.a.a.m */
public abstract class C7678m implements C6627c {
    /* renamed from: a */
    protected C6626b f26420a;
    /* renamed from: b */
    private C6634k f26421b;
    /* renamed from: c */
    private List f26422c;

    /* renamed from: b */
    protected abstract String[] mo6422b(C6634k c6634k, String[] strArr, boolean z);

    /* renamed from: a */
    protected void m34553a(C6634k c6634k) {
        this.f26421b = c6634k;
        this.f26422c = new ArrayList(c6634k.m27016b());
    }

    /* renamed from: a */
    protected C6634k m34549a() {
        return this.f26421b;
    }

    /* renamed from: b */
    protected List m34554b() {
        return this.f26422c;
    }

    /* renamed from: a */
    public C6626b mo5692a(C6634k c6634k, String[] strArr, boolean z) {
        return m34547a(c6634k, strArr, null, z);
    }

    /* renamed from: a */
    public C6626b m34547a(C6634k c6634k, String[] strArr, Properties properties, boolean z) {
        for (C6631h o : c6634k.m27013a()) {
            o.m27005o();
        }
        m34553a(c6634k);
        this.f26420a = new C6626b();
        c6634k = null;
        if (strArr == null) {
            strArr = new String[0];
        }
        ListIterator listIterator = Arrays.asList(mo6422b(m34549a(), strArr, z)).listIterator();
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            if (!"--".equals(str)) {
                if ("-".equals(str)) {
                    if (!z) {
                        this.f26420a.m26975b(str);
                        if (c6634k == null) {
                            while (listIterator.hasNext()) {
                                str = (String) listIterator.next();
                                if ("--".equals(str)) {
                                    this.f26420a.m26975b(str);
                                }
                            }
                        }
                    }
                } else if (!str.startsWith("-")) {
                    this.f26420a.m26975b(str);
                    if (z) {
                    }
                    if (c6634k == null) {
                        while (listIterator.hasNext()) {
                            str = (String) listIterator.next();
                            if ("--".equals(str)) {
                                this.f26420a.m26975b(str);
                            }
                        }
                    }
                } else if (!z || m34549a().m27018b(str)) {
                    m34550a(str, listIterator);
                    if (c6634k == null) {
                        while (listIterator.hasNext()) {
                            str = (String) listIterator.next();
                            if ("--".equals(str)) {
                                this.f26420a.m26975b(str);
                            }
                        }
                    }
                } else {
                    this.f26420a.m26975b(str);
                }
            }
            c6634k = true;
            if (c6634k == null) {
                while (listIterator.hasNext()) {
                    str = (String) listIterator.next();
                    if ("--".equals(str)) {
                        this.f26420a.m26975b(str);
                    }
                }
            }
        }
        m34551a(properties);
        m34556c();
        return this.f26420a;
    }

    /* renamed from: a */
    protected void m34551a(java.util.Properties r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        if (r5 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r5.propertyNames();
    L_0x0007:
        r1 = r0.hasMoreElements();
        if (r1 == 0) goto L_0x005f;
    L_0x000d:
        r1 = r0.nextElement();
        r1 = r1.toString();
        r2 = r4.f26420a;
        r2 = r2.m26974a(r1);
        if (r2 != 0) goto L_0x0007;
    L_0x001d:
        r2 = r4.m34549a();
        r2 = r2.m27014a(r1);
        r1 = r5.getProperty(r1);
        r3 = r2.m26996f();
        if (r3 == 0) goto L_0x0040;
    L_0x002f:
        r3 = r2.m27004n();
        if (r3 == 0) goto L_0x003c;
    L_0x0035:
        r3 = r2.m27004n();
        r3 = r3.length;
        if (r3 != 0) goto L_0x0059;
    L_0x003c:
        r2.m26991a(r1);	 Catch:{ RuntimeException -> 0x0059 }
        goto L_0x0059;
    L_0x0040:
        r3 = "yes";
        r3 = r3.equalsIgnoreCase(r1);
        if (r3 != 0) goto L_0x0059;
    L_0x0048:
        r3 = "true";
        r3 = r3.equalsIgnoreCase(r1);
        if (r3 != 0) goto L_0x0059;
    L_0x0050:
        r3 = "1";
        r1 = r3.equalsIgnoreCase(r1);
        if (r1 != 0) goto L_0x0059;
    L_0x0058:
        goto L_0x005f;
    L_0x0059:
        r1 = r4.f26420a;
        r1.m26973a(r2);
        goto L_0x0007;
    L_0x005f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.a.a.m.a(java.util.Properties):void");
    }

    /* renamed from: c */
    protected void m34556c() {
        if (!m34554b().isEmpty()) {
            throw new C7677g(m34554b());
        }
    }

    /* renamed from: a */
    public void m34552a(org.apache.p371a.p372a.C6631h r3, java.util.ListIterator r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
    L_0x0000:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x002d;
    L_0x0006:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r1 = r2.m34549a();
        r1 = r1.m27018b(r0);
        if (r1 == 0) goto L_0x0022;
    L_0x0016:
        r1 = "-";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0022;
    L_0x001e:
        r4.previous();
        goto L_0x002d;
    L_0x0022:
        r0 = org.apache.p371a.p372a.C6636o.m27020b(r0);	 Catch:{ RuntimeException -> 0x002a }
        r3.m26991a(r0);	 Catch:{ RuntimeException -> 0x002a }
        goto L_0x0000;
    L_0x002a:
        r4.previous();
    L_0x002d:
        r4 = r3.m27004n();
        if (r4 != 0) goto L_0x0040;
    L_0x0033:
        r4 = r3.m26994d();
        if (r4 == 0) goto L_0x003a;
    L_0x0039:
        goto L_0x0040;
    L_0x003a:
        r4 = new org.apache.a.a.f;
        r4.<init>(r3);
        throw r4;
    L_0x0040:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.a.a.m.a(org.apache.a.a.h, java.util.ListIterator):void");
    }

    /* renamed from: a */
    protected void m34550a(String str, ListIterator listIterator) {
        if (m34549a().m27018b(str)) {
            C6631h c6631h = (C6631h) m34549a().m27014a(str).clone();
            if (c6631h.m26998h()) {
                m34554b().remove(c6631h.m26990a());
            }
            if (m34549a().m27017b(c6631h) != null) {
                C6632i b = m34549a().m27017b(c6631h);
                if (b.m27009c()) {
                    m34554b().remove(b);
                }
                b.m27007a(c6631h);
            }
            if (c6631h.m26996f()) {
                m34552a(c6631h, listIterator);
            }
            this.f26420a.m26973a(c6631h);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unrecognized option: ");
        stringBuffer.append(str);
        throw new C7679n(stringBuffer.toString(), str);
    }
}
