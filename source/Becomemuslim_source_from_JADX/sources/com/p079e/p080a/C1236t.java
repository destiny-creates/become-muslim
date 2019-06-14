package com.p079e.p080a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: Picasso */
/* renamed from: com.e.a.t */
public class C1236t {
    /* renamed from: a */
    static final Handler f3495a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                int i2 = 0;
                List list;
                if (i == 8) {
                    list = (List) message.obj;
                    i = list.size();
                    while (i2 < i) {
                        C1210c c1210c = (C1210c) list.get(i2);
                        c1210c.f3402b.m4314a(c1210c);
                        i2++;
                    }
                    return;
                } else if (i == 13) {
                    list = (List) message.obj;
                    i = list.size();
                    while (i2 < i) {
                        C1194a c1194a = (C1194a) list.get(i2);
                        c1194a.f3348a.m4317c(c1194a);
                        i2++;
                    }
                    return;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown handler message received: ");
                    stringBuilder.append(message.what);
                    throw new AssertionError(stringBuilder.toString());
                }
            }
            C1194a c1194a2 = (C1194a) message.obj;
            if (c1194a2.m4182j().f3506l) {
                ae.m4221a("Main", "canceled", c1194a2.f3349b.m4329a(), "target got garbage collected");
            }
            c1194a2.f3348a.m4306a(c1194a2.m4176d());
        }
    };
    /* renamed from: b */
    static volatile C1236t f3496b = null;
    /* renamed from: c */
    final Context f3497c;
    /* renamed from: d */
    final C1219i f3498d;
    /* renamed from: e */
    final C1211d f3499e;
    /* renamed from: f */
    final aa f3500f;
    /* renamed from: g */
    final Map<Object, C1194a> f3501g;
    /* renamed from: h */
    final Map<ImageView, C1214h> f3502h;
    /* renamed from: i */
    final ReferenceQueue<Object> f3503i;
    /* renamed from: j */
    final Config f3504j;
    /* renamed from: k */
    boolean f3505k;
    /* renamed from: l */
    volatile boolean f3506l;
    /* renamed from: m */
    boolean f3507m;
    /* renamed from: n */
    private final C1232c f3508n;
    /* renamed from: o */
    private final C1235f f3509o;
    /* renamed from: p */
    private final C1231b f3510p;
    /* renamed from: q */
    private final List<C1245y> f3511q;

    /* compiled from: Picasso */
    /* renamed from: com.e.a.t$a */
    public static class C1229a {
        /* renamed from: a */
        private final Context f3471a;
        /* renamed from: b */
        private C1222j f3472b;
        /* renamed from: c */
        private ExecutorService f3473c;
        /* renamed from: d */
        private C1211d f3474d;
        /* renamed from: e */
        private C1232c f3475e;
        /* renamed from: f */
        private C1235f f3476f;
        /* renamed from: g */
        private List<C1245y> f3477g;
        /* renamed from: h */
        private Config f3478h;
        /* renamed from: i */
        private boolean f3479i;
        /* renamed from: j */
        private boolean f3480j;

        public C1229a(Context context) {
            if (context != null) {
                this.f3471a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C1236t m4300a() {
            Context context = this.f3471a;
            if (this.f3472b == null) {
                this.f3472b = ae.m4210a(context);
            }
            if (this.f3474d == null) {
                this.f3474d = new C3505m(context);
            }
            if (this.f3473c == null) {
                this.f3473c = new C1239v();
            }
            if (this.f3476f == null) {
                this.f3476f = C1235f.f3494a;
            }
            aa aaVar = new aa(this.f3474d);
            Context context2 = context;
            return new C1236t(context2, new C1219i(context2, this.f3473c, C1236t.f3495a, this.f3472b, this.f3474d, aaVar), this.f3474d, this.f3475e, this.f3476f, this.f3477g, aaVar, this.f3478h, this.f3479i, this.f3480j);
        }
    }

    /* compiled from: Picasso */
    /* renamed from: com.e.a.t$b */
    private static class C1231b extends Thread {
        /* renamed from: a */
        private final ReferenceQueue<Object> f3483a;
        /* renamed from: b */
        private final Handler f3484b;

        C1231b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f3483a = referenceQueue;
            this.f3484b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
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
            r3 = this;
            r0 = 10;
            android.os.Process.setThreadPriority(r0);
        L_0x0005:
            r0 = r3.f3483a;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0 = r0.remove(r1);	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0 = (com.p079e.p080a.C1194a.C1193a) r0;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1 = r3.f3484b;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1 = r1.obtainMessage();	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            if (r0 == 0) goto L_0x0024;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
        L_0x0017:
            r2 = 3;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1.what = r2;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0 = r0.f3347a;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1.obj = r0;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0 = r3.f3484b;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0.sendMessage(r1);	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            goto L_0x0005;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
        L_0x0024:
            r1.recycle();	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            goto L_0x0005;
        L_0x0028:
            r0 = move-exception;
            r1 = r3.f3484b;
            r2 = new com.e.a.t$b$1;
            r2.<init>(r3, r0);
            r1.post(r2);
        L_0x0033:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.e.a.t.b.run():void");
        }
    }

    /* compiled from: Picasso */
    /* renamed from: com.e.a.t$c */
    public interface C1232c {
        /* renamed from: a */
        void m4301a(C1236t c1236t, Uri uri, Exception exception);
    }

    /* compiled from: Picasso */
    /* renamed from: com.e.a.t$d */
    public enum C1233d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        /* renamed from: d */
        final int f3489d;

        private C1233d(int i) {
            this.f3489d = i;
        }
    }

    /* compiled from: Picasso */
    /* renamed from: com.e.a.t$e */
    public enum C1234e {
        LOW,
        NORMAL,
        HIGH
    }

    /* compiled from: Picasso */
    /* renamed from: com.e.a.t$f */
    public interface C1235f {
        /* renamed from: a */
        public static final C1235f f3494a = new C35081();

        /* compiled from: Picasso */
        /* renamed from: com.e.a.t$f$1 */
        static class C35081 implements C1235f {
            /* renamed from: a */
            public C1242w mo832a(C1242w c1242w) {
                return c1242w;
            }

            C35081() {
            }
        }

        /* renamed from: a */
        C1242w mo832a(C1242w c1242w);
    }

    C1236t(Context context, C1219i c1219i, C1211d c1211d, C1232c c1232c, C1235f c1235f, List<C1245y> list, aa aaVar, Config config, boolean z, boolean z2) {
        this.f3497c = context;
        this.f3498d = c1219i;
        this.f3499e = c1211d;
        this.f3508n = c1232c;
        this.f3509o = c1235f;
        this.f3504j = config;
        c1232c = new ArrayList((list != null ? list.size() : null) + 7);
        c1232c.add(new C3509z(context));
        if (list != null) {
            c1232c.addAll(list);
        }
        c1232c.add(new C3502f(context));
        c1232c.add(new C4546o(context));
        c1232c.add(new C3503g(context));
        c1232c.add(new C3499b(context));
        c1232c.add(new C4545k(context));
        c1232c.add(new C3506r(c1219i.f3431d, aaVar));
        this.f3511q = Collections.unmodifiableList(c1232c);
        this.f3500f = aaVar;
        this.f3501g = new WeakHashMap();
        this.f3502h = new WeakHashMap();
        this.f3505k = z;
        this.f3506l = z2;
        this.f3503i = new ReferenceQueue();
        this.f3510p = new C1231b(this.f3503i, f3495a);
        this.f3510p.start();
    }

    /* renamed from: a */
    public void m4311a(ImageView imageView) {
        m4306a((Object) imageView);
    }

    /* renamed from: a */
    public C1243x m4308a(Uri uri) {
        return new C1243x(this, uri, 0);
    }

    /* renamed from: a */
    public C1243x m4309a(String str) {
        if (str == null) {
            return new C1243x(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return m4308a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* renamed from: a */
    List<C1245y> m4310a() {
        return this.f3511q;
    }

    /* renamed from: a */
    C1242w m4307a(C1242w c1242w) {
        C1242w a = this.f3509o.mo832a(c1242w);
        if (a != null) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request transformer ");
        stringBuilder.append(this.f3509o.getClass().getCanonicalName());
        stringBuilder.append(" returned null for ");
        stringBuilder.append(c1242w);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    void m4312a(ImageView imageView, C1214h c1214h) {
        this.f3502h.put(imageView, c1214h);
    }

    /* renamed from: a */
    void m4313a(C1194a c1194a) {
        Object d = c1194a.m4176d();
        if (!(d == null || this.f3501g.get(d) == c1194a)) {
            m4306a(d);
            this.f3501g.put(d, c1194a);
        }
        m4316b(c1194a);
    }

    /* renamed from: b */
    void m4316b(C1194a c1194a) {
        this.f3498d.m4271a(c1194a);
    }

    /* renamed from: b */
    Bitmap m4315b(String str) {
        str = this.f3499e.mo823a(str);
        if (str != null) {
            this.f3500f.m4187a();
        } else {
            this.f3500f.m4191b();
        }
        return str;
    }

    /* renamed from: a */
    void m4314a(C1210c c1210c) {
        C1194a i = c1210c.m4249i();
        List k = c1210c.m4251k();
        Object obj = 1;
        Object obj2 = (k == null || k.isEmpty()) ? null : 1;
        if (i == null) {
            if (obj2 == null) {
                obj = null;
            }
        }
        if (obj != null) {
            Uri uri = c1210c.m4248h().f3540d;
            Exception l = c1210c.m4252l();
            Bitmap e = c1210c.m4245e();
            c1210c = c1210c.m4253m();
            if (i != null) {
                m4304a(e, c1210c, i);
            }
            if (obj2 != null) {
                int size = k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m4304a(e, c1210c, (C1194a) k.get(i2));
                }
            }
            if (!(this.f3508n == null || l == null)) {
                this.f3508n.m4301a(this, uri, l);
            }
        }
    }

    /* renamed from: c */
    void m4317c(C1194a c1194a) {
        Bitmap b = C1225p.m4295a(c1194a.f3352e) ? m4315b(c1194a.m4177e()) : null;
        if (b != null) {
            m4304a(b, C1233d.MEMORY, c1194a);
            if (this.f3506l) {
                c1194a = c1194a.f3349b.m4329a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("from ");
                stringBuilder.append(C1233d.MEMORY);
                ae.m4221a("Main", "completed", c1194a, stringBuilder.toString());
                return;
            }
            return;
        }
        m4313a(c1194a);
        if (this.f3506l) {
            ae.m4220a("Main", "resumed", c1194a.f3349b.m4329a());
        }
    }

    /* renamed from: a */
    private void m4304a(Bitmap bitmap, C1233d c1233d, C1194a c1194a) {
        if (!c1194a.m4178f()) {
            if (!c1194a.m4179g()) {
                this.f3501g.remove(c1194a.m4176d());
            }
            if (bitmap == null) {
                c1194a.mo826a();
                if (this.f3506l != null) {
                    ae.m4220a("Main", "errored", c1194a.f3349b.m4329a());
                }
            } else if (c1233d != null) {
                c1194a.mo827a(bitmap, c1233d);
                if (this.f3506l != null) {
                    c1194a = c1194a.f3349b.m4329a();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("from ");
                    stringBuilder.append(c1233d);
                    ae.m4221a("Main", "completed", c1194a, stringBuilder.toString());
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    /* renamed from: a */
    private void m4306a(Object obj) {
        ae.m4217a();
        C1194a c1194a = (C1194a) this.f3501g.remove(obj);
        if (c1194a != null) {
            c1194a.mo828b();
            this.f3498d.m4278b(c1194a);
        }
        if (obj instanceof ImageView) {
            C1214h c1214h = (C1214h) this.f3502h.remove((ImageView) obj);
            if (c1214h != null) {
                c1214h.m4262a();
            }
        }
    }

    /* renamed from: a */
    public static C1236t m4303a(Context context) {
        if (f3496b == null) {
            synchronized (C1236t.class) {
                if (f3496b == null) {
                    f3496b = new C1229a(context).m4300a();
                }
            }
        }
        return f3496b;
    }
}
