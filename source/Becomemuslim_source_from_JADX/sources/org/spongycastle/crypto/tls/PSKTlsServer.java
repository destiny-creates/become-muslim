package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.agreement.DHStandardGroups;
import org.spongycastle.crypto.params.DHParameters;

public class PSKTlsServer extends AbstractTlsServer {
    /* renamed from: s */
    protected TlsPSKIdentityManager f32661s;

    /* renamed from: r */
    protected TlsEncryptionCredentials m43394r() {
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: s */
    protected DHParameters m43395s() {
        return DHStandardGroups.f22219m;
    }

    /* renamed from: f */
    protected int[] mo6817f() {
        return new int[]{49207, 49205, 178, 144};
    }

    /* renamed from: t */
    public TlsCredentials mo6818t() {
        int k = TlsUtils.m27882k(this.p);
        if (k != 24) {
            switch (k) {
                case 13:
                case 14:
                    break;
                case 15:
                    return m43394r();
                default:
                    throw new TlsFatalAlert((short) 80);
            }
        }
        return null;
    }

    /* renamed from: u */
    public TlsKeyExchange mo6819u() {
        int k = TlsUtils.m27882k(this.p);
        if (k != 24) {
            switch (k) {
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    throw new TlsFatalAlert((short) 80);
            }
        }
        return m43392a(k);
    }

    /* renamed from: a */
    protected TlsKeyExchange m43392a(int i) {
        return new TlsPSKKeyExchange(i, this.j, null, this.f32661s, m43395s(), this.l, this.m, this.n);
    }
}
