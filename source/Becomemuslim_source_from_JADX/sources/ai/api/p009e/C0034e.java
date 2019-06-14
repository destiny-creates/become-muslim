package ai.api.p009e;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: VoiceActivityDetector */
/* renamed from: ai.api.e.e */
public class C0034e {
    /* renamed from: a */
    public static final String f110a = "ai.api.e.e";
    /* renamed from: b */
    private final int f111b;
    /* renamed from: c */
    private C0033a f112c;
    /* renamed from: d */
    private double f113d = 0.0d;
    /* renamed from: e */
    private long f114e = -1;
    /* renamed from: f */
    private long f115f = 0;
    /* renamed from: g */
    private int f116g = 0;
    /* renamed from: h */
    private long f117h = 0;
    /* renamed from: i */
    private int f118i;
    /* renamed from: j */
    private long f119j = 3500;
    /* renamed from: k */
    private boolean f120k = false;
    /* renamed from: l */
    private boolean f121l = true;
    /* renamed from: m */
    private boolean f122m = true;
    /* renamed from: n */
    private double f123n = 0.0d;
    /* renamed from: o */
    private int f124o = 0;

    /* compiled from: VoiceActivityDetector */
    /* renamed from: ai.api.e.e$a */
    public interface C0033a {
        /* renamed from: h */
        void mo9h();

        /* renamed from: i */
        void mo10i();

        /* renamed from: j */
        void mo11j();
    }

    public C0034e(int i) {
        this.f111b = i;
    }

    /* renamed from: a */
    public void m105a(byte[] bArr, int i) {
        if (this.f122m) {
            bArr = m98a(ByteBuffer.wrap(bArr, 0, i).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer());
            this.f117h = (long) (((this.f118i * (i / 2)) * 1000) / this.f111b);
            if (bArr != null) {
                if (this.f114e < 0 || this.f117h - this.f114e >= 30) {
                    this.f116g = 1;
                } else {
                    bArr = this.f116g + 1;
                    this.f116g = bArr;
                    if (bArr >= 3) {
                        if (this.f120k == null) {
                            m101e();
                        }
                        this.f115f = this.f117h;
                        this.f119j = Math.max(800, this.f119j - 675);
                    }
                }
                this.f114e = this.f117h;
            } else if (this.f117h - this.f115f > this.f119j) {
                if (this.f120k != null) {
                    m99c();
                } else {
                    m100d();
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m98a(ShortBuffer shortBuffer) {
        int limit = shortBuffer.limit();
        this.f124o += limit;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i >= limit) {
                break;
            }
            short s = shortBuffer.get(i);
            float f = (float) (((double) s) / 32767.0d);
            d += ((double) (f * f)) / ((double) limit);
            this.f123n += (double) (s * s);
            if (f <= 0.0f) {
                i4 = -1;
            }
            if (!(i3 == 0 || i4 == i3)) {
                i2++;
            }
            i++;
            i3 = i4;
        }
        shortBuffer = this.f118i + 1;
        this.f118i = shortBuffer;
        if (shortBuffer < 15) {
            this.f113d += d / 15.0d;
            return false;
        } else if (i2 < 5 || i2 > 15 || d <= this.f113d * 3.1d) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public double m102a() {
        double sqrt = Math.sqrt(this.f123n / ((double) this.f124o)) / 100.0d;
        this.f123n = 0.0d;
        this.f124o = 0;
        return sqrt;
    }

    /* renamed from: b */
    public void m106b() {
        this.f117h = 0;
        this.f118i = 0;
        this.f113d = 0.0d;
        this.f114e = -1;
        this.f115f = 0;
        this.f116g = 0;
        this.f119j = 3500;
        this.f120k = false;
        this.f122m = true;
    }

    /* renamed from: a */
    public void m103a(C0033a c0033a) {
        this.f112c = c0033a;
    }

    /* renamed from: c */
    private void m99c() {
        Log.v(f110a, "onSpeechEnd");
        this.f120k = false;
        this.f122m = false;
        if (this.f121l && this.f112c != null) {
            this.f112c.mo10i();
        }
    }

    /* renamed from: d */
    private void m100d() {
        Log.v(f110a, "onSpeechCancel");
        this.f120k = false;
        this.f122m = false;
        if (this.f112c != null) {
            this.f112c.mo11j();
        }
    }

    /* renamed from: e */
    private void m101e() {
        Log.v(f110a, "onSpeechBegin");
        this.f120k = true;
        if (this.f112c != null) {
            this.f112c.mo9h();
        }
    }

    /* renamed from: a */
    public void m104a(boolean z) {
        this.f121l = z;
    }
}
