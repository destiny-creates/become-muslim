package org.spongycastle.asn1.ua;

import com.facebook.stetho.dumpapp.Framer;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

public class DSTU4145Params extends ASN1Object {
    /* renamed from: a */
    private static final byte[] f31110a = new byte[]{(byte) -87, (byte) -42, (byte) -21, (byte) 69, (byte) -15, (byte) 60, (byte) 112, (byte) -126, Byte.MIN_VALUE, (byte) -60, (byte) -106, (byte) 123, (byte) 35, (byte) 31, (byte) 94, (byte) -83, (byte) -10, (byte) 88, (byte) -21, (byte) -92, (byte) -64, (byte) 55, (byte) 41, (byte) 29, (byte) 56, (byte) -39, (byte) 107, (byte) -16, (byte) 37, (byte) -54, (byte) 78, (byte) 23, (byte) -8, (byte) -23, (byte) 114, (byte) 13, (byte) -58, (byte) 21, (byte) -76, (byte) 58, (byte) 40, (byte) -105, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) 11, (byte) -63, (byte) -34, (byte) -93, (byte) 100, (byte) 56, (byte) -75, (byte) 100, (byte) -22, (byte) 44, (byte) 23, (byte) -97, (byte) -48, (byte) 18, (byte) 62, (byte) 109, (byte) -72, (byte) -6, (byte) -59, (byte) 121, (byte) 4};
    /* renamed from: b */
    private ASN1ObjectIdentifier f31111b;
    /* renamed from: c */
    private DSTU4145ECBinary f31112c;
    /* renamed from: d */
    private byte[] f31113d = f31110a;

    public DSTU4145Params(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f31111b = aSN1ObjectIdentifier;
    }

    public DSTU4145Params(DSTU4145ECBinary dSTU4145ECBinary) {
        this.f31112c = dSTU4145ECBinary;
    }

    /* renamed from: a */
    public boolean m40195a() {
        return this.f31111b != null;
    }

    /* renamed from: b */
    public DSTU4145ECBinary m40196b() {
        return this.f31112c;
    }

    /* renamed from: c */
    public byte[] m40197c() {
        return this.f31113d;
    }

    /* renamed from: d */
    public static byte[] m40194d() {
        return f31110a;
    }

    /* renamed from: g */
    public ASN1ObjectIdentifier m40199g() {
        return this.f31111b;
    }

    /* renamed from: a */
    public static DSTU4145Params m40193a(Object obj) {
        if (obj instanceof DSTU4145Params) {
            return (DSTU4145Params) obj;
        }
        if (obj != null) {
            DSTU4145Params dSTU4145Params;
            obj = ASN1Sequence.m43000a(obj);
            if (obj.mo6860a(0) instanceof ASN1ObjectIdentifier) {
                dSTU4145Params = new DSTU4145Params(ASN1ObjectIdentifier.m42973a(obj.mo6860a(0)));
            } else {
                dSTU4145Params = new DSTU4145Params(DSTU4145ECBinary.m40186a(obj.mo6860a(0)));
            }
            if (obj.mo6862g() == 2) {
                dSTU4145Params.f31113d = ASN1OctetString.m42990a(obj.mo6860a(1)).mo6859c();
                if (dSTU4145Params.f31113d.length != f31110a.length) {
                    throw new IllegalArgumentException("object parse error");
                }
            }
            return dSTU4145Params;
        }
        throw new IllegalArgumentException("object parse error");
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31111b != null) {
            aSN1EncodableVector.m27141a(this.f31111b);
        } else {
            aSN1EncodableVector.m27141a(this.f31112c);
        }
        if (!Arrays.m29353a(this.f31113d, f31110a)) {
            aSN1EncodableVector.m27141a(new DEROctetString(this.f31113d));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
