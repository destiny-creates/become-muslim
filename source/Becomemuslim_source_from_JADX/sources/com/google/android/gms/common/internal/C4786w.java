package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.common.internal.w */
public class C4786w extends C4363a {
    public static final Creator<C4786w> CREATOR = new an();
    /* renamed from: a */
    private final int f13238a;
    /* renamed from: b */
    private final Account f13239b;
    /* renamed from: c */
    private final int f13240c;
    /* renamed from: d */
    private final GoogleSignInAccount f13241d;

    C4786w(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f13238a = i;
        this.f13239b = account;
        this.f13240c = i2;
        this.f13241d = googleSignInAccount;
    }

    public C4786w(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    /* renamed from: a */
    public Account m16851a() {
        return this.f13239b;
    }

    /* renamed from: b */
    public int m16852b() {
        return this.f13240c;
    }

    /* renamed from: c */
    public GoogleSignInAccount m16853c() {
        return this.f13241d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13238a);
        C2835c.m8188a(parcel, 2, m16851a(), i, false);
        C2835c.m8184a(parcel, 3, m16852b());
        C2835c.m8188a(parcel, 4, m16853c(), i, false);
        C2835c.m8180a(parcel, a);
    }
}
