package com.google.firebase.components;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.C2872v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.a */
public final class C5340a<T> {
    /* renamed from: a */
    private final Set<Class<? super T>> f18014a;
    /* renamed from: b */
    private final Set<C5344e> f18015b;
    /* renamed from: c */
    private final int f18016c;
    /* renamed from: d */
    private final C5342c<T> f18017d;
    /* renamed from: e */
    private final Set<Class<?>> f18018e;

    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.components.a$1 */
    public static /* synthetic */ class C53381<T> {
        /* renamed from: a */
        private final T f18007a;
        /* renamed from: b */
        private final C5346l<T> f18008b;

        /* renamed from: a */
        public static C53381<Context> m22624a(Context context) {
            return new C53381(context, new C6905k());
        }

        private C53381(T t, C5346l<T> c5346l) {
            this.f18007a = t;
            this.f18008b = c5346l;
        }

        /* renamed from: a */
        public List<C5343d> m22628a() {
            return C53381.m22627b(this.f18008b.mo4879a(this.f18007a));
        }

        /* renamed from: b */
        private static List<C5343d> m22627b(List<String> list) {
            List<C5343d> arrayList = new ArrayList();
            for (String cls : list) {
                try {
                    Class cls2 = Class.forName(cls);
                    if (C5343d.class.isAssignableFrom(cls2)) {
                        arrayList.add((C5343d) cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } else {
                        Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[]{cls, "com.google.firebase.components.ComponentRegistrar"}));
                    }
                } catch (Throwable e) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{cls}), e);
                } catch (Throwable e2) {
                    Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{cls}), e2);
                } catch (Throwable e22) {
                    Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{cls}), e22);
                } catch (Throwable e222) {
                    Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{cls}), e222);
                } catch (Throwable e2222) {
                    Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{cls}), e2222);
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        static List<C5340a<?>> m22625a(List<C5340a<?>> list) {
            Map hashMap = new HashMap(list.size());
            for (C5340a c5340a : list) {
                C5347n c5347n = new C5347n(c5340a);
                for (Class put : c5340a.m22639a()) {
                    if (hashMap.put(put, c5347n) != null) {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{(Class) r2.next()}));
                    }
                }
            }
            for (C5347n c5347n2 : hashMap.values()) {
                for (C5344e c5344e : c5347n2.m22655b().m22640b()) {
                    if (c5344e.m22651c()) {
                        C5347n c5347n3 = (C5347n) hashMap.get(c5344e.m22649a());
                        if (c5347n3 != null) {
                            c5347n2.m22654a(c5347n3);
                            c5347n3.m22656b(c5347n2);
                        }
                    }
                }
            }
            Set<C5347n> hashSet = new HashSet(hashMap.values());
            Set a = C53381.m22626a((Set) hashSet);
            List<C5340a<?>> arrayList = new ArrayList();
            while (!a.isEmpty()) {
                c5347n = (C5347n) a.iterator().next();
                a.remove(c5347n);
                arrayList.add(c5347n.m22655b());
                for (C5347n c5347n4 : c5347n.m22653a()) {
                    c5347n4.m22657c(c5347n);
                    if (c5347n4.m22658c()) {
                        a.add(c5347n4);
                    }
                }
            }
            if (arrayList.size() == list.size()) {
                Collections.reverse(arrayList);
                return arrayList;
            }
            list = new ArrayList();
            for (C5347n c5347n5 : hashSet) {
                if (!(c5347n5.m22658c() || c5347n5.m22659d())) {
                    list.add(c5347n5.m22655b());
                }
            }
            throw new C6901f(list);
        }

        /* renamed from: a */
        private static Set<C5347n> m22626a(Set<C5347n> set) {
            Set<C5347n> hashSet = new HashSet();
            for (C5347n c5347n : set) {
                if (c5347n.m22658c()) {
                    hashSet.add(c5347n);
                }
            }
            return hashSet;
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.components.a$a */
    public static class C5339a<T> {
        /* renamed from: a */
        private final Set<Class<? super T>> f18009a;
        /* renamed from: b */
        private final Set<C5344e> f18010b;
        /* renamed from: c */
        private int f18011c;
        /* renamed from: d */
        private C5342c<T> f18012d;
        /* renamed from: e */
        private Set<Class<?>> f18013e;

        private C5339a(Class<T> cls, Class<? super T>... clsArr) {
            this.f18009a = new HashSet();
            this.f18010b = new HashSet();
            int i = 0;
            this.f18011c = 0;
            this.f18013e = new HashSet();
            C2872v.a(cls, "Null interface");
            this.f18009a.add(cls);
            cls = clsArr.length;
            while (i < cls) {
                C2872v.a(clsArr[i], "Null interface");
                i++;
            }
            Collections.addAll(this.f18009a, clsArr);
        }

        /* renamed from: a */
        public C5339a<T> m22632a(C5344e c5344e) {
            C2872v.a(c5344e, "Null dependency");
            C2872v.b(this.f18009a.contains(c5344e.m22649a()) ^ 1, "Components are not allowed to depend on interfaces they themselves provide.");
            this.f18010b.add(c5344e);
            return this;
        }

        /* renamed from: a */
        public C5339a<T> m22630a() {
            return m22629a(1);
        }

        /* renamed from: b */
        public C5339a<T> m22633b() {
            return m22629a(2);
        }

        /* renamed from: a */
        private C5339a<T> m22629a(int i) {
            C2872v.a(this.f18011c == 0, "Instantiation type has already been set.");
            this.f18011c = i;
            return this;
        }

        /* renamed from: a */
        public C5339a<T> m22631a(C5342c<T> c5342c) {
            this.f18012d = (C5342c) C2872v.a(c5342c, "Null factory");
            return this;
        }

        /* renamed from: c */
        public C5340a<T> m22634c() {
            C2872v.a(this.f18012d != null, "Missing required property: factory.");
            return new C5340a(new HashSet(this.f18009a), new HashSet(this.f18010b), this.f18011c, this.f18012d, this.f18013e);
        }
    }

    /* renamed from: a */
    static /* synthetic */ Object m22638a(Object obj) {
        return obj;
    }

    private C5340a(Set<Class<? super T>> set, Set<C5344e> set2, int i, C5342c<T> c5342c, Set<Class<?>> set3) {
        this.f18014a = Collections.unmodifiableSet(set);
        this.f18015b = Collections.unmodifiableSet(set2);
        this.f18016c = i;
        this.f18017d = c5342c;
        this.f18018e = Collections.unmodifiableSet(set3);
    }

    /* renamed from: a */
    public final Set<Class<? super T>> m22639a() {
        return this.f18014a;
    }

    /* renamed from: b */
    public final Set<C5344e> m22640b() {
        return this.f18015b;
    }

    /* renamed from: c */
    public final C5342c<T> m22641c() {
        return this.f18017d;
    }

    /* renamed from: d */
    public final Set<Class<?>> m22642d() {
        return this.f18018e;
    }

    /* renamed from: e */
    public final boolean m22643e() {
        return this.f18016c == 1;
    }

    /* renamed from: f */
    public final boolean m22644f() {
        return this.f18016c == 2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Component<");
        stringBuilder.append(Arrays.toString(this.f18014a.toArray()));
        stringBuilder.append(">{");
        stringBuilder.append(this.f18016c);
        stringBuilder.append(", deps=");
        stringBuilder.append(Arrays.toString(this.f18015b.toArray()));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static <T> C5339a<T> m22635a(Class<T> cls) {
        return new C5339a(cls, new Class[0]);
    }

    /* renamed from: a */
    public static <T> C5339a<T> m22636a(Class<T> cls, Class<? super T>... clsArr) {
        return new C5339a(cls, clsArr);
    }

    @SafeVarargs
    /* renamed from: a */
    public static <T> C5340a<T> m22637a(T t, Class<T> cls, Class<? super T>... clsArr) {
        return C5340a.m22636a(cls, clsArr).m22631a(C6904j.m32362a((Object) t)).m22634c();
    }
}
