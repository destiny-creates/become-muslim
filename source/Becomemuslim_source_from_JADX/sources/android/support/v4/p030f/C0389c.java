package android.support.v4.p030f;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IResultReceiver */
/* renamed from: android.support.v4.f.c */
public interface C0389c extends IInterface {

    /* compiled from: IResultReceiver */
    /* renamed from: android.support.v4.f.c$a */
    public static abstract class C3197a extends Binder implements C0389c {

        /* compiled from: IResultReceiver */
        /* renamed from: android.support.v4.f.c$a$a */
        private static class C3196a implements C0389c {
            /* renamed from: a */
            private IBinder f8243a;

            C3196a(IBinder iBinder) {
                this.f8243a = iBinder;
            }

            public IBinder asBinder() {
                return this.f8243a;
            }

            /* renamed from: a */
            public void mo226a(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8243a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C3197a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        /* renamed from: a */
        public static C0389c m9670a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0389c)) {
                return new C3196a(iBinder);
            }
            return (C0389c) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                mo226a(parcel.readInt(), parcel.readInt() != null ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    /* renamed from: a */
    void mo226a(int i, Bundle bundle);
}
