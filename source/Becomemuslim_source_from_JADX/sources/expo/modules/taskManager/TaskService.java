package expo.modules.taskManager;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import expo.modules.taskManager.exceptions.InvalidConsumerClassException;
import expo.modules.taskManager.exceptions.TaskNotFoundException;
import expo.modules.taskManager.exceptions.TaskRegisteringFailedException;
import expo.p304a.p305a.C6003j;
import expo.p307b.p317j.C6038b;
import expo.p307b.p317j.C6039c;
import expo.p307b.p317j.C6040d;
import expo.p307b.p317j.C6041e;
import expo.p307b.p317j.C6042f;
import expo.p307b.p317j.C7390g;
import expo.p318c.p319a.C6047a;
import expo.p318c.p319a.C6047a.C6043a;
import expo.p318c.p319a.p320a.C6044a;
import expo.p318c.p319a.p320a.C6046c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class TaskService implements C6003j, C7390g {
    private static final int MAX_TASK_EXECUTION_TIME_MS = 15000;
    private static final String SHARED_PREFERENCES_NAME = "TaskManagerModule";
    private static final String TAG = "TaskService";
    private static final Map<String, C6046c> sAppRecords = new HashMap();
    private static final Map<String, List<String>> sEvents = new HashMap();
    private static final Map<String, List<Bundle>> sEventsQueues = new HashMap();
    private static final Map<String, WeakReference<C6041e>> sHeadlessTaskManagers = new HashMap();
    private static final Map<String, C6039c> sTaskCallbacks = new HashMap();
    private static final Map<String, WeakReference<C6041e>> sTaskManagers = new HashMap();
    private static Map<String, Map<String, C6040d>> sTasksTable;
    private WeakReference<Context> mContextRef;

    public String getName() {
        return TAG;
    }

    public TaskService(Context context) {
        this.mContextRef = new WeakReference(context);
        if (sTasksTable == null) {
            sTasksTable = new HashMap();
            restoreTasks();
        }
    }

    public boolean hasRegisteredTask(String str, String str2) {
        return getTask(str, str2) != null ? true : null;
    }

    public void registerTask(String str, String str2, String str3, Class cls, Map<String, Object> map) {
        C6040d task = getTask(str, str2);
        Class unversionedClassForClass = unversionedClassForClass(cls);
        if (task == null || unversionedClassForClass == null || !unversionedClassForClass.isInstance(task.getConsumer())) {
            internalRegisterTask(str, str2, str3, cls, map);
        } else {
            task.setOptions(map);
            task.getConsumer().setOptions(map);
        }
        saveTasksForAppWithId(str2);
    }

    public void unregisterTask(String str, String str2, Class cls) {
        C6040d task = getTask(str, str2);
        cls = unversionedClassForClass(cls);
        if (task != null) {
            if (cls != null) {
                if (cls.isInstance(task.getConsumer()) == null) {
                    throw new InvalidConsumerClassException(str);
                }
            }
            Map map = (Map) sTasksTable.get(str2);
            if (map != null) {
                map.remove(str);
            }
            cls = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unregistering task '");
            stringBuilder.append(str);
            stringBuilder.append("' for app '");
            stringBuilder.append(str2);
            stringBuilder.append("'.");
            Log.i(cls, stringBuilder.toString());
            task.getConsumer().didUnregister();
            saveTasksForAppWithId(str2);
            return;
        }
        throw new TaskNotFoundException(str, str2);
    }

    public void unregisterAllTasksForAppId(String str) {
        Map map = (Map) sTasksTable.get(str);
        if (map != null) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unregistering all tasks for app '");
            stringBuilder.append(str);
            stringBuilder.append("'.");
            Log.i(str2, stringBuilder.toString());
            for (C6040d consumer : map.values()) {
                consumer.getConsumer().didUnregister();
            }
            map.clear();
            removeAppFromConfig(str);
        }
    }

    public boolean taskHasConsumerOfClass(String str, String str2, Class cls) {
        str = getTask(str, str2);
        return (str == null || unversionedClassForClass(cls).isInstance(str.getConsumer()) == null) ? null : true;
    }

    public Bundle getTaskOptions(String str, String str2) {
        str = getTask(str, str2);
        return str != null ? str.getOptionsBundle() : null;
    }

    public List<Bundle> getTasksForAppId(String str) {
        Map map = (Map) sTasksTable.get(str);
        List<Bundle> arrayList = new ArrayList();
        if (map != null) {
            for (C6040d c6040d : map.values()) {
                Bundle bundle = new Bundle();
                bundle.putString("taskName", c6040d.getName());
                bundle.putString("taskType", c6040d.getConsumer().taskType());
                bundle.putBundle("options", c6040d.getOptionsBundle());
                arrayList.add(bundle);
            }
        }
        return arrayList;
    }

    public void notifyTaskFinished(String str, final String str2, Map<String, Object> map) {
        String str3 = (String) map.get("eventId");
        List list = (List) sEvents.get(str2);
        String str4 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Finished task '");
        stringBuilder.append(str);
        stringBuilder.append("' with eventId '");
        stringBuilder.append(str3);
        stringBuilder.append("'.");
        Log.i(str4, stringBuilder.toString());
        if (list != null) {
            list.remove(str3);
            if (list.size() == null) {
                sEvents.remove(str2);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (!TaskService.sEvents.containsKey(str2)) {
                            TaskService.this.invalidateAppRecord(str2);
                        }
                    }
                }, 2000);
            }
        }
        C6039c c6039c = (C6039c) sTaskCallbacks.get(str3);
        if (c6039c != null) {
            c6039c.onFinished(map);
        }
    }

    public void setTaskManager(C6041e c6041e, String str, String str2) {
        boolean isRunningInHeadlessMode = c6041e.isRunningInHeadlessMode();
        (isRunningInHeadlessMode ? sHeadlessTaskManagers : sTaskManagers).put(str, new WeakReference(c6041e));
        List<Bundle> list = (List) sEventsQueues.get(str);
        if (list != null) {
            for (Bundle executeTaskWithBody : list) {
                c6041e.executeTaskWithBody(executeTaskWithBody);
            }
        }
        sEventsQueues.remove(str);
        if (!isRunningInHeadlessMode) {
            maybeUpdateAppUrlForAppId(str2, str);
        }
    }

    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        Uri data = intent.getData();
        if (TaskBroadcastReceiver.INTENT_ACTION.equals(action)) {
            if (data != null) {
                action = data.getQueryParameter("appId");
                String queryParameter = data.getQueryParameter("taskName");
                C6038b taskConsumer = getTaskConsumer(queryParameter, action);
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Handling TaskService intent with task name '");
                stringBuilder.append(queryParameter);
                stringBuilder.append("' for app with ID '");
                stringBuilder.append(action);
                stringBuilder.append("'.");
                Log.i(str, stringBuilder.toString());
                if (taskConsumer == null) {
                    Log.w(TAG, "Task or consumer not found.");
                    Integer valueOf = Integer.valueOf(data.getQueryParameter("intentId"));
                    Context context = (Context) this.mContextRef.get();
                    if (context != null) {
                        PendingIntent.getBroadcast(context, valueOf.intValue(), intent, 134217728).cancel();
                    }
                    return;
                }
                taskConsumer.didReceiveBroadcast(intent);
            }
        }
    }

    public boolean handleJob(JobService jobService, JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        String string = extras.getString("appId");
        String string2 = extras.getString("taskName");
        C6038b taskConsumer = getTaskConsumer(string2, string);
        TaskManagerUtils.removeFromPendingJobs(jobParameters.getJobId());
        if (taskConsumer == null) {
            Log.w(TAG, "Task or consumer not found.");
            return null;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Handling TaskService job with task name '");
        stringBuilder.append(string2);
        stringBuilder.append("' for app with ID '");
        stringBuilder.append(string);
        stringBuilder.append("'.");
        Log.i(str, stringBuilder.toString());
        boolean didExecuteJob = taskConsumer.didExecuteJob(jobService, jobParameters);
        if (didExecuteJob) {
            finishJobAfterTimeout(jobService, jobParameters, 15000);
        }
        return didExecuteJob;
    }

    public boolean cancelJob(JobService jobService, JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        String string = extras.getString("appId");
        String string2 = extras.getString("taskName");
        C6038b taskConsumer = getTaskConsumer(string2, string);
        TaskManagerUtils.removeFromPendingJobs(jobParameters.getJobId());
        if (taskConsumer == null) {
            return null;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Job for task '");
        stringBuilder.append(string2);
        stringBuilder.append("' has been cancelled by the system.");
        Log.i(str, stringBuilder.toString());
        return taskConsumer.didCancelJob(jobService, jobParameters);
    }

    public void executeTask(C6040d c6040d, Bundle bundle, Error error, C6039c c6039c) {
        C6041e taskManager = getTaskManager(c6040d.getAppId());
        bundle = createExecutionEventBody(c6040d, bundle, error);
        error = bundle.getBundle("executionInfo");
        if (error != null) {
            error = error.getString("eventId");
            String appId = c6040d.getAppId();
            List list = (List) sEvents.get(appId);
            if (c6039c != null) {
                sTaskCallbacks.put(error, c6039c);
            }
            if (list == null) {
                list = new ArrayList();
                list.add(error);
                sEvents.put(appId, list);
            } else {
                list.add(error);
            }
            if (taskManager != null) {
                taskManager.executeTaskWithBody(bundle);
                return;
            }
            if (sEventsQueues.containsKey(appId) == null) {
                sEventsQueues.put(appId, new ArrayList());
            }
            ((List) sEventsQueues.get(appId)).add(bundle);
            if (sAppRecords.containsKey(appId) == null && loadApp(appId, c6040d.getAppUrl()) == null) {
                try {
                    unregisterTask(c6040d.getName(), appId, null);
                } catch (C6040d c6040d2) {
                    Log.e(TAG, "Error occurred while unregistering invalid task.", c6040d2);
                }
                list.remove(error);
                sEventsQueues.remove(appId);
            }
        }
    }

    private void internalRegisterTask(String str, String str2, String str3, Class<C6038b> cls, Map<String, Object> map) {
        TaskManagerUtils taskManagerUtils = new TaskManagerUtils();
        if (((Context) this.mContextRef.get()) != null) {
            try {
                C6038b c6038b = (C6038b) cls.getDeclaredConstructor(new Class[]{Context.class, C6042f.class}).newInstance(new Object[]{(Context) this.mContextRef.get(), taskManagerUtils});
                Class<C6038b> task = new Task(str, str2, str3, c6038b, map, this);
                str3 = sTasksTable.containsKey(str2) != null ? (Map) sTasksTable.get(str2) : new HashMap();
                str3.put(str, task);
                sTasksTable.put(str2, str3);
                str3 = TAG;
                map = new StringBuilder();
                map.append("Registered task with name '");
                map.append(str);
                map.append("' for app with ID '");
                map.append(str2);
                map.append("'.");
                Log.i(str3, map.toString());
                c6038b.didRegister(task);
            } catch (String str4) {
                throw new TaskRegisteringFailedException(cls, str4);
            }
        }
    }

    private Bundle createExecutionEventBody(C6040d c6040d, Bundle bundle, Error error) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        error = errorBundleForError(error);
        bundle3.putString("eventId", UUID.randomUUID().toString());
        bundle3.putString("taskName", c6040d.getName());
        bundle2.putBundle("executionInfo", bundle3);
        c6040d = "data";
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle2.putBundle(c6040d, bundle);
        bundle2.putBundle("error", error);
        return bundle2;
    }

    private Bundle errorBundleForError(Error error) {
        if (error == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, error.getMessage());
        return bundle;
    }

    private C6040d getTask(String str, String str2) {
        Map map = (Map) sTasksTable.get(str2);
        return map != null ? (C6040d) map.get(str) : null;
    }

    private C6038b getTaskConsumer(String str, String str2) {
        C6038b c6038b = null;
        if (str != null) {
            if (str2 != null) {
                str = getTask(str, str2);
                if (str != null) {
                    c6038b = str.getConsumer();
                }
                return c6038b;
            }
        }
        return null;
    }

    private SharedPreferences getSharedPreferences() {
        Context context = (Context) this.mContextRef.get();
        return context != null ? context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0) : null;
    }

    private void maybeUpdateAppUrlForAppId(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        Map jsonToMap = sharedPreferences != null ? jsonToMap(sharedPreferences.getString(str2, "")) : null;
        if (jsonToMap != null && jsonToMap.size() > 0) {
            String str3 = (String) jsonToMap.get("appUrl");
            if (str3 == null || !str3.equals(str)) {
                jsonToMap.put("appUrl", str);
                sharedPreferences.edit().putString(str2, new JSONObject(jsonToMap).toString()).apply();
            }
        }
    }

    private void restoreTasks() {
        for (Entry entry : getSharedPreferences().getAll().entrySet()) {
            Map jsonToMap = jsonToMap(entry.getValue().toString());
            HashMap hashMap = (HashMap) jsonToMap.get("tasks");
            String str = (String) jsonToMap.get("appUrl");
            if (!(str == null || hashMap == null || hashMap.size() <= 0)) {
                for (String str2 : hashMap.keySet()) {
                    HashMap hashMap2 = (HashMap) hashMap.get(str2);
                    String str3 = (String) hashMap2.get("consumerClass");
                    try {
                        Class cls = Class.forName(str3);
                        int consumerVersion = getConsumerVersion(cls);
                        int intValue = ((Integer) hashMap2.get("consumerVersion")).intValue();
                        if (consumerVersion == intValue) {
                            try {
                                internalRegisterTask(str2, (String) entry.getKey(), str, cls, (HashMap) hashMap2.get("options"));
                            } catch (TaskRegisteringFailedException e) {
                                Log.e(TAG, e.getMessage());
                            }
                        } else {
                            String str4 = TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Task consumer '");
                            stringBuilder.append(str3);
                            stringBuilder.append("' has version '");
                            stringBuilder.append(consumerVersion);
                            stringBuilder.append("' that is not compatible with the saved version '");
                            stringBuilder.append(intValue);
                            stringBuilder.append("'.");
                            Log.w(str4, stringBuilder.toString());
                        }
                    } catch (ClassNotFoundException e2) {
                        Log.e(TAG, e2.getMessage());
                        e2.printStackTrace();
                    }
                }
            }
            saveTasksForAppWithId((String) entry.getKey());
        }
    }

    private void saveTasksForAppWithId(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        Map map = (Map) sTasksTable.get(str);
        if (sharedPreferences != null) {
            if (map != null) {
                if (map.size() != 0) {
                    Map hashMap = new HashMap();
                    Map hashMap2 = new HashMap();
                    Object obj = null;
                    for (C6040d c6040d : map.values()) {
                        hashMap2.put(c6040d.getName(), exportTaskToMap(c6040d));
                        obj = c6040d.getAppUrl();
                    }
                    hashMap.put("appUrl", obj);
                    hashMap.put("tasks", hashMap2);
                    sharedPreferences.edit().putString(str, new JSONObject(hashMap).toString()).apply();
                    return;
                }
            }
            sharedPreferences.edit().remove(str).apply();
        }
    }

    private void removeAppFromConfig(String str) {
        getSharedPreferences().edit().remove(str).apply();
    }

    private C6041e getTaskManager(String str) {
        C6041e c6041e;
        WeakReference weakReference = (WeakReference) sTaskManagers.get(str);
        if (weakReference == null) {
            c6041e = null;
        } else {
            c6041e = (C6041e) weakReference.get();
        }
        if (c6041e == null) {
            weakReference = (WeakReference) sHeadlessTaskManagers.get(str);
        }
        if (weakReference == null) {
            return null;
        }
        return (C6041e) weakReference.get();
    }

    private Map<String, Object> exportTaskToMap(C6040d c6040d) {
        Map<String, Object> hashMap = new HashMap();
        Class cls = c6040d.getConsumer().getClass();
        String unversionedClassNameForClass = unversionedClassNameForClass(cls);
        hashMap.put("name", c6040d.getName());
        hashMap.put("consumerClass", unversionedClassNameForClass);
        hashMap.put("consumerVersion", Integer.valueOf(getConsumerVersion(cls)));
        hashMap.put("options", c6040d.getOptions());
        return hashMap;
    }

    private C6044a createAppLoader() {
        Context context = (Context) this.mContextRef.get();
        return context != null ? C6047a.m25173a("react-native-experience", context) : null;
    }

    private boolean loadApp(final String str, String str2) {
        C6044a createAppLoader = createAppLoader();
        if (createAppLoader == null) {
            Log.e(TAG, "Cannot execute background task because application loader can't be found.");
            return false;
        } else if (str2 == null) {
            Log.e(TAG, "Cannot execute background task because application URL is invalid");
            return false;
        } else {
            Map hashMap = new HashMap();
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading headless app '");
            stringBuilder.append(str);
            stringBuilder.append("' with url '");
            stringBuilder.append(str2);
            stringBuilder.append("'.");
            Log.i(str3, stringBuilder.toString());
            sAppRecords.put(str, createAppLoader.mo5394a(str2, hashMap, new C6043a() {
                public void onComplete(boolean z, Exception exception) {
                    if (exception != null) {
                        exception.printStackTrace();
                        Log.e(TaskService.TAG, exception.getMessage());
                    }
                    if (!z) {
                        TaskService.sEvents.remove(str);
                        TaskService.sEventsQueues.remove(str);
                        TaskService.sAppRecords.remove(str);
                        TaskService.this.unregisterAllTasksForAppId(str);
                    }
                }
            }));
            return true;
        }
    }

    private void invalidateAppRecord(String str) {
        C6046c c6046c = (C6046c) sAppRecords.get(str);
        if (c6046c != null) {
            c6046c.mo5399a();
            sAppRecords.remove(str);
            sHeadlessTaskManagers.remove(str);
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalidated headless app '");
            stringBuilder.append(str);
            stringBuilder.append("'.");
            Log.i(str2, stringBuilder.toString());
        }
    }

    private void finishJobAfterTimeout(final JobService jobService, final JobParameters jobParameters, long j) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                jobService.jobFinished(jobParameters, false);
            }
        }, j);
    }

    private static java.util.Map<java.lang.String, java.lang.Object> jsonToMap(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000a }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x000a }
        r1 = jsonToMap(r0);	 Catch:{ JSONException -> 0x000a }
        return r1;
    L_0x000a:
        r1 = new java.util.HashMap;
        r1.<init>();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.taskManager.TaskService.jsonToMap(java.lang.String):java.util.Map<java.lang.String, java.lang.Object>");
    }

    private static Map<String, Object> jsonToMap(JSONObject jSONObject) {
        Map<String, Object> hashMap = new HashMap();
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, jsonObjectToObject(jSONObject.get(str)));
            }
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
        }
        return hashMap;
    }

    private static List<Object> jsonToList(JSONArray jSONArray) {
        List<Object> arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONArray) {
                    obj = jsonToList((JSONArray) obj);
                } else if (obj instanceof JSONObject) {
                    obj = jsonToMap((JSONObject) obj);
                }
                arrayList.add(obj);
                i++;
            } catch (JSONArray jSONArray2) {
                jSONArray2.printStackTrace();
            }
        }
        return arrayList;
    }

    private static Object jsonObjectToObject(Object obj) {
        if (obj instanceof JSONObject) {
            return jsonToMap((JSONObject) obj);
        }
        return obj instanceof JSONArray ? jsonToList((JSONArray) obj) : obj;
    }

    private static int getConsumerVersion(java.lang.Class r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "VERSION";	 Catch:{ NoSuchFieldException -> 0x0012, NoSuchFieldException -> 0x0012 }
        r1 = r1.getDeclaredField(r0);	 Catch:{ NoSuchFieldException -> 0x0012, NoSuchFieldException -> 0x0012 }
        r0 = 0;	 Catch:{ NoSuchFieldException -> 0x0012, NoSuchFieldException -> 0x0012 }
        r1 = r1.get(r0);	 Catch:{ NoSuchFieldException -> 0x0012, NoSuchFieldException -> 0x0012 }
        r1 = (java.lang.Integer) r1;	 Catch:{ NoSuchFieldException -> 0x0012, NoSuchFieldException -> 0x0012 }
        r1 = r1.intValue();	 Catch:{ NoSuchFieldException -> 0x0012, NoSuchFieldException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.taskManager.TaskService.getConsumerVersion(java.lang.Class):int");
    }

    private static String unversionedClassNameForClass(Class cls) {
        return cls.getName().replaceFirst("\\^abi\\d+_\\d+_\\d+\\.", "");
    }

    private static Class unversionedClassForClass(Class cls) {
        if (cls == null) {
            return null;
        }
        cls = unversionedClassNameForClass(cls);
        try {
            return Class.forName(cls);
        } catch (ClassNotFoundException e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class with name '");
            stringBuilder.append(cls);
            stringBuilder.append("' not found.");
            Log.e(str, stringBuilder.toString());
            e.printStackTrace();
            return null;
        }
    }
}
