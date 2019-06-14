package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.C4876i;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2853f;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.auth.api.f */
final class C4751f extends C4337a<C4876i, GoogleSignInOptions> {
    C4751f() {
    }

    /* renamed from: a */
    public final /* synthetic */ C4340f mo3263a(Context context, Looper looper, C2853f c2853f, Object obj, C2775b c2775b, C2776c c2776c) {
        return new C4876i(context, looper, c2853f, (GoogleSignInOptions) obj, c2775b, c2776c);
    }

    /* renamed from: a */
    public final /* synthetic */ List mo3264a(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        if (googleSignInOptions == null) {
            return Collections.emptyList();
        }
        return googleSignInOptions.m17455a();
    }
}
