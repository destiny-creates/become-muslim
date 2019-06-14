package org.spongycastle.jce.provider;

import java.security.AlgorithmParameters;
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
    private static final ASN1Null f23043a = DERNull.f32850a;

    X509SignatureUtil() {
    }

    /* renamed from: a */
    static void m28308a(Signature signature, ASN1Encodable aSN1Encodable) {
        StringBuilder stringBuilder;
        if (aSN1Encodable != null && !f23043a.equals(aSN1Encodable)) {
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
    static String m28307a(AlgorithmIdentifier algorithmIdentifier) {
        Object b = algorithmIdentifier.m40231b();
        if (!(b == null || f23043a.equals(b))) {
            StringBuilder stringBuilder;
            if (algorithmIdentifier.m40230a().equals(PKCSObjectIdentifiers.f21864k)) {
                algorithmIdentifier = RSASSAPSSparams.m40148a(b);
                stringBuilder = new StringBuilder();
                stringBuilder.append(m28306a(algorithmIdentifier.m40149a().m40230a()));
                stringBuilder.append("withRSAandMGF1");
                return stringBuilder.toString();
            } else if (algorithmIdentifier.m40230a().equals(X9ObjectIdentifiers.f22171l)) {
                algorithmIdentifier = ASN1Sequence.m43000a(b);
                stringBuilder = new StringBuilder();
                stringBuilder.append(m28306a(ASN1ObjectIdentifier.m42973a(algorithmIdentifier.mo6860a(0))));
                stringBuilder.append("withECDSA");
                return stringBuilder.toString();
            }
        }
        return algorithmIdentifier.m40230a().m42986b();
    }

    /* renamed from: a */
    private static String m28306a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
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
