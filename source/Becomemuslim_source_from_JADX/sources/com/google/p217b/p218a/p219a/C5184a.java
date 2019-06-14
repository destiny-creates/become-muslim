package com.google.p217b.p218a.p219a;

import com.facebook.ads.internal.p088c.C1354a;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.google.p217b.C6891h;
import com.google.p217b.p218a.C6851a;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p222b.C5205e;
import com.google.p217b.p222b.p224b.C5197a;
import com.google.p217b.p222b.p224b.C5199c;
import com.raizlabs.android.dbflow.config.C5679e;
import host.exp.exponent.p339f.C6352l;
import java.util.Arrays;

/* compiled from: Decoder */
/* renamed from: com.google.b.a.a.a */
public final class C5184a {
    /* renamed from: a */
    private static final String[] f17455a = new String[]{"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    /* renamed from: b */
    private static final String[] f17456b = new String[]{"CTRL_PS", " ", C1354a.f3934a, "b", "c", "d", C5679e.f18978a, "f", "g", "h", "i", "j", "k", C6352l.f20613a, "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    /* renamed from: c */
    private static final String[] f17457c = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    /* renamed from: d */
    private static final String[] f17458d = new String[]{"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    /* renamed from: e */
    private static final String[] f17459e = new String[]{"CTRL_PS", " ", AppEventsConstants.EVENT_PARAM_VALUE_NO, AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    /* renamed from: f */
    private C6851a f17460f;

    /* compiled from: Decoder */
    /* renamed from: com.google.b.a.a.a$a */
    private enum C5183a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    /* renamed from: a */
    private static int m21879a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    /* renamed from: a */
    public C5205e m21887a(C6851a c6851a) {
        this.f17460f = c6851a;
        boolean[] c = m21886c(m21884a(c6851a.m22033d()));
        C5205e c5205e = new C5205e(C5184a.m21883a(c), C5184a.m21885b(c), null, null);
        c5205e.m22020a(c.length);
        return c5205e;
    }

    /* renamed from: b */
    private static String m21885b(boolean[] zArr) {
        int length = zArr.length;
        C5183a c5183a = C5183a.UPPER;
        C5183a c5183a2 = C5183a.UPPER;
        StringBuilder stringBuilder = new StringBuilder(20);
        C5183a c5183a3 = c5183a;
        int i = 0;
        while (i < length) {
            int i2;
            if (c5183a2 == C5183a.BINARY) {
                if (length - i < 5) {
                    break;
                }
                int a = C5184a.m21880a(zArr, i, 5);
                i += 5;
                if (a == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    a = C5184a.m21880a(zArr, i, 11) + 31;
                    i += 11;
                }
                i2 = i;
                for (i = 0; i < a; i++) {
                    if (length - i2 < 8) {
                        i = length;
                        break;
                    }
                    stringBuilder.append((char) C5184a.m21880a(zArr, i2, 8));
                    i2 += 8;
                }
                i = i2;
            } else {
                i2 = c5183a2 == C5183a.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int a2 = C5184a.m21880a(zArr, i, i2);
                i += i2;
                String a3 = C5184a.m21882a(c5183a2, a2);
                if (a3.startsWith("CTRL_")) {
                    c5183a3 = C5184a.m21881a(a3.charAt(5));
                    if (a3.charAt(6) != 'L') {
                        C5183a c5183a4 = c5183a3;
                        c5183a3 = c5183a2;
                        c5183a2 = c5183a4;
                    }
                } else {
                    stringBuilder.append(a3);
                }
            }
            c5183a2 = c5183a3;
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static C5183a m21881a(char c) {
        if (c == 'B') {
            return C5183a.BINARY;
        }
        if (c == 'D') {
            return C5183a.DIGIT;
        }
        if (c == 'P') {
            return C5183a.PUNCT;
        }
        switch (c) {
            case 'L':
                return C5183a.LOWER;
            case 'M':
                return C5183a.MIXED;
            default:
                return C5183a.UPPER;
        }
    }

    /* renamed from: a */
    private static String m21882a(C5183a c5183a, int i) {
        switch (c5183a) {
            case UPPER:
                return f17455a[i];
            case LOWER:
                return f17456b[i];
            case MIXED:
                return f17457c[i];
            case PUNCT:
                return f17458d[i];
            case DIGIT:
                return f17459e[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    /* renamed from: c */
    private boolean[] m21886c(boolean[] zArr) {
        C5197a c5197a;
        int i = 8;
        if (this.f17460f.m32233a() <= 2) {
            i = 6;
            c5197a = C5197a.f17518c;
        } else if (this.f17460f.m32233a() <= 8) {
            c5197a = C5197a.f17522g;
        } else if (this.f17460f.m32233a() <= 22) {
            i = 10;
            c5197a = C5197a.f17517b;
        } else {
            i = 12;
            c5197a = C5197a.f17516a;
        }
        int b = this.f17460f.m32234b();
        int length = zArr.length / i;
        if (length >= b) {
            int[] iArr = new int[length];
            int length2 = zArr.length % i;
            int i2 = 0;
            while (i2 < length) {
                iArr[i2] = C5184a.m21880a(zArr, length2, i);
                i2++;
                length2 += i;
            }
            try {
                new C5199c(c5197a).m21994a(iArr, length - b);
                int i3 = (1 << i) - 1;
                i2 = 0;
                for (length = 0; length < b; length++) {
                    length2 = iArr[length];
                    if (length2 == 0 || length2 == i3) {
                        throw C6891h.m32342a();
                    }
                    if (length2 == 1 || length2 == i3 - 1) {
                        i2++;
                    }
                }
                boolean[] zArr2 = new boolean[((b * i) - i2)];
                length2 = 0;
                for (i2 = 0; i2 < b; i2++) {
                    int i4 = iArr[i2];
                    if (i4 != 1) {
                        if (i4 != i3 - 1) {
                            int i5 = i - 1;
                            while (i5 >= 0) {
                                int i6 = length2 + 1;
                                zArr2[length2] = ((1 << i5) & i4) != 0;
                                i5--;
                                length2 = i6;
                            }
                        }
                    }
                    Arrays.fill(zArr2, length2, (length2 + i) - 1, i4 > 1);
                    length2 += i - 1;
                }
                return zArr2;
            } catch (boolean[] zArr3) {
                throw C6891h.m32343a(zArr3);
            }
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    private boolean[] m21884a(C5202b c5202b) {
        int i;
        int i2;
        int i3;
        C5202b c5202b2 = c5202b;
        boolean c = this.f17460f.m32235c();
        int a = this.f17460f.m32233a();
        int i4 = (c ? 11 : 14) + (a << 2);
        int[] iArr = new int[i4];
        boolean[] zArr = new boolean[C5184a.m21879a(a, c)];
        int i5 = 2;
        if (c) {
            for (i = 0; i < iArr.length; i++) {
                iArr[i] = i;
            }
        } else {
            i2 = i4 / 2;
            i = ((i4 + 1) + (((i2 - 1) / 15) * 2)) / 2;
            for (i3 = 0; i3 < i2; i3++) {
                int i6 = (i3 / 15) + i3;
                iArr[(i2 - i3) - 1] = (i - i6) - 1;
                iArr[i2 + i3] = (i6 + i) + 1;
            }
        }
        i = 0;
        i2 = 0;
        while (i < a) {
            boolean z;
            int i7;
            C5184a c5184a;
            i3 = ((a - i) << i5) + (c ? 9 : 12);
            i6 = i << 1;
            int i8 = (i4 - 1) - i6;
            int i9 = 0;
            while (i9 < i3) {
                int i10 = i9 << 1;
                int i11 = 0;
                for (i5 = 
/*
Method generation error in method: com.google.b.a.a.a.a(com.google.b.b.b):boolean[], dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r8_2 'i5' int) = (r8_1 'i5' int), (r8_8 'i5' int) binds: {(r8_8 'i5' int)=B:24:0x00c1, (r8_1 'i5' int)=B:19:0x0062} in method: com.google.b.a.a.a.a(com.google.b.b.b):boolean[], dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 26 more

*/

                /* renamed from: a */
                private static int m21880a(boolean[] zArr, int i, int i2) {
                    int i3 = 0;
                    for (int i4 = i; i4 < i + i2; i4++) {
                        i3 <<= 1;
                        if (zArr[i4]) {
                            i3 |= 1;
                        }
                    }
                    return i3;
                }

                /* renamed from: a */
                private static byte m21878a(boolean[] zArr, int i) {
                    int length = zArr.length - i;
                    if (length >= 8) {
                        return (byte) C5184a.m21880a(zArr, i, 8);
                    }
                    return (byte) (C5184a.m21880a(zArr, i, length) << (8 - length));
                }

                /* renamed from: a */
                static byte[] m21883a(boolean[] zArr) {
                    byte[] bArr = new byte[((zArr.length + 7) / 8)];
                    for (int i = 0; i < bArr.length; i++) {
                        bArr[i] = C5184a.m21878a(zArr, i << 3);
                    }
                    return bArr;
                }
            }
