package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7386f;
import java.util.Collections;
import java.util.List;

public class MagnetometerUncalibratedService extends SubscribableSensorService implements C5998e, C7386f {
    int getSensorType() {
        return 14;
    }

    public MagnetometerUncalibratedService(Context context) {
        super(context);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7386f.class);
    }
}
