package org.spongycastle.asn1.x509;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;

public class KeyUsage extends ASN1Object {
    /* renamed from: a */
    private DERBitString f31354a;

    /* renamed from: a */
    public static KeyUsage m40375a(Object obj) {
        if (obj instanceof KeyUsage) {
            return (KeyUsage) obj;
        }
        return obj != null ? new KeyUsage(DERBitString.m43051a(obj)) : null;
    }

    /* renamed from: a */
    public static KeyUsage m40376a(Extensions extensions) {
        return m40375a(extensions.m40333b(Extension.f31279c));
    }

    public KeyUsage(int i) {
        this.f31354a = new DERBitString(i);
    }

    private KeyUsage(DERBitString dERBitString) {
        this.f31354a = dERBitString;
    }

    /* renamed from: a */
    public byte[] m40377a() {
        return this.f31354a.m43059c();
    }

    public String toString() {
        byte[] c = this.f31354a.m43059c();
        if (c.length == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("KeyUsage: 0x");
            stringBuilder.append(Integer.toHexString(c[0] & JfifUtil.MARKER_FIRST_BYTE));
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("KeyUsage: 0x");
        stringBuilder.append(Integer.toHexString((c[0] & JfifUtil.MARKER_FIRST_BYTE) | ((c[1] & JfifUtil.MARKER_FIRST_BYTE) << 8)));
        return stringBuilder.toString();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31354a;
    }
}
