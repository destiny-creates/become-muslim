package android.arch.lifecycle;

import android.arch.lifecycle.C0074c.C0072a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ClassesInfoCache */
/* renamed from: android.arch.lifecycle.a */
class C0070a {
    /* renamed from: a */
    static C0070a f197a = new C0070a();
    /* renamed from: b */
    private final Map<Class, C0068a> f198b = new HashMap();
    /* renamed from: c */
    private final Map<Class, Boolean> f199c = new HashMap();

    /* compiled from: ClassesInfoCache */
    /* renamed from: android.arch.lifecycle.a$a */
    static class C0068a {
        /* renamed from: a */
        final Map<C0072a, List<C0069b>> f193a = new HashMap();
        /* renamed from: b */
        final Map<C0069b, C0072a> f194b;

        C0068a(Map<C0069b, C0072a> map) {
            this.f194b = map;
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                C0072a c0072a = (C0072a) entry.getValue();
                List list = (List) this.f193a.get(c0072a);
                if (list == null) {
                    list = new ArrayList();
                    this.f193a.put(c0072a, list);
                }
                list.add(entry.getKey());
            }
        }

        /* renamed from: a */
        void m170a(C0076e c0076e, C0072a c0072a, Object obj) {
            C0068a.m169a((List) this.f193a.get(c0072a), c0076e, c0072a, obj);
            C0068a.m169a((List) this.f193a.get(C0072a.ON_ANY), c0076e, c0072a, obj);
        }

        /* renamed from: a */
        private static void m169a(List<C0069b> list, C0076e c0076e, C0072a c0072a, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0069b) list.get(size)).m171a(c0076e, c0072a, obj);
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache */
    /* renamed from: android.arch.lifecycle.a$b */
    static class C0069b {
        /* renamed from: a */
        final int f195a;
        /* renamed from: b */
        final Method f196b;

        C0069b(int i, Method method) {
            this.f195a = i;
            this.f196b = method;
            this.f196b.setAccessible(true);
        }

        /* renamed from: a */
        void m171a(C0076e c0076e, C0072a c0072a, Object obj) {
            try {
                switch (this.f195a) {
                    case 0:
                        this.f196b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f196b.invoke(obj, new Object[]{c0076e});
                        return;
                    case 2:
                        this.f196b.invoke(obj, new Object[]{c0076e, c0072a});
                        return;
                    default:
                        return;
                }
            } catch (C0076e c0076e2) {
                throw new RuntimeException("Failed to call observer method", c0076e2.getCause());
            } catch (C0076e c0076e22) {
                throw new RuntimeException(c0076e22);
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    C0069b c0069b = (C0069b) obj;
                    if (this.f195a != c0069b.f195a || this.f196b.getName().equals(c0069b.f196b.getName()) == null) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f195a * 31) + this.f196b.getName().hashCode();
        }
    }

    C0070a() {
    }

    /* renamed from: a */
    boolean m175a(Class cls) {
        if (this.f199c.containsKey(cls)) {
            return ((Boolean) this.f199c.get(cls)).booleanValue();
        }
        Method[] c = m174c(cls);
        for (Method annotation : c) {
            if (((C0082l) annotation.getAnnotation(C0082l.class)) != null) {
                m172a(cls, c);
                return true;
            }
        }
        this.f199c.put(cls, Boolean.valueOf(false));
        return false;
    }

    /* renamed from: c */
    private Method[] m174c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (Class cls2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", cls2);
        }
    }

    /* renamed from: b */
    C0068a m176b(Class cls) {
        C0068a c0068a = (C0068a) this.f198b.get(cls);
        if (c0068a != null) {
            return c0068a;
        }
        return m172a(cls, null);
    }

    /* renamed from: a */
    private void m173a(Map<C0069b, C0072a> map, C0069b c0069b, C0072a c0072a, Class cls) {
        C0072a c0072a2 = (C0072a) map.get(c0069b);
        if (c0072a2 != null) {
            if (c0072a != c0072a2) {
                map = c0069b.f196b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Method ");
                stringBuilder.append(map.getName());
                stringBuilder.append(" in ");
                stringBuilder.append(cls.getName());
                stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous");
                stringBuilder.append(" value ");
                stringBuilder.append(c0072a2);
                stringBuilder.append(", new value ");
                stringBuilder.append(c0072a);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (c0072a2 == null) {
            map.put(c0069b, c0072a);
        }
    }

    /* renamed from: a */
    private C0068a m172a(Class cls, Method[] methodArr) {
        Class superclass = cls.getSuperclass();
        Map hashMap = new HashMap();
        if (superclass != null) {
            C0068a b = m176b(superclass);
            if (b != null) {
                hashMap.putAll(b.f194b);
            }
        }
        for (Class b2 : cls.getInterfaces()) {
            for (Entry entry : m176b(b2).f194b.entrySet()) {
                m173a(hashMap, (C0069b) entry.getKey(), (C0072a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m174c(cls);
        }
        boolean z = false;
        for (Method method : r13) {
            C0082l c0082l = (C0082l) method.getAnnotation(C0082l.class);
            if (c0082l != null) {
                int i;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(C0076e.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                C0072a a = c0082l.m191a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(C0072a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a == C0072a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m173a(hashMap, new C0069b(i, method), a, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        methodArr = new C0068a(hashMap);
        this.f198b.put(cls, methodArr);
        this.f199c.put(cls, Boolean.valueOf(z));
        return methodArr;
    }
}
