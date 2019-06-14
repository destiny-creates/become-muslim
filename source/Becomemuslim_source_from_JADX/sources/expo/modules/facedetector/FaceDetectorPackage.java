package expo.modules.facedetector;

import android.content.Context;
import expo.p304a.C6006c;
import expo.p304a.C7369b;
import expo.p304a.p305a.C5998e;
import java.util.Collections;
import java.util.List;

public class FaceDetectorPackage extends C7369b {
    public List<C5998e> createInternalModules(Context context) {
        return Collections.singletonList(new FaceDetectorProvider());
    }

    public List<C6006c> createExportedModules(Context context) {
        return Collections.singletonList(new FaceDetectorModule(context));
    }
}
