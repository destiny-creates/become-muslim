package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import java.util.concurrent.Callable;

final class fl implements Callable<fi> {
    /* renamed from: a */
    private final /* synthetic */ Context f15494a;
    /* renamed from: b */
    private final /* synthetic */ fk f15495b;

    fl(fk fkVar, Context context) {
        this.f15495b = fkVar;
        this.f15494a = context;
    }

    public final /* synthetic */ Object call() {
        fi a;
        fm fmVar = (fm) this.f15495b.f15493a.get(this.f15494a);
        if (fmVar != null) {
            if ((fmVar.f15496a + ((Long) aph.m18688f().m18889a(asp.bq)).longValue() < ax.l().a() ? 1 : null) == null) {
                if (((Boolean) aph.m18688f().m18889a(asp.bp)).booleanValue()) {
                    a = new fj(this.f15494a, fmVar.f15497b).m19435a();
                    this.f15495b.f15493a.put(this.f15494a, new fm(this.f15495b, a));
                    return a;
                }
            }
        }
        a = new fj(this.f15494a).m19435a();
        this.f15495b.f15493a.put(this.f15494a, new fm(this.f15495b, a));
        return a;
    }
}
