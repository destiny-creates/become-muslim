package com.p050a.p051a.p056c.p058b;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C4836q;
import com.p050a.p051a.p056c.p057a.C4521a;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p057a.C4524d;
import com.p050a.p051a.p056c.p059c.C4529a;
import java.util.List;

/* compiled from: ShapeStroke */
/* renamed from: com.a.a.c.b.p */
public class C3381p implements C0895b {
    /* renamed from: a */
    private final String f8999a;
    /* renamed from: b */
    private final C4522b f9000b;
    /* renamed from: c */
    private final List<C4522b> f9001c;
    /* renamed from: d */
    private final C4521a f9002d;
    /* renamed from: e */
    private final C4524d f9003e;
    /* renamed from: f */
    private final C4522b f9004f;
    /* renamed from: g */
    private final C0904a f9005g;
    /* renamed from: h */
    private final C0905b f9006h;

    /* compiled from: ShapeStroke */
    /* renamed from: com.a.a.c.b.p$a */
    public enum C0904a {
        Butt,
        Round,
        Unknown;

        /* renamed from: a */
        public Cap m3186a() {
            switch (this) {
                case Butt:
                    return Cap.BUTT;
                case Round:
                    return Cap.ROUND;
                default:
                    return Cap.SQUARE;
            }
        }
    }

    /* compiled from: ShapeStroke */
    /* renamed from: com.a.a.c.b.p$b */
    public enum C0905b {
        Miter,
        Round,
        Bevel;

        /* renamed from: a */
        public Join m3187a() {
            switch (this) {
                case Bevel:
                    return Join.BEVEL;
                case Miter:
                    return Join.MITER;
                case Round:
                    return Join.ROUND;
                default:
                    return null;
            }
        }
    }

    public C3381p(String str, C4522b c4522b, List<C4522b> list, C4521a c4521a, C4524d c4524d, C4522b c4522b2, C0904a c0904a, C0905b c0905b) {
        this.f8999a = str;
        this.f9000b = c4522b;
        this.f9001c = list;
        this.f9002d = c4521a;
        this.f9003e = c4524d;
        this.f9004f = c4522b2;
        this.f9005g = c0904a;
        this.f9006h = c0905b;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        return new C4836q(c0957g, c4529a, this);
    }

    /* renamed from: a */
    public String m10756a() {
        return this.f8999a;
    }

    /* renamed from: b */
    public C4521a m10757b() {
        return this.f9002d;
    }

    /* renamed from: c */
    public C4524d m10758c() {
        return this.f9003e;
    }

    /* renamed from: d */
    public C4522b m10759d() {
        return this.f9004f;
    }

    /* renamed from: e */
    public List<C4522b> m10760e() {
        return this.f9001c;
    }

    /* renamed from: f */
    public C4522b m10761f() {
        return this.f9000b;
    }

    /* renamed from: g */
    public C0904a m10762g() {
        return this.f9005g;
    }

    /* renamed from: h */
    public C0905b m10763h() {
        return this.f9006h;
    }
}
