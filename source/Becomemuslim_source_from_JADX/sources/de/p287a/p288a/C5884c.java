package de.p287a.p288a;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: EventBus */
/* renamed from: de.a.a.c */
public class C5884c {
    /* renamed from: a */
    public static String f19562a = "Event";
    /* renamed from: b */
    static volatile C5884c f19563b;
    /* renamed from: c */
    private static final C5885d f19564c = new C5885d();
    /* renamed from: d */
    private static final Map<Class<?>, List<Class<?>>> f19565d = new HashMap();
    /* renamed from: e */
    private final Map<Class<?>, CopyOnWriteArrayList<C5894m>> f19566e;
    /* renamed from: f */
    private final Map<Object, List<Class<?>>> f19567f;
    /* renamed from: g */
    private final Map<Class<?>, Object> f19568g;
    /* renamed from: h */
    private final ThreadLocal<C5883a> f19569h;
    /* renamed from: i */
    private final C5887f f19570i;
    /* renamed from: j */
    private final C5880b f19571j;
    /* renamed from: k */
    private final C5879a f19572k;
    /* renamed from: l */
    private final C5893l f19573l;
    /* renamed from: m */
    private final ExecutorService f19574m;
    /* renamed from: n */
    private final boolean f19575n;
    /* renamed from: o */
    private final boolean f19576o;
    /* renamed from: p */
    private final boolean f19577p;
    /* renamed from: q */
    private final boolean f19578q;
    /* renamed from: r */
    private final boolean f19579r;
    /* renamed from: s */
    private final boolean f19580s;

    /* compiled from: EventBus */
    /* renamed from: de.a.a.c$1 */
    class C58811 extends ThreadLocal<C5883a> {
        /* renamed from: a */
        final /* synthetic */ C5884c f19554a;

        C58811(C5884c c5884c) {
            this.f19554a = c5884c;
        }

        protected /* synthetic */ Object initialValue() {
            return m24752a();
        }

        /* renamed from: a */
        protected C5883a m24752a() {
            return new C5883a();
        }
    }

    /* compiled from: EventBus */
    /* renamed from: de.a.a.c$a */
    static final class C5883a {
        /* renamed from: a */
        final List<Object> f19556a = new ArrayList();
        /* renamed from: b */
        boolean f19557b;
        /* renamed from: c */
        boolean f19558c;
        /* renamed from: d */
        C5894m f19559d;
        /* renamed from: e */
        Object f19560e;
        /* renamed from: f */
        boolean f19561f;

        C5883a() {
        }
    }

    /* renamed from: a */
    public static C5884c m24753a() {
        if (f19563b == null) {
            synchronized (C5884c.class) {
                if (f19563b == null) {
                    f19563b = new C5884c();
                }
            }
        }
        return f19563b;
    }

    public C5884c() {
        this(f19564c);
    }

    C5884c(C5885d c5885d) {
        this.f19569h = new C58811(this);
        this.f19566e = new HashMap();
        this.f19567f = new HashMap();
        this.f19568g = new ConcurrentHashMap();
        this.f19570i = new C5887f(this, Looper.getMainLooper(), 10);
        this.f19571j = new C5880b(this);
        this.f19572k = new C5879a(this);
        this.f19573l = new C5893l(c5885d.f19589h);
        this.f19576o = c5885d.f19582a;
        this.f19577p = c5885d.f19583b;
        this.f19578q = c5885d.f19584c;
        this.f19579r = c5885d.f19585d;
        this.f19575n = c5885d.f19586e;
        this.f19580s = c5885d.f19587f;
        this.f19574m = c5885d.f19588g;
    }

    /* renamed from: a */
    public void m24765a(Object obj) {
        m24760a(obj, false, 0);
    }

    /* renamed from: b */
    public void m24767b(Object obj) {
        m24760a(obj, true, 0);
    }

    /* renamed from: a */
    private synchronized void m24760a(Object obj, boolean z, int i) {
        for (C5892k a : this.f19573l.m24778a(obj.getClass())) {
            m24758a(obj, a, z, i);
        }
    }

    /* renamed from: a */
    private void m24758a(Object obj, C5892k c5892k, boolean z, int i) {
        Class cls = c5892k.f19608c;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f19566e.get(cls);
        C5894m c5894m = new C5894m(obj, c5892k, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f19566e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(c5894m) != null) {
            z = new StringBuilder();
            z.append("Subscriber ");
            z.append(obj.getClass());
            z.append(" already registered to event ");
            z.append(cls);
            throw new C5886e(z.toString());
        }
        c5892k = copyOnWriteArrayList.size();
        boolean z2 = false;
        int i2 = 0;
        while (i2 <= c5892k) {
            if (i2 != c5892k) {
                if (c5894m.f19614c <= ((C5894m) copyOnWriteArrayList.get(i2)).f19614c) {
                    i2++;
                }
            }
            copyOnWriteArrayList.add(i2, c5894m);
            break;
        }
        c5892k = (List) this.f19567f.get(obj);
        if (c5892k == null) {
            c5892k = new ArrayList();
            this.f19567f.put(obj, c5892k);
        }
        c5892k.add(cls);
        if (z) {
            Object obj2;
            synchronized (this.f19568g) {
                obj2 = this.f19568g.get(cls);
            }
            if (obj2 != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z2 = true;
                }
                m24756a(c5894m, obj2, z2);
            }
        }
    }

    /* renamed from: a */
    private void m24759a(Object obj, Class<?> cls) {
        List list = (List) this.f19566e.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                C5894m c5894m = (C5894m) list.get(i);
                if (c5894m.f19612a == obj) {
                    c5894m.f19615d = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* renamed from: c */
    public synchronized void m24768c(Object obj) {
        List<Class> list = (List) this.f19567f.get(obj);
        if (list != null) {
            for (Class a : list) {
                m24759a(obj, a);
            }
            this.f19567f.remove(obj);
        } else {
            String str = f19562a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Subscriber to unregister was not registered before: ");
            stringBuilder.append(obj.getClass());
            Log.w(str, stringBuilder.toString());
        }
    }

    /* renamed from: d */
    public void m24769d(Object obj) {
        C5883a c5883a = (C5883a) this.f19569h.get();
        List list = c5883a.f19556a;
        list.add(obj);
        if (c5883a.f19557b == null) {
            c5883a.f19558c = Looper.getMainLooper() == Looper.myLooper() ? true : null;
            c5883a.f19557b = true;
            if (c5883a.f19561f == null) {
                while (list.isEmpty() == null) {
                    try {
                        m24757a(list.remove(0), c5883a);
                    } finally {
                        c5883a.f19557b = false;
                        c5883a.f19558c = false;
                    }
                }
                return;
            }
            throw new C5886e("Internal error. Abort state was not reset");
        }
    }

    /* renamed from: e */
    public void m24770e(Object obj) {
        synchronized (this.f19568g) {
            this.f19568g.put(obj.getClass(), obj);
        }
        m24769d(obj);
    }

    /* renamed from: a */
    private void m24757a(Object obj, C5883a c5883a) {
        int i;
        Class cls = obj.getClass();
        if (this.f19580s) {
            List a = m24754a(cls);
            i = 0;
            for (int i2 = 0; i2 < a.size(); i2++) {
                i |= m24762a(obj, c5883a, (Class) a.get(i2));
            }
        } else {
            i = m24762a(obj, c5883a, cls);
        }
        if (i == 0) {
            if (this.f19577p != null) {
                c5883a = f19562a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No subscribers registered for event ");
                stringBuilder.append(cls);
                Log.d(c5883a, stringBuilder.toString());
            }
            if (this.f19579r != null && cls != C5888g.class && cls != C5891j.class) {
                m24769d(new C5888g(this, obj));
            }
        }
    }

    /* renamed from: a */
    private boolean m24762a(Object obj, C5883a c5883a, Class<?> cls) {
        synchronized (this) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f19566e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        cls = copyOnWriteArrayList.iterator();
        loop0:
        while (cls.hasNext()) {
            boolean z = (C5894m) cls.next();
            c5883a.f19560e = obj;
            c5883a.f19559d = z;
            try {
                m24756a((C5894m) z, obj, c5883a.f19558c);
                z = c5883a.f19561f;
                continue;
            } finally {
                c5883a.f19560e = null;
                c5883a.f19559d = null;
                c5883a.f19561f = false;
            }
            if (z) {
                break loop0;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m24756a(C5894m c5894m, Object obj, boolean z) {
        switch (c5894m.f19613b.f19607b) {
            case PostThread:
                m24764a(c5894m, obj);
                return;
            case MainThread:
                if (z) {
                    m24764a(c5894m, obj);
                    return;
                } else {
                    this.f19570i.m24771a(c5894m, obj);
                    return;
                }
            case BackgroundThread:
                if (z) {
                    this.f19571j.m24751a(c5894m, obj);
                    return;
                } else {
                    m24764a(c5894m, obj);
                    return;
                }
            case Async:
                this.f19572k.m24750a(c5894m, obj);
                return;
            default:
                z = new StringBuilder();
                z.append("Unknown thread mode: ");
                z.append(c5894m.f19613b.f19607b);
                throw new IllegalStateException(z.toString());
        }
    }

    /* renamed from: a */
    private List<Class<?>> m24754a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f19565d) {
            list = (List) f19565d.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    C5884c.m24761a((List) list, cls2.getInterfaces());
                }
                f19565d.put(cls, list);
            }
        }
        return list;
    }

    /* renamed from: a */
    static void m24761a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                C5884c.m24761a((List) list, cls.getInterfaces());
            }
        }
    }

    /* renamed from: a */
    void m24763a(C5889h c5889h) {
        Object obj = c5889h.f19597a;
        C5894m c5894m = c5889h.f19598b;
        C5889h.m24773a(c5889h);
        if (c5894m.f19615d != null) {
            m24764a(c5894m, obj);
        }
    }

    /* renamed from: a */
    void m24764a(C5894m c5894m, Object obj) {
        try {
            c5894m.f19613b.f19606a.invoke(c5894m.f19612a, new Object[]{obj});
        } catch (InvocationTargetException e) {
            m24755a(c5894m, obj, e.getCause());
        } catch (C5894m c5894m2) {
            throw new IllegalStateException("Unexpected exception", c5894m2);
        }
    }

    /* renamed from: a */
    private void m24755a(C5894m c5894m, Object obj, Throwable th) {
        String str;
        StringBuilder stringBuilder;
        if (obj instanceof C5891j) {
            if (this.f19576o) {
                str = f19562a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("SubscriberExceptionEvent subscriber ");
                stringBuilder.append(c5894m.f19612a.getClass());
                stringBuilder.append(" threw an exception");
                Log.e(str, stringBuilder.toString(), th);
                C5891j c5891j = (C5891j) obj;
                c5894m = f19562a;
                th = new StringBuilder();
                th.append("Initial event ");
                th.append(c5891j.f19604c);
                th.append(" caused exception in ");
                th.append(c5891j.f19605d);
                Log.e(c5894m, th.toString(), c5891j.f19603b);
            }
        } else if (this.f19575n) {
            throw new C5886e("Invoking subscriber failed", th);
        } else {
            if (this.f19576o) {
                str = f19562a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Could not dispatch event: ");
                stringBuilder.append(obj.getClass());
                stringBuilder.append(" to subscribing class ");
                stringBuilder.append(c5894m.f19612a.getClass());
                Log.e(str, stringBuilder.toString(), th);
            }
            if (this.f19578q) {
                m24769d(new C5891j(this, th, obj, c5894m.f19612a));
            }
        }
    }

    /* renamed from: b */
    ExecutorService m24766b() {
        return this.f19574m;
    }
}
