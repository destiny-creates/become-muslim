package com.raizlabs.android.dbflow.p273c.p274a.p275a;

import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p273c.C5673e;
import com.raizlabs.android.dbflow.p281e.C5698h;
import java.util.Collection;

/* compiled from: ProcessModelHelper */
/* renamed from: com.raizlabs.android.dbflow.c.a.a.b */
public class C5661b {
    /* renamed from: a */
    public static <ModelClass extends C5698h> void m24012a(Class<? extends C5698h> cls, final Collection<ModelClass> collection, final C5659a<ModelClass> c5659a) {
        if (!collection.isEmpty()) {
            C5673e.m24046a(C5680f.m24086b(cls).m24064f(), new Runnable() {
                public void run() {
                    for (C5698h a : collection) {
                        c5659a.mo5045a(a);
                    }
                }
            });
        }
    }
}
