package p289e.p292c.p295e.p297b;

/* compiled from: Pow2 */
/* renamed from: e.c.e.b.h */
public final class C5958h {
    /* renamed from: b */
    public static boolean m24925b(int i) {
        return (i & (i + -1)) == 0;
    }

    /* renamed from: a */
    public static int m24924a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
