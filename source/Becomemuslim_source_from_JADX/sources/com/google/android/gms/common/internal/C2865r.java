package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.common.internal.r */
public interface C2865r extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.r$a */
    public static abstract class C4374a extends Binder implements C2865r {

        /* renamed from: com.google.android.gms.common.internal.r$a$a */
        private static class C4373a implements C2865r {
            /* renamed from: a */
            private final IBinder f11594a;

            C4373a(IBinder iBinder) {
                this.f11594a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f11594a;
            }

            /* renamed from: a */
            public final void mo2480a(C2864q c2864q, C4784i c4784i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c2864q != null ? c2864q.asBinder() : null);
                    if (c4784i != null) {
                        obtain.writeInt(1);
                        c4784i.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11594a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i > 16777215) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            i2 = parcel.readStrongBinder();
            C4784i c4784i = null;
            if (i2 == 0) {
                i2 = 0;
            } else {
                IInterface queryLocalInterface = i2.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                if (queryLocalInterface instanceof C2864q) {
                    i2 = (C2864q) queryLocalInterface;
                } else {
                    i2 = new ba(i2);
                }
            }
            if (i == 46) {
                if (parcel.readInt() != 0) {
                    c4784i = (C4784i) C4784i.CREATOR.createFromParcel(parcel);
                }
                mo2480a(i2, c4784i);
                parcel2.writeNoException();
                return true;
            } else if (i == 47) {
                if (parcel.readInt() != 0) {
                    bg.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            } else {
                parcel.readInt();
                if (i != 4) {
                    parcel.readString();
                }
                if (!(i == 23 || i == 25 || i == 27)) {
                    if (i != 30) {
                        if (i != 34) {
                            if (!(i == 41 || i == 43)) {
                                switch (i) {
                                    case 1:
                                        parcel.readString();
                                        parcel.createStringArray();
                                        parcel.readString();
                                        if (parcel.readInt() != 0) {
                                            Bundle.CREATOR.createFromParcel(parcel);
                                            break;
                                        }
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        switch (i) {
                                            case 5:
                                            case 6:
                                            case 7:
                                            case 8:
                                            case 11:
                                            case 12:
                                            case 13:
                                            case 14:
                                            case 15:
                                            case 16:
                                            case 17:
                                            case 18:
                                                break;
                                            case 9:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                parcel.readString();
                                                parcel.readStrongBinder();
                                                parcel.readString();
                                                if (parcel.readInt() != 0) {
                                                    Bundle.CREATOR.createFromParcel(parcel);
                                                    break;
                                                }
                                                break;
                                            case 10:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                break;
                                            case 19:
                                                parcel.readStrongBinder();
                                                if (parcel.readInt() != 0) {
                                                    Bundle.CREATOR.createFromParcel(parcel);
                                                    break;
                                                }
                                                break;
                                            case 20:
                                                break;
                                            default:
                                                switch (i) {
                                                    case 37:
                                                    case 38:
                                                        break;
                                                    default:
                                                        break;
                                                }
                                        }
                                }
                            }
                        }
                        parcel.readString();
                        throw new UnsupportedOperationException();
                    }
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    throw new UnsupportedOperationException();
                }
                if (parcel.readInt() != 0) {
                    Bundle.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            }
        }
    }

    /* renamed from: a */
    void mo2480a(C2864q c2864q, C4784i c4784i);
}
