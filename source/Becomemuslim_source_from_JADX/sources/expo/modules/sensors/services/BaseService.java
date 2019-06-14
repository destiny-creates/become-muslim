package expo.modules.sensors.services;

import android.content.Context;
import expo.p304a.C6007d;
import expo.p304a.p305a.C6000g;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;

abstract class BaseService implements C6000g, C6001h {
    private Context mContext;
    private boolean mIsForegrounded = false;
    private C6007d mModuleRegistry;

    public abstract void onExperienceBackgrounded();

    public abstract void onExperienceForegrounded();

    public void onHostDestroy() {
    }

    BaseService(Context context) {
        this.mContext = context;
    }

    protected Context getContext() {
        return this.mContext;
    }

    public void setModuleRegistry(C6007d c6007d) {
        if (!(this.mModuleRegistry == null || this.mModuleRegistry.m25133a(C5993b.class) == null)) {
            ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).unregisterLifecycleEventListener(this);
        }
        this.mModuleRegistry = c6007d;
        if (this.mModuleRegistry != null && this.mModuleRegistry.m25133a(C5993b.class) != null) {
            ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).registerLifecycleEventListener(this);
        }
    }

    public void onHostResume() {
        this.mIsForegrounded = true;
        onExperienceForegrounded();
    }

    public void onHostPause() {
        this.mIsForegrounded = false;
        onExperienceBackgrounded();
    }

    boolean getExperienceIsForegrounded() {
        return this.mIsForegrounded;
    }
}
