package org.spongycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509CertPairStoreSelector;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPCertPairs extends X509StoreSpi {
    /* renamed from: a */
    private LDAPStoreHelper f27619a;

    /* renamed from: a */
    public Collection mo5889a(Selector selector) {
        if (!(selector instanceof X509CertPairStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CertPairStoreSelector x509CertPairStoreSelector = (X509CertPairStoreSelector) selector;
        Collection hashSet = new HashSet();
        hashSet.addAll(this.f27619a.m29494a(x509CertPairStoreSelector));
        return hashSet;
    }
}
