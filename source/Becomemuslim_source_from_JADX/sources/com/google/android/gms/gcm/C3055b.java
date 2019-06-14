package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.util.C3211a;
import android.util.Log;
import com.amplitude.api.Constants;
import com.google.android.gms.iid.C3060a;
import com.google.android.gms.iid.C3063h;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* renamed from: com.google.android.gms.gcm.b */
public class C3055b {
    /* renamed from: a */
    private static C3055b f7783a;
    /* renamed from: e */
    private static final AtomicInteger f7784e = new AtomicInteger(1);
    /* renamed from: b */
    private Context f7785b;
    /* renamed from: c */
    private PendingIntent f7786c;
    /* renamed from: d */
    private final Map<String, Handler> f7787d = Collections.synchronizedMap(new C3211a());
    /* renamed from: f */
    private final BlockingQueue<Intent> f7788f = new LinkedBlockingQueue();
    /* renamed from: g */
    private final Messenger f7789g = new Messenger(new C4427e(this, Looper.getMainLooper()));

    @Deprecated
    /* renamed from: a */
    public static synchronized C3055b m8915a(Context context) {
        synchronized (C3055b.class) {
            if (f7783a == null) {
                C3055b.m8921b(context);
                C3055b c3055b = new C3055b();
                f7783a = c3055b;
                c3055b.f7785b = context.getApplicationContext();
            }
            context = f7783a;
        }
        return context;
    }

    /* renamed from: b */
    static void m8921b(Context context) {
        context = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(context).length() + 48);
        stringBuilder.append("GCM SDK is deprecated, ");
        stringBuilder.append(context);
        stringBuilder.append(" should update to use FCM");
        Log.w("GCM", stringBuilder.toString());
    }

    /* renamed from: a */
    private final boolean m8918a(Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.f7787d.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return null;
    }

    @Deprecated
    /* renamed from: a */
    public synchronized String m8924a(String... strArr) {
        return m8916a(C3063h.m8961a(this.f7785b), strArr);
    }

    @Deprecated
    /* renamed from: a */
    private final synchronized String m8916a(boolean z, String... strArr) {
        String b = C3063h.m8965b(this.f7785b);
        if (b == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } else if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        } else {
            StringBuilder stringBuilder = new StringBuilder(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                stringBuilder.append(',');
                stringBuilder.append(strArr[i]);
            }
            strArr = stringBuilder.toString();
            Bundle bundle = new Bundle();
            if (b.contains(".gsf")) {
                bundle.putString("legacy.sender", strArr);
                return C3060a.m8934c(this.f7785b).m8938a(strArr, "GCM", bundle);
            }
            bundle.putString("sender", strArr);
            z = m8914a(bundle, z);
            strArr = "registration_id";
            if (z) {
                strArr = z.getStringExtra(strArr);
                if (strArr != null) {
                    return strArr;
                }
                z = z.getStringExtra("error");
                if (z) {
                    throw new IOException(z);
                }
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    @Deprecated
    /* renamed from: a */
    private final Intent m8914a(Bundle bundle, boolean z) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (C3055b.m8923c(this.f7785b) >= 0) {
            Intent intent = new Intent(z ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(C3063h.m8965b(this.f7785b));
            m8922b(intent);
            int andIncrement = f7784e.getAndIncrement();
            StringBuilder stringBuilder = new StringBuilder(21);
            stringBuilder.append("google.rpc");
            stringBuilder.append(andIncrement);
            intent.putExtra("google.message_id", stringBuilder.toString());
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.f7789g);
            if (z) {
                this.f7785b.sendBroadcast(intent);
            } else {
                this.f7785b.startService(intent);
            }
            try {
                return (Intent) this.f7788f.poll(Constants.EVENT_UPLOAD_PERIOD_MILLIS, TimeUnit.MILLISECONDS);
            } catch (Bundle bundle2) {
                throw new IOException(bundle2.getMessage());
            }
        } else {
            throw new IOException("Google Play Services missing");
        }
    }

    /* renamed from: b */
    private final synchronized void m8922b(Intent intent) {
        if (this.f7786c == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f7786c = PendingIntent.getBroadcast(this.f7785b, 0, intent2, 0);
        }
        intent.putExtra("app", this.f7786c);
    }

    /* renamed from: c */
    public static int m8923c(android.content.Context r2) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = com.google.android.gms.iid.C3063h.m8965b(r2);
        if (r0 == 0) goto L_0x0014;
    L_0x0006:
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0014 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r2.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0014 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ NameNotFoundException -> 0x0014 }
    L_0x0011:
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.b.c(android.content.Context):int");
    }
}
