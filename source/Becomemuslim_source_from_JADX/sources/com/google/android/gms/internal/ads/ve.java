package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.vn.C8286a;
import com.google.android.gms.internal.ads.wa.C8292a;
import com.google.android.gms.internal.ads.wz.C8301a;
import java.security.GeneralSecurityException;
import java.util.Arrays;

final class ve implements yl {
    /* renamed from: a */
    private final String f24334a;
    /* renamed from: b */
    private final int f24335b;
    /* renamed from: c */
    private wa f24336c;
    /* renamed from: d */
    private vj f24337d;
    /* renamed from: e */
    private int f24338e;

    ve(xk xkVar) {
        this.f24334a = xkVar.m43711a();
        if (this.f24334a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                wc a = wc.m43591a(xkVar.m43712b());
                this.f24336c = (wa) ui.m20155b(xkVar);
                this.f24335b = a.m43593a();
            } catch (Throwable e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.f24334a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                vl a2 = vl.m43522a(xkVar.m43712b());
                this.f24337d = (vj) ui.m20155b(xkVar);
                this.f24338e = a2.m43524a().m43549b();
                this.f24335b = this.f24338e + a2.m43526b().m43686b();
            } catch (Throwable e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        } else {
            String str = "unsupported AEAD DEM key type: ";
            String valueOf = String.valueOf(this.f24334a);
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    /* renamed from: a */
    public final int mo4388a() {
        return this.f24335b;
    }

    /* renamed from: a */
    public final ts mo4389a(byte[] bArr) {
        if (bArr.length == this.f24335b) {
            acx acx;
            if (this.f24334a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                acx = (wa) ((C8292a) wa.m43586c().m42158a(this.f24336c)).m43580a(aai.m17832a(bArr, 0, this.f24335b)).m42162c();
            } else if (this.f24334a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.f24338e);
                wz wzVar = (wz) ((C8301a) wz.m43674d().m42158a(this.f24337d.m43521c())).m43665a(aai.m17831a(Arrays.copyOfRange(bArr, this.f24338e, this.f24335b))).m42162c();
                vj vjVar = (vj) vj.m43516d().m43506a(this.f24337d.m43518a()).m43507a((vn) ((C8286a) vn.m43537d().m42158a(this.f24337d.m43520b())).m43528a(aai.m17831a(copyOfRange)).m42162c()).m43508a(wzVar).m42162c();
            } else {
                throw new GeneralSecurityException("unknown DEM key type");
            }
            return (ts) ui.m20157b(this.f24334a, acx);
        }
        throw new GeneralSecurityException("Symmetric key has incorrect length");
    }
}
