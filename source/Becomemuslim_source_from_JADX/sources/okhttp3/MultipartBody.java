package okhttp3;

import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.server.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import p286d.C5869f;
import p286d.C7203d;
import p286d.C8037c;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    private static final byte[] COLONSPACE = new byte[]{(byte) 58, (byte) 32};
    private static final byte[] CRLF = new byte[]{(byte) 13, (byte) 10};
    private static final byte[] DASHDASH = new byte[]{Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final C5869f boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    public static final class Builder {
        private final C5869f boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = C5869f.m24697a(str);
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("multipart != ");
                stringBuilder.append(mediaType);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Part part) {
            if (part != null) {
                this.parts.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    public static final class Part {
        final RequestBody body;
        final Headers headers;

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            if (requestBody != null) {
                if (headers != null) {
                    if (headers.get(HttpHeaders.CONTENT_TYPE) != null) {
                        throw new IllegalArgumentException("Unexpected header: Content-Type");
                    }
                }
                if (headers != null) {
                    if (headers.get(HttpHeaders.CONTENT_LENGTH) != null) {
                        throw new IllegalArgumentException("Unexpected header: Content-Length");
                    }
                }
                return new Part(headers, requestBody);
            }
            throw new NullPointerException("body == null");
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create(null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str != null) {
                StringBuilder stringBuilder = new StringBuilder("form-data; name=");
                MultipartBody.appendQuotedString(stringBuilder, str);
                if (str2 != null) {
                    stringBuilder.append("; filename=");
                    MultipartBody.appendQuotedString(stringBuilder, str2);
                }
                return create(Headers.of("Content-Disposition", stringBuilder.toString()), requestBody);
            }
            throw new NullPointerException("name == null");
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public Headers headers() {
            return this.headers;
        }

        public RequestBody body() {
            return this.body;
        }
    }

    MultipartBody(C5869f c5869f, MediaType mediaType, List<Part> list) {
        this.boundary = c5869f;
        this.originalType = mediaType;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mediaType);
        stringBuilder.append("; boundary=");
        stringBuilder.append(c5869f.mo5099a());
        this.contentType = MediaType.parse(stringBuilder.toString());
        this.parts = Util.immutableList((List) list);
    }

    public MediaType type() {
        return this.originalType;
    }

    public String boundary() {
        return this.boundary.mo5099a();
    }

    public int size() {
        return this.parts.size();
    }

    public List<Part> parts() {
        return this.parts;
    }

    public Part part(int i) {
        return (Part) this.parts.get(i);
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public long contentLength() {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        j = writeOrCountBytes(null, true);
        this.contentLength = j;
        return j;
    }

    public void writeTo(C7203d c7203d) {
        writeOrCountBytes(c7203d, false);
    }

    private long writeOrCountBytes(C7203d c7203d, boolean z) {
        C8037c c8037c;
        if (z) {
            c7203d = new C8037c();
            c8037c = c7203d;
        } else {
            c8037c = null;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = (Part) this.parts.get(i);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            c7203d.mo6296c(DASHDASH);
            c7203d.mo6293b(this.boundary);
            c7203d.mo6296c(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c7203d.mo6294b(headers.name(i2)).mo6296c(COLONSPACE).mo6294b(headers.value(i2)).mo6296c(CRLF);
                }
            }
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                c7203d.mo6294b("Content-Type: ").mo6294b(contentType.toString()).mo6296c(CRLF);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                c7203d.mo6294b("Content-Length: ").mo6316n(contentLength).mo6296c(CRLF);
            } else if (z) {
                c8037c.m39025t();
                return -1;
            }
            c7203d.mo6296c(CRLF);
            if (z) {
                j += contentLength;
            } else {
                requestBody.writeTo(c7203d);
            }
            c7203d.mo6296c(CRLF);
        }
        c7203d.mo6296c(DASHDASH);
        c7203d.mo6293b(this.boundary);
        c7203d.mo6296c(DASHDASH);
        c7203d.mo6296c(CRLF);
        if (z) {
            j += c8037c.m38961a();
            c8037c.m39025t();
        }
        return j;
    }

    static StringBuilder appendQuotedString(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                stringBuilder.append("%0A");
            } else if (charAt == '\r') {
                stringBuilder.append("%0D");
            } else if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append("%22");
            }
        }
        stringBuilder.append('\"');
        return stringBuilder;
    }
}
