package org.spongycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class Base64 {
    /* renamed from: a */
    private static final Encoder f23437a = new Base64Encoder();

    /* renamed from: a */
    public static byte[] m29432a(byte[] bArr) {
        return m29433a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static byte[] m29433a(byte[] bArr, int i, int i2) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(((i2 + 2) / 3) * 4);
        try {
            f23437a.mo5938a(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (byte[] bArr2) {
            i2 = new StringBuilder();
            i2.append("exception encoding base64 string: ");
            i2.append(bArr2.getMessage());
            throw new EncoderException(i2.toString(), bArr2);
        }
    }

    /* renamed from: a */
    public static byte[] m29431a(String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 4) * 3);
        try {
            f23437a.mo5937a(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unable to decode base64 string: ");
            stringBuilder.append(str2.getMessage());
            throw new DecoderException(stringBuilder.toString(), str2);
        }
    }
}
