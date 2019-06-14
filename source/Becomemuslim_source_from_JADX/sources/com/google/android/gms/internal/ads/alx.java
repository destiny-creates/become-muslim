package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;

final class alx {
    /* renamed from: a */
    private ByteArrayOutputStream f14744a = new ByteArrayOutputStream(4096);
    /* renamed from: b */
    private Base64OutputStream f14745b = new Base64OutputStream(this.f14744a, 10);

    /* renamed from: a */
    public final void m18617a(byte[] bArr) {
        this.f14745b.write(bArr);
    }

    public final String toString() {
        String byteArrayOutputStream;
        try {
            this.f14745b.close();
        } catch (Throwable e) {
            mt.m19919b("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.f14744a.close();
            byteArrayOutputStream = this.f14744a.toString();
        } catch (Throwable e2) {
            mt.m19919b("HashManager: Unable to convert to Base64.", e2);
            byteArrayOutputStream = "";
        } catch (Throwable th) {
            this.f14744a = null;
            this.f14745b = null;
        }
        this.f14744a = null;
        this.f14745b = null;
        return byteArrayOutputStream;
    }
}
