package org.apache.p378b.p379a;

import org.apache.p378b.p379a.p381c.C6652e;
import org.apache.p378b.p379a.p381c.C6653f;
import org.apache.p378b.p379a.p382d.C8277c;
import org.apache.p378b.p379a.p383e.C6669d;

/* compiled from: LogManager */
/* renamed from: org.apache.b.a.b */
public class C6650b {
    /* renamed from: a */
    private static volatile C6653f f21376a;
    /* renamed from: b */
    private static final C6657c f21377b = C8277c.m42922c();
    /* renamed from: c */
    private static final String f21378c = C6650b.class.getName();

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = org.apache.p378b.p379a.p382d.C8277c.m42922c();
        f21377b = r0;
        r0 = org.apache.p378b.p379a.C6650b.class;
        r0 = r0.getName();
        f21378c = r0;
        r0 = org.apache.p378b.p379a.p383e.C6666b.m27118a();
        r1 = "log4j2.loggerContextFactory";
        r0 = r0.m27120a(r1);
        r1 = 2;
        r2 = 0;
        r3 = 1;
        if (r0 == 0) goto L_0x0052;
    L_0x001d:
        r4 = org.apache.p378b.p379a.p383e.C6665a.m27112a(r0);	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
        r5 = org.apache.p378b.p379a.p381c.C6653f.class;	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
        r5 = r5.isAssignableFrom(r4);	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
        if (r5 == 0) goto L_0x0052;	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
    L_0x0029:
        r5 = org.apache.p378b.p379a.p381c.C6653f.class;	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
        r4 = r4.asSubclass(r5);	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
        r4 = r4.newInstance();	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
        r4 = (org.apache.p378b.p379a.p381c.C6653f) r4;	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
        f21376a = r4;	 Catch:{ ClassNotFoundException -> 0x0047, Exception -> 0x0038 }
        goto L_0x0052;
    L_0x0038:
        r4 = move-exception;
        r5 = f21377b;
        r6 = "Unable to create configured LoggerContextFactory {}";
        r7 = new java.lang.Object[r1];
        r7[r2] = r0;
        r7[r3] = r4;
        r5.mo6431b(r6, r7);
        goto L_0x0052;
    L_0x0047:
        r4 = f21377b;
        r5 = "Unable to locate configured LoggerContextFactory {}";
        r6 = new java.lang.Object[r3];
        r6[r2] = r0;
        r4.mo6431b(r5, r6);
    L_0x0052:
        r0 = f21376a;
        if (r0 != 0) goto L_0x0134;
    L_0x0056:
        r0 = new java.util.TreeMap;
        r0.<init>();
        r4 = org.apache.p378b.p379a.p383e.C6667c.m27127b();
        if (r4 == 0) goto L_0x0126;
    L_0x0061:
        r4 = org.apache.p378b.p379a.p383e.C6667c.m27124a();
        r4 = r4.iterator();
    L_0x0069:
        r5 = r4.hasNext();
        if (r5 == 0) goto L_0x00a5;
    L_0x006f:
        r5 = r4.next();
        r5 = (org.apache.p378b.p379a.p381c.C6654h) r5;
        r6 = r5.m27083c();
        if (r6 == 0) goto L_0x0069;
    L_0x007b:
        r7 = r5.m27081a();	 Catch:{ Exception -> 0x0087 }
        r8 = r6.newInstance();	 Catch:{ Exception -> 0x0087 }
        r0.put(r7, r8);	 Catch:{ Exception -> 0x0087 }
        goto L_0x0069;
    L_0x0087:
        r7 = move-exception;
        r8 = f21377b;
        r9 = "Unable to create class {} specified in {}";
        r10 = 3;
        r10 = new java.lang.Object[r10];
        r6 = r6.getName();
        r10[r2] = r6;
        r5 = r5.m27086f();
        r5 = r5.toString();
        r10[r3] = r5;
        r10[r1] = r7;
        r8.mo6431b(r9, r10);
        goto L_0x0069;
    L_0x00a5:
        r1 = r0.isEmpty();
        if (r1 == 0) goto L_0x00bb;
    L_0x00ab:
        r0 = f21377b;
        r1 = "Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...";
        r0.mo6429b(r1);
        r0 = new org.apache.b.a.b.c;
        r0.<init>();
        f21376a = r0;
        goto L_0x0134;
    L_0x00bb:
        r1 = new java.lang.StringBuilder;
        r2 = "Multiple logging implementations found: \n";
        r1.<init>(r2);
        r2 = r0.entrySet();
        r2 = r2.iterator();
    L_0x00ca:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x00fe;
    L_0x00d0:
        r3 = r2.next();
        r3 = (java.util.Map.Entry) r3;
        r4 = "Factory: ";
        r1.append(r4);
        r4 = r3.getValue();
        r4 = (org.apache.p378b.p379a.p381c.C6653f) r4;
        r4 = r4.getClass();
        r4 = r4.getName();
        r1.append(r4);
        r4 = ", Weighting: ";
        r1.append(r4);
        r3 = r3.getKey();
        r1.append(r3);
        r3 = 10;
        r1.append(r3);
        goto L_0x00ca;
    L_0x00fe:
        r2 = r0.lastKey();
        r0 = r0.get(r2);
        r0 = (org.apache.p378b.p379a.p381c.C6653f) r0;
        f21376a = r0;
        r0 = "Using factory: ";
        r1.append(r0);
        r0 = f21376a;
        r0 = r0.getClass();
        r0 = r0.getName();
        r1.append(r0);
        r0 = f21377b;
        r1 = r1.toString();
        r0.mo6432c(r1);
        goto L_0x0134;
    L_0x0126:
        r0 = f21377b;
        r1 = "Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...";
        r0.mo6429b(r1);
        r0 = new org.apache.b.a.b.c;
        r0.<init>();
        f21376a = r0;
    L_0x0134:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.b.<clinit>():void");
    }

    /* renamed from: a */
    public static C6652e m27075a(ClassLoader classLoader, boolean z) {
        return f21376a.mo5703a(f21378c, classLoader, null, z);
    }

    /* renamed from: a */
    public static C6653f m27076a() {
        return f21376a;
    }

    /* renamed from: a */
    public static C6657c m27077a(Class<?> cls) {
        if (cls != null) {
            return C6650b.m27075a(cls.getClassLoader(), false).mo5702a(cls.getName());
        }
        cls = C6669d.m27130a(2);
        if (cls != null) {
            return C6650b.m27077a(cls);
        }
        throw new UnsupportedOperationException("No class provided, and an appropriate one cannot be found.");
    }

    protected C6650b() {
    }
}
