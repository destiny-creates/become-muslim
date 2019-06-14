package org.spongycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.modes.AEADBlockCipher;

public class CipherOutputStream extends FilterOutputStream {
    /* renamed from: a */
    private BufferedBlockCipher f22394a;
    /* renamed from: b */
    private StreamCipher f22395b;
    /* renamed from: c */
    private AEADBlockCipher f22396c;
    /* renamed from: d */
    private final byte[] f22397d;
    /* renamed from: e */
    private byte[] f22398e;

    public void write(int i) {
        i = (byte) i;
        this.f22397d[0] = i;
        if (this.f22395b != null) {
            this.out.write(this.f22395b.mo5721a(i));
        } else {
            write(this.f22397d, 0, 1);
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        m27458a(i2, false);
        if (this.f22394a != null) {
            bArr = this.f22394a.mo5777a(bArr, i, i2, this.f22398e, 0);
            if (bArr != null) {
                this.out.write(this.f22398e, 0, bArr);
            }
        } else if (this.f22396c != null) {
            bArr = this.f22396c.mo5770a(bArr, i, i2, this.f22398e, 0);
            if (bArr != null) {
                this.out.write(this.f22398e, 0, bArr);
            }
        } else {
            this.f22395b.mo5722a(bArr, i, i2, this.f22398e, 0);
            this.out.write(this.f22398e, 0, i2);
        }
    }

    /* renamed from: a */
    private void m27458a(int i, boolean z) {
        boolean b;
        if (z) {
            if (this.f22394a) {
                b = this.f22394a.mo5778b(i);
            } else if (this.f22396c) {
                b = this.f22396c.mo5774b(i);
            }
        } else if (this.f22394a) {
            b = this.f22394a.mo5775a(i);
        } else if (this.f22396c) {
            b = this.f22396c.mo5768a(i);
        }
        if (!this.f22398e || this.f22398e.length < b) {
            this.f22398e = new byte[b];
        }
    }

    public void flush() {
        this.out.flush();
    }

    public void close() {
        IOException iOException;
        IOException e;
        m27458a(0, true);
        try {
            int a;
            if (this.f22394a != null) {
                a = this.f22394a.mo5776a(this.f22398e, 0);
                if (a != 0) {
                    this.out.write(this.f22398e, 0, a);
                }
            } else if (this.f22396c != null) {
                a = this.f22396c.mo5769a(this.f22398e, 0);
                if (a != 0) {
                    this.out.write(this.f22398e, 0, a);
                }
            } else if (this.f22395b != null) {
                this.f22395b.mo5751c();
            }
            iOException = null;
        } catch (Throwable e2) {
            iOException = new InvalidCipherTextIOException("Error finalising cipher data", e2);
        } catch (Throwable e22) {
            iOException = new CipherIOException("Error closing stream: ", e22);
        }
        try {
            flush();
            this.out.close();
        } catch (IOException e3) {
            e = e3;
            if (iOException == null) {
            }
        }
        e = iOException;
        if (e != null) {
            throw e;
        }
    }
}
