package com.google.android.exoplayer2.p163k;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: ContentDataSource */
/* renamed from: com.google.android.exoplayer2.k.e */
public final class C4239e implements C2498g {
    /* renamed from: a */
    private final ContentResolver f11166a;
    /* renamed from: b */
    private final C2514v<? super C4239e> f11167b;
    /* renamed from: c */
    private Uri f11168c;
    /* renamed from: d */
    private AssetFileDescriptor f11169d;
    /* renamed from: e */
    private FileInputStream f11170e;
    /* renamed from: f */
    private long f11171f;
    /* renamed from: g */
    private boolean f11172g;

    /* compiled from: ContentDataSource */
    /* renamed from: com.google.android.exoplayer2.k.e$a */
    public static class C2496a extends IOException {
        public C2496a(IOException iOException) {
            super(iOException);
        }
    }

    public C4239e(Context context, C2514v<? super C4239e> c2514v) {
        this.f11166a = context.getContentResolver();
        this.f11167b = c2514v;
    }

    /* renamed from: a */
    public long mo2268a(C2501j c2501j) {
        try {
            this.f11168c = c2501j.f6349a;
            this.f11169d = this.f11166a.openAssetFileDescriptor(this.f11168c, "r");
            if (this.f11169d != null) {
                this.f11170e = new FileInputStream(this.f11169d.getFileDescriptor());
                long startOffset = this.f11169d.getStartOffset();
                long skip = this.f11170e.skip(c2501j.f6352d + startOffset) - startOffset;
                if (skip == c2501j.f6352d) {
                    long j = -1;
                    if (c2501j.f6353e != -1) {
                        this.f11171f = c2501j.f6353e;
                    } else {
                        startOffset = this.f11169d.getLength();
                        if (startOffset == -1) {
                            FileChannel channel = this.f11170e.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                j = size - channel.position();
                            }
                            this.f11171f = j;
                        } else {
                            this.f11171f = startOffset - skip;
                        }
                    }
                    this.f11172g = true;
                    if (this.f11167b != null) {
                        this.f11167b.mo2319a((Object) this, c2501j);
                    }
                    return this.f11171f;
                }
                throw new EOFException();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not open file descriptor for: ");
            stringBuilder.append(this.f11168c);
            throw new FileNotFoundException(stringBuilder.toString());
        } catch (C2501j c2501j2) {
            throw new C2496a(c2501j2);
        }
    }

    /* renamed from: a */
    public int mo2267a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        if (this.f11171f == 0) {
            return -1;
        }
        try {
            if (this.f11171f != -1) {
                i2 = (int) Math.min(this.f11171f, (long) i2);
            }
            int read = this.f11170e.read(bArr, i, i2);
            if (read != -1) {
                if (this.f11171f != -1) {
                    this.f11171f -= (long) read;
                }
                if (this.f11167b != 0) {
                    this.f11167b.mo2318a((Object) this, read);
                }
                return read;
            } else if (this.f11171f == -1) {
                return -1;
            } else {
                throw new C2496a(new EOFException());
            }
        } catch (byte[] bArr2) {
            throw new C2496a(bArr2);
        }
    }

    /* renamed from: a */
    public Uri mo2269a() {
        return this.f11168c;
    }

    /* renamed from: b */
    public void mo2270b() {
        this.f11168c = null;
        try {
            if (this.f11170e != null) {
                this.f11170e.close();
            }
            this.f11170e = null;
            try {
                if (this.f11169d != null) {
                    this.f11169d.close();
                }
                this.f11169d = null;
                if (this.f11172g) {
                    this.f11172g = false;
                    if (this.f11167b != null) {
                        this.f11167b.mo2317a(this);
                    }
                }
            } catch (IOException e) {
                throw new C2496a(e);
            } catch (Throwable th) {
                this.f11169d = null;
                if (this.f11172g) {
                    this.f11172g = false;
                    if (this.f11167b != null) {
                        this.f11167b.mo2317a(this);
                    }
                }
            }
        } catch (IOException e2) {
            throw new C2496a(e2);
        } catch (Throwable th2) {
            this.f11170e = null;
            try {
                if (this.f11169d != null) {
                    this.f11169d.close();
                }
                this.f11169d = null;
                if (this.f11172g) {
                    this.f11172g = false;
                    if (this.f11167b != null) {
                        this.f11167b.mo2317a(this);
                    }
                }
            } catch (IOException e22) {
                throw new C2496a(e22);
            } catch (Throwable th3) {
                this.f11169d = null;
                if (this.f11172g) {
                    this.f11172g = false;
                    if (this.f11167b != null) {
                        this.f11167b.mo2317a(this);
                    }
                }
            }
        }
    }
}
