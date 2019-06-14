package com.google.firebase.iid;

import com.google.android.gms.p186f.C2950c;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;

final /* synthetic */ class as implements C2950c {
    /* renamed from: a */
    private final FirebaseInstanceId f24740a;
    /* renamed from: b */
    private final String f24741b;
    /* renamed from: c */
    private final String f24742c;
    /* renamed from: d */
    private final C2955h f24743d;
    /* renamed from: e */
    private final String f24744e;

    as(FirebaseInstanceId firebaseInstanceId, String str, String str2, C2955h c2955h, String str3) {
        this.f24740a = firebaseInstanceId;
        this.f24741b = str;
        this.f24742c = str2;
        this.f24743d = c2955h;
        this.f24744e = str3;
    }

    public final void onComplete(C2954g c2954g) {
        this.f24740a.m22681a(this.f24741b, this.f24742c, this.f24743d, this.f24744e, c2954g);
    }
}
