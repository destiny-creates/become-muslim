package com.raizlabs.android.dbflow.p281e;

import com.raizlabs.android.dbflow.config.C5680f;

/* compiled from: BaseModel */
/* renamed from: com.raizlabs.android.dbflow.e.b */
public abstract class C7139b implements C5698h {
    /* renamed from: a */
    private C8030i f25285a;

    /* compiled from: BaseModel */
    /* renamed from: com.raizlabs.android.dbflow.e.b$a */
    public enum C5695a {
        SAVE,
        INSERT,
        UPDATE,
        DELETE,
        CHANGE
    }

    /* renamed from: a */
    public void mo5063a() {
        m33196c().m38917b(this);
    }

    /* renamed from: b */
    public void m33195b() {
        m33196c().m38918c(this);
    }

    /* renamed from: c */
    public C8030i m33196c() {
        if (this.f25285a == null) {
            this.f25285a = C5680f.m24089e(getClass());
        }
        return this.f25285a;
    }
}
