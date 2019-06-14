package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7383c;
import java.util.Collections;
import java.util.List;

public class GyroscopeService extends SubscribableSensorService implements C5998e, C7383c {
    int getSensorType() {
        return 4;
    }

    public GyroscopeService(Context context) {
        super(context);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7383c.class);
    }
}
