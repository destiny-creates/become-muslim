package org.spongycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.EphemeralKeyPair;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Pack;

public class IESEngine {
    /* renamed from: a */
    BasicAgreement f22318a;
    /* renamed from: b */
    DerivationFunction f22319b;
    /* renamed from: c */
    Mac f22320c;
    /* renamed from: d */
    BufferedBlockCipher f22321d;
    /* renamed from: e */
    byte[] f22322e;
    /* renamed from: f */
    boolean f22323f;
    /* renamed from: g */
    CipherParameters f22324g;
    /* renamed from: h */
    CipherParameters f22325h;
    /* renamed from: i */
    IESParameters f22326i;
    /* renamed from: j */
    byte[] f22327j;
    /* renamed from: k */
    private EphemeralKeyPairGenerator f22328k;
    /* renamed from: l */
    private KeyParser f22329l;
    /* renamed from: m */
    private byte[] f22330m;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac) {
        this.f22318a = basicAgreement;
        this.f22319b = derivationFunction;
        this.f22320c = mac;
        this.f22322e = new byte[mac.mo5766b()];
        this.f22321d = null;
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac, BufferedBlockCipher bufferedBlockCipher) {
        this.f22318a = basicAgreement;
        this.f22319b = derivationFunction;
        this.f22320c = mac;
        this.f22322e = new byte[mac.mo5766b()];
        this.f22321d = bufferedBlockCipher;
    }

    /* renamed from: a */
    public void m27421a(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.f22323f = z;
        this.f22324g = cipherParameters;
        this.f22325h = cipherParameters2;
        this.f22327j = new byte[false];
        m27415a(cipherParameters3);
    }

    /* renamed from: a */
    public void m27420a(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.f22323f = true;
        this.f22325h = asymmetricKeyParameter;
        this.f22328k = ephemeralKeyPairGenerator;
        m27415a(cipherParameters);
    }

    /* renamed from: a */
    public void m27419a(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser) {
        this.f22323f = false;
        this.f22324g = asymmetricKeyParameter;
        this.f22329l = keyParser;
        m27415a(cipherParameters);
    }

    /* renamed from: a */
    private void m27415a(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f22330m = parametersWithIV.m35695a();
            this.f22326i = (IESParameters) parametersWithIV.m35696b();
            return;
        }
        this.f22330m = null;
        this.f22326i = (IESParameters) cipherParameters;
    }

    /* renamed from: a */
    public BufferedBlockCipher m27418a() {
        return this.f22321d;
    }

    /* renamed from: b */
    public Mac m27424b() {
        return this.f22320c;
    }

    /* renamed from: b */
    private byte[] m27416b(byte[] bArr, int i, int i2) {
        Object obj;
        byte[] bArr2;
        Object obj2;
        if (this.f22321d == null) {
            obj = new byte[i2];
            bArr2 = new byte[(this.f22326i.m35668c() / 8)];
            obj2 = new byte[(obj.length + bArr2.length)];
            this.f22319b.mo5726a(obj2, 0, obj2.length);
            if (this.f22327j.length != 0) {
                System.arraycopy(obj2, 0, bArr2, 0, bArr2.length);
                System.arraycopy(obj2, bArr2.length, obj, 0, obj.length);
            } else {
                System.arraycopy(obj2, 0, obj, 0, obj.length);
                System.arraycopy(obj2, i2, bArr2, 0, bArr2.length);
            }
            obj2 = new byte[i2];
            for (int i3 = 0; i3 != i2; i3++) {
                obj2[i3] = (byte) (bArr[i + i3] ^ obj[i3]);
            }
            obj = obj2;
        } else {
            obj = new byte[(((IESWithCipherParameters) this.f22326i).m40795d() / 8)];
            bArr2 = new byte[(this.f22326i.m35668c() / 8)];
            obj2 = new byte[(obj.length + bArr2.length)];
            this.f22319b.mo5726a(obj2, 0, obj2.length);
            System.arraycopy(obj2, 0, obj, 0, obj.length);
            System.arraycopy(obj2, obj.length, bArr2, 0, bArr2.length);
            if (this.f22330m != null) {
                this.f22321d.mo5786a(true, new ParametersWithIV(new KeyParameter(obj), this.f22330m));
            } else {
                this.f22321d.mo5786a(true, new KeyParameter(obj));
            }
            obj = new byte[this.f22321d.mo5778b(i2)];
            int a = this.f22321d.mo5777a(bArr, i, i2, obj, 0);
            i2 = a + this.f22321d.mo5776a((byte[]) obj, a);
        }
        bArr = this.f22326i.m35667b();
        i = 0;
        if (this.f22327j.length != 0) {
            i = mo5752a(bArr);
        }
        obj2 = new byte[this.f22320c.mo5766b()];
        this.f22320c.mo5764a(new KeyParameter(bArr2));
        this.f22320c.mo5765a(obj, 0, obj.length);
        if (bArr != null) {
            this.f22320c.mo5765a(bArr, 0, bArr.length);
        }
        if (this.f22327j.length != null) {
            this.f22320c.mo5765a(i, 0, i.length);
        }
        this.f22320c.mo5761a(obj2, 0);
        bArr = new byte[((this.f22327j.length + i2) + obj2.length)];
        System.arraycopy(this.f22327j, 0, bArr, 0, this.f22327j.length);
        System.arraycopy(obj, 0, bArr, this.f22327j.length, i2);
        System.arraycopy(obj2, 0, bArr, this.f22327j.length + i2, obj2.length);
        return bArr;
    }

    /* renamed from: c */
    private byte[] m27417c(byte[] bArr, int i, int i2) {
        if (i2 > this.f22326i.m35668c() / 8) {
            byte[] bArr2;
            int length;
            byte[] bArr3;
            Object obj;
            Object obj2;
            if (this.f22321d == null) {
                obj = new byte[((i2 - this.f22327j.length) - this.f22320c.mo5766b())];
                bArr2 = new byte[(this.f22326i.m35668c() / 8)];
                obj2 = new byte[(obj.length + bArr2.length)];
                this.f22319b.mo5726a(obj2, 0, obj2.length);
                if (this.f22327j.length != 0) {
                    System.arraycopy(obj2, 0, bArr2, 0, bArr2.length);
                    System.arraycopy(obj2, bArr2.length, obj, 0, obj.length);
                } else {
                    System.arraycopy(obj2, 0, obj, 0, obj.length);
                    System.arraycopy(obj2, obj.length, bArr2, 0, bArr2.length);
                }
                byte[] bArr4 = new byte[obj.length];
                for (int i3 = 0; i3 != obj.length; i3++) {
                    bArr4[i3] = (byte) (bArr[(this.f22327j.length + i) + i3] ^ obj[i3]);
                }
                byte[] bArr5 = bArr4;
                length = obj.length;
                bArr3 = bArr5;
            } else {
                obj = new byte[(((IESWithCipherParameters) this.f22326i).m40795d() / 8)];
                bArr2 = new byte[(this.f22326i.m35668c() / 8)];
                obj2 = new byte[(obj.length + bArr2.length)];
                this.f22319b.mo5726a(obj2, 0, obj2.length);
                System.arraycopy(obj2, 0, obj, 0, obj.length);
                System.arraycopy(obj2, obj.length, bArr2, 0, bArr2.length);
                if (this.f22330m != null) {
                    this.f22321d.mo5786a(false, new ParametersWithIV(new KeyParameter(obj), this.f22330m));
                } else {
                    this.f22321d.mo5786a(false, new KeyParameter(obj));
                }
                bArr3 = new byte[this.f22321d.mo5778b((i2 - this.f22327j.length) - this.f22320c.mo5766b())];
                length = this.f22321d.mo5777a(bArr, i + this.f22327j.length, (i2 - this.f22327j.length) - this.f22320c.mo5766b(), bArr3, 0);
                length += this.f22321d.mo5776a(bArr3, length);
            }
            byte[] b = this.f22326i.m35667b();
            byte[] bArr6 = null;
            if (this.f22327j.length != 0) {
                bArr6 = mo5752a(b);
            }
            int i4 = i + i2;
            byte[] a = Arrays.m29361a(bArr, i4 - this.f22320c.mo5766b(), i4);
            byte[] bArr7 = new byte[a.length];
            this.f22320c.mo5764a(new KeyParameter(bArr2));
            this.f22320c.mo5765a(bArr, i + this.f22327j.length, (i2 - this.f22327j.length) - bArr7.length);
            if (b != null) {
                this.f22320c.mo5765a(b, 0, b.length);
            }
            if (this.f22327j.length != null) {
                this.f22320c.mo5765a(bArr6, 0, bArr6.length);
            }
            this.f22320c.mo5761a(bArr7, 0);
            if (Arrays.m29372b(a, bArr7) != null) {
                return Arrays.m29361a(bArr3, 0, length);
            }
            throw new InvalidCipherTextException("Invalid MAC.");
        }
        throw new InvalidCipherTextException("Length of input must be greater than the MAC");
    }

    /* renamed from: a */
    public byte[] m27423a(byte[] bArr, int i, int i2) {
        if (this.f22323f) {
            if (this.f22328k != null) {
                EphemeralKeyPair a = this.f22328k.m27454a();
                this.f22324g = a.m27321a().m27282b();
                this.f22327j = a.m27322b();
            }
        } else if (this.f22329l != null) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                this.f22325h = this.f22329l.mo5787a(byteArrayInputStream);
                this.f22327j = Arrays.m29361a(bArr, i, (i2 - byteArrayInputStream.available()) + i);
            } catch (byte[] bArr2) {
                i2 = new StringBuilder();
                i2.append("unable to recover ephemeral public key: ");
                i2.append(bArr2.getMessage());
                throw new InvalidCipherTextException(i2.toString(), bArr2);
            }
        }
        this.f22318a.mo5724a(this.f22324g);
        byte[] a2 = BigIntegers.m29388a(this.f22318a.mo5723a(), this.f22318a.mo5725b(this.f22325h));
        if (this.f22327j.length != 0) {
            byte[] d = Arrays.m29385d(this.f22327j, a2);
            Arrays.m29351a(a2, (byte) 0);
            a2 = d;
        }
        try {
            this.f22319b.mo5727a(new KDFParameters(a2, this.f22326i.m35666a()));
            if (this.f22323f) {
                bArr2 = m27416b(bArr2, i, i2);
            } else {
                bArr2 = m27417c(bArr2, i, i2);
            }
            Arrays.m29351a(a2, (byte) 0);
            return bArr2;
        } catch (Throwable th) {
            Arrays.m29351a(a2, (byte) 0);
        }
    }

    /* renamed from: a */
    protected byte[] mo5752a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            Pack.m29401a(((long) bArr.length) * 8, bArr2, (int) null);
        }
        return bArr2;
    }
}
