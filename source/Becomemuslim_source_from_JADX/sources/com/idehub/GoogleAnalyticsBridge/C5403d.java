package com.idehub.GoogleAnalyticsBridge;

import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.google.android.gms.analytics.C2709e.C4302a;
import com.google.android.gms.analytics.C2709e.C4303b;
import com.google.android.gms.analytics.C2709e.C4304d;
import com.google.android.gms.analytics.C2709e.C4305e;
import com.google.android.gms.analytics.C2709e.C4306f;
import com.google.android.gms.analytics.p171a.C2702a;
import com.google.android.gms.analytics.p171a.C2703b;

/* compiled from: GoogleAnalyticsPayload */
/* renamed from: com.idehub.GoogleAnalyticsBridge.d */
public class C5403d {

    /* compiled from: GoogleAnalyticsPayload */
    /* renamed from: com.idehub.GoogleAnalyticsBridge.d$6 */
    static /* synthetic */ class C54016 {
        /* renamed from: a */
        static final /* synthetic */ int[] f18193a = new int[ReadableType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.facebook.react.bridge.ReadableType.values();
            r0 = r0.length;
            r0 = new int[r0];
            f18193a = r0;
            r0 = f18193a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.react.bridge.ReadableType.String;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f18193a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.facebook.react.bridge.ReadableType.Number;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f18193a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.facebook.react.bridge.ReadableType.Boolean;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.idehub.GoogleAnalyticsBridge.d.6.<clinit>():void");
        }
    }

    /* compiled from: GoogleAnalyticsPayload */
    /* renamed from: com.idehub.GoogleAnalyticsBridge.d$a */
    private static abstract class C5402a {
        /* renamed from: a */
        public abstract void mo4905a(C2702a c2702a);

        /* renamed from: a */
        public abstract void mo4906a(C2702a c2702a, String str);

        /* renamed from: a */
        public abstract void mo4907a(C2703b c2703b);

        /* renamed from: a */
        public abstract void mo4908a(Integer num, Integer num2);

        /* renamed from: a */
        public abstract void mo4909a(Integer num, String str);

        /* renamed from: a */
        public abstract void mo4910a(String str);

        /* renamed from: b */
        public abstract void mo4911b(String str);

        private C5402a() {
        }

        /* renamed from: a */
        public void m22955a(ReadableMap readableMap) {
            m22948b(readableMap);
            m22949c(readableMap);
            m22950d(readableMap);
            m22951e(readableMap);
            m22952f(readableMap);
            m22953g(readableMap);
            m22954h(readableMap);
        }

        /* renamed from: b */
        private void m22948b(ReadableMap readableMap) {
            if (readableMap.hasKey("products")) {
                readableMap = readableMap.getArray("products");
                for (int i = 0; i < readableMap.size(); i++) {
                    mo4905a(C5403d.m22971c(readableMap.getMap(i)));
                }
            }
        }

        /* renamed from: c */
        private void m22949c(ReadableMap readableMap) {
            if (readableMap.hasKey("impressionProducts")) {
                String string = readableMap.getString("impressionList");
                readableMap = readableMap.getArray("impressionProducts");
                for (int i = 0; i < readableMap.size(); i++) {
                    mo4906a(C5403d.m22971c(readableMap.getMap(i)), string);
                }
            }
        }

        /* renamed from: d */
        private void m22950d(ReadableMap readableMap) {
            if (readableMap.hasKey("productAction")) {
                mo4907a(C5403d.m22972d(readableMap.getMap("productAction")));
            }
        }

        /* renamed from: e */
        private void m22951e(ReadableMap readableMap) {
            if (readableMap.hasKey("customDimensions")) {
                readableMap = readableMap.getMap("customDimensions");
                ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    String str = null;
                    switch (C54016.f18193a[readableMap.getType(nextKey).ordinal()]) {
                        case 1:
                            str = readableMap.getString(nextKey);
                            break;
                        case 2:
                            str = Double.toString(readableMap.getDouble(nextKey));
                            break;
                        case 3:
                            str = Boolean.toString(readableMap.getBoolean(nextKey));
                            break;
                        default:
                            break;
                    }
                    if (str != null) {
                        mo4909a(Integer.valueOf(Integer.parseInt(nextKey)), str);
                    }
                }
            }
        }

        /* renamed from: f */
        private void m22952f(ReadableMap readableMap) {
            if (readableMap.hasKey("customMetrics")) {
                readableMap = readableMap.getMap("customMetrics");
                ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    mo4908a(Integer.valueOf(Integer.parseInt(nextKey)), Integer.valueOf(readableMap.getInt(nextKey)));
                }
            }
        }

        /* renamed from: g */
        private void m22953g(ReadableMap readableMap) {
            if (readableMap.hasKey("utmCampaignUrl")) {
                mo4910a(readableMap.getString("utmCampaignUrl"));
            }
        }

        /* renamed from: h */
        private void m22954h(ReadableMap readableMap) {
            if (readableMap.hasKey("session")) {
                mo4911b(readableMap.getString("session"));
            }
        }
    }

    /* renamed from: a */
    public static void m22967a(final C4304d c4304d, ReadableMap readableMap) {
        new C5402a() {
            /* renamed from: a */
            public void mo4905a(C2702a c2702a) {
                c4304d.a(c2702a);
            }

            /* renamed from: a */
            public void mo4906a(C2702a c2702a, String str) {
                c4304d.a(c2702a, str);
            }

            /* renamed from: a */
            public void mo4907a(C2703b c2703b) {
                c4304d.a(c2703b);
            }

            /* renamed from: a */
            public void mo4909a(Integer num, String str) {
                c4304d.a(num.intValue(), str);
            }

            /* renamed from: a */
            public void mo4908a(Integer num, Integer num2) {
                c4304d.a(num.intValue(), (float) num2.intValue());
            }

            /* renamed from: a */
            public void mo4910a(String str) {
                c4304d.d(str);
            }

            /* renamed from: b */
            public void mo4911b(String str) {
                c4304d.a("&sc", str);
            }
        }.m22955a(readableMap);
    }

    /* renamed from: a */
    public static void m22965a(final C4302a c4302a, ReadableMap readableMap) {
        new C5402a() {
            /* renamed from: a */
            public void mo4905a(C2702a c2702a) {
                c4302a.a(c2702a);
            }

            /* renamed from: a */
            public void mo4906a(C2702a c2702a, String str) {
                c4302a.a(c2702a, str);
            }

            /* renamed from: a */
            public void mo4907a(C2703b c2703b) {
                c4302a.a(c2703b);
            }

            /* renamed from: a */
            public void mo4909a(Integer num, String str) {
                c4302a.a(num.intValue(), str);
            }

            /* renamed from: a */
            public void mo4908a(Integer num, Integer num2) {
                c4302a.a(num.intValue(), (float) num2.intValue());
            }

            /* renamed from: a */
            public void mo4910a(String str) {
                c4302a.d(str);
            }

            /* renamed from: b */
            public void mo4911b(String str) {
                c4302a.a("&sc", str);
            }
        }.m22955a(readableMap);
    }

    /* renamed from: a */
    public static void m22969a(final C4306f c4306f, ReadableMap readableMap) {
        new C5402a() {
            /* renamed from: a */
            public void mo4905a(C2702a c2702a) {
                c4306f.a(c2702a);
            }

            /* renamed from: a */
            public void mo4906a(C2702a c2702a, String str) {
                c4306f.a(c2702a, str);
            }

            /* renamed from: a */
            public void mo4907a(C2703b c2703b) {
                c4306f.a(c2703b);
            }

            /* renamed from: a */
            public void mo4909a(Integer num, String str) {
                c4306f.a(num.intValue(), str);
            }

            /* renamed from: a */
            public void mo4908a(Integer num, Integer num2) {
                c4306f.a(num.intValue(), (float) num2.intValue());
            }

            /* renamed from: a */
            public void mo4910a(String str) {
                c4306f.d(str);
            }

            /* renamed from: b */
            public void mo4911b(String str) {
                c4306f.a("&sc", str);
            }
        }.m22955a(readableMap);
    }

    /* renamed from: a */
    public static void m22966a(final C4303b c4303b, ReadableMap readableMap) {
        new C5402a() {
            /* renamed from: a */
            public void mo4905a(C2702a c2702a) {
                c4303b.a(c2702a);
            }

            /* renamed from: a */
            public void mo4906a(C2702a c2702a, String str) {
                c4303b.a(c2702a, str);
            }

            /* renamed from: a */
            public void mo4907a(C2703b c2703b) {
                c4303b.a(c2703b);
            }

            /* renamed from: a */
            public void mo4909a(Integer num, String str) {
                c4303b.a(num.intValue(), str);
            }

            /* renamed from: a */
            public void mo4908a(Integer num, Integer num2) {
                c4303b.a(num.intValue(), (float) num2.intValue());
            }

            /* renamed from: a */
            public void mo4910a(String str) {
                c4303b.d(str);
            }

            /* renamed from: b */
            public void mo4911b(String str) {
                c4303b.a("&sc", str);
            }
        }.m22955a(readableMap);
    }

    /* renamed from: a */
    public static void m22968a(final C4305e c4305e, ReadableMap readableMap) {
        new C5402a() {
            /* renamed from: a */
            public void mo4905a(C2702a c2702a) {
                c4305e.a(c2702a);
            }

            /* renamed from: a */
            public void mo4906a(C2702a c2702a, String str) {
                c4305e.a(c2702a, str);
            }

            /* renamed from: a */
            public void mo4907a(C2703b c2703b) {
                c4305e.a(c2703b);
            }

            /* renamed from: a */
            public void mo4909a(Integer num, String str) {
                c4305e.a(num.intValue(), str);
            }

            /* renamed from: a */
            public void mo4908a(Integer num, Integer num2) {
                c4305e.a(num.intValue(), (float) num2.intValue());
            }

            /* renamed from: a */
            public void mo4910a(String str) {
                c4305e.d(str);
            }

            /* renamed from: b */
            public void mo4911b(String str) {
                c4305e.a("&sc", str);
            }
        }.m22955a(readableMap);
    }

    /* renamed from: c */
    private static C2702a m22971c(ReadableMap readableMap) {
        C2702a b = new C2702a().a(readableMap.getString("id")).b(readableMap.getString("name"));
        if (readableMap.hasKey("brand")) {
            b.c(readableMap.getString("brand"));
        }
        if (readableMap.hasKey("price")) {
            b.a(readableMap.getDouble("price"));
        }
        if (readableMap.hasKey("quantity")) {
            b.b(readableMap.getInt("quantity"));
        }
        if (readableMap.hasKey("variant")) {
            b.e(readableMap.getString("variant"));
        }
        if (readableMap.hasKey("category")) {
            b.d(readableMap.getString("category"));
        }
        if (readableMap.hasKey("couponCode")) {
            b.f(readableMap.getString("couponCode"));
        }
        return b;
    }

    /* renamed from: d */
    private static C2703b m22972d(ReadableMap readableMap) {
        C2703b c2703b = new C2703b(C5403d.m22964a(Integer.valueOf(readableMap.getInt(NativeProtocol.WEB_DIALOG_ACTION))));
        if (readableMap.hasKey("transaction")) {
            ReadableMap map = readableMap.getMap("transaction");
            c2703b.a(map.getString("id"));
            if (map.hasKey("tax")) {
                c2703b.b(map.getDouble("tax"));
            }
            if (map.hasKey("revenue")) {
                c2703b.a(map.getDouble("revenue"));
            }
            if (map.hasKey("shipping")) {
                c2703b.c(map.getDouble("shipping"));
            }
            if (map.hasKey("couponCode")) {
                c2703b.c(map.getString("couponCode"));
            }
            if (map.hasKey("affiliation")) {
                c2703b.b(map.getString("affiliation"));
            }
        }
        if (readableMap.hasKey("checkoutStep")) {
            c2703b.a(readableMap.getInt("checkoutStep"));
        }
        if (readableMap.hasKey("checkoutOption")) {
            c2703b.d(readableMap.getString("checkoutOption"));
        }
        if (readableMap.hasKey("productActionList")) {
            c2703b.e(readableMap.getString("productActionList"));
        }
        if (readableMap.hasKey("productListSource")) {
            c2703b.f(readableMap.getString("productListSource"));
        }
        return c2703b;
    }

    /* renamed from: a */
    private static String m22964a(Integer num) {
        switch (num.intValue()) {
            case 1:
                return "click";
            case 2:
                return "detail";
            case 3:
                return "add";
            case 4:
                return "remove";
            case 5:
                return "checkout";
            case 6:
                return "checkout_option";
            case 8:
                return "refund";
            default:
                return "purchase";
        }
    }
}
