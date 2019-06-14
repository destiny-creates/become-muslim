package org.spongycastle.asn1.eac;

import java.util.Hashtable;

public class BidirectionalMap extends Hashtable {
    private static final long serialVersionUID = -7457289971962812909L;
    /* renamed from: a */
    Hashtable f21597a = new Hashtable();

    public Object put(Object obj, Object obj2) {
        this.f21597a.put(obj2, obj);
        return super.put(obj, obj2);
    }
}
