package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class TlsStreamCipher implements TlsCipher {
    /* renamed from: a */
    protected TlsContext f27353a;
    /* renamed from: b */
    protected StreamCipher f27354b;
    /* renamed from: c */
    protected StreamCipher f27355c;
    /* renamed from: d */
    protected TlsMac f27356d;
    /* renamed from: e */
    protected TlsMac f27357e;
    /* renamed from: f */
    protected boolean f27358f;

    public TlsStreamCipher(TlsContext tlsContext, StreamCipher streamCipher, StreamCipher streamCipher2, Digest digest, Digest digest2, int i, boolean z) {
        TlsContext tlsContext2 = tlsContext;
        StreamCipher streamCipher3 = streamCipher;
        StreamCipher streamCipher4 = streamCipher2;
        int i2 = i;
        boolean z2 = z;
        boolean f = tlsContext.mo6487f();
        this.f27353a = tlsContext2;
        this.f27358f = z2;
        this.f27354b = streamCipher3;
        this.f27355c = streamCipher4;
        int b = ((i2 * 2) + digest.mo5732b()) + digest2.mo5732b();
        byte[] a = TlsUtils.m27828a(tlsContext2, b);
        TlsContext tlsContext3 = tlsContext;
        byte[] bArr = a;
        TlsMac tlsMac = new TlsMac(tlsContext3, digest, bArr, 0, digest.mo5732b());
        int b2 = digest.mo5732b() + 0;
        TlsMac tlsMac2 = tlsMac;
        tlsMac = new TlsMac(tlsContext3, digest2, bArr, b2, digest2.mo5732b());
        int b3 = b2 + digest2.mo5732b();
        CipherParameters keyParameter = new KeyParameter(a, b3, i2);
        b3 += i2;
        CipherParameters keyParameter2 = new KeyParameter(a, b3, i2);
        if (b3 + i2 == b) {
            if (f) {
                r0.f27356d = tlsMac2;
                r0.f27357e = tlsMac;
                r0.f27354b = streamCipher4;
                r0.f27355c = streamCipher3;
                CipherParameters cipherParameters = keyParameter2;
                keyParameter2 = keyParameter;
                keyParameter = cipherParameters;
            } else {
                r0.f27356d = tlsMac;
                r0.f27357e = tlsMac2;
                r0.f27354b = streamCipher3;
                r0.f27355c = streamCipher4;
            }
            if (z2) {
                byte[] bArr2 = new byte[8];
                ParametersWithIV parametersWithIV = new ParametersWithIV(keyParameter, bArr2);
                keyParameter2 = new ParametersWithIV(keyParameter2, bArr2);
                keyParameter = parametersWithIV;
            }
            r0.f27354b.mo5750a(true, keyParameter);
            r0.f27355c.mo5750a(false, keyParameter2);
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public byte[] mo5831a(long j, short s, byte[] bArr, int i, int i2) {
        long j2;
        if (this.f27358f) {
            j2 = j;
            m35969a(r0.f27354b, true, j);
        } else {
            j2 = j;
        }
        byte[] bArr2 = new byte[(i2 + r0.f27356d.m27715a())];
        byte[] bArr3 = bArr;
        int i3 = i;
        int i4 = i2;
        r0.f27354b.mo5722a(bArr3, i3, i4, bArr2, 0);
        byte[] a = r0.f27356d.m27717a(j, s, bArr3, i3, i4);
        r0.f27354b.mo5722a(a, 0, a.length, bArr2, i2);
        return bArr2;
    }

    /* renamed from: b */
    public byte[] mo5832b(long j, short s, byte[] bArr, int i, int i2) {
        int i3 = i2;
        if (this.f27358f) {
            m35969a(r10.f27355c, false, j);
        } else {
            long j2 = j;
        }
        int a = r10.f27357e.m27715a();
        if (i3 >= a) {
            int i4 = i3 - a;
            byte[] bArr2 = new byte[i3];
            byte[] bArr3 = bArr2;
            r10.f27355c.mo5722a(bArr, i, i2, bArr3, 0);
            m35968a(j, s, bArr3, i4, i2, bArr2, 0, i4);
            return Arrays.m29361a(bArr2, 0, i4);
        }
        throw new TlsFatalAlert((short) 50);
    }

    /* renamed from: a */
    protected void m35968a(long j, short s, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        if (!Arrays.m29372b(Arrays.m29361a(bArr, i, i2), this.f27357e.m27717a(j, s, bArr2, i3, i4))) {
            throw new TlsFatalAlert((short) 20);
        }
    }

    /* renamed from: a */
    protected void m35969a(StreamCipher streamCipher, boolean z, long j) {
        byte[] bArr = new byte[8];
        TlsUtils.m27809a(j, bArr, 0);
        streamCipher.mo5750a(z, new ParametersWithIV(null, bArr));
    }
}
