package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p206e.C4959b;
import com.google.android.gms.internal.p206e.C4960c;

/* renamed from: com.google.android.gms.common.internal.q */
public interface C2864q extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.q$a */
    public static abstract class C4372a extends C4959b implements C2864q {
        public C4372a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        /* renamed from: a */
        protected final boolean m14391a(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    mo2474a(parcel.readInt(), (IBinder) parcel.readStrongBinder(), (Bundle) C4960c.a(parcel, Bundle.CREATOR));
                    break;
                case 2:
                    mo2473a(parcel.readInt(), (Bundle) C4960c.a(parcel, Bundle.CREATOR));
                    break;
                case 3:
                    mo2475a(parcel.readInt(), (IBinder) parcel.readStrongBinder(), (aq) C4960c.a(parcel, aq.CREATOR));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo2473a(int i, Bundle bundle);

    /* renamed from: a */
    void mo2474a(int i, IBinder iBinder, Bundle bundle);

    /* renamed from: a */
    void mo2475a(int i, IBinder iBinder, aq aqVar);
}
