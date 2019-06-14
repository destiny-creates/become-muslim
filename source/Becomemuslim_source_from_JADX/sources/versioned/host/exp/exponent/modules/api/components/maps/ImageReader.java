package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.net.Uri;
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
import com.google.android.gms.maps.model.C5136a;
import com.google.android.gms.maps.model.C5137b;

public class ImageReader {
    private final Context context;
    private DataSource<CloseableReference<CloseableImage>> dataSource;
    private final ImageReadable imp;
    private final DraweeHolder<?> logoHolder;
    private final ControllerListener<ImageInfo> mLogoControllerListener = new C82001();
    private final Resources resources;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.ImageReader$1 */
    class C82001 extends BaseControllerListener<ImageInfo> {
        C82001() {
        }

        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            try {
                imageInfo = (CloseableReference) ImageReader.this.dataSource.getResult();
                if (imageInfo != null) {
                    try {
                        CloseableImage closeableImage = (CloseableImage) imageInfo.get();
                        if (!(closeableImage == null || (closeableImage instanceof CloseableStaticBitmap) == null)) {
                            str = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap();
                            if (str != null) {
                                Bitmap copy = str.copy(Config.ARGB_8888, true);
                                ImageReader.this.imp.setIconBitmap(copy);
                                ImageReader.this.imp.setIconBitmapDescriptor(C5137b.m21764a(copy));
                            }
                        }
                    } catch (Throwable th) {
                        str = th;
                        ImageReader.this.dataSource.close();
                        if (imageInfo != null) {
                            CloseableReference.closeSafely(imageInfo);
                        }
                        throw str;
                    }
                }
                ImageReader.this.dataSource.close();
                if (imageInfo != null) {
                    CloseableReference.closeSafely(imageInfo);
                }
                ImageReader.this.imp.update();
            } catch (ImageInfo imageInfo2) {
                ImageInfo imageInfo3 = imageInfo2;
                imageInfo2 = null;
                str = imageInfo3;
                ImageReader.this.dataSource.close();
                if (imageInfo2 != null) {
                    CloseableReference.closeSafely(imageInfo2);
                }
                throw str;
            }
        }
    }

    public ImageReader(Context context, Resources resources, ImageReadable imageReadable) {
        this.context = context;
        this.resources = resources;
        this.imp = imageReadable;
        this.logoHolder = DraweeHolder.create(createDraweeHeirarchy(resources), context);
        this.logoHolder.onAttach();
    }

    private GenericDraweeHierarchy createDraweeHeirarchy(Resources resources) {
        return new GenericDraweeHierarchyBuilder(resources).setActualImageScaleType(ScaleType.FIT_CENTER).setFadeDuration(0).build();
    }

    public void setImage(String str) {
        if (str == null) {
            this.imp.setIconBitmapDescriptor(null);
            this.imp.update();
            return;
        }
        if (!(str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://"))) {
            if (!str.startsWith("asset://")) {
                C5136a bitmapDescriptorByName = getBitmapDescriptorByName(str);
                if (bitmapDescriptorByName != null) {
                    this.imp.setIconBitmapDescriptor(bitmapDescriptorByName);
                    this.imp.setIconBitmap(BitmapFactory.decodeResource(this.resources, getDrawableResourceByName(str)));
                }
                this.imp.update();
                return;
            }
        }
        str = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build();
        this.dataSource = Fresco.getImagePipeline().fetchDecodedImage(str, this);
        this.logoHolder.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(str)).setControllerListener(this.mLogoControllerListener)).setOldController(this.logoHolder.getController())).build());
    }

    private int getDrawableResourceByName(String str) {
        return this.resources.getIdentifier(str, "drawable", this.context.getPackageName());
    }

    private C5136a getBitmapDescriptorByName(String str) {
        return C5137b.m21763a(getDrawableResourceByName(str));
    }
}
