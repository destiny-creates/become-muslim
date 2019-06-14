package com.raizlabs.android.dbflow.p273c.p274a.p275a;

import com.raizlabs.android.dbflow.p273c.C5672d;
import com.raizlabs.android.dbflow.p273c.p274a.C7116a;
import com.raizlabs.android.dbflow.p281e.C5698h;
import java.util.List;

/* compiled from: ProcessModelTransaction */
/* renamed from: com.raizlabs.android.dbflow.c.a.a.d */
public abstract class C8021d<ModelClass extends C5698h> extends C7116a<List<ModelClass>> implements C5659a<ModelClass> {
    /* renamed from: e */
    protected C5662c<ModelClass> f29787e;
    /* renamed from: f */
    private final C5672d f29788f;
    /* renamed from: g */
    private long f29789g = 0;
    /* renamed from: h */
    private final long f29790h;
    /* renamed from: i */
    private C5663a<ModelClass> f29791i;

    /* compiled from: ProcessModelTransaction */
    /* renamed from: com.raizlabs.android.dbflow.c.a.a.d$a */
    public interface C5663a<ModelClass> {
        /* renamed from: a */
        void m24020a(long j, long j2, ModelClass modelClass);
    }

    /* compiled from: ProcessModelTransaction */
    /* renamed from: com.raizlabs.android.dbflow.c.a.a.d$1 */
    class C71151 implements C5659a<ModelClass> {
        /* renamed from: a */
        final /* synthetic */ C8021d f25254a;

        C71151(C8021d c8021d) {
            this.f25254a = c8021d;
        }

        /* renamed from: a */
        public void mo5045a(ModelClass modelClass) {
            this.f25254a.mo5045a((C5698h) modelClass);
            this.f25254a.f29789g = 1 + this.f25254a.f29789g;
            if (this.f25254a.f29791i != null) {
                this.f25254a.f29791i.m24020a(this.f25254a.f29789g, this.f25254a.f29790h, modelClass);
            }
        }
    }

    /* renamed from: a */
    public abstract void mo5045a(ModelClass modelClass);

    /* renamed from: b */
    public /* synthetic */ Object mo6273b() {
        return m38871c();
    }

    public C8021d(C5662c<ModelClass> c5662c, C5672d c5672d) {
        super(c5662c.m24016a(), c5662c.f18917b);
        this.f29787e = c5662c;
        this.f29788f = c5672d;
        this.f29790h = (long) this.f29787e.f18916a.size();
    }

    /* renamed from: a */
    public boolean mo5046a() {
        return this.f29787e.m24019b();
    }

    /* renamed from: c */
    public List<ModelClass> m38871c() {
        if (this.f29788f != null) {
            this.f29788f.m24044b();
        }
        this.f29787e.m24017a(new C71151(this));
        List<ModelClass> list = this.f29787e.f18916a;
        if (this.f29788f != null) {
            this.f29788f.m24045c();
        }
        return list;
    }
}
