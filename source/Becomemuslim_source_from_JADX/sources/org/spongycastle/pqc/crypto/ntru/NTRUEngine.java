package org.spongycastle.pqc.crypto.ntru;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import org.spongycastle.util.Arrays;

public class NTRUEngine implements AsymmetricBlockCipher {
    /* renamed from: a */
    private boolean f27761a;
    /* renamed from: b */
    private NTRUEncryptionParameters f27762b;
    /* renamed from: c */
    private NTRUEncryptionPublicKeyParameters f27763c;
    /* renamed from: d */
    private NTRUEncryptionPrivateKeyParameters f27764d;
    /* renamed from: e */
    private SecureRandom f27765e;

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        this.f27761a = z;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f27765e = parametersWithRandom.m35697a();
                this.f27763c = (NTRUEncryptionPublicKeyParameters) parametersWithRandom.m35698b();
            } else {
                this.f27765e = new SecureRandom();
                this.f27763c = (NTRUEncryptionPublicKeyParameters) cipherParameters;
            }
            this.f27762b = this.f27763c.m42097b();
            return;
        }
        this.f27764d = (NTRUEncryptionPrivateKeyParameters) cipherParameters;
        this.f27762b = this.f27764d.m42097b();
    }

    /* renamed from: a */
    public int mo5736a() {
        return this.f27762b.f23283m;
    }

    /* renamed from: b */
    public int mo5739b() {
        return ((this.f27762b.f23271a * m36382a(this.f27762b.f23272b)) + 7) / 8;
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        if (this.f27761a != null) {
            return m36390a(bArr2, this.f27763c);
        }
        return m36389a(bArr2, this.f27764d);
    }

    /* renamed from: a */
    private byte[] m36390a(byte[] bArr, NTRUEncryptionPublicKeyParameters nTRUEncryptionPublicKeyParameters) {
        Object obj = bArr;
        IntegerPolynomial integerPolynomial = nTRUEncryptionPublicKeyParameters.f32738c;
        int i = this.f27762b.f23271a;
        int i2 = this.f27762b.f23272b;
        int i3 = this.f27762b.f23283m;
        int i4 = this.f27762b.f23284n;
        int i5 = this.f27762b.f23285o;
        int i6 = this.f27762b.f23287q;
        int i7 = this.f27762b.f23288r;
        int i8 = this.f27762b.f23291u;
        boolean z = this.f27762b.f23292v;
        byte[] bArr2 = this.f27762b.f23293w;
        int length = obj.length;
        if (i3 > JfifUtil.MARKER_FIRST_BYTE) {
            throw new IllegalArgumentException("llen values bigger than 1 are not supported");
        } else if (length <= i3) {
            while (true) {
                Object obj2 = new byte[(i4 / 8)];
                r6.f27765e.nextBytes(obj2);
                Object obj3 = new byte[((i3 + 1) - length)];
                boolean z2 = z;
                byte[] bArr3 = new byte[(i5 / 8)];
                int i9 = i8;
                int i10 = i4;
                System.arraycopy(obj2, 0, bArr3, 0, obj2.length);
                bArr3[obj2.length] = (byte) length;
                int i11 = length;
                System.arraycopy(obj, 0, bArr3, obj2.length + 1, obj.length);
                System.arraycopy(obj3, 0, bArr3, (obj2.length + 1) + obj.length, obj3.length);
                IntegerPolynomial a = IntegerPolynomial.m36538a(bArr3, i);
                byte[] a2 = m36388a(integerPolynomial.m36550a(i2), i7 / 8);
                r22 = i11;
                byte[] bArr4 = bArr2;
                int i12 = i5;
                boolean z3 = z2;
                byte[] bArr5 = bArr3;
                int i13 = i7;
                i7 = i9;
                IntegerPolynomial a3 = m36384a(m36391a(bArr2, bArr, r22, obj2, a2), bArr5).mo5934a(integerPolynomial, i2);
                IntegerPolynomial integerPolynomial2 = (IntegerPolynomial) a3.clone();
                integerPolynomial2.m36564g(4);
                a.m36552b(m36383a(integerPolynomial2.m36550a(4), i, i7, z3));
                a.m36565h();
                if (a.m36577n(-1) >= i6) {
                    if (a.m36577n(0) >= i6) {
                        if (a.m36577n(1) >= i6) {
                            a3.m36553b(a, i2);
                            a3.m36569j(i2);
                            return a3.m36550a(i2);
                        }
                    }
                }
                z = z3;
                i8 = i7;
                bArr2 = bArr4;
                i4 = i10;
                length = r22;
                i5 = i12;
                i7 = i13;
                obj = bArr;
            }
        } else {
            r22 = length;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Message too long: ");
            stringBuilder.append(r22);
            stringBuilder.append(">");
            stringBuilder.append(i3);
            throw new DataLengthException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private byte[] m36391a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        i = new byte[(((bArr.length + i) + bArr3.length) + bArr4.length)];
        System.arraycopy(bArr, 0, i, 0, bArr.length);
        System.arraycopy(bArr2, 0, i, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, i, bArr.length + bArr2.length, bArr3.length);
        System.arraycopy(bArr4, 0, i, (bArr.length + bArr2.length) + bArr3.length, bArr4.length);
        return i;
    }

    /* renamed from: a */
    private Polynomial m36384a(byte[] bArr, byte[] bArr2) {
        IndexGenerator indexGenerator = new IndexGenerator(bArr, this.f27762b);
        if (this.f27762b.f23296z == 1) {
            return new ProductFormPolynomial(new SparseTernaryPolynomial(m36392a(indexGenerator, this.f27762b.f23278h)), new SparseTernaryPolynomial(m36392a(indexGenerator, this.f27762b.f23279i)), new SparseTernaryPolynomial(m36392a(indexGenerator, this.f27762b.f23280j)));
        }
        int i = this.f27762b.f23277g;
        boolean z = this.f27762b.f23294x;
        int[] a = m36392a(indexGenerator, i);
        if (z) {
            return new SparseTernaryPolynomial(a);
        }
        return new DenseTernaryPolynomial(a);
    }

    /* renamed from: a */
    private int[] m36392a(IndexGenerator indexGenerator, int i) {
        int[] iArr = new int[this.f27762b.f23271a];
        for (int i2 = -1; i2 <= 1; i2 += 2) {
            int i3 = 0;
            while (i3 < i) {
                int a = indexGenerator.m29100a();
                if (iArr[a] == 0) {
                    iArr[a] = i2;
                    i3++;
                }
            }
        }
        return iArr;
    }

    /* renamed from: a */
    private IntegerPolynomial m36383a(byte[] bArr, int i, int i2, boolean z) {
        Digest digest = this.f27762b.f23270A;
        int b = digest.mo5732b();
        Object obj = new byte[(i2 * b)];
        if (z) {
            bArr = m36387a(digest, bArr);
        }
        int i3 = 0;
        while (i3 < i2) {
            digest.mo5731a(bArr, 0, bArr.length);
            m36385a(digest, i3);
            System.arraycopy(m36386a(digest), 0, obj, i3 * b, b);
            i3++;
        }
        i2 = new IntegerPolynomial(i);
        while (true) {
            int i4 = 0;
            for (b = 0; b != obj.length; b++) {
                int i5 = obj[b] & JfifUtil.MARKER_FIRST_BYTE;
                if (i5 < 243) {
                    int i6 = i4;
                    for (i4 = 0; i4 < 4; i4++) {
                        int i7 = i5 % 3;
                        i2.f27879a[i6] = i7 - 1;
                        i6++;
                        if (i6 == i) {
                            return i2;
                        }
                        i5 = (i5 - i7) / 3;
                    }
                    i2.f27879a[i6] = i5 - 1;
                    i6++;
                    if (i6 == i) {
                        return i2;
                    }
                    i4 = i6;
                }
            }
            if (i4 >= i) {
                return i2;
            }
            digest.mo5731a(bArr, 0, bArr.length);
            m36385a(digest, i3);
            obj = m36386a(digest);
            i3++;
        }
    }

    /* renamed from: a */
    private void m36385a(Digest digest, int i) {
        digest.mo5730a((byte) (i >> 24));
        digest.mo5730a((byte) (i >> 16));
        digest.mo5730a((byte) (i >> 8));
        digest.mo5730a((byte) i);
    }

    /* renamed from: a */
    private byte[] m36386a(Digest digest) {
        byte[] bArr = new byte[digest.mo5732b()];
        digest.mo5728a(bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    private byte[] m36387a(Digest digest, byte[] bArr) {
        byte[] bArr2 = new byte[digest.mo5732b()];
        digest.mo5731a(bArr, 0, bArr.length);
        digest.mo5728a(bArr2, 0);
        return bArr2;
    }

    /* renamed from: a */
    private byte[] m36389a(byte[] bArr, NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters) {
        NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters2 = nTRUEncryptionPrivateKeyParameters;
        Polynomial polynomial = nTRUEncryptionPrivateKeyParameters2.f32735c;
        IntegerPolynomial integerPolynomial = nTRUEncryptionPrivateKeyParameters2.f32736d;
        IntegerPolynomial integerPolynomial2 = nTRUEncryptionPrivateKeyParameters2.f32737e;
        int i = this.f27762b.f23271a;
        int i2 = this.f27762b.f23272b;
        int i3 = this.f27762b.f23284n;
        int i4 = this.f27762b.f23283m;
        int i5 = this.f27762b.f23287q;
        int i6 = this.f27762b.f23288r;
        int i7 = this.f27762b.f23291u;
        boolean z = this.f27762b.f23292v;
        byte[] bArr2 = this.f27762b.f23293w;
        if (i4 <= JfifUtil.MARKER_FIRST_BYTE) {
            i3 /= 8;
            IntegerPolynomial a = IntegerPolynomial.m36539a(bArr, i, i2);
            IntegerPolynomial a2 = m36394a(a, polynomial, integerPolynomial);
            if (a2.m36577n(-1) < i5) {
                throw new InvalidCipherTextException("Less than dm0 coefficients equal -1");
            } else if (a2.m36577n(0) < i5) {
                throw new InvalidCipherTextException("Less than dm0 coefficients equal 0");
            } else if (a2.m36577n(1) >= i5) {
                IntegerPolynomial integerPolynomial3 = (IntegerPolynomial) a.clone();
                integerPolynomial3.m36555c(a2);
                integerPolynomial3.m36564g(i2);
                IntegerPolynomial integerPolynomial4 = (IntegerPolynomial) integerPolynomial3.clone();
                integerPolynomial4.m36564g(4);
                a2.m36555c(m36383a(integerPolynomial4.m36550a(4), i, i7, z));
                a2.m36565h();
                Object d = a2.m36558d();
                Object obj = new byte[i3];
                System.arraycopy(d, 0, obj, 0, i3);
                i7 = JfifUtil.MARKER_FIRST_BYTE & d[i3];
                if (i7 <= i4) {
                    byte[] bArr3 = new byte[i7];
                    i3++;
                    System.arraycopy(d, i3, bArr3, 0, i7);
                    i3 += i7;
                    byte[] bArr4 = new byte[(d.length - i3)];
                    System.arraycopy(d, i3, bArr4, 0, bArr4.length);
                    if (Arrays.m29372b(bArr4, new byte[bArr4.length])) {
                        IntegerPolynomial a3 = m36384a(m36391a(bArr2, bArr3, i7, obj, m36388a(integerPolynomial2.m36550a(i2), i6 / 8)), bArr3).mo5933a(integerPolynomial2);
                        a3.m36564g(i2);
                        if (a3.equals(integerPolynomial3)) {
                            return bArr3;
                        }
                        throw new InvalidCipherTextException("Invalid message encoding");
                    }
                    throw new InvalidCipherTextException("The message is not followed by zeroes");
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Message too long: ");
                stringBuilder.append(i7);
                stringBuilder.append(">");
                stringBuilder.append(i4);
                throw new InvalidCipherTextException(stringBuilder.toString());
            } else {
                throw new InvalidCipherTextException("Less than dm0 coefficients equal 1");
            }
        }
        throw new DataLengthException("maxMsgLenBytes values bigger than 255 are not supported");
    }

    /* renamed from: a */
    protected IntegerPolynomial m36394a(IntegerPolynomial integerPolynomial, Polynomial polynomial, IntegerPolynomial integerPolynomial2) {
        if (this.f27762b.f23295y) {
            polynomial = polynomial.mo5934a(integerPolynomial, this.f27762b.f23272b);
            polynomial.m36560e(3);
            polynomial.m36552b(integerPolynomial);
        } else {
            polynomial = polynomial.mo5934a(integerPolynomial, this.f27762b.f23272b);
        }
        polynomial.m36576m(this.f27762b.f23272b);
        polynomial.m36565h();
        if (this.f27762b.f23295y == null) {
            polynomial = new DenseTernaryPolynomial((IntegerPolynomial) polynomial).mo5934a(integerPolynomial2, 3);
        }
        polynomial.m36576m(3);
        return polynomial;
    }

    /* renamed from: a */
    private byte[] m36388a(byte[] bArr, int i) {
        Object obj = new byte[i];
        if (i >= bArr.length) {
            i = bArr.length;
        }
        System.arraycopy(bArr, 0, obj, 0, i);
        return obj;
    }

    /* renamed from: a */
    private int m36382a(int i) {
        if (i == 2048) {
            return 11;
        }
        throw new IllegalStateException("log2 not fully implemented");
    }
}
