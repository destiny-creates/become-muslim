package org.spongycastle.asn1;

import java.io.OutputStream;

public class BEROctetStringGenerator extends BERGenerator {

    private class BufferedBEROctetStream extends OutputStream {
        /* renamed from: a */
        final /* synthetic */ BEROctetStringGenerator f21448a;
        /* renamed from: b */
        private byte[] f21449b;
        /* renamed from: c */
        private int f21450c;
        /* renamed from: d */
        private DEROutputStream f21451d;

        public void write(int i) {
            byte[] bArr = this.f21449b;
            int i2 = this.f21450c;
            this.f21450c = i2 + 1;
            bArr[i2] = (byte) i;
            if (this.f21450c == this.f21449b.length) {
                DEROctetString.m44380a(this.f21451d, this.f21449b);
                this.f21450c = 0;
            }
        }

        public void write(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                int min = Math.min(i2, this.f21449b.length - this.f21450c);
                System.arraycopy(bArr, i, this.f21449b, this.f21450c, min);
                this.f21450c += min;
                if (this.f21450c >= this.f21449b.length) {
                    DEROctetString.m44380a(this.f21451d, this.f21449b);
                    this.f21450c = 0;
                    i += min;
                    i2 -= min;
                } else {
                    return;
                }
            }
        }

        public void close() {
            if (this.f21450c != 0) {
                Object obj = new byte[this.f21450c];
                System.arraycopy(this.f21449b, 0, obj, 0, this.f21450c);
                DEROctetString.m44380a(this.f21451d, obj);
            }
            this.f21448a.m34601a();
        }
    }
}
