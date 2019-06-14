package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ae;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bv;
import com.google.android.gms.ads.internal.gmsg.C4268c;
import org.json.JSONObject;

@cm
public final class bu implements bq<qo> {
    /* renamed from: a */
    private no<qo> f24001a;
    /* renamed from: b */
    private final C4268c f24002b = new C4268c(this.f24004d);
    /* renamed from: c */
    private final aul f24003c;
    /* renamed from: d */
    private final Context f24004d;
    /* renamed from: e */
    private final mv f24005e;
    /* renamed from: f */
    private final ae f24006f;
    /* renamed from: g */
    private final ahi f24007g;
    /* renamed from: h */
    private String f24008h;

    public bu(Context context, ae aeVar, String str, ahi ahi, mv mvVar) {
        mt.m19922d("Webview loading for native ads.");
        this.f24004d = context;
        this.f24006f = aeVar;
        this.f24007g = ahi;
        this.f24005e = mvVar;
        this.f24008h = str;
        ax.f();
        no a = qv.m20038a(this.f24004d, this.f24005e, (String) aph.m18688f().m18889a(asp.bX), this.f24007g, this.f24006f.h());
        this.f24003c = new aul(aeVar, str);
        this.f24001a = nd.m19940a(a, new bv(this), nu.f15847b);
        nb.m19936a(this.f24001a, "WebViewNativeAdsUtil.constructor");
    }

    /* renamed from: a */
    final /* synthetic */ no m30646a(qo qoVar) {
        mt.m19922d("Javascript has loaded for native ads.");
        qoVar.mo6718v().mo4342a(this.f24006f, this.f24006f, this.f24006f, this.f24006f, this.f24006f, false, null, new bv(this.f24004d, null, null), null, null);
        qoVar.mo6678a("/logScionEvent", this.f24002b);
        qoVar.mo6678a("/logScionEvent", this.f24003c);
        return nd.m19938a((Object) qoVar);
    }

    /* renamed from: a */
    public final no<JSONObject> mo4220a(JSONObject jSONObject) {
        return nd.m19940a(this.f24001a, new bw(this, jSONObject), nu.f15846a);
    }

    /* renamed from: a */
    final /* synthetic */ no m30648a(JSONObject jSONObject, qo qoVar) {
        jSONObject.put("ads_id", this.f24008h);
        qoVar.mo6652b("google.afma.nativeAds.handleDownloadedImpressionPing", jSONObject);
        return nd.m19938a(new JSONObject());
    }

    /* renamed from: a */
    public final void mo4221a() {
        nd.m19945a(this.f24001a, new cf(this), nu.f15846a);
    }

    /* renamed from: a */
    public final void mo4222a(String str, com.google.android.gms.ads.internal.gmsg.ae<? super qo> aeVar) {
        nd.m19945a(this.f24001a, new cb(this, str, aeVar), nu.f15846a);
    }

    /* renamed from: a */
    public final void mo4223a(String str, JSONObject jSONObject) {
        nd.m19945a(this.f24001a, new cd(this, str, jSONObject), nu.f15846a);
    }

    /* renamed from: b */
    public final no<JSONObject> mo4224b(JSONObject jSONObject) {
        return nd.m19940a(this.f24001a, new bx(this, jSONObject), nu.f15846a);
    }

    /* renamed from: b */
    final /* synthetic */ no m30653b(JSONObject jSONObject, qo qoVar) {
        jSONObject.put("ads_id", this.f24008h);
        qoVar.mo6652b("google.afma.nativeAds.handleImpressionPing", jSONObject);
        return nd.m19938a(new JSONObject());
    }

    /* renamed from: b */
    public final void mo4225b(String str, com.google.android.gms.ads.internal.gmsg.ae<? super qo> aeVar) {
        nd.m19945a(this.f24001a, new cc(this, str, aeVar), nu.f15846a);
    }

    /* renamed from: c */
    public final no<JSONObject> mo4226c(JSONObject jSONObject) {
        return nd.m19940a(this.f24001a, new by(this, jSONObject), nu.f15846a);
    }

    /* renamed from: c */
    final /* synthetic */ no m30656c(JSONObject jSONObject, qo qoVar) {
        jSONObject.put("ads_id", this.f24008h);
        qoVar.mo6652b("google.afma.nativeAds.handleClickGmsg", jSONObject);
        return nd.m19938a(new JSONObject());
    }

    /* renamed from: d */
    public final no<JSONObject> mo4227d(JSONObject jSONObject) {
        return nd.m19940a(this.f24001a, new bz(this, jSONObject), nu.f15846a);
    }

    /* renamed from: d */
    final /* synthetic */ no m30658d(JSONObject jSONObject, qo qoVar) {
        jSONObject.put("ads_id", this.f24008h);
        no nzVar = new nz();
        qoVar.mo6678a("/nativeAdPreProcess", new ca(this, qoVar, nzVar));
        qoVar.mo6652b("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        return nzVar;
    }
}
