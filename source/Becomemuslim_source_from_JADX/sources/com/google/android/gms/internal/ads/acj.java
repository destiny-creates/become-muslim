package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class acj extends ach {
    /* renamed from: a */
    private static final Class<?> f23536a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private acj() {
        super();
    }

    /* renamed from: a */
    private static <L> List<L> m29733a(Object obj, long j, int i) {
        List<L> c = m29734c(obj, j);
        if (c.isEmpty()) {
            Object acf = c instanceof acg ? new acf(i) : new ArrayList(i);
            aep.m18229a(obj, j, acf);
            return acf;
        }
        List<L> arrayList;
        if (f23536a.isAssignableFrom(c.getClass())) {
            arrayList = new ArrayList(c.size() + i);
            arrayList.addAll(c);
        } else if (!(c instanceof aem)) {
            return c;
        } else {
            arrayList = new acf(c.size() + i);
            arrayList.addAll((aem) c);
        }
        aep.m18229a(obj, j, (Object) arrayList);
        return arrayList;
    }

    /* renamed from: c */
    private static <E> List<E> m29734c(Object obj, long j) {
        return (List) aep.m18251f(obj, j);
    }

    /* renamed from: a */
    final <L> List<L> mo3741a(Object obj, long j) {
        return m29733a(obj, j, 10);
    }

    /* renamed from: a */
    final <E> void mo3742a(Object obj, Object obj2, long j) {
        obj2 = m29734c(obj2, j);
        List a = m29733a(obj, j, obj2.size());
        int size = a.size();
        int size2 = obj2.size();
        if (size > 0 && size2 > 0) {
            a.addAll(obj2);
        }
        if (size > 0) {
            obj2 = a;
        }
        aep.m18229a(obj, j, obj2);
    }

    /* renamed from: b */
    final void mo3743b(Object obj, long j) {
        Object e;
        List list = (List) aep.m18251f(obj, j);
        if (list instanceof acg) {
            e = ((acg) list).mo3792e();
        } else if (!f23536a.isAssignableFrom(list.getClass())) {
            e = Collections.unmodifiableList(list);
        } else {
            return;
        }
        aep.m18229a(obj, j, e);
    }
}
