package org.spongycastle.asn1;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import org.spongycastle.util.Arrays;

public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    /* renamed from: a */
    protected final boolean f32472a;
    /* renamed from: b */
    protected final int f32473b;
    /* renamed from: c */
    protected final byte[] f32474c;

    ASN1ApplicationSpecific(boolean z, int i, byte[] bArr) {
        this.f32472a = z;
        this.f32473b = i;
        this.f32474c = bArr;
    }

    /* renamed from: a */
    protected static int m42928a(byte[] bArr) {
        bArr = bArr[1] & JfifUtil.MARKER_FIRST_BYTE;
        if (bArr == 128 || bArr <= 127) {
            return 2;
        }
        bArr &= 127;
        if (bArr <= 4) {
            return bArr + 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DER length more than 4 bytes: ");
        stringBuilder.append(bArr);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean mo6788a() {
        return this.f32472a;
    }

    /* renamed from: b */
    public byte[] m42934b() {
        return this.f32474c;
    }

    /* renamed from: c */
    public int m42935c() {
        return this.f32473b;
    }

    /* renamed from: a */
    public ASN1Primitive m42930a(int i) {
        if (i < 31) {
            byte[] f = mo6822f();
            byte[] a = m42929a(i, f);
            if ((f[0] & 32) != 0) {
                a[0] = (byte) (a[0] | 32);
            }
            return new ASN1InputStream(a).m34595d();
        }
        throw new IOException("unsupported tag number");
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27170b(this.f32473b) + StreamUtil.m27168a(this.f32474c.length)) + this.f32474c.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27145a(this.f32472a ? 96 : 64, this.f32473b, this.f32474c);
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        boolean z = false;
        if (!(aSN1Primitive instanceof ASN1ApplicationSpecific)) {
            return false;
        }
        ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific) aSN1Primitive;
        if (this.f32472a == aSN1ApplicationSpecific.f32472a && this.f32473b == aSN1ApplicationSpecific.f32473b && Arrays.m29353a(this.f32474c, aSN1ApplicationSpecific.f32474c) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f32472a ^ this.f32473b) ^ Arrays.m29342a(this.f32474c);
    }

    /* renamed from: a */
    private byte[] m42929a(int i, byte[] bArr) {
        int i2;
        if ((bArr[0] & 31) == 31) {
            i2 = 2;
            int i3 = bArr[1] & JfifUtil.MARKER_FIRST_BYTE;
            if ((i3 & 127) != 0) {
                while (i3 >= 0 && (i3 & 128) != 0) {
                    int i4 = i2 + 1;
                    i3 = bArr[i2] & JfifUtil.MARKER_FIRST_BYTE;
                    i2 = i4;
                }
            } else {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
        }
        i2 = 1;
        Object obj = new byte[((bArr.length - i2) + 1)];
        System.arraycopy(bArr, i2, obj, 1, obj.length - 1);
        obj[0] = (byte) i;
        return obj;
    }
}
