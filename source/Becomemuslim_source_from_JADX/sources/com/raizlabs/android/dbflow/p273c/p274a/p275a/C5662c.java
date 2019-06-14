package com.raizlabs.android.dbflow.p273c.p274a.p275a;

import com.raizlabs.android.dbflow.p273c.C5667b;
import com.raizlabs.android.dbflow.p273c.p274a.C5665d;
import com.raizlabs.android.dbflow.p281e.C5698h;
import com.raizlabs.android.dbflow.p281e.p385b.C7138a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: ProcessModelInfo */
/* renamed from: com.raizlabs.android.dbflow.c.a.a.c */
public class C5662c<ModelClass extends C5698h> {
    /* renamed from: a */
    List<ModelClass> f18916a = new ArrayList();
    /* renamed from: b */
    C5665d<List<ModelClass>> f18917b;
    /* renamed from: c */
    C5667b f18918c;
    /* renamed from: d */
    Class<ModelClass> f18919d;

    C5662c() {
    }

    /* renamed from: a */
    public static <ModelClass extends C5698h> C5662c<ModelClass> m24013a(Collection<ModelClass> collection) {
        return new C5662c().m24018b(collection);
    }

    /* renamed from: b */
    public C5662c<ModelClass> m24018b(Collection<ModelClass> collection) {
        this.f18916a.addAll(collection);
        if (collection != null && collection.size() > 0) {
            ArrayList arrayList = new ArrayList(collection);
            Class cls = ((C5698h) arrayList.get(0)).getClass();
            if (C7138a.class.isAssignableFrom(cls)) {
                this.f18919d = ((C7138a) arrayList.get(0)).m33193b();
            } else {
                this.f18919d = cls;
            }
        }
        return this;
    }

    /* renamed from: a */
    public C5662c<ModelClass> m24014a(C5665d<List<ModelClass>> c5665d) {
        this.f18917b = c5665d;
        return this;
    }

    /* renamed from: a */
    public C5662c<ModelClass> m24015a(C5667b c5667b) {
        this.f18918c = c5667b;
        return this;
    }

    /* renamed from: a */
    public C5667b m24016a() {
        if (this.f18918c == null) {
            this.f18918c = C5667b.m24035a();
        }
        return this.f18918c;
    }

    /* renamed from: b */
    public boolean m24019b() {
        return this.f18916a.isEmpty() ^ 1;
    }

    /* renamed from: a */
    public void m24017a(C5659a<ModelClass> c5659a) {
        if (!this.f18916a.isEmpty()) {
            Class cls = this.f18919d;
            if (C7138a.class.isAssignableFrom(cls) && !this.f18916a.isEmpty()) {
                cls = ((C7138a) this.f18916a.get(0)).m33193b();
            }
            C5661b.m24012a(cls, this.f18916a, c5659a);
        }
    }
}
