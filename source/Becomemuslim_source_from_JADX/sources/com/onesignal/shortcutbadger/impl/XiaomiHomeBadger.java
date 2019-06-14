package com.onesignal.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.facebook.internal.NativeProtocol;
import com.onesignal.shortcutbadger.C5534a;
import com.onesignal.shortcutbadger.C5535b;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class XiaomiHomeBadger implements C5534a {
    /* renamed from: a */
    private ResolveInfo f24850a;

    /* renamed from: a */
    public void mo4971a(android.content.Context r5, android.content.ComponentName r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "android.app.MiuiNotification";	 Catch:{ Exception -> 0x0031 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0031 }
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x0031 }
        r1 = r0.getClass();	 Catch:{ Exception -> 0x0031 }
        r2 = "messageCount";	 Catch:{ Exception -> 0x0031 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0031 }
        r2 = 1;	 Catch:{ Exception -> 0x0031 }
        r1.setAccessible(r2);	 Catch:{ Exception -> 0x0031 }
        if (r7 != 0) goto L_0x001d;
    L_0x001a:
        r2 = "";	 Catch:{ Exception -> 0x0029 }
        goto L_0x0021;	 Catch:{ Exception -> 0x0029 }
    L_0x001d:
        r2 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0029 }
    L_0x0021:
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0029 }
        r1.set(r0, r2);	 Catch:{ Exception -> 0x0029 }
        goto L_0x0075;
    L_0x0029:
        r2 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0031 }
        r1.set(r0, r2);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0075;
        r0 = new android.content.Intent;
        r1 = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
        r0.<init>(r1);
        r1 = "android.intent.extra.update_application_component_name";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r6.getPackageName();
        r2.append(r3);
        r3 = "/";
        r2.append(r3);
        r6 = r6.getClassName();
        r2.append(r6);
        r6 = r2.toString();
        r0.putExtra(r1, r6);
        r6 = "android.intent.extra.update_application_message_text";
        if (r7 != 0) goto L_0x0061;
    L_0x005e:
        r1 = "";
        goto L_0x0065;
    L_0x0061:
        r1 = java.lang.Integer.valueOf(r7);
    L_0x0065:
        r1 = java.lang.String.valueOf(r1);
        r0.putExtra(r6, r1);
        r6 = com.onesignal.shortcutbadger.p253a.C5532a.m23555a(r5, r0);
        if (r6 == 0) goto L_0x0075;
    L_0x0072:
        r5.sendBroadcast(r0);
    L_0x0075:
        r6 = android.os.Build.MANUFACTURER;
        r0 = "Xiaomi";
        r6 = r6.equalsIgnoreCase(r0);
        if (r6 == 0) goto L_0x0082;
    L_0x007f:
        r4.m32733a(r5, r7);
    L_0x0082:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.impl.XiaomiHomeBadger.a(android.content.Context, android.content.ComponentName, int):void");
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m32733a(Context context, int i) {
        if (this.f24850a == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.f24850a = context.getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        }
        if (this.f24850a != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            context = new Builder(context).setContentTitle("").setContentText("").setSmallIcon(this.f24850a.getIconResource()).build();
            try {
                Object obj = context.getClass().getDeclaredField("extraNotification").get(context);
                obj.getClass().getDeclaredMethod("setMessageCount", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)});
                notificationManager.notify(0, context);
            } catch (Context context2) {
                throw new C5535b("not able to set badge", context2);
            }
        }
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher"});
    }
}
