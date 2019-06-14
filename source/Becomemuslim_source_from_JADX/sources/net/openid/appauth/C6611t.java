package net.openid.appauth;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: Utils */
/* renamed from: net.openid.appauth.t */
class C6611t {
    /* renamed from: a */
    public static String m26969a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        inputStream = new char[1024];
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int read = bufferedReader.read(inputStream);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(inputStream, 0, read);
        }
    }

    /* renamed from: b */
    public static void m26970b(java.io.InputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.t.b(java.io.InputStream):void");
    }
}
