package host.exp.exponent.p346j;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;

/* compiled from: ScopedApplicationContext */
/* renamed from: host.exp.exponent.j.i */
public class C6392i extends Application {
    /* renamed from: a */
    private Application f20687a;

    public C6392i(Application application, C6393j c6393j) {
        this.f20687a = application;
        attachBaseContext(c6393j);
    }

    public void onCreate() {
        this.f20687a.onCreate();
    }

    public void onTerminate() {
        this.f20687a.onTerminate();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f20687a.onConfigurationChanged(configuration);
    }

    public void onLowMemory() {
        this.f20687a.onLowMemory();
    }

    public void onTrimMemory(int i) {
        this.f20687a.onTrimMemory(i);
    }

    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f20687a.registerComponentCallbacks(componentCallbacks);
    }

    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f20687a.unregisterComponentCallbacks(componentCallbacks);
    }

    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f20687a.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f20687a.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
        this.f20687a.registerOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
        this.f20687a.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
    }
}
