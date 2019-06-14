package com.google.p217b.p240g.p241a;

import com.google.p217b.p222b.C5202b;

/* compiled from: DataMask */
/* renamed from: com.google.b.g.a.c */
enum C5284c {
    DATA_MASK_000 {
        /* renamed from: a */
        boolean mo4871a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        /* renamed from: a */
        boolean mo4871a(int i, int i2) {
            return (i & 1) == 0;
        }
    },
    DATA_MASK_010 {
        /* renamed from: a */
        boolean mo4871a(int i, int i2) {
            return i2 % 3 == 0;
        }
    },
    DATA_MASK_011 {
        /* renamed from: a */
        boolean mo4871a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    },
    DATA_MASK_100 {
        /* renamed from: a */
        boolean mo4871a(int i, int i2) {
            return (((i / 2) + (i2 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 {
        /* renamed from: a */
        boolean mo4871a(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    },
    DATA_MASK_110 {
        /* renamed from: a */
        boolean mo4871a(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    },
    DATA_MASK_111 {
        /* renamed from: a */
        boolean mo4871a(int i, int i2) {
            return (((i + i2) + ((i * i2) % 3)) & 1) == 0;
        }
    };

    /* renamed from: a */
    abstract boolean mo4871a(int i, int i2);

    /* renamed from: a */
    final void m22425a(C5202b c5202b, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (mo4871a(i2, i3)) {
                    c5202b.m22006c(i3, i2);
                }
            }
        }
    }
}
