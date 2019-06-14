package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: FragmentManager */
/* renamed from: android.support.v4.app.q */
final class C0323q implements Parcelable {
    public static final Creator<C0323q> CREATOR = new C03221();
    /* renamed from: a */
    C0325s[] f848a;
    /* renamed from: b */
    int[] f849b;
    /* renamed from: c */
    C0294d[] f850c;
    /* renamed from: d */
    int f851d = -1;
    /* renamed from: e */
    int f852e;

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.q$1 */
    static class C03221 implements Creator<C0323q> {
        C03221() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m949a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m950a(i);
        }

        /* renamed from: a */
        public C0323q m949a(Parcel parcel) {
            return new C0323q(parcel);
        }

        /* renamed from: a */
        public C0323q[] m950a(int i) {
            return new C0323q[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C0323q(Parcel parcel) {
        this.f848a = (C0325s[]) parcel.createTypedArray(C0325s.CREATOR);
        this.f849b = parcel.createIntArray();
        this.f850c = (C0294d[]) parcel.createTypedArray(C0294d.CREATOR);
        this.f851d = parcel.readInt();
        this.f852e = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f848a, i);
        parcel.writeIntArray(this.f849b);
        parcel.writeTypedArray(this.f850c, i);
        parcel.writeInt(this.f851d);
        parcel.writeInt(this.f852e);
    }
}
