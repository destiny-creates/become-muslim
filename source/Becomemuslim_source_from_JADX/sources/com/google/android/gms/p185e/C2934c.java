package com.google.android.gms.p185e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.e.c */
public class C2934c {
    /* renamed from: a */
    public static final Object f7486a = new Object();
    /* renamed from: b */
    private static final String[] f7487b = "gtm.lifetime".toString().split("\\.");
    /* renamed from: c */
    private static final Pattern f7488c = Pattern.compile("(\\d+)\\s*([smhd]?)");
    /* renamed from: d */
    private final ConcurrentHashMap<C2932b, Integer> f7489d;
    /* renamed from: e */
    private final Map<String, Object> f7490e;
    /* renamed from: f */
    private final ReentrantLock f7491f;
    /* renamed from: g */
    private final LinkedList<Map<String, Object>> f7492g;
    /* renamed from: h */
    private final C2933c f7493h;
    /* renamed from: i */
    private final CountDownLatch f7494i;

    /* renamed from: com.google.android.gms.e.c$a */
    static final class C2931a {
        /* renamed from: a */
        public final String f7484a;
        /* renamed from: b */
        public final Object f7485b;

        C2931a(String str, Object obj) {
            this.f7484a = str;
            this.f7485b = obj;
        }

        public final String toString() {
            String str = this.f7484a;
            String obj = this.f7485b.toString();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(obj).length());
            stringBuilder.append("Key: ");
            stringBuilder.append(str);
            stringBuilder.append(" value: ");
            stringBuilder.append(obj);
            return stringBuilder.toString();
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f7484a.hashCode()), Integer.valueOf(this.f7485b.hashCode())});
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C2931a)) {
                return false;
            }
            C2931a c2931a = (C2931a) obj;
            if (!this.f7484a.equals(c2931a.f7484a) || this.f7485b.equals(c2931a.f7485b) == null) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.e.c$b */
    interface C2932b {
        /* renamed from: a */
        void mo2559a(Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.e.c$c */
    interface C2933c {
        /* renamed from: a */
        void mo2570a(C2944u c2944u);

        /* renamed from: a */
        void mo2571a(String str);

        /* renamed from: a */
        void mo2572a(List<C2931a> list, long j);
    }

    C2934c() {
        this(new C4401s());
    }

    C2934c(C2933c c2933c) {
        this.f7493h = c2933c;
        this.f7489d = new ConcurrentHashMap();
        this.f7490e = new HashMap();
        this.f7491f = new ReentrantLock();
        this.f7492g = new LinkedList();
        this.f7494i = new CountDownLatch(1);
        this.f7493h.mo2570a(new C4402t(this));
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.f7490e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.f7490e.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    /* renamed from: a */
    public void m8616a(String str, Map<String, Object> map) {
        Map hashMap = new HashMap(map);
        hashMap.put("event", str);
        m8617a(hashMap);
    }

    /* renamed from: a */
    public void m8615a(String str, Object obj) {
        m8617a(C2934c.m8610b(str, obj));
    }

    /* renamed from: a */
    public void m8617a(java.util.Map<java.lang.String, java.lang.Object> r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = this;
        r0 = r1.f7494i;	 Catch:{ InterruptedException -> 0x0006 }
        r0.await();	 Catch:{ InterruptedException -> 0x0006 }
        goto L_0x000b;
    L_0x0006:
        r0 = "DataLayer.push: unexpected InterruptedException";
        com.google.android.gms.p185e.bs.m8584b(r0);
    L_0x000b:
        r1.m8611b(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.c.a(java.util.Map):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final void m8611b(java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
        r8 = this;
        r0 = r8.f7491f;
        r0.lock();
        r0 = r8.f7492g;	 Catch:{ all -> 0x00b3 }
        r0.offer(r9);	 Catch:{ all -> 0x00b3 }
        r0 = r8.f7491f;	 Catch:{ all -> 0x00b3 }
        r0 = r0.getHoldCount();	 Catch:{ all -> 0x00b3 }
        r1 = 0;
        r2 = 1;
        if (r0 != r2) goto L_0x0075;
    L_0x0014:
        r0 = 0;
    L_0x0015:
        r3 = r8.f7492g;	 Catch:{ all -> 0x00b3 }
        r3 = r3.poll();	 Catch:{ all -> 0x00b3 }
        r3 = (java.util.Map) r3;	 Catch:{ all -> 0x00b3 }
        if (r3 == 0) goto L_0x0075;
    L_0x001f:
        r4 = r8.f7490e;	 Catch:{ all -> 0x00b3 }
        monitor-enter(r4);	 Catch:{ all -> 0x00b3 }
        r5 = r3.keySet();	 Catch:{ all -> 0x0072 }
        r5 = r5.iterator();	 Catch:{ all -> 0x0072 }
    L_0x002a:
        r6 = r5.hasNext();	 Catch:{ all -> 0x0072 }
        if (r6 == 0) goto L_0x0044;
    L_0x0030:
        r6 = r5.next();	 Catch:{ all -> 0x0072 }
        r6 = (java.lang.String) r6;	 Catch:{ all -> 0x0072 }
        r7 = r3.get(r6);	 Catch:{ all -> 0x0072 }
        r6 = com.google.android.gms.p185e.C2934c.m8610b(r6, r7);	 Catch:{ all -> 0x0072 }
        r7 = r8.f7490e;	 Catch:{ all -> 0x0072 }
        r8.m8609a(r6, r7);	 Catch:{ all -> 0x0072 }
        goto L_0x002a;
    L_0x0044:
        monitor-exit(r4);	 Catch:{ all -> 0x0072 }
        r4 = r8.f7489d;	 Catch:{ all -> 0x00b3 }
        r4 = r4.keySet();	 Catch:{ all -> 0x00b3 }
        r4 = r4.iterator();	 Catch:{ all -> 0x00b3 }
    L_0x004f:
        r5 = r4.hasNext();	 Catch:{ all -> 0x00b3 }
        if (r5 == 0) goto L_0x005f;
    L_0x0055:
        r5 = r4.next();	 Catch:{ all -> 0x00b3 }
        r5 = (com.google.android.gms.p185e.C2934c.C2932b) r5;	 Catch:{ all -> 0x00b3 }
        r5.mo2559a(r3);	 Catch:{ all -> 0x00b3 }
        goto L_0x004f;
    L_0x005f:
        r0 = r0 + r2;
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 > r3) goto L_0x0065;
    L_0x0064:
        goto L_0x0015;
    L_0x0065:
        r9 = r8.f7492g;	 Catch:{ all -> 0x00b3 }
        r9.clear();	 Catch:{ all -> 0x00b3 }
        r9 = new java.lang.RuntimeException;	 Catch:{ all -> 0x00b3 }
        r0 = "Seems like an infinite loop of pushing to the data layer";
        r9.<init>(r0);	 Catch:{ all -> 0x00b3 }
        throw r9;	 Catch:{ all -> 0x00b3 }
    L_0x0072:
        r9 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0072 }
        throw r9;	 Catch:{ all -> 0x00b3 }
    L_0x0075:
        r0 = f7487b;	 Catch:{ all -> 0x00b3 }
        r2 = r0.length;	 Catch:{ all -> 0x00b3 }
        r3 = r9;
    L_0x0079:
        r4 = 0;
        if (r1 >= r2) goto L_0x008d;
    L_0x007c:
        r5 = r0[r1];	 Catch:{ all -> 0x00b3 }
        r6 = r3 instanceof java.util.Map;	 Catch:{ all -> 0x00b3 }
        if (r6 != 0) goto L_0x0084;
    L_0x0082:
        r3 = r4;
        goto L_0x008d;
    L_0x0084:
        r3 = (java.util.Map) r3;	 Catch:{ all -> 0x00b3 }
        r3 = r3.get(r5);	 Catch:{ all -> 0x00b3 }
        r1 = r1 + 1;
        goto L_0x0079;
    L_0x008d:
        if (r3 != 0) goto L_0x0090;
    L_0x008f:
        goto L_0x0098;
    L_0x0090:
        r0 = r3.toString();	 Catch:{ all -> 0x00b3 }
        r4 = com.google.android.gms.p185e.C2934c.m8612c(r0);	 Catch:{ all -> 0x00b3 }
    L_0x0098:
        if (r4 == 0) goto L_0x00ad;
    L_0x009a:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00b3 }
        r0.<init>();	 Catch:{ all -> 0x00b3 }
        r1 = "";
        r8.m8608a(r9, r1, r0);	 Catch:{ all -> 0x00b3 }
        r9 = r8.f7493h;	 Catch:{ all -> 0x00b3 }
        r1 = r4.longValue();	 Catch:{ all -> 0x00b3 }
        r9.mo2572a(r0, r1);	 Catch:{ all -> 0x00b3 }
    L_0x00ad:
        r9 = r8.f7491f;
        r9.unlock();
        return;
    L_0x00b3:
        r9 = move-exception;
        r0 = r8.f7491f;
        r0.unlock();
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.c.b(java.util.Map):void");
    }

    /* renamed from: a */
    final void m8614a(String str) {
        m8615a(str, null);
        this.f7493h.mo2571a(str);
    }

    /* renamed from: a */
    private final void m8608a(Map<String, Object> map, String str, Collection<C2931a> collection) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str2 = str.length() == 0 ? "" : ".";
            String str3 = (String) entry.getKey();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + String.valueOf(str2).length()) + String.valueOf(str3).length());
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            str2 = stringBuilder.toString();
            if (entry.getValue() instanceof Map) {
                m8608a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C2931a(str2, entry.getValue()));
            }
        }
    }

    /* renamed from: c */
    private static java.lang.Long m8612c(java.lang.String r9) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = f7488c;
        r0 = r0.matcher(r9);
        r1 = r0.matches();
        r2 = 0;
        if (r1 != 0) goto L_0x0027;
    L_0x000d:
        r0 = "unknown _lifetime: ";
        r9 = java.lang.String.valueOf(r9);
        r1 = r9.length();
        if (r1 == 0) goto L_0x001e;
    L_0x0019:
        r9 = r0.concat(r9);
        goto L_0x0023;
    L_0x001e:
        r9 = new java.lang.String;
        r9.<init>(r0);
    L_0x0023:
        com.google.android.gms.p185e.bs.m8586c(r9);
        return r2;
    L_0x0027:
        r1 = 1;
        r3 = 0;
        r1 = r0.group(r1);	 Catch:{ NumberFormatException -> 0x0033 }
        r5 = java.lang.Long.parseLong(r1);	 Catch:{ NumberFormatException -> 0x0033 }
        goto L_0x004e;
    L_0x0033:
        r1 = "illegal number in _lifetime value: ";
        r5 = java.lang.String.valueOf(r9);
        r6 = r5.length();
        if (r6 == 0) goto L_0x0044;
    L_0x003f:
        r1 = r1.concat(r5);
        goto L_0x004a;
    L_0x0044:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5;
    L_0x004a:
        com.google.android.gms.p185e.bs.m8584b(r1);
        r5 = r3;
    L_0x004e:
        r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r1 > 0) goto L_0x006c;
    L_0x0052:
        r0 = "non-positive _lifetime: ";
        r9 = java.lang.String.valueOf(r9);
        r1 = r9.length();
        if (r1 == 0) goto L_0x0063;
    L_0x005e:
        r9 = r0.concat(r9);
        goto L_0x0068;
    L_0x0063:
        r9 = new java.lang.String;
        r9.<init>(r0);
    L_0x0068:
        com.google.android.gms.p185e.bs.m8586c(r9);
        return r2;
    L_0x006c:
        r1 = 2;
        r0 = r0.group(r1);
        r1 = r0.length();
        if (r1 != 0) goto L_0x007c;
    L_0x0077:
        r9 = java.lang.Long.valueOf(r5);
        return r9;
    L_0x007c:
        r1 = 0;
        r0 = r0.charAt(r1);
        r1 = 100;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7 = 60;
        if (r0 == r1) goto L_0x00ca;
    L_0x0089:
        r1 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        if (r0 == r1) goto L_0x00bf;
    L_0x008d:
        r1 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        if (r0 == r1) goto L_0x00b6;
    L_0x0091:
        r1 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        if (r0 == r1) goto L_0x00af;
    L_0x0095:
        r0 = "unknown units in _lifetime: ";
        r9 = java.lang.String.valueOf(r9);
        r1 = r9.length();
        if (r1 == 0) goto L_0x00a6;
    L_0x00a1:
        r9 = r0.concat(r9);
        goto L_0x00ab;
    L_0x00a6:
        r9 = new java.lang.String;
        r9.<init>(r0);
    L_0x00ab:
        com.google.android.gms.p185e.bs.m8584b(r9);
        return r2;
    L_0x00af:
        r5 = r5 * r3;
        r9 = java.lang.Long.valueOf(r5);
        return r9;
    L_0x00b6:
        r5 = r5 * r3;
        r5 = r5 * r7;
        r9 = java.lang.Long.valueOf(r5);
        return r9;
    L_0x00bf:
        r5 = r5 * r3;
        r5 = r5 * r7;
        r5 = r5 * r7;
        r9 = java.lang.Long.valueOf(r5);
        return r9;
    L_0x00ca:
        r5 = r5 * r3;
        r5 = r5 * r7;
        r5 = r5 * r7;
        r0 = 24;
        r5 = r5 * r0;
        r9 = java.lang.Long.valueOf(r5);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.c.c(java.lang.String):java.lang.Long");
    }

    /* renamed from: b */
    public Object m8618b(String str) {
        synchronized (this.f7490e) {
            Object obj = this.f7490e;
            str = str.split("\\.");
            int length = str.length;
            int i = 0;
            while (i < length) {
                Object obj2 = str[i];
                if (obj instanceof Map) {
                    obj = ((Map) obj).get(obj2);
                    if (obj == null) {
                        return null;
                    }
                    i++;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    /* renamed from: a */
    public static Map<String, Object> m8604a(Object... objArr) {
        if (objArr.length % 2 == 0) {
            Map<String, Object> hashMap = new HashMap();
            int i = 0;
            while (i < objArr.length) {
                if (objArr[i] instanceof String) {
                    hashMap.put((String) objArr[i], objArr[i + 1]);
                    i += 2;
                } else {
                    objArr = String.valueOf(objArr[i]);
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(objArr).length() + 21);
                    stringBuilder.append("key is not a string: ");
                    stringBuilder.append(objArr);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            return hashMap;
        }
        throw new IllegalArgumentException("expected even number of key-value pairs");
    }

    /* renamed from: a */
    final void m8613a(C2932b c2932b) {
        this.f7489d.put(c2932b, Integer.valueOf(0));
    }

    /* renamed from: b */
    static Map<String, Object> m8610b(String str, Object obj) {
        Map hashMap = new HashMap();
        str = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < str.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(str[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(str[str.length - 1], obj);
        return hashMap;
    }

    /* renamed from: a */
    private final void m8609a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m8607a((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m8609a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    /* renamed from: a */
    private final void m8607a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m8607a((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m8609a((Map) obj, (Map) list2.get(i));
            } else if (obj != f7486a) {
                list2.set(i, obj);
            }
        }
    }
}
