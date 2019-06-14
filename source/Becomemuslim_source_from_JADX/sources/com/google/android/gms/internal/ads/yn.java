package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.interfaces.ECPublicKey;

public final class yn implements tz {
    /* renamed from: a */
    private static final byte[] f24405a = new byte[0];
    /* renamed from: b */
    private final yp f24406b;
    /* renamed from: c */
    private final String f24407c;
    /* renamed from: d */
    private final byte[] f24408d;
    /* renamed from: e */
    private final yu f24409e;
    /* renamed from: f */
    private final yl f24410f;

    public yn(ECPublicKey eCPublicKey, byte[] bArr, String str, yu yuVar, yl ylVar) {
        yr.m20180a(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.f24406b = new yp(eCPublicKey);
        this.f24408d = bArr;
        this.f24407c = str;
        this.f24409e = yuVar;
        this.f24410f = ylVar;
    }

    /* renamed from: a */
    public final byte[] mo4387a(byte[] bArr, byte[] bArr2) {
        yq a = this.f24406b.m20172a(this.f24407c, this.f24408d, bArr2, this.f24410f.mo4388a(), this.f24409e);
        bArr = this.f24410f.mo4389a(a.m20174b()).mo4385a(bArr, f24405a);
        bArr2 = a.m20173a();
        return ByteBuffer.allocate(bArr2.length + bArr.length).put(bArr2).put(bArr).array();
    }
}
