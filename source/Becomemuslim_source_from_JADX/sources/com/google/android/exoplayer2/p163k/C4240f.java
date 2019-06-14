package com.google.android.exoplayer2.p163k;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.C2571p;
import java.net.URLDecoder;

/* compiled from: DataSchemeDataSource */
/* renamed from: com.google.android.exoplayer2.k.f */
public final class C4240f implements C2498g {
    /* renamed from: a */
    private C2501j f11173a;
    /* renamed from: b */
    private int f11174b;
    /* renamed from: c */
    private byte[] f11175c;

    /* renamed from: a */
    public long mo2268a(C2501j c2501j) {
        this.f11173a = c2501j;
        c2501j = c2501j.f6349a;
        String scheme = c2501j.getScheme();
        if ("data".equals(scheme)) {
            String[] split = c2501j.getSchemeSpecificPart().split(",");
            if (split.length <= 2) {
                c2501j = split[1];
                if (split[0].contains(";base64")) {
                    try {
                        this.f11175c = Base64.decode(c2501j, 0);
                    } catch (Throwable e) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Error while parsing Base64 encoded string: ");
                        stringBuilder.append(c2501j);
                        throw new C2571p(stringBuilder.toString(), e);
                    }
                }
                this.f11175c = URLDecoder.decode(c2501j, "US-ASCII").getBytes();
                return (long) this.f11175c.length;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unexpected URI format: ");
            stringBuilder2.append(c2501j);
            throw new C2571p(stringBuilder2.toString());
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unsupported scheme: ");
        stringBuilder2.append(scheme);
        throw new C2571p(stringBuilder2.toString());
    }

    /* renamed from: a */
    public int mo2267a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        int length = this.f11175c.length - this.f11174b;
        if (length == 0) {
            return -1;
        }
        i2 = Math.min(i2, length);
        System.arraycopy(this.f11175c, this.f11174b, bArr, i, i2);
        this.f11174b += i2;
        return i2;
    }

    /* renamed from: a */
    public Uri mo2269a() {
        return this.f11173a != null ? this.f11173a.f6349a : null;
    }

    /* renamed from: b */
    public void mo2270b() {
        this.f11173a = null;
        this.f11175c = null;
    }
}
