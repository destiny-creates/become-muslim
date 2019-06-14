package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p164l.C2541v;
import java.util.UUID;

/* compiled from: C */
/* renamed from: com.google.android.exoplayer2.b */
public final class C2251b {
    /* renamed from: a */
    public static final int f5375a = (C2541v.f6467a < 23 ? 1020 : 6396);
    /* renamed from: b */
    public static final UUID f5376b = new UUID(0, 0);
    /* renamed from: c */
    public static final UUID f5377c = new UUID(1186680826959645954L, -5988876978535335093L);
    /* renamed from: d */
    public static final UUID f5378d = new UUID(-2129748144642739255L, 8654423357094679310L);
    /* renamed from: e */
    public static final UUID f5379e = new UUID(-1301668207276963122L, -6645017420763422227L);
    /* renamed from: f */
    public static final UUID f5380f = new UUID(-7348484286925749626L, -6083546864340672619L);

    /* renamed from: b */
    public static long m6222b(long j) {
        return j != -9223372036854775807L ? j == Long.MIN_VALUE ? j : j * 1000 : j;
    }

    /* renamed from: a */
    public static long m6221a(long j) {
        if (j != -9223372036854775807L) {
            return j == Long.MIN_VALUE ? j : j / 1000;
        } else {
            return j;
        }
    }
}
