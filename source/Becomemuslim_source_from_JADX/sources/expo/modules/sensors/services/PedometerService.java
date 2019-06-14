package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7387g;
import java.util.Collections;
import java.util.List;

public class PedometerService extends SubscribableSensorService implements C5998e, C7387g {
    int getSensorType() {
        return 19;
    }

    public PedometerService(Context context) {
        super(context);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7387g.class);
    }
}
