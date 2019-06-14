package expolib_v1.p321a.p322a.p324b;

import expolib_v1.p321a.ad;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase */
/* renamed from: expolib_v1.a.a.b.d */
public final class C6150d {
    /* renamed from: a */
    private final Set<ad> f19873a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m25233a(ad adVar) {
        this.f19873a.add(adVar);
    }

    /* renamed from: b */
    public synchronized void m25234b(ad adVar) {
        this.f19873a.remove(adVar);
    }

    /* renamed from: c */
    public synchronized boolean m25235c(ad adVar) {
        return this.f19873a.contains(adVar);
    }
}
