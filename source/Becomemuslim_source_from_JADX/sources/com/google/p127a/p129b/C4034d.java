package com.google.p127a.p129b;

import com.google.p127a.C2149b;
import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.p128a.C2121d;
import com.google.p127a.p128a.C2122e;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2154c;
import java.util.Collections;
import java.util.List;

/* compiled from: Excluder */
/* renamed from: com.google.a.b.d */
public final class C4034d implements C2169x, Cloneable {
    /* renamed from: a */
    public static final C4034d f10096a = new C4034d();
    /* renamed from: b */
    private double f10097b = -1.0d;
    /* renamed from: c */
    private int f10098c = 136;
    /* renamed from: d */
    private boolean f10099d = true;
    /* renamed from: e */
    private boolean f10100e;
    /* renamed from: f */
    private List<C2149b> f10101f = Collections.emptyList();
    /* renamed from: g */
    private List<C2149b> f10102g = Collections.emptyList();

    protected /* synthetic */ Object clone() {
        return m12433a();
    }

    /* renamed from: a */
    protected com.google.p127a.p129b.C4034d m12433a() {
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
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x0007 }
        r0 = (com.google.p127a.p129b.C4034d) r0;	 Catch:{ CloneNotSupportedException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.d.a():com.google.a.b.d");
    }

    /* renamed from: a */
    public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
        Class a = c2150a.m5891a();
        final boolean a2 = m12435a(a, true);
        final boolean a3 = m12435a(a, false);
        if (!a2 && !a3) {
            return null;
        }
        final C2157f c2157f2 = c2157f;
        final C2150a<T> c2150a2 = c2150a;
        return new C2168w<T>(this) {
            /* renamed from: e */
            final /* synthetic */ C4034d f10094e;
            /* renamed from: f */
            private C2168w<T> f10095f;

            /* renamed from: b */
            public T mo1992b(C2152a c2152a) {
                if (!a3) {
                    return m12424a().mo1992b(c2152a);
                }
                c2152a.mo2007n();
                return null;
            }

            /* renamed from: a */
            public void mo1991a(C2154c c2154c, T t) {
                if (a2) {
                    c2154c.mo2021f();
                } else {
                    m12424a().mo1991a(c2154c, t);
                }
            }

            /* renamed from: a */
            private C2168w<T> m12424a() {
                C2168w<T> c2168w = this.f10095f;
                if (c2168w != null) {
                    return c2168w;
                }
                c2168w = c2157f2.m5971a(this.f10094e, c2150a2);
                this.f10095f = c2168w;
                return c2168w;
            }
        };
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m12436a(java.lang.reflect.Field r7, boolean r8) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
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
        r6 = this;
        r0 = r6.f10098c;
        r1 = r7.getModifiers();
        r0 = r0 & r1;
        r1 = 1;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r2 = r6.f10097b;
        r4 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x002a;
    L_0x0013:
        r0 = com.google.p127a.p128a.C2121d.class;
        r0 = r7.getAnnotation(r0);
        r0 = (com.google.p127a.p128a.C2121d) r0;
        r2 = com.google.p127a.p128a.C2122e.class;
        r2 = r7.getAnnotation(r2);
        r2 = (com.google.p127a.p128a.C2122e) r2;
        r0 = r6.m12428a(r0, r2);
        if (r0 != 0) goto L_0x002a;
    L_0x0029:
        return r1;
    L_0x002a:
        r0 = r7.isSynthetic();
        if (r0 == 0) goto L_0x0031;
    L_0x0030:
        return r1;
    L_0x0031:
        r0 = r6.f10100e;
        if (r0 == 0) goto L_0x004f;
    L_0x0035:
        r0 = com.google.p127a.p128a.C2118a.class;
        r0 = r7.getAnnotation(r0);
        r0 = (com.google.p127a.p128a.C2118a) r0;
        if (r0 == 0) goto L_0x004e;
    L_0x003f:
        if (r8 == 0) goto L_0x0048;
    L_0x0041:
        r0 = r0.m5820a();
        if (r0 != 0) goto L_0x004f;
    L_0x0047:
        goto L_0x004e;
    L_0x0048:
        r0 = r0.m5821b();
        if (r0 != 0) goto L_0x004f;
    L_0x004e:
        return r1;
    L_0x004f:
        r0 = r6.f10099d;
        if (r0 != 0) goto L_0x005e;
    L_0x0053:
        r0 = r7.getType();
        r0 = r6.m12431b(r0);
        if (r0 == 0) goto L_0x005e;
    L_0x005d:
        return r1;
    L_0x005e:
        r0 = r7.getType();
        r0 = r6.m12430a(r0);
        if (r0 == 0) goto L_0x0069;
    L_0x0068:
        return r1;
    L_0x0069:
        if (r8 == 0) goto L_0x006e;
    L_0x006b:
        r8 = r6.f10101f;
        goto L_0x0070;
    L_0x006e:
        r8 = r6.f10102g;
    L_0x0070:
        r0 = r8.isEmpty();
        if (r0 != 0) goto L_0x0092;
    L_0x0076:
        r0 = new com.google.a.c;
        r0.<init>(r7);
        r7 = r8.iterator();
    L_0x007f:
        r8 = r7.hasNext();
        if (r8 == 0) goto L_0x0092;
    L_0x0085:
        r8 = r7.next();
        r8 = (com.google.p127a.C2149b) r8;
        r8 = r8.m5886a(r0);
        if (r8 == 0) goto L_0x007f;
    L_0x0091:
        return r1;
    L_0x0092:
        r7 = 0;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.d.a(java.lang.reflect.Field, boolean):boolean");
    }

    /* renamed from: a */
    public boolean m12435a(Class<?> cls, boolean z) {
        if (this.f10097b != -1.0d && !m12428a((C2121d) cls.getAnnotation(C2121d.class), (C2122e) cls.getAnnotation(C2122e.class))) {
            return true;
        }
        if ((!this.f10099d && m12431b(cls)) || m12430a((Class) cls)) {
            return true;
        }
        for (C2149b a : z ? this.f10101f : this.f10102g) {
            if (a.m5887a((Class) cls)) {
                return true;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m12430a(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || (!cls.isAnonymousClass() && cls.isLocalClass() == null)) ? null : true;
    }

    /* renamed from: b */
    private boolean m12431b(Class<?> cls) {
        return (cls.isMemberClass() && m12432c(cls) == null) ? true : null;
    }

    /* renamed from: c */
    private boolean m12432c(Class<?> cls) {
        return (cls.getModifiers() & 8) != null ? true : null;
    }

    /* renamed from: a */
    private boolean m12428a(C2121d c2121d, C2122e c2122e) {
        return (m12427a(c2121d) == null || m12429a(c2122e) == null) ? null : true;
    }

    /* renamed from: a */
    private boolean m12427a(C2121d c2121d) {
        return (c2121d == null || c2121d.m5824a() <= this.f10097b) ? true : null;
    }

    /* renamed from: a */
    private boolean m12429a(C2122e c2122e) {
        return (c2122e == null || c2122e.m5825a() > this.f10097b) ? true : null;
    }
}
