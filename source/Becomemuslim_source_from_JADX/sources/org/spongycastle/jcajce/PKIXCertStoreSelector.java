package org.spongycastle.jcajce;

import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.util.Collection;
import org.spongycastle.util.Selector;

public class PKIXCertStoreSelector<T extends Certificate> implements Selector<T> {
    /* renamed from: a */
    private final CertSelector f27371a;

    public static class Builder {
        /* renamed from: a */
        private final CertSelector f22671a;

        public Builder(CertSelector certSelector) {
            this.f22671a = (CertSelector) certSelector.clone();
        }

        /* renamed from: a */
        public PKIXCertStoreSelector<? extends Certificate> m27901a() {
            return new PKIXCertStoreSelector(this.f22671a);
        }
    }

    private PKIXCertStoreSelector(CertSelector certSelector) {
        this.f27371a = certSelector;
    }

    /* renamed from: a */
    public boolean m35980a(Certificate certificate) {
        return this.f27371a.match(certificate);
    }

    public Object clone() {
        return new PKIXCertStoreSelector(this.f27371a);
    }

    /* renamed from: a */
    public static Collection<? extends Certificate> m35978a(final PKIXCertStoreSelector pKIXCertStoreSelector, CertStore certStore) {
        return certStore.getCertificates(new CertSelector() {
            public Object clone() {
                return this;
            }

            public boolean match(Certificate certificate) {
                return pKIXCertStoreSelector == null ? true : pKIXCertStoreSelector.m35980a(certificate);
            }
        });
    }
}
