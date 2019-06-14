package org.spongycastle.jce.provider;

import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    /* renamed from: a */
    public static final ProviderConfiguration f27551a = new BouncyCastleProviderConfiguration();
    /* renamed from: b */
    private static String f27552b = "BouncyCastle Security Provider v1.53";
    /* renamed from: c */
    private static final Map f27553c = new HashMap();
    /* renamed from: d */
    private static final String[] f27554d = new String[]{"PBEPBKDF2", "PBEPKCS12"};
    /* renamed from: e */
    private static final String[] f27555e = new String[]{"SipHash"};
    /* renamed from: f */
    private static final String[] f27556f = new String[]{"AES", "ARC4", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF"};
    /* renamed from: g */
    private static final String[] f27557g = new String[]{"X509", "IES"};
    /* renamed from: h */
    private static final String[] f27558h = new String[]{"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145"};
    /* renamed from: i */
    private static final String[] f27559i = new String[]{"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool"};
    /* renamed from: j */
    private static final String[] f27560j = new String[]{"BC", "PKCS12"};

    /* renamed from: org.spongycastle.jce.provider.BouncyCastleProvider$1 */
    class C66951 implements PrivilegedAction {
        /* renamed from: a */
        final /* synthetic */ BouncyCastleProvider f22951a;

        C66951(BouncyCastleProvider bouncyCastleProvider) {
            this.f22951a = bouncyCastleProvider;
        }

        public Object run() {
            this.f22951a.m36190a();
            return null;
        }
    }

    public BouncyCastleProvider() {
        super("SC", 1.53d, f27552b);
        AccessController.doPrivileged(new C66951(this));
    }

    /* renamed from: a */
    private void m36190a() {
        m36191a("org.spongycastle.jcajce.provider.digest.", f27559i);
        m36191a("org.spongycastle.jcajce.provider.symmetric.", f27554d);
        m36191a("org.spongycastle.jcajce.provider.symmetric.", f27555e);
        m36191a("org.spongycastle.jcajce.provider.symmetric.", f27556f);
        m36191a("org.spongycastle.jcajce.provider.asymmetric.", f27557g);
        m36191a("org.spongycastle.jcajce.provider.asymmetric.", f27558h);
        m36191a("org.spongycastle.jcajce.provider.keystore.", f27560j);
        put("X509Store.CERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.spongycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.spongycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.spongycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.spongycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.spongycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        put("CertPathValidator.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        put("CertPathValidator.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertPathValidator.PKIX", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.PKIX", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertStore.Collection", "org.spongycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.spongycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.spongycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }

    /* renamed from: a */
    private void m36191a(java.lang.String r6, java.lang.String[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
    L_0x0001:
        r1 = r7.length;
        if (r0 == r1) goto L_0x007a;
    L_0x0004:
        r1 = 0;
        r2 = r5.getClass();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2 = r2.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0046 }
        if (r2 == 0) goto L_0x002b;	 Catch:{ ClassNotFoundException -> 0x0046 }
    L_0x000f:
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3.<init>();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3.append(r6);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r4 = r7[r0];	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3.append(r4);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r4 = "$Mappings";	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3.append(r4);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2 = r2.loadClass(r3);	 Catch:{ ClassNotFoundException -> 0x0046 }
    L_0x0029:
        r1 = r2;	 Catch:{ ClassNotFoundException -> 0x0046 }
        goto L_0x0046;	 Catch:{ ClassNotFoundException -> 0x0046 }
    L_0x002b:
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2.append(r6);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3 = r7[r0];	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3 = "$Mappings";	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0046 }
        goto L_0x0029;
    L_0x0046:
        if (r1 == 0) goto L_0x0077;
    L_0x0048:
        r1 = r1.newInstance();	 Catch:{ Exception -> 0x0052 }
        r1 = (org.spongycastle.jcajce.provider.util.AlgorithmProvider) r1;	 Catch:{ Exception -> 0x0052 }
        r1.mo5864a(r5);	 Catch:{ Exception -> 0x0052 }
        goto L_0x0077;
    L_0x0052:
        r1 = move-exception;
        r2 = new java.lang.InternalError;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "cannot create instance of ";
        r3.append(r4);
        r3.append(r6);
        r6 = r7[r0];
        r3.append(r6);
        r6 = "$Mappings : ";
        r3.append(r6);
        r3.append(r1);
        r6 = r3.toString();
        r2.<init>(r6);
        throw r2;
    L_0x0077:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x007a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.BouncyCastleProvider.a(java.lang.String, java.lang.String[]):void");
    }

    /* renamed from: b */
    public boolean mo5886b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        if (!containsKey(stringBuilder.toString())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.");
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(str2);
            if (containsKey(stringBuilder.toString()) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo5883a(String str, String str2) {
        if (containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("duplicate provider key (");
            stringBuilder.append(str);
            stringBuilder.append(") found");
            throw new IllegalStateException(stringBuilder.toString());
        }
        put(str, str2);
    }

    /* renamed from: a */
    public void mo5884a(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(aSN1ObjectIdentifier);
        mo5883a(stringBuilder.toString(), str2);
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".OID.");
        stringBuilder.append(aSN1ObjectIdentifier);
        mo5883a(stringBuilder.toString(), str2);
    }

    /* renamed from: a */
    public void mo5885a(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        f27553c.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }

    /* renamed from: a */
    public static PublicKey m36189a(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) f27553c.get(subjectPublicKeyInfo.m40410a().m40230a());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.mo5917a(subjectPublicKeyInfo);
    }

    /* renamed from: a */
    public static PrivateKey m36188a(PrivateKeyInfo privateKeyInfo) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) f27553c.get(privateKeyInfo.m40112a().m40230a());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.mo5916a(privateKeyInfo);
    }
}
