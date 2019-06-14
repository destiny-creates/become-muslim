package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C4521a;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p057a.C4523c;
import com.p050a.p051a.p056c.p057a.C4524d;
import com.p050a.p051a.p056c.p057a.C4525f;
import com.p050a.p051a.p056c.p057a.C4526g;
import com.p050a.p051a.p056c.p057a.C4527h;
import com.p050a.p051a.p056c.p057a.C4528j;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0950a;
import java.util.List;

/* compiled from: AnimatableValueParser */
/* renamed from: com.a.a.d.d */
public class C0924d {
    /* renamed from: a */
    public static C4522b m3245a(JsonReader jsonReader, C0954f c0954f) {
        return C0924d.m3246a(jsonReader, c0954f, true);
    }

    /* renamed from: a */
    public static C4522b m3246a(JsonReader jsonReader, C0954f c0954f, boolean z) {
        return new C4522b(C0924d.m3248a(jsonReader, z ? C0948f.m3313a() : true, c0954f, C3387j.f9019a));
    }

    /* renamed from: b */
    static C4524d m3250b(JsonReader jsonReader, C0954f c0954f) {
        return new C4524d(C0924d.m3249a(jsonReader, c0954f, C3389p.f9021a));
    }

    /* renamed from: c */
    static C4525f m3251c(JsonReader jsonReader, C0954f c0954f) {
        return new C4525f(C0924d.m3248a(jsonReader, C0948f.m3313a(), c0954f, C3391z.f9023a));
    }

    /* renamed from: d */
    static C4526g m3252d(JsonReader jsonReader, C0954f c0954f) {
        return new C4526g(C0924d.m3249a(jsonReader, c0954f, ad.f9014a));
    }

    /* renamed from: e */
    static C4527h m3253e(JsonReader jsonReader, C0954f c0954f) {
        return new C4527h(C0924d.m3248a(jsonReader, C0948f.m3313a(), c0954f, ae.f9015a));
    }

    /* renamed from: f */
    static C4528j m3254f(JsonReader jsonReader, C0954f c0954f) {
        return new C4528j(C0924d.m3249a(jsonReader, c0954f, C3386i.f9018a));
    }

    /* renamed from: g */
    static C4521a m3255g(JsonReader jsonReader, C0954f c0954f) {
        return new C4521a(C0924d.m3249a(jsonReader, c0954f, C3385g.f9017a));
    }

    /* renamed from: a */
    static C4523c m3247a(JsonReader jsonReader, C0954f c0954f, int i) {
        return new C4523c(C0924d.m3249a(jsonReader, c0954f, new C3388m(i)));
    }

    /* renamed from: a */
    private static <T> List<C0950a<T>> m3249a(JsonReader jsonReader, C0954f c0954f, ak<T> akVar) {
        return C0934s.m3275a(jsonReader, c0954f, 1.0f, akVar);
    }

    /* renamed from: a */
    private static <T> List<C0950a<T>> m3248a(JsonReader jsonReader, float f, C0954f c0954f, ak<T> akVar) {
        return C0934s.m3275a(jsonReader, c0954f, f, akVar);
    }
}
