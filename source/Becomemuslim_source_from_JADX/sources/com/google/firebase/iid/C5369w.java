package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.util.C0463l;
import android.util.Log;
import com.google.android.gms.p186f.C2955h;
import com.google.firebase.iid.ao.C5352a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.firebase.iid.w */
final class C5369w {
    /* renamed from: a */
    private static int f18124a;
    /* renamed from: b */
    private static PendingIntent f18125b;
    /* renamed from: c */
    private final C0463l<String, C2955h<Bundle>> f18126c = new C0463l();
    /* renamed from: d */
    private final Context f18127d;
    /* renamed from: e */
    private final C5366q f18128e;
    /* renamed from: f */
    private Messenger f18129f;
    /* renamed from: g */
    private Messenger f18130g;
    /* renamed from: h */
    private ao f18131h;

    public C5369w(Context context, C5366q c5366q) {
        this.f18127d = context;
        this.f18128e = c5366q;
        this.f18129f = new Messenger(new C6916x(this, Looper.getMainLooper()));
    }

    /* renamed from: a */
    private final void m22791a(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
        } else {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new C5352a());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof ao) {
                    this.f18131h = (ao) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.f18130g = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            String action = intent2.getAction();
            String str;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                CharSequence stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    action = intent2.getStringExtra("error");
                    if (action == null) {
                        message = String.valueOf(intent2.getExtras());
                        StringBuilder stringBuilder = new StringBuilder(String.valueOf(message).length() + 49);
                        stringBuilder.append("Unexpected response, no error or registration id ");
                        stringBuilder.append(message);
                        Log.w("FirebaseInstanceId", stringBuilder.toString());
                    } else {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String str2 = "FirebaseInstanceId";
                            String str3 = "Received InstanceID error ";
                            String valueOf = String.valueOf(action);
                            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                        }
                        if (action.startsWith("|")) {
                            String[] split = action.split("\\|");
                            if (split.length > 2) {
                                if ("ID".equals(split[1])) {
                                    action = split[2];
                                    str = split[3];
                                    if (str.startsWith(":")) {
                                        str = str.substring(1);
                                    }
                                    m22793a(action, intent2.putExtra("error", str).getExtras());
                                }
                            }
                            message = "FirebaseInstanceId";
                            str = "Unexpected structured response ";
                            action = String.valueOf(action);
                            Log.w(message, action.length() != 0 ? str.concat(action) : new String(str));
                        } else {
                            synchronized (this.f18126c) {
                                for (int i = 0; i < this.f18126c.size(); i++) {
                                    m22793a((String) this.f18126c.b(i), intent2.getExtras());
                                }
                            }
                        }
                    }
                } else {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (matcher.matches()) {
                        action = matcher.group(1);
                        str = matcher.group(2);
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", str);
                        m22793a(action, extras);
                        return;
                    }
                    if (Log.isLoggable("FirebaseInstanceId", 3) != null) {
                        message = "FirebaseInstanceId";
                        str = "Unexpected response string: ";
                        action = String.valueOf(stringExtra);
                        Log.d(message, action.length() != 0 ? str.concat(action) : new String(str));
                    }
                    return;
                }
            }
            if (Log.isLoggable("FirebaseInstanceId", 3) != null) {
                message = "FirebaseInstanceId";
                str = "Unexpected response action: ";
                action = String.valueOf(action);
                Log.d(message, action.length() != 0 ? str.concat(action) : new String(str));
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m22790a(Context context, Intent intent) {
        synchronized (C5369w.class) {
            if (f18125b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f18125b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f18125b);
        }
    }

    /* renamed from: a */
    private final void m22793a(String str, Bundle bundle) {
        synchronized (this.f18126c) {
            C2955h c2955h = (C2955h) this.f18126c.remove(str);
            if (c2955h == null) {
                bundle = "FirebaseInstanceId";
                String str2 = "Missing callback for ";
                str = String.valueOf(str);
                Log.w(bundle, str.length() != 0 ? str2.concat(str) : new String(str2));
                return;
            }
            c2955h.a(bundle);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final android.os.Bundle m22796a(android.os.Bundle r6) {
        /*
        r5 = this;
        r0 = r5.f18128e;
        r0 = r0.m22785d();
        r1 = 12000000; // 0xb71b00 float:1.6815582E-38 double:5.9287878E-317;
        if (r0 < r1) goto L_0x0067;
    L_0x000b:
        r0 = r5.f18127d;
        r0 = com.google.firebase.iid.C5356e.m22761a(r0);
        r1 = 1;
        r0 = r0.m22764b(r1, r6);
        r0 = com.google.android.gms.p186f.C2958j.a(r0);	 Catch:{ InterruptedException -> 0x001d, InterruptedException -> 0x001d }
        r0 = (android.os.Bundle) r0;	 Catch:{ InterruptedException -> 0x001d, InterruptedException -> 0x001d }
        return r0;
    L_0x001d:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x004b;
    L_0x0027:
        r1 = "FirebaseInstanceId";
        r2 = java.lang.String.valueOf(r0);
        r3 = java.lang.String.valueOf(r2);
        r3 = r3.length();
        r3 = r3 + 22;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Error making request: ";
        r4.append(r3);
        r4.append(r2);
        r2 = r4.toString();
        android.util.Log.d(r1, r2);
    L_0x004b:
        r1 = r0.getCause();
        r1 = r1 instanceof com.google.firebase.iid.C5365o;
        if (r1 == 0) goto L_0x0065;
    L_0x0053:
        r0 = r0.getCause();
        r0 = (com.google.firebase.iid.C5365o) r0;
        r0 = r0.m22777a();
        r1 = 4;
        if (r0 != r1) goto L_0x0065;
    L_0x0060:
        r6 = r5.m22794b(r6);
        return r6;
    L_0x0065:
        r6 = 0;
        return r6;
    L_0x0067:
        r6 = r5.m22794b(r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.w.a(android.os.Bundle):android.os.Bundle");
    }

    /* renamed from: b */
    private final Bundle m22794b(Bundle bundle) {
        Bundle c = m22795c(bundle);
        if (c == null || !c.containsKey("google.messenger")) {
            return c;
        }
        c = m22795c(bundle);
        return (c == null || c.containsKey("google.messenger") == null) ? c : null;
    }

    /* renamed from: a */
    private static synchronized String m22789a() {
        String num;
        synchronized (C5369w.class) {
            int i = f18124a;
            f18124a = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* renamed from: c */
    private final android.os.Bundle m22795c(android.os.Bundle r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = com.google.firebase.iid.C5369w.m22789a();
        r1 = new com.google.android.gms.f.h;
        r1.<init>();
        r2 = r8.f18126c;
        monitor-enter(r2);
        r3 = r8.f18126c;	 Catch:{ all -> 0x0126 }
        r3.put(r0, r1);	 Catch:{ all -> 0x0126 }
        monitor-exit(r2);	 Catch:{ all -> 0x0126 }
        r2 = r8.f18128e;
        r2 = r2.m22782a();
        if (r2 == 0) goto L_0x011e;
    L_0x001a:
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "com.google.android.gms";
        r2.setPackage(r3);
        r3 = r8.f18128e;
        r3 = r3.m22782a();
        r4 = 2;
        if (r3 != r4) goto L_0x0033;
    L_0x002d:
        r3 = "com.google.iid.TOKEN_REQUEST";
        r2.setAction(r3);
        goto L_0x0038;
    L_0x0033:
        r3 = "com.google.android.c2dm.intent.REGISTER";
        r2.setAction(r3);
    L_0x0038:
        r2.putExtras(r9);
        r9 = r8.f18127d;
        com.google.firebase.iid.C5369w.m22790a(r9, r2);
        r9 = "kid";
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r3 = r3 + 5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r3);
        r3 = "|ID|";
        r5.append(r3);
        r5.append(r0);
        r3 = "|";
        r5.append(r3);
        r3 = r5.toString();
        r2.putExtra(r9, r3);
        r9 = "FirebaseInstanceId";
        r3 = 3;
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x0096;
    L_0x006e:
        r9 = "FirebaseInstanceId";
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
        android.util.Log.d(r9, r5);
    L_0x0096:
        r9 = "google.messenger";
        r5 = r8.f18129f;
        r2.putExtra(r9, r5);
        r9 = r8.f18130g;
        if (r9 != 0) goto L_0x00a5;
    L_0x00a1:
        r9 = r8.f18131h;
        if (r9 == 0) goto L_0x00cb;
    L_0x00a5:
        r9 = android.os.Message.obtain();
        r9.obj = r2;
        r5 = r8.f18130g;	 Catch:{ RemoteException -> 0x00bb }
        if (r5 == 0) goto L_0x00b5;	 Catch:{ RemoteException -> 0x00bb }
    L_0x00af:
        r5 = r8.f18130g;	 Catch:{ RemoteException -> 0x00bb }
        r5.send(r9);	 Catch:{ RemoteException -> 0x00bb }
        goto L_0x00de;	 Catch:{ RemoteException -> 0x00bb }
    L_0x00b5:
        r5 = r8.f18131h;	 Catch:{ RemoteException -> 0x00bb }
        r5.m22726a(r9);	 Catch:{ RemoteException -> 0x00bb }
        goto L_0x00de;
        r9 = "FirebaseInstanceId";
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x00cb;
    L_0x00c4:
        r9 = "FirebaseInstanceId";
        r3 = "Messenger failed, fallback to startService";
        android.util.Log.d(r9, r3);
    L_0x00cb:
        r9 = r8.f18128e;
        r9 = r9.m22782a();
        if (r9 != r4) goto L_0x00d9;
    L_0x00d3:
        r9 = r8.f18127d;
        r9.sendBroadcast(r2);
        goto L_0x00de;
    L_0x00d9:
        r9 = r8.f18127d;
        r9.startService(r2);
    L_0x00de:
        r9 = r1.a();	 Catch:{ InterruptedException -> 0x0102, InterruptedException -> 0x0102, ExecutionException -> 0x00fb }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;	 Catch:{ InterruptedException -> 0x0102, InterruptedException -> 0x0102, ExecutionException -> 0x00fb }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0102, InterruptedException -> 0x0102, ExecutionException -> 0x00fb }
        r9 = com.google.android.gms.p186f.C2958j.a(r9, r1, r3);	 Catch:{ InterruptedException -> 0x0102, InterruptedException -> 0x0102, ExecutionException -> 0x00fb }
        r9 = (android.os.Bundle) r9;	 Catch:{ InterruptedException -> 0x0102, InterruptedException -> 0x0102, ExecutionException -> 0x00fb }
        r1 = r8.f18126c;
        monitor-enter(r1);
        r2 = r8.f18126c;	 Catch:{ all -> 0x00f6 }
        r2.remove(r0);	 Catch:{ all -> 0x00f6 }
        monitor-exit(r1);	 Catch:{ all -> 0x00f6 }
        return r9;	 Catch:{ all -> 0x00f6 }
    L_0x00f6:
        r9 = move-exception;	 Catch:{ all -> 0x00f6 }
        monitor-exit(r1);	 Catch:{ all -> 0x00f6 }
        throw r9;
    L_0x00f9:
        r9 = move-exception;
        goto L_0x0111;
    L_0x00fb:
        r9 = move-exception;
        r1 = new java.io.IOException;	 Catch:{ all -> 0x00f9 }
        r1.<init>(r9);	 Catch:{ all -> 0x00f9 }
        throw r1;	 Catch:{ all -> 0x00f9 }
    L_0x0102:
        r9 = "FirebaseInstanceId";	 Catch:{ all -> 0x00f9 }
        r1 = "No response";	 Catch:{ all -> 0x00f9 }
        android.util.Log.w(r9, r1);	 Catch:{ all -> 0x00f9 }
        r9 = new java.io.IOException;	 Catch:{ all -> 0x00f9 }
        r1 = "TIMEOUT";	 Catch:{ all -> 0x00f9 }
        r9.<init>(r1);	 Catch:{ all -> 0x00f9 }
        throw r9;	 Catch:{ all -> 0x00f9 }
    L_0x0111:
        r1 = r8.f18126c;
        monitor-enter(r1);
        r2 = r8.f18126c;	 Catch:{ all -> 0x011b }
        r2.remove(r0);	 Catch:{ all -> 0x011b }
        monitor-exit(r1);	 Catch:{ all -> 0x011b }
        throw r9;
    L_0x011b:
        r9 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x011b }
        throw r9;
    L_0x011e:
        r9 = new java.io.IOException;
        r0 = "MISSING_INSTANCEID_SERVICE";
        r9.<init>(r0);
        throw r9;
    L_0x0126:
        r9 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0126 }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.w.c(android.os.Bundle):android.os.Bundle");
    }
}
