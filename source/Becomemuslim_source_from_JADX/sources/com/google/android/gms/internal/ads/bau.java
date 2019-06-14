package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class bau implements ae<bbl> {
    /* renamed from: a */
    private final /* synthetic */ ahi f23874a;
    /* renamed from: b */
    private final /* synthetic */ bac f23875b;
    /* renamed from: c */
    private final /* synthetic */ ly f23876c;
    /* renamed from: d */
    private final /* synthetic */ bao f23877d;

    bau(bao bao, ahi ahi, bac bac, ly lyVar) {
        this.f23877d = bao;
        this.f23874a = ahi;
        this.f23875b = bac;
        this.f23876c = lyVar;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        synchronized (this.f23877d.f15139a) {
            mt.m19922d("JS Engine is requesting an update");
            if (this.f23877d.f15146h == 0) {
                mt.m19922d("Starting reload.");
                this.f23877d.f15146h = 2;
                this.f23877d.m19204a(this.f23874a);
            }
            this.f23875b.mo6656b("/requestReload", (ae) this.f23876c.m19843a());
        }
    }
}
