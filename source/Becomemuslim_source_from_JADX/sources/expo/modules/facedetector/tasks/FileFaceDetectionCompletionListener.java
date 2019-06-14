package expo.modules.facedetector.tasks;

import android.os.Bundle;

public interface FileFaceDetectionCompletionListener {
    void reject(String str, String str2);

    void resolve(Bundle bundle);
}
