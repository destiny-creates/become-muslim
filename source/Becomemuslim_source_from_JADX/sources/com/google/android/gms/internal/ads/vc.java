package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class vc {
    /* renamed from: a */
    public static yt m20162a(wu wuVar) {
        switch (vd.f16063b[wuVar.ordinal()]) {
            case 1:
                return yt.NIST_P256;
            case 2:
                return yt.NIST_P384;
            case 3:
                return yt.NIST_P521;
            default:
                String valueOf = String.valueOf(wuVar);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 20);
                stringBuilder.append("unknown curve type: ");
                stringBuilder.append(valueOf);
                throw new GeneralSecurityException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static yu m20163a(wg wgVar) {
        switch (vd.f16064c[wgVar.ordinal()]) {
            case 1:
                return yu.UNCOMPRESSED;
            case 2:
                return yu.COMPRESSED;
            default:
                String valueOf = String.valueOf(wgVar);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 22);
                stringBuilder.append("unknown point format: ");
                stringBuilder.append(valueOf);
                throw new GeneralSecurityException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static String m20164a(wx wxVar) {
        switch (vd.f16062a[wxVar.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(wxVar);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 27);
                stringBuilder.append("hash unsupported for HMAC: ");
                stringBuilder.append(valueOf);
                throw new NoSuchAlgorithmException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static void m20165a(wm wmVar) {
        yr.m20178a(m20162a(wmVar.m43617a().m43660a()));
        m20164a(wmVar.m43617a().m43662b());
        if (wmVar.m43620c() != wg.UNKNOWN_FORMAT) {
            ui.m20149a(wmVar.m43619b().m43609a());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }
}
