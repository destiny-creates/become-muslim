package expolib_v1.p321a.p322a.p329g;

import java.lang.reflect.Method;

/* compiled from: OptionalMethod */
/* renamed from: expolib_v1.a.a.g.d */
class C6191d<T> {
    /* renamed from: a */
    private final Class<?> f20040a;
    /* renamed from: b */
    private final String f20041b;
    /* renamed from: c */
    private final Class[] f20042c;

    public C6191d(Class<?> cls, String str, Class... clsArr) {
        this.f20040a = cls;
        this.f20041b = str;
        this.f20042c = clsArr;
    }

    /* renamed from: a */
    public boolean m25488a(T t) {
        return m25485a(t.getClass()) != null ? true : null;
    }

    /* renamed from: a */
    public java.lang.Object m25487a(T r3, java.lang.Object... r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3.getClass();
        r0 = r2.m25485a(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r3 = r0.invoke(r3, r4);	 Catch:{ IllegalAccessException -> 0x0011 }
        return r3;
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.d.a(java.lang.Object, java.lang.Object[]):java.lang.Object");
    }

    /* renamed from: b */
    public Object m25489b(T t, Object... objArr) {
        try {
            return m25487a(t, objArr);
        } catch (T t2) {
            t2 = t2.getTargetException();
            if ((t2 instanceof RuntimeException) != null) {
                throw ((RuntimeException) t2);
            }
            objArr = new AssertionError("Unexpected exception");
            objArr.initCause(t2);
            throw objArr;
        }
    }

    /* renamed from: c */
    public Object m25490c(T t, Object... objArr) {
        Method a = m25485a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (T t2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpectedly could not call: ");
                stringBuilder.append(a);
                objArr = new AssertionError(stringBuilder.toString());
                objArr.initCause(t2);
                throw objArr;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Method ");
        stringBuilder2.append(this.f20041b);
        stringBuilder2.append(" not supported for object ");
        stringBuilder2.append(t2);
        throw new AssertionError(stringBuilder2.toString());
    }

    /* renamed from: d */
    public Object m25491d(T t, Object... objArr) {
        try {
            return m25490c(t, objArr);
        } catch (T t2) {
            t2 = t2.getTargetException();
            if ((t2 instanceof RuntimeException) != null) {
                throw ((RuntimeException) t2);
            }
            objArr = new AssertionError("Unexpected exception");
            objArr.initCause(t2);
            throw objArr;
        }
    }

    /* renamed from: a */
    private Method m25485a(Class<?> cls) {
        if (this.f20041b == null) {
            return null;
        }
        cls = C6191d.m25486a(cls, this.f20041b, this.f20042c);
        if (cls == null || this.f20040a == null || this.f20040a.isAssignableFrom(cls.getReturnType())) {
            return cls;
        }
        return null;
    }

    /* renamed from: a */
    private static java.lang.reflect.Method m25486a(java.lang.Class<?> r1, java.lang.String r2, java.lang.Class[] r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r1.getMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x000d }
        r2 = r1.getModifiers();	 Catch:{ NoSuchMethodException -> 0x000e }
        r2 = r2 & 1;
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        r1 = r0;
    L_0x000e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.g.d.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
