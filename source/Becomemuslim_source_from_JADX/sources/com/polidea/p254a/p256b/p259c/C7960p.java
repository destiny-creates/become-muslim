package com.polidea.p254a.p256b.p259c;

import android.os.DeadObjectException;
import com.polidea.p254a.p255a.C5548g;
import com.polidea.p254a.p255a.C6975n;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.C7084k;
import com.polidea.p254a.p256b.p261e.C5598i;
import com.polidea.p254a.p256b.p262f.C5610w;
import p289e.C7332c;
import p289e.p291b.C5917e;

/* compiled from: ScanOperation */
/* renamed from: com.polidea.a.b.c.p */
public abstract class C7960p<SCAN_RESULT_TYPE, SCAN_CALLBACK_TYPE> extends C7084k<SCAN_RESULT_TYPE> {
    /* renamed from: a */
    private final C5610w f29668a;

    /* renamed from: a */
    abstract SCAN_CALLBACK_TYPE mo6757a(C7332c<SCAN_RESULT_TYPE> c7332c);

    /* renamed from: a */
    abstract boolean mo6758a(C5610w c5610w, SCAN_CALLBACK_TYPE scan_callback_type);

    /* renamed from: b */
    abstract void mo6759b(C5610w c5610w, SCAN_CALLBACK_TYPE scan_callback_type);

    C7960p(C5610w c5610w) {
        this.f29668a = c5610w;
    }

    /* renamed from: a */
    protected final void mo6272a(C7332c<SCAN_RESULT_TYPE> c7332c, C5598i c5598i) {
        final Object a = mo6757a((C7332c) c7332c);
        try {
            c7332c.mo6330a(new C5917e(this) {
                /* renamed from: b */
                final /* synthetic */ C7960p f24989b;

                /* renamed from: a */
                public void mo4973a() {
                    C5615p.m23868c("Scan operation is requested to stop.", new Object[0]);
                    this.f24989b.mo6759b(this.f24989b.f29668a, a);
                }
            });
            C5615p.m23868c("Scan operation is requested to start.", new Object[0]);
            if (!mo6758a(this.f29668a, a)) {
                c7332c.mo5001a(new C6975n(0));
            }
        } catch (Throwable th) {
            c5598i.mo5017a();
        }
        c5598i.mo5017a();
    }

    /* renamed from: a */
    protected C5548g mo6271a(DeadObjectException deadObjectException) {
        return new C6975n(1, (Throwable) deadObjectException);
    }
}
