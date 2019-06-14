package com.polidea.p254a.p256b.p260d;

import com.polidea.p254a.p255a.C6975n;
import com.polidea.p254a.p256b.p262f.C5607o;
import com.polidea.p254a.p256b.p262f.C5610w;

/* compiled from: ScanPreconditionsVerifierApi18 */
/* renamed from: com.polidea.a.b.d.j */
public class C7042j implements C5589i {
    /* renamed from: a */
    final C5610w f24996a;
    /* renamed from: b */
    final C5607o f24997b;

    public C7042j(C5610w c5610w, C5607o c5607o) {
        this.f24996a = c5610w;
        this.f24997b = c5607o;
    }

    /* renamed from: a */
    public void mo5009a() {
        if (!this.f24996a.m23839a()) {
            throw new C6975n(2);
        } else if (!this.f24996a.m23842b()) {
            throw new C6975n(1);
        } else if (!this.f24997b.mo5019a()) {
            throw new C6975n(3);
        } else if (!this.f24997b.mo5020b()) {
            throw new C6975n(4);
        }
    }
}
