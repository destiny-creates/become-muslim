package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@cm
public final class py implements Iterable<pw> {
    /* renamed from: a */
    private final List<pw> f15932a = new ArrayList();

    /* renamed from: a */
    public static boolean m20029a(pn pnVar) {
        pw b = m20030b(pnVar);
        if (b == null) {
            return false;
        }
        b.f28733b.mo6125b();
        return true;
    }

    /* renamed from: b */
    static pw m20030b(pn pnVar) {
        Iterator it = ax.z().iterator();
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (pwVar.f28732a == pnVar) {
                return pwVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final int m20031a() {
        return this.f15932a.size();
    }

    /* renamed from: a */
    public final void m20032a(pw pwVar) {
        this.f15932a.add(pwVar);
    }

    /* renamed from: b */
    public final void m20033b(pw pwVar) {
        this.f15932a.remove(pwVar);
    }

    public final Iterator<pw> iterator() {
        return this.f15932a.iterator();
    }
}
