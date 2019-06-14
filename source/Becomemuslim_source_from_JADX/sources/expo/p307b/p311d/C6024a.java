package expo.p307b.p311d;

import android.os.Bundle;
import java.util.List;
import java.util.Map;

/* compiled from: FaceDetector */
/* renamed from: expo.b.d.a */
public interface C6024a {
    List<Bundle> detectFaces(byte[] bArr, int i, int i2, int i3, int i4, double d, double d2);

    boolean isOperational();

    void release();

    void setSettings(Map<String, Object> map);
}
