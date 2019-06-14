package io.nlopez.smartlocation.geocoding.p365a;

import android.location.Address;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: LocationAddress */
/* renamed from: io.nlopez.smartlocation.geocoding.a.a */
public class C6552a implements Parcelable {
    public static final Creator CREATOR = new C65511();
    /* renamed from: a */
    private Location f21068a;
    /* renamed from: b */
    private Address f21069b;

    /* compiled from: LocationAddress */
    /* renamed from: io.nlopez.smartlocation.geocoding.a.a$1 */
    static class C65511 implements Creator {
        C65511() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m26744a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m26745a(i);
        }

        /* renamed from: a */
        public C6552a m26744a(Parcel parcel) {
            return new C6552a(parcel);
        }

        /* renamed from: a */
        public C6552a[] m26745a(int i) {
            return new C6552a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C6552a(Address address) {
        this.f21069b = address;
        this.f21068a = new Location(C6552a.class.getCanonicalName());
        this.f21068a.setLatitude(address.getLatitude());
        this.f21068a.setLongitude(address.getLongitude());
    }

    public C6552a(Parcel parcel) {
        this.f21068a = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f21069b = (Address) parcel.readParcelable(Address.class.getClassLoader());
    }

    /* renamed from: a */
    public Location m26746a() {
        return this.f21068a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f21068a, i);
        parcel.writeParcelable(this.f21069b, i);
    }
}
