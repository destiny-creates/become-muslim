package com.facebook.common.util;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {
    public static byte[] getBytesFromStream(InputStream inputStream) {
        return getBytesFromStream(inputStream, inputStream.available());
    }

    public static byte[] getBytesFromStream(InputStream inputStream, int i) {
        OutputStream c17331 = new ByteArrayOutputStream(i) {
            public byte[] toByteArray() {
                if (this.count == this.buf.length) {
                    return this.buf;
                }
                return super.toByteArray();
            }
        };
        ByteStreams.copy(inputStream, c17331);
        return c17331.toByteArray();
    }

    public static long skip(InputStream inputStream, long j) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkArgument(j >= 0);
        long j2 = j;
        while (j2 > 0) {
            long skip = inputStream.skip(j2);
            if (skip > 0) {
                j2 -= skip;
            } else if (inputStream.read() == -1) {
                return j - j2;
            } else {
                j2--;
            }
        }
        return j;
    }
}
