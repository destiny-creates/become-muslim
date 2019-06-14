package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.C0366b;
import android.support.v4.util.C3211a;
import android.util.Log;
import java.io.File;
import java.util.Map;

/* renamed from: com.google.firebase.iid.z */
final class C5371z {
    /* renamed from: a */
    private final SharedPreferences f18137a;
    /* renamed from: b */
    private final Context f18138b;
    /* renamed from: c */
    private final bb f18139c;
    /* renamed from: d */
    private final Map<String, bc> f18140d;

    public C5371z(Context context) {
        this(context, new bb());
    }

    private C5371z(Context context, bb bbVar) {
        this.f18140d = new C3211a();
        this.f18138b = context;
        this.f18137a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f18139c = bbVar;
        File file = new File(C0366b.b(this.f18138b), "com.google.android.gms.appid-no-backup");
        if (file.exists() == null) {
            try {
                if (file.createNewFile() != null && m22807c() == null) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    m22813b();
                    FirebaseInstanceId.m22665a().m22690i();
                }
            } catch (Context context2) {
                if (Log.isLoggable("FirebaseInstanceId", 3) != null) {
                    bbVar = "FirebaseInstanceId";
                    String str = "Error creating file in no backup dir: ";
                    context2 = String.valueOf(context2.getMessage());
                    Log.d(bbVar, context2.length() != 0 ? str.concat(context2) : new String(str));
                }
            }
        }
    }

    /* renamed from: a */
    public final synchronized String m22809a() {
        return this.f18137a.getString("topic_operaion_queue", "");
    }

    /* renamed from: a */
    public final synchronized void m22810a(String str) {
        this.f18137a.edit().putString("topic_operaion_queue", str).apply();
    }

    /* renamed from: c */
    private final synchronized boolean m22807c() {
        return this.f18137a.getAll().isEmpty();
    }

    /* renamed from: b */
    private static String m22806b(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append(str);
        stringBuilder.append("|T|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static String m22805a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append("|S|");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public final synchronized void m22813b() {
        this.f18140d.clear();
        bb.m22739a(this.f18138b);
        this.f18137a.edit().clear().commit();
    }

    /* renamed from: a */
    public final synchronized aa m22808a(String str, String str2, String str3) {
        return aa.m22696a(this.f18137a.getString(C5371z.m22806b(str, str2, str3), null));
    }

    /* renamed from: a */
    public final synchronized void m22811a(String str, String str2, String str3, String str4, String str5) {
        str4 = aa.m22698a(str4, str5, System.currentTimeMillis());
        if (str4 != null) {
            str5 = this.f18137a.edit();
            str5.putString(C5371z.m22806b(str, str2, str3), str4);
            str5.commit();
        }
    }

    /* renamed from: b */
    public final synchronized com.google.firebase.iid.bc m22812b(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f18140d;	 Catch:{ all -> 0x0033 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0033 }
        r0 = (com.google.firebase.iid.bc) r0;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);
        return r0;
    L_0x000d:
        r0 = r2.f18139c;	 Catch:{ d -> 0x0016 }
        r1 = r2.f18138b;	 Catch:{ d -> 0x0016 }
        r0 = r0.m22749a(r1, r3);	 Catch:{ d -> 0x0016 }
        goto L_0x002c;
    L_0x0016:
        r0 = "FirebaseInstanceId";	 Catch:{ all -> 0x0033 }
        r1 = "Stored data is corrupt, generating new identity";	 Catch:{ all -> 0x0033 }
        android.util.Log.w(r0, r1);	 Catch:{ all -> 0x0033 }
        r0 = com.google.firebase.iid.FirebaseInstanceId.m22665a();	 Catch:{ all -> 0x0033 }
        r0.m22690i();	 Catch:{ all -> 0x0033 }
        r0 = r2.f18139c;	 Catch:{ all -> 0x0033 }
        r1 = r2.f18138b;	 Catch:{ all -> 0x0033 }
        r0 = r0.m22750b(r1, r3);	 Catch:{ all -> 0x0033 }
    L_0x002c:
        r1 = r2.f18140d;	 Catch:{ all -> 0x0033 }
        r1.put(r3, r0);	 Catch:{ all -> 0x0033 }
        monitor-exit(r2);
        return r0;
    L_0x0033:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.z.b(java.lang.String):com.google.firebase.iid.bc");
    }

    /* renamed from: c */
    public final synchronized void m22814c(String str) {
        str = String.valueOf(str).concat("|T|");
        Editor edit = this.f18137a.edit();
        for (String str2 : this.f18137a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
