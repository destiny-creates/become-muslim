package co.apptailor.googlesignin;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.auth.C4320b;
import com.google.android.gms.auth.C4321d;
import com.google.android.gms.auth.api.signin.C2734a;
import com.google.android.gms.auth.api.signin.C4312c;
import com.google.android.gms.auth.api.signin.C4314e;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.p186f.C2950c;
import com.google.android.gms.p186f.C2954g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class RNGoogleSigninModule extends ReactContextBaseJavaModule {
    public static final String ASYNC_OP_IN_PROGRESS = "ASYNC_OP_IN_PROGRESS";
    public static final String ERROR_USER_RECOVERABLE_AUTH = "ERROR_USER_RECOVERABLE_AUTH";
    public static final String MODULE_NAME = "RNGoogleSignin";
    public static final String PLAY_SERVICES_NOT_AVAILABLE = "PLAY_SERVICES_NOT_AVAILABLE";
    public static final int RC_SIGN_IN = 9001;
    public static final int REQUEST_CODE_RECOVER_AUTH = 53294;
    private static final String SHOULD_RECOVER = "SHOULD_RECOVER";
    private C4312c _apiClient;
    private C0848a pendingAuthRecovery;
    private C0849b promiseWrapper = new C0849b();

    /* renamed from: co.apptailor.googlesignin.RNGoogleSigninModule$1 */
    class C08441 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RNGoogleSigninModule f2346a;

        /* renamed from: co.apptailor.googlesignin.RNGoogleSigninModule$1$1 */
        class C33431 implements C2950c {
            /* renamed from: a */
            final /* synthetic */ C08441 f8885a;

            C33431(C08441 c08441) {
                this.f8885a = c08441;
            }

            public void onComplete(C2954g c2954g) {
                this.f8885a.f2346a.handleSignInTaskResult(c2954g);
            }
        }

        C08441(RNGoogleSigninModule rNGoogleSigninModule) {
            this.f2346a = rNGoogleSigninModule;
        }

        public void run() {
            C2954g b = this.f2346a._apiClient.m14004b();
            if (b.mo2589b()) {
                this.f2346a.handleSignInTaskResult(b);
            } else {
                b.mo2578a(new C33431(this));
            }
        }
    }

    /* renamed from: co.apptailor.googlesignin.RNGoogleSigninModule$a */
    private static class C0846a extends AsyncTask<WritableMap, Void, Void> {
        /* renamed from: a */
        private WeakReference<RNGoogleSigninModule> f2349a;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3048a((WritableMap[]) objArr);
        }

        C0846a(RNGoogleSigninModule rNGoogleSigninModule) {
            this.f2349a = new WeakReference(rNGoogleSigninModule);
        }

        /* renamed from: a */
        protected Void m3048a(WritableMap... writableMapArr) {
            WritableMap writableMap = writableMapArr[0];
            RNGoogleSigninModule rNGoogleSigninModule = (RNGoogleSigninModule) this.f2349a.get();
            if (rNGoogleSigninModule == null) {
                return null;
            }
            try {
                m3045a(rNGoogleSigninModule, writableMap);
                rNGoogleSigninModule.getPromiseWrapper().m3053a(writableMap);
            } catch (Exception e) {
                m3047a(rNGoogleSigninModule, e, writableMap, writableMapArr.length >= 2 ? writableMapArr[1] : null);
            }
            return null;
        }

        /* renamed from: a */
        private void m3045a(RNGoogleSigninModule rNGoogleSigninModule, WritableMap writableMap) {
            writableMap.putString("accessToken", C4320b.m14019a(rNGoogleSigninModule.getReactApplicationContext(), new Account(writableMap.getMap("user").getString("email"), "com.google"), C0850d.m3060a(writableMap.getArray("scopes"))));
        }

        /* renamed from: a */
        private void m3047a(RNGoogleSigninModule rNGoogleSigninModule, Exception exception, WritableMap writableMap, WritableMap writableMap2) {
            if (exception instanceof C4321d) {
                writableMap2 = (writableMap2 == null || !writableMap2.hasKey(RNGoogleSigninModule.SHOULD_RECOVER) || writableMap2.getBoolean(RNGoogleSigninModule.SHOULD_RECOVER) == null) ? null : true;
                if (writableMap2 != null) {
                    m3046a(rNGoogleSigninModule, exception, writableMap);
                    return;
                } else {
                    rNGoogleSigninModule.promiseWrapper.m3055a(RNGoogleSigninModule.ERROR_USER_RECOVERABLE_AUTH, (Throwable) exception);
                    return;
                }
            }
            rNGoogleSigninModule.promiseWrapper.m3055a(RNGoogleSigninModule.MODULE_NAME, (Throwable) exception);
        }

        /* renamed from: a */
        private void m3046a(RNGoogleSigninModule rNGoogleSigninModule, Exception exception, WritableMap writableMap) {
            Activity access$700 = rNGoogleSigninModule.getCurrentActivity();
            if (access$700 == null) {
                rNGoogleSigninModule.pendingAuthRecovery = null;
                rNGoogleSigninModule = rNGoogleSigninModule.promiseWrapper;
                String str = RNGoogleSigninModule.MODULE_NAME;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot attempt recovery auth because app is not in foreground. ");
                stringBuilder.append(exception.getLocalizedMessage());
                rNGoogleSigninModule.m3054a(str, stringBuilder.toString());
                return;
            }
            rNGoogleSigninModule.pendingAuthRecovery = new C0848a(writableMap);
            access$700.startActivityForResult(((C4321d) exception).m14021a(), RNGoogleSigninModule.REQUEST_CODE_RECOVER_AUTH);
        }
    }

    /* renamed from: co.apptailor.googlesignin.RNGoogleSigninModule$c */
    private static class C0847c extends AsyncTask<String, Void, Void> {
        /* renamed from: a */
        private WeakReference<RNGoogleSigninModule> f2350a;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3049a((String[]) objArr);
        }

        C0847c(RNGoogleSigninModule rNGoogleSigninModule) {
            this.f2350a = new WeakReference(rNGoogleSigninModule);
        }

        /* renamed from: a */
        protected Void m3049a(String... strArr) {
            RNGoogleSigninModule rNGoogleSigninModule = (RNGoogleSigninModule) this.f2350a.get();
            if (rNGoogleSigninModule == null) {
                return null;
            }
            try {
                C4320b.m14020a(rNGoogleSigninModule.getReactApplicationContext(), strArr[0]);
                rNGoogleSigninModule.getPromiseWrapper().m3053a(Boolean.valueOf(true));
            } catch (Throwable e) {
                rNGoogleSigninModule.promiseWrapper.m3055a(RNGoogleSigninModule.MODULE_NAME, e);
            }
            return null;
        }
    }

    /* renamed from: co.apptailor.googlesignin.RNGoogleSigninModule$b */
    private class C4502b extends BaseActivityEventListener {
        /* renamed from: a */
        final /* synthetic */ RNGoogleSigninModule f12105a;

        private C4502b(RNGoogleSigninModule rNGoogleSigninModule) {
            this.f12105a = rNGoogleSigninModule;
        }

        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i == RNGoogleSigninModule.RC_SIGN_IN) {
                this.f12105a.handleSignInTaskResult(C2734a.m7794a(intent));
            } else if (i != RNGoogleSigninModule.REQUEST_CODE_RECOVER_AUTH) {
            } else {
                if (i2 == -1) {
                    this.f12105a.rerunFailedAuthTokenTask();
                } else {
                    this.f12105a.promiseWrapper.m3054a(RNGoogleSigninModule.MODULE_NAME, "Failed authentication recovery attempt, probably user-rejected.");
                }
            }
        }
    }

    public String getName() {
        return MODULE_NAME;
    }

    public C0849b getPromiseWrapper() {
        return this.promiseWrapper;
    }

    public RNGoogleSigninModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new C4502b());
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("BUTTON_SIZE_ICON", Integer.valueOf(2));
        hashMap.put("BUTTON_SIZE_STANDARD", Integer.valueOf(0));
        hashMap.put("BUTTON_SIZE_WIDE", Integer.valueOf(1));
        hashMap.put("BUTTON_COLOR_AUTO", Integer.valueOf(2));
        hashMap.put("BUTTON_COLOR_LIGHT", Integer.valueOf(1));
        hashMap.put("BUTTON_COLOR_DARK", Integer.valueOf(0));
        hashMap.put("SIGN_IN_CANCELLED", String.valueOf(12501));
        hashMap.put("SIGN_IN_REQUIRED", String.valueOf(4));
        hashMap.put("IN_PROGRESS", ASYNC_OP_IN_PROGRESS);
        hashMap.put(PLAY_SERVICES_NOT_AVAILABLE, PLAY_SERVICES_NOT_AVAILABLE);
        return hashMap;
    }

    @ReactMethod
    public void playServicesAvailable(boolean z, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.w(MODULE_NAME, "could not determine playServicesAvailable, activity is null");
            promise.reject(MODULE_NAME, "activity is null");
            return;
        }
        C4361e a = C4361e.m14332a();
        int a2 = a.mo2455a((Context) currentActivity);
        if (a2 != 0) {
            if (z && a.mo2458a(a2)) {
                a.m14337a(currentActivity, a2, (int) true).show();
            }
            promise.reject(PLAY_SERVICES_NOT_AVAILABLE, "Play services not available");
        } else {
            promise.resolve(Boolean.valueOf(true));
        }
    }

    @ReactMethod
    public void configure(ReadableMap readableMap, Promise promise) {
        ReadableArray array = readableMap.hasKey("scopes") ? readableMap.getArray("scopes") : Arguments.createArray();
        String str = null;
        String string = readableMap.hasKey("webClientId") ? readableMap.getString("webClientId") : null;
        boolean z = readableMap.hasKey("offlineAccess") && readableMap.getBoolean("offlineAccess");
        boolean z2 = readableMap.hasKey("forceConsentPrompt") && readableMap.getBoolean("forceConsentPrompt");
        String string2 = readableMap.hasKey("accountName") ? readableMap.getString("accountName") : null;
        if (readableMap.hasKey("hostedDomain")) {
            str = readableMap.getString("hostedDomain");
        }
        this._apiClient = C2734a.m7793a(getReactApplicationContext(), C0850d.m3059a(C0850d.m3061b(array), string, z, z2, string2, str));
        promise.resolve(Boolean.valueOf(true));
    }

    @ReactMethod
    public void signInSilently(Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
            return;
        }
        String str = "signInSilently";
        if (this.promiseWrapper.m3056a(promise, str)) {
            UiThreadUtil.runOnUiThread(new C08441(this));
        } else {
            rejectWithAsyncOperationStillInProgress(promise, str);
        }
    }

    private void handleSignInTaskResult(C2954g<GoogleSignInAccount> c2954g) {
        try {
            startTokenRetrievalTaskWithRecovery((GoogleSignInAccount) c2954g.mo2586a(C2782b.class));
        } catch (C2954g<GoogleSignInAccount> c2954g2) {
            c2954g2 = c2954g2.m7935a();
            this.promiseWrapper.m3054a(String.valueOf(c2954g2), C4314e.m14009a(c2954g2));
        }
    }

    @ReactMethod
    public void signIn(Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
            return;
        }
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(MODULE_NAME, "activity is null");
            return;
        }
        String str = "signIn";
        if (this.promiseWrapper.m3056a(promise, str)) {
            UiThreadUtil.runOnUiThread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ RNGoogleSigninModule f2348b;

                public void run() {
                    currentActivity.startActivityForResult(this.f2348b._apiClient.m14003a(), RNGoogleSigninModule.RC_SIGN_IN);
                }
            });
        } else {
            rejectWithAsyncOperationStillInProgress(promise, str);
        }
    }

    private void rerunFailedAuthTokenTask() {
        if (this.pendingAuthRecovery.m3050a() != null) {
            new C0846a(this).execute(new WritableMap[]{r0, null});
            return;
        }
        this.promiseWrapper.m3054a(MODULE_NAME, "rerunFailedAuthTokenTask: recovery failed");
    }

    @ReactMethod
    public void signOut(final Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
        } else {
            this._apiClient.m14005c().mo2578a(new C2950c<Void>(this) {
                /* renamed from: b */
                final /* synthetic */ RNGoogleSigninModule f8887b;

                public void onComplete(C2954g<Void> c2954g) {
                    this.f8887b.handleSignOutOrRevokeAccessTask(c2954g, promise);
                }
            });
        }
    }

    private void handleSignOutOrRevokeAccessTask(C2954g<Void> c2954g, Promise promise) {
        if (c2954g.mo2589b()) {
            promise.resolve(Boolean.valueOf(true));
            return;
        }
        c2954g = C0850d.m3057a((C2954g) c2954g);
        promise.reject(String.valueOf(c2954g), C4314e.m14009a(c2954g));
    }

    @ReactMethod
    public void revokeAccess(final Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
        } else {
            this._apiClient.m14006d().mo2578a(new C2950c<Void>(this) {
                /* renamed from: b */
                final /* synthetic */ RNGoogleSigninModule f8889b;

                public void onComplete(C2954g<Void> c2954g) {
                    this.f8889b.handleSignOutOrRevokeAccessTask(c2954g, promise);
                }
            });
        }
    }

    @ReactMethod
    public void isSignedIn(Promise promise) {
        promise.resolve(Boolean.valueOf(C2734a.m7792a(getReactApplicationContext()) != null));
    }

    @ReactMethod
    public void getCurrentUser(Promise promise) {
        Object obj;
        GoogleSignInAccount a = C2734a.m7792a(getReactApplicationContext());
        if (a == null) {
            obj = null;
        } else {
            obj = C0850d.m3058a(a);
        }
        promise.resolve(obj);
    }

    @ReactMethod
    public void clearCachedToken(String str, Promise promise) {
        String str2 = "clearCachedToken";
        if (this.promiseWrapper.m3056a(promise, str2)) {
            new C0847c(this).execute(new String[]{str});
            return;
        }
        rejectWithAsyncOperationStillInProgress(promise, str2);
    }

    @ReactMethod
    public void getTokens(Promise promise) {
        String str = "getTokensAsync";
        GoogleSignInAccount a = C2734a.m7792a(getReactApplicationContext());
        if (a == null) {
            promise.reject(MODULE_NAME, "getTokens requires a user to be signed in");
        } else if (this.promiseWrapper.m3056a(promise, str)) {
            startTokenRetrievalTaskWithRecovery(a);
        } else {
            rejectWithAsyncOperationStillInProgress(promise, str);
        }
    }

    private void startTokenRetrievalTaskWithRecovery(GoogleSignInAccount googleSignInAccount) {
        googleSignInAccount = C0850d.m3058a(googleSignInAccount);
        Arguments.createMap().putBoolean(SHOULD_RECOVER, true);
        new C0846a(this).execute(new WritableMap[]{googleSignInAccount, r0});
    }

    private void rejectWithNullClientError(Promise promise) {
        promise.reject(MODULE_NAME, "apiClient is null - call configure first");
    }

    private void rejectWithAsyncOperationStillInProgress(Promise promise, String str) {
        String str2 = ASYNC_OP_IN_PROGRESS;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot set promise. You've called \"");
        stringBuilder.append(str);
        stringBuilder.append("\" while \"");
        stringBuilder.append(this.promiseWrapper.m3052a());
        stringBuilder.append("\" is already in progress and has not completed yet. Make sure you're not repeatedly calling signInSilently and signIn from your JS code while the previous call has not completed yet.");
        promise.reject(str2, stringBuilder.toString());
    }
}
