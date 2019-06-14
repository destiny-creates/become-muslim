package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSignature;

public class GMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private GMSSRandom f27652a;
    /* renamed from: b */
    private byte[][] f27653b;
    /* renamed from: c */
    private byte[][] f27654c;
    /* renamed from: d */
    private byte[][] f27655d;
    /* renamed from: e */
    private GMSSDigestProvider f27656e;
    /* renamed from: f */
    private int f27657f;
    /* renamed from: g */
    private int f27658g;
    /* renamed from: h */
    private boolean f27659h;
    /* renamed from: i */
    private GMSSParameters f27660i;
    /* renamed from: j */
    private int[] f27661j;
    /* renamed from: k */
    private int[] f27662k;
    /* renamed from: l */
    private int[] f27663l;
    /* renamed from: m */
    private GMSSKeyGenerationParameters f27664m;

    /* renamed from: b */
    private AsymmetricCipherKeyPair m36329b() {
        int i;
        byte[][] bArr;
        Vector[] vectorArr;
        byte[][][] bArr2;
        Vector[][] vectorArr2;
        if (!this.f27659h) {
            m36330c();
        }
        byte[][][] bArr3 = new byte[r1.f27658g][][];
        byte[][][] bArr4 = new byte[(r1.f27658g - 1)][][];
        Treehash[][] treehashArr = new Treehash[r1.f27658g][];
        Treehash[][] treehashArr2 = new Treehash[(r1.f27658g - 1)][];
        Vector[] vectorArr3 = new Vector[r1.f27658g];
        Vector[] vectorArr4 = new Vector[(r1.f27658g - 1)];
        Vector[][] vectorArr5 = new Vector[r1.f27658g][];
        Vector[][] vectorArr6 = new Vector[(r1.f27658g - 1)][];
        for (i = 0; i < r1.f27658g; i++) {
            bArr3[i] = (byte[][]) Array.newInstance(byte.class, new int[]{r1.f27661j[i], r1.f27657f});
            treehashArr[i] = new Treehash[(r1.f27661j[i] - r1.f27663l[i])];
            if (i > 0) {
                int i2 = i - 1;
                bArr4[i2] = (byte[][]) Array.newInstance(byte.class, new int[]{r1.f27661j[i], r1.f27657f});
                treehashArr2[i2] = new Treehash[(r1.f27661j[i] - r1.f27663l[i])];
            }
            vectorArr3[i] = new Vector();
            if (i > 0) {
                vectorArr4[i - 1] = new Vector();
            }
        }
        byte[][] bArr5 = (byte[][]) Array.newInstance(byte.class, new int[]{r1.f27658g, r1.f27657f});
        byte[][] bArr6 = (byte[][]) Array.newInstance(byte.class, new int[]{r1.f27658g - 1, r1.f27657f});
        byte[][] bArr7 = (byte[][]) Array.newInstance(byte.class, new int[]{r1.f27658g, r1.f27657f});
        i = 0;
        while (i < r1.f27658g) {
            bArr = bArr6;
            System.arraycopy(r1.f27653b[i], 0, bArr7[i], 0, r1.f27657f);
            i++;
            bArr6 = bArr;
        }
        bArr = bArr6;
        r1.f27655d = (byte[][]) Array.newInstance(byte.class, new int[]{r1.f27658g - 1, r1.f27657f});
        int i3 = r1.f27658g - 1;
        while (i3 >= 0) {
            GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(r1.f27661j[i3], r1.f27663l[i3], r1.f27656e);
            try {
                GMSSRootCalc a;
                if (i3 == r1.f27658g - 1) {
                    a = m36328a(null, vectorArr3[i3], bArr7[i3], i3);
                } else {
                    a = m36328a(bArr5[i3 + 1], vectorArr3[i3], bArr7[i3], i3);
                }
                gMSSRootCalc = a;
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = 0;
            while (i < r1.f27661j[i3]) {
                vectorArr = vectorArr3;
                bArr2 = bArr3;
                System.arraycopy(gMSSRootCalc.m29057b()[i], 0, bArr3[i3][i], 0, r1.f27657f);
                i++;
                vectorArr3 = vectorArr;
                bArr3 = bArr2;
            }
            bArr2 = bArr3;
            vectorArr = vectorArr3;
            vectorArr5[i3] = gMSSRootCalc.m29059d();
            treehashArr[i3] = gMSSRootCalc.m29058c();
            System.arraycopy(gMSSRootCalc.m29060e(), 0, bArr5[i3], 0, r1.f27657f);
            i3--;
            vectorArr3 = vectorArr;
            bArr3 = bArr2;
        }
        bArr2 = bArr3;
        vectorArr = vectorArr3;
        i = r1.f27658g - 2;
        while (i >= 0) {
            int i4 = i + 1;
            GMSSRootCalc a2 = m36327a(vectorArr4[i], bArr7[i4], i4);
            int i5 = 0;
            while (i5 < r1.f27661j[i4]) {
                vectorArr2 = vectorArr5;
                System.arraycopy(a2.m29057b()[i5], 0, bArr4[i][i5], 0, r1.f27657f);
                i5++;
                vectorArr5 = vectorArr2;
            }
            vectorArr2 = vectorArr5;
            vectorArr6[i] = a2.m29059d();
            treehashArr2[i] = a2.m29058c();
            System.arraycopy(a2.m29060e(), 0, bArr[i], 0, r1.f27657f);
            System.arraycopy(bArr7[i4], 0, r1.f27654c[i], 0, r1.f27657f);
            i--;
            vectorArr5 = vectorArr2;
        }
        vectorArr2 = vectorArr5;
        AsymmetricKeyParameter gMSSPublicKeyParameters = new GMSSPublicKeyParameters(bArr5[0], r1.f27660i);
        bArr5 = r1.f27653b;
        bArr7 = r1.f27654c;
        byte[][] bArr8 = r1.f27655d;
        GMSSParameters gMSSParameters = r1.f27660i;
        GMSSDigestProvider gMSSDigestProvider = r1.f27656e;
        AsymmetricKeyParameter asymmetricKeyParameter = r2;
        AsymmetricKeyParameter gMSSPrivateKeyParameters = new GMSSPrivateKeyParameters(bArr5, bArr7, bArr2, bArr4, treehashArr, treehashArr2, vectorArr, vectorArr4, vectorArr2, vectorArr6, bArr, bArr8, gMSSParameters, gMSSDigestProvider);
        return new AsymmetricCipherKeyPair(gMSSPublicKeyParameters, asymmetricKeyParameter);
    }

    /* renamed from: a */
    private GMSSRootCalc m36328a(byte[] bArr, Vector vector, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[this.f27657f];
        bArr3 = new byte[this.f27657f];
        bArr3 = this.f27652a.m29078a(bArr2);
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.f27661j[i], this.f27663l[i], this.f27656e);
        gMSSRootCalc.m29053a(vector);
        if (i == this.f27658g - 1) {
            bArr = new WinternitzOTSignature(bArr3, this.f27656e.m29043a(), this.f27662k[i]).m29086a();
        } else {
            this.f27655d[i] = new WinternitzOTSignature(bArr3, this.f27656e.m29043a(), this.f27662k[i]).m29087a(bArr);
            bArr = new WinternitzOTSVerify(this.f27656e.m29043a(), this.f27662k[i]).m29084a(bArr, this.f27655d[i]);
        }
        gMSSRootCalc.m29054a(bArr);
        vector = 3;
        int i2 = 0;
        for (bArr = 1; bArr < (1 << this.f27661j[i]); bArr++) {
            if (bArr == vector && i2 < this.f27661j[i] - this.f27663l[i]) {
                gMSSRootCalc.m29055a(bArr2, i2);
                vector *= 2;
                i2++;
            }
            gMSSRootCalc.m29054a(new WinternitzOTSignature(this.f27652a.m29078a(bArr2), this.f27656e.m29043a(), this.f27662k[i]).m29086a());
        }
        if (gMSSRootCalc.m29056a() != null) {
            return gMSSRootCalc;
        }
        System.err.println("Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    /* renamed from: a */
    private GMSSRootCalc m36327a(Vector vector, byte[] bArr, int i) {
        byte[] bArr2 = new byte[this.f27658g];
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.f27661j[i], this.f27663l[i], this.f27656e);
        gMSSRootCalc.m29053a(vector);
        int i2 = 3;
        int i3 = 0;
        for (vector = null; vector < (1 << this.f27661j[i]); vector++) {
            if (vector == i2 && i3 < this.f27661j[i] - this.f27663l[i]) {
                gMSSRootCalc.m29055a(bArr, i3);
                i2 *= 2;
                i3++;
            }
            gMSSRootCalc.m29054a(new WinternitzOTSignature(this.f27652a.m29078a(bArr), this.f27656e.m29043a(), this.f27662k[i]).m29086a());
        }
        if (gMSSRootCalc.m29056a() != null) {
            return gMSSRootCalc;
        }
        System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    /* renamed from: a */
    public void m36332a(KeyGenerationParameters keyGenerationParameters) {
        this.f27664m = (GMSSKeyGenerationParameters) keyGenerationParameters;
        this.f27660i = new GMSSParameters(this.f27664m.m36326c().m29049a(), this.f27664m.m36326c().m29050b(), this.f27664m.m36326c().m29051c(), this.f27664m.m36326c().m29052d());
        this.f27658g = this.f27660i.m29049a();
        this.f27661j = this.f27660i.m29050b();
        this.f27662k = this.f27660i.m29051c();
        this.f27663l = this.f27660i.m29052d();
        this.f27653b = (byte[][]) Array.newInstance(byte.class, new int[]{this.f27658g, this.f27657f});
        this.f27654c = (byte[][]) Array.newInstance(byte.class, new int[]{this.f27658g - 1, this.f27657f});
        keyGenerationParameters = new SecureRandom();
        for (int i = 0; i < this.f27658g; i++) {
            keyGenerationParameters.nextBytes(this.f27653b[i]);
            this.f27652a.m29078a(this.f27653b[i]);
        }
        this.f27659h = true;
    }

    /* renamed from: c */
    private void m36330c() {
        int[] iArr = new int[]{10, 10, 10, 10};
        m36332a(new GMSSKeyGenerationParameters(new SecureRandom(), new GMSSParameters(iArr.length, iArr, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2})));
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        return m36329b();
    }
}
