package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings.Secure;
import android.support.v4.app.C0341x.C3188a;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: NotificationManagerCompat */
public final class af {
    /* renamed from: a */
    private static final Object f750a = new Object();
    /* renamed from: b */
    private static String f751b;
    /* renamed from: c */
    private static Set<String> f752c = new HashSet();
    /* renamed from: f */
    private static final Object f753f = new Object();
    /* renamed from: g */
    private static C0284d f754g;
    /* renamed from: d */
    private final Context f755d;
    /* renamed from: e */
    private final NotificationManager f756e = ((NotificationManager) this.f755d.getSystemService("notification"));

    /* compiled from: NotificationManagerCompat */
    /* renamed from: android.support.v4.app.af$c */
    private static class C0282c {
        /* renamed from: a */
        final ComponentName f738a;
        /* renamed from: b */
        final IBinder f739b;

        C0282c(ComponentName componentName, IBinder iBinder) {
            this.f738a = componentName;
            this.f739b = iBinder;
        }
    }

    /* compiled from: NotificationManagerCompat */
    /* renamed from: android.support.v4.app.af$d */
    private static class C0284d implements ServiceConnection, Callback {
        /* renamed from: a */
        private final Context f745a;
        /* renamed from: b */
        private final HandlerThread f746b;
        /* renamed from: c */
        private final Handler f747c;
        /* renamed from: d */
        private final Map<ComponentName, C0283a> f748d = new HashMap();
        /* renamed from: e */
        private Set<String> f749e = new HashSet();

        /* compiled from: NotificationManagerCompat */
        /* renamed from: android.support.v4.app.af$d$a */
        private static class C0283a {
            /* renamed from: a */
            final ComponentName f740a;
            /* renamed from: b */
            boolean f741b = false;
            /* renamed from: c */
            C0341x f742c;
            /* renamed from: d */
            ArrayDeque<C0285e> f743d = new ArrayDeque();
            /* renamed from: e */
            int f744e = 0;

            C0283a(ComponentName componentName) {
                this.f740a = componentName;
            }
        }

        C0284d(Context context) {
            this.f745a = context;
            this.f746b = new HandlerThread("NotificationManagerCompat");
            this.f746b.start();
            this.f747c = new Handler(this.f746b.getLooper(), this);
        }

        /* renamed from: a */
        public void m824a(C0285e c0285e) {
            this.f747c.obtainMessage(0, c0285e).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    m821b((C0285e) message.obj);
                    return true;
                case 1:
                    C0282c c0282c = (C0282c) message.obj;
                    m817a(c0282c.f738a, c0282c.f739b);
                    return true;
                case 2:
                    m816a((ComponentName) message.obj);
                    return true;
                case 3:
                    m819b((ComponentName) message.obj);
                    return true;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        private void m821b(C0285e c0285e) {
            m815a();
            for (C0283a c0283a : this.f748d.values()) {
                c0283a.f743d.add(c0285e);
                m823d(c0283a);
            }
        }

        /* renamed from: a */
        private void m817a(ComponentName componentName, IBinder iBinder) {
            C0283a c0283a = (C0283a) this.f748d.get(componentName);
            if (c0283a != null) {
                c0283a.f742c = C3188a.m9647a(iBinder);
                c0283a.f744e = null;
                m823d(c0283a);
            }
        }

        /* renamed from: a */
        private void m816a(ComponentName componentName) {
            C0283a c0283a = (C0283a) this.f748d.get(componentName);
            if (c0283a != null) {
                m820b(c0283a);
            }
        }

        /* renamed from: b */
        private void m819b(ComponentName componentName) {
            C0283a c0283a = (C0283a) this.f748d.get(componentName);
            if (c0283a != null) {
                m823d(c0283a);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Connected to service ");
                stringBuilder.append(componentName);
                Log.d("NotifManCompat", stringBuilder.toString());
            }
            this.f747c.obtainMessage(1, new C0282c(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Disconnected from service ");
                stringBuilder.append(componentName);
                Log.d("NotifManCompat", stringBuilder.toString());
            }
            this.f747c.obtainMessage(2, componentName).sendToTarget();
        }

        /* renamed from: a */
        private void m815a() {
            Set b = af.m829b(this.f745a);
            if (!b.equals(this.f749e)) {
                StringBuilder stringBuilder;
                this.f749e = b;
                List<ResolveInfo> queryIntentServices = this.f745a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                Set<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (b.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Permission present on component ");
                            stringBuilder.append(componentName);
                            stringBuilder.append(", not adding listener record.");
                            Log.w("NotifManCompat", stringBuilder.toString());
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f748d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Adding listener record for ");
                            stringBuilder2.append(componentName2);
                            Log.d("NotifManCompat", stringBuilder2.toString());
                        }
                        this.f748d.put(componentName2, new C0283a(componentName2));
                    }
                }
                Iterator it = this.f748d.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Removing listener record for ");
                            stringBuilder.append(entry.getKey());
                            Log.d("NotifManCompat", stringBuilder.toString());
                        }
                        m820b((C0283a) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: a */
        private boolean m818a(C0283a c0283a) {
            if (c0283a.f741b) {
                return true;
            }
            c0283a.f741b = this.f745a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(c0283a.f740a), this, 33);
            if (c0283a.f741b) {
                c0283a.f744e = 0;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to bind to listener ");
                stringBuilder.append(c0283a.f740a);
                Log.w("NotifManCompat", stringBuilder.toString());
                this.f745a.unbindService(this);
            }
            return c0283a.f741b;
        }

        /* renamed from: b */
        private void m820b(C0283a c0283a) {
            if (c0283a.f741b) {
                this.f745a.unbindService(this);
                c0283a.f741b = false;
            }
            c0283a.f742c = null;
        }

        /* renamed from: c */
        private void m822c(C0283a c0283a) {
            if (!this.f747c.hasMessages(3, c0283a.f740a)) {
                c0283a.f744e++;
                if (c0283a.f744e > 6) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Giving up on delivering ");
                    stringBuilder.append(c0283a.f743d.size());
                    stringBuilder.append(" tasks to ");
                    stringBuilder.append(c0283a.f740a);
                    stringBuilder.append(" after ");
                    stringBuilder.append(c0283a.f744e);
                    stringBuilder.append(" retries");
                    Log.w("NotifManCompat", stringBuilder.toString());
                    c0283a.f743d.clear();
                    return;
                }
                int i = (1 << (c0283a.f744e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Scheduling retry for ");
                    stringBuilder2.append(i);
                    stringBuilder2.append(" ms");
                    Log.d("NotifManCompat", stringBuilder2.toString());
                }
                this.f747c.sendMessageDelayed(this.f747c.obtainMessage(3, c0283a.f740a), (long) i);
            }
        }

        /* renamed from: d */
        private void m823d(android.support.v4.app.af.C0284d.C0283a r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r5 = this;
            r0 = "NotifManCompat";
            r1 = 3;
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x0034;
        L_0x0009:
            r0 = "NotifManCompat";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "Processing component ";
            r2.append(r3);
            r3 = r6.f740a;
            r2.append(r3);
            r3 = ", ";
            r2.append(r3);
            r3 = r6.f743d;
            r3 = r3.size();
            r2.append(r3);
            r3 = " queued tasks";
            r2.append(r3);
            r2 = r2.toString();
            android.util.Log.d(r0, r2);
        L_0x0034:
            r0 = r6.f743d;
            r0 = r0.isEmpty();
            if (r0 == 0) goto L_0x003d;
        L_0x003c:
            return;
        L_0x003d:
            r0 = r5.m818a(r6);
            if (r0 == 0) goto L_0x00c4;
        L_0x0043:
            r0 = r6.f742c;
            if (r0 != 0) goto L_0x0049;
        L_0x0047:
            goto L_0x00c4;
        L_0x0049:
            r0 = r6.f743d;
            r0 = r0.peek();
            r0 = (android.support.v4.app.af.C0285e) r0;
            if (r0 != 0) goto L_0x0054;
        L_0x0053:
            goto L_0x00b8;
        L_0x0054:
            r2 = "NotifManCompat";	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r2 = android.util.Log.isLoggable(r2, r1);	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            if (r2 == 0) goto L_0x0072;	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
        L_0x005c:
            r2 = "NotifManCompat";	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r3 = new java.lang.StringBuilder;	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r3.<init>();	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r4 = "Sending task ";	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r3.append(r4);	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r3.append(r0);	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r3 = r3.toString();	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            android.util.Log.d(r2, r3);	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
        L_0x0072:
            r2 = r6.f742c;	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r0.mo180a(r2);	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r0 = r6.f743d;	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            r0.remove();	 Catch:{ DeadObjectException -> 0x0097, RemoteException -> 0x007d }
            goto L_0x0049;
        L_0x007d:
            r0 = move-exception;
            r1 = "NotifManCompat";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "RemoteException communicating with ";
            r2.append(r3);
            r3 = r6.f740a;
            r2.append(r3);
            r2 = r2.toString();
            android.util.Log.w(r1, r2, r0);
            goto L_0x00b8;
            r0 = "NotifManCompat";
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x00b8;
        L_0x00a0:
            r0 = "NotifManCompat";
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Remote service has died: ";
            r1.append(r2);
            r2 = r6.f740a;
            r1.append(r2);
            r1 = r1.toString();
            android.util.Log.d(r0, r1);
        L_0x00b8:
            r0 = r6.f743d;
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x00c3;
        L_0x00c0:
            r5.m822c(r6);
        L_0x00c3:
            return;
        L_0x00c4:
            r5.m822c(r6);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.af.d.d(android.support.v4.app.af$d$a):void");
        }
    }

    /* compiled from: NotificationManagerCompat */
    /* renamed from: android.support.v4.app.af$e */
    private interface C0285e {
        /* renamed from: a */
        void mo180a(C0341x c0341x);
    }

    /* compiled from: NotificationManagerCompat */
    /* renamed from: android.support.v4.app.af$a */
    private static class C3173a implements C0285e {
        /* renamed from: a */
        final String f8141a;
        /* renamed from: b */
        final int f8142b;
        /* renamed from: c */
        final String f8143c;
        /* renamed from: d */
        final boolean f8144d = null;

        C3173a(String str, int i, String str2) {
            this.f8141a = str;
            this.f8142b = i;
            this.f8143c = str2;
        }

        /* renamed from: a */
        public void mo180a(C0341x c0341x) {
            if (this.f8144d) {
                c0341x.mo215a(this.f8141a);
            } else {
                c0341x.mo216a(this.f8141a, this.f8142b, this.f8143c);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.f8141a);
            stringBuilder.append(", id:");
            stringBuilder.append(this.f8142b);
            stringBuilder.append(", tag:");
            stringBuilder.append(this.f8143c);
            stringBuilder.append(", all:");
            stringBuilder.append(this.f8144d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: NotificationManagerCompat */
    /* renamed from: android.support.v4.app.af$b */
    private static class C3174b implements C0285e {
        /* renamed from: a */
        final String f8145a;
        /* renamed from: b */
        final int f8146b;
        /* renamed from: c */
        final String f8147c;
        /* renamed from: d */
        final Notification f8148d;

        C3174b(String str, int i, String str2, Notification notification) {
            this.f8145a = str;
            this.f8146b = i;
            this.f8147c = str2;
            this.f8148d = notification;
        }

        /* renamed from: a */
        public void mo180a(C0341x c0341x) {
            c0341x.mo217a(this.f8145a, this.f8146b, this.f8147c, this.f8148d);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.f8145a);
            stringBuilder.append(", id:");
            stringBuilder.append(this.f8146b);
            stringBuilder.append(", tag:");
            stringBuilder.append(this.f8147c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* renamed from: a */
    public static af m826a(Context context) {
        return new af(context);
    }

    private af(Context context) {
        this.f755d = context;
    }

    /* renamed from: a */
    public void m830a(int i) {
        m832a(null, i);
    }

    /* renamed from: a */
    public void m832a(String str, int i) {
        this.f756e.cancel(str, i);
        if (VERSION.SDK_INT <= 19) {
            m827a(new C3173a(this.f755d.getPackageName(), i, str));
        }
    }

    /* renamed from: a */
    public void m831a(int i, Notification notification) {
        m833a(null, i, notification);
    }

    /* renamed from: a */
    public void m833a(String str, int i, Notification notification) {
        if (m828a(notification)) {
            m827a(new C3174b(this.f755d.getPackageName(), i, str, notification));
            this.f756e.cancel(str, i);
            return;
        }
        this.f756e.notify(str, i, notification);
    }

    /* renamed from: a */
    public boolean m834a() {
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
        r11 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 24;
        if (r0 < r1) goto L_0x000d;
    L_0x0006:
        r0 = r11.f756e;
        r0 = r0.areNotificationsEnabled();
        return r0;
    L_0x000d:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        r2 = 1;
        if (r0 < r1) goto L_0x0083;
    L_0x0014:
        r0 = r11.f755d;
        r1 = "appops";
        r0 = r0.getSystemService(r1);
        r0 = (android.app.AppOpsManager) r0;
        r1 = r11.f755d;
        r1 = r1.getApplicationInfo();
        r3 = r11.f755d;
        r3 = r3.getApplicationContext();
        r3 = r3.getPackageName();
        r1 = r1.uid;
        r4 = android.app.AppOpsManager.class;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r4 = r4.getName();	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r4 = java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r5 = "checkOpNoThrow";	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r6 = 3;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r7 = new java.lang.Class[r6];	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r9 = 0;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r7[r9] = r8;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r7[r2] = r8;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r8 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r10 = 2;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r7[r10] = r8;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r5 = r4.getMethod(r5, r7);	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r7 = "OP_POST_NOTIFICATION";	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r4 = r4.getDeclaredField(r7);	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r7 = java.lang.Integer.class;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r4 = r4.get(r7);	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r4 = (java.lang.Integer) r4;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r4 = r4.intValue();	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r6 = new java.lang.Object[r6];	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r6[r9] = r4;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r6[r2] = r1;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r6[r10] = r3;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r0 = r5.invoke(r0, r6);	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r0 = (java.lang.Integer) r0;	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        r0 = r0.intValue();	 Catch:{ ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082 }
        if (r0 != 0) goto L_0x0080;
    L_0x007f:
        goto L_0x0081;
    L_0x0080:
        r2 = 0;
    L_0x0081:
        return r2;
    L_0x0082:
        return r2;
    L_0x0083:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.af.a():boolean");
    }

    /* renamed from: b */
    public static Set<String> m829b(Context context) {
        context = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f750a) {
            if (context != null) {
                if (!context.equals(f751b)) {
                    String[] split = context.split(":");
                    Set hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f752c = hashSet;
                    f751b = context;
                }
            }
        }
        return f752c;
    }

    /* renamed from: a */
    private static boolean m828a(Notification notification) {
        notification = ac.m809a(notification);
        return (notification == null || notification.getBoolean("android.support.useSideChannel") == null) ? null : true;
    }

    /* renamed from: a */
    private void m827a(C0285e c0285e) {
        synchronized (f753f) {
            if (f754g == null) {
                f754g = new C0284d(this.f755d.getApplicationContext());
            }
            f754g.m824a(c0285e);
        }
    }
}
