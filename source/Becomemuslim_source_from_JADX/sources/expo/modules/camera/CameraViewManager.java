package expo.modules.camera;

import android.content.Context;
import com.google.android.p133a.C2186a;
import com.google.android.p133a.C2210k;
import expo.p304a.C6007d;
import expo.p304a.C6012g;
import expo.p304a.C6012g.C6011b;
import expo.p304a.p305a.C5997d;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;
import expo.p307b.p308a.C6020d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CameraViewManager extends C6012g<ExpoCameraView> implements C6001h {
    private static final String REACT_CLASS = "ExponentCamera";
    private C6007d mModuleRegistry;

    public enum Events {
        EVENT_CAMERA_READY("onCameraReady"),
        EVENT_ON_MOUNT_ERROR("onMountError"),
        EVENT_ON_BAR_CODE_SCANNED("onBarCodeScanned"),
        EVENT_ON_FACES_DETECTED("onFacesDetected"),
        EVENT_ON_FACE_DETECTION_ERROR("onFaceDetectionError"),
        EVENT_ON_PICTURE_SAVED("onPictureSaved");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    public void onDropViewInstance(ExpoCameraView expoCameraView) {
        ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).unregisterLifecycleEventListener(expoCameraView);
        expoCameraView.stop();
    }

    public C6011b getViewManagerType() {
        return C6011b.GROUP;
    }

    public ExpoCameraView createViewInstance(Context context) {
        return new ExpoCameraView(context, this.mModuleRegistry);
    }

    public List<String> getExportedEventNames() {
        List<String> arrayList = new ArrayList(Events.values().length);
        for (Events events : Events.values()) {
            arrayList.add(events.toString());
        }
        return arrayList;
    }

    @C5997d(a = "type")
    public void setType(ExpoCameraView expoCameraView, int i) {
        expoCameraView.setFacing(i);
    }

    @C5997d(a = "ratio")
    public void setRatio(ExpoCameraView expoCameraView, String str) {
        expoCameraView.setAspectRatio(C2186a.a(str));
    }

    @C5997d(a = "flashMode")
    public void setFlashMode(ExpoCameraView expoCameraView, int i) {
        expoCameraView.setFlash(i);
    }

    @C5997d(a = "autoFocus")
    public void setAutoFocus(ExpoCameraView expoCameraView, boolean z) {
        expoCameraView.setAutoFocus(z);
    }

    @C5997d(a = "focusDepth")
    public void setFocusDepth(ExpoCameraView expoCameraView, float f) {
        expoCameraView.setFocusDepth(f);
    }

    @C5997d(a = "zoom")
    public void setZoom(ExpoCameraView expoCameraView, float f) {
        expoCameraView.setZoom(f);
    }

    @C5997d(a = "whiteBalance")
    public void setWhiteBalance(ExpoCameraView expoCameraView, int i) {
        expoCameraView.setWhiteBalance(i);
    }

    @C5997d(a = "pictureSize")
    public void setPictureSize(ExpoCameraView expoCameraView, String str) {
        expoCameraView.setPictureSize(C2210k.a(str));
    }

    @C5997d(a = "barCodeScannerSettings")
    public void setBarCodeScannerSettings(ExpoCameraView expoCameraView, Map<String, Object> map) {
        expoCameraView.setBarCodeScannerSettings(new C6020d(map));
    }

    @C5997d(a = "useCamera2Api")
    public void setUseCamera2Api(ExpoCameraView expoCameraView, boolean z) {
        expoCameraView.setUsingCamera2Api(z);
    }

    @C5997d(a = "barCodeScannerEnabled")
    public void setBarCodeScanning(ExpoCameraView expoCameraView, boolean z) {
        expoCameraView.setShouldScanBarCodes(z);
    }

    @C5997d(a = "faceDetectorEnabled")
    public void setFaceDetectorEnabled(ExpoCameraView expoCameraView, boolean z) {
        expoCameraView.setShouldDetectFaces(z);
    }

    @C5997d(a = "faceDetectorSettings")
    public void setFaceDetectorSettings(ExpoCameraView expoCameraView, Map<String, Object> map) {
        expoCameraView.setFaceDetectorSettings(map);
    }
}
