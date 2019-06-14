package org.spongycastle.jcajce;

import java.security.InvalidParameterException;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PKIXExtendedBuilderParameters implements CertPathParameters {
    /* renamed from: a */
    private final PKIXExtendedParameters f22675a;
    /* renamed from: b */
    private final Set<X509Certificate> f22676b;
    /* renamed from: c */
    private final int f22677c;

    public static class Builder {
        /* renamed from: a */
        private final PKIXExtendedParameters f22672a;
        /* renamed from: b */
        private int f22673b = 5;
        /* renamed from: c */
        private Set<X509Certificate> f22674c = new HashSet();

        public Builder(PKIXBuilderParameters pKIXBuilderParameters) {
            this.f22672a = new org.spongycastle.jcajce.PKIXExtendedParameters.Builder((PKIXParameters) pKIXBuilderParameters).m27928a();
            this.f22673b = pKIXBuilderParameters.getMaxPathLength();
        }

        public Builder(PKIXExtendedParameters pKIXExtendedParameters) {
            this.f22672a = pKIXExtendedParameters;
        }

        /* renamed from: a */
        public Builder m27906a(Set<X509Certificate> set) {
            this.f22674c.addAll(set);
            return this;
        }

        /* renamed from: a */
        public Builder m27905a(int i) {
            if (i >= -1) {
                this.f22673b = i;
                return this;
            }
            throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
        }

        /* renamed from: a */
        public PKIXExtendedBuilderParameters m27907a() {
            return new PKIXExtendedBuilderParameters();
        }
    }

    public Object clone() {
        return this;
    }

    private PKIXExtendedBuilderParameters(Builder builder) {
        this.f22675a = builder.f22672a;
        this.f22676b = Collections.unmodifiableSet(builder.f22674c);
        this.f22677c = builder.f22673b;
    }

    /* renamed from: a */
    public PKIXExtendedParameters m27908a() {
        return this.f22675a;
    }

    /* renamed from: b */
    public Set m27909b() {
        return this.f22676b;
    }

    /* renamed from: c */
    public int m27910c() {
        return this.f22677c;
    }
}
