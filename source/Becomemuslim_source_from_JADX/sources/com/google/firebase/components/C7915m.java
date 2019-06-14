package com.google.firebase.components;

import com.google.android.gms.common.internal.C2872v;
import com.google.firebase.components.C5340a.C53381;
import com.google.firebase.p244a.C5322c;
import com.google.firebase.p244a.C5323d;
import com.google.firebase.p245b.C5334a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.m */
public final class C7915m extends C6903i {
    /* renamed from: a */
    private final List<C5340a<?>> f29529a;
    /* renamed from: b */
    private final Map<Class<?>, C6907q<?>> f29530b = new HashMap();
    /* renamed from: c */
    private final C6906o f29531c;

    public C7915m(Executor executor, Iterable<C5343d> iterable, C5340a<?>... c5340aArr) {
        this.f29531c = new C6906o(executor);
        List arrayList = new ArrayList();
        arrayList.add(C5340a.m22637a(this.f29531c, C6906o.class, C5323d.class, C5322c.class));
        for (C5343d components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        Collections.addAll(arrayList, c5340aArr);
        this.f29529a = Collections.unmodifiableList(C53381.m22625a(arrayList));
        for (C5340a a : this.f29529a) {
            m38511a(a);
        }
        m38510a();
    }

    /* renamed from: b */
    public final <T> C5334a<T> mo6263b(Class<T> cls) {
        C2872v.a(cls, "Null interface requested.");
        return (C5334a) this.f29530b.get(cls);
    }

    /* renamed from: a */
    public final void m38513a(boolean z) {
        for (C5340a c5340a : this.f29529a) {
            if (c5340a.m22643e() || (c5340a.m22644f() && z)) {
                mo4878a((Class) c5340a.m22639a().iterator().next());
            }
        }
        this.f29531c.m32368a();
    }

    /* renamed from: a */
    private <T> void m38511a(C5340a<T> c5340a) {
        C6907q c6907q = new C6907q(c5340a.m22641c(), new C7916s(c5340a, this));
        for (T put : c5340a.m22639a()) {
            this.f29530b.put(put, c6907q);
        }
    }

    /* renamed from: a */
    private void m38510a() {
        for (C5340a b : this.f29529a) {
            for (C5344e c5344e : b.m22640b()) {
                if (c5344e.m22650b()) {
                    if (!this.f29530b.containsKey(c5344e.m22649a())) {
                        throw new C6902h(String.format("Unsatisfied dependency for component %s: %s", new Object[]{b, c5344e.m22649a()}));
                    }
                }
            }
        }
    }
}
