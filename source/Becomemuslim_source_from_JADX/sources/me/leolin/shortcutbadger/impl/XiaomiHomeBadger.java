package me.leolin.shortcutbadger.impl;

import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C6563a;

public class XiaomiHomeBadger implements C6563a {
    /* renamed from: a */
    public void mo5508a(android.content.Context r5, android.content.ComponentName r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "android.app.MiuiNotification";	 Catch:{ Exception -> 0x0029 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0029 }
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x0029 }
        r1 = r0.getClass();	 Catch:{ Exception -> 0x0029 }
        r2 = "messageCount";	 Catch:{ Exception -> 0x0029 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0029 }
        r2 = 1;	 Catch:{ Exception -> 0x0029 }
        r1.setAccessible(r2);	 Catch:{ Exception -> 0x0029 }
        if (r7 != 0) goto L_0x001d;	 Catch:{ Exception -> 0x0029 }
    L_0x001a:
        r2 = "";	 Catch:{ Exception -> 0x0029 }
        goto L_0x0021;	 Catch:{ Exception -> 0x0029 }
    L_0x001d:
        r2 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0029 }
    L_0x0021:
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0029 }
        r1.set(r0, r2);	 Catch:{ Exception -> 0x0029 }
        goto L_0x0067;
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
        if (r7 != 0) goto L_0x0059;
    L_0x0056:
        r7 = "";
        goto L_0x005d;
    L_0x0059:
        r7 = java.lang.Integer.valueOf(r7);
    L_0x005d:
        r7 = java.lang.String.valueOf(r7);
        r0.putExtra(r6, r7);
        r5.sendBroadcast(r0);
    L_0x0067:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: me.leolin.shortcutbadger.impl.XiaomiHomeBadger.a(android.content.Context, android.content.ComponentName, int):void");
    }

    /* renamed from: a */
    public List<String> mo5507a() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2"});
    }
}
