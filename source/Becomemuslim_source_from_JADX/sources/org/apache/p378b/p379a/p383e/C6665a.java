package org.apache.p378b.p379a.p383e;

import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedHashSet;

/* compiled from: LoaderUtil */
/* renamed from: org.apache.b.a.e.a */
public final class C6665a {
    /* renamed from: a */
    private static final SecurityManager f21407a = System.getSecurityManager();
    /* renamed from: b */
    private static Boolean f21408b;
    /* renamed from: c */
    private static final boolean f21409c;
    /* renamed from: d */
    private static final PrivilegedAction<ClassLoader> f21410d = new C6663a();

    /* compiled from: LoaderUtil */
    /* renamed from: org.apache.b.a.e.a$a */
    private static class C6663a implements PrivilegedAction<ClassLoader> {
        private C6663a() {
        }

        public /* synthetic */ Object run() {
            return m27109a();
        }

        /* renamed from: a */
        public ClassLoader m27109a() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader;
            }
            contextClassLoader = C6665a.class.getClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = ClassLoader.getSystemClassLoader();
            }
            return contextClassLoader;
        }
    }

    /* compiled from: LoaderUtil */
    /* renamed from: org.apache.b.a.e.a$b */
    static class C6664b {
        /* renamed from: a */
        private final ClassLoader f21405a;
        /* renamed from: b */
        private final URL f21406b;

        public C6664b(ClassLoader classLoader, URL url) {
            this.f21405a = classLoader;
            this.f21406b = url;
        }

        /* renamed from: a */
        public ClassLoader m27110a() {
            return this.f21405a;
        }

        /* renamed from: b */
        public URL m27111b() {
            return this.f21406b;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
            r4 = this;
            r0 = 1;
            if (r4 != r5) goto L_0x0004;
        L_0x0003:
            return r0;
        L_0x0004:
            r1 = 0;
            if (r5 == 0) goto L_0x003d;
        L_0x0007:
            r2 = r4.getClass();
            r3 = r5.getClass();
            if (r2 == r3) goto L_0x0012;
        L_0x0011:
            goto L_0x003d;
        L_0x0012:
            r5 = (org.apache.p378b.p379a.p383e.C6665a.C6664b) r5;
            r2 = r4.f21405a;
            if (r2 == 0) goto L_0x0023;
        L_0x0018:
            r2 = r4.f21405a;
            r3 = r5.f21405a;
            r2 = r2.equals(r3);
            if (r2 != 0) goto L_0x0028;
        L_0x0022:
            goto L_0x0027;
        L_0x0023:
            r2 = r5.f21405a;
            if (r2 == 0) goto L_0x0028;
        L_0x0027:
            return r1;
        L_0x0028:
            r2 = r4.f21406b;
            if (r2 == 0) goto L_0x0037;
        L_0x002c:
            r2 = r4.f21406b;
            r5 = r5.f21406b;
            r5 = r2.equals(r5);
            if (r5 != 0) goto L_0x003c;
        L_0x0036:
            goto L_0x003b;
        L_0x0037:
            r5 = r5.f21406b;
            if (r5 == 0) goto L_0x003c;
        L_0x003b:
            return r1;
        L_0x003c:
            return r0;
        L_0x003d:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.e.a.b.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (this.f21405a != null ? this.f21405a.hashCode() : 0) * 31;
            if (this.f21406b != null) {
                i = this.f21406b.hashCode();
            }
            return hashCode + i;
        }
    }

    private C6665a() {
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.System.getSecurityManager();
        f21407a = r0;
        r0 = new org.apache.b.a.e.a$a;
        r1 = 0;
        r0.<init>();
        f21410d = r0;
        r0 = f21407a;
        r1 = 0;
        if (r0 == 0) goto L_0x0024;
    L_0x0013:
        r0 = f21407a;	 Catch:{ SecurityException -> 0x0020 }
        r2 = new java.lang.RuntimePermission;	 Catch:{ SecurityException -> 0x0020 }
        r3 = "getClassLoader";	 Catch:{ SecurityException -> 0x0020 }
        r2.<init>(r3);	 Catch:{ SecurityException -> 0x0020 }
        r0.checkPermission(r2);	 Catch:{ SecurityException -> 0x0020 }
        goto L_0x0021;
    L_0x0020:
        r1 = 1;
    L_0x0021:
        f21409c = r1;
        goto L_0x0026;
    L_0x0024:
        f21409c = r1;
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.e.a.<clinit>():void");
    }

    /* renamed from: a */
    public static ClassLoader m27113a() {
        if (f21409c) {
            return C6665a.class.getClassLoader();
        }
        return (ClassLoader) (f21407a == null ? f21410d.run() : AccessController.doPrivileged(f21410d));
    }

    /* renamed from: a */
    public static java.lang.Class<?> m27112a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = org.apache.p378b.p379a.p383e.C6665a.m27115b();
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r1 = java.lang.Class.forName(r1);
        return r1;
    L_0x000b:
        r0 = org.apache.p378b.p379a.p383e.C6665a.m27113a();	 Catch:{ Throwable -> 0x0014 }
        r0 = r0.loadClass(r1);	 Catch:{ Throwable -> 0x0014 }
        return r0;
    L_0x0014:
        r1 = java.lang.Class.forName(r1);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.e.a.a(java.lang.String):java.lang.Class<?>");
    }

    /* renamed from: b */
    private static boolean m27115b() {
        if (f21408b == null) {
            String a = C6666b.m27118a().m27121a("log4j.ignoreTCL", null);
            boolean z = (a == null || "false".equalsIgnoreCase(a.trim())) ? false : true;
            f21408b = Boolean.valueOf(z);
        }
        return f21408b.booleanValue();
    }

    /* renamed from: b */
    public static Collection<URL> m27114b(String str) {
        String<C6664b> c = C6665a.m27116c(str);
        Collection<URL> linkedHashSet = new LinkedHashSet(c.size());
        for (C6664b b : c) {
            linkedHashSet.add(b.m27111b());
        }
        return linkedHashSet;
    }

    /* renamed from: c */
    static Collection<C6664b> m27116c(String str) {
        r0 = new ClassLoader[3];
        int i = 0;
        r0[0] = C6665a.m27113a();
        r0[1] = C6665a.class.getClassLoader();
        r0[2] = ClassLoader.getSystemClassLoader();
        Collection<C6664b> linkedHashSet = new LinkedHashSet();
        int length = r0.length;
        while (i < length) {
            ClassLoader classLoader = r0[i];
            if (classLoader != null) {
                try {
                    Enumeration resources = classLoader.getResources(str);
                    while (resources.hasMoreElements()) {
                        linkedHashSet.add(new C6664b(classLoader, (URL) resources.nextElement()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
        return linkedHashSet;
    }
}
