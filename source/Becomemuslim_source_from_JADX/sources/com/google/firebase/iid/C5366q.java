package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.C2904o;
import com.google.firebase.C5335b;
import java.util.List;

/* renamed from: com.google.firebase.iid.q */
public final class C5366q {
    /* renamed from: a */
    private final Context f18117a;
    /* renamed from: b */
    private String f18118b;
    /* renamed from: c */
    private String f18119c;
    /* renamed from: d */
    private int f18120d;
    /* renamed from: e */
    private int f18121e = 0;

    public C5366q(Context context) {
        this.f18117a = context;
    }

    /* renamed from: a */
    public final synchronized int m22782a() {
        if (this.f18121e != 0) {
            return this.f18121e;
        }
        PackageManager packageManager = this.f18117a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        Intent intent;
        if (!C2904o.l()) {
            intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f18121e = 1;
                return this.f18121e;
            }
        }
        intent = new Intent("com.google.iid.TOKEN_REQUEST");
        intent.setPackage("com.google.android.gms");
        List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (C2904o.l()) {
                this.f18121e = 2;
            } else {
                this.f18121e = 1;
            }
            return this.f18121e;
        }
        this.f18121e = 2;
        return this.f18121e;
    }

    /* renamed from: a */
    public static String m22779a(C5335b c5335b) {
        String b = c5335b.m22614c().m22623b();
        if (b != null) {
            return b;
        }
        c5335b = c5335b.m22614c().m22622a();
        if (!c5335b.startsWith("1:")) {
            return c5335b;
        }
        c5335b = c5335b.split(":");
        if (c5335b.length < 2) {
            return null;
        }
        c5335b = c5335b[1];
        if (c5335b.isEmpty()) {
            return null;
        }
        return c5335b;
    }

    /* renamed from: a */
    public static java.lang.String m22780a(java.security.KeyPair r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = r3.getPublic();
        r3 = r3.getEncoded();
        r0 = "SHA1";	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3 = r0.digest(r3);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r3[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r1 & 15;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r1 + 112;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = (byte) r1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3[r0] = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = 8;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2 = 11;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3 = android.util.Base64.encodeToString(r3, r0, r1, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        return r3;
    L_0x0025:
        r3 = "FirebaseInstanceId";
        r0 = "Unexpected error, device missing required algorithms";
        android.util.Log.w(r3, r0);
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.q.a(java.security.KeyPair):java.lang.String");
    }

    /* renamed from: b */
    public final synchronized String m22783b() {
        if (this.f18118b == null) {
            m22781e();
        }
        return this.f18118b;
    }

    /* renamed from: c */
    public final synchronized String m22784c() {
        if (this.f18119c == null) {
            m22781e();
        }
        return this.f18119c;
    }

    /* renamed from: d */
    public final synchronized int m22785d() {
        if (this.f18120d == 0) {
            PackageInfo a = m22778a("com.google.android.gms");
            if (a != null) {
                this.f18120d = a.versionCode;
            }
        }
        return this.f18120d;
    }

    /* renamed from: e */
    private final synchronized void m22781e() {
        PackageInfo a = m22778a(this.f18117a.getPackageName());
        if (a != null) {
            this.f18118b = Integer.toString(a.versionCode);
            this.f18119c = a.versionName;
        }
    }

    /* renamed from: a */
    private final PackageInfo m22778a(String str) {
        try {
            return this.f18117a.getPackageManager().getPackageInfo(str, 0);
        } catch (String str2) {
            str2 = String.valueOf(str2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 23);
            stringBuilder.append("Failed to find package ");
            stringBuilder.append(str2);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }
}
