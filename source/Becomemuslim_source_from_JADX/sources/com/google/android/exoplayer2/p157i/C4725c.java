package com.google.android.exoplayer2.p157i;

import android.support.v7.widget.LinearLayoutManager;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p135b.C4086f;
import com.google.android.exoplayer2.p135b.C4087g;
import java.nio.ByteBuffer;

/* compiled from: SimpleSubtitleDecoder */
/* renamed from: com.google.android.exoplayer2.i.c */
public abstract class C4725c extends C4087g<C4726i, C4727j, C2473g> implements C4230f {
    /* renamed from: a */
    private final String f12870a;

    /* renamed from: a */
    protected abstract C2464e mo3431a(byte[] bArr, int i, boolean z);

    /* renamed from: a */
    public void mo3242a(long j) {
    }

    /* renamed from: g */
    protected /* synthetic */ C4085e mo3245g() {
        return mo3247i();
    }

    /* renamed from: h */
    protected /* synthetic */ C4086f mo3246h() {
        return mo3248j();
    }

    protected C4725c(String str) {
        super(new C4726i[2], new C4727j[2]);
        this.f12870a = str;
        m12767a(1024);
    }

    /* renamed from: i */
    protected final C4726i mo3247i() {
        return new C4726i();
    }

    /* renamed from: j */
    protected final C4727j mo3248j() {
        return new C4863d(this);
    }

    /* renamed from: a */
    protected final void m16258a(C4727j c4727j) {
        super.mo3244a((C4086f) c4727j);
    }

    /* renamed from: a */
    protected final C2473g m16254a(C4726i c4726i, C4727j c4727j, boolean z) {
        try {
            ByteBuffer byteBuffer = c4726i.b;
            C4727j c4727j2 = c4727j;
            c4727j2.m16267a(c4726i.c, mo3431a(byteBuffer.array(), byteBuffer.limit(), z), c4726i.f12871d);
            c4727j.m6205c(LinearLayoutManager.INVALID_OFFSET);
            return null;
        } catch (C4726i c4726i2) {
            return c4726i2;
        }
    }
}
