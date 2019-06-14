package org.spongycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class Streams {
    /* renamed from: a */
    private static int f23445a = 4096;

    /* renamed from: a */
    public static byte[] m29442a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m29441a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static int m29439a(InputStream inputStream, byte[] bArr) {
        return m29440a(inputStream, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static int m29440a(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    /* renamed from: a */
    public static void m29441a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[f23445a];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
