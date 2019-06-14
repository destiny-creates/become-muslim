package p289e.p290a;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import p289e.p300f.C5979f;

/* compiled from: OnErrorThrowable */
/* renamed from: e.a.g */
public final class C5910g extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;

    /* compiled from: OnErrorThrowable */
    /* renamed from: e.a.g$a */
    public static class C5909a extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        /* renamed from: a */
        private final Object f19630a;

        /* compiled from: OnErrorThrowable */
        /* renamed from: e.a.g$a$a */
        static final class C5908a {
            /* renamed from: a */
            static final Set<Class<?>> f19629a = C5908a.m24796a();

            /* renamed from: a */
            private static Set<Class<?>> m24796a() {
                Set<Class<?>> hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public C5909a(Object obj) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OnError while emitting onNext value: ");
            stringBuilder.append(C5909a.m24797a(obj));
            super(stringBuilder.toString());
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Object obj2) {
                    obj2 = obj2.getMessage();
                }
            }
            this.f19630a = obj2;
        }

        /* renamed from: a */
        public Object m24798a() {
            return this.f19630a;
        }

        /* renamed from: a */
        static String m24797a(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (C5908a.f19629a.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String a = C5979f.m25082a().m25084b().m25054a(obj);
            if (a != null) {
                return a;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj.getClass().getName());
            stringBuilder.append(".class");
            return stringBuilder.toString();
        }
    }

    /* renamed from: a */
    public static Throwable m24799a(Throwable th, Object obj) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable c = C5903b.m24795c(th);
        if ((c instanceof C5909a) && ((C5909a) c).m24798a() == obj) {
            return th;
        }
        C5903b.m24792a(th, new C5909a(obj));
        return th;
    }
}
