package org.apache.p371a.p372a;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: HelpFormatter */
/* renamed from: org.apache.a.a.e */
public class C6630e {
    /* renamed from: a */
    public int f21300a = 74;
    /* renamed from: b */
    public int f21301b = 1;
    /* renamed from: c */
    public int f21302c = 3;
    /* renamed from: d */
    public String f21303d = "usage: ";
    /* renamed from: e */
    public String f21304e = System.getProperty("line.separator");
    /* renamed from: f */
    public String f21305f = "-";
    /* renamed from: g */
    public String f21306g = "--";
    /* renamed from: h */
    public String f21307h = "arg";
    /* renamed from: i */
    protected Comparator f21308i = new C6629a(null);

    /* compiled from: HelpFormatter */
    /* renamed from: org.apache.a.a.e$1 */
    class C66281 {
    }

    /* compiled from: HelpFormatter */
    /* renamed from: org.apache.a.a.e$a */
    private static class C6629a implements Comparator {
        private C6629a() {
        }

        C6629a(C66281 c66281) {
            this();
        }

        public int compare(Object obj, Object obj2) {
            return ((C6631h) obj).m26990a().compareToIgnoreCase(((C6631h) obj2).m26990a());
        }
    }

    /* renamed from: a */
    public int m26977a() {
        return this.f21300a;
    }

    /* renamed from: b */
    public int m26984b() {
        return this.f21301b;
    }

    /* renamed from: c */
    public int m26985c() {
        return this.f21302c;
    }

    /* renamed from: d */
    public Comparator m26986d() {
        return this.f21308i;
    }

    /* renamed from: a */
    public void m26983a(PrintWriter printWriter, int i, C6634k c6634k, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        m26982a(stringBuffer, i, c6634k, i2, i3);
        printWriter.println(stringBuffer.toString());
    }

    /* renamed from: a */
    protected StringBuffer m26982a(StringBuffer stringBuffer, int i, C6634k c6634k, int i2, int i3) {
        i2 = m26979a(i2);
        String a = m26979a(i3);
        List arrayList = new ArrayList();
        C6634k<C6631h> a2 = c6634k.m27013a();
        Collections.sort(a2, m26986d());
        int i4 = 0;
        int i5 = 0;
        for (C6631h c6631h : a2) {
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (c6631h.m26992b() == null) {
                stringBuffer2.append(i2);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("   ");
                stringBuffer3.append(this.f21306g);
                stringBuffer2.append(stringBuffer3.toString());
                stringBuffer2.append(c6631h.m26993c());
            } else {
                stringBuffer2.append(i2);
                stringBuffer2.append(this.f21305f);
                stringBuffer2.append(c6631h.m26992b());
                if (c6631h.m26995e()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(this.f21306g);
                    stringBuffer2.append(c6631h.m26993c());
                }
            }
            if (c6631h.m26996f()) {
                if (c6631h.m27000j()) {
                    stringBuffer2.append(" <");
                    stringBuffer2.append(c6631h.m26999i());
                    stringBuffer2.append(">");
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > i5) {
                i5 = stringBuffer2.length();
            }
        }
        c6634k = a2.iterator();
        while (c6634k.hasNext() != 0) {
            C6631h c6631h2 = (C6631h) c6634k.next();
            int i6 = i4 + 1;
            StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i4).toString());
            if (stringBuffer4.length() < i5) {
                stringBuffer4.append(m26979a(i5 - stringBuffer4.length()));
            }
            stringBuffer4.append(a);
            i4 = i5 + i3;
            if (c6631h2.m26997g() != null) {
                stringBuffer4.append(c6631h2.m26997g());
            }
            m26981a(stringBuffer, i, i4, stringBuffer4.toString());
            if (c6634k.hasNext() != 0) {
                stringBuffer.append(this.f21304e);
            }
            i4 = i6;
        }
        return stringBuffer;
    }

    /* renamed from: a */
    protected StringBuffer m26981a(StringBuffer stringBuffer, int i, int i2, String str) {
        int a = m26978a(str, i, 0);
        if (a == -1) {
            stringBuffer.append(m26980a(str));
            return stringBuffer;
        }
        stringBuffer.append(m26980a(str.substring(0, a)));
        stringBuffer.append(this.f21304e);
        if (i2 >= i) {
            i2 = 1;
        }
        String a2 = m26979a(i2);
        while (true) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(a2);
            stringBuffer2.append(str.substring(a).trim());
            str = stringBuffer2.toString();
            a = m26978a(str, i, 0);
            if (a == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i && a == i2 - 1) {
                a = i;
            }
            stringBuffer.append(m26980a(str.substring(0, a)));
            stringBuffer.append(this.f21304e);
        }
    }

    /* renamed from: a */
    protected int m26978a(String str, int i, int i2) {
        int indexOf = str.indexOf(10, i2);
        if (indexOf == -1 || indexOf > i) {
            indexOf = str.indexOf(9, i2);
            if (indexOf == -1 || indexOf > i) {
                i += i2;
                if (i >= str.length()) {
                    return -1;
                }
                indexOf = i;
                while (indexOf >= i2) {
                    char charAt = str.charAt(indexOf);
                    if (charAt == ' ' || charAt == '\n' || charAt == '\r') {
                        break;
                    }
                    indexOf--;
                }
                if (indexOf > i2) {
                    return indexOf;
                }
                while (i <= str.length()) {
                    i2 = str.charAt(i);
                    if (i2 == 32 || i2 == 10 || i2 == 13) {
                        break;
                    }
                    i++;
                }
                if (i == str.length()) {
                    i = -1;
                }
                return i;
            }
        }
        return indexOf + 1;
    }

    /* renamed from: a */
    protected String m26979a(int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected String m26980a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                int length = str.length();
                while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
                    length--;
                }
                return str.substring(0, length);
            }
        }
        return str;
    }
}
