package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.Map;

@cm
public final class lg {
    /* renamed from: a */
    private static bai f15761a;
    /* renamed from: b */
    private static final Object f15762b = new Object();
    @Deprecated
    /* renamed from: c */
    private static final lm<Void> f15763c = new lh();

    public lg(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        m19830a(context);
    }

    /* renamed from: a */
    private static bai m19830a(Context context) {
        bai a;
        synchronized (f15762b) {
            if (f15761a == null) {
                asp.m18892a(context);
                if (((Boolean) aph.m18688f().m18889a(asp.cI)).booleanValue()) {
                    a = la.m37558a(context);
                } else {
                    a = new bai(new ln(new File(context.getCacheDir(), "volley")), new ik(new rt()));
                    a.m19194a();
                }
                f15761a = a;
            }
            a = f15761a;
        }
        return a;
    }

    /* renamed from: a */
    public final no<String> m19831a(int i, String str, Map<String, String> map, byte[] bArr) {
        String str2 = str;
        no loVar = new lo();
        lg lgVar = this;
        bdl lkVar = new lk(this, str2, loVar);
        mm mmVar = new mm(null);
        awi llVar = new ll(this, i, str, loVar, lkVar, bArr, map, mmVar);
        if (mm.m19905c()) {
            try {
                mmVar.m19907a(str2, "GET", llVar.mo6109b(), llVar.mo6108a());
            } catch (Throwable e) {
                mt.m19924e(e.getMessage());
            }
        }
        f15761a.m19193a(llVar);
        return loVar;
    }

    @Deprecated
    /* renamed from: a */
    public final <T> no<T> m19832a(String str, lm<T> lmVar) {
        no nzVar = new nz();
        f15761a.m19193a(new lp(str, nzVar));
        return nd.m19942a(nd.m19941a(nzVar, new lj(this, lmVar), ju.f15687a), Throwable.class, new li(this, lmVar), nu.f15847b);
    }

    /* renamed from: a */
    public final no<String> m19833a(String str, Map<String, String> map) {
        return m19831a(0, str, map, null);
    }
}
