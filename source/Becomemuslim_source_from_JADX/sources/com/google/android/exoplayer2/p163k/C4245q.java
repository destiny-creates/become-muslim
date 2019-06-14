package com.google.android.exoplayer2.p163k;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: FileDataSource */
/* renamed from: com.google.android.exoplayer2.k.q */
public final class C4245q implements C2498g {
    /* renamed from: a */
    private final C2514v<? super C4245q> f11206a;
    /* renamed from: b */
    private RandomAccessFile f11207b;
    /* renamed from: c */
    private Uri f11208c;
    /* renamed from: d */
    private long f11209d;
    /* renamed from: e */
    private boolean f11210e;

    /* compiled from: FileDataSource */
    /* renamed from: com.google.android.exoplayer2.k.q$a */
    public static class C2503a extends IOException {
        public C2503a(IOException iOException) {
            super(iOException);
        }
    }

    public C4245q() {
        this(null);
    }

    public C4245q(C2514v<? super C4245q> c2514v) {
        this.f11206a = c2514v;
    }

    /* renamed from: a */
    public long mo2268a(C2501j c2501j) {
        try {
            this.f11208c = c2501j.f6349a;
            this.f11207b = new RandomAccessFile(c2501j.f6349a.getPath(), "r");
            this.f11207b.seek(c2501j.f6352d);
            this.f11209d = c2501j.f6353e == -1 ? this.f11207b.length() - c2501j.f6352d : c2501j.f6353e;
            if (this.f11209d >= 0) {
                this.f11210e = true;
                if (this.f11206a != null) {
                    this.f11206a.mo2319a((Object) this, c2501j);
                }
                return this.f11209d;
            }
            throw new EOFException();
        } catch (C2501j c2501j2) {
            throw new C2503a(c2501j2);
        }
    }

    /* renamed from: a */
    public int mo2267a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        if (this.f11209d == 0) {
            return -1;
        }
        try {
            int read = this.f11207b.read(bArr, i, (int) Math.min(this.f11209d, (long) i2));
            if (read > null) {
                this.f11209d -= (long) read;
                if (this.f11206a != 0) {
                    this.f11206a.mo2318a((Object) this, read);
                }
            }
            return read;
        } catch (byte[] bArr2) {
            throw new C2503a(bArr2);
        }
    }

    /* renamed from: a */
    public Uri mo2269a() {
        return this.f11208c;
    }

    /* renamed from: b */
    public void mo2270b() {
        this.f11208c = null;
        try {
            if (this.f11207b != null) {
                this.f11207b.close();
            }
            this.f11207b = null;
            if (this.f11210e) {
                this.f11210e = false;
                if (this.f11206a != null) {
                    this.f11206a.mo2317a(this);
                }
            }
        } catch (IOException e) {
            throw new C2503a(e);
        } catch (Throwable th) {
            this.f11207b = null;
            if (this.f11210e) {
                this.f11210e = false;
                if (this.f11206a != null) {
                    this.f11206a.mo2317a(this);
                }
            }
        }
    }
}
