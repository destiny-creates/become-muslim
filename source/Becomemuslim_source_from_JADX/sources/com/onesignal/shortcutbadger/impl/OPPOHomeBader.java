package com.onesignal.shortcutbadger.impl;

import com.onesignal.shortcutbadger.C5534a;
import java.util.Collections;
import java.util.List;

public class OPPOHomeBader implements C5534a {
    /* renamed from: a */
    private static int f24845a = -1;

    @android.annotation.TargetApi(11)
    /* renamed from: a */
    public void mo4971a(android.content.Context r4, android.content.ComponentName r5, int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        if (r6 != 0) goto L_0x0003;
    L_0x0002:
        r6 = -1;
    L_0x0003:
        r0 = new android.content.Intent;
        r1 = "com.oppo.unsettledevent";
        r0.<init>(r1);
        r1 = "pakeageName";
        r5 = r5.getPackageName();
        r0.putExtra(r1, r5);
        r5 = "number";
        r0.putExtra(r5, r6);
        r5 = "upgradeNumber";
        r0.putExtra(r5, r6);
        r5 = com.onesignal.shortcutbadger.p253a.C5532a.m23555a(r4, r0);
        if (r5 == 0) goto L_0x0027;
    L_0x0023:
        r4.sendBroadcast(r0);
        goto L_0x0064;
    L_0x0027:
        r5 = r3.m32716b();
        r1 = 6;
        if (r5 != r1) goto L_0x0064;
    L_0x002e:
        r5 = new android.os.Bundle;	 Catch:{ Throwable -> 0x0049 }
        r5.<init>();	 Catch:{ Throwable -> 0x0049 }
        r1 = "app_badge_count";	 Catch:{ Throwable -> 0x0049 }
        r5.putInt(r1, r6);	 Catch:{ Throwable -> 0x0049 }
        r4 = r4.getContentResolver();	 Catch:{ Throwable -> 0x0049 }
        r6 = "content://com.android.badge/badge";	 Catch:{ Throwable -> 0x0049 }
        r6 = android.net.Uri.parse(r6);	 Catch:{ Throwable -> 0x0049 }
        r1 = "setAppBadgeCount";	 Catch:{ Throwable -> 0x0049 }
        r2 = 0;	 Catch:{ Throwable -> 0x0049 }
        r4.call(r6, r1, r2, r5);	 Catch:{ Throwable -> 0x0049 }
        goto L_0x0064;
    L_0x0049:
        r4 = new com.onesignal.shortcutbadger.b;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "unable to resolve intent: ";
        r5.append(r6);
        r6 = r0.toString();
        r5.append(r6);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0064:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.a(android.content.Context, android.content.ComponentName, int):void");
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    /* renamed from: b */
    private int m32716b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = f24845a;
        if (r0 < 0) goto L_0x0007;
    L_0x0004:
        r0 = f24845a;
        return r0;
    L_0x0007:
        r0 = "com.color.os.ColorBuild";	 Catch:{ Exception -> 0x001b }
        r0 = r3.m32712a(r0);	 Catch:{ Exception -> 0x001b }
        r1 = "getColorOSVERSION";	 Catch:{ Exception -> 0x001b }
        r2 = 0;	 Catch:{ Exception -> 0x001b }
        r0 = r3.m32713a(r0, r1, r2, r2);	 Catch:{ Exception -> 0x001b }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x001b }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x001b }
        goto L_0x001c;
    L_0x001b:
        r0 = 0;
    L_0x001c:
        if (r0 != 0) goto L_0x0042;
    L_0x001e:
        r1 = "ro.build.version.opporom";	 Catch:{ Exception -> 0x0042 }
        r1 = r3.m32717b(r1);	 Catch:{ Exception -> 0x0042 }
        r2 = "V1.4";	 Catch:{ Exception -> 0x0042 }
        r2 = r1.startsWith(r2);	 Catch:{ Exception -> 0x0042 }
        if (r2 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x0042 }
    L_0x002c:
        r0 = 3;	 Catch:{ Exception -> 0x0042 }
        return r0;	 Catch:{ Exception -> 0x0042 }
    L_0x002e:
        r2 = "V2.0";	 Catch:{ Exception -> 0x0042 }
        r2 = r1.startsWith(r2);	 Catch:{ Exception -> 0x0042 }
        if (r2 == 0) goto L_0x0038;	 Catch:{ Exception -> 0x0042 }
    L_0x0036:
        r0 = 4;	 Catch:{ Exception -> 0x0042 }
        return r0;	 Catch:{ Exception -> 0x0042 }
    L_0x0038:
        r2 = "V2.1";	 Catch:{ Exception -> 0x0042 }
        r1 = r1.startsWith(r2);	 Catch:{ Exception -> 0x0042 }
        if (r1 == 0) goto L_0x0042;
    L_0x0040:
        r0 = 5;
        return r0;
    L_0x0042:
        f24845a = r0;
        r0 = f24845a;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.b():int");
    }

    /* renamed from: a */
    private Object m32713a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        if (!(cls == null || m32715a((Object) str))) {
            cls = m32714a(cls, str, clsArr);
            if (cls != null) {
                cls.setAccessible(true);
                try {
                    return cls.invoke(null, objArr);
                } catch (Class cls2) {
                    cls2.printStackTrace();
                } catch (Class cls22) {
                    cls22.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private java.lang.reflect.Method m32714a(java.lang.Class r3, java.lang.String r4, java.lang.Class[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 == 0) goto L_0x0029;
    L_0x0003:
        r1 = r2.m32715a(r4);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0029;
    L_0x000a:
        r3.getMethods();	 Catch:{ Exception -> 0x0015 }
        r3.getDeclaredMethods();	 Catch:{ Exception -> 0x0015 }
        r1 = r3.getDeclaredMethod(r4, r5);	 Catch:{ Exception -> 0x0015 }
        return r1;
    L_0x0015:
        r1 = r3.getMethod(r4, r5);	 Catch:{ Exception -> 0x001a }
        return r1;
    L_0x001a:
        r1 = r3.getSuperclass();
        if (r1 == 0) goto L_0x0028;
    L_0x0020:
        r3 = r3.getSuperclass();
        r0 = r2.m32714a(r3, r4, r5);
    L_0x0028:
        return r0;
    L_0x0029:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* renamed from: a */
    private java.lang.Class m32712a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r1 = 0;
    L_0x0006:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.a(java.lang.String):java.lang.Class");
    }

    /* renamed from: a */
    private boolean m32715a(Object obj) {
        if (!(obj == null || obj.toString().equals(""))) {
            if (obj.toString().trim().equals("null") == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: b */
    private java.lang.String m32717b(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2.<init>();	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r3 = "getprop ";	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2.append(r3);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2.append(r5);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = r2.toString();	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = r1.exec(r5);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = r5.getInputStream();	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r2.<init>(r5);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r1.<init>(r2, r5);	 Catch:{ IOException -> 0x003d, all -> 0x0038 }
        r5 = r1.readLine();	 Catch:{ IOException -> 0x003e, all -> 0x0035 }
        r1.close();	 Catch:{ IOException -> 0x003e, all -> 0x0035 }
        com.onesignal.shortcutbadger.p253a.C5533b.m23557a(r1);
        return r5;
    L_0x0035:
        r5 = move-exception;
        r0 = r1;
        goto L_0x0039;
    L_0x0038:
        r5 = move-exception;
    L_0x0039:
        com.onesignal.shortcutbadger.p253a.C5533b.m23557a(r0);
        throw r5;
    L_0x003d:
        r1 = r0;
    L_0x003e:
        com.onesignal.shortcutbadger.p253a.C5533b.m23557a(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.OPPOHomeBader.b(java.lang.String):java.lang.String");
    }
}
