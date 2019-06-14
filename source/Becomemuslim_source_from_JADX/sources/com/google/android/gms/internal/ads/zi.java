package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public final class zi implements ue {
    /* renamed from: a */
    private Mac f24414a;
    /* renamed from: b */
    private final int f24415b;
    /* renamed from: c */
    private final String f24416c;
    /* renamed from: d */
    private final Key f24417d;

    public zi(String str, Key key, int i) {
        if (i >= 10) {
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873) {
                        if (str.equals("HMACSHA512")) {
                            obj = 2;
                        }
                    }
                } else if (str.equals("HMACSHA256")) {
                    obj = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                obj = null;
            }
            switch (obj) {
                case null:
                    if (i > 20) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                    break;
                case 1:
                    if (i <= 32) {
                        break;
                    }
                    throw new InvalidAlgorithmParameterException("tag size too big");
                case 2:
                    if (i <= 64) {
                        break;
                    }
                    throw new InvalidAlgorithmParameterException("tag size too big");
                default:
                    String str2 = "unknown Hmac algorithm: ";
                    str = String.valueOf(str);
                    throw new NoSuchAlgorithmException(str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            this.f24416c = str;
            this.f24415b = i;
            this.f24417d = key;
            this.f24414a = (Mac) yw.f16112b.m20184a(str);
            this.f24414a.init(key);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    /* renamed from: a */
    public final byte[] mo4393a(byte[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f24414a;	 Catch:{ CloneNotSupportedException -> 0x0009 }
        r0 = r0.clone();	 Catch:{ CloneNotSupportedException -> 0x0009 }
        r0 = (javax.crypto.Mac) r0;	 Catch:{ CloneNotSupportedException -> 0x0009 }
        goto L_0x0018;
    L_0x0009:
        r0 = com.google.android.gms.internal.ads.yw.f16112b;
        r1 = r3.f24416c;
        r0 = r0.m20184a(r1);
        r0 = (javax.crypto.Mac) r0;
        r1 = r3.f24417d;
        r0.init(r1);
    L_0x0018:
        r0.update(r4);
        r4 = r3.f24415b;
        r4 = new byte[r4];
        r0 = r0.doFinal();
        r1 = r3.f24415b;
        r2 = 0;
        java.lang.System.arraycopy(r0, r2, r4, r2, r1);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zi.a(byte[]):byte[]");
    }
}
