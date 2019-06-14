package expo.p307b.p308a;

import android.graphics.Bitmap;
import java.util.List;

/* compiled from: BarCodeScanner */
/* renamed from: expo.b.a.a */
public interface C6017a {
    C6019c scan(byte[] bArr, int i, int i2, int i3);

    List<C6019c> scanMultiple(Bitmap bitmap);

    void setSettings(C6020d c6020d);
}
