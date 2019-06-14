package org.spongycastle.crypto.tls;

import java.util.Hashtable;

public class SRPTlsClient extends AbstractTlsClient {
    /* renamed from: i */
    protected TlsSRPGroupVerifier f32662i;
    /* renamed from: j */
    protected byte[] f32663j;
    /* renamed from: k */
    protected byte[] f32664k;

    /* renamed from: g */
    protected boolean m43402g() {
        return false;
    }

    /* renamed from: a */
    public void mo6456a(Hashtable hashtable) {
        if (!TlsUtils.m27823a(hashtable, TlsSRPUtils.f22632a, (short) 47)) {
            if (m43402g()) {
                throw new TlsFatalAlert((short) 47);
            }
        }
        super.mo6456a(hashtable);
    }

    /* renamed from: e */
    public TlsKeyExchange mo6815e() {
        int k = TlsUtils.m27882k(this.g);
        switch (k) {
            case 21:
            case 22:
            case 23:
                return m43399b(k);
            default:
                throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: f */
    public TlsAuthentication mo6816f() {
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: b */
    protected TlsKeyExchange m43399b(int i) {
        return new TlsSRPKeyExchange(i, this.c, this.f32662i, this.f32663j, this.f32664k);
    }
}
