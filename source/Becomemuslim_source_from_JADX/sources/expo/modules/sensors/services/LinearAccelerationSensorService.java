package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7384d;
import java.util.Collections;
import java.util.List;

public class LinearAccelerationSensorService extends SubscribableSensorService implements C5998e, C7384d {
    int getSensorType() {
        return 10;
    }

    public LinearAccelerationSensorService(Context context) {
        super(context);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7384d.class);
    }
}
