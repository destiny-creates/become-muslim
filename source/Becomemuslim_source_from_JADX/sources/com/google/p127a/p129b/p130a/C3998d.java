package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.p128a.C2119b;
import com.google.p127a.p129b.C2133c;
import com.google.p127a.p131c.C2150a;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
/* renamed from: com.google.a.b.a.d */
public final class C3998d implements C2169x {
    /* renamed from: a */
    private final C2133c f10018a;

    public C3998d(C2133c c2133c) {
        this.f10018a = c2133c;
    }

    /* renamed from: a */
    public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
        C2119b c2119b = (C2119b) c2150a.m5891a().getAnnotation(C2119b.class);
        if (c2119b == null) {
            return null;
        }
        return C3998d.m12230a(this.f10018a, c2157f, c2150a, c2119b);
    }

    /* renamed from: a */
    static C2168w<?> m12230a(C2133c c2133c, C2157f c2157f, C2150a<?> c2150a, C2119b c2119b) {
        c2119b = c2119b.m5822a();
        if (C2168w.class.isAssignableFrom(c2119b)) {
            return (C2168w) c2133c.m5861a(C2150a.m5890b(c2119b)).mo2026a();
        }
        if (C2169x.class.isAssignableFrom(c2119b)) {
            return ((C2169x) c2133c.m5861a(C2150a.m5890b(c2119b)).mo2026a()).mo1990a(c2157f, c2150a);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }
}
