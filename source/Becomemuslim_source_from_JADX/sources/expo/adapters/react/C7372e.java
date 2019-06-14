package expo.adapters.react;

import android.content.Context;
import expo.p304a.C6007d;
import expo.p304a.C6008e;
import expo.p304a.C6012g;
import expo.p304a.p305a.C6002i;
import expo.p304a.p305a.C6003j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: ReactModuleRegistryProvider */
/* renamed from: expo.adapters.react.e */
public class C7372e extends C6008e {
    /* renamed from: a */
    private Collection<C6012g> f25773a;
    /* renamed from: b */
    private Collection<C6003j> f25774b;

    public C7372e(List<C6002i> list, List<C6003j> list2) {
        super(list);
        this.f25774b = list2;
    }

    /* renamed from: a */
    public C6007d mo5139a(Context context) {
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        for (C6002i c6002i : m25146a()) {
            arrayList.addAll(c6002i.createInternalModules(context));
            arrayList2.addAll(c6002i.createExportedModules(context));
        }
        return new C6007d(arrayList, arrayList2, m33788b(context), m33786g(context));
    }

    /* renamed from: g */
    private Collection<C6003j> m33786g(Context context) {
        if (this.f25774b != null) {
            return this.f25774b;
        }
        Collection<C6003j> arrayList = new ArrayList();
        for (C6002i createSingletonModules : m25146a()) {
            arrayList.addAll(createSingletonModules.createSingletonModules(context));
        }
        return arrayList;
    }

    /* renamed from: b */
    Collection<C6012g> m33788b(Context context) {
        if (this.f25773a != null) {
            return this.f25773a;
        }
        this.f25773a = Collections.newSetFromMap(new WeakHashMap());
        this.f25773a.addAll(m25149e(context));
        return this.f25773a;
    }
}
