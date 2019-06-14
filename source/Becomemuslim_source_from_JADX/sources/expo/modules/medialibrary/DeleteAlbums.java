package expo.modules.medialibrary;

import android.content.Context;
import android.os.AsyncTask;
import expo.p304a.C6009f;
import java.util.List;

class DeleteAlbums extends AsyncTask<Void, Void, Void> {
    String[] mAlbumIds;
    Context mContext;
    C6009f mPromise;

    public DeleteAlbums(Context context, List<String> list, C6009f c6009f) {
        this.mContext = context;
        this.mPromise = c6009f;
        this.mAlbumIds = (String[]) list.toArray(new String[null]);
    }

    protected Void doInBackground(Void... voidArr) {
        voidArr = new StringBuilder();
        voidArr.append("bucket_id IN (");
        voidArr.append(MediaLibraryUtils.getInPart(this.mAlbumIds));
        voidArr.append(" )");
        MediaLibraryUtils.deleteAssets(this.mContext, voidArr.toString(), this.mAlbumIds, this.mPromise);
        return null;
    }
}
