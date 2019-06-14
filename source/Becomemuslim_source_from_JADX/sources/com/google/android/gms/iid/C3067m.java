package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.C0366b;
import android.support.v4.util.C3211a;
import android.util.Log;
import java.io.File;
import java.util.Map;

/* renamed from: com.google.android.gms.iid.m */
public final class C3067m {
    /* renamed from: a */
    private SharedPreferences f7839a;
    /* renamed from: b */
    private Context f7840b;
    /* renamed from: c */
    private final C3077x f7841c;
    /* renamed from: d */
    private final Map<String, C3078y> f7842d;

    public C3067m(Context context) {
        this(context, new C3077x());
    }

    private C3067m(Context context, C3077x c3077x) {
        this.f7842d = new C3211a();
        this.f7840b = context;
        this.f7839a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f7841c = c3077x;
        File file = new File(C0366b.m1111b(this.f7840b), "com.google.android.gms.appid-no-backup");
        if (file.exists() == null) {
            try {
                if (file.createNewFile() != null && m8981a() == null) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    C4428b.m14713a(this.f7840b, this);
                }
            } catch (Context context2) {
                if (Log.isLoggable("InstanceID/Store", 3) != null) {
                    c3077x = "InstanceID/Store";
                    String str = "Error creating file in no backup dir: ";
                    context2 = String.valueOf(context2.getMessage());
                    Log.d(c3077x, context2.length() != 0 ? str.concat(context2) : new String(str));
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m8981a() {
        return this.f7839a.getAll().isEmpty();
    }

    /* renamed from: c */
    private static String m8976c(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append(str);
        stringBuilder.append("|T|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    /* renamed from: d */
    private static String m8977d(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str).length() + 14) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append(str);
        stringBuilder.append("|T-timestamp|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    final synchronized String m8978a(String str) {
        return this.f7839a.getString(str, null);
    }

    /* renamed from: b */
    public final synchronized void m8984b(String str) {
        Editor edit = this.f7839a.edit();
        for (String str2 : this.f7839a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    /* renamed from: b */
    public final synchronized void m8983b() {
        this.f7842d.clear();
        C3077x.m9000a(this.f7840b);
        this.f7839a.edit().clear().commit();
    }

    /* renamed from: a */
    public final synchronized String m8979a(String str, String str2, String str3) {
        return this.f7839a.getString(C3067m.m8976c(str, str2, str3), null);
    }

    /* renamed from: b */
    final synchronized long m8982b(String str, String str2, String str3) {
        return this.f7839a.getLong(C3067m.m8977d(str, str2, str3), -1);
    }

    /* renamed from: a */
    public final synchronized void m8980a(String str, String str2, String str3, String str4, String str5) {
        String c = C3067m.m8976c(str, str2, str3);
        str = C3067m.m8977d(str, str2, str3);
        str2 = this.f7839a.edit();
        str2.putString(c, str4);
        str2.putLong(str, System.currentTimeMillis());
        str2.putString("appVersion", str5);
        str2.commit();
    }

    /* renamed from: c */
    public final synchronized com.google.android.gms.iid.C3078y m8985c(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f7842d;	 Catch:{ all -> 0x0031 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0031 }
        r0 = (com.google.android.gms.iid.C3078y) r0;	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);
        return r0;
    L_0x000d:
        r0 = r2.f7841c;	 Catch:{ z -> 0x0016 }
        r1 = r2.f7840b;	 Catch:{ z -> 0x0016 }
        r0 = r0.m9011a(r1, r3);	 Catch:{ z -> 0x0016 }
        goto L_0x002a;
    L_0x0016:
        r0 = "InstanceID/Store";	 Catch:{ all -> 0x0031 }
        r1 = "Stored data is corrupt, generating new identity";	 Catch:{ all -> 0x0031 }
        android.util.Log.w(r0, r1);	 Catch:{ all -> 0x0031 }
        r0 = r2.f7840b;	 Catch:{ all -> 0x0031 }
        com.google.android.gms.iid.C4428b.m14713a(r0, r2);	 Catch:{ all -> 0x0031 }
        r0 = r2.f7841c;	 Catch:{ all -> 0x0031 }
        r1 = r2.f7840b;	 Catch:{ all -> 0x0031 }
        r0 = r0.m9012b(r1, r3);	 Catch:{ all -> 0x0031 }
    L_0x002a:
        r1 = r2.f7842d;	 Catch:{ all -> 0x0031 }
        r1.put(r3, r0);	 Catch:{ all -> 0x0031 }
        monitor-exit(r2);
        return r0;
    L_0x0031:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.m.c(java.lang.String):com.google.android.gms.iid.y");
    }

    /* renamed from: d */
    final void m8986d(String str) {
        synchronized (this) {
            this.f7842d.remove(str);
        }
        C3077x.m9007c(this.f7840b, str);
        m8984b(String.valueOf(str).concat("|"));
    }

    /* renamed from: a */
    static String m8975a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append("|S|");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
