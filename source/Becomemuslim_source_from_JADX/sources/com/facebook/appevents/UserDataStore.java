package com.facebook.appevents;

import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final String LAST_NAME = "ln";
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    private static final String TAG = "UserDataStore";
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    private static String hashedUserData;
    private static volatile boolean initialized = false;
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /* renamed from: com.facebook.appevents.UserDataStore$1 */
    static class C17021 implements Runnable {
        C17021() {
        }

        public void run() {
            UserDataStore.initAndWait();
        }
    }

    public static void initStore() {
        if (!initialized) {
            AppEventsLogger.getAnalyticsExecutor().execute(new C17021());
        }
    }

    public static void setUserDataAndHash(final Bundle bundle) {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserData");
            initAndWait();
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                UserDataStore.lock.writeLock().lock();
                try {
                    UserDataStore.hashedUserData = UserDataStore.hashUserData(bundle);
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    edit.putString(UserDataStore.USER_DATA_KEY, UserDataStore.hashedUserData);
                    edit.apply();
                } finally {
                    UserDataStore.lock.writeLock().unlock();
                }
            }
        });
    }

    public static void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(EMAIL, str);
        }
        if (str2 != null) {
            bundle.putString(FIRST_NAME, str2);
        }
        if (str3 != null) {
            bundle.putString(LAST_NAME, str3);
        }
        if (str4 != null) {
            bundle.putString(PHONE, str4);
        }
        if (str5 != null) {
            bundle.putString(DATE_OF_BIRTH, str5);
        }
        if (str6 != null) {
            bundle.putString(GENDER, str6);
        }
        if (str7 != null) {
            bundle.putString(CITY, str7);
        }
        if (str8 != null) {
            bundle.putString(STATE, str8);
        }
        if (str9 != null) {
            bundle.putString(ZIP, str9);
        }
        if (str10 != null) {
            bundle.putString(COUNTRY, str10);
        }
        setUserDataAndHash(bundle);
    }

    public static String getHashedUserData() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        lock.readLock().lock();
        try {
            String str = hashedUserData;
            return str;
        } finally {
            lock.readLock().unlock();
        }
    }

    private static void initAndWait() {
        if (!initialized) {
            lock.writeLock().lock();
            try {
                if (!initialized) {
                    hashedUserData = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(USER_DATA_KEY, null);
                    initialized = true;
                    lock.writeLock().unlock();
                }
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    private static java.lang.String hashUserData(android.os.Bundle r5) {
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
        if (r5 != 0) goto L_0x0004;
    L_0x0002:
        r5 = 0;
        return r5;
    L_0x0004:
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = r5.keySet();
        r1 = r1.iterator();
    L_0x0011:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0049;
    L_0x0017:
        r2 = r1.next();
        r2 = (java.lang.String) r2;
        r3 = r5.get(r2);	 Catch:{ JSONException -> 0x0011 }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x0011 }
        r4 = maybeSHA256Hashed(r3);	 Catch:{ JSONException -> 0x0011 }
        if (r4 == 0) goto L_0x0033;	 Catch:{ JSONException -> 0x0011 }
    L_0x002b:
        r3 = r3.toLowerCase();	 Catch:{ JSONException -> 0x0011 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0011 }
        goto L_0x0011;	 Catch:{ JSONException -> 0x0011 }
    L_0x0033:
        r3 = r5.get(r2);	 Catch:{ JSONException -> 0x0011 }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x0011 }
        r3 = normalizeData(r2, r3);	 Catch:{ JSONException -> 0x0011 }
        r3 = encryptData(r3);	 Catch:{ JSONException -> 0x0011 }
        if (r3 == 0) goto L_0x0011;	 Catch:{ JSONException -> 0x0011 }
    L_0x0045:
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0011 }
        goto L_0x0011;
    L_0x0049:
        r5 = r0.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.UserDataStore.hashUserData(android.os.Bundle):java.lang.String");
    }

    private static java.lang.String encryptData(java.lang.String r2) {
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
        r0 = 0;
        if (r2 == 0) goto L_0x0021;
    L_0x0003:
        r1 = r2.isEmpty();
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0021;
    L_0x000a:
        r1 = "SHA-256";	 Catch:{ NoSuchAlgorithmException -> 0x0020 }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0020 }
        r2 = r2.getBytes();
        r1.update(r2);
        r2 = r1.digest();
        r2 = com.facebook.appevents.internal.AppEventUtility.bytesToHex(r2);
        return r2;
    L_0x0020:
        return r0;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.UserDataStore.encryptData(java.lang.String):java.lang.String");
    }

    private static String normalizeData(String str, String str2) {
        String str3 = "";
        int hashCode = str.hashCode();
        if (hashCode != 3185) {
            if (hashCode != 3240) {
                if (hashCode != 3272) {
                    if (hashCode != 3294) {
                        if (hashCode != 3458) {
                            if (hashCode != 3576) {
                                if (hashCode != 3681) {
                                    if (hashCode == 957831062) {
                                        if (str.equals(COUNTRY) != null) {
                                            str = 5;
                                            switch (str) {
                                                case null:
                                                case 1:
                                                case 2:
                                                case 3:
                                                case 4:
                                                case 5:
                                                    return str2.trim().toLowerCase();
                                                case 6:
                                                    return str2.trim().replaceAll("[^0-9]", "");
                                                case 7:
                                                    str = str2.trim().toLowerCase();
                                                    return str.length() > null ? str.substring(0, 1) : "";
                                                default:
                                                    return str3;
                                            }
                                        }
                                    }
                                } else if (str.equals(STATE) != null) {
                                    str = 4;
                                    switch (str) {
                                        case null:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                            return str2.trim().toLowerCase();
                                        case 6:
                                            return str2.trim().replaceAll("[^0-9]", "");
                                        case 7:
                                            str = str2.trim().toLowerCase();
                                            if (str.length() > null) {
                                            }
                                            return str.length() > null ? str.substring(0, 1) : "";
                                        default:
                                            return str3;
                                    }
                                }
                            } else if (str.equals(PHONE) != null) {
                                str = 6;
                                switch (str) {
                                    case null:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                        return str2.trim().toLowerCase();
                                    case 6:
                                        return str2.trim().replaceAll("[^0-9]", "");
                                    case 7:
                                        str = str2.trim().toLowerCase();
                                        if (str.length() > null) {
                                        }
                                        return str.length() > null ? str.substring(0, 1) : "";
                                    default:
                                        return str3;
                                }
                            }
                        } else if (str.equals(LAST_NAME) != null) {
                            str = 2;
                            switch (str) {
                                case null:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    return str2.trim().toLowerCase();
                                case 6:
                                    return str2.trim().replaceAll("[^0-9]", "");
                                case 7:
                                    str = str2.trim().toLowerCase();
                                    if (str.length() > null) {
                                    }
                                    return str.length() > null ? str.substring(0, 1) : "";
                                default:
                                    return str3;
                            }
                        }
                    } else if (str.equals(GENDER) != null) {
                        str = 7;
                        switch (str) {
                            case null:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                return str2.trim().toLowerCase();
                            case 6:
                                return str2.trim().replaceAll("[^0-9]", "");
                            case 7:
                                str = str2.trim().toLowerCase();
                                if (str.length() > null) {
                                }
                                return str.length() > null ? str.substring(0, 1) : "";
                            default:
                                return str3;
                        }
                    }
                } else if (str.equals(FIRST_NAME) != null) {
                    str = true;
                    switch (str) {
                        case null:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            return str2.trim().toLowerCase();
                        case 6:
                            return str2.trim().replaceAll("[^0-9]", "");
                        case 7:
                            str = str2.trim().toLowerCase();
                            if (str.length() > null) {
                            }
                            return str.length() > null ? str.substring(0, 1) : "";
                        default:
                            return str3;
                    }
                }
            } else if (str.equals(EMAIL) != null) {
                str = null;
                switch (str) {
                    case null:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return str2.trim().toLowerCase();
                    case 6:
                        return str2.trim().replaceAll("[^0-9]", "");
                    case 7:
                        str = str2.trim().toLowerCase();
                        if (str.length() > null) {
                        }
                        return str.length() > null ? str.substring(0, 1) : "";
                    default:
                        return str3;
                }
            }
        } else if (str.equals(CITY) != null) {
            str = 3;
            switch (str) {
                case null:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return str2.trim().toLowerCase();
                case 6:
                    return str2.trim().replaceAll("[^0-9]", "");
                case 7:
                    str = str2.trim().toLowerCase();
                    if (str.length() > null) {
                    }
                    return str.length() > null ? str.substring(0, 1) : "";
                default:
                    return str3;
            }
        }
        str = -1;
        switch (str) {
            case null:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return str2.trim().toLowerCase();
            case 6:
                return str2.trim().replaceAll("[^0-9]", "");
            case 7:
                str = str2.trim().toLowerCase();
                if (str.length() > null) {
                }
                return str.length() > null ? str.substring(0, 1) : "";
            default:
                return str3;
        }
    }

    private static boolean maybeSHA256Hashed(String str) {
        return str.matches("[A-Fa-f0-9]{64}");
    }
}
