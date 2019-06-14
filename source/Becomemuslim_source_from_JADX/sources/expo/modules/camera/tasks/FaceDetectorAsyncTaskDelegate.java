package expo.modules.camera.tasks;

import android.os.Bundle;
import expo.p307b.p311d.C6024a;
import java.util.List;

public interface FaceDetectorAsyncTaskDelegate {
    void onFaceDetectingTaskCompleted();

    void onFaceDetectionError(C6024a c6024a);

    void onFacesDetected(List<Bundle> list);
}
