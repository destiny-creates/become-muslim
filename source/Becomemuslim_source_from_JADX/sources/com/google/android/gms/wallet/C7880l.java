package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.l */
public final class C7880l extends C4363a {
    public static final Creator<C7880l> CREATOR = new C5181z();
    /* renamed from: a */
    int f29418a;
    /* renamed from: b */
    Bundle f29419b = new Bundle();

    /* renamed from: com.google.android.gms.wallet.l$a */
    public final class C5157a {
        /* renamed from: a */
        private final /* synthetic */ C7880l f17434a;

        private C5157a(C7880l c7880l) {
            this.f17434a = c7880l;
        }

        /* renamed from: a */
        public final C5157a m21861a(int i) {
            this.f17434a.f29418a = i;
            return this;
        }

        /* renamed from: a */
        public final C5157a m21862a(String str, String str2) {
            C2872v.a(str, "Tokenization parameter name must not be empty");
            C2872v.a(str2, "Tokenization parameter value must not be empty");
            this.f17434a.f29419b.putString(str, str2);
            return this;
        }

        /* renamed from: a */
        public final C7880l m21863a() {
            return this.f17434a;
        }
    }

    private C7880l() {
    }

    C7880l(int i, Bundle bundle) {
        this.f29418a = i;
        this.f29419b = bundle;
    }

    /* renamed from: a */
    public static C5157a m38417a() {
        return new C5157a();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29418a);
        C2835c.a(parcel, 3, this.f29419b, false);
        C2835c.a(parcel, i);
    }
}
