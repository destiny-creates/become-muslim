package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final String LAST_LOGGED_TIME_SEC = "LAST_LOGGED_TIME_SEC";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final int PURCHASE_EXPIRE_TIME_SEC = 43200;
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String PURCHASE_SUBS_STORE = "com.facebook.internal.PURCHASE_SUBS";
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final long SUBSCRIPTION_HARTBEAT_INTERVAL = 86400;
    private static final String TAG = InAppPurchaseEventManager.class.getCanonicalName();
    private static final HashMap<String, Class<?>> classMap = new HashMap();
    private static final HashMap<String, Method> methodMap = new HashMap();
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final SharedPreferences purchaseSubsSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_SUBS_STORE, 0);
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    InAppPurchaseEventManager() {
    }

    public static Object asInterface(Context context, IBinder iBinder) {
        return invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
    }

    public static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            String str = (String) arrayList.next();
            if (!readSkuDetailsFromCache.containsKey(str)) {
                arrayList2.add(str);
            }
        }
        readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
        return readSkuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> hashMap = new HashMap();
        if (obj != null) {
            if (!arrayList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
                Object[] objArr = new Object[4];
                int i = 0;
                objArr[0] = Integer.valueOf(3);
                objArr[1] = PACKAGE_NAME;
                objArr[2] = z ? SUBSCRIPTION : INAPP;
                objArr[3] = bundle;
                context = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
                if (context != null) {
                    Bundle bundle2 = (Bundle) context;
                    if (bundle2.getInt(RESPONSE_CODE) == null) {
                        context = bundle2.getStringArrayList(DETAILS_LIST);
                        if (context != null && arrayList.size() == context.size()) {
                            while (i < arrayList.size()) {
                                hashMap.put(arrayList.get(i), context.get(i));
                                i++;
                            }
                        }
                        writeSkuDetailsToCache(hashMap);
                    }
                }
                return hashMap;
            }
        }
        return hashMap;
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        Map<String, String> hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            String str = (String) arrayList.next();
            String string = skuDetailSharedPrefs.getString(str, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(str, split[1]);
                }
            }
        }
        return hashMap;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Editor edit = skuDetailSharedPrefs.edit();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str = (String) entry.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append(";");
            stringBuilder.append((String) entry.getValue());
            edit.putString(str, stringBuilder.toString());
        }
        edit.apply();
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        boolean z = false;
        if (obj == null) {
            return Boolean.valueOf(false);
        }
        context = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{Integer.valueOf(3), PACKAGE_NAME, str});
        if (context != null && ((Integer) context).intValue() == null) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        return filterPurchasesInapp(getPurchases(context, obj, INAPP));
    }

    public static ArrayList<String> getPurchasesSubsExpire(Context context, Object obj) {
        ArrayList<String> arrayList = new ArrayList();
        Map all = purchaseSubsSharedPrefs.getAll();
        if (all.isEmpty()) {
            return arrayList;
        }
        context = getPurchases(context, obj, SUBSCRIPTION);
        obj = new HashSet();
        context = context.iterator();
        while (context.hasNext()) {
            try {
                obj.add(new JSONObject((String) context.next()).getString("productId"));
            } catch (Throwable e) {
                Log.e(TAG, "Error parsing purchase json", e);
            }
        }
        Context<String> hashSet = new HashSet();
        for (Entry key : all.entrySet()) {
            String str = (String) key.getKey();
            if (!obj.contains(str)) {
                hashSet.add(str);
            }
        }
        obj = purchaseSubsSharedPrefs.edit();
        for (String str2 : hashSet) {
            str = purchaseSubsSharedPrefs.getString(str2, "");
            obj.remove(str2);
            if (!str.isEmpty()) {
                arrayList.add(purchaseSubsSharedPrefs.getString(str2, ""));
            }
        }
        obj.apply();
        return arrayList;
    }

    public static Map<String, SubscriptionType> getPurchasesSubs(Context context, Object obj) {
        Map<String, SubscriptionType> hashMap = new HashMap();
        context = getPurchases(context, obj, SUBSCRIPTION).iterator();
        while (context.hasNext() != null) {
            String str = (String) context.next();
            SubscriptionType subsType = getSubsType(str);
            if (!(subsType == SubscriptionType.DUPLICATED || subsType == SubscriptionType.UNKNOWN)) {
                hashMap.put(str, subsType);
            }
        }
        return hashMap;
    }

    private static SubscriptionType getSubsType(String str) {
        SubscriptionType subscriptionType = null;
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.getString("productId");
            String string = purchaseSubsSharedPrefs.getString(str, "");
            JSONObject jSONObject2 = string.isEmpty() ? new JSONObject() : new JSONObject(string);
            if (!jSONObject2.optString("purchaseToken").equals(jSONObject.get("purchaseToken"))) {
                subscriptionType = currentTimeMillis - (jSONObject.getLong("purchaseTime") / 1000) < 43200 ? SubscriptionType.NEW : SubscriptionType.HEARTBEAT;
            }
            if (subscriptionType == null && !string.isEmpty()) {
                boolean z = jSONObject2.getBoolean("autoRenewing");
                boolean z2 = jSONObject.getBoolean("autoRenewing");
                if (!z2 && z) {
                    subscriptionType = SubscriptionType.CANCEL;
                } else if (!z && z2) {
                    subscriptionType = SubscriptionType.RESTORE;
                }
            }
            if (subscriptionType == null && !string.isEmpty()) {
                if (currentTimeMillis - jSONObject2.getLong(LAST_LOGGED_TIME_SEC) > SUBSCRIPTION_HARTBEAT_INTERVAL) {
                    subscriptionType = SubscriptionType.HEARTBEAT;
                } else {
                    subscriptionType = SubscriptionType.DUPLICATED;
                }
            }
            if (subscriptionType != SubscriptionType.DUPLICATED) {
                jSONObject.put(LAST_LOGGED_TIME_SEC, currentTimeMillis);
                purchaseSubsSharedPrefs.edit().putString(str, jSONObject.toString()).apply();
            }
            return subscriptionType;
        } catch (String str2) {
            Log.e(TAG, "parsing purchase failure: ", str2);
            return SubscriptionType.UNKNOWN;
        }
    }

    private static ArrayList<String> getPurchases(Context context, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (obj != null && isBillingSupported(context, obj, str).booleanValue()) {
            String str2 = null;
            int i = 0;
            do {
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASES, obj, new Object[]{Integer.valueOf(3), PACKAGE_NAME, str, str2});
                if (invokeMethod != null) {
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        Collection stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                        if (stringArrayList == null) {
                            break;
                        }
                        i += stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        if (i >= 30) {
                            break;
                        }
                    }
                }
                str2 = null;
                if (i >= 30) {
                    break;
                }
                break;
            } while (str2 != null);
        }
        return arrayList;
    }

    public static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        ArrayList<String> arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        Class cls = getClass(context, IN_APP_BILLING_SERVICE);
        if (cls == null || getMethod(cls, GET_PURCHASE_HISTORY) == null) {
            return arrayList;
        }
        return filterPurchasesInapp(getPurchaseHistory(context, obj, INAPP));
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (isBillingSupported(context, obj, str).booleanValue()) {
            int i = 0;
            Boolean valueOf = Boolean.valueOf(false);
            Object obj2 = null;
            int i2 = 0;
            while (true) {
                Context context2 = context;
                obj2 = invokeMethod(context2, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{Integer.valueOf(6), PACKAGE_NAME, str, obj2, new Bundle()});
                if (obj2 != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) obj2;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        Boolean valueOf2;
                        Iterator it = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST).iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            try {
                                if (currentTimeMillis - (new JSONObject(str2).getLong("purchaseTime") / 1000) > 1200) {
                                    valueOf2 = Boolean.valueOf(true);
                                    break;
                                }
                                arrayList.add(str2);
                                i2++;
                            } catch (Throwable e) {
                                Log.e(TAG, "parsing purchase failure: ", e);
                            }
                        }
                        valueOf2 = valueOf;
                        valueOf = valueOf2;
                        obj2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        if (i2 >= 30 || r0 == null) {
                            break;
                        } else if (valueOf.booleanValue()) {
                            break;
                        } else {
                            i = 0;
                        }
                    }
                }
                obj2 = null;
                if (valueOf.booleanValue()) {
                    break;
                }
                i = 0;
            }
        }
        return arrayList;
    }

    private static ArrayList<String> filterPurchasesInapp(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        Editor edit = purchaseInappSharedPrefs.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            String str = (String) arrayList.next();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j / 1000) <= 43200) {
                    if (!purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                        edit.putString(string, string2);
                        arrayList2.add(str);
                    }
                }
            } catch (Throwable e) {
                Log.e(TAG, "parsing purchase failure: ", e);
            }
        }
        edit.apply();
        return arrayList2;
    }

    private static Method getMethod(Class<?> cls, String str) {
        Throwable th;
        String str2;
        StringBuilder stringBuilder;
        Method method = (Method) methodMap.get(str);
        if (method != null) {
            return method;
        }
        Class[] clsArr = null;
        Object obj = -1;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals(GET_PURCHASES)) {
                        obj = 3;
                        break;
                    }
                    break;
                case -1450694211:
                    if (str.equals(IS_BILLING_SUPPORTED)) {
                        obj = 2;
                        break;
                    }
                    break;
                case -1123215065:
                    if (str.equals(AS_INTERFACE)) {
                        obj = null;
                        break;
                    }
                    break;
                case -594356707:
                    if (str.equals(GET_PURCHASE_HISTORY)) {
                        obj = 4;
                        break;
                    }
                    break;
                case -573310373:
                    if (str.equals(GET_SKU_DETAILS)) {
                        obj = 1;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                    clsArr = new Class[]{IBinder.class};
                    break;
                case 1:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
                    break;
                case 2:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class};
                    break;
                case 3:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
                    break;
                case 4:
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
                    break;
                default:
                    break;
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            try {
                methodMap.put(str, declaredMethod);
                method = declaredMethod;
            } catch (Throwable e) {
                Method method2 = declaredMethod;
                th = e;
                method = method2;
                str2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append(cls.getName());
                stringBuilder.append(".");
                stringBuilder.append(str);
                stringBuilder.append(" method not found");
                Log.e(str2, stringBuilder.toString(), th);
                return method;
            }
        } catch (NoSuchMethodException e2) {
            th = e2;
            str2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append(cls.getName());
            stringBuilder.append(".");
            stringBuilder.append(str);
            stringBuilder.append(" method not found");
            Log.e(str2, stringBuilder.toString(), th);
            return method;
        }
        return method;
    }

    private static Class<?> getClass(Context context, String str) {
        String str2;
        StringBuilder stringBuilder;
        Class<?> cls = (Class) classMap.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            context = context.getClassLoader().loadClass(str);
            try {
                classMap.put(str, context);
            } catch (ClassNotFoundException e) {
                ClassNotFoundException classNotFoundException = e;
                cls = context;
                context = classNotFoundException;
                str2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" is not available, please add ");
                stringBuilder.append(str);
                stringBuilder.append(" to the project.");
                Log.e(str2, stringBuilder.toString(), context);
                context = cls;
                return context;
            }
        } catch (ClassNotFoundException e2) {
            context = e2;
            str2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" is not available, please add ");
            stringBuilder.append(str);
            stringBuilder.append(" to the project.");
            Log.e(str2, stringBuilder.toString(), context);
            context = cls;
            return context;
        }
        return context;
    }

    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        StringBuilder stringBuilder;
        context = getClass(context, str);
        if (context == null) {
            return null;
        }
        str2 = getMethod(context, str2);
        if (str2 == null) {
            return null;
        }
        if (obj != null) {
            obj = context.cast(obj);
        }
        try {
            return str2.invoke(obj, objArr);
        } catch (Object obj2) {
            objArr = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal access to method ");
            stringBuilder.append(context.getName());
            stringBuilder.append(".");
            stringBuilder.append(str2.getName());
            Log.e(objArr, stringBuilder.toString(), obj2);
            return null;
        } catch (Object obj22) {
            objArr = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invocation target exception in ");
            stringBuilder.append(context.getName());
            stringBuilder.append(".");
            stringBuilder.append(str2.getName());
            Log.e(objArr, stringBuilder.toString(), obj22);
            return null;
        }
    }

    public static void clearSkuDetailsCache() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = skuDetailSharedPrefs.getLong(LAST_CLEARED_TIME, 0);
        if (j == 0) {
            skuDetailSharedPrefs.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        } else if (currentTimeMillis - j > 604800) {
            skuDetailSharedPrefs.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        }
    }
}
