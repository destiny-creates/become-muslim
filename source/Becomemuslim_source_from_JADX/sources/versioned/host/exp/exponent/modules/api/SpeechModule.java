package versioned.host.exp.exponent.modules.api;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.UtteranceProgressListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

public class SpeechModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private Queue<Map<String, Object>> mDelayedUtterances = new ArrayDeque();
    private TextToSpeech mTextToSpeech;
    private boolean mTtsReady = false;

    /* renamed from: versioned.host.exp.exponent.modules.api.SpeechModule$2 */
    class C67202 implements OnInitListener {

        /* renamed from: versioned.host.exp.exponent.modules.api.SpeechModule$2$1 */
        class C67191 extends UtteranceProgressListener {
            C67191() {
            }

            public void onStart(String str) {
                ((RCTDeviceEventEmitter) SpeechModule.this.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("Exponent.speakingStarted", SpeechModule.this.idToMap(str));
            }

            public void onDone(String str) {
                ((RCTDeviceEventEmitter) SpeechModule.this.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("Exponent.speakingDone", SpeechModule.this.idToMap(str));
            }

            public void onStop(String str, boolean z) {
                ((RCTDeviceEventEmitter) SpeechModule.this.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("Exponent.speakingStopped", SpeechModule.this.idToMap(str));
            }

            public void onError(String str) {
                ((RCTDeviceEventEmitter) SpeechModule.this.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("Exponent.speakingError", SpeechModule.this.idToMap(str));
            }
        }

        C67202() {
        }

        public void onInit(int i) {
            if (i == 0) {
                synchronized (SpeechModule.this) {
                    SpeechModule.this.mTtsReady = true;
                    SpeechModule.this.mTextToSpeech.setOnUtteranceProgressListener(new C67191());
                    for (Map map : SpeechModule.this.mDelayedUtterances) {
                        SpeechModule.this.speakOut((String) map.get("id"), (String) map.get("text"), (ReadableMap) map.get("options"));
                    }
                }
            }
        }
    }

    public String getName() {
        return "ExponentSpeech";
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public SpeechModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @ReactMethod
    public void speak(final String str, final String str2, final ReadableMap readableMap) {
        if (this.mTtsReady) {
            speakOut(str, str2, readableMap);
            return;
        }
        this.mDelayedUtterances.add(Collections.unmodifiableMap(new HashMap<String, Object>() {
        }));
        getTextToSpeech();
    }

    private void speakOut(String str, String str2, ReadableMap readableMap) {
        TextToSpeech textToSpeech = getTextToSpeech();
        if (readableMap.hasKey("language")) {
            Locale locale = new Locale(readableMap.getString("language"));
            int isLanguageAvailable = textToSpeech.isLanguageAvailable(locale);
            if (isLanguageAvailable == -1 || isLanguageAvailable == -2) {
                textToSpeech.setLanguage(Locale.getDefault());
            } else {
                textToSpeech.setLanguage(locale);
            }
        } else {
            textToSpeech.setLanguage(Locale.getDefault());
        }
        if (readableMap.hasKey("pitch")) {
            textToSpeech.setPitch((float) readableMap.getDouble("pitch"));
        }
        if (readableMap.hasKey("rate")) {
            textToSpeech.setSpeechRate((float) readableMap.getDouble("rate"));
        }
        textToSpeech.speak(str2, 1, null, str);
    }

    @ReactMethod
    public void isSpeaking(Promise promise) {
        promise.resolve(Boolean.valueOf(getTextToSpeech().isSpeaking()));
    }

    @ReactMethod
    public void stop() {
        getTextToSpeech().stop();
    }

    private TextToSpeech getTextToSpeech() {
        if (this.mTextToSpeech == null) {
            this.mTextToSpeech = new TextToSpeech(getReactApplicationContext(), new C67202());
        }
        return this.mTextToSpeech;
    }

    public void onHostDestroy() {
        getTextToSpeech().shutdown();
    }

    private WritableMap idToMap(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", str);
        return createMap;
    }
}
