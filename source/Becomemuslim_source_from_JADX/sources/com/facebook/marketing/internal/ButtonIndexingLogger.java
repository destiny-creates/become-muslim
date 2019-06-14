package com.facebook.marketing.internal;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.amplitude.api.AmplitudeClient;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ButtonIndexingLogger {
    private static final String API_ENDPOINT = "%s/button_indexing";
    private static final String TAG = ButtonIndexingLogger.class.getCanonicalName();
    private static volatile Set<String> clickedKeySet = new HashSet();
    private static volatile Set<String> loadedKeySet = new HashSet();

    private static JSONObject generateButtonDetail(View view, String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            str = str.split("\\.", -1);
            int length = str.length - 1;
            View view2 = view;
            while (view2 != null) {
                Object obj;
                Object obj2;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("classname", view2.getClass().getCanonicalName());
                jSONObject2.put("index", str[length]);
                jSONObject2.put("id", view2.getId());
                if (SensitiveUserDataUtils.isSensitiveUserData(view2)) {
                    obj = "";
                } else {
                    obj = ViewHierarchy.getTextOfView(view2);
                }
                jSONObject2.put("text", obj);
                jSONObject2.put("tag", view2.getTag() == null ? "" : String.valueOf(view2.getTag()));
                String str2 = "description";
                if (view2.getContentDescription() == null) {
                    obj2 = "";
                } else {
                    obj2 = String.valueOf(view2.getContentDescription());
                }
                jSONObject2.put(str2, obj2);
                jSONArray.put(jSONObject2);
                view2 = ViewHierarchy.getParentOfView(view2);
                length--;
            }
            str = new JSONArray();
            for (int length2 = jSONArray.length() - 1; length2 >= 0; length2--) {
                str.put(jSONArray.get(length2));
            }
            jSONObject.put("path", str);
            jSONObject.put("is_from_click", z);
            if ((view instanceof ImageView) != null) {
                view = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
                str = new ByteArrayOutputStream();
                view.compress(CompressFormat.PNG, 100, str);
                jSONObject.put(MessengerShareContentUtility.MEDIA_IMAGE, Base64.encodeToString(str.toByteArray(), null));
            }
            return jSONObject;
        } catch (View view3) {
            Log.e(TAG, "Log button indexing error", view3);
            return new JSONObject();
        }
    }

    private static void sendGraphAPIRequest(Context context, String str, String str2) {
        context = AttributionIdentifiers.getAttributionIdentifiers(context);
        if (context != null && context.getAndroidAdvertiserId() != null) {
            context = context.getAndroidAdvertiserId();
            String appVersion = AppEventUtility.getAppVersion();
            Bundle bundle = new Bundle();
            try {
                bundle.putString("app_version", appVersion);
                bundle.putString(AmplitudeClient.DEVICE_ID_KEY, context);
                bundle.putString("indexed_button_list", str);
                context = GraphRequest.newPostRequest(null, String.format(Locale.US, API_ENDPOINT, new Object[]{str2}), null, null);
                context.setParameters(bundle);
                context.executeAndWait();
            } catch (Context context2) {
                Log.e(TAG, "failed to send button indexing request", context2);
            }
        }
    }

    public static void logIndexing(String str, View view, String str2, Context context) {
        if (!clickedKeySet.contains(str2)) {
            clickedKeySet.add(str2);
            if (generateButtonDetail(view, str2, true).length() > null) {
                sendGraphAPIRequest(context, new JSONArray(Arrays.asList(new String[]{generateButtonDetail(view, str2, true).toString()})).toString(), str);
            }
        }
    }

    public static void logAllIndexing(final JSONObject jSONObject, final String str) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    String applicationId = FacebookSdk.getApplicationId();
                    AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                    jSONObject.put("screenname", str);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    jSONObject.put("view", jSONArray);
                    GraphRequest buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(jSONObject.toString(), currentAccessToken, applicationId, Constants.BUTTON_SAMPLING);
                    if (buildAppIndexingRequest != null) {
                        buildAppIndexingRequest.executeAndWait();
                    }
                } catch (Exception e) {
                    Utility.logd(ButtonIndexingLogger.TAG, e);
                }
            }
        });
    }
}
