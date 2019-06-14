package org.spongycastle.asn1.x509;

import java.util.StringTokenizer;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.util.IPAddress;

public class GeneralName extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private ASN1Encodable f31308a;
    /* renamed from: b */
    private int f31309b;

    public GeneralName(X500Name x500Name) {
        this.f31308a = x500Name;
        this.f31309b = 4;
    }

    public GeneralName(int i, ASN1Encodable aSN1Encodable) {
        this.f31308a = aSN1Encodable;
        this.f31309b = i;
    }

    public GeneralName(int i, String str) {
        this.f31309b = i;
        if (!(i == 1 || i == 2)) {
            if (i != 6) {
                if (i == 8) {
                    this.f31308a = new ASN1ObjectIdentifier(str);
                    return;
                } else if (i == 4) {
                    this.f31308a = new X500Name(str);
                    return;
                } else if (i == 7) {
                    i = m40340b(str);
                    if (i != 0) {
                        this.f31308a = new DEROctetString(i);
                        return;
                    }
                    throw new IllegalArgumentException("IP Address is invalid");
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("can't process String for tag: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        this.f31308a = new DERIA5String(str);
    }

    /* renamed from: a */
    public static org.spongycastle.asn1.x509.GeneralName m40335a(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 == 0) goto L_0x00b8;
    L_0x0002:
        r0 = r3 instanceof org.spongycastle.asn1.x509.GeneralName;
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        goto L_0x00b8;
    L_0x0008:
        r0 = r3 instanceof org.spongycastle.asn1.ASN1TaggedObject;
        if (r0 == 0) goto L_0x0080;
    L_0x000c:
        r0 = r3;
        r0 = (org.spongycastle.asn1.ASN1TaggedObject) r0;
        r1 = r0.m43030b();
        r2 = 0;
        switch(r1) {
            case 0: goto L_0x0076;
            case 1: goto L_0x006c;
            case 2: goto L_0x0062;
            case 3: goto L_0x004b;
            case 4: goto L_0x0040;
            case 5: goto L_0x0036;
            case 6: goto L_0x002c;
            case 7: goto L_0x0022;
            case 8: goto L_0x0018;
            default: goto L_0x0017;
        };
    L_0x0017:
        goto L_0x0080;
    L_0x0018:
        r3 = new org.spongycastle.asn1.x509.GeneralName;
        r0 = org.spongycastle.asn1.ASN1ObjectIdentifier.m42974a(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x0022:
        r3 = new org.spongycastle.asn1.x509.GeneralName;
        r0 = org.spongycastle.asn1.ASN1OctetString.m42991a(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x002c:
        r3 = new org.spongycastle.asn1.x509.GeneralName;
        r0 = org.spongycastle.asn1.DERIA5String.m43080a(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x0036:
        r3 = new org.spongycastle.asn1.x509.GeneralName;
        r0 = org.spongycastle.asn1.ASN1Sequence.m43001a(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x0040:
        r3 = new org.spongycastle.asn1.x509.GeneralName;
        r2 = 1;
        r0 = org.spongycastle.asn1.x500.X500Name.m40213a(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x004b:
        r3 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "unknown tag: ";
        r0.append(r2);
        r0.append(r1);
        r0 = r0.toString();
        r3.<init>(r0);
        throw r3;
    L_0x0062:
        r3 = new org.spongycastle.asn1.x509.GeneralName;
        r0 = org.spongycastle.asn1.DERIA5String.m43080a(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x006c:
        r3 = new org.spongycastle.asn1.x509.GeneralName;
        r0 = org.spongycastle.asn1.DERIA5String.m43080a(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x0076:
        r3 = new org.spongycastle.asn1.x509.GeneralName;
        r0 = org.spongycastle.asn1.ASN1Sequence.m43001a(r0, r2);
        r3.<init>(r1, r0);
        return r3;
    L_0x0080:
        r0 = r3 instanceof byte[];
        if (r0 == 0) goto L_0x0099;
    L_0x0084:
        r3 = (byte[]) r3;	 Catch:{ IOException -> 0x0091 }
        r3 = (byte[]) r3;	 Catch:{ IOException -> 0x0091 }
        r3 = org.spongycastle.asn1.ASN1Primitive.m39798b(r3);	 Catch:{ IOException -> 0x0091 }
        r3 = m40335a(r3);	 Catch:{ IOException -> 0x0091 }
        return r3;
    L_0x0091:
        r3 = new java.lang.IllegalArgumentException;
        r0 = "unable to parse encoded general name";
        r3.<init>(r0);
        throw r3;
    L_0x0099:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "unknown object in getInstance: ";
        r1.append(r2);
        r3 = r3.getClass();
        r3 = r3.getName();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x00b8:
        r3 = (org.spongycastle.asn1.x509.GeneralName) r3;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.GeneralName.a(java.lang.Object):org.spongycastle.asn1.x509.GeneralName");
    }

    /* renamed from: a */
    public static GeneralName m40336a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40335a(ASN1TaggedObject.m43027a(aSN1TaggedObject, true));
    }

    /* renamed from: a */
    public int m40343a() {
        return this.f31309b;
    }

    /* renamed from: b */
    public ASN1Encodable m40344b() {
        return this.f31308a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f31309b);
        stringBuffer.append(": ");
        int i = this.f31309b;
        if (i != 4) {
            if (i != 6) {
                switch (i) {
                    case 1:
                    case 2:
                        break;
                    default:
                        stringBuffer.append(this.f31308a.toString());
                        break;
                }
            }
            stringBuffer.append(DERIA5String.m43079a(this.f31308a).mo6440b());
        } else {
            stringBuffer.append(X500Name.m40212a(this.f31308a).toString());
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private byte[] m40340b(String str) {
        int indexOf;
        byte[] bArr;
        if (!IPAddress.m29393c(str)) {
            if (!IPAddress.m29394d(str)) {
                if (!IPAddress.m29392b(str)) {
                    if (!IPAddress.m29390a(str)) {
                        return null;
                    }
                }
                indexOf = str.indexOf(47);
                if (indexOf < 0) {
                    byte[] bArr2 = new byte[4];
                    m40339b(str, bArr2, 0);
                    return bArr2;
                }
                bArr = new byte[8];
                m40339b(str.substring(0, indexOf), bArr, 0);
                str = str.substring(indexOf + 1);
                if (str.indexOf(46) > 0) {
                    m40339b(str, bArr, 4);
                } else {
                    m40337a(str, bArr, 4);
                }
                return bArr;
            }
        }
        indexOf = str.indexOf(47);
        if (indexOf < 0) {
            bArr2 = new byte[16];
            m40338a(m40342d(str), bArr2, 0);
            return bArr2;
        }
        int[] d;
        bArr = new byte[32];
        m40338a(m40342d(str.substring(0, indexOf)), bArr, 0);
        str = str.substring(indexOf + 1);
        if (str.indexOf(58) > 0) {
            d = m40342d(str);
        } else {
            d = m40341c(str);
        }
        m40338a(d, bArr, 16);
        return bArr;
    }

    /* renamed from: a */
    private void m40337a(String str, byte[] bArr, int i) {
        str = Integer.parseInt(str);
        for (int i2 = 0; i2 != str; i2++) {
            int i3 = (i2 / 8) + i;
            bArr[i3] = (byte) (bArr[i3] | (1 << (7 - (i2 % 8))));
        }
    }

    /* renamed from: b */
    private void m40339b(String str, byte[] bArr, int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "./");
        str = null;
        while (stringTokenizer.hasMoreTokens()) {
            int i2 = str + 1;
            bArr[str + i] = (byte) Integer.parseInt(stringTokenizer.nextToken());
            str = i2;
        }
    }

    /* renamed from: c */
    private int[] m40341c(String str) {
        int[] iArr = new int[8];
        str = Integer.parseInt(str);
        for (int i = 0; i != str; i++) {
            int i2 = i / 16;
            iArr[i2] = iArr[i2] | (1 << (15 - (i % 16)));
        }
        return iArr;
    }

    /* renamed from: a */
    private void m40338a(int[] iArr, byte[] bArr, int i) {
        for (int i2 = 0; i2 != iArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i3 + i] = (byte) (iArr[i2] >> 8);
            bArr[(i3 + 1) + i] = (byte) iArr[i2];
        }
    }

    /* renamed from: d */
    private int[] m40342d(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ":", true);
        Object obj = new int[8];
        if (str.charAt(0) == ':' && str.charAt(1) == 58) {
            stringTokenizer.nextToken();
        }
        str = null;
        int i = -1;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals(":")) {
                i = str + 1;
                obj[str] = null;
                int i2 = i;
                i = str;
                str = i2;
            } else if (nextToken.indexOf(46) < 0) {
                int i3 = str + 1;
                obj[str] = Integer.parseInt(nextToken, 16);
                if (stringTokenizer.hasMoreTokens() != null) {
                    stringTokenizer.nextToken();
                }
                str = i3;
            } else {
                StringTokenizer stringTokenizer2 = new StringTokenizer(nextToken, ".");
                int i4 = str + 1;
                obj[str] = (Integer.parseInt(stringTokenizer2.nextToken()) << 8) | Integer.parseInt(stringTokenizer2.nextToken());
                str = i4 + 1;
                obj[i4] = Integer.parseInt(stringTokenizer2.nextToken()) | (Integer.parseInt(stringTokenizer2.nextToken()) << 8);
            }
        }
        if (str != obj.length) {
            str -= i;
            System.arraycopy(obj, i, obj, obj.length - str, str);
            while (i != obj.length - str) {
                obj[i] = null;
                i++;
            }
        }
        return obj;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f31309b == 4) {
            return new DERTaggedObject(true, this.f31309b, this.f31308a);
        }
        return new DERTaggedObject(false, this.f31309b, this.f31308a);
    }
}
