package org.spongycastle.x509;

import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.util.Selector;

public class ExtendedPKIXBuilderParameters extends ExtendedPKIXParameters {
    /* renamed from: a */
    private int f27902a = 5;
    /* renamed from: b */
    private Set f27903b = Collections.EMPTY_SET;

    /* renamed from: a */
    public Set m36619a() {
        return Collections.unmodifiableSet(this.f27903b);
    }

    public ExtendedPKIXBuilderParameters(Set set, Selector selector) {
        super(set);
        m29454a(selector);
    }

    /* renamed from: b */
    public int m36621b() {
        return this.f27902a;
    }

    /* renamed from: a */
    protected void mo5940a(PKIXParameters pKIXParameters) {
        super.mo5940a(pKIXParameters);
        if (pKIXParameters instanceof ExtendedPKIXBuilderParameters) {
            ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) pKIXParameters;
            this.f27902a = extendedPKIXBuilderParameters.f27902a;
            this.f27903b = new HashSet(extendedPKIXBuilderParameters.f27903b);
        }
        if (pKIXParameters instanceof PKIXBuilderParameters) {
            this.f27902a = ((PKIXBuilderParameters) pKIXParameters).getMaxPathLength();
        }
    }

    public Object clone() {
        try {
            ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = new ExtendedPKIXBuilderParameters(getTrustAnchors(), m29459g());
            extendedPKIXBuilderParameters.mo5940a(this);
            return extendedPKIXBuilderParameters;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
