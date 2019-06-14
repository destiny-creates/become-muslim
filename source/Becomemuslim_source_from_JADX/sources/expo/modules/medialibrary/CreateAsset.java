package expo.modules.medialibrary;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import expo.p304a.C6009f;
import java.io.File;

class CreateAsset extends AsyncTask<Void, Void, Void> {
    private final Context mContext;
    private final C6009f mPromise;
    private final Uri mUri;

    /* renamed from: expo.modules.medialibrary.CreateAsset$1 */
    class C61151 implements OnScanCompletedListener {
        C61151() {
        }

        public void onScanCompleted(String str, Uri uri) {
            if (uri == null) {
                CreateAsset.this.mPromise.m25152a("E_UNABLE_TO_SAVE", "Could not add image to gallery.");
                return;
            }
            MediaLibraryUtils.queryAssetInfo(CreateAsset.this.mContext, "_data=?", new String[]{str}, false, CreateAsset.this.mPromise);
        }
    }

    CreateAsset(Context context, String str, C6009f c6009f) {
        this.mContext = context;
        this.mUri = Uri.parse(str);
        this.mPromise = c6009f;
    }

    private File createAssetFile() {
        File file = new File(this.mUri.getPath());
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        file = MediaLibraryUtils.safeCopyFile(file, externalStoragePublicDirectory);
        if (externalStoragePublicDirectory.exists()) {
            if (file.isFile()) {
                return file;
            }
        }
        this.mPromise.m25152a("E_UNABLE_TO_SAVE", "Could not create asset record. Related file is not existing.");
        return null;
    }

    protected Void doInBackground(Void... voidArr) {
        try {
            if (createAssetFile() == null) {
                return null;
            }
            MediaScannerConnection.scanFile(this.mContext, new String[]{r0.getPath()}, null, new C61151());
            return null;
        } catch (Throwable e) {
            this.mPromise.mo5138a("E_IO_EXCEPTION", "Unable to copy file into external storage.", e);
        } catch (Throwable e2) {
            this.mPromise.mo5138a("E_UNABLE_TO_LOAD_PERMISSION", "Could not get asset: need READ_EXTERNAL_STORAGE permission.", e2);
        }
    }
}
