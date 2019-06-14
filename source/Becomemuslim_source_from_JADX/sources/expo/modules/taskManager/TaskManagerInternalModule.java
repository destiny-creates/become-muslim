package expo.modules.taskManager;

import android.content.Context;
import android.os.Bundle;
import expo.p304a.C6007d;
import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;
import expo.p307b.p310c.C6023a;
import expo.p307b.p317j.C6041e;
import expo.p307b.p317j.C7390g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TaskManagerInternalModule implements C5998e, C6001h, C6041e {
    private C6023a mConstants;
    private WeakReference<Context> mContextRef;
    private C5991a mEventEmitter;
    private List<Bundle> mEventsQueue = new ArrayList();
    private C7390g mTaskService;

    public TaskManagerInternalModule(Context context) {
        this.mContextRef = new WeakReference(context);
    }

    public List<Class> getExportedInterfaces() {
        return Arrays.asList(new Class[]{C6041e.class});
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mEventEmitter = (C5991a) c6007d.m25133a(C5991a.class);
        this.mConstants = (C6023a) c6007d.m25133a(C6023a.class);
        this.mTaskService = (C7390g) c6007d.m25134a("TaskService", C7390g.class);
        this.mTaskService.setTaskManager(this, getAppId(), getAppUrl());
    }

    public void registerTask(String str, Class cls, Map<String, Object> map) {
        checkTaskService();
        this.mTaskService.registerTask(str, getAppId(), getAppUrl(), cls, map);
    }

    public void unregisterTask(String str, Class cls) {
        checkTaskService();
        this.mTaskService.unregisterTask(str, getAppId(), cls);
    }

    public void executeTaskWithBody(Bundle bundle) {
        if (this.mEventsQueue != null) {
            this.mEventsQueue.add(bundle);
        } else {
            this.mEventEmitter.mo5142a(TaskManagerModule.EVENT_NAME, bundle);
        }
    }

    public boolean taskHasConsumerOfClass(String str, Class cls) {
        if (this.mTaskService == null) {
            return null;
        }
        return this.mTaskService.taskHasConsumerOfClass(str, getAppId(), cls);
    }

    public void flushQueuedEvents() {
        if (this.mEventsQueue != null) {
            for (Bundle a : this.mEventsQueue) {
                this.mEventEmitter.mo5142a(TaskManagerModule.EVENT_NAME, a);
            }
            this.mEventsQueue = null;
        }
    }

    public String getAppId() {
        return this.mConstants != null ? this.mConstants.getAppId() : null;
    }

    public boolean isRunningInHeadlessMode() {
        return this.mConstants != null ? ((Boolean) this.mConstants.getConstants().get("isHeadless")).booleanValue() : false;
    }

    private String getAppUrl() {
        if (this.mConstants != null) {
            String str = (String) this.mConstants.getConstants().get("experienceUrl");
            if (str != null) {
                return str;
            }
        }
        Context context = (Context) this.mContextRef.get();
        return context != null ? context.getPackageName() : null;
    }

    private void checkTaskService() {
        if (this.mTaskService == null) {
            throw new IllegalStateException("Unable to find TaskService singleton module in module registry.");
        }
    }
}
