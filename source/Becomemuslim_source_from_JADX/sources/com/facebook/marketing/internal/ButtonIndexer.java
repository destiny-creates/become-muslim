package com.facebook.marketing.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ButtonIndexer {
    private static final String TAG = ButtonIndexer.class.getCanonicalName();
    private Set<Activity> activitiesSet = new HashSet();
    private HashSet<String> delegateSet = new HashSet();
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<ViewProcessor> viewProcessors = new HashSet();

    /* renamed from: com.facebook.marketing.internal.ButtonIndexer$1 */
    class C18451 implements Runnable {
        C18451() {
        }

        public void run() {
            ButtonIndexer.this.processViews();
        }
    }

    protected static class ViewProcessor implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        private static volatile float displayDensity = -1.0f;
        public static volatile Set<String> loadedKeySet = new HashSet();
        private final String activityName;
        private HashSet<String> delegateSet;
        private final Handler handler;
        private WeakReference<View> rootView;
        private HashMap<String, WeakReference<View>> viewMap = new HashMap();

        public ViewProcessor(View view, String str, HashSet<String> hashSet, Handler handler) {
            this.rootView = new WeakReference(view);
            this.handler = handler;
            this.activityName = str;
            this.delegateSet = hashSet;
            if (displayDensity < null) {
                displayDensity = view.getContext().getResources().getDisplayMetrics().density;
            }
            this.handler.postDelayed(this, 200);
        }

        public void run() {
            RemoteConfig remoteConfigWithoutQuery = RemoteConfigManager.getRemoteConfigWithoutQuery(FacebookSdk.getApplicationId());
            if (remoteConfigWithoutQuery != null) {
                if (remoteConfigWithoutQuery.getEnableButtonIndexing()) {
                    process();
                }
            }
        }

        public void onGlobalLayout() {
            process();
        }

        public void onScrollChanged() {
            process();
        }

        private void process() {
            View view = (View) this.rootView.get();
            if (view != null) {
                attachListeners(view);
            }
        }

        public void attachListeners(View view) {
            view = getClickableElementsOfView(view, -1, this.activityName, false);
            if (view != null) {
                ButtonIndexingLogger.logAllIndexing(view, this.activityName);
            }
            for (Entry entry : this.viewMap.entrySet()) {
                attachListener((View) ((WeakReference) entry.getValue()).get(), (String) entry.getKey());
            }
        }

        public JSONObject getClickableElementsOfView(View view, int i, String str, boolean z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(String.valueOf(i));
            i = stringBuilder.toString();
            if (view == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                boolean isClickableView = ViewHierarchy.isClickableView(view);
                if (isClickableView) {
                    this.viewMap.put(i, new WeakReference(view));
                }
                if ((view instanceof TextView) || (view instanceof ImageView)) {
                    if (!z) {
                        if (isClickableView) {
                        }
                    }
                    if (loadedKeySet.contains(i)) {
                        return null;
                    }
                    loadedKeySet.add(i);
                    return ViewHierarchy.setAppearanceOfView(view, ViewHierarchy.setBasicInfoOfView(view, jSONObject), displayDensity);
                }
                JSONArray jSONArray = new JSONArray();
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        boolean z2;
                        JSONObject clickableElementsOfView;
                        View childAt = viewGroup.getChildAt(i2);
                        if (!z) {
                            if (!isClickableView) {
                                z2 = false;
                                clickableElementsOfView = getClickableElementsOfView(childAt, i2, i, z2);
                                if (clickableElementsOfView != null) {
                                    jSONArray.put(clickableElementsOfView);
                                }
                            }
                        }
                        z2 = true;
                        clickableElementsOfView = getClickableElementsOfView(childAt, i2, i, z2);
                        if (clickableElementsOfView != null) {
                            jSONArray.put(clickableElementsOfView);
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    view = ViewHierarchy.setBasicInfoOfView(view, jSONObject);
                    view.put("childviews", jSONArray);
                    return view;
                }
            } catch (Exception e) {
                Utility.logd(ButtonIndexer.TAG, e);
            }
            return null;
        }

        private void attachListener(View view, String str) {
            if (view != null) {
                try {
                    AccessibilityDelegate existingDelegate = ViewHierarchy.getExistingDelegate(view);
                    Object obj = null;
                    Object obj2 = existingDelegate != null ? 1 : null;
                    Object obj3 = (obj2 == null || !(existingDelegate instanceof AutoLoggingAccessibilityDelegate)) ? null : 1;
                    if (obj3 != null && ((AutoLoggingAccessibilityDelegate) existingDelegate).getSupportButtonIndexing()) {
                        obj = 1;
                    }
                    if (!this.delegateSet.contains(str) && (obj2 == null || obj3 == null || r1 == null)) {
                        view.setAccessibilityDelegate(ButtonIndexingEventListener.getAccessibilityDelegate(view, str));
                        this.delegateSet.add(str);
                    }
                } catch (View view2) {
                    Log.e(ButtonIndexer.TAG, "Failed to attach auto logging event listener.", view2);
                }
            }
        }
    }

    public void add(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.activitiesSet.add(activity);
            this.delegateSet.clear();
            startTracking();
            return;
        }
        throw new FacebookException("Can't add activity to ButtonIndexer on non-UI thread");
    }

    public void remove(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.activitiesSet.remove(activity);
            this.viewProcessors.clear();
            this.delegateSet.clear();
            return;
        }
        throw new FacebookException("Can't remove activity from ButtonIndexer on non-UI thread");
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            processViews();
        } else {
            this.uiThreadHandler.post(new C18451());
        }
    }

    private void processViews() {
        for (Activity activity : this.activitiesSet) {
            this.viewProcessors.add(new ViewProcessor(activity.getWindow().getDecorView().getRootView(), activity.getClass().getSimpleName(), this.delegateSet, this.uiThreadHandler));
        }
    }
}
