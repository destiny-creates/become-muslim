package com.facebook.stetho.common;

public class ExceptionUtil {
    public static <T extends Throwable> void propagateIfInstanceOf(Throwable th, Class<T> cls) {
        if (cls.isInstance(th) != null) {
            throw th;
        }
    }

    public static RuntimeException propagate(Throwable th) {
        propagateIfInstanceOf(th, Error.class);
        propagateIfInstanceOf(th, RuntimeException.class);
        throw new RuntimeException(th);
    }

    public static <T extends Throwable> void sneakyThrow(Throwable th) {
        throw th;
    }
}
