package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import p286d.C5869f;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            if (str != null) {
                for (String pin : strArr) {
                    this.pins.add(new Pin(str, pin));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), null);
        }
    }

    static final class Pin {
        private static final String WILDCARD = "*.";
        final String canonicalHostname;
        final C5869f hash;
        final String hashAlgorithm;
        final String pattern;

        Pin(String str, String str2) {
            StringBuilder stringBuilder;
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(str.substring(WILDCARD.length()));
                str = HttpUrl.parse(stringBuilder.toString()).host();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(str);
                str = HttpUrl.parse(stringBuilder.toString()).host();
            }
            this.canonicalHostname = str;
            if (str2.startsWith("sha1/") != null) {
                this.hashAlgorithm = "sha1/";
                this.hash = C5869f.m24700b(str2.substring("sha1/".length()));
            } else if (str2.startsWith("sha256/") != null) {
                this.hashAlgorithm = "sha256/";
                this.hash = C5869f.m24700b(str2.substring("sha256/".length()));
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("pins must start with 'sha256/' or 'sha1/': ");
                stringBuilder.append(str2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (this.hash == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("pins must be base64: ");
                stringBuilder.append(str2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        boolean matches(String str) {
            if (!this.pattern.startsWith(WILDCARD)) {
                return str.equals(this.canonicalHostname);
            }
            int indexOf = str.indexOf(46);
            boolean z = true;
            if ((str.length() - indexOf) - 1 == this.canonicalHostname.length()) {
                if (str.regionMatches(false, indexOf + 1, this.canonicalHostname, 0, this.canonicalHostname.length()) != null) {
                    return z;
                }
            }
            z = false;
            return z;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                if (this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash) != null) {
                    return true;
                }
            }
            return null;
        }

        public int hashCode() {
            return ((((527 + this.pattern.hashCode()) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.hashAlgorithm);
            stringBuilder.append(this.hash.mo5103b());
            return stringBuilder.toString();
        }
    }

    CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins) != null) {
                return z;
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        return ((this.certificateChainCleaner != null ? this.certificateChainCleaner.hashCode() : 0) * 31) + this.pins.hashCode();
    }

    public void check(String str, List<Certificate> list) {
        List findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            int i;
            if (this.certificateChainCleaner != null) {
                list = this.certificateChainCleaner.clean(list, str);
            }
            int size = list.size();
            for (i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = findMatchingPins.size();
                Object obj = null;
                Object obj2 = obj;
                for (int i2 = 0; i2 < size2; i2++) {
                    Pin pin = (Pin) findMatchingPins.get(i2);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (obj == null) {
                            obj = sha256(x509Certificate);
                        }
                        if (pin.hash.equals(obj)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = sha1(x509Certificate);
                        }
                        if (pin.hash.equals(obj2)) {
                            return;
                        }
                    } else {
                        list = new StringBuilder();
                        list.append("unsupported hashAlgorithm: ");
                        list.append(pin.hashAlgorithm);
                        throw new AssertionError(list.toString());
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Certificate pinning failure!");
            stringBuilder.append("\n  Peer certificate chain:");
            i = list.size();
            for (int i3 = 0; i3 < i; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                stringBuilder.append("\n    ");
                stringBuilder.append(pin(x509Certificate2));
                stringBuilder.append(": ");
                stringBuilder.append(x509Certificate2.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ");
            stringBuilder.append(str);
            stringBuilder.append(":");
            str = findMatchingPins.size();
            for (int i4 = 0; i4 < str; i4++) {
                Pin pin2 = (Pin) findMatchingPins.get(i4);
                stringBuilder.append("\n    ");
                stringBuilder.append(pin2);
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }

    public void check(String str, Certificate... certificateArr) {
        check(str, Arrays.asList(certificateArr));
    }

    List<Pin> findMatchingPins(String str) {
        List<Pin> emptyList = Collections.emptyList();
        for (Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(pin);
            }
        }
        return emptyList;
    }

    CertificatePinner withCertificateChainCleaner(CertificateChainCleaner certificateChainCleaner) {
        if (Util.equal(this.certificateChainCleaner, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sha256/");
            stringBuilder.append(sha256((X509Certificate) certificate).mo5103b());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static C5869f sha1(X509Certificate x509Certificate) {
        return C5869f.m24699a(x509Certificate.getPublicKey().getEncoded()).mo5105d();
    }

    static C5869f sha256(X509Certificate x509Certificate) {
        return C5869f.m24699a(x509Certificate.getPublicKey().getEncoded()).mo5106e();
    }
}
