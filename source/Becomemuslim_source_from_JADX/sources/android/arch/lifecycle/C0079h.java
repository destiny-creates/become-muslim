package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling */
/* renamed from: android.arch.lifecycle.h */
public class C0079h {
    /* renamed from: a */
    private static Map<Class, Integer> f210a = new HashMap();
    /* renamed from: b */
    private static Map<Class, List<Constructor<? extends C0071b>>> f211b = new HashMap();

    /* renamed from: a */
    static GenericLifecycleObserver m183a(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class cls = obj.getClass();
        if (C0079h.m187b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) f211b.get(cls);
        int i = 0;
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(C0079h.m184a((Constructor) list.get(0), obj));
        }
        C0071b[] c0071bArr = new C0071b[list.size()];
        while (i < list.size()) {
            c0071bArr[i] = C0079h.m184a((Constructor) list.get(i), obj);
            i++;
        }
        return new CompositeGeneratedAdaptersObserver(c0071bArr);
    }

    /* renamed from: a */
    private static C0071b m184a(Constructor<? extends C0071b> constructor, Object obj) {
        try {
            return (C0071b) constructor.newInstance(new Object[]{obj});
        } catch (Constructor<? extends C0071b> constructor2) {
            throw new RuntimeException(constructor2);
        } catch (Constructor<? extends C0071b> constructor22) {
            throw new RuntimeException(constructor22);
        } catch (Constructor<? extends C0071b> constructor222) {
            throw new RuntimeException(constructor222);
        }
    }

    /* renamed from: a */
    private static java.lang.reflect.Constructor<? extends android.arch.lifecycle.C0071b> m186a(java.lang.Class<?> r4) {
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
        r0 = r4.getPackage();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1 = r4.getCanonicalName();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        if (r0 == 0) goto L_0x000f;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x000a:
        r0 = r0.getName();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        goto L_0x0011;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x000f:
        r0 = "";	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0011:
        r2 = r0.isEmpty();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        if (r2 == 0) goto L_0x0019;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0018:
        goto L_0x0022;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0019:
        r2 = r0.length();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2 = r2 + r3;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1 = r1.substring(r2);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0022:
        r1 = android.arch.lifecycle.C0079h.m185a(r1);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2 = r0.isEmpty();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        if (r2 == 0) goto L_0x002d;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x002c:
        goto L_0x0041;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x002d:
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r0 = ".";	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2.append(r1);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0041:
        r0 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1[r2] = r4;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r4 = r0.getDeclaredConstructor(r1);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r0 = r4.isAccessible();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        if (r0 != 0) goto L_0x0057;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0054:
        r4.setAccessible(r3);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0057:
        return r4;
    L_0x0058:
        r4 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r4);
        throw r0;
    L_0x005f:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.h.a(java.lang.Class):java.lang.reflect.Constructor<? extends android.arch.lifecycle.b>");
    }

    /* renamed from: b */
    private static int m187b(Class<?> cls) {
        if (f210a.containsKey(cls)) {
            return ((Integer) f210a.get(cls)).intValue();
        }
        int c = C0079h.m188c(cls);
        f210a.put(cls, Integer.valueOf(c));
        return c;
    }

    /* renamed from: c */
    private static int m188c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor a = C0079h.m186a((Class) cls);
        if (a != null) {
            f211b.put(cls, Collections.singletonList(a));
            return 2;
        } else if (C0070a.f197a.m175a(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            Object obj = null;
            if (C0079h.m189d(superclass)) {
                if (C0079h.m187b(superclass) == 1) {
                    return 1;
                }
                obj = new ArrayList((Collection) f211b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (C0079h.m189d(cls2)) {
                    if (C0079h.m187b(cls2) == 1) {
                        return 1;
                    }
                    if (obj == null) {
                        obj = new ArrayList();
                    }
                    obj.addAll((Collection) f211b.get(cls2));
                }
            }
            if (obj == null) {
                return 1;
            }
            f211b.put(cls, obj);
            return 2;
        }
    }

    /* renamed from: d */
    private static boolean m189d(Class<?> cls) {
        return (cls == null || C0075d.class.isAssignableFrom(cls) == null) ? null : true;
    }

    /* renamed from: a */
    public static String m185a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.replace(".", "_"));
        stringBuilder.append("_LifecycleAdapter");
        return stringBuilder.toString();
    }
}
