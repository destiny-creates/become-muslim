package com.google.android.exoplayer2.p145g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

/* compiled from: Metadata */
/* renamed from: com.google.android.exoplayer2.g.a */
public final class C2344a implements Parcelable {
    public static final Creator<C2344a> CREATOR = new C23411();
    /* renamed from: a */
    private final C2342a[] f5806a;

    /* compiled from: Metadata */
    /* renamed from: com.google.android.exoplayer2.g.a$1 */
    static class C23411 implements Creator<C2344a> {
        C23411() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6500a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6501a(i);
        }

        /* renamed from: a */
        public C2344a m6500a(Parcel parcel) {
            return new C2344a(parcel);
        }

        /* renamed from: a */
        public C2344a[] m6501a(int i) {
            return new C2344a[0];
        }
    }

    /* compiled from: Metadata */
    /* renamed from: com.google.android.exoplayer2.g.a$a */
    public interface C2342a extends Parcelable {
    }

    public int describeContents() {
        return 0;
    }

    public C2344a(C2342a... c2342aArr) {
        if (c2342aArr == null) {
            c2342aArr = new C2342a[null];
        }
        this.f5806a = c2342aArr;
    }

    public C2344a(List<? extends C2342a> list) {
        if (list != null) {
            this.f5806a = new C2342a[list.size()];
            list.toArray(this.f5806a);
            return;
        }
        this.f5806a = new C2342a[null];
    }

    C2344a(Parcel parcel) {
        this.f5806a = new C2342a[parcel.readInt()];
        for (int i = 0; i < this.f5806a.length; i++) {
            this.f5806a[i] = (C2342a) parcel.readParcelable(C2342a.class.getClassLoader());
        }
    }

    /* renamed from: a */
    public int m6504a() {
        return this.f5806a.length;
    }

    /* renamed from: a */
    public C2342a m6505a(int i) {
        return this.f5806a[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return Arrays.equals(this.f5806a, ((C2344a) obj).f5806a);
            }
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5806a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5806a.length);
        for (Parcelable writeParcelable : this.f5806a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
