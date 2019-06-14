package net.openid.appauth;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;
import net.openid.appauth.p370c.C6578a;

/* compiled from: CodeVerifierUtil */
/* renamed from: net.openid.appauth.m */
public final class C6601m {
    /* renamed from: a */
    private static final Pattern f21257a = Pattern.compile("^[0-9a-zA-Z\\-\\.\\_\\~]{43,128}$");

    /* renamed from: a */
    public static void m26914a(String str) {
        boolean z = false;
        C6605p.m26935a(43 <= str.length(), (Object) "codeVerifier length is shorter than allowed by the PKCE specification");
        if (str.length() <= 128) {
            z = true;
        }
        C6605p.m26935a(z, (Object) "codeVerifier length is longer than allowed by the PKCE specification");
        C6605p.m26935a(f21257a.matcher(str).matches(), (Object) "codeVerifier string contains illegal characters");
    }

    /* renamed from: a */
    public static String m26912a() {
        return C6601m.m26913a(new SecureRandom(), 64);
    }

    /* renamed from: a */
    public static String m26913a(SecureRandom secureRandom, int i) {
        C6605p.m26933a((Object) secureRandom, (Object) "entropySource cannot be null");
        boolean z = false;
        C6605p.m26935a(32 <= i, (Object) "entropyBytes is less than the minimum permitted");
        if (i <= 96) {
            z = true;
        }
        C6605p.m26935a(z, (Object) "entropyBytes is greater than the maximum permitted");
        i = new byte[i];
        secureRandom.nextBytes(i);
        return Base64.encodeToString(i, 11);
    }

    /* renamed from: b */
    public static String m26916b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes("ISO_8859_1"));
            return Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException e) {
            C6578a.m26807c("SHA-256 is not supported on this device! Using plain challenge", e);
            return str;
        } catch (String str2) {
            C6578a.m26808d("ISO-8859-1 encoding not supported on this device!", str2);
            throw new IllegalStateException("ISO-8859-1 encoding not supported", str2);
        }
    }

    /* renamed from: b */
    public static java.lang.String m26915b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "SHA-256";	 Catch:{ NoSuchAlgorithmException -> 0x0008 }
        java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0008 }
        r0 = "S256";	 Catch:{ NoSuchAlgorithmException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = "plain";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.m.b():java.lang.String");
    }
}
