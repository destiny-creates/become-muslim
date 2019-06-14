package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD4Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.RIPEMD128Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.RIPEMD256Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;

public class DigestSignatureSpi extends SignatureSpi {
    /* renamed from: a */
    private Digest f22792a;
    /* renamed from: b */
    private AsymmetricBlockCipher f22793b;
    /* renamed from: c */
    private AlgorithmIdentifier f22794c;

    public static class MD2 extends DigestSignatureSpi {
        public MD2() {
            super(PKCSObjectIdentifiers.f21839F, new MD2Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD4 extends DigestSignatureSpi {
        public MD4() {
            super(PKCSObjectIdentifiers.f21840G, new MD4Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD5 extends DigestSignatureSpi {
        public MD5() {
            super(PKCSObjectIdentifiers.f21841H, new MD5Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD128 extends DigestSignatureSpi {
        public RIPEMD128() {
            super(TeleTrusTObjectIdentifiers.f21983c, new RIPEMD128Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD160 extends DigestSignatureSpi {
        public RIPEMD160() {
            super(TeleTrusTObjectIdentifiers.f21982b, new RIPEMD160Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD256 extends DigestSignatureSpi {
        public RIPEMD256() {
            super(TeleTrusTObjectIdentifiers.f21984d, new RIPEMD256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA1 extends DigestSignatureSpi {
        public SHA1() {
            super(OIWObjectIdentifiers.f21830i, new SHA1Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA224 extends DigestSignatureSpi {
        public SHA224() {
            super(NISTObjectIdentifiers.f21785f, new SHA224Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA256 extends DigestSignatureSpi {
        public SHA256() {
            super(NISTObjectIdentifiers.f21782c, new SHA256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA384 extends DigestSignatureSpi {
        public SHA384() {
            super(NISTObjectIdentifiers.f21783d, new SHA384Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512 extends DigestSignatureSpi {
        public SHA512() {
            super(NISTObjectIdentifiers.f21784e, new SHA512Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512_224 extends DigestSignatureSpi {
        public SHA512_224() {
            super(NISTObjectIdentifiers.f21786g, new SHA512tDigest(224), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512_256 extends DigestSignatureSpi {
        public SHA512_256() {
            super(NISTObjectIdentifiers.f21787h, new SHA512tDigest(256), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class noneRSA extends DigestSignatureSpi {
        public noneRSA() {
            super(new NullDigest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    protected Object engineGetParameter(String str) {
        return null;
    }

    protected AlgorithmParameters engineGetParameters() {
        return null;
    }

    protected DigestSignatureSpi(Digest digest, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f22792a = digest;
        this.f22793b = asymmetricBlockCipher;
        this.f22794c = null;
    }

    protected DigestSignatureSpi(ASN1ObjectIdentifier aSN1ObjectIdentifier, Digest digest, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f22792a = digest;
        this.f22793b = asymmetricBlockCipher;
        this.f22794c = new AlgorithmIdentifier(aSN1ObjectIdentifier, DERNull.f32850a);
    }

    protected void engineInitVerify(PublicKey publicKey) {
        if (publicKey instanceof RSAPublicKey) {
            publicKey = RSAUtil.m27985a((RSAPublicKey) publicKey);
            this.f22792a.mo5733c();
            this.f22793b.mo5737a(false, publicKey);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Supplied key (");
        stringBuilder.append(m27980a((Object) publicKey));
        stringBuilder.append(") is not a RSAPublicKey instance");
        throw new InvalidKeyException(stringBuilder.toString());
    }

    protected void engineInitSign(PrivateKey privateKey) {
        if (privateKey instanceof RSAPrivateKey) {
            privateKey = RSAUtil.m27984a((RSAPrivateKey) privateKey);
            this.f22792a.mo5733c();
            this.f22793b.mo5737a(true, privateKey);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Supplied key (");
        stringBuilder.append(m27980a((Object) privateKey));
        stringBuilder.append(") is not a RSAPrivateKey instance");
        throw new InvalidKeyException(stringBuilder.toString());
    }

    /* renamed from: a */
    private String m27980a(Object obj) {
        return obj == null ? null : obj.getClass().getName();
    }

    protected void engineUpdate(byte b) {
        this.f22792a.mo5730a(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.f22792a.mo5731a(bArr, i, i2);
    }

    protected byte[] engineSign() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f22792a;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r4.f22792a;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r0 = r4.m27981a(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0025, Exception -> 0x001a }
        r1 = r4.f22793b;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0025, Exception -> 0x001a }
        r3 = r0.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0025, Exception -> 0x001a }
        r0 = r1.mo5738a(r0, r2, r3);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0025, Exception -> 0x001a }
        return r0;
    L_0x001a:
        r0 = move-exception;
        r1 = new java.security.SignatureException;
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0025:
        r0 = new java.security.SignatureException;
        r1 = "key too small for signature type";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi.engineSign():byte[]");
    }

    protected boolean engineVerify(byte[] r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r10.f22792a;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r10.f22792a;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r1 = r10.f22793b;	 Catch:{ Exception -> 0x0068 }
        r3 = r11.length;	 Catch:{ Exception -> 0x0068 }
        r11 = r1.mo5738a(r11, r2, r3);	 Catch:{ Exception -> 0x0068 }
        r1 = r10.m27981a(r0);	 Catch:{ Exception -> 0x0068 }
        r3 = r11.length;
        r4 = r1.length;
        if (r3 != r4) goto L_0x0022;
    L_0x001d:
        r11 = org.spongycastle.util.Arrays.m29372b(r11, r1);
        return r11;
    L_0x0022:
        r3 = r11.length;
        r4 = r1.length;
        r4 = r4 + -2;
        if (r3 != r4) goto L_0x0064;
    L_0x0028:
        r3 = r11.length;
        r4 = r0.length;
        r3 = r3 - r4;
        r3 = r3 + -2;
        r4 = r1.length;
        r5 = r0.length;
        r4 = r4 - r5;
        r4 = r4 + -2;
        r5 = 1;
        r6 = r1[r5];
        r6 = r6 + -2;
        r6 = (byte) r6;
        r1[r5] = r6;
        r6 = 3;
        r7 = r1[r6];
        r7 = r7 + -2;
        r7 = (byte) r7;
        r1[r6] = r7;
        r6 = 0;
        r7 = 0;
    L_0x0044:
        r8 = r0.length;
        if (r6 >= r8) goto L_0x0054;
    L_0x0047:
        r8 = r3 + r6;
        r8 = r11[r8];
        r9 = r4 + r6;
        r9 = r1[r9];
        r8 = r8 ^ r9;
        r7 = r7 | r8;
        r6 = r6 + 1;
        goto L_0x0044;
    L_0x0054:
        r0 = 0;
    L_0x0055:
        if (r0 >= r3) goto L_0x0060;
    L_0x0057:
        r4 = r11[r0];
        r6 = r1[r0];
        r4 = r4 ^ r6;
        r7 = r7 | r4;
        r0 = r0 + 1;
        goto L_0x0055;
    L_0x0060:
        if (r7 != 0) goto L_0x0063;
    L_0x0062:
        r2 = 1;
    L_0x0063:
        return r2;
    L_0x0064:
        org.spongycastle.util.Arrays.m29372b(r1, r1);
        return r2;
    L_0x0068:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi.engineVerify(byte[]):boolean");
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* renamed from: a */
    private byte[] m27981a(byte[] bArr) {
        if (this.f22794c == null) {
            return bArr;
        }
        return new DigestInfo(this.f22794c, bArr).m34596a("DER");
    }
}
