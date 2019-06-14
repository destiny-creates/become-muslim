package android.arch.lifecycle;

import java.util.HashMap;

/* compiled from: ViewModelStore */
/* renamed from: android.arch.lifecycle.p */
public class C0088p {
    /* renamed from: a */
    private final HashMap<String, C0085n> f216a = new HashMap();

    /* renamed from: a */
    final void m206a(String str, C0085n c0085n) {
        C0085n c0085n2 = (C0085n) this.f216a.get(str);
        if (c0085n2 != null) {
            c0085n2.mo173a();
        }
        this.f216a.put(str, c0085n);
    }

    /* renamed from: a */
    final C0085n m204a(String str) {
        return (C0085n) this.f216a.get(str);
    }

    /* renamed from: a */
    public final void m205a() {
        for (C0085n a : this.f216a.values()) {
            a.mo173a();
        }
        this.f216a.clear();
    }
}
