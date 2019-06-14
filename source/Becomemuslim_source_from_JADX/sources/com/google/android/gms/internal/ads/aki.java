package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.C4268c;
import com.google.android.gms.ads.internal.gmsg.ae;
import org.json.JSONObject;

@cm
public final class aki implements akr {
    /* renamed from: a */
    private final ajv f23691a;
    /* renamed from: b */
    private final Context f23692b;
    /* renamed from: c */
    private final C4268c f23693c;
    /* renamed from: d */
    private bbb f23694d;
    /* renamed from: e */
    private boolean f23695e;
    /* renamed from: f */
    private final ae<bbl> f23696f = new akn(this);
    /* renamed from: g */
    private final ae<bbl> f23697g = new ako(this);
    /* renamed from: h */
    private final ae<bbl> f23698h = new akp(this);
    /* renamed from: i */
    private final ae<bbl> f23699i = new akq(this);

    public aki(ajv ajv, bao bao, Context context) {
        this.f23691a = ajv;
        this.f23692b = context;
        this.f23693c = new C4268c(this.f23692b);
        this.f23694d = bao.m19207b(null);
        this.f23694d.mo4320a(new akj(this), new akk(this));
        String str = "Core JS tracking ad unit: ";
        String valueOf = String.valueOf(this.f23691a.f14613a.m18519d());
        mt.m19918b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: a */
    final void m30019a(bbl bbl) {
        bbl.mo6655a("/updateActiveView", this.f23696f);
        bbl.mo6655a("/untrackActiveViewUnit", this.f23697g);
        bbl.mo6655a("/visibilityChanged", this.f23698h);
        if (ax.B().m19541a(this.f23692b)) {
            bbl.mo6655a("/logScionEvent", this.f23699i);
        }
    }

    /* renamed from: a */
    public final void mo3836a(JSONObject jSONObject, boolean z) {
        this.f23694d.mo4320a(new akl(this, jSONObject), new od());
    }

    /* renamed from: a */
    public final boolean mo3837a() {
        return this.f23695e;
    }

    /* renamed from: b */
    public final void mo3838b() {
        this.f23694d.mo4320a(new akm(this), new od());
        this.f23694d.m37254c();
    }

    /* renamed from: b */
    final void m30023b(bbl bbl) {
        bbl.mo6656b("/visibilityChanged", this.f23698h);
        bbl.mo6656b("/untrackActiveViewUnit", this.f23697g);
        bbl.mo6656b("/updateActiveView", this.f23696f);
        if (ax.B().m19541a(this.f23692b)) {
            bbl.mo6656b("/logScionEvent", this.f23699i);
        }
    }
}
