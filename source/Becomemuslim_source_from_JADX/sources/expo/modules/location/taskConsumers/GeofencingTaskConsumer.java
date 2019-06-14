package expo.modules.location.taskConsumers;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.location.C5076f;
import com.google.android.gms.location.C5076f.C5075a;
import com.google.android.gms.location.C5078i;
import com.google.android.gms.location.C5082m;
import com.google.android.gms.location.C6833h;
import com.google.android.gms.location.C7835j;
import com.google.android.gms.location.C7835j.C5079a;
import expo.modules.location.LocationHelpers;
import expo.p307b.p317j.C6038b;
import expo.p307b.p317j.C6040d;
import expo.p307b.p317j.C6042f;
import expo.p307b.p317j.C7389a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GeofencingTaskConsumer extends C7389a implements C6038b {
    private static final String TAG = "GeofencingTaskConsumer";
    private C6833h mGeofencingClient;
    private List<C5076f> mGeofencingList;
    private C7835j mGeofencingRequest;
    private PendingIntent mPendingIntent;
    private Map<String, PersistableBundle> mRegions;
    private C6040d mTask;

    private int eventTypeFromTransitionType(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    private static String getErrorString(int i) {
        switch (i) {
            case 1000:
                return "Geofencing not available.";
            case AdError.NO_FILL_ERROR_CODE /*1001*/:
                return "Too many geofences.";
            case 1002:
                return "Too many pending intents.";
            default:
                return "Unknown geofencing error.";
        }
    }

    private int regionStateForTransitionType(int i) {
        if (i != 4) {
            switch (i) {
                case 1:
                    break;
                case 2:
                    return 2;
                default:
                    return 0;
            }
        }
        return 1;
    }

    public String taskType() {
        return "geofencing";
    }

    public GeofencingTaskConsumer(Context context, C6042f c6042f) {
        super(context, c6042f);
    }

    public void didRegister(C6040d c6040d) {
        this.mTask = c6040d;
        startGeofencing();
    }

    public void didUnregister() {
        stopGeofencing();
        this.mTask = null;
        this.mPendingIntent = null;
        this.mGeofencingClient = null;
        this.mGeofencingRequest = null;
        this.mGeofencingList = null;
    }

    public void setOptions(Map<String, Object> map) {
        super.setOptions(map);
        stopGeofencing();
        startGeofencing();
    }

    public void didReceiveBroadcast(Intent intent) {
        intent = C5078i.m21560a(intent);
        if (intent.m21561a()) {
            this.mTask.execute(null, new Error(getErrorString(intent.m21562b())));
            return;
        }
        int c = intent.m21563c();
        int regionStateForTransitionType = regionStateForTransitionType(c);
        c = eventTypeFromTransitionType(c);
        for (C5076f a : intent.m21564d()) {
            PersistableBundle persistableBundle = (PersistableBundle) this.mRegions.get(a.mo6206a());
            if (persistableBundle != null) {
                PersistableBundle persistableBundle2 = new PersistableBundle();
                persistableBundle.putInt(ServerProtocol.DIALOG_PARAM_STATE, regionStateForTransitionType);
                persistableBundle2.putInt("eventType", c);
                persistableBundle2.putPersistableBundle("region", persistableBundle);
                getTaskManagerUtils().scheduleJob(getContext().getApplicationContext(), this.mTask, persistableBundle2);
            }
        }
    }

    public boolean didExecuteJob(JobService jobService, JobParameters jobParameters) {
        jobService = jobParameters.getExtras().getPersistableBundle("data");
        jobParameters = new Bundle();
        Bundle bundle = new Bundle();
        bundle.putAll(jobService.getPersistableBundle("region"));
        jobParameters.putInt("eventType", jobService.getInt("eventType"));
        jobParameters.putBundle("region", bundle);
        this.mTask.execute(jobParameters, null);
        return true;
    }

    private void startGeofencing() {
        Context context = getContext();
        if (context == null) {
            Log.w(TAG, "The context has been abandoned.");
        } else if (LocationHelpers.isAnyProviderAvailable(context)) {
            this.mRegions = new HashMap();
            this.mGeofencingList = new ArrayList();
            for (Map map : (ArrayList) this.mTask.getOptions().get("regions")) {
                C5076f geofenceFromRegion = geofenceFromRegion(map);
                String a = geofenceFromRegion.mo6206a();
                this.mRegions.put(a, bundleFromRegion(a, map));
                this.mGeofencingList.add(geofenceFromRegion);
            }
            this.mPendingIntent = preparePendingIntent();
            this.mGeofencingRequest = prepareGeofencingRequest(this.mGeofencingList);
            this.mGeofencingClient = C5082m.m21574a(getContext());
            try {
                this.mGeofencingClient.m32116a(this.mGeofencingRequest, this.mPendingIntent);
            } catch (Throwable e) {
                Log.w(TAG, "Geofencing request has been rejected.", e);
            }
        } else {
            Log.w(TAG, "There is no location provider available.");
        }
    }

    private void stopGeofencing() {
        if (this.mGeofencingClient != null && this.mPendingIntent != null) {
            this.mGeofencingClient.m32115a(this.mPendingIntent);
            this.mPendingIntent.cancel();
        }
    }

    private C7835j prepareGeofencingRequest(List<C5076f> list) {
        return new C5079a().m21566a(3).m21568a((List) list).m21569a();
    }

    private PendingIntent preparePendingIntent() {
        return getTaskManagerUtils().createTaskIntent(getContext(), this.mTask);
    }

    private C5076f geofenceFromRegion(Map<String, Object> map) {
        int i;
        String uuid = map.containsKey("identifier") ? (String) map.get("identifier") : UUID.randomUUID().toString();
        double doubleFromObject = doubleFromObject(map.get("latitude"));
        double doubleFromObject2 = doubleFromObject(map.get("longitude"));
        double doubleFromObject3 = doubleFromObject(map.get("radius"));
        Object obj = 1;
        int i2 = 0;
        if (map.containsKey("notifyOnEnter")) {
            if (!((Boolean) map.get("notifyOnEnter")).booleanValue()) {
                i = 0;
                if (map.containsKey("notifyOnExit")) {
                    if (((Boolean) map.get("notifyOnExit")).booleanValue() != null) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    i2 = 2;
                }
                return new C5075a().m21553a(uuid).m21550a(doubleFromObject, doubleFromObject2, (float) doubleFromObject3).m21552a(-1).m21551a(i | i2).m21554a();
            }
        }
        i = 1;
        if (map.containsKey("notifyOnExit")) {
            if (((Boolean) map.get("notifyOnExit")).booleanValue() != null) {
                obj = null;
            }
        }
        if (obj != null) {
            i2 = 2;
        }
        return new C5075a().m21553a(uuid).m21550a(doubleFromObject, doubleFromObject2, (float) doubleFromObject3).m21552a(-1).m21551a(i | i2).m21554a();
    }

    private PersistableBundle bundleFromRegion(String str, Map<String, Object> map) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("identifier", str);
        persistableBundle.putDouble("radius", doubleFromObject(map.get("radius")));
        persistableBundle.putDouble("latitude", doubleFromObject(map.get("latitude")));
        persistableBundle.putDouble("longitude", doubleFromObject(map.get("longitude")));
        persistableBundle.putInt(ServerProtocol.DIALOG_PARAM_STATE, null);
        return persistableBundle;
    }

    private static double doubleFromObject(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).doubleValue();
        }
        return ((Double) obj).doubleValue();
    }
}
