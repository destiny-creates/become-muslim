package com.google.android.gms.p175c.p176a;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p205d.C4953b;
import com.google.android.gms.internal.p205d.C4954c;

/* renamed from: com.google.android.gms.c.a.f */
public abstract class C4330f extends C4953b implements C2766e {
    public C4330f() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* renamed from: a */
    protected boolean m14032a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                mo3276a((C4775b) C4954c.a(parcel, C4775b.CREATOR), (C4758b) C4954c.a(parcel, C4758b.CREATOR));
                break;
            case 4:
                mo3274a((Status) C4954c.a(parcel, Status.CREATOR));
                break;
            case 6:
                mo3277b((Status) C4954c.a(parcel, Status.CREATOR));
                break;
            case 7:
                mo3275a((Status) C4954c.a(parcel, Status.CREATOR), (GoogleSignInAccount) C4954c.a(parcel, GoogleSignInAccount.CREATOR));
                break;
            case 8:
                mo3273a((C4761k) C4954c.a(parcel, C4761k.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
