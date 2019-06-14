package org.spongycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionStore<T> implements Iterable<T>, Store<T> {
    /* renamed from: a */
    private Collection<T> f27884a;

    /* renamed from: a */
    public Collection<T> mo5936a(Selector<T> selector) {
        if (selector == null) {
            return new ArrayList(this.f27884a);
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.f27884a) {
            if (selector.mo5847a(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Iterator<T> iterator() {
        return mo5936a(null).iterator();
    }
}
