package expo.modules.medialibrary;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import expo.p304a.C6009f;

class RemoveAssetsFromAlbum extends AsyncTask<Void, Void, Void> {
    private final String mAlbumId;
    private final String[] mAssetsId;
    private final Context mContext;
    private final C6009f mPromise;

    RemoveAssetsFromAlbum(Context context, String[] strArr, String str, C6009f c6009f) {
        this.mContext = context;
        this.mAssetsId = strArr;
        this.mAlbumId = str;
        this.mPromise = c6009f;
    }

    protected Void doInBackground(Void... voidArr) {
        voidArr = new StringBuilder();
        voidArr.append("bucket_id=? AND _id IN (");
        voidArr.append(TextUtils.join(",", this.mAssetsId));
        voidArr.append(" )");
        MediaLibraryUtils.deleteAssets(this.mContext, voidArr.toString(), new String[]{this.mAlbumId}, this.mPromise);
        return null;
    }
}
