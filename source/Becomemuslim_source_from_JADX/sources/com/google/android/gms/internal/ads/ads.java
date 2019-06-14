package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class ads {
    /* renamed from: a */
    private static final Class<?> f14312a = m18125d();
    /* renamed from: b */
    private static final aej<?, ?> f14313b = m18099a(false);
    /* renamed from: c */
    private static final aej<?, ?> f14314c = m18099a(true);
    /* renamed from: d */
    private static final aej<?, ?> f14315d = new ael();

    /* renamed from: a */
    static int m18093a(int i, Object obj, adq adq) {
        return obj instanceof ace ? aaw.m29592a(i, (ace) obj) : aaw.m29602b(i, (acx) obj, adq);
    }

    /* renamed from: a */
    static int m18094a(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        i = aaw.m29617e(i) * size;
        Object b;
        if (list instanceof acg) {
            acg acg = (acg) list;
            while (i2 < size) {
                b = acg.mo3790b(i2);
                i += b instanceof aai ? aaw.m29605b((aai) b) : aaw.m29607b((String) b);
                i2++;
            }
        } else {
            while (i2 < size) {
                b = list.get(i2);
                i += b instanceof aai ? aaw.m29605b((aai) b) : aaw.m29607b((String) b);
                i2++;
            }
        }
        return i;
    }

    /* renamed from: a */
    static int m18095a(int i, List<?> list, adq adq) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        i = aaw.m29617e(i) * size;
        while (i2 < size) {
            Object obj = list.get(i2);
            i += obj instanceof ace ? aaw.m29593a((ace) obj) : aaw.m29594a((acx) obj, adq);
            i2++;
        }
        return i;
    }

    /* renamed from: a */
    static int m18096a(int i, List<Long> list, boolean z) {
        return list.size() == 0 ? 0 : m18097a((List) list) + (list.size() * aaw.m29617e(i));
    }

    /* renamed from: a */
    static int m18097a(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof acl) {
            acl acl = (acl) list;
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29616d(acl.m36733b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29616d(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static aej<?, ?> m18098a() {
        return f14313b;
    }

    /* renamed from: a */
    private static com.google.android.gms.internal.ads.aej<?, ?> m18099a(boolean r6) {
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
        r0 = 0;
        r1 = m18129e();	 Catch:{ Throwable -> 0x0023 }
        if (r1 != 0) goto L_0x0008;	 Catch:{ Throwable -> 0x0023 }
    L_0x0007:
        return r0;	 Catch:{ Throwable -> 0x0023 }
    L_0x0008:
        r2 = 1;	 Catch:{ Throwable -> 0x0023 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0023 }
        r4 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x0023 }
        r5 = 0;	 Catch:{ Throwable -> 0x0023 }
        r3[r5] = r4;	 Catch:{ Throwable -> 0x0023 }
        r1 = r1.getConstructor(r3);	 Catch:{ Throwable -> 0x0023 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0023 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x0023 }
        r2[r5] = r6;	 Catch:{ Throwable -> 0x0023 }
        r6 = r1.newInstance(r2);	 Catch:{ Throwable -> 0x0023 }
        r6 = (com.google.android.gms.internal.ads.aej) r6;	 Catch:{ Throwable -> 0x0023 }
        return r6;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ads.a(boolean):com.google.android.gms.internal.ads.aej<?, ?>");
    }

    /* renamed from: a */
    static <UT, UB> UB m18100a(int i, int i2, UB ub, aej<UT, UB> aej) {
        Object a;
        if (ub == null) {
            a = aej.mo3771a();
        }
        aej.mo3774a(a, i, (long) i2);
        return a;
    }

    /* renamed from: a */
    static <UT, UB> UB m18101a(int i, List<Integer> list, abu<?> abu, UB ub, aej<UT, UB> aej) {
        if (abu == null) {
            return ub;
        }
        UB ub2;
        int intValue;
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    intValue = ((Integer) it.next()).intValue();
                    if (abu.mo3850a(intValue) == null) {
                        ub = m18100a(i, intValue, (Object) ub2, (aej) aej);
                        it.remove();
                    }
                }
                break loop1;
            }
        }
        int size = list.size();
        ub2 = ub;
        intValue = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int intValue2 = ((Integer) list.get(i2)).intValue();
            if (abu.mo3850a(intValue2) != null) {
                if (i2 != intValue) {
                    list.set(intValue, Integer.valueOf(intValue2));
                }
                intValue++;
            } else {
                ub2 = m18100a(i, intValue2, (Object) ub2, (aej) aej);
            }
        }
        if (intValue != size) {
            list.subList(intValue, size).clear();
        }
        return ub2;
    }

    /* renamed from: a */
    public static void m18102a(int i, List<String> list, afd afd) {
        if (list != null && !list.isEmpty()) {
            afd.mo3696a(i, (List) list);
        }
    }

    /* renamed from: a */
    public static void m18103a(int i, List<?> list, afd afd, adq adq) {
        if (list != null && !list.isEmpty()) {
            afd.mo3697a(i, (List) list, adq);
        }
    }

    /* renamed from: a */
    public static void m18104a(int i, List<Double> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3718g(i, list, z);
        }
    }

    /* renamed from: a */
    static <T, FT extends abk<FT>> void m18105a(abf<FT> abf, T t, T t2) {
        abi a = abf.mo3727a((Object) t2);
        if (!a.m17913b()) {
            abf.mo3735b(t).m17912a(a);
        }
    }

    /* renamed from: a */
    static <T> void m18106a(acs acs, T t, T t2, long j) {
        aep.m18229a((Object) t, j, acs.mo3746a(aep.m18251f(t, j), aep.m18251f(t2, j)));
    }

    /* renamed from: a */
    static <T, UT, UB> void m18107a(aej<UT, UB> aej, T t, T t2) {
        aej.mo3778a((Object) t, aej.mo3785c(aej.mo3780b(t), aej.mo3780b(t2)));
    }

    /* renamed from: a */
    public static void m18108a(Class<?> cls) {
        if (!abq.class.isAssignableFrom(cls) && f14312a != null) {
            if (!f14312a.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    /* renamed from: a */
    public static boolean m18109a(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long j = (long) i3;
        return ((((long) i2) - ((long) i)) + 1) + 9 <= ((2 * j) + 3) + ((j + 3) * 3);
    }

    /* renamed from: a */
    static boolean m18110a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    static int m18111b(int i, List<aai> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        size *= aaw.m29617e(i);
        while (i2 < list.size()) {
            size += aaw.m29605b((aai) list.get(i2));
            i2++;
        }
        return size;
    }

    /* renamed from: b */
    static int m18112b(int i, List<acx> list, adq adq) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        while (i2 < size) {
            i3 += aaw.m29611c(i, (acx) list.get(i2), adq);
            i2++;
        }
        return i3;
    }

    /* renamed from: b */
    static int m18113b(int i, List<Long> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : m18114b(list) + (size * aaw.m29617e(i));
    }

    /* renamed from: b */
    static int m18114b(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof acl) {
            acl acl = (acl) list;
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29619e(acl.m36733b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29619e(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: b */
    public static aej<?, ?> m18115b() {
        return f14314c;
    }

    /* renamed from: b */
    public static void m18116b(int i, List<aai> list, afd afd) {
        if (list != null && !list.isEmpty()) {
            afd.mo3704b(i, (List) list);
        }
    }

    /* renamed from: b */
    public static void m18117b(int i, List<?> list, afd afd, adq adq) {
        if (list != null && !list.isEmpty()) {
            afd.mo3705b(i, (List) list, adq);
        }
    }

    /* renamed from: b */
    public static void m18118b(int i, List<Float> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3717f(i, list, z);
        }
    }

    /* renamed from: c */
    static int m18119c(int i, List<Long> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : m18120c(list) + (size * aaw.m29617e(i));
    }

    /* renamed from: c */
    static int m18120c(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof acl) {
            acl acl = (acl) list;
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29623f(acl.m36733b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29623f(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: c */
    public static aej<?, ?> m18121c() {
        return f14315d;
    }

    /* renamed from: c */
    public static void m18122c(int i, List<Long> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3709c(i, list, z);
        }
    }

    /* renamed from: d */
    static int m18123d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : m18124d(list) + (size * aaw.m29617e(i));
    }

    /* renamed from: d */
    static int m18124d(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof abr) {
            abr abr = (abr) list;
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29637k(abr.m36716b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29637k(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: d */
    private static java.lang.Class<?> m18125d() {
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
        r0 = "com.google.protobuf.GeneratedMessage";	 Catch:{ Throwable -> 0x0007 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ads.d():java.lang.Class<?>");
    }

    /* renamed from: d */
    public static void m18126d(int i, List<Long> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3712d(i, list, z);
        }
    }

    /* renamed from: e */
    static int m18127e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : m18128e(list) + (size * aaw.m29617e(i));
    }

    /* renamed from: e */
    static int m18128e(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof abr) {
            abr abr = (abr) list;
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29620f(abr.m36716b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29620f(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: e */
    private static java.lang.Class<?> m18129e() {
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
        r0 = "com.google.protobuf.UnknownFieldSetSchema";	 Catch:{ Throwable -> 0x0007 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ads.e():java.lang.Class<?>");
    }

    /* renamed from: e */
    public static void m18130e(int i, List<Long> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3725n(i, list, z);
        }
    }

    /* renamed from: f */
    static int m18131f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : m18132f(list) + (size * aaw.m29617e(i));
    }

    /* renamed from: f */
    static int m18132f(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof abr) {
            abr abr = (abr) list;
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29624g(abr.m36716b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29624g(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: f */
    public static void m18133f(int i, List<Long> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3715e(i, list, z);
        }
    }

    /* renamed from: g */
    static int m18134g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : m18135g(list) + (size * aaw.m29617e(i));
    }

    /* renamed from: g */
    static int m18135g(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof abr) {
            abr abr = (abr) list;
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29628h(abr.m36716b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += aaw.m29628h(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: g */
    public static void m18136g(int i, List<Long> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3723l(i, list, z);
        }
    }

    /* renamed from: h */
    static int m18137h(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : size * aaw.m29633i(i, 0);
    }

    /* renamed from: h */
    static int m18138h(List<?> list) {
        return list.size() << 2;
    }

    /* renamed from: h */
    public static void m18139h(int i, List<Integer> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3698a(i, (List) list, z);
        }
    }

    /* renamed from: i */
    static int m18140i(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : size * aaw.m29626g(i, 0);
    }

    /* renamed from: i */
    static int m18141i(List<?> list) {
        return list.size() << 3;
    }

    /* renamed from: i */
    public static void m18142i(int i, List<Integer> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3721j(i, list, z);
        }
    }

    /* renamed from: j */
    static int m18143j(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : size * aaw.m29604b(i, true);
    }

    /* renamed from: j */
    static int m18144j(List<?> list) {
        return list.size();
    }

    /* renamed from: j */
    public static void m18145j(int i, List<Integer> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3724m(i, list, z);
        }
    }

    /* renamed from: k */
    public static void m18146k(int i, List<Integer> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3706b(i, (List) list, z);
        }
    }

    /* renamed from: l */
    public static void m18147l(int i, List<Integer> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3722k(i, list, z);
        }
    }

    /* renamed from: m */
    public static void m18148m(int i, List<Integer> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3719h(i, list, z);
        }
    }

    /* renamed from: n */
    public static void m18149n(int i, List<Boolean> list, afd afd, boolean z) {
        if (list != null && !list.isEmpty()) {
            afd.mo3720i(i, list, z);
        }
    }
}
