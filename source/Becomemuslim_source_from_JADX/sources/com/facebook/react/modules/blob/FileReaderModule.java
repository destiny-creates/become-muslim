package com.facebook.react.modules.blob;

import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "FileReaderModule")
public class FileReaderModule extends ReactContextBaseJavaModule {
    private static final String ERROR_INVALID_BLOB = "ERROR_INVALID_BLOB";
    protected static final String NAME = "FileReaderModule";

    public String getName() {
        return NAME;
    }

    public FileReaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private BlobModule getBlobModule() {
        return (BlobModule) getReactApplicationContext().getNativeModule(BlobModule.class);
    }

    @ReactMethod
    public void readAsText(ReadableMap readableMap, String str, Promise promise) {
        readableMap = getBlobModule().resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size"));
        if (readableMap == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is invalid");
            return;
        }
        try {
            promise.resolve(new String(readableMap, str));
        } catch (Throwable e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void readAsDataURL(ReadableMap readableMap, Promise promise) {
        byte[] resolve = getBlobModule().resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size"));
        if (resolve == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is invalid");
            return;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("data:");
            if (!readableMap.hasKey("type") || readableMap.getString("type").isEmpty()) {
                stringBuilder.append("application/octet-stream");
            } else {
                stringBuilder.append(readableMap.getString("type"));
            }
            stringBuilder.append(";base64,");
            stringBuilder.append(Base64.encodeToString(resolve, 2));
            promise.resolve(stringBuilder.toString());
        } catch (Throwable e) {
            promise.reject(e);
        }
    }
}
