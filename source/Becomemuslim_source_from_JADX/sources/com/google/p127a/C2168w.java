package com.google.p127a;

import com.google.p127a.p129b.p130a.C4000f;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2154c;

/* compiled from: TypeAdapter */
/* renamed from: com.google.a.w */
public abstract class C2168w<T> {
    /* renamed from: a */
    public abstract void mo1991a(C2154c c2154c, T t);

    /* renamed from: b */
    public abstract T mo1992b(C2152a c2152a);

    /* renamed from: a */
    public final C2162l m6008a(T t) {
        try {
            C2154c c4000f = new C4000f();
            mo1991a(c4000f, t);
            return c4000f.mo2014a();
        } catch (Throwable e) {
            throw new C4050m(e);
        }
    }
}
