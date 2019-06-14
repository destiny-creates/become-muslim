package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x9.X9IntegerConverter;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.agreement.ECDHCBasicAgreement;
import org.spongycastle.crypto.agreement.ECMQVBasicAgreement;
import org.spongycastle.crypto.agreement.kdf.ConcatenationKDFGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.spec.MQVParameterSpec;
import org.spongycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.MQVPrivateKey;
import org.spongycastle.jce.interfaces.MQVPublicKey;
import org.spongycastle.util.Strings;

public class KeyAgreementSpi extends BaseAgreementSpi {
    /* renamed from: a */
    private static final X9IntegerConverter f27392a = new X9IntegerConverter();
    /* renamed from: b */
    private static final Hashtable f27393b = new Hashtable();
    /* renamed from: c */
    private static final Hashtable f27394c = new Hashtable();
    /* renamed from: d */
    private String f27395d;
    /* renamed from: e */
    private BigInteger f27396e;
    /* renamed from: f */
    private ECDomainParameters f27397f;
    /* renamed from: g */
    private BasicAgreement f27398g;
    /* renamed from: h */
    private DerivationFunction f27399h;
    /* renamed from: i */
    private MQVParameterSpec f27400i;
    /* renamed from: j */
    private byte[] f27401j;

    public static class CDHwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA1KDFAndSharedInfo() {
            super("ECCDHwithSHA1KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class CDHwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA224KDFAndSharedInfo() {
            super("ECCDHwithSHA224KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class CDHwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA256KDFAndSharedInfo() {
            super("ECCDHwithSHA256KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class CDHwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA384KDFAndSharedInfo() {
            super("ECCDHwithSHA384KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class CDHwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA512KDFAndSharedInfo() {
            super("ECCDHwithSHA512KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
        }
    }

    public static class DH extends KeyAgreementSpi {
        public DH() {
            super("ECDH", new ECDHBasicAgreement(), null);
        }
    }

    public static class DHC extends KeyAgreementSpi {
        public DHC() {
            super("ECDHC", new ECDHCBasicAgreement(), null);
        }
    }

    public static class DHwithSHA1CKDF extends KeyAgreementSpi {
        public DHwithSHA1CKDF() {
            super("ECDHwithSHA1CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA1KDF extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA1KDFAndSharedInfo() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA224KDFAndSharedInfo() {
            super("ECDHwithSHA224KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class DHwithSHA256CKDF extends KeyAgreementSpi {
        public DHwithSHA256CKDF() {
            super("ECDHwithSHA256CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA256Digest()));
        }
    }

    public static class DHwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA256KDFAndSharedInfo() {
            super("ECDHwithSHA256KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class DHwithSHA384CKDF extends KeyAgreementSpi {
        public DHwithSHA384CKDF() {
            super("ECDHwithSHA384CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA384Digest()));
        }
    }

    public static class DHwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA384KDFAndSharedInfo() {
            super("ECDHwithSHA384KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class DHwithSHA512CKDF extends KeyAgreementSpi {
        public DHwithSHA512CKDF() {
            super("ECDHwithSHA512CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA512Digest()));
        }
    }

    public static class DHwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA512KDFAndSharedInfo() {
            super("ECDHwithSHA512KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
        }
    }

    public static class MQV extends KeyAgreementSpi {
        public MQV() {
            super("ECMQV", new ECMQVBasicAgreement(), null);
        }
    }

    public static class MQVwithSHA1CKDF extends KeyAgreementSpi {
        public MQVwithSHA1CKDF() {
            super("ECMQVwithSHA1CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA1Digest()));
        }
    }

    public static class MQVwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA1KDFAndSharedInfo() {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class MQVwithSHA224CKDF extends KeyAgreementSpi {
        public MQVwithSHA224CKDF() {
            super("ECMQVwithSHA224CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA224Digest()));
        }
    }

    public static class MQVwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA224KDFAndSharedInfo() {
            super("ECMQVwithSHA224KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class MQVwithSHA256CKDF extends KeyAgreementSpi {
        public MQVwithSHA256CKDF() {
            super("ECMQVwithSHA256CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA256Digest()));
        }
    }

    public static class MQVwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA256KDFAndSharedInfo() {
            super("ECMQVwithSHA256KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class MQVwithSHA384CKDF extends KeyAgreementSpi {
        public MQVwithSHA384CKDF() {
            super("ECMQVwithSHA384CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA384Digest()));
        }
    }

    public static class MQVwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA384KDFAndSharedInfo() {
            super("ECMQVwithSHA384KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class MQVwithSHA512CKDF extends KeyAgreementSpi {
        public MQVwithSHA512CKDF() {
            super("ECMQVwithSHA512CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA512Digest()));
        }
    }

    public static class MQVwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA512KDFAndSharedInfo() {
            super("ECMQVwithSHA512KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
        }
    }

    static {
        f27393b.put("DESEDE", PKCSObjectIdentifiers.f21835B);
        f27393b.put("AES", NISTObjectIdentifiers.f21769E);
        f27393b.put("DES", OIWObjectIdentifiers.f21826e);
        f27394c.put("DES", "DES");
        f27394c.put("DESEDE", "DES");
        f27394c.put(OIWObjectIdentifiers.f21826e.m42986b(), "DES");
        f27394c.put(PKCSObjectIdentifiers.f21835B.m42986b(), "DES");
        f27394c.put(PKCSObjectIdentifiers.bD.m42986b(), "DES");
    }

    /* renamed from: a */
    private byte[] m35995a(BigInteger bigInteger) {
        return f27392a.m27276a(bigInteger, f27392a.m27274a(this.f27397f.m35647a()));
    }

    protected KeyAgreementSpi(String str, BasicAgreement basicAgreement, DerivationFunction derivationFunction) {
        this.f27395d = str;
        this.f27398g = basicAgreement;
        this.f27399h = derivationFunction;
    }

    protected Key engineDoPhase(Key key, boolean z) {
        if (this.f27397f == null) {
            z = new StringBuilder();
            z.append(this.f27395d);
            z.append(" not initialised.");
            throw new IllegalStateException(z.toString());
        } else if (z) {
            CipherParameters mQVPublicParameters;
            if (this.f27398g instanceof ECMQVBasicAgreement) {
                if (key instanceof MQVPublicKey) {
                    MQVPublicKey mQVPublicKey = (MQVPublicKey) key;
                    mQVPublicParameters = new MQVPublicParameters((ECPublicKeyParameters) ECUtil.m28010a(mQVPublicKey.mo5899a()), (ECPublicKeyParameters) ECUtil.m28010a(mQVPublicKey.mo5900b()));
                } else {
                    mQVPublicParameters = new MQVPublicParameters((ECPublicKeyParameters) ECUtil.m28010a((PublicKey) key), (ECPublicKeyParameters) ECUtil.m28010a(this.f27400i.m28108c()));
                }
            } else if (key instanceof PublicKey) {
                mQVPublicParameters = ECUtil.m28010a((PublicKey) key);
            } else {
                z = new StringBuilder();
                z.append(this.f27395d);
                z.append(" key agreement requires ");
                z.append(m35993a(ECPublicKey.class));
                z.append(" for doPhase");
                throw new InvalidKeyException(z.toString());
            }
            this.f27396e = this.f27398g.mo5725b(mQVPublicParameters);
            return null;
        } else {
            z = new StringBuilder();
            z.append(this.f27395d);
            z.append(" can only be between two parties.");
            throw new IllegalStateException(z.toString());
        }
    }

    protected byte[] engineGenerateSecret() {
        if (this.f27399h == null) {
            return m35995a(this.f27396e);
        }
        throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
    }

    protected int engineGenerateSecret(byte[] bArr, int i) {
        Object engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        i = new StringBuilder();
        i.append(this.f27395d);
        i.append(" key agreement: need ");
        i.append(engineGenerateSecret.length);
        i.append(" bytes");
        throw new ShortBufferException(i.toString());
    }

    protected SecretKey engineGenerateSecret(String str) {
        byte[] bArr;
        Object a = m35995a(this.f27396e);
        String b = Strings.m29424b(str);
        b = f27393b.containsKey(b) ? ((ASN1ObjectIdentifier) f27393b.get(b)).m42986b() : str;
        int b2 = BaseAgreementSpi.m27988b(b);
        if (this.f27399h != null) {
            if (b2 >= 0) {
                bArr = new byte[(b2 / 8)];
                this.f27399h.mo5727a(new KDFParameters(a, this.f27401j));
                this.f27399h.mo5726a(bArr, 0, bArr.length);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown algorithm encountered: ");
                stringBuilder.append(b);
                throw new NoSuchAlgorithmException(stringBuilder.toString());
            }
        } else if (b2 > 0) {
            bArr = new byte[(b2 / 8)];
            System.arraycopy(a, 0, bArr, 0, bArr.length);
        } else {
            bArr = a;
        }
        if (f27394c.containsKey(b)) {
            DESParameters.m40788a(bArr);
        }
        return new SecretKeySpec(bArr, BaseAgreementSpi.m27987a(str));
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec != null && (algorithmParameterSpec instanceof MQVParameterSpec) == null) {
            if ((algorithmParameterSpec instanceof UserKeyingMaterialSpec) == null) {
                throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
            }
        }
        m35994a(key, algorithmParameterSpec);
    }

    protected void engineInit(Key key, SecureRandom secureRandom) {
        m35994a(key, null);
    }

    /* renamed from: a */
    private void m35994a(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        byte[] bArr = null;
        if (this.f27398g instanceof ECMQVBasicAgreement) {
            ECPrivateKeyParameters eCPrivateKeyParameters;
            ECPublicKeyParameters eCPublicKeyParameters;
            this.f27400i = null;
            boolean z = key instanceof MQVPrivateKey;
            if (!z) {
                if (!(algorithmParameterSpec instanceof MQVParameterSpec)) {
                    algorithmParameterSpec = new StringBuilder();
                    algorithmParameterSpec.append(this.f27395d);
                    algorithmParameterSpec.append(" key agreement requires ");
                    algorithmParameterSpec.append(m35993a(MQVParameterSpec.class));
                    algorithmParameterSpec.append(" for initialisation");
                    throw new InvalidKeyException(algorithmParameterSpec.toString());
                }
            }
            if (z) {
                MQVPrivateKey mQVPrivateKey = (MQVPrivateKey) key;
                ECPrivateKeyParameters eCPrivateKeyParameters2 = (ECPrivateKeyParameters) ECUtil.m28009a(mQVPrivateKey.mo5896a());
                eCPrivateKeyParameters = (ECPrivateKeyParameters) ECUtil.m28009a(mQVPrivateKey.mo5897b());
                if (mQVPrivateKey.mo5898c() != null) {
                    eCPublicKeyParameters = (ECPublicKeyParameters) ECUtil.m28010a(mQVPrivateKey.mo5898c());
                }
                key = eCPrivateKeyParameters2;
            } else {
                MQVParameterSpec mQVParameterSpec = (MQVParameterSpec) algorithmParameterSpec;
                key = (ECPrivateKeyParameters) ECUtil.m28009a((PrivateKey) key);
                eCPrivateKeyParameters = (ECPrivateKeyParameters) ECUtil.m28009a(mQVParameterSpec.m28106a());
                if (mQVParameterSpec.m28107b() != null) {
                    eCPublicKeyParameters = (ECPublicKeyParameters) ECUtil.m28010a(mQVParameterSpec.m28107b());
                }
                this.f27400i = mQVParameterSpec;
                this.f27401j = mQVParameterSpec.m28109d();
            }
            algorithmParameterSpec = new MQVPrivateParameters(key, eCPrivateKeyParameters, eCPublicKeyParameters);
            this.f27397f = key.m40792b();
            this.f27398g.mo5724a(algorithmParameterSpec);
        } else if (key instanceof PrivateKey) {
            ECPrivateKeyParameters eCPrivateKeyParameters3 = (ECPrivateKeyParameters) ECUtil.m28009a((PrivateKey) key);
            this.f27397f = eCPrivateKeyParameters3.m40792b();
            if (algorithmParameterSpec instanceof UserKeyingMaterialSpec) {
                bArr = ((UserKeyingMaterialSpec) algorithmParameterSpec).m28112a();
            }
            this.f27401j = bArr;
            this.f27398g.mo5724a(eCPrivateKeyParameters3);
        } else {
            algorithmParameterSpec = new StringBuilder();
            algorithmParameterSpec.append(this.f27395d);
            algorithmParameterSpec.append(" key agreement requires ");
            algorithmParameterSpec.append(m35993a(ECPrivateKey.class));
            algorithmParameterSpec.append(" for initialisation");
            throw new InvalidKeyException(algorithmParameterSpec.toString());
        }
    }

    /* renamed from: a */
    private static String m35993a(Class cls) {
        cls = cls.getName();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }
}
