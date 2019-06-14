package org.spongycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509CertPairStoreSelector;
import org.spongycastle.x509.X509CertStoreSelector;
import org.spongycastle.x509.X509CertificatePair;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPCerts extends X509StoreSpi {
    /* renamed from: a */
    private LDAPStoreHelper f27620a;

    /* renamed from: a */
    public Collection mo5889a(Selector selector) {
        if (!(selector instanceof X509CertStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CertStoreSelector x509CertStoreSelector = (X509CertStoreSelector) selector;
        Collection hashSet = new HashSet();
        if (x509CertStoreSelector.getBasicConstraints() > 0) {
            hashSet.addAll(this.f27620a.m29498b(x509CertStoreSelector));
            hashSet.addAll(m36248a(x509CertStoreSelector));
        } else if (x509CertStoreSelector.getBasicConstraints() == -2) {
            hashSet.addAll(this.f27620a.m29495a(x509CertStoreSelector));
        } else {
            hashSet.addAll(this.f27620a.m29495a(x509CertStoreSelector));
            hashSet.addAll(this.f27620a.m29498b(x509CertStoreSelector));
            hashSet.addAll(m36248a(x509CertStoreSelector));
        }
        return hashSet;
    }

    /* renamed from: a */
    private Collection m36248a(X509CertStoreSelector x509CertStoreSelector) {
        Collection hashSet = new HashSet();
        X509CertPairStoreSelector x509CertPairStoreSelector = new X509CertPairStoreSelector();
        x509CertPairStoreSelector.m36635a(x509CertStoreSelector);
        x509CertPairStoreSelector.m36638b(new X509CertStoreSelector());
        X509CertStoreSelector<X509CertificatePair> hashSet2 = new HashSet(this.f27620a.m29494a(x509CertPairStoreSelector));
        Collection hashSet3 = new HashSet();
        Collection hashSet4 = new HashSet();
        for (X509CertificatePair x509CertificatePair : hashSet2) {
            if (x509CertificatePair.m29471a() != null) {
                hashSet3.add(x509CertificatePair.m29471a());
            }
            if (x509CertificatePair.m29472b() != null) {
                hashSet4.add(x509CertificatePair.m29472b());
            }
        }
        hashSet.addAll(hashSet3);
        hashSet.addAll(hashSet4);
        return hashSet;
    }
}
