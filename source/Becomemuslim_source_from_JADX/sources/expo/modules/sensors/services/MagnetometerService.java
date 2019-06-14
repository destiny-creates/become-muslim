package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7385e;
import java.util.Collections;
import java.util.List;

public class MagnetometerService extends SubscribableSensorService implements C5998e, C7385e {
    int getSensorType() {
        return 2;
    }

    public MagnetometerService(Context context) {
        super(context);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7385e.class);
    }
}
