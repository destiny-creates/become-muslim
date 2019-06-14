package org.spongycastle.crypto.tls;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class TlsBlockCipher implements TlsCipher {
    /* renamed from: a */
    protected TlsContext f27326a;
    /* renamed from: b */
    protected byte[] f27327b = new byte[256];
    /* renamed from: c */
    protected boolean f27328c;
    /* renamed from: d */
    protected boolean f27329d;
    /* renamed from: e */
    protected BlockCipher f27330e;
    /* renamed from: f */
    protected BlockCipher f27331f;
    /* renamed from: g */
    protected TlsMac f27332g;
    /* renamed from: h */
    protected TlsMac f27333h;

    /* renamed from: a */
    protected int m35896a(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }

    public TlsBlockCipher(TlsContext tlsContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int i) {
        byte[] bArr;
        TlsContext tlsContext2 = tlsContext;
        BlockCipher blockCipher3 = blockCipher;
        BlockCipher blockCipher4 = blockCipher2;
        int i2 = i;
        this.f27326a = tlsContext2;
        tlsContext.mo5808a().mo5791b(this.f27327b);
        this.f27328c = TlsUtils.m27847b(tlsContext);
        this.f27329d = tlsContext.mo5810c().f22552n;
        int b = ((i2 * 2) + digest.mo5732b()) + digest2.mo5732b();
        if (!this.f27328c) {
            b += blockCipher.mo5743b() + blockCipher2.mo5743b();
        }
        int i3 = b;
        byte[] a = TlsUtils.m27828a(tlsContext2, i3);
        TlsContext tlsContext3 = tlsContext;
        byte[] bArr2 = a;
        TlsMac tlsMac = new TlsMac(tlsContext3, digest, bArr2, 0, digest.mo5732b());
        int b2 = digest.mo5732b() + 0;
        TlsMac tlsMac2 = tlsMac;
        tlsMac = new TlsMac(tlsContext3, digest2, bArr2, b2, digest2.mo5732b());
        b2 += digest2.mo5732b();
        CipherParameters keyParameter = new KeyParameter(a, b2, i2);
        b2 += i2;
        CipherParameters keyParameter2 = new KeyParameter(a, b2, i2);
        b2 += i2;
        if (r0.f27328c) {
            bArr = new byte[blockCipher.mo5743b()];
            bArr2 = new byte[blockCipher2.mo5743b()];
        } else {
            bArr = Arrays.m29361a(a, b2, blockCipher.mo5743b() + b2);
            b2 += blockCipher.mo5743b();
            bArr2 = Arrays.m29361a(a, b2, blockCipher2.mo5743b() + b2);
            b2 += blockCipher2.mo5743b();
        }
        if (b2 == i3) {
            CipherParameters parametersWithIV;
            if (tlsContext.mo6487f()) {
                r0.f27332g = tlsMac2;
                r0.f27333h = tlsMac;
                r0.f27330e = blockCipher4;
                r0.f27331f = blockCipher3;
                parametersWithIV = new ParametersWithIV(keyParameter2, bArr2);
                keyParameter = new ParametersWithIV(keyParameter, bArr);
            } else {
                r0.f27332g = tlsMac;
                r0.f27333h = tlsMac2;
                r0.f27330e = blockCipher3;
                r0.f27331f = blockCipher4;
                parametersWithIV = new ParametersWithIV(keyParameter, bArr);
                keyParameter = new ParametersWithIV(keyParameter2, bArr2);
            }
            r0.f27330e.mo5742a(true, parametersWithIV);
            r0.f27331f.mo5742a(false, keyParameter);
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public byte[] mo5831a(long j, short s, byte[] bArr, int i, int i2) {
        Object obj;
        int i3;
        int i4;
        int i5 = i2;
        int b = this.f27330e.mo5743b();
        int a = this.f27332g.m27715a();
        ProtocolVersion e = this.f27326a.mo5812e();
        int i6 = (b - 1) - ((!this.f27329d ? i5 + a : i5) % b);
        if (!(e.m27571c() || e.m27573d())) {
            i6 += m35897a(r0.f27326a.mo5809b(), (255 - i6) / b) * b;
        }
        int i7 = i6;
        a = ((a + i5) + i7) + 1;
        if (r0.f27328c) {
            a += b;
        }
        Object obj2 = new byte[a];
        if (r0.f27328c) {
            Object obj3 = new byte[b];
            r0.f27326a.mo5808a().mo5791b(obj3);
            r0.f27330e.mo5742a(true, new ParametersWithIV(null, obj3));
            System.arraycopy(obj3, 0, obj2, 0, b);
            obj = bArr;
            i3 = i;
            i4 = b + 0;
        } else {
            obj = bArr;
            i3 = i;
            i4 = 0;
        }
        System.arraycopy(obj, i3, obj2, i4, i5);
        int i8 = i4 + i5;
        if (!r0.f27329d) {
            obj3 = r0.f27332g.m27717a(j, s, bArr, i, i2);
            System.arraycopy(obj3, 0, obj2, i8, obj3.length);
            i8 += obj3.length;
        }
        int i9 = i8;
        a = 0;
        while (a <= i7) {
            int i10 = i9 + 1;
            obj2[i9] = (byte) i7;
            a++;
            i9 = i10;
        }
        while (i4 < i9) {
            r0.f27330e.mo5740a(obj2, i4, obj2, i4);
            i4 += b;
        }
        if (!r0.f27329d) {
            return obj2;
        }
        Object obj4 = obj2;
        obj3 = r0.f27332g.m27717a(j, s, obj2, 0, i9);
        System.arraycopy(obj3, 0, obj4, i9, obj3.length);
        a = obj3.length;
        return obj4;
    }

    /* renamed from: b */
    public byte[] mo5832b(long j, short s, byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        int b = this.f27331f.mo5743b();
        int a = this.f27333h.m27715a();
        if (this.f27329d) {
            i3 = b + a;
        } else {
            i3 = Math.max(b, a + 1);
        }
        if (r6.f27328c) {
            i3 += b;
        }
        if (i5 >= i3) {
            i3 = r6.f27329d ? i5 - a : i5;
            if (i3 % b == 0) {
                int i6;
                byte[] bArr3;
                if (r6.f27329d) {
                    int i7 = i4 + i5;
                    if ((Arrays.m29372b(r6.f27333h.m27717a(j, s, bArr, i, i5 - a), Arrays.m29361a(bArr2, i7 - a, i7)) ^ 1) != 0) {
                        throw new TlsFatalAlert((short) 20);
                    }
                }
                if (r6.f27328c) {
                    r6.f27331f.mo5742a(false, new ParametersWithIV(null, bArr2, i4, b));
                    i4 += b;
                    i3 -= b;
                }
                int i8 = i4;
                int i9 = i3;
                for (i4 = 0; i4 < i9; i4 += b) {
                    i3 = i8 + i4;
                    r6.f27331f.mo5740a(bArr2, i3, bArr2, i3);
                }
                i4 = m35898a(bArr, i8, i9, b, r6.f27329d ? 0 : a);
                i5 = i4 == 0 ? 1 : 0;
                i4 = i9 - i4;
                if (r6.f27329d) {
                    i6 = i8;
                    bArr3 = bArr2;
                } else {
                    i4 -= a;
                    i3 = i8 + i4;
                    i6 = i8;
                    bArr3 = bArr2;
                    i5 |= Arrays.m29372b(r6.f27333h.m27718a(j, s, bArr, i8, i4, i9 - a, r6.f27327b), Arrays.m29361a(bArr2, i3, i3 + a)) ^ 1;
                }
                if (i5 == 0) {
                    return Arrays.m29361a(bArr3, i6, i6 + i4);
                }
                throw new TlsFatalAlert((short) 20);
            }
            throw new TlsFatalAlert((short) 21);
        }
        throw new TlsFatalAlert((short) 50);
    }

    /* renamed from: a */
    protected int m35898a(byte[] bArr, int i, int i2, int i3, int i4) {
        i += i2;
        byte b = bArr[i - 1];
        int i5 = (b & JfifUtil.MARKER_FIRST_BYTE) + 1;
        if ((!TlsUtils.m27825a(this.f27326a) || i5 <= i3) && i4 + i5 <= i2) {
            i3 = i - i5;
            i2 = 0;
            while (true) {
                i4 = i3 + 1;
                i2 = (byte) (i2 | (bArr[i3] ^ b));
                if (i4 >= i) {
                    break;
                }
                i3 = i4;
            }
            bArr = i2 != 0 ? null : i5;
        } else {
            bArr = null;
            i2 = 0;
            i5 = 0;
        }
        i = this.f27327b;
        for (i5 = 
/*
Method generation error in method: org.spongycastle.crypto.tls.TlsBlockCipher.a(byte[], int, int, int, int):int, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_3 'i5' int) = (r1_1 'i5' int), (r1_1 'i5' int), (r1_2 'i5' int) binds: {(r1_1 'i5' int)=B:10:0x002a, (r1_1 'i5' int)=B:11:0x002c, (r1_2 'i5' int)=B:5:0x0017} in method: org.spongycastle.crypto.tls.TlsBlockCipher.a(byte[], int, int, int, int):int, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
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
	... 16 more

*/

        /* renamed from: a */
        protected int m35897a(SecureRandom secureRandom, int i) {
            return Math.min(m35896a(secureRandom.nextInt()), i);
        }
    }
