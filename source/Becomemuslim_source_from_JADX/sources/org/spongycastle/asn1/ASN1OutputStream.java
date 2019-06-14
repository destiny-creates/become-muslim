package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class ASN1OutputStream {
    /* renamed from: a */
    private OutputStream f21439a;

    private class ImplicitOutputStream extends ASN1OutputStream {
        /* renamed from: a */
        final /* synthetic */ ASN1OutputStream f26448a;
        /* renamed from: b */
        private boolean f26449b = true;

        public ImplicitOutputStream(ASN1OutputStream aSN1OutputStream, OutputStream outputStream) {
            this.f26448a = aSN1OutputStream;
            super(outputStream);
        }

        /* renamed from: b */
        public void mo5710b(int i) {
            if (this.f26449b) {
                this.f26449b = false;
            } else {
                super.mo5710b(i);
            }
        }
    }

    public ASN1OutputStream(OutputStream outputStream) {
        this.f21439a = outputStream;
    }

    /* renamed from: a */
    void m27143a(int i) {
        if (i > 127) {
            int i2 = i;
            int i3 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i3++;
            }
            mo5710b((byte) (i3 | 128));
            for (i3 = (i3 - 1) * 8; i3 >= 0; i3 -= 8) {
                mo5710b((byte) (i >> i3));
            }
            return;
        }
        mo5710b((byte) i);
    }

    /* renamed from: b */
    void mo5710b(int i) {
        this.f21439a.write(i);
    }

    /* renamed from: a */
    void m27149a(byte[] bArr) {
        this.f21439a.write(bArr);
    }

    /* renamed from: a */
    void m27150a(byte[] bArr, int i, int i2) {
        this.f21439a.write(bArr, i, i2);
    }

    /* renamed from: a */
    void m27146a(int i, byte[] bArr) {
        mo5710b(i);
        m27143a(bArr.length);
        m27149a(bArr);
    }

    /* renamed from: a */
    void m27144a(int i, int i2) {
        if (i2 < 31) {
            mo5710b(i | i2);
            return;
        }
        mo5710b(i | 31);
        if (i2 < 128) {
            mo5710b(i2);
            return;
        }
        byte[] bArr = new byte[5];
        int length = bArr.length - 1;
        bArr[length] = (byte) (i2 & 127);
        do {
            i2 >>= 7;
            length--;
            bArr[length] = (byte) ((i2 & 127) | 128);
        } while (i2 > 127);
        m27150a(bArr, length, bArr.length - length);
    }

    /* renamed from: a */
    void m27145a(int i, int i2, byte[] bArr) {
        m27144a(i, i2);
        m27143a(bArr.length);
        m27149a(bArr);
    }

    /* renamed from: a */
    public void mo5713a(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1Encodable.mo5709e().mo6787a(this);
            return;
        }
        throw new IOException("null object detected");
    }

    /* renamed from: a */
    void m27148a(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive != null) {
            aSN1Primitive.mo6787a(new ImplicitOutputStream(this, this.f21439a));
            return;
        }
        throw new IOException("null object detected");
    }

    /* renamed from: a */
    ASN1OutputStream mo5712a() {
        return new DEROutputStream(this.f21439a);
    }

    /* renamed from: b */
    ASN1OutputStream mo5714b() {
        return new DLOutputStream(this.f21439a);
    }
}
