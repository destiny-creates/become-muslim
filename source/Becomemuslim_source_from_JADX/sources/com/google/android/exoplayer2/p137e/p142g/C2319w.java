package com.google.android.exoplayer2.p137e.p142g;

import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;
import java.util.Collections;
import java.util.List;

/* compiled from: TsPayloadReader */
/* renamed from: com.google.android.exoplayer2.e.g.w */
public interface C2319w {

    /* compiled from: TsPayloadReader */
    /* renamed from: com.google.android.exoplayer2.e.g.w$a */
    public static final class C2315a {
        /* renamed from: a */
        public final String f5744a;
        /* renamed from: b */
        public final int f5745b;
        /* renamed from: c */
        public final byte[] f5746c;

        public C2315a(String str, int i, byte[] bArr) {
            this.f5744a = str;
            this.f5745b = i;
            this.f5746c = bArr;
        }
    }

    /* compiled from: TsPayloadReader */
    /* renamed from: com.google.android.exoplayer2.e.g.w$b */
    public static final class C2316b {
        /* renamed from: a */
        public final int f5747a;
        /* renamed from: b */
        public final String f5748b;
        /* renamed from: c */
        public final List<C2315a> f5749c;
        /* renamed from: d */
        public final byte[] f5750d;

        public C2316b(int i, String str, List<C2315a> list, byte[] bArr) {
            this.f5747a = i;
            this.f5748b = str;
            if (list == null) {
                i = Collections.emptyList();
            } else {
                i = Collections.unmodifiableList(list);
            }
            this.f5749c = i;
            this.f5750d = bArr;
        }
    }

    /* compiled from: TsPayloadReader */
    /* renamed from: com.google.android.exoplayer2.e.g.w$c */
    public interface C2317c {
        /* renamed from: a */
        SparseArray<C2319w> mo2213a();

        /* renamed from: a */
        C2319w mo2214a(int i, C2316b c2316b);
    }

    /* compiled from: TsPayloadReader */
    /* renamed from: com.google.android.exoplayer2.e.g.w$d */
    public static final class C2318d {
        /* renamed from: a */
        private final String f5751a;
        /* renamed from: b */
        private final int f5752b;
        /* renamed from: c */
        private final int f5753c;
        /* renamed from: d */
        private int f5754d;
        /* renamed from: e */
        private String f5755e;

        public C2318d(int i, int i2) {
            this(LinearLayoutManager.INVALID_OFFSET, i, i2);
        }

        public C2318d(int i, int i2, int i3) {
            if (i != LinearLayoutManager.INVALID_OFFSET) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("/");
                i = stringBuilder.toString();
            } else {
                i = "";
            }
            this.f5751a = i;
            this.f5752b = i2;
            this.f5753c = i3;
            this.f5754d = LinearLayoutManager.INVALID_OFFSET;
        }

        /* renamed from: a */
        public void m6431a() {
            this.f5754d = this.f5754d == LinearLayoutManager.INVALID_OFFSET ? this.f5752b : this.f5754d + this.f5753c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f5751a);
            stringBuilder.append(this.f5754d);
            this.f5755e = stringBuilder.toString();
        }

        /* renamed from: b */
        public int m6432b() {
            m6430d();
            return this.f5754d;
        }

        /* renamed from: c */
        public String m6433c() {
            m6430d();
            return this.f5755e;
        }

        /* renamed from: d */
        private void m6430d() {
            if (this.f5754d == LinearLayoutManager.INVALID_OFFSET) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }

    /* renamed from: a */
    void mo2215a();

    /* renamed from: a */
    void mo2216a(C2529l c2529l, boolean z);

    /* renamed from: a */
    void mo2217a(C2537s c2537s, C2320g c2320g, C2318d c2318d);
}
