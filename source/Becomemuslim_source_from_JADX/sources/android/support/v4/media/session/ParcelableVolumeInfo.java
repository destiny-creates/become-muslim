package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C04331();
    /* renamed from: a */
    public int f1123a;
    /* renamed from: b */
    public int f1124b;
    /* renamed from: c */
    public int f1125c;
    /* renamed from: d */
    public int f1126d;
    /* renamed from: e */
    public int f1127e;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo$1 */
    static class C04331 implements Creator<ParcelableVolumeInfo> {
        C04331() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1293a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1294a(i);
        }

        /* renamed from: a */
        public ParcelableVolumeInfo m1293a(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: a */
        public ParcelableVolumeInfo[] m1294a(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f1123a = parcel.readInt();
        this.f1125c = parcel.readInt();
        this.f1126d = parcel.readInt();
        this.f1127e = parcel.readInt();
        this.f1124b = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1123a);
        parcel.writeInt(this.f1125c);
        parcel.writeInt(this.f1126d);
        parcel.writeInt(this.f1127e);
        parcel.writeInt(this.f1124b);
    }
}
