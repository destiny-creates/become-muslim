package org.apache.p371a.p373b.p375b;

import java.io.InputStream;
import java.security.MessageDigest;

/* compiled from: DigestUtils */
/* renamed from: org.apache.a.b.b.a */
public class C6639a {
    /* renamed from: b */
    private static byte[] m27028b(MessageDigest messageDigest, InputStream inputStream) {
        return C6639a.m27026a(messageDigest, inputStream).digest();
    }

    /* renamed from: a */
    public static MessageDigest m27025a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (String str2) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static MessageDigest m27024a() {
        return C6639a.m27025a("MD5");
    }

    /* renamed from: a */
    public static byte[] m27027a(InputStream inputStream) {
        return C6639a.m27028b(C6639a.m27024a(), inputStream);
    }

    /* renamed from: a */
    public static MessageDigest m27026a(MessageDigest messageDigest, InputStream inputStream) {
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr, 0, 1024);
        while (read > -1) {
            messageDigest.update(bArr, 0, read);
            read = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest;
    }
}
