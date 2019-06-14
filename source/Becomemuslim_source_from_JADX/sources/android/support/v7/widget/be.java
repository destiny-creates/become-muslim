package android.support.v7.widget;

/* compiled from: RtlSpacingHelper */
class be {
    /* renamed from: a */
    private int f2086a = 0;
    /* renamed from: b */
    private int f2087b = 0;
    /* renamed from: c */
    private int f2088c = LinearLayoutManager.INVALID_OFFSET;
    /* renamed from: d */
    private int f2089d = LinearLayoutManager.INVALID_OFFSET;
    /* renamed from: e */
    private int f2090e = 0;
    /* renamed from: f */
    private int f2091f = 0;
    /* renamed from: g */
    private boolean f2092g = false;
    /* renamed from: h */
    private boolean f2093h = false;

    be() {
    }

    /* renamed from: a */
    public int m2736a() {
        return this.f2086a;
    }

    /* renamed from: b */
    public int m2739b() {
        return this.f2087b;
    }

    /* renamed from: c */
    public int m2741c() {
        return this.f2092g ? this.f2087b : this.f2086a;
    }

    /* renamed from: d */
    public int m2742d() {
        return this.f2092g ? this.f2086a : this.f2087b;
    }

    /* renamed from: a */
    public void m2737a(int i, int i2) {
        this.f2088c = i;
        this.f2089d = i2;
        this.f2093h = true;
        if (this.f2092g) {
            if (i2 != LinearLayoutManager.INVALID_OFFSET) {
                this.f2086a = i2;
            }
            if (i != LinearLayoutManager.INVALID_OFFSET) {
                this.f2087b = i;
                return;
            }
            return;
        }
        if (i != LinearLayoutManager.INVALID_OFFSET) {
            this.f2086a = i;
        }
        if (i2 != LinearLayoutManager.INVALID_OFFSET) {
            this.f2087b = i2;
        }
    }

    /* renamed from: b */
    public void m2740b(int i, int i2) {
        this.f2093h = false;
        if (i != LinearLayoutManager.INVALID_OFFSET) {
            this.f2090e = i;
            this.f2086a = i;
        }
        if (i2 != LinearLayoutManager.INVALID_OFFSET) {
            this.f2091f = i2;
            this.f2087b = i2;
        }
    }

    /* renamed from: a */
    public void m2738a(boolean z) {
        if (z != this.f2092g) {
            this.f2092g = z;
            if (!this.f2093h) {
                this.f2086a = this.f2090e;
                this.f2087b = this.f2091f;
            } else if (z) {
                this.f2086a = !this.f2089d ? this.f2089d : this.f2090e;
                this.f2087b = !this.f2088c ? this.f2088c : this.f2091f;
            } else {
                this.f2086a = !this.f2088c ? this.f2088c : this.f2090e;
                this.f2087b = !this.f2089d ? this.f2089d : this.f2091f;
            }
        }
    }
}
