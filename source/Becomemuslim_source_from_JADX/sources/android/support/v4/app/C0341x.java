package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: INotificationSideChannel */
/* renamed from: android.support.v4.app.x */
public interface C0341x extends IInterface {

    /* compiled from: INotificationSideChannel */
    /* renamed from: android.support.v4.app.x$a */
    public static abstract class C3188a extends Binder implements C0341x {

        /* compiled from: INotificationSideChannel */
        /* renamed from: android.support.v4.app.x$a$a */
        private static class C3187a implements C0341x {
            /* renamed from: a */
            private IBinder f8226a;

            C3187a(IBinder iBinder) {
                this.f8226a = iBinder;
            }

            public IBinder asBinder() {
                return this.f8226a;
            }

            /* renamed from: a */
            public void mo217a(String str, int i, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8226a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo216a(String str, int i, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.f8226a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo215a(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    this.f8226a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        /* renamed from: a */
        public static C0341x m9647a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0341x)) {
                return new C3187a(iBinder);
            }
            return (C0341x) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                        mo217a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 2:
                        parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                        mo216a(parcel.readString(), parcel.readInt(), parcel.readString());
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                        mo215a(parcel.readString());
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("android.support.v4.app.INotificationSideChannel");
            return true;
        }
    }

    /* renamed from: a */
    void mo215a(String str);

    /* renamed from: a */
    void mo216a(String str, int i, String str2);

    /* renamed from: a */
    void mo217a(String str, int i, String str2, Notification notification);
}
