package versioned.host.exp.exponent.modules.internal;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.modules.storage.AsyncStorageModule;
import host.exp.exponent.p339f.C6355n;

public class ExponentUnsignedAsyncStorageModule extends ReactContextBaseJavaModule {
    private static final String ERROR_MESSAGE = "Can't use AsyncStorage in unsigned Experience.";

    public boolean canOverrideExistingModule() {
        return true;
    }

    public String getName() {
        return AsyncStorageModule.NAME;
    }

    public ExponentUnsignedAsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void multiGet(ReadableArray readableArray, Callback callback) {
        C6355n.m26073a().mo5408a(ERROR_MESSAGE);
    }

    @ReactMethod
    public void multiSet(ReadableArray readableArray, Callback callback) {
        C6355n.m26073a().mo5408a(ERROR_MESSAGE);
    }

    @ReactMethod
    public void multiRemove(ReadableArray readableArray, Callback callback) {
        C6355n.m26073a().mo5408a(ERROR_MESSAGE);
    }

    @ReactMethod
    public void multiMerge(ReadableArray readableArray, Callback callback) {
        C6355n.m26073a().mo5408a(ERROR_MESSAGE);
    }

    @ReactMethod
    public void clear(Callback callback) {
        C6355n.m26073a().mo5408a(ERROR_MESSAGE);
    }

    @ReactMethod
    public void getAllKeys(Callback callback) {
        C6355n.m26073a().mo5408a(ERROR_MESSAGE);
    }
}
