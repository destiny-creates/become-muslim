package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.C2603a;

@cm
public class apj extends C2603a {
    /* renamed from: a */
    private final Object f23788a = new Object();
    /* renamed from: b */
    private C2603a f23789b;

    /* renamed from: a */
    public final void m30073a(C2603a c2603a) {
        synchronized (this.f23788a) {
            this.f23789b = c2603a;
        }
    }

    public void onAdClosed() {
        synchronized (this.f23788a) {
            if (this.f23789b != null) {
                this.f23789b.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.f23788a) {
            if (this.f23789b != null) {
                this.f23789b.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f23788a) {
            if (this.f23789b != null) {
                this.f23789b.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.f23788a) {
            if (this.f23789b != null) {
                this.f23789b.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.f23788a) {
            if (this.f23789b != null) {
                this.f23789b.onAdOpened();
            }
        }
    }
}
