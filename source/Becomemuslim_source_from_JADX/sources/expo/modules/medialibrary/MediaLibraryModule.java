package expo.modules.medialibrary;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import com.facebook.internal.AnalyticsEvents;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;
import expo.p307b.p315h.C6033a;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaLibraryModule extends C6006c implements C6001h {
    private Context mContext;
    private MediaStoreContentObserver mImagesObserver = null;
    private C6007d mModuleRegistry;
    private MediaStoreContentObserver mVideosObserver = null;

    /* renamed from: expo.modules.medialibrary.MediaLibraryModule$1 */
    class C61201 extends HashMap<String, Object> {

        /* renamed from: expo.modules.medialibrary.MediaLibraryModule$1$1 */
        class C61181 extends HashMap<String, Object> {
            C61181() {
                put("audio", "audio");
                put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                put("video", "video");
                put("unknown", "unknown");
                put("all", "all");
            }
        }

        /* renamed from: expo.modules.medialibrary.MediaLibraryModule$1$2 */
        class C61192 extends HashMap<String, Object> {
            C61192() {
                put("default", "default");
                put("id", "id");
                put("creationTime", "creationTime");
                put("modificationTime", "modificationTime");
                put("mediaType", "mediaType");
                put("width", "width");
                put("height", "height");
                put("duration", "duration");
            }
        }

        C61201() {
            put("MediaType", Collections.unmodifiableMap(new C61181()));
            put("SortBy", Collections.unmodifiableMap(new C61192()));
            put("CHANGE_LISTENER_NAME", "mediaLibraryDidChange");
        }
    }

    private class MediaStoreContentObserver extends ContentObserver {
        private int mAssetsTotalCount = getAssetsTotalCount(this.mMediaType);
        private int mMediaType;

        public MediaStoreContentObserver(Handler handler, int i) {
            super(handler);
            this.mMediaType = i;
        }

        public void onChange(boolean z) {
            onChange(z, null);
        }

        public void onChange(boolean z, Uri uri) {
            z = getAssetsTotalCount(this.mMediaType);
            if (this.mAssetsTotalCount != z) {
                this.mAssetsTotalCount = z;
                ((C5991a) MediaLibraryModule.this.mModuleRegistry.m25133a(C5991a.class)).mo5142a("mediaLibraryDidChange", new Bundle());
            }
        }

        private int getAssetsTotalCount(int i) {
            ContentResolver contentResolver = MediaLibraryModule.this.mContext.getContentResolver();
            Uri uri = MediaLibraryConstants.EXTERNAL_CONTENT;
            String[] strArr = new String[]{"count(*) AS count"};
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("media_type == ");
            stringBuilder.append(i);
            i = contentResolver.query(uri, strArr, stringBuilder.toString(), null, null);
            i.moveToFirst();
            return i.getInt(0);
        }
    }

    public String getName() {
        return "ExponentMediaLibrary";
    }

    public MediaLibraryModule(Context context) {
        super(context);
        this.mContext = context;
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new C61201());
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    @C5996c
    public void createAssetAsync(String str, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new CreateAsset(this.mContext, str, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
        }
    }

    @C5996c
    public void addAssetsToAlbumAsync(List<String> list, String str, boolean z, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new AddAssetsToAlbum(this.mContext, (String[]) list.toArray(new String[0]), str, z, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @C5996c
    public void removeAssetsFromAlbumAsync(List<String> list, String str, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new RemoveAssetsFromAlbum(this.mContext, (String[]) list.toArray(new String[0]), str, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @C5996c
    public void deleteAssetsAsync(List<String> list, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new DeleteAssets(this.mContext, (String[]) list.toArray(new String[0]), c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @C5996c
    public void getAssetInfoAsync(String str, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new GetAssetInfo(this.mContext, str, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
        }
    }

    @C5996c
    public void getAlbumsAsync(C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new GetAlbums(this.mContext, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @C5996c
    public void getAlbumAsync(String str, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new GetAlbum(this.mContext, str, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
        }
    }

    @C5996c
    public void createAlbumAsync(String str, String str2, boolean z, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new CreateAlbum(this.mContext, str, str2, z, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
        }
    }

    @C5996c
    public void deleteAlbumsAsync(List<String> list, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new DeleteAlbums(this.mContext, list, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
        }
    }

    @C5996c
    public void getAssetsAsync(Map<String, Object> map, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Missing CAMERA_ROLL permissions.");
        } else {
            new GetAssets(this.mContext, map, c6009f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
        }
    }

    @C5996c
    public void startObserving(C6009f c6009f) {
        if (this.mImagesObserver != null) {
            c6009f.mo5137a(null);
            return;
        }
        Handler handler = new Handler();
        this.mImagesObserver = new MediaStoreContentObserver(handler, 1);
        this.mVideosObserver = new MediaStoreContentObserver(handler, 3);
        ContentResolver contentResolver = this.mContext.getContentResolver();
        contentResolver.registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, this.mImagesObserver);
        contentResolver.registerContentObserver(Video.Media.EXTERNAL_CONTENT_URI, true, this.mVideosObserver);
        c6009f.mo5137a(null);
    }

    @C5996c
    public void stopObserving(C6009f c6009f) {
        if (this.mImagesObserver != null) {
            ContentResolver contentResolver = this.mContext.getContentResolver();
            contentResolver.unregisterContentObserver(this.mImagesObserver);
            contentResolver.unregisterContentObserver(this.mVideosObserver);
            this.mImagesObserver = null;
            this.mVideosObserver = null;
        }
        c6009f.mo5137a(null);
    }

    private boolean isMissingPermissions() {
        C6033a c6033a = (C6033a) this.mModuleRegistry.m25133a(C6033a.class);
        if (c6033a == null) {
            return false;
        }
        return c6033a.getPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}).equals(new int[]{0, 0});
    }
}
