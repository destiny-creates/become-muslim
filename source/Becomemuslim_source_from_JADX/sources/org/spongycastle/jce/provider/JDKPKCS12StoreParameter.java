package org.spongycastle.jce.provider;

import java.io.OutputStream;
import java.security.KeyStore.LoadStoreParameter;
import java.security.KeyStore.ProtectionParameter;

public class JDKPKCS12StoreParameter implements LoadStoreParameter {
    /* renamed from: a */
    private OutputStream f22979a;
    /* renamed from: b */
    private ProtectionParameter f22980b;
    /* renamed from: c */
    private boolean f22981c;

    /* renamed from: a */
    public OutputStream m28172a() {
        return this.f22979a;
    }

    public ProtectionParameter getProtectionParameter() {
        return this.f22980b;
    }

    /* renamed from: b */
    public boolean m28173b() {
        return this.f22981c;
    }
}
