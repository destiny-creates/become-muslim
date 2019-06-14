package com.raizlabs.android.dbflow.p276d.p277a;

import com.raizlabs.android.dbflow.p276d.p278b.C7128b;

/* compiled from: BaseCondition */
/* renamed from: com.raizlabs.android.dbflow.d.a.a */
abstract class C7126a implements C5686d {
    /* renamed from: a */
    protected String f25257a = "";
    /* renamed from: b */
    protected Object f25258b;
    /* renamed from: c */
    protected C7128b f25259c;
    /* renamed from: d */
    protected String f25260d;
    /* renamed from: e */
    protected String f25261e;
    /* renamed from: f */
    protected boolean f25262f = false;
    /* renamed from: g */
    protected boolean f25263g = false;

    C7126a(C7128b c7128b) {
        if (c7128b != null) {
            this.f25259c = c7128b;
            return;
        }
        throw new IllegalArgumentException("Column cannot be null");
    }

    /* renamed from: a */
    public Object mo6274a() {
        return this.f25258b;
    }

    /* renamed from: b */
    public String mo6277b() {
        return this.f25259c.mo5061a();
    }

    /* renamed from: c */
    public String mo5058c() {
        return this.f25261e;
    }

    /* renamed from: d */
    public boolean mo5059d() {
        return this.f25261e != null && this.f25261e.length() > 0;
    }

    /* renamed from: e */
    public String mo6278e() {
        return this.f25257a;
    }

    /* renamed from: f */
    public String mo6279f() {
        return this.f25260d;
    }
}
