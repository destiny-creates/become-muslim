package org.spongycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509CRLStoreSelector;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPCRLs extends X509StoreSpi {
    /* renamed from: a */
    private LDAPStoreHelper f27618a;

    /* renamed from: a */
    public Collection mo5889a(Selector selector) {
        if (!(selector instanceof X509CRLStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CRLStoreSelector x509CRLStoreSelector = (X509CRLStoreSelector) selector;
        Collection hashSet = new HashSet();
        if (x509CRLStoreSelector.m36632b()) {
            hashSet.addAll(this.f27618a.m29501d(x509CRLStoreSelector));
        } else {
            hashSet.addAll(this.f27618a.m29501d(x509CRLStoreSelector));
            hashSet.addAll(this.f27618a.m29500c(x509CRLStoreSelector));
            hashSet.addAll(this.f27618a.m29497b(x509CRLStoreSelector));
            hashSet.addAll(this.f27618a.m29493a(x509CRLStoreSelector));
            hashSet.addAll(this.f27618a.m29502e(x509CRLStoreSelector));
        }
        return hashSet;
    }
}
