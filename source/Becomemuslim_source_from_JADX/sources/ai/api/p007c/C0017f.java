package ai.api.p007c;

import com.google.p127a.p128a.C2118a;
import java.lang.reflect.Type;

/* compiled from: ResponseMessage */
/* renamed from: ai.api.c.f */
public abstract class C0017f {
    /* renamed from: a */
    static final /* synthetic */ boolean f72a = (C0017f.class.desiredAssertionStatus() ^ 1);
    @C2118a
    /* renamed from: b */
    private int f73b;

    /* compiled from: ResponseMessage */
    /* renamed from: ai.api.c.f$a */
    public enum C0016a {
        SPEECH(0, C3095f.class),
        CARD(1, C3091b.class),
        QUICK_REPLY(2, C3094e.class),
        IMAGE(3, C3092c.class),
        PAYLOAD(4, C3093d.class);
        
        /* renamed from: f */
        private final int f70f;
        /* renamed from: g */
        private final Type f71g;

        private C0016a(int i, Type type) {
            this.f70f = i;
            this.f71g = type;
        }

        /* renamed from: a */
        public int m62a() {
            return this.f70f;
        }

        /* renamed from: b */
        public Type m63b() {
            return this.f71g;
        }
    }

    /* compiled from: ResponseMessage */
    /* renamed from: ai.api.c.f$b */
    public static class C3091b extends C0017f {
        public C3091b() {
            super(C0016a.CARD);
        }
    }

    /* compiled from: ResponseMessage */
    /* renamed from: ai.api.c.f$c */
    public static class C3092c extends C0017f {
        public C3092c() {
            super(C0016a.IMAGE);
        }
    }

    /* compiled from: ResponseMessage */
    /* renamed from: ai.api.c.f$d */
    public static class C3093d extends C0017f {
        public C3093d() {
            super(C0016a.PAYLOAD);
        }
    }

    /* compiled from: ResponseMessage */
    /* renamed from: ai.api.c.f$e */
    public static class C3094e extends C0017f {
        public C3094e() {
            super(C0016a.QUICK_REPLY);
        }
    }

    /* compiled from: ResponseMessage */
    /* renamed from: ai.api.c.f$f */
    public static class C3095f extends C0017f {
        public C3095f() {
            super(C0016a.SPEECH);
        }
    }

    protected C0017f(C0016a c0016a) {
        if (!f72a) {
            if (c0016a == null) {
                throw new AssertionError();
            }
        }
        this.f73b = c0016a.f70f;
    }
}
