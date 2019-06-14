package me.leolin.shortcutbadger.impl;

import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C6563a;

public class NovaHomeBadger implements C6563a {
    /* renamed from: a */
    public void mo5508a(android.content.Context r5, android.content.ComponentName r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new android.content.ContentValues;	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r0.<init>();	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r1 = "tag";	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r3 = r6.getPackageName();	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r3 = "/";	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r2.append(r3);	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r6 = r6.getClassName();	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r2.append(r6);	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r6 = r2.toString();	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r0.put(r1, r6);	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r6 = "count";	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r0.put(r6, r7);	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r5 = r5.getContentResolver();	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r6 = "content://com.teslacoilsw.notifier/unread_count";	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r6 = android.net.Uri.parse(r6);	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        r5.insert(r6, r0);	 Catch:{ IllegalArgumentException -> 0x0048, Exception -> 0x003d }
        goto L_0x0048;
    L_0x003d:
        r5 = move-exception;
        r6 = new me.leolin.shortcutbadger.b;
        r5 = r5.getMessage();
        r6.<init>(r5);
        throw r6;
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: me.leolin.shortcutbadger.impl.NovaHomeBadger.a(android.content.Context, android.content.ComponentName, int):void");
    }

    /* renamed from: a */
    public List<String> mo5507a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }
}
