package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.google.android.gms.wallet.p */
public final class C7882p extends C4363a {
    public static final Creator<C7882p> CREATOR = new ae();
    /* renamed from: a */
    ArrayList<String> f29424a;

    /* renamed from: com.google.android.gms.wallet.p$a */
    public final class C5159a {
        /* renamed from: a */
        private final /* synthetic */ C7882p f17435a;

        private C5159a(C7882p c7882p) {
            this.f17435a = c7882p;
        }

        /* renamed from: a */
        public final C5159a m21864a(Collection<String> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("allowedCountryCodes can't be null or empty! If you don't have restrictions, just leave it unset.");
            }
            if (this.f17435a.f29424a == null) {
                this.f17435a.f29424a = new ArrayList();
            }
            this.f17435a.f29424a.addAll(collection);
            return this;
        }

        /* renamed from: a */
        public final C7882p m21865a() {
            return this.f17435a;
        }
    }

    private C7882p() {
    }

    C7882p(ArrayList<String> arrayList) {
        this.f29424a = arrayList;
    }

    /* renamed from: a */
    public static C5159a m38418a() {
        return new C5159a();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.b(parcel, 1, this.f29424a, false);
        C2835c.a(parcel, i);
    }
}
