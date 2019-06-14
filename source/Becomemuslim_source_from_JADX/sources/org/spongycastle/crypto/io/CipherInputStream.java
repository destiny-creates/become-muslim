package org.spongycastle.crypto.io;

import com.facebook.imageutils.JfifUtil;
import java.io.FilterInputStream;
import java.io.IOException;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.SkippingCipher;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.util.Arrays;

public class CipherInputStream extends FilterInputStream {
    /* renamed from: a */
    private SkippingCipher f22382a;
    /* renamed from: b */
    private byte[] f22383b;
    /* renamed from: c */
    private BufferedBlockCipher f22384c;
    /* renamed from: d */
    private StreamCipher f22385d;
    /* renamed from: e */
    private AEADBlockCipher f22386e;
    /* renamed from: f */
    private byte[] f22387f;
    /* renamed from: g */
    private byte[] f22388g;
    /* renamed from: h */
    private int f22389h;
    /* renamed from: i */
    private int f22390i;
    /* renamed from: j */
    private boolean f22391j;
    /* renamed from: k */
    private long f22392k;
    /* renamed from: l */
    private int f22393l;

    /* renamed from: a */
    private int m27455a() {
        if (this.f22391j) {
            return -1;
        }
        this.f22389h = 0;
        this.f22390i = 0;
        while (this.f22390i == 0) {
            int read = this.in.read(this.f22383b);
            if (read == -1) {
                m27457b();
                if (this.f22390i == 0) {
                    return -1;
                }
                return this.f22390i;
            }
            try {
                m27456a(read, false);
                if (this.f22384c != null) {
                    this.f22390i = this.f22384c.mo5777a(this.f22383b, 0, read, this.f22387f, 0);
                } else if (this.f22386e != null) {
                    this.f22390i = this.f22386e.mo5770a(this.f22383b, 0, read, this.f22387f, 0);
                } else {
                    this.f22385d.mo5722a(this.f22383b, 0, read, this.f22387f, 0);
                    this.f22390i = read;
                }
            } catch (Throwable e) {
                throw new CipherIOException("Error processing stream ", e);
            }
        }
        return this.f22390i;
    }

    /* renamed from: b */
    private void m27457b() {
        try {
            this.f22391j = true;
            m27456a(0, true);
            if (this.f22384c != null) {
                this.f22390i = this.f22384c.mo5776a(this.f22387f, 0);
            } else if (this.f22386e != null) {
                this.f22390i = this.f22386e.mo5769a(this.f22387f, 0);
            } else {
                this.f22390i = 0;
            }
        } catch (Throwable e) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e);
        } catch (Exception e2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error finalising cipher ");
            stringBuilder.append(e2);
            throw new IOException(stringBuilder.toString());
        }
    }

    public int read() {
        if (this.f22389h >= this.f22390i && m27455a() < 0) {
            return -1;
        }
        byte[] bArr = this.f22387f;
        int i = this.f22389h;
        this.f22389h = i + 1;
        return bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f22389h >= this.f22390i && m27455a() < 0) {
            return -1;
        }
        i2 = Math.min(i2, available());
        System.arraycopy(this.f22387f, this.f22389h, bArr, i, i2);
        this.f22389h += i2;
        return i2;
    }

    public long skip(long j) {
        if (j <= 0) {
            return 0;
        }
        if (this.f22382a != null) {
            long available = (long) available();
            if (j <= available) {
                this.f22389h = (int) (((long) this.f22389h) + j);
                return j;
            }
            this.f22389h = this.f22390i;
            j = this.in.skip(j - available);
            if (j == this.f22382a.mo6449a(j)) {
                return j + available;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to skip cipher ");
            stringBuilder.append(j);
            stringBuilder.append(" bytes.");
            throw new IOException(stringBuilder.toString());
        }
        j = (int) Math.min(j, (long) available());
        this.f22389h += j;
        return (long) j;
    }

    public int available() {
        return this.f22390i - this.f22389h;
    }

    /* renamed from: a */
    private void m27456a(int i, boolean z) {
        boolean b;
        if (z) {
            if (this.f22384c) {
                b = this.f22384c.mo5778b(i);
            } else if (this.f22386e) {
                b = this.f22386e.mo5774b(i);
            }
        } else if (this.f22384c) {
            b = this.f22384c.mo5775a(i);
        } else if (this.f22386e) {
            b = this.f22386e.mo5768a(i);
        }
        if (!this.f22387f || this.f22387f.length < b) {
            this.f22387f = new byte[b];
        }
    }

    public void close() {
        try {
            this.in.close();
            this.f22389h = 0;
            this.f22390i = 0;
            this.f22393l = 0;
            this.f22392k = 0;
            if (this.f22388g != null) {
                Arrays.m29351a(this.f22388g, (byte) 0);
                this.f22388g = null;
            }
            if (this.f22387f != null) {
                Arrays.m29351a(this.f22387f, (byte) 0);
                this.f22387f = null;
            }
            Arrays.m29351a(this.f22383b, (byte) 0);
        } finally {
            if (!this.f22391j) {
                m27457b();
            }
        }
    }

    public void mark(int i) {
        this.in.mark(i);
        if (this.f22382a != 0) {
            this.f22392k = this.f22382a.mo6451d();
        }
        if (this.f22387f != 0) {
            this.f22388g = new byte[this.f22387f.length];
            System.arraycopy(this.f22387f, 0, this.f22388g, 0, this.f22387f.length);
        }
        this.f22393l = this.f22389h;
    }

    public void reset() {
        if (this.f22382a != null) {
            this.in.reset();
            this.f22382a.mo6450b(this.f22392k);
            if (this.f22388g != null) {
                this.f22387f = this.f22388g;
            }
            this.f22389h = this.f22393l;
            return;
        }
        throw new IOException("cipher must implement SkippingCipher to be used with reset()");
    }

    public boolean markSupported() {
        return this.f22382a != null ? this.in.markSupported() : false;
    }
}
