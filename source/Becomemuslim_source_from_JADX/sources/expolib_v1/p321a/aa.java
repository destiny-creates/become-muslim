package expolib_v1.p321a;

import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C7496d;
import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;

/* compiled from: RequestBody */
/* renamed from: expolib_v1.a.aa */
public abstract class aa {
    public long contentLength() {
        return -1;
    }

    public abstract C6240u contentType();

    public abstract void writeTo(C7496d c7496d);

    public static aa create(C6240u c6240u, String str) {
        Charset charset = C6165c.f19911e;
        if (c6240u != null) {
            charset = c6240u.m25784b();
            if (charset == null) {
                charset = C6165c.f19911e;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c6240u);
                stringBuilder.append("; charset=utf-8");
                c6240u = C6240u.m25781a(stringBuilder.toString());
            }
        }
        return aa.create(c6240u, str.getBytes(charset));
    }

    public static aa create(final C6240u c6240u, final C6251f c6251f) {
        return new aa() {
            public C6240u contentType() {
                return c6240u;
            }

            public long contentLength() {
                return (long) c6251f.mo5366h();
            }

            public void writeTo(C7496d c7496d) {
                c7496d.mo6376c(c6251f);
            }
        };
    }

    public static aa create(C6240u c6240u, byte[] bArr) {
        return aa.create(c6240u, bArr, 0, bArr.length);
    }

    public static aa create(final C6240u c6240u, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            C6165c.m25314a((long) bArr.length, (long) i, (long) i2);
            return new aa() {
                public C6240u contentType() {
                    return c6240u;
                }

                public long contentLength() {
                    return (long) i2;
                }

                public void writeTo(C7496d c7496d) {
                    c7496d.mo6377c(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static aa create(final C6240u c6240u, final File file) {
        if (file != null) {
            return new aa() {
                public C6240u contentType() {
                    return c6240u;
                }

                public long contentLength() {
                    return file.length();
                }

                public void writeTo(C7496d c7496d) {
                    Closeable closeable = null;
                    try {
                        Closeable a = C6252l.m25864a(file);
                        try {
                            c7496d.mo6368a(a);
                            C6165c.m25315a(a);
                        } catch (Throwable th) {
                            c7496d = th;
                            closeable = a;
                            C6165c.m25315a(closeable);
                            throw c7496d;
                        }
                    } catch (Throwable th2) {
                        c7496d = th2;
                        C6165c.m25315a(closeable);
                        throw c7496d;
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
