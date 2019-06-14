package org.spongycastle.crypto.generators;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAValidationParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.encoders.Hex;

public class DSAParametersGenerator {
    /* renamed from: a */
    private static final BigInteger f22359a = BigInteger.valueOf(0);
    /* renamed from: b */
    private static final BigInteger f22360b = BigInteger.valueOf(1);
    /* renamed from: c */
    private static final BigInteger f22361c = BigInteger.valueOf(2);
    /* renamed from: d */
    private Digest f22362d;
    /* renamed from: e */
    private int f22363e;
    /* renamed from: f */
    private int f22364f;
    /* renamed from: g */
    private int f22365g;
    /* renamed from: h */
    private int f22366h;
    /* renamed from: i */
    private SecureRandom f22367i;
    /* renamed from: j */
    private boolean f22368j;
    /* renamed from: k */
    private int f22369k;

    /* renamed from: a */
    private static int m27439a(int i) {
        return i > 1024 ? 256 : 160;
    }

    public DSAParametersGenerator() {
        this(new SHA1Digest());
    }

    public DSAParametersGenerator(Digest digest) {
        this.f22362d = digest;
    }

    /* renamed from: a */
    public void m27450a(int i, int i2, SecureRandom secureRandom) {
        this.f22363e = i;
        this.f22364f = m27439a(i);
        this.f22365g = i2;
        this.f22366h = Math.max(m27445b(this.f22363e), (i2 + 1) / 2);
        this.f22367i = secureRandom;
        this.f22368j = false;
        this.f22369k = -1;
    }

    /* renamed from: a */
    public void m27451a(DSAParameterGenerationParameters dSAParameterGenerationParameters) {
        int a = dSAParameterGenerationParameters.m27495a();
        int b = dSAParameterGenerationParameters.m27496b();
        if (a < 1024 || a > 3072 || a % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        }
        if (a == 1024) {
            if (b != 160) {
                throw new IllegalArgumentException("N must be 160 for L = 1024");
            }
        }
        if (a == 2048 && b != 224) {
            if (b != 256) {
                throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
            }
        }
        if (a == 3072) {
            if (b != 256) {
                throw new IllegalArgumentException("N must be 256 for L = 3072");
            }
        }
        if (this.f22362d.mo5732b() * 8 >= b) {
            this.f22363e = a;
            this.f22364f = b;
            this.f22365g = dSAParameterGenerationParameters.m27497c();
            this.f22366h = Math.max(m27445b(a), (this.f22365g + 1) / 2);
            this.f22367i = dSAParameterGenerationParameters.m27498d();
            this.f22368j = true;
            this.f22369k = dSAParameterGenerationParameters.m27499e();
            return;
        }
        throw new IllegalStateException("Digest output size too small for value of N");
    }

    /* renamed from: a */
    public DSAParameters m27449a() {
        if (this.f22368j) {
            return m27448c();
        }
        return m27447b();
    }

    /* renamed from: b */
    private DSAParameters m27447b() {
        byte[] bArr = new byte[20];
        Object obj = new byte[20];
        byte[] bArr2 = new byte[20];
        byte[] bArr3 = new byte[20];
        int i = (this.f22363e - 1) / 160;
        Object obj2 = new byte[(this.f22363e / 8)];
        if (this.f22362d instanceof SHA1Digest) {
            while (true) {
                this.f22367i.nextBytes(bArr);
                m27442a(this.f22362d, bArr, obj, 0);
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                m27443a(bArr2);
                m27442a(this.f22362d, bArr2, bArr2, 0);
                for (int i2 = 0; i2 != bArr3.length; i2++) {
                    bArr3[i2] = (byte) (obj[i2] ^ bArr2[i2]);
                }
                bArr3[0] = (byte) (bArr3[0] | -128);
                bArr3[19] = (byte) (bArr3[19] | 1);
                BigInteger bigInteger = new BigInteger(1, bArr3);
                if (m27444a(bigInteger)) {
                    byte[] b = Arrays.m29373b(bArr);
                    m27443a(b);
                    for (int i3 = 0; i3 < 4096; i3++) {
                        int i4;
                        for (i4 = 1; i4 <= i; i4++) {
                            m27443a(b);
                            m27442a(this.f22362d, b, obj2, obj2.length - (obj.length * i4));
                        }
                        i4 = obj2.length - (obj.length * i);
                        m27443a(b);
                        m27442a(this.f22362d, b, obj, 0);
                        System.arraycopy(obj, obj.length - i4, obj2, 0, i4);
                        obj2[0] = (byte) (obj2[0] | -128);
                        BigInteger bigInteger2 = new BigInteger(1, obj2);
                        bigInteger2 = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(f22360b));
                        if (bigInteger2.bitLength() == this.f22363e) {
                            if (m27444a(bigInteger2)) {
                                return new DSAParameters(bigInteger2, bigInteger, m27440a(bigInteger2, bigInteger, this.f22367i), new DSAValidationParameters(bArr, i3));
                            }
                        }
                    }
                    continue;
                }
            }
        } else {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
    }

    /* renamed from: a */
    private static BigInteger m27440a(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        bigInteger2 = bigInteger.subtract(f22360b).divide(bigInteger2);
        BigInteger subtract = bigInteger.subtract(f22361c);
        do {
            modPow = BigIntegers.m29386a(f22361c, subtract, secureRandom).modPow(bigInteger2, bigInteger);
        } while (modPow.bitLength() <= 1);
        return modPow;
    }

    /* renamed from: c */
    private DSAParameters m27448c() {
        BigInteger bit;
        int i;
        BigInteger bigInteger;
        Digest digest = this.f22362d;
        int b = digest.mo5732b() * 8;
        byte[] bArr = new byte[(this.f22364f / 8)];
        int i2 = (this.f22363e - 1) / b;
        int i3 = (this.f22363e - 1) % b;
        Object obj = new byte[(this.f22363e / 8)];
        Object obj2 = new byte[digest.mo5732b()];
        loop0:
        while (true) {
            this.f22367i.nextBytes(bArr);
            m27442a(digest, bArr, obj2, 0);
            bit = new BigInteger(1, obj2).mod(f22360b.shiftLeft(this.f22364f - 1)).setBit(0).setBit(this.f22364f - 1);
            if (m27444a(bit)) {
                byte[] b2 = Arrays.m29373b(bArr);
                int i4 = this.f22363e * 4;
                i = 0;
                while (i < i4) {
                    int i5;
                    for (i5 = 1; i5 <= i2; i5++) {
                        m27443a(b2);
                        m27442a(digest, b2, obj, obj.length - (obj2.length * i5));
                    }
                    i5 = obj.length - (obj2.length * i2);
                    m27443a(b2);
                    m27442a(digest, b2, obj2, 0);
                    System.arraycopy(obj2, obj2.length - i5, obj, 0, i5);
                    obj[0] = (byte) (obj[0] | -128);
                    bigInteger = new BigInteger(1, obj);
                    bigInteger = bigInteger.subtract(bigInteger.mod(bit.shiftLeft(1)).subtract(f22360b));
                    if (bigInteger.bitLength() == this.f22363e) {
                        if (m27444a(bigInteger)) {
                            break loop0;
                        }
                    }
                    i++;
                }
                continue;
            }
        }
        if (this.f22369k >= 0) {
            BigInteger a = m27441a(digest, bigInteger, bit, bArr, this.f22369k);
            if (a != null) {
                return new DSAParameters(bigInteger, bit, a, new DSAValidationParameters(bArr, i, this.f22369k));
            }
        }
        return new DSAParameters(bigInteger, bit, m27446b(bigInteger, bit, this.f22367i), new DSAValidationParameters(bArr, i));
    }

    /* renamed from: a */
    private boolean m27444a(BigInteger bigInteger) {
        return bigInteger.isProbablePrime(this.f22365g);
    }

    /* renamed from: b */
    private static BigInteger m27446b(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return m27440a(bigInteger, bigInteger2, secureRandom);
    }

    /* renamed from: a */
    private static BigInteger m27441a(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i) {
        bigInteger2 = bigInteger.subtract(f22360b).divide(bigInteger2);
        Object a = Hex.m29436a("6767656E");
        byte[] bArr2 = new byte[(((bArr.length + a.length) + 1) + 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(a, 0, bArr2, bArr.length, a.length);
        bArr2[bArr2.length - 3] = (byte) i;
        bArr = new byte[digest.mo5732b()];
        for (i = 1; i < NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST; i++) {
            m27443a(bArr2);
            m27442a(digest, bArr2, bArr, 0);
            BigInteger modPow = new BigInteger(1, bArr).modPow(bigInteger2, bigInteger);
            if (modPow.compareTo(f22361c) >= 0) {
                return modPow;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m27442a(Digest digest, byte[] bArr, byte[] bArr2, int i) {
        digest.mo5731a(bArr, 0, bArr.length);
        digest.mo5728a(bArr2, i);
    }

    /* renamed from: b */
    private static int m27445b(int i) {
        return i <= 1024 ? 40 : (((i - 1) / 1024) * 8) + 48;
    }

    /* renamed from: a */
    private static void m27443a(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b = (byte) ((bArr[length] + 1) & JfifUtil.MARKER_FIRST_BYTE);
            bArr[length] = b;
            if (b == (byte) 0) {
                length--;
            } else {
                return;
            }
        }
    }
}
