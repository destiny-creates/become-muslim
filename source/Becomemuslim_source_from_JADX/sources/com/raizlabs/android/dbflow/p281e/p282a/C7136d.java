package com.raizlabs.android.dbflow.p281e.p282a;

import com.raizlabs.android.dbflow.p281e.C5698h;

/* compiled from: ModelLruCache */
/* renamed from: com.raizlabs.android.dbflow.e.a.d */
public class C7136d<ModelClass extends C5698h> extends C5694c<ModelClass, C5693b<Long, ModelClass>> {
    public C7136d(int i) {
        super(new C5693b(i));
    }

    /* renamed from: a */
    public ModelClass mo5062a(Object obj) {
        if (obj instanceof Number) {
            return (C5698h) ((C5693b) m24141a()).m24136a(Long.valueOf(((Number) obj).longValue()));
        }
        throw new IllegalArgumentException("A ModelLruCache must use an id that can cast toa Number to convert it into a long");
    }
}
