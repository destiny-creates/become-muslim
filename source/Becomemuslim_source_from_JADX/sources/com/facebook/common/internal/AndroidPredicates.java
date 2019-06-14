package com.facebook.common.internal;

public class AndroidPredicates {

    /* renamed from: com.facebook.common.internal.AndroidPredicates$1 */
    static class C37151 implements Predicate<T> {
        public boolean apply(T t) {
            return true;
        }

        C37151() {
        }
    }

    /* renamed from: com.facebook.common.internal.AndroidPredicates$2 */
    static class C37162 implements Predicate<T> {
        public boolean apply(T t) {
            return false;
        }

        C37162() {
        }
    }

    private AndroidPredicates() {
    }

    public static <T> Predicate<T> True() {
        return new C37151();
    }

    public static <T> Predicate<T> False() {
        return new C37162();
    }
}
