package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.ECDSASigner;
import org.spongycastle.crypto.signers.ECNRSigner;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;
import org.spongycastle.jcajce.provider.asymmetric.util.DSABase;
import org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;

public class SignatureSpi extends DSABase {

    private static class PlainDSAEncoder implements DSAEncoder {
        private PlainDSAEncoder() {
        }

        /* renamed from: a */
        public byte[] mo5853a(BigInteger bigInteger, BigInteger bigInteger2) {
            Object obj;
            bigInteger = m36000a(bigInteger);
            bigInteger2 = m36000a(bigInteger2);
            if (bigInteger.length > bigInteger2.length) {
                obj = new byte[(bigInteger.length * 2)];
            } else {
                obj = new byte[(bigInteger2.length * 2)];
            }
            System.arraycopy(bigInteger, 0, obj, (obj.length / 2) - bigInteger.length, bigInteger.length);
            System.arraycopy(bigInteger2, 0, obj, obj.length - bigInteger2.length, bigInteger2.length);
            return obj;
        }

        /* renamed from: a */
        private byte[] m36000a(BigInteger bigInteger) {
            bigInteger = bigInteger.toByteArray();
            if (bigInteger[0] != (byte) 0) {
                return bigInteger;
            }
            Object obj = new byte[(bigInteger.length - 1)];
            System.arraycopy(bigInteger, 1, obj, 0, obj.length);
            return obj;
        }

        /* renamed from: a */
        public BigInteger[] mo5854a(byte[] bArr) {
            BigInteger[] bigIntegerArr = new BigInteger[2];
            Object obj = new byte[(bArr.length / 2)];
            Object obj2 = new byte[(bArr.length / 2)];
            System.arraycopy(bArr, 0, obj, 0, obj.length);
            System.arraycopy(bArr, obj.length, obj2, 0, obj2.length);
            bigIntegerArr[0] = new BigInteger(1, obj);
            bigIntegerArr[1] = new BigInteger(1, obj2);
            return bigIntegerArr;
        }
    }

    private static class StdDSAEncoder implements DSAEncoder {
        private StdDSAEncoder() {
        }

        /* renamed from: a */
        public byte[] mo5853a(BigInteger bigInteger, BigInteger bigInteger2) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.m27141a(new ASN1Integer(bigInteger));
            aSN1EncodableVector.m27141a(new ASN1Integer(bigInteger2));
            return new DERSequence(aSN1EncodableVector).m34596a("DER");
        }

        /* renamed from: a */
        public BigInteger[] mo5854a(byte[] bArr) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.m39798b(bArr);
            return new BigInteger[]{ASN1Integer.m42963a(aSN1Sequence.mo6860a(0)).m42968b(), ASN1Integer.m42963a(aSN1Sequence.mo6860a(1)).m42968b()};
        }
    }

    public static class ecCVCDSA224 extends SignatureSpi {
        public ecCVCDSA224() {
            super(new SHA224Digest(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    public static class ecCVCDSA256 extends SignatureSpi {
        public ecCVCDSA256() {
            super(new SHA256Digest(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    public static class ecCVCDSA384 extends SignatureSpi {
        public ecCVCDSA384() {
            super(new SHA384Digest(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    public static class ecCVCDSA512 extends SignatureSpi {
        public ecCVCDSA512() {
            super(new SHA512Digest(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    public static class ecCVCDSA extends SignatureSpi {
        public ecCVCDSA() {
            super(new SHA1Digest(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    public static class ecDSA224 extends SignatureSpi {
        public ecDSA224() {
            super(new SHA224Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    public static class ecDSA256 extends SignatureSpi {
        public ecDSA256() {
            super(new SHA256Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    public static class ecDSA384 extends SignatureSpi {
        public ecDSA384() {
            super(new SHA384Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    public static class ecDSA512 extends SignatureSpi {
        public ecDSA512() {
            super(new SHA512Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    public static class ecDSA extends SignatureSpi {
        public ecDSA() {
            super(new SHA1Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    public static class ecDSARipeMD160 extends SignatureSpi {
        public ecDSARipeMD160() {
            super(new RIPEMD160Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    public static class ecDSAnone extends SignatureSpi {
        public ecDSAnone() {
            super(new NullDigest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    public static class ecDetDSA224 extends SignatureSpi {
        public ecDetDSA224() {
            super(new SHA224Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA224Digest())), new StdDSAEncoder());
        }
    }

    public static class ecDetDSA256 extends SignatureSpi {
        public ecDetDSA256() {
            super(new SHA256Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA256Digest())), new StdDSAEncoder());
        }
    }

    public static class ecDetDSA384 extends SignatureSpi {
        public ecDetDSA384() {
            super(new SHA384Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA384Digest())), new StdDSAEncoder());
        }
    }

    public static class ecDetDSA512 extends SignatureSpi {
        public ecDetDSA512() {
            super(new SHA512Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA512Digest())), new StdDSAEncoder());
        }
    }

    public static class ecDetDSA extends SignatureSpi {
        public ecDetDSA() {
            super(new SHA1Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA1Digest())), new StdDSAEncoder());
        }
    }

    public static class ecNR224 extends SignatureSpi {
        public ecNR224() {
            super(new SHA224Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    public static class ecNR256 extends SignatureSpi {
        public ecNR256() {
            super(new SHA256Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    public static class ecNR384 extends SignatureSpi {
        public ecNR384() {
            super(new SHA384Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    public static class ecNR512 extends SignatureSpi {
        public ecNR512() {
            super(new SHA512Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    public static class ecNR extends SignatureSpi {
        public ecNR() {
            super(new SHA1Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    public static class ecPlainDSARP160 extends SignatureSpi {
        public ecPlainDSARP160() {
            super(new RIPEMD160Digest(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    SignatureSpi(Digest digest, DSA dsa, DSAEncoder dSAEncoder) {
        super(digest, dsa, dSAEncoder);
    }

    protected void engineInitVerify(PublicKey publicKey) {
        publicKey = ECUtil.m28010a(publicKey);
        this.bF.mo5733c();
        this.bG.mo5800a(false, publicKey);
    }

    protected void engineInitSign(PrivateKey privateKey) {
        privateKey = ECUtil.m28009a(privateKey);
        this.bF.mo5733c();
        if (this.appRandom != null) {
            this.bG.mo5800a(true, new ParametersWithRandom(privateKey, this.appRandom));
        } else {
            this.bG.mo5800a(true, privateKey);
        }
    }
}
