package org.spongycastle.pqc.crypto.gmss.util;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.Digest;

public class WinternitzOTSVerify {
    /* renamed from: a */
    private Digest f23244a;
    /* renamed from: b */
    private int f23245b;

    /* renamed from: a */
    public int m29083a(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public WinternitzOTSVerify(Digest digest, int i) {
        this.f23245b = i;
        this.f23244a = digest;
    }

    /* renamed from: a */
    public int m29082a() {
        int b = this.f23244a.mo5732b();
        int i = ((b << 3) + (this.f23245b - 1)) / this.f23245b;
        return b * (i + (((m29083a((i << this.f23245b) + 1) + this.f23245b) - 1) / this.f23245b));
    }

    /* renamed from: a */
    public byte[] m29084a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        Object obj = bArr2;
        int b = this.f23244a.mo5732b();
        byte[] bArr4 = new byte[b];
        this.f23244a.mo5731a(bArr3, 0, bArr3.length);
        bArr3 = new byte[this.f23244a.mo5732b()];
        this.f23244a.mo5728a(bArr3, 0);
        int i = b << 3;
        int i2 = ((this.f23245b - 1) + i) / this.f23245b;
        int a = m29083a((i2 << this.f23245b) + 1);
        int i3 = ((((this.f23245b + a) - 1) / this.f23245b) + i2) * b;
        if (i3 != obj.length) {
            return null;
        }
        Object obj2;
        Object obj3 = new byte[i3];
        int i4 = 8;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if (8 % r0.f23245b == 0) {
            i4 = 8 / r0.f23245b;
            i = (1 << r0.f23245b) - 1;
            obj2 = new byte[b];
            i5 = 0;
            int i12 = 0;
            i6 = 0;
            while (i5 < bArr3.length) {
                Object obj4 = obj2;
                int i13 = i6;
                i6 = i12;
                i12 = 0;
                while (i12 < i4) {
                    i7 = bArr3[i5] & i;
                    i6 += i7;
                    i8 = i4;
                    i4 = i13 * b;
                    System.arraycopy(obj, i4, obj4, 0, b);
                    while (i7 < i) {
                        i9 = i6;
                        r0.f23244a.mo5731a(obj4, 0, obj4.length);
                        obj4 = new byte[r0.f23244a.mo5732b()];
                        r0.f23244a.mo5728a(obj4, 0);
                        i7++;
                        i6 = i9;
                        byte[] bArr5 = bArr2;
                    }
                    i9 = i6;
                    System.arraycopy(obj4, 0, obj3, i4, b);
                    bArr3[i5] = (byte) (bArr3[i5] >>> r0.f23245b);
                    i13++;
                    i12++;
                    i4 = i8;
                    obj = bArr2;
                }
                i8 = i4;
                i5++;
                i12 = i6;
                i6 = i13;
                obj2 = obj4;
                obj = bArr2;
            }
            i10 = (i2 << r0.f23245b) - i12;
            for (i11 = 0; i11 < a; i11 += r0.f23245b) {
                i5 = i6 * b;
                System.arraycopy(bArr2, i5, obj2, 0, b);
                for (i2 = i10 & i; i2 < i; i2++) {
                    r0.f23244a.mo5731a(obj2, 0, obj2.length);
                    obj2 = new byte[r0.f23244a.mo5732b()];
                    r0.f23244a.mo5728a(obj2, 0);
                }
                System.arraycopy(obj2, 0, obj3, i5, b);
                i10 >>>= r0.f23245b;
                i6++;
            }
        } else {
            Object obj5 = obj;
            long j;
            if (r0.f23245b < 8) {
                int i14;
                i10 = b / r0.f23245b;
                i = (1 << r0.f23245b) - 1;
                Object obj6 = new byte[b];
                int i15 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                while (i15 < i10) {
                    int i16 = i7;
                    long j2 = 0;
                    for (i7 = 0; i7 < r0.f23245b; i7++) {
                        j2 ^= (long) ((bArr3[i16] & JfifUtil.MARKER_FIRST_BYTE) << (i7 << 3));
                        i16++;
                    }
                    obj2 = obj6;
                    i6 = 0;
                    for (i4 = 
/*
Method generation error in method: org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSVerify.a(byte[], byte[]):byte[], dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r11_11 'i4' int) = (r11_0 'i4' int), (r11_19 'i4' int) binds: {(r11_19 'i4' int)=B:36:0x0153, (r11_0 'i4' int)=B:24:0x00e9} in method: org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSVerify.a(byte[], byte[]):byte[], dex: classes2.dex
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
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:128)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
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
	... 35 more

*/
                }
