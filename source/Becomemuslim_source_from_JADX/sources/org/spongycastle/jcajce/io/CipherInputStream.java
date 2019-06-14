package org.spongycastle.jcajce.io;

import com.facebook.imageutils.JfifUtil;
import java.io.FilterInputStream;
import javax.crypto.Cipher;
import org.spongycastle.crypto.io.InvalidCipherTextIOException;

public class CipherInputStream extends FilterInputStream {
    /* renamed from: a */
    private final Cipher f22700a;
    /* renamed from: b */
    private final byte[] f22701b;
    /* renamed from: c */
    private boolean f22702c;
    /* renamed from: d */
    private byte[] f22703d;
    /* renamed from: e */
    private int f22704e;
    /* renamed from: f */
    private int f22705f;

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public void reset() {
    }

    /* renamed from: a */
    private int m27956a() {
        if (this.f22702c) {
            return -1;
        }
        this.f22705f = 0;
        this.f22704e = 0;
        while (this.f22704e == 0) {
            int read = this.in.read(this.f22701b);
            if (read == -1) {
                this.f22703d = m27957b();
                if (this.f22703d != null) {
                    if (this.f22703d.length != 0) {
                        this.f22704e = this.f22703d.length;
                        return this.f22704e;
                    }
                }
                return -1;
            }
            this.f22703d = this.f22700a.update(this.f22701b, 0, read);
            if (this.f22703d != null) {
                this.f22704e = this.f22703d.length;
            }
        }
        return this.f22704e;
    }

    /* renamed from: b */
    private byte[] m27957b() {
        try {
            this.f22702c = true;
            return this.f22700a.doFinal();
        } catch (Throwable e) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e);
        }
    }

    public int read() {
        if (this.f22705f >= this.f22704e && m27956a() < 0) {
            return -1;
        }
        byte[] bArr = this.f22703d;
        int i = this.f22705f;
        this.f22705f = i + 1;
        return bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f22705f >= this.f22704e && m27956a() < 0) {
            return -1;
        }
        i2 = Math.min(i2, available());
        System.arraycopy(this.f22703d, this.f22705f, bArr, i, i2);
        this.f22705f += i2;
        return i2;
    }

    public long skip(long j) {
        if (j <= 0) {
            return 0;
        }
        j = (int) Math.min(j, (long) available());
        this.f22705f += j;
        return (long) j;
    }

    public int available() {
        return this.f22704e - this.f22705f;
    }

    public void close() {
        try {
            this.in.close();
            this.f22705f = 0;
            this.f22704e = 0;
        } finally {
            if (!this.f22702c) {
                m27957b();
            }
        }
    }
}
