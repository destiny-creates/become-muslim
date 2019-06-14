package expo.p304a;

/* compiled from: ArgumentsHelper */
/* renamed from: expo.a.a */
public class C6004a {
    /* renamed from: a */
    static Object m25129a(Object obj, Class<?> cls) {
        StringBuilder stringBuilder;
        if (Object.class.isAssignableFrom(cls)) {
            if (obj != null) {
                Class cls2 = obj.getClass();
                if (!cls.isAssignableFrom(cls2)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Argument of an incompatible class: ");
                    stringBuilder.append(cls2);
                    stringBuilder.append(" cannot be passed as an argument to parameter expecting ");
                    stringBuilder.append(cls);
                    stringBuilder.append(".");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        } else if (obj != null) {
            Class<?> cls3 = obj.getClass();
            if (!(cls == cls3 || Number.class.isAssignableFrom(cls3))) {
                if (!Boolean.class.isAssignableFrom(cls3)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Argument of an incompatible class: ");
                    stringBuilder.append(cls3);
                    stringBuilder.append(" cannot be passed as an argument to parameter expecting ");
                    stringBuilder.append(cls);
                    stringBuilder.append(".");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Argument null cannot be passed to an argument to parameter expecting ");
            stringBuilder2.append(cls);
            stringBuilder2.append(".");
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        return obj;
    }
}
