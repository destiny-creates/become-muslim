package com.google.android.gms.internal.p210i;

import com.google.android.gms.common.internal.C2872v;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.android.gms.internal.i.bo */
final class bo {
    /* renamed from: a */
    private int f16429a;
    /* renamed from: b */
    private ByteArrayOutputStream f16430b = new ByteArrayOutputStream();
    /* renamed from: c */
    private final /* synthetic */ bn f16431c;

    public bo(bn bnVar) {
        this.f16431c = bnVar;
    }

    /* renamed from: a */
    public final boolean m20343a(bg bgVar) {
        C2872v.a(bgVar);
        if (this.f16429a + 1 > as.m20292g()) {
            return false;
        }
        String a = this.f16431c.m37766a(bgVar, false);
        if (a == null) {
            this.f16431c.m21045l().m37754a(bgVar, "Error formatting hit");
            return true;
        }
        byte[] bytes = a.getBytes();
        int length = bytes.length;
        if (length > as.m20288c()) {
            this.f16431c.m21045l().m37754a(bgVar, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.f16430b.size() > null) {
            length++;
        }
        if (this.f16430b.size() + length > ((Integer) ba.f16401t.m20315a()).intValue()) {
            return false;
        }
        try {
            if (this.f16430b.size() > null) {
                this.f16430b.write(bn.f28806c);
            }
            this.f16430b.write(bytes);
            this.f16429a += 1;
            return true;
        } catch (bg bgVar2) {
            this.f16431c.m21037e("Failed to write payload when batching hits", bgVar2);
            return true;
        }
    }

    /* renamed from: a */
    public final int m20342a() {
        return this.f16429a;
    }

    /* renamed from: b */
    public final byte[] m20344b() {
        return this.f16430b.toByteArray();
    }
}
