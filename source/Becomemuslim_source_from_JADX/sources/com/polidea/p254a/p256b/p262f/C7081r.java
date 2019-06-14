package com.polidea.p254a.p256b.p262f;

/* compiled from: LocationServicesStatusApi23 */
/* renamed from: com.polidea.a.b.f.r */
public class C7081r implements C5607o {
    /* renamed from: a */
    private final C5605i f25057a;
    /* renamed from: b */
    private final C5604g f25058b;
    /* renamed from: c */
    private final boolean f25059c;
    /* renamed from: d */
    private final int f25060d;

    C7081r(C5605i c5605i, C5604g c5604g, int i, boolean z) {
        this.f25057a = c5605i;
        this.f25058b = c5604g;
        this.f25060d = i;
        this.f25059c = z;
    }

    /* renamed from: a */
    public boolean mo5019a() {
        return this.f25058b.m23826a();
    }

    /* renamed from: b */
    public boolean mo5020b() {
        if (m32979c()) {
            if (!this.f25057a.m23827a()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private boolean m32979c() {
        return !this.f25059c && this.f25060d >= 23;
    }
}
