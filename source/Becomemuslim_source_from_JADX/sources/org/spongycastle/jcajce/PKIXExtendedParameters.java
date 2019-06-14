package org.spongycastle.jcajce;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.x509.GeneralName;

public class PKIXExtendedParameters implements CertPathParameters {
    /* renamed from: a */
    private final PKIXParameters f22689a;
    /* renamed from: b */
    private final PKIXCertStoreSelector f22690b;
    /* renamed from: c */
    private final Date f22691c;
    /* renamed from: d */
    private final List<PKIXCertStore> f22692d;
    /* renamed from: e */
    private final Map<GeneralName, PKIXCertStore> f22693e;
    /* renamed from: f */
    private final List<PKIXCRLStore> f22694f;
    /* renamed from: g */
    private final Map<GeneralName, PKIXCRLStore> f22695g;
    /* renamed from: h */
    private final boolean f22696h;
    /* renamed from: i */
    private final boolean f22697i;
    /* renamed from: j */
    private final int f22698j;
    /* renamed from: k */
    private final Set<TrustAnchor> f22699k;

    public static class Builder {
        /* renamed from: a */
        private final PKIXParameters f22678a;
        /* renamed from: b */
        private final Date f22679b;
        /* renamed from: c */
        private PKIXCertStoreSelector f22680c;
        /* renamed from: d */
        private List<PKIXCertStore> f22681d = new ArrayList();
        /* renamed from: e */
        private Map<GeneralName, PKIXCertStore> f22682e = new HashMap();
        /* renamed from: f */
        private List<PKIXCRLStore> f22683f = new ArrayList();
        /* renamed from: g */
        private Map<GeneralName, PKIXCRLStore> f22684g = new HashMap();
        /* renamed from: h */
        private boolean f22685h;
        /* renamed from: i */
        private int f22686i = 0;
        /* renamed from: j */
        private boolean f22687j = false;
        /* renamed from: k */
        private Set<TrustAnchor> f22688k;

        public Builder(PKIXParameters pKIXParameters) {
            this.f22678a = (PKIXParameters) pKIXParameters.clone();
            CertSelector targetCertConstraints = pKIXParameters.getTargetCertConstraints();
            if (targetCertConstraints != null) {
                this.f22680c = new org.spongycastle.jcajce.PKIXCertStoreSelector.Builder(targetCertConstraints).m27901a();
            }
            Date date = pKIXParameters.getDate();
            if (date == null) {
                date = new Date();
            }
            this.f22679b = date;
            this.f22685h = pKIXParameters.isRevocationEnabled();
            this.f22688k = pKIXParameters.getTrustAnchors();
        }

        public Builder(PKIXExtendedParameters pKIXExtendedParameters) {
            this.f22678a = pKIXExtendedParameters.f22689a;
            this.f22679b = pKIXExtendedParameters.f22691c;
            this.f22680c = pKIXExtendedParameters.f22690b;
            this.f22681d = new ArrayList(pKIXExtendedParameters.f22692d);
            this.f22682e = new HashMap(pKIXExtendedParameters.f22693e);
            this.f22683f = new ArrayList(pKIXExtendedParameters.f22694f);
            this.f22684g = new HashMap(pKIXExtendedParameters.f22695g);
            this.f22687j = pKIXExtendedParameters.f22697i;
            this.f22686i = pKIXExtendedParameters.f22698j;
            this.f22685h = pKIXExtendedParameters.m27955q();
            this.f22688k = pKIXExtendedParameters.m27947i();
        }

        /* renamed from: a */
        public Builder m27925a(PKIXCertStore pKIXCertStore) {
            this.f22681d.add(pKIXCertStore);
            return this;
        }

        /* renamed from: a */
        public Builder m27924a(PKIXCRLStore pKIXCRLStore) {
            this.f22683f.add(pKIXCRLStore);
            return this;
        }

        /* renamed from: a */
        public Builder m27926a(PKIXCertStoreSelector pKIXCertStoreSelector) {
            this.f22680c = pKIXCertStoreSelector;
            return this;
        }

        /* renamed from: a */
        public Builder m27927a(boolean z) {
            this.f22687j = z;
            return this;
        }

        /* renamed from: a */
        public Builder m27922a(int i) {
            this.f22686i = i;
            return this;
        }

        /* renamed from: a */
        public Builder m27923a(TrustAnchor trustAnchor) {
            this.f22688k = Collections.singleton(trustAnchor);
            return this;
        }

        /* renamed from: b */
        public void m27929b(boolean z) {
            this.f22685h = z;
        }

        /* renamed from: a */
        public PKIXExtendedParameters m27928a() {
            return new PKIXExtendedParameters();
        }
    }

    public Object clone() {
        return this;
    }

    private PKIXExtendedParameters(Builder builder) {
        this.f22689a = builder.f22678a;
        this.f22691c = builder.f22679b;
        this.f22692d = Collections.unmodifiableList(builder.f22681d);
        this.f22693e = Collections.unmodifiableMap(new HashMap(builder.f22682e));
        this.f22694f = Collections.unmodifiableList(builder.f22683f);
        this.f22695g = Collections.unmodifiableMap(new HashMap(builder.f22684g));
        this.f22690b = builder.f22680c;
        this.f22696h = builder.f22685h;
        this.f22697i = builder.f22687j;
        this.f22698j = builder.f22686i;
        this.f22699k = Collections.unmodifiableSet(builder.f22688k);
    }

    /* renamed from: a */
    public List<PKIXCertStore> m27939a() {
        return this.f22692d;
    }

    /* renamed from: b */
    public Map<GeneralName, PKIXCertStore> m27940b() {
        return this.f22693e;
    }

    /* renamed from: c */
    public List<PKIXCRLStore> m27941c() {
        return this.f22694f;
    }

    /* renamed from: d */
    public Map<GeneralName, PKIXCRLStore> m27942d() {
        return this.f22695g;
    }

    /* renamed from: e */
    public Date m27943e() {
        return new Date(this.f22691c.getTime());
    }

    /* renamed from: f */
    public boolean m27944f() {
        return this.f22697i;
    }

    /* renamed from: g */
    public int m27945g() {
        return this.f22698j;
    }

    /* renamed from: h */
    public PKIXCertStoreSelector m27946h() {
        return this.f22690b;
    }

    /* renamed from: i */
    public Set m27947i() {
        return this.f22699k;
    }

    /* renamed from: j */
    public Set m27948j() {
        return this.f22689a.getInitialPolicies();
    }

    /* renamed from: k */
    public String m27949k() {
        return this.f22689a.getSigProvider();
    }

    /* renamed from: l */
    public boolean m27950l() {
        return this.f22689a.isExplicitPolicyRequired();
    }

    /* renamed from: m */
    public boolean m27951m() {
        return this.f22689a.isAnyPolicyInhibited();
    }

    /* renamed from: n */
    public boolean m27952n() {
        return this.f22689a.isPolicyMappingInhibited();
    }

    /* renamed from: o */
    public List m27953o() {
        return this.f22689a.getCertPathCheckers();
    }

    /* renamed from: p */
    public List<CertStore> m27954p() {
        return this.f22689a.getCertStores();
    }

    /* renamed from: q */
    public boolean m27955q() {
        return this.f22696h;
    }
}
