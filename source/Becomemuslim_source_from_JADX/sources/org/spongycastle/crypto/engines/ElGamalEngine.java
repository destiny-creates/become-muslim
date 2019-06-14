package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ElGamalKeyParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.BigIntegers;

public class ElGamalEngine implements AsymmetricBlockCipher {
    /* renamed from: e */
    private static final BigInteger f26621e = BigInteger.valueOf(0);
    /* renamed from: f */
    private static final BigInteger f26622f = BigInteger.valueOf(1);
    /* renamed from: g */
    private static final BigInteger f26623g = BigInteger.valueOf(2);
    /* renamed from: a */
    private ElGamalKeyParameters f26624a;
    /* renamed from: b */
    private SecureRandom f26625b;
    /* renamed from: c */
    private boolean f26626c;
    /* renamed from: d */
    private int f26627d;

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f26624a = (ElGamalKeyParameters) parametersWithRandom.m35698b();
            this.f26625b = parametersWithRandom.m35697a();
        } else {
            this.f26624a = (ElGamalKeyParameters) cipherParameters;
            this.f26625b = new SecureRandom();
        }
        this.f26626c = z;
        this.f26627d = this.f26624a.m40793b().m35655a().bitLength();
        if (z) {
            if (!(this.f26624a instanceof ElGamalPublicKeyParameters)) {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else if (!(this.f26624a instanceof ElGamalPrivateKeyParameters)) {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
    }

    /* renamed from: a */
    public int mo5736a() {
        if (this.f26626c) {
            return (this.f26627d - 1) / 8;
        }
        return ((this.f26627d + 7) / 8) * 2;
    }

    /* renamed from: b */
    public int mo5739b() {
        if (this.f26626c) {
            return ((this.f26627d + 7) / 8) * 2;
        }
        return (this.f26627d - 1) / 8;
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        if (this.f26624a != null) {
            int i3;
            if (this.f26626c) {
                i3 = ((this.f26627d - 1) + 7) / 8;
            } else {
                i3 = mo5736a();
            }
            if (i2 <= i3) {
                BigInteger a = this.f26624a.m40793b().m35655a();
                Object obj;
                if (this.f26624a instanceof ElGamalPrivateKeyParameters) {
                    i2 /= 2;
                    obj = new byte[i2];
                    i2 = new byte[i2];
                    System.arraycopy(bArr, i, obj, 0, obj.length);
                    System.arraycopy(bArr, i + obj.length, i2, 0, i2.length);
                    bArr = new BigInteger(1, obj);
                    return BigIntegers.m29389a(bArr.modPow(a.subtract(f26622f).subtract(((ElGamalPrivateKeyParameters) this.f26624a).m43371c()), a).multiply(new BigInteger(1, i2)).mod(a));
                }
                if (!(i == 0 && i2 == bArr.length)) {
                    obj = new byte[i2];
                    System.arraycopy(bArr, i, obj, 0, i2);
                    bArr = obj;
                }
                i = new BigInteger(1, bArr);
                if (i.compareTo(a) < null) {
                    ElGamalPublicKeyParameters elGamalPublicKeyParameters = (ElGamalPublicKeyParameters) this.f26624a;
                    i2 = a.bitLength();
                    BigInteger bigInteger = new BigInteger(i2, this.f26625b);
                    while (true) {
                        if (!bigInteger.equals(f26621e)) {
                            if (bigInteger.compareTo(a.subtract(f26623g)) <= 0) {
                                break;
                            }
                        }
                        bigInteger = new BigInteger(i2, this.f26625b);
                    }
                    i2 = this.f26624a.m40793b().m35656b().modPow(bigInteger, a);
                    bArr = i.multiply(elGamalPublicKeyParameters.m43372c().modPow(bigInteger, a)).mod(a);
                    i = i2.toByteArray();
                    bArr = bArr.toByteArray();
                    i2 = new byte[mo5739b()];
                    if (i.length > i2.length / 2) {
                        System.arraycopy(i, 1, i2, (i2.length / 2) - (i.length - 1), i.length - 1);
                    } else {
                        System.arraycopy(i, 0, i2, (i2.length / 2) - i.length, i.length);
                    }
                    if (bArr.length > i2.length / 2) {
                        System.arraycopy(bArr, 1, i2, i2.length - (bArr.length - 1), bArr.length - 1);
                    } else {
                        System.arraycopy(bArr, 0, i2, i2.length - bArr.length, bArr.length);
                    }
                    return i2;
                }
                throw new DataLengthException("input too large for ElGamal cipher.\n");
            }
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        throw new IllegalStateException("ElGamal engine not initialised");
    }
}
