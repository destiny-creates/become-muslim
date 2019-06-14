package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;

public abstract class PlatformBitmapFactory {

    /* renamed from: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory$1 */
    static /* synthetic */ class C17601 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = android.graphics.Bitmap.Config.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$android$graphics$Bitmap$Config = r0;
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.graphics.Bitmap.Config.ALPHA_8;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.graphics.Bitmap.Config.ARGB_4444;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.1.<clinit>():void");
        }
    }

    public abstract CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Config config);

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Config config) {
        return createBitmap(i, i2, config, null);
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2) {
        return createBitmap(i, i2, Config.ARGB_8888);
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Config config, Object obj) {
        return createBitmapInternal(i, i2, config);
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Object obj) {
        return createBitmap(i, i2, Config.ARGB_8888, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap) {
        return createBitmap(bitmap, null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, Object obj) {
        return createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return createBitmap(bitmap, i, i2, i3, i4, null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Object obj) {
        return createBitmap(bitmap, i, i2, i3, i4, null, false, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix, boolean z) {
        return createBitmap(bitmap, i, i2, i3, i4, matrix, z, null);
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        return createScaledBitmap(bitmap, i, i2, z, null);
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z, Object obj) {
        checkWidthHeight(i, i2);
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix.setScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return createBitmap(bitmap, 0, 0, width, height, matrix, z, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix, boolean z, Object obj) {
        CloseableReference<Bitmap> createBitmap;
        Canvas canvas;
        Paint paint;
        Bitmap bitmap2 = bitmap;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        Matrix matrix2 = matrix;
        Preconditions.checkNotNull(bitmap2, "Source bitmap cannot be null");
        checkXYSign(i, i2);
        checkWidthHeight(i3, i4);
        checkFinalImageBounds(bitmap, i, i2, i3, i4);
        Rect rect = new Rect(i5, i6, i5 + i7, i6 + i8);
        RectF rectF = new RectF(0.0f, 0.0f, (float) i7, (float) i8);
        Config suitableBitmapConfig = getSuitableBitmapConfig(bitmap);
        if (matrix2 != null) {
            if (!matrix.isIdentity()) {
                boolean z2;
                i5 = matrix.rectStaysRect() ^ 1;
                RectF rectF2 = new RectF();
                matrix2.mapRect(rectF2, rectF);
                int round = Math.round(rectF2.width());
                int round2 = Math.round(rectF2.height());
                if (i5 != 0) {
                    suitableBitmapConfig = Config.ARGB_8888;
                }
                Config config = suitableBitmapConfig;
                if (i5 == 0) {
                    if (!bitmap.hasAlpha()) {
                        z2 = false;
                        createBitmap = createBitmap(round, round2, config, z2, obj);
                        setPropertyFromSourceBitmap(bitmap2, (Bitmap) createBitmap.get());
                        canvas = new Canvas((Bitmap) createBitmap.get());
                        canvas.translate(-rectF2.left, -rectF2.top);
                        canvas.concat(matrix2);
                        paint = new Paint();
                        paint.setFilterBitmap(z);
                        if (i5 != 0) {
                            paint.setAntiAlias(true);
                        }
                        canvas.drawBitmap(bitmap2, rect, rectF, paint);
                        canvas.setBitmap(null);
                        return createBitmap;
                    }
                }
                z2 = true;
                createBitmap = createBitmap(round, round2, config, z2, obj);
                setPropertyFromSourceBitmap(bitmap2, (Bitmap) createBitmap.get());
                canvas = new Canvas((Bitmap) createBitmap.get());
                canvas.translate(-rectF2.left, -rectF2.top);
                canvas.concat(matrix2);
                paint = new Paint();
                paint.setFilterBitmap(z);
                if (i5 != 0) {
                    paint.setAntiAlias(true);
                }
                canvas.drawBitmap(bitmap2, rect, rectF, paint);
                canvas.setBitmap(null);
                return createBitmap;
            }
        }
        createBitmap = createBitmap(i3, i4, suitableBitmapConfig, bitmap.hasAlpha(), obj);
        setPropertyFromSourceBitmap(bitmap2, (Bitmap) createBitmap.get());
        canvas = new Canvas((Bitmap) createBitmap.get());
        paint = null;
        canvas.drawBitmap(bitmap2, rect, rectF, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Config config) {
        return createBitmap(displayMetrics, i, i2, config, null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Config config, Object obj) {
        return createBitmap(displayMetrics, i, i2, config, true, obj);
    }

    private CloseableReference<Bitmap> createBitmap(int i, int i2, Config config, boolean z) {
        return createBitmap(i, i2, config, z, null);
    }

    private CloseableReference<Bitmap> createBitmap(int i, int i2, Config config, boolean z, Object obj) {
        return createBitmap(null, i, i2, config, z, obj);
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Config config, boolean z) {
        return createBitmap(displayMetrics, i, i2, config, z, null);
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Config config, boolean z, Object obj) {
        checkWidthHeight(i, i2);
        i = createBitmapInternal(i, i2, config);
        Bitmap bitmap = (Bitmap) i.get();
        if (displayMetrics != null) {
            bitmap.setDensity(displayMetrics.densityDpi);
        }
        if (VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(z);
        }
        if (config == Config.ARGB_8888 && !z) {
            bitmap.eraseColor(-16777216);
        }
        return i;
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i, int i2, Config config) {
        return createBitmap(iArr, i, i2, config, null);
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i, int i2, Config config, Object obj) {
        config = createBitmapInternal(i, i2, config);
        ((Bitmap) config.get()).setPixels(iArr, 0, i, 0, 0, i, i2);
        return config;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Config config) {
        return createBitmap(displayMetrics, iArr, i, i2, config, null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Config config, Object obj) {
        return createBitmap(displayMetrics, iArr, 0, i, i, i2, config, obj);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Config config) {
        return createBitmap(displayMetrics, iArr, i, i2, i3, i4, config, null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Config config, Object obj) {
        CloseableReference<Bitmap> createBitmap = createBitmap(displayMetrics, i3, i4, config, obj);
        ((Bitmap) createBitmap.get()).setPixels(iArr, i, i2, 0, 0, i3, i4);
        return createBitmap;
    }

    private static Config getSuitableBitmapConfig(Bitmap bitmap) {
        Config config = Config.ARGB_8888;
        bitmap = bitmap.getConfig();
        if (bitmap == null) {
            return config;
        }
        switch (C17601.$SwitchMap$android$graphics$Bitmap$Config[bitmap.ordinal()]) {
            case 1:
                return Config.RGB_565;
            case 2:
                return Config.ALPHA_8;
            default:
                return Config.ARGB_8888;
        }
    }

    private static void checkWidthHeight(int i, int i2) {
        boolean z = false;
        Preconditions.checkArgument(i > 0 ? 1 : 0, "width must be > 0");
        if (i2 > 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "height must be > 0");
    }

    private static void checkXYSign(int i, int i2) {
        boolean z = false;
        Preconditions.checkArgument(i >= 0 ? 1 : 0, "x must be >= 0");
        if (i2 >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "y must be >= 0");
    }

    private static void checkFinalImageBounds(Bitmap bitmap, int i, int i2, int i3, int i4) {
        boolean z = false;
        Preconditions.checkArgument(i + i3 <= bitmap.getWidth() ? 1 : 0, "x + width must be <= bitmap.width()");
        if (i2 + i4 <= bitmap.getHeight()) {
            z = true;
        }
        Preconditions.checkArgument(z, "y + height must be <= bitmap.height()");
    }

    private static void setPropertyFromSourceBitmap(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
        if (VERSION.SDK_INT >= 12) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
        if (VERSION.SDK_INT >= 19) {
            bitmap2.setPremultiplied(bitmap.isPremultiplied());
        }
    }
}
