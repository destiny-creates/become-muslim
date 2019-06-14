package org.spongycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPAttrCerts extends X509StoreSpi {
    /* renamed from: a */
    private LDAPStoreHelper f27617a;

    /* renamed from: a */
    public Collection mo5889a(Selector selector) {
        if (!(selector instanceof X509AttributeCertStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509AttributeCertStoreSelector x509AttributeCertStoreSelector = (X509AttributeCertStoreSelector) selector;
        Collection hashSet = new HashSet();
        hashSet.addAll(this.f27617a.m29492a(x509AttributeCertStoreSelector));
        hashSet.addAll(this.f27617a.m29499c(x509AttributeCertStoreSelector));
        hashSet.addAll(this.f27617a.m29496b(x509AttributeCertStoreSelector));
        return hashSet;
    }
}
