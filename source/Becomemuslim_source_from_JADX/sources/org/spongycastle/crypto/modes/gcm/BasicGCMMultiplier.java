package org.spongycastle.crypto.modes.gcm;

public class BasicGCMMultiplier implements GCMMultiplier {
    /* renamed from: a */
    private int[] f27055a;

    /* renamed from: a */
    public void mo5781a(byte[] bArr) {
        this.f27055a = GCMUtil.m27486a(bArr);
    }

    /* renamed from: b */
    public void mo5782b(byte[] bArr) {
        int[] a = GCMUtil.m27486a(bArr);
        GCMUtil.m27483a(a, this.f27055a);
        GCMUtil.m27482a(a, bArr);
    }
}
