package com.p050a.p051a.p061e;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.p050a.p051a.C0954f;

/* compiled from: LottieValueAnimator */
/* renamed from: com.a.a.e.c */
public class C3395c extends C0944a implements FrameCallback {
    /* renamed from: a */
    protected boolean f9031a = false;
    /* renamed from: b */
    private float f9032b = 1.0f;
    /* renamed from: c */
    private boolean f9033c = false;
    /* renamed from: d */
    private long f9034d = 0;
    /* renamed from: e */
    private float f9035e = 0.0f;
    /* renamed from: f */
    private int f9036f = 0;
    /* renamed from: g */
    private float f9037g = -2.14748365E9f;
    /* renamed from: h */
    private float f9038h = 2.14748365E9f;
    /* renamed from: i */
    private C0954f f9039i;

    public Object getAnimatedValue() {
        return Float.valueOf(m10806d());
    }

    /* renamed from: d */
    public float m10806d() {
        if (this.f9039i == null) {
            return 0.0f;
        }
        return (this.f9035e - this.f9039i.m3343d()) / (this.f9039i.m3344e() - this.f9039i.m3343d());
    }

    public float getAnimatedFraction() {
        if (this.f9039i == null) {
            return 0.0f;
        }
        if (m10798p()) {
            return (m10814l() - this.f9035e) / (m10814l() - m10813k());
        }
        return (this.f9035e - m10813k()) / (m10814l() - m10813k());
    }

    public long getDuration() {
        return this.f9039i == null ? 0 : (long) this.f9039i.m3342c();
    }

    /* renamed from: e */
    public float m10807e() {
        return this.f9035e;
    }

    public boolean isRunning() {
        return this.f9031a;
    }

    public void doFrame(long j) {
        m10815m();
        if (this.f9039i != null) {
            if (isRunning() != null) {
                j = System.nanoTime();
                float o = ((float) (j - this.f9034d)) / m10797o();
                float f = this.f9035e;
                if (m10798p()) {
                    o = -o;
                }
                this.f9035e = f + o;
                int c = C0947e.m3312c(this.f9035e, m10813k(), m10814l()) ^ 1;
                this.f9035e = C0947e.m3310b(this.f9035e, m10813k(), m10814l());
                this.f9034d = j;
                m3296c();
                if (c != 0) {
                    if (getRepeatCount() == -1 || this.f9036f < getRepeatCount()) {
                        m3292a();
                        this.f9036f++;
                        if (getRepeatMode() == 2) {
                            this.f9033c ^= 1;
                            m10809g();
                        } else {
                            this.f9035e = m10798p() ? m10814l() : m10813k();
                        }
                        this.f9034d = j;
                    } else {
                        this.f9035e = m10814l();
                        m10816n();
                        m3295b(m10798p());
                    }
                }
                m10799q();
            }
        }
    }

    /* renamed from: o */
    private float m10797o() {
        if (this.f9039i == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.f9039i.m3345f()) / Math.abs(this.f9032b);
    }

    /* renamed from: f */
    public void m10808f() {
        this.f9039i = null;
        this.f9037g = -2.14748365E9f;
        this.f9038h = 2.14748365E9f;
    }

    /* renamed from: a */
    public void m10803a(C0954f c0954f) {
        Object obj = this.f9039i == null ? 1 : null;
        this.f9039i = c0954f;
        if (obj != null) {
            m10802a((int) Math.max(this.f9037g, c0954f.m3343d()), (int) Math.min(this.f9038h, c0954f.m3344e()));
        } else {
            m10802a((int) c0954f.m3343d(), (int) c0954f.m3344e());
        }
        m10801a((int) this.f9035e);
        this.f9034d = System.nanoTime();
    }

    /* renamed from: a */
    public void m10801a(int i) {
        i = (float) i;
        if (this.f9035e != i) {
            this.f9035e = C0947e.m3310b(i, m10813k(), m10814l());
            this.f9034d = System.nanoTime();
            m3296c();
        }
    }

    /* renamed from: b */
    public void m10804b(int i) {
        m10802a(i, (int) this.f9038h);
    }

    /* renamed from: c */
    public void m10805c(int i) {
        m10802a((int) this.f9037g, i);
    }

    /* renamed from: a */
    public void m10802a(int i, int i2) {
        float d = this.f9039i == null ? Float.MIN_VALUE : this.f9039i.m3343d();
        float e = this.f9039i == null ? Float.MAX_VALUE : this.f9039i.m3344e();
        i = (float) i;
        this.f9037g = C0947e.m3310b(i, d, e);
        i2 = (float) i2;
        this.f9038h = C0947e.m3310b(i2, d, e);
        m10801a((int) C0947e.m3310b(this.f9035e, i, i2));
    }

    /* renamed from: g */
    public void m10809g() {
        m10800a(-m10810h());
    }

    /* renamed from: a */
    public void m10800a(float f) {
        this.f9032b = f;
    }

    /* renamed from: h */
    public float m10810h() {
        return this.f9032b;
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f9033c != 0) {
            this.f9033c = false;
            m10809g();
        }
    }

    /* renamed from: i */
    public void m10811i() {
        m3293a(m10798p());
        m10801a((int) (m10798p() ? m10814l() : m10813k()));
        this.f9034d = System.nanoTime();
        this.f9036f = 0;
        m10815m();
    }

    /* renamed from: j */
    public void m10812j() {
        m10816n();
        m3295b(m10798p());
    }

    public void cancel() {
        m3294b();
        m10816n();
    }

    /* renamed from: p */
    private boolean m10798p() {
        return m10810h() < 0.0f;
    }

    /* renamed from: k */
    public float m10813k() {
        if (this.f9039i == null) {
            return 0.0f;
        }
        return this.f9037g == -2.14748365E9f ? this.f9039i.m3343d() : this.f9037g;
    }

    /* renamed from: l */
    public float m10814l() {
        if (this.f9039i == null) {
            return 0.0f;
        }
        return this.f9038h == 2.14748365E9f ? this.f9039i.m3344e() : this.f9038h;
    }

    /* renamed from: m */
    protected void m10815m() {
        m10816n();
        Choreographer.getInstance().postFrameCallback(this);
        this.f9031a = true;
    }

    /* renamed from: n */
    protected void m10816n() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.f9031a = false;
    }

    /* renamed from: q */
    private void m10799q() {
        if (this.f9039i != null) {
            if (this.f9035e < this.f9037g || this.f9035e > this.f9038h) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f9037g), Float.valueOf(this.f9038h), Float.valueOf(this.f9035e)}));
            }
        }
    }
}
