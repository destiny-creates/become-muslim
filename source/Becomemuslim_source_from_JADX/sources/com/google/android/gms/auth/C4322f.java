package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.p178b.C2823a;
import com.google.android.gms.internal.p204c.C4947f;
import com.google.android.gms.internal.p204c.C6778k;
import java.io.IOException;

/* renamed from: com.google.android.gms.auth.f */
final class C4322f implements C2754h<TokenData> {
    /* renamed from: a */
    private final /* synthetic */ Account f11370a;
    /* renamed from: b */
    private final /* synthetic */ String f11371b;
    /* renamed from: c */
    private final /* synthetic */ Bundle f11372c;

    C4322f(Account account, String str, Bundle bundle) {
        this.f11370a = account;
        this.f11371b = str;
        this.f11372c = bundle;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo2368a(IBinder iBinder) {
        Bundle bundle = (Bundle) C2753e.m7843b(C6778k.a(iBinder).a(this.f11370a, this.f11371b, this.f11372c));
        TokenData a = TokenData.m16647a(bundle, "tokenDetails");
        if (a != null) {
            return a;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        C4947f a2 = C4947f.a(string);
        int i = 0;
        if (C4947f.a(a2)) {
            C2823a a3 = C2753e.f7048e;
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(a2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 31);
            stringBuilder.append("isUserRecoverableError status: ");
            stringBuilder.append(valueOf);
            objArr[0] = stringBuilder.toString();
            a3.m8116c("GoogleAuthUtil", objArr);
            throw new C4321d(string, intent);
        }
        if (!(C4947f.f16169b.equals(a2) == null && C4947f.f16170c.equals(a2) == null && C4947f.f16171d.equals(a2) == null)) {
            i = 1;
        }
        if (i != 0) {
            throw new IOException(string);
        }
        throw new C2727a(string);
    }
}
