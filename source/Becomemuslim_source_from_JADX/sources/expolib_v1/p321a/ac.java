package expolib_v1.p321a;

import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* compiled from: ResponseBody */
/* renamed from: expolib_v1.a.ac */
public abstract class ac implements Closeable {
    private Reader reader;

    /* compiled from: ResponseBody */
    /* renamed from: expolib_v1.a.ac$a */
    static final class C6209a extends Reader {
        /* renamed from: a */
        private final C7497e f20122a;
        /* renamed from: b */
        private final Charset f20123b;
        /* renamed from: c */
        private boolean f20124c;
        /* renamed from: d */
        private Reader f20125d;

        C6209a(C7497e c7497e, Charset charset) {
            this.f20122a = c7497e;
            this.f20123b = charset;
        }

        public int read(char[] cArr, int i, int i2) {
            if (this.f20124c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f20125d;
            if (reader == null) {
                Reader inputStreamReader = new InputStreamReader(this.f20122a.mo6384g(), C6165c.m25309a(this.f20122a, this.f20123b));
                this.f20125d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }

        public void close() {
            this.f20124c = true;
            if (this.f20125d != null) {
                this.f20125d.close();
            } else {
                this.f20122a.close();
            }
        }
    }

    public abstract long contentLength();

    public abstract C6240u contentType();

    public abstract C7497e source();

    public final InputStream byteStream() {
        return source().mo6384g();
    }

    public final byte[] bytes() {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            Closeable source = source();
            try {
                byte[] t = source.mo6402t();
                if (contentLength != -1) {
                    if (contentLength != ((long) t.length)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Content-Length (");
                        stringBuilder.append(contentLength);
                        stringBuilder.append(") and stream length (");
                        stringBuilder.append(t.length);
                        stringBuilder.append(") disagree");
                        throw new IOException(stringBuilder.toString());
                    }
                }
                return t;
            } finally {
                C6165c.m25315a(source);
            }
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Cannot buffer entire body for content length: ");
            stringBuilder2.append(contentLength);
            throw new IOException(stringBuilder2.toString());
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        reader = new C6209a(source(), charset());
        this.reader = reader;
        return reader;
    }

    public final String string() {
        Closeable source = source();
        try {
            String a = source.mo6369a(C6165c.m25309a((C7497e) source, charset()));
            return a;
        } finally {
            C6165c.m25315a(source);
        }
    }

    private Charset charset() {
        C6240u contentType = contentType();
        return contentType != null ? contentType.m25783a(C6165c.f19911e) : C6165c.f19911e;
    }

    public void close() {
        C6165c.m25315a(source());
    }

    public static ac create(C6240u c6240u, String str) {
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
        str = new C8170c().m39594a(str, charset);
        return ac.create(c6240u, str.m39582a(), str);
    }

    public static ac create(C6240u c6240u, byte[] bArr) {
        return ac.create(c6240u, (long) bArr.length, new C8170c().m39610c(bArr));
    }

    public static ac create(final C6240u c6240u, final long j, final C7497e c7497e) {
        if (c7497e != null) {
            return new ac() {
                public C6240u contentType() {
                    return c6240u;
                }

                public long contentLength() {
                    return j;
                }

                public C7497e source() {
                    return c7497e;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
