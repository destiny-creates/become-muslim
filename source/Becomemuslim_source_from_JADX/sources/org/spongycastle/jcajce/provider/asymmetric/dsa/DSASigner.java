package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;

public class DSASigner extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private Digest bF;
    private DSA bG;
    private SecureRandom bH;

    public static class detDSA224 extends DSASigner {
        public detDSA224() {
            super(new SHA224Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA224Digest())));
        }
    }

    public static class detDSA256 extends DSASigner {
        public detDSA256() {
            super(new SHA256Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA256Digest())));
        }
    }

    public static class detDSA384 extends DSASigner {
        public detDSA384() {
            super(new SHA384Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA384Digest())));
        }
    }

    public static class detDSA512 extends DSASigner {
        public detDSA512() {
            super(new SHA512Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA512Digest())));
        }
    }

    public static class detDSA extends DSASigner {
        public detDSA() {
            super(new SHA1Digest(), new org.spongycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(new SHA1Digest())));
        }
    }

    public static class dsa224 extends DSASigner {
        public dsa224() {
            super(new SHA224Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class dsa256 extends DSASigner {
        public dsa256() {
            super(new SHA256Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class dsa384 extends DSASigner {
        public dsa384() {
            super(new SHA384Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class dsa512 extends DSASigner {
        public dsa512() {
            super(new SHA512Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class noneDSA extends DSASigner {
        public noneDSA() {
            super(new NullDigest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    public static class stdDSA extends DSASigner {
        public stdDSA() {
            super(new SHA1Digest(), new org.spongycastle.crypto.signers.DSASigner());
        }
    }

    protected DSASigner(Digest digest, DSA dsa) {
        this.bF = digest;
        this.bG = dsa;
    }

    protected void engineInitVerify(java.security.PublicKey r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3 instanceof java.security.interfaces.DSAKey;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r3 = org.spongycastle.jcajce.provider.asymmetric.dsa.DSAUtil.m27965a(r3);
        goto L_0x001e;
    L_0x0009:
        r3 = r3.getEncoded();	 Catch:{ Exception -> 0x0032 }
        r0 = new org.spongycastle.jcajce.provider.asymmetric.dsa.BCDSAPublicKey;	 Catch:{ Exception -> 0x0032 }
        r3 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.m40409a(r3);	 Catch:{ Exception -> 0x0032 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0032 }
        r3 = r0 instanceof java.security.interfaces.DSAKey;	 Catch:{ Exception -> 0x0032 }
        if (r3 == 0) goto L_0x002a;	 Catch:{ Exception -> 0x0032 }
    L_0x001a:
        r3 = org.spongycastle.jcajce.provider.asymmetric.dsa.DSAUtil.m27965a(r0);	 Catch:{ Exception -> 0x0032 }
    L_0x001e:
        r0 = r2.bF;
        r0.mo5733c();
        r0 = r2.bG;
        r1 = 0;
        r0.mo5800a(r1, r3);
        return;
    L_0x002a:
        r3 = new java.security.InvalidKeyException;	 Catch:{ Exception -> 0x0032 }
        r0 = "can't recognise key type in DSA based signer";	 Catch:{ Exception -> 0x0032 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0032 }
        throw r3;	 Catch:{ Exception -> 0x0032 }
    L_0x0032:
        r3 = new java.security.InvalidKeyException;
        r0 = "can't recognise key type in DSA based signer";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner.engineInitVerify(java.security.PublicKey):void");
    }

    protected void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) {
        this.bH = secureRandom;
        engineInitSign(privateKey);
    }

    protected void engineInitSign(PrivateKey privateKey) {
        privateKey = DSAUtil.m27964a(privateKey);
        if (this.bH != null) {
            privateKey = new ParametersWithRandom(privateKey, this.bH);
        }
        this.bF.mo5733c();
        this.bG.mo5800a(true, privateKey);
    }

    protected void engineUpdate(byte b) {
        this.bF.mo5730a(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.bF.mo5731a(bArr, i, i2);
    }

    protected byte[] engineSign() {
        byte[] bArr = new byte[this.bF.mo5732b()];
        this.bF.mo5728a(bArr, 0);
        try {
            BigInteger[] a = this.bG.mo5802a(bArr);
            return m35989a(a[0], a[1]);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    protected boolean engineVerify(byte[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.bF;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r4.bF;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r5 = r4.m35990a(r5);	 Catch:{ Exception -> 0x001e }
        r1 = r4.bG;
        r2 = r5[r2];
        r3 = 1;
        r5 = r5[r3];
        r5 = r1.mo5801a(r0, r2, r5);
        return r5;
    L_0x001e:
        r5 = new java.security.SignatureException;
        r0 = "error decoding signature bytes.";
        r5.<init>(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner.engineVerify(byte[]):boolean");
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* renamed from: a */
    private byte[] m35989a(BigInteger bigInteger, BigInteger bigInteger2) {
        return new DERSequence(new ASN1Integer[]{new ASN1Integer(bigInteger), new ASN1Integer(bigInteger2)}).m34596a("DER");
    }

    /* renamed from: a */
    private BigInteger[] m35990a(byte[] bArr) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.m39798b(bArr);
        return new BigInteger[]{((ASN1Integer) aSN1Sequence.mo6860a(0)).m42968b(), ((ASN1Integer) aSN1Sequence.mo6860a(1)).m42968b()};
    }
}
