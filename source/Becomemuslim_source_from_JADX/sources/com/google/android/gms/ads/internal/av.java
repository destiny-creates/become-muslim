package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.ahi;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.mt;
import java.util.concurrent.TimeUnit;

final class av extends AsyncTask<Void, Void, String> {
    /* renamed from: a */
    private final /* synthetic */ ar f6732a;

    private av(ar arVar) {
        this.f6732a = arVar;
    }

    /* renamed from: a */
    private final String m7448a(Void... voidArr) {
        try {
            this.f6732a.f12984h = (ahi) this.f6732a.f12979c.get(((Long) aph.f().a(asp.cz)).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            mt.c("", e);
        }
        return this.f6732a.m16513c();
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m7448a((Void[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.f6732a.f12982f != null && str != null) {
            this.f6732a.f12982f.loadUrl(str);
        }
    }
}
