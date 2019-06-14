package expo.modules.medialibrary;

import android.content.Context;
import android.os.AsyncTask;
import expo.p304a.C6009f;

class GetAlbum extends AsyncTask<Void, Void, Void> {
    private final String mAlbumName;
    private final Context mContext;
    private final C6009f mPromise;

    public GetAlbum(Context context, String str, C6009f c6009f) {
        this.mContext = context;
        this.mPromise = c6009f;
        this.mAlbumName = str;
    }

    protected Void doInBackground(Void... voidArr) {
        MediaLibraryUtils.queryAlbum(this.mContext, "media_type != 0 AND bucket_display_name=?) /*", new String[]{this.mAlbumName}, this.mPromise);
        return null;
    }
}
