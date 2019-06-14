package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.C2653o;
import org.json.JSONObject;

@cm
public final class bca<I, O> implements bbp<I, O> {
    /* renamed from: a */
    private final bbr<O> f28468a;
    /* renamed from: b */
    private final bbs<I> f28469b;
    /* renamed from: c */
    private final bao f28470c;
    /* renamed from: d */
    private final String f28471d;

    bca(bao bao, String str, bbs<I> bbs, bbr<O> bbr) {
        this.f28470c = bao;
        this.f28471d = str;
        this.f28469b = bbs;
        this.f28468a = bbr;
    }

    /* renamed from: a */
    private final void m37262a(bbb bbb, bbl bbl, I i, nz<O> nzVar) {
        try {
            ax.e();
            String a = jw.m19688a();
            C2653o.f6891o.a(a, new bcd(this, bbb, nzVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", a);
            jSONObject.put("args", this.f28469b.mo4095a(i));
            bbl.mo6652b(this.f28471d, jSONObject);
        } catch (Throwable e) {
            nzVar.m30914a(e);
            mt.m19919b("Unable to invokeJavaScript", e);
        } finally {
            bbb.m37254c();
        }
    }

    /* renamed from: a */
    public final no<O> mo4228a(I i) {
        return mo6092b(i);
    }

    /* renamed from: b */
    public final no<O> mo6092b(I i) {
        no nzVar = new nz();
        of b = this.f28470c.m19207b(null);
        b.mo4320a(new bcb(this, b, i, nzVar), new bcc(this, nzVar, b));
        return nzVar;
    }
}
