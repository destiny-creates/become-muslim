package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.u */
abstract class C4888u extends C4789s {
    /* renamed from: b */
    private static final WeakReference<byte[]> f14005b = new WeakReference(null);
    /* renamed from: a */
    private WeakReference<byte[]> f14006a = f14005b;

    C4888u(byte[] bArr) {
        super(bArr);
    }

    /* renamed from: d */
    protected abstract byte[] mo3554d();

    /* renamed from: c */
    final byte[] mo3467c() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f14006a.get();
            if (bArr == null) {
                bArr = mo3554d();
                this.f14006a = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
