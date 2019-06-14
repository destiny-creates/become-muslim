package expo.modules.medialibrary;

import android.content.Context;
import android.os.AsyncTask;
import expo.p304a.C6009f;

class GetAssetInfo extends AsyncTask<Void, Void, Void> {
    private final String mAssetId;
    private final Context mContext;
    private final C6009f mPromise;

    public GetAssetInfo(Context context, String str, C6009f c6009f) {
        this.mContext = context;
        this.mAssetId = str;
        this.mPromise = c6009f;
    }

    protected Void doInBackground(Void... voidArr) {
        MediaLibraryUtils.queryAssetInfo(this.mContext, "_id=?", new String[]{this.mAssetId}, true, this.mPromise);
        return null;
    }
}
