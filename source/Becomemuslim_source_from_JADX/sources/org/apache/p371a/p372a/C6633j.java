package org.apache.p371a.p372a;

/* compiled from: OptionValidator */
/* renamed from: org.apache.a.a.j */
class C6633j {
    /* renamed from: a */
    static void m27010a(String str) {
        if (str != null) {
            int i = 0;
            if (str.length() == 1) {
                char charAt = str.charAt(0);
                if (!C6633j.m27011a(charAt)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("illegal option value '");
                    stringBuffer.append(charAt);
                    stringBuffer.append("'");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            } else {
                str = str.toCharArray();
                while (i < str.length) {
                    if (C6633j.m27012b(str[i])) {
                        i++;
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("opt contains illegal character value '");
                        stringBuffer2.append(str[i]);
                        stringBuffer2.append("'");
                        throw new IllegalArgumentException(stringBuffer2.toString());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m27011a(char c) {
        if (!(C6633j.m27012b(c) || c == ' ' || c == '?')) {
            if (c != '@') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m27012b(char c) {
        return Character.isJavaIdentifierPart(c);
    }
}
