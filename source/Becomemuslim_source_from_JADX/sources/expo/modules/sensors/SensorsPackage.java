package expo.modules.sensors;

import android.content.Context;
import expo.modules.sensors.modules.AccelerometerModule;
import expo.modules.sensors.modules.DeviceMotionModule;
import expo.modules.sensors.modules.GyroscopeModule;
import expo.modules.sensors.modules.MagnetometerModule;
import expo.modules.sensors.modules.MagnetometerUncalibratedModule;
import expo.modules.sensors.modules.PedometerModule;
import expo.modules.sensors.services.AccelerometerService;
import expo.modules.sensors.services.GravitySensorService;
import expo.modules.sensors.services.GyroscopeService;
import expo.modules.sensors.services.LinearAccelerationSensorService;
import expo.modules.sensors.services.MagnetometerService;
import expo.modules.sensors.services.MagnetometerUncalibratedService;
import expo.modules.sensors.services.PedometerService;
import expo.modules.sensors.services.RotationVectorSensorService;
import expo.p304a.C6006c;
import expo.p304a.C7369b;
import expo.p304a.p305a.C5998e;
import java.util.Arrays;
import java.util.List;

public class SensorsPackage extends C7369b {
    public List<C5998e> createInternalModules(Context context) {
        return Arrays.asList(new C5998e[]{new AccelerometerService(context), new GravitySensorService(context), new GyroscopeService(context), new LinearAccelerationSensorService(context), new MagnetometerService(context), new MagnetometerUncalibratedService(context), new RotationVectorSensorService(context), new PedometerService(context)});
    }

    public List<C6006c> createExportedModules(Context context) {
        return Arrays.asList(new C6006c[]{new AccelerometerModule(context), new GyroscopeModule(context), new DeviceMotionModule(context), new MagnetometerModule(context), new MagnetometerUncalibratedModule(context), new PedometerModule(context)});
    }
}
