package org.spongycastle.jce.provider;

import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CertStoreCollectionSpi extends CertStoreSpi {
    /* renamed from: a */
    private CollectionCertStoreParameters f22970a;

    public Collection engineGetCertificates(CertSelector certSelector) {
        Collection arrayList = new ArrayList();
        Iterator it = this.f22970a.getCollection().iterator();
        if (certSelector == null) {
            while (it.hasNext() != null) {
                certSelector = it.next();
                if (certSelector instanceof Certificate) {
                    arrayList.add(certSelector);
                }
            }
        } else {
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof Certificate) && certSelector.match((Certificate) next)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public Collection engineGetCRLs(CRLSelector cRLSelector) {
        Collection arrayList = new ArrayList();
        Iterator it = this.f22970a.getCollection().iterator();
        if (cRLSelector == null) {
            while (it.hasNext() != null) {
                cRLSelector = it.next();
                if (cRLSelector instanceof CRL) {
                    arrayList.add(cRLSelector);
                }
            }
        } else {
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof CRL) && cRLSelector.match((CRL) next)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}
