package com.google.android.gms.internal.ads;

import java.util.Map;

final class ll extends uu {
    /* renamed from: a */
    private final /* synthetic */ byte[] f28704a;
    /* renamed from: b */
    private final /* synthetic */ Map f28705b;
    /* renamed from: c */
    private final /* synthetic */ mm f28706c;

    ll(lg lgVar, int i, String str, bee bee, bdl bdl, byte[] bArr, Map map, mm mmVar) {
        this.f28704a = bArr;
        this.f28705b = map;
        this.f28706c = mmVar;
        super(i, str, bee, bdl);
    }

    /* renamed from: a */
    protected final /* synthetic */ void mo4315a(Object obj) {
        mo6107a((String) obj);
    }

    /* renamed from: a */
    protected final void mo6107a(String str) {
        this.f28706c.m19906a(str);
        super.mo6107a(str);
    }

    /* renamed from: a */
    public final byte[] mo6108a() {
        return this.f28704a == null ? super.mo6108a() : this.f28704a;
    }

    /* renamed from: b */
    public final Map<String, String> mo6109b() {
        return this.f28705b == null ? super.mo6109b() : this.f28705b;
    }
}
