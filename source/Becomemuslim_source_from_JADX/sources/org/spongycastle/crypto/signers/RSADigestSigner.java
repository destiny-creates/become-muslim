package org.spongycastle.crypto.signers;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class RSADigestSigner implements Signer {
    /* renamed from: e */
    private static final Hashtable f27278e = new Hashtable();
    /* renamed from: a */
    private final AsymmetricBlockCipher f27279a = new PKCS1Encoding(new RSABlindedEngine());
    /* renamed from: b */
    private final AlgorithmIdentifier f27280b;
    /* renamed from: c */
    private final Digest f27281c;
    /* renamed from: d */
    private boolean f27282d;

    static {
        f27278e.put("RIPEMD128", TeleTrusTObjectIdentifiers.f21983c);
        f27278e.put("RIPEMD160", TeleTrusTObjectIdentifiers.f21982b);
        f27278e.put("RIPEMD256", TeleTrusTObjectIdentifiers.f21984d);
        f27278e.put("SHA-1", X509ObjectIdentifiers.f22087i);
        f27278e.put("SHA-224", NISTObjectIdentifiers.f21785f);
        f27278e.put("SHA-256", NISTObjectIdentifiers.f21782c);
        f27278e.put("SHA-384", NISTObjectIdentifiers.f21783d);
        f27278e.put("SHA-512", NISTObjectIdentifiers.f21784e);
        f27278e.put("SHA-512/224", NISTObjectIdentifiers.f21786g);
        f27278e.put("SHA-512/256", NISTObjectIdentifiers.f21787h);
        f27278e.put("MD2", PKCSObjectIdentifiers.f21839F);
        f27278e.put("MD4", PKCSObjectIdentifiers.f21840G);
        f27278e.put("MD5", PKCSObjectIdentifiers.f21841H);
    }

    public RSADigestSigner(Digest digest, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f27281c = digest;
        this.f27280b = new AlgorithmIdentifier(aSN1ObjectIdentifier, DERNull.f32850a);
    }

    /* renamed from: a */
    public void mo5796a(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.f27282d = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).m35698b();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z) {
            if (!asymmetricKeyParameter.m35630a()) {
                throw new IllegalArgumentException("signing requires private key");
            }
        }
        if (!z) {
            if (asymmetricKeyParameter.m35630a()) {
                throw new IllegalArgumentException("verification requires public key");
            }
        }
        m35832b();
        this.f27279a.mo5737a(z, cipherParameters);
    }

    /* renamed from: a */
    public void mo5795a(byte b) {
        this.f27281c.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5797a(byte[] bArr, int i, int i2) {
        this.f27281c.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public byte[] mo5799a() {
        if (this.f27282d) {
            byte[] bArr = new byte[this.f27281c.mo5732b()];
            this.f27281c.mo5728a(bArr, 0);
            try {
                bArr = m35826b(bArr);
                return this.f27279a.mo5738a(bArr, 0, bArr.length);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unable to encode signature: ");
                stringBuilder.append(e.getMessage());
                throw new CryptoException(stringBuilder.toString(), e);
            }
        }
        throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
    }

    /* renamed from: a */
    public boolean mo5798a(byte[] r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r10.f27282d;
        if (r0 != 0) goto L_0x006d;
    L_0x0004:
        r0 = r10.f27281c;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r10.f27281c;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r1 = r10.f27279a;	 Catch:{ Exception -> 0x006c }
        r3 = r11.length;	 Catch:{ Exception -> 0x006c }
        r11 = r1.mo5738a(r11, r2, r3);	 Catch:{ Exception -> 0x006c }
        r1 = r10.m35826b(r0);	 Catch:{ Exception -> 0x006c }
        r3 = r11.length;
        r4 = r1.length;
        if (r3 != r4) goto L_0x0026;
    L_0x0021:
        r11 = org.spongycastle.util.Arrays.m29372b(r11, r1);
        return r11;
    L_0x0026:
        r3 = r11.length;
        r4 = r1.length;
        r4 = r4 + -2;
        if (r3 != r4) goto L_0x0068;
    L_0x002c:
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
    L_0x0048:
        r8 = r0.length;
        if (r6 >= r8) goto L_0x0058;
    L_0x004b:
        r8 = r3 + r6;
        r8 = r11[r8];
        r9 = r4 + r6;
        r9 = r1[r9];
        r8 = r8 ^ r9;
        r7 = r7 | r8;
        r6 = r6 + 1;
        goto L_0x0048;
    L_0x0058:
        r0 = 0;
    L_0x0059:
        if (r0 >= r3) goto L_0x0064;
    L_0x005b:
        r4 = r11[r0];
        r6 = r1[r0];
        r4 = r4 ^ r6;
        r7 = r7 | r4;
        r0 = r0 + 1;
        goto L_0x0059;
    L_0x0064:
        if (r7 != 0) goto L_0x0067;
    L_0x0066:
        r2 = 1;
    L_0x0067:
        return r2;
    L_0x0068:
        org.spongycastle.util.Arrays.m29372b(r1, r1);
        return r2;
    L_0x006c:
        return r2;
    L_0x006d:
        r11 = new java.lang.IllegalStateException;
        r0 = "RSADigestSigner not initialised for verification";
        r11.<init>(r0);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.RSADigestSigner.a(byte[]):boolean");
    }

    /* renamed from: b */
    public void m35832b() {
        this.f27281c.mo5733c();
    }

    /* renamed from: b */
    private byte[] m35826b(byte[] bArr) {
        return new DigestInfo(this.f27280b, bArr).m34596a("DER");
    }
}
