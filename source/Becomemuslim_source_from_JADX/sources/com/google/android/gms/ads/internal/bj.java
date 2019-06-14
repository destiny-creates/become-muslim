package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.ao;
import com.google.android.gms.internal.ads.atc;
import com.google.android.gms.internal.ads.atd;
import com.google.android.gms.internal.ads.atg;
import com.google.android.gms.internal.ads.id;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.qo;

final class bj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ it f6825a;
    /* renamed from: b */
    final /* synthetic */ id f6826b;
    /* renamed from: c */
    final /* synthetic */ bg f6827c;
    /* renamed from: d */
    private final /* synthetic */ atc f6828d;

    bj(bg bgVar, it itVar, id idVar, atc atc) {
        this.f6827c = bgVar;
        this.f6825a = itVar;
        this.f6826b = idVar;
        this.f6828d = atc;
    }

    public final void run() {
        if (this.f6825a.f15601b.f28613r && this.f6827c.e.f6774B != null) {
            String str = null;
            if (this.f6825a.f15601b.f28596a != null) {
                ax.m7464e();
                str = jw.a(this.f6825a.f15601b.f28596a);
            }
            atg atd = new atd(this.f6827c, str, this.f6825a.f15601b.f28597b);
            this.f6827c.e.f6781I = 1;
            try {
                this.f6827c.c = false;
                this.f6827c.e.f6774B.a(atd);
                return;
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
                this.f6827c.c = true;
            }
        }
        bv bvVar = new bv(this.f6827c.e.f6792c, this.f6826b, this.f6825a.f15601b.f28576E);
        try {
            qo a = this.f6827c.mo3586a(this.f6825a, bvVar, this.f6826b);
            a.setOnTouchListener(new bl(this, bvVar));
            a.setOnClickListener(new bm(this, bvVar));
            this.f6827c.e.f6781I = 0;
            ay ayVar = this.f6827c.e;
            ax.m7463d();
            ayVar.f6797h = ao.a(this.f6827c.e.f6792c, this.f6827c, this.f6825a, this.f6827c.e.f6793d, a, this.f6827c.j, this.f6827c, this.f6828d);
        } catch (Throwable e2) {
            jn.b("Could not obtain webview.", e2);
            jw.f15691a.post(new bk(this));
        }
    }
}
