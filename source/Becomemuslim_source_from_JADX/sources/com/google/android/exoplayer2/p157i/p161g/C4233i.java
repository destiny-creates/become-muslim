package com.google.android.exoplayer2.p157i.p161g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: WebvttSubtitle */
/* renamed from: com.google.android.exoplayer2.i.g.i */
final class C4233i implements C2464e {
    /* renamed from: a */
    private final List<C4232e> f11139a;
    /* renamed from: b */
    private final int f11140b;
    /* renamed from: c */
    private final long[] f11141c = new long[(this.f11140b * 2)];
    /* renamed from: d */
    private final long[] f11142d;

    public C4233i(List<C4232e> list) {
        this.f11139a = list;
        this.f11140b = list.size();
        for (int i = 0; i < this.f11140b; i++) {
            C4232e c4232e = (C4232e) list.get(i);
            int i2 = i * 2;
            this.f11141c[i2] = c4232e.f11137m;
            this.f11141c[i2 + 1] = c4232e.f11138n;
        }
        this.f11142d = Arrays.copyOf(this.f11141c, this.f11141c.length);
        Arrays.sort(this.f11142d);
    }

    /* renamed from: a */
    public int mo2291a(long j) {
        j = C2541v.m7184b(this.f11142d, j, false, false);
        return j < this.f11142d.length ? j : -1;
    }

    /* renamed from: b */
    public int mo2293b() {
        return this.f11142d.length;
    }

    /* renamed from: a */
    public long mo2292a(int i) {
        boolean z = false;
        C2516a.m7017a(i >= 0);
        if (i < this.f11142d.length) {
            z = true;
        }
        C2516a.m7017a(z);
        return this.f11142d[i];
    }

    /* renamed from: b */
    public List<C2458b> mo2294b(long j) {
        CharSequence charSequence = null;
        List list = null;
        C4232e c4232e = list;
        for (int i = 0; i < this.f11140b; i++) {
            int i2 = i * 2;
            if (this.f11141c[i2] <= j && j < this.f11141c[i2 + 1]) {
                if (list == null) {
                    list = new ArrayList();
                }
                C4232e c4232e2 = (C4232e) this.f11139a.get(i);
                if (!c4232e2.m13720a()) {
                    list.add(c4232e2);
                } else if (c4232e == null) {
                    c4232e = c4232e2;
                } else if (charSequence == null) {
                    charSequence = new SpannableStringBuilder();
                    charSequence.append(c4232e.a).append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).append(c4232e2.a);
                } else {
                    charSequence.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).append(c4232e2.a);
                }
            }
        }
        if (charSequence != null) {
            list.add(new C4232e(charSequence));
        } else if (c4232e != null) {
            list.add(c4232e);
        }
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }
}
