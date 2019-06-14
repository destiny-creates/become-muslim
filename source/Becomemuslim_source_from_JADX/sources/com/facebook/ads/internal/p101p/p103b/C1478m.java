package com.facebook.ads.internal.p101p.p103b;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.facebook.ads.AudienceNetworkActivity;
import java.io.Closeable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/* renamed from: com.facebook.ads.internal.p.b.m */
public class C1478m {
    /* renamed from: a */
    static String m5227a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Object fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return TextUtils.isEmpty(fileExtensionFromUrl) ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    /* renamed from: a */
    private static String m5228a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static void m5229a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                Log.e("ProxyCache", "Error closing resource", e);
            }
        }
    }

    /* renamed from: a */
    static void m5230a(byte[] bArr, long j, int i) {
        C1473j.m5211a((Object) bArr, "Buffer must be not null!");
        boolean z = false;
        C1473j.m5212a(j >= 0, "Data offset must be positive!");
        if (i >= 0 && i <= bArr.length) {
            z = true;
        }
        C1473j.m5212a(z, "Length must be in range [0..buffer.length]");
    }

    /* renamed from: b */
    static String m5231b(String str) {
        try {
            return URLEncoder.encode(str, AudienceNetworkActivity.WEBVIEW_ENCODING);
        } catch (Throwable e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    /* renamed from: c */
    static String m5232c(String str) {
        try {
            return URLDecoder.decode(str, AudienceNetworkActivity.WEBVIEW_ENCODING);
        } catch (Throwable e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    /* renamed from: d */
    public static String m5233d(String str) {
        try {
            return C1478m.m5228a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
