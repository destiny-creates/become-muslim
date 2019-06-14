package net.openid.appauth.p368a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.common.util.UriUtil;

/* compiled from: BrowserSelector */
/* renamed from: net.openid.appauth.a.d */
public final class C6570d {
    /* renamed from: a */
    static final Intent f21107a = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));

    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    /* renamed from: a */
    public static java.util.List<net.openid.appauth.p368a.C6568b> m26781a(android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = r10.getPackageManager();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 64;
        r3 = 23;
        if (r1 < r3) goto L_0x0015;
    L_0x0011:
        r1 = 131136; // 0x20040 float:1.8376E-40 double:6.479E-319;
        goto L_0x0017;
    L_0x0015:
        r1 = 64;
    L_0x0017:
        r3 = f21107a;
        r4 = 0;
        r3 = r10.resolveActivity(r3, r4);
        if (r3 == 0) goto L_0x0025;
    L_0x0020:
        r3 = r3.activityInfo;
        r3 = r3.packageName;
        goto L_0x0026;
    L_0x0025:
        r3 = 0;
    L_0x0026:
        r5 = f21107a;
        r1 = r10.queryIntentActivities(r5, r1);
        r1 = r1.iterator();
    L_0x0030:
        r5 = r1.hasNext();
        if (r5 == 0) goto L_0x0086;
    L_0x0036:
        r5 = r1.next();
        r5 = (android.content.pm.ResolveInfo) r5;
        r6 = net.openid.appauth.p368a.C6570d.m26784a(r5);
        if (r6 != 0) goto L_0x0043;
    L_0x0042:
        goto L_0x0030;
    L_0x0043:
        r6 = r5.activityInfo;	 Catch:{ NameNotFoundException -> 0x0084 }
        r6 = r6.packageName;	 Catch:{ NameNotFoundException -> 0x0084 }
        r6 = r10.getPackageInfo(r6, r2);	 Catch:{ NameNotFoundException -> 0x0084 }
        r7 = r5.activityInfo;	 Catch:{ NameNotFoundException -> 0x0084 }
        r7 = r7.packageName;	 Catch:{ NameNotFoundException -> 0x0084 }
        r7 = net.openid.appauth.p368a.C6570d.m26783a(r10, r7);	 Catch:{ NameNotFoundException -> 0x0084 }
        r8 = 1;	 Catch:{ NameNotFoundException -> 0x0084 }
        if (r7 == 0) goto L_0x006c;	 Catch:{ NameNotFoundException -> 0x0084 }
    L_0x0056:
        r7 = new net.openid.appauth.a.b;	 Catch:{ NameNotFoundException -> 0x0084 }
        r7.<init>(r6, r8);	 Catch:{ NameNotFoundException -> 0x0084 }
        r9 = r5.activityInfo;	 Catch:{ NameNotFoundException -> 0x0084 }
        r9 = r9.packageName;	 Catch:{ NameNotFoundException -> 0x0084 }
        r9 = r9.equals(r3);	 Catch:{ NameNotFoundException -> 0x0084 }
        if (r9 == 0) goto L_0x0069;	 Catch:{ NameNotFoundException -> 0x0084 }
    L_0x0065:
        r0.add(r4, r7);	 Catch:{ NameNotFoundException -> 0x0084 }
        goto L_0x006d;	 Catch:{ NameNotFoundException -> 0x0084 }
    L_0x0069:
        r0.add(r7);	 Catch:{ NameNotFoundException -> 0x0084 }
    L_0x006c:
        r8 = 0;	 Catch:{ NameNotFoundException -> 0x0084 }
    L_0x006d:
        r7 = new net.openid.appauth.a.b;	 Catch:{ NameNotFoundException -> 0x0084 }
        r7.<init>(r6, r4);	 Catch:{ NameNotFoundException -> 0x0084 }
        r5 = r5.activityInfo;	 Catch:{ NameNotFoundException -> 0x0084 }
        r5 = r5.packageName;	 Catch:{ NameNotFoundException -> 0x0084 }
        r5 = r5.equals(r3);	 Catch:{ NameNotFoundException -> 0x0084 }
        if (r5 == 0) goto L_0x0080;	 Catch:{ NameNotFoundException -> 0x0084 }
    L_0x007c:
        r0.add(r8, r7);	 Catch:{ NameNotFoundException -> 0x0084 }
        goto L_0x0030;	 Catch:{ NameNotFoundException -> 0x0084 }
    L_0x0080:
        r0.add(r7);	 Catch:{ NameNotFoundException -> 0x0084 }
        goto L_0x0030;
        goto L_0x0030;
    L_0x0086:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.a.d.a(android.content.Context):java.util.List<net.openid.appauth.a.b>");
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    /* renamed from: a */
    public static C6568b m26782a(Context context, C6569c c6569c) {
        C6568b c6568b = null;
        for (C6568b c6568b2 : C6570d.m26781a(context)) {
            if (c6569c.mo5509a(c6568b2)) {
                if (c6568b2.f21106d.booleanValue()) {
                    return c6568b2;
                }
                if (c6568b == null) {
                    c6568b = c6568b2;
                }
            }
        }
        return c6568b;
    }

    /* renamed from: a */
    private static boolean m26783a(PackageManager packageManager, String str) {
        Intent intent = new Intent();
        intent.setAction("android.support.customtabs.action.CustomTabsService");
        intent.setPackage(str);
        if (packageManager.resolveService(intent, 0) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m26784a(ResolveInfo resolveInfo) {
        if (resolveInfo.filter.hasAction("android.intent.action.VIEW") && resolveInfo.filter.hasCategory("android.intent.category.BROWSABLE")) {
            if (resolveInfo.filter.schemesIterator() != null) {
                if (resolveInfo.filter.authoritiesIterator() != null) {
                    return false;
                }
                resolveInfo = resolveInfo.filter.schemesIterator();
                int i = 0;
                int i2 = 0;
                while (resolveInfo.hasNext()) {
                    String str = (String) resolveInfo.next();
                    i |= UriUtil.HTTP_SCHEME.equals(str);
                    i2 |= UriUtil.HTTPS_SCHEME.equals(str);
                    if (i != 0 && i2 != 0) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
