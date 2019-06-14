package expo.modules.google.signin;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.auth.C4320b;
import com.google.android.gms.auth.api.signin.C2734a;
import com.google.android.gms.auth.api.signin.C4312c;
import com.google.android.gms.auth.api.signin.C4314e;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p186f.C2950c;
import com.google.android.gms.p186f.C2954g;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5994a;
import expo.p304a.p305a.C5995b;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;
import expo.p307b.p310c.C6023a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GoogleSignInModule extends C6006c implements C6001h {
    protected static final String ERROR_CONCURRENT_TASK_IN_PROGRESS = "E_CONCURRENT_TASK_IN_PROGRESS";
    protected static final String ERROR_EXCEPTION = "E_GOOGLE_SIGN_IN";
    public static final String MODULE_NAME = "ExpoGoogleSignIn";
    public static final int RC_LOG_IN = 1737;
    public static final int RC_PLAY_SERVICES = 2404;
    private C4312c _apiClient;
    private AuthTask authTask = new AuthTask();
    private final C5994a mActivityEventListener = new GoogleSignInActivityEventListener();
    private C6007d mModuleRegistry;

    private static class AccessTokenRetrievalTask extends AsyncTask<Bundle, Void, Bundle> {
        private WeakReference<GoogleSignInModule> weakModuleRef;

        AccessTokenRetrievalTask(GoogleSignInModule googleSignInModule) {
            this.weakModuleRef = new WeakReference(googleSignInModule);
        }

        protected Bundle doInBackground(Bundle... bundleArr) {
            bundleArr = bundleArr[0];
            String string = bundleArr.getString("email");
            GoogleSignInModule googleSignInModule = (GoogleSignInModule) this.weakModuleRef.get();
            if (googleSignInModule == null) {
                return bundleArr;
            }
            try {
                string = C4320b.a(googleSignInModule.getApplicationContext(), new Account(string, "com.google"), Serialization.scopesToString(bundleArr.getStringArrayList("scopes")));
                Bundle bundle = bundleArr.getBundle("auth");
                bundle.putString("accessToken", string);
                bundleArr.putBundle("auth", bundle);
                return bundleArr;
            } catch (Bundle[] bundleArr2) {
                googleSignInModule.authTask.reject(GoogleSignInModule.ERROR_EXCEPTION, bundleArr2.getLocalizedMessage());
                return null;
            }
        }

        protected void onPostExecute(Bundle bundle) {
            super.onPostExecute(bundle);
            GoogleSignInModule googleSignInModule = (GoogleSignInModule) this.weakModuleRef.get();
            if (googleSignInModule != null && bundle != null) {
                googleSignInModule.authTask.resolve(bundle);
            }
        }
    }

    private class GoogleSignInActivityEventListener implements C5994a {
        public void onNewIntent(Intent intent) {
        }

        private GoogleSignInActivityEventListener() {
        }

        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i == GoogleSignInModule.RC_LOG_IN) {
                GoogleSignInModule.this.handleSignInTaskResult(C2734a.a(intent));
            }
        }
    }

    public String getName() {
        return MODULE_NAME;
    }

    public GoogleSignInModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
        if (c6007d != null) {
            ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).registerActivityEventListener(this.mActivityEventListener);
        }
    }

    protected final Context getApplicationContext() {
        return getContext().getApplicationContext();
    }

    protected final Activity getCurrentActivity() {
        return ((C5995b) this.mModuleRegistry.m25133a(C5995b.class)).getCurrentActivity();
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap2.put("SIGN_IN_CANCELLED", String.valueOf(12501));
        hashMap2.put("TASK_IN_PROGRESS", ERROR_CONCURRENT_TASK_IN_PROGRESS);
        hashMap2.put("SIGN_IN_FAILED", String.valueOf(12500));
        hashMap2.put("SIGN_IN_REQUIRED", String.valueOf(4));
        hashMap2.put("INVALID_ACCOUNT", String.valueOf(5));
        hashMap2.put("SIGN_IN_NETWORK_ERROR", String.valueOf(7));
        hashMap2.put("SIGN_IN_EXCEPTION", ERROR_EXCEPTION);
        Map hashMap3 = new HashMap();
        hashMap3.put("PROFILE", "profile");
        hashMap3.put("EMAIL", "email");
        hashMap3.put("OPEN_ID", "openid");
        hashMap3.put("PLUS_ME", "https://www.googleapis.com/auth/plus.me");
        hashMap3.put("GAMES", "https://www.googleapis.com/auth/games");
        hashMap3.put("GAMES_LITE", "https://www.googleapis.com/auth/games_lite");
        hashMap3.put("CLOUD_SAVE", "https://www.googleapis.com/auth/datastoremobile");
        hashMap3.put("APP_STATE", "https://www.googleapis.com/auth/appstate");
        hashMap3.put("DRIVE_FILE", "https://www.googleapis.com/auth/drive.file");
        hashMap3.put("DRIVE_APPFOLDER", "https://www.googleapis.com/auth/drive.appdata");
        hashMap3.put("DRIVE_FULL", "https://www.googleapis.com/auth/drive");
        hashMap3.put("DRIVE_APPS", "https://www.googleapis.com/auth/drive.apps");
        hashMap3.put("FITNESS_ACTIVITY_READ", "https://www.googleapis.com/auth/fitness.activity.read");
        hashMap3.put("FITNESS_ACTIVITY_READ_WRITE", "https://www.googleapis.com/auth/fitness.activity.write");
        hashMap3.put("FITNESS_LOCATION_READ", "https://www.googleapis.com/auth/fitness.location.read");
        hashMap3.put("FITNESS_LOCATION_READ_WRITE", "https://www.googleapis.com/auth/fitness.location.write");
        hashMap3.put("FITNESS_BODY_READ", "https://www.googleapis.com/auth/fitness.body.read");
        hashMap3.put("FITNESS_BODY_READ_WRITE", "https://www.googleapis.com/auth/fitness.body.write");
        hashMap3.put("FITNESS_NUTRITION_READ", "https://www.googleapis.com/auth/fitness.nutrition.read");
        hashMap3.put("FITNESS_NUTRITION_READ_WRITE", "https://www.googleapis.com/auth/fitness.nutrition.write");
        hashMap3.put("FITNESS_BLOOD_PRESSURE_READ", "https://www.googleapis.com/auth/fitness.blood_pressure.read");
        hashMap3.put("FITNESS_BLOOD_PRESSURE_READ_WRITE", "https://www.googleapis.com/auth/fitness.blood_pressure.write");
        hashMap3.put("FITNESS_BLOOD_GLUCOSE_READ", "https://www.googleapis.com/auth/fitness.blood_glucose.read");
        hashMap3.put("FITNESS_BLOOD_GLUCOSE_READ_WRITE", "https://www.googleapis.com/auth/fitness.blood_glucose.write");
        hashMap3.put("FITNESS_OXYGEN_SATURATION_READ", "https://www.googleapis.com/auth/fitness.oxygen_saturation.read");
        hashMap3.put("FITNESS_OXYGEN_SATURATION_READ_WRITE", "https://www.googleapis.com/auth/fitness.oxygen_saturation.write");
        hashMap3.put("FITNESS_BODY_TEMPERATURE_READ", "https://www.googleapis.com/auth/fitness.body_temperature.read");
        hashMap3.put("FITNESS_BODY_TEMPERATURE_READ_WRITE", "https://www.googleapis.com/auth/fitness.body_temperature.write");
        hashMap3.put("FITNESS_REPRODUCTIVE_HEALTH_READ", "https://www.googleapis.com/auth/fitness.reproductive_health.read");
        hashMap3.put("FITNESS_REPRODUCTIVE_HEALTH_READ_WRITE", "https://www.googleapis.com/auth/fitness.reproductive_health.write");
        HashMap hashMap4 = new HashMap();
        hashMap3.put(MessengerShareContentUtility.PREVIEW_DEFAULT, "default");
        hashMap3.put("GAMES", "games");
        hashMap.put("SCOPES", hashMap3);
        hashMap.put("ERRORS", hashMap2);
        hashMap.put("TYPES", hashMap4);
        return hashMap;
    }

    @C5996c
    public void arePlayServicesAvailableAsync(boolean z, C6009f c6009f) {
        Context currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            c6009f.m25152a(ERROR_EXCEPTION, "Activity is null");
            return;
        }
        C4361e a = C4361e.a();
        int a2 = a.a(currentActivity);
        if (a2 != 0) {
            if (z && a.a(a2)) {
                a.a(currentActivity, a2, true).show();
            }
            c6009f.m25152a(ERROR_EXCEPTION, "Play Services are not available");
        } else {
            c6009f.mo5137a(Boolean.valueOf(true));
        }
    }

    @C5996c
    public void getCurrentUserAsync(C6009f c6009f) {
        GoogleSignInAccount a = C2734a.a(getApplicationContext());
        if (a == null) {
            c6009f.mo5137a(null);
        } else {
            c6009f.mo5137a(Serialization.jsonFromGoogleUser(a));
        }
    }

    @C5996c
    public void getPhotoAsync(Number number, C6009f c6009f) {
        number = C2734a.a(getApplicationContext());
        if (number != null) {
            if (number.h() != null) {
                c6009f.mo5137a(number.h().toString());
                return;
            }
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void getTokensAsync(Boolean bool, C6009f c6009f) {
        if (getClientOrReject(c6009f) != null) {
            bool = C2734a.a(getApplicationContext());
            if (bool == null) {
                c6009f.m25152a(ERROR_EXCEPTION, "getTokens requires a user to be signed in");
            }
            if (this.authTask.update(c6009f, "getTokensAsync") != null) {
                c6009f = new Bundle();
                c6009f.putString("email", bool.c());
                ArrayList arrayList = new ArrayList();
                for (Scope scope : bool.l()) {
                    arrayList.add(scope.toString());
                }
                c6009f.putStringArrayList("scopes", arrayList);
                c6009f.putBundle("auth", new Bundle());
                new AccessTokenRetrievalTask(this).execute(new Bundle[]{c6009f});
            }
        }
    }

    @C5996c
    public void initAsync(Map<String, Object> map, C6009f c6009f) {
        String appOwnership = getAppOwnership();
        Context applicationContext = getApplicationContext();
        map = Serialization.getSignInOptions(applicationContext, map, appOwnership, c6009f);
        if (map != null) {
            this._apiClient = C2734a.a(applicationContext, map);
            c6009f.mo5137a(Boolean.valueOf(true));
        }
    }

    private String getAppOwnership() {
        return ((C6023a) this.mModuleRegistry.m25133a(C6023a.class)).getAppOwnership();
    }

    @C5996c
    public void signInSilentlyAsync(C6009f c6009f) {
        final C4312c clientOrReject = getClientOrReject(c6009f);
        if (clientOrReject == null || !this.authTask.update(c6009f, "signInSilentlyAsync") || Boolean.valueOf(addUIThreadRunnableOrReject(new Runnable() {

            /* renamed from: expo.modules.google.signin.GoogleSignInModule$1$1 */
            class C74131 implements C2950c {
                C74131() {
                }

                public void onComplete(C2954g c2954g) {
                    GoogleSignInModule.this.handleSignInTaskResult(c2954g);
                }
            }

            public void run() {
                C2954g b = clientOrReject.b();
                if (b.b()) {
                    GoogleSignInModule.this.handleSignInTaskResult(b);
                } else {
                    b.a(new C74131());
                }
            }
        }, c6009f)).booleanValue() != null) {
        }
    }

    private void handleSignInTaskResult(C2954g<GoogleSignInAccount> c2954g) {
        try {
            c2954g = Serialization.jsonFromGoogleUser((GoogleSignInAccount) c2954g.a(C2782b.class));
            new AccessTokenRetrievalTask(this).execute(new Bundle[]{c2954g});
        } catch (C2954g<GoogleSignInAccount> c2954g2) {
            c2954g2 = c2954g2.a();
            this.authTask.reject(String.valueOf(c2954g2), C4314e.a(c2954g2));
        }
    }

    @C5996c
    public void signInAsync(C6009f c6009f) {
        final C4312c clientOrReject = getClientOrReject(c6009f);
        if (clientOrReject == null || !this.authTask.update(c6009f, "signInAsync") || Boolean.valueOf(addUIThreadRunnableOrReject(new Runnable() {
            public void run() {
                Intent a = clientOrReject.a();
                Activity currentActivity = GoogleSignInModule.this.getCurrentActivity();
                if (currentActivity == null) {
                    GoogleSignInModule.this.authTask.reject(GoogleSignInModule.ERROR_EXCEPTION, "activity is null");
                } else {
                    currentActivity.startActivityForResult(a, GoogleSignInModule.RC_LOG_IN);
                }
            }
        }, c6009f)).booleanValue() != null) {
        }
    }

    @C5996c
    public void clearCacheAsync(String str, C6009f c6009f) {
        try {
            C4320b.a(getApplicationContext(), str);
            c6009f.mo5137a((Object) null);
        } catch (String str2) {
            c6009f.mo5138a(ERROR_EXCEPTION, str2.getMessage(), str2);
        }
    }

    @C5996c
    public void signOutAsync(final C6009f c6009f) {
        C4312c clientOrReject = getClientOrReject(c6009f);
        if (clientOrReject != null) {
            clientOrReject.c().a(new C2950c<Void>() {
                public void onComplete(C2954g<Void> c2954g) {
                    GoogleSignInModule.this.handleSignOutOrRevokeAccessTask(c2954g, c6009f);
                }
            });
        }
    }

    @C5996c
    public void disconnectAsync(final C6009f c6009f) {
        C4312c clientOrReject = getClientOrReject(c6009f);
        if (clientOrReject != null) {
            clientOrReject.d().a(new C2950c<Void>() {
                public void onComplete(C2954g<Void> c2954g) {
                    GoogleSignInModule.this.handleSignOutOrRevokeAccessTask(c2954g, c6009f);
                }
            });
        }
    }

    @C5996c
    public void isConnectedAsync(C6009f c6009f) {
        GoogleSignInAccount a = C2734a.a(getApplicationContext());
        boolean z = false;
        if (a == null) {
            c6009f.mo5137a(Boolean.valueOf(false));
            return;
        }
        if (a != null) {
            z = true;
        }
        c6009f.mo5137a(Boolean.valueOf(z));
    }

    private void handleSignOutOrRevokeAccessTask(C2954g<Void> c2954g, C6009f c6009f) {
        if (c2954g.b()) {
            c6009f.mo5137a((Object) null);
            return;
        }
        c2954g = Serialization.getExceptionCode(c2954g);
        c6009f.m25152a(String.valueOf(c2954g), C4314e.a(c2954g));
    }

    private boolean addUIThreadRunnableOrReject(Runnable runnable, C6009f c6009f) {
        C5993b c5993b = (C5993b) this.mModuleRegistry.m25133a(C5993b.class);
        if (c5993b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Implementation of ");
            stringBuilder.append(C5993b.class.getName());
            stringBuilder.append(" is null. Are you sure you've included a proper Expo adapter for your platform?");
            c6009f.m25155a(new IllegalStateException(stringBuilder.toString()));
            return null;
        }
        c5993b.runOnUiQueueThread(runnable);
        return true;
    }

    private C4312c getClientOrReject(C6009f c6009f) {
        if (this._apiClient == null) {
            c6009f.m25152a(ERROR_EXCEPTION, "apiClient is null - call configure first");
        }
        return this._apiClient;
    }
}
