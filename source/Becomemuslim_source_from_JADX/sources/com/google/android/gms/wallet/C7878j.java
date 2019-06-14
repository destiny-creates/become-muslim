package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public final class C7878j extends C4363a {
    public static final Creator<C7878j> CREATOR = new C5166w();
    /* renamed from: a */
    boolean f29406a;
    /* renamed from: b */
    boolean f29407b;
    /* renamed from: c */
    C7872d f29408c;
    /* renamed from: d */
    boolean f29409d;
    /* renamed from: e */
    C7882p f29410e;
    /* renamed from: f */
    ArrayList<Integer> f29411f;
    /* renamed from: g */
    C7880l f29412g;
    /* renamed from: h */
    C7883q f29413h;
    /* renamed from: i */
    boolean f29414i;
    /* renamed from: j */
    String f29415j;

    /* renamed from: com.google.android.gms.wallet.j$a */
    public final class C5156a {
        /* renamed from: a */
        private final /* synthetic */ C7878j f17433a;

        private C5156a(C7878j c7878j) {
            this.f17433a = c7878j;
        }

        /* renamed from: a */
        public final C5156a m21854a(int i) {
            if (this.f17433a.f29411f == null) {
                this.f17433a.f29411f = new ArrayList();
            }
            this.f17433a.f29411f.add(Integer.valueOf(i));
            return this;
        }

        /* renamed from: a */
        public final C5156a m21855a(C7872d c7872d) {
            this.f17433a.f29408c = c7872d;
            return this;
        }

        /* renamed from: a */
        public final C5156a m21856a(C7880l c7880l) {
            this.f17433a.f29412g = c7880l;
            return this;
        }

        /* renamed from: a */
        public final C5156a m21857a(C7882p c7882p) {
            this.f17433a.f29410e = c7882p;
            return this;
        }

        /* renamed from: a */
        public final C5156a m21858a(C7883q c7883q) {
            this.f17433a.f29413h = c7883q;
            return this;
        }

        /* renamed from: a */
        public final C5156a m21859a(boolean z) {
            this.f17433a.f29409d = z;
            return this;
        }

        /* renamed from: a */
        public final C7878j m21860a() {
            if (this.f17433a.f29415j == null) {
                C2872v.a(this.f17433a.f29411f, "Allowed payment methods must be set! You can set it through addAllowedPaymentMethod() or addAllowedPaymentMethods() in the PaymentDataRequest Builder.");
                C2872v.a(this.f17433a.f29408c, "Card requirements must be set!");
                if (this.f17433a.f29412g != null) {
                    C2872v.a(this.f17433a.f29413h, "Transaction info must be set if paymentMethodTokenizationParameters is set!");
                }
            }
            return this.f17433a;
        }
    }

    private C7878j() {
        this.f29414i = true;
    }

    C7878j(boolean z, boolean z2, C7872d c7872d, boolean z3, C7882p c7882p, ArrayList<Integer> arrayList, C7880l c7880l, C7883q c7883q, boolean z4, String str) {
        this.f29406a = z;
        this.f29407b = z2;
        this.f29408c = c7872d;
        this.f29409d = z3;
        this.f29410e = c7882p;
        this.f29411f = arrayList;
        this.f29412g = c7880l;
        this.f29413h = c7883q;
        this.f29414i = z4;
        this.f29415j = str;
    }

    /* renamed from: a */
    public static C5156a m38415a() {
        return new C5156a();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29406a);
        C2835c.a(parcel, 2, this.f29407b);
        C2835c.a(parcel, 3, this.f29408c, i, false);
        C2835c.a(parcel, 4, this.f29409d);
        C2835c.a(parcel, 5, this.f29410e, i, false);
        C2835c.a(parcel, 6, this.f29411f, false);
        C2835c.a(parcel, 7, this.f29412g, i, false);
        C2835c.a(parcel, 8, this.f29413h, i, false);
        C2835c.a(parcel, 9, this.f29414i);
        C2835c.a(parcel, 10, this.f29415j, false);
        C2835c.a(parcel, a);
    }
}
