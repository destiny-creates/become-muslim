package com.bitgo.randombytes;

import android.util.Base64;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

class RandomBytesModule extends ReactContextBaseJavaModule {
    private static final String SEED_KEY = "seed";

    public String getName() {
        return "RNRandomBytes";
    }

    public RandomBytesModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void randomBytes(int i, Callback callback) {
        callback.invoke(null, getRandomBytes(i));
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(SEED_KEY, getRandomBytes(4096));
        return hashMap;
    }

    private String getRandomBytes(int i) {
        i = new byte[i];
        new SecureRandom().nextBytes(i);
        return Base64.encodeToString(i, 2);
    }
}
