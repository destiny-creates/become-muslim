package com.gettipsi.stripe;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.share.internal.ShareConstants;
import com.gettipsi.stripe.p125a.C2103a;
import com.gettipsi.stripe.p126b.C2104a;
import com.gettipsi.stripe.p126b.C2106c;
import com.gettipsi.stripe.p126b.C2107d;
import com.stripe.android.C5766p;
import com.stripe.android.C5817w;
import com.stripe.android.p285b.C7162i;
import com.stripe.android.p285b.C7168u;

public class StripeModule extends ReactContextBaseJavaModule {
    private static final String MODULE_NAME = "StripeModule";
    private static final String TAG;
    private static StripeModule sInstance = null;
    private final ActivityEventListener mActivityEventListener = new C46811(this);
    private Promise mCreateSourcePromise;
    private C7162i mCreatedSource;
    private C2109c mPayFlow;
    private String mPublicKey;
    private C5766p mStripe;

    /* renamed from: com.gettipsi.stripe.StripeModule$2 */
    class C39812 implements C2107d<Activity> {
        /* renamed from: a */
        final /* synthetic */ StripeModule f9990a;

        C39812(StripeModule stripeModule) {
            this.f9990a = stripeModule;
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1986b() {
            return m12189a();
        }

        /* renamed from: a */
        public Activity m12189a() {
            return this.f9990a.getCurrentActivity();
        }
    }

    /* renamed from: com.gettipsi.stripe.StripeModule$1 */
    class C46811 extends BaseActivityEventListener {
        /* renamed from: a */
        final /* synthetic */ StripeModule f12637a;

        C46811(StripeModule stripeModule) {
            this.f12637a = stripeModule;
        }

        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (!this.f12637a.getPayFlow().mo1989a(activity, i, i2, intent)) {
                super.onActivityResult(activity, i, i2, intent);
            }
        }
    }

    public boolean canOverrideExistingModule() {
        return true;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("### ");
        stringBuilder.append(MODULE_NAME);
        stringBuilder.append(": ");
        TAG = stringBuilder.toString();
    }

    public static StripeModule getInstance() {
        return sInstance;
    }

    public C5766p getStripe() {
        return this.mStripe;
    }

    public StripeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this.mActivityEventListener);
        sInstance = this;
    }

    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void init(ReadableMap readableMap) {
        C2104a.m5776a((Object) readableMap);
        String b = C2106c.m5805b(readableMap, "publishableKey");
        readableMap = C2106c.m5805b(readableMap, "androidPayMode");
        if (!(b == null || TextUtils.equals(b, this.mPublicKey))) {
            C2104a.m5777a(b);
            this.mPublicKey = b;
            this.mStripe = new C5766p(getReactApplicationContext(), this.mPublicKey);
            getPayFlow().m5815a(this.mPublicKey);
        }
        if (readableMap != null) {
            boolean z;
            if (!"test".equals(readableMap)) {
                if (!"production".equals(readableMap)) {
                    z = false;
                    C2104a.m5778a(z);
                    getPayFlow().m5813a(androidPayModeToEnvironment(readableMap));
                }
            }
            z = true;
            C2104a.m5778a(z);
            getPayFlow().m5813a(androidPayModeToEnvironment(readableMap));
        }
    }

    private C2109c getPayFlow() {
        if (this.mPayFlow == null) {
            this.mPayFlow = C2109c.m5809a(new C39812(this));
        }
        return this.mPayFlow;
    }

    private static int androidPayModeToEnvironment(String str) {
        C2104a.m5777a(str);
        return "test".equals(str.toLowerCase()) != null ? 3 : 1;
    }

    @ReactMethod
    public void deviceSupportsAndroidPay(Promise promise) {
        getPayFlow().mo1988a(false, promise);
    }

    @ReactMethod
    public void canMakeAndroidPayPayments(Promise promise) {
        getPayFlow().mo1988a(true, promise);
    }

    @ReactMethod
    public void createTokenWithCard(ReadableMap readableMap, final Promise promise) {
        try {
            C2104a.m5776a(this.mStripe);
            C2104a.m5777a(this.mPublicKey);
            this.mStripe.a(C2106c.m5804b(readableMap), this.mPublicKey, new C5817w(this) {
                /* renamed from: b */
                final /* synthetic */ StripeModule f9992b;

                /* renamed from: a */
                public void m12191a(C7168u c7168u) {
                    promise.resolve(C2106c.m5794a(c7168u));
                }

                /* renamed from: a */
                public void m12192a(Exception exception) {
                    exception.printStackTrace();
                    promise.reject(StripeModule.TAG, exception.getMessage());
                }
            });
        } catch (ReadableMap readableMap2) {
            promise.reject(TAG, readableMap2.getMessage());
        }
    }

    @ReactMethod
    public void createTokenWithBankAccount(ReadableMap readableMap, final Promise promise) {
        try {
            C2104a.m5776a(this.mStripe);
            C2104a.m5777a(this.mPublicKey);
            this.mStripe.a(C2106c.m5806c(readableMap), this.mPublicKey, null, new C5817w(this) {
                /* renamed from: b */
                final /* synthetic */ StripeModule f9994b;

                /* renamed from: a */
                public void m12193a(C7168u c7168u) {
                    promise.resolve(C2106c.m5794a(c7168u));
                }

                /* renamed from: a */
                public void m12194a(Exception exception) {
                    exception.printStackTrace();
                    promise.reject(StripeModule.TAG, exception.getMessage());
                }
            });
        } catch (ReadableMap readableMap2) {
            promise.reject(TAG, readableMap2.getMessage());
        }
    }

    @ReactMethod
    public void paymentRequestWithCardForm(ReadableMap readableMap, Promise promise) {
        Object currentActivity = getCurrentActivity();
        try {
            C2104a.m5776a(currentActivity);
            C2104a.m5777a(this.mPublicKey);
            C2103a a = C2103a.m5764a(this.mPublicKey);
            a.m5774a(promise);
            a.show(currentActivity.getFragmentManager(), "AddNewCard");
        } catch (ReadableMap readableMap2) {
            promise.reject(TAG, readableMap2.getMessage());
        }
    }

    @ReactMethod
    public void paymentRequestWithAndroidPay(ReadableMap readableMap, Promise promise) {
        getPayFlow().mo1987a(readableMap, promise);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.facebook.react.bridge.ReactMethod
    public void createSourceWithParams(com.facebook.react.bridge.ReadableMap r8, final com.facebook.react.bridge.Promise r9) {
        /*
        r7 = this;
        r0 = "type";
        r0 = r8.getString(r0);
        r1 = r0.hashCode();
        switch(r1) {
            case -1920743119: goto L_0x0054;
            case -1414960566: goto L_0x004a;
            case -896955097: goto L_0x0040;
            case -579178115: goto L_0x0036;
            case -102703842: goto L_0x002c;
            case 38358441: goto L_0x0022;
            case 100048981: goto L_0x0018;
            case 1690449641: goto L_0x000e;
            default: goto L_0x000d;
        };
    L_0x000d:
        goto L_0x005e;
    L_0x000e:
        r1 = "sepaDebit";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005e;
    L_0x0016:
        r0 = 5;
        goto L_0x005f;
    L_0x0018:
        r1 = "ideal";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005e;
    L_0x0020:
        r0 = 4;
        goto L_0x005f;
    L_0x0022:
        r1 = "giropay";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005e;
    L_0x002a:
        r0 = 3;
        goto L_0x005f;
    L_0x002c:
        r1 = "bitcoin";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005e;
    L_0x0034:
        r0 = 2;
        goto L_0x005f;
    L_0x0036:
        r1 = "threeDSecure";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005e;
    L_0x003e:
        r0 = 7;
        goto L_0x005f;
    L_0x0040:
        r1 = "sofort";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005e;
    L_0x0048:
        r0 = 6;
        goto L_0x005f;
    L_0x004a:
        r1 = "alipay";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005e;
    L_0x0052:
        r0 = 0;
        goto L_0x005f;
    L_0x0054:
        r1 = "bancontact";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005e;
    L_0x005c:
        r0 = 1;
        goto L_0x005f;
    L_0x005e:
        r0 = -1;
    L_0x005f:
        switch(r0) {
            case 0: goto L_0x0146;
            case 1: goto L_0x0128;
            case 2: goto L_0x0110;
            case 3: goto L_0x00f2;
            case 4: goto L_0x00cd;
            case 5: goto L_0x00a3;
            case 6: goto L_0x0084;
            case 7: goto L_0x0065;
            default: goto L_0x0062;
        };
    L_0x0062:
        r8 = 0;
        goto L_0x0169;
    L_0x0065:
        r0 = "amount";
        r0 = r8.getInt(r0);
        r0 = (long) r0;
        r2 = "currency";
        r2 = r8.getString(r2);
        r3 = "returnURL";
        r3 = r8.getString(r3);
        r4 = "card";
        r8 = r8.getString(r4);
        r8 = com.stripe.android.p285b.C5728m.d(r0, r2, r3, r8);
        goto L_0x0169;
    L_0x0084:
        r0 = "amount";
        r0 = r8.getInt(r0);
        r0 = (long) r0;
        r2 = "returnURL";
        r2 = r8.getString(r2);
        r3 = "country";
        r3 = r8.getString(r3);
        r4 = "statementDescriptor";
        r8 = com.gettipsi.stripe.p126b.C2106c.m5805b(r8, r4);
        r8 = com.stripe.android.p285b.C5728m.c(r0, r2, r3, r8);
        goto L_0x0169;
    L_0x00a3:
        r0 = "name";
        r1 = r8.getString(r0);
        r0 = "iban";
        r2 = r8.getString(r0);
        r0 = "addressLine1";
        r3 = com.gettipsi.stripe.p126b.C2106c.m5805b(r8, r0);
        r0 = "city";
        r4 = r8.getString(r0);
        r0 = "postalCode";
        r5 = r8.getString(r0);
        r0 = "country";
        r6 = r8.getString(r0);
        r8 = com.stripe.android.p285b.C5728m.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0169;
    L_0x00cd:
        r0 = "amount";
        r0 = r8.getInt(r0);
        r1 = (long) r0;
        r0 = "name";
        r3 = r8.getString(r0);
        r0 = "returnURL";
        r4 = r8.getString(r0);
        r0 = "statementDescriptor";
        r5 = com.gettipsi.stripe.p126b.C2106c.m5805b(r8, r0);
        r0 = "bank";
        r6 = com.gettipsi.stripe.p126b.C2106c.m5805b(r8, r0);
        r8 = com.stripe.android.p285b.C5728m.b(r1, r3, r4, r5, r6);
        goto L_0x0169;
    L_0x00f2:
        r0 = "amount";
        r0 = r8.getInt(r0);
        r0 = (long) r0;
        r2 = "name";
        r2 = r8.getString(r2);
        r3 = "returnURL";
        r3 = r8.getString(r3);
        r4 = "statementDescriptor";
        r8 = com.gettipsi.stripe.p126b.C2106c.m5805b(r8, r4);
        r8 = com.stripe.android.p285b.C5728m.b(r0, r2, r3, r8);
        goto L_0x0169;
    L_0x0110:
        r0 = "amount";
        r0 = r8.getInt(r0);
        r0 = (long) r0;
        r2 = "currency";
        r2 = r8.getString(r2);
        r3 = "email";
        r8 = r8.getString(r3);
        r8 = com.stripe.android.p285b.C5728m.a(r0, r2, r8);
        goto L_0x0169;
    L_0x0128:
        r0 = "amount";
        r0 = r8.getInt(r0);
        r0 = (long) r0;
        r2 = "name";
        r2 = r8.getString(r2);
        r3 = "returnURL";
        r3 = r8.getString(r3);
        r4 = "statementDescriptor";
        r8 = com.gettipsi.stripe.p126b.C2106c.m5805b(r8, r4);
        r8 = com.stripe.android.p285b.C5728m.a(r0, r2, r3, r8);
        goto L_0x0169;
    L_0x0146:
        r0 = "amount";
        r0 = r8.getInt(r0);
        r1 = (long) r0;
        r0 = "currency";
        r3 = r8.getString(r0);
        r0 = "name";
        r4 = com.gettipsi.stripe.p126b.C2106c.m5805b(r8, r0);
        r0 = "email";
        r5 = com.gettipsi.stripe.p126b.C2106c.m5805b(r8, r0);
        r0 = "returnURL";
        r6 = r8.getString(r0);
        r8 = com.stripe.android.p285b.C5728m.a(r1, r3, r4, r5, r6);
    L_0x0169:
        com.gettipsi.stripe.p126b.C2104a.m5776a(r8);
        r0 = r7.mStripe;
        r1 = new com.gettipsi.stripe.StripeModule$5;
        r1.<init>(r7, r9);
        r0.a(r8, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gettipsi.stripe.StripeModule.createSourceWithParams(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    void processRedirect(Uri uri) {
        if (this.mCreatedSource != null) {
            if (this.mCreateSourcePromise != null) {
                if (uri == null) {
                    this.mCreateSourcePromise.reject(TAG, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED);
                    this.mCreatedSource = null;
                    this.mCreateSourcePromise = null;
                    return;
                }
                final String queryParameter = uri.getQueryParameter("client_secret");
                if (this.mCreatedSource.d().equals(queryParameter)) {
                    uri = uri.getQueryParameter(ShareConstants.FEED_SOURCE_PARAM);
                    if (this.mCreatedSource.y().equals(uri)) {
                        final Promise promise = this.mCreateSourcePromise;
                        this.mCreatedSource = null;
                        this.mCreateSourcePromise = null;
                        new AsyncTask<Void, Void, Void>(this) {
                            /* renamed from: d */
                            final /* synthetic */ StripeModule f5018d;

                            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                                return m5762a((Void[]) objArr);
                            }

                            /* renamed from: a */
                            protected java.lang.Void m5762a(java.lang.Void... r5) {
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
                                r4 = this;
                                r5 = 0;
                                r0 = r4.f5018d;	 Catch:{ Exception -> 0x007d }
                                r0 = r0.mStripe;	 Catch:{ Exception -> 0x007d }
                                r1 = r4;	 Catch:{ Exception -> 0x007d }
                                r2 = r1;	 Catch:{ Exception -> 0x007d }
                                r0 = r0.a(r1, r2);	 Catch:{ Exception -> 0x007d }
                                r1 = r0.n();
                                r2 = -1;
                                r3 = r1.hashCode();
                                switch(r3) {
                                    case -1281977283: goto L_0x004e;
                                    case -682587753: goto L_0x0044;
                                    case -567770136: goto L_0x003a;
                                    case -284840886: goto L_0x0030;
                                    case -123173735: goto L_0x0026;
                                    case 1418477070: goto L_0x001c;
                                    default: goto L_0x001b;
                                };
                            L_0x001b:
                                goto L_0x0057;
                            L_0x001c:
                                r3 = "chargeable";
                                r1 = r1.equals(r3);
                                if (r1 == 0) goto L_0x0057;
                            L_0x0024:
                                r2 = 0;
                                goto L_0x0057;
                            L_0x0026:
                                r3 = "canceled";
                                r1 = r1.equals(r3);
                                if (r1 == 0) goto L_0x0057;
                            L_0x002e:
                                r2 = 2;
                                goto L_0x0057;
                            L_0x0030:
                                r3 = "unknown";
                                r1 = r1.equals(r3);
                                if (r1 == 0) goto L_0x0057;
                            L_0x0038:
                                r2 = 5;
                                goto L_0x0057;
                            L_0x003a:
                                r3 = "consumed";
                                r1 = r1.equals(r3);
                                if (r1 == 0) goto L_0x0057;
                            L_0x0042:
                                r2 = 1;
                                goto L_0x0057;
                            L_0x0044:
                                r3 = "pending";
                                r1 = r1.equals(r3);
                                if (r1 == 0) goto L_0x0057;
                            L_0x004c:
                                r2 = 3;
                                goto L_0x0057;
                            L_0x004e:
                                r3 = "failed";
                                r1 = r1.equals(r3);
                                if (r1 == 0) goto L_0x0057;
                            L_0x0056:
                                r2 = 4;
                            L_0x0057:
                                switch(r2) {
                                    case 0: goto L_0x0073;
                                    case 1: goto L_0x0073;
                                    case 2: goto L_0x0067;
                                    case 3: goto L_0x005b;
                                    case 4: goto L_0x005b;
                                    case 5: goto L_0x005b;
                                    default: goto L_0x005a;
                                };
                            L_0x005a:
                                goto L_0x007c;
                            L_0x005b:
                                r0 = r2;
                                r1 = com.gettipsi.stripe.StripeModule.TAG;
                                r2 = "Source redirect failed";
                                r0.reject(r1, r2);
                                goto L_0x007c;
                            L_0x0067:
                                r0 = r2;
                                r1 = com.gettipsi.stripe.StripeModule.TAG;
                                r2 = "User cancelled source redirect";
                                r0.reject(r1, r2);
                                goto L_0x007c;
                            L_0x0073:
                                r1 = r2;
                                r0 = com.gettipsi.stripe.p126b.C2106c.m5789a(r0);
                                r1.resolve(r0);
                            L_0x007c:
                                return r5;
                            L_0x007d:
                                return r5;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.gettipsi.stripe.StripeModule.6.a(java.lang.Void[]):java.lang.Void");
                            }
                        }.execute(new Void[null]);
                        return;
                    }
                    this.mCreateSourcePromise.reject(TAG, "Received wrong source id in redirect uri");
                    this.mCreatedSource = null;
                    this.mCreateSourcePromise = null;
                    return;
                }
                this.mCreateSourcePromise.reject(TAG, "Received redirect uri but there is no source to process");
                this.mCreatedSource = null;
                this.mCreateSourcePromise = null;
            }
        }
    }
}
