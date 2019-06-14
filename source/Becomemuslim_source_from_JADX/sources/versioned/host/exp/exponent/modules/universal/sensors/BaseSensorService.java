package versioned.host.exp.exponent.modules.universal.sensors;

import android.hardware.SensorEventListener2;
import expo.p307b.p316i.C6037b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.C6328c;
import host.exp.exponent.p339f.p340a.p342b.C8176k;
import javax.inject.C6562a;

public abstract class BaseSensorService {
    private C6330b mExperienceId;
    @C6562a
    protected C6328c mKernelServiceRegistry;

    protected abstract C8176k getSensorKernelService();

    public BaseSensorService(C6330b c6330b) {
        this.mExperienceId = c6330b;
        C6294a.m25957a().m25961b(BaseSensorService.class, this);
    }

    protected C6330b getExperienceId() {
        return this.mExperienceId;
    }

    protected C6328c getKernelServiceRegistry() {
        return this.mKernelServiceRegistry;
    }

    public C6037b createSubscriptionForListener(SensorEventListener2 sensorEventListener2) {
        return new SensorSubscription(getSensorKernelService().m39710a(getExperienceId(), new ScopedSensorEventListener(sensorEventListener2)));
    }
}
