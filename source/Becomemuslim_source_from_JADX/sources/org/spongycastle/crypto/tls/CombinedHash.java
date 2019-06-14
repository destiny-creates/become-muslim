package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;

class CombinedHash implements TlsHandshakeHash {
    /* renamed from: a */
    protected TlsContext f31814a;
    /* renamed from: b */
    protected Digest f31815b;
    /* renamed from: c */
    protected Digest f31816c;

    /* renamed from: d */
    public TlsHandshakeHash mo6483d() {
        return this;
    }

    /* renamed from: e */
    public void mo6484e() {
    }

    CombinedHash() {
        this.f31815b = TlsUtils.m27855c((short) 1);
        this.f31816c = TlsUtils.m27855c((short) 2);
    }

    CombinedHash(CombinedHash combinedHash) {
        this.f31814a = combinedHash.f31814a;
        this.f31815b = TlsUtils.m27800a((short) 1, combinedHash.f31815b);
        this.f31816c = TlsUtils.m27800a((short) 2, combinedHash.f31816c);
    }

    /* renamed from: a */
    public void m40865a(TlsContext tlsContext) {
        this.f31814a = tlsContext;
    }

    /* renamed from: a */
    public void mo6481a(short s) {
        throw new IllegalStateException("CombinedHash only supports calculating the legacy PRF for handshake hash");
    }

    /* renamed from: f */
    public TlsHandshakeHash mo6485f() {
        return new CombinedHash(this);
    }

    /* renamed from: g */
    public Digest mo6486g() {
        return new CombinedHash(this);
    }

    /* renamed from: b */
    public byte[] mo6482b(short s) {
        throw new IllegalStateException("CombinedHash doesn't support multiple hashes");
    }

    /* renamed from: a */
    public String mo5729a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f31815b.mo5729a());
        stringBuilder.append(" and ");
        stringBuilder.append(this.f31816c.mo5729a());
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5732b() {
        return this.f31815b.mo5732b() + this.f31816c.mo5732b();
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        this.f31815b.mo5730a(b);
        this.f31816c.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        this.f31815b.mo5731a(bArr, i, i2);
        this.f31816c.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        if (this.f31814a != null && TlsUtils.m27825a(this.f31814a)) {
            m40864a(this.f31815b, SSL3Mac.f27309a, SSL3Mac.f27310b, 48);
            m40864a(this.f31816c, SSL3Mac.f27309a, SSL3Mac.f27310b, 40);
        }
        int a = this.f31815b.mo5728a(bArr, i);
        return a + this.f31816c.mo5728a(bArr, i + a);
    }

    /* renamed from: c */
    public void mo5733c() {
        this.f31815b.mo5733c();
        this.f31816c.mo5733c();
    }

    /* renamed from: a */
    protected void m40864a(Digest digest, byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = this.f31814a.mo5810c().f22544f;
        digest.mo5731a(bArr3, 0, bArr3.length);
        digest.mo5731a(bArr, 0, i);
        bArr = new byte[digest.mo5732b()];
        digest.mo5728a(bArr, 0);
        digest.mo5731a(bArr3, 0, bArr3.length);
        digest.mo5731a(bArr2, 0, i);
        digest.mo5731a(bArr, 0, bArr.length);
    }
}
