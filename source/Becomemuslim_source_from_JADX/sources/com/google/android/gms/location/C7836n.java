package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.location.n */
public final class C7836n extends C4363a {
    public static final Creator<C7836n> CREATOR = new C5090z();
    /* renamed from: a */
    private final List<LocationRequest> f29188a;
    /* renamed from: b */
    private final boolean f29189b;
    /* renamed from: c */
    private final boolean f29190c;
    /* renamed from: d */
    private C7841x f29191d;

    /* renamed from: com.google.android.gms.location.n$a */
    public static final class C5083a {
        /* renamed from: a */
        private final ArrayList<LocationRequest> f17387a = new ArrayList();
        /* renamed from: b */
        private boolean f17388b = false;
        /* renamed from: c */
        private boolean f17389c = false;
        /* renamed from: d */
        private C7841x f17390d = null;

        /* renamed from: a */
        public final C5083a m21576a(LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.f17387a.add(locationRequest);
            }
            return this;
        }

        /* renamed from: a */
        public final C5083a m21577a(boolean z) {
            this.f17388b = z;
            return this;
        }

        /* renamed from: a */
        public final C7836n m21578a() {
            return new C7836n(this.f17387a, this.f17388b, this.f17389c, null);
        }
    }

    C7836n(List<LocationRequest> list, boolean z, boolean z2, C7841x c7841x) {
        this.f29188a = list;
        this.f29189b = z;
        this.f29190c = z2;
        this.f29191d = c7841x;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.c(parcel, 1, Collections.unmodifiableList(this.f29188a), false);
        C2835c.a(parcel, 2, this.f29189b);
        C2835c.a(parcel, 3, this.f29190c);
        C2835c.a(parcel, 5, this.f29191d, i, false);
        C2835c.a(parcel, a);
    }
}
