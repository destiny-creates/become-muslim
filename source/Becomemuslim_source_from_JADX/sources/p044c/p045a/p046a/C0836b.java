package p044c.p045a.p046a;

import java.util.Arrays;

/* compiled from: Intrinsics */
/* renamed from: c.a.a.b */
public class C0836b {
    private C0836b() {
    }

    /* renamed from: a */
    public static void m3014a(Object obj, String str) {
        if (obj == null) {
            C0836b.m3015a(str);
        }
    }

    /* renamed from: a */
    private static void m3015a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append(className);
        stringBuilder.append(".");
        stringBuilder.append(methodName);
        stringBuilder.append(", parameter ");
        stringBuilder.append(str);
        throw ((IllegalArgumentException) C0836b.m3012a(new IllegalArgumentException(stringBuilder.toString())));
    }

    /* renamed from: a */
    private static <T extends Throwable> T m3012a(T t) {
        return C0836b.m3013a((Throwable) t, C0836b.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m3013a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        str = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) str.toArray(new StackTraceElement[str.size()]));
        return t;
    }
}
