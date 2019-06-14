package com.google.android.gms.internal.ads;

import java.security.interfaces.ECPrivateKey;

public final class ym implements ty {
    /* renamed from: a */
    private static final byte[] f24398a = new byte[0];
    /* renamed from: b */
    private final ECPrivateKey f24399b;
    /* renamed from: c */
    private final yo f24400c;
    /* renamed from: d */
    private final String f24401d;
    /* renamed from: e */
    private final byte[] f24402e;
    /* renamed from: f */
    private final yu f24403f;
    /* renamed from: g */
    private final yl f24404g;

    public ym(ECPrivateKey eCPrivateKey, byte[] bArr, String str, yu yuVar, yl ylVar) {
        this.f24399b = eCPrivateKey;
        this.f24400c = new yo(eCPrivateKey);
        this.f24402e = bArr;
        this.f24401d = str;
        this.f24403f = yuVar;
        this.f24404g = ylVar;
    }
}
