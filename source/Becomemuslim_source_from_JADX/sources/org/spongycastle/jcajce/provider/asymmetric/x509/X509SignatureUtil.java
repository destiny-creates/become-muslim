package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

class X509SignatureUtil {
    /* renamed from: a */
    private static final ASN1Null f22853a = DERNull.f32850a;

    X509SignatureUtil() {
    }

    /* renamed from: a */
    static void m28042a(Signature signature, ASN1Encodable aSN1Encodable) {
        StringBuilder stringBuilder;
        if (aSN1Encodable != null && !f22853a.equals(aSN1Encodable)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(aSN1Encodable.mo5709e().mo6822f());
                if (signature.getAlgorithm().endsWith("MGF1") != null) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (Signature signature2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Exception extracting parameters: ");
                        stringBuilder.append(signature2.getMessage());
                        throw new SignatureException(stringBuilder.toString());
                    }
                }
            } catch (Signature signature22) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("IOException decoding parameters: ");
                stringBuilder.append(signature22.getMessage());
                throw new SignatureException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    static String m28041a(AlgorithmIdentifier algorithmIdentifier) {
        Object b = algorithmIdentifier.m40231b();
        int i = 0;
        if (!(b == null || f22853a.equals(b))) {
            StringBuilder stringBuilder;
            if (algorithmIdentifier.m40230a().equals(PKCSObjectIdentifiers.f21864k)) {
                algorithmIdentifier = RSASSAPSSparams.m40148a(b);
                stringBuilder = new StringBuilder();
                stringBuilder.append(m28040a(algorithmIdentifier.m40149a().m40230a()));
                stringBuilder.append("withRSAandMGF1");
                return stringBuilder.toString();
            } else if (algorithmIdentifier.m40230a().equals(X9ObjectIdentifiers.f22171l)) {
                algorithmIdentifier = ASN1Sequence.m43000a(b);
                stringBuilder = new StringBuilder();
                stringBuilder.append(m28040a((ASN1ObjectIdentifier) algorithmIdentifier.mo6860a(0)));
                stringBuilder.append("withECDSA");
                return stringBuilder.toString();
            }
        }
        Provider provider = Security.getProvider("SC");
        if (provider != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.Signature.");
            stringBuilder2.append(algorithmIdentifier.m40230a().m42986b());
            String property = provider.getProperty(stringBuilder2.toString());
            if (property != null) {
                return property;
            }
        }
        Provider[] providers = Security.getProviders();
        while (i != providers.length) {
            Provider provider2 = providers[i];
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.Signature.");
            stringBuilder3.append(algorithmIdentifier.m40230a().m42986b());
            String property2 = provider2.getProperty(stringBuilder3.toString());
            if (property2 != null) {
                return property2;
            }
            i++;
        }
        return algorithmIdentifier.m40230a().m42986b();
    }

    /* renamed from: a */
    private static String m28040a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (PKCSObjectIdentifiers.f21841H.equals(aSN1ObjectIdentifier)) {
            return "MD5";
        }
        if (OIWObjectIdentifiers.f21830i.equals(aSN1ObjectIdentifier)) {
            return "SHA1";
        }
        if (NISTObjectIdentifiers.f21785f.equals(aSN1ObjectIdentifier)) {
            return "SHA224";
        }
        if (NISTObjectIdentifiers.f21782c.equals(aSN1ObjectIdentifier)) {
            return "SHA256";
        }
        if (NISTObjectIdentifiers.f21783d.equals(aSN1ObjectIdentifier)) {
            return "SHA384";
        }
        if (NISTObjectIdentifiers.f21784e.equals(aSN1ObjectIdentifier)) {
            return "SHA512";
        }
        if (TeleTrusTObjectIdentifiers.f21983c.equals(aSN1ObjectIdentifier)) {
            return "RIPEMD128";
        }
        if (TeleTrusTObjectIdentifiers.f21982b.equals(aSN1ObjectIdentifier)) {
            return "RIPEMD160";
        }
        if (TeleTrusTObjectIdentifiers.f21984d.equals(aSN1ObjectIdentifier)) {
            return "RIPEMD256";
        }
        if (CryptoProObjectIdentifiers.f21556b.equals(aSN1ObjectIdentifier)) {
            return "GOST3411";
        }
        return aSN1ObjectIdentifier.m42986b();
    }
}
