package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.f */
public final class C7874f extends C4363a {
    public static final Creator<C7874f> CREATOR = new ar();
    /* renamed from: a */
    ArrayList<Integer> f29367a;
    /* renamed from: b */
    ArrayList<Integer> f29368b;
    /* renamed from: c */
    boolean f29369c;
    /* renamed from: d */
    private String f29370d;
    /* renamed from: e */
    private String f29371e;
    /* renamed from: f */
    private String f29372f;

    /* renamed from: com.google.android.gms.wallet.f$a */
    public final class C5155a {
        /* renamed from: a */
        private final /* synthetic */ C7874f f17432a;

        private C5155a(C7874f c7874f) {
            this.f17432a = c7874f;
        }

        /* renamed from: a */
        public final C5155a m21851a(int i) {
            if (this.f17432a.f29368b == null) {
                this.f17432a.f29368b = new ArrayList();
            }
            this.f17432a.f29368b.add(Integer.valueOf(i));
            return this;
        }

        /* renamed from: a */
        public final C5155a m21852a(boolean z) {
            this.f17432a.f29369c = z;
            return this;
        }

        /* renamed from: a */
        public final C7874f m21853a() {
            return this.f17432a;
        }
    }

    C7874f() {
    }

    C7874f(ArrayList<Integer> arrayList, String str, String str2, ArrayList<Integer> arrayList2, boolean z, String str3) {
        this.f29367a = arrayList;
        this.f29370d = str;
        this.f29371e = str2;
        this.f29368b = arrayList2;
        this.f29369c = z;
        this.f29372f = str3;
    }

    /* renamed from: a */
    public static C5155a m38408a() {
        return new C5155a();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29367a, false);
        C2835c.a(parcel, 4, this.f29370d, false);
        C2835c.a(parcel, 5, this.f29371e, false);
        C2835c.a(parcel, 6, this.f29368b, false);
        C2835c.a(parcel, 7, this.f29369c);
        C2835c.a(parcel, 8, this.f29372f, false);
        C2835c.a(parcel, i);
    }
}
