package org.spongycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class Hex {
    /* renamed from: a */
    private static final Encoder f23440a = new HexEncoder();

    /* renamed from: a */
    public static byte[] m29437a(byte[] bArr) {
        return m29438a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static byte[] m29438a(byte[] bArr, int i, int i2) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f23440a.mo5938a(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (byte[] bArr2) {
            i2 = new StringBuilder();
            i2.append("exception encoding Hex string: ");
            i2.append(bArr2.getMessage());
            throw new EncoderException(i2.toString(), bArr2);
        }
    }

    /* renamed from: a */
    public static byte[] m29436a(String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f23440a.mo5937a(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exception decoding Hex string: ");
            stringBuilder.append(str2.getMessage());
            throw new DecoderException(stringBuilder.toString(), str2);
        }
    }
}
