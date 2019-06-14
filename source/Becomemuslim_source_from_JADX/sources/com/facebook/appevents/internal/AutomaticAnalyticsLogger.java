package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Validate;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONObject;

public class AutomaticAnalyticsLogger {
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    private static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    private static class PurchaseLoggingParameters {
        Currency currency;
        Bundle param;
        BigDecimal purchaseAmount;

        PurchaseLoggingParameters(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            this.purchaseAmount = bigDecimal;
            this.currency = currency;
            this.param = bundle;
        }
    }

    public static void logActivateAppEvent() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        boolean autoLogAppEventsEnabled = FacebookSdk.getAutoLogAppEventsEnabled();
        Validate.notNull(applicationContext, "context");
        if (!autoLogAppEventsEnabled) {
            return;
        }
        if (applicationContext instanceof Application) {
            AppEventsLogger.activateApp((Application) applicationContext, applicationId);
        } else {
            Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
        }
    }

    public static void logActivityTimeSpentEvent(String str, long j) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        Validate.notNull(applicationContext, "context");
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        if (queryAppSettings != null && queryAppSettings.getAutomaticLoggingEnabled() && j > 0) {
            AppEventsLogger newLogger = AppEventsLogger.newLogger(applicationContext);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
            newLogger.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, (double) j, bundle);
        }
    }

    public static void logPurchaseInapp(String str, String str2) {
        if (isImplicitPurchaseLoggingEnabled()) {
            str = getPurchaseLoggingParameters(str, str2);
            if (str != null) {
                internalAppEventsLogger.logPurchaseImplicitlyInternal(str.purchaseAmount, str.currency, str.param);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void logPurchaseSubs(com.facebook.appevents.internal.SubscriptionType r2, java.lang.String r3, java.lang.String r4) {
        /*
        r0 = isImplicitPurchaseLoggingEnabled();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        com.facebook.FacebookSdk.getApplicationId();
        r0 = com.facebook.appevents.internal.AutomaticAnalyticsLogger.C17181.$SwitchMap$com$facebook$appevents$internal$SubscriptionType;
        r2 = r2.ordinal();
        r2 = r0[r2];
        switch(r2) {
            case 1: goto L_0x0023;
            case 2: goto L_0x0020;
            case 3: goto L_0x001d;
            case 4: goto L_0x001a;
            case 5: goto L_0x0016;
            default: goto L_0x0015;
        };
    L_0x0015:
        goto L_0x0037;
    L_0x0016:
        logPurchaseInapp(r3, r4);
        goto L_0x0037;
    L_0x001a:
        r2 = "SubscriptionExpire";
        goto L_0x0025;
    L_0x001d:
        r2 = "SubscriptionHeartbeat";
        goto L_0x0025;
    L_0x0020:
        r2 = "SubscriptionCancel";
        goto L_0x0025;
    L_0x0023:
        r2 = "SubscriptionRestore";
    L_0x0025:
        r3 = getPurchaseLoggingParameters(r3, r4);
        if (r3 == 0) goto L_0x0036;
    L_0x002b:
        r4 = internalAppEventsLogger;
        r0 = r3.purchaseAmount;
        r1 = r3.currency;
        r3 = r3.param;
        r4.logEventImplicitly(r2, r0, r1, r3);
    L_0x0036:
        return;
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AutomaticAnalyticsLogger.logPurchaseSubs(com.facebook.appevents.internal.SubscriptionType, java.lang.String, java.lang.String):void");
    }

    public static boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled();
    }

    private static PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = new JSONObject(str2);
            str2 = new Bundle(1);
            str2.putCharSequence(Constants.IAP_PRODUCT_ID, jSONObject.getString("productId"));
            str2.putCharSequence(Constants.IAP_PURCHASE_TIME, jSONObject.getString("purchaseTime"));
            str2.putCharSequence(Constants.IAP_PURCHASE_TOKEN, jSONObject.getString("purchaseToken"));
            str2.putCharSequence(Constants.IAP_PACKAGE_NAME, jSONObject.optString("packageName"));
            str2.putCharSequence(Constants.IAP_PRODUCT_TITLE, str.optString("title"));
            str2.putCharSequence(Constants.IAP_PRODUCT_DESCRIPTION, str.optString("description"));
            Object optString = str.optString("type");
            str2.putCharSequence(Constants.IAP_PRODUCT_TYPE, optString);
            if (optString.equals("subs")) {
                str2.putCharSequence(Constants.IAP_SUBSCRIPTION_AUTORENEWING, Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                str2.putCharSequence(Constants.IAP_SUBSCRIPTION_PERIOD, str.optString("subscriptionPeriod"));
                str2.putCharSequence(Constants.IAP_FREE_TRIAL_PERIOD, str.optString("freeTrialPeriod"));
                CharSequence optString2 = str.optString("introductoryPriceCycles");
                if (!optString2.isEmpty()) {
                    str2.putCharSequence(Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, str.optString("introductoryPriceAmountMicros"));
                    str2.putCharSequence(Constants.IAP_INTRO_PRICE_CYCLES, optString2);
                }
            }
            return new PurchaseLoggingParameters(new BigDecimal(((double) str.getLong("price_amount_micros")) / 1000000.0d), Currency.getInstance(str.getString("price_currency_code")), str2);
        } catch (String str3) {
            Log.e(TAG, "Error parsing in-app subscription data.", str3);
            return null;
        }
    }
}
