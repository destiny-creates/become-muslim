package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class abq<MessageType extends abq<MessageType, BuilderType>, BuilderType extends C8211a<MessageType, BuilderType>> extends zx<MessageType, BuilderType> {
    private static Map<Object, abq<?, ?>> zzdtv = new ConcurrentHashMap();
    protected aek zzdtt = aek.m18195a();
    private int zzdtu = -1;

    /* renamed from: com.google.android.gms.internal.ads.abq$e */
    public enum C4918e {
        /* renamed from: a */
        public static final int f14222a = 1;
        /* renamed from: b */
        public static final int f14223b = 2;
        /* renamed from: c */
        public static final int f14224c = 3;
        /* renamed from: d */
        public static final int f14225d = 4;
        /* renamed from: e */
        public static final int f14226e = 5;
        /* renamed from: f */
        public static final int f14227f = 6;
        /* renamed from: g */
        public static final int f14228g = 7;
        /* renamed from: h */
        public static final int f14229h = 1;
        /* renamed from: i */
        public static final int f14230i = 2;
        /* renamed from: j */
        public static final int f14231j = 1;
        /* renamed from: k */
        public static final int f14232k = 2;
        /* renamed from: l */
        private static final /* synthetic */ int[] f14233l = new int[]{f14222a, f14223b, f14224c, f14225d, f14226e, f14227f, f14228g};
        /* renamed from: m */
        private static final /* synthetic */ int[] f14234m = new int[]{f14229h, f14230i};
        /* renamed from: n */
        private static final /* synthetic */ int[] f14235n = new int[]{f14231j, f14232k};

        /* renamed from: a */
        public static int[] m17929a() {
            return (int[]) f14233l.clone();
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.abq$b */
    public static class C6757b<T extends abq<T, ?>> extends aab<T> {
        /* renamed from: a */
        private T f23535a;

        public C6757b(T t) {
            this.f23535a = t;
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.abq$d */
    public static class C6758d<ContainingType extends acx, Type> extends aba<ContainingType, Type> {
    }

    /* renamed from: com.google.android.gms.internal.ads.abq$a */
    public static abstract class C8211a<MessageType extends abq<MessageType, BuilderType>, BuilderType extends C8211a<MessageType, BuilderType>> extends zy<MessageType, BuilderType> {
        /* renamed from: a */
        protected MessageType f32193a;
        /* renamed from: b */
        private final MessageType f32194b;
        /* renamed from: c */
        private boolean f32195c = false;

        protected C8211a(MessageType messageType) {
            this.f32194b = messageType;
            this.f32193a = (abq) messageType.mo6835a(C4918e.f14225d, null, null);
        }

        /* renamed from: a */
        private static void m42157a(MessageType messageType, MessageType messageType2) {
            adk.m18007a().m18010a((Object) messageType).mo3760b(messageType, messageType2);
        }

        /* renamed from: a */
        public final BuilderType m42158a(MessageType messageType) {
            m42161b();
            C8211a.m42157a(this.f32193a, messageType);
            return this;
        }

        /* renamed from: a */
        public final /* synthetic */ zy mo6627a() {
            return (C8211a) clone();
        }

        /* renamed from: a */
        protected final /* synthetic */ zy mo6628a(zx zxVar) {
            return m42158a((abq) zxVar);
        }

        /* renamed from: b */
        protected final void m42161b() {
            if (this.f32195c) {
                abq abq = (abq) this.f32193a.mo6835a(C4918e.f14225d, null, null);
                C8211a.m42157a(abq, this.f32193a);
                this.f32193a = abq;
                this.f32195c = false;
            }
        }

        /* renamed from: c */
        public final MessageType m42162c() {
            Object obj;
            boolean z = true;
            if (!this.f32195c) {
                obj = this.f32193a;
                adk.m18007a().m18010a(obj).mo3761c(obj);
                this.f32195c = true;
            }
            obj = this.f32193a;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) obj.mo6835a(C4918e.f14222a, null, null)).byteValue();
            if (byteValue != (byte) 1) {
                if (byteValue == (byte) 0) {
                    z = false;
                } else {
                    z = adk.m18007a().m18010a(obj).mo3762d(obj);
                    if (booleanValue) {
                        obj.mo6835a(C4918e.f14223b, z ? obj : null, null);
                    }
                }
            }
            if (z) {
                return obj;
            }
            throw new aei(obj);
        }

        public /* synthetic */ Object clone() {
            C8211a c8211a = (C8211a) this.f32194b.mo6835a(C4918e.f14226e, null, null);
            if (!this.f32195c) {
                Object obj = this.f32193a;
                adk.m18007a().m18010a(obj).mo3761c(obj);
                this.f32195c = true;
            }
            c8211a.m42158a(this.f32193a);
            return c8211a;
        }

        /* renamed from: d */
        public final /* synthetic */ acx mo6630d() {
            if (this.f32195c) {
                return this.f32193a;
            }
            Object obj = this.f32193a;
            adk.m18007a().m18010a(obj).mo3761c(obj);
            this.f32195c = true;
            return this.f32193a;
        }

        /* renamed from: e */
        public final /* synthetic */ acx mo6631e() {
            Object obj;
            boolean z = true;
            if (!this.f32195c) {
                obj = this.f32193a;
                adk.m18007a().m18010a(obj).mo3761c(obj);
                this.f32195c = true;
            }
            obj = this.f32193a;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) obj.mo6835a(C4918e.f14222a, null, null)).byteValue();
            if (byteValue != (byte) 1) {
                if (byteValue == (byte) 0) {
                    z = false;
                } else {
                    z = adk.m18007a().m18010a(obj).mo3762d(obj);
                    if (booleanValue) {
                        obj.mo6835a(C4918e.f14223b, z ? obj : null, null);
                    }
                }
            }
            if (z) {
                return obj;
            }
            throw new aei(obj);
        }

        /* renamed from: k */
        public final boolean mo6632k() {
            return abq.m42175a(this.f32193a, false);
        }

        /* renamed from: p */
        public final /* synthetic */ acx mo6633p() {
            return this.f32194b;
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.abq$c */
    public static abstract class C8281c<MessageType extends C8281c<MessageType, BuilderType>, BuilderType> extends abq<MessageType, BuilderType> implements acz {
        protected abi<Object> zzdtz = abi.m17901a();
    }

    /* renamed from: a */
    protected static <T extends abq<T, ?>> T m42167a(T t, aai aai) {
        boolean booleanValue;
        byte byteValue;
        Object a = m42168a((abq) t, aai, abd.m17883a());
        boolean z = false;
        if (a != null) {
            boolean z2;
            booleanValue = Boolean.TRUE.booleanValue();
            byteValue = ((Byte) a.mo6835a(C4918e.f14222a, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z2 = true;
            } else if (byteValue == (byte) 0) {
                z2 = false;
            } else {
                z2 = adk.m18007a().m18010a(a).mo3762d(a);
                if (booleanValue) {
                    a.mo6835a(C4918e.f14223b, z2 ? a : null, null);
                }
            }
            if (!z2) {
                throw new aei(a).m18175a().m17953a(a);
            }
        }
        if (a != null) {
            booleanValue = Boolean.TRUE.booleanValue();
            byteValue = ((Byte) a.mo6835a(C4918e.f14222a, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z = true;
            } else if (byteValue != (byte) 0) {
                z = adk.m18007a().m18010a(a).mo3762d(a);
                if (booleanValue) {
                    a.mo6835a(C4918e.f14223b, z ? a : null, null);
                }
            }
            if (!z) {
                throw new aei(a).m18175a().m17953a(a);
            }
        }
        return a;
    }

    /* renamed from: a */
    private static <T extends abq<T, ?>> T m42168a(T t, aai aai, abd abd) {
        try {
            aar e = aai.mo6044e();
            t = m42169a((abq) t, e, abd);
            e.mo3618a(0);
            return t;
        } catch (abw e2) {
            throw e2.m17953a(t);
        } catch (abw e3) {
            throw e3;
        }
    }

    /* renamed from: a */
    private static <T extends abq<T, ?>> T m42169a(T t, aar aar, abd abd) {
        Object obj = (abq) t.mo6835a(C4918e.f14225d, null, null);
        try {
            adk.m18007a().m18010a(obj).mo3755a(obj, aau.m29541a(aar), abd);
            adk.m18007a().m18010a(obj).mo3761c(obj);
            return obj;
        } catch (IOException e) {
            if (e.getCause() instanceof abw) {
                throw ((abw) e.getCause());
            }
            throw new abw(e.getMessage()).m17953a(obj);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof abw) {
                throw ((abw) e2.getCause());
            }
            throw e2;
        }
    }

    /* renamed from: a */
    protected static <T extends abq<T, ?>> T m42170a(T t, byte[] bArr) {
        Object b = m42176b(t, bArr);
        if (b != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) b.mo6835a(C4918e.f14222a, null, null)).byteValue();
            boolean z = true;
            if (byteValue != (byte) 1) {
                if (byteValue == (byte) 0) {
                    z = false;
                } else {
                    z = adk.m18007a().m18010a(b).mo3762d(b);
                    if (booleanValue) {
                        b.mo6835a(C4918e.f14223b, z ? b : null, null);
                    }
                }
            }
            if (!z) {
                throw new aei(b).m18175a().m17953a(b);
            }
        }
        return b;
    }

    /* renamed from: a */
    static <T extends abq<?, ?>> T m42171a(Class<T> cls) {
        T t = (abq) zzdtv.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (abq) zzdtv.get(cls);
            } catch (Throwable e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String str = "Unable to get default instance for: ";
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: a */
    protected static Object m42172a(acx acx, String str, Object[] objArr) {
        return new adm(acx, str, objArr);
    }

    /* renamed from: a */
    static Object m42173a(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }

    /* renamed from: a */
    protected static <T extends abq<?, ?>> void m42174a(Class<T> cls, T t) {
        zzdtv.put(cls, t);
    }

    /* renamed from: a */
    protected static final <T extends abq<T, ?>> boolean m42175a(T t, boolean z) {
        byte byteValue = ((Byte) t.mo6835a(C4918e.f14222a, null, null)).byteValue();
        return byteValue == (byte) 1 ? true : byteValue == (byte) 0 ? false : adk.m18007a().m18010a((Object) t).mo3762d(t);
    }

    /* renamed from: b */
    private static <T extends com.google.android.gms.internal.ads.abq<T, ?>> T m42176b(T r6, byte[] r7) {
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
        r0 = com.google.android.gms.internal.ads.abq.C4918e.f14225d;
        r1 = 0;
        r6 = r6.mo6835a(r0, r1, r1);
        r6 = (com.google.android.gms.internal.ads.abq) r6;
        r0 = com.google.android.gms.internal.ads.adk.m18007a();	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r0 = r0.m18010a(r6);	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r3 = 0;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r4 = r7.length;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r5 = new com.google.android.gms.internal.ads.aaf;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r5.<init>();	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r1 = r6;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r2 = r7;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r0.mo3757a(r1, r2, r3, r4, r5);	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7 = com.google.android.gms.internal.ads.adk.m18007a();	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7 = r7.m18010a(r6);	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7.mo3761c(r6);	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7 = r6.zzdpf;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        if (r7 != 0) goto L_0x002d;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
    L_0x002c:
        return r6;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
    L_0x002d:
        r7 = new java.lang.RuntimeException;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7.<init>();	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        throw r7;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
    L_0x0033:
        r7 = com.google.android.gms.internal.ads.abw.m17945a();
        r6 = r7.m17953a(r6);
        throw r6;
    L_0x003c:
        r7 = move-exception;
        r0 = r7.getCause();
        r0 = r0 instanceof com.google.android.gms.internal.ads.abw;
        if (r0 == 0) goto L_0x004c;
    L_0x0045:
        r6 = r7.getCause();
        r6 = (com.google.android.gms.internal.ads.abw) r6;
        throw r6;
    L_0x004c:
        r0 = new com.google.android.gms.internal.ads.abw;
        r7 = r7.getMessage();
        r0.<init>(r7);
        r6 = r0.m17953a(r6);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.abq.b(com.google.android.gms.internal.ads.abq, byte[]):T");
    }

    /* renamed from: m */
    protected static <E> abv<E> m42177m() {
        return adl.m36738d();
    }

    /* renamed from: a */
    protected abstract Object mo6835a(int i, Object obj, Object obj2);

    /* renamed from: a */
    final void mo6634a(int i) {
        this.zzdtu = i;
    }

    /* renamed from: a */
    public final void mo6635a(aaw aaw) {
        adk.m18007a().m18009a(getClass()).mo3756a((Object) this, aay.m29676a(aaw));
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !((abq) mo6835a(C4918e.f14227f, null, null)).getClass().isInstance(obj) ? false : adk.m18007a().m18010a((Object) this).mo3758a((Object) this, (abq) obj);
    }

    public int hashCode() {
        if (this.zzdpf != 0) {
            return this.zzdpf;
        }
        this.zzdpf = adk.m18007a().m18010a((Object) this).mo3753a(this);
        return this.zzdpf;
    }

    /* renamed from: j */
    final int mo6636j() {
        return this.zzdtu;
    }

    /* renamed from: k */
    public final boolean mo6632k() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) mo6835a(C4918e.f14222a, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return false;
        }
        boolean d = adk.m18007a().m18010a((Object) this).mo3762d(this);
        if (booleanValue) {
            mo6835a(C4918e.f14223b, d ? this : null, null);
        }
        return d;
    }

    /* renamed from: l */
    public final int mo6637l() {
        if (this.zzdtu == -1) {
            this.zzdtu = adk.m18007a().m18010a((Object) this).mo3759b(this);
        }
        return this.zzdtu;
    }

    /* renamed from: n */
    public final /* synthetic */ acy mo6638n() {
        C8211a c8211a = (C8211a) mo6835a(C4918e.f14226e, null, null);
        c8211a.m42158a(this);
        return c8211a;
    }

    /* renamed from: o */
    public final /* synthetic */ acy mo6639o() {
        return (C8211a) mo6835a(C4918e.f14226e, null, null);
    }

    /* renamed from: p */
    public final /* synthetic */ acx mo6633p() {
        return (abq) mo6835a(C4918e.f14227f, null, null);
    }

    public String toString() {
        return ada.m17999a(this, super.toString());
    }
}
