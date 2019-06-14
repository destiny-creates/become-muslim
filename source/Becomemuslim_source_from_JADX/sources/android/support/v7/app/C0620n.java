package android.support.v7.app;

/* compiled from: TwilightCalculator */
/* renamed from: android.support.v7.app.n */
class C0620n {
    /* renamed from: d */
    private static C0620n f1600d;
    /* renamed from: a */
    public long f1601a;
    /* renamed from: b */
    public long f1602b;
    /* renamed from: c */
    public int f1603c;

    C0620n() {
    }

    /* renamed from: a */
    static C0620n m2096a() {
        if (f1600d == null) {
            f1600d = new C0620n();
        }
        return f1600d;
    }

    /* renamed from: a */
    public void m2097a(long j, double d, double d2) {
        C0620n c0620n = this;
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        float f2 = (0.01720197f * f) + 6.24006f;
        double d3 = (double) f2;
        double sin = (((((Math.sin(d3) * 0.03341960161924362d) + d3) + (Math.sin((double) (2.0f * f2)) * 3.4906598739326E-4d)) + (Math.sin((double) (f2 * 3.0f)) * 5.236000106378924E-6d)) + 1.796593063d) + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double round = ((((double) (((float) Math.round(((double) (f - 9.0E-4f)) - d4)) + 9.0E-4f)) + d4) + (Math.sin(d3) * 0.0053d)) + (Math.sin(2.0d * sin) * -0.0069d);
        d3 = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        sin = 0.01745329238474369d * d;
        d4 = (Math.sin(-0.10471975803375244d) - (Math.sin(sin) * Math.sin(d3))) / (Math.cos(sin) * Math.cos(d3));
        if (d4 >= 1.0d) {
            c0620n.f1603c = 1;
            c0620n.f1601a = -1;
            c0620n.f1602b = -1;
        } else if (d4 <= -1.0d) {
            c0620n.f1603c = 0;
            c0620n.f1601a = -1;
            c0620n.f1602b = -1;
        } else {
            double acos = (double) ((float) (Math.acos(d4) / 6.283185307179586d));
            c0620n.f1601a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            c0620n.f1602b = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            if (c0620n.f1602b >= j || c0620n.f1601a <= j) {
                c0620n.f1603c = 1;
            } else {
                c0620n.f1603c = 0;
            }
        }
    }
}
