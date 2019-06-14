package expo.modules.medialibrary;

import android.net.Uri;
import android.provider.MediaStore.Files;
import com.facebook.share.internal.MessengerShareContentUtility;
import expo.modules.contacts.EXColumns;
import java.util.HashMap;
import java.util.Map;

final class MediaLibraryConstants {
    static final String[] ASSET_PROJECTION = new String[]{EXColumns.ID, "_display_name", "_data", MessengerShareContentUtility.MEDIA_TYPE, "width", "height", "datetaken", "date_modified", "latitude", "longitude", "orientation", SORT_BY_DURATION, "bucket_id"};
    static final String ERROR_IO_EXCEPTION = "E_IO_EXCEPTION";
    static final String ERROR_MEDIA_LIBRARY_CORRUPTED = "E_MEDIA_LIBRARY_CORRUPTED";
    static final String ERROR_NO_ALBUM = "E_NO_ALBUM";
    static final String ERROR_NO_ASSET = "E_NO_ASSET";
    static final String ERROR_NO_PERMISSIONS = "E_NO_PERMISSIONS";
    static final String ERROR_NO_PERMISSIONS_MESSAGE = "Missing CAMERA_ROLL permissions.";
    static final String ERROR_UNABLE_TO_DELETE = "E_UNABLE_TO_DELETE";
    static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    static final String ERROR_UNABLE_TO_SAVE_PERMISSION = "E_UNABLE_TO_SAVE_PERMISSION";
    static final Uri EXTERNAL_CONTENT = Files.getContentUri("external");
    static final String LIBRARY_DID_CHANGE_EVENT = "mediaLibraryDidChange";
    static final Map<String, Integer> MEDIA_TYPES = new C61161();
    static final String MEDIA_TYPE_ALL = "all";
    static final String MEDIA_TYPE_AUDIO = "audio";
    static final String MEDIA_TYPE_PHOTO = "photo";
    static final String MEDIA_TYPE_UNKNOWN = "unknown";
    static final String MEDIA_TYPE_VIDEO = "video";
    static final String SORT_BY_CREATION_TIME = "creationTime";
    static final String SORT_BY_DEFAULT = "default";
    static final String SORT_BY_DURATION = "duration";
    static final String SORT_BY_HEIGHT = "height";
    static final String SORT_BY_ID = "id";
    static final String SORT_BY_MEDIA_TYPE = "mediaType";
    static final String SORT_BY_MODIFICATION_TIME = "modificationTime";
    static final String SORT_BY_WIDTH = "width";
    static final Map<String, String> SORT_KEYS = new C61172();
    public static final String TAG = "MediaLibraryModule";
    static final String[][] exifTags = new String[][]{new String[]{"string", "Artist"}, new String[]{"int", "BitsPerSample"}, new String[]{"int", "Compression"}, new String[]{"string", "Copyright"}, new String[]{"string", "DateTime"}, new String[]{"string", "ImageDescription"}, new String[]{"int", "ImageLength"}, new String[]{"int", "ImageWidth"}, new String[]{"int", "JPEGInterchangeFormat"}, new String[]{"int", "JPEGInterchangeFormatLength"}, new String[]{"string", "Make"}, new String[]{"string", "Model"}, new String[]{"int", "Orientation"}, new String[]{"int", "PhotometricInterpretation"}, new String[]{"int", "PlanarConfiguration"}, new String[]{"double", "PrimaryChromaticities"}, new String[]{"double", "ReferenceBlackWhite"}, new String[]{"int", "ResolutionUnit"}, new String[]{"int", "RowsPerStrip"}, new String[]{"int", "SamplesPerPixel"}, new String[]{"string", "Software"}, new String[]{"int", "StripByteCounts"}, new String[]{"int", "StripOffsets"}, new String[]{"int", "TransferFunction"}, new String[]{"double", "WhitePoint"}, new String[]{"double", "XResolution"}, new String[]{"double", "YCbCrCoefficients"}, new String[]{"int", "YCbCrPositioning"}, new String[]{"int", "YCbCrSubSampling"}, new String[]{"double", "YResolution"}, new String[]{"double", "ApertureValue"}, new String[]{"double", "BrightnessValue"}, new String[]{"string", "CFAPattern"}, new String[]{"int", "ColorSpace"}, new String[]{"string", "ComponentsConfiguration"}, new String[]{"double", "CompressedBitsPerPixel"}, new String[]{"int", "Contrast"}, new String[]{"int", "CustomRendered"}, new String[]{"string", "DateTimeDigitized"}, new String[]{"string", "DateTimeOriginal"}, new String[]{"string", "DeviceSettingDescription"}, new String[]{"double", "DigitalZoomRatio"}, new String[]{"string", "ExifVersion"}, new String[]{"double", "ExposureBiasValue"}, new String[]{"double", "ExposureIndex"}, new String[]{"int", "ExposureMode"}, new String[]{"int", "ExposureProgram"}, new String[]{"double", "ExposureTime"}, new String[]{"double", "FNumber"}, new String[]{"string", "FileSource"}, new String[]{"int", "Flash"}, new String[]{"double", "FlashEnergy"}, new String[]{"string", "FlashpixVersion"}, new String[]{"double", "FocalLength"}, new String[]{"int", "FocalLengthIn35mmFilm"}, new String[]{"int", "FocalPlaneResolutionUnit"}, new String[]{"double", "FocalPlaneXResolution"}, new String[]{"double", "FocalPlaneYResolution"}, new String[]{"int", "GainControl"}, new String[]{"int", "ISOSpeedRatings"}, new String[]{"string", "ImageUniqueID"}, new String[]{"int", "LightSource"}, new String[]{"string", "MakerNote"}, new String[]{"double", "MaxApertureValue"}, new String[]{"int", "MeteringMode"}, new String[]{"int", "NewSubfileType"}, new String[]{"string", "OECF"}, new String[]{"int", "PixelXDimension"}, new String[]{"int", "PixelYDimension"}, new String[]{"string", "RelatedSoundFile"}, new String[]{"int", "Saturation"}, new String[]{"int", "SceneCaptureType"}, new String[]{"string", "SceneType"}, new String[]{"int", "SensingMethod"}, new String[]{"int", "Sharpness"}, new String[]{"double", "ShutterSpeedValue"}, new String[]{"string", "SpatialFrequencyResponse"}, new String[]{"string", "SpectralSensitivity"}, new String[]{"int", "SubfileType"}, new String[]{"string", "SubSecTime"}, new String[]{"string", "SubSecTimeDigitized"}, new String[]{"string", "SubSecTimeOriginal"}, new String[]{"int", "SubjectArea"}, new String[]{"double", "SubjectDistance"}, new String[]{"int", "SubjectDistanceRange"}, new String[]{"int", "SubjectLocation"}, new String[]{"string", "UserComment"}, new String[]{"int", "WhiteBalance"}, new String[]{"int", "GPSAltitudeRef"}, new String[]{"string", "GPSAreaInformation"}, new String[]{"double", "GPSDOP"}, new String[]{"string", "GPSDateStamp"}, new String[]{"double", "GPSDestBearing"}, new String[]{"string", "GPSDestBearingRef"}, new String[]{"double", "GPSDestDistance"}, new String[]{"string", "GPSDestDistanceRef"}, new String[]{"double", "GPSDestLatitude"}, new String[]{"string", "GPSDestLatitudeRef"}, new String[]{"double", "GPSDestLongitude"}, new String[]{"string", "GPSDestLongitudeRef"}, new String[]{"int", "GPSDifferential"}, new String[]{"double", "GPSImgDirection"}, new String[]{"string", "GPSImgDirectionRef"}, new String[]{"string", "GPSLatitudeRef"}, new String[]{"string", "GPSLongitudeRef"}, new String[]{"string", "GPSMapDatum"}, new String[]{"string", "GPSMeasureMode"}, new String[]{"string", "GPSProcessingMethod"}, new String[]{"string", "GPSSatellites"}, new String[]{"double", "GPSSpeed"}, new String[]{"string", "GPSSpeedRef"}, new String[]{"string", "GPSStatus"}, new String[]{"string", "GPSTimeStamp"}, new String[]{"double", "GPSTrack"}, new String[]{"string", "GPSTrackRef"}, new String[]{"string", "GPSVersionID"}, new String[]{"string", "InteroperabilityIndex"}, new String[]{"int", "ThumbnailImageLength"}, new String[]{"int", "ThumbnailImageWidth"}, new String[]{"int", "DNGVersion"}, new String[]{"int", "DefaultCropSize"}, new String[]{"int", "PreviewImageStart"}, new String[]{"int", "PreviewImageLength"}, new String[]{"int", "AspectFrame"}, new String[]{"int", "SensorBottomBorder"}, new String[]{"int", "SensorLeftBorder"}, new String[]{"int", "SensorRightBorder"}, new String[]{"int", "SensorTopBorder"}, new String[]{"int", "ISO"}};

    /* renamed from: expo.modules.medialibrary.MediaLibraryConstants$1 */
    static class C61161 extends HashMap<String, Integer> {
        C61161() {
            put(MediaLibraryConstants.MEDIA_TYPE_AUDIO, Integer.valueOf(2));
            put("photo", Integer.valueOf(1));
            put("video", Integer.valueOf(3));
            put("unknown", Integer.valueOf(0));
        }
    }

    /* renamed from: expo.modules.medialibrary.MediaLibraryConstants$2 */
    static class C61172 extends HashMap<String, String> {
        C61172() {
            put(MediaLibraryConstants.SORT_BY_DEFAULT, EXColumns.ID);
            put("id", EXColumns.ID);
            put(MediaLibraryConstants.SORT_BY_CREATION_TIME, "datetaken");
            put(MediaLibraryConstants.SORT_BY_MODIFICATION_TIME, "date_modified");
            put(MediaLibraryConstants.SORT_BY_MEDIA_TYPE, MessengerShareContentUtility.MEDIA_TYPE);
            put("width", "width");
            put("height", "height");
            put(MediaLibraryConstants.SORT_BY_DURATION, MediaLibraryConstants.SORT_BY_DURATION);
        }
    }

    MediaLibraryConstants() {
    }
}
