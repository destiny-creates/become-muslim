package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C4783e;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.location.aj;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.j.aw */
public final class aw extends C4363a {
    public static final Creator<aw> CREATOR = new ax();
    /* renamed from: a */
    static final List<C4783e> f28952a = Collections.emptyList();
    /* renamed from: b */
    static final aj f28953b = new aj();
    /* renamed from: c */
    private aj f28954c;
    /* renamed from: d */
    private List<C4783e> f28955d;
    /* renamed from: e */
    private String f28956e;

    aw(aj ajVar, List<C4783e> list, String str) {
        this.f28954c = ajVar;
        this.f28955d = list;
        this.f28956e = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aw)) {
            return false;
        }
        aw awVar = (aw) obj;
        return C2868t.a(this.f28954c, awVar.f28954c) && C2868t.a(this.f28955d, awVar.f28955d) && C2868t.a(this.f28956e, awVar.f28956e);
    }

    public final int hashCode() {
        return this.f28954c.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28954c, i, false);
        C2835c.c(parcel, 2, this.f28955d, false);
        C2835c.a(parcel, 3, this.f28956e, false);
        C2835c.a(parcel, a);
    }
}
