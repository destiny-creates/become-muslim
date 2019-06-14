package p289e.p292c.p293a;

import java.io.Serializable;
import p289e.C5982f;

/* compiled from: NotificationLite */
/* renamed from: e.c.a.h */
public final class C5937h {
    /* renamed from: a */
    private static final Object f19656a = new C59341();
    /* renamed from: b */
    private static final Object f19657b = new C59352();

    /* compiled from: NotificationLite */
    /* renamed from: e.c.a.h$1 */
    static class C59341 implements Serializable {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }

        C59341() {
        }
    }

    /* compiled from: NotificationLite */
    /* renamed from: e.c.a.h$2 */
    static class C59352 implements Serializable {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }

        C59352() {
        }
    }

    /* compiled from: NotificationLite */
    /* renamed from: e.c.a.h$a */
    static final class C5936a implements Serializable {
        private static final long serialVersionUID = 3;
        /* renamed from: a */
        final Throwable f19655a;

        public C5936a(Throwable th) {
            this.f19655a = th;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Notification=>Error:");
            stringBuilder.append(this.f19655a);
            return stringBuilder.toString();
        }
    }

    /* renamed from: a */
    public static <T> Object m24848a(T t) {
        return t == null ? f19657b : t;
    }

    /* renamed from: a */
    public static Object m24847a() {
        return f19656a;
    }

    /* renamed from: a */
    public static Object m24849a(Throwable th) {
        return new C5936a(th);
    }

    /* renamed from: a */
    public static <T> boolean m24850a(C5982f<? super T> c5982f, Object obj) {
        if (obj == f19656a) {
            c5982f.L_();
            return true;
        } else if (obj == f19657b) {
            c5982f.mo5000a(null);
            return false;
        } else if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        } else if (obj.getClass() == C5936a.class) {
            c5982f.mo5001a(((C5936a) obj).f19655a);
            return true;
        } else {
            c5982f.mo5000a(obj);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m24851b(Object obj) {
        return obj == f19656a ? true : null;
    }

    /* renamed from: c */
    public static boolean m24852c(Object obj) {
        return obj instanceof C5936a;
    }

    /* renamed from: d */
    public static <T> T m24853d(Object obj) {
        return obj == f19657b ? null : obj;
    }

    /* renamed from: e */
    public static Throwable m24854e(Object obj) {
        return ((C5936a) obj).f19655a;
    }
}
