package expo.modules.sensors.modules;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Bundle;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p307b.p316i.C6036a;
import expo.p307b.p316i.p388a.C7386f;

public class MagnetometerUncalibratedModule extends BaseSensorModule {
    public String getEventName() {
        return "magnetometerUncalibratedDidUpdate";
    }

    public String getName() {
        return "ExponentMagnetometerUncalibrated";
    }

    public MagnetometerUncalibratedModule(Context context) {
        super(context);
    }

    protected C6036a getSensorService() {
        return (C6036a) getModuleRegistry().m25133a(C7386f.class);
    }

    protected Bundle eventToMap(SensorEvent sensorEvent) {
        Bundle bundle = new Bundle();
        bundle.putDouble("x", (double) sensorEvent.values[0]);
        bundle.putDouble("y", (double) sensorEvent.values[1]);
        bundle.putDouble("z", (double) sensorEvent.values[2]);
        return bundle;
    }

    @C5996c
    public void startObserving(C6009f c6009f) {
        super.startObserving();
        c6009f.mo5137a(null);
    }

    @C5996c
    public void stopObserving(C6009f c6009f) {
        super.stopObserving();
        c6009f.mo5137a(null);
    }

    @C5996c
    public void setUpdateInterval(int i, C6009f c6009f) {
        super.setUpdateInterval(i);
        c6009f.mo5137a((Object) 0);
    }
}
