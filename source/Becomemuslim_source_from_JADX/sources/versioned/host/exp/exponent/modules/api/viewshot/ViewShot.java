package versioned.host.exp.exponent.modules.api.viewshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Base64;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.UIBlock;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.zip.Deflater;

public class ViewShot implements UIBlock {
    private static final int ARGB_SIZE = 4;
    static final String ERROR_UNABLE_TO_SNAPSHOT = "E_UNABLE_TO_SNAPSHOT";
    private static final int PREALLOCATE_SIZE = 65536;
    private static final Object guardBitmaps = new Object();
    private static byte[] outputBuffer = new byte[65536];
    private static final Set<Bitmap> weakBitmaps = Collections.newSetFromMap(new WeakHashMap());
    private final Activity currentActivity;
    private final String extension;
    private final int format;
    private final Integer height;
    private final File output;
    private final Promise promise;
    private final double quality;
    private final ReactApplicationContext reactContext;
    private final String result;
    private final Boolean snapshotContentContainer;
    private final int tag;
    private final Integer width;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Formats {
        public static final int JPEG = 0;
        public static final int PNG = 1;
        public static final int RAW = -1;
        public static final int WEBP = 2;
        public static final CompressFormat[] mapping = new CompressFormat[]{CompressFormat.JPEG, CompressFormat.PNG, CompressFormat.WEBP};
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Results {
        public static final String BASE_64 = "base64";
        public static final String DATA_URI = "data-uri";
        public static final String TEMP_FILE = "tmpfile";
        public static final String ZIP_BASE_64 = "zip-base64";
    }

    public static class ReusableByteArrayOutputStream extends ByteArrayOutputStream {
        private static final int MAX_ARRAY_SIZE = 2147483639;

        public ReusableByteArrayOutputStream(byte[] bArr) {
            super(0);
            this.buf = bArr;
        }

        public byte[] innerBuffer() {
            return this.buf;
        }

        public ByteBuffer asBuffer(int i) {
            if (this.buf.length < i) {
                grow(i);
            }
            return ByteBuffer.wrap(this.buf);
        }

        public void setSize(int i) {
            this.count = i;
        }

        protected void grow(int i) {
            int length = this.buf.length << 1;
            if (length - i < 0) {
                length = i;
            }
            if (length - MAX_ARRAY_SIZE > 0) {
                length = hugeCapacity(i);
            }
            this.buf = Arrays.copyOf(this.buf, length);
        }

        protected static int hugeCapacity(int i) {
            if (i >= 0) {
                return i > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
            } else {
                throw new OutOfMemoryError();
            }
        }
    }

    private static <T extends A, A> T cast(A a) {
        return a;
    }

    public ViewShot(int i, String str, int i2, double d, Integer num, Integer num2, File file, String str2, Boolean bool, ReactApplicationContext reactApplicationContext, Activity activity, Promise promise) {
        this.tag = i;
        this.extension = str;
        this.format = i2;
        this.quality = d;
        this.width = num;
        this.height = num2;
        this.output = file;
        this.result = str2;
        this.snapshotContentContainer = bool;
        this.reactContext = reactApplicationContext;
        this.currentActivity = activity;
        this.promise = promise;
    }

    public void execute(com.facebook.react.uimanager.NativeViewHierarchyManager r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.tag;
        r1 = -1;
        if (r0 != r1) goto L_0x0017;
    L_0x0005:
        r4 = r3.currentActivity;
        r4 = r4.getWindow();
        r4 = r4.getDecorView();
        r0 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;
        r4 = r4.findViewById(r0);
        goto L_0x001d;
    L_0x0017:
        r0 = r3.tag;
        r4 = r4.resolveView(r0);
    L_0x001d:
        if (r4 != 0) goto L_0x003a;
    L_0x001f:
        r4 = r3.promise;
        r0 = "E_UNABLE_TO_SNAPSHOT";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No view found with reactTag: ";
        r1.append(r2);
        r2 = r3.tag;
        r1.append(r2);
        r1 = r1.toString();
        r4.reject(r0, r1);
        return;
    L_0x003a:
        r0 = new versioned.host.exp.exponent.modules.api.viewshot.ViewShot$ReusableByteArrayOutputStream;	 Catch:{ Throwable -> 0x0099 }
        r2 = outputBuffer;	 Catch:{ Throwable -> 0x0099 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0099 }
        r2 = proposeSize(r4);	 Catch:{ Throwable -> 0x0099 }
        r0.setSize(r2);	 Catch:{ Throwable -> 0x0099 }
        r0 = r0.innerBuffer();	 Catch:{ Throwable -> 0x0099 }
        outputBuffer = r0;	 Catch:{ Throwable -> 0x0099 }
        r0 = "tmpfile";	 Catch:{ Throwable -> 0x0099 }
        r2 = r3.result;	 Catch:{ Throwable -> 0x0099 }
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x0099 }
        if (r0 == 0) goto L_0x0060;	 Catch:{ Throwable -> 0x0099 }
    L_0x0058:
        r0 = r3.format;	 Catch:{ Throwable -> 0x0099 }
        if (r1 != r0) goto L_0x0060;	 Catch:{ Throwable -> 0x0099 }
    L_0x005c:
        r3.saveToRawFileOnDevice(r4);	 Catch:{ Throwable -> 0x0099 }
        goto L_0x00a2;	 Catch:{ Throwable -> 0x0099 }
    L_0x0060:
        r0 = "tmpfile";	 Catch:{ Throwable -> 0x0099 }
        r2 = r3.result;	 Catch:{ Throwable -> 0x0099 }
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x0099 }
        if (r0 == 0) goto L_0x0072;	 Catch:{ Throwable -> 0x0099 }
    L_0x006a:
        r0 = r3.format;	 Catch:{ Throwable -> 0x0099 }
        if (r1 == r0) goto L_0x0072;	 Catch:{ Throwable -> 0x0099 }
    L_0x006e:
        r3.saveToTempFileOnDevice(r4);	 Catch:{ Throwable -> 0x0099 }
        goto L_0x00a2;	 Catch:{ Throwable -> 0x0099 }
    L_0x0072:
        r0 = "base64";	 Catch:{ Throwable -> 0x0099 }
        r1 = r3.result;	 Catch:{ Throwable -> 0x0099 }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x0099 }
        if (r0 != 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0099 }
    L_0x007c:
        r0 = "zip-base64";	 Catch:{ Throwable -> 0x0099 }
        r1 = r3.result;	 Catch:{ Throwable -> 0x0099 }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x0099 }
        if (r0 == 0) goto L_0x0087;	 Catch:{ Throwable -> 0x0099 }
    L_0x0086:
        goto L_0x0095;	 Catch:{ Throwable -> 0x0099 }
    L_0x0087:
        r0 = "data-uri";	 Catch:{ Throwable -> 0x0099 }
        r1 = r3.result;	 Catch:{ Throwable -> 0x0099 }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x0099 }
        if (r0 == 0) goto L_0x00a2;	 Catch:{ Throwable -> 0x0099 }
    L_0x0091:
        r3.saveToDataUriString(r4);	 Catch:{ Throwable -> 0x0099 }
        goto L_0x00a2;	 Catch:{ Throwable -> 0x0099 }
    L_0x0095:
        r3.saveToBase64String(r4);	 Catch:{ Throwable -> 0x0099 }
        goto L_0x00a2;
    L_0x0099:
        r4 = r3.promise;
        r0 = "E_UNABLE_TO_SNAPSHOT";
        r1 = "Failed to capture view snapshot";
        r4.reject(r0, r1);
    L_0x00a2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.viewshot.ViewShot.execute(com.facebook.react.uimanager.NativeViewHierarchyManager):void");
    }

    private void saveToTempFileOnDevice(View view) {
        captureView(view, new FileOutputStream(this.output));
        this.promise.resolve(Uri.fromFile(this.output).toString());
    }

    private void saveToRawFileOnDevice(View view) {
        String uri = Uri.fromFile(this.output).toString();
        FileOutputStream fileOutputStream = new FileOutputStream(this.output);
        OutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(outputBuffer);
        view = captureView(view, reusableByteArrayOutputStream);
        outputBuffer = reusableByteArrayOutputStream.innerBuffer();
        int size = reusableByteArrayOutputStream.size();
        fileOutputStream.write(String.format(Locale.US, "%d:%d|", new Object[]{Integer.valueOf(view.x), Integer.valueOf(view.y)}).getBytes(Charset.forName("US-ASCII")));
        fileOutputStream.write(outputBuffer, 0, size);
        fileOutputStream.close();
        this.promise.resolve(uri);
    }

    private void saveToDataUriString(View view) {
        OutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(outputBuffer);
        captureView(view, reusableByteArrayOutputStream);
        outputBuffer = reusableByteArrayOutputStream.innerBuffer();
        view = Base64.encodeToString(outputBuffer, 0, reusableByteArrayOutputStream.size(), 2);
        String str = "jpg".equals(this.extension) ? "jpeg" : this.extension;
        Promise promise = this.promise;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("data:image/");
        stringBuilder.append(str);
        stringBuilder.append(";base64,");
        stringBuilder.append(view);
        promise.resolve(stringBuilder.toString());
    }

    private void saveToBase64String(View view) {
        Object obj = -1 == this.format ? 1 : null;
        boolean equals = Results.ZIP_BASE_64.equals(this.result);
        OutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(outputBuffer);
        view = captureView(view, reusableByteArrayOutputStream);
        outputBuffer = reusableByteArrayOutputStream.innerBuffer();
        int size = reusableByteArrayOutputStream.size();
        view = String.format(Locale.US, "%d:%d|", new Object[]{Integer.valueOf(view.x), Integer.valueOf(view.y)});
        if (obj == null) {
            view = "";
        }
        StringBuilder stringBuilder;
        if (equals) {
            Deflater deflater = new Deflater();
            deflater.setInput(outputBuffer, 0, size);
            deflater.finish();
            ReusableByteArrayOutputStream reusableByteArrayOutputStream2 = new ReusableByteArrayOutputStream(new byte[32]);
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                reusableByteArrayOutputStream2.write(bArr, 0, deflater.deflate(bArr));
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(view);
            stringBuilder.append(Base64.encodeToString(reusableByteArrayOutputStream2.innerBuffer(), 0, reusableByteArrayOutputStream2.size(), 2));
            view = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(view);
            stringBuilder.append(Base64.encodeToString(outputBuffer, 0, size, 2));
            view = stringBuilder.toString();
        }
        this.promise.resolve(view);
    }

    private List<View> getAllChildren(View view) {
        List arrayList;
        if (view instanceof ViewGroup) {
            arrayList = new ArrayList();
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(getAllChildren(viewGroup.getChildAt(i)));
            }
            return arrayList;
        }
        arrayList = new ArrayList();
        arrayList.add(view);
        return arrayList;
    }

    private Point captureView(View view, OutputStream outputStream) {
        try {
            view = captureViewImpl(view, outputStream);
            return view;
        } finally {
            outputStream.close();
        }
    }

    private Point captureViewImpl(View view, OutputStream outputStream) {
        ViewShot viewShot = this;
        View view2 = view;
        OutputStream outputStream2 = outputStream;
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Impossible to snapshot the view: view is invalid");
        }
        Point point;
        Bitmap bitmap;
        boolean z = false;
        if (viewShot.snapshotContentContainer.booleanValue()) {
            ScrollView scrollView = (ScrollView) view2;
            int i = 0;
            for (int i2 = 0; i2 < scrollView.getChildCount(); i2++) {
                i += scrollView.getChildAt(i2).getHeight();
            }
            height = i;
        }
        Point point2 = new Point(width, height);
        Bitmap bitmapForScreenshot = getBitmapForScreenshot(width, height);
        Canvas canvas = new Canvas(bitmapForScreenshot);
        view2.draw(canvas);
        Iterator it = getAllChildren(view).iterator();
        while (it.hasNext()) {
            View view3 = (View) it.next();
            if (view3 instanceof TextureView) {
                if (view3.getVisibility() == 0) {
                    TextureView textureView = (TextureView) view3;
                    textureView.setOpaque(z);
                    Point parentOffsets = getParentOffsets(view2, view3);
                    int left = (view3.getLeft() + view3.getPaddingLeft()) + parentOffsets.x;
                    int top = (view3.getTop() + view3.getPaddingTop()) + parentOffsets.y;
                    int width2 = view3.getWidth();
                    int height2 = view3.getHeight();
                    Iterator it2 = it;
                    Rect rect = new Rect(z, z, width2, height2);
                    point = point2;
                    RectF rectF = new RectF((float) left, (float) top, (float) (left + width2), (float) (top + height2));
                    Bitmap bitmap2 = textureView.getBitmap(getBitmapForScreenshot(view3.getWidth(), view3.getHeight()));
                    canvas.save();
                    canvas.setMatrix(concatMatrix(view2, view3));
                    canvas.drawBitmap(bitmap2, rect, rectF, null);
                    canvas.restore();
                    recycleBitmap(bitmap2);
                    it = it2;
                    point2 = point;
                    outputStream2 = outputStream;
                    z = false;
                }
            }
        }
        point = point2;
        if (viewShot.width == null || viewShot.height == null || (viewShot.width.intValue() == width && viewShot.height.intValue() == height)) {
            bitmap = bitmapForScreenshot;
        } else {
            bitmap = Bitmap.createScaledBitmap(bitmapForScreenshot, viewShot.width.intValue(), viewShot.height.intValue(), true);
            recycleBitmap(bitmapForScreenshot);
        }
        if (-1 == viewShot.format) {
            outputStream2 = outputStream;
            if (outputStream2 instanceof ReusableByteArrayOutputStream) {
                width = (width * height) * 4;
                ReusableByteArrayOutputStream reusableByteArrayOutputStream = (ReusableByteArrayOutputStream) cast(outputStream);
                bitmap.copyPixelsToBuffer(reusableByteArrayOutputStream.asBuffer(width));
                reusableByteArrayOutputStream.setSize(width);
                recycleBitmap(bitmap);
                return point;
            }
        }
        outputStream2 = outputStream;
        bitmap.compress(Formats.mapping[viewShot.format], (int) (viewShot.quality * 100.0d), outputStream2);
        recycleBitmap(bitmap);
        return point;
    }

    private Matrix concatMatrix(View view, View view2) {
        Matrix matrix = new Matrix();
        do {
            matrix.preConcat(view2.getMatrix());
            view2 = (View) view2.getParent();
        } while (view2 != view);
        return matrix;
    }

    private Point getParentOffsets(View view, View view2) {
        int i = 0;
        int i2 = 0;
        for (view2 = (View) view2.getParent(); view2 != null; view2 = (View) view2.getParent()) {
            if (view2 == view) {
                break;
            }
            i += view2.getLeft();
            i2 += view2.getTop();
        }
        return new Point(i, i2);
    }

    private static int proposeSize(View view) {
        return Math.min((view.getWidth() * view.getHeight()) * 4, 32);
    }

    private static void recycleBitmap(Bitmap bitmap) {
        synchronized (guardBitmaps) {
            weakBitmaps.add(bitmap);
        }
    }

    private static Bitmap getBitmapForScreenshot(int i, int i2) {
        synchronized (guardBitmaps) {
            for (Bitmap bitmap : weakBitmaps) {
                if (bitmap.getWidth() * bitmap.getHeight() <= i * i2) {
                    weakBitmaps.remove(bitmap);
                    bitmap.eraseColor(0);
                    return bitmap;
                }
            }
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
    }
}
