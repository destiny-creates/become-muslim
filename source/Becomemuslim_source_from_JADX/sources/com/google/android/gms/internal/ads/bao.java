package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.ae;

@cm
public final class bao {
    /* renamed from: a */
    private final Object f15139a;
    /* renamed from: b */
    private final Context f15140b;
    /* renamed from: c */
    private final String f15141c;
    /* renamed from: d */
    private final mv f15142d;
    /* renamed from: e */
    private lb<bac> f15143e;
    /* renamed from: f */
    private lb<bac> f15144f;
    /* renamed from: g */
    private bbf f15145g;
    /* renamed from: h */
    private int f15146h;

    public bao(Context context, mv mvVar, String str) {
        this.f15139a = new Object();
        this.f15146h = 1;
        this.f15141c = str;
        this.f15140b = context.getApplicationContext();
        this.f15142d = mvVar;
        this.f15143e = new bba();
        this.f15144f = new bba();
    }

    public bao(Context context, mv mvVar, String str, lb<bac> lbVar, lb<bac> lbVar2) {
        this(context, mvVar, str);
        this.f15143e = lbVar;
        this.f15144f = lbVar2;
    }

    /* renamed from: a */
    protected final bbf m19204a(ahi ahi) {
        of bbf = new bbf(this.f15144f);
        nu.f15846a.execute(new bap(this, ahi, bbf));
        bbf.mo4320a(new bax(this, bbf), new bay(this, bbf));
        return bbf;
    }

    /* renamed from: a */
    final /* synthetic */ void m19205a(ahi ahi, bbf bbf) {
        try {
            Context context = this.f15140b;
            mv mvVar = this.f15142d;
            bac azn = ((Boolean) aph.m18688f().m18889a(asp.aA)).booleanValue() ? new azn(context, mvVar) : new bae(context, mvVar, ahi, null);
            azn.mo6647a(new baq(this, bbf, azn));
            azn.mo6655a("/jsLoaded", new bat(this, bbf, azn));
            ly lyVar = new ly();
            ae bau = new bau(this, ahi, azn, lyVar);
            lyVar.m19844a(bau);
            azn.mo6655a("/requestReload", bau);
            if (this.f15141c.endsWith(".js")) {
                azn.mo6648a(this.f15141c);
            } else if (this.f15141c.startsWith("<html>")) {
                azn.mo6653c(this.f15141c);
            } else {
                azn.mo6654d(this.f15141c);
            }
            jw.f15691a.postDelayed(new bav(this, bbf, azn), (long) baz.f15158a);
        } catch (Throwable th) {
            mt.m19919b("Error creating webview.", th);
            ax.i().m30834a(th, "SdkJavascriptFactory.loadJavascriptEngine");
            bbf.m30917a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final /* synthetic */ void m19206a(com.google.android.gms.internal.ads.bbf r4, com.google.android.gms.internal.ads.bac r5) {
        /*
        r3 = this;
        r0 = r3.f15139a;
        monitor-enter(r0);
        r1 = r4.m30920b();	 Catch:{ all -> 0x002a }
        r2 = -1;
        if (r1 == r2) goto L_0x0028;
    L_0x000a:
        r1 = r4.m30920b();	 Catch:{ all -> 0x002a }
        r2 = 1;
        if (r1 != r2) goto L_0x0012;
    L_0x0011:
        goto L_0x0028;
    L_0x0012:
        r4.m30917a();	 Catch:{ all -> 0x002a }
        r4 = com.google.android.gms.internal.ads.nu.f15846a;	 Catch:{ all -> 0x002a }
        r5.getClass();	 Catch:{ all -> 0x002a }
        r5 = com.google.android.gms.internal.ads.bas.m19208a(r5);	 Catch:{ all -> 0x002a }
        r4.execute(r5);	 Catch:{ all -> 0x002a }
        r4 = "Could not receive loaded message in a timely manner. Rejecting.";
        com.google.android.gms.internal.ads.jn.m30864a(r4);	 Catch:{ all -> 0x002a }
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return;
    L_0x0028:
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return;
    L_0x002a:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bao.a(com.google.android.gms.internal.ads.bbf, com.google.android.gms.internal.ads.bac):void");
    }

    /* renamed from: b */
    public final bbb m19207b(ahi ahi) {
        synchronized (this.f15139a) {
            bbb c;
            if (this.f15145g != null) {
                if (this.f15145g.m30920b() != -1) {
                    if (this.f15146h == 0) {
                        c = this.f15145g.m37257c();
                        return c;
                    } else if (this.f15146h == 1) {
                        this.f15146h = 2;
                        m19204a(null);
                        c = this.f15145g.m37257c();
                        return c;
                    } else if (this.f15146h == 2) {
                        c = this.f15145g.m37257c();
                        return c;
                    } else {
                        c = this.f15145g.m37257c();
                        return c;
                    }
                }
            }
            this.f15146h = 2;
            this.f15145g = m19204a(null);
            c = this.f15145g.m37257c();
            return c;
        }
    }
}
