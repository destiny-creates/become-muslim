package expo.modules.facedetector;

import android.content.Context;
import android.os.Bundle;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.facedetector.tasks.FileFaceDetectionAsyncTask;
import expo.modules.facedetector.tasks.FileFaceDetectionCompletionListener;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FaceDetectorModule extends C6006c implements C6001h {
    private static final String DETECT_LANDMARKS_OPTION_KEY = "detectLandmarks";
    private static final String MODE_OPTION_KEY = "mode";
    private static final String RUN_CLASSIFICATIONS_OPTION_KEY = "runClassifications";
    private static final String TAG = "ExpoFaceDetector";
    private C6007d mModuleRegistry;

    /* renamed from: expo.modules.facedetector.FaceDetectorModule$1 */
    class C60911 extends HashMap<String, Object> {

        /* renamed from: expo.modules.facedetector.FaceDetectorModule$1$1 */
        class C60881 extends HashMap<String, Object> {
            C60881() {
                put("fast", Integer.valueOf(ExpoFaceDetector.FAST_MODE));
                put("accurate", Integer.valueOf(ExpoFaceDetector.ACCURATE_MODE));
            }
        }

        /* renamed from: expo.modules.facedetector.FaceDetectorModule$1$2 */
        class C60892 extends HashMap<String, Object> {
            C60892() {
                put("all", Integer.valueOf(ExpoFaceDetector.ALL_CLASSIFICATIONS));
                put(ViewProps.NONE, Integer.valueOf(ExpoFaceDetector.NO_CLASSIFICATIONS));
            }
        }

        /* renamed from: expo.modules.facedetector.FaceDetectorModule$1$3 */
        class C60903 extends HashMap<String, Object> {
            C60903() {
                put("all", Integer.valueOf(ExpoFaceDetector.ALL_LANDMARKS));
                put(ViewProps.NONE, Integer.valueOf(ExpoFaceDetector.NO_LANDMARKS));
            }
        }

        C60911() {
            put("Mode", getFaceDetectionModeConstants());
            put("Landmarks", getFaceDetectionLandmarksConstants());
            put("Classifications", getFaceDetectionClassificationsConstants());
        }

        private Map<String, Object> getFaceDetectionModeConstants() {
            return Collections.unmodifiableMap(new C60881());
        }

        private Map<String, Object> getFaceDetectionClassificationsConstants() {
            return Collections.unmodifiableMap(new C60892());
        }

        private Map<String, Object> getFaceDetectionLandmarksConstants() {
            return Collections.unmodifiableMap(new C60903());
        }
    }

    public String getName() {
        return TAG;
    }

    public FaceDetectorModule(Context context) {
        super(context);
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new C60911());
    }

    @C5996c
    public void detectFaces(HashMap<String, Object> hashMap, final C6009f c6009f) {
        new FileFaceDetectionAsyncTask(detectorForOptions(hashMap, getContext()), hashMap, new FileFaceDetectionCompletionListener() {
            public void resolve(Bundle bundle) {
                c6009f.mo5137a((Object) bundle);
            }

            public void reject(String str, String str2) {
                c6009f.mo5138a(str, str2, null);
            }
        }).execute(new Void[null]);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    private static ExpoFaceDetector detectorForOptions(HashMap<String, Object> hashMap, Context context) {
        ExpoFaceDetector expoFaceDetector = new ExpoFaceDetector(context);
        expoFaceDetector.setTrackingEnabled(null);
        if (hashMap.get(MODE_OPTION_KEY) != null) {
            expoFaceDetector.setMode(((Number) hashMap.get(MODE_OPTION_KEY)).intValue());
        }
        if (hashMap.get(RUN_CLASSIFICATIONS_OPTION_KEY) != null) {
            expoFaceDetector.setClassificationType(((Number) hashMap.get(RUN_CLASSIFICATIONS_OPTION_KEY)).intValue());
        }
        if (hashMap.get(DETECT_LANDMARKS_OPTION_KEY) != null) {
            expoFaceDetector.setLandmarkType(((Number) hashMap.get(DETECT_LANDMARKS_OPTION_KEY)).intValue());
        }
        return expoFaceDetector;
    }
}
