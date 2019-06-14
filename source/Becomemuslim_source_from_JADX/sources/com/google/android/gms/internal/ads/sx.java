package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;

@cm
final class sx {
    /* renamed from: a */
    private static final String[] f16023a = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    /* renamed from: b */
    private static final String[] f16024b = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};

    sx() {
    }

    /* renamed from: a */
    private static void m20106a(String str, String str2, String str3) {
        if (((Boolean) aph.m18688f().m18889a(asp.bs)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            str = "host";
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str2 = parse.getHost();
                    bundle.putString(str, str2);
                }
            }
            str2 = "";
            bundle.putString(str, str2);
        }
    }

    /* renamed from: a */
    final void m20107a(int i, String str) {
        String str2;
        if (i < 0) {
            int i2 = (-i) - 1;
            if (i2 < f16023a.length) {
                str2 = f16023a[i2];
                m20106a("http_err", str2, str);
            }
        }
        str2 = String.valueOf(i);
        m20106a("http_err", str2, str);
    }

    /* renamed from: a */
    final void m20108a(SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= f16024b.length) ? String.valueOf(primaryError) : f16024b[primaryError];
            m20106a("ssl_err", valueOf, sslError.getUrl());
        }
    }
}
