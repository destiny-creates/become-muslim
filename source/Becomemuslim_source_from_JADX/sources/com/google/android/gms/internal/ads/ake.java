package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import org.json.JSONObject;

@cm
public final class ake implements akr {
    /* renamed from: a */
    private final ajv f23683a;
    /* renamed from: b */
    private final qo f23684b;
    /* renamed from: c */
    private final ae<qo> f23685c = new akf(this);
    /* renamed from: d */
    private final ae<qo> f23686d = new akg(this);
    /* renamed from: e */
    private final ae<qo> f23687e = new akh(this);

    public ake(ajv ajv, qo qoVar) {
        this.f23683a = ajv;
        this.f23684b = qoVar;
        qo qoVar2 = this.f23684b;
        qoVar2.mo6678a("/updateActiveView", this.f23685c);
        qoVar2.mo6678a("/untrackActiveViewUnit", this.f23686d);
        qoVar2.mo6678a("/visibilityChanged", this.f23687e);
        String str = "Custom JS tracking ad unit: ";
        String valueOf = String.valueOf(this.f23683a.f14613a.m18519d());
        mt.m19918b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: a */
    public final void mo3836a(JSONObject jSONObject, boolean z) {
        if (z) {
            this.f23683a.m18537b((akr) this);
        } else {
            this.f23684b.mo6652b("AFMA_updateActiveView", jSONObject);
        }
    }

    /* renamed from: a */
    public final boolean mo3837a() {
        return true;
    }

    /* renamed from: b */
    public final void mo3838b() {
        qo qoVar = this.f23684b;
        qoVar.mo6686b("/visibilityChanged", this.f23687e);
        qoVar.mo6686b("/untrackActiveViewUnit", this.f23686d);
        qoVar.mo6686b("/updateActiveView", this.f23685c);
    }
}
