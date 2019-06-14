package com.facebook.common.util;

import android.util.Base64;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.imageutils.JfifUtil;
import java.io.InputStream;
import java.security.MessageDigest;

public class SecureHashUtil {
    private static final int BUFFER_SIZE = 4096;
    static final byte[] HEX_CHAR_TABLE = new byte[]{(byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};

    public static String makeSHA1Hash(String str) {
        try {
            return makeSHA1Hash(str.getBytes(AudienceNetworkActivity.WEBVIEW_ENCODING));
        } catch (String str2) {
            throw new RuntimeException(str2);
        }
    }

    public static String makeSHA1Hash(byte[] bArr) {
        return makeHash(bArr, "SHA-1");
    }

    public static String makeSHA256Hash(byte[] bArr) {
        return makeHash(bArr, "SHA-256");
    }

    public static String makeSHA1HashBase64(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr, 0, bArr.length);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (byte[] bArr2) {
            throw new RuntimeException(bArr2);
        }
    }

    public static String makeMD5Hash(String str) {
        try {
            return makeMD5Hash(str.getBytes(AudienceNetworkActivity.WEBVIEW_ENCODING));
        } catch (String str2) {
            throw new RuntimeException(str2);
        }
    }

    public static String makeMD5Hash(byte[] bArr) {
        return makeHash(bArr, "MD5");
    }

    public static String makeMD5Hash(InputStream inputStream) {
        return makeHash(inputStream, "MD5");
    }

    public static String convertToHex(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            int i = b & JfifUtil.MARKER_FIRST_BYTE;
            stringBuilder.append((char) HEX_CHAR_TABLE[i >>> 4]);
            stringBuilder.append((char) HEX_CHAR_TABLE[i & 15]);
        }
        return stringBuilder.toString();
    }

    private static String makeHash(byte[] bArr, String str) {
        try {
            str = MessageDigest.getInstance(str);
            str.update(bArr, 0, bArr.length);
            return convertToHex(str.digest());
        } catch (byte[] bArr2) {
            throw new RuntimeException(bArr2);
        } catch (byte[] bArr22) {
            throw new RuntimeException(bArr22);
        }
    }

    private static String makeHash(InputStream inputStream, String str) {
        try {
            str = MessageDigest.getInstance(str);
            byte[] bArr = new byte[BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return convertToHex(str.digest());
                }
                str.update(bArr, 0, read);
            }
        } catch (InputStream inputStream2) {
            throw new RuntimeException(inputStream2);
        } catch (InputStream inputStream22) {
            throw new RuntimeException(inputStream22);
        }
    }
}
