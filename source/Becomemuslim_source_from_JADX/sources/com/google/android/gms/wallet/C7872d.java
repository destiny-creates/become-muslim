package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.google.android.gms.wallet.d */
public final class C7872d extends C4363a {
    public static final Creator<C7872d> CREATOR = new an();
    /* renamed from: a */
    ArrayList<Integer> f29360a;
    /* renamed from: b */
    boolean f29361b;
    /* renamed from: c */
    boolean f29362c;
    /* renamed from: d */
    int f29363d;

    /* renamed from: com.google.android.gms.wallet.d$a */
    public final class C5154a {
        /* renamed from: a */
        private final /* synthetic */ C7872d f17431a;

        private C5154a(C7872d c7872d) {
            this.f17431a = c7872d;
        }

        /* renamed from: a */
        public final C5154a m21848a(Collection<Integer> collection) {
            boolean z = (collection == null || collection.isEmpty()) ? false : true;
            C2872v.b(z, "allowedCardNetworks can't be null or empty! You must provide a valid value from WalletConstants.CardNetwork.");
            if (this.f17431a.f29360a == null) {
                this.f17431a.f29360a = new ArrayList();
            }
            this.f17431a.f29360a.addAll(collection);
            return this;
        }

        /* renamed from: a */
        public final C5154a m21849a(boolean z) {
            this.f17431a.f29362c = z;
            return this;
        }

        /* renamed from: a */
        public final C7872d m21850a() {
            C2872v.a(this.f17431a.f29360a, "Allowed card networks must be non-empty! You can set it through addAllowedCardNetwork() or addAllowedCardNetworks() in the CardRequirements Builder.");
            return this.f17431a;
        }
    }

    private C7872d() {
        this.f29361b = true;
    }

    C7872d(ArrayList<Integer> arrayList, boolean z, boolean z2, int i) {
        this.f29360a = arrayList;
        this.f29361b = z;
        this.f29362c = z2;
        this.f29363d = i;
    }

    /* renamed from: a */
    public static C5154a m38404a() {
        return new C5154a();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29360a, false);
        C2835c.a(parcel, 2, this.f29361b);
        C2835c.a(parcel, 3, this.f29362c);
        C2835c.a(parcel, 4, this.f29363d);
        C2835c.a(parcel, i);
    }
}
