package org.spongycastle.jce;

import java.security.cert.CertStoreParameters;
import org.spongycastle.x509.X509StoreParameters;

public class X509LDAPCertStoreParameters implements CertStoreParameters, X509StoreParameters {
    /* renamed from: A */
    private String f27510A;
    /* renamed from: B */
    private String f27511B;
    /* renamed from: C */
    private String f27512C;
    /* renamed from: D */
    private String f27513D;
    /* renamed from: E */
    private String f27514E;
    /* renamed from: F */
    private String f27515F;
    /* renamed from: G */
    private String f27516G;
    /* renamed from: H */
    private String f27517H;
    /* renamed from: I */
    private String f27518I;
    /* renamed from: J */
    private String f27519J;
    /* renamed from: a */
    private String f27520a;
    /* renamed from: b */
    private String f27521b;
    /* renamed from: c */
    private String f27522c;
    /* renamed from: d */
    private String f27523d;
    /* renamed from: e */
    private String f27524e;
    /* renamed from: f */
    private String f27525f;
    /* renamed from: g */
    private String f27526g;
    /* renamed from: h */
    private String f27527h;
    /* renamed from: i */
    private String f27528i;
    /* renamed from: j */
    private String f27529j;
    /* renamed from: k */
    private String f27530k;
    /* renamed from: l */
    private String f27531l;
    /* renamed from: m */
    private String f27532m;
    /* renamed from: n */
    private String f27533n;
    /* renamed from: o */
    private String f27534o;
    /* renamed from: p */
    private String f27535p;
    /* renamed from: q */
    private String f27536q;
    /* renamed from: r */
    private String f27537r;
    /* renamed from: s */
    private String f27538s;
    /* renamed from: t */
    private String f27539t;
    /* renamed from: u */
    private String f27540u;
    /* renamed from: v */
    private String f27541v;
    /* renamed from: w */
    private String f27542w;
    /* renamed from: x */
    private String f27543x;
    /* renamed from: y */
    private String f27544y;
    /* renamed from: z */
    private String f27545z;

    public static class Builder {
        /* renamed from: A */
        private String f22915A;
        /* renamed from: B */
        private String f22916B;
        /* renamed from: C */
        private String f22917C;
        /* renamed from: D */
        private String f22918D;
        /* renamed from: E */
        private String f22919E;
        /* renamed from: F */
        private String f22920F;
        /* renamed from: G */
        private String f22921G;
        /* renamed from: H */
        private String f22922H;
        /* renamed from: I */
        private String f22923I;
        /* renamed from: J */
        private String f22924J;
        /* renamed from: a */
        private String f22925a;
        /* renamed from: b */
        private String f22926b;
        /* renamed from: c */
        private String f22927c;
        /* renamed from: d */
        private String f22928d;
        /* renamed from: e */
        private String f22929e;
        /* renamed from: f */
        private String f22930f;
        /* renamed from: g */
        private String f22931g;
        /* renamed from: h */
        private String f22932h;
        /* renamed from: i */
        private String f22933i;
        /* renamed from: j */
        private String f22934j;
        /* renamed from: k */
        private String f22935k;
        /* renamed from: l */
        private String f22936l;
        /* renamed from: m */
        private String f22937m;
        /* renamed from: n */
        private String f22938n;
        /* renamed from: o */
        private String f22939o;
        /* renamed from: p */
        private String f22940p;
        /* renamed from: q */
        private String f22941q;
        /* renamed from: r */
        private String f22942r;
        /* renamed from: s */
        private String f22943s;
        /* renamed from: t */
        private String f22944t;
        /* renamed from: u */
        private String f22945u;
        /* renamed from: v */
        private String f22946v;
        /* renamed from: w */
        private String f22947w;
        /* renamed from: x */
        private String f22948x;
        /* renamed from: y */
        private String f22949y;
        /* renamed from: z */
        private String f22950z;

        public Builder() {
            this("ldap://localhost:389", "");
        }

        public Builder(String str, String str2) {
            this.f22925a = str;
            if (str2 == null) {
                this.f22926b = "";
            } else {
                this.f22926b = str2;
            }
            this.f22927c = "userCertificate";
            this.f22928d = "cACertificate";
            this.f22929e = "crossCertificatePair";
            this.f22930f = "certificateRevocationList";
            this.f22931g = "deltaRevocationList";
            this.f22932h = "authorityRevocationList";
            this.f22933i = "attributeCertificateAttribute";
            this.f22934j = "aACertificate";
            this.f22935k = "attributeDescriptorCertificate";
            this.f22936l = "attributeCertificateRevocationList";
            this.f22937m = "attributeAuthorityRevocationList";
            this.f22938n = "cn";
            this.f22939o = "cn ou o";
            this.f22940p = "cn ou o";
            this.f22941q = "cn ou o";
            this.f22942r = "cn ou o";
            this.f22943s = "cn ou o";
            this.f22944t = "cn";
            this.f22945u = "cn o ou";
            this.f22946v = "cn o ou";
            this.f22947w = "cn o ou";
            this.f22948x = "cn o ou";
            this.f22949y = "cn";
            this.f22950z = "o ou";
            this.f22915A = "o ou";
            this.f22916B = "o ou";
            this.f22917C = "o ou";
            this.f22918D = "o ou";
            this.f22919E = "cn";
            this.f22920F = "o ou";
            this.f22921G = "o ou";
            this.f22922H = "o ou";
            this.f22923I = "o ou";
            this.f22924J = "uid serialNumber cn";
        }
    }

    public Object clone() {
        return this;
    }

    public int hashCode() {
        return m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(m36147a(0, this.f27522c), this.f27523d), this.f27524e), this.f27525f), this.f27526g), this.f27527h), this.f27528i), this.f27529j), this.f27530k), this.f27531l), this.f27532m), this.f27533n), this.f27534o), this.f27535p), this.f27536q), this.f27537r), this.f27538s), this.f27539t), this.f27540u), this.f27541v), this.f27542w), this.f27543x), this.f27544y), this.f27545z), this.f27510A), this.f27511B), this.f27512C), this.f27513D), this.f27514E), this.f27515F), this.f27516G), this.f27517H), this.f27518I), this.f27519J);
    }

    /* renamed from: a */
    private int m36147a(int i, Object obj) {
        return (i * 29) + (obj == null ? null : obj.hashCode());
    }

    /* renamed from: a */
    public String m36158a() {
        return this.f27529j;
    }

    /* renamed from: b */
    public String m36159b() {
        return this.f27515F;
    }

    /* renamed from: c */
    public String m36160c() {
        return this.f27532m;
    }

    /* renamed from: d */
    public String m36161d() {
        return this.f27518I;
    }

    /* renamed from: e */
    public String m36162e() {
        return this.f27528i;
    }

    /* renamed from: f */
    public String m36163f() {
        return this.f27514E;
    }

    /* renamed from: g */
    public String m36164g() {
        return this.f27531l;
    }

    /* renamed from: h */
    public String m36165h() {
        return this.f27517H;
    }

    /* renamed from: i */
    public String m36166i() {
        return this.f27530k;
    }

    /* renamed from: j */
    public String m36167j() {
        return this.f27516G;
    }

    /* renamed from: k */
    public String m36168k() {
        return this.f27527h;
    }

    /* renamed from: l */
    public String m36169l() {
        return this.f27513D;
    }

    /* renamed from: m */
    public String m36170m() {
        return this.f27521b;
    }

    /* renamed from: n */
    public String m36171n() {
        return this.f27523d;
    }

    /* renamed from: o */
    public String m36172o() {
        return this.f27545z;
    }

    /* renamed from: p */
    public String m36173p() {
        return this.f27525f;
    }

    /* renamed from: q */
    public String m36174q() {
        return this.f27511B;
    }

    /* renamed from: r */
    public String m36175r() {
        return this.f27524e;
    }

    /* renamed from: s */
    public String m36176s() {
        return this.f27510A;
    }

    /* renamed from: t */
    public String m36177t() {
        return this.f27526g;
    }

    /* renamed from: u */
    public String m36178u() {
        return this.f27512C;
    }

    /* renamed from: v */
    public String m36179v() {
        return this.f27540u;
    }

    /* renamed from: w */
    public String m36180w() {
        return this.f27543x;
    }

    /* renamed from: x */
    public String m36181x() {
        return this.f27539t;
    }

    /* renamed from: y */
    public String m36182y() {
        return this.f27542w;
    }

    /* renamed from: z */
    public String m36183z() {
        return this.f27541v;
    }

    /* renamed from: A */
    public String m36148A() {
        return this.f27538s;
    }

    /* renamed from: B */
    public String m36149B() {
        return this.f27534o;
    }

    /* renamed from: C */
    public String m36150C() {
        return this.f27536q;
    }

    /* renamed from: D */
    public String m36151D() {
        return this.f27535p;
    }

    /* renamed from: E */
    public String m36152E() {
        return this.f27537r;
    }

    /* renamed from: F */
    public String m36153F() {
        return this.f27520a;
    }

    /* renamed from: G */
    public String m36154G() {
        return this.f27533n;
    }

    /* renamed from: H */
    public String m36155H() {
        return this.f27519J;
    }

    /* renamed from: I */
    public String m36156I() {
        return this.f27522c;
    }

    /* renamed from: J */
    public String m36157J() {
        return this.f27544y;
    }
}
