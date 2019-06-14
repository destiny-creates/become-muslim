package expo.modules.facedetector;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p311d.C6024a;
import expo.p307b.p311d.C6025b;
import java.util.Collections;
import java.util.List;

public class FaceDetectorProvider implements C5998e, C6025b {
    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C6025b.class);
    }

    public C6024a createFaceDetectorWithContext(Context context) {
        return new ExpoFaceDetector(context);
    }
}
