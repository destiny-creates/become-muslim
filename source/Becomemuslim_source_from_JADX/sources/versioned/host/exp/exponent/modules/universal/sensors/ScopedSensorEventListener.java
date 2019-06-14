package versioned.host.exp.exponent.modules.universal.sensors;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import host.exp.exponent.p339f.p340a.p342b.C6325i;

public class ScopedSensorEventListener implements C6325i {
    private SensorEventListener2 mEventListener;

    ScopedSensorEventListener(SensorEventListener2 sensorEventListener2) {
        this.mEventListener = sensorEventListener2;
    }

    public void onSensorDataChanged(SensorEvent sensorEvent) {
        this.mEventListener.onSensorChanged(sensorEvent);
    }
}
