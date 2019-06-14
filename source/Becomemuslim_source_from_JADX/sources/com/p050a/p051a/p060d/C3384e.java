package com.p050a.p051a.p060d;

import android.os.AsyncTask;
import android.util.JsonReader;
import com.p050a.p051a.C0888a;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.C0954f.C0949a;
import com.p050a.p051a.C0960j;

/* compiled from: AsyncCompositionLoader */
/* renamed from: com.a.a.d.e */
public final class C3384e extends AsyncTask<JsonReader, Void, C0954f> implements C0888a {
    /* renamed from: a */
    private final C0960j f9016a;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m10775a((JsonReader[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m10777a((C0954f) obj);
    }

    public C3384e(C0960j c0960j) {
        this.f9016a = c0960j;
    }

    /* renamed from: a */
    protected C0954f m10775a(JsonReader... jsonReaderArr) {
        try {
            return C0949a.m3324a(jsonReaderArr[0]);
        } catch (JsonReader[] jsonReaderArr2) {
            throw new IllegalStateException(jsonReaderArr2);
        }
    }

    /* renamed from: a */
    protected void m10777a(C0954f c0954f) {
        this.f9016a.mo741a(c0954f);
    }

    /* renamed from: a */
    public void mo740a() {
        cancel(true);
    }
}
