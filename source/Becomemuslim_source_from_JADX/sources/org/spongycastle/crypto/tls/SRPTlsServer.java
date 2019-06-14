package org.spongycastle.crypto.tls;

import java.util.Hashtable;

public class SRPTlsServer extends AbstractTlsServer {
    /* renamed from: s */
    protected TlsSRPIdentityManager f32665s;
    /* renamed from: t */
    protected byte[] f32666t;
    /* renamed from: u */
    protected TlsSRPLoginParameters f32667u;

    /* renamed from: r */
    protected TlsSignerCredentials m43407r() {
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: s */
    protected TlsSignerCredentials m43408s() {
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: f */
    protected int[] mo6817f() {
        return new int[]{49186, 49183, 49185, 49182, 49184, 49181};
    }

    /* renamed from: a */
    public void mo6465a(Hashtable hashtable) {
        super.mo6465a(hashtable);
        this.f32666t = TlsSRPUtils.m27785a(hashtable);
    }

    /* renamed from: k */
    public int mo6473k() {
        int k = super.mo6473k();
        if (TlsSRPUtils.m27784a(k)) {
            if (this.f32666t != null) {
                this.f32667u = this.f32665s.mo5834a(this.f32666t);
            }
            if (this.f32667u == null) {
                throw new TlsFatalAlert((short) 115);
            }
        }
        return k;
    }

    /* renamed from: t */
    public TlsCredentials mo6818t() {
        switch (TlsUtils.m27882k(this.p)) {
            case 21:
                return null;
            case 22:
                return m43407r();
            case 23:
                return m43408s();
            default:
                throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: u */
    public TlsKeyExchange mo6819u() {
        int k = TlsUtils.m27882k(this.p);
        switch (k) {
            case 21:
            case 22:
            case 23:
                return m43403a(k);
            default:
                throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: a */
    protected TlsKeyExchange m43403a(int i) {
        return new TlsSRPKeyExchange(i, this.j, this.f32666t, this.f32667u);
    }
}
