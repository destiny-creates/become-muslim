package com.google.android.exoplayer2.p163k;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: AssetDataSource */
/* renamed from: com.google.android.exoplayer2.k.c */
public final class C4238c implements C2498g {
    /* renamed from: a */
    private final AssetManager f11160a;
    /* renamed from: b */
    private final C2514v<? super C4238c> f11161b;
    /* renamed from: c */
    private Uri f11162c;
    /* renamed from: d */
    private InputStream f11163d;
    /* renamed from: e */
    private long f11164e;
    /* renamed from: f */
    private boolean f11165f;

    /* compiled from: AssetDataSource */
    /* renamed from: com.google.android.exoplayer2.k.c$a */
    public static final class C2493a extends IOException {
        public C2493a(IOException iOException) {
            super(iOException);
        }
    }

    public C4238c(Context context, C2514v<? super C4238c> c2514v) {
        this.f11160a = context.getAssets();
        this.f11161b = c2514v;
    }

    /* renamed from: a */
    public long mo2268a(C2501j c2501j) {
        try {
            this.f11162c = c2501j.f6349a;
            String path = this.f11162c.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.f11163d = this.f11160a.open(path, 1);
            if (this.f11163d.skip(c2501j.f6352d) >= c2501j.f6352d) {
                if (c2501j.f6353e != -1) {
                    this.f11164e = c2501j.f6353e;
                } else {
                    this.f11164e = (long) this.f11163d.available();
                    if (this.f11164e == 2147483647L) {
                        this.f11164e = -1;
                    }
                }
                this.f11165f = true;
                if (this.f11161b != null) {
                    this.f11161b.mo2319a((Object) this, c2501j);
                }
                return this.f11164e;
            }
            throw new EOFException();
        } catch (C2501j c2501j2) {
            throw new C2493a(c2501j2);
        }
    }

    /* renamed from: a */
    public int mo2267a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        if (this.f11164e == 0) {
            return -1;
        }
        try {
            if (this.f11164e != -1) {
                i2 = (int) Math.min(this.f11164e, (long) i2);
            }
            int read = this.f11163d.read(bArr, i, i2);
            if (read != -1) {
                if (this.f11164e != -1) {
                    this.f11164e -= (long) read;
                }
                if (this.f11161b != 0) {
                    this.f11161b.mo2318a((Object) this, read);
                }
                return read;
            } else if (this.f11164e == -1) {
                return -1;
            } else {
                throw new C2493a(new EOFException());
            }
        } catch (byte[] bArr2) {
            throw new C2493a(bArr2);
        }
    }

    /* renamed from: a */
    public Uri mo2269a() {
        return this.f11162c;
    }

    /* renamed from: b */
    public void mo2270b() {
        this.f11162c = null;
        try {
            if (this.f11163d != null) {
                this.f11163d.close();
            }
            this.f11163d = null;
            if (this.f11165f) {
                this.f11165f = false;
                if (this.f11161b != null) {
                    this.f11161b.mo2317a(this);
                }
            }
        } catch (IOException e) {
            throw new C2493a(e);
        } catch (Throwable th) {
            this.f11163d = null;
            if (this.f11165f) {
                this.f11165f = false;
                if (this.f11161b != null) {
                    this.f11161b.mo2317a(this);
                }
            }
        }
    }
}
