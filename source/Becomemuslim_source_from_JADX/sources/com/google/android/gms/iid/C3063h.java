package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.support.v4.util.C3211a;
import android.util.Log;
import com.google.android.gms.common.util.C2904o;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.iid.h */
public class C3063h {
    /* renamed from: a */
    private static final C3066l<Boolean> f7824a = C3065k.m8972a().mo2604a("gcm_iid_use_messenger_ipc", true);
    /* renamed from: b */
    private static String f7825b = null;
    /* renamed from: c */
    private static boolean f7826c = false;
    /* renamed from: d */
    private static int f7827d = 0;
    /* renamed from: e */
    private static int f7828e = 0;
    /* renamed from: f */
    private static int f7829f = 0;
    /* renamed from: g */
    private static BroadcastReceiver f7830g = null;
    /* renamed from: h */
    private Context f7831h;
    /* renamed from: i */
    private Map<String, Object> f7832i = new C3211a();
    /* renamed from: j */
    private Messenger f7833j;
    /* renamed from: k */
    private Messenger f7834k;
    /* renamed from: l */
    private MessengerCompat f7835l;
    /* renamed from: m */
    private PendingIntent f7836m;

    public C3063h(Context context) {
        this.f7831h = context;
    }

    /* renamed from: a */
    public static boolean m8961a(Context context) {
        if (f7825b != null) {
            C3063h.m8965b(context);
        }
        return f7826c;
    }

    /* renamed from: b */
    public static String m8965b(Context context) {
        if (f7825b != null) {
            return f7825b;
        }
        f7827d = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        boolean z = true;
        if (!C2904o.m8466l()) {
            Object obj;
            for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
                if (C3063h.m8963a(packageManager, resolveInfo.serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    f7826c = false;
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                return f7825b;
            }
        }
        for (ResolveInfo resolveInfo2 : packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0)) {
            if (C3063h.m8963a(packageManager, resolveInfo2.activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                f7826c = true;
                break;
            }
        }
        z = false;
        if (z) {
            return f7825b;
        }
        Log.w("InstanceID", "Failed to resolve IID implementation package, falling back");
        if (C3063h.m8962a(packageManager, "com.google.android.gms")) {
            f7826c = C2904o.m8466l();
            return f7825b;
        } else if (C2904o.m8463i() || C3063h.m8962a(packageManager, "com.google.android.gsf") == null) {
            Log.w("InstanceID", "Google Play services is missing, unable to get tokens");
            return null;
        } else {
            f7826c = false;
            return f7825b;
        }
    }

    /* renamed from: a */
    private static boolean m8963a(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return C3063h.m8962a(packageManager, str);
        }
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 56) + String.valueOf(str2).length());
        stringBuilder.append("Possible malicious package ");
        stringBuilder.append(str);
        stringBuilder.append(" declares ");
        stringBuilder.append(str2);
        stringBuilder.append(" without permission");
        Log.w("InstanceID", stringBuilder.toString());
        return null;
    }

    /* renamed from: a */
    private static boolean m8962a(android.content.pm.PackageManager r1, java.lang.String r2) {
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
        r0 = 0;
        r1 = r1.getApplicationInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x000f }
        r2 = r1.packageName;	 Catch:{ NameNotFoundException -> 0x000f }
        f7825b = r2;	 Catch:{ NameNotFoundException -> 0x000f }
        r1 = r1.uid;	 Catch:{ NameNotFoundException -> 0x000f }
        f7828e = r1;	 Catch:{ NameNotFoundException -> 0x000f }
        r1 = 1;
        return r1;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.h.a(android.content.pm.PackageManager, java.lang.String):boolean");
    }

    /* renamed from: c */
    private static int m8967c(android.content.Context r2) {
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
        r0 = r2.getPackageManager();
        r2 = com.google.android.gms.iid.C3063h.m8965b(r2);	 Catch:{ NameNotFoundException -> 0x0010 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0010 }
        return r2;
    L_0x0010:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.h.c(android.content.Context):int");
    }

    /* renamed from: a */
    public final void m8971a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f7835l = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f7834k = (Messenger) parcelableExtra;
                    }
                }
                m8970a((Intent) message.obj);
                return;
            }
            Log.w("InstanceID", "Dropping invalid message");
        }
    }

    /* renamed from: b */
    private final synchronized void m8966b(Intent intent) {
        if (this.f7836m == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f7836m = PendingIntent.getBroadcast(this.f7831h, 0, intent2, 0);
        }
        intent.putExtra("app", this.f7836m);
    }

    /* renamed from: a */
    static String m8958a(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string == null) {
                string = bundle.getString("unregistered");
            }
            if (string != null) {
                return string;
            }
            string = bundle.getString("error");
            if (string != null) {
                throw new IOException(string);
            }
            bundle = String.valueOf(bundle);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(bundle).length() + 29);
            stringBuilder.append("Unexpected response from GCM ");
            stringBuilder.append(bundle);
            Log.w("InstanceID", stringBuilder.toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* renamed from: a */
    private final void m8960a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f7832i.get(str);
            this.f7832i.put(str, obj);
            C3063h.m8959a(obj2, obj);
        }
    }

    /* renamed from: a */
    private static void m8959a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (Object obj3) {
                obj3 = String.valueOf(obj3);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(obj3).length() + 24);
                stringBuilder.append("Failed to send response ");
                stringBuilder.append(obj3);
                Log.w("InstanceID", stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    public final void m8970a(Intent intent) {
        if (intent == null) {
            if (Log.isLoggable("InstanceID", 3) != null) {
                Log.d("InstanceID", "Unexpected response: null");
            }
            return;
        }
        String action = intent.getAction();
        String str;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
            CharSequence stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                Object stringExtra2 = intent.getStringExtra("error");
                if (stringExtra2 == null) {
                    intent = String.valueOf(intent.getExtras());
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(intent).length() + 49);
                    stringBuilder.append("Unexpected response, no error or registration id ");
                    stringBuilder.append(intent);
                    Log.w("InstanceID", stringBuilder.toString());
                    return;
                }
                String str2;
                String valueOf;
                if (Log.isLoggable("InstanceID", 3)) {
                    str2 = "InstanceID";
                    String str3 = "Received InstanceID error ";
                    valueOf = String.valueOf(stringExtra2);
                    Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
                str2 = null;
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (!"ID".equals(split[1])) {
                        valueOf = "InstanceID";
                        String str4 = "Unexpected structured response ";
                        action = String.valueOf(stringExtra2);
                        Log.w(valueOf, action.length() != 0 ? str4.concat(action) : new String(str4));
                    }
                    if (split.length > 2) {
                        action = split[2];
                        str = split[3];
                        if (str.startsWith(":")) {
                            str = str.substring(1);
                        }
                        str2 = action;
                    } else {
                        str = "UNKNOWN";
                    }
                    stringExtra2 = str;
                    intent.putExtra("error", stringExtra2);
                }
                if (str2 == null) {
                    synchronized (getClass()) {
                        for (String str5 : this.f7832i.keySet()) {
                            Object obj = this.f7832i.get(str5);
                            this.f7832i.put(str5, stringExtra2);
                            C3063h.m8959a(obj, stringExtra2);
                        }
                    }
                    return;
                }
                m8960a(str2, stringExtra2);
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (matcher.matches()) {
                str = matcher.group(1);
                action = matcher.group(2);
                Object extras = intent.getExtras();
                extras.putString("registration_id", action);
                m8960a(str, extras);
                return;
            }
            if (Log.isLoggable("InstanceID", 3) != null) {
                intent = "InstanceID";
                str = "Unexpected response string: ";
                action = String.valueOf(stringExtra);
                Log.d(intent, action.length() != 0 ? str.concat(action) : new String(str));
            }
            return;
        }
        if (Log.isLoggable("InstanceID", 3)) {
            str = "InstanceID";
            action = "Unexpected response ";
            intent = String.valueOf(intent.getAction());
            Log.d(str, intent.length() != 0 ? action.concat(intent) : new String(action));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final android.os.Bundle m8969a(android.os.Bundle r5, java.security.KeyPair r6) {
        /*
        r4 = this;
        r0 = r4.f7831h;
        r0 = com.google.android.gms.iid.C3063h.m8967c(r0);
        r1 = "gmsv";
        r2 = java.lang.Integer.toString(r0);
        r5.putString(r1, r2);
        r1 = "osv";
        r2 = android.os.Build.VERSION.SDK_INT;
        r2 = java.lang.Integer.toString(r2);
        r5.putString(r1, r2);
        r1 = "app_ver";
        r2 = r4.f7831h;
        r2 = com.google.android.gms.iid.C3060a.m8930a(r2);
        r2 = java.lang.Integer.toString(r2);
        r5.putString(r1, r2);
        r1 = "app_ver_name";
        r2 = r4.f7831h;
        r2 = com.google.android.gms.iid.C3060a.m8933b(r2);
        r5.putString(r1, r2);
        r1 = "cliv";
        r2 = "iid-12451000";
        r5.putString(r1, r2);
        r1 = "appid";
        r6 = com.google.android.gms.iid.C3060a.m8932a(r6);
        r5.putString(r1, r6);
        r6 = 12000000; // 0xb71b00 float:1.6815582E-38 double:5.9287878E-317;
        if (r0 < r6) goto L_0x00b4;
    L_0x0049:
        r6 = f7824a;
        r6 = r6.mo2605a();
        r6 = (java.lang.Boolean) r6;
        r6 = r6.booleanValue();
        if (r6 == 0) goto L_0x00b4;
    L_0x0057:
        r6 = new com.google.android.gms.iid.ab;
        r0 = r4.f7831h;
        r6.<init>(r0);
        r0 = 1;
        r6 = r6.m8945a(r0, r5);
        r6 = com.google.android.gms.p186f.C2958j.m8791a(r6);	 Catch:{ InterruptedException -> 0x006a, InterruptedException -> 0x006a }
        r6 = (android.os.Bundle) r6;	 Catch:{ InterruptedException -> 0x006a, InterruptedException -> 0x006a }
        return r6;
    L_0x006a:
        r6 = move-exception;
        r0 = "InstanceID";
        r1 = 3;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0098;
    L_0x0074:
        r0 = "InstanceID";
        r1 = java.lang.String.valueOf(r6);
        r2 = java.lang.String.valueOf(r1);
        r2 = r2.length();
        r2 = r2 + 22;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Error making request: ";
        r3.append(r2);
        r3.append(r1);
        r1 = r3.toString();
        android.util.Log.d(r0, r1);
    L_0x0098:
        r0 = r6.getCause();
        r0 = r0 instanceof com.google.android.gms.iid.C3061c;
        if (r0 == 0) goto L_0x00b2;
    L_0x00a0:
        r6 = r6.getCause();
        r6 = (com.google.android.gms.iid.C3061c) r6;
        r6 = r6.m8956a();
        r0 = 4;
        if (r6 != r0) goto L_0x00b2;
    L_0x00ad:
        r5 = r4.m8964b(r5);
        return r5;
    L_0x00b2:
        r5 = 0;
        return r5;
    L_0x00b4:
        r5 = r4.m8964b(r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.h.a(android.os.Bundle, java.security.KeyPair):android.os.Bundle");
    }

    /* renamed from: b */
    private final Bundle m8964b(Bundle bundle) {
        Bundle c = m8968c(bundle);
        if (c == null || !c.containsKey("google.messenger")) {
            return c;
        }
        c = m8968c(bundle);
        return (c == null || c.containsKey("google.messenger") == null) ? c : null;
    }

    /* renamed from: a */
    private static synchronized String m8957a() {
        String num;
        synchronized (C3063h.class) {
            int i = f7829f;
            f7829f = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* renamed from: c */
    private final android.os.Bundle m8968c(android.os.Bundle r9) {
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
        r8 = this;
        r0 = new android.os.ConditionVariable;
        r0.<init>();
        r1 = com.google.android.gms.iid.C3063h.m8957a();
        r2 = r8.getClass();
        monitor-enter(r2);
        r3 = r8.f7832i;	 Catch:{ all -> 0x01dc }
        r3.put(r1, r0);	 Catch:{ all -> 0x01dc }
        monitor-exit(r2);	 Catch:{ all -> 0x01dc }
        r2 = r8.f7833j;
        if (r2 != 0) goto L_0x002d;
    L_0x0018:
        r2 = r8.f7831h;
        com.google.android.gms.iid.C3063h.m8965b(r2);
        r2 = new android.os.Messenger;
        r3 = new com.google.android.gms.iid.i;
        r4 = android.os.Looper.getMainLooper();
        r3.<init>(r8, r4);
        r2.<init>(r3);
        r8.f7833j = r2;
    L_0x002d:
        r2 = f7825b;
        if (r2 == 0) goto L_0x01d4;
    L_0x0031:
        r2 = new android.content.Intent;
        r3 = f7826c;
        if (r3 == 0) goto L_0x003a;
    L_0x0037:
        r3 = "com.google.iid.TOKEN_REQUEST";
        goto L_0x003c;
    L_0x003a:
        r3 = "com.google.android.c2dm.intent.REGISTER";
    L_0x003c:
        r2.<init>(r3);
        r3 = f7825b;
        r2.setPackage(r3);
        r2.putExtras(r9);
        r8.m8966b(r2);
        r9 = "kid";
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r3 = r3 + 5;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "|ID|";
        r4.append(r3);
        r4.append(r1);
        r3 = "|";
        r4.append(r3);
        r3 = r4.toString();
        r2.putExtra(r9, r3);
        r9 = "X-kid";
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r3 = r3 + 5;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "|ID|";
        r4.append(r3);
        r4.append(r1);
        r3 = "|";
        r4.append(r3);
        r3 = r4.toString();
        r2.putExtra(r9, r3);
        r9 = "com.google.android.gsf";
        r3 = f7825b;
        r9 = r9.equals(r3);
        r3 = "useGsf";
        r3 = r2.getStringExtra(r3);
        if (r3 == 0) goto L_0x00aa;
    L_0x00a4:
        r9 = "1";
        r9 = r9.equals(r3);
    L_0x00aa:
        r3 = "InstanceID";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x00db;
    L_0x00b3:
        r3 = "InstanceID";
        r5 = r2.getExtras();
        r5 = java.lang.String.valueOf(r5);
        r6 = java.lang.String.valueOf(r5);
        r6 = r6.length();
        r6 = r6 + 8;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Sending ";
        r7.append(r6);
        r7.append(r5);
        r5 = r7.toString();
        android.util.Log.d(r3, r5);
    L_0x00db:
        r3 = r8.f7834k;
        if (r3 == 0) goto L_0x0102;
    L_0x00df:
        r3 = "google.messenger";
        r5 = r8.f7833j;
        r2.putExtra(r3, r5);
        r3 = android.os.Message.obtain();
        r3.obj = r2;
        r5 = r8.f7834k;	 Catch:{ RemoteException -> 0x00f3 }
        r5.send(r3);	 Catch:{ RemoteException -> 0x00f3 }
        goto L_0x0181;
    L_0x00f3:
        r3 = "InstanceID";
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x0102;
    L_0x00fb:
        r3 = "InstanceID";
        r5 = "Messenger failed, fallback to startService";
        android.util.Log.d(r3, r5);
    L_0x0102:
        if (r9 == 0) goto L_0x0145;
    L_0x0104:
        r9 = com.google.android.gms.iid.C3063h.class;
        monitor-enter(r9);
        r3 = f7830g;	 Catch:{ all -> 0x0142 }
        if (r3 != 0) goto L_0x013b;	 Catch:{ all -> 0x0142 }
    L_0x010b:
        r3 = new com.google.android.gms.iid.j;	 Catch:{ all -> 0x0142 }
        r3.<init>(r8);	 Catch:{ all -> 0x0142 }
        f7830g = r3;	 Catch:{ all -> 0x0142 }
        r3 = "InstanceID";	 Catch:{ all -> 0x0142 }
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ all -> 0x0142 }
        if (r3 == 0) goto L_0x0121;	 Catch:{ all -> 0x0142 }
    L_0x011a:
        r3 = "InstanceID";	 Catch:{ all -> 0x0142 }
        r4 = "Registered GSF callback receiver";	 Catch:{ all -> 0x0142 }
        android.util.Log.d(r3, r4);	 Catch:{ all -> 0x0142 }
    L_0x0121:
        r3 = new android.content.IntentFilter;	 Catch:{ all -> 0x0142 }
        r4 = "com.google.android.c2dm.intent.REGISTRATION";	 Catch:{ all -> 0x0142 }
        r3.<init>(r4);	 Catch:{ all -> 0x0142 }
        r4 = r8.f7831h;	 Catch:{ all -> 0x0142 }
        r4 = r4.getPackageName();	 Catch:{ all -> 0x0142 }
        r3.addCategory(r4);	 Catch:{ all -> 0x0142 }
        r4 = r8.f7831h;	 Catch:{ all -> 0x0142 }
        r5 = f7830g;	 Catch:{ all -> 0x0142 }
        r6 = "com.google.android.c2dm.permission.SEND";	 Catch:{ all -> 0x0142 }
        r7 = 0;	 Catch:{ all -> 0x0142 }
        r4.registerReceiver(r5, r3, r6, r7);	 Catch:{ all -> 0x0142 }
    L_0x013b:
        monitor-exit(r9);	 Catch:{ all -> 0x0142 }
        r9 = r8.f7831h;
        r9.sendBroadcast(r2);
        goto L_0x0181;
    L_0x0142:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0142 }
        throw r0;
    L_0x0145:
        r9 = "google.messenger";
        r3 = r8.f7833j;
        r2.putExtra(r9, r3);
        r9 = "messenger2";
        r3 = "1";
        r2.putExtra(r9, r3);
        r9 = r8.f7835l;
        if (r9 == 0) goto L_0x0172;
    L_0x0157:
        r9 = android.os.Message.obtain();
        r9.obj = r2;
        r3 = r8.f7835l;	 Catch:{ RemoteException -> 0x0163 }
        r3.m14712a(r9);	 Catch:{ RemoteException -> 0x0163 }
        goto L_0x0181;
    L_0x0163:
        r9 = "InstanceID";
        r9 = android.util.Log.isLoggable(r9, r4);
        if (r9 == 0) goto L_0x0172;
    L_0x016b:
        r9 = "InstanceID";
        r3 = "Messenger failed, fallback to startService";
        android.util.Log.d(r9, r3);
    L_0x0172:
        r9 = f7826c;
        if (r9 == 0) goto L_0x017c;
    L_0x0176:
        r9 = r8.f7831h;
        r9.sendBroadcast(r2);
        goto L_0x0181;
    L_0x017c:
        r9 = r8.f7831h;
        r9.startService(r2);
    L_0x0181:
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.block(r2);
        r9 = r8.getClass();
        monitor-enter(r9);
        r0 = r8.f7832i;	 Catch:{ all -> 0x01d1 }
        r0 = r0.remove(r1);	 Catch:{ all -> 0x01d1 }
        r1 = r0 instanceof android.os.Bundle;	 Catch:{ all -> 0x01d1 }
        if (r1 == 0) goto L_0x0199;	 Catch:{ all -> 0x01d1 }
    L_0x0195:
        r0 = (android.os.Bundle) r0;	 Catch:{ all -> 0x01d1 }
        monitor-exit(r9);	 Catch:{ all -> 0x01d1 }
        return r0;	 Catch:{ all -> 0x01d1 }
    L_0x0199:
        r1 = r0 instanceof java.lang.String;	 Catch:{ all -> 0x01d1 }
        if (r1 == 0) goto L_0x01a5;	 Catch:{ all -> 0x01d1 }
    L_0x019d:
        r1 = new java.io.IOException;	 Catch:{ all -> 0x01d1 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x01d1 }
        r1.<init>(r0);	 Catch:{ all -> 0x01d1 }
        throw r1;	 Catch:{ all -> 0x01d1 }
    L_0x01a5:
        r1 = "InstanceID";	 Catch:{ all -> 0x01d1 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x01d1 }
        r2 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x01d1 }
        r2 = r2.length();	 Catch:{ all -> 0x01d1 }
        r2 = r2 + 12;	 Catch:{ all -> 0x01d1 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01d1 }
        r3.<init>(r2);	 Catch:{ all -> 0x01d1 }
        r2 = "No response ";	 Catch:{ all -> 0x01d1 }
        r3.append(r2);	 Catch:{ all -> 0x01d1 }
        r3.append(r0);	 Catch:{ all -> 0x01d1 }
        r0 = r3.toString();	 Catch:{ all -> 0x01d1 }
        android.util.Log.w(r1, r0);	 Catch:{ all -> 0x01d1 }
        r0 = new java.io.IOException;	 Catch:{ all -> 0x01d1 }
        r1 = "TIMEOUT";	 Catch:{ all -> 0x01d1 }
        r0.<init>(r1);	 Catch:{ all -> 0x01d1 }
        throw r0;	 Catch:{ all -> 0x01d1 }
    L_0x01d1:
        r0 = move-exception;	 Catch:{ all -> 0x01d1 }
        monitor-exit(r9);	 Catch:{ all -> 0x01d1 }
        throw r0;
    L_0x01d4:
        r9 = new java.io.IOException;
        r0 = "MISSING_INSTANCEID_SERVICE";
        r9.<init>(r0);
        throw r9;
    L_0x01dc:
        r9 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x01dc }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.h.c(android.os.Bundle):android.os.Bundle");
    }
}
