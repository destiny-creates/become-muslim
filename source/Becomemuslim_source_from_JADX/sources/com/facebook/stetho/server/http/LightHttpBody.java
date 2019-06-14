package com.facebook.stetho.server.http;

import com.facebook.stetho.common.Utf8Charset;
import java.io.OutputStream;

public abstract class LightHttpBody {
    public abstract int contentLength();

    public abstract String contentType();

    public abstract void writeTo(OutputStream outputStream);

    public static LightHttpBody create(String str, String str2) {
        try {
            return create(str.getBytes(Utf8Charset.NAME), str2);
        } catch (String str3) {
            throw new RuntimeException(str3);
        }
    }

    public static LightHttpBody create(final byte[] bArr, final String str) {
        return new LightHttpBody() {
            public String contentType() {
                return str;
            }

            public int contentLength() {
                return bArr.length;
            }

            public void writeTo(OutputStream outputStream) {
                outputStream.write(bArr);
            }
        };
    }
}
