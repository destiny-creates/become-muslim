package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.p187a.C4792a;
import com.google.android.gms.fitness.p187a.C4798o;

/* renamed from: com.google.android.gms.internal.g.aq */
public final class aq extends C4970a implements ao {
    aq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
    }

    /* renamed from: a */
    public final void mo4401a(C4792a c4792a) {
        Parcel a = m20248a();
        ap.m20256a(a, (Parcelable) c4792a);
        m20249a(1, a);
    }

    /* renamed from: a */
    public final void mo4402a(C4798o c4798o) {
        Parcel a = m20248a();
        ap.m20256a(a, (Parcelable) c4798o);
        m20249a(2, a);
    }
}
