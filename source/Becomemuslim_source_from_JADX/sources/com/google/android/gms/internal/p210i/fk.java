package com.google.android.gms.internal.p210i;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.i.fk */
public abstract class fk<MessageType extends fk<MessageType, BuilderType>, BuilderType extends C8218a<MessageType, BuilderType>> extends dr<MessageType, BuilderType> {
    private static Map<Object, fk<?, ?>> zzbam = new ConcurrentHashMap();
    protected ic zzbak = ic.m20783a();
    private int zzbal = -1;

    /* renamed from: com.google.android.gms.internal.i.fk$e */
    public enum C4996e {
        /* renamed from: a */
        public static final int f16603a = 1;
        /* renamed from: b */
        public static final int f16604b = 2;
        /* renamed from: c */
        public static final int f16605c = 3;
        /* renamed from: d */
        public static final int f16606d = 4;
        /* renamed from: e */
        public static final int f16607e = 5;
        /* renamed from: f */
        public static final int f16608f = 6;
        /* renamed from: g */
        public static final int f16609g = 7;
        /* renamed from: h */
        public static final int f16610h = 1;
        /* renamed from: i */
        public static final int f16611i = 2;
        /* renamed from: j */
        public static final int f16612j = 1;
        /* renamed from: k */
        public static final int f16613k = 2;
        /* renamed from: l */
        private static final /* synthetic */ int[] f16614l = new int[]{f16603a, f16604b, f16605c, f16606d, f16607e, f16608f, f16609g};
        /* renamed from: m */
        private static final /* synthetic */ int[] f16615m = new int[]{f16610h, f16611i};
        /* renamed from: n */
        private static final /* synthetic */ int[] f16616n = new int[]{f16612j, f16613k};

        /* renamed from: a */
        public static int[] m20552a() {
            return (int[]) f16614l.clone();
        }
    }

    /* renamed from: com.google.android.gms.internal.i.fk$d */
    public static class C6793d<ContainingType extends gt, Type> extends eu<ContainingType, Type> {
    }

    /* renamed from: com.google.android.gms.internal.i.fk$b */
    public static class C7817b<T extends fk<T, ?>> extends dt<T> {
        /* renamed from: a */
        private final T f28906a;

        public C7817b(T t) {
            this.f28906a = t;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo6197a(el elVar, ew ewVar) {
            return fk.m42482a(this.f28906a, elVar, ewVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.fk$a */
    public static abstract class C8218a<MessageType extends fk<MessageType, BuilderType>, BuilderType extends C8218a<MessageType, BuilderType>> extends ds<MessageType, BuilderType> {
        /* renamed from: a */
        private final MessageType f32301a;
        /* renamed from: b */
        private MessageType f32302b;
        /* renamed from: c */
        private boolean f32303c = null;

        protected C8218a(MessageType messageType) {
            this.f32301a = messageType;
            this.f32302b = (fk) messageType.mo6849a(C4996e.f16606d, null, null);
        }

        /* renamed from: p */
        public final boolean mo6731p() {
            return fk.m42487a(this.f32302b, false);
        }

        /* renamed from: b */
        public MessageType m42476b() {
            if (this.f32303c) {
                return this.f32302b;
            }
            this.f32302b.m42493o();
            this.f32303c = true;
            return this.f32302b;
        }

        /* renamed from: c */
        public final MessageType m42477c() {
            fk fkVar = (fk) mo6729d();
            if (fkVar.mo6731p()) {
                return fkVar;
            }
            throw new ia(fkVar);
        }

        /* renamed from: a */
        public final BuilderType m42475a(MessageType messageType) {
            if (this.f32303c) {
                fk fkVar = (fk) this.f32302b.mo6849a(C4996e.f16606d, null, null);
                C8218a.m42472a(fkVar, this.f32302b);
                this.f32302b = fkVar;
                this.f32303c = false;
            }
            C8218a.m42472a(this.f32302b, messageType);
            return this;
        }

        /* renamed from: a */
        private static void m42472a(MessageType messageType, MessageType messageType2) {
            hf.m20628a().m20630a((Object) messageType).mo4574b(messageType, messageType2);
        }

        /* renamed from: a */
        protected final /* synthetic */ ds mo6727a(dr drVar) {
            return m42475a((fk) drVar);
        }

        /* renamed from: a */
        public final /* synthetic */ ds mo6726a() {
            return (C8218a) clone();
        }

        /* renamed from: d */
        public /* synthetic */ gt mo6729d() {
            return m42476b();
        }

        /* renamed from: e */
        public /* synthetic */ gt mo6730e() {
            return m42477c();
        }

        /* renamed from: v */
        public final /* synthetic */ gt mo6732v() {
            return this.f32301a;
        }

        public /* synthetic */ Object clone() {
            C8218a c8218a = (C8218a) this.f32301a.mo6849a(C4996e.f16607e, null, null);
            c8218a.m42475a((fk) mo6729d());
            return c8218a;
        }
    }

    /* renamed from: com.google.android.gms.internal.i.fk$c */
    public static abstract class C8336c<MessageType extends C8336c<MessageType, BuilderType>, BuilderType> extends fk<MessageType, BuilderType> implements gv {
        protected fa<Object> zzbaq = fa.m20525a();
    }

    /* renamed from: a */
    protected abstract Object mo6849a(int i, Object obj, Object obj2);

    public String toString() {
        return gw.m20619a(this, super.toString());
    }

    public int hashCode() {
        if (this.zzavp != 0) {
            return this.zzavp;
        }
        this.zzavp = hf.m20628a().m20630a((Object) this).mo4568a(this);
        return this.zzavp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((fk) mo6849a(C4996e.f16608f, null, null)).getClass().isInstance(obj)) {
            return hf.m20628a().m20630a((Object) this).mo4572a((Object) this, (fk) obj);
        }
        return null;
    }

    /* renamed from: o */
    protected final void m42493o() {
        hf.m20628a().m20630a((Object) this).mo4575c(this);
    }

    /* renamed from: p */
    public final boolean mo6731p() {
        return fk.m42487a(this, Boolean.TRUE.booleanValue());
    }

    /* renamed from: q */
    public final BuilderType m42495q() {
        C8218a c8218a = (C8218a) mo6849a(C4996e.f16607e, null, null);
        c8218a.m42475a(this);
        return c8218a;
    }

    /* renamed from: n */
    final int mo6735n() {
        return this.zzbal;
    }

    /* renamed from: a */
    final void mo6733a(int i) {
        this.zzbal = i;
    }

    /* renamed from: a */
    public final void mo6734a(eq eqVar) {
        hf.m20628a().m20629a(getClass()).mo4571a((Object) this, es.m31522a(eqVar));
    }

    /* renamed from: r */
    public final int mo6736r() {
        if (this.zzbal == -1) {
            this.zzbal = hf.m20628a().m20630a((Object) this).mo4573b(this);
        }
        return this.zzbal;
    }

    /* renamed from: a */
    static <T extends fk<?, ?>> T m42483a(Class<T> cls) {
        T t = (fk) zzbam.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (fk) zzbam.get(cls);
            } catch (Class<T> cls2) {
                throw new IllegalStateException("Class initialization cannot fail.", cls2);
            }
        }
        if (t == null) {
            t = (fk) ((fk) ih.m20812a((Class) cls2)).mo6849a(C4996e.f16608f, null, null);
            if (t != null) {
                zzbam.put(cls2, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    /* renamed from: a */
    protected static <T extends fk<?, ?>> void m42486a(Class<T> cls, T t) {
        zzbam.put(cls, t);
    }

    /* renamed from: a */
    protected static Object m42484a(gt gtVar, String str, Object[] objArr) {
        return new hg(gtVar, str, objArr);
    }

    /* renamed from: a */
    static Object m42485a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Method method2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", method2);
        } catch (Method method22) {
            method22 = method22.getCause();
            if ((method22 instanceof RuntimeException) != null) {
                throw ((RuntimeException) method22);
            } else if ((method22 instanceof Error) != null) {
                throw ((Error) method22);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", method22);
            }
        }
    }

    /* renamed from: a */
    protected static final <T extends fk<T, ?>> boolean m42487a(T t, boolean z) {
        byte byteValue = ((Byte) t.mo6849a(C4996e.f16603a, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return null;
        }
        boolean d = hf.m20628a().m20630a((Object) t).mo4576d(t);
        if (z) {
            t.mo6849a(C4996e.f16604b, d ? t : null, null);
        }
        return d;
    }

    /* renamed from: s */
    protected static fq m42488s() {
        return fl.m37954d();
    }

    /* renamed from: a */
    static <T extends fk<T, ?>> T m42482a(T t, el elVar, ew ewVar) {
        Object obj = (fk) t.mo6849a(C4996e.f16606d, null, null);
        try {
            hf.m20628a().m20630a(obj).mo4570a(obj, eo.m31383a(elVar), ewVar);
            obj.m42493o();
            return obj;
        } catch (el elVar2) {
            if ((elVar2.getCause() instanceof fs) != null) {
                throw ((fs) elVar2.getCause());
            }
            throw new fs(elVar2.getMessage()).m20576a(obj);
        } catch (T t2) {
            if ((t2.getCause() instanceof fs) != null) {
                throw ((fs) t2.getCause());
            }
            throw t2;
        }
    }

    /* renamed from: t */
    public final /* synthetic */ gu mo6737t() {
        C8218a c8218a = (C8218a) mo6849a(C4996e.f16607e, null, null);
        c8218a.m42475a(this);
        return c8218a;
    }

    /* renamed from: u */
    public final /* synthetic */ gu mo6738u() {
        return (C8218a) mo6849a(C4996e.f16607e, null, null);
    }

    /* renamed from: v */
    public final /* synthetic */ gt mo6732v() {
        return (fk) mo6849a(C4996e.f16608f, null, null);
    }
}
