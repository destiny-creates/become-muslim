package com.facebook.react.modules.fresco;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner.Cleanable;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import expolib_v1.com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import expolib_v1.p321a.C7487t;
import expolib_v1.p321a.C7490w;
import java.util.HashSet;
import java.util.Set;

@ReactModule(name = "FrescoModule")
public class FrescoModule extends ReactContextBaseJavaModule implements LifecycleEventListener, Cleanable {
    private static boolean sHasBeenInitialized = false;
    private final boolean mClearOnDestroy;
    private ImagePipelineConfig mConfig;

    public String getName() {
        return "FrescoModule";
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, true, null);
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z) {
        this(reactApplicationContext, z, null);
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z, ImagePipelineConfig imagePipelineConfig) {
        super(reactApplicationContext);
        this.mClearOnDestroy = z;
        this.mConfig = imagePipelineConfig;
    }

    public void initialize() {
        super.initialize();
        getReactApplicationContext().addLifecycleEventListener(this);
        if (!hasBeenInitialized()) {
            if (this.mConfig == null) {
                this.mConfig = getDefaultConfig(getReactApplicationContext());
            }
            Fresco.initialize(getReactApplicationContext().getApplicationContext(), this.mConfig);
            sHasBeenInitialized = true;
        } else if (this.mConfig != null) {
            FLog.m5714w(ReactConstants.TAG, "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
        }
        this.mConfig = null;
    }

    public void clearSensitiveData() {
        Fresco.getImagePipeline().clearCaches();
    }

    public static boolean hasBeenInitialized() {
        return sHasBeenInitialized;
    }

    private static ImagePipelineConfig getDefaultConfig(ReactContext reactContext) {
        return getDefaultConfigBuilder(reactContext).build();
    }

    public static Builder getDefaultConfigBuilder(ReactContext reactContext) {
        Set hashSet = new HashSet();
        hashSet.add(new SystraceRequestListener());
        C7490w createClient = OkHttpClientProvider.createClient();
        ((CookieJarContainer) createClient.g()).setCookieJar(new C7487t(new ForwardingCookieHandler(reactContext)));
        return OkHttpImagePipelineConfigFactory.newBuilder(reactContext.getApplicationContext(), createClient).setNetworkFetcher(new ReactOkHttpNetworkFetcher(createClient)).setDownsampleEnabled(false).setRequestListeners(hashSet);
    }

    public void onHostDestroy() {
        if (hasBeenInitialized() && this.mClearOnDestroy) {
            Fresco.getImagePipeline().clearMemoryCaches();
        }
    }
}
