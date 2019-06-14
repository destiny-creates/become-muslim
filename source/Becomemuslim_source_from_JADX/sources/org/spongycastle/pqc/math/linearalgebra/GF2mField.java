package org.spongycastle.pqc.math.linearalgebra;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.util.ByteConstants;
import java.security.SecureRandom;

public class GF2mField {
    /* renamed from: a */
    private int f23372a = 0;
    /* renamed from: b */
    private int f23373b;

    /* renamed from: a */
    public int m29214a(int i, int i2) {
        return i ^ i2;
    }

    public GF2mField(int i, int i2) {
        if (i != PolynomialRingGF2.m29282a(i2)) {
            throw new IllegalArgumentException(" Error: the degree is not correct");
        } else if (PolynomialRingGF2.m29286b(i2)) {
            this.f23372a = i;
            this.f23373b = i2;
        } else {
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        }
    }

    /* renamed from: a */
    public int m29212a() {
        return this.f23372a;
    }

    /* renamed from: b */
    public byte[] m29219b() {
        return LittleEndianConversions.m29241a(this.f23373b);
    }

    /* renamed from: b */
    public int m29217b(int i, int i2) {
        return PolynomialRingGF2.m29284a(i, i2, this.f23373b);
    }

    /* renamed from: c */
    public int m29220c(int i, int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i2 < 0) {
            i = m29213a(i);
            i2 = -i2;
        }
        int i3 = i;
        i = 1;
        for (i2 = 
/*
Method generation error in method: org.spongycastle.pqc.math.linearalgebra.GF2mField.c(int, int):int, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r5_2 'i2' int) = (r5_0 'i2' int), (r5_1 'i2' int) binds: {(r5_0 'i2' int)=B:8:0x000b, (r5_1 'i2' int)=B:9:0x000d} in method: org.spongycastle.pqc.math.linearalgebra.GF2mField.c(int, int):int, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
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
	... 28 more

*/

        /* renamed from: a */
        public int m29213a(int i) {
            return m29220c(i, (1 << this.f23372a) - 2);
        }

        /* renamed from: b */
        public int m29216b(int i) {
            for (int i2 = 1; i2 < this.f23372a; i2++) {
                i = m29217b(i, i);
            }
            return i;
        }

        /* renamed from: a */
        public int m29215a(SecureRandom secureRandom) {
            return RandUtils.m29292a(secureRandom, 1 << this.f23372a);
        }

        /* renamed from: b */
        public int m29218b(SecureRandom secureRandom) {
            int a = RandUtils.m29292a(secureRandom, 1 << this.f23372a);
            int i = 0;
            while (a == 0 && i < ByteConstants.MB) {
                a = RandUtils.m29292a(secureRandom, 1 << this.f23372a);
                i++;
            }
            return i == ByteConstants.MB ? 1 : a;
        }

        /* renamed from: c */
        public boolean m29221c(int i) {
            boolean z = false;
            if (this.f23372a == 31) {
                if (i >= 0) {
                    z = true;
                }
                return z;
            }
            if (i >= 0 && i < (1 << this.f23372a)) {
                z = true;
            }
            return z;
        }

        /* renamed from: d */
        public String m29222d(int i) {
            String str = "";
            for (int i2 = 0; i2 < this.f23372a; i2++) {
                StringBuilder stringBuilder;
                if ((((byte) i) & 1) == 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                }
                i >>>= 1;
            }
            return str;
        }

        public boolean equals(Object obj) {
            if (obj != null) {
                if (obj instanceof GF2mField) {
                    GF2mField gF2mField = (GF2mField) obj;
                    if (this.f23372a == gF2mField.f23372a && this.f23373b == gF2mField.f23373b) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f23373b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Finite Field GF(2^");
            stringBuilder.append(this.f23372a);
            stringBuilder.append(") = ");
            stringBuilder.append("GF(2)[X]/<");
            stringBuilder.append(m29211e(this.f23373b));
            stringBuilder.append("> ");
            return stringBuilder.toString();
        }

        /* renamed from: e */
        private static String m29211e(int i) {
            String str = "";
            if (i == 0) {
                return AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (((byte) (i & 1)) == (byte) 1) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
            i >>>= 1;
            int i2 = 1;
            while (i != 0) {
                if (((byte) (i & 1)) == (byte) 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("+x^");
                    stringBuilder.append(i2);
                    str = stringBuilder.toString();
                }
                i >>>= 1;
                i2++;
            }
            return str;
        }
    }
