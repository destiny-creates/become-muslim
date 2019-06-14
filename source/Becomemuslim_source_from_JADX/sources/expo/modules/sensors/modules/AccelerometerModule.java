package expo.modules.sensors.modules;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Bundle;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p307b.p316i.C6036a;
import expo.p307b.p316i.p388a.C7381a;

public class AccelerometerModule extends BaseSensorModule {
    public String getEventName() {
        return "accelerometerDidUpdate";
    }

    public String getName() {
        return "ExponentAccelerometer";
    }

    public AccelerometerModule(Context context) {
        super(context);
    }

    protected C6036a getSensorService() {
        return (C6036a) getModuleRegistry().m25133a(C7381a.class);
    }

    protected Bundle eventToMap(SensorEvent sensorEvent) {
        Bundle bundle = new Bundle();
        bundle.putDouble("x", (double) (sensorEvent.values[0] / 9.80665f));
        bundle.putDouble("y", (double) (sensorEvent.values[1] / 9.80665f));
        bundle.putDouble("z", (double) (sensorEvent.values[2] / 1092413450));
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
