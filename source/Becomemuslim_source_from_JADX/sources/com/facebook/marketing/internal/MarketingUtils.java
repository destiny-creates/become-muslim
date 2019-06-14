package com.facebook.marketing.internal;

import android.os.Build;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.text.NumberFormat;
import java.util.Locale;

public class MarketingUtils {
    private static final String TAG = MarketingUtils.class.getCanonicalName();

    public static boolean isEmulator() {
        if (!(Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)))) {
            if (!"google_sdk".equals(Build.PRODUCT)) {
                return false;
            }
        }
        return true;
    }

    public static double normalizePrice(String str) {
        try {
            return NumberFormat.getNumberInstance(Locale.getDefault()).parse(str.replaceAll("[^\\d,.+-]", "")).doubleValue();
        } catch (String str2) {
            Log.e(TAG, "Error parsing price: ", str2);
            return 0.0d;
        }
    }
}
