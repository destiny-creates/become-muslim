package com.google.android.exoplayer2.p149h.p153c;

import android.net.Uri;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2500i;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2516a;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Aes128DataSource */
/* renamed from: com.google.android.exoplayer2.h.c.a */
final class C4195a implements C2498g {
    /* renamed from: a */
    private final C2498g f10975a;
    /* renamed from: b */
    private final byte[] f10976b;
    /* renamed from: c */
    private final byte[] f10977c;
    /* renamed from: d */
    private CipherInputStream f10978d;

    public C4195a(C2498g c2498g, byte[] bArr, byte[] bArr2) {
        this.f10975a = c2498g;
        this.f10976b = bArr;
        this.f10977c = bArr2;
    }

    /* renamed from: a */
    public long mo2268a(C2501j c2501j) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.f10976b, "AES"), new IvParameterSpec(this.f10977c));
                this.f10978d = new CipherInputStream(new C2500i(this.f10975a, c2501j), instance);
                return -1;
            } catch (C2501j c2501j2) {
                throw new RuntimeException(c2501j2);
            }
        } catch (C2501j c2501j22) {
            throw new RuntimeException(c2501j22);
        }
    }

    /* renamed from: b */
    public void mo2270b() {
        this.f10978d = null;
        this.f10975a.mo2270b();
    }

    /* renamed from: a */
    public int mo2267a(byte[] bArr, int i, int i2) {
        C2516a.m7019b(this.f10978d != null);
        bArr = this.f10978d.read(bArr, i, i2);
        return bArr < null ? -1 : bArr;
    }

    /* renamed from: a */
    public Uri mo2269a() {
        return this.f10975a.mo2269a();
    }
}
