package com.google.android.exoplayer2.p157i.p159b;

import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C4725c;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.List;

/* compiled from: DvbDecoder */
/* renamed from: com.google.android.exoplayer2.i.b.a */
public final class C4860a extends C4725c {
    /* renamed from: a */
    private final C2457b f13882a;

    /* renamed from: a */
    protected /* synthetic */ C2464e mo3431a(byte[] bArr, int i, boolean z) {
        return m17360b(bArr, i, z);
    }

    public C4860a(List<byte[]> list) {
        super("DvbDecoder");
        C2529l c2529l = new C2529l((byte[]) list.get(0));
        this.f13882a = new C2457b(c2529l.m7104h(), c2529l.m7104h());
    }

    /* renamed from: b */
    protected C4225c m17360b(byte[] bArr, int i, boolean z) {
        if (z) {
            this.f13882a.m6789a();
        }
        return new C4225c(this.f13882a.m6788a(bArr, i));
    }
}
