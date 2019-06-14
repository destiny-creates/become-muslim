package de.p287a.p288a;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SubscriberMethodFinder */
/* renamed from: de.a.a.l */
class C5893l {
    /* renamed from: a */
    private static final Map<String, List<C5892k>> f19610a = new HashMap();
    /* renamed from: b */
    private final Map<Class<?>, Class<?>> f19611b = new ConcurrentHashMap();

    C5893l(List<Class<?>> list) {
        if (list != null) {
            for (Class cls : list) {
                this.f19611b.put(cls, cls);
            }
        }
    }

    /* renamed from: a */
    List<C5892k> m24778a(Class<?> cls) {
        String name = cls.getName();
        synchronized (f19610a) {
            List<C5892k> list = (List) f19610a.get(name);
        }
        if (list != null) {
            return list;
        }
        List<C5892k> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        Class cls2 = cls;
        while (cls2 != null) {
            String name2 = cls2.getName();
            if (name2.startsWith("java.") || name2.startsWith("javax.")) {
                break;
            } else if (name2.startsWith("android.")) {
                break;
            } else {
                for (Method method : cls2.getDeclaredMethods()) {
                    String name3 = method.getName();
                    if (name3.startsWith("onEvent")) {
                        int modifiers = method.getModifiers();
                        if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                            Class[] parameterTypes = method.getParameterTypes();
                            if (parameterTypes.length == 1) {
                                C5895n c5895n;
                                String substring = name3.substring("onEvent".length());
                                if (substring.length() == 0) {
                                    c5895n = C5895n.PostThread;
                                } else if (substring.equals("MainThread")) {
                                    c5895n = C5895n.MainThread;
                                } else if (substring.equals("BackgroundThread")) {
                                    c5895n = C5895n.BackgroundThread;
                                } else if (substring.equals("Async")) {
                                    c5895n = C5895n.Async;
                                } else if (!this.f19611b.containsKey(cls2)) {
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("Illegal onEvent method, check for typos: ");
                                    stringBuilder2.append(method);
                                    throw new C5886e(stringBuilder2.toString());
                                }
                                Class cls3 = parameterTypes[0];
                                stringBuilder.setLength(0);
                                stringBuilder.append(name3);
                                stringBuilder.append('>');
                                stringBuilder.append(cls3.getName());
                                if (hashSet.add(stringBuilder.toString())) {
                                    arrayList.add(new C5892k(method, c5895n, cls3));
                                }
                            } else {
                                continue;
                            }
                        } else if (!this.f19611b.containsKey(cls2)) {
                            String str = C5884c.f19562a;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Skipping method (not public, static or abstract): ");
                            stringBuilder3.append(cls2);
                            stringBuilder3.append(".");
                            stringBuilder3.append(name3);
                            Log.d(str, stringBuilder3.toString());
                        }
                    }
                }
                cls2 = cls2.getSuperclass();
            }
        }
        if (arrayList.isEmpty()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Subscriber ");
            stringBuilder4.append(cls);
            stringBuilder4.append(" has no public methods called ");
            stringBuilder4.append("onEvent");
            throw new C5886e(stringBuilder4.toString());
        }
        synchronized (f19610a) {
            f19610a.put(name, arrayList);
        }
        return arrayList;
    }
}
