package expo.modules.sensors.services;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import expo.p304a.C6007d;

public abstract class BaseSensorService extends BaseService implements SensorEventListener2 {
    private Sensor mSensor;
    private SensorManager mSensorManager = ((SensorManager) getContext().getSystemService("sensor"));

    abstract int getSensorType();

    public /* bridge */ /* synthetic */ void onHostDestroy() {
        super.onHostDestroy();
    }

    public /* bridge */ /* synthetic */ void onHostPause() {
        super.onHostPause();
    }

    public /* bridge */ /* synthetic */ void onHostResume() {
        super.onHostResume();
    }

    public /* bridge */ /* synthetic */ void setModuleRegistry(C6007d c6007d) {
        super.setModuleRegistry(c6007d);
    }

    BaseSensorService(Context context) {
        super(context);
    }

    protected void startObserving() {
        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(getSensorType());
        this.mSensor = defaultSensor;
        if (defaultSensor != null) {
            this.mSensorManager.registerListener(this, this.mSensor, 0);
        }
    }

    protected void stopObserving() {
        this.mSensorManager.unregisterListener(this);
    }
}
