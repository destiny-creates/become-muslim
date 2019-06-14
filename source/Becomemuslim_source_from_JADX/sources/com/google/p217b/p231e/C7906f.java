package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.p222b.C5202b;
import java.util.Map;

/* compiled from: Code39Writer */
/* renamed from: com.google.b.e.f */
public final class C7906f extends C6874s {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (c5193a == C5193a.CODE_39) {
            return super.mo4860a(str, c5193a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(c5193a)));
    }

    /* renamed from: a */
    public boolean[] mo6261a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr;
            int i;
            int i2;
            int i3;
            boolean[] zArr;
            int[] iArr2;
            int a;
            for (int i4 = 0; i4 < length; i4++) {
                if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i4)) < 0) {
                    str = C7906f.m38470b(str);
                    length = str.length();
                    if (length <= 80) {
                        iArr = new int[9];
                        i = length + 25;
                        i2 = 0;
                        while (i2 < length) {
                            C7906f.m38469a(C7905e.f29501a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i2))], iArr);
                            i3 = i;
                            for (i = 0; i < 9; i++) {
                                i3 += iArr[i];
                            }
                            i2++;
                            i = i3;
                        }
                        zArr = new boolean[i];
                        C7906f.m38469a(148, iArr);
                        i3 = C6874s.m32300a(zArr, 0, iArr, true);
                        iArr2 = new int[]{1};
                        a = i3 + C6874s.m32300a(zArr, i3, iArr2, false);
                        for (i3 = 0; i3 < length; i3++) {
                            C7906f.m38469a(C7905e.f29501a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i3))], iArr);
                            a += C6874s.m32300a(zArr, a, iArr, true);
                            a += C6874s.m32300a(zArr, a, iArr2, false);
                        }
                        C7906f.m38469a(148, iArr);
                        C6874s.m32300a(zArr, a, iArr, true);
                        return zArr;
                    }
                    StringBuilder stringBuilder = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
                    stringBuilder.append(length);
                    stringBuilder.append(" (extended full ASCII mode)");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            iArr = new int[9];
            i = length + 25;
            i2 = 0;
            while (i2 < length) {
                C7906f.m38469a(C7905e.f29501a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i2))], iArr);
                i3 = i;
                for (i = 0; i < 9; i++) {
                    i3 += iArr[i];
                }
                i2++;
                i = i3;
            }
            zArr = new boolean[i];
            C7906f.m38469a(148, iArr);
            i3 = C6874s.m32300a(zArr, 0, iArr, true);
            iArr2 = new int[]{1};
            a = i3 + C6874s.m32300a(zArr, i3, iArr2, false);
            for (i3 = 0; i3 < length; i3++) {
                C7906f.m38469a(C7905e.f29501a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i3))], iArr);
                a += C6874s.m32300a(zArr, a, iArr, true);
                a += C6874s.m32300a(zArr, a, iArr2, false);
            }
            C7906f.m38469a(148, iArr);
            C6874s.m32300a(zArr, a, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }

    /* renamed from: a */
    private static void m38469a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    /* renamed from: b */
    private static String m38470b(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\u0000') {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        stringBuilder.append("%V");
                    } else if (charAt != '`') {
                        switch (charAt) {
                            case '-':
                            case '.':
                                break;
                            default:
                                if (charAt > '\u001a') {
                                    if (charAt >= ' ') {
                                        if (charAt > ',' && charAt != '/') {
                                            if (charAt != ':') {
                                                if (charAt <= '9') {
                                                    stringBuilder.append((char) ((charAt - 48) + 48));
                                                    break;
                                                } else if (charAt <= '?') {
                                                    stringBuilder.append('%');
                                                    stringBuilder.append((char) ((charAt - 59) + 70));
                                                    break;
                                                } else if (charAt <= 'Z') {
                                                    stringBuilder.append((char) ((charAt - 65) + 65));
                                                    break;
                                                } else if (charAt <= '_') {
                                                    stringBuilder.append('%');
                                                    stringBuilder.append((char) ((charAt - 91) + 75));
                                                    break;
                                                } else if (charAt <= 'z') {
                                                    stringBuilder.append('+');
                                                    stringBuilder.append((char) ((charAt - 97) + 65));
                                                    break;
                                                } else if (charAt <= '') {
                                                    stringBuilder.append('%');
                                                    stringBuilder.append((char) ((charAt - 123) + 80));
                                                    break;
                                                } else {
                                                    stringBuilder = new StringBuilder("Requested content contains a non-encodable character: '");
                                                    stringBuilder.append(str.charAt(i));
                                                    stringBuilder.append("'");
                                                    throw new IllegalArgumentException(stringBuilder.toString());
                                                }
                                            }
                                        }
                                        stringBuilder.append('/');
                                        stringBuilder.append((char) ((charAt - 33) + 65));
                                        break;
                                    }
                                    stringBuilder.append('%');
                                    stringBuilder.append((char) ((charAt - 27) + 65));
                                    break;
                                }
                                stringBuilder.append('$');
                                stringBuilder.append((char) ((charAt - 1) + 65));
                                continue;
                        }
                    } else {
                        stringBuilder.append("%W");
                    }
                }
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append("%U");
            }
        }
        return stringBuilder.toString();
    }
}
