package host.exp.exponent.p339f.p340a.p342b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import host.exp.exponent.p339f.p340a.C6324a;

/* compiled from: BaseSensorKernelService */
/* renamed from: host.exp.exponent.f.a.b.b */
public abstract class C7546b extends C6324a implements SensorEventListener {
    /* renamed from: a */
    private Sensor f26146a;
    /* renamed from: b */
    private SensorManager f26147b = ((SensorManager) m26011a().getSystemService("sensor"));

    /* renamed from: c */
    abstract int mo6767c();

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    C7546b(Context context) {
        super(context);
    }

    /* renamed from: d */
    protected void m34173d() {
        Sensor defaultSensor = this.f26147b.getDefaultSensor(mo6767c());
        this.f26146a = defaultSensor;
        if (defaultSensor != null) {
            this.f26147b.registerListener(this, this.f26146a, 0);
        }
    }

    /* renamed from: e */
    protected void m34174e() {
        this.f26147b.unregisterListener(this);
    }
}
