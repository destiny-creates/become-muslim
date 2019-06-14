package org.spongycastle.crypto.ec;

import org.spongycastle.math.ec.ECPoint;

public class ECPair {
    /* renamed from: a */
    private final ECPoint f22308a;
    /* renamed from: b */
    private final ECPoint f22309b;

    /* renamed from: a */
    public ECPoint m27412a() {
        return this.f22308a;
    }

    /* renamed from: b */
    public ECPoint m27414b() {
        return this.f22309b;
    }

    /* renamed from: a */
    public boolean m27413a(ECPair eCPair) {
        return (!eCPair.m27412a().m28397a(m27412a()) || eCPair.m27414b().m28397a(m27414b()) == null) ? null : true;
    }

    public boolean equals(Object obj) {
        return obj instanceof ECPair ? m27413a((ECPair) obj) : null;
    }

    public int hashCode() {
        return this.f22308a.hashCode() + (this.f22309b.hashCode() * 37);
    }
}
