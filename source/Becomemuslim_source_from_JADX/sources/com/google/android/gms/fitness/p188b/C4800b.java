package com.google.android.gms.fitness.p188b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.fitness.data.C4801a;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.b.b */
public class C4800b extends C4363a implements C2814k {
    public static final Creator<C4800b> CREATOR = new C2985d();
    /* renamed from: a */
    private final List<C4801a> f13371a;
    /* renamed from: b */
    private final Status f13372b;

    public C4800b(List<C4801a> list, Status status) {
        this.f13371a = Collections.unmodifiableList(list);
        this.f13372b = status;
    }

    /* renamed from: a */
    public List<C4801a> m16956a() {
        return this.f13371a;
    }

    /* renamed from: b */
    public Status mo2360b() {
        return this.f13372b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C4800b) {
                C4800b c4800b = (C4800b) obj;
                obj = (this.f13372b.equals(c4800b.f13372b) && C2868t.m8374a(this.f13371a, c4800b.f13371a)) ? 1 : null;
                if (obj != null) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C2868t.m8372a(this.f13372b, this.f13371a);
    }

    public String toString() {
        return C2868t.m8373a((Object) this).m8371a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f13372b).m8371a("dataSources", this.f13371a).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8207c(parcel, 1, m16956a(), false);
        C2835c.m8188a(parcel, 2, mo2360b(), i, false);
        C2835c.m8180a(parcel, a);
    }
}
