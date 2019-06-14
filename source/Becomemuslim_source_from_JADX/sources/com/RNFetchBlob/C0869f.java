package com.RNFetchBlob;

/* compiled from: RNFetchBlobProgressConfig */
/* renamed from: com.RNFetchBlob.f */
public class C0869f {
    /* renamed from: a */
    long f2428a = 0;
    /* renamed from: b */
    int f2429b = 0;
    /* renamed from: c */
    int f2430c = -1;
    /* renamed from: d */
    public int f2431d = -1;
    /* renamed from: e */
    public boolean f2432e = false;
    /* renamed from: f */
    public C0868a f2433f = C0868a.Download;

    /* compiled from: RNFetchBlobProgressConfig */
    /* renamed from: com.RNFetchBlob.f$a */
    public enum C0868a {
        Upload,
        Download
    }

    C0869f(boolean z, int i, int i2, C0868a c0868a) {
        this.f2432e = z;
        this.f2431d = i;
        this.f2433f = c0868a;
        this.f2430c = i2;
    }

    /* renamed from: a */
    public boolean m3104a(float f) {
        boolean z = false;
        if (this.f2430c > 0 && f > 0.0f) {
            if (Math.floor((double) (f * ((float) this.f2430c))) <= ((double) this.f2429b)) {
                f = 0.0f;
                if (System.currentTimeMillis() - this.f2428a > ((long) this.f2431d) && this.f2432e && r8 != null) {
                    z = true;
                }
                if (z) {
                    this.f2429b++;
                    this.f2428a = System.currentTimeMillis();
                }
                return z;
            }
        }
        f = Float.MIN_VALUE;
        z = true;
        if (z) {
            this.f2429b++;
            this.f2428a = System.currentTimeMillis();
        }
        return z;
    }
}
