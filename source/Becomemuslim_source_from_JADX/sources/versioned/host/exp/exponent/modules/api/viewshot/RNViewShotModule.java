package versioned.host.exp.exponent.modules.api.viewshot;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import host.exp.exponent.p346j.C6393j;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.Map;

public class RNViewShotModule extends ReactContextBaseJavaModule {
    public static final String RNVIEW_SHOT = "RNViewShot";
    private static final String TEMP_FILE_PREFIX = "ReactNative-snapshot-image";
    private final C6393j mScopedContext;
    private final ReactApplicationContext reactContext;

    private static class CleanTask extends GuardedAsyncTask<Void, Void> implements FilenameFilter {
        private final File cacheDir;
        private final File externalCacheDir;

        private CleanTask(ReactContext reactContext) {
            super(reactContext);
            this.cacheDir = reactContext.getCacheDir();
            this.externalCacheDir = reactContext.getExternalCacheDir();
        }

        protected void doInBackgroundGuarded(Void... voidArr) {
            if (this.cacheDir != null) {
                cleanDirectory(this.cacheDir);
            }
            if (this.externalCacheDir != null) {
                cleanDirectory(this.externalCacheDir);
            }
        }

        public final boolean accept(File file, String str) {
            return str.startsWith(RNViewShotModule.TEMP_FILE_PREFIX);
        }

        private void cleanDirectory(File file) {
            file = file.listFiles(this);
            if (file != null) {
                for (File file2 : file) {
                    if (file2.delete()) {
                        String str = RNViewShotModule.RNVIEW_SHOT;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("deleted file: ");
                        stringBuilder.append(file2.getAbsolutePath());
                        Log.d(str, stringBuilder.toString());
                    }
                }
            }
        }
    }

    public String getName() {
        return RNVIEW_SHOT;
    }

    public RNViewShotModule(ReactApplicationContext reactApplicationContext, C6393j c6393j) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.mScopedContext = c6393j;
    }

    public Map<String, Object> getConstants() {
        return Collections.emptyMap();
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        new CleanTask(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void releaseCapture(String str) {
        str = Uri.parse(str).getPath();
        if (str != null) {
            File file = new File(str);
            if (file.exists() != null) {
                str = file.getParentFile();
                if (str.equals(this.reactContext.getExternalCacheDir()) || str.equals(this.reactContext.getCacheDir()) != null) {
                    file.delete();
                }
            }
        }
    }

    @com.facebook.react.bridge.ReactMethod
    public void captureRef(int r19, com.facebook.react.bridge.ReadableMap r20, com.facebook.react.bridge.Promise r21) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r18 = this;
        r0 = r18;
        r1 = r20;
        r2 = r18.getReactApplicationContext();
        r2 = r2.getResources();
        r2 = r2.getDisplayMetrics();
        r3 = "format";
        r6 = r1.getString(r3);
        r3 = "jpg";
        r3 = r3.equals(r6);
        if (r3 == 0) goto L_0x0021;
    L_0x001e:
        r3 = 0;
        r7 = 0;
        goto L_0x0039;
    L_0x0021:
        r3 = "webm";
        r3 = r3.equals(r6);
        if (r3 == 0) goto L_0x002c;
    L_0x0029:
        r3 = 2;
        r7 = 2;
        goto L_0x0039;
    L_0x002c:
        r3 = "raw";
        r3 = r3.equals(r6);
        if (r3 == 0) goto L_0x0037;
    L_0x0034:
        r3 = -1;
        r7 = -1;
        goto L_0x0039;
    L_0x0037:
        r3 = 1;
        r7 = 1;
    L_0x0039:
        r3 = "quality";
        r8 = r1.getDouble(r3);
        r3 = "width";
        r3 = r1.hasKey(r3);
        r4 = 0;
        if (r3 == 0) goto L_0x005a;
    L_0x0048:
        r3 = r2.density;
        r10 = (double) r3;
        r3 = "width";
        r12 = r1.getDouble(r3);
        r10 = r10 * r12;
        r3 = (int) r10;
        r3 = java.lang.Integer.valueOf(r3);
        r10 = r3;
        goto L_0x005b;
    L_0x005a:
        r10 = r4;
    L_0x005b:
        r3 = "height";
        r3 = r1.hasKey(r3);
        if (r3 == 0) goto L_0x0075;
    L_0x0063:
        r2 = r2.density;
        r2 = (double) r2;
        r5 = "height";
        r11 = r1.getDouble(r5);
        r2 = r2 * r11;
        r2 = (int) r2;
        r2 = java.lang.Integer.valueOf(r2);
        r11 = r2;
        goto L_0x0076;
    L_0x0075:
        r11 = r4;
    L_0x0076:
        r2 = "result";
        r13 = r1.getString(r2);
        r2 = "snapshotContentContainer";
        r1 = r1.getBoolean(r2);
        r14 = java.lang.Boolean.valueOf(r1);
        r1 = "tmpfile";	 Catch:{ Throwable -> 0x00b5 }
        r1 = r1.equals(r13);	 Catch:{ Throwable -> 0x00b5 }
        if (r1 == 0) goto L_0x0096;	 Catch:{ Throwable -> 0x00b5 }
    L_0x008e:
        r1 = r0.mScopedContext;	 Catch:{ Throwable -> 0x00b5 }
        r1 = r0.createTempFile(r1, r6);	 Catch:{ Throwable -> 0x00b5 }
        r12 = r1;	 Catch:{ Throwable -> 0x00b5 }
        goto L_0x0097;	 Catch:{ Throwable -> 0x00b5 }
    L_0x0096:
        r12 = r4;	 Catch:{ Throwable -> 0x00b5 }
    L_0x0097:
        r16 = r18.getCurrentActivity();	 Catch:{ Throwable -> 0x00b5 }
        r1 = r0.reactContext;	 Catch:{ Throwable -> 0x00b5 }
        r2 = com.facebook.react.uimanager.UIManagerModule.class;	 Catch:{ Throwable -> 0x00b5 }
        r1 = r1.getNativeModule(r2);	 Catch:{ Throwable -> 0x00b5 }
        r1 = (com.facebook.react.uimanager.UIManagerModule) r1;	 Catch:{ Throwable -> 0x00b5 }
        r2 = new versioned.host.exp.exponent.modules.api.viewshot.ViewShot;	 Catch:{ Throwable -> 0x00b5 }
        r15 = r0.reactContext;	 Catch:{ Throwable -> 0x00b5 }
        r4 = r2;	 Catch:{ Throwable -> 0x00b5 }
        r5 = r19;	 Catch:{ Throwable -> 0x00b5 }
        r17 = r21;	 Catch:{ Throwable -> 0x00b5 }
        r4.<init>(r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ Throwable -> 0x00b5 }
        r1.addUIBlock(r2);	 Catch:{ Throwable -> 0x00b5 }
        goto L_0x00cf;
    L_0x00b5:
        r1 = "E_UNABLE_TO_SNAPSHOT";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Failed to snapshot view tag ";
        r2.append(r3);
        r3 = r19;
        r2.append(r3);
        r2 = r2.toString();
        r3 = r21;
        r3.reject(r1, r2);
    L_0x00cf:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.viewshot.RNViewShotModule.captureRef(int, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void captureScreen(ReadableMap readableMap, Promise promise) {
        captureRef(-1, readableMap, promise);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File createTempFile(android.content.Context r6, java.lang.String r7) {
        /*
        r5 = this;
        r0 = r6.getExternalCacheDir();
        r6 = r6.getCacheDir();
        if (r0 != 0) goto L_0x0015;
    L_0x000a:
        if (r6 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0015;
    L_0x000d:
        r6 = new java.io.IOException;
        r7 = "No cache directory available";
        r6.<init>(r7);
        throw r6;
    L_0x0015:
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        r0 = r6;
        goto L_0x0028;
    L_0x0019:
        if (r6 != 0) goto L_0x001c;
    L_0x001b:
        goto L_0x0028;
    L_0x001c:
        r1 = r0.getFreeSpace();
        r3 = r6.getFreeSpace();
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x0017;
    L_0x0028:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r1 = ".";
        r6.append(r1);
        r6.append(r7);
        r6 = r6.toString();
        r7 = "ReactNative-snapshot-image";
        r6 = java.io.File.createTempFile(r7, r6, r0);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.viewshot.RNViewShotModule.createTempFile(android.content.Context, java.lang.String):java.io.File");
    }
}
