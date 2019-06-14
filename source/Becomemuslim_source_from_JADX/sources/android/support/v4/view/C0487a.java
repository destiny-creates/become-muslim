package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

/* compiled from: AbsSavedState */
/* renamed from: android.support.v4.view.a */
public abstract class C0487a implements Parcelable {
    public static final Creator<C0487a> CREATOR = new C04782();
    /* renamed from: d */
    public static final C0487a f1256d = new C32161();
    /* renamed from: a */
    private final Parcelable f1257a;

    /* compiled from: AbsSavedState */
    /* renamed from: android.support.v4.view.a$2 */
    static class C04782 implements ClassLoaderCreator<C0487a> {
        C04782() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1491a(parcel);
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return m1492a(parcel, classLoader);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1493a(i);
        }

        /* renamed from: a */
        public C0487a m1492a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return C0487a.f1256d;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: a */
        public C0487a m1491a(Parcel parcel) {
            return m1492a(parcel, null);
        }

        /* renamed from: a */
        public C0487a[] m1493a(int i) {
            return new C0487a[i];
        }
    }

    /* compiled from: AbsSavedState */
    /* renamed from: android.support.v4.view.a$1 */
    static class C32161 extends C0487a {
        C32161() {
            super();
        }
    }

    public int describeContents() {
        return 0;
    }

    private C0487a() {
        this.f1257a = null;
    }

    protected C0487a(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable == f1256d) {
                parcelable = null;
            }
            this.f1257a = parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected C0487a(Parcel parcel, ClassLoader classLoader) {
        parcel = parcel.readParcelable(classLoader);
        if (parcel == null) {
            parcel = f1256d;
        }
        this.f1257a = parcel;
    }

    /* renamed from: a */
    public final Parcelable m1558a() {
        return this.f1257a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1257a, i);
    }
}
