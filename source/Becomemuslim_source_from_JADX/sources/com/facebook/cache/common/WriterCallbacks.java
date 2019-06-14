package com.facebook.cache.common;

import com.facebook.common.internal.ByteStreams;
import java.io.InputStream;
import java.io.OutputStream;

public class WriterCallbacks {
    public static WriterCallback from(final InputStream inputStream) {
        return new WriterCallback() {
            public void write(OutputStream outputStream) {
                ByteStreams.copy(inputStream, outputStream);
            }
        };
    }

    public static WriterCallback from(final byte[] bArr) {
        return new WriterCallback() {
            public void write(OutputStream outputStream) {
                outputStream.write(bArr);
            }
        };
    }
}
