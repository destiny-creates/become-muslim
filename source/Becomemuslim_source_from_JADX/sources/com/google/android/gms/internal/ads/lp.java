package com.google.android.gms.internal.ads;

import java.util.Map;

public final class lp extends awi<aug> {
    /* renamed from: a */
    private final nz<aug> f24153a;
    /* renamed from: b */
    private final Map<String, String> f24154b;
    /* renamed from: c */
    private final mm f24155c;

    public lp(String str, nz<aug> nzVar) {
        this(str, null, nzVar);
    }

    private lp(String str, Map<String, String> map, nz<aug> nzVar) {
        super(0, str, new lq(nzVar));
        this.f24154b = null;
        this.f24153a = nzVar;
        this.f24155c = new mm();
        this.f24155c.m19907a(str, "GET", null, null);
    }

    /* renamed from: a */
    protected final bck<aug> mo4314a(aug aug) {
        return bck.m19231a(aug, oq.m19972a(aug));
    }

    /* renamed from: a */
    protected final /* synthetic */ void mo4315a(Object obj) {
        aug aug = (aug) obj;
        this.f24155c.m19910a(aug.f15006c, aug.f15004a);
        mm mmVar = this.f24155c;
        byte[] bArr = aug.f15005b;
        if (mm.m19905c() && bArr != null) {
            mmVar.m19911a(bArr);
        }
        this.f24153a.m30915b(aug);
    }
}
