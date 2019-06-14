package com.google.android.gms.internal.p210i;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.C2872v;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.i.aj */
public final class aj extends C6797o {
    /* renamed from: a */
    private volatile String f28799a;
    /* renamed from: b */
    private Future<String> f28800b;

    protected aj(C5008q c5008q) {
        super(c5008q);
    }

    /* renamed from: a */
    protected final void mo6145a() {
    }

    /* renamed from: b */
    public final String m37737b() {
        String str;
        m31800z();
        synchronized (this) {
            if (this.f28799a == null) {
                this.f28800b = m21047n().a(new ak(this));
            }
            if (this.f28800b != null) {
                try {
                    this.f28799a = (String) this.f28800b.get();
                } catch (InterruptedException e) {
                    m21034d("ClientId loading or generation was interrupted", e);
                    this.f28799a = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } catch (ExecutionException e2) {
                    m21037e("Failed to load or generate client id", e2);
                    this.f28799a = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                if (this.f28799a == null) {
                    this.f28799a = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                m21026a("Loaded clientId", this.f28799a);
                this.f28800b = null;
            }
            str = this.f28799a;
        }
        return str;
    }

    /* renamed from: c */
    final String m37738c() {
        synchronized (this) {
            this.f28799a = null;
            this.f28800b = m21047n().a(new al(this));
        }
        return m37737b();
    }

    /* renamed from: d */
    final String m37739d() {
        String a = m37732a(m21047n().c());
        return a == null ? m37735e() : a;
    }

    /* renamed from: e */
    private final String m37735e() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            return !m37734a(m21047n().c(), toLowerCase) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : toLowerCase;
        } catch (Exception e) {
            m21037e("Error saving clientId file", e);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    /* renamed from: a */
    private final java.lang.String m37732a(android.content.Context r7) {
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
        r6 = this;
        r0 = "ClientId should be loaded from worker thread";
        com.google.android.gms.common.internal.C2872v.c(r0);
        r0 = 0;
        r1 = "gaClientId";	 Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0072, all -> 0x006f }
        r1 = r7.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0072, all -> 0x006f }
        r2 = 36;
        r3 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r4 = 0;	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r2 = r1.read(r3, r4, r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r5 = r1.available();	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        if (r5 <= 0) goto L_0x0035;	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
    L_0x001b:
        r2 = "clientId file seems corrupted, deleting it.";	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r6.m21040h(r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r1.close();	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r2 = "gaClientId";	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r7.deleteFile(r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        if (r1 == 0) goto L_0x0034;
    L_0x002a:
        r1.close();	 Catch:{ IOException -> 0x002e }
        goto L_0x0034;
    L_0x002e:
        r7 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.m21037e(r1, r7);
    L_0x0034:
        return r0;
    L_0x0035:
        r5 = 14;
        if (r2 >= r5) goto L_0x0053;
    L_0x0039:
        r2 = "clientId file is empty, deleting it.";	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r6.m21040h(r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r1.close();	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r2 = "gaClientId";	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r7.deleteFile(r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        if (r1 == 0) goto L_0x0052;
    L_0x0048:
        r1.close();	 Catch:{ IOException -> 0x004c }
        goto L_0x0052;
    L_0x004c:
        r7 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.m21037e(r1, r7);
    L_0x0052:
        return r0;
    L_0x0053:
        r1.close();	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r5 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r5.<init>(r3, r4, r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r2 = "Read client id from disk";	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r6.m21026a(r2, r5);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        if (r1 == 0) goto L_0x006c;
    L_0x0062:
        r1.close();	 Catch:{ IOException -> 0x0066 }
        goto L_0x006c;
    L_0x0066:
        r7 = move-exception;
        r0 = "Failed to close client id reading stream";
        r6.m21037e(r0, r7);
    L_0x006c:
        return r5;
    L_0x006d:
        r2 = move-exception;
        goto L_0x0074;
    L_0x006f:
        r7 = move-exception;
        r1 = r0;
        goto L_0x008c;
    L_0x0072:
        r2 = move-exception;
        r1 = r0;
    L_0x0074:
        r3 = "Error reading client id file, deleting it";	 Catch:{ all -> 0x008b }
        r6.m21037e(r3, r2);	 Catch:{ all -> 0x008b }
        r2 = "gaClientId";	 Catch:{ all -> 0x008b }
        r7.deleteFile(r2);	 Catch:{ all -> 0x008b }
        if (r1 == 0) goto L_0x008a;
    L_0x0080:
        r1.close();	 Catch:{ IOException -> 0x0084 }
        goto L_0x008a;
    L_0x0084:
        r7 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.m21037e(r1, r7);
    L_0x008a:
        return r0;
    L_0x008b:
        r7 = move-exception;
    L_0x008c:
        if (r1 == 0) goto L_0x0098;
    L_0x008e:
        r1.close();	 Catch:{ IOException -> 0x0092 }
        goto L_0x0098;
    L_0x0092:
        r0 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.m21037e(r1, r0);
    L_0x0098:
        throw r7;
    L_0x0099:
        r1 = r0;
    L_0x009a:
        if (r1 == 0) goto L_0x00a6;
    L_0x009c:
        r1.close();	 Catch:{ IOException -> 0x00a0 }
        goto L_0x00a6;
    L_0x00a0:
        r7 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.m21037e(r1, r7);
    L_0x00a6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.aj.a(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    private final boolean m37734a(Context context, String str) {
        C2872v.a(str);
        C2872v.c("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            m21026a("Storing clientId", str);
            context = context.openFileOutput("gaClientId", 0);
            try {
                context.write(str.getBytes());
                if (context != null) {
                    try {
                        context.close();
                    } catch (Context context2) {
                        m21037e("Failed to close clientId writing stream", context2);
                    }
                }
                return true;
            } catch (FileNotFoundException e) {
                str = e;
                fileOutputStream = context2;
                m21037e("Error creating clientId file", str);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Context context22) {
                        m21037e("Failed to close clientId writing stream", context22);
                    }
                }
                return false;
            } catch (IOException e2) {
                str = e2;
                fileOutputStream = context22;
                try {
                    m21037e("Error writing to clientId file", str);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Context context222) {
                            m21037e("Failed to close clientId writing stream", context222);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    str = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Context context2222) {
                            m21037e("Failed to close clientId writing stream", context2222);
                        }
                    }
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                fileOutputStream = context2222;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw str;
            }
        } catch (FileNotFoundException e3) {
            str = e3;
            m21037e("Error creating clientId file", str);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (IOException e4) {
            str = e4;
            m21037e("Error writing to clientId file", str);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        }
    }
}
