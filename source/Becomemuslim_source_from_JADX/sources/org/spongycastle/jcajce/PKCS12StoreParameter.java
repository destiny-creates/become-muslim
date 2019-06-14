package org.spongycastle.jcajce;

import java.io.OutputStream;
import java.security.KeyStore.LoadStoreParameter;
import java.security.KeyStore.ProtectionParameter;

public class PKCS12StoreParameter implements LoadStoreParameter {
    /* renamed from: a */
    private final OutputStream f22660a;
    /* renamed from: b */
    private final ProtectionParameter f22661b;
    /* renamed from: c */
    private final boolean f22662c;

    public PKCS12StoreParameter(OutputStream outputStream, ProtectionParameter protectionParameter, boolean z) {
        this.f22660a = outputStream;
        this.f22661b = protectionParameter;
        this.f22662c = z;
    }

    /* renamed from: a */
    public OutputStream m27888a() {
        return this.f22660a;
    }

    public ProtectionParameter getProtectionParameter() {
        return this.f22661b;
    }

    /* renamed from: b */
    public boolean m27889b() {
        return this.f22662c;
    }
}
