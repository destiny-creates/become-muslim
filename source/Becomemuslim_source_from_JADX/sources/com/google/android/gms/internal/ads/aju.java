package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@cm
public final class aju implements akd {
    /* renamed from: a */
    private final Object f23669a = new Object();
    /* renamed from: b */
    private final WeakHashMap<is, ajv> f23670b = new WeakHashMap();
    /* renamed from: c */
    private final ArrayList<ajv> f23671c = new ArrayList();
    /* renamed from: d */
    private final Context f23672d;
    /* renamed from: e */
    private final mv f23673e;
    /* renamed from: f */
    private final bao f23674f;

    public aju(Context context, mv mvVar) {
        this.f23672d = context.getApplicationContext();
        this.f23673e = mvVar;
        this.f23674f = new bao(context.getApplicationContext(), mvVar, (String) aph.m18688f().m18889a(asp.f14936a));
    }

    /* renamed from: e */
    private final boolean m29986e(is isVar) {
        boolean z;
        synchronized (this.f23669a) {
            ajv ajv = (ajv) this.f23670b.get(isVar);
            z = ajv != null && ajv.m18540c();
        }
        return z;
    }

    /* renamed from: a */
    public final void mo3830a(ajv ajv) {
        synchronized (this.f23669a) {
            if (!ajv.m18540c()) {
                this.f23671c.remove(ajv);
                Iterator it = this.f23670b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == ajv) {
                        it.remove();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m29988a(aou aou, is isVar) {
        m29989a(aou, isVar, isVar.f15575b.getView());
    }

    /* renamed from: a */
    public final void m29989a(aou aou, is isVar, View view) {
        m29991a(aou, isVar, new akb(view, isVar), null);
    }

    /* renamed from: a */
    public final void m29990a(aou aou, is isVar, View view, qo qoVar) {
        m29991a(aou, isVar, new akb(view, isVar), qoVar);
    }

    /* renamed from: a */
    public final void m29991a(aou aou, is isVar, alh alh, qo qoVar) {
        synchronized (this.f23669a) {
            ajv ajv;
            if (m29986e(isVar)) {
                ajv = (ajv) this.f23670b.get(isVar);
            } else {
                ajv ajv2 = new ajv(this.f23672d, aou, isVar, this.f23673e, alh);
                ajv2.m18532a((akd) this);
                this.f23670b.put(isVar, ajv2);
                this.f23671c.add(ajv2);
                ajv = ajv2;
            }
            ajv.m18533a(qoVar != null ? new ake(ajv, qoVar) : new aki(ajv, this.f23674f, this.f23672d));
        }
    }

    /* renamed from: a */
    public final void m29992a(is isVar) {
        synchronized (this.f23669a) {
            ajv ajv = (ajv) this.f23670b.get(isVar);
            if (ajv != null) {
                ajv.m18536b();
            }
        }
    }

    /* renamed from: b */
    public final void m29993b(is isVar) {
        synchronized (this.f23669a) {
            ajv ajv = (ajv) this.f23670b.get(isVar);
            if (ajv != null) {
                ajv.m18541d();
            }
        }
    }

    /* renamed from: c */
    public final void m29994c(is isVar) {
        synchronized (this.f23669a) {
            ajv ajv = (ajv) this.f23670b.get(isVar);
            if (ajv != null) {
                ajv.m18542e();
            }
        }
    }

    /* renamed from: d */
    public final void m29995d(is isVar) {
        synchronized (this.f23669a) {
            ajv ajv = (ajv) this.f23670b.get(isVar);
            if (ajv != null) {
                ajv.m18543f();
            }
        }
    }
}
