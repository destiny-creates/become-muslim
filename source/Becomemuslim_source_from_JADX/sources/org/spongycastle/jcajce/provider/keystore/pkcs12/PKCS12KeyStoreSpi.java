package org.spongycastle.jcajce.provider.keystore.pkcs12;

import com.facebook.imageutils.JfifUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.Key;
import java.security.KeyStore.LoadStoreParameter;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BEROutputStream;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.AuthenticatedSafe;
import org.spongycastle.asn1.pkcs.CertBag;
import org.spongycastle.asn1.pkcs.ContentInfo;
import org.spongycastle.asn1.pkcs.EncryptedData;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.pkcs.MacData;
import org.spongycastle.asn1.pkcs.PBES2Parameters;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.Pfx;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.pkcs.SafeBag;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12StoreParameter;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.JDKPKCS12StoreParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class PKCS12KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    private static final DefaultSecretKeyProvider bH = new DefaultSecretKeyProvider();
    protected SecureRandom bF = new SecureRandom();
    private final JcaJceHelper bG = new BCJcaJceHelper();
    private IgnoresCaseHashtable bI = new IgnoresCaseHashtable();
    private Hashtable bJ = new Hashtable();
    private IgnoresCaseHashtable bK = new IgnoresCaseHashtable();
    private Hashtable bL = new Hashtable();
    private Hashtable bM = new Hashtable();
    private CertificateFactory bN;
    private ASN1ObjectIdentifier bO;
    private ASN1ObjectIdentifier bP;

    private class CertId {
        /* renamed from: a */
        byte[] f22863a;
        /* renamed from: b */
        final /* synthetic */ PKCS12KeyStoreSpi f22864b;

        CertId(PKCS12KeyStoreSpi pKCS12KeyStoreSpi, PublicKey publicKey) {
            this.f22864b = pKCS12KeyStoreSpi;
            this.f22863a = pKCS12KeyStoreSpi.m36044a(publicKey).m40407a();
        }

        CertId(PKCS12KeyStoreSpi pKCS12KeyStoreSpi, byte[] bArr) {
            this.f22864b = pKCS12KeyStoreSpi;
            this.f22863a = bArr;
        }

        public int hashCode() {
            return Arrays.m29342a(this.f22863a);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CertId)) {
                return null;
            }
            return Arrays.m29353a(this.f22863a, ((CertId) obj).f22863a);
        }
    }

    private static class DefaultSecretKeyProvider {
        /* renamed from: a */
        private final Map f22865a;

        DefaultSecretKeyProvider() {
            Map hashMap = new HashMap();
            hashMap.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.m29396a(128));
            hashMap.put(PKCSObjectIdentifiers.f21835B.m42986b(), Integers.m29396a(JfifUtil.MARKER_SOFn));
            hashMap.put(NISTObjectIdentifiers.f21796q, Integers.m29396a(128));
            hashMap.put(NISTObjectIdentifiers.f21803x, Integers.m29396a(JfifUtil.MARKER_SOFn));
            hashMap.put(NISTObjectIdentifiers.f21769E, Integers.m29396a(256));
            hashMap.put(NTTObjectIdentifiers.f21806a, Integers.m29396a(128));
            hashMap.put(NTTObjectIdentifiers.f21807b, Integers.m29396a(JfifUtil.MARKER_SOFn));
            hashMap.put(NTTObjectIdentifiers.f21808c, Integers.m29396a(256));
            hashMap.put(CryptoProObjectIdentifiers.f21558d, Integers.m29396a(256));
            this.f22865a = Collections.unmodifiableMap(hashMap);
        }

        /* renamed from: a */
        public int m28056a(AlgorithmIdentifier algorithmIdentifier) {
            Integer num = (Integer) this.f22865a.get(algorithmIdentifier.m40230a());
            return num != null ? num.intValue() : -1;
        }
    }

    private static class IgnoresCaseHashtable {
        /* renamed from: a */
        private Hashtable f22866a;
        /* renamed from: b */
        private Hashtable f22867b;

        private IgnoresCaseHashtable() {
            this.f22866a = new Hashtable();
            this.f22867b = new Hashtable();
        }

        /* renamed from: a */
        public void m28059a(String str, Object obj) {
            Object c = str == null ? null : Strings.m29427c(str);
            String str2 = (String) this.f22867b.get(c);
            if (str2 != null) {
                this.f22866a.remove(str2);
            }
            this.f22867b.put(c, str);
            this.f22866a.put(str, obj);
        }

        /* renamed from: a */
        public Enumeration m28058a() {
            return this.f22866a.keys();
        }

        /* renamed from: a */
        public Object m28057a(String str) {
            str = (String) this.f22867b.remove(str == null ? null : Strings.m29427c(str));
            if (str == null) {
                return null;
            }
            return this.f22866a.remove(str);
        }

        /* renamed from: b */
        public Object m28060b(String str) {
            str = (String) this.f22867b.get(str == null ? null : Strings.m29427c(str));
            if (str == null) {
                return null;
            }
            return this.f22866a.get(str);
        }

        /* renamed from: b */
        public Enumeration m28061b() {
            return this.f22866a.elements();
        }
    }

    public static class BCPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore3DES() {
            super(new BouncyCastleProvider(), by, by);
        }
    }

    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(new BouncyCastleProvider(), by, bB);
        }
    }

    public static class DefPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore3DES() {
            super(null, by, by);
        }
    }

    public static class DefPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore() {
            super(null, by, bB);
        }
    }

    public PKCS12KeyStoreSpi(Provider provider, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.bO = aSN1ObjectIdentifier;
        this.bP = aSN1ObjectIdentifier2;
        if (provider != null) {
            try {
                this.bN = CertificateFactory.getInstance("X.509", provider);
                return;
            } catch (Provider provider2) {
                aSN1ObjectIdentifier2 = new StringBuilder();
                aSN1ObjectIdentifier2.append("can't create cert factory - ");
                aSN1ObjectIdentifier2.append(provider2.toString());
                throw new IllegalArgumentException(aSN1ObjectIdentifier2.toString());
            }
        }
        this.bN = CertificateFactory.getInstance("X.509");
    }

    /* renamed from: a */
    private org.spongycastle.asn1.x509.SubjectKeyIdentifier m36044a(java.security.PublicKey r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = r2.getEncoded();	 Catch:{ Exception -> 0x0012 }
        r2 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.m40409a(r2);	 Catch:{ Exception -> 0x0012 }
        r0 = new org.spongycastle.asn1.x509.SubjectKeyIdentifier;	 Catch:{ Exception -> 0x0012 }
        r2 = m36048a(r2);	 Catch:{ Exception -> 0x0012 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0012 }
        return r0;
    L_0x0012:
        r2 = new java.lang.RuntimeException;
        r0 = "error creating key";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.a(java.security.PublicKey):org.spongycastle.asn1.x509.SubjectKeyIdentifier");
    }

    /* renamed from: a */
    private static byte[] m36048a(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.mo5732b()];
        subjectPublicKeyInfo = subjectPublicKeyInfo.m40413d().m43059c();
        sHA1Digest.mo5731a(subjectPublicKeyInfo, 0, subjectPublicKeyInfo.length);
        sHA1Digest.mo5728a(bArr, 0);
        return bArr;
    }

    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration a = this.bK.m28058a();
        while (a.hasMoreElements()) {
            hashtable.put(a.nextElement(), "cert");
        }
        a = this.bI.m28058a();
        while (a.hasMoreElements()) {
            String str = (String) a.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    public boolean engineContainsAlias(String str) {
        if (this.bK.m28060b(str) == null) {
            if (this.bI.m28060b(str) == null) {
                return null;
            }
        }
        return true;
    }

    public void engineDeleteEntry(String str) {
        Key key = (Key) this.bI.m28057a(str);
        Certificate certificate = (Certificate) this.bK.m28057a(str);
        if (certificate != null) {
            this.bL.remove(new CertId(this, certificate.getPublicKey()));
        }
        if (key != null) {
            str = (String) this.bJ.remove(str);
            if (str != null) {
                certificate = (Certificate) this.bM.remove(str);
            }
            if (certificate != null) {
                this.bL.remove(new CertId(this, certificate.getPublicKey()));
            }
        }
    }

    public Certificate engineGetCertificate(String str) {
        if (str != null) {
            Certificate certificate = (Certificate) this.bK.m28060b(str);
            if (certificate != null) {
                return certificate;
            }
            String str2 = (String) this.bJ.get(str);
            if (str2 != null) {
                return (Certificate) this.bM.get(str2);
            }
            return (Certificate) this.bM.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getCertificate.");
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration b = this.bK.m28061b();
        Enumeration a = this.bK.m28058a();
        while (b.hasMoreElements()) {
            String str = (String) a.nextElement();
            if (((Certificate) b.nextElement()).equals(certificate)) {
                return str;
            }
        }
        b = this.bM.elements();
        a = this.bM.keys();
        while (b.hasMoreElements()) {
            str = (String) a.nextElement();
            if (((Certificate) b.nextElement()).equals(certificate)) {
                return str;
            }
        }
        return null;
    }

    public java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        if (r9 == 0) goto L_0x00c8;
    L_0x0002:
        r0 = r8.engineIsKeyEntry(r9);
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r9 = r8.engineGetCertificate(r9);
        if (r9 == 0) goto L_0x00c7;
    L_0x0010:
        r0 = new java.util.Vector;
        r0.<init>();
    L_0x0015:
        if (r9 == 0) goto L_0x00b1;
    L_0x0017:
        r2 = r9;
        r2 = (java.security.cert.X509Certificate) r2;
        r3 = org.spongycastle.asn1.x509.Extension.f31295s;
        r3 = r3.m42986b();
        r3 = r2.getExtensionValue(r3);
        if (r3 == 0) goto L_0x0065;
    L_0x0026:
        r4 = new org.spongycastle.asn1.ASN1InputStream;	 Catch:{ IOException -> 0x005a }
        r4.<init>(r3);	 Catch:{ IOException -> 0x005a }
        r3 = r4.m34595d();	 Catch:{ IOException -> 0x005a }
        r3 = (org.spongycastle.asn1.ASN1OctetString) r3;	 Catch:{ IOException -> 0x005a }
        r3 = r3.mo6859c();	 Catch:{ IOException -> 0x005a }
        r4 = new org.spongycastle.asn1.ASN1InputStream;	 Catch:{ IOException -> 0x005a }
        r4.<init>(r3);	 Catch:{ IOException -> 0x005a }
        r3 = r4.m34595d();	 Catch:{ IOException -> 0x005a }
        r3 = org.spongycastle.asn1.x509.AuthorityKeyIdentifier.m40255a(r3);	 Catch:{ IOException -> 0x005a }
        r4 = r3.m40256a();	 Catch:{ IOException -> 0x005a }
        if (r4 == 0) goto L_0x0065;	 Catch:{ IOException -> 0x005a }
    L_0x0048:
        r4 = r8.bL;	 Catch:{ IOException -> 0x005a }
        r5 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId;	 Catch:{ IOException -> 0x005a }
        r3 = r3.m40256a();	 Catch:{ IOException -> 0x005a }
        r5.<init>(r8, r3);	 Catch:{ IOException -> 0x005a }
        r3 = r4.get(r5);	 Catch:{ IOException -> 0x005a }
        r3 = (java.security.cert.Certificate) r3;	 Catch:{ IOException -> 0x005a }
        goto L_0x0066;
    L_0x005a:
        r9 = move-exception;
        r0 = new java.lang.RuntimeException;
        r9 = r9.toString();
        r0.<init>(r9);
        throw r0;
    L_0x0065:
        r3 = r1;
    L_0x0066:
        if (r3 != 0) goto L_0x00a0;
    L_0x0068:
        r4 = r2.getIssuerDN();
        r5 = r2.getSubjectDN();
        r5 = r4.equals(r5);
        if (r5 != 0) goto L_0x00a0;
    L_0x0076:
        r5 = r8.bL;
        r5 = r5.keys();
    L_0x007c:
        r6 = r5.hasMoreElements();
        if (r6 == 0) goto L_0x00a0;
    L_0x0082:
        r6 = r8.bL;
        r7 = r5.nextElement();
        r6 = r6.get(r7);
        r6 = (java.security.cert.X509Certificate) r6;
        r7 = r6.getSubjectDN();
        r7 = r7.equals(r4);
        if (r7 == 0) goto L_0x007c;
    L_0x0098:
        r7 = r6.getPublicKey();	 Catch:{ Exception -> 0x007c }
        r2.verify(r7);	 Catch:{ Exception -> 0x007c }
        r3 = r6;
    L_0x00a0:
        r2 = r0.contains(r9);
        if (r2 == 0) goto L_0x00a9;
    L_0x00a6:
        r9 = r1;
        goto L_0x0015;
    L_0x00a9:
        r0.addElement(r9);
        if (r3 == r9) goto L_0x00a6;
    L_0x00ae:
        r9 = r3;
        goto L_0x0015;
    L_0x00b1:
        r9 = r0.size();
        r9 = new java.security.cert.Certificate[r9];
        r1 = 0;
    L_0x00b8:
        r2 = r9.length;
        if (r1 == r2) goto L_0x00c6;
    L_0x00bb:
        r2 = r0.elementAt(r1);
        r2 = (java.security.cert.Certificate) r2;
        r9[r1] = r2;
        r1 = r1 + 1;
        goto L_0x00b8;
    L_0x00c6:
        return r9;
    L_0x00c7:
        return r1;
    L_0x00c8:
        r9 = new java.lang.IllegalArgumentException;
        r0 = "null alias passed to getCertificateChain.";
        r9.<init>(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineGetCertificateChain(java.lang.String):java.security.cert.Certificate[]");
    }

    public Date engineGetCreationDate(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        } else if (this.bI.m28060b(str) == null && this.bK.m28060b(str) == null) {
            return null;
        } else {
            return new Date();
        }
    }

    public Key engineGetKey(String str, char[] cArr) {
        if (str != null) {
            return (Key) this.bI.m28060b(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    public boolean engineIsCertificateEntry(String str) {
        return (this.bK.m28060b(str) == null || this.bI.m28060b(str) != null) ? null : true;
    }

    public boolean engineIsKeyEntry(String str) {
        return this.bI.m28060b(str) != null ? true : null;
    }

    public void engineSetCertificateEntry(String str, Certificate certificate) {
        if (this.bI.m28060b(str) == null) {
            this.bK.m28059a(str, certificate);
            this.bL.put(new CertId(this, certificate.getPublicKey()), certificate);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There is a key entry with the name ");
        stringBuilder.append(str);
        stringBuilder.append(".");
        throw new KeyStoreException(stringBuilder.toString());
    }

    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        throw new RuntimeException("operation not supported");
    }

    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        cArr = key instanceof PrivateKey;
        if (cArr != null) {
            if (cArr != null) {
                if (certificateArr == null) {
                    throw new KeyStoreException("no certificate chain for private key");
                }
            }
            if (this.bI.m28060b(str) != null) {
                engineDeleteEntry(str);
            }
            this.bI.m28059a(str, key);
            if (certificateArr != null) {
                cArr = null;
                this.bK.m28059a(str, certificateArr[0]);
                while (cArr != certificateArr.length) {
                    this.bL.put(new CertId(this, certificateArr[cArr].getPublicKey()), certificateArr[cArr]);
                    cArr++;
                }
                return;
            }
            return;
        }
        throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
    }

    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration a = this.bK.m28058a();
        while (a.hasMoreElements()) {
            hashtable.put(a.nextElement(), "cert");
        }
        a = this.bI.m28058a();
        while (a.hasMoreElements()) {
            String str = (String) a.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    /* renamed from: a */
    protected PrivateKey m36049a(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) {
        ASN1ObjectIdentifier a = algorithmIdentifier.m40230a();
        try {
            if (a.m42984a(PKCSObjectIdentifiers.bv)) {
                algorithmIdentifier = PKCS12PBEParams.m40103a(algorithmIdentifier.m40231b());
                AlgorithmParameterSpec pBEParameterSpec = new PBEParameterSpec(algorithmIdentifier.m40105b(), algorithmIdentifier.m40104a().intValue());
                algorithmIdentifier = this.bG.mo5876a(a.m42986b());
                algorithmIdentifier.init(4, new PKCS12Key(cArr, z), pBEParameterSpec);
                return (PrivateKey) algorithmIdentifier.unwrap(bArr, "", 2);
            } else if (a.equals(PKCSObjectIdentifiers.f21870y)) {
                return (PrivateKey) m36043a(4, cArr, algorithmIdentifier).unwrap(bArr, "", 2);
            } else {
                bArr = new StringBuilder();
                bArr.append("exception unwrapping private key - cannot recognise: ");
                bArr.append(a);
                throw new IOException(bArr.toString());
            }
        } catch (AlgorithmIdentifier algorithmIdentifier2) {
            cArr = new StringBuilder();
            cArr.append("exception unwrapping private key - ");
            cArr.append(algorithmIdentifier2.toString());
            throw new IOException(cArr.toString());
        }
    }

    /* renamed from: a */
    protected byte[] m36050a(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) {
        KeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            cArr = this.bG.mo5880e(str);
            AlgorithmParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.m40105b(), pKCS12PBEParams.m40104a().intValue());
            str = this.bG.mo5876a(str);
            str.init(3, cArr.generateSecret(pBEKeySpec), pBEParameterSpec);
            return str.wrap(key);
        } catch (String str2) {
            pKCS12PBEParams = new StringBuilder();
            pKCS12PBEParams.append("exception encrypting data - ");
            pKCS12PBEParams.append(str2.toString());
            throw new IOException(pKCS12PBEParams.toString());
        }
    }

    /* renamed from: a */
    protected byte[] m36051a(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) {
        ASN1ObjectIdentifier a = algorithmIdentifier.m40230a();
        int i = z ? true : true;
        if (a.m42984a(PKCSObjectIdentifiers.bv)) {
            algorithmIdentifier = PKCS12PBEParams.m40103a(algorithmIdentifier.m40231b());
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
            try {
                AlgorithmParameterSpec pBEParameterSpec = new PBEParameterSpec(algorithmIdentifier.m40105b(), algorithmIdentifier.m40104a().intValue());
                algorithmIdentifier = new PKCS12Key(cArr, z2);
                cArr = this.bG.mo5876a(a.m42986b());
                cArr.init(i, algorithmIdentifier, pBEParameterSpec);
                return cArr.doFinal(bArr);
            } catch (boolean z3) {
                cArr = new StringBuilder();
                cArr.append("exception decrypting data - ");
                cArr.append(z3.toString());
                throw new IOException(cArr.toString());
            }
        } else if (a.equals(PKCSObjectIdentifiers.f21870y)) {
            try {
                return m36043a(i, cArr, algorithmIdentifier).doFinal(bArr);
            } catch (boolean z32) {
                cArr = new StringBuilder();
                cArr.append("exception decrypting data - ");
                cArr.append(z32.toString());
                throw new IOException(cArr.toString());
            }
        } else {
            algorithmIdentifier = new StringBuilder();
            algorithmIdentifier.append("unknown PBE algorithm: ");
            algorithmIdentifier.append(a);
            throw new IOException(algorithmIdentifier.toString());
        }
    }

    /* renamed from: a */
    private Cipher m36043a(int i, char[] cArr, AlgorithmIdentifier algorithmIdentifier) {
        algorithmIdentifier = PBES2Parameters.m40093a(algorithmIdentifier.m40231b());
        PBKDF2Params a = PBKDF2Params.m40097a(algorithmIdentifier.m40094a().m40085b());
        AlgorithmIdentifier a2 = AlgorithmIdentifier.m40228a(algorithmIdentifier.m40095b());
        SecretKeyFactory e = this.bG.mo5880e(algorithmIdentifier.m40094a().m40084a().m42986b());
        if (a.m40100c()) {
            cArr = e.generateSecret(new PBEKeySpec(cArr, a.m40098a(), a.m40099b().intValue(), bH.m28056a(a2)));
        } else {
            cArr = e.generateSecret(new PBKDF2KeySpec(cArr, a.m40098a(), a.m40099b().intValue(), bH.m28056a(a2), a.m40101d()));
        }
        Cipher instance = Cipher.getInstance(algorithmIdentifier.m40095b().m40079a().m42986b());
        AlgorithmIdentifier.m40228a(algorithmIdentifier.m40095b());
        Object b = algorithmIdentifier.m40095b().m40080b();
        if (b instanceof ASN1OctetString) {
            instance.init(i, cArr, new IvParameterSpec(ASN1OctetString.m42990a(b).mo6859c()));
        } else {
            algorithmIdentifier = GOST28147Parameters.m39940a(b);
            instance.init(i, cArr, new GOST28147ParameterSpec(algorithmIdentifier.m39941a(), algorithmIdentifier.m39942b()));
        }
        return instance;
    }

    public void engineLoad(InputStream inputStream, char[] cArr) {
        PKCS12KeyStoreSpi pKCS12KeyStoreSpi = this;
        InputStream inputStream2 = inputStream;
        char[] cArr2 = cArr;
        if (inputStream2 != null) {
            if (cArr2 != null) {
                InputStream bufferedInputStream = new BufferedInputStream(inputStream2);
                bufferedInputStream.mark(10);
                if (bufferedInputStream.read() == 48) {
                    int intValue;
                    boolean z;
                    C66901 c66901;
                    Object obj;
                    ContentInfo[] a;
                    int i;
                    ASN1Sequence aSN1Sequence;
                    int i2;
                    SafeBag a2;
                    EncryptedPrivateKeyInfo a3;
                    PrivateKey a4;
                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier;
                    Enumeration b;
                    ASN1OctetString aSN1OctetString;
                    Object obj2;
                    ASN1Sequence aSN1Sequence2;
                    ASN1ObjectIdentifier aSN1ObjectIdentifier;
                    ASN1Set aSN1Set;
                    ASN1Encodable aSN1Encodable;
                    ASN1Encodable a5;
                    String b2;
                    Object obj3;
                    String str;
                    PrintStream printStream;
                    StringBuilder stringBuilder;
                    boolean z2;
                    PrintStream printStream2;
                    StringBuilder stringBuilder2;
                    EncryptedData a6;
                    StringBuilder stringBuilder3;
                    PrivateKey a7;
                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2;
                    ASN1OctetString aSN1OctetString2;
                    Object obj4;
                    ASN1Primitive aSN1Primitive;
                    String str2;
                    Object obj5;
                    ASN1Sequence aSN1Sequence3;
                    ASN1Set aSN1Set2;
                    ASN1Encodable aSN1Encodable2;
                    String b3;
                    SafeBag safeBag;
                    CertBag a8;
                    Certificate generateCertificate;
                    Enumeration b4;
                    String str3;
                    ASN1OctetString aSN1OctetString3;
                    ASN1Sequence a9;
                    ASN1ObjectIdentifier a10;
                    ASN1Set a11;
                    ASN1Primitive aSN1Primitive2;
                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3;
                    ASN1Encodable a12;
                    String str4;
                    bufferedInputStream.reset();
                    Pfx a13 = Pfx.m40107a((ASN1Sequence) new ASN1InputStream(bufferedInputStream).m34595d());
                    ContentInfo a14 = a13.m40108a();
                    Vector vector = new Vector();
                    int i3 = 1;
                    int i4 = 0;
                    if (a13.m40109b() != null) {
                        MacData b5 = a13.m40109b();
                        DigestInfo a15 = b5.m40088a();
                        AlgorithmIdentifier a16 = a15.m40306a();
                        byte[] b6 = b5.m40089b();
                        intValue = b5.m40090c().intValue();
                        byte[] c = ((ASN1OctetString) a14.m40063b()).mo6859c();
                        try {
                            byte[] a17 = m36047a(a16.m40230a(), b6, intValue, cArr, false, c);
                            byte[] b7 = a15.m40307b();
                            if (!Arrays.m29372b(a17, b7)) {
                                if (cArr2.length > 0) {
                                    throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
                                } else if (Arrays.m29372b(m36047a(a16.m40230a(), b6, intValue, cArr, true, c), b7)) {
                                    z = true;
                                    c66901 = null;
                                    pKCS12KeyStoreSpi.bI = new IgnoresCaseHashtable();
                                    pKCS12KeyStoreSpi.bJ = new Hashtable();
                                    if (a14.m40062a().equals(O)) {
                                        obj = null;
                                    } else {
                                        a = AuthenticatedSafe.m40051a(new ASN1InputStream(((ASN1OctetString) a14.m40063b()).mo6859c()).m34595d()).m40052a();
                                        i = 0;
                                        obj = null;
                                        while (i != a.length) {
                                            if (a[i].m40062a().equals(O)) {
                                                aSN1Sequence = (ASN1Sequence) new ASN1InputStream(((ASN1OctetString) a[i].m40063b()).mo6859c()).m34595d();
                                                i2 = 0;
                                                while (i2 != aSN1Sequence.mo6862g()) {
                                                    a2 = SafeBag.m40154a(aSN1Sequence.mo6860a(i2));
                                                    if (a2.m40155a().equals(bq)) {
                                                        a3 = EncryptedPrivateKeyInfo.m40074a(a2.m40156b());
                                                        a4 = m36049a(a3.m40075a(), a3.m40076b(), cArr2, z);
                                                        pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) a4;
                                                        if (a2.m40157c() == null) {
                                                            b = a2.m40157c().m43020b();
                                                            aSN1OctetString = c66901;
                                                            obj2 = aSN1OctetString;
                                                            while (b.hasMoreElements()) {
                                                                aSN1Sequence2 = (ASN1Sequence) b.nextElement();
                                                                aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence2.mo6860a(i4);
                                                                aSN1Set = (ASN1Set) aSN1Sequence2.mo6860a(i3);
                                                                if (aSN1Set.m43021c() <= 0) {
                                                                    aSN1Encodable = (ASN1Primitive) aSN1Set.m43016a(0);
                                                                    a5 = pKCS12BagAttributeCarrier.mo5850a(aSN1ObjectIdentifier);
                                                                    if (a5 != null) {
                                                                        pKCS12BagAttributeCarrier.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
                                                                    } else if (a5.mo5709e().equals(aSN1Encodable)) {
                                                                        throw new IOException("attempt to add existing attribute with different value");
                                                                    }
                                                                } else {
                                                                    aSN1Encodable = null;
                                                                }
                                                                if (aSN1ObjectIdentifier.equals(ai)) {
                                                                    b2 = ((DERBMPString) aSN1Encodable).mo6440b();
                                                                    pKCS12KeyStoreSpi.bI.m28059a(b2, a4);
                                                                    obj2 = b2;
                                                                } else if (aSN1ObjectIdentifier.equals(aj)) {
                                                                    aSN1OctetString = (ASN1OctetString) aSN1Encodable;
                                                                }
                                                                i3 = 1;
                                                                i4 = 0;
                                                            }
                                                            obj3 = obj2;
                                                        } else {
                                                            obj3 = null;
                                                            aSN1OctetString = null;
                                                        }
                                                        if (aSN1OctetString == null) {
                                                            str = new String(Hex.m29437a(aSN1OctetString.mo6859c()));
                                                            if (obj3 != null) {
                                                                pKCS12KeyStoreSpi.bI.m28059a(str, a4);
                                                            } else {
                                                                pKCS12KeyStoreSpi.bJ.put(obj3, str);
                                                            }
                                                        } else {
                                                            pKCS12KeyStoreSpi.bI.m28059a("unmarked", a4);
                                                            obj = 1;
                                                        }
                                                    } else if (a2.m40155a().equals(br)) {
                                                        printStream = System.out;
                                                        stringBuilder = new StringBuilder();
                                                        stringBuilder.append("extra in data ");
                                                        stringBuilder.append(a2.m40155a());
                                                        printStream.println(stringBuilder.toString());
                                                        System.out.println(ASN1Dump.m27217a(a2));
                                                    } else {
                                                        vector.addElement(a2);
                                                    }
                                                    i2++;
                                                    c66901 = null;
                                                    i3 = 1;
                                                    i4 = 0;
                                                }
                                            } else if (a[i].m40062a().equals(T)) {
                                                z2 = z;
                                                printStream2 = System.out;
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("extra ");
                                                stringBuilder2.append(a[i].m40062a().m42986b());
                                                printStream2.println(stringBuilder2.toString());
                                                printStream2 = System.out;
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("extra ");
                                                stringBuilder2.append(ASN1Dump.m27217a(a[i].m40063b()));
                                                printStream2.println(stringBuilder2.toString());
                                                i++;
                                                z = z2;
                                                c66901 = null;
                                                i3 = 1;
                                                i4 = 0;
                                            } else {
                                                a6 = EncryptedData.m40070a(a[i].m40063b());
                                                aSN1Sequence = (ASN1Sequence) ASN1Primitive.m39798b(m36051a(false, a6.m40071a(), cArr, z, a6.m40072b().mo6859c()));
                                                i2 = 0;
                                                while (i2 != aSN1Sequence.mo6862g()) {
                                                    a2 = SafeBag.m40154a(aSN1Sequence.mo6860a(i2));
                                                    if (a2.m40155a().equals(br)) {
                                                        vector.addElement(a2);
                                                        z2 = z;
                                                    } else if (a2.m40155a().equals(bq)) {
                                                        z2 = z;
                                                        if (a2.m40155a().equals(bp)) {
                                                            printStream2 = System.out;
                                                            stringBuilder3 = new StringBuilder();
                                                            stringBuilder3.append("extra in encryptedData ");
                                                            stringBuilder3.append(a2.m40155a());
                                                            printStream2.println(stringBuilder3.toString());
                                                            System.out.println(ASN1Dump.m27217a(a2));
                                                        } else {
                                                            a7 = BouncyCastleProvider.m36188a(PrivateKeyInfo.m40111a(a2.m40156b()));
                                                            pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) a7;
                                                            b = a2.m40157c().m43020b();
                                                            aSN1OctetString2 = null;
                                                            obj4 = null;
                                                            while (b.hasMoreElements()) {
                                                                aSN1Sequence2 = ASN1Sequence.m43000a(b.nextElement());
                                                                aSN1ObjectIdentifier = ASN1ObjectIdentifier.m42973a(aSN1Sequence2.mo6860a(0));
                                                                aSN1Set = ASN1Set.m43012a(aSN1Sequence2.mo6860a(1));
                                                                if (aSN1Set.m43021c() > 0) {
                                                                    aSN1Primitive = (ASN1Primitive) aSN1Set.m43016a(0);
                                                                    a5 = pKCS12BagAttributeCarrier2.mo5850a(aSN1ObjectIdentifier);
                                                                    if (a5 != null) {
                                                                        pKCS12BagAttributeCarrier2.mo5851a(aSN1ObjectIdentifier, aSN1Primitive);
                                                                    } else if (a5.mo5709e().equals(aSN1Primitive)) {
                                                                        throw new IOException("attempt to add existing attribute with different value");
                                                                    }
                                                                    if (aSN1ObjectIdentifier.equals(ai)) {
                                                                        obj4 = ((DERBMPString) aSN1Primitive).mo6440b();
                                                                        pKCS12KeyStoreSpi.bI.m28059a(obj4, a7);
                                                                    } else if (aSN1ObjectIdentifier.equals(aj)) {
                                                                        aSN1OctetString2 = (ASN1OctetString) aSN1Primitive;
                                                                    }
                                                                }
                                                            }
                                                            str2 = new String(Hex.m29437a(aSN1OctetString2.mo6859c()));
                                                            if (obj4 != null) {
                                                                pKCS12KeyStoreSpi.bI.m28059a(str2, a7);
                                                            } else {
                                                                pKCS12KeyStoreSpi.bJ.put(obj4, str2);
                                                            }
                                                        }
                                                    } else {
                                                        a3 = EncryptedPrivateKeyInfo.m40074a(a2.m40156b());
                                                        a4 = m36049a(a3.m40075a(), a3.m40076b(), cArr2, z);
                                                        pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) a4;
                                                        b = a2.m40157c().m43020b();
                                                        aSN1OctetString = null;
                                                        obj5 = null;
                                                        while (b.hasMoreElements()) {
                                                            aSN1Sequence3 = (ASN1Sequence) b.nextElement();
                                                            aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence3.mo6860a(0);
                                                            z2 = z;
                                                            aSN1Set2 = (ASN1Set) aSN1Sequence3.mo6860a(1);
                                                            if (aSN1Set2.m43021c() <= 0) {
                                                                aSN1Encodable2 = (ASN1Primitive) aSN1Set2.m43016a(0);
                                                                a5 = pKCS12BagAttributeCarrier.mo5850a(aSN1ObjectIdentifier);
                                                                if (a5 != null) {
                                                                    pKCS12BagAttributeCarrier.mo5851a(aSN1ObjectIdentifier, aSN1Encodable2);
                                                                } else if (a5.mo5709e().equals(aSN1Encodable2)) {
                                                                    throw new IOException("attempt to add existing attribute with different value");
                                                                }
                                                            } else {
                                                                aSN1Encodable2 = null;
                                                            }
                                                            if (aSN1ObjectIdentifier.equals(ai)) {
                                                                b3 = ((DERBMPString) aSN1Encodable2).mo6440b();
                                                                pKCS12KeyStoreSpi.bI.m28059a(b3, a4);
                                                                obj5 = b3;
                                                            } else if (aSN1ObjectIdentifier.equals(aj)) {
                                                                aSN1OctetString = (ASN1OctetString) aSN1Encodable2;
                                                            }
                                                            z = z2;
                                                        }
                                                        z2 = z;
                                                        b3 = new String(Hex.m29437a(aSN1OctetString.mo6859c()));
                                                        if (obj5 != null) {
                                                            pKCS12KeyStoreSpi.bI.m28059a(b3, a4);
                                                        } else {
                                                            pKCS12KeyStoreSpi.bJ.put(obj5, b3);
                                                        }
                                                    }
                                                    i2++;
                                                    z = z2;
                                                }
                                            }
                                            z2 = z;
                                            i++;
                                            z = z2;
                                            c66901 = null;
                                            i3 = 1;
                                            i4 = 0;
                                        }
                                    }
                                    pKCS12KeyStoreSpi.bK = new IgnoresCaseHashtable();
                                    pKCS12KeyStoreSpi.bL = new Hashtable();
                                    pKCS12KeyStoreSpi.bM = new Hashtable();
                                    while (intValue != vector.size()) {
                                        safeBag = (SafeBag) vector.elementAt(intValue);
                                        a8 = CertBag.m40055a(safeBag.m40156b());
                                        if (a8.m40056a().equals(am)) {
                                            stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append("Unsupported certificate type: ");
                                            stringBuilder2.append(a8.m40056a());
                                            throw new RuntimeException(stringBuilder2.toString());
                                        }
                                        try {
                                            generateCertificate = pKCS12KeyStoreSpi.bN.generateCertificate(new ByteArrayInputStream(((ASN1OctetString) a8.m40057b()).mo6859c()));
                                            if (safeBag.m40157c() == null) {
                                                b4 = safeBag.m40157c().m43020b();
                                                str3 = null;
                                                aSN1OctetString3 = str3;
                                                while (b4.hasMoreElements()) {
                                                    a9 = ASN1Sequence.m43000a(b4.nextElement());
                                                    a10 = ASN1ObjectIdentifier.m42973a(a9.mo6860a(0));
                                                    a11 = ASN1Set.m43012a(a9.mo6860a(1));
                                                    if (a11.m43021c() > 0) {
                                                        aSN1Primitive2 = (ASN1Primitive) a11.m43016a(0);
                                                        if (generateCertificate instanceof PKCS12BagAttributeCarrier) {
                                                            pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) generateCertificate;
                                                            a12 = pKCS12BagAttributeCarrier3.mo5850a(a10);
                                                            if (a12 != null) {
                                                                pKCS12BagAttributeCarrier3.mo5851a(a10, aSN1Primitive2);
                                                            } else if (a12.mo5709e().equals(aSN1Primitive2)) {
                                                                throw new IOException("attempt to add existing attribute with different value");
                                                            }
                                                        }
                                                        if (a10.equals(ai)) {
                                                            str3 = ((DERBMPString) aSN1Primitive2).mo6440b();
                                                        } else if (a10.equals(aj)) {
                                                            aSN1OctetString3 = (ASN1OctetString) aSN1Primitive2;
                                                        }
                                                    }
                                                }
                                            } else {
                                                str3 = null;
                                                aSN1OctetString3 = str3;
                                            }
                                            pKCS12KeyStoreSpi.bL.put(new CertId(pKCS12KeyStoreSpi, generateCertificate.getPublicKey()), generateCertificate);
                                            if (obj != null) {
                                                if (aSN1OctetString3 != null) {
                                                    pKCS12KeyStoreSpi.bM.put(new String(Hex.m29437a(aSN1OctetString3.mo6859c())), generateCertificate);
                                                }
                                                if (str3 != null) {
                                                    pKCS12KeyStoreSpi.bK.m28059a(str3, generateCertificate);
                                                }
                                            } else if (pKCS12KeyStoreSpi.bM.isEmpty()) {
                                                str4 = new String(Hex.m29437a(m36044a(generateCertificate.getPublicKey()).m40407a()));
                                                pKCS12KeyStoreSpi.bM.put(str4, generateCertificate);
                                                pKCS12KeyStoreSpi.bI.m28059a(str4, pKCS12KeyStoreSpi.bI.m28057a("unmarked"));
                                            }
                                        } catch (Exception e) {
                                            throw new RuntimeException(e.toString());
                                        }
                                    }
                                    return;
                                } else {
                                    throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
                                }
                            }
                        } catch (IOException e2) {
                            throw e2;
                        } catch (Exception e3) {
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("error constructing MAC: ");
                            stringBuilder4.append(e3.toString());
                            throw new IOException(stringBuilder4.toString());
                        }
                    }
                    z = false;
                    c66901 = null;
                    pKCS12KeyStoreSpi.bI = new IgnoresCaseHashtable();
                    pKCS12KeyStoreSpi.bJ = new Hashtable();
                    if (a14.m40062a().equals(O)) {
                        obj = null;
                    } else {
                        a = AuthenticatedSafe.m40051a(new ASN1InputStream(((ASN1OctetString) a14.m40063b()).mo6859c()).m34595d()).m40052a();
                        i = 0;
                        obj = null;
                        while (i != a.length) {
                            if (a[i].m40062a().equals(O)) {
                                aSN1Sequence = (ASN1Sequence) new ASN1InputStream(((ASN1OctetString) a[i].m40063b()).mo6859c()).m34595d();
                                i2 = 0;
                                while (i2 != aSN1Sequence.mo6862g()) {
                                    a2 = SafeBag.m40154a(aSN1Sequence.mo6860a(i2));
                                    if (a2.m40155a().equals(bq)) {
                                        a3 = EncryptedPrivateKeyInfo.m40074a(a2.m40156b());
                                        a4 = m36049a(a3.m40075a(), a3.m40076b(), cArr2, z);
                                        pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) a4;
                                        if (a2.m40157c() == null) {
                                            obj3 = null;
                                            aSN1OctetString = null;
                                        } else {
                                            b = a2.m40157c().m43020b();
                                            aSN1OctetString = c66901;
                                            obj2 = aSN1OctetString;
                                            while (b.hasMoreElements()) {
                                                aSN1Sequence2 = (ASN1Sequence) b.nextElement();
                                                aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence2.mo6860a(i4);
                                                aSN1Set = (ASN1Set) aSN1Sequence2.mo6860a(i3);
                                                if (aSN1Set.m43021c() <= 0) {
                                                    aSN1Encodable = null;
                                                } else {
                                                    aSN1Encodable = (ASN1Primitive) aSN1Set.m43016a(0);
                                                    a5 = pKCS12BagAttributeCarrier.mo5850a(aSN1ObjectIdentifier);
                                                    if (a5 != null) {
                                                        pKCS12BagAttributeCarrier.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
                                                    } else if (a5.mo5709e().equals(aSN1Encodable)) {
                                                        throw new IOException("attempt to add existing attribute with different value");
                                                    }
                                                }
                                                if (aSN1ObjectIdentifier.equals(ai)) {
                                                    b2 = ((DERBMPString) aSN1Encodable).mo6440b();
                                                    pKCS12KeyStoreSpi.bI.m28059a(b2, a4);
                                                    obj2 = b2;
                                                } else if (aSN1ObjectIdentifier.equals(aj)) {
                                                    aSN1OctetString = (ASN1OctetString) aSN1Encodable;
                                                }
                                                i3 = 1;
                                                i4 = 0;
                                            }
                                            obj3 = obj2;
                                        }
                                        if (aSN1OctetString == null) {
                                            pKCS12KeyStoreSpi.bI.m28059a("unmarked", a4);
                                            obj = 1;
                                        } else {
                                            str = new String(Hex.m29437a(aSN1OctetString.mo6859c()));
                                            if (obj3 != null) {
                                                pKCS12KeyStoreSpi.bJ.put(obj3, str);
                                            } else {
                                                pKCS12KeyStoreSpi.bI.m28059a(str, a4);
                                            }
                                        }
                                    } else if (a2.m40155a().equals(br)) {
                                        printStream = System.out;
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append("extra in data ");
                                        stringBuilder.append(a2.m40155a());
                                        printStream.println(stringBuilder.toString());
                                        System.out.println(ASN1Dump.m27217a(a2));
                                    } else {
                                        vector.addElement(a2);
                                    }
                                    i2++;
                                    c66901 = null;
                                    i3 = 1;
                                    i4 = 0;
                                }
                            } else if (a[i].m40062a().equals(T)) {
                                z2 = z;
                                printStream2 = System.out;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("extra ");
                                stringBuilder2.append(a[i].m40062a().m42986b());
                                printStream2.println(stringBuilder2.toString());
                                printStream2 = System.out;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("extra ");
                                stringBuilder2.append(ASN1Dump.m27217a(a[i].m40063b()));
                                printStream2.println(stringBuilder2.toString());
                                i++;
                                z = z2;
                                c66901 = null;
                                i3 = 1;
                                i4 = 0;
                            } else {
                                a6 = EncryptedData.m40070a(a[i].m40063b());
                                aSN1Sequence = (ASN1Sequence) ASN1Primitive.m39798b(m36051a(false, a6.m40071a(), cArr, z, a6.m40072b().mo6859c()));
                                i2 = 0;
                                while (i2 != aSN1Sequence.mo6862g()) {
                                    a2 = SafeBag.m40154a(aSN1Sequence.mo6860a(i2));
                                    if (a2.m40155a().equals(br)) {
                                        vector.addElement(a2);
                                        z2 = z;
                                    } else if (a2.m40155a().equals(bq)) {
                                        z2 = z;
                                        if (a2.m40155a().equals(bp)) {
                                            printStream2 = System.out;
                                            stringBuilder3 = new StringBuilder();
                                            stringBuilder3.append("extra in encryptedData ");
                                            stringBuilder3.append(a2.m40155a());
                                            printStream2.println(stringBuilder3.toString());
                                            System.out.println(ASN1Dump.m27217a(a2));
                                        } else {
                                            a7 = BouncyCastleProvider.m36188a(PrivateKeyInfo.m40111a(a2.m40156b()));
                                            pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) a7;
                                            b = a2.m40157c().m43020b();
                                            aSN1OctetString2 = null;
                                            obj4 = null;
                                            while (b.hasMoreElements()) {
                                                aSN1Sequence2 = ASN1Sequence.m43000a(b.nextElement());
                                                aSN1ObjectIdentifier = ASN1ObjectIdentifier.m42973a(aSN1Sequence2.mo6860a(0));
                                                aSN1Set = ASN1Set.m43012a(aSN1Sequence2.mo6860a(1));
                                                if (aSN1Set.m43021c() > 0) {
                                                    aSN1Primitive = (ASN1Primitive) aSN1Set.m43016a(0);
                                                    a5 = pKCS12BagAttributeCarrier2.mo5850a(aSN1ObjectIdentifier);
                                                    if (a5 != null) {
                                                        pKCS12BagAttributeCarrier2.mo5851a(aSN1ObjectIdentifier, aSN1Primitive);
                                                    } else if (a5.mo5709e().equals(aSN1Primitive)) {
                                                        throw new IOException("attempt to add existing attribute with different value");
                                                    }
                                                    if (aSN1ObjectIdentifier.equals(ai)) {
                                                        obj4 = ((DERBMPString) aSN1Primitive).mo6440b();
                                                        pKCS12KeyStoreSpi.bI.m28059a(obj4, a7);
                                                    } else if (aSN1ObjectIdentifier.equals(aj)) {
                                                        aSN1OctetString2 = (ASN1OctetString) aSN1Primitive;
                                                    }
                                                }
                                            }
                                            str2 = new String(Hex.m29437a(aSN1OctetString2.mo6859c()));
                                            if (obj4 != null) {
                                                pKCS12KeyStoreSpi.bJ.put(obj4, str2);
                                            } else {
                                                pKCS12KeyStoreSpi.bI.m28059a(str2, a7);
                                            }
                                        }
                                    } else {
                                        a3 = EncryptedPrivateKeyInfo.m40074a(a2.m40156b());
                                        a4 = m36049a(a3.m40075a(), a3.m40076b(), cArr2, z);
                                        pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) a4;
                                        b = a2.m40157c().m43020b();
                                        aSN1OctetString = null;
                                        obj5 = null;
                                        while (b.hasMoreElements()) {
                                            aSN1Sequence3 = (ASN1Sequence) b.nextElement();
                                            aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence3.mo6860a(0);
                                            z2 = z;
                                            aSN1Set2 = (ASN1Set) aSN1Sequence3.mo6860a(1);
                                            if (aSN1Set2.m43021c() <= 0) {
                                                aSN1Encodable2 = null;
                                            } else {
                                                aSN1Encodable2 = (ASN1Primitive) aSN1Set2.m43016a(0);
                                                a5 = pKCS12BagAttributeCarrier.mo5850a(aSN1ObjectIdentifier);
                                                if (a5 != null) {
                                                    pKCS12BagAttributeCarrier.mo5851a(aSN1ObjectIdentifier, aSN1Encodable2);
                                                } else if (a5.mo5709e().equals(aSN1Encodable2)) {
                                                    throw new IOException("attempt to add existing attribute with different value");
                                                }
                                            }
                                            if (aSN1ObjectIdentifier.equals(ai)) {
                                                b3 = ((DERBMPString) aSN1Encodable2).mo6440b();
                                                pKCS12KeyStoreSpi.bI.m28059a(b3, a4);
                                                obj5 = b3;
                                            } else if (aSN1ObjectIdentifier.equals(aj)) {
                                                aSN1OctetString = (ASN1OctetString) aSN1Encodable2;
                                            }
                                            z = z2;
                                        }
                                        z2 = z;
                                        b3 = new String(Hex.m29437a(aSN1OctetString.mo6859c()));
                                        if (obj5 != null) {
                                            pKCS12KeyStoreSpi.bJ.put(obj5, b3);
                                        } else {
                                            pKCS12KeyStoreSpi.bI.m28059a(b3, a4);
                                        }
                                    }
                                    i2++;
                                    z = z2;
                                }
                            }
                            z2 = z;
                            i++;
                            z = z2;
                            c66901 = null;
                            i3 = 1;
                            i4 = 0;
                        }
                    }
                    pKCS12KeyStoreSpi.bK = new IgnoresCaseHashtable();
                    pKCS12KeyStoreSpi.bL = new Hashtable();
                    pKCS12KeyStoreSpi.bM = new Hashtable();
                    for (intValue = 0; intValue != vector.size(); intValue++) {
                        safeBag = (SafeBag) vector.elementAt(intValue);
                        a8 = CertBag.m40055a(safeBag.m40156b());
                        if (a8.m40056a().equals(am)) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Unsupported certificate type: ");
                            stringBuilder2.append(a8.m40056a());
                            throw new RuntimeException(stringBuilder2.toString());
                        }
                        generateCertificate = pKCS12KeyStoreSpi.bN.generateCertificate(new ByteArrayInputStream(((ASN1OctetString) a8.m40057b()).mo6859c()));
                        if (safeBag.m40157c() == null) {
                            str3 = null;
                            aSN1OctetString3 = str3;
                        } else {
                            b4 = safeBag.m40157c().m43020b();
                            str3 = null;
                            aSN1OctetString3 = str3;
                            while (b4.hasMoreElements()) {
                                a9 = ASN1Sequence.m43000a(b4.nextElement());
                                a10 = ASN1ObjectIdentifier.m42973a(a9.mo6860a(0));
                                a11 = ASN1Set.m43012a(a9.mo6860a(1));
                                if (a11.m43021c() > 0) {
                                    aSN1Primitive2 = (ASN1Primitive) a11.m43016a(0);
                                    if (generateCertificate instanceof PKCS12BagAttributeCarrier) {
                                        pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) generateCertificate;
                                        a12 = pKCS12BagAttributeCarrier3.mo5850a(a10);
                                        if (a12 != null) {
                                            pKCS12BagAttributeCarrier3.mo5851a(a10, aSN1Primitive2);
                                        } else if (a12.mo5709e().equals(aSN1Primitive2)) {
                                            throw new IOException("attempt to add existing attribute with different value");
                                        }
                                    }
                                    if (a10.equals(ai)) {
                                        str3 = ((DERBMPString) aSN1Primitive2).mo6440b();
                                    } else if (a10.equals(aj)) {
                                        aSN1OctetString3 = (ASN1OctetString) aSN1Primitive2;
                                    }
                                }
                            }
                        }
                        pKCS12KeyStoreSpi.bL.put(new CertId(pKCS12KeyStoreSpi, generateCertificate.getPublicKey()), generateCertificate);
                        if (obj != null) {
                            if (aSN1OctetString3 != null) {
                                pKCS12KeyStoreSpi.bM.put(new String(Hex.m29437a(aSN1OctetString3.mo6859c())), generateCertificate);
                            }
                            if (str3 != null) {
                                pKCS12KeyStoreSpi.bK.m28059a(str3, generateCertificate);
                            }
                        } else if (pKCS12KeyStoreSpi.bM.isEmpty()) {
                            str4 = new String(Hex.m29437a(m36044a(generateCertificate.getPublicKey()).m40407a()));
                            pKCS12KeyStoreSpi.bM.put(str4, generateCertificate);
                            pKCS12KeyStoreSpi.bI.m28059a(str4, pKCS12KeyStoreSpi.bI.m28057a("unmarked"));
                        }
                    }
                    return;
                }
                throw new IOException("stream does not represent a PKCS12 key store");
            }
            throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
        }
    }

    public void engineStore(LoadStoreParameter loadStoreParameter) {
        if (loadStoreParameter != null) {
            StringBuilder stringBuilder;
            PKCS12StoreParameter pKCS12StoreParameter;
            char[] cArr;
            boolean z = loadStoreParameter instanceof PKCS12StoreParameter;
            if (!z) {
                if (!(loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("No support for 'param' of type ");
                    stringBuilder.append(loadStoreParameter.getClass().getName());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            if (z) {
                pKCS12StoreParameter = (PKCS12StoreParameter) loadStoreParameter;
            } else {
                JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
                pKCS12StoreParameter = new PKCS12StoreParameter(jDKPKCS12StoreParameter.m28172a(), loadStoreParameter.getProtectionParameter(), jDKPKCS12StoreParameter.m28173b());
            }
            loadStoreParameter = loadStoreParameter.getProtectionParameter();
            if (loadStoreParameter == null) {
                cArr = null;
            } else if (loadStoreParameter instanceof PasswordProtection) {
                cArr = ((PasswordProtection) loadStoreParameter).getPassword();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("No support for protection parameter of type ");
                stringBuilder.append(loadStoreParameter.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            m36046a(pKCS12StoreParameter.m27888a(), cArr, pKCS12StoreParameter.m27889b());
            return;
        }
        throw new IllegalArgumentException("'param' arg cannot be null");
    }

    public void engineStore(OutputStream outputStream, char[] cArr) {
        m36046a(outputStream, cArr, false);
    }

    /* renamed from: a */
    private void m36046a(OutputStream outputStream, char[] cArr, boolean z) {
        StringBuilder stringBuilder;
        PKCS12KeyStoreSpi pKCS12KeyStoreSpi = this;
        OutputStream outputStream2 = outputStream;
        char[] cArr2 = cArr;
        if (cArr2 != null) {
            String str;
            ASN1EncodableVector aSN1EncodableVector;
            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier;
            Enumeration a;
            Object obj;
            ASN1Encodable aSN1Encodable;
            Certificate engineGetCertificate;
            CertBag certBag;
            ASN1Encodable aSN1Encodable2;
            ASN1EncodableVector aSN1EncodableVector2;
            DEROutputStream dEROutputStream;
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            Enumeration a2 = pKCS12KeyStoreSpi.bI.m28058a();
            while (a2.hasMoreElements()) {
                byte[] bArr = new byte[20];
                pKCS12KeyStoreSpi.bF.nextBytes(bArr);
                str = (String) a2.nextElement();
                Key key = (PrivateKey) pKCS12KeyStoreSpi.bI.m28060b(str);
                PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams(bArr, 1024);
                EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(pKCS12KeyStoreSpi.bO, pKCS12PBEParams.mo5709e()), m36050a(pKCS12KeyStoreSpi.bO.m42986b(), key, pKCS12PBEParams, cArr2));
                aSN1EncodableVector = new ASN1EncodableVector();
                if (key instanceof PKCS12BagAttributeCarrier) {
                    pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) key;
                    DERBMPString dERBMPString = (DERBMPString) pKCS12BagAttributeCarrier.mo5850a(ai);
                    if (dERBMPString == null || !dERBMPString.mo6440b().equals(str)) {
                        pKCS12BagAttributeCarrier.mo5851a(ai, new DERBMPString(str));
                    }
                    if (pKCS12BagAttributeCarrier.mo5850a(aj) == null) {
                        pKCS12BagAttributeCarrier.mo5851a(aj, m36044a(engineGetCertificate(str).getPublicKey()));
                    }
                    a = pKCS12BagAttributeCarrier.mo5849a();
                    obj = null;
                    while (a.hasMoreElements()) {
                        aSN1Encodable = (ASN1ObjectIdentifier) a.nextElement();
                        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                        aSN1EncodableVector4.m27141a(aSN1Encodable);
                        aSN1EncodableVector4.m27141a(new DERSet(pKCS12BagAttributeCarrier.mo5850a(aSN1Encodable)));
                        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector4));
                        obj = 1;
                    }
                } else {
                    obj = null;
                }
                if (obj == null) {
                    ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                    Certificate engineGetCertificate2 = engineGetCertificate(str);
                    aSN1EncodableVector5.m27141a(aj);
                    aSN1EncodableVector5.m27141a(new DERSet(m36044a(engineGetCertificate2.getPublicKey())));
                    aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector5));
                    aSN1EncodableVector5 = new ASN1EncodableVector();
                    aSN1EncodableVector5.m27141a(ai);
                    aSN1EncodableVector5.m27141a(new DERSet(new DERBMPString(str)));
                    aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector5));
                }
                aSN1EncodableVector3.m27141a(new SafeBag(bq, encryptedPrivateKeyInfo.mo5709e(), new DERSet(aSN1EncodableVector)));
            }
            ASN1Encodable bEROctetString = new BEROctetString(new DERSequence(aSN1EncodableVector3).m34596a("DER"));
            byte[] bArr2 = new byte[20];
            pKCS12KeyStoreSpi.bF.nextBytes(bArr2);
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(pKCS12KeyStoreSpi.bP, new PKCS12PBEParams(bArr2, 1024).mo5709e());
            Hashtable hashtable = new Hashtable();
            Enumeration a3 = pKCS12KeyStoreSpi.bI.m28058a();
            while (a3.hasMoreElements()) {
                try {
                    Enumeration enumeration;
                    str = (String) a3.nextElement();
                    engineGetCertificate = engineGetCertificate(str);
                    certBag = new CertBag(am, new DEROctetString(engineGetCertificate.getEncoded()));
                    ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                    if (engineGetCertificate instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) engineGetCertificate;
                        DERBMPString dERBMPString2 = (DERBMPString) pKCS12BagAttributeCarrier2.mo5850a(ai);
                        if (dERBMPString2 == null || !dERBMPString2.mo6440b().equals(str)) {
                            pKCS12BagAttributeCarrier2.mo5851a(ai, new DERBMPString(str));
                        }
                        if (pKCS12BagAttributeCarrier2.mo5850a(aj) == null) {
                            pKCS12BagAttributeCarrier2.mo5851a(aj, m36044a(engineGetCertificate.getPublicKey()));
                        }
                        Enumeration a4 = pKCS12BagAttributeCarrier2.mo5849a();
                        obj = null;
                        while (a4.hasMoreElements()) {
                            aSN1Encodable2 = (ASN1ObjectIdentifier) a4.nextElement();
                            enumeration = a3;
                            aSN1EncodableVector = new ASN1EncodableVector();
                            aSN1EncodableVector.m27141a(aSN1Encodable2);
                            aSN1EncodableVector.m27141a(new DERSet(pKCS12BagAttributeCarrier2.mo5850a(aSN1Encodable2)));
                            aSN1EncodableVector7.m27141a(new DERSequence(aSN1EncodableVector));
                            a3 = enumeration;
                            cArr2 = cArr;
                            obj = 1;
                        }
                        enumeration = a3;
                    } else {
                        enumeration = a3;
                        obj = null;
                    }
                    if (obj == null) {
                        aSN1EncodableVector = new ASN1EncodableVector();
                        aSN1EncodableVector.m27141a(aj);
                        aSN1EncodableVector.m27141a(new DERSet(m36044a(engineGetCertificate.getPublicKey())));
                        aSN1EncodableVector7.m27141a(new DERSequence(aSN1EncodableVector));
                        aSN1EncodableVector = new ASN1EncodableVector();
                        aSN1EncodableVector.m27141a(ai);
                        aSN1EncodableVector.m27141a(new DERSet(new DERBMPString(str)));
                        aSN1EncodableVector7.m27141a(new DERSequence(aSN1EncodableVector));
                    }
                    aSN1EncodableVector6.m27141a(new SafeBag(br, certBag.mo5709e(), new DERSet(aSN1EncodableVector7)));
                    hashtable.put(engineGetCertificate, engineGetCertificate);
                    a3 = enumeration;
                    cArr2 = cArr;
                } catch (CertificateEncodingException e) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error encoding certificate: ");
                    stringBuilder.append(e.toString());
                    throw new IOException(stringBuilder.toString());
                }
            }
            a3 = pKCS12KeyStoreSpi.bK.m28058a();
            while (a3.hasMoreElements()) {
                try {
                    str = (String) a3.nextElement();
                    engineGetCertificate = (Certificate) pKCS12KeyStoreSpi.bK.m28060b(str);
                    if (pKCS12KeyStoreSpi.bI.m28060b(str) == null) {
                        Object obj2;
                        Enumeration enumeration2;
                        certBag = new CertBag(am, new DEROctetString(engineGetCertificate.getEncoded()));
                        aSN1EncodableVector2 = new ASN1EncodableVector();
                        if (engineGetCertificate instanceof PKCS12BagAttributeCarrier) {
                            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) engineGetCertificate;
                            DERBMPString dERBMPString3 = (DERBMPString) pKCS12BagAttributeCarrier3.mo5850a(ai);
                            if (dERBMPString3 == null || !dERBMPString3.mo6440b().equals(str)) {
                                pKCS12BagAttributeCarrier3.mo5851a(ai, new DERBMPString(str));
                            }
                            Enumeration a5 = pKCS12BagAttributeCarrier3.mo5849a();
                            obj2 = null;
                            while (a5.hasMoreElements()) {
                                aSN1Encodable2 = (ASN1ObjectIdentifier) a5.nextElement();
                                enumeration2 = a3;
                                if (aSN1Encodable2.equals(PKCSObjectIdentifiers.aj)) {
                                    a3 = enumeration2;
                                } else {
                                    aSN1EncodableVector = new ASN1EncodableVector();
                                    aSN1EncodableVector.m27141a(aSN1Encodable2);
                                    aSN1EncodableVector.m27141a(new DERSet(pKCS12BagAttributeCarrier3.mo5850a(aSN1Encodable2)));
                                    aSN1EncodableVector2.m27141a(new DERSequence(aSN1EncodableVector));
                                    a3 = enumeration2;
                                    obj2 = 1;
                                }
                            }
                            enumeration2 = a3;
                        } else {
                            enumeration2 = a3;
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            aSN1EncodableVector = new ASN1EncodableVector();
                            aSN1EncodableVector.m27141a(ai);
                            aSN1EncodableVector.m27141a(new DERSet(new DERBMPString(str)));
                            aSN1EncodableVector2.m27141a(new DERSequence(aSN1EncodableVector));
                        }
                        aSN1EncodableVector6.m27141a(new SafeBag(br, certBag.mo5709e(), new DERSet(aSN1EncodableVector2)));
                        hashtable.put(engineGetCertificate, engineGetCertificate);
                        a3 = enumeration2;
                    }
                } catch (CertificateEncodingException e2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error encoding certificate: ");
                    stringBuilder.append(e2.toString());
                    throw new IOException(stringBuilder.toString());
                }
            }
            Set a6 = m36042a();
            Enumeration keys = pKCS12KeyStoreSpi.bL.keys();
            while (keys.hasMoreElements()) {
                try {
                    engineGetCertificate = (Certificate) pKCS12KeyStoreSpi.bL.get((CertId) keys.nextElement());
                    if (a6.contains(engineGetCertificate)) {
                        if (hashtable.get(engineGetCertificate) == null) {
                            certBag = new CertBag(am, new DEROctetString(engineGetCertificate.getEncoded()));
                            aSN1EncodableVector2 = new ASN1EncodableVector();
                            if (engineGetCertificate instanceof PKCS12BagAttributeCarrier) {
                                pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) engineGetCertificate;
                                a = pKCS12BagAttributeCarrier.mo5849a();
                                while (a.hasMoreElements()) {
                                    aSN1Encodable = (ASN1ObjectIdentifier) a.nextElement();
                                    if (!aSN1Encodable.equals(PKCSObjectIdentifiers.aj)) {
                                        ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                                        aSN1EncodableVector8.m27141a(aSN1Encodable);
                                        aSN1EncodableVector8.m27141a(new DERSet(pKCS12BagAttributeCarrier.mo5850a(aSN1Encodable)));
                                        aSN1EncodableVector2.m27141a(new DERSequence(aSN1EncodableVector8));
                                    }
                                }
                            }
                            aSN1EncodableVector6.m27141a(new SafeBag(br, certBag.mo5709e(), new DERSet(aSN1EncodableVector2)));
                        }
                    }
                } catch (CertificateEncodingException e22) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error encoding certificate: ");
                    stringBuilder.append(e22.toString());
                    throw new IOException(stringBuilder.toString());
                }
            }
            EncryptedData encryptedData = new EncryptedData(O, algorithmIdentifier, new BEROctetString(m36051a(true, algorithmIdentifier, cArr, false, new DERSequence(aSN1EncodableVector6).m34596a("DER"))));
            ASN1Encodable authenticatedSafe = new AuthenticatedSafe(new ContentInfo[]{new ContentInfo(O, bEROctetString), new ContentInfo(T, encryptedData.mo5709e())});
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (z) {
                dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            } else {
                dEROutputStream = new BEROutputStream(byteArrayOutputStream);
            }
            dEROutputStream.mo5713a(authenticatedSafe);
            ContentInfo contentInfo = new ContentInfo(O, new BEROctetString(byteArrayOutputStream.toByteArray()));
            byte[] bArr3 = new byte[20];
            pKCS12KeyStoreSpi.bF.nextBytes(bArr3);
            try {
                DEROutputStream dEROutputStream2;
                authenticatedSafe = new Pfx(contentInfo, new MacData(new DigestInfo(new AlgorithmIdentifier(i, DERNull.f32850a), m36047a(i, bArr3, 1024, cArr, false, ((ASN1OctetString) contentInfo.m40063b()).mo6859c())), bArr3, 1024));
                if (z) {
                    dEROutputStream2 = new DEROutputStream(outputStream2);
                } else {
                    dEROutputStream2 = new BEROutputStream(outputStream2);
                }
                dEROutputStream2.mo5713a(authenticatedSafe);
                return;
            } catch (Exception e3) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("error constructing MAC: ");
                stringBuilder.append(e3.toString());
                throw new IOException(stringBuilder.toString());
            }
        }
        throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
    }

    /* renamed from: a */
    private Set m36042a() {
        Set hashSet = new HashSet();
        Enumeration a = this.bI.m28058a();
        while (a.hasMoreElements()) {
            Certificate[] engineGetCertificateChain = engineGetCertificateChain((String) a.nextElement());
            for (int i = 0; i != engineGetCertificateChain.length; i++) {
                hashSet.add(engineGetCertificateChain[i]);
            }
        }
        a = this.bK.m28058a();
        while (a.hasMoreElements()) {
            hashSet.add(engineGetCertificate((String) a.nextElement()));
        }
        return hashSet;
    }

    /* renamed from: a */
    private byte[] m36047a(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) {
        AlgorithmParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        aSN1ObjectIdentifier = this.bG.mo5877b(aSN1ObjectIdentifier.m42986b());
        aSN1ObjectIdentifier.init(new PKCS12Key(cArr, z), pBEParameterSpec);
        aSN1ObjectIdentifier.update(bArr2);
        return aSN1ObjectIdentifier.doFinal();
    }
}
