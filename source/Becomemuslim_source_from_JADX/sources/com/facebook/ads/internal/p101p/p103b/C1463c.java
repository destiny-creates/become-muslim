package com.facebook.ads.internal.p101p.p103b;

import com.facebook.ads.internal.p101p.p103b.p104a.C1455a;
import com.facebook.ads.internal.p101p.p103b.p104a.C1456c;
import java.io.File;

/* renamed from: com.facebook.ads.internal.p.b.c */
class C1463c {
    /* renamed from: a */
    public final File f4313a;
    /* renamed from: b */
    public final C1456c f4314b;
    /* renamed from: c */
    public final C1455a f4315c;

    C1463c(File file, C1456c c1456c, C1455a c1455a) {
        this.f4313a = file;
        this.f4314b = c1456c;
        this.f4315c = c1455a;
    }

    /* renamed from: a */
    File m5174a(String str) {
        return new File(this.f4313a, this.f4314b.mo989a(str));
    }
}
