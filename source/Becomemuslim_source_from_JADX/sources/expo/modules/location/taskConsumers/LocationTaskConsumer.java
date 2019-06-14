package expo.modules.location.taskConsumers;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.location.C5082m;
import com.google.android.gms.location.C6832e;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import expo.modules.location.LocationHelpers;
import expo.modules.location.LocationModule;
import expo.p307b.p317j.C6038b;
import expo.p307b.p317j.C6039c;
import expo.p307b.p317j.C6040d;
import expo.p307b.p317j.C6042f;
import expo.p307b.p317j.C7389a;
import io.nlopez.smartlocation.p359a.p360a.C6526b;
import java.util.ArrayList;
import java.util.Map;
import versioned.host.exp.exponent.modules.api.components.LinearGradientManager;

public class LocationTaskConsumer extends C7389a implements C6038b {
    private static final String TAG = "LocationTaskConsumer";
    private static long sLastTimestamp;
    private C6832e mLocationClient;
    private LocationRequest mLocationRequest;
    private PendingIntent mPendingIntent;
    private C6040d mTask;

    private int mapAccuracyToPriority(int i) {
        switch (i) {
            case 1:
                return 105;
            case 2:
                return 104;
            case 4:
            case 5:
            case 6:
                return 100;
            default:
                return 102;
        }
    }

    public String taskType() {
        return PlaceFields.LOCATION;
    }

    public LocationTaskConsumer(Context context, C6042f c6042f) {
        super(context, c6042f);
    }

    public void didRegister(C6040d c6040d) {
        this.mTask = c6040d;
        startLocationUpdates();
    }

    public void didUnregister() {
        stopLocationUpdates();
        this.mTask = null;
        this.mPendingIntent = null;
        this.mLocationRequest = null;
        this.mLocationClient = null;
    }

    public void setOptions(Map<String, Object> map) {
        super.setOptions(map);
        stopLocationUpdates();
        startLocationUpdates();
    }

    public void didReceiveBroadcast(Intent intent) {
        if (this.mTask != null) {
            Context applicationContext = getContext().getApplicationContext();
            intent = LocationResult.m38217b(intent);
            if (intent != null) {
                PersistableBundle persistableBundle = new PersistableBundle();
                int i = 0;
                for (Location location : intent.m38218a()) {
                    long time = location.getTime();
                    if (time > sLastTimestamp) {
                        persistableBundle.putPersistableBundle(Integer.valueOf(i).toString(), (PersistableBundle) LocationModule.locationToBundle(location, PersistableBundle.class));
                        sLastTimestamp = time;
                        i++;
                    }
                }
                persistableBundle.putInt("length", i);
                if (i > 0) {
                    getTaskManagerUtils().scheduleJob(applicationContext, this.mTask, persistableBundle);
                }
            }
        }
    }

    public boolean didExecuteJob(final JobService jobService, final JobParameters jobParameters) {
        PersistableBundle persistableBundle = jobParameters.getExtras().getPersistableBundle("data");
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Integer valueOf = Integer.valueOf(persistableBundle.getInt("length", 0));
        while (i < valueOf.intValue()) {
            PersistableBundle persistableBundle2 = persistableBundle.getPersistableBundle(String.valueOf(i));
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = new Bundle();
            bundle3.putAll(persistableBundle2.getPersistableBundle("coords"));
            bundle2.putAll(persistableBundle2);
            bundle2.putBundle("coords", bundle3);
            arrayList.add(bundle2);
            i++;
        }
        bundle.putParcelableArrayList(LinearGradientManager.PROP_LOCATIONS, arrayList);
        this.mTask.execute(bundle, null, new C6039c() {
            public void onFinished(Map<String, Object> map) {
                jobService.jobFinished(jobParameters, false);
            }
        });
        return true;
    }

    private void startLocationUpdates() {
        Context context = getContext();
        if (context == null) {
            Log.w(TAG, "The context has been abandoned.");
        } else if (LocationHelpers.isAnyProviderAvailable(context)) {
            this.mLocationRequest = prepareLocationRequest();
            this.mPendingIntent = preparePendingIntent();
            try {
                this.mLocationClient = C5082m.m21575b(context);
                this.mLocationClient.m32114a(this.mLocationRequest, this.mPendingIntent);
            } catch (Throwable e) {
                Log.w(TAG, "Location request has been rejected.", e);
            }
        } else {
            Log.w(TAG, "There is no location provider available.");
        }
    }

    private void stopLocationUpdates() {
        if (this.mLocationClient != null && this.mPendingIntent != null) {
            this.mLocationClient.m32113a(this.mPendingIntent);
            this.mPendingIntent.cancel();
        }
    }

    private LocationRequest prepareLocationRequest() {
        Map options = this.mTask.getOptions();
        C6526b mapOptionsToLocationParams = LocationHelpers.mapOptionsToLocationParams(options);
        return new LocationRequest().m38215c(mapOptionsToLocationParams.m26686a()).m38211a(mapOptionsToLocationParams.m26686a()).m38209a(mapOptionsToLocationParams.m26687b()).m38210a(mapAccuracyToPriority(LocationHelpers.getAccuracyFromOptions(options)));
    }

    private PendingIntent preparePendingIntent() {
        return getTaskManagerUtils().createTaskIntent(getContext(), this.mTask);
    }
}
