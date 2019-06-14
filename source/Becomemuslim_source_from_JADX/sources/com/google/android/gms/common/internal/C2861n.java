package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.api.C2781a.C4340f;

/* renamed from: com.google.android.gms.common.internal.n */
public class C2861n {
    /* renamed from: a */
    private final SparseIntArray f7331a;
    /* renamed from: b */
    private C2830f f7332b;

    public C2861n() {
        this(C4361e.m14332a());
    }

    public C2861n(C2830f c2830f) {
        this.f7331a = new SparseIntArray();
        C2872v.m8380a((Object) c2830f);
        this.f7332b = c2830f;
    }

    /* renamed from: a */
    public int m8362a(Context context, C4340f c4340f) {
        C2872v.m8380a((Object) context);
        C2872v.m8380a((Object) c4340f);
        if (!c4340f.m14049k()) {
            return 0;
        }
        int f = c4340f.mo3293f();
        int i = this.f7331a.get(f, -1);
        if (i != -1) {
            return i;
        }
        for (int i2 = 0; i2 < this.f7331a.size(); i2++) {
            int keyAt = this.f7331a.keyAt(i2);
            if (keyAt > f && this.f7331a.get(keyAt) == 0) {
                i = 0;
                break;
            }
        }
        if (i == -1) {
            i = this.f7332b.mo2459b(context, f);
        }
        this.f7331a.put(f, i);
        return i;
    }

    /* renamed from: a */
    public void m8363a() {
        this.f7331a.clear();
    }
}
