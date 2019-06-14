package com.google.android.exoplayer2.p157i.p198c;

import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Collections;
import java.util.List;

/* compiled from: SsaSubtitle */
/* renamed from: com.google.android.exoplayer2.i.c.b */
final class C4226b implements C2464e {
    /* renamed from: a */
    private final C2458b[] f11126a;
    /* renamed from: b */
    private final long[] f11127b;

    public C4226b(C2458b[] c2458bArr, long[] jArr) {
        this.f11126a = c2458bArr;
        this.f11127b = jArr;
    }

    /* renamed from: a */
    public int mo2291a(long j) {
        j = C2541v.m7184b(this.f11127b, j, false, false);
        return j < this.f11127b.length ? j : -1;
    }

    /* renamed from: b */
    public int mo2293b() {
        return this.f11127b.length;
    }

    /* renamed from: a */
    public long mo2292a(int i) {
        boolean z = false;
        C2516a.m7017a(i >= 0);
        if (i < this.f11127b.length) {
            z = true;
        }
        C2516a.m7017a(z);
        return this.f11127b[i];
    }

    /* renamed from: b */
    public List<C2458b> mo2294b(long j) {
        j = C2541v.m7167a(this.f11127b, j, true, false);
        if (j != -1) {
            if (this.f11126a[j] != null) {
                return Collections.singletonList(this.f11126a[j]);
            }
        }
        return Collections.emptyList();
    }
}
