package net.openid.appauth.p368a;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.util.HashSet;
import java.util.Set;

/* compiled from: BrowserDescriptor */
/* renamed from: net.openid.appauth.a.b */
public class C6568b {
    /* renamed from: a */
    public final String f21103a;
    /* renamed from: b */
    public final Set<String> f21104b;
    /* renamed from: c */
    public final String f21105c;
    /* renamed from: d */
    public final Boolean f21106d;

    public C6568b(PackageInfo packageInfo, boolean z) {
        this(packageInfo.packageName, C6568b.m26779a(packageInfo.signatures), packageInfo.versionName, z);
    }

    public C6568b(String str, Set<String> set, String str2, boolean z) {
        this.f21103a = str;
        this.f21104b = set;
        this.f21105c = str2;
        this.f21106d = Boolean.valueOf(z);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj instanceof C6568b) {
                C6568b c6568b = (C6568b) obj;
                if (!this.f21103a.equals(c6568b.f21103a) || !this.f21105c.equals(c6568b.f21105c) || this.f21106d != c6568b.f21106d || this.f21104b.equals(c6568b.f21104b) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.f21103a.hashCode() * 92821) + this.f21105c.hashCode()) * 92821) + this.f21106d.booleanValue();
        for (String hashCode2 : this.f21104b) {
            hashCode = (hashCode * 92821) + hashCode2.hashCode();
        }
        return hashCode;
    }

    /* renamed from: a */
    public static java.lang.String m26778a(android.content.pm.Signature r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "SHA-512";	 Catch:{ NoSuchAlgorithmException -> 0x0015 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0015 }
        r1 = r1.toByteArray();	 Catch:{ NoSuchAlgorithmException -> 0x0015 }
        r1 = r0.digest(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0015 }
        r0 = 10;	 Catch:{ NoSuchAlgorithmException -> 0x0015 }
        r1 = android.util.Base64.encodeToString(r1, r0);	 Catch:{ NoSuchAlgorithmException -> 0x0015 }
        return r1;
    L_0x0015:
        r1 = new java.lang.IllegalStateException;
        r0 = "Platform does not supportSHA-512 hashing";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.a.b.a(android.content.pm.Signature):java.lang.String");
    }

    /* renamed from: a */
    public static Set<String> m26779a(Signature[] signatureArr) {
        Set<String> hashSet = new HashSet();
        for (Signature a : signatureArr) {
            hashSet.add(C6568b.m26778a(a));
        }
        return hashSet;
    }
}
