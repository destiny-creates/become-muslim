package versioned.host.exp.exponent.modules.api;

import android.content.Intent;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import host.exp.exponent.C6292b;
import host.exp.p333a.C6271b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class FacebookModule extends ReactContextBaseJavaModule implements C6292b {
    private CallbackManager mCallbackManager = Factory.create();

    public String getName() {
        return "ExponentFacebook";
    }

    public FacebookModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        C6271b.m25897a().m25912a((C6292b) this);
        FacebookSdk.sdkInitialize(reactApplicationContext);
    }

    private WritableArray arrayFromPermissions(Set<String> set) {
        WritableArray createArray = Arguments.createArray();
        for (String pushString : set) {
            createArray.pushString(pushString);
        }
        return createArray;
    }

    @ReactMethod
    public void logInWithReadPermissionsAsync(final String str, ReadableMap readableMap, final Promise promise) {
        Collection arrayList;
        AccessToken.setCurrentAccessToken(null);
        FacebookSdk.setApplicationId(str);
        Object obj = null;
        if (readableMap.hasKey(NativeProtocol.RESULT_ARGS_PERMISSIONS)) {
            arrayList = new ArrayList();
            ReadableArray array = readableMap.getArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getString(i));
            }
        } else {
            arrayList = Arrays.asList(new String[]{"public_profile", "email"});
        }
        if (readableMap.hasKey("behavior")) {
            LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
            readableMap = readableMap.getString("behavior");
            int hashCode = readableMap.hashCode();
            if (hashCode != 117588) {
                if (hashCode == 150940456) {
                    if (readableMap.equals("browser") != null) {
                        switch (obj) {
                            case null:
                                loginBehavior = LoginBehavior.WEB_ONLY;
                                break;
                            case 1:
                                loginBehavior = LoginBehavior.WEB_VIEW_ONLY;
                                break;
                            default:
                                break;
                        }
                        LoginManager.getInstance().setLoginBehavior(loginBehavior);
                    }
                }
            } else if (readableMap.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB) != null) {
                obj = 1;
                switch (obj) {
                    case null:
                        loginBehavior = LoginBehavior.WEB_ONLY;
                        break;
                    case 1:
                        loginBehavior = LoginBehavior.WEB_VIEW_ONLY;
                        break;
                    default:
                        break;
                }
                LoginManager.getInstance().setLoginBehavior(loginBehavior);
            }
            obj = -1;
            switch (obj) {
                case null:
                    loginBehavior = LoginBehavior.WEB_ONLY;
                    break;
                case 1:
                    loginBehavior = LoginBehavior.WEB_VIEW_ONLY;
                    break;
                default:
                    break;
            }
            LoginManager.getInstance().setLoginBehavior(loginBehavior);
        }
        LoginManager.getInstance().registerCallback(this.mCallbackManager, new FacebookCallback<LoginResult>() {
            public void onSuccess(LoginResult loginResult) {
                LoginManager.getInstance().registerCallback(FacebookModule.this.mCallbackManager, null);
                if (str.equals(loginResult.getAccessToken().getApplicationId())) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("type", GraphResponse.SUCCESS_KEY);
                    createMap.putString("token", loginResult.getAccessToken().getToken());
                    createMap.putInt("expires", (int) (loginResult.getAccessToken().getExpires().getTime() / 1000));
                    createMap.putArray(NativeProtocol.RESULT_ARGS_PERMISSIONS, FacebookModule.this.arrayFromPermissions(loginResult.getAccessToken().getPermissions()));
                    createMap.putArray("declinedPermissions", FacebookModule.this.arrayFromPermissions(loginResult.getAccessToken().getDeclinedPermissions()));
                    promise.resolve(createMap);
                    return;
                }
                promise.reject(new IllegalStateException("Logged into wrong app, try again?"));
            }

            public void onCancel() {
                LoginManager.getInstance().registerCallback(FacebookModule.this.mCallbackManager, null);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "cancel");
                promise.resolve(createMap);
            }

            public void onError(FacebookException facebookException) {
                LoginManager.getInstance().registerCallback(FacebookModule.this.mCallbackManager, null);
                promise.reject(facebookException);
            }
        });
        try {
            LoginManager.getInstance().logInWithReadPermissions(C6271b.m25897a().m25920b(), arrayList);
        } catch (String str2) {
            promise.reject("E_FBLOGIN_ERROR", "An error occurred while trying to log in to Facebook", str2);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mCallbackManager.onActivityResult(i, i2, intent);
    }
}
