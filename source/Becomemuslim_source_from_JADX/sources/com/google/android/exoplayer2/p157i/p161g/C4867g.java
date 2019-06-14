package com.google.android.exoplayer2.p157i.p161g;

import android.text.TextUtils;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C2473g;
import com.google.android.exoplayer2.p157i.C4725c;
import com.google.android.exoplayer2.p157i.p161g.C4232e.C2468a;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WebvttDecoder */
/* renamed from: com.google.android.exoplayer2.i.g.g */
public final class C4867g extends C4725c {
    /* renamed from: a */
    private final C2471f f13912a = new C2471f();
    /* renamed from: b */
    private final C2529l f13913b = new C2529l();
    /* renamed from: c */
    private final C2468a f13914c = new C2468a();
    /* renamed from: d */
    private final C2465a f13915d = new C2465a();
    /* renamed from: e */
    private final List<C2466d> f13916e = new ArrayList();

    /* renamed from: a */
    protected /* synthetic */ C2464e mo3431a(byte[] bArr, int i, boolean z) {
        return m17398b(bArr, i, z);
    }

    public C4867g() {
        super("WebvttDecoder");
    }

    /* renamed from: b */
    protected C4233i m17398b(byte[] bArr, int i, boolean z) {
        this.f13913b.m7091a(bArr, i);
        this.f13914c.m6880a();
        this.f13916e.clear();
        C2472h.m6906a(this.f13913b);
        while (TextUtils.isEmpty(this.f13913b.m7122z()) == null) {
        }
        bArr = new ArrayList();
        while (true) {
            boolean a = C4867g.m17395a(this.f13913b);
            if (!a) {
                return new C4233i(bArr);
            }
            if (a) {
                C4867g.m17396b(this.f13913b);
            } else if (a) {
                if (bArr.isEmpty() != 0) {
                    this.f13913b.m7122z();
                    i = this.f13915d.m6849a(this.f13913b);
                    if (i != 0) {
                        this.f13916e.add(i);
                    }
                } else {
                    throw new C2473g("A style block was found after the first cue.");
                }
            } else if (a && this.f13912a.m6904a(this.f13913b, this.f13914c, this.f13916e) != 0) {
                bArr.add(this.f13914c.m6884b());
                this.f13914c.m6880a();
            }
        }
    }

    /* renamed from: a */
    private static int m17395a(C2529l c2529l) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = c2529l.m7097d();
            String z = c2529l.m7122z();
            i = z == null ? 0 : "STYLE".equals(z) ? 2 : "NOTE".startsWith(z) ? 1 : 3;
        }
        c2529l.m7096c(i2);
        return i;
    }

    /* renamed from: b */
    private static void m17396b(C2529l c2529l) {
        while (!TextUtils.isEmpty(c2529l.m7122z())) {
        }
    }
}
