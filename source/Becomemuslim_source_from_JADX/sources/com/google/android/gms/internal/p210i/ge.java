package com.google.android.gms.internal.p210i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.i.ge */
final class ge extends gc {
    /* renamed from: a */
    private static final Class<?> f24500a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private ge() {
        super();
    }

    /* renamed from: a */
    final <L> List<L> mo4556a(Object obj, long j) {
        return ge.m31599a(obj, j, 10);
    }

    /* renamed from: b */
    final void mo4558b(Object obj, long j) {
        Object e;
        List list = (List) ih.m20843f(obj, j);
        if (list instanceof gb) {
            e = ((gb) list).mo4606e();
        } else if (!f24500a.isAssignableFrom(list.getClass())) {
            if ((list instanceof he) && (list instanceof fr)) {
                fr frVar = (fr) list;
                if (frVar.mo4429a() != null) {
                    frVar.mo4430b();
                }
                return;
            }
            e = Collections.unmodifiableList(list);
        } else {
            return;
        }
        ih.m20820a(obj, j, e);
    }

    /* renamed from: a */
    private static <L> List<L> m31599a(Object obj, long j, int i) {
        List<L> c = ge.m31600c(obj, j);
        Object gaVar;
        if (c.isEmpty()) {
            if (c instanceof gb) {
                gaVar = new ga(i);
            } else if ((c instanceof he) && (c instanceof fr)) {
                gaVar = ((fr) c).mo6150a(i);
            } else {
                gaVar = new ArrayList(i);
            }
            ih.m20820a(obj, j, gaVar);
            return gaVar;
        }
        ArrayList arrayList;
        if (f24500a.isAssignableFrom(c.getClass())) {
            arrayList = new ArrayList(c.size() + i);
            arrayList.addAll(c);
            ih.m20820a(obj, j, (Object) arrayList);
        } else if (c instanceof ie) {
            Object gaVar2 = new ga(c.size() + i);
            gaVar2.addAll((ie) c);
            ih.m20820a(obj, j, gaVar2);
        } else if (!(c instanceof he) || !(c instanceof fr)) {
            return c;
        } else {
            fr frVar = (fr) c;
            if (frVar.mo4429a()) {
                return c;
            }
            gaVar = frVar.mo6150a(c.size() + i);
            ih.m20820a(obj, j, gaVar);
            return gaVar;
        }
        return arrayList;
    }

    /* renamed from: a */
    final <E> void mo4557a(Object obj, Object obj2, long j) {
        obj2 = ge.m31600c(obj2, j);
        List a = ge.m31599a(obj, j, obj2.size());
        int size = a.size();
        int size2 = obj2.size();
        if (size > 0 && size2 > 0) {
            a.addAll(obj2);
        }
        if (size > 0) {
            obj2 = a;
        }
        ih.m20820a(obj, j, obj2);
    }

    /* renamed from: c */
    private static <E> List<E> m31600c(Object obj, long j) {
        return (List) ih.m20843f(obj, j);
    }
}
