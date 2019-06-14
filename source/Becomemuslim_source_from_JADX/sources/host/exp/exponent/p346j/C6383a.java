package host.exp.exponent.p346j;

import host.exp.exponent.p334a.C6289b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AsyncCondition */
/* renamed from: host.exp.exponent.j.a */
public class C6383a {
    /* renamed from: a */
    private static final String f20672a = "a";
    /* renamed from: b */
    private static final Map<String, C6382a> f20673b = new HashMap();

    /* compiled from: AsyncCondition */
    /* renamed from: host.exp.exponent.j.a$a */
    public interface C6382a {
        /* renamed from: a */
        boolean mo5390a();

        /* renamed from: b */
        void mo5391b();
    }

    /* renamed from: a */
    public static void m26190a(String str, C6382a c6382a) {
        if (c6382a.mo5390a()) {
            c6382a.mo5391b();
        } else {
            synchronized (f20673b) {
                if (f20673b.containsKey(str)) {
                    c6382a = f20672a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Map already contains entry for key ");
                    stringBuilder.append(str);
                    stringBuilder.append(". Ignoring.");
                    C6289b.m25953c(c6382a, stringBuilder.toString());
                    return;
                }
                f20673b.put(str, c6382a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m26189a(java.lang.String r4) {
        /*
        r0 = f20673b;
        monitor-enter(r0);
        r1 = f20673b;	 Catch:{ all -> 0x0036 }
        r1 = r1.containsKey(r4);	 Catch:{ all -> 0x0036 }
        if (r1 != 0) goto L_0x0023;
    L_0x000b:
        r1 = f20672a;	 Catch:{ all -> 0x0036 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0036 }
        r2.<init>();	 Catch:{ all -> 0x0036 }
        r3 = "Could not find listener for key: ";
        r2.append(r3);	 Catch:{ all -> 0x0036 }
        r2.append(r4);	 Catch:{ all -> 0x0036 }
        r4 = r2.toString();	 Catch:{ all -> 0x0036 }
        android.util.Log.w(r1, r4);	 Catch:{ all -> 0x0036 }
        monitor-exit(r0);	 Catch:{ all -> 0x0036 }
        return;
    L_0x0023:
        r1 = f20673b;	 Catch:{ all -> 0x0036 }
        r4 = r1.remove(r4);	 Catch:{ all -> 0x0036 }
        r4 = (host.exp.exponent.p346j.C6383a.C6382a) r4;	 Catch:{ all -> 0x0036 }
        r1 = r4.mo5390a();	 Catch:{ all -> 0x0036 }
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r4.mo5391b();	 Catch:{ all -> 0x0036 }
    L_0x0034:
        monitor-exit(r0);	 Catch:{ all -> 0x0036 }
        return;
    L_0x0036:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0036 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.j.a.a(java.lang.String):void");
    }

    /* renamed from: b */
    public static void m26191b(String str) {
        synchronized (f20673b) {
            f20673b.remove(str);
        }
    }
}
