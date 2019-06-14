package expo.modules.medialibrary;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p018e.C0207a;
import android.text.TextUtils;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.MessengerShareContentUtility;
import expo.modules.contacts.EXColumns;
import expo.p304a.C6009f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class MediaLibraryUtils {
    static final FileStrategy copyStrategy = new C74251();
    static final FileStrategy moveStrategy = new C74262();

    interface FileStrategy {
        File apply(File file, File file2, Context context);
    }

    /* renamed from: expo.modules.medialibrary.MediaLibraryUtils$1 */
    static class C74251 implements FileStrategy {
        C74251() {
        }

        public File apply(File file, File file2, Context context) {
            return MediaLibraryUtils.safeCopyFile(file, file2);
        }
    }

    /* renamed from: expo.modules.medialibrary.MediaLibraryUtils$2 */
    static class C74262 implements FileStrategy {
        C74262() {
        }

        public File apply(File file, File file2, Context context) {
            file2 = MediaLibraryUtils.safeMoveFile(file, file2);
            context.getContentResolver().delete(MediaLibraryConstants.EXTERNAL_CONTENT, "_data=?", new String[]{file.getPath()});
            return file2;
        }
    }

    static String exportMediaType(int i) {
        switch (i) {
            case 1:
                return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
            case 2:
            case 4:
                return "audio";
            case 3:
                return "video";
            default:
                return "unknown";
        }
    }

    MediaLibraryUtils() {
    }

    static String[] getFileNameAndExtension(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            lastIndexOf = str.length();
        }
        String substring = str.substring(lastIndexOf);
        str = str.substring(0, lastIndexOf);
        return new String[]{str, substring};
    }

    static File safeMoveFile(File file, File file2) {
        file2 = safeCopyFile(file, file2);
        file.delete();
        return file2;
    }

    static File safeCopyFile(File file, File file2) {
        Throwable th;
        File file3 = new File(file2, file.getName());
        String[] fileNameAndExtension = getFileNameAndExtension(file.getName());
        int i = 0;
        while (file3.exists()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(fileNameAndExtension[0]);
            stringBuilder.append("_");
            stringBuilder.append(i);
            stringBuilder.append(fileNameAndExtension[1]);
            file3 = new File(file2, stringBuilder.toString());
            i++;
            if (i > 32767) {
                throw new IOException("File name suffix limit reached (32767)");
            }
        }
        file = new FileInputStream(file).getChannel();
        try {
            FileChannel channel = new FileOutputStream(file3).getChannel();
            try {
                if (file.transferTo(0, file.size(), channel) == file.size()) {
                    if (channel != null) {
                        channel.close();
                    }
                    if (file != null) {
                        file.close();
                    }
                    return file3;
                }
                file3.delete();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Could not save file to ");
                stringBuilder2.append(file2);
                stringBuilder2.append(" Not enough space.");
                throw new IOException(stringBuilder2.toString());
            } catch (Throwable th2) {
                Throwable th3 = th2;
                th2 = file2;
                file2 = th3;
            }
            if (channel != null) {
                if (th2 != null) {
                    channel.close();
                } else {
                    channel.close();
                }
            }
            throw file2;
            throw file2;
        } catch (File file22) {
            File file4 = file22;
            try {
            } catch (File file5) {
                file4.addSuppressed(file5);
            }
        }
    }

    static void queryAssetInfo(Context context, String str, String[] strArr, boolean z, C6009f c6009f) {
        try {
            context = context.getContentResolver().query(MediaLibraryConstants.EXTERNAL_CONTENT, MediaLibraryConstants.ASSET_PROJECTION, str, strArr, null);
            if (context == null) {
                c6009f.m25152a("E_UNABLE_TO_LOAD", "Could not get asset. Query returns null.");
            } else if (context.getCount() == 1) {
                context.moveToFirst();
                Object arrayList = new ArrayList();
                putAssetsInfo(context, arrayList, 1, 0, z);
                c6009f.mo5137a(arrayList);
            } else {
                c6009f.mo5137a((Object) null);
            }
            if (context != null) {
                context.close();
            }
        } catch (Context context2) {
            c6009f.mo5138a("E_UNABLE_TO_LOAD_PERMISSION", "Could not get asset: need READ_EXTERNAL_STORAGE permission.", context2);
        } catch (Context context22) {
            c6009f.mo5138a("E_IO_EXCEPTION", "Could not read file or parse EXIF tags", context22);
        } catch (Context context222) {
            str.addSuppressed(context222);
        }
    }

    static void putAssetsInfo(Cursor cursor, ArrayList<Bundle> arrayList, int i, int i2, boolean z) {
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex(EXColumns.ID);
        int columnIndex2 = cursor2.getColumnIndex("_display_name");
        int columnIndex3 = cursor2.getColumnIndex(MessengerShareContentUtility.MEDIA_TYPE);
        int columnIndex4 = cursor2.getColumnIndex("width");
        int columnIndex5 = cursor2.getColumnIndex("height");
        int columnIndex6 = cursor2.getColumnIndex("latitude");
        int columnIndex7 = cursor2.getColumnIndex("longitude");
        int columnIndex8 = cursor2.getColumnIndex("datetaken");
        int columnIndex9 = cursor2.getColumnIndex("date_modified");
        int columnIndex10 = cursor2.getColumnIndex("duration");
        int columnIndex11 = cursor2.getColumnIndex("orientation");
        int columnIndex12 = cursor2.getColumnIndex("_data");
        int columnIndex13 = cursor2.getColumnIndex("bucket_id");
        if (cursor2.moveToPosition(i2)) {
            int i3 = i;
            int i4 = 0;
            while (i4 < i3 && !cursor.isAfterLast()) {
                StringBuilder stringBuilder = new StringBuilder();
                int i5 = i4;
                stringBuilder.append("file://");
                stringBuilder.append(cursor2.getString(columnIndex12));
                String stringBuilder2 = stringBuilder.toString();
                i3 = cursor2.getInt(columnIndex3);
                int i6 = columnIndex3;
                int i7 = columnIndex4;
                int i8 = columnIndex5;
                int[] maybeRotateAssetSize = maybeRotateAssetSize(cursor2.getInt(columnIndex4), cursor2.getInt(columnIndex5), cursor2.getInt(columnIndex11));
                Bundle bundle = new Bundle();
                int i9 = columnIndex11;
                bundle.putString("id", cursor2.getString(columnIndex));
                bundle.putString("filename", cursor2.getString(columnIndex2));
                bundle.putString("uri", stringBuilder2);
                bundle.putString("mediaType", exportMediaType(i3));
                int i10 = columnIndex;
                int i11 = columnIndex12;
                bundle.putLong("width", (long) maybeRotateAssetSize[0]);
                bundle.putLong("height", (long) maybeRotateAssetSize[1]);
                bundle.putLong("creationTime", cursor2.getLong(columnIndex8));
                bundle.putDouble("modificationTime", ((double) cursor2.getLong(columnIndex9)) * 1000.0d);
                bundle.putDouble("duration", ((double) cursor2.getInt(columnIndex10)) / 1000.0d);
                bundle.putString("albumId", cursor2.getString(columnIndex13));
                if (z) {
                    if (i3 == 1) {
                        getExifFullInfo(cursor2, bundle);
                    }
                    bundle.putString("localUri", stringBuilder2);
                    double d = cursor2.getDouble(columnIndex6);
                    double d2 = cursor2.getDouble(columnIndex7);
                    if (d == 0.0d) {
                        if (d2 == 0.0d) {
                            bundle.putParcelable(PlaceFields.LOCATION, null);
                        }
                    }
                    Parcelable bundle2 = new Bundle();
                    bundle2.putDouble("latitude", d);
                    bundle2.putDouble("longitude", d2);
                    bundle.putParcelable(PlaceFields.LOCATION, bundle2);
                }
                cursor.moveToNext();
                arrayList.add(bundle);
                i4 = i5 + 1;
                columnIndex3 = i6;
                columnIndex4 = i7;
                columnIndex5 = i8;
                columnIndex11 = i9;
                columnIndex = i10;
                columnIndex12 = i11;
                i3 = i;
            }
        }
    }

    static String convertSortByKey(String str) {
        if (MediaLibraryConstants.SORT_KEYS.containsKey(str)) {
            return (String) MediaLibraryConstants.SORT_KEYS.get(str);
        }
        throw new IllegalArgumentException(String.format("SortBy key \"%s\" is not supported!", new Object[]{str}));
    }

    static Integer convertMediaType(String str) {
        if (MediaLibraryConstants.MEDIA_TYPES.containsKey(str)) {
            return (Integer) MediaLibraryConstants.MEDIA_TYPES.get(str);
        }
        throw new IllegalArgumentException(String.format("MediaType \"%s\" is not supported!", new Object[]{str}));
    }

    static int[] maybeRotateAssetSize(int i, int i2, int i3) {
        if (Math.abs(i3) % RotationOptions.ROTATE_180 == 90) {
            return new int[]{i2, i};
        }
        return new int[]{i, i2};
    }

    static String mapOrderDescriptor(List list) {
        Iterable arrayList = new ArrayList(20);
        for (Object next : list) {
            if (next instanceof String) {
                String convertSortByKey = convertSortByKey((String) next);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(convertSortByKey);
                stringBuilder.append(" DESC");
                arrayList.add(stringBuilder.toString());
            } else if (next instanceof Object[]) {
                Object[] objArr = (Object[]) next;
                if (objArr.length == 2) {
                    String convertSortByKey2 = convertSortByKey((String) objArr[0]);
                    boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(convertSortByKey2);
                    stringBuilder2.append(booleanValue ? " ASC" : " DESC");
                    arrayList.add(stringBuilder2.toString());
                } else {
                    throw new IllegalArgumentException("Array sortBy in assetsOptions has invalid layout.");
                }
            } else {
                throw new IllegalArgumentException("Array sortBy in assetsOptions contains invalid items.");
            }
        }
        return TextUtils.join(",", arrayList);
    }

    static void getExifFullInfo(Cursor cursor, Bundle bundle) {
        cursor = new C0207a(new File(cursor.getString(cursor.getColumnIndex("_data"))).getPath());
        Parcelable bundle2 = new Bundle();
        for (String[] strArr : MediaLibraryConstants.exifTags) {
            String str = strArr[1];
            if (cursor.a(str) != null) {
                Object obj;
                String str2 = strArr[0];
                int hashCode = str2.hashCode();
                if (hashCode == -1325958191) {
                    if (str2.equals("double")) {
                        obj = 2;
                        switch (obj) {
                            case null:
                                bundle2.putString(str, cursor.a(str));
                                break;
                            case 1:
                                bundle2.putInt(str, cursor.a(str, 0));
                                break;
                            case 2:
                                bundle2.putDouble(str, cursor.a(str, 0.0d));
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == -891985903) {
                    if (str2.equals("string")) {
                        obj = null;
                        switch (obj) {
                            case null:
                                bundle2.putString(str, cursor.a(str));
                                break;
                            case 1:
                                bundle2.putInt(str, cursor.a(str, 0));
                                break;
                            case 2:
                                bundle2.putDouble(str, cursor.a(str, 0.0d));
                                break;
                            default:
                                break;
                        }
                    }
                } else if (hashCode == 104431) {
                    if (str2.equals("int")) {
                        obj = 1;
                        switch (obj) {
                            case null:
                                bundle2.putString(str, cursor.a(str));
                                break;
                            case 1:
                                bundle2.putInt(str, cursor.a(str, 0));
                                break;
                            case 2:
                                bundle2.putDouble(str, cursor.a(str, 0.0d));
                                break;
                            default:
                                break;
                        }
                    }
                }
                obj = -1;
                switch (obj) {
                    case null:
                        bundle2.putString(str, cursor.a(str));
                        break;
                    case 1:
                        bundle2.putInt(str, cursor.a(str, 0));
                        break;
                    case 2:
                        bundle2.putDouble(str, cursor.a(str, 0.0d));
                        break;
                    default:
                        break;
                }
            }
        }
        bundle.putParcelable("exif", bundle2);
    }

    static void queryAlbum(Context context, String str, String[] strArr, C6009f c6009f) {
        Object bundle = new Bundle();
        try {
            context = context.getContentResolver().query(MediaLibraryConstants.EXTERNAL_CONTENT, new String[]{"bucket_id", "bucket_display_name", "COUNT(*)"}, str, strArr, "*/ GROUP BY bucket_id ORDER BY bucket_display_name");
            if (context == null) {
                c6009f.m25152a("E_UNABLE_TO_LOAD", "Could not get album. Query is incorrect.");
                if (context != null) {
                    context.close();
                }
            } else if (context.moveToNext() == null) {
                c6009f.mo5137a((Object) null);
                if (context != null) {
                    context.close();
                }
            } else {
                strArr = context.getColumnIndex("bucket_id");
                int columnIndex = context.getColumnIndex("bucket_display_name");
                int columnIndex2 = context.getColumnIndex("COUNT(*)");
                bundle.putString("id", context.getString(strArr));
                bundle.putString("title", context.getString(columnIndex));
                bundle.putInt("assetCount", context.getInt(columnIndex2));
                c6009f.mo5137a(bundle);
                if (context != null) {
                    context.close();
                }
            }
        } catch (Context context2) {
            c6009f.mo5138a("E_UNABLE_TO_LOAD_PERMISSION", "Could not get albums: need READ_EXTERNAL_STORAGE permission.", context2);
        } catch (Context context22) {
            str.addSuppressed(context22);
        }
    }

    static void deleteAssets(Context context, String str, String[] strArr, C6009f c6009f) {
        try {
            str = context.getContentResolver().query(MediaLibraryConstants.EXTERNAL_CONTENT, new String[]{"_data"}, str, strArr, null);
            if (str == null) {
                c6009f.m25152a("E_UNABLE_TO_LOAD", "Could not get album. Query returns null.");
            } else {
                while (str.moveToNext()) {
                    String string = str.getString(str.getColumnIndex("_data"));
                    if (new File(string).delete()) {
                        ContentResolver contentResolver = context.getContentResolver();
                        Uri uri = MediaLibraryConstants.EXTERNAL_CONTENT;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("_data = \"");
                        stringBuilder.append(string);
                        stringBuilder.append("\"");
                        contentResolver.delete(uri, stringBuilder.toString(), null);
                    } else {
                        c6009f.m25152a("E_UNABLE_TO_DELETE", "Could not delete file.");
                        if (str != null) {
                            str.close();
                        }
                        return;
                    }
                }
                c6009f.mo5137a(Boolean.valueOf(true));
            }
            if (str != null) {
                str.close();
            }
        } catch (Context context2) {
            c6009f.mo5138a("E_UNABLE_TO_SAVE_PERMISSION", "Could not delete asset: need WRITE_EXTERNAL_STORAGE permission.", context2);
        } catch (String str2) {
            strArr.addSuppressed(str2);
        }
    }

    static String getInPart(String[] strArr) {
        strArr = new String[strArr.length];
        Arrays.fill(strArr, "?");
        return TextUtils.join(",", strArr);
    }

    static List<File> getAssetsById(Context context, C6009f c6009f, String... strArr) {
        C6009f c6009f2;
        String[] strArr2 = new String[]{"_data"};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_id IN ( ");
        stringBuilder.append(getInPart(strArr));
        stringBuilder.append(" )");
        context = context.getContentResolver().query(MediaLibraryConstants.EXTERNAL_CONTENT, strArr2, stringBuilder.toString(), strArr, null);
        if (context == null) {
            try {
                c6009f.m25152a("E_UNABLE_TO_LOAD", "Could not get assets. Query returns null.");
                if (context != null) {
                    context.close();
                }
                return null;
            } catch (Context context2) {
                c6009f2.addSuppressed(context2);
            }
        } else if (context2.getCount() != strArr.length) {
            c6009f.m25152a("E_NO_ASSET", "Could not get all of the requested assets");
            if (context2 != null) {
                context2.close();
            }
            return null;
        } else {
            strArr = new ArrayList();
            while (context2.moveToNext()) {
                String string = context2.getString(context2.getColumnIndex("_data"));
                File file = new File(string);
                if (file.exists()) {
                    if (file.isFile()) {
                        strArr.add(file);
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Path ");
                stringBuilder2.append(string);
                stringBuilder2.append(" does not exist or isn't file.");
                c6009f.m25152a("E_UNABLE_TO_LOAD", stringBuilder2.toString());
                if (context2 != null) {
                    context2.close();
                }
                return null;
            }
            if (context2 != null) {
                context2.close();
            }
            return strArr;
        }
    }
}
