package org.apache.p378b.p379a.p383e;

import java.lang.reflect.Method;
import org.apache.p378b.p379a.C6657c;
import org.apache.p378b.p379a.p382d.C8277c;

/* compiled from: ReflectionUtil */
/* renamed from: org.apache.b.a.e.d */
public final class C6669d {
    /* renamed from: a */
    static final int f21419a;
    /* renamed from: b */
    private static final C6657c f21420b = C8277c.m42922c();
    /* renamed from: c */
    private static final boolean f21421c;
    /* renamed from: d */
    private static final Method f21422d;
    /* renamed from: e */
    private static final C6668a f21423e;

    /* compiled from: ReflectionUtil */
    /* renamed from: org.apache.b.a.e.d$a */
    static final class C6668a extends SecurityManager {
        C6668a() {
        }

        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = org.apache.p378b.p379a.p382d.C8277c.m42922c();
        f21420b = r0;
        r0 = -1;
        r1 = 0;
        r2 = 1;
        r3 = 0;
        r4 = "sun.reflect.Reflection";	 Catch:{ Exception -> 0x006c }
        r4 = org.apache.p378b.p379a.p383e.C6665a.m27112a(r4);	 Catch:{ Exception -> 0x006c }
        r5 = "getCallerClass";	 Catch:{ Exception -> 0x006c }
        r6 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x006c }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x006c }
        r6[r3] = r7;	 Catch:{ Exception -> 0x006c }
        r5 = r4.getDeclaredMethod(r5, r6);	 Catch:{ Exception -> 0x006c }
        r6 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x006c }
        r7 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x006c }
        r6[r3] = r7;	 Catch:{ Exception -> 0x006c }
        r6 = r5.invoke(r1, r6);	 Catch:{ Exception -> 0x006c }
        r7 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x006c }
        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x006c }
        r7[r3] = r8;	 Catch:{ Exception -> 0x006c }
        r7 = r5.invoke(r1, r7);	 Catch:{ Exception -> 0x006c }
        if (r6 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x006c }
    L_0x0036:
        if (r6 == r4) goto L_0x0039;	 Catch:{ Exception -> 0x006c }
    L_0x0038:
        goto L_0x0060;	 Catch:{ Exception -> 0x006c }
    L_0x0039:
        r6 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x006c }
        r7 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x006c }
        r6[r3] = r7;	 Catch:{ Exception -> 0x006c }
        r6 = r5.invoke(r1, r6);	 Catch:{ Exception -> 0x006c }
        if (r6 != r4) goto L_0x005e;	 Catch:{ Exception -> 0x006c }
    L_0x0047:
        r4 = f21420b;	 Catch:{ Exception -> 0x006c }
        r6 = "You are using Java 1.7.0_25 which has a broken implementation of Reflection.getCallerClass.";	 Catch:{ Exception -> 0x006c }
        r4.mo6432c(r6);	 Catch:{ Exception -> 0x006c }
        r4 = f21420b;	 Catch:{ Exception -> 0x006c }
        r6 = "You should upgrade to at least Java 1.7.0_40 or later.";	 Catch:{ Exception -> 0x006c }
        r4.mo6432c(r6);	 Catch:{ Exception -> 0x006c }
        r4 = f21420b;	 Catch:{ Exception -> 0x006c }
        r6 = "Using stack depth compensation offset of 1 due to Java 7u25.";	 Catch:{ Exception -> 0x006c }
        r4.mo6425a(r6);	 Catch:{ Exception -> 0x006c }
        r0 = 1;	 Catch:{ Exception -> 0x006c }
        goto L_0x0075;	 Catch:{ Exception -> 0x006c }
    L_0x005e:
        r0 = 0;	 Catch:{ Exception -> 0x006c }
        goto L_0x0075;	 Catch:{ Exception -> 0x006c }
    L_0x0060:
        r4 = f21420b;	 Catch:{ Exception -> 0x006c }
        r5 = "Unexpected return value from Reflection.getCallerClass(): {}";	 Catch:{ Exception -> 0x006c }
        r6 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x006c }
        r6[r3] = r7;	 Catch:{ Exception -> 0x006c }
        r4.mo6434c(r5, r6);	 Catch:{ Exception -> 0x006c }
        goto L_0x0074;
    L_0x006c:
        r4 = move-exception;
        r5 = f21420b;
        r6 = "sun.reflect.Reflection.getCallerClass is not supported. ReflectionUtil.getCallerClass will be much slower due to this.";
        r5.mo6433c(r6, r4);
    L_0x0074:
        r5 = r1;
    L_0x0075:
        if (r5 == 0) goto L_0x0078;
    L_0x0077:
        goto L_0x0079;
    L_0x0078:
        r2 = 0;
    L_0x0079:
        f21421c = r2;
        f21422d = r5;
        f21419a = r0;
        r0 = java.lang.System.getSecurityManager();	 Catch:{ SecurityException -> 0x0095 }
        if (r0 == 0) goto L_0x008f;	 Catch:{ SecurityException -> 0x0095 }
    L_0x0085:
        r2 = new java.lang.RuntimePermission;	 Catch:{ SecurityException -> 0x0095 }
        r3 = "createSecurityManager";	 Catch:{ SecurityException -> 0x0095 }
        r2.<init>(r3);	 Catch:{ SecurityException -> 0x0095 }
        r0.checkPermission(r2);	 Catch:{ SecurityException -> 0x0095 }
    L_0x008f:
        r0 = new org.apache.b.a.e.d$a;	 Catch:{ SecurityException -> 0x0095 }
        r0.<init>();	 Catch:{ SecurityException -> 0x0095 }
        goto L_0x009d;
    L_0x0095:
        r0 = f21420b;
        r2 = "Not allowed to create SecurityManager. Falling back to slowest ReflectionUtil implementation.";
        r0.mo6425a(r2);
        r0 = r1;
    L_0x009d:
        f21423e = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.e.d.<clinit>():void");
    }

    /* renamed from: a */
    public static boolean m27131a() {
        return f21421c;
    }

    /* renamed from: a */
    public static Class<?> m27130a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        } else if (C6669d.m27131a()) {
            try {
                return (Class) f21422d.invoke(null, new Object[]{Integer.valueOf((i + 1) + f21419a)});
            } catch (Exception e) {
                f21420b.mo6431b("Error in ReflectionUtil.getCallerClass({}).", Integer.valueOf(i), e);
                return null;
            }
        } else {
            try {
                return C6665a.m27112a(C6669d.m27133b(i + 1).getClassName());
            } catch (ClassNotFoundException e2) {
                f21420b.mo6431b("Could not find class in ReflectionUtil.getCallerClass({}).", Integer.valueOf(i), e2);
                return null;
            }
        }
    }

    /* renamed from: b */
    static StackTraceElement m27133b(int i) {
        int i2 = 0;
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (C6669d.m27132a(stackTraceElement)) {
                if (i2 == i) {
                    return stackTraceElement;
                }
                i2++;
            }
        }
        f21420b.mo6431b("Could not find an appropriate StackTraceElement at index {}", Integer.valueOf(i));
        throw new IndexOutOfBoundsException(Integer.toString(i));
    }

    /* renamed from: a */
    private static boolean m27132a(StackTraceElement stackTraceElement) {
        if (stackTraceElement.isNativeMethod()) {
            return false;
        }
        String className = stackTraceElement.getClassName();
        if (className.startsWith("sun.reflect.")) {
            return false;
        }
        stackTraceElement = stackTraceElement.getMethodName();
        if (className.startsWith("java.lang.reflect.") && (stackTraceElement.equals("invoke") || stackTraceElement.equals("newInstance"))) {
            return false;
        }
        if (className.equals("java.lang.Class") && stackTraceElement.equals("newInstance")) {
            return false;
        }
        if (!className.equals("java.lang.invoke.MethodHandle") || stackTraceElement.startsWith("invoke") == null) {
            return true;
        }
        return false;
    }
}
