package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.internal.ads.s */
public abstract class C6767s extends ajm implements C4936r {
    public C6767s() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    /* renamed from: a */
    public static C4936r m31047a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        return queryLocalInterface instanceof C4936r ? (C4936r) queryLocalInterface : new C6768t(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo4359a((Bundle) ajn.m18501a(parcel, Bundle.CREATOR));
                break;
            case 2:
                mo4364f();
                break;
            case 3:
                mo4365g();
                break;
            case 4:
                mo4366h();
                break;
            case 5:
                mo4367i();
                break;
            case 6:
                Bundle bundle = (Bundle) ajn.m18501a(parcel, Bundle.CREATOR);
                mo4361b(bundle);
                parcel2.writeNoException();
                ajn.m18507b(parcel2, bundle);
                break;
            case 7:
                mo4368j();
                break;
            case 8:
                mo4369k();
                break;
            case 9:
                mo4370l();
                break;
            case 10:
                mo4362d();
                break;
            case 11:
                boolean e = mo4363e();
                parcel2.writeNoException();
                ajn.m18504a(parcel2, e);
                break;
            case 12:
                mo4358a(parcel.readInt(), parcel.readInt(), (Intent) ajn.m18501a(parcel, Intent.CREATOR));
                break;
            case 13:
                mo4360a(C4325a.a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
