package org.spongycastle.crypto.modes;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;

public class GOFBBlockCipher extends StreamBlockCipher {
    /* renamed from: a */
    boolean f31724a = true;
    /* renamed from: b */
    int f31725b;
    /* renamed from: c */
    int f31726c;
    /* renamed from: d */
    private byte[] f31727d;
    /* renamed from: e */
    private byte[] f31728e;
    /* renamed from: f */
    private byte[] f31729f;
    /* renamed from: g */
    private int f31730g;
    /* renamed from: h */
    private final int f31731h;
    /* renamed from: i */
    private final BlockCipher f31732i;

    public GOFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f31732i = blockCipher;
        this.f31731h = blockCipher.mo5743b();
        if (this.f31731h == 8) {
            this.f31727d = new byte[blockCipher.mo5743b()];
            this.f31728e = new byte[blockCipher.mo5743b()];
            this.f31729f = new byte[blockCipher.mo5743b()];
            return;
        }
        throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        this.f31724a = true;
        this.f31725b = 0;
        this.f31726c = 0;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            Object a = parametersWithIV.m35695a();
            if (a.length < this.f31727d.length) {
                System.arraycopy(a, 0, this.f31727d, this.f31727d.length - a.length, a.length);
                for (int i = 0; i < this.f31727d.length - a.length; i++) {
                    this.f31727d[i] = (byte) 0;
                }
            } else {
                System.arraycopy(a, 0, this.f31727d, 0, this.f31727d.length);
            }
            mo5744c();
            if (parametersWithIV.m35696b() != null) {
                this.f31732i.mo5742a(true, parametersWithIV.m35696b());
                return;
            }
            return;
        }
        mo5744c();
        if (cipherParameters != null) {
            this.f31732i.mo5742a(true, cipherParameters);
        }
    }

    /* renamed from: a */
    public String mo5749a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f31732i.mo5741a());
        stringBuilder.append("/GCTR");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f31731h;
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        mo5722a(bArr, i, this.f31731h, bArr2, i2);
        return this.f31731h;
    }

    /* renamed from: c */
    public void mo5744c() {
        this.f31724a = true;
        this.f31725b = 0;
        this.f31726c = 0;
        System.arraycopy(this.f31727d, 0, this.f31728e, 0, this.f31727d.length);
        this.f31730g = 0;
        this.f31732i.mo5744c();
    }

    /* renamed from: a */
    private int m40758a(byte[] bArr, int i) {
        return ((((bArr[i + 3] << 24) & -16777216) + ((bArr[i + 2] << 16) & 16711680)) + ((bArr[i + 1] << 8) & 65280)) + (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: a */
    private void m40759a(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }

    /* renamed from: b */
    protected byte mo6454b(byte b) {
        if (this.f31730g == 0) {
            if (this.f31724a) {
                this.f31724a = false;
                this.f31732i.mo5740a(this.f31728e, 0, this.f31729f, 0);
                this.f31725b = m40758a(this.f31729f, 0);
                this.f31726c = m40758a(this.f31729f, 4);
            }
            this.f31725b += 16843009;
            this.f31726c += 16843012;
            m40759a(this.f31725b, this.f31728e, 0);
            m40759a(this.f31726c, this.f31728e, 4);
            this.f31732i.mo5740a(this.f31728e, 0, this.f31729f, 0);
        }
        byte[] bArr = this.f31729f;
        int i = this.f31730g;
        this.f31730g = i + 1;
        b = (byte) (b ^ bArr[i]);
        if (this.f31730g == this.f31731h) {
            this.f31730g = 0;
            System.arraycopy(this.f31728e, this.f31731h, this.f31728e, 0, this.f31728e.length - this.f31731h);
            System.arraycopy(this.f31729f, 0, this.f31728e, this.f31728e.length - this.f31731h, this.f31731h);
        }
        return b;
    }
}
