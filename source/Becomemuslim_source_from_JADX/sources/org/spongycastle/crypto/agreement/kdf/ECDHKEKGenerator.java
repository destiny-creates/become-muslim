package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Pack;

public class ECDHKEKGenerator implements DigestDerivationFunction {
    /* renamed from: a */
    private DigestDerivationFunction f31543a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f31544b;
    /* renamed from: c */
    private int f31545c;
    /* renamed from: d */
    private byte[] f31546d;

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.f31544b = dHKDFParameters.m34718a();
        this.f31545c = dHKDFParameters.m34719b();
        this.f31546d = dHKDFParameters.m34720c();
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new AlgorithmIdentifier(this.f31544b, DERNull.f32850a));
        aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, new DEROctetString(Pack.m29404a(this.f31545c))));
        try {
            this.f31543a.mo5727a(new KDFParameters(this.f31546d, new DERSequence(aSN1EncodableVector).m34596a("DER")));
            return this.f31543a.mo5726a(bArr, i, i2);
        } catch (byte[] bArr2) {
            i2 = new StringBuilder();
            i2.append("unable to initialise kdf: ");
            i2.append(bArr2.getMessage());
            throw new IllegalArgumentException(i2.toString());
        }
    }
}
