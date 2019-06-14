package org.spongycastle.crypto.prng;

public class ThreadedSeedGenerator {

    private class SeedGenerator implements Runnable {
        /* renamed from: a */
        private volatile int f22441a;
        /* renamed from: b */
        private volatile boolean f22442b;

        public void run() {
            while (!this.f22442b) {
                this.f22441a++;
            }
        }
    }
}
