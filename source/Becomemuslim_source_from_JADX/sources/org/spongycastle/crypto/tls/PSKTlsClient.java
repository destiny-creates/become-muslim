package org.spongycastle.crypto.tls;

public class PSKTlsClient extends AbstractTlsClient {
    /* renamed from: i */
    protected TlsPSKIdentity f32660i;

    /* renamed from: e */
    public TlsKeyExchange mo6815e() {
        int k = TlsUtils.m27882k(this.g);
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
        return m43389b(k);
    }

    /* renamed from: f */
    public TlsAuthentication mo6816f() {
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: b */
    protected TlsKeyExchange m43389b(int i) {
        return new TlsPSKKeyExchange(i, this.c, this.f32660i, null, null, this.d, this.e, this.f);
    }
}
