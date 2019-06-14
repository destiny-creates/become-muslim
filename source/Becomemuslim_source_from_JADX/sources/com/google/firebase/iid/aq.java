package com.google.firebase.iid;

import com.google.android.gms.p186f.C2955h;

final /* synthetic */ class aq implements Runnable {
    /* renamed from: a */
    private final FirebaseInstanceId f18084a;
    /* renamed from: b */
    private final String f18085b;
    /* renamed from: c */
    private final String f18086c;
    /* renamed from: d */
    private final C2955h f18087d;
    /* renamed from: e */
    private final String f18088e;

    aq(FirebaseInstanceId firebaseInstanceId, String str, String str2, C2955h c2955h, String str3) {
        this.f18084a = firebaseInstanceId;
        this.f18085b = str;
        this.f18086c = str2;
        this.f18087d = c2955h;
        this.f18088e = str3;
    }

    public final void run() {
        this.f18084a.m22680a(this.f18085b, this.f18086c, this.f18087d, this.f18088e);
    }
}
