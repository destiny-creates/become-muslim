package expo.modules.barcodescanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p307b.p308a.C6017a;
import expo.p307b.p308a.C6019c;
import expo.p307b.p308a.C6020d;
import expo.p307b.p314g.C6030a;
import expo.p307b.p314g.C6030a.C6029a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BarCodeScannerModule extends C6006c implements C6001h {
    private static final String ERROR_TAG = "E_BARCODE_SCANNER";
    private static final String TAG = "ExpoBarCodeScannerModule";
    private static final Map<String, Object> VALID_BARCODE_TYPES = Collections.unmodifiableMap(new C60641());
    private final BarCodeScannerProvider mBarCodeScannerProvider = new BarCodeScannerProvider();
    private C6007d mModuleRegistry;

    /* renamed from: expo.modules.barcodescanner.BarCodeScannerModule$1 */
    static class C60641 extends HashMap<String, Object> {
        C60641() {
            put("aztec", Integer.valueOf(4096));
            put("ean13", Integer.valueOf(32));
            put("ean8", Integer.valueOf(64));
            put("qr", Integer.valueOf(256));
            put("pdf417", Integer.valueOf(2048));
            put("upc_e", Integer.valueOf(1024));
            put("datamatrix", Integer.valueOf(16));
            put("code39", Integer.valueOf(2));
            put("code93", Integer.valueOf(4));
            put("itf14", Integer.valueOf(128));
            put("codabar", Integer.valueOf(8));
            put("code128", Integer.valueOf(1));
            put("upc_a", Integer.valueOf(512));
        }
    }

    /* renamed from: expo.modules.barcodescanner.BarCodeScannerModule$2 */
    class C60662 extends HashMap<String, Object> {

        /* renamed from: expo.modules.barcodescanner.BarCodeScannerModule$2$1 */
        class C60651 extends HashMap<String, Object> {
            C60651() {
                put("front", Integer.valueOf(1));
                put("back", Integer.valueOf(2));
            }
        }

        C60662() {
            put("BarCodeType", getBarCodeConstants());
            put("Type", getTypeConstants());
        }

        private Map<String, Object> getBarCodeConstants() {
            return BarCodeScannerModule.VALID_BARCODE_TYPES;
        }

        private Map<String, Object> getTypeConstants() {
            return Collections.unmodifiableMap(new C60651());
        }
    }

    public String getName() {
        return TAG;
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    public BarCodeScannerModule(Context context) {
        super(context);
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new C60662());
    }

    @C5996c
    public void scanFromURLAsync(final String str, List<Double> list, final C6009f c6009f) {
        final List arrayList = new ArrayList();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(Integer.valueOf(((Double) list.get(i)).intValue()));
            }
        }
        ((C6030a) this.mModuleRegistry.m25133a(C6030a.class)).loadImageFromURL(str, new C6029a() {

            /* renamed from: expo.modules.barcodescanner.BarCodeScannerModule$3$1 */
            class C73971 extends C6020d {
                C73971() {
                    putTypes(arrayList);
                }
            }

            public void onSuccess(Bitmap bitmap) {
                C6017a createBarCodeDetectorWithContext = BarCodeScannerModule.this.mBarCodeScannerProvider.createBarCodeDetectorWithContext(BarCodeScannerModule.this.getContext());
                createBarCodeDetectorWithContext.setSettings(new C73971());
                Bitmap<C6019c> scanMultiple = createBarCodeDetectorWithContext.scanMultiple(bitmap);
                Object arrayList = new ArrayList();
                for (C6019c c6019c : scanMultiple) {
                    Bundle bundle = new Bundle();
                    bundle.putString("data", c6019c.m25164b());
                    bundle.putInt("type", c6019c.m25163a());
                    arrayList.add(bundle);
                }
                c6009f.mo5137a(arrayList);
            }

            public void onFailure(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not get the image from given url: '");
                stringBuilder.append(str);
                stringBuilder.append("'");
                c6009f.mo5138a("E_BARCODE_SCANNER_IMAGE_RETRIEVAL_ERROR", stringBuilder.toString(), th);
            }
        });
    }
}
