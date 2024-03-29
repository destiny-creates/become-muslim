package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class ViewIndexingTrigger implements SensorEventListener {
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.299999952316284d;
    private OnShakeListener mListener;

    public interface OnShakeListener {
        void onShake();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mListener = onShakeListener;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.mListener != null) {
            float f = sensorEvent.values[0];
            double d = (double) (f / 9.80665f);
            double d2 = (double) (sensorEvent.values[1] / 9.80665f);
            double d3 = (double) (sensorEvent.values[2] / 1092413450);
            if (Math.sqrt(((d * d) + (d2 * d2)) + (d3 * d3)) > SHAKE_THRESHOLD_GRAVITY) {
                this.mListener.onShake();
            }
        }
    }
}
