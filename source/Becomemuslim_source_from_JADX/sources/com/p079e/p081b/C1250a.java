package com.p079e.p081b;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: ShakeDetector */
/* renamed from: com.e.b.a */
public class C1250a implements SensorEventListener {
    /* renamed from: a */
    private int f3581a = 13;
    /* renamed from: b */
    private final C1249d f3582b = new C1249d();
    /* renamed from: c */
    private final C1246a f3583c;
    /* renamed from: d */
    private SensorManager f3584d;
    /* renamed from: e */
    private Sensor f3585e;

    /* compiled from: ShakeDetector */
    /* renamed from: com.e.b.a$a */
    public interface C1246a {
        void hearShake();
    }

    /* compiled from: ShakeDetector */
    /* renamed from: com.e.b.a$b */
    static class C1247b {
        /* renamed from: a */
        long f3572a;
        /* renamed from: b */
        boolean f3573b;
        /* renamed from: c */
        C1247b f3574c;

        C1247b() {
        }
    }

    /* compiled from: ShakeDetector */
    /* renamed from: com.e.b.a$c */
    static class C1248c {
        /* renamed from: a */
        private C1247b f3575a;

        C1248c() {
        }

        /* renamed from: a */
        C1247b m4354a() {
            C1247b c1247b = this.f3575a;
            if (c1247b == null) {
                return new C1247b();
            }
            this.f3575a = c1247b.f3574c;
            return c1247b;
        }

        /* renamed from: a */
        void m4355a(C1247b c1247b) {
            c1247b.f3574c = this.f3575a;
            this.f3575a = c1247b;
        }
    }

    /* compiled from: ShakeDetector */
    /* renamed from: com.e.b.a$d */
    static class C1249d {
        /* renamed from: a */
        private final C1248c f3576a = new C1248c();
        /* renamed from: b */
        private C1247b f3577b;
        /* renamed from: c */
        private C1247b f3578c;
        /* renamed from: d */
        private int f3579d;
        /* renamed from: e */
        private int f3580e;

        C1249d() {
        }

        /* renamed from: a */
        void m4358a(long j, boolean z) {
            m4357a(j - 500000000);
            C1247b a = this.f3576a.m4354a();
            a.f3572a = j;
            a.f3573b = z;
            a.f3574c = 0;
            if (this.f3578c != null) {
                this.f3578c.f3574c = a;
            }
            this.f3578c = a;
            if (this.f3577b == null) {
                this.f3577b = a;
            }
            this.f3579d++;
            if (z) {
                this.f3580e++;
            }
        }

        /* renamed from: a */
        void m4356a() {
            while (this.f3577b != null) {
                C1247b c1247b = this.f3577b;
                this.f3577b = c1247b.f3574c;
                this.f3576a.m4355a(c1247b);
            }
            this.f3578c = null;
            this.f3579d = 0;
            this.f3580e = 0;
        }

        /* renamed from: a */
        void m4357a(long j) {
            while (this.f3579d >= 4 && this.f3577b != null && j - this.f3577b.f3572a > 0) {
                C1247b c1247b = this.f3577b;
                if (c1247b.f3573b) {
                    this.f3580e--;
                }
                this.f3579d--;
                this.f3577b = c1247b.f3574c;
                if (this.f3577b == null) {
                    this.f3578c = null;
                }
                this.f3576a.m4355a(c1247b);
            }
        }

        /* renamed from: b */
        boolean m4359b() {
            return this.f3578c != null && this.f3577b != null && this.f3578c.f3572a - this.f3577b.f3572a >= 250000000 && this.f3580e >= (this.f3579d >> 1) + (this.f3579d >> 2);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public C1250a(C1246a c1246a) {
        this.f3583c = c1246a;
    }

    /* renamed from: a */
    public boolean m4361a(SensorManager sensorManager) {
        boolean z = true;
        if (this.f3585e != null) {
            return true;
        }
        this.f3585e = sensorManager.getDefaultSensor(1);
        if (this.f3585e != null) {
            this.f3584d = sensorManager;
            sensorManager.registerListener(this, this.f3585e, 0);
        }
        if (this.f3585e == null) {
            z = false;
        }
        return z;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean a = m4360a(sensorEvent);
        this.f3582b.m4358a(sensorEvent.timestamp, a);
        if (this.f3582b.m4359b() != null) {
            this.f3582b.m4356a();
            this.f3583c.hearShake();
        }
    }

    /* renamed from: a */
    private boolean m4360a(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        sensorEvent = sensorEvent.values[2];
        if (((double) (((f * f) + (f2 * f2)) + (sensorEvent * sensorEvent))) > ((double) (this.f3581a * this.f3581a))) {
            return true;
        }
        return false;
    }
}
