package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p203b.C4941b;
import com.google.android.gms.internal.p203b.C4942c;

/* renamed from: com.google.android.gms.auth.api.signin.internal.v */
public abstract class C4318v extends C4941b implements C2748u {
    public C4318v() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    /* renamed from: a */
    protected final boolean m14015a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 101:
                mo3265a((GoogleSignInAccount) C4942c.a(parcel, GoogleSignInAccount.CREATOR), (Status) C4942c.a(parcel, Status.CREATOR));
                break;
            case 102:
                mo3266a((Status) C4942c.a(parcel, Status.CREATOR));
                break;
            case 103:
                mo3267b((Status) C4942c.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
