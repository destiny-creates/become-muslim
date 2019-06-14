package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.C4910m;
import com.google.android.gms.ads.internal.bu;

@cm
public final class axy {
    /* renamed from: a */
    private final Context f15042a;
    /* renamed from: b */
    private final bcy f15043b;
    /* renamed from: c */
    private final mv f15044c;
    /* renamed from: d */
    private final bu f15045d;

    axy(Context context, bcy bcy, mv mvVar, bu buVar) {
        this.f15042a = context;
        this.f15043b = bcy;
        this.f15044c = mvVar;
        this.f15045d = buVar;
    }

    /* renamed from: a */
    public final Context m19102a() {
        return this.f15042a.getApplicationContext();
    }

    /* renamed from: a */
    public final C4910m m19103a(String str) {
        return new C4910m(this.f15042a, new aou(), str, this.f15043b, this.f15044c, this.f15045d);
    }

    /* renamed from: b */
    public final C4910m m19104b(String str) {
        return new C4910m(this.f15042a.getApplicationContext(), new aou(), str, this.f15043b, this.f15044c, this.f15045d);
    }

    /* renamed from: b */
    public final axy m19105b() {
        return new axy(this.f15042a.getApplicationContext(), this.f15043b, this.f15044c, this.f15045d);
    }
}
