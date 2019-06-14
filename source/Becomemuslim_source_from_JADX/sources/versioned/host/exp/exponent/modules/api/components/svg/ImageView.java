package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.net.Uri;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
class ImageView extends RenderableView {
    private String mAlign;
    private SVGLength mH;
    private int mImageHeight;
    private int mImageWidth;
    private final AtomicBoolean mLoading = new AtomicBoolean(false);
    private int mMeetOrSlice;
    private SVGLength mW;
    private SVGLength mX;
    private SVGLength mY;
    private String uriString;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.svg.ImageView$1 */
    class C82801 extends BaseBitmapDataSubscriber {
        C82801() {
        }

        public void onNewResultImpl(Bitmap bitmap) {
            ImageView.this.mLoading.set(false);
            bitmap = ImageView.this.getSvgView();
            if (bitmap != null) {
                bitmap.invalidate();
            }
        }

        public void onFailureImpl(DataSource dataSource) {
            ImageView.this.mLoading.set(false);
            FLog.w(ReactConstants.TAG, dataSource.getFailureCause(), "RNSVG: fetchDecodedImage failed!", new Object[0]);
        }
    }

    public ImageView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.mX = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.mY = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.mW = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.mH = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "src")
    public void setSrc(ReadableMap readableMap) {
        if (readableMap != null) {
            this.uriString = readableMap.getString("uri");
            if (this.uriString != null) {
                if (!this.uriString.isEmpty()) {
                    if (readableMap.hasKey("width") && readableMap.hasKey("height")) {
                        this.mImageWidth = readableMap.getInt("width");
                        this.mImageHeight = readableMap.getInt("height");
                    } else {
                        this.mImageWidth = 0;
                        this.mImageHeight = 0;
                    }
                    if (Uri.parse(this.uriString).getScheme() == null) {
                        ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(this.mContext, this.uriString);
                    }
                }
            }
        }
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    void draw(Canvas canvas, Paint paint, float f) {
        if (!this.mLoading.get()) {
            ImageRequest build = ImageRequestBuilder.newBuilderWithSource(new ImageSource(this.mContext, this.uriString).getUri()).build();
            if (Fresco.getImagePipeline().isInBitmapMemoryCache(build)) {
                tryRender(build, canvas, paint, f * this.mOpacity);
            } else {
                loadBitmap(build);
            }
        }
    }

    Path getPath(Canvas canvas, Paint paint) {
        canvas = new Path();
        canvas.addRect(getRect(), Direction.CW);
        return canvas;
    }

    private void loadBitmap(ImageRequest imageRequest) {
        Fresco.getImagePipeline().fetchDecodedImage(imageRequest, this.mContext).subscribe(new C82801(), UiThreadImmediateExecutorService.getInstance());
    }

    private RectF getRect() {
        double relativeOnWidth = relativeOnWidth(this.mX);
        double relativeOnHeight = relativeOnHeight(this.mY);
        double relativeOnWidth2 = relativeOnWidth(this.mW);
        double relativeOnHeight2 = relativeOnHeight(this.mH);
        if (relativeOnWidth2 == 0.0d) {
            relativeOnWidth2 = (double) (((float) this.mImageWidth) * this.mScale);
        }
        if (relativeOnHeight2 == 0.0d) {
            relativeOnHeight2 = (double) (((float) this.mImageHeight) * this.mScale);
        }
        return new RectF((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2));
    }

    private void doRender(Canvas canvas, Paint paint, Bitmap bitmap, float f) {
        if (this.mImageWidth == 0 || this.mImageHeight == 0) {
            this.mImageWidth = bitmap.getWidth();
            this.mImageHeight = bitmap.getHeight();
        }
        RectF rect = getRect();
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.mImageWidth, (float) this.mImageHeight);
        ViewBox.getTransform(rectF, rect, this.mAlign, this.mMeetOrSlice).mapRect(rectF);
        if (this.mMatrix != null) {
            this.mMatrix.mapRect(rectF);
        }
        if (this.mTransform != null) {
            this.mTransform.mapRect(rectF);
        }
        canvas.clipPath(getPath(canvas, paint));
        paint = getClipPath(canvas, paint);
        if (paint != null) {
            canvas.clipPath(paint);
        }
        paint = new Paint();
        paint.setAlpha((int) (f * 255.0f));
        canvas.drawBitmap(bitmap, 0.0f, rectF, paint);
        canvas.getMatrix().mapRect(rectF);
        setClientRect(rectF);
    }

    private void tryRender(ImageRequest imageRequest, Canvas canvas, Paint paint, float f) {
        imageRequest = Fresco.getImagePipeline().fetchImageFromBitmapCache(imageRequest, this.mContext);
        CloseableReference closeableReference;
        try {
            closeableReference = (CloseableReference) imageRequest.getResult();
            if (closeableReference != null) {
                if (closeableReference.get() instanceof CloseableBitmap) {
                    Bitmap underlyingBitmap = ((CloseableBitmap) closeableReference.get()).getUnderlyingBitmap();
                    if (underlyingBitmap != null) {
                        doRender(canvas, paint, underlyingBitmap, f);
                    }
                }
                CloseableReference.closeSafely(closeableReference);
            }
            imageRequest.close();
        } catch (Canvas canvas2) {
            throw new IllegalStateException(canvas2);
        } catch (Canvas canvas22) {
            try {
                throw new IllegalStateException(canvas22);
            } catch (Throwable th) {
                imageRequest.close();
            }
        } catch (Throwable th2) {
            CloseableReference.closeSafely(closeableReference);
        }
    }
}
