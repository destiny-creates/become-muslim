package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class DSADigestSigner implements Signer {
    /* renamed from: a */
    private final Digest f27239a;
    /* renamed from: b */
    private final DSA f27240b;
    /* renamed from: c */
    private boolean f27241c;

    public DSADigestSigner(DSA dsa, Digest digest) {
        this.f27239a = digest;
        this.f27240b = dsa;
    }

    /* renamed from: a */
    public void mo5796a(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.f27241c = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).m35698b();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z) {
            if (!asymmetricKeyParameter.m35630a()) {
                throw new IllegalArgumentException("Signing Requires Private Key.");
            }
        }
        if (!z) {
            if (asymmetricKeyParameter.m35630a()) {
                throw new IllegalArgumentException("Verification Requires Public Key.");
            }
        }
        m35776b();
        this.f27240b.mo5800a(z, cipherParameters);
    }

    /* renamed from: a */
    public void mo5795a(byte b) {
        this.f27239a.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5797a(byte[] bArr, int i, int i2) {
        this.f27239a.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public byte[] mo5799a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f27241c;
        if (r0 == 0) goto L_0x002a;
    L_0x0004:
        r0 = r3.f27239a;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r3.f27239a;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r1 = r3.f27240b;
        r0 = r1.mo5802a(r0);
        r1 = r0[r2];	 Catch:{ IOException -> 0x0022 }
        r2 = 1;	 Catch:{ IOException -> 0x0022 }
        r0 = r0[r2];	 Catch:{ IOException -> 0x0022 }
        r0 = r3.m35769a(r1, r0);	 Catch:{ IOException -> 0x0022 }
        return r0;
    L_0x0022:
        r0 = new java.lang.IllegalStateException;
        r1 = "unable to encode signature";
        r0.<init>(r1);
        throw r0;
    L_0x002a:
        r0 = new java.lang.IllegalStateException;
        r1 = "DSADigestSigner not initialised for signature generation.";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.DSADigestSigner.a():byte[]");
    }

    /* renamed from: a */
    public boolean mo5798a(byte[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.f27241c;
        if (r0 != 0) goto L_0x0023;
    L_0x0004:
        r0 = r5.f27239a;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r5.f27239a;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r6 = r5.m35770b(r6);	 Catch:{ IOException -> 0x0022 }
        r1 = r5.f27240b;	 Catch:{ IOException -> 0x0022 }
        r3 = r6[r2];	 Catch:{ IOException -> 0x0022 }
        r4 = 1;	 Catch:{ IOException -> 0x0022 }
        r6 = r6[r4];	 Catch:{ IOException -> 0x0022 }
        r6 = r1.mo5801a(r0, r3, r6);	 Catch:{ IOException -> 0x0022 }
        return r6;
    L_0x0022:
        return r2;
    L_0x0023:
        r6 = new java.lang.IllegalStateException;
        r0 = "DSADigestSigner not initialised for verification";
        r6.<init>(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.DSADigestSigner.a(byte[]):boolean");
    }

    /* renamed from: b */
    public void m35776b() {
        this.f27239a.mo5733c();
    }

    /* renamed from: a */
    private byte[] m35769a(BigInteger bigInteger, BigInteger bigInteger2) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(bigInteger));
        aSN1EncodableVector.m27141a(new ASN1Integer(bigInteger2));
        return new DERSequence(aSN1EncodableVector).m34596a("DER");
    }

    /* renamed from: b */
    private BigInteger[] m35770b(byte[] bArr) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.m39798b(bArr);
        return new BigInteger[]{((ASN1Integer) aSN1Sequence.mo6860a(0)).m42968b(), ((ASN1Integer) aSN1Sequence.mo6860a(1)).m42968b()};
    }
}
