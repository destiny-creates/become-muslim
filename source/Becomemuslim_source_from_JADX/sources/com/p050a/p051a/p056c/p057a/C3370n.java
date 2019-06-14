package com.p050a.p051a.p056c.p057a;

import com.p050a.p051a.p062f.C0950a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue */
/* renamed from: com.a.a.c.a.n */
abstract class C3370n<V, O> implements C0893m<V, O> {
    /* renamed from: a */
    final List<C0950a<V>> f8945a;

    C3370n(V v) {
        this(Collections.singletonList(new C0950a(v)));
    }

    C3370n(List<C0950a<V>> list) {
        this.f8945a = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.f8945a.isEmpty()) {
            stringBuilder.append("values=");
            stringBuilder.append(Arrays.toString(this.f8945a.toArray()));
        }
        return stringBuilder.toString();
    }
}
