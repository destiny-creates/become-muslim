package versioned.host.exp.exponent.modules.api;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.C4890j;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2774a;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.C2987c;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.C4801a;
import com.google.android.gms.fitness.data.C4803c;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.p187a.C2970c;
import com.google.android.gms.fitness.p187a.C2972d.C2971a;
import com.google.android.gms.fitness.p187a.C4792a.C2968a;
import com.google.android.gms.fitness.p187a.C4793b.C2969a;
import com.google.android.gms.fitness.p188b.C4799a;
import com.google.android.gms.fitness.p188b.C4800b;
import host.exp.exponent.experience.ExperienceActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PedometerModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static String TAG = "PedometerModule";
    private static Map<String, GoogleApiClient> sInstanceMap = new HashMap();
    private GoogleApiClient mClient;
    private C2970c mListener;
    private int mWatchTotalSteps = 0;

    /* renamed from: versioned.host.exp.exponent.modules.api.PedometerModule$1 */
    class C77441 implements C2776c {
        public void onConnectionFailed(C4775b c4775b) {
        }

        C77441() {
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.PedometerModule$2 */
    class C77452 implements C2775b {
        public void onConnected(Bundle bundle) {
        }

        public void onConnectionSuspended(int i) {
        }

        C77452() {
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.PedometerModule$3 */
    class C77463 implements C2815l<Status> {
        public void onResult(Status status) {
        }

        C77463() {
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.PedometerModule$5 */
    class C77475 implements C2970c {
        C77475() {
        }

        public void onDataPoint(DataPoint dataPoint) {
            dataPoint = dataPoint.a(C4803c.f13506d);
            WritableMap createMap = Arguments.createMap();
            PedometerModule.this.mWatchTotalSteps = PedometerModule.this.mWatchTotalSteps + dataPoint.c();
            createMap.putInt("steps", PedometerModule.this.mWatchTotalSteps);
            ((RCTDeviceEventEmitter) PedometerModule.this.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("Exponent.pedometerUpdate", createMap);
        }
    }

    public String getName() {
        return "ExponentPedometer";
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public PedometerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void assertApiClient() {
        if (this.mClient == null) {
            if (sInstanceMap.get(getExperienceId()) != null) {
                this.mClient = (GoogleApiClient) sInstanceMap.get(getExperienceId());
                return;
            }
            this.mClient = new C2774a(getReactApplicationContext()).a(C2987c.f7650h).a(C2987c.f7644b).a(C2987c.f7646d).a(new Scope("https://www.googleapis.com/auth/fitness.activity.read")).a(new C77452()).a((C4890j) Assertions.assertNotNull((C4890j) getCurrentActivity()), 0, new C77441()).b();
            sInstanceMap.put(getExperienceId(), this.mClient);
            C2987c.f7647e.a(this.mClient, DataType.f13418a).a(new C77463());
        }
    }

    @ReactMethod
    public void getStepCountAsync(double d, double d2, Promise promise) {
        assertApiClient();
        final double d3 = d;
        final double d4 = d2;
        final Promise promise2 = promise;
        AsyncTask.execute(new Runnable() {
            public void run() {
                int i = 0;
                for (Bucket a : ((C4799a) C2987c.f7651i.a(PedometerModule.this.mClient, new C2968a().a(DataType.f13406O, DataType.f13406O).a(1, TimeUnit.DAYS).a((long) d3, (long) d4, TimeUnit.MILLISECONDS).a()).a(1, TimeUnit.MINUTES)).c()) {
                    for (DataPoint a2 : a.a(DataType.f13418a).c()) {
                        i += a2.a(C4803c.f13506d).c();
                    }
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("steps", i);
                promise2.resolve(createMap);
            }
        });
    }

    @ReactMethod
    public void watchStepCount() {
        assertApiClient();
        stopWatchingStepCount();
        this.mWatchTotalSteps = 0;
        this.mListener = new C77475();
        C2987c.f7645c.a(this.mClient, new C2971a().a(DataType.f13418a).a(5, TimeUnit.SECONDS).a(), this.mListener);
    }

    @ReactMethod
    public void stopWatchingStepCount() {
        assertApiClient();
        if (this.mListener != null) {
            C2987c.f7645c.a(this.mClient, this.mListener);
        }
    }

    @ReactMethod
    public void isAvailableAsync(final Promise promise) {
        assertApiClient();
        C2987c.f7645c.a(this.mClient, new C2969a().a(new DataType[]{DataType.f13418a}).a()).a(new C2815l<C4800b>() {
            public void onResult(C4800b c4800b) {
                if (c4800b.b().d()) {
                    for (C4801a a : c4800b.a()) {
                        if (a.a().equals(DataType.f13418a)) {
                            promise.resolve(Boolean.valueOf(true));
                            return;
                        }
                    }
                    promise.resolve(Boolean.valueOf(false));
                    return;
                }
                promise.reject("E_PEDOMETER", "Failed to determine if the pedometer is available.");
            }
        });
    }

    public void onHostDestroy() {
        sInstanceMap.remove(getExperienceId());
    }

    private String getExperienceId() {
        ExperienceActivity experienceActivity = (ExperienceActivity) getCurrentActivity();
        return experienceActivity != null ? experienceActivity.m44609r() : null;
    }
}
