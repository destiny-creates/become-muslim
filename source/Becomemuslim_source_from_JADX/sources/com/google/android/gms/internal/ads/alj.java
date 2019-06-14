package com.google.android.gms.internal.ads;

import android.support.v7.widget.LinearLayoutManager;
import com.google.android.gms.ads.internal.ax;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@cm
public final class alj {
    /* renamed from: a */
    private final Object f14690a = new Object();
    /* renamed from: b */
    private int f14691b;
    /* renamed from: c */
    private List<ali> f14692c = new LinkedList();

    /* renamed from: a */
    public final ali m18580a() {
        synchronized (this.f14690a) {
            ali ali = null;
            if (this.f14692c.size() == 0) {
                mt.m19918b("Queue empty");
                return null;
            }
            int i = 0;
            if (this.f14692c.size() >= 2) {
                int i2 = LinearLayoutManager.INVALID_OFFSET;
                int i3 = 0;
                for (ali ali2 : this.f14692c) {
                    int i4 = ali2.m18578i();
                    if (i4 > i2) {
                        i = i3;
                        ali = ali2;
                        i2 = i4;
                    }
                    i3++;
                }
                this.f14692c.remove(i);
                return ali;
            }
            ali ali3 = (ali) this.f14692c.get(0);
            ali3.m18574e();
            return ali3;
        }
    }

    /* renamed from: a */
    public final boolean m18581a(ali ali) {
        synchronized (this.f14690a) {
            if (this.f14692c.contains(ali)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: b */
    public final boolean m18582b(ali ali) {
        synchronized (this.f14690a) {
            Iterator it = this.f14692c.iterator();
            while (it.hasNext()) {
                ali ali2 = (ali) it.next();
                if (!((Boolean) aph.m18688f().m18889a(asp.f14932W)).booleanValue() || ax.i().m30847l().m19659b()) {
                    if (((Boolean) aph.m18688f().m18889a(asp.f14934Y)).booleanValue() && !ax.i().m30847l().m19665d() && ali != ali2 && ali2.m18573d().equals(ali.m18573d())) {
                        it.remove();
                        return true;
                    }
                } else if (ali != ali2 && ali2.m18570b().equals(ali.m18570b())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: c */
    public final void m18583c(ali ali) {
        synchronized (this.f14690a) {
            int size;
            if (this.f14692c.size() >= 10) {
                size = this.f14692c.size();
                StringBuilder stringBuilder = new StringBuilder(41);
                stringBuilder.append("Queue is full, current size = ");
                stringBuilder.append(size);
                mt.m19918b(stringBuilder.toString());
                this.f14692c.remove(0);
            }
            size = this.f14691b;
            this.f14691b = size + 1;
            ali.m18567a(size);
            this.f14692c.add(ali);
        }
    }
}
