package android.support.p015c;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.p015c.C0110f.C3112a;
import java.util.List;

/* compiled from: ICustomTabsService */
/* renamed from: android.support.c.g */
public interface C0111g extends IInterface {

    /* compiled from: ICustomTabsService */
    /* renamed from: android.support.c.g$a */
    public static abstract class C3114a extends Binder implements C0111g {

        /* compiled from: ICustomTabsService */
        /* renamed from: android.support.c.g$a$a */
        private static class C3113a implements C0111g {
            /* renamed from: a */
            private IBinder f7941a;

            C3113a(IBinder iBinder) {
                this.f7941a = iBinder;
            }

            public IBinder asBinder() {
                return this.f7941a;
            }

            /* renamed from: a */
            public boolean mo34a(long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeLong(j);
                    boolean z = false;
                    this.f7941a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != null) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo35a(C0110f c0110f) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeStrongBinder(c0110f != null ? c0110f.asBinder() : null);
                    boolean z = false;
                    this.f7941a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != null) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo38a(C0110f c0110f, Uri uri, Bundle bundle, List<Bundle> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeStrongBinder(c0110f != null ? c0110f.asBinder() : null);
                    c0110f = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.f7941a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == null) {
                        c0110f = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return c0110f;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Bundle mo33a(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7941a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readInt() != null ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return str;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo39a(C0110f c0110f, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeStrongBinder(c0110f != null ? c0110f.asBinder() : null);
                    c0110f = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7941a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == null) {
                        c0110f = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return c0110f;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo37a(C0110f c0110f, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeStrongBinder(c0110f != null ? c0110f.asBinder() : null);
                    c0110f = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7941a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == null) {
                        c0110f = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return c0110f;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public int mo32a(C0110f c0110f, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeStrongBinder(c0110f != null ? c0110f.asBinder() : null);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7941a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    c0110f = obtain2.readInt();
                    return c0110f;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo36a(C0110f c0110f, int i, Uri uri, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeStrongBinder(c0110f != null ? c0110f.asBinder() : null);
                    obtain.writeInt(i);
                    c0110f = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7941a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == null) {
                        c0110f = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return c0110f;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        /* renamed from: a */
        public static C0111g m9154a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0111g)) {
                return new C3113a(iBinder);
            }
            return (C0111g) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                Bundle bundle = null;
                switch (i) {
                    case 2:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        i = mo34a((long) parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        i = mo35a((C0110f) C3112a.m9145a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        i = C3112a.m9145a(parcel.readStrongBinder());
                        i2 = parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : 0;
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        i = mo38a((C0110f) i, (Uri) i2, bundle, (List) parcel.createTypedArrayList(Bundle.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        i = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        i = mo33a((String) i, bundle);
                        parcel2.writeNoException();
                        if (i != 0) {
                            parcel2.writeInt(1);
                            i.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        i = C3112a.m9145a(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        i = mo39a((C0110f) i, bundle);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 7:
                        Uri uri;
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        i = C3112a.m9145a(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        }
                        i = mo37a((C0110f) i, uri);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 8:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        i = C3112a.m9145a(parcel.readStrongBinder());
                        i2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        i = mo32a(i, i2, bundle);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        i = C3112a.m9145a(parcel.readStrongBinder());
                        i2 = parcel.readInt();
                        Uri uri2 = parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        i = mo36a((C0110f) i, i2, uri2, bundle);
                        parcel2.writeNoException();
                        parcel2.writeInt(i);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("android.support.customtabs.ICustomTabsService");
            return true;
        }
    }

    /* renamed from: a */
    int mo32a(C0110f c0110f, String str, Bundle bundle);

    /* renamed from: a */
    Bundle mo33a(String str, Bundle bundle);

    /* renamed from: a */
    boolean mo34a(long j);

    /* renamed from: a */
    boolean mo35a(C0110f c0110f);

    /* renamed from: a */
    boolean mo36a(C0110f c0110f, int i, Uri uri, Bundle bundle);

    /* renamed from: a */
    boolean mo37a(C0110f c0110f, Uri uri);

    /* renamed from: a */
    boolean mo38a(C0110f c0110f, Uri uri, Bundle bundle, List<Bundle> list);

    /* renamed from: a */
    boolean mo39a(C0110f c0110f, Bundle bundle);
}
