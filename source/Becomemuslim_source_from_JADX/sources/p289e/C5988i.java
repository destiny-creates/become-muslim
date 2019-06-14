package p289e;

import p289e.p290a.C5903b;
import p289e.p291b.C5914b;
import p289e.p291b.C5919g;
import p289e.p292c.p293a.bh;
import p289e.p292c.p293a.bi;
import p289e.p300f.C5977c;

/* compiled from: Single */
/* renamed from: e.i */
public class C5988i<T> {
    /* renamed from: a */
    final C7359a<T> f19786a;

    /* compiled from: Single */
    /* renamed from: e.i$a */
    public interface C7359a<T> extends C5914b<C7366j<? super T>> {
    }

    protected C5988i(C7359a<T> c7359a) {
        this.f19786a = C5977c.m25064a((C7359a) c7359a);
    }

    /* renamed from: a */
    public static <T> C5988i<T> m25121a(C7359a<T> c7359a) {
        return new C5988i(c7359a);
    }

    /* renamed from: a */
    private static <T> C5974e<T> m25120a(C5988i<T> c5988i) {
        return C5974e.m24972a(new bi(c5988i.f19786a));
    }

    /* renamed from: a */
    public final <R> C5974e<R> m25122a(C5919g<? super T, ? extends C5974e<? extends R>> c5919g) {
        return C5974e.m24982b(C5988i.m25120a(m25124b(c5919g)));
    }

    /* renamed from: b */
    public final <R> C5988i<R> m25124b(C5919g<? super T, ? extends R> c5919g) {
        return C5988i.m25121a(new bh(this, c5919g));
    }

    /* renamed from: a */
    public final C5989l m25123a(C7366j<? super T> c7366j) {
        if (c7366j != null) {
            try {
                C5977c.m25065a(this, this.f19786a).mo4974b(c7366j);
                return C5977c.m25070b((C5989l) c7366j);
            } catch (C7366j<? super T> c7366j2) {
                C5903b.m24794b(c7366j2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error occurred attempting to subscribe [");
                stringBuilder.append(th.getMessage());
                stringBuilder.append("] and then again while trying to pass to onError.");
                C5977c.m25075d(new RuntimeException(stringBuilder.toString(), c7366j2));
            }
        } else {
            throw new IllegalArgumentException("te is null");
        }
    }
}
