package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public class RSA {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("AlgorithmParameters.OAEP", "org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP");
            configurableProvider.mo5883a("AlgorithmParameters.PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.RSAPSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.RSASSA-PSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA224withRSA/PSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA256withRSA/PSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA384withRSA/PSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA224WITHRSAANDMGF1", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA256WITHRSAANDMGF1", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA384WITHRSAANDMGF1", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA512WITHRSAANDMGF1", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.RAWRSAPSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.NONEWITHRSAPSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.NONEWITHRSASSA-PSS", "PSS");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.NONEWITHRSAANDMGF1", "PSS");
            configurableProvider.mo5883a("Cipher.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            configurableProvider.mo5883a("Cipher.RSA/RAW", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            configurableProvider.mo5883a("Cipher.RSA/PKCS1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableProvider.mo5884a("Cipher", PKCSObjectIdentifiers.h_, "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableProvider.mo5884a("Cipher", X509ObjectIdentifiers.f22088l, "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableProvider.mo5883a("Cipher.RSA/1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly");
            configurableProvider.mo5883a("Cipher.RSA/2", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly");
            configurableProvider.mo5883a("Cipher.RSA/OAEP", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            configurableProvider.mo5884a("Cipher", PKCSObjectIdentifiers.f21862h, "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            configurableProvider.mo5883a("Cipher.RSA/ISO9796-1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding");
            configurableProvider.mo5883a("Alg.Alias.Cipher.RSA//RAW", "RSA");
            configurableProvider.mo5883a("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
            configurableProvider.mo5883a("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
            configurableProvider.mo5883a("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
            configurableProvider.mo5883a("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
            configurableProvider.mo5883a("KeyFactory.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            configurableProvider.mo5883a("KeyPairGenerator.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi");
            AsymmetricKeyInfoConverter keyFactorySpi = new KeyFactorySpi();
            m36125a(configurableProvider, PKCSObjectIdentifiers.h_, "RSA", keyFactorySpi);
            m36125a(configurableProvider, X509ObjectIdentifiers.f22088l, "RSA", keyFactorySpi);
            m36125a(configurableProvider, PKCSObjectIdentifiers.f21862h, "RSA", keyFactorySpi);
            m36125a(configurableProvider, PKCSObjectIdentifiers.f21864k, "RSA", keyFactorySpi);
            m36124a(configurableProvider, PKCSObjectIdentifiers.h_, "RSA");
            m36124a(configurableProvider, X509ObjectIdentifiers.f22088l, "RSA");
            m36124a(configurableProvider, PKCSObjectIdentifiers.f21862h, "OAEP");
            m36124a(configurableProvider, PKCSObjectIdentifiers.f21864k, "PSS");
            configurableProvider.mo5883a("Signature.RSASSA-PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Signature.");
            stringBuilder.append(PKCSObjectIdentifiers.f21864k);
            configurableProvider.mo5883a(stringBuilder.toString(), "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            stringBuilder = new StringBuilder();
            stringBuilder.append("Signature.OID.");
            stringBuilder.append(PKCSObjectIdentifiers.f21864k);
            configurableProvider.mo5883a(stringBuilder.toString(), "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableProvider.mo5883a("Signature.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA");
            configurableProvider.mo5883a("Signature.RAWRSASSA-PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS");
            configurableProvider.mo5883a("Alg.Alias.Signature.RAWRSA", "RSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.NONEWITHRSA", "RSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.RAWRSAPSS", "RAWRSASSA-PSS");
            configurableProvider.mo5883a("Alg.Alias.Signature.NONEWITHRSAPSS", "RAWRSASSA-PSS");
            configurableProvider.mo5883a("Alg.Alias.Signature.NONEWITHRSASSA-PSS", "RAWRSASSA-PSS");
            configurableProvider.mo5883a("Alg.Alias.Signature.NONEWITHRSAANDMGF1", "RAWRSASSA-PSS");
            configurableProvider.mo5883a("Alg.Alias.Signature.RSAPSS", "RSASSA-PSS");
            m40997b(configurableProvider, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
            m40997b(configurableProvider, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
            m40997b(configurableProvider, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
            m40997b(configurableProvider, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
            m40997b(configurableProvider, "SHA512(224)", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSA");
            m40997b(configurableProvider, "SHA512(256)", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSA");
            if (configurableProvider.mo5886b("MessageDigest", "MD2")) {
                m40996a(configurableProvider, "MD2", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2", PKCSObjectIdentifiers.i_);
            }
            if (configurableProvider.mo5886b("MessageDigest", "MD4")) {
                m40996a(configurableProvider, "MD4", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4", PKCSObjectIdentifiers.f21860d);
            }
            if (configurableProvider.mo5886b("MessageDigest", "MD5")) {
                m40996a(configurableProvider, "MD5", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5", PKCSObjectIdentifiers.f21861e);
                m40995a(configurableProvider, "MD5", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption");
            }
            if (configurableProvider.mo5886b("MessageDigest", "SHA1")) {
                configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA1withRSA/PSS", "PSS");
                configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.SHA1WITHRSAANDMGF1", "PSS");
                m40997b(configurableProvider, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA");
                m40996a(configurableProvider, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1", PKCSObjectIdentifiers.j_);
                m40995a(configurableProvider, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption");
                stringBuilder = new StringBuilder();
                stringBuilder.append("Alg.Alias.Signature.");
                stringBuilder.append(OIWObjectIdentifiers.f21832k);
                configurableProvider.mo5883a(stringBuilder.toString(), "SHA1WITHRSA");
                stringBuilder = new StringBuilder();
                stringBuilder.append("Alg.Alias.Signature.OID.");
                stringBuilder.append(OIWObjectIdentifiers.f21832k);
                configurableProvider.mo5883a(stringBuilder.toString(), "SHA1WITHRSA");
                m40998c(configurableProvider, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA1WithRSAEncryption");
            }
            m40996a(configurableProvider, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224", PKCSObjectIdentifiers.p_);
            m40996a(configurableProvider, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256", PKCSObjectIdentifiers.m_);
            m40996a(configurableProvider, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384", PKCSObjectIdentifiers.n_);
            m40996a(configurableProvider, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512", PKCSObjectIdentifiers.o_);
            m40996a(configurableProvider, "SHA512(224)", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_224", null);
            m40996a(configurableProvider, "SHA512(256)", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_256", null);
            m40995a(configurableProvider, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA224WithRSAEncryption");
            m40995a(configurableProvider, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA256WithRSAEncryption");
            m40995a(configurableProvider, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA384WithRSAEncryption");
            m40995a(configurableProvider, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512WithRSAEncryption");
            m40995a(configurableProvider, "SHA512(224)", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_224WithRSAEncryption");
            m40995a(configurableProvider, "SHA512(256)", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_256WithRSAEncryption");
            m40998c(configurableProvider, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA224WithRSAEncryption");
            m40998c(configurableProvider, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA256WithRSAEncryption");
            m40998c(configurableProvider, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA384WithRSAEncryption");
            m40998c(configurableProvider, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512WithRSAEncryption");
            m40998c(configurableProvider, "SHA512(224)", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_224WithRSAEncryption");
            m40998c(configurableProvider, "SHA512(256)", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_256WithRSAEncryption");
            if (configurableProvider.mo5886b("MessageDigest", "RIPEMD128")) {
                m40996a(configurableProvider, "RIPEMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", TeleTrusTObjectIdentifiers.f21987g);
                m40996a(configurableProvider, "RMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", null);
                m40998c(configurableProvider, "RMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
                m40998c(configurableProvider, "RIPEMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
            }
            if (configurableProvider.mo5886b("MessageDigest", "RIPEMD160")) {
                m40996a(configurableProvider, "RIPEMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", TeleTrusTObjectIdentifiers.f21986f);
                m40996a(configurableProvider, "RMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", null);
                configurableProvider.mo5883a("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
                configurableProvider.mo5883a("Signature.RIPEMD160withRSA/ISO9796-2", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption");
                m40998c(configurableProvider, "RMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
                m40998c(configurableProvider, "RIPEMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
            }
            if (configurableProvider.mo5886b("MessageDigest", "RIPEMD256")) {
                m40996a(configurableProvider, "RIPEMD256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", TeleTrusTObjectIdentifiers.f21988h);
                m40996a(configurableProvider, "RMD256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", null);
            }
            if (configurableProvider.mo5886b("MessageDigest", "WHIRLPOOL")) {
                m40995a(configurableProvider, "Whirlpool", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
                m40995a(configurableProvider, "WHIRLPOOL", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
                m40998c(configurableProvider, "Whirlpool", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
                m40998c(configurableProvider, "WHIRLPOOL", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
            }
        }

        /* renamed from: a */
        private void m40996a(ConfigurableProvider configurableProvider, String str, String str2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("WITHRSA");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("withRSA");
            String stringBuilder4 = stringBuilder3.toString();
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(str);
            stringBuilder5.append("WithRSA");
            String stringBuilder6 = stringBuilder5.toString();
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(str);
            stringBuilder7.append("/");
            stringBuilder7.append("RSA");
            String stringBuilder8 = stringBuilder7.toString();
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append(str);
            stringBuilder9.append("WITHRSAENCRYPTION");
            String stringBuilder10 = stringBuilder9.toString();
            StringBuilder stringBuilder11 = new StringBuilder();
            stringBuilder11.append(str);
            stringBuilder11.append("withRSAEncryption");
            String stringBuilder12 = stringBuilder11.toString();
            StringBuilder stringBuilder13 = new StringBuilder();
            stringBuilder13.append(str);
            stringBuilder13.append("WithRSAEncryption");
            str = stringBuilder13.toString();
            stringBuilder13 = new StringBuilder();
            stringBuilder13.append("Signature.");
            stringBuilder13.append(stringBuilder2);
            configurableProvider.mo5883a(stringBuilder13.toString(), str2);
            str2 = new StringBuilder();
            str2.append("Alg.Alias.Signature.");
            str2.append(stringBuilder4);
            configurableProvider.mo5883a(str2.toString(), stringBuilder2);
            str2 = new StringBuilder();
            str2.append("Alg.Alias.Signature.");
            str2.append(stringBuilder6);
            configurableProvider.mo5883a(str2.toString(), stringBuilder2);
            str2 = new StringBuilder();
            str2.append("Alg.Alias.Signature.");
            str2.append(stringBuilder10);
            configurableProvider.mo5883a(str2.toString(), stringBuilder2);
            str2 = new StringBuilder();
            str2.append("Alg.Alias.Signature.");
            str2.append(stringBuilder12);
            configurableProvider.mo5883a(str2.toString(), stringBuilder2);
            str2 = new StringBuilder();
            str2.append("Alg.Alias.Signature.");
            str2.append(str);
            configurableProvider.mo5883a(str2.toString(), stringBuilder2);
            str = new StringBuilder();
            str.append("Alg.Alias.Signature.");
            str.append(stringBuilder8);
            configurableProvider.mo5883a(str.toString(), stringBuilder2);
            if (aSN1ObjectIdentifier != null) {
                str = new StringBuilder();
                str.append("Alg.Alias.Signature.");
                str.append(aSN1ObjectIdentifier);
                configurableProvider.mo5883a(str.toString(), stringBuilder2);
                str = new StringBuilder();
                str.append("Alg.Alias.Signature.OID.");
                str.append(aSN1ObjectIdentifier);
                configurableProvider.mo5883a(str.toString(), stringBuilder2);
            }
        }

        /* renamed from: a */
        private void m40995a(ConfigurableProvider configurableProvider, String str, String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(str);
            stringBuilder.append("withRSA/ISO9796-2");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("WITHRSA/ISO9796-2");
            configurableProvider.mo5883a(stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(str);
            stringBuilder.append("WithRSA/ISO9796-2");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("WITHRSA/ISO9796-2");
            configurableProvider.mo5883a(stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Signature.");
            stringBuilder.append(str);
            stringBuilder.append("WITHRSA/ISO9796-2");
            configurableProvider.mo5883a(stringBuilder.toString(), str2);
        }

        /* renamed from: b */
        private void m40997b(ConfigurableProvider configurableProvider, String str, String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(str);
            stringBuilder.append("withRSA/PSS");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("WITHRSAANDMGF1");
            configurableProvider.mo5883a(stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(str);
            stringBuilder.append("WithRSA/PSS");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("WITHRSAANDMGF1");
            configurableProvider.mo5883a(stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(str);
            stringBuilder.append("withRSAandMGF1");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("WITHRSAANDMGF1");
            configurableProvider.mo5883a(stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(str);
            stringBuilder.append("WithRSAAndMGF1");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("WITHRSAANDMGF1");
            configurableProvider.mo5883a(stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Signature.");
            stringBuilder.append(str);
            stringBuilder.append("WITHRSAANDMGF1");
            configurableProvider.mo5883a(stringBuilder.toString(), str2);
        }

        /* renamed from: c */
        private void m40998c(ConfigurableProvider configurableProvider, String str, String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(str);
            stringBuilder.append("withRSA/X9.31");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("WITHRSA/X9.31");
            configurableProvider.mo5883a(stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(str);
            stringBuilder.append("WithRSA/X9.31");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("WITHRSA/X9.31");
            configurableProvider.mo5883a(stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Signature.");
            stringBuilder.append(str);
            stringBuilder.append("WITHRSA/X9.31");
            configurableProvider.mo5883a(stringBuilder.toString(), str2);
        }
    }
}
