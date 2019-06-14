package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.api.C2784d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2859l.C2858a;
import com.google.android.gms.common.internal.C2864q.C4372a;
import com.google.android.gms.common.internal.C2865r.C4374a.C4373a;
import com.google.android.gms.internal.p206e.C4962e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.d */
public abstract class C2850d<T extends IInterface> {
    /* renamed from: d */
    public static final String[] f7263d = new String[]{"service_esmobile", "service_googleme"};
    /* renamed from: e */
    private static final C4776d[] f7264e = new C4776d[0];
    /* renamed from: A */
    private C4775b f7265A;
    /* renamed from: B */
    private boolean f7266B;
    /* renamed from: C */
    private volatile aq f7267C;
    /* renamed from: a */
    final Handler f7268a;
    /* renamed from: b */
    protected C2846c f7269b;
    /* renamed from: c */
    protected AtomicInteger f7270c;
    /* renamed from: f */
    private int f7271f;
    /* renamed from: g */
    private long f7272g;
    /* renamed from: h */
    private long f7273h;
    /* renamed from: i */
    private int f7274i;
    /* renamed from: j */
    private long f7275j;
    /* renamed from: k */
    private aw f7276k;
    /* renamed from: l */
    private final Context f7277l;
    /* renamed from: m */
    private final Looper f7278m;
    /* renamed from: n */
    private final C2859l f7279n;
    /* renamed from: o */
    private final C2830f f7280o;
    /* renamed from: p */
    private final Object f7281p;
    /* renamed from: q */
    private final Object f7282q;
    /* renamed from: r */
    private C2865r f7283r;
    /* renamed from: s */
    private T f7284s;
    /* renamed from: t */
    private final ArrayList<C2848h<?>> f7285t;
    /* renamed from: u */
    private C2849j f7286u;
    /* renamed from: v */
    private int f7287v;
    /* renamed from: w */
    private final C2844a f7288w;
    /* renamed from: x */
    private final C2845b f7289x;
    /* renamed from: y */
    private final int f7290y;
    /* renamed from: z */
    private final String f7291z;

    /* renamed from: com.google.android.gms.common.internal.d$a */
    public interface C2844a {
        /* renamed from: a */
        void mo2462a(int i);

        /* renamed from: a */
        void mo2463a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.internal.d$b */
    public interface C2845b {
        /* renamed from: a */
        void mo2464a(C4775b c4775b);
    }

    /* renamed from: com.google.android.gms.common.internal.d$c */
    public interface C2846c {
        /* renamed from: a */
        void mo2393a(C4775b c4775b);
    }

    /* renamed from: com.google.android.gms.common.internal.d$e */
    public interface C2847e {
        /* renamed from: a */
        void mo2425a();
    }

    /* renamed from: com.google.android.gms.common.internal.d$h */
    protected abstract class C2848h<TListener> {
        /* renamed from: a */
        private TListener f7258a;
        /* renamed from: b */
        private boolean f7259b = null;
        /* renamed from: c */
        private final /* synthetic */ C2850d f7260c;

        public C2848h(C2850d c2850d, TListener tListener) {
            this.f7260c = c2850d;
            this.f7258a = tListener;
        }

        /* renamed from: a */
        protected abstract void mo2477a(TListener tListener);

        /* renamed from: b */
        protected abstract void mo2478b();

        /* renamed from: c */
        public final void m8251c() {
            synchronized (this) {
                Object obj = this.f7258a;
                if (this.f7259b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    stringBuilder.append("Callback proxy ");
                    stringBuilder.append(valueOf);
                    stringBuilder.append(" being reused. This is not safe.");
                    Log.w("GmsClient", stringBuilder.toString());
                }
            }
            if (obj != null) {
                try {
                    mo2477a(obj);
                } catch (RuntimeException e) {
                    mo2478b();
                    throw e;
                }
            }
            mo2478b();
            synchronized (this) {
                this.f7259b = true;
            }
            m8252d();
        }

        /* renamed from: d */
        public final void m8252d() {
            m8253e();
            synchronized (this.f7260c.f7285t) {
                this.f7260c.f7285t.remove(this);
            }
        }

        /* renamed from: e */
        public final void m8253e() {
            synchronized (this) {
                this.f7258a = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$j */
    public final class C2849j implements ServiceConnection {
        /* renamed from: a */
        private final int f7261a;
        /* renamed from: b */
        private final /* synthetic */ C2850d f7262b;

        public C2849j(C2850d c2850d, int i) {
            this.f7262b = c2850d;
            this.f7261a = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder == null) {
                this.f7262b.m8266c(16);
                return;
            }
            synchronized (this.f7262b.f7282q) {
                C2865r c2865r;
                C2850d c2850d = this.f7262b;
                if (iBinder == null) {
                    c2865r = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof C2865r)) {
                        c2865r = new C4373a(iBinder);
                    } else {
                        c2865r = (C2865r) queryLocalInterface;
                    }
                }
                c2850d.f7283r = c2865r;
            }
            this.f7262b.m8277a(0, null, this.f7261a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.f7262b.f7282q) {
                this.f7262b.f7283r = null;
            }
            this.f7262b.f7268a.sendMessage(this.f7262b.f7268a.obtainMessage(6, this.f7261a, 1));
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$d */
    protected class C4367d implements C2846c {
        /* renamed from: a */
        private final /* synthetic */ C2850d f11589a;

        public C4367d(C2850d c2850d) {
            this.f11589a = c2850d;
        }

        /* renamed from: a */
        public void mo2393a(C4775b c4775b) {
            if (c4775b.m16826b()) {
                this.f11589a.m8285a(null, this.f11589a.mo3295y());
                return;
            }
            if (this.f11589a.f7289x != null) {
                this.f11589a.f7289x.mo2464a(c4775b);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$f */
    private abstract class C4368f extends C2848h<Boolean> {
        /* renamed from: a */
        private final int f11590a;
        /* renamed from: b */
        private final Bundle f11591b;
        /* renamed from: c */
        private final /* synthetic */ C2850d f11592c;

        protected C4368f(C2850d c2850d, int i, Bundle bundle) {
            this.f11592c = c2850d;
            super(c2850d, Boolean.valueOf(true));
            this.f11590a = i;
            this.f11591b = bundle;
        }

        /* renamed from: a */
        protected abstract void mo3291a(C4775b c4775b);

        /* renamed from: a */
        protected abstract boolean mo3292a();

        /* renamed from: b */
        protected final void mo2478b() {
        }

        /* renamed from: a */
        protected final /* synthetic */ void mo2477a(Object obj) {
            PendingIntent pendingIntent = null;
            if (((Boolean) obj) == null) {
                this.f11592c.m8264b(1, null);
                return;
            }
            obj = this.f11590a;
            if (obj != null) {
                if (obj != 10) {
                    this.f11592c.m8264b(1, null);
                    if (this.f11591b != null) {
                        pendingIntent = (PendingIntent) this.f11591b.getParcelable("pendingIntent");
                    }
                    mo3291a(new C4775b(this.f11590a, pendingIntent));
                } else {
                    this.f11592c.m8264b(1, null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", new Object[]{getClass().getSimpleName(), this.f11592c.q_(), this.f11592c.mo3449b()}));
                }
            } else if (mo3292a() == null) {
                this.f11592c.m8264b(1, null);
                mo3291a(new C4775b(8, null));
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$g */
    final class C4369g extends C4962e {
        /* renamed from: a */
        private final /* synthetic */ C2850d f11593a;

        public C4369g(C2850d c2850d, Looper looper) {
            this.f11593a = c2850d;
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (this.f11593a.f7270c.get() != message.arg1) {
                if (C4369g.m14387b(message)) {
                    C4369g.m14386a(message);
                }
            } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.f11593a.m8294i()) {
                C4369g.m14386a(message);
            } else {
                PendingIntent pendingIntent = null;
                C4775b d;
                if (message.what == 4) {
                    this.f11593a.f7265A = new C4775b(message.arg2);
                    if (this.f11593a.mo3454A() == null || this.f11593a.f7266B != null) {
                        if (this.f11593a.f7265A != null) {
                            d = this.f11593a.f7265A;
                        } else {
                            d = new C4775b(8);
                        }
                        this.f11593a.f7269b.mo2393a(d);
                        this.f11593a.m8281a(d);
                        return;
                    }
                    this.f11593a.m8264b(3, null);
                } else if (message.what == 5) {
                    if (this.f11593a.f7265A != null) {
                        d = this.f11593a.f7265A;
                    } else {
                        d = new C4775b(8);
                    }
                    this.f11593a.f7269b.mo2393a(d);
                    this.f11593a.m8281a(d);
                } else if (message.what == 3) {
                    if (message.obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) message.obj;
                    }
                    C4775b c4775b = new C4775b(message.arg2, pendingIntent);
                    this.f11593a.f7269b.mo2393a(c4775b);
                    this.f11593a.m8281a(c4775b);
                } else if (message.what == 6) {
                    this.f11593a.m8264b(5, null);
                    if (this.f11593a.f7288w != null) {
                        this.f11593a.f7288w.mo2462a(message.arg2);
                    }
                    this.f11593a.m8276a(message.arg2);
                    this.f11593a.m8262a(5, 1, null);
                } else if (message.what == 2 && !this.f11593a.m8293h()) {
                    C4369g.m14386a(message);
                } else if (C4369g.m14387b(message)) {
                    ((C2848h) message.obj).m8251c();
                } else {
                    message = message.what;
                    StringBuilder stringBuilder = new StringBuilder(45);
                    stringBuilder.append("Don't know how to handle message: ");
                    stringBuilder.append(message);
                    Log.wtf("GmsClient", stringBuilder.toString(), new Exception());
                }
            }
        }

        /* renamed from: a */
        private static void m14386a(Message message) {
            C2848h c2848h = (C2848h) message.obj;
            c2848h.mo2478b();
            c2848h.m8252d();
        }

        /* renamed from: b */
        private static boolean m14387b(Message message) {
            if (!(message.what == 2 || message.what == 1)) {
                if (message.what != 7) {
                    return null;
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$i */
    public static final class C4780i extends C4372a {
        /* renamed from: a */
        private C2850d f13217a;
        /* renamed from: b */
        private final int f13218b;

        public C4780i(C2850d c2850d, int i) {
            this.f13217a = c2850d;
            this.f13218b = i;
        }

        /* renamed from: a */
        public final void mo2473a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        /* renamed from: a */
        public final void mo2474a(int i, IBinder iBinder, Bundle bundle) {
            C2872v.m8381a(this.f13217a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f13217a.m8278a(i, iBinder, bundle, this.f13218b);
            this.f13217a = 0;
        }

        /* renamed from: a */
        public final void mo2475a(int i, IBinder iBinder, aq aqVar) {
            C2872v.m8381a(this.f13217a, (Object) "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            C2872v.m8380a((Object) aqVar);
            this.f13217a.m8258a(aqVar);
            mo2474a(i, iBinder, aqVar.f13214a);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$k */
    protected final class C4781k extends C4368f {
        /* renamed from: a */
        private final IBinder f13219a;
        /* renamed from: b */
        private final /* synthetic */ C2850d f13220b;

        public C4781k(C2850d c2850d, int i, IBinder iBinder, Bundle bundle) {
            this.f13220b = c2850d;
            super(c2850d, i, bundle);
            this.f13219a = iBinder;
        }

        /* renamed from: a */
        protected final void mo3291a(C4775b c4775b) {
            if (this.f13220b.f7289x != null) {
                this.f13220b.f7289x.mo2464a(c4775b);
            }
            this.f13220b.m8281a(c4775b);
        }

        /* renamed from: a */
        protected final boolean mo3292a() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r6 = this;
            r0 = 0;
            r1 = r6.f13219a;	 Catch:{ RemoteException -> 0x0088 }
            r1 = r1.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0088 }
            r2 = r6.f13220b;
            r2 = r2.mo3449b();
            r2 = r2.equals(r1);
            if (r2 != 0) goto L_0x004b;
        L_0x0013:
            r2 = "GmsClient";
            r3 = r6.f13220b;
            r3 = r3.mo3449b();
            r4 = java.lang.String.valueOf(r3);
            r4 = r4.length();
            r4 = r4 + 34;
            r5 = java.lang.String.valueOf(r1);
            r5 = r5.length();
            r4 = r4 + r5;
            r5 = new java.lang.StringBuilder;
            r5.<init>(r4);
            r4 = "service descriptor mismatch: ";
            r5.append(r4);
            r5.append(r3);
            r3 = " vs. ";
            r5.append(r3);
            r5.append(r1);
            r1 = r5.toString();
            android.util.Log.e(r2, r1);
            return r0;
        L_0x004b:
            r1 = r6.f13220b;
            r2 = r6.f13219a;
            r1 = r1.mo3448a(r2);
            if (r1 == 0) goto L_0x0087;
        L_0x0055:
            r2 = r6.f13220b;
            r3 = 2;
            r4 = 4;
            r2 = r2.m8262a(r3, r4, r1);
            if (r2 != 0) goto L_0x0068;
        L_0x005f:
            r2 = r6.f13220b;
            r3 = 3;
            r1 = r2.m8262a(r3, r4, r1);
            if (r1 == 0) goto L_0x0087;
        L_0x0068:
            r0 = r6.f13220b;
            r1 = 0;
            r0.f7265A = r1;
            r0 = r6.f13220b;
            r0 = r0.m8274a();
            r1 = r6.f13220b;
            r1 = r1.f7288w;
            if (r1 == 0) goto L_0x0085;
        L_0x007c:
            r1 = r6.f13220b;
            r1 = r1.f7288w;
            r1.mo2463a(r0);
        L_0x0085:
            r0 = 1;
            return r0;
        L_0x0087:
            return r0;
        L_0x0088:
            r1 = "GmsClient";
            r2 = "service probably died";
            android.util.Log.w(r1, r2);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.d.k.a():boolean");
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$l */
    protected final class C4782l extends C4368f {
        /* renamed from: a */
        private final /* synthetic */ C2850d f13221a;

        public C4782l(C2850d c2850d, int i, Bundle bundle) {
            this.f13221a = c2850d;
            super(c2850d, i, null);
        }

        /* renamed from: a */
        protected final void mo3291a(C4775b c4775b) {
            this.f13221a.f7269b.mo2393a(c4775b);
            this.f13221a.m8281a(c4775b);
        }

        /* renamed from: a */
        protected final boolean mo3292a() {
            this.f13221a.f7269b.mo2393a(C4775b.f13206a);
            return true;
        }
    }

    /* renamed from: a */
    public Bundle m8274a() {
        return null;
    }

    /* renamed from: a */
    protected abstract T mo3448a(IBinder iBinder);

    /* renamed from: a */
    void mo3460a(int i, T t) {
    }

    /* renamed from: b */
    protected abstract String mo3449b();

    /* renamed from: c */
    public boolean mo3450c() {
        return false;
    }

    /* renamed from: j */
    public boolean mo3457j() {
        return false;
    }

    /* renamed from: k */
    public boolean m8296k() {
        return true;
    }

    /* renamed from: o */
    protected String m8300o() {
        return "com.google.android.gms";
    }

    /* renamed from: p */
    protected String m8301p() {
        return null;
    }

    protected abstract String q_();

    /* renamed from: s */
    public Account mo3294s() {
        return null;
    }

    /* renamed from: x */
    public boolean m8309x() {
        return false;
    }

    protected C2850d(Context context, Looper looper, int i, C2844a c2844a, C2845b c2845b, String str) {
        this(context, looper, C2859l.m8356a(context), C2830f.m8133b(), i, (C2844a) C2872v.m8380a((Object) c2844a), (C2845b) C2872v.m8380a((Object) c2845b), str);
    }

    protected C2850d(Context context, Looper looper, C2859l c2859l, C2830f c2830f, int i, C2844a c2844a, C2845b c2845b, String str) {
        this.f7281p = new Object();
        this.f7282q = new Object();
        this.f7285t = new ArrayList();
        this.f7287v = 1;
        this.f7265A = null;
        this.f7266B = false;
        this.f7267C = null;
        this.f7270c = new AtomicInteger(0);
        this.f7277l = (Context) C2872v.m8381a((Object) context, (Object) "Context must not be null");
        this.f7278m = (Looper) C2872v.m8381a((Object) looper, (Object) "Looper must not be null");
        this.f7279n = (C2859l) C2872v.m8381a((Object) c2859l, (Object) "Supervisor must not be null");
        this.f7280o = (C2830f) C2872v.m8381a((Object) c2830f, (Object) "API availability must not be null");
        this.f7268a = new C4369g(this, looper);
        this.f7290y = i;
        this.f7288w = c2844a;
        this.f7289x = c2845b;
        this.f7291z = str;
    }

    /* renamed from: e */
    private final String mo3452e() {
        return this.f7291z == null ? this.f7277l.getClass().getName() : this.f7291z;
    }

    /* renamed from: a */
    private final void m8258a(aq aqVar) {
        this.f7267C = aqVar;
    }

    /* renamed from: n */
    public final C4776d[] m8299n() {
        aq aqVar = this.f7267C;
        if (aqVar == null) {
            return null;
        }
        return aqVar.f13215b;
    }

    /* renamed from: a */
    protected void m8280a(T t) {
        this.f7273h = System.currentTimeMillis();
    }

    /* renamed from: a */
    protected void m8276a(int i) {
        this.f7271f = i;
        this.f7272g = System.currentTimeMillis();
    }

    /* renamed from: a */
    protected void m8281a(C4775b c4775b) {
        this.f7274i = c4775b.m16827c();
        this.f7275j = System.currentTimeMillis();
    }

    /* renamed from: b */
    private final void m8264b(int i, T t) {
        C2872v.m8390b((i == 4 ? 1 : null) == (t != null ? 1 : null));
        synchronized (this.f7281p) {
            this.f7287v = i;
            this.f7284s = t;
            mo3460a(i, (IInterface) t);
            switch (i) {
                case 1:
                    if (this.f7286u != 0) {
                        this.f7279n.m8357a(q_(), m8300o(), 129, this.f7286u, mo3452e());
                        this.f7286u = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (!(this.f7286u == 0 || this.f7276k == 0)) {
                        t = this.f7276k.m8230a();
                        String b = this.f7276k.m8231b();
                        StringBuilder stringBuilder = new StringBuilder((String.valueOf(t).length() + 70) + String.valueOf(b).length());
                        stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
                        stringBuilder.append(t);
                        stringBuilder.append(" on ");
                        stringBuilder.append(b);
                        Log.e("GmsClient", stringBuilder.toString());
                        this.f7279n.m8357a(this.f7276k.m8230a(), this.f7276k.m8231b(), this.f7276k.m8232c(), this.f7286u, mo3452e());
                        this.f7270c.incrementAndGet();
                    }
                    this.f7286u = new C2849j(this, this.f7270c.get());
                    if (this.f7287v != 3 || m8301p() == 0) {
                        i = new aw(m8300o(), q_(), false, 129);
                    } else {
                        i = new aw(m8303r().getPackageName(), m8301p(), true, 129);
                    }
                    this.f7276k = i;
                    if (this.f7279n.mo2467a(new C2858a(this.f7276k.m8230a(), this.f7276k.m8231b(), this.f7276k.m8232c()), this.f7286u, mo3452e()) == 0) {
                        t = this.f7276k.m8230a();
                        String b2 = this.f7276k.m8231b();
                        StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(t).length() + 34) + String.valueOf(b2).length());
                        stringBuilder2.append("unable to connect to service: ");
                        stringBuilder2.append(t);
                        stringBuilder2.append(" on ");
                        stringBuilder2.append(b2);
                        Log.e("GmsClient", stringBuilder2.toString());
                        m8277a(16, null, this.f7270c.get());
                        break;
                    }
                    break;
                case 4:
                    m8280a((IInterface) t);
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    private final boolean m8262a(int i, int i2, T t) {
        synchronized (this.f7281p) {
            if (this.f7287v != i) {
                return false;
            }
            m8264b(i2, t);
            return true;
        }
    }

    /* renamed from: q */
    public void m8302q() {
        int b = this.f7280o.mo2459b(this.f7277l, mo3293f());
        if (b != 0) {
            m8264b(1, null);
            m8283a(new C4367d(this), b, null);
            return;
        }
        m8282a(new C4367d(this));
    }

    /* renamed from: a */
    public void m8282a(C2846c c2846c) {
        this.f7269b = (C2846c) C2872v.m8381a((Object) c2846c, (Object) "Connection progress callbacks cannot be null.");
        m8264b(2, null);
    }

    /* renamed from: h */
    public boolean m8293h() {
        boolean z;
        synchronized (this.f7281p) {
            z = this.f7287v == 4;
        }
        return z;
    }

    /* renamed from: i */
    public boolean m8294i() {
        boolean z;
        synchronized (this.f7281p) {
            if (this.f7287v != 2) {
                if (this.f7287v != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: z */
    private final boolean mo3296z() {
        boolean z;
        synchronized (this.f7281p) {
            z = this.f7287v == 3;
        }
        return z;
    }

    /* renamed from: g */
    public void m8292g() {
        this.f7270c.incrementAndGet();
        synchronized (this.f7285t) {
            int size = this.f7285t.size();
            for (int i = 0; i < size; i++) {
                ((C2848h) this.f7285t.get(i)).m8253e();
            }
            this.f7285t.clear();
        }
        synchronized (this.f7282q) {
            this.f7283r = null;
        }
        m8264b(1, null);
    }

    /* renamed from: b */
    public void m8288b(int i) {
        this.f7268a.sendMessage(this.f7268a.obtainMessage(6, this.f7270c.get(), i));
    }

    /* renamed from: c */
    private final void m8266c(int i) {
        if (mo3296z() != 0) {
            i = 5;
            this.f7266B = true;
        } else {
            i = 4;
        }
        this.f7268a.sendMessage(this.f7268a.obtainMessage(i, this.f7270c.get(), 16));
    }

    /* renamed from: a */
    protected void m8283a(C2846c c2846c, int i, PendingIntent pendingIntent) {
        this.f7269b = (C2846c) C2872v.m8381a((Object) c2846c, (Object) "Connection progress callbacks cannot be null.");
        this.f7268a.sendMessage(this.f7268a.obtainMessage(3, this.f7270c.get(), i, pendingIntent));
    }

    /* renamed from: r */
    public final Context m8303r() {
        return this.f7277l;
    }

    /* renamed from: t */
    public C4776d[] m8305t() {
        return f7264e;
    }

    /* renamed from: u */
    protected Bundle mo3458u() {
        return new Bundle();
    }

    /* renamed from: a */
    protected void m8278a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f7268a.sendMessage(this.f7268a.obtainMessage(1, i2, -1, new C4781k(this, i, iBinder, bundle)));
    }

    /* renamed from: a */
    protected final void m8277a(int i, Bundle bundle, int i2) {
        this.f7268a.sendMessage(this.f7268a.obtainMessage(7, i2, -1, new C4782l(this, i, null)));
    }

    /* renamed from: v */
    protected final void m8307v() {
        if (!m8293h()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* renamed from: w */
    public final T m8308w() {
        T t;
        synchronized (this.f7281p) {
            if (this.f7287v != 5) {
                m8307v();
                C2872v.m8387a(this.f7284s != null, (Object) "Client is connected but service is null");
                t = this.f7284s;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    /* renamed from: a */
    public void m8285a(C2862o c2862o, Set<Scope> set) {
        Bundle u = mo3458u();
        C4784i c4784i = new C4784i(this.f7290y);
        c4784i.f13224a = this.f7277l.getPackageName();
        c4784i.f13227d = u;
        if (set != null) {
            c4784i.f13226c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (mo3457j() != null) {
            c4784i.f13228e = mo3294s() != null ? mo3294s() : new Account("<<default account>>", "com.google");
            if (c2862o != null) {
                c4784i.f13225b = c2862o.asBinder();
            }
        } else if (m8309x() != null) {
            c4784i.f13228e = mo3294s();
        }
        c4784i.f13229f = f7264e;
        c4784i.f13230g = m8305t();
        try {
            synchronized (this.f7282q) {
                if (this.f7283r != null) {
                    this.f7283r.mo2480a(new C4780i(this, this.f7270c.get()), c4784i);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (C2862o c2862o2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", c2862o2);
            m8288b(1);
        } catch (C2862o c2862o22) {
            throw c2862o22;
        } catch (C2862o c2862o222) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", c2862o222);
            m8278a(8, null, null, this.f7270c.get());
        }
    }

    /* renamed from: a */
    public void m8284a(C2847e c2847e) {
        c2847e.mo2425a();
    }

    /* renamed from: d */
    public Intent mo3451d() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* renamed from: y */
    protected Set<Scope> mo3295y() {
        return Collections.EMPTY_SET;
    }

    /* renamed from: a */
    public void m8286a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f7281p) {
            strArr = this.f7287v;
            IInterface iInterface = this.f7284s;
        }
        synchronized (this.f7282q) {
            fileDescriptor = this.f7283r;
        }
        printWriter.append(str).append("mConnectState=");
        switch (strArr) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(mo3449b()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (fileDescriptor == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(fileDescriptor.asBinder())));
        }
        fileDescriptor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f7273h > 0) {
            strArr = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f7273h;
            String format = fileDescriptor.format(new Date(this.f7273h));
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            strArr.println(stringBuilder.toString());
        }
        if (this.f7272g > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f7271f) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f7271f));
                    break;
            }
            strArr = printWriter.append(" lastSuspendedTime=");
            j = this.f7272g;
            format = fileDescriptor.format(new Date(this.f7272g));
            stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            strArr.println(stringBuilder.toString());
        }
        if (this.f7275j > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(C2784d.m7938b(this.f7274i));
            str = printWriter.append(" lastFailedTime=");
            printWriter = this.f7275j;
            fileDescriptor = fileDescriptor.format(new Date(this.f7275j));
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(fileDescriptor).length() + 21);
            stringBuilder2.append(printWriter);
            stringBuilder2.append(" ");
            stringBuilder2.append(fileDescriptor);
            str.println(stringBuilder2.toString());
        }
    }

    /* renamed from: l */
    public IBinder m8297l() {
        synchronized (this.f7282q) {
            if (this.f7283r == null) {
                return null;
            }
            IBinder asBinder = this.f7283r.asBinder();
            return asBinder;
        }
    }

    /* renamed from: A */
    private final boolean mo3454A() {
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
        r0 = r2.f7266B;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r2.mo3449b();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        return r1;
    L_0x0011:
        r0 = r2.m8301p();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x001c;
    L_0x001b:
        return r1;
    L_0x001c:
        r0 = r2.mo3449b();	 Catch:{ ClassNotFoundException -> 0x0025 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0025 }
        r0 = 1;
        return r0;
    L_0x0025:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.d.A():boolean");
    }

    /* renamed from: m */
    public String m8298m() {
        if (m8293h() && this.f7276k != null) {
            return this.f7276k.m8231b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    /* renamed from: f */
    public int mo3293f() {
        return C2830f.f7233b;
    }
}
