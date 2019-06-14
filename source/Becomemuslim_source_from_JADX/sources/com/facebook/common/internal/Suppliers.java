package com.facebook.common.internal;

public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_FALSE = new C37193();
    public static final Supplier<Boolean> BOOLEAN_TRUE = new C37182();

    /* renamed from: com.facebook.common.internal.Suppliers$2 */
    static class C37182 implements Supplier<Boolean> {
        C37182() {
        }

        public Boolean get() {
            return Boolean.valueOf(true);
        }
    }

    /* renamed from: com.facebook.common.internal.Suppliers$3 */
    static class C37193 implements Supplier<Boolean> {
        C37193() {
        }

        public Boolean get() {
            return Boolean.valueOf(false);
        }
    }

    public static <T> Supplier<T> of(final T t) {
        return new Supplier<T>() {
            public T get() {
                return t;
            }
        };
    }
}
