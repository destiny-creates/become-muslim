package com.facebook.react.modules.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.logging.FLog;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.internal.MessengerShareContentUtility;
import expo.modules.contacts.EXColumns;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

@ReactModule(name = "CameraRollManager")
public class CameraRollManager extends ReactContextBaseJavaModule {
    private static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    private static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    private static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    public static final boolean IS_JELLY_BEAN_OR_LATER = (VERSION.SDK_INT >= 16);
    protected static final String NAME = "CameraRollManager";
    private static final String[] PROJECTION;
    private static final String SELECTION_BUCKET = "bucket_display_name = ?";
    private static final String SELECTION_DATE_TAKEN = "datetaken < ?";

    private static class GetPhotosTask extends GuardedAsyncTask<Void, Void> {
        private final String mAfter;
        private final String mAssetType;
        private final Context mContext;
        private final int mFirst;
        private final String mGroupName;
        private final ReadableArray mMimeTypes;
        private final Promise mPromise;

        private GetPhotosTask(ReactContext reactContext, int i, String str, String str2, ReadableArray readableArray, String str3, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mFirst = i;
            this.mAfter = str;
            this.mGroupName = str2;
            this.mMimeTypes = readableArray;
            this.mPromise = promise;
            this.mAssetType = str3;
        }

        protected void doInBackgroundGuarded(Void... voidArr) {
            voidArr = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            List arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.mAfter)) {
                voidArr.append(" AND datetaken < ?");
                arrayList.add(this.mAfter);
            }
            if (!TextUtils.isEmpty(this.mGroupName)) {
                voidArr.append(" AND bucket_display_name = ?");
                arrayList.add(this.mGroupName);
            }
            if (this.mMimeTypes != null && this.mMimeTypes.size() > 0) {
                voidArr.append(" AND mime_type IN (");
                for (int i = 0; i < this.mMimeTypes.size(); i++) {
                    voidArr.append("?,");
                    arrayList.add(this.mMimeTypes.getString(i));
                }
                voidArr.replace(voidArr.length() - 1, voidArr.length(), ")");
            }
            WritableMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.mContext.getContentResolver();
            try {
                Uri uri = (this.mAssetType == null || !this.mAssetType.equals("Videos")) ? Media.EXTERNAL_CONTENT_URI : Video.Media.EXTERNAL_CONTENT_URI;
                Uri uri2 = uri;
                String[] access$200 = CameraRollManager.PROJECTION;
                String stringBuilder = voidArr.toString();
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                voidArr = new StringBuilder();
                voidArr.append("datetaken DESC, date_modified DESC LIMIT ");
                voidArr.append(this.mFirst + 1);
                voidArr = contentResolver.query(uri2, access$200, stringBuilder, strArr, voidArr.toString());
                if (voidArr == null) {
                    this.mPromise.reject(CameraRollManager.ERROR_UNABLE_TO_LOAD, "Could not get photos");
                    return;
                }
                CameraRollManager.putEdges(contentResolver, voidArr, writableNativeMap, this.mFirst, this.mAssetType);
                CameraRollManager.putPageInfo(voidArr, writableNativeMap, this.mFirst);
                voidArr.close();
                this.mPromise.resolve(writableNativeMap);
            } catch (Void[] voidArr2) {
                this.mPromise.reject(CameraRollManager.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get photos: need READ_EXTERNAL_STORAGE permission", voidArr2);
            } catch (Throwable th) {
                voidArr2.close();
                this.mPromise.resolve(writableNativeMap);
            }
        }
    }

    private static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;
        private final Promise mPromise;
        private final Uri mUri;

        /* renamed from: com.facebook.react.modules.camera.CameraRollManager$SaveToCameraRoll$1 */
        class C19321 implements OnScanCompletedListener {
            C19321() {
            }

            public void onScanCompleted(String str, Uri uri) {
                if (uri != null) {
                    SaveToCameraRoll.this.mPromise.resolve(uri.toString());
                } else {
                    SaveToCameraRoll.this.mPromise.reject(CameraRollManager.ERROR_UNABLE_TO_SAVE, "Could not add image to gallery");
                }
            }
        }

        public SaveToCameraRoll(ReactContext reactContext, Uri uri, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUri = uri;
            this.mPromise = promise;
        }

        protected void doInBackgroundGuarded(Void... voidArr) {
            FileChannel channel;
            Throwable e;
            Throwable th;
            voidArr = new File(this.mUri.getPath());
            FileChannel fileChannel = null;
            try {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                externalStoragePublicDirectory.mkdirs();
                if (externalStoragePublicDirectory.isDirectory()) {
                    String substring;
                    int i;
                    File file = new File(externalStoragePublicDirectory, voidArr.getName());
                    String name = voidArr.getName();
                    if (name.indexOf(46) >= 0) {
                        substring = name.substring(0, name.lastIndexOf(46));
                        i = 0;
                        String str = substring;
                        substring = name.substring(name.lastIndexOf(46));
                        name = str;
                    } else {
                        substring = "";
                        i = 0;
                    }
                    while (!file.createNewFile()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(name);
                        stringBuilder.append("_");
                        int i2 = i + 1;
                        stringBuilder.append(i);
                        stringBuilder.append(substring);
                        file = new File(externalStoragePublicDirectory, stringBuilder.toString());
                        i = i2;
                    }
                    voidArr = new FileInputStream(voidArr).getChannel();
                    try {
                        channel = new FileOutputStream(file).getChannel();
                        try {
                            channel.transferFrom(voidArr, 0, voidArr.size());
                            voidArr.close();
                            channel.close();
                            MediaScannerConnection.scanFile(this.mContext, new String[]{file.getAbsolutePath()}, null, new C19321());
                            if (voidArr != null && voidArr.isOpen()) {
                                try {
                                    voidArr.close();
                                } catch (Throwable e2) {
                                    FLog.m5675e(ReactConstants.TAG, "Could not close input channel", e2);
                                }
                            }
                            if (!(channel == null || channel.isOpen() == null)) {
                                try {
                                    channel.close();
                                } catch (Throwable e22) {
                                    FLog.m5675e(ReactConstants.TAG, "Could not close output channel", e22);
                                }
                            }
                        } catch (Throwable e3) {
                            th = e3;
                            fileChannel = voidArr;
                            e22 = th;
                            try {
                                this.mPromise.reject(e22);
                                try {
                                    fileChannel.close();
                                } catch (Throwable e222) {
                                    FLog.m5675e(ReactConstants.TAG, "Could not close input channel", e222);
                                }
                                channel.close();
                            } catch (Throwable th2) {
                                voidArr = th2;
                                if (fileChannel != null && fileChannel.isOpen()) {
                                    try {
                                        fileChannel.close();
                                    } catch (Throwable e32) {
                                        FLog.m5675e(ReactConstants.TAG, "Could not close input channel", e32);
                                    }
                                }
                                if (channel != null && channel.isOpen()) {
                                    try {
                                        channel.close();
                                    } catch (Throwable e322) {
                                        FLog.m5675e(ReactConstants.TAG, "Could not close output channel", e322);
                                    }
                                }
                                throw voidArr;
                            }
                        } catch (Throwable e3222) {
                            th = e3222;
                            fileChannel = voidArr;
                            voidArr = th;
                            fileChannel.close();
                            channel.close();
                            throw voidArr;
                        }
                    } catch (Throwable e4) {
                        fileChannel = voidArr;
                        e222 = e4;
                        channel = null;
                        this.mPromise.reject(e222);
                        if (!(fileChannel == null || fileChannel.isOpen() == null)) {
                            fileChannel.close();
                        }
                        if (!(channel == null || channel.isOpen() == null)) {
                            channel.close();
                        }
                    } catch (Throwable e42) {
                        fileChannel = voidArr;
                        voidArr = e42;
                        channel = null;
                        fileChannel.close();
                        channel.close();
                        throw voidArr;
                    }
                }
                this.mPromise.reject(CameraRollManager.ERROR_UNABLE_TO_LOAD, "External media storage directory not available");
            } catch (IOException e5) {
                e222 = e5;
                channel = null;
                this.mPromise.reject(e222);
                fileChannel.close();
                channel.close();
            } catch (Throwable th3) {
                voidArr = th3;
                channel = null;
                fileChannel.close();
                channel.close();
                throw voidArr;
            }
        }
    }

    public String getName() {
        return NAME;
    }

    static {
        if (IS_JELLY_BEAN_OR_LATER) {
            PROJECTION = new String[]{EXColumns.ID, "mime_type", "bucket_display_name", "datetaken", "width", "height", "longitude", "latitude"};
        } else {
            PROJECTION = new String[]{EXColumns.ID, "mime_type", "bucket_display_name", "datetaken", "longitude", "latitude"};
        }
    }

    public CameraRollManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void saveToCameraRoll(String str, String str2, Promise promise) {
        new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(str), promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
    }

    @ReactMethod
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        int i = readableMap.getInt("first");
        String string = readableMap.hasKey("after") ? readableMap.getString("after") : null;
        String string2 = readableMap.hasKey("groupName") ? readableMap.getString("groupName") : null;
        String string3 = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : null;
        ReadableArray array = readableMap.hasKey("mimeTypes") ? readableMap.getArray("mimeTypes") : null;
        if (readableMap.hasKey("groupTypes") == null) {
            new GetPhotosTask(getReactApplicationContext(), i, string, string2, array, string3, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new JSApplicationIllegalArgumentException("groupTypes is not supported on Android");
    }

    private static void putPageInfo(Cursor cursor, WritableMap writableMap, int i) {
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i < cursor.getCount());
        if (i < cursor.getCount()) {
            cursor.moveToPosition(i - 1);
            writableNativeMap.putString("end_cursor", cursor.getString(cursor.getColumnIndex("datetaken")));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    private static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, String str) {
        Cursor cursor2 = cursor;
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        cursor.moveToFirst();
        int columnIndex = cursor2.getColumnIndex(EXColumns.ID);
        int columnIndex2 = cursor2.getColumnIndex("mime_type");
        int columnIndex3 = cursor2.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor2.getColumnIndex("datetaken");
        int columnIndex5 = IS_JELLY_BEAN_OR_LATER ? cursor2.getColumnIndex("width") : -1;
        int columnIndex6 = IS_JELLY_BEAN_OR_LATER ? cursor2.getColumnIndex("height") : -1;
        int columnIndex7 = cursor2.getColumnIndex("longitude");
        int columnIndex8 = cursor2.getColumnIndex("latitude");
        int i2 = i;
        int i3 = 0;
        while (i3 < i2 && !cursor.isAfterLast()) {
            WritableArray writableArray;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableMap writableNativeMap2 = new WritableNativeMap();
            WritableMap writableMap2 = writableNativeMap2;
            WritableNativeArray writableNativeArray2 = writableNativeArray;
            WritableNativeMap writableNativeMap3 = writableNativeMap;
            int i4 = i3;
            int i5 = columnIndex;
            columnIndex = columnIndex8;
            if (putImageInfo(contentResolver, cursor, writableNativeMap2, columnIndex, columnIndex5, columnIndex6, str)) {
                WritableMap writableMap3 = writableMap2;
                putBasicNodeInfo(cursor2, writableMap3, columnIndex2, columnIndex3, columnIndex4);
                putLocationInfo(cursor2, writableMap3, columnIndex7, columnIndex);
                writableNativeMap3.putMap("node", writableMap3);
                writableArray = writableNativeArray2;
                writableArray.pushMap(writableNativeMap3);
            } else {
                writableArray = writableNativeArray2;
                i4--;
            }
            cursor.moveToNext();
            i3 = i4 + 1;
            i2 = i;
            WritableArray writableArray2 = writableArray;
            columnIndex8 = columnIndex;
            columnIndex = i5;
        }
        writableMap.putArray("edges", writableNativeArray);
    }

    private static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i, int i2, int i3) {
        writableMap.putString("type", cursor.getString(i));
        writableMap.putString("group_name", cursor.getString(i2));
        writableMap.putDouble("timestamp", ((double) cursor.getLong(i3)) / 1000.0d);
    }

    private static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, String str) {
        String str2;
        WritableMap writableNativeMap = new WritableNativeMap();
        if (str == null || !str.equals("Videos")) {
            i = Uri.withAppendedPath(Media.EXTERNAL_CONTENT_URI, cursor.getString(i));
        } else {
            i = Uri.withAppendedPath(Video.Media.EXTERNAL_CONTENT_URI, cursor.getString(i));
        }
        writableNativeMap.putString("uri", i.toString());
        float f = -1.0f;
        if (IS_JELLY_BEAN_OR_LATER) {
            f = (float) cursor.getInt(i2);
            cursor = (float) cursor.getInt(i3);
        } else {
            cursor = -1082130432;
        }
        if (!(str == null || str.equals("Videos") == null || VERSION.SDK_INT < 10)) {
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                str = contentResolver.openAssetFileDescriptor(i, "r");
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str.getFileDescriptor());
                if (f <= 0.0f || r7 <= null) {
                    try {
                        f = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        cursor = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    } catch (Throwable e) {
                        str2 = ReactConstants.TAG;
                        writableMap = new StringBuilder();
                        writableMap.append("Number format exception occurred while trying to fetch video metadata for ");
                        writableMap.append(i.toString());
                        FLog.m5675e(str2, writableMap.toString(), e);
                        mediaMetadataRetriever.release();
                        str.close();
                        return false;
                    }
                }
                writableNativeMap.putInt("playableDuration", Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000);
                mediaMetadataRetriever.release();
                str.close();
            } catch (Throwable e2) {
                str2 = ReactConstants.TAG;
                writableMap = new StringBuilder();
                writableMap.append("Could not get video metadata for ");
                writableMap.append(i.toString());
                FLog.m5675e(str2, writableMap.toString(), e2);
                return false;
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                str.close();
            }
        }
        if (f <= 0.0f || r7 <= null) {
            try {
                contentResolver = contentResolver.openAssetFileDescriptor(i, "r");
                cursor = new Options();
                cursor.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(contentResolver.getFileDescriptor(), null, cursor);
                f = (float) cursor.outWidth;
                cursor = (float) cursor.outHeight;
                contentResolver.close();
            } catch (Throwable e22) {
                str2 = ReactConstants.TAG;
                writableMap = new StringBuilder();
                writableMap.append("Could not get width/height for ");
                writableMap.append(i.toString());
                FLog.m5675e(str2, writableMap.toString(), e22);
                return false;
            }
        }
        writableNativeMap.putDouble("width", (double) f);
        writableNativeMap.putDouble("height", (double) cursor);
        writableMap.putMap(MessengerShareContentUtility.MEDIA_IMAGE, writableNativeMap);
        return true;
    }

    private static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i, int i2) {
        double d = cursor.getDouble(i);
        i = cursor.getDouble(i2);
        if (d > 0.0d || i > 0) {
            cursor = new WritableNativeMap();
            cursor.putDouble("longitude", d);
            cursor.putDouble("latitude", i);
            writableMap.putMap(PlaceFields.LOCATION, cursor);
        }
    }
}
