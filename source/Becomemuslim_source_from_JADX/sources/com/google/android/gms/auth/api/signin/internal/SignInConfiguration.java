package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class SignInConfiguration extends C4363a implements ReflectedParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new C2750z();
    /* renamed from: a */
    private final String f13131a;
    /* renamed from: b */
    private GoogleSignInOptions f13132b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f13131a = C2872v.m8382a(str);
        this.f13132b = googleSignInOptions;
    }

    /* renamed from: a */
    public final GoogleSignInOptions m16672a() {
        return this.f13132b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 2, this.f13131a, false);
        C2835c.m8188a(parcel, 5, this.f13132b, i, false);
        C2835c.m8180a(parcel, a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
        r3 = this;
        r0 = r4 instanceof com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r4 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r4;
        r0 = r3.f13131a;
        r2 = r4.f13131a;
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r3.f13132b;
        if (r0 != 0) goto L_0x001b;
    L_0x0016:
        r4 = r4.f13132b;
        if (r4 != 0) goto L_0x0027;
    L_0x001a:
        goto L_0x0025;
    L_0x001b:
        r0 = r3.f13132b;
        r4 = r4.f13132b;
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0027;
    L_0x0025:
        r4 = 1;
        return r4;
    L_0x0027:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInConfiguration.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return new C2741b().m7798a(this.f13131a).m7798a(this.f13132b).m7797a();
    }
}
