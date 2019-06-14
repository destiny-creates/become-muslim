package versioned.host.exp.exponent.modules.universal.sensors;

import expo.p307b.p316i.C6037b;
import host.exp.exponent.p339f.p340a.p342b.C6326j;

public class SensorSubscription implements C6037b {
    private C6326j mSensorKernelServiceSubscription;

    public SensorSubscription(C6326j c6326j) {
        this.mSensorKernelServiceSubscription = c6326j;
    }

    public void start() {
        this.mSensorKernelServiceSubscription.m26016a();
    }

    public boolean isEnabled() {
        return this.mSensorKernelServiceSubscription.m26018b();
    }

    public Long getUpdateInterval() {
        return this.mSensorKernelServiceSubscription.m26020d();
    }

    public void setUpdateInterval(long j) {
        this.mSensorKernelServiceSubscription.m26017a(j);
    }

    public void stop() {
        this.mSensorKernelServiceSubscription.m26022f();
    }

    public void release() {
        this.mSensorKernelServiceSubscription.m26023g();
    }
}
