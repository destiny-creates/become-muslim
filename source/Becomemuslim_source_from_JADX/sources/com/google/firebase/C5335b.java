package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.C0366b;
import android.support.v4.util.C3211a;
import android.util.Log;
import com.google.android.gms.common.api.internal.C2794b;
import com.google.android.gms.common.api.internal.C2794b.C2793a;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.common.util.C2906q;
import com.google.firebase.components.C5340a;
import com.google.firebase.components.C5340a.C53381;
import com.google.firebase.components.C7915m;
import com.google.firebase.p244a.C5322c;
import com.google.firebase.p384c.C6900a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.b */
public class C5335b {
    /* renamed from: a */
    static final Map<String, C5335b> f17972a = new C3211a();
    /* renamed from: b */
    private static final List<String> f17973b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    /* renamed from: c */
    private static final List<String> f17974c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    /* renamed from: d */
    private static final List<String> f17975d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    /* renamed from: e */
    private static final List<String> f17976e = Arrays.asList(new String[0]);
    /* renamed from: f */
    private static final Set<String> f17977f = Collections.emptySet();
    /* renamed from: g */
    private static final Object f17978g = new Object();
    /* renamed from: h */
    private static final Executor f17979h = new C5332d();
    /* renamed from: i */
    private final Context f17980i;
    /* renamed from: j */
    private final String f17981j;
    /* renamed from: k */
    private final C5337c f17982k;
    /* renamed from: l */
    private final C7915m f17983l;
    /* renamed from: m */
    private final SharedPreferences f17984m;
    /* renamed from: n */
    private final C5322c f17985n;
    /* renamed from: o */
    private final AtomicBoolean f17986o = new AtomicBoolean(false);
    /* renamed from: p */
    private final AtomicBoolean f17987p = new AtomicBoolean();
    /* renamed from: q */
    private final AtomicBoolean f17988q;
    /* renamed from: r */
    private final List<Object> f17989r = new CopyOnWriteArrayList();
    /* renamed from: s */
    private final List<C5330a> f17990s = new CopyOnWriteArrayList();
    /* renamed from: t */
    private final List<Object> f17991t = new CopyOnWriteArrayList();
    /* renamed from: u */
    private C5331b f17992u;

    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.b$a */
    public interface C5330a {
        /* renamed from: a */
        void m22595a(boolean z);
    }

    @Deprecated
    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.b$b */
    public interface C5331b {
    }

    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.b$d */
    static class C5332d implements Executor {
        /* renamed from: a */
        private static final Handler f17969a = new Handler(Looper.getMainLooper());

        private C5332d() {
        }

        public final void execute(Runnable runnable) {
            f17969a.post(runnable);
        }
    }

    @TargetApi(24)
    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.b$e */
    static class C5333e extends BroadcastReceiver {
        /* renamed from: a */
        private static AtomicReference<C5333e> f17970a = new AtomicReference();
        /* renamed from: b */
        private final Context f17971b;

        private C5333e(Context context) {
            this.f17971b = context;
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (C5335b.f17978g) {
                for (C5335b a : C5335b.f17972a.values()) {
                    a.m22610j();
                }
            }
            this.f17971b.unregisterReceiver(this);
        }

        /* renamed from: a */
        static /* synthetic */ void m22596a(Context context) {
            if (f17970a.get() == null) {
                BroadcastReceiver c5333e = new C5333e(context);
                if (f17970a.compareAndSet(null, c5333e)) {
                    context.registerReceiver(c5333e, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }
    }

    @TargetApi(14)
    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.b$c */
    static class C6899c implements C2793a {
        /* renamed from: a */
        private static AtomicReference<C6899c> f24718a = new AtomicReference();

        private C6899c() {
        }

        /* renamed from: a */
        public final void m32360a(boolean z) {
            synchronized (C5335b.f17978g) {
                Iterator it = new ArrayList(C5335b.f17972a.values()).iterator();
                while (it.hasNext()) {
                    C5335b c5335b = (C5335b) it.next();
                    if (c5335b.f17986o.get()) {
                        c5335b.m22604a(z);
                    }
                }
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m32359a(Context context) {
            if (C2904o.b()) {
                if (context.getApplicationContext() instanceof Application) {
                    Application application = (Application) context.getApplicationContext();
                    if (f24718a.get() == null) {
                        C2793a c6899c = new C6899c();
                        if (f24718a.compareAndSet(null, c6899c)) {
                            C2794b.a(application);
                            C2794b.a().a(c6899c);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public Context m22611a() {
        m22609i();
        return this.f17980i;
    }

    /* renamed from: b */
    public String m22613b() {
        m22609i();
        return this.f17981j;
    }

    /* renamed from: c */
    public C5337c m22614c() {
        m22609i();
        return this.f17982k;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C5335b) {
            return this.f17981j.equals(((C5335b) obj).m22613b());
        }
        return null;
    }

    public int hashCode() {
        return this.f17981j.hashCode();
    }

    public String toString() {
        return C2868t.a(this).a("name", this.f17981j).a("options", this.f17982k).toString();
    }

    /* renamed from: d */
    public static C5335b m22606d() {
        C5335b c5335b;
        synchronized (f17978g) {
            c5335b = (C5335b) f17972a.get("[DEFAULT]");
            if (c5335b != null) {
            } else {
                StringBuilder stringBuilder = new StringBuilder("Default FirebaseApp is not initialized in this process ");
                stringBuilder.append(C2906q.a());
                stringBuilder.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return c5335b;
    }

    /* renamed from: a */
    public static C5335b m22598a(Context context) {
        synchronized (f17978g) {
            if (f17972a.containsKey("[DEFAULT]")) {
                context = C5335b.m22606d();
                return context;
            }
            C5337c a = C5337c.m22621a(context);
            if (a == null) {
                Log.d("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            context = C5335b.m22599a(context, a);
            return context;
        }
    }

    /* renamed from: a */
    public static C5335b m22599a(Context context, C5337c c5337c) {
        return C5335b.m22600a(context, c5337c, "[DEFAULT]");
    }

    /* renamed from: a */
    public static C5335b m22600a(Context context, C5337c c5337c, String str) {
        C5335b c5335b;
        C6899c.m32359a(context);
        str = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f17978g) {
            boolean containsKey = f17972a.containsKey(str) ^ 1;
            StringBuilder stringBuilder = new StringBuilder("FirebaseApp name ");
            stringBuilder.append(str);
            stringBuilder.append(" already exists!");
            C2872v.a(containsKey, stringBuilder.toString());
            C2872v.a(context, "Application context cannot be null.");
            c5335b = new C5335b(context, str, c5337c);
            f17972a.put(str, c5335b);
        }
        c5335b.m22610j();
        return c5335b;
    }

    /* renamed from: a */
    public <T> T m22612a(Class<T> cls) {
        m22609i();
        return this.f17983l.mo4878a((Class) cls);
    }

    /* renamed from: e */
    public boolean m22615e() {
        m22609i();
        return this.f17988q.get();
    }

    private C5335b(Context context, String str, C5337c c5337c) {
        this.f17980i = (Context) C2872v.a(context);
        this.f17981j = C2872v.a(str);
        this.f17982k = (C5337c) C2872v.a(c5337c);
        this.f17992u = new C6900a();
        this.f17984m = context.getSharedPreferences("com.google.firebase.common.prefs", 0);
        this.f17988q = new AtomicBoolean(m22608h());
        str = C53381.m22624a(context).m22628a();
        this.f17983l = new C7915m(f17979h, str, C5340a.m22637a(context, Context.class, new Class[0]), C5340a.m22637a(this, C5335b.class, new Class[0]), C5340a.m22637a(c5337c, C5337c.class, new Class[0]));
        this.f17985n = (C5322c) this.f17983l.mo4878a(C5322c.class);
    }

    /* renamed from: h */
    private boolean m22608h() {
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
        r4 = this;
        r0 = r4.f17984m;
        r1 = "firebase_data_collection_default_enabled";
        r0 = r0.contains(r1);
        r1 = 1;
        if (r0 == 0) goto L_0x0014;
    L_0x000b:
        r0 = r4.f17984m;
        r2 = "firebase_data_collection_default_enabled";
        r0 = r0.getBoolean(r2, r1);
        return r0;
    L_0x0014:
        r0 = r4.f17980i;	 Catch:{ NameNotFoundException -> 0x0041 }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0041 }
        if (r0 == 0) goto L_0x0041;	 Catch:{ NameNotFoundException -> 0x0041 }
    L_0x001c:
        r2 = r4.f17980i;	 Catch:{ NameNotFoundException -> 0x0041 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0041 }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0041 }
        r0 = r0.getApplicationInfo(r2, r3);	 Catch:{ NameNotFoundException -> 0x0041 }
        if (r0 == 0) goto L_0x0041;	 Catch:{ NameNotFoundException -> 0x0041 }
    L_0x002a:
        r2 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0041 }
        if (r2 == 0) goto L_0x0041;	 Catch:{ NameNotFoundException -> 0x0041 }
    L_0x002e:
        r2 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0041 }
        r3 = "firebase_data_collection_default_enabled";	 Catch:{ NameNotFoundException -> 0x0041 }
        r2 = r2.containsKey(r3);	 Catch:{ NameNotFoundException -> 0x0041 }
        if (r2 == 0) goto L_0x0041;	 Catch:{ NameNotFoundException -> 0x0041 }
    L_0x0038:
        r0 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0041 }
        r2 = "firebase_data_collection_default_enabled";	 Catch:{ NameNotFoundException -> 0x0041 }
        r0 = r0.getBoolean(r2);	 Catch:{ NameNotFoundException -> 0x0041 }
        return r0;
    L_0x0041:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.b.h():boolean");
    }

    /* renamed from: i */
    private void m22609i() {
        C2872v.a(this.f17987p.get() ^ 1, "FirebaseApp was deleted");
    }

    /* renamed from: f */
    public boolean m22616f() {
        return "[DEFAULT]".equals(m22613b());
    }

    /* renamed from: a */
    private void m22604a(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (C5330a a : this.f17990s) {
            a.m22595a(z);
        }
    }

    /* renamed from: j */
    private void m22610j() {
        boolean c = C0366b.c(this.f17980i);
        if (c) {
            C5333e.m22596a(this.f17980i);
        } else {
            this.f17983l.m38513a(m22616f());
        }
        C5335b.m22603a(C5335b.class, this, f17973b, c);
        if (m22616f()) {
            C5335b.m22603a(C5335b.class, this, f17974c, c);
            C5335b.m22603a(Context.class, this.f17980i, f17975d, c);
        }
    }

    /* renamed from: a */
    private static <T> void m22603a(java.lang.Class<T> r6, T r7, java.lang.Iterable<java.lang.String> r8, boolean r9) {
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
        r8 = r8.iterator();
    L_0x0004:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00b4;
    L_0x000a:
        r0 = r8.next();
        r0 = (java.lang.String) r0;
        if (r9 == 0) goto L_0x0021;
    L_0x0012:
        r1 = f17976e;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r1 = r1.contains(r0);	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        if (r1 == 0) goto L_0x0004;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x001a:
        goto L_0x0021;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x001b:
        r1 = move-exception;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        goto L_0x004a;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x001d:
        r0 = move-exception;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        goto L_0x005e;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        goto L_0x007d;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x0021:
        r1 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r2 = "getInstance";	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r4 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r5 = 0;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r4[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r1 = r1.getMethod(r2, r4);	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r2 = r1.getModifiers();	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r4 = java.lang.reflect.Modifier.isPublic(r2);	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        if (r4 == 0) goto L_0x0004;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x003b:
        r2 = java.lang.reflect.Modifier.isStatic(r2);	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        if (r2 == 0) goto L_0x0004;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x0041:
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r3 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r3[r5] = r7;	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r1.invoke(r2, r3);	 Catch:{ ClassNotFoundException -> 0x001f, NoSuchMethodException -> 0x0066, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        goto L_0x0004;
    L_0x004a:
        r2 = "FirebaseApp";
        r3 = new java.lang.StringBuilder;
        r4 = "Failed to initialize ";
        r3.<init>(r4);
        r3.append(r0);
        r0 = r3.toString();
        android.util.Log.wtf(r2, r0, r1);
        goto L_0x0004;
    L_0x005e:
        r1 = "FirebaseApp";
        r2 = "Firebase API initialization failure.";
        android.util.Log.wtf(r1, r2, r0);
        goto L_0x0004;
    L_0x0066:
        r6 = new java.lang.IllegalStateException;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r7.append(r0);
        r8 = "#getInstance has been removed by Proguard. Add keep rule to prevent it.";
        r7.append(r8);
        r7 = r7.toString();
        r6.<init>(r7);
        throw r6;
    L_0x007d:
        r1 = f17977f;
        r1 = r1.contains(r0);
        if (r1 != 0) goto L_0x009d;
    L_0x0085:
        r1 = "FirebaseApp";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = " is not linked. Skipping initialization.";
        r2.append(r0);
        r0 = r2.toString();
        android.util.Log.d(r1, r0);
        goto L_0x0004;
    L_0x009d:
        r6 = new java.lang.IllegalStateException;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r7.append(r0);
        r8 = " is missing, but is required. Check if it has been removed by Proguard.";
        r7.append(r8);
        r7 = r7.toString();
        r6.<init>(r7);
        throw r6;
    L_0x00b4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.b.a(java.lang.Class, java.lang.Object, java.lang.Iterable, boolean):void");
    }
}
