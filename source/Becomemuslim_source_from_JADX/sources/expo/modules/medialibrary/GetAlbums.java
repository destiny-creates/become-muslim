package expo.modules.medialibrary;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import expo.p304a.C6009f;
import java.util.ArrayList;

class GetAlbums extends AsyncTask<Void, Void, Void> {
    private final Context mContext;
    private final C6009f mPromise;

    public GetAlbums(Context context, C6009f c6009f) {
        this.mContext = context;
        this.mPromise = c6009f;
    }

    protected Void doInBackground(Void... voidArr) {
        Cursor query;
        Throwable th;
        Object arrayList = new ArrayList();
        try {
            query = this.mContext.getContentResolver().query(MediaLibraryConstants.EXTERNAL_CONTENT, new String[]{"bucket_id", "bucket_display_name", "COUNT(*)"}, "media_type != 0) /*", null, "*/ GROUP BY bucket_id ORDER BY bucket_display_name");
            if (query == null) {
                try {
                    this.mPromise.m25152a("E_UNABLE_TO_LOAD", "Could not get albums. Query returns null.");
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    th2 = voidArr;
                    voidArr = th3;
                }
            } else {
                int columnIndex = query.getColumnIndex("bucket_id");
                int columnIndex2 = query.getColumnIndex("bucket_display_name");
                int columnIndex3 = query.getColumnIndex("COUNT(*)");
                while (query.moveToNext()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("id", query.getString(columnIndex));
                    bundle.putString("title", query.getString(columnIndex2));
                    bundle.putParcelable("type", null);
                    bundle.putInt("assetCount", query.getInt(columnIndex3));
                    arrayList.add(bundle);
                }
                this.mPromise.mo5137a(arrayList);
            }
            if (query != null) {
                query.close();
            }
        } catch (Void[] voidArr2) {
            this.mPromise.mo5138a("E_UNABLE_TO_LOAD_PERMISSION", "Could not get albums: need READ_EXTERNAL_STORAGE permission.", voidArr2);
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
        throw voidArr2;
        throw voidArr2;
    }
}
