package org.spongycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Pack;

public class DHKEKGenerator implements DerivationFunction {
    /* renamed from: a */
    private final Digest f26484a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f26485b;
    /* renamed from: c */
    private int f26486c;
    /* renamed from: d */
    private byte[] f26487d;
    /* renamed from: e */
    private byte[] f26488e;

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.f26485b = dHKDFParameters.m34718a();
        this.f26486c = dHKDFParameters.m34719b();
        this.f26487d = dHKDFParameters.m34720c();
        this.f26488e = dHKDFParameters.m34721d();
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        DHKEKGenerator dHKEKGenerator = this;
        Object obj = bArr;
        int i3 = i2;
        int i4 = i;
        if (obj.length - i3 >= i4) {
            long j = (long) i3;
            int b = dHKEKGenerator.f26484a.mo5732b();
            if (j <= 8589934591L) {
                long j2 = (long) b;
                int i5 = (int) (((j + j2) - 1) / j2);
                Object obj2 = new byte[dHKEKGenerator.f26484a.mo5732b()];
                int i6 = 0;
                int i7 = i3;
                int i8 = i4;
                i3 = 0;
                i4 = 1;
                while (i3 < i5) {
                    boolean z;
                    dHKEKGenerator.f26484a.mo5731a(dHKEKGenerator.f26487d, i6, dHKEKGenerator.f26487d.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.m27141a(dHKEKGenerator.f26485b);
                    aSN1EncodableVector2.m27141a(new DEROctetString(Pack.m29404a(i4)));
                    aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
                    if (dHKEKGenerator.f26488e != null) {
                        z = true;
                        aSN1EncodableVector.m27141a(new DERTaggedObject(true, i6, new DEROctetString(dHKEKGenerator.f26488e)));
                    } else {
                        z = true;
                    }
                    aSN1EncodableVector.m27141a(new DERTaggedObject(z, 2, new DEROctetString(Pack.m29404a(dHKEKGenerator.f26486c))));
                    try {
                        byte[] a = new DERSequence(aSN1EncodableVector).m34596a("DER");
                        dHKEKGenerator.f26484a.mo5731a(a, 0, a.length);
                        dHKEKGenerator.f26484a.mo5728a(obj2, 0);
                        if (i7 > b) {
                            System.arraycopy(obj2, 0, obj, i8, b);
                            i8 += b;
                            i7 -= b;
                        } else {
                            System.arraycopy(obj2, 0, obj, i8, i7);
                        }
                        i4++;
                        i3++;
                        i6 = 0;
                    } catch (IOException e) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unable to encode parameter info: ");
                        stringBuilder.append(e.getMessage());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                dHKEKGenerator.f26484a.mo5733c();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new DataLengthException("output buffer too small");
    }
}
