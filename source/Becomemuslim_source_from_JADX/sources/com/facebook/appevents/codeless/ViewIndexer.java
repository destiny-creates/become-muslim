package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class ViewIndexer {
    private static final String APP_VERSION_PARAM = "app_version";
    private static final String PLATFORM_PARAM = "platform";
    private static final String REQUEST_TYPE = "request_type";
    private static final String SUCCESS = "success";
    private static final String TAG = ViewIndexer.class.getCanonicalName();
    private static final String TREE_PARAM = "tree";
    private static ViewIndexer instance;
    private WeakReference<Activity> activityReference;
    private Timer indexingTimer;
    private String previousDigest = null;
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    private static class ScreenshotTaker implements Callable<String> {
        private WeakReference<View> rootView;

        public ScreenshotTaker(View view) {
            this.rootView = new WeakReference(view);
        }

        public String call() {
            View view = (View) this.rootView.get();
            if (!(view == null || view.getWidth() == 0)) {
                if (view.getHeight() != 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
                    view.draw(new Canvas(createBitmap));
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    createBitmap.compress(CompressFormat.JPEG, 10, byteArrayOutputStream);
                    return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                }
            }
            return "";
        }
    }

    /* renamed from: com.facebook.appevents.codeless.ViewIndexer$4 */
    static class C37064 implements Callback {
        C37064() {
        }

        public void onCompleted(GraphResponse graphResponse) {
            Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "App index sent to FB!");
        }
    }

    public ViewIndexer(Activity activity) {
        this.activityReference = new WeakReference(activity);
        instance = this;
    }

    public void schedule() {
        final Activity activity = (Activity) this.activityReference.get();
        if (activity != null) {
            final String simpleName = activity.getClass().getSimpleName();
            FacebookSdk.getApplicationId();
            final TimerTask c17081 = new TimerTask() {
                public void run() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                    /*
                    r6 = this;
                    r0 = r0;	 Catch:{ Exception -> 0x0082 }
                    r0 = r0.getWindow();	 Catch:{ Exception -> 0x0082 }
                    r0 = r0.getDecorView();	 Catch:{ Exception -> 0x0082 }
                    r0 = r0.getRootView();	 Catch:{ Exception -> 0x0082 }
                    r1 = com.facebook.appevents.internal.ActivityLifecycleTracker.getIsAppIndexingEnabled();	 Catch:{ Exception -> 0x0082 }
                    if (r1 != 0) goto L_0x0015;	 Catch:{ Exception -> 0x0082 }
                L_0x0014:
                    return;	 Catch:{ Exception -> 0x0082 }
                L_0x0015:
                    r1 = com.facebook.internal.InternalSettings.isUnityApp();	 Catch:{ Exception -> 0x0082 }
                    if (r1 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x0082 }
                L_0x001b:
                    com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy();	 Catch:{ Exception -> 0x0082 }
                    return;	 Catch:{ Exception -> 0x0082 }
                L_0x001f:
                    r1 = new java.util.concurrent.FutureTask;	 Catch:{ Exception -> 0x0082 }
                    r2 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker;	 Catch:{ Exception -> 0x0082 }
                    r2.<init>(r0);	 Catch:{ Exception -> 0x0082 }
                    r1.<init>(r2);	 Catch:{ Exception -> 0x0082 }
                    r2 = com.facebook.appevents.codeless.ViewIndexer.this;	 Catch:{ Exception -> 0x0082 }
                    r2 = r2.uiThreadHandler;	 Catch:{ Exception -> 0x0082 }
                    r2.post(r1);	 Catch:{ Exception -> 0x0082 }
                    r2 = "";	 Catch:{ Exception -> 0x0082 }
                    r3 = 1;
                    r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Exception -> 0x003f }
                    r1 = r1.get(r3, r5);	 Catch:{ Exception -> 0x003f }
                    r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x003f }
                    goto L_0x004a;
                L_0x003f:
                    r1 = move-exception;
                    r3 = com.facebook.appevents.codeless.ViewIndexer.TAG;	 Catch:{ Exception -> 0x0082 }
                    r4 = "Failed to take screenshot.";	 Catch:{ Exception -> 0x0082 }
                    android.util.Log.e(r3, r4, r1);	 Catch:{ Exception -> 0x0082 }
                    r1 = r2;	 Catch:{ Exception -> 0x0082 }
                L_0x004a:
                    r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0082 }
                    r2.<init>();	 Catch:{ Exception -> 0x0082 }
                    r3 = "screenname";	 Catch:{ JSONException -> 0x006d }
                    r4 = r1;	 Catch:{ JSONException -> 0x006d }
                    r2.put(r3, r4);	 Catch:{ JSONException -> 0x006d }
                    r3 = "screenshot";	 Catch:{ JSONException -> 0x006d }
                    r2.put(r3, r1);	 Catch:{ JSONException -> 0x006d }
                    r1 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x006d }
                    r1.<init>();	 Catch:{ JSONException -> 0x006d }
                    r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r0);	 Catch:{ JSONException -> 0x006d }
                    r1.put(r0);	 Catch:{ JSONException -> 0x006d }
                    r0 = "view";	 Catch:{ JSONException -> 0x006d }
                    r2.put(r0, r1);	 Catch:{ JSONException -> 0x006d }
                    goto L_0x0076;
                L_0x006d:
                    r0 = com.facebook.appevents.codeless.ViewIndexer.TAG;	 Catch:{ Exception -> 0x0082 }
                    r1 = "Failed to create JSONObject";	 Catch:{ Exception -> 0x0082 }
                    android.util.Log.e(r0, r1);	 Catch:{ Exception -> 0x0082 }
                L_0x0076:
                    r0 = r2.toString();	 Catch:{ Exception -> 0x0082 }
                    r1 = com.facebook.appevents.codeless.ViewIndexer.this;	 Catch:{ Exception -> 0x0082 }
                    r2 = r1;	 Catch:{ Exception -> 0x0082 }
                    r1.sendToServer(r0, r2);	 Catch:{ Exception -> 0x0082 }
                    goto L_0x008c;
                L_0x0082:
                    r0 = move-exception;
                    r1 = com.facebook.appevents.codeless.ViewIndexer.TAG;
                    r2 = "UI Component tree indexing failure!";
                    android.util.Log.e(r1, r2, r0);
                L_0x008c:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer.1.run():void");
                }
            };
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    try {
                        if (ViewIndexer.this.indexingTimer != null) {
                            ViewIndexer.this.indexingTimer.cancel();
                        }
                        ViewIndexer.this.previousDigest = null;
                        ViewIndexer.this.indexingTimer = new Timer();
                        ViewIndexer.this.indexingTimer.scheduleAtFixedRate(c17081, 0, 1000);
                    } catch (Throwable e) {
                        Log.e(ViewIndexer.TAG, "Error scheduling indexing job", e);
                    }
                }
            });
        }
    }

    public void unschedule() {
        if (!(((Activity) this.activityReference.get()) == null || this.indexingTimer == null)) {
            try {
                this.indexingTimer.cancel();
                this.indexingTimer = null;
            } catch (Throwable e) {
                Log.e(TAG, "Error unscheduling indexing job", e);
            }
        }
    }

    public static void sendToServerUnityInstance(String str) {
        if (instance != null) {
            instance.sendToServerUnity(str);
        }
    }

    @Deprecated
    public void sendToServerUnity(String str) {
        Activity activity = (Activity) this.activityReference.get();
        String str2 = "";
        if (activity != null) {
            str2 = activity.getClass().getSimpleName();
        }
        instance.sendToServer(str, str2);
    }

    private void sendToServer(final String str, String str2) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                String applicationId = FacebookSdk.getApplicationId();
                String md5hash = Utility.md5hash(str);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                if (md5hash == null || !md5hash.equals(ViewIndexer.this.previousDigest)) {
                    GraphRequest buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(str, currentAccessToken, applicationId, Constants.APP_INDEXING);
                    if (buildAppIndexingRequest != null) {
                        GraphResponse executeAndWait = buildAppIndexingRequest.executeAndWait();
                        try {
                            JSONObject jSONObject = executeAndWait.getJSONObject();
                            if (jSONObject != null) {
                                if (jSONObject.has("success") && jSONObject.getString("success") == ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) {
                                    Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "Successfully send UI component tree to server");
                                    ViewIndexer.this.previousDigest = md5hash;
                                }
                                if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                                    ActivityLifecycleTracker.updateAppIndexing(Boolean.valueOf(jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED)));
                                }
                            } else {
                                md5hash = ViewIndexer.TAG;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Error sending UI component tree to Facebook: ");
                                stringBuilder.append(executeAndWait.getError());
                                Log.e(md5hash, stringBuilder.toString());
                            }
                        } catch (Throwable e) {
                            Log.e(ViewIndexer.TAG, "Error decoding server response.", e);
                        }
                    }
                }
            }
        });
    }

    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        if (str == null) {
            return null;
        }
        accessToken = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", new Object[]{str2}), null, null);
        str2 = accessToken.getParameters();
        if (str2 == null) {
            str2 = new Bundle();
        }
        str2.putString(TREE_PARAM, str);
        str2.putString(APP_VERSION_PARAM, AppEventUtility.getAppVersion());
        str2.putString(PLATFORM_PARAM, "android");
        str2.putString(REQUEST_TYPE, str3);
        if (str3.equals(Constants.APP_INDEXING) != null) {
            str2.putString(Constants.DEVICE_SESSION_ID, ActivityLifecycleTracker.getCurrentDeviceSessionID());
        }
        accessToken.setParameters(str2);
        accessToken.setCallback(new C37064());
        return accessToken;
    }
}
