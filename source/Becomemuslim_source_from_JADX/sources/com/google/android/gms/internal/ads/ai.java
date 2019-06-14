package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.atomic.AtomicBoolean;

@cm
public abstract class ai implements kp<Void>, rx {
    /* renamed from: a */
    protected final Context f23624a;
    /* renamed from: b */
    protected final qo f23625b;
    /* renamed from: c */
    protected dp f23626c;
    /* renamed from: d */
    private final ap f23627d;
    /* renamed from: e */
    private final it f23628e;
    /* renamed from: f */
    private Runnable f23629f;
    /* renamed from: g */
    private final Object f23630g = new Object();
    /* renamed from: h */
    private AtomicBoolean f23631h = new AtomicBoolean(true);

    protected ai(Context context, it itVar, qo qoVar, ap apVar) {
        this.f23624a = context;
        this.f23628e = itVar;
        this.f23626c = this.f23628e.f15601b;
        this.f23625b = qoVar;
        this.f23627d = apVar;
    }

    /* renamed from: a */
    protected abstract void mo6081a();

    /* renamed from: a */
    protected void mo6642a(int i) {
        ai aiVar = this;
        int i2 = i;
        if (i2 != -2) {
            aiVar.f23626c = new dp(i2, aiVar.f23626c.f28605j);
        }
        aiVar.f23625b.mo6707p();
        ap apVar = aiVar.f23627d;
        dl dlVar = aiVar.f23628e.f15600a;
        is isVar = r1;
        bci bci = null;
        ap apVar2 = apVar;
        bci bci2 = null;
        is isVar2 = new is(dlVar.f28547c, aiVar.f23625b, aiVar.f23626c.f28598c, i, aiVar.f23626c.f28600e, aiVar.f23626c.f28604i, aiVar.f23626c.f28606k, aiVar.f23626c.f28605j, dlVar.f28553i, aiVar.f23626c.f28602g, null, null, null, null, null, aiVar.f23626c.f28603h, aiVar.f23628e.f15603d, aiVar.f23626c.f28601f, aiVar.f23628e.f15605f, aiVar.f23626c.f28608m, aiVar.f23626c.f28609n, aiVar.f23628e.f15607h, null, aiVar.f23626c.f28572A, aiVar.f23626c.f28573B, aiVar.f23626c.f28574C, aiVar.f23626c.f28575D, aiVar.f23626c.f28576E, null, aiVar.f23626c.f28579H, aiVar.f23626c.f28583L, aiVar.f23628e.f15608i, aiVar.f23628e.f15601b.f28586O, aiVar.f23628e.f15609j, aiVar.f23628e.f15601b.f28588Q, aiVar.f23626c.f28589R, aiVar.f23628e.f15601b.f28590S, aiVar.f23628e.f15601b.f28591T);
        apVar2.m18682b(isVar);
    }

    /* renamed from: a */
    public final void mo3817a(boolean z) {
        mt.m19918b("WebView finished loading.");
        int i = 0;
        if (this.f23631h.getAndSet(false)) {
            if (z) {
                i = -2;
            }
            mo6642a(i);
            jw.f15691a.removeCallbacks(this.f23629f);
        }
    }

    /* renamed from: b */
    public void mo3818b() {
        if (this.f23631h.getAndSet(false)) {
            this.f23625b.stopLoading();
            ax.g();
            kc.m19752a(this.f23625b);
            mo6642a(-1);
            jw.f15691a.removeCallbacks(this.f23629f);
        }
    }

    /* renamed from: c */
    public final /* synthetic */ Object mo3819c() {
        C2872v.b("Webview render task needs to be called on UI thread.");
        this.f23629f = new aj(this);
        jw.f15691a.postDelayed(this.f23629f, ((Long) aph.m18688f().m18889a(asp.bB)).longValue());
        mo6081a();
        return null;
    }
}
