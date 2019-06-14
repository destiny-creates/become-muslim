package expo.modules.medialibrary;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import expo.p304a.C6009f;

class DeleteAssets extends AsyncTask<Void, Void, Void> {
    private final String[] mAssetsId;
    private final Context mContext;
    private final C6009f mPromise;

    DeleteAssets(Context context, String[] strArr, C6009f c6009f) {
        this.mContext = context;
        this.mAssetsId = strArr;
        this.mPromise = c6009f;
    }

    protected Void doInBackground(Void... voidArr) {
        voidArr = new StringBuilder();
        voidArr.append("_id IN (");
        voidArr.append(TextUtils.join(",", this.mAssetsId));
        voidArr.append(" )");
        MediaLibraryUtils.deleteAssets(this.mContext, voidArr.toString(), null, this.mPromise);
        return null;
    }
}
