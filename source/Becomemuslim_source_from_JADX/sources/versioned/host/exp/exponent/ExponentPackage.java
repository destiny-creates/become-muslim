package versioned.host.exp.exponent;

import android.content.Context;
import android.os.Looper;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import expo.adapters.react.C7372e;
import expo.p304a.p305a.C6002i;
import expo.p304a.p305a.C6003j;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.C6338h;
import host.exp.exponent.p346j.C6393j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import versioned.host.exp.exponent.modules.api.AmplitudeModule;
import versioned.host.exp.exponent.modules.api.BrightnessModule;
import versioned.host.exp.exponent.modules.api.CalendarModule;
import versioned.host.exp.exponent.modules.api.DocumentPickerModule;
import versioned.host.exp.exponent.modules.api.ErrorRecoveryModule;
import versioned.host.exp.exponent.modules.api.FacebookModule;
import versioned.host.exp.exponent.modules.api.ImageManipulatorModule;
import versioned.host.exp.exponent.modules.api.ImagePickerModule;
import versioned.host.exp.exponent.modules.api.IntentLauncherModule;
import versioned.host.exp.exponent.modules.api.KeepAwakeModule;
import versioned.host.exp.exponent.modules.api.KeyboardModule;
import versioned.host.exp.exponent.modules.api.MailComposerModule;
import versioned.host.exp.exponent.modules.api.PedometerModule;
import versioned.host.exp.exponent.modules.api.SQLiteModule;
import versioned.host.exp.exponent.modules.api.ScreenOrientationModule;
import versioned.host.exp.exponent.modules.api.SecureStoreModule;
import versioned.host.exp.exponent.modules.api.ShakeModule;
import versioned.host.exp.exponent.modules.api.SpeechModule;
import versioned.host.exp.exponent.modules.api.SplashScreenModule;
import versioned.host.exp.exponent.modules.api.URLHandlerModule;
import versioned.host.exp.exponent.modules.api.UpdatesModule;
import versioned.host.exp.exponent.modules.api.WebBrowserModule;
import versioned.host.exp.exponent.modules.api.av.AVModule;
import versioned.host.exp.exponent.modules.api.av.video.VideoManager;
import versioned.host.exp.exponent.modules.api.av.video.VideoViewManager;
import versioned.host.exp.exponent.modules.api.cognito.RNAWSCognitoModule;
import versioned.host.exp.exponent.modules.api.components.LinearGradientManager;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNGestureHandlerModule;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNGestureHandlerPackage;
import versioned.host.exp.exponent.modules.api.components.lottie.LottiePackage;
import versioned.host.exp.exponent.modules.api.components.maps.MapsPackage;
import versioned.host.exp.exponent.modules.api.components.svg.SvgPackage;
import versioned.host.exp.exponent.modules.api.fbads.AdIconViewManager;
import versioned.host.exp.exponent.modules.api.fbads.AdSettingsManager;
import versioned.host.exp.exponent.modules.api.fbads.BannerViewManager;
import versioned.host.exp.exponent.modules.api.fbads.InterstitialAdManager;
import versioned.host.exp.exponent.modules.api.fbads.MediaViewManager;
import versioned.host.exp.exponent.modules.api.fbads.NativeAdManager;
import versioned.host.exp.exponent.modules.api.fbads.NativeAdViewManager;
import versioned.host.exp.exponent.modules.api.notifications.NotificationsModule;
import versioned.host.exp.exponent.modules.api.reanimated.ReanimatedModule;
import versioned.host.exp.exponent.modules.api.screens.RNScreensPackage;
import versioned.host.exp.exponent.modules.api.viewshot.RNViewShotModule;
import versioned.host.exp.exponent.modules.internal.ExponentAsyncStorageModule;
import versioned.host.exp.exponent.modules.internal.ExponentIntentModule;
import versioned.host.exp.exponent.modules.internal.ExponentUnsignedAsyncStorageModule;
import versioned.host.exp.exponent.modules.test.ExponentTestNativeModule;
import versioned.host.exp.exponent.modules.universal.ExpoModuleRegistryAdapter;
import versioned.host.exp.exponent.modules.universal.ScopedModuleRegistryAdapter;

public class ExponentPackage implements ReactPackage {
    private static final String TAG = "ExponentPackage";
    private static List<C6003j> sSingletonModules;
    private static Set<Class> sSingletonModulesClasses;
    private final Map<String, Object> mExperienceProperties;
    private final boolean mIsKernel;
    private final JSONObject mManifest;
    private final ScopedModuleRegistryAdapter mModuleRegistryAdapter;

    private ExponentPackage(boolean z, Map<String, Object> map, JSONObject jSONObject, List<C6002i> list, List<C6003j> list2) {
        this.mIsKernel = z;
        this.mExperienceProperties = map;
        this.mManifest = jSONObject;
        this.mModuleRegistryAdapter = createDefaultModuleRegistryAdapterForPackages(list, list2);
    }

    public ExponentPackage(Map<String, Object> map, JSONObject jSONObject, List<C6002i> list, ExponentPackageDelegate exponentPackageDelegate, List<C6003j> list2) {
        this.mIsKernel = false;
        this.mExperienceProperties = map;
        this.mManifest = jSONObject;
        if (list == null) {
            list = ExperiencePackagePicker.packages(jSONObject);
        }
        if (exponentPackageDelegate != null) {
            this.mModuleRegistryAdapter = exponentPackageDelegate.getScopedModuleRegistryAdapterForPackages(list, list2);
        } else {
            this.mModuleRegistryAdapter = createDefaultModuleRegistryAdapterForPackages(list, list2);
        }
    }

    public static ExponentPackage kernelExponentPackage(Context context, JSONObject jSONObject, List<C6002i> list) {
        Map hashMap = new HashMap();
        List orCreateSingletonModules = getOrCreateSingletonModules(context, jSONObject, list);
        hashMap.put("linkingUri", "exp://");
        hashMap.put("isHeadless", Boolean.valueOf(false));
        return new ExponentPackage(true, hashMap, jSONObject, (List) list, orCreateSingletonModules);
    }

    public static List<C6003j> getOrCreateSingletonModules(Context context, JSONObject jSONObject, List<C6002i> list) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (sSingletonModules == null) {
                sSingletonModules = new ArrayList();
            }
            if (sSingletonModulesClasses == null) {
                sSingletonModulesClasses = new HashSet();
            }
            if (list == null) {
                list = ExperiencePackagePicker.packages(jSONObject);
            }
            for (C6002i createSingletonModules : r5) {
                list = createSingletonModules.createSingletonModules(context).iterator();
                while (list.hasNext()) {
                    C6003j c6003j = (C6003j) list.next();
                    if (!sSingletonModulesClasses.contains(c6003j.getClass())) {
                        sSingletonModules.add(c6003j);
                        sSingletonModulesClasses.add(c6003j.getClass());
                    }
                }
            }
            return sSingletonModules;
        }
        throw new RuntimeException("Singleton modules must be created on the main thread.");
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        boolean optBoolean = this.mManifest != null ? this.mManifest.optBoolean("isVerified") : false;
        List<NativeModule> arrayList = new ArrayList(Arrays.asList(new NativeModule[]{new URLHandlerModule(reactApplicationContext), new ShakeModule(reactApplicationContext), new KeyboardModule(reactApplicationContext), new UpdatesModule(reactApplicationContext, this.mExperienceProperties, this.mManifest), new ExponentIntentModule(reactApplicationContext, this.mExperienceProperties)}));
        if (this.mIsKernel) {
            arrayList.add((NativeModule) C6338h.m26057a(reactApplicationContext));
        }
        if (optBoolean) {
            try {
                C6330b a = C6330b.m26047a(this.mManifest.getString("id"));
                C6393j c6393j = new C6393j(reactApplicationContext, a.m26049b());
                arrayList.add(new ExponentAsyncStorageModule(reactApplicationContext, this.mManifest));
                arrayList.add(new NotificationsModule(reactApplicationContext, this.mManifest, this.mExperienceProperties));
                arrayList.add(new ImagePickerModule(reactApplicationContext, c6393j, a));
                arrayList.add(new ImageManipulatorModule(reactApplicationContext, c6393j));
                arrayList.add(new FacebookModule(reactApplicationContext));
                arrayList.add(new AmplitudeModule(reactApplicationContext, c6393j));
                arrayList.add(new RNViewShotModule(reactApplicationContext, c6393j));
                arrayList.add(new KeepAwakeModule(reactApplicationContext));
                arrayList.add(new ExponentTestNativeModule(reactApplicationContext));
                arrayList.add(new WebBrowserModule(reactApplicationContext));
                arrayList.add(new AVModule(reactApplicationContext, c6393j, a));
                arrayList.add(new VideoManager(reactApplicationContext));
                arrayList.add(new NativeAdManager(reactApplicationContext));
                arrayList.add(new AdSettingsManager(reactApplicationContext));
                arrayList.add(new InterstitialAdManager(reactApplicationContext));
                arrayList.add(new PedometerModule(reactApplicationContext));
                arrayList.add(new SQLiteModule(reactApplicationContext, c6393j));
                arrayList.add(new DocumentPickerModule(reactApplicationContext, c6393j));
                arrayList.add(new ErrorRecoveryModule(reactApplicationContext, a));
                arrayList.add(new IntentLauncherModule(reactApplicationContext));
                arrayList.add(new ScreenOrientationModule(reactApplicationContext));
                arrayList.add(new SpeechModule(reactApplicationContext));
                arrayList.add(new SecureStoreModule(reactApplicationContext, c6393j));
                arrayList.add(new BrightnessModule(reactApplicationContext));
                arrayList.add(new RNGestureHandlerModule(reactApplicationContext));
                arrayList.add(new RNAWSCognitoModule(reactApplicationContext));
                arrayList.add(new MailComposerModule(reactApplicationContext));
                arrayList.add(new CalendarModule(reactApplicationContext, a));
                arrayList.add(new ReanimatedModule(reactApplicationContext));
                arrayList.add(new SplashScreenModule(reactApplicationContext, a));
                arrayList.addAll(new SvgPackage().createNativeModules(reactApplicationContext));
                arrayList.addAll(this.mModuleRegistryAdapter.createNativeModules(c6393j, a, this.mExperienceProperties, this.mManifest, arrayList));
            } catch (ReactApplicationContext reactApplicationContext2) {
                C6289b.m25953c(TAG, reactApplicationContext2.toString());
            }
        } else {
            arrayList.add(new ExponentUnsignedAsyncStorageModule(reactApplicationContext2));
        }
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ViewManager> arrayList = new ArrayList(Arrays.asList(new ViewManager[]{new LinearGradientManager(), new VideoViewManager(), new NativeAdViewManager(), new BannerViewManager(), new MediaViewManager(), new AdIconViewManager()}));
        addViewManagersFromPackages(reactApplicationContext, arrayList, Arrays.asList(new ReactPackage[]{new SvgPackage(), new MapsPackage(), new LottiePackage(), new RNGestureHandlerPackage(), new RNScreensPackage()}));
        arrayList.addAll(this.mModuleRegistryAdapter.createViewManagers(reactApplicationContext));
        return arrayList;
    }

    private void addViewManagersFromPackages(ReactApplicationContext reactApplicationContext, List<ViewManager> list, List<ReactPackage> list2) {
        for (ReactPackage createViewManagers : list2) {
            list.addAll(createViewManagers.createViewManagers(reactApplicationContext));
        }
    }

    private ExpoModuleRegistryAdapter createDefaultModuleRegistryAdapterForPackages(List<C6002i> list, List<C6003j> list2) {
        return new ExpoModuleRegistryAdapter(new C7372e(list, list2));
    }
}
