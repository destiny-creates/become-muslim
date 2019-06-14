package versioned.host.exp.exponent.modules.universal.sensors;

import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7384d;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.p342b.C8176k;
import java.util.Collections;
import java.util.List;

public class ScopedLinearAccelerationSensorService extends BaseSensorService implements C5998e, C7384d {
    public ScopedLinearAccelerationSensorService(C6330b c6330b) {
        super(c6330b);
    }

    protected C8176k getSensorKernelService() {
        return getKernelServiceRegistry().m26038g();
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7384d.class);
    }
}
