package expo.modules.barcodescanner.scanners;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.p190g.C3052b;
import com.google.android.gms.p190g.p191a.C4421b;
import com.google.android.gms.p190g.p191a.C4421b.C3025a;
import com.google.android.gms.p190g.p191a.C4820a;
import expo.modules.barcodescanner.utils.FrameFactory;
import expo.p307b.p308a.C6019c;
import expo.p307b.p308a.C6020d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GMVBarCodeScanner extends ExpoBarCodeScanner {
    private String TAG = GMVBarCodeScanner.class.getSimpleName();
    private C4421b mBarcodeDetector = new C3025a(this.mContext).a(0).a();

    public GMVBarCodeScanner(Context context) {
        super(context);
    }

    public C6019c scan(byte[] bArr, int i, int i2, int i3) {
        try {
            bArr = scan(FrameFactory.buildFrame(bArr, i, i2, i3).getFrame());
            return bArr.size() > 0 ? (C6019c) bArr.get(0) : null;
        } catch (byte[] bArr2) {
            i = this.TAG;
            i2 = new StringBuilder();
            i2.append("Failed to detect barcode: ");
            i2.append(bArr2.getMessage());
            Log.e(i, i2.toString());
            return null;
        }
    }

    public List<C6019c> scanMultiple(Bitmap bitmap) {
        return scan(FrameFactory.buildFrame(bitmap).getFrame());
    }

    private List<C6019c> scan(C3052b c3052b) {
        try {
            c3052b = this.mBarcodeDetector.a(c3052b);
            List<C6019c> arrayList = new ArrayList();
            for (int i = 0; i < c3052b.size(); i++) {
                C4820a c4820a = (C4820a) c3052b.get(c3052b.keyAt(i));
                arrayList.add(new C6019c(c4820a.f13614a, c4820a.f13615b));
            }
            return arrayList;
        } catch (C3052b c3052b2) {
            String str = this.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to detect barcode: ");
            stringBuilder.append(c3052b2.getMessage());
            Log.e(str, stringBuilder.toString());
            return Collections.emptyList();
        }
    }

    public void setSettings(C6020d c6020d) {
        C6020d<Integer> parseBarCodeTypesFromSettings = parseBarCodeTypesFromSettings(c6020d);
        if (!areNewAndOldBarCodeTypesEqual(parseBarCodeTypesFromSettings)) {
            int i = 0;
            for (Integer intValue : parseBarCodeTypesFromSettings) {
                i |= intValue.intValue();
            }
            this.mBarCodeTypes = parseBarCodeTypesFromSettings;
            this.mBarcodeDetector = new C3025a(this.mContext).a(i).a();
        }
    }

    public boolean isAvailable() {
        return this.mBarcodeDetector.b();
    }
}
