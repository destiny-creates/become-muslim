package org.spongycastle.x509;

import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.spongycastle.util.Selector;

public class ExtendedPKIXParameters extends PKIXParameters {
    /* renamed from: a */
    private List f23477a = new ArrayList();
    /* renamed from: b */
    private Selector f23478b;
    /* renamed from: c */
    private boolean f23479c;
    /* renamed from: d */
    private List f23480d = new ArrayList();
    /* renamed from: e */
    private Set f23481e = new HashSet();
    /* renamed from: f */
    private Set f23482f = new HashSet();
    /* renamed from: g */
    private Set f23483g = new HashSet();
    /* renamed from: h */
    private Set f23484h = new HashSet();
    /* renamed from: i */
    private int f23485i = 0;
    /* renamed from: j */
    private boolean f23486j = false;

    public ExtendedPKIXParameters(Set set) {
        super(set);
    }

    /* renamed from: a */
    protected void mo5940a(PKIXParameters pKIXParameters) {
        setDate(pKIXParameters.getDate());
        setCertPathCheckers(pKIXParameters.getCertPathCheckers());
        setCertStores(pKIXParameters.getCertStores());
        setAnyPolicyInhibited(pKIXParameters.isAnyPolicyInhibited());
        setExplicitPolicyRequired(pKIXParameters.isExplicitPolicyRequired());
        setPolicyMappingInhibited(pKIXParameters.isPolicyMappingInhibited());
        setRevocationEnabled(pKIXParameters.isRevocationEnabled());
        setInitialPolicies(pKIXParameters.getInitialPolicies());
        setPolicyQualifiersRejected(pKIXParameters.getPolicyQualifiersRejected());
        setSigProvider(pKIXParameters.getSigProvider());
        setTargetCertConstraints(pKIXParameters.getTargetCertConstraints());
        try {
            setTrustAnchors(pKIXParameters.getTrustAnchors());
            if (pKIXParameters instanceof ExtendedPKIXParameters) {
                Selector selector;
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) pKIXParameters;
                this.f23485i = extendedPKIXParameters.f23485i;
                this.f23486j = extendedPKIXParameters.f23486j;
                this.f23479c = extendedPKIXParameters.f23479c;
                if (extendedPKIXParameters.f23478b == null) {
                    selector = null;
                } else {
                    selector = (Selector) extendedPKIXParameters.f23478b.clone();
                }
                this.f23478b = selector;
                this.f23477a = new ArrayList(extendedPKIXParameters.f23477a);
                this.f23480d = new ArrayList(extendedPKIXParameters.f23480d);
                this.f23481e = new HashSet(extendedPKIXParameters.f23481e);
                this.f23483g = new HashSet(extendedPKIXParameters.f23483g);
                this.f23482f = new HashSet(extendedPKIXParameters.f23482f);
                this.f23484h = new HashSet(extendedPKIXParameters.f23484h);
            }
        } catch (PKIXParameters pKIXParameters2) {
            throw new RuntimeException(pKIXParameters2.getMessage());
        }
    }

    /* renamed from: c */
    public boolean m29455c() {
        return this.f23486j;
    }

    /* renamed from: d */
    public int m29456d() {
        return this.f23485i;
    }

    public void setCertStores(List list) {
        if (list != null) {
            for (CertStore addCertStore : list) {
                addCertStore(addCertStore);
            }
        }
    }

    /* renamed from: e */
    public List m29457e() {
        return Collections.unmodifiableList(this.f23480d);
    }

    /* renamed from: f */
    public List m29458f() {
        return Collections.unmodifiableList(new ArrayList(this.f23477a));
    }

    public Object clone() {
        try {
            ExtendedPKIXParameters extendedPKIXParameters = new ExtendedPKIXParameters(getTrustAnchors());
            extendedPKIXParameters.mo5940a((PKIXParameters) this);
            return extendedPKIXParameters;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* renamed from: g */
    public Selector m29459g() {
        return this.f23478b != null ? (Selector) this.f23478b.clone() : null;
    }

    /* renamed from: a */
    public void m29454a(Selector selector) {
        if (selector != null) {
            this.f23478b = (Selector) selector.clone();
        } else {
            this.f23478b = null;
        }
    }

    public void setTargetCertConstraints(CertSelector certSelector) {
        super.setTargetCertConstraints(certSelector);
        if (certSelector != null) {
            this.f23478b = X509CertStoreSelector.m36639a((X509CertSelector) certSelector);
        } else {
            this.f23478b = null;
        }
    }

    /* renamed from: h */
    public Set m29460h() {
        return Collections.unmodifiableSet(this.f23482f);
    }

    /* renamed from: i */
    public Set m29461i() {
        return Collections.unmodifiableSet(this.f23483g);
    }

    /* renamed from: j */
    public Set m29462j() {
        return Collections.unmodifiableSet(this.f23484h);
    }
}
