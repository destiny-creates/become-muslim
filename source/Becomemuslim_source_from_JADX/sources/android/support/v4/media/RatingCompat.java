package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C04231();
    /* renamed from: a */
    private final int f1101a;
    /* renamed from: b */
    private final float f1102b;

    /* renamed from: android.support.v4.media.RatingCompat$1 */
    static class C04231 implements Creator<RatingCompat> {
        C04231() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1248a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1249a(i);
        }

        /* renamed from: a */
        public RatingCompat m1248a(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] m1249a(int i) {
            return new RatingCompat[i];
        }
    }

    RatingCompat(int i, float f) {
        this.f1101a = i;
        this.f1102b = f;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rating:style=");
        stringBuilder.append(this.f1101a);
        stringBuilder.append(" rating=");
        if (this.f1102b < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(this.f1102b);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public int describeContents() {
        return this.f1101a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1101a);
        parcel.writeFloat(this.f1102b);
    }
}
