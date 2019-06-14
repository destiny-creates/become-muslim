package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;
import org.json.JSONObject;

@cm
public final class bae implements azw, bac {
    /* renamed from: a */
    private final qo f32207a;
    /* renamed from: b */
    private final Context f32208b;

    public bae(Context context, mv mvVar, ahi ahi, bu buVar) {
        this.f32208b = context;
        ax.f();
        this.f32207a = qv.m20039a(context, sc.m20088a(), "", false, false, ahi, mvVar, null, null, null, amx.m18642a());
        this.f32207a.getView().setWillNotDraw(true);
    }

    /* renamed from: a */
    private static void m42213a(Runnable runnable) {
        aph.m18683a();
        if (mi.m19877b()) {
            runnable.run();
        } else {
            jw.f15691a.post(runnable);
        }
    }

    /* renamed from: a */
    public final void mo6646a() {
        this.f32207a.destroy();
    }

    /* renamed from: a */
    public final void mo6647a(bad bad) {
        rw v = this.f32207a.mo6718v();
        bad.getClass();
        v.mo4344a(bah.m30411a(bad));
    }

    /* renamed from: a */
    public final void mo6648a(String str) {
        m42213a(new baj(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    /* renamed from: a */
    public final void mo6655a(String str, ae<? super bbl> aeVar) {
        this.f32207a.mo6678a(str, new bam(this, aeVar));
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
        m42213a(new baf(this, str));
    }

    /* renamed from: b */
    public final void mo6656b(String str, ae<? super bbl> aeVar) {
        this.f32207a.mo6679a(str, new bag(aeVar));
    }

    /* renamed from: b */
    public final void mo6652b(String str, JSONObject jSONObject) {
        azx.m19179a((azw) this, str, jSONObject);
    }

    /* renamed from: c */
    public final void mo6653c(String str) {
        m42213a(new bak(this, str));
    }

    /* renamed from: d */
    public final void mo6654d(String str) {
        m42213a(new bal(this, str));
    }

    /* renamed from: e */
    final /* synthetic */ void m42227e(String str) {
        this.f32207a.mo4090b(str);
    }
}
