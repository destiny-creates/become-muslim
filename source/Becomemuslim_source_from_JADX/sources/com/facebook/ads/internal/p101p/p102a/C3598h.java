package com.facebook.ads.internal.p101p.p102a;

import android.os.AsyncTask;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.internal.p.a.h */
public class C3598h extends AsyncTask<C1448l, Void, C1450n> implements C1445c {
    /* renamed from: a */
    private static Executor f9602a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    /* renamed from: b */
    private C1443a f9603b;
    /* renamed from: c */
    private C1444b f9604c;
    /* renamed from: d */
    private Exception f9605d;

    public C3598h(C1443a c1443a, C1444b c1444b) {
        this.f9603b = c1443a;
        this.f9604c = c1444b;
    }

    /* renamed from: a */
    protected C1450n m11730a(C1448l... c1448lArr) {
        if (c1448lArr != null) {
            try {
                if (c1448lArr.length > 0) {
                    return this.f9603b.m5103a(c1448lArr[0]);
                }
            } catch (Exception e) {
                this.f9605d = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    /* renamed from: a */
    public void mo981a(C1448l c1448l) {
        super.executeOnExecutor(f9602a, new C1448l[]{c1448l});
    }

    /* renamed from: a */
    protected void m11732a(C1450n c1450n) {
        this.f9604c.mo966a(c1450n);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m11730a((C1448l[]) objArr);
    }

    protected void onCancelled() {
        this.f9604c.mo967a(this.f9605d);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m11732a((C1450n) obj);
    }
}
