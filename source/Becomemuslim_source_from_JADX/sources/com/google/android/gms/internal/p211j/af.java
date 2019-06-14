package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C4783e;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.j.af */
public final class af extends C4363a {
    public static final Creator<af> CREATOR = new ag();
    /* renamed from: a */
    static final List<C4783e> f28928a = Collections.emptyList();
    /* renamed from: b */
    private LocationRequest f28929b;
    /* renamed from: c */
    private List<C4783e> f28930c;
    /* renamed from: d */
    private String f28931d;
    /* renamed from: e */
    private boolean f28932e;
    /* renamed from: f */
    private boolean f28933f;
    /* renamed from: g */
    private boolean f28934g;
    /* renamed from: h */
    private String f28935h;
    /* renamed from: i */
    private boolean f28936i = true;

    af(LocationRequest locationRequest, List<C4783e> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f28929b = locationRequest;
        this.f28930c = list;
        this.f28931d = str;
        this.f28932e = z;
        this.f28933f = z2;
        this.f28934g = z3;
        this.f28935h = str2;
    }

    @Deprecated
    /* renamed from: a */
    public static af m38020a(LocationRequest locationRequest) {
        return new af(locationRequest, f28928a, null, false, false, false, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof af)) {
            return false;
        }
        af afVar = (af) obj;
        return C2868t.a(this.f28929b, afVar.f28929b) && C2868t.a(this.f28930c, afVar.f28930c) && C2868t.a(this.f28931d, afVar.f28931d) && this.f28932e == afVar.f28932e && this.f28933f == afVar.f28933f && this.f28934g == afVar.f28934g && C2868t.a(this.f28935h, afVar.f28935h);
    }

    public final int hashCode() {
        return this.f28929b.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f28929b);
        if (this.f28931d != null) {
            stringBuilder.append(" tag=");
            stringBuilder.append(this.f28931d);
        }
        if (this.f28935h != null) {
            stringBuilder.append(" moduleId=");
            stringBuilder.append(this.f28935h);
        }
        stringBuilder.append(" hideAppOps=");
        stringBuilder.append(this.f28932e);
        stringBuilder.append(" clients=");
        stringBuilder.append(this.f28930c);
        stringBuilder.append(" forceCoarseLocation=");
        stringBuilder.append(this.f28933f);
        if (this.f28934g) {
            stringBuilder.append(" exemptFromBackgroundThrottle");
        }
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28929b, i, false);
        C2835c.c(parcel, 5, this.f28930c, false);
        C2835c.a(parcel, 6, this.f28931d, false);
        C2835c.a(parcel, 7, this.f28932e);
        C2835c.a(parcel, 8, this.f28933f);
        C2835c.a(parcel, 9, this.f28934g);
        C2835c.a(parcel, 10, this.f28935h, false);
        C2835c.a(parcel, a);
    }
}
