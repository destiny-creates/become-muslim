package com.google.android.exoplayer2.p137e.p140d;

import android.util.Log;
import com.google.android.exoplayer2.p137e.C2329m.C2328a;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: TrackEncryptionBox */
/* renamed from: com.google.android.exoplayer2.e.d.k */
public final class C2286k {
    /* renamed from: a */
    public final boolean f5584a;
    /* renamed from: b */
    public final String f5585b;
    /* renamed from: c */
    public final C2328a f5586c;
    /* renamed from: d */
    public final int f5587d;
    /* renamed from: e */
    public final byte[] f5588e;

    public C2286k(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4 = 0;
        int i5 = i == 0 ? 1 : 0;
        if (bArr2 == null) {
            i4 = 1;
        }
        C2516a.m7017a(i4 ^ i5);
        this.f5584a = z;
        this.f5585b = str;
        this.f5587d = i;
        this.f5588e = bArr2;
        this.f5586c = new C2328a(C2286k.m6324a(str), bArr, i2, i3);
    }

    /* renamed from: a */
    private static int m6324a(String str) {
        if (str == null) {
            return 1;
        }
        Object obj = -1;
        int hashCode = str.hashCode();
        if (hashCode != 3046605) {
            if (hashCode != 3046671) {
                if (hashCode != 3049879) {
                    if (hashCode == 3049895) {
                        if (str.equals("cens")) {
                            obj = 1;
                        }
                    }
                } else if (str.equals("cenc")) {
                    obj = null;
                }
            } else if (str.equals("cbcs")) {
                obj = 3;
            }
        } else if (str.equals("cbc1")) {
            obj = 2;
        }
        switch (obj) {
            case null:
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported protection scheme type '");
                stringBuilder.append(str);
                stringBuilder.append("'. Assuming AES-CTR ");
                stringBuilder.append("crypto mode.");
                Log.w("TrackEncryptionBox", stringBuilder.toString());
                return 1;
        }
    }
}
