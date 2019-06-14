package expo.modules.facedetector;

import android.graphics.PointF;
import android.os.Bundle;
import com.google.android.gms.p190g.p192b.C3048a;
import com.google.android.gms.p190g.p192b.C3050c;

public class FaceDetectorUtils {
    private static final String[] landmarkNames = new String[]{"bottomMouthPosition", "leftCheekPosition", "leftEarPosition", "leftEarTipPosition", "leftEyePosition", "leftMouthPosition", "noseBasePosition", "rightCheekPosition", "rightEarPosition", "rightEarTipPosition", "rightEyePosition", "rightMouthPosition"};

    public static double valueMirroredHorizontally(double d, int i, double d2) {
        return (((double) i) - (d / d2)) * d2;
    }

    public static Bundle serializeFace(C3048a c3048a) {
        return serializeFace(c3048a, 1.0d, 1.0d);
    }

    public static Bundle serializeFace(C3048a c3048a, double d, double d2) {
        Bundle bundle = new Bundle();
        bundle.putInt("faceID", c3048a.j());
        bundle.putDouble("rollAngle", (double) c3048a.e());
        bundle.putDouble("yawAngle", (double) c3048a.d());
        if (c3048a.i() >= 0.0f) {
            bundle.putDouble("smilingProbability", (double) c3048a.i());
        }
        if (c3048a.g() >= 0.0f) {
            bundle.putDouble("leftEyeOpenProbability", (double) c3048a.g());
        }
        if (c3048a.h() >= 0.0f) {
            bundle.putDouble("rightEyeOpenProbability", (double) c3048a.h());
        }
        for (C3050c c3050c : c3048a.f()) {
            bundle.putBundle(landmarkNames[c3050c.b()], mapFromPoint(c3050c.a(), d, d2));
        }
        Bundle bundle2 = new Bundle(2);
        bundle2.putDouble("x", ((double) c3048a.a().x) * d);
        bundle2.putDouble("y", ((double) c3048a.a().y) * d2);
        Bundle bundle3 = new Bundle(2);
        bundle3.putDouble("width", ((double) c3048a.b()) * d);
        bundle3.putDouble("height", ((double) c3048a.c()) * d2);
        c3048a = new Bundle(2);
        c3048a.putBundle("origin", bundle2);
        c3048a.putBundle("size", bundle3);
        bundle.putBundle("bounds", c3048a);
        return bundle;
    }

    public static Bundle rotateFaceX(Bundle bundle, int i, double d) {
        Bundle bundle2 = bundle.getBundle("bounds");
        Bundle positionTranslatedHorizontally = positionTranslatedHorizontally(positionMirroredHorizontally(bundle2.getBundle("origin"), i, d), -bundle2.getBundle("size").getDouble("width"));
        Bundle bundle3 = new Bundle(bundle2);
        bundle3.putBundle("origin", positionTranslatedHorizontally);
        for (String str : landmarkNames) {
            Bundle bundle4 = bundle.getBundle(str);
            if (bundle4 != null) {
                bundle.putBundle(str, positionMirroredHorizontally(bundle4, i, d));
            }
        }
        bundle.putBundle("bounds", bundle3);
        return bundle;
    }

    public static Bundle changeAnglesDirection(Bundle bundle) {
        bundle.putDouble("rollAngle", ((-bundle.getDouble("rollAngle")) + 360.0d) % 360.0d);
        bundle.putDouble("yawAngle", ((-bundle.getDouble("yawAngle")) + 360.0d) % 360.0d);
        return bundle;
    }

    public static Bundle mapFromPoint(PointF pointF, double d, double d2) {
        Bundle bundle = new Bundle();
        bundle.putDouble("x", ((double) pointF.x) * d);
        bundle.putDouble("y", ((double) pointF.y) * d2);
        return bundle;
    }

    public static Bundle positionTranslatedHorizontally(Bundle bundle, double d) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putDouble("x", bundle.getDouble("x") + d);
        return bundle2;
    }

    public static Bundle positionMirroredHorizontally(Bundle bundle, int i, double d) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putDouble("x", valueMirroredHorizontally(bundle.getDouble("x"), i, d));
        return bundle2;
    }
}
