package host.exp.exponent.p339f;

import de.p287a.p288a.C5884c;
import host.exp.exponent.p339f.C6352l.C6349a;
import host.exp.exponent.p339f.C6352l.C6350b;
import host.exp.exponent.p339f.C6352l.C6351c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: KernelInterface */
/* renamed from: host.exp.exponent.f.m */
public abstract class C6353m {
    /* renamed from: a */
    private static final Map<String, Set<C6350b>> f20615a = new HashMap();

    /* renamed from: a */
    public abstract void mo5406a(C6351c c6351c);

    /* renamed from: a */
    public abstract void mo5407a(Exception exception);

    /* renamed from: a */
    public abstract void mo5408a(String str);

    /* renamed from: a */
    public abstract boolean mo5409a(String str, boolean z);

    /* renamed from: i */
    public boolean m26070i(String str) {
        return mo5409a(str, false);
    }

    /* renamed from: a */
    public void m26068a(String str, C6350b c6350b) {
        if (!f20615a.containsKey(str)) {
            f20615a.put(str, new HashSet());
        }
        ((Set) f20615a.get(str)).add(c6350b);
        C5884c.m24753a().m24769d(new C6349a(str));
    }

    /* renamed from: j */
    public Set<C6350b> m26071j(String str) {
        if (!f20615a.containsKey(str)) {
            return new HashSet();
        }
        Set<C6350b> set = (Set) f20615a.get(str);
        f20615a.remove(str);
        return set;
    }
}
