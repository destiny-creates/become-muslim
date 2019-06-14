package com.google.android.gms.internal.ads;

final class bcn implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ bcl f15218a;
    /* renamed from: b */
    private final /* synthetic */ bcm f15219b;

    bcn(bcm bcm, bcl bcl) {
        this.f15219b = bcm;
        this.f15218a = bcl;
    }

    public final void run() {
        synchronized (this.f15219b.f23907i) {
            if (this.f15219b.f23917s != -2) {
                return;
            }
            this.f15219b.f23916r = this.f15219b.m30450d();
            if (this.f15219b.f23916r == null) {
                this.f15219b.mo4097a(4);
            } else if (!this.f15219b.m30452e() || this.f15219b.m30447b(1)) {
                this.f15218a.m37270a(this.f15219b);
                this.f15219b.m30441a(this.f15218a);
            } else {
                String f = this.f15219b.f23899a;
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(f).length() + 56);
                stringBuilder.append("Ignoring adapter ");
                stringBuilder.append(f);
                stringBuilder.append(" as delayed impression is not supported");
                mt.m19924e(stringBuilder.toString());
                this.f15219b.mo4097a(2);
            }
        }
    }
}
