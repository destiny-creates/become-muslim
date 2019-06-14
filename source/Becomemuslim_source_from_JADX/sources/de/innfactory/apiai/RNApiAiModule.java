package de.innfactory.apiai;

import ai.api.C0009a.C0004a;
import ai.api.C0020c;
import ai.api.C0044j;
import ai.api.p005a.C0006c;
import ai.api.p005a.C0008e;
import ai.api.p005a.C3087a;
import ai.api.p005a.C3087a.C0005a;
import ai.api.p005a.C3089b;
import ai.api.p007c.C0012a;
import ai.api.p007c.C0013c;
import ai.api.p007c.C3090b;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.p127a.C2157f;
import com.google.p127a.p131c.C2150a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RNApiAiModule extends ReactContextBaseJavaModule implements C0020c {
    private static final String LANG_CHINESE_CHINA = "LANG_CHINESE_CHINA";
    private static final String LANG_CHINESE_HONGKONG = "LANG_CHINESE_HONGKONG";
    private static final String LANG_CHINESE_TAIWAN = "LANG_CHINESE_TAIWAN";
    private static final String LANG_DUTCH = "LANG_DUTCH";
    private static final String LANG_ENGLISH = "LANG_ENGLISH";
    private static final String LANG_ENGLISH_GB = "LANG_ENGLISH_GB";
    private static final String LANG_ENGLISH_US = "LANG_ENGLISH_US";
    private static final String LANG_FRENCH = "LANG_FRENCH";
    private static final String LANG_GERMAN = "LANG_GERMAN";
    private static final String LANG_ITALIAN = "LANG_ITALIAN";
    private static final String LANG_JAPANESE = "LANG_JAPANESE";
    private static final String LANG_KOREAN = "LANG_KOREAN";
    private static final String LANG_PORTUGUESE = "LANG_PORTUGUESE";
    private static final String LANG_PORTUGUESE_BRAZIL = "LANG_PORTUGUESE_BRAZIL";
    private static final String LANG_RUSSIAN = "LANG_RUSSIAN";
    private static final String LANG_SPANISH = "LANG_SPANISH";
    private static final String LANG_UKRAINIAN = "LANG_UKRAINIAN";
    private static final String TAG = "ApiAi";
    private String accessToken;
    private C3089b aiDataService;
    private C0006c aiService;
    private C3087a config = new C3087a("", C0004a.f18r, C0005a.System);
    private List<Object> contexts;
    private List<Object> entities;
    private String languageTag;
    private Callback onAudioLevelCallback;
    private Callback onErrorCallback;
    private Callback onListeningCanceledCallback;
    private Callback onListeningFinishedCallback;
    private Callback onListeningStartedCallback;
    private Callback onResultCallback;
    private List<Object> permantentContexts;

    /* renamed from: de.innfactory.apiai.RNApiAiModule$4 */
    class C58964 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RNApiAiModule f19621a;

        C58964(RNApiAiModule rNApiAiModule) {
            this.f19621a = rNApiAiModule;
        }

        public void run() {
            this.f19621a.aiService = C0006c.a(this.f19621a.getReactApplicationContext(), this.f19621a.config);
            this.f19621a.aiService.a(this.f19621a);
            if (this.f19621a.contexts == null && this.f19621a.permantentContexts == null) {
                if (this.f19621a.entities == null) {
                    this.f19621a.aiService.a();
                    return;
                }
            }
            this.f19621a.aiService.a(new C0044j(this.f19621a.mergeContexts(this.f19621a.contexts, this.f19621a.permantentContexts), this.f19621a.entities));
            this.f19621a.contexts = null;
            this.f19621a.entities = null;
        }
    }

    /* renamed from: de.innfactory.apiai.RNApiAiModule$5 */
    class C58975 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RNApiAiModule f19622a;

        C58975(RNApiAiModule rNApiAiModule) {
            this.f19622a = rNApiAiModule;
        }

        public void run() {
            if (this.f19622a.aiService != null) {
                this.f19622a.aiService.b();
            }
        }
    }

    /* renamed from: de.innfactory.apiai.RNApiAiModule$6 */
    class C58986 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RNApiAiModule f19623a;

        C58986(RNApiAiModule rNApiAiModule) {
            this.f19623a = rNApiAiModule;
        }

        public void run() {
            if (this.f19623a.aiService != null) {
                this.f19623a.aiService.c();
            }
        }
    }

    /* renamed from: de.innfactory.apiai.RNApiAiModule$1 */
    class C72171 extends C2150a<List<Object>> {
        /* renamed from: d */
        final /* synthetic */ RNApiAiModule f25494d;

        C72171(RNApiAiModule rNApiAiModule) {
            this.f25494d = rNApiAiModule;
        }
    }

    /* renamed from: de.innfactory.apiai.RNApiAiModule$2 */
    class C72182 extends C2150a<List<Object>> {
        /* renamed from: d */
        final /* synthetic */ RNApiAiModule f25495d;

        C72182(RNApiAiModule rNApiAiModule) {
            this.f25495d = rNApiAiModule;
        }
    }

    /* renamed from: de.innfactory.apiai.RNApiAiModule$3 */
    class C72193 extends C2150a<List<Object>> {
        /* renamed from: d */
        final /* synthetic */ RNApiAiModule f25496d;

        C72193(RNApiAiModule rNApiAiModule) {
            this.f25496d = rNApiAiModule;
        }
    }

    public String getName() {
        return TAG;
    }

    public RNApiAiModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void setConfiguration(String str, String str2) {
        this.accessToken = str;
        this.languageTag = str2;
        this.config = new C3087a(str, C0004a.a(str2), C0005a.System);
    }

    @ReactMethod
    public void getLanguage(Promise promise) {
        promise.resolve(this.languageTag);
    }

    @ReactMethod
    public void setContextsAsJson(String str) {
        this.contexts = (List) new C2157f().a(str, new C72171(this).b());
    }

    @ReactMethod
    public void setPermanentContextsAsJson(String str) {
        this.permantentContexts = (List) new C2157f().a(str, new C72182(this).b());
    }

    @ReactMethod
    public void setEntitiesAsJson(String str) {
        this.entities = (List) new C2157f().a(str, new C72193(this).b());
    }

    @ReactMethod
    public void startListeningNative(Callback callback, Callback callback2) {
        this.onResultCallback = callback;
        this.onErrorCallback = callback2;
        getCurrentActivity().runOnUiThread(new C58964(this));
    }

    @ReactMethod
    public void stopListening() {
        getCurrentActivity().runOnUiThread(new C58975(this));
    }

    @ReactMethod
    public void cancel() {
        getCurrentActivity().runOnUiThread(new C58986(this));
    }

    public void onResult(C0013c c0013c) {
        if (this.onResultCallback != null) {
            C2157f c2157f = new C2157f();
            try {
                this.onResultCallback.invoke(new Object[]{c2157f.a(c0013c)});
            } catch (C0013c c0013c2) {
                Log.e(TAG, c0013c2.getMessage(), c0013c2);
            }
        }
    }

    public void onError(C0012a c0012a) {
        if (this.onErrorCallback != null) {
            C2157f c2157f = new C2157f();
            try {
                this.onErrorCallback.invoke(new Object[]{c2157f.a(c0012a)});
            } catch (C0012a c0012a2) {
                Log.e(TAG, c0012a2.getMessage(), c0012a2);
            }
        }
    }

    @ReactMethod
    public void onListeningStarted(Callback callback) {
        this.onListeningStartedCallback = callback;
    }

    public void onListeningStarted() {
        if (this.onListeningStartedCallback != null) {
            try {
                this.onListeningStartedCallback.invoke(new Object[0]);
            } catch (Throwable e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    @ReactMethod
    public void onListeningCanceled(Callback callback) {
        this.onListeningCanceledCallback = callback;
    }

    public void onListeningCanceled() {
        if (this.onListeningCanceledCallback != null) {
            try {
                this.onListeningCanceledCallback.invoke(new Object[0]);
            } catch (Throwable e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    @ReactMethod
    public void onListeningFinished(Callback callback) {
        this.onListeningFinishedCallback = callback;
    }

    public void onListeningFinished() {
        if (this.onListeningFinishedCallback != null) {
            try {
                this.onListeningFinishedCallback.invoke(new Object[0]);
            } catch (Throwable e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    @ReactMethod
    public void onAudioLevel(Callback callback) {
        this.onAudioLevelCallback = callback;
    }

    public void onAudioLevel(float f) {
        if (this.onAudioLevelCallback != null) {
            try {
                this.onAudioLevelCallback.invoke(new Object[]{Float.valueOf(f)});
            } catch (float f2) {
                Log.e(TAG, f2.getMessage(), f2);
            }
        }
    }

    @ReactMethod
    public void requestQueryNative(String str, Callback callback, Callback callback2) {
        this.onResultCallback = callback;
        this.onErrorCallback = callback2;
        if (this.aiDataService == null) {
            this.aiDataService = new C3089b(getReactApplicationContext(), this.config);
        }
        callback = new C3090b();
        callback.a(str);
        new AsyncTask<C3090b, Void, C0013c>(this) {
            /* renamed from: b */
            final /* synthetic */ RNApiAiModule f19625b;

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m24779a((C3090b[]) objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                m24780a((C0013c) obj);
            }

            /* renamed from: a */
            protected ai.api.p007c.C0013c m24779a(ai.api.p007c.C3090b... r6) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r5 = this;
                r0 = 0;
                r6 = r6[r0];
                r6 = 0;
                r1 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r1 = r1.contexts;	 Catch:{ f -> 0x005e }
                if (r1 != 0) goto L_0x002a;	 Catch:{ f -> 0x005e }
            L_0x000c:
                r1 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r1 = r1.permantentContexts;	 Catch:{ f -> 0x005e }
                if (r1 != 0) goto L_0x002a;	 Catch:{ f -> 0x005e }
            L_0x0014:
                r1 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r1 = r1.entities;	 Catch:{ f -> 0x005e }
                if (r1 == 0) goto L_0x001d;	 Catch:{ f -> 0x005e }
            L_0x001c:
                goto L_0x002a;	 Catch:{ f -> 0x005e }
            L_0x001d:
                r1 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r1 = r1.aiDataService;	 Catch:{ f -> 0x005e }
                r2 = r3;	 Catch:{ f -> 0x005e }
                r1 = r1.a(r2);	 Catch:{ f -> 0x005e }
                goto L_0x005d;	 Catch:{ f -> 0x005e }
            L_0x002a:
                r1 = new ai.api.j;	 Catch:{ f -> 0x005e }
                r2 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r3 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r3 = r3.contexts;	 Catch:{ f -> 0x005e }
                r4 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r4 = r4.permantentContexts;	 Catch:{ f -> 0x005e }
                r2 = r2.mergeContexts(r3, r4);	 Catch:{ f -> 0x005e }
                r3 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r3 = r3.entities;	 Catch:{ f -> 0x005e }
                r1.<init>(r2, r3);	 Catch:{ f -> 0x005e }
                r2 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r2 = r2.aiDataService;	 Catch:{ f -> 0x005e }
                r3 = r3;	 Catch:{ f -> 0x005e }
                r1 = r2.a(r3, r1);	 Catch:{ f -> 0x005e }
                r2 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r2.contexts = r6;	 Catch:{ f -> 0x005e }
                r2 = r5.f19625b;	 Catch:{ f -> 0x005e }
                r2.entities = r6;	 Catch:{ f -> 0x005e }
            L_0x005d:
                return r1;
            L_0x005e:
                r1 = move-exception;
                r2 = new com.google.a.f;
                r2.<init>();
                r3 = r5.f19625b;	 Catch:{ Exception -> 0x0077 }
                r3 = r3.onErrorCallback;	 Catch:{ Exception -> 0x0077 }
                r4 = 1;	 Catch:{ Exception -> 0x0077 }
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0077 }
                r2 = r2.a(r1);	 Catch:{ Exception -> 0x0077 }
                r4[r0] = r2;	 Catch:{ Exception -> 0x0077 }
                r3.invoke(r4);	 Catch:{ Exception -> 0x0077 }
                goto L_0x0080;
            L_0x0077:
                r0 = "ApiAi";
                r2 = r1.getMessage();
                android.util.Log.e(r0, r2, r1);
            L_0x0080:
                return r6;
                */
                throw new UnsupportedOperationException("Method not decompiled: de.innfactory.apiai.RNApiAiModule.7.a(ai.api.c.b[]):ai.api.c.c");
            }

            /* renamed from: a */
            protected void m24780a(C0013c c0013c) {
                if (c0013c != null) {
                    this.f19625b.onResult(c0013c);
                }
            }
        }.execute(new C3090b[]{callback});
    }

    @ReactMethod
    public void getAccessToken(Promise promise) {
        promise.resolve(this.accessToken);
    }

    @ReactMethod
    public void getSessionId(Promise promise) {
        promise.resolve(C0008e.a(getReactApplicationContext()));
    }

    private List<Object> mergeContexts(List<Object> list, List<Object> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        list.addAll(list2);
        return list;
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(LANG_CHINESE_CHINA, "zh-CN");
        hashMap.put(LANG_CHINESE_HONGKONG, "zh-HK");
        hashMap.put(LANG_CHINESE_TAIWAN, "zh-TW");
        hashMap.put(LANG_DUTCH, "nl");
        hashMap.put(LANG_ENGLISH, "en");
        hashMap.put(LANG_ENGLISH_GB, "en-GB");
        hashMap.put(LANG_ENGLISH_US, "en-US");
        hashMap.put(LANG_FRENCH, "fr");
        hashMap.put(LANG_GERMAN, "de");
        hashMap.put(LANG_ITALIAN, "it");
        hashMap.put(LANG_JAPANESE, "ja");
        hashMap.put(LANG_KOREAN, "ko");
        hashMap.put(LANG_PORTUGUESE, "pt");
        hashMap.put(LANG_PORTUGUESE_BRAZIL, "pt-BR");
        hashMap.put(LANG_RUSSIAN, "ru");
        hashMap.put(LANG_SPANISH, "es");
        hashMap.put(LANG_UKRAINIAN, "uk");
        return hashMap;
    }
}
