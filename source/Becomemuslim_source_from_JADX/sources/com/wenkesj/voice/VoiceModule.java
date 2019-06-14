package com.wenkesj.voice;

import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.share.internal.ShareConstants;
import java.util.Locale;

public class VoiceModule extends ReactContextBaseJavaModule implements RecognitionListener {
    private boolean isRecognizing = false;
    private String locale = null;
    final ReactApplicationContext reactContext;
    private SpeechRecognizer speech = null;

    /* renamed from: com.wenkesj.voice.VoiceModule$1 */
    class C71971 implements PermissionListener {
        /* renamed from: a */
        final /* synthetic */ VoiceModule f25469a;

        C71971(VoiceModule voiceModule) {
            this.f25469a = voiceModule;
        }

        public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            boolean z = true;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                z = z && (iArr[i2] == 0 ? 1 : null) != null;
            }
            return z;
        }
    }

    public static String getErrorText(int i) {
        switch (i) {
            case 1:
                return "Network timeout";
            case 2:
                return "Network error";
            case 3:
                return "Audio recording error";
            case 4:
                return "error from server";
            case 5:
                return "Client side error";
            case 6:
                return "No speech input";
            case 7:
                return "No match";
            case 8:
                return "RecognitionService busy";
            case 9:
                return "Insufficient permissions";
            default:
                return "Didn't understand, please try again.";
        }
    }

    public String getName() {
        return "RCTVoice";
    }

    public void onEvent(int i, Bundle bundle) {
    }

    public VoiceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    private String getLocale(String str) {
        if (str == null || str.equals("")) {
            return Locale.getDefault().toString();
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startListening(com.facebook.react.bridge.ReadableMap r9) {
        /*
        r8 = this;
        r0 = r8.speech;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = r8.speech;
        r0.destroy();
        r0 = 0;
        r8.speech = r0;
    L_0x000c:
        r0 = r8.reactContext;
        r0 = android.speech.SpeechRecognizer.createSpeechRecognizer(r0);
        r8.speech = r0;
        r0 = r8.speech;
        r0.setRecognitionListener(r8);
        r0 = new android.content.Intent;
        r1 = "android.speech.action.RECOGNIZE_SPEECH";
        r0.<init>(r1);
        r1 = r9.keySetIterator();
    L_0x0024:
        r2 = r1.hasNextKey();
        if (r2 == 0) goto L_0x0114;
    L_0x002a:
        r2 = r1.nextKey();
        r3 = r2.hashCode();
        r4 = 1;
        r5 = 0;
        r6 = -1;
        switch(r3) {
            case -799376495: goto L_0x006b;
            case -530349781: goto L_0x0061;
            case -136377678: goto L_0x0057;
            case 1189324300: goto L_0x004d;
            case 1326635678: goto L_0x0043;
            case 2061034665: goto L_0x0039;
            default: goto L_0x0038;
        };
    L_0x0038:
        goto L_0x0075;
    L_0x0039:
        r3 = "EXTRA_PARTIAL_RESULTS";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0075;
    L_0x0041:
        r3 = 2;
        goto L_0x0076;
    L_0x0043:
        r3 = "EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0075;
    L_0x004b:
        r3 = 4;
        goto L_0x0076;
    L_0x004d:
        r3 = "EXTRA_MAX_RESULTS";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0075;
    L_0x0055:
        r3 = 1;
        goto L_0x0076;
    L_0x0057:
        r3 = "EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0075;
    L_0x005f:
        r3 = 5;
        goto L_0x0076;
    L_0x0061:
        r3 = "EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0075;
    L_0x0069:
        r3 = 3;
        goto L_0x0076;
    L_0x006b:
        r3 = "EXTRA_LANGUAGE_MODEL";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0075;
    L_0x0073:
        r3 = 0;
        goto L_0x0076;
    L_0x0075:
        r3 = -1;
    L_0x0076:
        switch(r3) {
            case 0: goto L_0x00cf;
            case 1: goto L_0x00bc;
            case 2: goto L_0x00b1;
            case 3: goto L_0x009e;
            case 4: goto L_0x008c;
            case 5: goto L_0x007a;
            default: goto L_0x0079;
        };
    L_0x0079:
        goto L_0x0024;
    L_0x007a:
        r2 = r9.getDouble(r2);
        r2 = java.lang.Double.valueOf(r2);
        r3 = "android.speech.extras.SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS";
        r2 = r2.intValue();
        r0.putExtra(r3, r2);
        goto L_0x0024;
    L_0x008c:
        r2 = r9.getDouble(r2);
        r2 = java.lang.Double.valueOf(r2);
        r3 = "android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS";
        r2 = r2.intValue();
        r0.putExtra(r3, r2);
        goto L_0x0024;
    L_0x009e:
        r2 = r9.getDouble(r2);
        r2 = java.lang.Double.valueOf(r2);
        r3 = "android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";
        r2 = r2.intValue();
        r0.putExtra(r3, r2);
        goto L_0x0024;
    L_0x00b1:
        r3 = "android.speech.extra.PARTIAL_RESULTS";
        r2 = r9.getBoolean(r2);
        r0.putExtra(r3, r2);
        goto L_0x0024;
    L_0x00bc:
        r2 = r9.getDouble(r2);
        r2 = java.lang.Double.valueOf(r2);
        r3 = "android.speech.extra.MAX_RESULTS";
        r2 = r2.intValue();
        r0.putExtra(r3, r2);
        goto L_0x0024;
    L_0x00cf:
        r2 = r9.getString(r2);
        r3 = r2.hashCode();
        r7 = -874741222; // 0xffffffffcbdc821a float:-2.8902452E7 double:NaN;
        if (r3 == r7) goto L_0x00eb;
    L_0x00dc:
        r5 = 1951040016; // 0x744a8210 float:6.4177365E31 double:9.639418456E-315;
        if (r3 == r5) goto L_0x00e2;
    L_0x00e1:
        goto L_0x00f5;
    L_0x00e2:
        r3 = "LANGUAGE_MODEL_WEB_SEARCH";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00f5;
    L_0x00ea:
        goto L_0x00f6;
    L_0x00eb:
        r3 = "LANGUAGE_MODEL_FREE_FORM";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00f5;
    L_0x00f3:
        r4 = 0;
        goto L_0x00f6;
    L_0x00f5:
        r4 = -1;
    L_0x00f6:
        switch(r4) {
            case 0: goto L_0x010b;
            case 1: goto L_0x0102;
            default: goto L_0x00f9;
        };
    L_0x00f9:
        r2 = "android.speech.extra.LANGUAGE_MODEL";
        r3 = "free_form";
        r0.putExtra(r2, r3);
        goto L_0x0024;
    L_0x0102:
        r2 = "android.speech.extra.LANGUAGE_MODEL";
        r3 = "web_search";
        r0.putExtra(r2, r3);
        goto L_0x0024;
    L_0x010b:
        r2 = "android.speech.extra.LANGUAGE_MODEL";
        r3 = "free_form";
        r0.putExtra(r2, r3);
        goto L_0x0024;
    L_0x0114:
        r9 = "android.speech.extra.LANGUAGE";
        r1 = r8.locale;
        r1 = r8.getLocale(r1);
        r0.putExtra(r9, r1);
        r9 = r8.speech;
        r9.startListening(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wenkesj.voice.VoiceModule.startListening(com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactMethod
    public void startSpeech(String str, final ReadableMap readableMap, final Callback callback) {
        if (isPermissionGranted() || !readableMap.getBoolean("REQUEST_PERMISSIONS_AUTO")) {
            this.locale = str;
            new Handler(this.reactContext.getMainLooper()).post(new Runnable(this) {
                /* renamed from: c */
                final /* synthetic */ VoiceModule f19492c;

                public void run() {
                    try {
                        this.f19492c.startListening(readableMap);
                        this.f19492c.isRecognizing = true;
                        callback.invoke(new Object[]{Boolean.valueOf(false)});
                    } catch (Exception e) {
                        callback.invoke(new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        str = new String[]{"android.permission.RECORD_AUDIO"};
        if (getCurrentActivity() != null) {
            ((PermissionAwareActivity) getCurrentActivity()).requestPermissions(str, 1, new C71971(this));
        }
    }

    @ReactMethod
    public void stopSpeech(final Callback callback) {
        new Handler(this.reactContext.getMainLooper()).post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ VoiceModule f19494b;

            public void run() {
                try {
                    this.f19494b.speech.stopListening();
                    this.f19494b.isRecognizing = false;
                    callback.invoke(new Object[]{Boolean.valueOf(false)});
                } catch (Exception e) {
                    callback.invoke(new Object[]{e.getMessage()});
                }
            }
        });
    }

    @ReactMethod
    public void cancelSpeech(final Callback callback) {
        new Handler(this.reactContext.getMainLooper()).post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ VoiceModule f19496b;

            public void run() {
                try {
                    this.f19496b.speech.cancel();
                    this.f19496b.isRecognizing = false;
                    callback.invoke(new Object[]{Boolean.valueOf(false)});
                } catch (Exception e) {
                    callback.invoke(new Object[]{e.getMessage()});
                }
            }
        });
    }

    @ReactMethod
    public void destroySpeech(final Callback callback) {
        new Handler(this.reactContext.getMainLooper()).post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ VoiceModule f19498b;

            public void run() {
                try {
                    this.f19498b.speech.destroy();
                    this.f19498b.speech = null;
                    this.f19498b.isRecognizing = false;
                    callback.invoke(new Object[]{Boolean.valueOf(false)});
                } catch (Exception e) {
                    callback.invoke(new Object[]{e.getMessage()});
                }
            }
        });
    }

    @ReactMethod
    public void isSpeechAvailable(final Callback callback) {
        new Handler(this.reactContext.getMainLooper()).post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ VoiceModule f19501c;

            public void run() {
                try {
                    Boolean valueOf = Boolean.valueOf(SpeechRecognizer.isRecognitionAvailable(this.reactContext));
                    callback.invoke(new Object[]{valueOf, Boolean.valueOf(false)});
                } catch (Exception e) {
                    callback.invoke(new Object[]{Boolean.valueOf(false), e.getMessage()});
                }
            }
        });
    }

    private boolean isPermissionGranted() {
        return getReactApplicationContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0;
    }

    @ReactMethod
    public void isRecognizing(Callback callback) {
        callback.invoke(new Object[]{Boolean.valueOf(this.isRecognizing)});
    }

    private void sendEvent(String str, WritableMap writableMap) {
        ((RCTDeviceEventEmitter) this.reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public void onBeginningOfSpeech() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("error", false);
        sendEvent("onSpeechStart", createMap);
        Log.d("ASR", "onBeginningOfSpeech()");
    }

    public void onBufferReceived(byte[] bArr) {
        bArr = Arguments.createMap();
        bArr.putBoolean("error", false);
        sendEvent("onSpeechRecognized", bArr);
        Log.d("ASR", "onBufferReceived()");
    }

    public void onEndOfSpeech() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("error", false);
        sendEvent("onSpeechEnd", createMap);
        Log.d("ASR", "onEndOfSpeech()");
        this.isRecognizing = false;
    }

    public void onError(int i) {
        i = String.format("%d/%s", new Object[]{Integer.valueOf(i), getErrorText(i)});
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, i);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("error", createMap);
        sendEvent("onSpeechError", createMap2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onError() - ");
        stringBuilder.append(i);
        Log.d("ASR", stringBuilder.toString());
    }

    public void onPartialResults(Bundle bundle) {
        WritableArray createArray = Arguments.createArray();
        bundle = bundle.getStringArrayList("results_recognition").iterator();
        while (bundle.hasNext()) {
            createArray.pushString((String) bundle.next());
        }
        bundle = Arguments.createMap();
        bundle.putArray("value", createArray);
        sendEvent("onSpeechPartialResults", bundle);
        Log.d("ASR", "onPartialResults()");
    }

    public void onReadyForSpeech(Bundle bundle) {
        bundle = Arguments.createMap();
        bundle.putBoolean("error", false);
        sendEvent("onSpeechStart", bundle);
        Log.d("ASR", "onReadyForSpeech()");
    }

    public void onResults(Bundle bundle) {
        WritableArray createArray = Arguments.createArray();
        bundle = bundle.getStringArrayList("results_recognition").iterator();
        while (bundle.hasNext()) {
            createArray.pushString((String) bundle.next());
        }
        bundle = Arguments.createMap();
        bundle.putArray("value", createArray);
        sendEvent("onSpeechResults", bundle);
        Log.d("ASR", "onResults()");
    }

    public void onRmsChanged(float f) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("value", (double) f);
        sendEvent("onSpeechVolumeChanged", createMap);
    }
}
