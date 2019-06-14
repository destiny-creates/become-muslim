package expo.modules.medialibrary;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import expo.p304a.C6009f;
import java.util.ArrayList;
import java.util.Map;

class GetAssets extends AsyncTask<Void, Void, Void> {
    private final Map<String, Object> mAssetOptions;
    private final Context mContext;
    private final C6009f mPromise;

    public GetAssets(Context context, Map<String, Object> map, C6009f c6009f) {
        this.mContext = context;
        this.mAssetOptions = map;
        this.mPromise = c6009f;
    }

    protected Void doInBackground(Void... voidArr) {
        Cursor query;
        Throwable th;
        Object bundle = new Bundle();
        GetQueryInfo invoke = new GetQueryInfo(this.mAssetOptions).invoke();
        String selection = invoke.getSelection();
        String order = invoke.getOrder();
        int limit = invoke.getLimit();
        int offset = invoke.getOffset();
        try {
            query = this.mContext.getContentResolver().query(MediaLibraryConstants.EXTERNAL_CONTENT, MediaLibraryConstants.ASSET_PROJECTION, selection, null, order);
            if (query == null) {
                try {
                    this.mPromise.m25152a("E_UNABLE_TO_LOAD", "Could not get assets. Query returns null.");
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    th2 = voidArr;
                    voidArr = th3;
                }
            } else {
                ArrayList arrayList = new ArrayList();
                MediaLibraryUtils.putAssetsInfo(query, arrayList, limit, offset, false);
                bundle.putParcelableArrayList("assets", arrayList);
                bundle.putBoolean("hasNextPage", query.isAfterLast() ^ 1);
                bundle.putString("endCursor", Integer.toString(query.getPosition()));
                bundle.putInt("totalCount", query.getCount());
                this.mPromise.mo5137a(bundle);
            }
            if (query != null) {
                query.close();
            }
        } catch (Void[] voidArr2) {
            this.mPromise.mo5138a("E_UNABLE_TO_LOAD_PERMISSION", "Could not get asset: need READ_EXTERNAL_STORAGE permission.", voidArr2);
        } catch (Void[] voidArr22) {
            Log.e("E_UNABLE_TO_LOAD", "Could not read file or parse EXIF tags", voidArr22);
        }
        return null;
        if (query != null) {
            if (th2 != null) {
                try {
                    query.close();
                } catch (Throwable th4) {
                    th2.addSuppressed(th4);
                }
            } else {
                query.close();
            }
        }
        throw voidArr22;
        throw voidArr22;
    }
}
