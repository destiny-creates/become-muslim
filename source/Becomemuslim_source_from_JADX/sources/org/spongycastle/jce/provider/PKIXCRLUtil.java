package org.spongycastle.jce.provider;

import java.security.cert.CertStore;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.spongycastle.jcajce.PKIXCRLStoreSelector;
import org.spongycastle.util.Store;

class PKIXCRLUtil {
    PKIXCRLUtil() {
    }

    /* renamed from: a */
    public Set m28179a(PKIXCRLStoreSelector pKIXCRLStoreSelector, Date date, List list, List list2) {
        Set<X509CRL> hashSet = new HashSet();
        try {
            hashSet.addAll(m28178a(pKIXCRLStoreSelector, list2));
            hashSet.addAll(m28178a(pKIXCRLStoreSelector, list));
            list = new HashSet();
            for (X509CRL x509crl : hashSet) {
                if (x509crl.getNextUpdate().after(date)) {
                    X509Certificate c = pKIXCRLStoreSelector.m35977c();
                    if (c == null) {
                        list.add(x509crl);
                    } else if (x509crl.getThisUpdate().before(c.getNotAfter())) {
                        list.add(x509crl);
                    }
                }
            }
            return list;
        } catch (PKIXCRLStoreSelector pKIXCRLStoreSelector2) {
            throw new AnnotatedException("Exception obtaining complete CRLs.", pKIXCRLStoreSelector2);
        }
    }

    /* renamed from: a */
    private final Collection m28178a(PKIXCRLStoreSelector pKIXCRLStoreSelector, List list) {
        AnnotatedException annotatedException;
        Collection hashSet = new HashSet();
        AnnotatedException annotatedException2 = null;
        Object obj = null;
        for (Object next : list) {
            if (next instanceof Store) {
                try {
                    hashSet.addAll(((Store) next).mo5936a(pKIXCRLStoreSelector));
                } catch (Throwable e) {
                    annotatedException = new AnnotatedException("Exception searching in X.509 CRL store.", e);
                    annotatedException2 = annotatedException;
                }
            } else {
                try {
                    hashSet.addAll(PKIXCRLStoreSelector.m35972a(pKIXCRLStoreSelector, (CertStore) next));
                } catch (Throwable e2) {
                    annotatedException = new AnnotatedException("Exception searching in X.509 CRL store.", e2);
                    annotatedException2 = annotatedException;
                }
            }
            obj = 1;
        }
        if (obj == null) {
            if (annotatedException2 != null) {
                throw annotatedException2;
            }
        }
        return hashSet;
    }
}
