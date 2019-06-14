package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@cm
public final class jg implements aln {
    /* renamed from: a */
    private final Object f24133a;
    /* renamed from: b */
    private final jc f24134b;
    /* renamed from: c */
    private final HashSet<iu> f24135c;
    /* renamed from: d */
    private final HashSet<jf> f24136d;

    public jg() {
        this(aph.m18685c());
    }

    private jg(String str) {
        this.f24133a = new Object();
        this.f24135c = new HashSet();
        this.f24136d = new HashSet();
        this.f24134b = new jc(str);
    }

    /* renamed from: a */
    public final Bundle m30851a(Context context, jd jdVar, String str) {
        Bundle bundle;
        synchronized (this.f24133a) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f24134b.m19593a(context, str));
            Bundle bundle2 = new Bundle();
            Iterator it = this.f24136d.iterator();
            while (it.hasNext()) {
                jf jfVar = (jf) it.next();
                bundle2.putBundle(jfVar.m19599a(), jfVar.m19601b());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            it = this.f24135c.iterator();
            while (it.hasNext()) {
                arrayList.add(((iu) it.next()).m19575d());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            jdVar.m19597a(this.f24135c);
            this.f24135c.clear();
        }
        return bundle;
    }

    /* renamed from: a */
    public final void m30852a() {
        synchronized (this.f24133a) {
            this.f24134b.m19594a();
        }
    }

    /* renamed from: a */
    public final void m30853a(aoq aoq, long j) {
        synchronized (this.f24133a) {
            this.f24134b.m19595a(aoq, j);
        }
    }

    /* renamed from: a */
    public final void m30854a(iu iuVar) {
        synchronized (this.f24133a) {
            this.f24135c.add(iuVar);
        }
    }

    /* renamed from: a */
    public final void m30855a(jf jfVar) {
        synchronized (this.f24133a) {
            this.f24136d.add(jfVar);
        }
    }

    /* renamed from: a */
    public final void m30856a(HashSet<iu> hashSet) {
        synchronized (this.f24133a) {
            this.f24135c.addAll(hashSet);
        }
    }

    /* renamed from: a */
    public final void mo3846a(boolean z) {
        long a = ax.l().a();
        if (z) {
            if (a - ax.i().m30847l().m19672i() > ((Long) aph.m18688f().m18889a(asp.aI)).longValue()) {
                this.f24134b.f15644a = -1;
                return;
            }
            this.f24134b.f15644a = ax.i().m30847l().m19673j();
            return;
        }
        ax.i().m30847l().m19648a(a);
        ax.i().m30847l().m19655b(this.f24134b.f15644a);
    }

    /* renamed from: b */
    public final void m30858b() {
        synchronized (this.f24133a) {
            this.f24134b.m19596b();
        }
    }
}
