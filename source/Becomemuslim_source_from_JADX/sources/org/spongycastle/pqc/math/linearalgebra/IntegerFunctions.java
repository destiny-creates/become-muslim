package org.spongycastle.pqc.math.linearalgebra;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class IntegerFunctions {
    /* renamed from: a */
    private static final BigInteger f23381a = BigInteger.valueOf(0);
    /* renamed from: b */
    private static final BigInteger f23382b = BigInteger.valueOf(1);
    /* renamed from: c */
    private static final BigInteger f23383c = BigInteger.valueOf(2);
    /* renamed from: d */
    private static final BigInteger f23384d = BigInteger.valueOf(4);
    /* renamed from: e */
    private static final int[] f23385e = new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
    /* renamed from: f */
    private static SecureRandom f23386f = null;
    /* renamed from: g */
    private static final int[] f23387g = new int[]{0, 1, 0, -1, 0, -1, 0, 1};

    /* renamed from: a */
    public static int m29235a(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            i = -i;
        }
        int i2 = 0;
        for (i = 
/*
Method generation error in method: org.spongycastle.pqc.math.linearalgebra.IntegerFunctions.a(int):int, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_3 'i' int) = (r1_0 'i' int), (r1_2 'i' int) binds: {(r1_2 'i' int)=B:4:0x0006, (r1_0 'i' int)=B:3:0x0004} in method: org.spongycastle.pqc.math.linearalgebra.IntegerFunctions.a(int):int, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
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
	... 20 more

*/

        private IntegerFunctions() {
        }

        /* renamed from: a */
        public static BigInteger m29236a(int i, int i2) {
            BigInteger bigInteger = f23382b;
            if (i != 0) {
                if (i2 > (i >>> 1)) {
                    i2 = i - i2;
                }
                for (int i3 = 1; i3 <= i2; i3++) {
                    bigInteger = bigInteger.multiply(BigInteger.valueOf((long) (i - (i3 - 1)))).divide(BigInteger.valueOf((long) i3));
                }
                return bigInteger;
            } else if (i2 == 0) {
                return bigInteger;
            } else {
                return f23381a;
            }
        }
    }
