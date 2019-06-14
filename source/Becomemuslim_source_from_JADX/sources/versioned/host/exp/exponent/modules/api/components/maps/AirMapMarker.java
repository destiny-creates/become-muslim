package versioned.host.exp.exponent.modules.api.components.maps;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Property;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.model.C5136a;
import com.google.android.gms.maps.model.C5137b;
import com.google.android.gms.maps.model.C5143l;
import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.LatLng;

public class AirMapMarker extends AirMapFeature {
    private boolean anchorIsSet;
    private float anchorX;
    private float anchorY;
    private boolean calloutAnchorIsSet;
    private float calloutAnchorX;
    private float calloutAnchorY;
    private AirMapCallout calloutView;
    private final Context context;
    private DataSource<CloseableReference<CloseableImage>> dataSource;
    private boolean draggable = false;
    private boolean flat = false;
    private boolean hasCustomMarkerView = false;
    private boolean hasViewChanges = true;
    private int height;
    private Bitmap iconBitmap;
    private C5136a iconBitmapDescriptor;
    private String identifier;
    private final DraweeHolder<?> logoHolder;
    private Bitmap mLastBitmapCreated = null;
    private final ControllerListener<ImageInfo> mLogoControllerListener = new C81991();
    private C5143l marker;
    private float markerHue = 0.0f;
    private C7851m markerOptions;
    private float opacity = 1.0f;
    private LatLng position;
    private float rotation = 0.0f;
    private String snippet;
    private String title;
    private boolean tracksViewChanges = true;
    private boolean tracksViewChangesActive = false;
    private int width;
    private View wrappedCalloutView;
    private int zIndex = 0;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.AirMapMarker$2 */
    class C67402 implements TypeEvaluator<LatLng> {
        C67402() {
        }

        public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
            return AirMapMarker.this.interpolate(f, latLng, latLng2);
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.AirMapMarker$1 */
    class C81991 extends BaseControllerListener<ImageInfo> {
        C81991() {
        }

        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            try {
                imageInfo = (CloseableReference) AirMapMarker.this.dataSource.getResult();
                if (imageInfo != null) {
                    try {
                        CloseableImage closeableImage = (CloseableImage) imageInfo.get();
                        if (closeableImage != null && (closeableImage instanceof CloseableStaticBitmap)) {
                            animatable = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap();
                            if (animatable != null) {
                                Bitmap copy = animatable.copy(Config.ARGB_8888, true);
                                AirMapMarker.this.iconBitmap = copy;
                                AirMapMarker.this.iconBitmapDescriptor = C5137b.m21764a(copy);
                            }
                        }
                    } catch (Throwable th) {
                        str = th;
                        AirMapMarker.this.dataSource.close();
                        if (imageInfo != null) {
                            CloseableReference.closeSafely(imageInfo);
                        }
                        throw str;
                    }
                }
                AirMapMarker.this.dataSource.close();
                if (imageInfo != null) {
                    CloseableReference.closeSafely(imageInfo);
                }
                AirMapMarker.this.update(true);
            } catch (ImageInfo imageInfo2) {
                ImageInfo imageInfo3 = imageInfo2;
                imageInfo2 = null;
                str = imageInfo3;
                AirMapMarker.this.dataSource.close();
                if (imageInfo2 != null) {
                    CloseableReference.closeSafely(imageInfo2);
                }
                throw str;
            }
        }
    }

    public AirMapMarker(Context context) {
        super(context);
        this.context = context;
        this.logoHolder = DraweeHolder.create(createDraweeHierarchy(), context);
        this.logoHolder.onAttach();
    }

    public AirMapMarker(Context context, C7851m c7851m) {
        super(context);
        this.context = context;
        this.logoHolder = DraweeHolder.create(createDraweeHierarchy(), context);
        this.logoHolder.onAttach();
        this.position = c7851m.m38314a();
        setAnchor((double) c7851m.m38330e(), (double) c7851m.m38331f());
        setCalloutAnchor((double) c7851m.m38336k(), (double) c7851m.m38337l());
        setTitle(c7851m.m38325b());
        setSnippet(c7851m.m38328c());
        setRotation(c7851m.m38335j());
        setFlat(c7851m.m38334i());
        setDraggable(c7851m.m38332g());
        setZIndex(Math.round(c7851m.m38339n()));
        setAlpha(c7851m.m38338m());
        this.iconBitmapDescriptor = c7851m.m38329d();
    }

    private GenericDraweeHierarchy createDraweeHierarchy() {
        return new GenericDraweeHierarchyBuilder(getResources()).setActualImageScaleType(ScaleType.FIT_CENTER).setFadeDuration(0).build();
    }

    public void setCoordinate(ReadableMap readableMap) {
        this.position = new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude"));
        if (this.marker != null) {
            this.marker.m21791a(this.position);
        }
        update(null);
    }

    public void setIdentifier(String str) {
        this.identifier = str;
        update(null);
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setTitle(String str) {
        this.title = str;
        if (this.marker != null) {
            this.marker.m21793a(str);
        }
        update(null);
    }

    public void setSnippet(String str) {
        this.snippet = str;
        if (this.marker != null) {
            this.marker.m21798b(str);
        }
        update(null);
    }

    public void setRotation(float f) {
        this.rotation = f;
        if (this.marker != null) {
            this.marker.m21796b(f);
        }
        update(0.0f);
    }

    public void setFlat(boolean z) {
        this.flat = z;
        if (this.marker != null) {
            this.marker.m21802c(z);
        }
        update(false);
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
        if (this.marker != null) {
            this.marker.m21794a(z);
        }
        update(false);
    }

    public void setZIndex(int i) {
        this.zIndex = i;
        if (this.marker != null) {
            this.marker.m21789a((float) i);
        }
        update(0);
    }

    public void setOpacity(float f) {
        this.opacity = f;
        if (this.marker != null) {
            this.marker.m21801c(f);
        }
        update(0.0f);
    }

    public void setMarkerHue(float f) {
        this.markerHue = f;
        update(0.0f);
    }

    public void setAnchor(double d, double d2) {
        this.anchorIsSet = true;
        this.anchorX = (float) d;
        this.anchorY = (float) d2;
        if (this.marker != null) {
            this.marker.m21790a(this.anchorX, this.anchorY);
        }
        update(0.0d);
    }

    public void setCalloutAnchor(double d, double d2) {
        this.calloutAnchorIsSet = true;
        this.calloutAnchorX = (float) d;
        this.calloutAnchorY = (float) d2;
        if (this.marker != null) {
            this.marker.m21797b(this.calloutAnchorX, this.calloutAnchorY);
        }
        update(0.0d);
    }

    public void setTracksViewChanges(boolean z) {
        this.tracksViewChanges = z;
        updateTracksViewChanges();
    }

    private void updateTracksViewChanges() {
        boolean z = this.tracksViewChanges && this.hasCustomMarkerView && this.marker != null;
        if (z != this.tracksViewChangesActive) {
            this.tracksViewChangesActive = z;
            if (z) {
                ViewChangesTracker.getInstance().addMarker(this);
            } else {
                ViewChangesTracker.getInstance().removeMarker(this);
                updateMarkerIcon();
            }
        }
    }

    public boolean updateCustomForTracking() {
        if (!this.tracksViewChangesActive) {
            return false;
        }
        updateMarkerIcon();
        return true;
    }

    public void updateMarkerIcon() {
        if (this.hasViewChanges) {
            if (!this.hasCustomMarkerView) {
                this.hasViewChanges = false;
            }
            if (this.marker != null) {
                this.marker.m21792a(getIcon());
            }
        }
    }

    public LatLng interpolate(float f, LatLng latLng, LatLng latLng2) {
        double d = (double) f;
        return new LatLng(((latLng2.f29231a - latLng.f29231a) * d) + latLng.f29231a, ((latLng2.f29232b - latLng.f29232b) * d) + latLng.f29232b);
    }

    public void animateToCoodinate(LatLng latLng, Integer num) {
        TypeEvaluator c67402 = new C67402();
        Property of = Property.of(C5143l.class, LatLng.class, ViewProps.POSITION);
        latLng = ObjectAnimator.ofObject(this.marker, of, c67402, new LatLng[]{latLng});
        latLng.setDuration((long) num.intValue());
        latLng.start();
    }

    public void setImage(String str) {
        this.hasViewChanges = true;
        if (str == null) {
            this.iconBitmapDescriptor = null;
            update(true);
            return;
        }
        if (!(str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://"))) {
            if (!str.startsWith("asset://")) {
                this.iconBitmapDescriptor = getBitmapDescriptorByName(str);
                if (this.iconBitmapDescriptor != null) {
                    str = getDrawableResourceByName(str);
                    this.iconBitmap = BitmapFactory.decodeResource(getResources(), str);
                    if (this.iconBitmap == null) {
                        str = getResources().getDrawable(str);
                        this.iconBitmap = Bitmap.createBitmap(str.getIntrinsicWidth(), str.getIntrinsicHeight(), Config.ARGB_8888);
                        str.setBounds(0, 0, str.getIntrinsicWidth(), str.getIntrinsicHeight());
                        str.draw(new Canvas(this.iconBitmap));
                    }
                }
                update(true);
                return;
            }
        }
        str = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build();
        this.dataSource = Fresco.getImagePipeline().fetchDecodedImage(str, this);
        this.logoHolder.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(str)).setControllerListener(this.mLogoControllerListener)).setOldController(this.logoHolder.getController())).build());
    }

    public C7851m getMarkerOptions() {
        if (this.markerOptions == null) {
            this.markerOptions = new C7851m();
        }
        fillMarkerOptions(this.markerOptions);
        return this.markerOptions;
    }

    public void addView(View view, int i) {
        super.addView(view, i);
        if ((view instanceof AirMapCallout) == null) {
            this.hasCustomMarkerView = true;
            updateTracksViewChanges();
        }
        update(true);
    }

    public void requestLayout() {
        super.requestLayout();
        if (getChildCount() == 0 && this.hasCustomMarkerView) {
            this.hasCustomMarkerView = false;
            clearDrawableCache();
            updateTracksViewChanges();
            update(true);
        }
    }

    public Object getFeature() {
        return this.marker;
    }

    public void addToMap(C5125c c5125c) {
        this.marker = c5125c.m21702a(getMarkerOptions());
        updateTracksViewChanges();
    }

    public void removeFromMap(C5125c c5125c) {
        this.marker.m21788a();
        this.marker = null;
        updateTracksViewChanges();
    }

    private C5136a getIcon() {
        if (this.hasCustomMarkerView) {
            if (this.iconBitmapDescriptor == null) {
                return C5137b.m21764a(createDrawable());
            }
            Bitmap createDrawable = createDrawable();
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(this.iconBitmap.getWidth(), createDrawable.getWidth()), Math.max(this.iconBitmap.getHeight(), createDrawable.getHeight()), this.iconBitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(this.iconBitmap, 0.0f, 0.0f, null);
            canvas.drawBitmap(createDrawable, 0.0f, 0.0f, null);
            return C5137b.m21764a(createBitmap);
        } else if (this.iconBitmapDescriptor != null) {
            return this.iconBitmapDescriptor;
        } else {
            return C5137b.m21762a(this.markerHue);
        }
    }

    private C7851m fillMarkerOptions(C7851m c7851m) {
        c7851m.m38317a(this.position);
        if (this.anchorIsSet) {
            c7851m.m38316a(this.anchorX, this.anchorY);
        }
        if (this.calloutAnchorIsSet) {
            c7851m.m38322b(this.calloutAnchorX, this.calloutAnchorY);
        }
        c7851m.m38319a(this.title);
        c7851m.m38323b(this.snippet);
        c7851m.m38321b(this.rotation);
        c7851m.m38327c(this.flat);
        c7851m.m38320a(this.draggable);
        c7851m.m38315a((float) this.zIndex);
        c7851m.m38326c(this.opacity);
        c7851m.m38318a(getIcon());
        return c7851m;
    }

    public void update(boolean z) {
        if (this.marker != null) {
            if (z) {
                updateMarkerIcon();
            }
            if (this.anchorIsSet) {
                this.marker.m21790a(this.anchorX, this.anchorY);
            } else {
                this.marker.m21790a(0.5f, 1.0f);
            }
            if (this.calloutAnchorIsSet) {
                this.marker.m21797b(this.calloutAnchorX, this.calloutAnchorY);
            } else {
                this.marker.m21797b(0.5f, 0.0f);
            }
        }
    }

    public void update(int i, int i2) {
        this.width = i;
        this.height = i2;
        update(1);
    }

    private void clearDrawableCache() {
        this.mLastBitmapCreated = null;
    }

    private Bitmap createDrawable() {
        int i = 100;
        int i2 = this.width <= 0 ? 100 : this.width;
        if (this.height > 0) {
            i = this.height;
        }
        buildDrawingCache();
        Bitmap bitmap = this.mLastBitmapCreated;
        if (!(bitmap == null || bitmap.isRecycled() || bitmap.getWidth() != i2)) {
            if (bitmap.getHeight() == i) {
                bitmap.eraseColor(0);
                draw(new Canvas(bitmap));
                return bitmap;
            }
        }
        bitmap = Bitmap.createBitmap(i2, i, Config.ARGB_8888);
        this.mLastBitmapCreated = bitmap;
        draw(new Canvas(bitmap));
        return bitmap;
    }

    public void setCalloutView(AirMapCallout airMapCallout) {
        this.calloutView = airMapCallout;
    }

    public AirMapCallout getCalloutView() {
        return this.calloutView;
    }

    public View getCallout() {
        if (this.calloutView == null) {
            return null;
        }
        if (this.wrappedCalloutView == null) {
            wrapCalloutView();
        }
        if (this.calloutView.getTooltip()) {
            return this.wrappedCalloutView;
        }
        return null;
    }

    public View getInfoContents() {
        if (this.calloutView == null) {
            return null;
        }
        if (this.wrappedCalloutView == null) {
            wrapCalloutView();
        }
        if (this.calloutView.getTooltip()) {
            return null;
        }
        return this.wrappedCalloutView;
    }

    private void wrapCalloutView() {
        if (this.calloutView != null) {
            if (this.calloutView.getChildCount() != 0) {
                View linearLayout = new LinearLayout(this.context);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new LayoutParams(this.calloutView.width, this.calloutView.height, 0.0f));
                View linearLayout2 = new LinearLayout(this.context);
                linearLayout2.setOrientation(0);
                linearLayout2.setLayoutParams(new LayoutParams(this.calloutView.width, this.calloutView.height, 0.0f));
                linearLayout.addView(linearLayout2);
                linearLayout2.addView(this.calloutView);
                this.wrappedCalloutView = linearLayout;
            }
        }
    }

    private int getDrawableResourceByName(String str) {
        return getResources().getIdentifier(str, "drawable", getContext().getPackageName());
    }

    private C5136a getBitmapDescriptorByName(String str) {
        return C5137b.m21763a(getDrawableResourceByName(str));
    }
}
