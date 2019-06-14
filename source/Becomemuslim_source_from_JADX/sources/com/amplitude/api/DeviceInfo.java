package com.amplitude.api;

import android.content.ContentResolver;
import android.content.Context;
import android.location.Geocoder;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.util.Locale;
import java.util.UUID;

public class DeviceInfo {
    public static final String OS_NAME = "android";
    private static final String SETTING_ADVERTISING_ID = "advertising_id";
    private static final String SETTING_LIMIT_AD_TRACKING = "limit_ad_tracking";
    public static final String TAG = "com.amplitude.api.DeviceInfo";
    private CachedInfo cachedInfo;
    private Context context;
    private boolean locationListening = true;

    private class CachedInfo {
        private String advertisingId;
        private String brand;
        private String carrier;
        private String country;
        private boolean gpsEnabled;
        private String language;
        private boolean limitAdTrackingEnabled;
        private String manufacturer;
        private String model;
        private String osName;
        private String osVersion;
        private String versionName;

        private String getOsName() {
            return "android";
        }

        private CachedInfo() {
            this.advertisingId = getAdvertisingId();
            this.versionName = getVersionName();
            this.osName = getOsName();
            this.osVersion = getOsVersion();
            this.brand = getBrand();
            this.manufacturer = getManufacturer();
            this.model = getModel();
            this.carrier = getCarrier();
            this.country = getCountry();
            this.language = getLanguage();
            this.gpsEnabled = checkGPSEnabled();
        }

        private java.lang.String getVersionName() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r3 = this;
            r0 = com.amplitude.api.DeviceInfo.this;	 Catch:{ NameNotFoundException -> 0x001c }
            r0 = r0.context;	 Catch:{ NameNotFoundException -> 0x001c }
            r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001c }
            r1 = com.amplitude.api.DeviceInfo.this;	 Catch:{ NameNotFoundException -> 0x001c }
            r1 = r1.context;	 Catch:{ NameNotFoundException -> 0x001c }
            r1 = r1.getPackageName();	 Catch:{ NameNotFoundException -> 0x001c }
            r2 = 0;	 Catch:{ NameNotFoundException -> 0x001c }
            r0 = r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x001c }
            r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x001c }
            return r0;
        L_0x001c:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DeviceInfo.CachedInfo.getVersionName():java.lang.String");
        }

        private String getOsVersion() {
            return VERSION.RELEASE;
        }

        private String getBrand() {
            return Build.BRAND;
        }

        private String getManufacturer() {
            return Build.MANUFACTURER;
        }

        private String getModel() {
            return Build.MODEL;
        }

        private java.lang.String getCarrier() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = com.amplitude.api.DeviceInfo.this;	 Catch:{ Exception -> 0x0013 }
            r0 = r0.context;	 Catch:{ Exception -> 0x0013 }
            r1 = "phone";	 Catch:{ Exception -> 0x0013 }
            r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x0013 }
            r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x0013 }
            r0 = r0.getNetworkOperatorName();	 Catch:{ Exception -> 0x0013 }
            return r0;
        L_0x0013:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DeviceInfo.CachedInfo.getCarrier():java.lang.String");
        }

        private String getCountry() {
            Object countryFromLocation = getCountryFromLocation();
            if (!TextUtils.isEmpty(countryFromLocation)) {
                return countryFromLocation;
            }
            countryFromLocation = getCountryFromNetwork();
            if (TextUtils.isEmpty(countryFromLocation)) {
                return getCountryFromLocale();
            }
            return countryFromLocation;
        }

        private java.lang.String getCountryFromLocation() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r9 = this;
            r0 = com.amplitude.api.DeviceInfo.this;
            r0 = r0.isLocationListening();
            r1 = 0;
            if (r0 != 0) goto L_0x000a;
        L_0x0009:
            return r1;
        L_0x000a:
            r0 = com.amplitude.api.DeviceInfo.this;
            r0 = r0.getMostRecentLocation();
            if (r0 == 0) goto L_0x0044;
        L_0x0012:
            r2 = android.location.Geocoder.isPresent();	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            if (r2 == 0) goto L_0x0044;	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
        L_0x0018:
            r2 = com.amplitude.api.DeviceInfo.this;	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            r3 = r2.getGeocoder();	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            r4 = r0.getLatitude();	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            r6 = r0.getLongitude();	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            r8 = 1;	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            r0 = r3.getFromLocation(r4, r6, r8);	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            if (r0 == 0) goto L_0x0044;	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
        L_0x002d:
            r0 = r0.iterator();	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
        L_0x0031:
            r2 = r0.hasNext();	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            if (r2 == 0) goto L_0x0044;	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
        L_0x0037:
            r2 = r0.next();	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            r2 = (android.location.Address) r2;	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            if (r2 == 0) goto L_0x0031;	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
        L_0x003f:
            r0 = r2.getCountryCode();	 Catch:{ IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044, IOException -> 0x0044 }
            return r0;
        L_0x0044:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DeviceInfo.CachedInfo.getCountryFromLocation():java.lang.String");
        }

        private java.lang.String getCountryFromNetwork() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r3 = this;
            r0 = com.amplitude.api.DeviceInfo.this;	 Catch:{ Exception -> 0x0022 }
            r0 = r0.context;	 Catch:{ Exception -> 0x0022 }
            r1 = "phone";	 Catch:{ Exception -> 0x0022 }
            r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x0022 }
            r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x0022 }
            r1 = r0.getPhoneType();	 Catch:{ Exception -> 0x0022 }
            r2 = 2;	 Catch:{ Exception -> 0x0022 }
            if (r1 == r2) goto L_0x0022;	 Catch:{ Exception -> 0x0022 }
        L_0x0015:
            r0 = r0.getNetworkCountryIso();	 Catch:{ Exception -> 0x0022 }
            if (r0 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x0022 }
        L_0x001b:
            r1 = java.util.Locale.US;	 Catch:{ Exception -> 0x0022 }
            r0 = r0.toUpperCase(r1);	 Catch:{ Exception -> 0x0022 }
            return r0;
        L_0x0022:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DeviceInfo.CachedInfo.getCountryFromNetwork():java.lang.String");
        }

        private String getCountryFromLocale() {
            return Locale.getDefault().getCountry();
        }

        private String getLanguage() {
            return Locale.getDefault().getLanguage();
        }

        private String getAdvertisingId() {
            if ("Amazon".equals(getManufacturer())) {
                return getAndCacheAmazonAdvertisingId();
            }
            return getAndCacheGoogleAdvertisingId();
        }

        private String getAndCacheAmazonAdvertisingId() {
            ContentResolver contentResolver = DeviceInfo.this.context.getContentResolver();
            boolean z = false;
            if (Secure.getInt(contentResolver, DeviceInfo.SETTING_LIMIT_AD_TRACKING, 0) == 1) {
                z = true;
            }
            this.limitAdTrackingEnabled = z;
            this.advertisingId = Secure.getString(contentResolver, DeviceInfo.SETTING_ADVERTISING_ID);
            return this.advertisingId;
        }

        private java.lang.String getAndCacheGoogleAdvertisingId() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r6 = this;
            r0 = "com.google.android.gms.ads.identifier.AdvertisingIdClient";	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r1 = "getAdvertisingIdInfo";	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r2 = 1;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r4 = android.content.Context.class;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r5 = 0;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r3[r5] = r4;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r0 = r0.getMethod(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r1 = 0;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r3 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r4 = com.amplitude.api.DeviceInfo.this;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r4 = r4.context;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r3[r5] = r4;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r0 = r0.invoke(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r1 = r0.getClass();	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r3 = "isLimitAdTrackingEnabled";	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r4 = new java.lang.Class[r5];	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r1 = r1.getMethod(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r3 = new java.lang.Object[r5];	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r1 = r1.invoke(r0, r3);	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r1 = (java.lang.Boolean) r1;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            if (r1 == 0) goto L_0x0040;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
        L_0x0039:
            r1 = r1.booleanValue();	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            if (r1 == 0) goto L_0x0040;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
        L_0x003f:
            goto L_0x0041;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
        L_0x0040:
            r2 = 0;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
        L_0x0041:
            r6.limitAdTrackingEnabled = r2;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r1 = r0.getClass();	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r2 = "getId";	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r3 = new java.lang.Class[r5];	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r1 = r1.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r2 = new java.lang.Object[r5];	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r0 = r1.invoke(r0, r2);	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r0 = (java.lang.String) r0;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            r6.advertisingId = r0;	 Catch:{ ClassNotFoundException -> 0x0073, InvocationTargetException -> 0x0067, Exception -> 0x005a }
            goto L_0x007e;
        L_0x005a:
            r0 = move-exception;
            r1 = com.amplitude.api.AmplitudeLog.getLogger();
            r2 = "com.amplitude.api.DeviceInfo";
            r3 = "Encountered an error connecting to Google Play Services";
            r1.m3416e(r2, r3, r0);
            goto L_0x007e;
        L_0x0067:
            r0 = com.amplitude.api.AmplitudeLog.getLogger();
            r1 = "com.amplitude.api.DeviceInfo";
            r2 = "Google Play Services not available";
            r0.m3421w(r1, r2);
            goto L_0x007e;
        L_0x0073:
            r0 = com.amplitude.api.AmplitudeLog.getLogger();
            r1 = "com.amplitude.api.DeviceInfo";
            r2 = "Google Play Services SDK not found!";
            r0.m3421w(r1, r2);
        L_0x007e:
            r0 = r6.advertisingId;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DeviceInfo.CachedInfo.getAndCacheGoogleAdvertisingId():java.lang.String");
        }

        private boolean checkGPSEnabled() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r6 = this;
            r0 = 0;
            r1 = "com.google.android.gms.common.GooglePlayServicesUtil";	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r1 = java.lang.Class.forName(r1);	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r2 = "isGooglePlayServicesAvailable";	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r3 = 1;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r4 = new java.lang.Class[r3];	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r5 = android.content.Context.class;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r4[r0] = r5;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r1 = r1.getMethod(r2, r4);	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r2 = 0;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r4 = new java.lang.Object[r3];	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r5 = com.amplitude.api.DeviceInfo.this;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r5 = r5.context;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r4[r0] = r5;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r1 = r1.invoke(r2, r4);	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            r1 = (java.lang.Integer) r1;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            if (r1 == 0) goto L_0x002e;	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
        L_0x0027:
            r1 = r1.intValue();	 Catch:{ NoClassDefFoundError -> 0x007b, ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0063, InvocationTargetException -> 0x0057, IllegalAccessException -> 0x004b, Exception -> 0x002f }
            if (r1 != 0) goto L_0x002e;
        L_0x002d:
            r0 = 1;
        L_0x002e:
            return r0;
        L_0x002f:
            r1 = move-exception;
            r2 = com.amplitude.api.AmplitudeLog.getLogger();
            r3 = "com.amplitude.api.DeviceInfo";
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r5 = "Error when checking for Google Play Services: ";
            r4.append(r5);
            r4.append(r1);
            r1 = r4.toString();
            r2.m3421w(r3, r1);
            goto L_0x0086;
        L_0x004b:
            r1 = com.amplitude.api.AmplitudeLog.getLogger();
            r2 = "com.amplitude.api.DeviceInfo";
            r3 = "Google Play Services not available";
            r1.m3421w(r2, r3);
            goto L_0x0086;
        L_0x0057:
            r1 = com.amplitude.api.AmplitudeLog.getLogger();
            r2 = "com.amplitude.api.DeviceInfo";
            r3 = "Google Play Services not available";
            r1.m3421w(r2, r3);
            goto L_0x0086;
        L_0x0063:
            r1 = com.amplitude.api.AmplitudeLog.getLogger();
            r2 = "com.amplitude.api.DeviceInfo";
            r3 = "Google Play Services not available";
            r1.m3421w(r2, r3);
            goto L_0x0086;
        L_0x006f:
            r1 = com.amplitude.api.AmplitudeLog.getLogger();
            r2 = "com.amplitude.api.DeviceInfo";
            r3 = "Google Play Services Util not found!";
            r1.m3421w(r2, r3);
            goto L_0x0086;
        L_0x007b:
            r1 = com.amplitude.api.AmplitudeLog.getLogger();
            r2 = "com.amplitude.api.DeviceInfo";
            r3 = "Google Play Services Util not found!";
            r1.m3421w(r2, r3);
        L_0x0086:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DeviceInfo.CachedInfo.checkGPSEnabled():boolean");
        }
    }

    public DeviceInfo(Context context) {
        this.context = context;
    }

    private CachedInfo getCachedInfo() {
        if (this.cachedInfo == null) {
            this.cachedInfo = new CachedInfo();
        }
        return this.cachedInfo;
    }

    public void prefetch() {
        getCachedInfo();
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public String getVersionName() {
        return getCachedInfo().versionName;
    }

    public String getOsName() {
        return getCachedInfo().osName;
    }

    public String getOsVersion() {
        return getCachedInfo().osVersion;
    }

    public String getBrand() {
        return getCachedInfo().brand;
    }

    public String getManufacturer() {
        return getCachedInfo().manufacturer;
    }

    public String getModel() {
        return getCachedInfo().model;
    }

    public String getCarrier() {
        return getCachedInfo().carrier;
    }

    public String getCountry() {
        return getCachedInfo().country;
    }

    public String getLanguage() {
        return getCachedInfo().language;
    }

    public String getAdvertisingId() {
        return getCachedInfo().advertisingId;
    }

    public boolean isLimitAdTrackingEnabled() {
        return getCachedInfo().limitAdTrackingEnabled;
    }

    public boolean isGooglePlayServicesEnabled() {
        return getCachedInfo().gpsEnabled;
    }

    public android.location.Location getMostRecentLocation() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r8 = this;
        r0 = r8.isLocationListening();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r8.context;
        r2 = "location";
        r0 = r0.getSystemService(r2);
        r0 = (android.location.LocationManager) r0;
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r1;
    L_0x0015:
        r2 = 1;
        r2 = r0.getProviders(r2);	 Catch:{ SecurityException -> 0x001b }
        goto L_0x001c;
    L_0x001b:
        r2 = r1;
    L_0x001c:
        if (r2 != 0) goto L_0x001f;
    L_0x001e:
        return r1;
    L_0x001f:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2 = r2.iterator();
    L_0x0028:
        r4 = r2.hasNext();
        if (r4 == 0) goto L_0x0040;
    L_0x002e:
        r4 = r2.next();
        r4 = (java.lang.String) r4;
        r4 = r0.getLastKnownLocation(r4);	 Catch:{ IllegalArgumentException -> 0x0039, IllegalArgumentException -> 0x0039 }
        goto L_0x003a;
    L_0x0039:
        r4 = r1;
    L_0x003a:
        if (r4 == 0) goto L_0x0028;
    L_0x003c:
        r3.add(r4);
        goto L_0x0028;
    L_0x0040:
        r4 = -1;
        r0 = r3.iterator();
    L_0x0046:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0061;
    L_0x004c:
        r2 = r0.next();
        r2 = (android.location.Location) r2;
        r6 = r2.getTime();
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x0046;
    L_0x005a:
        r3 = r2.getTime();
        r1 = r2;
        r4 = r3;
        goto L_0x0046;
    L_0x0061:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DeviceInfo.getMostRecentLocation():android.location.Location");
    }

    public boolean isLocationListening() {
        return this.locationListening;
    }

    public void setLocationListening(boolean z) {
        this.locationListening = z;
    }

    protected Geocoder getGeocoder() {
        return new Geocoder(this.context, Locale.ENGLISH);
    }
}
