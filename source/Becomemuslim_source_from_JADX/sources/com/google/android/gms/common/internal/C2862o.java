package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p206e.C4958a;
import com.google.android.gms.internal.p206e.C4959b;
import com.google.android.gms.internal.p206e.C4960c;

/* renamed from: com.google.android.gms.common.internal.o */
public interface C2862o extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.o$a */
    public static abstract class C4371a extends C4959b implements C2862o {

        /* renamed from: com.google.android.gms.common.internal.o$a$a */
        public static class C4370a extends C4958a implements C2862o {
            C4370a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            /* renamed from: a */
            public final Account mo2479a() {
                Parcel a = a(2, c());
                Account account = (Account) C4960c.a(a, Account.CREATOR);
                a.recycle();
                return account;
            }
        }

        /* renamed from: a */
        public static C2862o m14389a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof C2862o) {
                return (C2862o) queryLocalInterface;
            }
            return new C4370a(iBinder);
        }

        /* renamed from: a */
        protected final boolean m14390a(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 2) {
                return false;
            }
            i = mo2479a();
            parcel2.writeNoException();
            C4960c.b(parcel2, i);
            return true;
        }
    }

    /* renamed from: a */
    Account mo2479a();
}
