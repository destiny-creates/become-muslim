package org.spongycastle.crypto.tls;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Shorts;

class DeferredHash implements TlsHandshakeHash {
    /* renamed from: a */
    protected TlsContext f31817a;
    /* renamed from: b */
    private DigestInputBuffer f31818b;
    /* renamed from: c */
    private Hashtable f31819c;
    /* renamed from: d */
    private Short f31820d;

    DeferredHash() {
        this.f31818b = new DigestInputBuffer();
        this.f31819c = new Hashtable();
        this.f31820d = null;
    }

    private DeferredHash(Short sh, Digest digest) {
        this.f31818b = null;
        this.f31819c = new Hashtable();
        this.f31820d = sh;
        this.f31819c.put(sh, digest);
    }

    /* renamed from: a */
    public void m40903a(TlsContext tlsContext) {
        this.f31817a = tlsContext;
    }

    /* renamed from: d */
    public TlsHandshakeHash mo6483d() {
        int b = this.f31817a.mo5810c().m27597b();
        if (b == 0) {
            Object combinedHash = new CombinedHash();
            combinedHash.m40865a(this.f31817a);
            this.f31818b.m27554a(combinedHash);
            return combinedHash.mo6483d();
        }
        this.f31820d = Shorts.m29415a(TlsUtils.m27879h(b));
        m40902a(this.f31820d);
        return this;
    }

    /* renamed from: a */
    public void mo6481a(short s) {
        if (this.f31818b != null) {
            m40902a(Shorts.m29415a(s));
            return;
        }
        throw new IllegalStateException("Too late to track more hash algorithms");
    }

    /* renamed from: e */
    public void mo6484e() {
        m40913h();
    }

    /* renamed from: f */
    public TlsHandshakeHash mo6485f() {
        Digest a = TlsUtils.m27800a(this.f31820d.shortValue(), (Digest) this.f31819c.get(this.f31820d));
        if (this.f31818b != null) {
            this.f31818b.m27554a(a);
        }
        TlsHandshakeHash deferredHash = new DeferredHash(this.f31820d, a);
        deferredHash.m40903a(this.f31817a);
        return deferredHash;
    }

    /* renamed from: g */
    public Digest mo6486g() {
        m40913h();
        if (this.f31818b == null) {
            return TlsUtils.m27800a(this.f31820d.shortValue(), (Digest) this.f31819c.get(this.f31820d));
        }
        Digest c = TlsUtils.m27855c(this.f31820d.shortValue());
        this.f31818b.m27554a(c);
        return c;
    }

    /* renamed from: b */
    public byte[] mo6482b(short s) {
        Digest digest = (Digest) this.f31819c.get(Shorts.m29415a(s));
        if (digest != null) {
            s = TlsUtils.m27800a(s, digest);
            if (this.f31818b != null) {
                this.f31818b.m27554a(s);
            }
            byte[] bArr = new byte[s.mo5732b()];
            s.mo5728a(bArr, 0);
            return bArr;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HashAlgorithm ");
        stringBuilder.append(s);
        stringBuilder.append(" is not being tracked");
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    public String mo5729a() {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    /* renamed from: b */
    public int mo5732b() {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        if (this.f31818b != null) {
            this.f31818b.write(b);
            return;
        }
        Enumeration elements = this.f31819c.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).mo5730a(b);
        }
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        if (this.f31818b != null) {
            this.f31818b.write(bArr, i, i2);
            return;
        }
        Enumeration elements = this.f31819c.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).mo5731a(bArr, i, i2);
        }
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    /* renamed from: c */
    public void mo5733c() {
        if (this.f31818b != null) {
            this.f31818b.reset();
            return;
        }
        Enumeration elements = this.f31819c.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).mo5733c();
        }
    }

    /* renamed from: h */
    protected void m40913h() {
        if (this.f31818b != null && this.f31819c.size() <= 4) {
            Enumeration elements = this.f31819c.elements();
            while (elements.hasMoreElements()) {
                this.f31818b.m27554a((Digest) elements.nextElement());
            }
            this.f31818b = null;
        }
    }

    /* renamed from: a */
    protected void m40902a(Short sh) {
        if (!this.f31819c.containsKey(sh)) {
            this.f31819c.put(sh, TlsUtils.m27855c(sh.shortValue()));
        }
    }
}
