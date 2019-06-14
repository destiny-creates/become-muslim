package com.google.android.gms.internal.ads;

import android.content.Context;

@cm
public final class bbx {
    /* renamed from: a */
    private static final lb<bac> f15170a = new bby();
    /* renamed from: b */
    private static final lb<bac> f15171b = new bbz();
    /* renamed from: c */
    private final bao f15172c;

    public bbx(Context context, mv mvVar, String str) {
        this.f15172c = new bao(context, mvVar, str, f15170a, f15171b);
    }

    /* renamed from: a */
    public final <I, O> bbp<I, O> m19215a(String str, bbs<I> bbs, bbr<O> bbr) {
        return new bca(this.f15172c, str, bbs, bbr);
    }
}
