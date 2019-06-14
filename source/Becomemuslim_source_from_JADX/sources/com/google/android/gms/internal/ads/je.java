package com.google.android.gms.internal.ads;

import java.math.BigInteger;

@cm
public final class je {
    /* renamed from: a */
    private BigInteger f15653a = BigInteger.ONE;

    /* renamed from: a */
    public final synchronized String m19598a() {
        String bigInteger;
        bigInteger = this.f15653a.toString();
        this.f15653a = this.f15653a.add(BigInteger.ONE);
        return bigInteger;
    }
}
