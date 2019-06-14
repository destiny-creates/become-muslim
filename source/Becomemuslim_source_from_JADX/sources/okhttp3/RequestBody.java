package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import p286d.C5869f;
import p286d.C5870l;
import p286d.C7203d;

public abstract class RequestBody {

    /* renamed from: okhttp3.RequestBody$1 */
    class C76551 extends RequestBody {
        final /* synthetic */ C5869f val$content;
        final /* synthetic */ MediaType val$contentType;

        C76551(MediaType mediaType, C5869f c5869f) {
            this.val$contentType = mediaType;
            this.val$content = c5869f;
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() {
            return (long) this.val$content.mo5110h();
        }

        public void writeTo(C7203d c7203d) {
            c7203d.mo6293b(this.val$content);
        }
    }

    /* renamed from: okhttp3.RequestBody$2 */
    class C76562 extends RequestBody {
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ byte[] val$content;
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ int val$offset;

        C76562(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.val$contentType = mediaType;
            this.val$byteCount = i;
            this.val$content = bArr;
            this.val$offset = i2;
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() {
            return (long) this.val$byteCount;
        }

        public void writeTo(C7203d c7203d) {
            c7203d.mo6297c(this.val$content, this.val$offset, this.val$byteCount);
        }
    }

    /* renamed from: okhttp3.RequestBody$3 */
    class C76573 extends RequestBody {
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ File val$file;

        C76573(MediaType mediaType, File file) {
            this.val$contentType = mediaType;
            this.val$file = file;
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() {
            return this.val$file.length();
        }

        public void writeTo(C7203d c7203d) {
            Closeable closeable = null;
            try {
                Closeable a = C5870l.m24725a(this.val$file);
                try {
                    c7203d.mo6286a(a);
                    Util.closeQuietly(a);
                } catch (Throwable th) {
                    c7203d = th;
                    closeable = a;
                    Util.closeQuietly(closeable);
                    throw c7203d;
                }
            } catch (Throwable th2) {
                c7203d = th2;
                Util.closeQuietly(closeable);
                throw c7203d;
            }
        }
    }

    public long contentLength() {
        return -1;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(C7203d c7203d);

    public static RequestBody create(MediaType mediaType, String str) {
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
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(MediaType mediaType, C5869f c5869f) {
        return new C76551(mediaType, c5869f);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new C76562(mediaType, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(MediaType mediaType, File file) {
        if (file != null) {
            return new C76573(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }
}
