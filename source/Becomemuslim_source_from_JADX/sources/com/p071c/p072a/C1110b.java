package com.p071c.p072a;

import java.io.Serializable;
import p289e.C5982f;

/* compiled from: NotificationLite */
/* renamed from: com.c.a.b */
final class C1110b {
    /* renamed from: a */
    private static final Object f3125a = new C11091();

    /* compiled from: NotificationLite */
    /* renamed from: com.c.a.b$1 */
    static class C11091 implements Serializable {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }

        C11091() {
        }
    }

    /* renamed from: a */
    public static <T> Object m3936a(T t) {
        return t == null ? f3125a : t;
    }

    /* renamed from: a */
    public static <T> boolean m3937a(C5982f<? super T> c5982f, Object obj) {
        if (obj == f3125a) {
            c5982f.a(null);
            return false;
        } else if (obj != null) {
            c5982f.a(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    /* renamed from: b */
    public static <T> T m3938b(Object obj) {
        return obj == f3125a ? null : obj;
    }
}
