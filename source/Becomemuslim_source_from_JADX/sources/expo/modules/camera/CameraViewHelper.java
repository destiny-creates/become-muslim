package expo.modules.camera;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.CamcorderProfile;
import android.os.Bundle;
import android.support.p018e.C0207a;
import android.view.ViewGroup;
import expo.modules.camera.events.BarCodeScannedEvent;
import expo.modules.camera.events.CameraMountErrorEvent;
import expo.modules.camera.events.CameraReadyEvent;
import expo.modules.camera.events.FaceDetectionErrorEvent;
import expo.modules.camera.events.FacesDetectedEvent;
import expo.modules.camera.events.PictureSavedEvent;
import expo.p304a.p305a.p306a.C5991a;
import expo.p307b.p308a.C6019c;
import expo.p307b.p311d.C6024a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CameraViewHelper {
    private static final String[][] exifTags = new String[][]{new String[]{"string", "Artist"}, new String[]{"int", "BitsPerSample"}, new String[]{"int", "Compression"}, new String[]{"string", "Copyright"}, new String[]{"string", "DateTime"}, new String[]{"string", "ImageDescription"}, new String[]{"int", "ImageLength"}, new String[]{"int", "ImageWidth"}, new String[]{"int", "JPEGInterchangeFormat"}, new String[]{"int", "JPEGInterchangeFormatLength"}, new String[]{"string", "Make"}, new String[]{"string", "Model"}, new String[]{"int", "Orientation"}, new String[]{"int", "PhotometricInterpretation"}, new String[]{"int", "PlanarConfiguration"}, new String[]{"double", "PrimaryChromaticities"}, new String[]{"double", "ReferenceBlackWhite"}, new String[]{"int", "ResolutionUnit"}, new String[]{"int", "RowsPerStrip"}, new String[]{"int", "SamplesPerPixel"}, new String[]{"string", "Software"}, new String[]{"int", "StripByteCounts"}, new String[]{"int", "StripOffsets"}, new String[]{"int", "TransferFunction"}, new String[]{"double", "WhitePoint"}, new String[]{"double", "XResolution"}, new String[]{"double", "YCbCrCoefficients"}, new String[]{"int", "YCbCrPositioning"}, new String[]{"int", "YCbCrSubSampling"}, new String[]{"double", "YResolution"}, new String[]{"double", "ApertureValue"}, new String[]{"double", "BrightnessValue"}, new String[]{"string", "CFAPattern"}, new String[]{"int", "ColorSpace"}, new String[]{"string", "ComponentsConfiguration"}, new String[]{"double", "CompressedBitsPerPixel"}, new String[]{"int", "Contrast"}, new String[]{"int", "CustomRendered"}, new String[]{"string", "DateTimeDigitized"}, new String[]{"string", "DateTimeOriginal"}, new String[]{"string", "DeviceSettingDescription"}, new String[]{"double", "DigitalZoomRatio"}, new String[]{"string", "ExifVersion"}, new String[]{"double", "ExposureBiasValue"}, new String[]{"double", "ExposureIndex"}, new String[]{"int", "ExposureMode"}, new String[]{"int", "ExposureProgram"}, new String[]{"double", "ExposureTime"}, new String[]{"double", "FNumber"}, new String[]{"string", "FileSource"}, new String[]{"int", "Flash"}, new String[]{"double", "FlashEnergy"}, new String[]{"string", "FlashpixVersion"}, new String[]{"double", "FocalLength"}, new String[]{"int", "FocalLengthIn35mmFilm"}, new String[]{"int", "FocalPlaneResolutionUnit"}, new String[]{"double", "FocalPlaneXResolution"}, new String[]{"double", "FocalPlaneYResolution"}, new String[]{"int", "GainControl"}, new String[]{"int", "ISOSpeedRatings"}, new String[]{"string", "ImageUniqueID"}, new String[]{"int", "LightSource"}, new String[]{"string", "MakerNote"}, new String[]{"double", "MaxApertureValue"}, new String[]{"int", "MeteringMode"}, new String[]{"int", "NewSubfileType"}, new String[]{"string", "OECF"}, new String[]{"int", "PixelXDimension"}, new String[]{"int", "PixelYDimension"}, new String[]{"string", "RelatedSoundFile"}, new String[]{"int", "Saturation"}, new String[]{"int", "SceneCaptureType"}, new String[]{"string", "SceneType"}, new String[]{"int", "SensingMethod"}, new String[]{"int", "Sharpness"}, new String[]{"double", "ShutterSpeedValue"}, new String[]{"string", "SpatialFrequencyResponse"}, new String[]{"string", "SpectralSensitivity"}, new String[]{"int", "SubfileType"}, new String[]{"string", "SubSecTime"}, new String[]{"string", "SubSecTimeDigitized"}, new String[]{"string", "SubSecTimeOriginal"}, new String[]{"int", "SubjectArea"}, new String[]{"double", "SubjectDistance"}, new String[]{"int", "SubjectDistanceRange"}, new String[]{"int", "SubjectLocation"}, new String[]{"string", "UserComment"}, new String[]{"int", "WhiteBalance"}, new String[]{"int", "GPSAltitudeRef"}, new String[]{"string", "GPSAreaInformation"}, new String[]{"double", "GPSDOP"}, new String[]{"string", "GPSDateStamp"}, new String[]{"double", "GPSDestBearing"}, new String[]{"string", "GPSDestBearingRef"}, new String[]{"double", "GPSDestDistance"}, new String[]{"string", "GPSDestDistanceRef"}, new String[]{"double", "GPSDestLatitude"}, new String[]{"string", "GPSDestLatitudeRef"}, new String[]{"double", "GPSDestLongitude"}, new String[]{"string", "GPSDestLongitudeRef"}, new String[]{"int", "GPSDifferential"}, new String[]{"double", "GPSImgDirection"}, new String[]{"string", "GPSImgDirectionRef"}, new String[]{"string", "GPSLatitudeRef"}, new String[]{"string", "GPSLongitudeRef"}, new String[]{"string", "GPSMapDatum"}, new String[]{"string", "GPSMeasureMode"}, new String[]{"string", "GPSProcessingMethod"}, new String[]{"string", "GPSSatellites"}, new String[]{"double", "GPSSpeed"}, new String[]{"string", "GPSSpeedRef"}, new String[]{"string", "GPSStatus"}, new String[]{"string", "GPSTimeStamp"}, new String[]{"double", "GPSTrack"}, new String[]{"string", "GPSTrackRef"}, new String[]{"string", "GPSVersionID"}, new String[]{"string", "InteroperabilityIndex"}, new String[]{"int", "ThumbnailImageLength"}, new String[]{"int", "ThumbnailImageWidth"}, new String[]{"int", "DNGVersion"}, new String[]{"int", "DefaultCropSize"}, new String[]{"int", "PreviewImageStart"}, new String[]{"int", "PreviewImageLength"}, new String[]{"int", "AspectFrame"}, new String[]{"int", "SensorBottomBorder"}, new String[]{"int", "SensorLeftBorder"}, new String[]{"int", "SensorRightBorder"}, new String[]{"int", "SensorTopBorder"}, new String[]{"int", "ISO"}};

    public static void emitMountErrorEvent(C5991a c5991a, ViewGroup viewGroup, String str) {
        c5991a.mo5141a(viewGroup.getId(), CameraMountErrorEvent.obtain(str));
    }

    public static void emitCameraReadyEvent(C5991a c5991a, ViewGroup viewGroup) {
        c5991a.mo5141a(viewGroup.getId(), CameraReadyEvent.obtain());
    }

    public static void emitBarCodeReadEvent(C5991a c5991a, ViewGroup viewGroup, C6019c c6019c) {
        c5991a.mo5141a(viewGroup.getId(), BarCodeScannedEvent.obtain(viewGroup.getId(), c6019c));
    }

    public static void emitFacesDetectedEvent(C5991a c5991a, ViewGroup viewGroup, List<Bundle> list) {
        c5991a.mo5141a(viewGroup.getId(), FacesDetectedEvent.obtain(viewGroup.getId(), list));
    }

    public static void emitFaceDetectionErrorEvent(C5991a c5991a, ViewGroup viewGroup, C6024a c6024a) {
        c5991a.mo5141a(viewGroup.getId(), FaceDetectionErrorEvent.obtain(c6024a));
    }

    public static void emitPictureSavedEvent(C5991a c5991a, ViewGroup viewGroup, Bundle bundle) {
        c5991a.mo5141a(viewGroup.getId(), PictureSavedEvent.obtain(bundle));
    }

    public static int getCorrectCameraRotation(int i, int i2) {
        if (i2 == 1) {
            return ((i - 90) + 360) % 360;
        }
        return (((-i) + 90) + 360) % 360;
    }

    public static CamcorderProfile getCamcorderProfile(int i, int i2) {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(i, 1);
        switch (i2) {
            case 0:
                return CamcorderProfile.get(i, 8);
            case 1:
                return CamcorderProfile.get(i, 6);
            case 2:
                return CamcorderProfile.get(i, 5);
            case 3:
                return CamcorderProfile.get(i, 4);
            case 4:
                camcorderProfile = CamcorderProfile.get(i, 4);
                camcorderProfile.videoFrameWidth = 640;
                return camcorderProfile;
            default:
                return camcorderProfile;
        }
    }

    public static Bundle getExifData(C0207a c0207a) {
        Bundle bundle = new Bundle();
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
                                    bundle.putString(str, c0207a.a(str));
                                    break;
                                case 1:
                                    bundle.putInt(str, c0207a.a(str, 0));
                                    break;
                                case 2:
                                    bundle.putDouble(str, c0207a.a(str, 0.0d));
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
                                    bundle.putString(str, c0207a.a(str));
                                    break;
                                case 1:
                                    bundle.putInt(str, c0207a.a(str, 0));
                                    break;
                                case 2:
                                    bundle.putDouble(str, c0207a.a(str, 0.0d));
                                    break;
                                default:
                                    break;
                            }
                        }
                    } else if (hashCode == 104431) {
                        if (str2.equals("int")) {
                            switch (i2) {
                                case 0:
                                    bundle.putString(str, c0207a.a(str));
                                    break;
                                case 1:
                                    bundle.putInt(str, c0207a.a(str, 0));
                                    break;
                                case 2:
                                    bundle.putDouble(str, c0207a.a(str, 0.0d));
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    i2 = -1;
                    switch (i2) {
                        case 0:
                            bundle.putString(str, c0207a.a(str));
                            break;
                        case 1:
                            bundle.putInt(str, c0207a.a(str, 0));
                            break;
                        case 2:
                            bundle.putDouble(str, c0207a.a(str, 0.0d));
                            break;
                        default:
                            break;
                    }
                }
                i++;
            } else {
                double[] a = c0207a.a();
                if (a != null) {
                    bundle.putDouble("GPSLatitude", a[0]);
                    bundle.putDouble("GPSLongitude", a[1]);
                    bundle.putDouble("GPSAltitude", c0207a.a(0.0d));
                }
                return bundle;
            }
        }
    }

    public static Bitmap generateSimulatorPhoto(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        i = (float) i;
        i2 = (float) i2;
        canvas.drawRect(0.0f, 0.0f, i, i2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(-256);
        paint2.setTextSize(35.0f);
        canvas.drawText(new SimpleDateFormat("dd.MM.yy HH:mm:ss", Locale.US).format(Calendar.getInstance().getTime()), i * 1036831949, i2 * 1063675494, paint2);
        return createBitmap;
    }
}
