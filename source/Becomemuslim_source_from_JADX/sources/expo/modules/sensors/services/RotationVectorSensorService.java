package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7388h;
import java.util.Collections;
import java.util.List;

public class RotationVectorSensorService extends SubscribableSensorService implements C5998e, C7388h {
    int getSensorType() {
        return 11;
    }

    public RotationVectorSensorService(Context context) {
        super(context);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7388h.class);
    }
}
