package android.support.v4.p030f;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

@Deprecated
/* compiled from: ParcelableCompat */
/* renamed from: android.support.v4.f.e */
public final class C0392e {

    /* compiled from: ParcelableCompat */
    /* renamed from: android.support.v4.f.e$a */
    static class C0391a<T> implements ClassLoaderCreator<T> {
        /* renamed from: a */
        private final C0393f<T> f1014a;

        C0391a(C0393f<T> c0393f) {
            this.f1014a = c0393f;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f1014a.mo817a(parcel, null);
        }

        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f1014a.mo817a(parcel, classLoader);
        }

        public T[] newArray(int i) {
            return this.f1014a.mo818a(i);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static <T> Creator<T> m1170a(C0393f<T> c0393f) {
        return new C0391a(c0393f);
    }
}
