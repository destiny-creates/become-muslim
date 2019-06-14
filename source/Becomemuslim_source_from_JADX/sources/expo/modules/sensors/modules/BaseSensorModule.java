package expo.modules.sensors.modules;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.os.Bundle;
import android.util.Log;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.p305a.C6000g;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;
import expo.p304a.p305a.p306a.C5993b;
import expo.p307b.p316i.C6036a;
import expo.p307b.p316i.C6037b;

public abstract class BaseSensorModule extends C6006c implements SensorEventListener2, C6000g, C6001h {
    private boolean mIsObserving = null;
    private C6007d mModuleRegistry;
    private C6037b mSensorServiceSubscription;

    protected abstract Bundle eventToMap(SensorEvent sensorEvent);

    protected abstract String getEventName();

    protected abstract C6036a getSensorService();

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onFlushCompleted(Sensor sensor) {
    }

    BaseSensorModule(Context context) {
        super(context);
    }

    C6007d getModuleRegistry() {
        return this.mModuleRegistry;
    }

    public void setModuleRegistry(C6007d c6007d) {
        if (!(this.mModuleRegistry == null || this.mModuleRegistry.m25133a(C5993b.class) == null)) {
            ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).unregisterLifecycleEventListener(this);
        }
        this.mModuleRegistry = c6007d;
        if (this.mModuleRegistry != null && this.mModuleRegistry.m25133a(C5993b.class) != null) {
            ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).registerLifecycleEventListener(this);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        C5991a c5991a = (C5991a) this.mModuleRegistry.m25133a(C5991a.class);
        if (c5991a != null) {
            c5991a.mo5142a(getEventName(), eventToMap(sensorEvent));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not emit ");
        stringBuilder.append(getEventName());
        stringBuilder.append(" event, no event emitter present.");
        Log.e("E_SENSOR_MODULE", stringBuilder.toString());
    }

    public void setUpdateInterval(int i) {
        getSensorKernelServiceSubscription().setUpdateInterval((long) i);
    }

    private C6037b getSensorKernelServiceSubscription() {
        if (this.mSensorServiceSubscription != null) {
            return this.mSensorServiceSubscription;
        }
        this.mSensorServiceSubscription = getSensorService().createSubscriptionForListener(this);
        return this.mSensorServiceSubscription;
    }

    public void startObserving() {
        this.mIsObserving = true;
        getSensorKernelServiceSubscription().start();
    }

    public void stopObserving() {
        this.mIsObserving = false;
        getSensorKernelServiceSubscription().stop();
    }

    public void onHostResume() {
        if (this.mIsObserving) {
            getSensorKernelServiceSubscription().start();
        }
    }

    public void onHostPause() {
        getSensorKernelServiceSubscription().stop();
    }

    public void onHostDestroy() {
        getSensorKernelServiceSubscription().release();
    }
}
