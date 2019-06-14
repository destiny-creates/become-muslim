package versioned.host.exp.exponent.modules.universal.sensors;

import expo.p304a.p305a.C5998e;
import expo.p307b.p316i.p388a.C7385e;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.p342b.C8176k;
import java.util.Collections;
import java.util.List;

public class ScopedMagnetometerService extends BaseSensorService implements C5998e, C7385e {
    public ScopedMagnetometerService(C6330b c6330b) {
        super(c6330b);
    }

    protected C8176k getSensorKernelService() {
        return getKernelServiceRegistry().m26034c();
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C7385e.class);
    }
}
