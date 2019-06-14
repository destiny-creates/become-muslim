package expo.modules.sensors.services;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import expo.p307b.p316i.C6036a;
import expo.p307b.p316i.C6037b;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class SubscribableSensorService extends BaseSensorService implements C6036a {
    protected static int DEFAULT_UPDATE_INTERVAL = 100;
    private int mListenersCount = null;
    private Map<SensorServiceSubscription, Long> mSensorEventListenerLastUpdateMap = new WeakHashMap();

    SubscribableSensorService(Context context) {
        super(context);
    }

    public void onExperienceForegrounded() {
        updateObserving();
    }

    public void onExperienceBackgrounded() {
        updateObserving();
    }

    public C6037b createSubscriptionForListener(SensorEventListener2 sensorEventListener2) {
        C6037b sensorServiceSubscription = new SensorServiceSubscription(this, sensorEventListener2);
        this.mSensorEventListenerLastUpdateMap.put(sensorServiceSubscription, Long.valueOf(0));
        return sensorServiceSubscription;
    }

    void onSubscriptionEnabledChanged(SensorServiceSubscription sensorServiceSubscription) {
        if (sensorServiceSubscription.isEnabled() != null) {
            this.mListenersCount++;
        } else {
            this.mListenersCount--;
        }
        updateObserving();
    }

    void removeSubscription(SensorServiceSubscription sensorServiceSubscription) {
        this.mSensorEventListenerLastUpdateMap.remove(sensorServiceSubscription);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == getSensorType()) {
            long currentTimeMillis = System.currentTimeMillis();
            for (SensorServiceSubscription sensorServiceSubscription : this.mSensorEventListenerLastUpdateMap.keySet()) {
                if (sensorServiceSubscription != null && sensorServiceSubscription.isEnabled()) {
                    long j = 0;
                    if (this.mSensorEventListenerLastUpdateMap.containsKey(sensorServiceSubscription)) {
                        j = ((Long) this.mSensorEventListenerLastUpdateMap.get(sensorServiceSubscription)).longValue();
                    }
                    long j2 = (long) DEFAULT_UPDATE_INTERVAL;
                    if (sensorServiceSubscription.getUpdateInterval() != null) {
                        j2 = sensorServiceSubscription.getUpdateInterval().longValue();
                    }
                    if (currentTimeMillis - j > j2) {
                        sensorServiceSubscription.getSensorEventListener().onSensorChanged(sensorEvent);
                        this.mSensorEventListenerLastUpdateMap.put(sensorServiceSubscription, Long.valueOf(currentTimeMillis));
                    }
                }
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        if (sensor.getType() == getSensorType()) {
            for (SensorServiceSubscription sensorServiceSubscription : this.mSensorEventListenerLastUpdateMap.keySet()) {
                if (sensorServiceSubscription.isEnabled()) {
                    sensorServiceSubscription.getSensorEventListener().onAccuracyChanged(sensor, i);
                }
            }
        }
    }

    public void onFlushCompleted(Sensor sensor) {
        if (sensor.getType() == getSensorType()) {
            for (SensorServiceSubscription sensorServiceSubscription : this.mSensorEventListenerLastUpdateMap.keySet()) {
                if (sensorServiceSubscription.isEnabled()) {
                    sensorServiceSubscription.getSensorEventListener().onFlushCompleted(sensor);
                }
            }
        }
    }

    private void updateObserving() {
        if (this.mListenersCount <= 0 || !getExperienceIsForegrounded()) {
            super.stopObserving();
        } else {
            super.startObserving();
        }
    }
}
