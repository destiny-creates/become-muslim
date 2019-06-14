package org.spongycastle.jce.provider;

import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreSpi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.spongycastle.jce.MultiCertStoreParameters;

public class MultiCertStoreSpi extends CertStoreSpi {
    /* renamed from: a */
    private MultiCertStoreParameters f22982a;

    public Collection engineGetCertificates(CertSelector certSelector) {
        boolean b = this.f22982a.m28122b();
        Collection arrayList = b ? new ArrayList() : Collections.EMPTY_LIST;
        for (CertStore certificates : this.f22982a.m28121a()) {
            Collection certificates2 = certificates.getCertificates(certSelector);
            if (b) {
                arrayList.addAll(certificates2);
            } else if (!certificates2.isEmpty()) {
                return certificates2;
            }
        }
        return arrayList;
    }

    public Collection engineGetCRLs(CRLSelector cRLSelector) {
        boolean b = this.f22982a.m28122b();
        Collection arrayList = b ? new ArrayList() : Collections.EMPTY_LIST;
        for (CertStore cRLs : this.f22982a.m28121a()) {
            Collection cRLs2 = cRLs.getCRLs(cRLSelector);
            if (b) {
                arrayList.addAll(cRLs2);
            } else if (!cRLs2.isEmpty()) {
                return cRLs2;
            }
        }
        return arrayList;
    }
}
