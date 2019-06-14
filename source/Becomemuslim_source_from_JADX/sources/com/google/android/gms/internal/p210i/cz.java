package com.google.android.gms.internal.p210i;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.cz */
public final class cz {
    /* renamed from: a */
    private final Map<String, ct> f16469a;
    /* renamed from: b */
    private final ct f16470b;

    private cz(Map<String, ct> map, ct ctVar) {
        this.f16469a = map;
        this.f16470b = ctVar;
    }

    /* renamed from: a */
    public static da m20406a() {
        return new da();
    }

    /* renamed from: a */
    public final void m20407a(String str, ct ctVar) {
        this.f16469a.put(str, ctVar);
    }

    /* renamed from: b */
    public final Map<String, ct> m20408b() {
        return Collections.unmodifiableMap(this.f16469a);
    }

    /* renamed from: c */
    public final ct m20409c() {
        return this.f16470b;
    }

    public final String toString() {
        String valueOf = String.valueOf(Collections.unmodifiableMap(this.f16469a));
        String valueOf2 = String.valueOf(this.f16470b);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length());
        stringBuilder.append("Properties: ");
        stringBuilder.append(valueOf);
        stringBuilder.append(" pushAfterEvaluate: ");
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }
}
