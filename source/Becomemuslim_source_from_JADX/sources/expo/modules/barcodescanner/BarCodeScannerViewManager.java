package expo.modules.barcodescanner;

import android.content.Context;
import expo.p304a.C6007d;
import expo.p304a.C6012g;
import expo.p304a.C6012g.C6011b;
import expo.p304a.p305a.C5997d;
import expo.p304a.p305a.C6001h;
import expo.p307b.p308a.C6020d;
import java.util.ArrayList;
import java.util.List;

public class BarCodeScannerViewManager extends C6012g<BarCodeScannerView> implements C6001h {
    private static final String TAG = "ExpoBarCodeScannerView";
    private C6007d mModuleRegistry;

    public enum Events {
        EVENT_ON_BAR_CODE_SCANNED("onBarCodeScanned");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public String getName() {
        return TAG;
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    public BarCodeScannerView createViewInstance(Context context) {
        return new BarCodeScannerView(context, this.mModuleRegistry);
    }

    public C6011b getViewManagerType() {
        return C6011b.GROUP;
    }

    public List<String> getExportedEventNames() {
        List<String> arrayList = new ArrayList(Events.values().length);
        for (Events events : Events.values()) {
            arrayList.add(events.toString());
        }
        return arrayList;
    }

    @C5997d(a = "type")
    public void setType(BarCodeScannerView barCodeScannerView, int i) {
        barCodeScannerView.setCameraType(i);
    }

    @C5997d(a = "barCodeTypes")
    public void setBarCodeTypes(BarCodeScannerView barCodeScannerView, final ArrayList<Double> arrayList) {
        if (arrayList != null) {
            barCodeScannerView.setBarCodeScannerSettings(new C6020d() {
            });
        }
    }
}
