package expo.modules.taskManager;

import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import expo.p307b.p317j.C6040d;
import expo.p307b.p317j.C6042f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TaskManagerUtils implements C6042f {
    private static final int DEFAULT_OVERRIDE_DEADLINE = 60000;
    private static Integer sCurrentIntentId = Integer.valueOf(2137);
    private static Integer sCurrentJobId = Integer.valueOf(2137);
    private static final List<Integer> sPendingJobIds = new ArrayList();

    public PendingIntent createTaskIntent(Context context, C6040d c6040d) {
        Integer num = sCurrentIntentId;
        sCurrentIntentId = Integer.valueOf(sCurrentIntentId.intValue() + 1);
        String appId = c6040d.getAppId();
        c6040d = c6040d.getName();
        Intent intent = new Intent(TaskBroadcastReceiver.INTENT_ACTION, null, context, TaskBroadcastReceiver.class);
        intent.setData(new Builder().appendQueryParameter("intentId", num.toString()).appendQueryParameter("appId", appId).appendQueryParameter("taskName", c6040d).build());
        return PendingIntent.getBroadcast(context, num.intValue(), intent, 134217728);
    }

    public void scheduleJob(Context context, JobInfo jobInfo) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        int id = jobInfo.getId();
        if (jobScheduler != null) {
            jobScheduler.cancel(id);
            jobScheduler.schedule(jobInfo);
            addToPendingJobs(id);
            return;
        }
        Log.e(getClass().getName(), "Job scheduler not found!");
    }

    public void scheduleJob(Context context, C6040d c6040d, PersistableBundle persistableBundle) {
        Integer num = sCurrentJobId;
        sCurrentJobId = Integer.valueOf(sCurrentJobId.intValue() + 1);
        scheduleJob(context, createJobInfo(context, num.intValue(), createExtrasForTask(c6040d, persistableBundle)));
    }

    public static Bundle mapToBundle(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            Object value = entry.getValue();
            String str = (String) entry.getKey();
            if (value instanceof Double) {
                bundle.putDouble(str, ((Double) value).doubleValue());
            } else if (value instanceof Integer) {
                bundle.putInt(str, ((Integer) value).intValue());
            } else if (value instanceof String) {
                bundle.putString(str, (String) value);
            } else if (value instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value instanceof List) {
                List list = (List) value;
                Object obj = list.get(0);
                if (obj != null) {
                    if (!(obj instanceof Double)) {
                        if (obj instanceof Integer) {
                            bundle.putIntArray(str, listToIntArray(list));
                        } else if (obj instanceof String) {
                            bundle.putStringArray(str, listToStringArray(list));
                        } else if (obj instanceof Map) {
                            bundle.putParcelableArrayList(str, listToParcelableArrayList(list));
                        }
                    }
                }
                bundle.putDoubleArray(str, listToDoubleArray(list));
            } else if (value instanceof Map) {
                bundle.putBundle(str, mapToBundle((Map) value));
            }
        }
        return bundle;
    }

    public static double[] listToDoubleArray(List<Object> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    private static int[] listToIntArray(List<Object> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }

    private static String[] listToStringArray(List<Object> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = list.get(i).toString();
        }
        return strArr;
    }

    private static ArrayList<Parcelable> listToParcelableArrayList(List<Object> list) {
        ArrayList<Parcelable> arrayList = new ArrayList();
        list = list.iterator();
        while (list.hasNext()) {
            arrayList.add(mapToBundle((Map) list.next()));
        }
        return arrayList;
    }

    private static void addToPendingJobs(int i) {
        if (!sPendingJobIds.contains(Integer.valueOf(i))) {
            sPendingJobIds.add(Integer.valueOf(i));
        }
    }

    public static void removeFromPendingJobs(int i) {
        sPendingJobIds.remove(Integer.valueOf(i));
    }

    private JobInfo createJobInfo(Context context, int i, PersistableBundle persistableBundle) {
        return new JobInfo.Builder(i, new ComponentName(context, TaskJobService.class)).setExtras(persistableBundle).setMinimumLatency(0).setOverrideDeadline(DEFAULT_OVERRIDE_DEADLINE).setRequiredNetworkType(1).build();
    }

    private PersistableBundle createExtrasForTask(C6040d c6040d, PersistableBundle persistableBundle) {
        PersistableBundle persistableBundle2 = new PersistableBundle();
        persistableBundle2.putString("appId", c6040d.getAppId());
        persistableBundle2.putString("taskName", c6040d.getName());
        persistableBundle2.putPersistableBundle("data", persistableBundle);
        return persistableBundle2;
    }
}
