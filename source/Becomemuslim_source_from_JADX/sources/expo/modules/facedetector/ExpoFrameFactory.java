package expo.modules.facedetector;

import android.graphics.Bitmap;
import com.google.android.gms.p190g.C3052b.C3041a;
import java.nio.ByteBuffer;

public class ExpoFrameFactory {
    public static ExpoFrame buildFrame(byte[] bArr, int i, int i2, int i3) {
        C3041a c3041a = new C3041a();
        c3041a.a(ByteBuffer.wrap(bArr), i, i2, 17);
        if (i3 == 90) {
            c3041a.a(1);
        } else if (i3 == 180) {
            c3041a.a(2);
        } else if (i3 != 270) {
            c3041a.a(null);
        } else {
            c3041a.a(3);
        }
        return new ExpoFrame(c3041a.a(), new ImageDimensions(i, i2, i3));
    }

    public static ExpoFrame buildFrame(Bitmap bitmap) {
        C3041a c3041a = new C3041a();
        c3041a.a(bitmap);
        return new ExpoFrame(c3041a.a(), new ImageDimensions(bitmap.getWidth(), bitmap.getHeight()));
    }
}
