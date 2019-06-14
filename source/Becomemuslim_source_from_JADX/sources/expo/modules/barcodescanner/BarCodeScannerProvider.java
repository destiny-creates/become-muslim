package expo.modules.barcodescanner;

import android.content.Context;
import expo.modules.barcodescanner.scanners.GMVBarCodeScanner;
import expo.modules.barcodescanner.scanners.ZxingBarCodeScanner;
import expo.p304a.p305a.C5998e;
import expo.p307b.p308a.C6017a;
import expo.p307b.p308a.C6018b;
import java.util.Collections;
import java.util.List;

public class BarCodeScannerProvider implements C5998e, C6018b {
    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C6018b.class);
    }

    public C6017a createBarCodeDetectorWithContext(Context context) {
        C6017a gMVBarCodeScanner = new GMVBarCodeScanner(context);
        return !gMVBarCodeScanner.isAvailable() ? new ZxingBarCodeScanner(context) : gMVBarCodeScanner;
    }
}
