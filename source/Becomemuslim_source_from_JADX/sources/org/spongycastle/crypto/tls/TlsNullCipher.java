package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;

public class TlsNullCipher implements TlsCipher {
    /* renamed from: a */
    protected TlsContext f27341a;
    /* renamed from: b */
    protected TlsMac f27342b;
    /* renamed from: c */
    protected TlsMac f27343c;

    public TlsNullCipher(TlsContext tlsContext, Digest digest, Digest digest2) {
        Object obj = 1;
        Object obj2 = digest == null ? 1 : null;
        if (digest2 != null) {
            obj = null;
        }
        if (obj2 == obj) {
            TlsMac tlsMac;
            this.f27341a = tlsContext;
            TlsMac tlsMac2 = null;
            if (digest != null) {
                int b = digest.mo5732b() + digest2.mo5732b();
                TlsContext tlsContext2 = tlsContext;
                byte[] a = TlsUtils.m27828a(tlsContext, b);
                TlsMac tlsMac3 = new TlsMac(tlsContext2, digest, a, 0, digest.mo5732b());
                digest = digest.mo5732b() + 0;
                tlsMac3 = new TlsMac(tlsContext2, digest2, a, digest, digest2.mo5732b());
                if (digest + digest2.mo5732b() == b) {
                    tlsMac2 = tlsMac3;
                } else {
                    throw new TlsFatalAlert((short) 80);
                }
            }
            tlsMac = null;
            if (tlsContext.mo6487f() != null) {
                this.f27342b = tlsMac2;
                this.f27343c = tlsMac;
                return;
            }
            this.f27342b = tlsMac;
            this.f27343c = tlsMac2;
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public byte[] mo5831a(long j, short s, byte[] bArr, int i, int i2) {
        if (this.f27342b == null) {
            return Arrays.m29361a(bArr, i, i2 + i);
        }
        j = this.f27342b.m27717a(j, s, bArr, i, i2);
        Object obj = new byte[(j.length + i2)];
        System.arraycopy(bArr, i, obj, 0, i2);
        System.arraycopy(j, 0, obj, i2, j.length);
        return obj;
    }

    /* renamed from: b */
    public byte[] mo5832b(long j, short s, byte[] bArr, int i, int i2) {
        if (this.f27343c == null) {
            return Arrays.m29361a(bArr, i, i2 + i);
        }
        int a = this.f27343c.m27715a();
        if (i2 >= a) {
            int i3 = i2 - a;
            a = i + i3;
            if (Arrays.m29372b(Arrays.m29361a(bArr, a, i2 + i), this.f27343c.m27717a(j, s, bArr, i, i3)) != null) {
                return Arrays.m29361a(bArr, i, a);
            }
            throw new TlsFatalAlert((short) 20);
        }
        throw new TlsFatalAlert((short) 50);
    }
}
