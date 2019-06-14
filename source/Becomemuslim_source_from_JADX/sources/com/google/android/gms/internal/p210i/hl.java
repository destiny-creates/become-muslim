package com.google.android.gms.internal.p210i;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.hl */
final class hl {
    /* renamed from: a */
    private static final Class<?> f16662a = hl.m20714d();
    /* renamed from: b */
    private static final ib<?, ?> f16663b = hl.m20689a(false);
    /* renamed from: c */
    private static final ib<?, ?> f16664c = hl.m20689a(true);
    /* renamed from: d */
    private static final ib<?, ?> f16665d = new id();

    /* renamed from: a */
    public static void m20698a(Class<?> cls) {
        if (!fk.class.isAssignableFrom(cls) && f16662a != null) {
            if (f16662a.isAssignableFrom(cls) == null) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    /* renamed from: a */
    public static void m20694a(int i, List<Double> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4534g(i, list, z);
        }
    }

    /* renamed from: b */
    public static void m20707b(int i, List<Float> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4533f(i, list, z);
        }
    }

    /* renamed from: c */
    public static void m20711c(int i, List<Long> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4525c(i, list, z);
        }
    }

    /* renamed from: d */
    public static void m20715d(int i, List<Long> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4528d(i, list, z);
        }
    }

    /* renamed from: e */
    public static void m20719e(int i, List<Long> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4541n(i, list, z);
        }
    }

    /* renamed from: f */
    public static void m20722f(int i, List<Long> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4531e(i, list, z);
        }
    }

    /* renamed from: g */
    public static void m20725g(int i, List<Long> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4539l(i, list, z);
        }
    }

    /* renamed from: h */
    public static void m20728h(int i, List<Integer> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4514a(i, (List) list, z);
        }
    }

    /* renamed from: i */
    public static void m20731i(int i, List<Integer> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4537j(i, list, z);
        }
    }

    /* renamed from: j */
    public static void m20734j(int i, List<Integer> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4540m(i, list, z);
        }
    }

    /* renamed from: k */
    public static void m20735k(int i, List<Integer> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4522b(i, (List) list, z);
        }
    }

    /* renamed from: l */
    public static void m20736l(int i, List<Integer> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4538k(i, list, z);
        }
    }

    /* renamed from: m */
    public static void m20737m(int i, List<Integer> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4535h(i, list, z);
        }
    }

    /* renamed from: n */
    public static void m20738n(int i, List<Boolean> list, ix ixVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4536i(i, list, z);
        }
    }

    /* renamed from: a */
    public static void m20692a(int i, List<String> list, ix ixVar) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4512a(i, (List) list);
        }
    }

    /* renamed from: b */
    public static void m20705b(int i, List<dy> list, ix ixVar) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4520b(i, (List) list);
        }
    }

    /* renamed from: a */
    public static void m20693a(int i, List<?> list, ix ixVar, hi hiVar) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4513a(i, (List) list, hiVar);
        }
    }

    /* renamed from: b */
    public static void m20706b(int i, List<?> list, ix ixVar, hi hiVar) {
        if (list != null && !list.isEmpty()) {
            ixVar.mo4521b(i, (List) list, hiVar);
        }
    }

    /* renamed from: a */
    static int m20687a(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof gg) {
            gg ggVar = (gg) list;
            i2 = 0;
            while (i < size) {
                i2 += eq.m31460d(ggVar.m37972b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += eq.m31460d(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    static int m20686a(int i, List<Long> list, boolean z) {
        if (list.size()) {
            return hl.m20687a((List) list) + (list.size() * eq.m31461e(i));
        }
        return 0;
    }

    /* renamed from: b */
    static int m20703b(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof gg) {
            gg ggVar = (gg) list;
            i2 = 0;
            while (i < size) {
                i2 += eq.m31463e(ggVar.m37972b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += eq.m31463e(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: b */
    static int m20702b(int i, List<Long> list, boolean z) {
        z = list.size();
        if (z) {
            return hl.m20703b(list) + (z * eq.m31461e(i));
        }
        return 0;
    }

    /* renamed from: c */
    static int m20709c(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof gg) {
            gg ggVar = (gg) list;
            i2 = 0;
            while (i < size) {
                i2 += eq.m31467f(ggVar.m37972b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += eq.m31467f(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: c */
    static int m20708c(int i, List<Long> list, boolean z) {
        z = list.size();
        if (z) {
            return hl.m20709c(list) + (z * eq.m31461e(i));
        }
        return 0;
    }

    /* renamed from: d */
    static int m20713d(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof fl) {
            fl flVar = (fl) list;
            i2 = 0;
            while (i < size) {
                i2 += eq.m31481k(flVar.m37958b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += eq.m31481k(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: d */
    static int m20712d(int i, List<Integer> list, boolean z) {
        z = list.size();
        if (z) {
            return hl.m20713d(list) + (z * eq.m31461e(i));
        }
        return 0;
    }

    /* renamed from: e */
    static int m20717e(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof fl) {
            fl flVar = (fl) list;
            i2 = 0;
            while (i < size) {
                i2 += eq.m31464f(flVar.m37958b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += eq.m31464f(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: e */
    static int m20716e(int i, List<Integer> list, boolean z) {
        z = list.size();
        if (z) {
            return hl.m20717e(list) + (z * eq.m31461e(i));
        }
        return 0;
    }

    /* renamed from: f */
    static int m20721f(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof fl) {
            fl flVar = (fl) list;
            i2 = 0;
            while (i < size) {
                i2 += eq.m31468g(flVar.m37958b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += eq.m31468g(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: f */
    static int m20720f(int i, List<Integer> list, boolean z) {
        z = list.size();
        if (z) {
            return hl.m20721f(list) + (z * eq.m31461e(i));
        }
        return 0;
    }

    /* renamed from: g */
    static int m20724g(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof fl) {
            fl flVar = (fl) list;
            i2 = 0;
            while (i < size) {
                i2 += eq.m31472h(flVar.m37958b(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += eq.m31472h(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    /* renamed from: g */
    static int m20723g(int i, List<Integer> list, boolean z) {
        z = list.size();
        if (z) {
            return hl.m20724g(list) + (z * eq.m31461e(i));
        }
        return 0;
    }

    /* renamed from: h */
    static int m20727h(List<?> list) {
        return list.size() << 2;
    }

    /* renamed from: h */
    static int m20726h(int i, List<?> list, boolean z) {
        list = list.size();
        if (list == null) {
            return 0;
        }
        return list * eq.m31477i(i, 0);
    }

    /* renamed from: i */
    static int m20730i(List<?> list) {
        return list.size() << 3;
    }

    /* renamed from: i */
    static int m20729i(int i, List<?> list, boolean z) {
        list = list.size();
        if (list == null) {
            return 0;
        }
        return list * eq.m31470g(i, 0);
    }

    /* renamed from: j */
    static int m20733j(List<?> list) {
        return list.size();
    }

    /* renamed from: j */
    static int m20732j(int i, List<?> list, boolean z) {
        list = list.size();
        if (list == null) {
            return 0;
        }
        return list * eq.m31445b(i, true);
    }

    /* renamed from: a */
    static int m20684a(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        i = eq.m31461e(i) * size;
        Object b;
        if (list instanceof gb) {
            gb gbVar = (gb) list;
            while (i2 < size) {
                b = gbVar.mo4604b(i2);
                if (b instanceof dy) {
                    i += eq.m31446b((dy) b);
                } else {
                    i += eq.m31449b((String) b);
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                b = list.get(i2);
                if (b instanceof dy) {
                    i += eq.m31446b((dy) b);
                } else {
                    i += eq.m31449b((String) b);
                }
                i2++;
            }
        }
        return i;
    }

    /* renamed from: a */
    static int m20683a(int i, Object obj, hi hiVar) {
        if (obj instanceof fz) {
            return eq.m31434a(i, (fz) obj);
        }
        return eq.m31443b(i, (gt) obj, hiVar);
    }

    /* renamed from: a */
    static int m20685a(int i, List<?> list, hi hiVar) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        i = eq.m31461e(i) * size;
        while (i2 < size) {
            Object obj = list.get(i2);
            if (obj instanceof fz) {
                i += eq.m31435a((fz) obj);
            } else {
                i += eq.m31448b((gt) obj, hiVar);
            }
            i2++;
        }
        return i;
    }

    /* renamed from: b */
    static int m20700b(int i, List<dy> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        size *= eq.m31461e(i);
        while (i2 < list.size()) {
            size += eq.m31446b((dy) list.get(i2));
            i2++;
        }
        return size;
    }

    /* renamed from: b */
    static int m20701b(int i, List<gt> list, hi hiVar) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        while (i2 < size) {
            i3 += eq.m31454c(i, (gt) list.get(i2), hiVar);
            i2++;
        }
        return i3;
    }

    /* renamed from: a */
    public static ib<?, ?> m20688a() {
        return f16663b;
    }

    /* renamed from: b */
    public static ib<?, ?> m20704b() {
        return f16664c;
    }

    /* renamed from: c */
    public static ib<?, ?> m20710c() {
        return f16665d;
    }

    /* renamed from: a */
    private static com.google.android.gms.internal.p210i.ib<?, ?> m20689a(boolean r6) {
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
        r1 = com.google.android.gms.internal.p210i.hl.m20718e();	 Catch:{ Throwable -> 0x0023 }
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
        r6 = (com.google.android.gms.internal.p210i.ib) r6;	 Catch:{ Throwable -> 0x0023 }
        return r6;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.hl.a(boolean):com.google.android.gms.internal.i.ib<?, ?>");
    }

    /* renamed from: d */
    private static java.lang.Class<?> m20714d() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.hl.d():java.lang.Class<?>");
    }

    /* renamed from: e */
    private static java.lang.Class<?> m20718e() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.hl.e():java.lang.Class<?>");
    }

    /* renamed from: a */
    static boolean m20699a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    static <T> void m20696a(go goVar, T t, T t2, long j) {
        ih.m20820a((Object) t, j, goVar.mo4561a(ih.m20843f(t, j), ih.m20843f(t2, j)));
    }

    /* renamed from: a */
    static <T, FT extends fc<FT>> void m20695a(ex<FT> exVar, T t, T t2) {
        fa a = exVar.mo4543a((Object) t2);
        if (!a.f16536a.isEmpty()) {
            exVar.mo4550b(t).m20535a(a);
        }
    }

    /* renamed from: a */
    static <T, UT, UB> void m20697a(ib<UT, UB> ibVar, T t, T t2) {
        ibVar.mo4592a((Object) t, ibVar.mo4599c(ibVar.mo4594b(t), ibVar.mo4594b(t2)));
    }

    /* renamed from: a */
    static <UT, UB> UB m20691a(int i, List<Integer> list, fp fpVar, UB ub, ib<UT, UB> ibVar) {
        if (fpVar == null) {
            return ub;
        }
        UB ub2;
        if (!(list instanceof RandomAccess)) {
            list = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (list.hasNext() != null) {
                    int intValue = ((Integer) list.next()).intValue();
                    if (!fpVar.mo4425a(intValue)) {
                        ub = hl.m20690a(i, intValue, (Object) ub2, (ib) ibVar);
                        list.remove();
                    }
                }
                break loop1;
            }
        }
        UB size = list.size();
        ub2 = ub;
        ub = null;
        for (UB ub3 = null; ub3 < size; ub3++) {
            int intValue2 = ((Integer) list.get(ub3)).intValue();
            if (fpVar.mo4425a(intValue2)) {
                if (ub3 != ub) {
                    list.set(ub, Integer.valueOf(intValue2));
                }
                ub++;
            } else {
                ub2 = hl.m20690a(i, intValue2, (Object) ub2, (ib) ibVar);
            }
        }
        if (ub != size) {
            list.subList(ub, size).clear();
        }
        return ub2;
    }

    /* renamed from: a */
    static <UT, UB> UB m20690a(int i, int i2, UB ub, ib<UT, UB> ibVar) {
        Object a;
        if (ub == null) {
            a = ibVar.mo4585a();
        }
        ibVar.mo4588a(a, i, (long) i2);
        return a;
    }
}
