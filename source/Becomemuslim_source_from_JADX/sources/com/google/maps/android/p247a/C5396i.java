package com.google.maps.android.p247a;

import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.C7854q;
import com.google.android.gms.maps.model.C7855s;
import java.util.Observable;

/* compiled from: Style */
/* renamed from: com.google.maps.android.a.i */
public abstract class C5396i extends Observable {
    /* renamed from: a */
    protected C7851m f18188a = new C7851m();
    /* renamed from: b */
    protected C7855s f18189b = new C7855s();
    /* renamed from: c */
    protected C7854q f18190c = new C7854q();

    /* renamed from: a */
    public float mo4898a() {
        return this.f18188a.m38335j();
    }

    /* renamed from: a */
    public void m22939a(float f) {
        this.f18188a.m38321b(f);
    }

    /* renamed from: a */
    public void m22940a(float f, float f2, String str, String str2) {
        if (str.equals("fraction") == null) {
            f = 0.5f;
        }
        if (str2.equals("fraction") == null) {
            f2 = 1.0f;
        }
        this.f18188a.m38316a(f, f2);
    }

    /* renamed from: b */
    public void m22942b(float f) {
        this.f18189b.m38358a(f);
    }

    /* renamed from: c */
    public void m22943c(float f) {
        this.f18190c.m38340a(f);
    }

    /* renamed from: a */
    public void m22941a(int i) {
        this.f18190c.m38347b(i);
    }
}
