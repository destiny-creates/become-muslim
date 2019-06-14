package expo.modules.medialibrary;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import expo.p304a.C6009f;
import java.io.File;

class CreateAlbum extends AsyncTask<Void, Void, Void> {
    private final String mAlbumName;
    private final String mAssetId;
    private final Context mContext;
    private final C6009f mPromise;
    private final FileStrategy mStrategy;

    /* renamed from: expo.modules.medialibrary.CreateAlbum$1 */
    class C61141 implements OnScanCompletedListener {
        C61141() {
        }

        public void onScanCompleted(String str, Uri uri) {
            if (uri == null) {
                CreateAlbum.this.mPromise.m25152a("E_UNABLE_TO_SAVE", "Could not add image to album.");
                return;
            }
            MediaLibraryUtils.queryAlbum(CreateAlbum.this.mContext, "_data=?) /*", new String[]{str}, CreateAlbum.this.mPromise);
        }
    }

    public CreateAlbum(Context context, String str, String str2, boolean z, C6009f c6009f) {
        this.mContext = context;
        this.mAlbumName = str;
        this.mAssetId = str2;
        this.mPromise = c6009f;
        this.mStrategy = z ? MediaLibraryUtils.copyStrategy : MediaLibraryUtils.moveStrategy;
    }

    private File createAlbum() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), this.mAlbumName);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        this.mPromise.m25152a("E_NO_ALBUM", "Could not create album directory.");
        return null;
    }

    protected Void doInBackground(Void... voidArr) {
        try {
            File createAlbum = createAlbum();
            if (createAlbum == null) {
                return null;
            }
            if (MediaLibraryUtils.getAssetsById(this.mContext, this.mPromise, this.mAssetId) == null) {
                return null;
            }
            createAlbum = this.mStrategy.apply((File) MediaLibraryUtils.getAssetsById(this.mContext, this.mPromise, this.mAssetId).get(0), createAlbum, this.mContext);
            MediaScannerConnection.scanFile(this.mContext, new String[]{createAlbum.getPath()}, null, new C61141());
            return null;
        } catch (Throwable e) {
            this.mPromise.mo5138a("E_UNABLE_TO_LOAD_PERMISSION", "Could not create album: need WRITE_EXTERNAL_STORAGE permission.", e);
        } catch (Throwable e2) {
            this.mPromise.mo5138a("E_UNABLE_TO_LOAD", "Could not read file or parse EXIF tags", e2);
        }
    }
}
