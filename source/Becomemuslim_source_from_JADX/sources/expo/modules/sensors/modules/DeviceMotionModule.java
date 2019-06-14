package expo.modules.sensors.modules;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;
import com.facebook.imagepipeline.common.RotationOptions;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;
import expo.p304a.p305a.p306a.C5993b;
import expo.p307b.p316i.C6036a;
import expo.p307b.p316i.C6037b;
import expo.p307b.p316i.p388a.C7381a;
import expo.p307b.p316i.p388a.C7382b;
import expo.p307b.p316i.p388a.C7383c;
import expo.p307b.p316i.p388a.C7384d;
import expo.p307b.p316i.p388a.C7388h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceMotionModule extends C6006c implements SensorEventListener2, C6001h {
    private SensorEvent mAccelerationEvent;
    private SensorEvent mAccelerationIncludingGravityEvent;
    private ScheduleDispatchFrameCallback mCurrentFrameCallback = new ScheduleDispatchFrameCallback();
    private DispatchEventRunnable mDispatchEventRunnable = new DispatchEventRunnable();
    private C5991a mEventEmitter;
    private SensorEvent mGravityEvent;
    private long mLastUpdate = 0;
    private C6007d mModuleRegistry = null;
    private SensorEvent mRotationEvent;
    private float[] mRotationMatrix = new float[9];
    private SensorEvent mRotationRateEvent;
    private float[] mRotationResult = new float[3];
    private List<C6037b> mServiceSubscriptions = null;
    private C5993b mUiManager = null;
    private int mUpdateInterval = 100;

    /* renamed from: expo.modules.sensors.modules.DeviceMotionModule$1 */
    class C61311 extends HashMap<String, Object> {
        C61311() {
            put("Gravity", Double.valueOf(9.81d));
        }
    }

    private class DispatchEventRunnable implements Runnable {
        private DispatchEventRunnable() {
        }

        public void run() {
            DeviceMotionModule.this.mEventEmitter.mo5142a("deviceMotionDidUpdate", DeviceMotionModule.this.eventsToMap());
        }
    }

    private class ScheduleDispatchFrameCallback implements FrameCallback {
        private volatile boolean mIsPosted;
        private boolean mShouldStop;

        /* renamed from: expo.modules.sensors.modules.DeviceMotionModule$ScheduleDispatchFrameCallback$1 */
        class C61331 implements Runnable {
            C61331() {
            }

            public void run() {
                ScheduleDispatchFrameCallback.this.maybePost();
            }
        }

        private ScheduleDispatchFrameCallback() {
            this.mIsPosted = false;
            this.mShouldStop = false;
        }

        public void doFrame(long j) {
            if (this.mShouldStop != null) {
                this.mIsPosted = 0;
            } else {
                post();
            }
            j = System.currentTimeMillis();
            if (j - DeviceMotionModule.this.mLastUpdate > ((long) DeviceMotionModule.this.mUpdateInterval)) {
                DeviceMotionModule.this.mUiManager.runOnClientCodeQueueThread(DeviceMotionModule.this.mDispatchEventRunnable);
                DeviceMotionModule.this.mLastUpdate = j;
            }
        }

        public void stop() {
            this.mShouldStop = true;
        }

        public void maybePost() {
            if (!this.mIsPosted) {
                this.mIsPosted = true;
                post();
            }
        }

        private void post() {
            Choreographer.getInstance().postFrameCallback(DeviceMotionModule.this.mCurrentFrameCallback);
        }

        public void maybePostFromNonUI() {
            if (!this.mIsPosted) {
                DeviceMotionModule.this.mUiManager.runOnUiQueueThread(new C61331());
            }
        }
    }

    public String getName() {
        return "ExponentDeviceMotion";
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onFlushCompleted(Sensor sensor) {
    }

    public DeviceMotionModule(Context context) {
        super(context);
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new C61311());
    }

    @C5996c
    public void setUpdateInterval(int i, C6009f c6009f) {
        this.mUpdateInterval = i;
        c6009f.mo5137a((Object) 0);
    }

    @C5996c
    public void startObserving(C6009f c6009f) {
        if (this.mServiceSubscriptions == null) {
            this.mServiceSubscriptions = new ArrayList();
            for (C6036a createSubscriptionForListener : getSensorKernelServices()) {
                C6037b createSubscriptionForListener2 = createSubscriptionForListener.createSubscriptionForListener(this);
                createSubscriptionForListener2.setUpdateInterval(0);
                this.mServiceSubscriptions.add(createSubscriptionForListener2);
            }
        }
        for (C6037b createSubscriptionForListener22 : this.mServiceSubscriptions) {
            createSubscriptionForListener22.start();
        }
        c6009f.mo5137a(null);
    }

    @C5996c
    public void stopObserving(final C6009f c6009f) {
        this.mUiManager.runOnUiQueueThread(new Runnable() {
            public void run() {
                for (C6037b stop : DeviceMotionModule.this.mServiceSubscriptions) {
                    stop.stop();
                }
                DeviceMotionModule.this.mCurrentFrameCallback.stop();
                c6009f.mo5137a(null);
            }
        });
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mEventEmitter = (C5991a) c6007d.m25133a(C5991a.class);
        this.mUiManager = (C5993b) c6007d.m25133a(C5993b.class);
        this.mModuleRegistry = c6007d;
    }

    private List<C6036a> getSensorKernelServices() {
        return Arrays.asList(new C6036a[]{(C6036a) this.mModuleRegistry.m25133a(C7383c.class), (C6036a) this.mModuleRegistry.m25133a(C7384d.class), (C6036a) this.mModuleRegistry.m25133a(C7381a.class), (C6036a) this.mModuleRegistry.m25133a(C7388h.class), (C6036a) this.mModuleRegistry.m25133a(C7382b.class)});
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() == 4) {
            this.mRotationRateEvent = sensorEvent;
        } else if (sensor.getType() == 1) {
            this.mAccelerationIncludingGravityEvent = sensorEvent;
        } else if (sensor.getType() == 10) {
            this.mAccelerationEvent = sensorEvent;
        } else if (sensor.getType() == 11) {
            this.mRotationEvent = sensorEvent;
        } else if (sensor.getType() == 9) {
            this.mGravityEvent = sensorEvent;
        }
        this.mCurrentFrameCallback.maybePostFromNonUI();
    }

    private Bundle eventsToMap() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        Bundle bundle4 = new Bundle();
        Bundle bundle5 = new Bundle();
        if (this.mAccelerationEvent != null) {
            bundle2.putDouble("x", (double) this.mAccelerationEvent.values[0]);
            bundle2.putDouble("y", (double) this.mAccelerationEvent.values[1]);
            bundle2.putDouble("z", (double) this.mAccelerationEvent.values[2]);
            bundle.putBundle("acceleration", bundle2);
        }
        if (!(this.mAccelerationIncludingGravityEvent == null || this.mGravityEvent == null)) {
            bundle3.putDouble("x", (double) (this.mAccelerationIncludingGravityEvent.values[0] - (this.mGravityEvent.values[0] * 2.0f)));
            bundle3.putDouble("y", (double) (this.mAccelerationIncludingGravityEvent.values[1] - (this.mGravityEvent.values[1] * 2.0f)));
            bundle3.putDouble("z", (double) (this.mAccelerationIncludingGravityEvent.values[2] - (this.mGravityEvent.values[2] * 2.0f)));
            bundle.putBundle("accelerationIncludingGravity", bundle3);
        }
        if (this.mRotationRateEvent != null) {
            bundle5.putDouble("alpha", (double) this.mRotationRateEvent.values[2]);
            bundle5.putDouble("beta", (double) this.mRotationRateEvent.values[0]);
            bundle5.putDouble("gamma", (double) this.mRotationRateEvent.values[1]);
            bundle.putBundle("rotationRate", bundle5);
        }
        if (this.mRotationEvent != null) {
            SensorManager.getRotationMatrixFromVector(this.mRotationMatrix, this.mRotationEvent.values);
            SensorManager.getOrientation(this.mRotationMatrix, this.mRotationResult);
            bundle4.putDouble("alpha", (double) (-this.mRotationResult[0]));
            bundle4.putDouble("beta", (double) (-this.mRotationResult[1]));
            bundle4.putDouble("gamma", (double) this.mRotationResult[2]);
            bundle.putBundle("rotation", bundle4);
        }
        bundle.putInt("orientation", getOrientation());
        return bundle;
    }

    private int getOrientation() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            switch (windowManager.getDefaultDisplay().getRotation()) {
                case 0:
                    return 0;
                case 1:
                    return 90;
                case 2:
                    return RotationOptions.ROTATE_180;
                case 3:
                    return -90;
                default:
                    break;
            }
        }
        return 0;
    }
}
