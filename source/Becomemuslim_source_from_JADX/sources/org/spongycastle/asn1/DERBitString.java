package org.spongycastle.asn1;

import com.facebook.imageutils.JfifUtil;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;

public class DERBitString extends ASN1Primitive implements ASN1String {
    /* renamed from: c */
    private static final char[] f32497c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: a */
    protected final byte[] f32498a;
    /* renamed from: b */
    protected final int f32499b;

    /* renamed from: a */
    protected static int m43049a(int i) {
        for (int i2 = 3; i2 >= 0; i2--) {
            int i3;
            if (i2 != 0) {
                i3 = i >> (i2 * 8);
                if (i3 != 0) {
                    i = i3 & JfifUtil.MARKER_FIRST_BYTE;
                    break;
                }
            } else if (i != 0) {
                i &= JfifUtil.MARKER_FIRST_BYTE;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            return 7;
        }
        i3 = 1;
        while (true) {
            i <<= 1;
            if ((i & JfifUtil.MARKER_FIRST_BYTE) == 0) {
                return 8 - i3;
            }
            i3++;
        }
    }

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    /* renamed from: b */
    protected static byte[] m43054b(int i) {
        int i2 = 4;
        for (int i3 = 3; i3 >= 1; i3--) {
            if (((JfifUtil.MARKER_FIRST_BYTE << (i3 * 8)) & i) != 0) {
                break;
            }
            i2--;
        }
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((i >> (i4 * 8)) & JfifUtil.MARKER_FIRST_BYTE);
        }
        return bArr;
    }

    /* renamed from: a */
    public static DERBitString m43051a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof DERBitString)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("illegal object in getInstance: ");
                stringBuilder.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (DERBitString) obj;
    }

    /* renamed from: a */
    public static DERBitString m43052a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        Object k = aSN1TaggedObject.m43036k();
        if (!z) {
            if (!(k instanceof DERBitString)) {
                return m43053a(((ASN1OctetString) k).mo6859c());
            }
        }
        return m43051a(k);
    }

    public DERBitString(byte[] bArr, int i) {
        this.f32498a = bArr;
        this.f32499b = i;
    }

    public DERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DERBitString(int i) {
        this.f32498a = m43054b(i);
        this.f32499b = m43049a(i);
    }

    public DERBitString(ASN1Encodable aSN1Encodable) {
        this.f32498a = aSN1Encodable.mo5709e().m34596a("DER");
        this.f32499b = null;
    }

    /* renamed from: c */
    public byte[] m43059c() {
        return this.f32498a;
    }

    /* renamed from: g */
    public int m43061g() {
        return this.f32499b;
    }

    /* renamed from: j */
    public int m43062j() {
        int i = 0;
        int i2 = 0;
        while (i != this.f32498a.length && i != 4) {
            i2 |= (this.f32498a[i] & JfifUtil.MARKER_FIRST_BYTE) << (i * 8);
            i++;
        }
        return i2;
    }

    /* renamed from: d */
    int mo6790d() {
        return ((StreamUtil.m27168a(this.f32498a.length + 1) + 1) + this.f32498a.length) + 1;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        byte[] bArr = new byte[(m43059c().length + 1)];
        bArr[0] = (byte) m43061g();
        System.arraycopy(m43059c(), 0, bArr, 1, bArr.length - 1);
        aSN1OutputStream.m27146a(3, bArr);
    }

    public int hashCode() {
        return this.f32499b ^ Arrays.m29342a(this.f32498a);
    }

    /* renamed from: a */
    protected boolean mo6789a(ASN1Primitive aSN1Primitive) {
        boolean z = false;
        if (!(aSN1Primitive instanceof DERBitString)) {
            return false;
        }
        DERBitString dERBitString = (DERBitString) aSN1Primitive;
        if (this.f32499b == dERBitString.f32499b && Arrays.m29353a(this.f32498a, dERBitString.f32498a) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public String mo6440b() {
        StringBuffer stringBuffer = new StringBuffer("#");
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ASN1OutputStream(byteArrayOutputStream).mo5713a((ASN1Encodable) this);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != toByteArray.length; i++) {
                stringBuffer.append(f32497c[(toByteArray[i] >>> 4) & 15]);
                stringBuffer.append(f32497c[toByteArray[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Internal error encoding BitString: ");
            stringBuilder.append(e.getMessage());
            throw new ASN1ParsingException(stringBuilder.toString(), e);
        }
    }

    public String toString() {
        return mo6440b();
    }

    /* renamed from: a */
    static DERBitString m43053a(byte[] bArr) {
        if (bArr.length >= 1) {
            byte b = bArr[0];
            Object obj = new byte[(bArr.length - 1)];
            if (obj.length != 0) {
                System.arraycopy(bArr, 1, obj, 0, bArr.length - 1);
            }
            return new DERBitString(obj, b);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    /* renamed from: a */
    static DERBitString m43050a(int i, InputStream inputStream) {
        if (i >= 1) {
            int read = inputStream.read();
            byte[] bArr = new byte[(i - 1)];
            if (bArr.length != 0) {
                if (Streams.m29439a(inputStream, bArr) != bArr.length) {
                    throw new EOFException("EOF encountered in middle of BIT STRING");
                }
            }
            return new DERBitString(bArr, read);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }
}
