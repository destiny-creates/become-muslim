package expo.modules.barcodescanner.scanners;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import com.google.p217b.C5310i;
import com.google.p217b.C6892j;
import com.google.p217b.C6895m;
import com.google.p217b.C6896n;
import expo.p307b.p308a.C6019c;
import expo.p307b.p308a.C6020d;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZxingBarCodeScanner extends ExpoBarCodeScanner {
    private static final Map<C5193a, Integer> GMV_FROM_ZXING = Collections.unmodifiableMap(new C60722());
    private static final Map<Integer, String> VALID_BARCODE_TYPES = Collections.unmodifiableMap(new C60711());
    private final C6892j mMultiFormatReader = new C6892j();

    /* renamed from: expo.modules.barcodescanner.scanners.ZxingBarCodeScanner$1 */
    static class C60711 extends HashMap<Integer, String> {
        C60711() {
            put(Integer.valueOf(4096), C5193a.AZTEC.toString());
            put(Integer.valueOf(32), C5193a.EAN_13.toString());
            put(Integer.valueOf(64), C5193a.EAN_8.toString());
            put(Integer.valueOf(256), C5193a.QR_CODE.toString());
            put(Integer.valueOf(2048), C5193a.PDF_417.toString());
            put(Integer.valueOf(1024), C5193a.UPC_E.toString());
            put(Integer.valueOf(16), C5193a.DATA_MATRIX.toString());
            put(Integer.valueOf(2), C5193a.CODE_39.toString());
            put(Integer.valueOf(4), C5193a.CODE_93.toString());
            put(Integer.valueOf(128), C5193a.ITF.toString());
            put(Integer.valueOf(8), C5193a.CODABAR.toString());
            put(Integer.valueOf(1), C5193a.CODE_128.toString());
            put(Integer.valueOf(512), C5193a.UPC_A.toString());
        }
    }

    /* renamed from: expo.modules.barcodescanner.scanners.ZxingBarCodeScanner$2 */
    static class C60722 extends HashMap<C5193a, Integer> {
        C60722() {
            put(C5193a.AZTEC, Integer.valueOf(4096));
            put(C5193a.EAN_13, Integer.valueOf(32));
            put(C5193a.EAN_8, Integer.valueOf(64));
            put(C5193a.QR_CODE, Integer.valueOf(256));
            put(C5193a.PDF_417, Integer.valueOf(2048));
            put(C5193a.UPC_E, Integer.valueOf(1024));
            put(C5193a.DATA_MATRIX, Integer.valueOf(16));
            put(C5193a.CODE_39, Integer.valueOf(2));
            put(C5193a.CODE_93, Integer.valueOf(4));
            put(C5193a.ITF, Integer.valueOf(128));
            put(C5193a.CODABAR, Integer.valueOf(8));
            put(C5193a.CODE_128, Integer.valueOf(1));
            put(C5193a.UPC_A, Integer.valueOf(512));
        }
    }

    public boolean isAvailable() {
        return true;
    }

    public ZxingBarCodeScanner(Context context) {
        super(context);
    }

    public List<C6019c> scanMultiple(Bitmap bitmap) {
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        bitmap = scan(new C6896n(bitmap.getWidth(), bitmap.getHeight(), iArr));
        return bitmap == null ? Collections.emptyList() : Collections.singletonList(bitmap);
    }

    public C6019c scan(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            i3 = new byte[bArr.length];
            for (int i4 = 0; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    i3[(((i5 * i2) + i2) - i4) - 1] = bArr[(i4 * i) + i5];
                }
            }
            i += i2;
            i2 = i - i2;
            i -= i2;
            bArr = i3;
        }
        return scan(generateSourceFromImageData(bArr, i, i2));
    }

    private expo.p307b.p308a.C6019c scan(com.google.p217b.C5310i r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = new com.google.b.c;	 Catch:{ l -> 0x0016, Throwable -> 0x0012 }
        r2 = new com.google.b.b.j;	 Catch:{ l -> 0x0016, Throwable -> 0x0012 }
        r2.<init>(r4);	 Catch:{ l -> 0x0016, Throwable -> 0x0012 }
        r1.<init>(r2);	 Catch:{ l -> 0x0016, Throwable -> 0x0012 }
        r4 = r3.mMultiFormatReader;	 Catch:{ l -> 0x0016, Throwable -> 0x0012 }
        r4 = r4.m32345a(r1);	 Catch:{ l -> 0x0016, Throwable -> 0x0012 }
        goto L_0x0017;
    L_0x0012:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0016:
        r4 = r0;
    L_0x0017:
        if (r4 == 0) goto L_0x0032;
    L_0x0019:
        r0 = new expo.b.a.c;
        r1 = GMV_FROM_ZXING;
        r2 = r4.m22577d();
        r1 = r1.get(r2);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r4 = r4.m22571a();
        r0.<init>(r1, r4);
    L_0x0032:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.barcodescanner.scanners.ZxingBarCodeScanner.scan(com.google.b.i):expo.b.a.c");
    }

    public void setSettings(C6020d c6020d) {
        if (areNewAndOldBarCodeTypesEqual(parseBarCodeTypesFromSettings(c6020d)) == null) {
            Map enumMap = new EnumMap(C5254e.class);
            EnumSet noneOf = EnumSet.noneOf(C5193a.class);
            if (this.mBarCodeTypes != null) {
                for (Integer intValue : this.mBarCodeTypes) {
                    String str = (String) VALID_BARCODE_TYPES.get(Integer.valueOf(intValue.intValue()));
                    if (str != null) {
                        noneOf.add(C5193a.valueOf(str));
                    }
                }
            }
            enumMap.put(C5254e.POSSIBLE_FORMATS, noneOf);
            this.mMultiFormatReader.m32347a(enumMap);
        }
    }

    private C5310i generateSourceFromImageData(byte[] bArr, int i, int i2) {
        return new C6895m(bArr, i, i2, 0, 0, i, i2, false);
    }
}
