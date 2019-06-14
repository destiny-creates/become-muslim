package versioned.host.exp.exponent.modules.api.components.maps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class ImageUtil {
    public static Bitmap convert(String str) {
        str = Base64.decode(str.substring(str.indexOf(",") + 1), 0);
        return BitmapFactory.decodeByteArray(str, 0, str.length);
    }

    public static String convert(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }
}
