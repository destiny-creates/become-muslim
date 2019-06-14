package org.spongycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import org.spongycastle.crypto.io.InvalidCipherTextIOException;

public class CipherOutputStream extends FilterOutputStream {
    /* renamed from: a */
    private final Cipher f22706a;
    /* renamed from: b */
    private final byte[] f22707b;

    public void write(int i) {
        this.f22707b[0] = (byte) i;
        write(this.f22707b, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) {
        bArr = this.f22706a.update(bArr, i, i2);
        if (bArr != null) {
            this.out.write(bArr);
        }
    }

    public void flush() {
        this.out.flush();
    }

    public void close() {
        IOException iOException;
        IOException e;
        try {
            byte[] doFinal = this.f22706a.doFinal();
            if (doFinal != null) {
                this.out.write(doFinal);
            }
            iOException = null;
        } catch (Throwable e2) {
            iOException = new InvalidCipherTextIOException("Error during cipher finalisation", e2);
        } catch (Exception e3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error closing stream: ");
            stringBuilder.append(e3);
            iOException = new IOException(stringBuilder.toString());
        }
        try {
            flush();
            this.out.close();
        } catch (IOException e4) {
            e = e4;
            if (iOException == null) {
            }
        }
        e = iOException;
        if (e != null) {
            throw e;
        }
    }
}
