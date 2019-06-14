package com.google.p217b.p240g.p241a;

/* compiled from: Mode */
/* renamed from: com.google.b.g.a.h */
public enum C5290h {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    /* renamed from: k */
    private final int[] f17873k;
    /* renamed from: l */
    private final int f17874l;

    private C5290h(int[] iArr, int i) {
        this.f17873k = iArr;
        this.f17874l = i;
    }

    /* renamed from: a */
    public static C5290h m22445a(int i) {
        switch (i) {
            case 0:
                return TERMINATOR;
            case 1:
                return NUMERIC;
            case 2:
                return ALPHANUMERIC;
            case 3:
                return STRUCTURED_APPEND;
            case 4:
                return BYTE;
            case 5:
                return FNC1_FIRST_POSITION;
            case 7:
                return ECI;
            case 8:
                return KANJI;
            case 9:
                return FNC1_SECOND_POSITION;
            case 13:
                return HANZI;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public int m22447a(C5294j c5294j) {
        c5294j = c5294j.m22459a();
        c5294j = c5294j <= 9 ? null : c5294j <= 26 ? true : 2;
        return this.f17873k[c5294j];
    }

    /* renamed from: a */
    public int m22446a() {
        return this.f17874l;
    }
}
