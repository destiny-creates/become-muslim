package com.polidea.p254a.p256b;

import java.util.UUID;

/* compiled from: BleIllegalOperationException */
/* renamed from: com.polidea.a.b.a */
public class C5560a extends RuntimeException {
    /* renamed from: a */
    public final UUID f18635a;
    /* renamed from: b */
    public final int f18636b;
    /* renamed from: c */
    public final int f18637c;

    public C5560a(String str, UUID uuid, int i, int i2) {
        super(str);
        this.f18635a = uuid;
        this.f18636b = i;
        this.f18637c = i2;
    }
}
