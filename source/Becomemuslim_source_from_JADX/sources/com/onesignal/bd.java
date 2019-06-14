package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.am.C5464i;
import com.onesignal.ar.C5480a;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TrackGooglePurchase */
class bd {
    /* renamed from: a */
    private static int f18484a = -99;
    /* renamed from: c */
    private static Class<?> f18485c;
    /* renamed from: b */
    private ServiceConnection f18486b;
    /* renamed from: d */
    private Object f18487d;
    /* renamed from: e */
    private Method f18488e;
    /* renamed from: f */
    private Method f18489f;
    /* renamed from: g */
    private Context f18490g;
    /* renamed from: h */
    private ArrayList<String> f18491h;
    /* renamed from: i */
    private boolean f18492i = true;
    /* renamed from: j */
    private boolean f18493j;

    /* compiled from: TrackGooglePurchase */
    /* renamed from: com.onesignal.bd$1 */
    class C54901 implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ bd f18482a;

        C54901(bd bdVar) {
            this.f18482a = bdVar;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            bd.f18484a = -99;
            this.f18482a.f18487d = null;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                componentName = bd.m23368c(Class.forName("com.android.vending.billing.IInAppBillingService$Stub"));
                componentName.setAccessible(true);
                this.f18482a.f18487d = componentName.invoke(null, new Object[]{iBinder});
                this.f18482a.m23369c();
            } catch (ComponentName componentName2) {
                componentName2.printStackTrace();
            }
        }
    }

    /* compiled from: TrackGooglePurchase */
    /* renamed from: com.onesignal.bd$2 */
    class C54912 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ bd f18483a;

        C54912(bd bdVar) {
            this.f18483a = bdVar;
        }

        public void run() {
            this.f18483a.f18493j = true;
            try {
                if (this.f18483a.f18488e == null) {
                    this.f18483a.f18488e = bd.m23371d(bd.f18485c);
                    this.f18483a.f18488e.setAccessible(true);
                }
                Bundle bundle = (Bundle) this.f18483a.f18488e.invoke(this.f18483a.f18487d, new Object[]{Integer.valueOf(3), this.f18483a.f18490g.getPackageName(), "inapp", null});
                if (bundle.getInt("RESPONSE_CODE") == 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    for (int i = 0; i < stringArrayList2.size(); i++) {
                        String str = (String) stringArrayList.get(i);
                        String string = new JSONObject((String) stringArrayList2.get(i)).getString("purchaseToken");
                        if (!(this.f18483a.f18491h.contains(string) || arrayList2.contains(string))) {
                            arrayList2.add(string);
                            arrayList.add(str);
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.f18483a.m23360a(arrayList, arrayList2);
                    } else if (stringArrayList2.size() == 0) {
                        this.f18483a.f18492i = false;
                        aq.m23280a("GTPlayerPurchases", "ExistingPurchases", false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f18483a.f18493j = false;
        }
    }

    bd(Context context) {
        boolean z = false;
        this.f18493j = false;
        this.f18490g = context;
        this.f18491h = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(aq.m23283b("GTPlayerPurchases", "purchaseTokens", "[]"));
            for (context = null; context < jSONArray.length(); context++) {
                this.f18491h.add(jSONArray.get(context).toString());
            }
            if (jSONArray.length() == null) {
                z = true;
            }
            this.f18492i = z;
            if (this.f18492i != null) {
                this.f18492i = aq.m23285b("GTPlayerPurchases", "ExistingPurchases", true);
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        m23374a();
    }

    /* renamed from: a */
    static boolean m23361a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = f18484a;
        r1 = -99;
        if (r0 != r1) goto L_0x000e;
    L_0x0006:
        r0 = "com.android.vending.BILLING";
        r2 = r2.checkCallingOrSelfPermission(r0);
        f18484a = r2;
    L_0x000e:
        r2 = 0;
        r0 = f18484a;	 Catch:{ Throwable -> 0x0021 }
        if (r0 != 0) goto L_0x001b;	 Catch:{ Throwable -> 0x0021 }
    L_0x0013:
        r0 = "com.android.vending.billing.IInAppBillingService";	 Catch:{ Throwable -> 0x0021 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0021 }
        f18485c = r0;	 Catch:{ Throwable -> 0x0021 }
    L_0x001b:
        r0 = f18484a;
        if (r0 != 0) goto L_0x0020;
    L_0x001f:
        r2 = 1;
    L_0x0020:
        return r2;
    L_0x0021:
        f18484a = r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.bd.a(android.content.Context):boolean");
    }

    /* renamed from: a */
    void m23374a() {
        if (this.f18486b == null) {
            this.f18486b = new C54901(this);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this.f18490g.bindService(intent, this.f18486b, 1);
        } else if (this.f18487d != null) {
            m23369c();
        }
    }

    /* renamed from: c */
    private void m23369c() {
        if (!this.f18493j) {
            new Thread(new C54912(this)).start();
        }
    }

    /* renamed from: a */
    private void m23360a(ArrayList<String> arrayList, final ArrayList<String> arrayList2) {
        try {
            if (this.f18489f == null) {
                this.f18489f = m23372e(f18485c);
                this.f18489f.setAccessible(true);
            }
            new Bundle().putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle bundle = (Bundle) this.f18489f.invoke(this.f18487d, new Object[]{Integer.valueOf(3), this.f18490g.getPackageName(), "inapp", bundle});
            if (bundle.getInt("RESPONSE_CODE") == 0) {
                String string;
                ArrayList stringArrayList = bundle.getStringArrayList("DETAILS_LIST");
                Map hashMap = new HashMap();
                Iterator it = stringArrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject((String) it.next());
                    string = jSONObject.getString("productId");
                    BigDecimal divide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sku", string);
                    jSONObject2.put("iso", jSONObject.getString("price_currency_code"));
                    jSONObject2.put("amount", divide.toString());
                    hashMap.put(string, jSONObject2);
                }
                JSONArray jSONArray = new JSONArray();
                arrayList = arrayList.iterator();
                while (arrayList.hasNext()) {
                    string = (String) arrayList.next();
                    if (hashMap.containsKey(string)) {
                        jSONArray.put(hashMap.get(string));
                    }
                }
                if (jSONArray.length() > null) {
                    am.m23170a(jSONArray, this.f18492i, new C5480a(this) {
                        /* renamed from: b */
                        final /* synthetic */ bd f24824b;

                        /* renamed from: a */
                        public void mo4940a(String str) {
                            this.f24824b.f18491h.addAll(arrayList2);
                            aq.m23279a("GTPlayerPurchases", "purchaseTokens", this.f24824b.f18491h.toString());
                            aq.m23280a("GTPlayerPurchases", "ExistingPurchases", true);
                            this.f24824b.f18492i = false;
                            this.f24824b.f18493j = false;
                        }
                    });
                }
            }
        } catch (Throwable th) {
            am.m23161a(C5464i.WARN, "Failed to track IAP purchases", th);
        }
    }

    /* renamed from: c */
    private static Method m23368c(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == IBinder.class) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: d */
    private static Method m23371d(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == String.class && parameterTypes[2] == String.class && parameterTypes[3] == String.class) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: e */
    private static Method m23372e(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            Class returnType = method.getReturnType();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == String.class && parameterTypes[2] == String.class && parameterTypes[3] == Bundle.class && returnType == Bundle.class) {
                return method;
            }
        }
        return null;
    }
}
