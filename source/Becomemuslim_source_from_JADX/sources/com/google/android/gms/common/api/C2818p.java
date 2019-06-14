package com.google.android.gms.common.api;

import com.google.android.gms.common.C4776d;

/* renamed from: com.google.android.gms.common.api.p */
public final class C2818p extends UnsupportedOperationException {
    /* renamed from: a */
    private final C4776d f7217a;

    public C2818p(C4776d c4776d) {
        this.f7217a = c4776d;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.f7217a);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 8);
        stringBuilder.append("Missing ");
        stringBuilder.append(valueOf);
        return stringBuilder.toString();
    }
}
