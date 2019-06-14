package expo.modules.taskManager;

import android.content.Context;
import android.os.Handler;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p307b.p317j.C6041e;
import expo.p307b.p317j.C7390g;
import java.util.HashMap;
import java.util.Map;

public class TaskManagerModule extends C6006c implements C6001h {
    static String EVENT_NAME = "TaskManager.executeTask";
    static String E_TASK_SERVICE_NOT_FOUND = "E_TASK_SERVICE_NOT_FOUND";
    private C6041e mTaskManagerInternal;
    private C7390g mTaskService;

    /* renamed from: expo.modules.taskManager.TaskManagerModule$1 */
    class C61361 implements Runnable {
        C61361() {
        }

        public void run() {
            if (TaskManagerModule.this.mTaskManagerInternal != null) {
                TaskManagerModule.this.mTaskManagerInternal.flushQueuedEvents();
            }
        }
    }

    public String getName() {
        return "ExpoTaskManager";
    }

    public TaskManagerModule(Context context) {
        super(context);
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("EVENT_NAME", EVENT_NAME);
        return hashMap;
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mTaskService = (C7390g) c6007d.m25134a("TaskService", C7390g.class);
        this.mTaskManagerInternal = (C6041e) c6007d.m25133a(C6041e.class);
    }

    @C5996c
    public void notifyTaskFinishedAsync(String str, Map<String, Object> map, C6009f c6009f) {
        if (checkTaskService(c6009f)) {
            this.mTaskService.notifyTaskFinished(str, getAppId(), map);
            c6009f.mo5137a((Object) null);
        }
    }

    @C5996c
    public void isTaskRegisteredAsync(String str, C6009f c6009f) {
        if (checkTaskService(c6009f)) {
            c6009f.mo5137a(Boolean.valueOf(this.mTaskService.hasRegisteredTask(str, getAppId())));
        }
    }

    @C5996c
    public void getTaskOptionsAsync(String str, C6009f c6009f) {
        if (checkTaskService(c6009f)) {
            c6009f.mo5137a(this.mTaskService.getTaskOptions(str, getAppId()));
        }
    }

    @C5996c
    public void getRegisteredTasksAsync(C6009f c6009f) {
        if (checkTaskService(c6009f)) {
            c6009f.mo5137a(this.mTaskService.getTasksForAppId(getAppId()));
        }
    }

    @C5996c
    public void unregisterTaskAsync(String str, C6009f c6009f) {
        if (checkTaskService(c6009f)) {
            try {
                this.mTaskService.unregisterTask(str, getAppId(), null);
                c6009f.mo5137a(null);
            } catch (Throwable e) {
                c6009f.m25155a(e);
            }
        }
    }

    @C5996c
    public void unregisterAllTasksAsync(C6009f c6009f) {
        if (checkTaskService(c6009f)) {
            try {
                this.mTaskService.unregisterAllTasksForAppId(getAppId());
                c6009f.mo5137a(null);
            } catch (Throwable e) {
                c6009f.m25155a(e);
            }
        }
    }

    @C5996c
    public void startObserving(C6009f c6009f) {
        new Handler().postDelayed(new C61361(), 1000);
        c6009f.mo5137a(null);
    }

    @C5996c
    public void stopObserving(C6009f c6009f) {
        c6009f.mo5137a(null);
    }

    private String getAppId() {
        return this.mTaskManagerInternal.getAppId();
    }

    private boolean checkTaskService(C6009f c6009f) {
        if (this.mTaskService != null) {
            return true;
        }
        c6009f.m25152a(E_TASK_SERVICE_NOT_FOUND, "Unable to find TaskService singleton module in module registry.");
        return null;
    }
}
