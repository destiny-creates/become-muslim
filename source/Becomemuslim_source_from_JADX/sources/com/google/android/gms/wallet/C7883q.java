package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.q */
public final class C7883q extends C4363a {
    public static final Creator<C7883q> CREATOR = new ag();
    /* renamed from: a */
    int f29425a;
    /* renamed from: b */
    String f29426b;
    /* renamed from: c */
    String f29427c;

    /* renamed from: com.google.android.gms.wallet.q$a */
    public final class C5160a {
        /* renamed from: a */
        private final /* synthetic */ C7883q f17436a;

        private C5160a(C7883q c7883q) {
            this.f17436a = c7883q;
        }

        /* renamed from: a */
        public final C5160a m21866a(int i) {
            this.f17436a.f29425a = i;
            return this;
        }

        /* renamed from: a */
        public final C5160a m21867a(String str) {
            this.f17436a.f29426b = str;
            return this;
        }

        /* renamed from: a */
        public final C7883q m21868a() {
            C2872v.a(this.f17436a.f29427c, "currencyCode must be set!");
            Object obj = 1;
            if (!(this.f17436a.f29425a == 1 || this.f17436a.f29425a == 2)) {
                if (this.f17436a.f29425a != 3) {
                    obj = null;
                }
            }
            if (obj != null) {
                if (this.f17436a.f29425a == 2) {
                    C2872v.a(this.f17436a.f29426b, "An estimated total price must be set if totalPriceStatus is set to WalletConstants.TOTAL_PRICE_STATUS_ESTIMATED!");
                }
                if (this.f17436a.f29425a == 3) {
                    C2872v.a(this.f17436a.f29426b, "An final total price must be set if totalPriceStatus is set to WalletConstants.TOTAL_PRICE_STATUS_FINAL!");
                }
                return this.f17436a;
            }
            throw new IllegalArgumentException("totalPriceStatus must be set to one of WalletConstants.TotalPriceStatus!");
        }

        /* renamed from: b */
        public final C5160a m21869b(String str) {
            this.f17436a.f29427c = str;
            return this;
        }
    }

    private C7883q() {
    }

    public C7883q(int i, String str, String str2) {
        this.f29425a = i;
        this.f29426b = str;
        this.f29427c = str2;
    }

    /* renamed from: a */
    public static C5160a m38419a() {
        return new C5160a();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29425a);
        C2835c.a(parcel, 2, this.f29426b, false);
        C2835c.a(parcel, 3, this.f29427c, false);
        C2835c.a(parcel, i);
    }
}
