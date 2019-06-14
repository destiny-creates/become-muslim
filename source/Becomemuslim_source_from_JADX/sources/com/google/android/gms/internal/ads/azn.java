package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.internal.ax;
import java.util.Map;
import org.json.JSONObject;

@cm
public final class azn extends baa<bbl> implements azw, bac {
    /* renamed from: a */
    private final sp f32206a;

    public azn(Context context, mv mvVar) {
        try {
            this.f32206a = new sp(new sb(context));
            this.f32206a.setWillNotDraw(true);
            this.f32206a.m31091a(new azo(this));
            this.f32206a.m31092a(new azp(this));
            this.f32206a.addJavascriptInterface(new azv(this), "GoogleJsInterface");
            ax.e().m19738a(context, mvVar.f28709a, this.f32206a.getSettings());
        } catch (Throwable th) {
            qz qzVar = new qz("Init failed.", th);
        }
    }

    /* renamed from: a */
    public final void mo6646a() {
        this.f32206a.destroy();
    }

    /* renamed from: a */
    public final void mo6647a(bad bad) {
        this.f32206a.m31093a(new azs(bad));
    }

    /* renamed from: a */
    public final void mo6648a(String str) {
        mo6653c(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[]{str}));
    }

    /* renamed from: a */
    public final void mo6649a(String str, String str2) {
        azx.m19177a((azw) this, str, str2);
    }

    /* renamed from: a */
    public final void mo6650a(String str, Map map) {
        azx.m19178a((azw) this, str, map);
    }

    /* renamed from: a */
    public final void mo4089a(String str, JSONObject jSONObject) {
        azx.m19180b(this, str, jSONObject);
    }

    /* renamed from: b */
    public final bbm mo6651b() {
        return new bbn(this);
    }

    /* renamed from: b */
    public final void mo4090b(String str) {
        nu.f15846a.execute(new azt(this, str));
    }

    /* renamed from: b */
    public final void mo6652b(String str, JSONObject jSONObject) {
        azx.m19179a((azw) this, str, jSONObject);
    }

    /* renamed from: c */
    public final void mo6653c(String str) {
        nu.f15846a.execute(new azq(this, str));
    }

    /* renamed from: d */
    public final void mo6654d(String str) {
        nu.f15846a.execute(new azr(this, str));
    }

    /* renamed from: e */
    final /* synthetic */ void m42208e(String str) {
        this.f32206a.mo4090b(str);
    }

    /* renamed from: f */
    final /* synthetic */ void m42209f(String str) {
        this.f32206a.loadUrl(str);
    }

    /* renamed from: g */
    final /* synthetic */ void m42210g(String str) {
        this.f32206a.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME);
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ Object mo4357o() {
        return this;
    }
}
