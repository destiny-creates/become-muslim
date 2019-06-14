package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public class SignInAccount extends C4363a implements ReflectedParcelable {
    public static final Creator<SignInAccount> CREATOR = new C2752k();
    @Deprecated
    /* renamed from: a */
    private String f13128a;
    /* renamed from: b */
    private GoogleSignInAccount f13129b;
    @Deprecated
    /* renamed from: c */
    private String f13130c;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f13129b = googleSignInAccount;
        this.f13128a = C2872v.m8383a(str, (Object) "8.3 and 8.4 SDKs require non-null email");
        this.f13130c = C2872v.m8383a(str2, (Object) "8.3 and 8.4 SDKs require non-null userId");
    }

    /* renamed from: a */
    public final GoogleSignInAccount m16671a() {
        return this.f13129b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 4, this.f13128a, false);
        C2835c.m8188a(parcel, 7, this.f13129b, i, false);
        C2835c.m8193a(parcel, 8, this.f13130c, false);
        C2835c.m8180a(parcel, a);
    }
}
