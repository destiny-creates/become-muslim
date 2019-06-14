package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.ChaChaEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.Poly1305;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class Chacha20Poly1305 implements TlsCipher {
    /* renamed from: a */
    protected TlsContext f27304a;
    /* renamed from: b */
    protected ChaChaEngine f27305b;
    /* renamed from: c */
    protected ChaChaEngine f27306c;

    /* renamed from: a */
    public int m35872a(int i) {
        return i - 16;
    }

    public Chacha20Poly1305(TlsContext tlsContext) {
        if (TlsUtils.m27860c(tlsContext)) {
            this.f27304a = tlsContext;
            byte[] a = TlsUtils.m27828a(tlsContext, 64);
            CipherParameters keyParameter = new KeyParameter(a, 0, 32);
            CipherParameters keyParameter2 = new KeyParameter(a, 32, 32);
            this.f27305b = new ChaChaEngine(20);
            this.f27306c = new ChaChaEngine(20);
            if (tlsContext.mo6487f() != null) {
                CipherParameters cipherParameters = keyParameter2;
                keyParameter2 = keyParameter;
                keyParameter = cipherParameters;
            }
            tlsContext = new byte[8];
            this.f27305b.mo5750a(true, new ParametersWithIV(keyParameter, tlsContext));
            this.f27306c.mo5750a(false, new ParametersWithIV(keyParameter2, tlsContext));
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public byte[] mo5831a(long j, short s, byte[] bArr, int i, int i2) {
        long j2 = j;
        int i3 = i2;
        int i4 = i3 + 16;
        KeyParameter a = m35873a(this.f27305b, true, j2);
        Object obj = new byte[i4];
        this.f27305b.mo5722a(bArr, i, i2, obj, 0);
        Object a2 = m35877a(a, m35875a(j2, s, i3), (byte[]) obj, 0, i2);
        System.arraycopy(a2, 0, obj, i3, a2.length);
        return obj;
    }

    /* renamed from: b */
    public byte[] mo5832b(long j, short s, byte[] bArr, int i, int i2) {
        if (m35872a(i2) >= 0) {
            int i3 = i2 - 16;
            if (Arrays.m29372b(m35877a(m35873a(this.f27306c, false, j), m35875a(j, s, i3), bArr, i, i3), Arrays.m29361a(bArr, i + i3, i2 + i)) != null) {
                j = new byte[i3];
                this.f27306c.mo5722a(bArr, i, i3, j, 0);
                return j;
            }
            throw new TlsFatalAlert((short) 20);
        }
        throw new TlsFatalAlert((short) 50);
    }

    /* renamed from: a */
    protected KeyParameter m35873a(ChaChaEngine chaChaEngine, boolean z, long j) {
        byte[] bArr = new byte[8];
        TlsUtils.m27809a(j, bArr, 0);
        chaChaEngine.mo5750a(z, (CipherParameters) new ParametersWithIV(null, bArr));
        z = new byte[true];
        chaChaEngine.mo5722a(z, 0, z.length, z, 0);
        System.arraycopy(z, 0, z, 32, 16);
        KeyParameter keyParameter = new KeyParameter(z, 16, 32);
        Poly1305KeyGenerator.m35370a(keyParameter.m35685a());
        return keyParameter;
    }

    /* renamed from: a */
    protected byte[] m35877a(KeyParameter keyParameter, byte[] bArr, byte[] bArr2, int i, int i2) {
        Mac poly1305 = new Poly1305();
        poly1305.mo5764a((CipherParameters) keyParameter);
        m35874a(poly1305, bArr, 0, bArr.length);
        m35874a(poly1305, bArr2, i, i2);
        keyParameter = new byte[poly1305.mo5766b()];
        poly1305.mo5761a(keyParameter, 0);
        return keyParameter;
    }

    /* renamed from: a */
    protected void m35874a(Mac mac, byte[] bArr, int i, int i2) {
        mac.mo5765a(bArr, i, i2);
        bArr = Pack.m29405a(((long) i2) & 4294967295L);
        mac.mo5765a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    protected byte[] m35875a(long j, short s, int i) {
        byte[] bArr = new byte[13];
        TlsUtils.m27809a(j, bArr, 0);
        TlsUtils.m27818a(s, bArr, (int) 8);
        TlsUtils.m27814a(this.f27304a.mo5812e(), bArr, 9);
        TlsUtils.m27843b(i, bArr, (int) 11);
        return bArr;
    }
}
