package p289e.p299e;

import p289e.C5982f;
import p289e.C7367k;

/* compiled from: Subscribers */
/* renamed from: e.e.e */
public final class C5973e {
    /* renamed from: a */
    public static <T> C7367k<T> m24964a() {
        return C5973e.m24965a(C5971a.m24962a());
    }

    /* renamed from: a */
    public static <T> C7367k<T> m24965a(final C5982f<? super T> c5982f) {
        return new C7367k<T>() {
            public void L_() {
                c5982f.L_();
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c5982f.mo5001a(th);
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                c5982f.mo5000a((Object) t);
            }
        };
    }

    /* renamed from: a */
    public static <T> C7367k<T> m24966a(final C7367k<? super T> c7367k) {
        return new C7367k<T>(c7367k) {
            public void L_() {
                c7367k.L_();
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c7367k.mo5001a(th);
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                c7367k.mo5000a((Object) t);
            }
        };
    }
}
