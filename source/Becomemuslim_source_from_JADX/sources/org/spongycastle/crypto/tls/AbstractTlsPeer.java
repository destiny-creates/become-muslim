package org.spongycastle.crypto.tls;

public abstract class AbstractTlsPeer implements TlsPeer {
    /* renamed from: a */
    public void mo5822a(short s, short s2) {
    }

    /* renamed from: a */
    public void mo5823a(short s, short s2, String str, Throwable th) {
    }

    /* renamed from: a */
    public void mo5824a(boolean z) {
        if (!z) {
            throw new TlsFatalAlert((short) 40);
        }
    }
}
