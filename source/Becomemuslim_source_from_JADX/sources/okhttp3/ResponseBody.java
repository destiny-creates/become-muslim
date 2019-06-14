package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import p286d.C7204e;
import p286d.C8037c;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final C7204e source;

        BomAwareReader(C7204e c7204e, Charset charset) {
            this.source = c7204e;
            this.charset = charset;
        }

        public int read(char[] cArr, int i, int i2) {
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.delegate;
            if (reader == null) {
                Reader inputStreamReader = new InputStreamReader(this.source.mo6301f(), Util.bomAwareCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }

        public void close() {
            this.closed = true;
            if (this.delegate != null) {
                this.delegate.close();
            } else {
                this.source.close();
            }
        }
    }

    /* renamed from: okhttp3.ResponseBody$1 */
    class C76581 extends ResponseBody {
        final /* synthetic */ C7204e val$content;
        final /* synthetic */ long val$contentLength;
        final /* synthetic */ MediaType val$contentType;

        C76581(MediaType mediaType, long j, C7204e c7204e) {
            this.val$contentType = mediaType;
            this.val$contentLength = j;
            this.val$content = c7204e;
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() {
            return this.val$contentLength;
        }

        public C7204e source() {
            return this.val$content;
        }
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract C7204e source();

    public final InputStream byteStream() {
        return source().mo6301f();
    }

    public final byte[] bytes() {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            Closeable source = source();
            try {
                byte[] s = source.mo6319s();
                if (contentLength != -1) {
                    if (contentLength != ((long) s.length)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Content-Length (");
                        stringBuilder.append(contentLength);
                        stringBuilder.append(") and stream length (");
                        stringBuilder.append(s.length);
                        stringBuilder.append(") disagree");
                        throw new IOException(stringBuilder.toString());
                    }
                }
                return s;
            } finally {
                Util.closeQuietly(source);
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
        reader = new BomAwareReader(source(), charset());
        this.reader = reader;
        return reader;
    }

    public final String string() {
        Closeable source = source();
        try {
            String a = source.mo6287a(Util.bomAwareCharset(source, charset()));
            return a;
        } finally {
            Util.closeQuietly(source);
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public void close() {
        Util.closeQuietly(source());
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(mediaType);
                stringBuilder.append("; charset=utf-8");
                mediaType = MediaType.parse(stringBuilder.toString());
            }
        }
        str = new C8037c().m38972a(str, charset);
        return create(mediaType, str.m38961a(), str);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new C8037c().m38982b(bArr));
    }

    public static ResponseBody create(MediaType mediaType, long j, C7204e c7204e) {
        if (c7204e != null) {
            return new C76581(mediaType, j, c7204e);
        }
        throw new NullPointerException("source == null");
    }
}
