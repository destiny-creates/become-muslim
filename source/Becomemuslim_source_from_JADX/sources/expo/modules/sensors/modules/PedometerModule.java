package expo.modules.sensors.modules;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Bundle;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p307b.p316i.C6036a;
import expo.p307b.p316i.p388a.C7387g;

public class PedometerModule extends BaseSensorModule {
    private Integer stepsAtTheBeginning = null;

    public String getEventName() {
        return "Exponent.pedometerUpdate";
    }

    public String getName() {
        return "ExponentPedometer";
    }

    public PedometerModule(Context context) {
        super(context);
    }

    protected C6036a getSensorService() {
        return (C6036a) getModuleRegistry().m25133a(C7387g.class);
    }

    protected Bundle eventToMap(SensorEvent sensorEvent) {
        if (this.stepsAtTheBeginning == null) {
            this.stepsAtTheBeginning = Integer.valueOf(((int) sensorEvent.values[0]) - 1);
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("steps", (double) (sensorEvent.values[0] - ((float) this.stepsAtTheBeginning.intValue())));
        return bundle;
    }

    @C5996c
    public void startObserving(C6009f c6009f) {
        super.startObserving();
        this.stepsAtTheBeginning = null;
        c6009f.mo5137a(null);
    }

    @C5996c
    public void stopObserving(C6009f c6009f) {
        super.stopObserving();
        this.stepsAtTheBeginning = null;
        c6009f.mo5137a(null);
    }

    @C5996c
    public void setUpdateInterval(int i, C6009f c6009f) {
        super.setUpdateInterval(i);
        c6009f.mo5137a((Object) 0);
    }

    @C5996c
    public void isAvailableAsync(C6009f c6009f) {
        c6009f.mo5137a(Boolean.valueOf(getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")));
    }

    @C5996c
    public void getStepCountAsync(Integer num, Integer num2, C6009f c6009f) {
        c6009f.m25152a("E_NOT_AVAILABLE", "Getting step count for date range is not supported on Android yet.");
    }
}
