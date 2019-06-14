package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7381a;
import java.util.Collections;
import java.util.List;

public class AccelerometerService extends SubscribableSensorService implements C5998e, C7381a {
    int getSensorType() {
        return 1;
    }

    public AccelerometerService(Context context) {
        super(context);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7381a.class);
    }
}
