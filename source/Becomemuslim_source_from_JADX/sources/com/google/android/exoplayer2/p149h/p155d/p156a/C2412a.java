package com.google.android.exoplayer2.p149h.p155d.p156a;

import android.net.Uri;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2539u;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.List;
import java.util.UUID;

/* compiled from: SsManifest */
/* renamed from: com.google.android.exoplayer2.h.d.a.a */
public class C2412a {
    /* renamed from: a */
    public final int f5959a;
    /* renamed from: b */
    public final int f5960b;
    /* renamed from: c */
    public final int f5961c;
    /* renamed from: d */
    public final boolean f5962d;
    /* renamed from: e */
    public final C2410a f5963e;
    /* renamed from: f */
    public final C2411b[] f5964f;
    /* renamed from: g */
    public final long f5965g;
    /* renamed from: h */
    public final long f5966h;

    /* compiled from: SsManifest */
    /* renamed from: com.google.android.exoplayer2.h.d.a.a$a */
    public static class C2410a {
        /* renamed from: a */
        public final UUID f5941a;
        /* renamed from: b */
        public final byte[] f5942b;

        public C2410a(UUID uuid, byte[] bArr) {
            this.f5941a = uuid;
            this.f5942b = bArr;
        }
    }

    /* compiled from: SsManifest */
    /* renamed from: com.google.android.exoplayer2.h.d.a.a$b */
    public static class C2411b {
        /* renamed from: a */
        public final int f5943a;
        /* renamed from: b */
        public final String f5944b;
        /* renamed from: c */
        public final long f5945c;
        /* renamed from: d */
        public final String f5946d;
        /* renamed from: e */
        public final int f5947e;
        /* renamed from: f */
        public final int f5948f;
        /* renamed from: g */
        public final int f5949g;
        /* renamed from: h */
        public final int f5950h;
        /* renamed from: i */
        public final String f5951i;
        /* renamed from: j */
        public final C2515k[] f5952j;
        /* renamed from: k */
        public final int f5953k;
        /* renamed from: l */
        private final String f5954l;
        /* renamed from: m */
        private final String f5955m;
        /* renamed from: n */
        private final List<Long> f5956n;
        /* renamed from: o */
        private final long[] f5957o;
        /* renamed from: p */
        private final long f5958p;

        public C2411b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, C2515k[] c2515kArr, List<Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, c2515kArr, list, C2541v.m7181a((List) list, 1000000, j), C2541v.m7185b(j2, 1000000, j));
        }

        private C2411b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, C2515k[] c2515kArr, List<Long> list, long[] jArr, long j2) {
            this.f5954l = str;
            this.f5955m = str2;
            this.f5943a = i;
            this.f5944b = str3;
            this.f5945c = j;
            this.f5946d = str4;
            this.f5947e = i2;
            this.f5948f = i3;
            this.f5949g = i4;
            this.f5950h = i5;
            this.f5951i = str5;
            this.f5952j = c2515kArr;
            this.f5956n = list;
            this.f5957o = jArr;
            this.f5958p = j2;
            this.f5953k = list.size();
        }

        /* renamed from: a */
        public int m6631a(long j) {
            return C2541v.m7167a(this.f5957o, j, true, true);
        }

        /* renamed from: a */
        public long m6632a(int i) {
            return this.f5957o[i];
        }

        /* renamed from: b */
        public long m6634b(int i) {
            return i == this.f5953k + -1 ? this.f5958p : this.f5957o[i + 1] - this.f5957o[i];
        }

        /* renamed from: a */
        public Uri m6633a(int i, int i2) {
            boolean z = false;
            C2516a.m7019b(this.f5952j != null);
            C2516a.m7019b(this.f5956n != null);
            if (i2 < this.f5956n.size()) {
                z = true;
            }
            C2516a.m7019b(z);
            i = Integer.toString(this.f5952j[i].f6376b);
            i2 = ((Long) this.f5956n.get(i2)).toString();
            return C2539u.m7158a(this.f5954l, this.f5955m.replace("{bitrate}", i).replace("{Bitrate}", i).replace("{start time}", i2).replace("{start_time}", i2));
        }
    }

    public C2412a(int i, int i2, long j, long j2, long j3, int i3, boolean z, C2410a c2410a, C2411b[] c2411bArr) {
        long j4 = -9223372036854775807L;
        long b = j2 == 0 ? -9223372036854775807L : C2541v.m7185b(j2, 1000000, j);
        if (j3 != 0) {
            j4 = C2541v.m7185b(j3, 1000000, j);
        }
        this(i, i2, b, j4, i3, z, c2410a, c2411bArr);
    }

    private C2412a(int i, int i2, long j, long j2, int i3, boolean z, C2410a c2410a, C2411b[] c2411bArr) {
        this.f5959a = i;
        this.f5960b = i2;
        this.f5965g = j;
        this.f5966h = j2;
        this.f5961c = i3;
        this.f5962d = z;
        this.f5963e = c2410a;
        this.f5964f = c2411bArr;
    }
}
