package com.google.android.exoplayer2.p136c;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
/* compiled from: FrameworkMediaCrypto */
/* renamed from: com.google.android.exoplayer2.c.e */
public final class C4088e implements C2259d {
    /* renamed from: a */
    private final MediaCrypto f10336a;
    /* renamed from: b */
    private final boolean f10337b;

    /* renamed from: a */
    public MediaCrypto m12778a() {
        return this.f10336a;
    }

    /* renamed from: a */
    public boolean m12779a(String str) {
        return (this.f10337b || this.f10336a.requiresSecureDecoderComponent(str) == null) ? null : true;
    }
}
