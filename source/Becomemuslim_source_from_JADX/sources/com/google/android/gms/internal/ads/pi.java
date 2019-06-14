package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;

@cm
final class pi implements SensorEventListener {
    /* renamed from: a */
    private final SensorManager f15885a;
    /* renamed from: b */
    private final Object f15886b = new Object();
    /* renamed from: c */
    private final Display f15887c;
    /* renamed from: d */
    private final float[] f15888d = new float[9];
    /* renamed from: e */
    private final float[] f15889e = new float[9];
    /* renamed from: f */
    private float[] f15890f;
    /* renamed from: g */
    private Handler f15891g;
    /* renamed from: h */
    private pk f15892h;

    pi(Context context) {
        this.f15885a = (SensorManager) context.getSystemService("sensor");
        this.f15887c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    /* renamed from: a */
    private final void m20000a(int i, int i2) {
        float f = this.f15889e[i];
        this.f15889e[i] = this.f15889e[i2];
        this.f15889e[i2] = f;
    }

    /* renamed from: a */
    final void m20001a() {
        if (this.f15891g == null) {
            Sensor defaultSensor = this.f15885a.getDefaultSensor(11);
            if (defaultSensor == null) {
                mt.m19920c("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.f15891g = new Handler(handlerThread.getLooper());
            if (!this.f15885a.registerListener(this, defaultSensor, 0, this.f15891g)) {
                mt.m19920c("SensorManager.registerListener failed.");
                m20004b();
            }
        }
    }

    /* renamed from: a */
    final void m20002a(pk pkVar) {
        this.f15892h = pkVar;
    }

    /* renamed from: a */
    final boolean m20003a(float[] fArr) {
        synchronized (this.f15886b) {
            if (this.f15890f == null) {
                return false;
            }
            System.arraycopy(this.f15890f, 0, fArr, 0, this.f15890f.length);
            return true;
        }
    }

    /* renamed from: b */
    final void m20004b() {
        if (this.f15891g != null) {
            this.f15885a.unregisterListener(this);
            this.f15891g.post(new pj(this));
            this.f15891g = null;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.f15886b) {
                if (this.f15890f == null) {
                    this.f15890f = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.f15888d, fArr);
            switch (this.f15887c.getRotation()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.f15888d, 2, 129, this.f15889e);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.f15888d, 129, 130, this.f15889e);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.f15888d, 130, 1, this.f15889e);
                    break;
                default:
                    System.arraycopy(this.f15888d, 0, this.f15889e, 0, 9);
                    break;
            }
            m20000a(1, 3);
            m20000a(2, 6);
            m20000a(5, 7);
            synchronized (this.f15886b) {
                System.arraycopy(this.f15889e, 0, this.f15890f, 0, 9);
            }
            if (this.f15892h != null) {
                this.f15892h.mo4336a();
            }
        }
    }
}
