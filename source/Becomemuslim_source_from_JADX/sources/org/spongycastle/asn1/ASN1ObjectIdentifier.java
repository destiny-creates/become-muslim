package org.spongycastle.asn1;

import com.facebook.imageutils.JfifUtil;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.util.Arrays;

public class ASN1ObjectIdentifier extends ASN1Primitive {
    /* renamed from: c */
    private static final Map f32484c = new HashMap();
    /* renamed from: a */
    private final String f32485a;
    /* renamed from: b */
    private byte[] f32486b;

    private static class OidHandle {
        /* renamed from: a */
        private int f21437a;
        /* renamed from: b */
        private final byte[] f21438b;

        OidHandle(byte[] bArr) {
            this.f21437a = Arrays.m29342a(bArr);
            this.f21438b = bArr;
        }

        public int hashCode() {
            return this.f21437a;
        }

        public boolean equals(Object obj) {
            return obj instanceof OidHandle ? Arrays.m29353a(this.f21438b, ((OidHandle) obj).f21438b) : null;
        }
    }

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    /* renamed from: a */
    public static ASN1ObjectIdentifier m42973a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof ASN1ObjectIdentifier)) {
                if (obj instanceof ASN1Encodable) {
                    ASN1Encodable aSN1Encodable = (ASN1Encodable) obj;
                    if (aSN1Encodable.mo5709e() instanceof ASN1ObjectIdentifier) {
                        return (ASN1ObjectIdentifier) aSN1Encodable.mo5709e();
                    }
                }
                StringBuilder stringBuilder;
                if (obj instanceof byte[]) {
                    try {
                        return (ASN1ObjectIdentifier) ASN1Primitive.m39798b((byte[]) obj);
                    } catch (Object obj2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("failed to construct object identifier from byte[]: ");
                        stringBuilder.append(obj2.getMessage());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("illegal object in getInstance: ");
                stringBuilder.append(obj2.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (ASN1ObjectIdentifier) obj2;
    }

    /* renamed from: a */
    public static ASN1ObjectIdentifier m42974a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        Object k = aSN1TaggedObject.m43036k();
        if (!z) {
            if (!(k instanceof ASN1ObjectIdentifier)) {
                return m42975a(ASN1OctetString.m42990a(aSN1TaggedObject.m43036k()).mo6859c());
            }
        }
        return m42973a(k);
    }

    ASN1ObjectIdentifier(byte[] bArr) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this;
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        long j = 0;
        BigInteger bigInteger = null;
        Object obj = 1;
        for (int i = 0; i != bArr2.length; i++) {
            int i2 = bArr2[i] & JfifUtil.MARKER_FIRST_BYTE;
            if (j <= 72057594037927808L) {
                j += (long) (i2 & 127);
                if ((i2 & 128) == 0) {
                    if (obj != null) {
                        if (j < 40) {
                            stringBuffer.append('0');
                        } else if (j < 80) {
                            stringBuffer.append('1');
                            j -= 40;
                        } else {
                            stringBuffer.append('2');
                            j -= 80;
                        }
                        obj = null;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j);
                    j = 0;
                } else {
                    j <<= 7;
                }
            } else {
                if (bigInteger == null) {
                    bigInteger = BigInteger.valueOf(j);
                }
                Object or = bigInteger.or(BigInteger.valueOf((long) (i2 & 127)));
                if ((i2 & 128) == 0) {
                    if (obj != null) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80));
                        obj = null;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        aSN1ObjectIdentifier.f32485a = stringBuffer.toString();
        aSN1ObjectIdentifier.f32486b = Arrays.m29373b(bArr);
    }

    public ASN1ObjectIdentifier(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'identifier' cannot be null");
        } else if (m42980c(str)) {
            this.f32485a = str;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("string ");
            stringBuilder.append(str);
            stringBuilder.append(" not an OID");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (m42979a(str, 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aSN1ObjectIdentifier.m42986b());
            stringBuilder.append(".");
            stringBuilder.append(str);
            this.f32485a = stringBuilder.toString();
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("string ");
        stringBuilder.append(str);
        stringBuilder.append(" not a valid OID branch");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: b */
    public String m42986b() {
        return this.f32485a;
    }

    /* renamed from: b */
    public ASN1ObjectIdentifier m42987b(String str) {
        return new ASN1ObjectIdentifier(this, str);
    }

    /* renamed from: a */
    public boolean m42984a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String b = m42986b();
        aSN1ObjectIdentifier = aSN1ObjectIdentifier.m42986b();
        return (b.length() <= aSN1ObjectIdentifier.length() || b.charAt(aSN1ObjectIdentifier.length()) != '.' || b.startsWith(aSN1ObjectIdentifier) == null) ? null : true;
    }

    /* renamed from: a */
    private void m42977a(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    /* renamed from: a */
    private void m42978a(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        bitLength--;
        BigInteger bigInteger2 = bigInteger;
        for (bigInteger = bitLength; bigInteger >= null; bigInteger--) {
            bArr[bigInteger] = (byte) ((bigInteger2.intValue() & 127) | 128);
            bigInteger2 = bigInteger2.shiftRight(7);
        }
        bArr[bitLength] = (byte) (bArr[bitLength] & 127);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private void m42976a(ByteArrayOutputStream byteArrayOutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.f32485a);
        int parseInt = Integer.parseInt(oIDTokenizer.m27167b()) * 40;
        String b = oIDTokenizer.m27167b();
        if (b.length() <= 18) {
            m42977a(byteArrayOutputStream, ((long) parseInt) + Long.parseLong(b));
        } else {
            m42978a(byteArrayOutputStream, new BigInteger(b).add(BigInteger.valueOf((long) parseInt)));
        }
        while (oIDTokenizer.m27166a()) {
            String b2 = oIDTokenizer.m27167b();
            if (b2.length() <= 18) {
                m42977a(byteArrayOutputStream, Long.parseLong(b2));
            } else {
                m42978a(byteArrayOutputStream, new BigInteger(b2));
            }
        }
    }

    /* renamed from: g */
    private synchronized byte[] m42981g() {
        if (this.f32486b == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m42976a(byteArrayOutputStream);
            this.f32486b = byteArrayOutputStream.toByteArray();
        }
        return this.f32486b;
    }

    /* renamed from: d */
    int mo6790d() {
        int length = m42981g().length;
        return (StreamUtil.m27168a(length) + 1) + length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        byte[] g = m42981g();
        aSN1OutputStream.mo5710b(6);
        aSN1OutputStream.m27143a(g.length);
        aSN1OutputStream.m27149a(g);
    }

    public int hashCode() {
        return this.f32485a.hashCode();
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            return this.f32485a.equals(((ASN1ObjectIdentifier) aSN1Primitive).f32485a);
        }
        return null;
    }

    public String toString() {
        return m42986b();
    }

    /* renamed from: a */
    private static boolean m42979a(String str, int i) {
        int length = str.length();
        boolean z;
        do {
            z = false;
            while (true) {
                length--;
                if (length < i) {
                    return z;
                }
                char charAt = str.charAt(length);
                if ('0' <= charAt && charAt <= '9') {
                    z = true;
                }
            }
            if (charAt != '.') {
                return false;
            }
        } while (z);
        return false;
    }

    /* renamed from: c */
    private static boolean m42980c(String str) {
        if (str.length() >= 3) {
            if (str.charAt(1) == '.') {
                char charAt = str.charAt(0);
                if (charAt >= '0') {
                    if (charAt <= '2') {
                        return m42979a(str, 2);
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: c */
    public ASN1ObjectIdentifier m42988c() {
        synchronized (f32484c) {
            OidHandle oidHandle = new OidHandle(m42981g());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) f32484c.get(oidHandle);
            if (aSN1ObjectIdentifier != null) {
                return aSN1ObjectIdentifier;
            }
            f32484c.put(oidHandle, this);
            return this;
        }
    }

    /* renamed from: a */
    static ASN1ObjectIdentifier m42975a(byte[] bArr) {
        OidHandle oidHandle = new OidHandle(bArr);
        synchronized (f32484c) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) f32484c.get(oidHandle);
            if (aSN1ObjectIdentifier != null) {
                return aSN1ObjectIdentifier;
            }
            return new ASN1ObjectIdentifier(bArr);
        }
    }
}
