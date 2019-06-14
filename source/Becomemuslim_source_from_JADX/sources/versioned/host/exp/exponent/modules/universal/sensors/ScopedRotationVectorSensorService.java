package versioned.host.exp.exponent.modules.universal.sensors;

import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7388h;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.p342b.C8176k;
import java.util.Collections;
import java.util.List;

public class ScopedRotationVectorSensorService extends BaseSensorService implements C5998e, C7388h {
    public ScopedRotationVectorSensorService(C6330b c6330b) {
        super(c6330b);
    }

    protected C8176k getSensorKernelService() {
        return getKernelServiceRegistry().m26037f();
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7388h.class);
    }
}
