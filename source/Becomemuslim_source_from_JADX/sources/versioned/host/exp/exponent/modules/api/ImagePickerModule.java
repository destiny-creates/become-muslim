package versioned.host.exp.exponent.modules.api;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.p018e.C0207a;
import android.util.Base64;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.theartofdev.edmodo.cropper.C5842d;
import host.exp.exponent.C6292b;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p346j.C6385c;
import host.exp.exponent.p346j.C6393j;
import host.exp.p333a.C6271b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.p371a.p376c.C6646d;
import versioned.host.exp.exponent.modules.ExpoKernelServiceConsumerBaseModule;
import versioned.host.exp.exponent.modules.api.viewshot.ViewShot.Results;

public class ImagePickerModule extends ExpoKernelServiceConsumerBaseModule implements C6292b {
    private static final int DEFAULT_QUALITY = 100;
    static final int REQUEST_LAUNCH_CAMERA = 1;
    static final int REQUEST_LAUNCH_IMAGE_LIBRARY = 2;
    public static final String TAG = "ExponentImagePicker";
    public static final String[][] exifTags = new String[][]{new String[]{"string", "Artist"}, new String[]{"int", "BitsPerSample"}, new String[]{"int", "Compression"}, new String[]{"string", "Copyright"}, new String[]{"string", "DateTime"}, new String[]{"string", "ImageDescription"}, new String[]{"int", "ImageLength"}, new String[]{"int", "ImageWidth"}, new String[]{"int", "JPEGInterchangeFormat"}, new String[]{"int", "JPEGInterchangeFormatLength"}, new String[]{"string", "Make"}, new String[]{"string", "Model"}, new String[]{"int", "Orientation"}, new String[]{"int", "PhotometricInterpretation"}, new String[]{"int", "PlanarConfiguration"}, new String[]{"double", "PrimaryChromaticities"}, new String[]{"double", "ReferenceBlackWhite"}, new String[]{"int", "ResolutionUnit"}, new String[]{"int", "RowsPerStrip"}, new String[]{"int", "SamplesPerPixel"}, new String[]{"string", "Software"}, new String[]{"int", "StripByteCounts"}, new String[]{"int", "StripOffsets"}, new String[]{"int", "TransferFunction"}, new String[]{"double", "WhitePoint"}, new String[]{"double", "XResolution"}, new String[]{"double", "YCbCrCoefficients"}, new String[]{"int", "YCbCrPositioning"}, new String[]{"int", "YCbCrSubSampling"}, new String[]{"double", "YResolution"}, new String[]{"double", "ApertureValue"}, new String[]{"double", "BrightnessValue"}, new String[]{"string", "CFAPattern"}, new String[]{"int", "ColorSpace"}, new String[]{"string", "ComponentsConfiguration"}, new String[]{"double", "CompressedBitsPerPixel"}, new String[]{"int", "Contrast"}, new String[]{"int", "CustomRendered"}, new String[]{"string", "DateTimeDigitized"}, new String[]{"string", "DateTimeOriginal"}, new String[]{"string", "DeviceSettingDescription"}, new String[]{"double", "DigitalZoomRatio"}, new String[]{"string", "ExifVersion"}, new String[]{"double", "ExposureBiasValue"}, new String[]{"double", "ExposureIndex"}, new String[]{"int", "ExposureMode"}, new String[]{"int", "ExposureProgram"}, new String[]{"double", "ExposureTime"}, new String[]{"double", "FNumber"}, new String[]{"string", "FileSource"}, new String[]{"int", "Flash"}, new String[]{"double", "FlashEnergy"}, new String[]{"string", "FlashpixVersion"}, new String[]{"double", "FocalLength"}, new String[]{"int", "FocalLengthIn35mmFilm"}, new String[]{"int", "FocalPlaneResolutionUnit"}, new String[]{"double", "FocalPlaneXResolution"}, new String[]{"double", "FocalPlaneYResolution"}, new String[]{"int", "GainControl"}, new String[]{"int", "ISOSpeedRatings"}, new String[]{"string", "ImageUniqueID"}, new String[]{"int", "LightSource"}, new String[]{"string", "MakerNote"}, new String[]{"double", "MaxApertureValue"}, new String[]{"int", "MeteringMode"}, new String[]{"int", "NewSubfileType"}, new String[]{"string", "OECF"}, new String[]{"int", "PixelXDimension"}, new String[]{"int", "PixelYDimension"}, new String[]{"string", "RelatedSoundFile"}, new String[]{"int", "Saturation"}, new String[]{"int", "SceneCaptureType"}, new String[]{"string", "SceneType"}, new String[]{"int", "SensingMethod"}, new String[]{"int", "Sharpness"}, new String[]{"double", "ShutterSpeedValue"}, new String[]{"string", "SpatialFrequencyResponse"}, new String[]{"string", "SpectralSensitivity"}, new String[]{"int", "SubfileType"}, new String[]{"string", "SubSecTime"}, new String[]{"string", "SubSecTimeDigitized"}, new String[]{"string", "SubSecTimeOriginal"}, new String[]{"int", "SubjectArea"}, new String[]{"double", "SubjectDistance"}, new String[]{"int", "SubjectDistanceRange"}, new String[]{"int", "SubjectLocation"}, new String[]{"string", "UserComment"}, new String[]{"int", "WhiteBalance"}, new String[]{"int", "GPSAltitudeRef"}, new String[]{"string", "GPSAreaInformation"}, new String[]{"double", "GPSDOP"}, new String[]{"string", "GPSDateStamp"}, new String[]{"double", "GPSDestBearing"}, new String[]{"string", "GPSDestBearingRef"}, new String[]{"double", "GPSDestDistance"}, new String[]{"string", "GPSDestDistanceRef"}, new String[]{"double", "GPSDestLatitude"}, new String[]{"string", "GPSDestLatitudeRef"}, new String[]{"double", "GPSDestLongitude"}, new String[]{"string", "GPSDestLongitudeRef"}, new String[]{"int", "GPSDifferential"}, new String[]{"double", "GPSImgDirection"}, new String[]{"string", "GPSImgDirectionRef"}, new String[]{"string", "GPSLatitudeRef"}, new String[]{"string", "GPSLongitudeRef"}, new String[]{"string", "GPSMapDatum"}, new String[]{"string", "GPSMeasureMode"}, new String[]{"string", "GPSProcessingMethod"}, new String[]{"string", "GPSSatellites"}, new String[]{"double", "GPSSpeed"}, new String[]{"string", "GPSSpeedRef"}, new String[]{"string", "GPSStatus"}, new String[]{"string", "GPSTimeStamp"}, new String[]{"double", "GPSTrack"}, new String[]{"string", "GPSTrackRef"}, new String[]{"string", "GPSVersionID"}, new String[]{"string", "InteroperabilityIndex"}, new String[]{"int", "ThumbnailImageLength"}, new String[]{"int", "ThumbnailImageWidth"}, new String[]{"int", "DNGVersion"}, new String[]{"int", "DefaultCropSize"}, new String[]{"int", "PreviewImageStart"}, new String[]{"int", "PreviewImageLength"}, new String[]{"int", "AspectFrame"}, new String[]{"int", "SensorBottomBorder"}, new String[]{"int", "SensorLeftBorder"}, new String[]{"int", "SensorRightBorder"}, new String[]{"int", "SensorTopBorder"}, new String[]{"int", "ISO"}};
    final String OPTION_ALLOWS_EDITING = "allowsEditing";
    final String OPTION_ASPECT = "aspect";
    final String OPTION_BASE64 = Results.BASE_64;
    final String OPTION_EXIF = "exif";
    final String OPTION_MEDIA_TYPES = "mediaTypes";
    final String OPTION_QUALITY = "quality";
    private Boolean allowsEditing = Boolean.valueOf(false);
    private Boolean base64 = Boolean.valueOf(false);
    private Boolean exif = Boolean.valueOf(false);
    private ReadableArray forceAspect = null;
    private Uri mCameraCaptureURI;
    private WritableMap mExifData = null;
    private Boolean mLaunchedCropper = Boolean.valueOf(false);
    private Promise mPromise;
    private C6393j mScopedContext;
    private String mediaTypes = null;
    private Integer quality = null;

    public String getName() {
        return TAG;
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext, C6393j c6393j, C6330b c6330b) {
        super(reactApplicationContext, c6330b);
        this.mScopedContext = c6393j;
        C6271b.m25897a().m25912a((C6292b) this);
    }

    private boolean readOptions(ReadableMap readableMap, Promise promise) {
        if (readableMap.hasKey("quality")) {
            this.quality = Integer.valueOf((int) (readableMap.getDouble("quality") * 100.0d));
        }
        boolean z = false;
        boolean z2 = readableMap.hasKey("allowsEditing") && readableMap.getBoolean("allowsEditing");
        this.allowsEditing = Boolean.valueOf(z2);
        if (readableMap.hasKey("mediaTypes")) {
            this.mediaTypes = readableMap.getString("mediaTypes");
        }
        if (readableMap.hasKey("aspect")) {
            this.forceAspect = readableMap.getArray("aspect");
            if (!(this.forceAspect.size() == 2 && this.forceAspect.getType(0) == ReadableType.Number && this.forceAspect.getType(1) == ReadableType.Number)) {
                promise.reject(new IllegalArgumentException("'aspect option must be of form [Number, Number]"));
                return false;
            }
        }
        this.forceAspect = null;
        promise = (readableMap.hasKey(Results.BASE_64) == null || readableMap.getBoolean(Results.BASE_64) == null) ? null : true;
        this.base64 = Boolean.valueOf(promise);
        if (!(readableMap.hasKey("exif") == null || readableMap.getBoolean("exif") == null)) {
            z = true;
        }
        this.exif = Boolean.valueOf(z);
        return true;
    }

    @ReactMethod
    public void launchCameraAsync(ReadableMap readableMap, Promise promise) {
        if (readOptions(readableMap, promise) != null) {
            readableMap = new Intent("android.media.action.IMAGE_CAPTURE");
            if (readableMap.resolveActivity(C6271b.m25897a().m25924d().getPackageManager()) == null) {
                promise.reject(new IllegalStateException("Error resolving activity"));
                return;
            }
            if (C6271b.m25897a().m25916a("android.permission.WRITE_EXTERNAL_STORAGE", this.experienceId) && C6271b.m25897a().m25916a("android.permission.CAMERA", this.experienceId)) {
                launchCameraWithPermissionsGranted(promise, readableMap);
            } else {
                promise.reject(new SecurityException("User rejected permissions"));
            }
        }
    }

    private void launchCameraWithPermissionsGranted(Promise promise, Intent intent) {
        try {
            File file = new File(C6385c.m26194a(this.mScopedContext.getCacheDir(), "ImagePicker", ".jpg"));
            this.mCameraCaptureURI = C6385c.m26193a(file);
            for (ResolveInfo resolveInfo : C6271b.m25897a().m25924d().getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) {
                C6271b.m25897a().m25924d().grantUriPermission(resolveInfo.activityInfo.packageName, this.mCameraCaptureURI, 3);
            }
            intent.putExtra("output", C6385c.m26195b(file));
            this.mPromise = promise;
            C6271b.m25897a().m25920b().startActivityForResult(intent, 1);
        } catch (Promise promise2) {
            promise2.printStackTrace();
        }
    }

    @ReactMethod
    public void launchImageLibraryAsync(ReadableMap readableMap, Promise promise) {
        if (readOptions(readableMap, promise) != null) {
            readableMap = new Intent();
            if (this.mediaTypes == null) {
                readableMap.setType("image/*");
            } else if (this.mediaTypes.equals("Images")) {
                readableMap.setType("image/*");
            } else if (this.mediaTypes.equals("Videos")) {
                readableMap.setType("video/*");
            } else if (this.mediaTypes.equals("All")) {
                readableMap.setType("*/*");
                readableMap.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }
            readableMap.setAction("android.intent.action.GET_CONTENT");
            this.mPromise = promise;
            C6271b.m25897a().m25920b().startActivityForResult(readableMap, 2);
        }
    }

    public void onActivityResult(final int i, int i2, final Intent intent) {
        if (i == 203) {
            if (this.mLaunchedCropper.booleanValue() != 0) {
                this.mLaunchedCropper = Boolean.valueOf(0);
                i = this.mPromise;
                this.mPromise = null;
                WritableMap writableMap = this.mExifData;
                this.mExifData = null;
                if (i != 0) {
                    if (i2 != -1) {
                        i2 = Arguments.createMap();
                        i2.putBoolean(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, true);
                        i.resolve(i2);
                        return;
                    }
                    handleCropperResult(intent, i, writableMap);
                } else {
                    return;
                }
            }
            return;
        }
        if (!(this.mPromise == null || (this.mCameraCaptureURI == null && i == 1))) {
            if (i == 1 || i == 2) {
                final Promise promise = this.mPromise;
                this.mPromise = null;
                if (i2 != -1) {
                    i2 = Arguments.createMap();
                    i2.putBoolean(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, true);
                    if (i == 1) {
                        revokeUriPermissionForCamera();
                    }
                    promise.resolve(i2);
                    return;
                }
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r9 = this;
                        r0 = r5;	 Catch:{ Exception -> 0x01ee }
                        r1 = 1;	 Catch:{ Exception -> 0x01ee }
                        if (r0 != r1) goto L_0x000c;	 Catch:{ Exception -> 0x01ee }
                    L_0x0005:
                        r0 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.mCameraCaptureURI;	 Catch:{ Exception -> 0x01ee }
                        goto L_0x0012;	 Catch:{ Exception -> 0x01ee }
                    L_0x000c:
                        r0 = r7;	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.getData();	 Catch:{ Exception -> 0x01ee }
                    L_0x0012:
                        r8 = r0;	 Catch:{ Exception -> 0x01ee }
                        r0 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.exif;	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x01ee }
                        if (r0 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x01ee }
                    L_0x001f:
                        r0 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.readExif(r8);	 Catch:{ Exception -> 0x01ee }
                        goto L_0x0027;	 Catch:{ Exception -> 0x01ee }
                    L_0x0026:
                        r0 = 0;	 Catch:{ Exception -> 0x01ee }
                    L_0x0027:
                        r7 = r0;	 Catch:{ Exception -> 0x01ee }
                        r0 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.getReactApplicationContext();	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.getType(r8);	 Catch:{ Exception -> 0x01ee }
                        if (r0 != 0) goto L_0x004a;	 Catch:{ Exception -> 0x01ee }
                    L_0x0038:
                        r2 = r8.toString();	 Catch:{ Exception -> 0x01ee }
                        r2 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r2);	 Catch:{ Exception -> 0x01ee }
                        if (r2 == 0) goto L_0x004a;	 Catch:{ Exception -> 0x01ee }
                    L_0x0042:
                        r0 = android.webkit.MimeTypeMap.getSingleton();	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.getMimeTypeFromExtension(r2);	 Catch:{ Exception -> 0x01ee }
                    L_0x004a:
                        r2 = "image";	 Catch:{ Exception -> 0x01ee }
                        r2 = r0.contains(r2);	 Catch:{ Exception -> 0x01ee }
                        r3 = 0;	 Catch:{ Exception -> 0x01ee }
                        if (r2 == 0) goto L_0x014b;	 Catch:{ Exception -> 0x01ee }
                    L_0x0053:
                        r2 = ".jpg";	 Catch:{ Exception -> 0x01ee }
                        r4 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x01ee }
                        r5 = "png";	 Catch:{ Exception -> 0x01ee }
                        r5 = r0.contains(r5);	 Catch:{ Exception -> 0x01ee }
                        if (r5 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x01ee }
                    L_0x005f:
                        r0 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Exception -> 0x01ee }
                        r2 = ".png";	 Catch:{ Exception -> 0x01ee }
                        r6 = r0;	 Catch:{ Exception -> 0x01ee }
                        goto L_0x0077;	 Catch:{ Exception -> 0x01ee }
                    L_0x0065:
                        r5 = "jpeg";	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.contains(r5);	 Catch:{ Exception -> 0x01ee }
                        if (r0 != 0) goto L_0x0076;	 Catch:{ Exception -> 0x01ee }
                    L_0x006d:
                        r0 = "ExponentImagePicker";	 Catch:{ Exception -> 0x01ee }
                        r2 = "Image type not supported. Falling back to JPEG instead.";	 Catch:{ Exception -> 0x01ee }
                        host.exp.exponent.p334a.C6289b.m25952b(r0, r2);	 Catch:{ Exception -> 0x01ee }
                        r2 = ".jpg";	 Catch:{ Exception -> 0x01ee }
                    L_0x0076:
                        r6 = r4;	 Catch:{ Exception -> 0x01ee }
                    L_0x0077:
                        r0 = r5;	 Catch:{ Exception -> 0x01ee }
                        if (r0 != r1) goto L_0x0081;	 Catch:{ Exception -> 0x01ee }
                    L_0x007b:
                        r0 = r8.getPath();	 Catch:{ Exception -> 0x01ee }
                    L_0x007f:
                        r5 = r0;	 Catch:{ Exception -> 0x01ee }
                        goto L_0x0092;	 Catch:{ Exception -> 0x01ee }
                    L_0x0081:
                        r0 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.mScopedContext;	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.getCacheDir();	 Catch:{ Exception -> 0x01ee }
                        r4 = "ImagePicker";	 Catch:{ Exception -> 0x01ee }
                        r0 = host.exp.exponent.p346j.C6385c.m26194a(r0, r4, r2);	 Catch:{ Exception -> 0x01ee }
                        goto L_0x007f;	 Catch:{ Exception -> 0x01ee }
                    L_0x0092:
                        r0 = r5;	 Catch:{ Exception -> 0x01ee }
                        if (r0 != r1) goto L_0x0098;	 Catch:{ Exception -> 0x01ee }
                    L_0x0096:
                        r0 = r8;	 Catch:{ Exception -> 0x01ee }
                        goto L_0x00a1;	 Catch:{ Exception -> 0x01ee }
                    L_0x0098:
                        r0 = new java.io.File;	 Catch:{ Exception -> 0x01ee }
                        r0.<init>(r5);	 Catch:{ Exception -> 0x01ee }
                        r0 = android.net.Uri.fromFile(r0);	 Catch:{ Exception -> 0x01ee }
                    L_0x00a1:
                        r2 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r2 = r2.allowsEditing;	 Catch:{ Exception -> 0x01ee }
                        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x01ee }
                        if (r2 == 0) goto L_0x011c;	 Catch:{ Exception -> 0x01ee }
                    L_0x00ad:
                        r2 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r4 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x01ee }
                        r2.mLaunchedCropper = r4;	 Catch:{ Exception -> 0x01ee }
                        r2 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r4 = r3;	 Catch:{ Exception -> 0x01ee }
                        r2.mPromise = r4;	 Catch:{ Exception -> 0x01ee }
                        r2 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r2.mExifData = r7;	 Catch:{ Exception -> 0x01ee }
                        r2 = com.theartofdev.edmodo.cropper.C5842d.m24638a(r8);	 Catch:{ Exception -> 0x01ee }
                        r4 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r4 = r4.forceAspect;	 Catch:{ Exception -> 0x01ee }
                        if (r4 == 0) goto L_0x00ee;	 Catch:{ Exception -> 0x01ee }
                    L_0x00ce:
                        r4 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r4 = r4.forceAspect;	 Catch:{ Exception -> 0x01ee }
                        r3 = r4.getInt(r3);	 Catch:{ Exception -> 0x01ee }
                        r4 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r4 = r4.forceAspect;	 Catch:{ Exception -> 0x01ee }
                        r4 = r4.getInt(r1);	 Catch:{ Exception -> 0x01ee }
                        r3 = r2.m24628a(r3, r4);	 Catch:{ Exception -> 0x01ee }
                        r1 = r3.m24631a(r1);	 Catch:{ Exception -> 0x01ee }
                        r3 = 0;	 Catch:{ Exception -> 0x01ee }
                        r1.m24626a(r3);	 Catch:{ Exception -> 0x01ee }
                    L_0x00ee:
                        r0 = r2.m24630a(r0);	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.m24629a(r6);	 Catch:{ Exception -> 0x01ee }
                        r1 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r1 = r1.quality;	 Catch:{ Exception -> 0x01ee }
                        if (r1 != 0) goto L_0x0101;	 Catch:{ Exception -> 0x01ee }
                    L_0x00fe:
                        r1 = 100;	 Catch:{ Exception -> 0x01ee }
                        goto L_0x010b;	 Catch:{ Exception -> 0x01ee }
                    L_0x0101:
                        r1 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r1 = r1.quality;	 Catch:{ Exception -> 0x01ee }
                        r1 = r1.intValue();	 Catch:{ Exception -> 0x01ee }
                    L_0x010b:
                        r0 = r0.m24627a(r1);	 Catch:{ Exception -> 0x01ee }
                        r1 = host.exp.p333a.C6271b.m25897a();	 Catch:{ Exception -> 0x01ee }
                        r1 = r1.m25920b();	 Catch:{ Exception -> 0x01ee }
                        r0.m24632a(r1);	 Catch:{ Exception -> 0x01ee }
                        goto L_0x01f2;	 Catch:{ Exception -> 0x01ee }
                    L_0x011c:
                        r0 = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(r8);	 Catch:{ Exception -> 0x01ee }
                        r1 = com.facebook.imagepipeline.common.RotationOptions.autoRotate();	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.setRotationOptions(r1);	 Catch:{ Exception -> 0x01ee }
                        r0 = r0.build();	 Catch:{ Exception -> 0x01ee }
                        r1 = com.facebook.drawee.backends.pipeline.Fresco.getImagePipeline();	 Catch:{ Exception -> 0x01ee }
                        r2 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r2 = r2.getReactApplicationContext();	 Catch:{ Exception -> 0x01ee }
                        r0 = r1.fetchDecodedImage(r0, r2);	 Catch:{ Exception -> 0x01ee }
                        r1 = new versioned.host.exp.exponent.modules.api.ImagePickerModule$1$1;	 Catch:{ Exception -> 0x01ee }
                        r2 = r1;	 Catch:{ Exception -> 0x01ee }
                        r3 = r9;	 Catch:{ Exception -> 0x01ee }
                        r4 = r0;	 Catch:{ Exception -> 0x01ee }
                        r2.<init>(r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x01ee }
                        r2 = com.facebook.common.executors.CallerThreadExecutor.getInstance();	 Catch:{ Exception -> 0x01ee }
                        r0.subscribe(r1, r2);	 Catch:{ Exception -> 0x01ee }
                        goto L_0x01f2;	 Catch:{ Exception -> 0x01ee }
                    L_0x014b:
                        r0 = com.facebook.react.bridge.Arguments.createMap();	 Catch:{ Exception -> 0x01ee }
                        r1 = "uri";	 Catch:{ Exception -> 0x01ee }
                        r2 = new java.io.File;	 Catch:{ Exception -> 0x01ee }
                        r4 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ Exception -> 0x01ee }
                        r4 = r4.writeVideo(r8);	 Catch:{ Exception -> 0x01ee }
                        r2.<init>(r4);	 Catch:{ Exception -> 0x01ee }
                        r2 = android.net.Uri.fromFile(r2);	 Catch:{ Exception -> 0x01ee }
                        r2 = r2.toString();	 Catch:{ Exception -> 0x01ee }
                        r0.putString(r1, r2);	 Catch:{ Exception -> 0x01ee }
                        r1 = "cancelled";	 Catch:{ Exception -> 0x01ee }
                        r0.putBoolean(r1, r3);	 Catch:{ Exception -> 0x01ee }
                        r1 = "type";	 Catch:{ Exception -> 0x01ee }
                        r2 = "video";	 Catch:{ Exception -> 0x01ee }
                        r0.putString(r1, r2);	 Catch:{ Exception -> 0x01ee }
                        r1 = new android.media.MediaMetadataRetriever;	 Catch:{ Exception -> 0x01ee }
                        r1.<init>();	 Catch:{ Exception -> 0x01ee }
                        r2 = versioned.host.exp.exponent.modules.api.ImagePickerModule.this;	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r2 = r2.mScopedContext;	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r1.setDataSource(r2, r8);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r2 = "width";	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = 18;	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = r1.extractMetadata(r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = r3.intValue();	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r0.putInt(r2, r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r2 = "height";	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = 19;	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = r1.extractMetadata(r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = r3.intValue();	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r0.putInt(r2, r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r2 = "rotation";	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = 24;	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = r1.extractMetadata(r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = r3.intValue();	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r0.putInt(r2, r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r2 = "duration";	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r3 = 9;	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r1 = r1.extractMetadata(r3);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r1 = r1.intValue();	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        r0.putInt(r2, r1);	 Catch:{ IllegalArgumentException -> 0x01ce, IllegalArgumentException -> 0x01ce }
                        goto L_0x01e8;
                    L_0x01ce:
                        r1 = versioned.host.exp.exponent.modules.api.ImagePickerModule.class;	 Catch:{ Exception -> 0x01ee }
                        r1 = r1.getSimpleName();	 Catch:{ Exception -> 0x01ee }
                        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ee }
                        r2.<init>();	 Catch:{ Exception -> 0x01ee }
                        r3 = "Could not read metadata from video: ";	 Catch:{ Exception -> 0x01ee }
                        r2.append(r3);	 Catch:{ Exception -> 0x01ee }
                        r2.append(r8);	 Catch:{ Exception -> 0x01ee }
                        r2 = r2.toString();	 Catch:{ Exception -> 0x01ee }
                        host.exp.exponent.p334a.C6289b.m25949a(r1, r2);	 Catch:{ Exception -> 0x01ee }
                    L_0x01e8:
                        r1 = r3;	 Catch:{ Exception -> 0x01ee }
                        r1.resolve(r0);	 Catch:{ Exception -> 0x01ee }
                        goto L_0x01f2;
                    L_0x01ee:
                        r0 = move-exception;
                        r0.printStackTrace();
                    L_0x01f2:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.ImagePickerModule.1.run():void");
                    }
                });
            }
        }
    }

    private void saveImage(Bitmap bitmap, CompressFormat compressFormat, File file, ByteArrayOutputStream byteArrayOutputStream) {
        writeImage(bitmap, file.getPath(), compressFormat);
        if (this.base64.booleanValue() != null) {
            bitmap.compress(CompressFormat.JPEG, this.quality.intValue(), byteArrayOutputStream);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void copyImage(android.net.Uri r3, java.io.File r4, java.io.ByteArrayOutputStream r5) {
        /*
        r2 = this;
        r0 = r2.mScopedContext;
        r0 = r0.getApplicationContext();
        r0 = r0.getContentResolver();
        r0 = r0.openInputStream(r3);
        r0 = java.util.Objects.requireNonNull(r0);
        r0 = (java.io.InputStream) r0;
        if (r5 == 0) goto L_0x0019;
    L_0x0016:
        org.apache.p371a.p376c.C6646d.m27051a(r0, r5);
    L_0x0019:
        r1 = android.net.Uri.fromFile(r4);
        r3 = r3.compareTo(r1);
        if (r3 == 0) goto L_0x004e;
    L_0x0023:
        r3 = new java.io.FileOutputStream;
        r3.<init>(r4);
        r4 = 0;
        if (r5 == 0) goto L_0x0037;
    L_0x002b:
        r5 = r5.toByteArray();	 Catch:{ Throwable -> 0x0035 }
        r3.write(r5);	 Catch:{ Throwable -> 0x0035 }
        goto L_0x003a;
    L_0x0033:
        r5 = move-exception;
        goto L_0x003f;
    L_0x0035:
        r4 = move-exception;
        goto L_0x003e;
    L_0x0037:
        org.apache.p371a.p376c.C6646d.m27051a(r0, r3);	 Catch:{ Throwable -> 0x0035 }
    L_0x003a:
        r3.close();
        goto L_0x004e;
    L_0x003e:
        throw r4;	 Catch:{ all -> 0x0033 }
    L_0x003f:
        if (r4 == 0) goto L_0x004a;
    L_0x0041:
        r3.close();	 Catch:{ Throwable -> 0x0045 }
        goto L_0x004d;
    L_0x0045:
        r3 = move-exception;
        r4.addSuppressed(r3);
        goto L_0x004d;
    L_0x004a:
        r3.close();
    L_0x004d:
        throw r5;
    L_0x004e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.ImagePickerModule.copyImage(android.net.Uri, java.io.File, java.io.ByteArrayOutputStream):void");
    }

    private void handleCropperResult(Intent intent, Promise promise, WritableMap writableMap) {
        int width;
        int i;
        int i2;
        OutputStream outputStream;
        WritableMap writableMap2;
        intent = C5842d.m24639a(intent);
        int g = intent.m24539g() % 360;
        if (g < 0) {
            g += 360;
        }
        if (g != 0) {
            if (g != RotationOptions.ROTATE_180) {
                g = intent.m24537e().height();
                width = intent.m24537e().width();
                i = g;
                i2 = width;
                outputStream = null;
                if (this.base64.booleanValue()) {
                    outputStream = new ByteArrayOutputStream();
                    try {
                        C6646d.m27051a(new FileInputStream(intent.m24534b().getPath()), outputStream);
                    } catch (Intent intent2) {
                        promise.reject(intent2);
                        return;
                    }
                }
                writableMap2 = writableMap;
                returnImageResult(writableMap2, intent2.m24534b().toString(), i, i2, outputStream, promise);
            }
        }
        g = intent2.m24537e().width();
        width = intent2.m24537e().height();
        i = g;
        i2 = width;
        outputStream = null;
        if (this.base64.booleanValue()) {
            outputStream = new ByteArrayOutputStream();
            C6646d.m27051a(new FileInputStream(intent2.m24534b().getPath()), outputStream);
        }
        writableMap2 = writableMap;
        returnImageResult(writableMap2, intent2.m24534b().toString(), i, i2, outputStream, promise);
    }

    private void returnImageResult(WritableMap writableMap, String str, int i, int i2, ByteArrayOutputStream byteArrayOutputStream, Promise promise) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("uri", str);
        if (this.base64.booleanValue() != null) {
            createMap.putString(Results.BASE_64, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
        }
        createMap.putInt("width", i);
        createMap.putInt("height", i2);
        if (writableMap != null) {
            createMap.putMap("exif", writableMap);
        }
        createMap.putBoolean(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, false);
        createMap.putString("type", MessengerShareContentUtility.MEDIA_IMAGE);
        promise.resolve(createMap);
    }

    private void writeImage(Bitmap bitmap, String str, CompressFormat compressFormat) {
        FileOutputStream fileOutputStream = null;
        try {
            OutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                bitmap.compress(compressFormat, this.quality.intValue(), fileOutputStream2);
                try {
                    fileOutputStream2.close();
                } catch (Bitmap bitmap2) {
                    bitmap2.printStackTrace();
                }
            } catch (Exception e) {
                bitmap2 = e;
                fileOutputStream = fileOutputStream2;
                try {
                    bitmap2.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    bitmap2 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (String str2) {
                            str2.printStackTrace();
                        }
                    }
                    throw bitmap2;
                }
            } catch (Throwable th2) {
                bitmap2 = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw bitmap2;
            }
        } catch (Exception e2) {
            bitmap2 = e2;
            bitmap2.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    private String writeVideo(Uri uri) {
        Uri uri2;
        OutputStream outputStream = null;
        try {
            uri = getReactApplicationContext().getContentResolver().openInputStream(uri);
            if (uri != null) {
                byte[] bArr = new byte[uri.available()];
                uri.read(bArr);
                uri = C6385c.m26194a(this.mScopedContext.getCacheDir(), "ImagePicker", ".mp4");
                try {
                    OutputStream fileOutputStream = new FileOutputStream(uri);
                    try {
                        fileOutputStream.write(bArr);
                        outputStream = fileOutputStream;
                    } catch (IOException e) {
                        uri2 = uri;
                        uri = e;
                        outputStream = fileOutputStream;
                        try {
                            uri.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Uri uri3) {
                                    uri3.printStackTrace();
                                }
                            }
                            return uri2;
                        } catch (Throwable th) {
                            uri3 = th;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw uri3;
                        }
                    } catch (Throwable th2) {
                        uri3 = th2;
                        outputStream = fileOutputStream;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw uri3;
                    }
                } catch (IOException e3) {
                    IOException iOException = e3;
                    uri2 = uri3;
                    uri3 = iOException;
                    uri3.printStackTrace();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return uri2;
                }
            }
            uri3 = null;
            if (outputStream == null) {
                return uri3;
            }
            try {
                outputStream.close();
                return uri3;
            } catch (IOException e22) {
                e22.printStackTrace();
                return uri3;
            }
        } catch (IOException e4) {
            uri3 = e4;
            uri2 = null;
            uri3.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            return uri2;
        }
    }

    private WritableMap readExif(Uri uri) {
        C0207a c0207a = new C0207a(getReactApplicationContext().getContentResolver().openInputStream(uri));
        uri = Arguments.createMap();
        String[][] strArr = exifTags;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i < length) {
                String[] strArr2 = strArr[i];
                String str = strArr2[1];
                if (c0207a.a(str) != null) {
                    String str2 = strArr2[0];
                    int hashCode = str2.hashCode();
                    if (hashCode == -1325958191) {
                        if (str2.equals("double")) {
                            i2 = 2;
                            switch (i2) {
                                case 0:
                                    uri.putString(str, c0207a.a(str));
                                    break;
                                case 1:
                                    uri.putInt(str, c0207a.a(str, 0));
                                    break;
                                case 2:
                                    uri.putDouble(str, c0207a.a(str, 0.0d));
                                    break;
                                default:
                                    break;
                            }
                        }
                    } else if (hashCode == -891985903) {
                        if (str2.equals("string")) {
                            i2 = 0;
                            switch (i2) {
                                case 0:
                                    uri.putString(str, c0207a.a(str));
                                    break;
                                case 1:
                                    uri.putInt(str, c0207a.a(str, 0));
                                    break;
                                case 2:
                                    uri.putDouble(str, c0207a.a(str, 0.0d));
                                    break;
                                default:
                                    break;
                            }
                        }
                    } else if (hashCode == 104431) {
                        if (str2.equals("int")) {
                            switch (i2) {
                                case 0:
                                    uri.putString(str, c0207a.a(str));
                                    break;
                                case 1:
                                    uri.putInt(str, c0207a.a(str, 0));
                                    break;
                                case 2:
                                    uri.putDouble(str, c0207a.a(str, 0.0d));
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    i2 = -1;
                    switch (i2) {
                        case 0:
                            uri.putString(str, c0207a.a(str));
                            break;
                        case 1:
                            uri.putInt(str, c0207a.a(str, 0));
                            break;
                        case 2:
                            uri.putDouble(str, c0207a.a(str, 0.0d));
                            break;
                        default:
                            break;
                    }
                }
                i++;
            } else {
                double[] a = c0207a.a();
                if (a != null) {
                    uri.putDouble("GPSLatitude", a[0]);
                    uri.putDouble("GPSLongitude", a[1]);
                    uri.putDouble("GPSAltitude", c0207a.a(0.0d));
                }
                return uri;
            }
        }
    }

    private void revokeUriPermissionForCamera() {
        C6271b.m25897a().m25924d().revokeUriPermission(this.mCameraCaptureURI, 3);
    }
}
