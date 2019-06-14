package expo.p304a;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.C6002i;
import expo.p304a.p305a.C6003j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: ModuleRegistryProvider */
/* renamed from: expo.a.e */
public class C6008e {
    /* renamed from: a */
    private List<C6002i> f19796a;

    public C6008e(List<C6002i> list) {
        this.f19796a = list;
    }

    /* renamed from: a */
    protected List<C6002i> m25146a() {
        return this.f19796a;
    }

    /* renamed from: a */
    public C6007d mo5139a(Context context) {
        return new C6007d(m25147c(context), m25148d(context), m25149e(context), m25150f(context));
    }

    /* renamed from: c */
    public Collection<C5998e> m25147c(Context context) {
        Collection<C5998e> arrayList = new ArrayList();
        for (C6002i createInternalModules : m25146a()) {
            arrayList.addAll(createInternalModules.createInternalModules(context));
        }
        return arrayList;
    }

    /* renamed from: d */
    public Collection<C6006c> m25148d(Context context) {
        Collection<C6006c> arrayList = new ArrayList();
        for (C6002i createExportedModules : m25146a()) {
            arrayList.addAll(createExportedModules.createExportedModules(context));
        }
        return arrayList;
    }

    /* renamed from: e */
    public Collection<C6012g> m25149e(Context context) {
        Collection<C6012g> arrayList = new ArrayList();
        for (C6002i createViewManagers : m25146a()) {
            arrayList.addAll(createViewManagers.createViewManagers(context));
        }
        return arrayList;
    }

    /* renamed from: f */
    public Collection<C6003j> m25150f(Context context) {
        Collection<C6003j> arrayList = new ArrayList();
        for (C6002i createSingletonModules : m25146a()) {
            arrayList.addAll(createSingletonModules.createSingletonModules(context));
        }
        return arrayList;
    }
}
