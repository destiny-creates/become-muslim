package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class InAppPurchaseActivityLifecycleTracker {
    private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
    private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
    private static ActivityLifecycleCallbacks callbacks;
    private static Boolean hasBiillingActivity = null;
    private static Boolean hasBillingService = null;
    private static Object inAppBillingObj;
    private static Intent intent;
    private static final AtomicBoolean isTracking = new AtomicBoolean(false);
    private static ServiceConnection serviceConnection;

    /* renamed from: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$1 */
    static class C17191 implements ServiceConnection {
        public void onServiceDisconnected(ComponentName componentName) {
        }

        C17191() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InAppPurchaseActivityLifecycleTracker.inAppBillingObj = InAppPurchaseEventManager.asInterface(FacebookSdk.getApplicationContext(), iBinder);
        }
    }

    /* renamed from: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$2 */
    static class C17222 implements ActivityLifecycleCallbacks {

        /* renamed from: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$2$1 */
        class C17201 implements Runnable {
            C17201() {
            }

            public void run() {
                Context applicationContext = FacebookSdk.getApplicationContext();
                InAppPurchaseActivityLifecycleTracker.logPurchaseInapp(applicationContext, InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj));
                Map purchasesSubs = InAppPurchaseEventManager.getPurchasesSubs(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                Iterator it = InAppPurchaseEventManager.getPurchasesSubsExpire(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj).iterator();
                while (it.hasNext()) {
                    purchasesSubs.put((String) it.next(), SubscriptionType.EXPIRE);
                }
                InAppPurchaseActivityLifecycleTracker.logPurchaseSubs(applicationContext, purchasesSubs);
            }
        }

        /* renamed from: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$2$2 */
        class C17212 implements Runnable {
            C17212() {
            }

            public void run() {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ArrayList purchasesInapp = InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                if (purchasesInapp.isEmpty()) {
                    purchasesInapp = InAppPurchaseEventManager.getPurchaseHistoryInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                }
                InAppPurchaseActivityLifecycleTracker.logPurchaseInapp(applicationContext, purchasesInapp);
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        C17222() {
        }

        public void onActivityResumed(Activity activity) {
            FacebookSdk.getExecutor().execute(new C17201());
        }

        public void onActivityStopped(Activity activity) {
            if (InAppPurchaseActivityLifecycleTracker.hasBiillingActivity.booleanValue() && activity.getLocalClassName().equals(InAppPurchaseActivityLifecycleTracker.BILLING_ACTIVITY_NAME) != null) {
                FacebookSdk.getExecutor().execute(new C17212());
            }
        }
    }

    public static void update() {
        initializeIfNotInitialized();
        if (hasBillingService.booleanValue() && AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            startTracking();
        }
    }

    private static void initializeIfNotInitialized() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = hasBillingService;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 0;
        r1 = "com.android.vending.billing.IInAppBillingService$Stub";	 Catch:{ ClassNotFoundException -> 0x0045 }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0045 }
        r1 = 1;	 Catch:{ ClassNotFoundException -> 0x0045 }
        r2 = java.lang.Boolean.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0045 }
        hasBillingService = r2;	 Catch:{ ClassNotFoundException -> 0x0045 }
        r2 = "com.android.billingclient.api.ProxyBillingActivity";	 Catch:{ ClassNotFoundException -> 0x001e }
        java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x001e }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x001e }
        hasBiillingActivity = r1;	 Catch:{ ClassNotFoundException -> 0x001e }
        goto L_0x0024;
    L_0x001e:
        r0 = java.lang.Boolean.valueOf(r0);
        hasBiillingActivity = r0;
    L_0x0024:
        com.facebook.appevents.internal.InAppPurchaseEventManager.clearSkuDetailsCache();
        r0 = new android.content.Intent;
        r1 = "com.android.vending.billing.InAppBillingService.BIND";
        r0.<init>(r1);
        r1 = "com.android.vending";
        r0 = r0.setPackage(r1);
        intent = r0;
        r0 = new com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$1;
        r0.<init>();
        serviceConnection = r0;
        r0 = new com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$2;
        r0.<init>();
        callbacks = r0;
        return;
    L_0x0045:
        r0 = java.lang.Boolean.valueOf(r0);
        hasBillingService = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized():void");
    }

    private static void startTracking() {
        if (isTracking.compareAndSet(false, true)) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(callbacks);
                applicationContext.bindService(intent, serviceConnection, 1);
            }
        }
    }

    private static void logPurchaseInapp(Context context, ArrayList<String> arrayList) {
        if (!arrayList.isEmpty()) {
            Map hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                String str = (String) arrayList.next();
                try {
                    String string = new JSONObject(str).getString("productId");
                    hashMap.put(string, str);
                    arrayList2.add(string);
                } catch (Throwable e) {
                    Log.e(TAG, "Error parsing in-app purchase data.", e);
                }
            }
            for (Entry entry : InAppPurchaseEventManager.getSkuDetails(context, arrayList2, inAppBillingObj, false).entrySet()) {
                AutomaticAnalyticsLogger.logPurchaseInapp((String) hashMap.get(entry.getKey()), (String) entry.getValue());
            }
        }
    }

    private static void logPurchaseSubs(Context context, Map<String, SubscriptionType> map) {
        if (!map.isEmpty()) {
            String str;
            Map hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                try {
                    String string = new JSONObject(str2).getString("productId");
                    arrayList.add(string);
                    hashMap.put(string, str2);
                } catch (Throwable e) {
                    Log.e(TAG, "Error parsing in-app purchase data.", e);
                }
            }
            context = InAppPurchaseEventManager.getSkuDetails(context, arrayList, inAppBillingObj, true);
            for (String str3 : context.keySet()) {
                str2 = (String) hashMap.get(str3);
                AutomaticAnalyticsLogger.logPurchaseSubs((SubscriptionType) map.get(str2), str2, (String) context.get(str3));
            }
        }
    }
}
