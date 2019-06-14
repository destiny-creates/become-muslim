package expo.modules.barcodescanner;

import android.content.Context;
import expo.p304a.C6006c;
import expo.p304a.C6012g;
import expo.p304a.C7369b;
import expo.p304a.p305a.C5998e;
import java.util.Collections;
import java.util.List;

public class BarCodeScannerPackage extends C7369b {
    public List<C5998e> createInternalModules(Context context) {
        return Collections.singletonList(new BarCodeScannerProvider());
    }

    public List<C6006c> createExportedModules(Context context) {
        return Collections.singletonList(new BarCodeScannerModule(context));
    }

    public List<C6012g> createViewManagers(Context context) {
        return Collections.singletonList(new BarCodeScannerViewManager());
    }
}
