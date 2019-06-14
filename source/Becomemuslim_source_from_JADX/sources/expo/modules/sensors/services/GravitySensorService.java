package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7382b;
import java.util.Collections;
import java.util.List;

public class GravitySensorService extends SubscribableSensorService implements C5998e, C7382b {
    int getSensorType() {
        return 9;
    }

    public GravitySensorService(Context context) {
        super(context);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7382b.class);
    }
}
