package p000a.p001a.p002a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: SetBuilder */
/* renamed from: a.a.a.e */
public final class C0001e<T> {
    /* renamed from: a */
    private final List<T> f0a;

    private C0001e(int i) {
        this.f0a = new ArrayList(i);
    }

    /* renamed from: a */
    public static <T> C0001e<T> m2a(int i) {
        return new C0001e(i);
    }

    /* renamed from: a */
    public C0001e<T> m3a(T t) {
        this.f0a.add(C0000d.m1a(t, "Set contributions cannot be null"));
        return this;
    }

    /* renamed from: a */
    public Set<T> m4a() {
        switch (this.f0a.size()) {
            case 0:
                return Collections.emptySet();
            case 1:
                return Collections.singleton(this.f0a.get(0));
            default:
                return Collections.unmodifiableSet(new HashSet(this.f0a));
        }
    }
}
