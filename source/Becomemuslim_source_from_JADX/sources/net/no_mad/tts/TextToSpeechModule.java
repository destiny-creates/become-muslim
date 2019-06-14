package net.no_mad.tts;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.widget.LinearLayoutManager;
import com.facebook.GraphResponse;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.util.ArrayList;
import java.util.HashMap;

public class TextToSpeechModule extends ReactContextBaseJavaModule {
    private OnAudioFocusChangeListener afChangeListener;
    private AudioManager audioManager;
    private boolean ducking = false;
    private ArrayList<Promise> initStatusPromises;
    private Boolean ready = null;
    private TextToSpeech tts;

    /* renamed from: net.no_mad.tts.TextToSpeechModule$1 */
    class C65661 implements OnInitListener {
        /* renamed from: a */
        final /* synthetic */ TextToSpeechModule f21096a;

        C65661(TextToSpeechModule textToSpeechModule) {
            this.f21096a = textToSpeechModule;
        }

        public void onInit(int i) {
            synchronized (this.f21096a.initStatusPromises) {
                this.f21096a.ready = i == 0 ? Boolean.TRUE : Boolean.FALSE;
                i = this.f21096a.initStatusPromises.iterator();
                while (i.hasNext()) {
                    this.f21096a.resolveReadyPromise((Promise) i.next());
                }
                this.f21096a.initStatusPromises.clear();
            }
        }
    }

    /* renamed from: net.no_mad.tts.TextToSpeechModule$2 */
    class C65672 extends UtteranceProgressListener {
        /* renamed from: a */
        final /* synthetic */ TextToSpeechModule f21097a;

        C65672(TextToSpeechModule textToSpeechModule) {
            this.f21097a = textToSpeechModule;
        }

        public void onStart(String str) {
            this.f21097a.sendEvent("tts-start", str);
        }

        public void onDone(String str) {
            if (this.f21097a.ducking) {
                this.f21097a.audioManager.abandonAudioFocus(this.f21097a.afChangeListener);
            }
            this.f21097a.sendEvent("tts-finish", str);
        }

        public void onError(String str) {
            if (this.f21097a.ducking) {
                this.f21097a.audioManager.abandonAudioFocus(this.f21097a.afChangeListener);
            }
            this.f21097a.sendEvent("tts-error", str);
        }

        public void onStop(String str, boolean z) {
            if (this.f21097a.ducking) {
                this.f21097a.audioManager.abandonAudioFocus(this.f21097a.afChangeListener);
            }
            this.f21097a.sendEvent("tts-cancel", str);
        }
    }

    public String getName() {
        return "TextToSpeech";
    }

    public TextToSpeechModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.audioManager = (AudioManager) reactApplicationContext.getApplicationContext().getSystemService("audio");
        this.initStatusPromises = new ArrayList();
        this.tts = new TextToSpeech(getReactApplicationContext(), new C65661(this));
        this.tts.setOnUtteranceProgressListener(new C65672(this));
    }

    private void resolveReadyPromise(Promise promise) {
        if (this.ready == Boolean.TRUE) {
            promise.resolve(GraphResponse.SUCCESS_KEY);
        } else {
            promise.reject("no_engine", "No TTS engine installed");
        }
    }

    private static void resolvePromiseWithStatusCode(int i, Promise promise) {
        switch (i) {
            case -9:
                promise.reject("not_installed_yet", "Unfinished download of voice data");
                return;
            case -8:
                promise.reject("invalid_request", "Failure caused by an invalid request");
                return;
            case -7:
                promise.reject("network_timeout", "Failure caused by network timeout.");
                return;
            case -6:
                promise.reject("network_error", "Failure caused by a network connectivity problems");
                return;
            case -5:
                promise.reject("output_error", "Failure related to the output (audio device or a file)");
                return;
            case ProfilePictureView.LARGE /*-4*/:
                promise.reject("service_error", "Failure of a TTS service");
                return;
            case ProfilePictureView.NORMAL /*-3*/:
                promise.reject("synthesis_error", "Failure of a TTS engine to synthesize the given input");
                return;
            case -2:
                promise.reject("lang_not_supported", "Language is not supported");
                return;
            case -1:
                promise.reject("lang_missing_data", "Language data is missing");
                return;
            case 0:
                promise.resolve(GraphResponse.SUCCESS_KEY);
                return;
            case 1:
                promise.resolve("lang_country_available");
                return;
            case 2:
                promise.resolve("lang_country_var_available");
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown error code: ");
                stringBuilder.append(i);
                promise.reject("error", stringBuilder.toString());
                return;
        }
    }

    @ReactMethod
    public void getInitStatus(Promise promise) {
        synchronized (this.initStatusPromises) {
            if (this.ready == null) {
                this.initStatusPromises.add(promise);
            } else {
                resolveReadyPromise(promise);
            }
        }
    }

    @ReactMethod
    public void speak(String str, ReadableMap readableMap, Promise promise) {
        if (!notReady(promise)) {
            if (!this.ducking || this.audioManager.requestAudioFocus(this.afChangeListener, 3, 3) == 1) {
                String num = Integer.toString(str.hashCode());
                str = speak(str, num, readableMap);
                if (str == null) {
                    promise.resolve(num);
                } else {
                    resolvePromiseWithStatusCode(str, promise);
                }
                return;
            }
            promise.reject("Android AudioManager error, failed to request audio focus");
        }
    }

    @com.facebook.react.bridge.ReactMethod
    public void setDefaultLanguage(java.lang.String r4, com.facebook.react.bridge.Promise r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.notReady(r5);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = "-";
        r0 = r4.indexOf(r0);
        r1 = -1;
        if (r0 == r1) goto L_0x0022;
    L_0x0010:
        r0 = "-";
        r4 = r4.split(r0);
        r0 = new java.util.Locale;
        r1 = 0;
        r1 = r4[r1];
        r2 = 1;
        r4 = r4[r2];
        r0.<init>(r1, r4);
        goto L_0x0027;
    L_0x0022:
        r0 = new java.util.Locale;
        r0.<init>(r4);
    L_0x0027:
        r4 = r3.tts;	 Catch:{ Exception -> 0x0031 }
        r4 = r4.setLanguage(r0);	 Catch:{ Exception -> 0x0031 }
        resolvePromiseWithStatusCode(r4, r5);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0038;
    L_0x0031:
        r4 = "error";
        r0 = "Unknown error code";
        r5.reject(r4, r0);
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.no_mad.tts.TextToSpeechModule.setDefaultLanguage(java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void setDucking(Boolean bool, Promise promise) {
        if (!notReady(promise)) {
            this.ducking = bool.booleanValue();
            promise.resolve(GraphResponse.SUCCESS_KEY);
        }
    }

    @ReactMethod
    public void setDefaultRate(Float f, Boolean bool, Promise promise) {
        if (!notReady(promise)) {
            if (bool.booleanValue() != null) {
                promise.resolve(Integer.valueOf(this.tts.setSpeechRate(f.floatValue())));
            } else {
                if (f.floatValue() < 0.5f) {
                    f = f.floatValue() * 1073741824;
                } else {
                    f = (f.floatValue() * 1082130432) - 1065353216;
                }
                promise.resolve(Integer.valueOf(this.tts.setSpeechRate(f)));
            }
        }
    }

    @ReactMethod
    public void setDefaultPitch(Float f, Promise promise) {
        if (!notReady(promise)) {
            promise.resolve(Integer.valueOf(this.tts.setPitch(f.floatValue())));
        }
    }

    @com.facebook.react.bridge.ReactMethod
    public void setDefaultVoice(java.lang.String r4, com.facebook.react.bridge.Promise r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.notReady(r5);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 < r1) goto L_0x003f;
    L_0x000d:
        r0 = r3.tts;	 Catch:{ Exception -> 0x0037 }
        r0 = r0.getVoices();	 Catch:{ Exception -> 0x0037 }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x0037 }
    L_0x0017:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x0037 }
        if (r1 == 0) goto L_0x0037;	 Catch:{ Exception -> 0x0037 }
    L_0x001d:
        r1 = r0.next();	 Catch:{ Exception -> 0x0037 }
        r1 = (android.speech.tts.Voice) r1;	 Catch:{ Exception -> 0x0037 }
        r2 = r1.getName();	 Catch:{ Exception -> 0x0037 }
        r2 = r2.equals(r4);	 Catch:{ Exception -> 0x0037 }
        if (r2 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0037 }
    L_0x002d:
        r4 = r3.tts;	 Catch:{ Exception -> 0x0037 }
        r4 = r4.setVoice(r1);	 Catch:{ Exception -> 0x0037 }
        resolvePromiseWithStatusCode(r4, r5);	 Catch:{ Exception -> 0x0037 }
        return;
    L_0x0037:
        r4 = "not_found";
        r0 = "The selected voice was not found";
        r5.reject(r4, r0);
        goto L_0x0046;
    L_0x003f:
        r4 = "not_available";
        r0 = "Android API 21 level or higher is required";
        r5.reject(r4, r0);
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.no_mad.tts.TextToSpeechModule.setDefaultVoice(java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    @com.facebook.react.bridge.ReactMethod
    public void voices(com.facebook.react.bridge.Promise r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.notReady(r7);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = com.facebook.react.bridge.Arguments.createArray();
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 21;
        if (r1 < r2) goto L_0x0078;
    L_0x0011:
        r1 = r6.tts;	 Catch:{ Exception -> 0x0078 }
        r1 = r1.getVoices();	 Catch:{ Exception -> 0x0078 }
        r1 = r1.iterator();	 Catch:{ Exception -> 0x0078 }
    L_0x001b:
        r2 = r1.hasNext();	 Catch:{ Exception -> 0x0078 }
        if (r2 == 0) goto L_0x0078;	 Catch:{ Exception -> 0x0078 }
    L_0x0021:
        r2 = r1.next();	 Catch:{ Exception -> 0x0078 }
        r2 = (android.speech.tts.Voice) r2;	 Catch:{ Exception -> 0x0078 }
        r3 = com.facebook.react.bridge.Arguments.createMap();	 Catch:{ Exception -> 0x0078 }
        r4 = "id";	 Catch:{ Exception -> 0x0078 }
        r5 = r2.getName();	 Catch:{ Exception -> 0x0078 }
        r3.putString(r4, r5);	 Catch:{ Exception -> 0x0078 }
        r4 = "name";	 Catch:{ Exception -> 0x0078 }
        r5 = r2.getName();	 Catch:{ Exception -> 0x0078 }
        r3.putString(r4, r5);	 Catch:{ Exception -> 0x0078 }
        r4 = "language";	 Catch:{ Exception -> 0x0078 }
        r5 = r2.getLocale();	 Catch:{ Exception -> 0x0078 }
        r5 = r5.toLanguageTag();	 Catch:{ Exception -> 0x0078 }
        r3.putString(r4, r5);	 Catch:{ Exception -> 0x0078 }
        r4 = "quality";	 Catch:{ Exception -> 0x0078 }
        r5 = r2.getQuality();	 Catch:{ Exception -> 0x0078 }
        r3.putInt(r4, r5);	 Catch:{ Exception -> 0x0078 }
        r4 = "latency";	 Catch:{ Exception -> 0x0078 }
        r5 = r2.getLatency();	 Catch:{ Exception -> 0x0078 }
        r3.putInt(r4, r5);	 Catch:{ Exception -> 0x0078 }
        r4 = "networkConnectionRequired";	 Catch:{ Exception -> 0x0078 }
        r5 = r2.isNetworkConnectionRequired();	 Catch:{ Exception -> 0x0078 }
        r3.putBoolean(r4, r5);	 Catch:{ Exception -> 0x0078 }
        r4 = "notInstalled";	 Catch:{ Exception -> 0x0078 }
        r2 = r2.getFeatures();	 Catch:{ Exception -> 0x0078 }
        r5 = "notInstalled";	 Catch:{ Exception -> 0x0078 }
        r2 = r2.contains(r5);	 Catch:{ Exception -> 0x0078 }
        r3.putBoolean(r4, r2);	 Catch:{ Exception -> 0x0078 }
        r0.pushMap(r3);	 Catch:{ Exception -> 0x0078 }
        goto L_0x001b;
    L_0x0078:
        r7.resolve(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.no_mad.tts.TextToSpeechModule.voices(com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void stop(Promise promise) {
        if (!notReady(promise)) {
            resolvePromiseWithStatusCode(this.tts.stop(), promise);
        }
    }

    @com.facebook.react.bridge.ReactMethod
    private void requestInstallEngine(com.facebook.react.bridge.Promise r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new android.content.Intent;
        r1 = "android.intent.action.VIEW";
        r0.<init>(r1);
        r1 = "market://details?id=com.google.android.tts";
        r1 = android.net.Uri.parse(r1);
        r0.setData(r1);
        r1 = r2.getCurrentActivity();	 Catch:{ Exception -> 0x001d }
        r1.startActivity(r0);	 Catch:{ Exception -> 0x001d }
        r0 = "success";	 Catch:{ Exception -> 0x001d }
        r3.resolve(r0);	 Catch:{ Exception -> 0x001d }
        goto L_0x0024;
    L_0x001d:
        r0 = "error";
        r1 = "Could not open Google Text to Speech App in the Play Store";
        r3.reject(r0, r1);
    L_0x0024:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.no_mad.tts.TextToSpeechModule.requestInstallEngine(com.facebook.react.bridge.Promise):void");
    }

    @com.facebook.react.bridge.ReactMethod
    private void requestInstallData(com.facebook.react.bridge.Promise r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "android.speech.tts.engine.INSTALL_TTS_DATA";
        r0.setAction(r1);
        r1 = r2.getCurrentActivity();	 Catch:{ ActivityNotFoundException -> 0x0017 }
        r1.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0017 }
        r0 = "success";	 Catch:{ ActivityNotFoundException -> 0x0017 }
        r3.resolve(r0);	 Catch:{ ActivityNotFoundException -> 0x0017 }
        goto L_0x001e;
    L_0x0017:
        r0 = "no_engine";
        r1 = "No TTS engine installed";
        r3.reject(r0, r1);
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.no_mad.tts.TextToSpeechModule.requestInstallData(com.facebook.react.bridge.Promise):void");
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        if (this.tts != null) {
            this.tts.stop();
            this.tts.shutdown();
        }
    }

    private boolean notReady(Promise promise) {
        if (this.ready == null) {
            promise.reject("not_ready", "TTS is not ready");
            return true;
        } else if (this.ready == Boolean.TRUE) {
            return null;
        } else {
            resolveReadyPromise(promise);
            return true;
        }
    }

    private int speak(String str, String str2, ReadableMap readableMap) {
        String string = readableMap.hasKey("KEY_PARAM_STREAM") ? readableMap.getString("KEY_PARAM_STREAM") : "";
        float f = readableMap.hasKey("KEY_PARAM_VOLUME") ? (float) readableMap.getDouble("KEY_PARAM_VOLUME") : 1.0f;
        readableMap = readableMap.hasKey("KEY_PARAM_PAN") ? (float) readableMap.getDouble("KEY_PARAM_PAN") : null;
        Object obj = -1;
        int i = 0;
        switch (string.hashCode()) {
            case -1192558710:
                if (string.equals("STREAM_VOICE_CALL")) {
                    obj = 6;
                    break;
                }
                break;
            case -1048950966:
                if (string.equals("STREAM_NOTIFICATION")) {
                    obj = 3;
                    break;
                }
                break;
            case -485436536:
                if (string.equals("STREAM_DTMF")) {
                    obj = 1;
                    break;
                }
                break;
            case -485030001:
                if (string.equals("STREAM_RING")) {
                    obj = 4;
                    break;
                }
                break;
            case 2081173454:
                if (string.equals("STREAM_SYSTEM")) {
                    obj = 5;
                    break;
                }
                break;
            case 2128316594:
                if (string.equals("STREAM_ALARM")) {
                    obj = null;
                    break;
                }
                break;
            case 2139683974:
                if (string.equals("STREAM_MUSIC")) {
                    obj = 2;
                    break;
                }
                break;
            default:
                break;
        }
        switch (obj) {
            case null:
                i = 4;
                break;
            case 1:
                i = 8;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 5;
                break;
            case 4:
                i = 2;
                break;
            case 5:
                i = 1;
                break;
            case 6:
                break;
            default:
                i = LinearLayoutManager.INVALID_OFFSET;
                break;
        }
        if (VERSION.SDK_INT >= 21) {
            Bundle bundle = new Bundle();
            bundle.putInt("streamType", i);
            bundle.putFloat("volume", f);
            bundle.putFloat("pan", readableMap);
            return this.tts.speak(str, 1, bundle, str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("utteranceId", str2);
        hashMap.put("streamType", String.valueOf(i));
        hashMap.put("volume", String.valueOf(f));
        hashMap.put("pan", String.valueOf(readableMap));
        return this.tts.speak(str, 1, hashMap);
    }

    private void sendEvent(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("utteranceId", str2);
        ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit(str, createMap);
    }
}
