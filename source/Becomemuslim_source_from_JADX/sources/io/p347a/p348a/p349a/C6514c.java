package io.p347a.p348a.p349a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.p347a.p348a.p349a.C6512a.C6414b;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import io.p347a.p348a.p349a.p350a.p353c.C6459d;
import io.p347a.p348a.p349a.p350a.p353c.C6464k;
import io.p347a.p348a.p349a.p350a.p353c.C6466m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric */
/* renamed from: io.a.a.a.c */
public class C6514c {
    /* renamed from: a */
    static volatile C6514c f20999a;
    /* renamed from: b */
    static final C6523l f21000b = new C7625b();
    /* renamed from: c */
    final C6523l f21001c;
    /* renamed from: d */
    final boolean f21002d;
    /* renamed from: e */
    private final Context f21003e;
    /* renamed from: f */
    private final Map<Class<? extends C6520i>, C6520i> f21004f;
    /* renamed from: g */
    private final ExecutorService f21005g;
    /* renamed from: h */
    private final Handler f21006h;
    /* renamed from: i */
    private final C6518f<C6514c> f21007i;
    /* renamed from: j */
    private final C6518f<?> f21008j;
    /* renamed from: k */
    private final C6436o f21009k;
    /* renamed from: l */
    private C6512a f21010l;
    /* renamed from: m */
    private WeakReference<Activity> f21011m;
    /* renamed from: n */
    private AtomicBoolean f21012n = new AtomicBoolean(null);

    /* compiled from: Fabric */
    /* renamed from: io.a.a.a.c$a */
    public static class C6513a {
        /* renamed from: a */
        private final Context f20990a;
        /* renamed from: b */
        private C6520i[] f20991b;
        /* renamed from: c */
        private C6464k f20992c;
        /* renamed from: d */
        private Handler f20993d;
        /* renamed from: e */
        private C6523l f20994e;
        /* renamed from: f */
        private boolean f20995f;
        /* renamed from: g */
        private String f20996g;
        /* renamed from: h */
        private String f20997h;
        /* renamed from: i */
        private C6518f<C6514c> f20998i;

        public C6513a(Context context) {
            if (context != null) {
                this.f20990a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C6513a m26622a(C6520i... c6520iArr) {
            if (this.f20991b == null) {
                this.f20991b = c6520iArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        /* renamed from: a */
        public C6514c m26623a() {
            HashMap hashMap;
            if (this.f20992c == null) {
                this.f20992c = C6464k.m26487a();
            }
            if (this.f20993d == null) {
                this.f20993d = new Handler(Looper.getMainLooper());
            }
            if (this.f20994e == null) {
                if (this.f20995f) {
                    this.f20994e = new C7625b(3);
                } else {
                    this.f20994e = new C7625b();
                }
            }
            if (this.f20997h == null) {
                this.f20997h = this.f20990a.getPackageName();
            }
            if (this.f20998i == null) {
                this.f20998i = C6518f.f21016d;
            }
            if (this.f20991b == null) {
                hashMap = new HashMap();
            } else {
                hashMap = C6514c.m26631b(Arrays.asList(this.f20991b));
            }
            HashMap hashMap2 = hashMap;
            return new C6514c(this.f20990a, hashMap2, this.f20992c, this.f20993d, this.f20994e, this.f20995f, this.f20998i, new C6436o(this.f20990a, this.f20997h, this.f20996g, hashMap2.values()));
        }
    }

    /* compiled from: Fabric */
    /* renamed from: io.a.a.a.c$1 */
    class C76261 extends C6414b {
        /* renamed from: a */
        final /* synthetic */ C6514c f26344a;

        C76261(C6514c c6514c) {
            this.f26344a = c6514c;
        }

        /* renamed from: a */
        public void mo5482a(Activity activity, Bundle bundle) {
            this.f26344a.m26637a(activity);
        }

        /* renamed from: a */
        public void mo5481a(Activity activity) {
            this.f26344a.m26637a(activity);
        }

        /* renamed from: b */
        public void mo5483b(Activity activity) {
            this.f26344a.m26637a(activity);
        }
    }

    /* renamed from: c */
    public String m26643c() {
        return "1.3.10.97";
    }

    /* renamed from: d */
    public String m26644d() {
        return "io.fabric.sdk.android:fabric";
    }

    /* renamed from: a */
    static C6514c m26624a() {
        if (f20999a != null) {
            return f20999a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    C6514c(Context context, Map<Class<? extends C6520i>, C6520i> map, C6464k c6464k, Handler handler, C6523l c6523l, boolean z, C6518f c6518f, C6436o c6436o) {
        this.f21003e = context;
        this.f21004f = map;
        this.f21005g = c6464k;
        this.f21006h = handler;
        this.f21001c = c6523l;
        this.f21002d = z;
        this.f21007i = c6518f;
        this.f21008j = m26638a(map.size());
        this.f21009k = c6436o;
    }

    /* renamed from: a */
    public static C6514c m26625a(Context context, C6520i... c6520iArr) {
        if (f20999a == null) {
            synchronized (C6514c.class) {
                if (f20999a == null) {
                    C6514c.m26633c(new C6513a(context).m26622a(c6520iArr).m26623a());
                }
            }
        }
        return f20999a;
    }

    /* renamed from: c */
    private static void m26633c(C6514c c6514c) {
        f20999a = c6514c;
        c6514c.m26636j();
    }

    /* renamed from: a */
    public C6514c m26637a(Activity activity) {
        this.f21011m = new WeakReference(activity);
        return this;
    }

    /* renamed from: b */
    public Activity m26641b() {
        return this.f21011m != null ? (Activity) this.f21011m.get() : null;
    }

    /* renamed from: j */
    private void m26636j() {
        m26637a(m26632c(this.f21003e));
        this.f21010l = new C6512a(this.f21003e);
        this.f21010l.m26621a(new C76261(this));
        m26639a(this.f21003e);
    }

    /* renamed from: a */
    void m26639a(Context context) {
        Future b = m26642b(context);
        Collection g = m26647g();
        C7629m c7629m = new C7629m(b, g);
        List<C6520i> arrayList = new ArrayList(g);
        Collections.sort(arrayList);
        c7629m.m26662a(context, this, C6518f.f21016d, this.f21009k);
        for (C6520i a : arrayList) {
            a.m26662a(context, this, this.f21008j, this.f21009k);
        }
        c7629m.m26653C();
        if (C6514c.m26634h().mo5474a("Fabric", 3) != null) {
            context = new StringBuilder("Initializing ");
            context.append(m26644d());
            context.append(" [Version: ");
            context.append(m26643c());
            context.append("], with the following kits:\n");
        } else {
            context = null;
        }
        for (C6520i c6520i : arrayList) {
            c6520i.f21018f.m34346a(c7629m.f);
            m26640a(this.f21004f, c6520i);
            c6520i.m26653C();
            if (context != null) {
                context.append(c6520i.mo5487b());
                context.append(" [Version: ");
                context.append(c6520i.mo5486a());
                context.append("]\n");
            }
        }
        if (context != null) {
            C6514c.m26634h().mo5472a("Fabric", context.toString());
        }
    }

    /* renamed from: a */
    void m26640a(Map<Class<? extends C6520i>, C6520i> map, C6520i c6520i) {
        C6459d c6459d = (C6459d) c6520i.getClass().getAnnotation(C6459d.class);
        if (c6459d != null) {
            for (Class cls : c6459d.m26483a()) {
                if (cls.isInterface()) {
                    for (C6520i c6520i2 : map.values()) {
                        if (cls.isAssignableFrom(c6520i2.getClass())) {
                            c6520i.f21018f.m34346a(c6520i2.f21018f);
                        }
                    }
                } else if (((C6520i) map.get(cls)) != null) {
                    c6520i.f21018f.m34346a(((C6520i) map.get(cls)).f21018f);
                } else {
                    throw new C6466m("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    /* renamed from: c */
    private Activity m26632c(Context context) {
        return context instanceof Activity ? (Activity) context : null;
    }

    /* renamed from: e */
    public C6512a m26645e() {
        return this.f21010l;
    }

    /* renamed from: f */
    public ExecutorService m26646f() {
        return this.f21005g;
    }

    /* renamed from: g */
    public Collection<C6520i> m26647g() {
        return this.f21004f.values();
    }

    /* renamed from: a */
    public static <T extends C6520i> T m26626a(Class<T> cls) {
        return (C6520i) C6514c.m26624a().f21004f.get(cls);
    }

    /* renamed from: h */
    public static C6523l m26634h() {
        if (f20999a == null) {
            return f21000b;
        }
        return f20999a.f21001c;
    }

    /* renamed from: i */
    public static boolean m26635i() {
        if (f20999a == null) {
            return false;
        }
        return f20999a.f21002d;
    }

    /* renamed from: b */
    private static Map<Class<? extends C6520i>, C6520i> m26631b(Collection<? extends C6520i> collection) {
        Map hashMap = new HashMap(collection.size());
        C6514c.m26629a(hashMap, (Collection) collection);
        return hashMap;
    }

    /* renamed from: a */
    private static void m26629a(Map<Class<? extends C6520i>, C6520i> map, Collection<? extends C6520i> collection) {
        for (C6520i c6520i : collection) {
            map.put(c6520i.getClass(), c6520i);
            if (c6520i instanceof C6521j) {
                C6514c.m26629a((Map) map, ((C6521j) c6520i).m26668c());
            }
        }
    }

    /* renamed from: a */
    C6518f<?> m26638a(final int i) {
        return new C6518f(this) {
            /* renamed from: a */
            final CountDownLatch f26345a = new CountDownLatch(i);
            /* renamed from: c */
            final /* synthetic */ C6514c f26347c;

            /* renamed from: a */
            public void mo5485a(Object obj) {
                this.f26345a.countDown();
                if (this.f26345a.getCount() == 0) {
                    this.f26347c.f21012n.set(true);
                    this.f26347c.f21007i.mo5485a(this.f26347c);
                }
            }

            /* renamed from: a */
            public void mo5484a(Exception exception) {
                this.f26347c.f21007i.mo5484a(exception);
            }
        };
    }

    /* renamed from: b */
    Future<Map<String, C6522k>> m26642b(Context context) {
        return m26646f().submit(new C6516e(context.getPackageCodePath()));
    }
}
