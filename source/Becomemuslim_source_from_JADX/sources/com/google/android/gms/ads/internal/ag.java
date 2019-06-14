package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.atc;
import com.google.android.gms.internal.ads.aui;
import com.google.android.gms.internal.ads.dl;
import com.google.android.gms.internal.ads.dm;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.nd;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

final class ag implements Callable<aui> {
    /* renamed from: a */
    private final /* synthetic */ int f6700a;
    /* renamed from: b */
    private final /* synthetic */ JSONArray f6701b;
    /* renamed from: c */
    private final /* synthetic */ int f6702c;
    /* renamed from: d */
    private final /* synthetic */ it f6703d;
    /* renamed from: e */
    private final /* synthetic */ ae f6704e;

    ag(ae aeVar, int i, JSONArray jSONArray, int i2, it itVar) {
        this.f6704e = aeVar;
        this.f6700a = i;
        this.f6701b = jSONArray;
        this.f6702c = i2;
        this.f6703d = itVar;
    }

    public final /* synthetic */ Object call() {
        if (this.f6700a >= this.f6701b.length()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(r0.f6701b.get(r0.f6700a));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ads", jSONArray);
        C4736a aeVar = new ae(r0.f6704e.e.f6792c, r0.f6704e.i, r0.f6704e.e.f6798i, r0.f6704e.e.f6791b, r0.f6704e.j, r0.f6704e.e.f6794e, true);
        ae.m17637a(r0.f6704e.e, aeVar.e);
        aeVar.p_();
        aeVar.m16438a(r0.f6704e.b);
        atc atc = aeVar.f12965a;
        int i = r0.f6700a;
        atc.a("num_ads_requested", String.valueOf(r0.f6702c));
        atc.a("ad_index", String.valueOf(i));
        dl dlVar = r0.f6703d.f15600a;
        String jSONObject2 = jSONObject.toString();
        Bundle bundle = dlVar.f28547c.f28263c != null ? new Bundle(dlVar.f28547c.f28263c) : new Bundle();
        bundle.putString("_ad", jSONObject2);
        aoq aoq = r5;
        aoq aoq2 = new aoq(dlVar.f28547c.f28261a, dlVar.f28547c.f28262b, bundle, dlVar.f28547c.f28264d, dlVar.f28547c.f28265e, dlVar.f28547c.f28266f, dlVar.f28547c.f28267g, dlVar.f28547c.f28268h, dlVar.f28547c.f28269i, dlVar.f28547c.f28270j, dlVar.f28547c.f28271k, dlVar.f28547c.f28272l, dlVar.f28547c.f28273m, dlVar.f28547c.f28274n, dlVar.f28547c.f28275o, dlVar.f28547c.f28276p, dlVar.f28547c.f28277q, dlVar.f28547c.f28278r);
        aeVar.m17430a(new dm(dlVar.f28546b, aoq, dlVar.f28548d, dlVar.f28549e, dlVar.f28550f, dlVar.f28551g, dlVar.f28553i, dlVar.f28554j, dlVar.f28555k, dlVar.f28556l, dlVar.f28558n, dlVar.f28570z, dlVar.f28559o, dlVar.f28560p, dlVar.f28561q, dlVar.f28562r, dlVar.f28563s, dlVar.f28564t, dlVar.f28565u, dlVar.f28566v, dlVar.f28567w, dlVar.f28568x, dlVar.f28569y, dlVar.f28520B, dlVar.f28521C, dlVar.f28527I, dlVar.f28522D, dlVar.f28523E, dlVar.f28524F, dlVar.f28525G, nd.a(dlVar.f28526H), dlVar.f28528J, dlVar.f28529K, dlVar.f28530L, dlVar.f28531M, dlVar.f28532N, dlVar.f28533O, dlVar.f28534P, dlVar.f28535Q, dlVar.f28539U, nd.a(dlVar.f28552h), dlVar.f28540V, dlVar.f28541W, dlVar.f28542X, 1, dlVar.f28544Z, dlVar.aa, dlVar.ab, dlVar.ac), aeVar.f12965a);
        return (aui) aeVar.m17645J().get();
    }
}
