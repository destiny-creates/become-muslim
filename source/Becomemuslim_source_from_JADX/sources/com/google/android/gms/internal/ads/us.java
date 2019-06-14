package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class us implements ts {
    /* renamed from: a */
    private static final byte[] f24328a = new byte[0];
    /* renamed from: b */
    private final xk f24329b;
    /* renamed from: c */
    private final ts f24330c;

    public us(xk xkVar, ts tsVar) {
        this.f24329b = xkVar;
        this.f24330c = tsVar;
    }

    /* renamed from: a */
    public final byte[] mo4385a(byte[] bArr, byte[] bArr2) {
        byte[] i = ui.m20155b(this.f24329b).mo6143i();
        byte[] a = this.f24330c.mo4385a(i, f24328a);
        bArr = ((ts) ui.m20151a(this.f24329b.m43711a(), i)).mo4385a(bArr, bArr2);
        return ByteBuffer.allocate((a.length + 4) + bArr.length).putInt(a.length).put(a).put(bArr).array();
    }
}
