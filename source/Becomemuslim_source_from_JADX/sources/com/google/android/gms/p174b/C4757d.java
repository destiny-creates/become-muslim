package com.google.android.gms.p174b;

import com.google.android.gms.p174b.C2758b.C4325a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.b.d */
public final class C4757d<T> extends C4325a {
    /* renamed from: a */
    private final T f13140a;

    private C4757d(T t) {
        this.f13140a = t;
    }

    /* renamed from: a */
    public static <T> C2758b m16684a(T t) {
        return new C4757d(t);
    }

    /* renamed from: a */
    public static <T> T m16685a(C2758b c2758b) {
        if (c2758b instanceof C4757d) {
            return ((C4757d) c2758b).f13140a;
        }
        c2758b = c2758b.asBinder();
        Field[] declaredFields = c2758b.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("Unexpected number of IObjectWrapper declared fields: ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            field.setAccessible(true);
            try {
                return field.get(c2758b);
            } catch (C2758b c2758b2) {
                throw new IllegalArgumentException("Binder object is null.", c2758b2);
            } catch (C2758b c2758b22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", c2758b22);
            }
        }
    }
}
