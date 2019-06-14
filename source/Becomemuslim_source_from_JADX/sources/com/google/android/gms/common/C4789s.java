package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ax;
import com.google.android.gms.common.internal.ay;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.Arrays;

/* renamed from: com.google.android.gms.common.s */
abstract class C4789s extends ay {
    /* renamed from: a */
    private int f13251a;

    protected C4789s(byte[] bArr) {
        C2872v.m8390b(bArr.length == 25);
        this.f13251a = Arrays.hashCode(bArr);
    }

    /* renamed from: c */
    abstract byte[] mo3467c();

    public int hashCode() {
        return this.f13251a;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof ax) {
                try {
                    ax axVar = (ax) obj;
                    if (axVar.mo2470b() != hashCode()) {
                        return false;
                    }
                    C2758b a = axVar.mo2469a();
                    if (a == null) {
                        return false;
                    }
                    return Arrays.equals(mo3467c(), (byte[]) C4757d.m16685a(a));
                } catch (Object obj2) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", obj2);
                    return false;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public final C2758b mo2469a() {
        return C4757d.m16684a(mo3467c());
    }

    /* renamed from: b */
    public final int mo2470b() {
        return hashCode();
    }

    /* renamed from: a */
    protected static byte[] m16861a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (String str2) {
            throw new AssertionError(str2);
        }
    }
}
