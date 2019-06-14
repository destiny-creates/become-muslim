package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.p222b.C5202b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: Code128Writer */
/* renamed from: com.google.b.e.d */
public final class C7904d extends C6874s {

    /* compiled from: Code128Writer */
    /* renamed from: com.google.b.e.d$a */
    private enum C5249a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (c5193a == C5193a.CODE_128) {
            return super.mo4860a(str, c5193a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(c5193a)));
    }

    /* renamed from: a */
    public boolean[] mo6261a(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case 'ñ':
                case 'ò':
                case 'ó':
                case 'ô':
                    break;
                default:
                    if (charAt <= '') {
                        break;
                    }
                    throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
            }
        }
        Collection<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int i7 = 103;
            if (i3 < length) {
                int a = C7904d.m38460a(str, i3, i4);
                if (a == i4) {
                    a = 101;
                    switch (str.charAt(i3)) {
                        case 'ñ':
                            a = 102;
                            break;
                        case 'ò':
                            a = 97;
                            break;
                        case 'ó':
                            a = 96;
                            break;
                        case 'ô':
                            if (i4 != 101) {
                                a = 100;
                                break;
                            }
                            break;
                        default:
                            switch (i4) {
                                case 100:
                                    a = str.charAt(i3) - 32;
                                    break;
                                case 101:
                                    a = str.charAt(i3) - 32;
                                    if (a < 0) {
                                        a += 96;
                                        break;
                                    }
                                    break;
                                default:
                                    a = Integer.parseInt(str.substring(i3, i3 + 2));
                                    i3++;
                                    break;
                            }
                    }
                    i3++;
                    i7 = a;
                } else {
                    if (i4 == 0) {
                        switch (a) {
                            case 100:
                                i7 = 104;
                                break;
                            case 101:
                                break;
                            default:
                                i7 = 105;
                                break;
                        }
                    }
                    i7 = a;
                    i4 = a;
                }
                arrayList.add(C7903c.f29500a[i7]);
                i5 += i7 * i6;
                if (i3 != 0) {
                    i6++;
                }
            } else {
                arrayList.add(C7903c.f29500a[i5 % 103]);
                arrayList.add(C7903c.f29500a[106]);
                length = 0;
                for (int[] iArr : arrayList) {
                    i5 = length;
                    for (int i62 : (int[]) str.next()) {
                        i5 += i62;
                    }
                    length = i5;
                }
                str = new boolean[length];
                for (int[] a2 : arrayList) {
                    i += C6874s.m32300a((boolean[]) str, i, a2, true);
                }
                return str;
            }
        }
    }

    /* renamed from: a */
    private static C5249a m38461a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return C5249a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 'ñ') {
            return C5249a.FNC_1;
        }
        if (charAt >= '0') {
            if (charAt <= '9') {
                i++;
                if (i >= length) {
                    return C5249a.ONE_DIGIT;
                }
                charSequence = charSequence.charAt(i);
                if (charSequence >= 48) {
                    if (charSequence <= 57) {
                        return C5249a.TWO_DIGITS;
                    }
                }
                return C5249a.ONE_DIGIT;
            }
        }
        return C5249a.UNCODABLE;
    }

    /* renamed from: a */
    private static int m38460a(CharSequence charSequence, int i, int i2) {
        C5249a a = C7904d.m38461a(charSequence, i);
        if (a == C5249a.ONE_DIGIT) {
            return 100;
        }
        if (a == C5249a.UNCODABLE) {
            if (i < charSequence.length()) {
                charSequence = charSequence.charAt(i);
                if (charSequence < 32 || (i2 == 101 && charSequence < 96)) {
                    return 101;
                }
            }
            return 100;
        } else if (i2 == 99) {
            return 99;
        } else {
            if (i2 != 100) {
                if (a == C5249a.FNC_1) {
                    a = C7904d.m38461a(charSequence, i + 1);
                }
                if (a == C5249a.TWO_DIGITS) {
                    return 99;
                }
                return 100;
            } else if (a == C5249a.FNC_1) {
                return 100;
            } else {
                i2 = C7904d.m38461a(charSequence, i + 2);
                if (i2 != C5249a.UNCODABLE) {
                    if (i2 != C5249a.ONE_DIGIT) {
                        if (i2 != C5249a.FNC_1) {
                            i += 4;
                            while (true) {
                                i2 = C7904d.m38461a(charSequence, i);
                                if (i2 != C5249a.TWO_DIGITS) {
                                    break;
                                }
                                i += 2;
                            }
                            if (i2 == C5249a.ONE_DIGIT) {
                                return 100;
                            }
                            return 99;
                        } else if (C7904d.m38461a(charSequence, i + 3) == C5249a.TWO_DIGITS) {
                            return 99;
                        } else {
                            return 100;
                        }
                    }
                }
                return 100;
            }
        }
    }
}
