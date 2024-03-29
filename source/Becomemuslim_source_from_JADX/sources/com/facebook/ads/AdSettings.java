package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;

public class AdSettings {
    public static final boolean DEBUG = false;
    /* renamed from: a */
    private static boolean f3653a;
    /* renamed from: b */
    private static TestAdType f3654b = TestAdType.DEFAULT;

    public enum TestAdType {
        DEFAULT(MessengerShareContentUtility.PREVIEW_DEFAULT, "Default"),
        IMG_16_9_APP_INSTALL("IMG_16_9_APP_INSTALL", "Image App install"),
        IMG_16_9_LINK("IMG_16_9_LINK", "Image link"),
        VIDEO_HD_16_9_46S_APP_INSTALL("VID_HD_16_9_46S_APP_INSTALL", "Video 46 sec App install"),
        VIDEO_HD_16_9_46S_LINK("VID_HD_16_9_46S_LINK", "Video 46 sec link"),
        VIDEO_HD_16_9_15S_APP_INSTALL("VID_HD_16_9_15S_APP_INSTALL", "Video 15 sec App install"),
        VIDEO_HD_16_9_15S_LINK("VID_HD_16_9_15S_LINK", "Video 15 sec link"),
        VIDEO_HD_9_16_39S_APP_INSTALL("VID_HD_9_16_39S_APP_INSTALL", "Video 39 sec App install"),
        VIDEO_HD_9_16_39S_LINK("VID_HD_9_16_39S_LINK", "Video 39 sec link"),
        CAROUSEL_IMG_SQUARE_APP_INSTALL("CAROUSEL_IMG_SQUARE_APP_INSTALL", "Carousel App install"),
        CAROUSEL_IMG_SQUARE_LINK("CAROUSEL_IMG_SQUARE_LINK", "Carousel link");
        
        /* renamed from: a */
        private final String f3651a;
        /* renamed from: b */
        private final String f3652b;

        private TestAdType(String str, String str2) {
            this.f3651a = str;
            this.f3652b = str2;
        }

        public String getAdTypeString() {
            return this.f3651a;
        }

        public String getHumanReadable() {
            return this.f3652b;
        }
    }

    public static void addTestDevice(String str) {
        AdInternalSettings.addTestDevice(str);
    }

    public static void addTestDevices(Collection<String> collection) {
        AdInternalSettings.addTestDevices(collection);
    }

    public static void clearTestDevices() {
        AdInternalSettings.clearTestDevices();
    }

    public static String getMediationService() {
        return AdInternalSettings.getMediationService();
    }

    public static TestAdType getTestAdType() {
        return f3654b;
    }

    public static String getUrlPrefix() {
        return AdInternalSettings.getUrlPrefix();
    }

    public static boolean isChildDirected() {
        return f3653a;
    }

    public static boolean isTestMode(Context context) {
        return AdInternalSettings.isTestMode(context);
    }

    public static boolean isVideoAutoplay() {
        return AdInternalSettings.isVideoAutoplay();
    }

    public static boolean isVideoAutoplayOnMobile() {
        return AdInternalSettings.isVideoAutoplayOnMobile();
    }

    public static void setDebugBuild(boolean z) {
        AdInternalSettings.setDebugBuild(z);
    }

    public static void setIsChildDirected(boolean z) {
        f3653a = z;
    }

    public static void setMediationService(String str) {
        AdInternalSettings.setMediationService(str);
    }

    public static void setTestAdType(TestAdType testAdType) {
        f3654b = testAdType;
    }

    public static void setUrlPrefix(String str) {
        AdInternalSettings.setUrlPrefix(str);
    }

    public static void setVideoAutoplay(boolean z) {
        AdInternalSettings.setVideoAutoplay(z);
    }

    public static void setVideoAutoplayOnMobile(boolean z) {
        AdInternalSettings.setVideoAutoplayOnMobile(z);
    }
}
