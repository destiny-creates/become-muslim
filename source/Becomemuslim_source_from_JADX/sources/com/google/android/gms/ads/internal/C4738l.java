package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.C0463l;
import android.text.TextUtils;
import com.google.android.gms.ads.p168b.C4735l;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.apn;
import com.google.android.gms.internal.ads.apq;
import com.google.android.gms.internal.ads.apu;
import com.google.android.gms.internal.ads.aqn;
import com.google.android.gms.internal.ads.aus;
import com.google.android.gms.internal.ads.awe;
import com.google.android.gms.internal.ads.awh;
import com.google.android.gms.internal.ads.awl;
import com.google.android.gms.internal.ads.awo;
import com.google.android.gms.internal.ads.awr;
import com.google.android.gms.internal.ads.awu;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.mv;

@cm
/* renamed from: com.google.android.gms.ads.internal.l */
public final class C4738l extends apu {
    /* renamed from: a */
    private apn f13005a;
    /* renamed from: b */
    private awe f13006b;
    /* renamed from: c */
    private awu f13007c;
    /* renamed from: d */
    private awh f13008d;
    /* renamed from: e */
    private C0463l<String, awl> f13009e = new C0463l();
    /* renamed from: f */
    private C0463l<String, awo> f13010f = new C0463l();
    /* renamed from: g */
    private awr f13011g;
    /* renamed from: h */
    private aou f13012h;
    /* renamed from: i */
    private C4735l f13013i;
    /* renamed from: j */
    private aus f13014j;
    /* renamed from: k */
    private aqn f13015k;
    /* renamed from: l */
    private final Context f13016l;
    /* renamed from: m */
    private final bcy f13017m;
    /* renamed from: n */
    private final String f13018n;
    /* renamed from: o */
    private final mv f13019o;
    /* renamed from: p */
    private final bu f13020p;

    public C4738l(Context context, String str, bcy bcy, mv mvVar, bu buVar) {
        this.f13016l = context;
        this.f13018n = str;
        this.f13017m = bcy;
        this.f13019o = mvVar;
        this.f13020p = buVar;
    }

    /* renamed from: a */
    public final apq m16543a() {
        return new C4737i(this.f13016l, this.f13018n, this.f13017m, this.f13019o, this.f13005a, this.f13006b, this.f13007c, this.f13008d, this.f13010f, this.f13009e, this.f13014j, this.f13015k, this.f13020p, this.f13011g, this.f13012h, this.f13013i);
    }

    /* renamed from: a */
    public final void m16544a(C4735l c4735l) {
        this.f13013i = c4735l;
    }

    /* renamed from: a */
    public final void m16545a(apn apn) {
        this.f13005a = apn;
    }

    /* renamed from: a */
    public final void m16546a(aqn aqn) {
        this.f13015k = aqn;
    }

    /* renamed from: a */
    public final void m16547a(aus aus) {
        this.f13014j = aus;
    }

    /* renamed from: a */
    public final void m16548a(awe awe) {
        this.f13006b = awe;
    }

    /* renamed from: a */
    public final void m16549a(awh awh) {
        this.f13008d = awh;
    }

    /* renamed from: a */
    public final void m16550a(awr awr, aou aou) {
        this.f13011g = awr;
        this.f13012h = aou;
    }

    /* renamed from: a */
    public final void m16551a(awu awu) {
        this.f13007c = awu;
    }

    /* renamed from: a */
    public final void m16552a(String str, awo awo, awl awl) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f13010f.put(str, awo);
        this.f13009e.put(str, awl);
    }
}
