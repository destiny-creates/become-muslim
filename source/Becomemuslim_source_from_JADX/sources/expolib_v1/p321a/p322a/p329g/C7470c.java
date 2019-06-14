package expolib_v1.p321a.p322a.p329g;

import expolib_v1.p321a.C6244x;
import expolib_v1.p321a.p322a.C6165c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: JdkWithJettyBootPlatform */
/* renamed from: expolib_v1.a.a.g.c */
class C7470c extends C6192e {
    /* renamed from: a */
    private final Method f25918a;
    /* renamed from: b */
    private final Method f25919b;
    /* renamed from: c */
    private final Method f25920c;
    /* renamed from: d */
    private final Class<?> f25921d;
    /* renamed from: e */
    private final Class<?> f25922e;

    /* compiled from: JdkWithJettyBootPlatform */
    /* renamed from: expolib_v1.a.a.g.c$a */
    private static class C6190a implements InvocationHandler {
        /* renamed from: a */
        boolean f20037a;
        /* renamed from: b */
        String f20038b;
        /* renamed from: c */
        private final List<String> f20039c;

        public C6190a(List<String> list) {
            this.f20039c = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            obj = method.getName();
            Class returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C6165c.f19908b;
            }
            if (obj.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (obj.equals("unsupported") && Void.TYPE == returnType) {
                this.f20037a = true;
                return null;
            } else if (obj.equals("protocols") && objArr.length == 0) {
                return this.f20039c;
            } else {
                if ((obj.equals("selectProtocol") || obj.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    String str;
                    List list = (List) objArr[0];
                    method = list.size();
                    for (objArr = null; objArr < method; objArr++) {
                        if (this.f20039c.contains(list.get(objArr))) {
                            str = (String) list.get(objArr);
                            this.f20038b = str;
                            return str;
                        }
                    }
                    str = (String) this.f20039c.get(0);
                    this.f20038b = str;
                    return str;
                } else if ((!obj.equals("protocolSelected") && obj.equals("selected") == null) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f20038b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    public C7470c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f25918a = method;
        this.f25919b = method2;
        this.f25920c = method3;
        this.f25921d = cls;
        this.f25922e = cls2;
    }

    /* renamed from: a */
    public void mo5299a(SSLSocket sSLSocket, String str, List<C6244x> list) {
        str = C6192e.m25494a((List) list);
        try {
            str = Proxy.newProxyInstance(C6192e.class.getClassLoader(), new Class[]{this.f25921d, this.f25922e}, new C6190a(str));
            this.f25918a.invoke(null, new Object[]{sSLSocket, str});
        } catch (SSLSocket sSLSocket2) {
            throw new AssertionError(sSLSocket2);
        }
    }

    /* renamed from: b */
    public void mo5301b(javax.net.ssl.SSLSocket r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f25920c;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r1 = 0;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r2 = 1;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r3 = 0;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r2[r3] = r5;	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        r0.invoke(r1, r2);	 Catch:{ IllegalAccessException -> 0x000d, IllegalAccessException -> 0x000d }
        return;
    L_0x000d:
        r5 = new java.lang.AssertionError;
        r5.<init>();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.c.b(javax.net.ssl.SSLSocket):void");
    }

    /* renamed from: a */
    public java.lang.String mo5294a(javax.net.ssl.SSLSocket r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f25919b;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r1 = 1;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r1 = new java.lang.Object[r1];	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r2 = 0;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r1[r2] = r4;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r4 = 0;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r0 = r0.invoke(r4, r1);	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r0 = java.lang.reflect.Proxy.getInvocationHandler(r0);	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r0 = (expolib_v1.p321a.p322a.p329g.C7470c.C6190a) r0;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r1 = r0.f20037a;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        if (r1 != 0) goto L_0x0026;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
    L_0x0017:
        r1 = r0.f20038b;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        if (r1 != 0) goto L_0x0026;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
    L_0x001b:
        r0 = expolib_v1.p321a.p322a.p329g.C6192e.m25495b();	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r1 = 4;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r2 = "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?";	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        r0.mo5296a(r1, r2, r4);	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        return r4;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
    L_0x0026:
        r1 = r0.f20037a;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
        if (r1 == 0) goto L_0x002b;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
    L_0x002a:
        goto L_0x002d;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
    L_0x002b:
        r4 = r0.f20038b;	 Catch:{ InvocationTargetException -> 0x002e, InvocationTargetException -> 0x002e }
    L_0x002d:
        return r4;
    L_0x002e:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.c.a(javax.net.ssl.SSLSocket):java.lang.String");
    }

    /* renamed from: a */
    public static expolib_v1.p321a.p322a.p329g.C6192e m33916a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "org.eclipse.jetty.alpn.ALPN";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r1 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = "$Provider";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.<init>();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.append(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = "$ClientProvider";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.append(r4);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r8 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.<init>();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.append(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r0 = "$ServerProvider";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3.append(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r0 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r9 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r0 = "put";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = 2;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = javax.net.ssl.SSLSocket.class;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r5 = 0;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3[r5] = r4;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = 1;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3[r4] = r2;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r0 = r1.getMethod(r0, r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = "get";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r6 = javax.net.ssl.SSLSocket.class;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r6 = r1.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r2 = "remove";	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = javax.net.ssl.SSLSocket.class;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r3[r5] = r4;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r7 = r1.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r1 = new expolib_v1.a.a.g.c;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4 = r1;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r5 = r0;	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        r4.<init>(r5, r6, r7, r8, r9);	 Catch:{ ClassNotFoundException -> 0x0076, ClassNotFoundException -> 0x0076 }
        return r1;
    L_0x0076:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.c.a():expolib_v1.a.a.g.e");
    }
}
