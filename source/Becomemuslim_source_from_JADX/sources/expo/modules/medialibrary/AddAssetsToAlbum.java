package expo.modules.medialibrary;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import expo.p304a.C6009f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class AddAssetsToAlbum extends AsyncTask<Void, Void, Void> {
    private final String mAlbumId;
    private final String[] mAssetsId;
    private final Context mContext;
    private final C6009f mPromise;
    private final FileStrategy mStrategy;

    AddAssetsToAlbum(Context context, String[] strArr, String str, boolean z, C6009f c6009f) {
        this.mContext = context;
        this.mAssetsId = strArr;
        this.mAlbumId = str;
        this.mStrategy = z ? MediaLibraryUtils.copyStrategy : MediaLibraryUtils.moveStrategy;
        this.mPromise = c6009f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File getAlbum() {
        /*
        r7 = this;
        r0 = "_data";
        r3 = new java.lang.String[]{r0};
        r0 = 1;
        r5 = new java.lang.String[r0];
        r0 = r7.mAlbumId;
        r1 = 0;
        r5[r1] = r0;
        r0 = r7.mContext;
        r1 = r0.getContentResolver();
        r2 = expo.modules.medialibrary.MediaLibraryConstants.EXTERNAL_CONTENT;
        r4 = "bucket_id=?) /*";
        r6 = "*/ LIMIT 1";
        r0 = r1.query(r2, r3, r4, r5, r6);
        r1 = 0;
        if (r0 != 0) goto L_0x0034;
    L_0x0021:
        r2 = r7.mPromise;	 Catch:{ Throwable -> 0x0032 }
        r3 = "E_UNABLE_TO_LOAD";
        r4 = "Could not get album. Query returns null.";
        r2.m25152a(r3, r4);	 Catch:{ Throwable -> 0x0032 }
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0.close();
    L_0x002f:
        return r1;
    L_0x0030:
        r2 = move-exception;
        goto L_0x0091;
    L_0x0032:
        r1 = move-exception;
        goto L_0x0090;
    L_0x0034:
        r2 = r0.getCount();	 Catch:{ Throwable -> 0x0032 }
        if (r2 != 0) goto L_0x005a;
    L_0x003a:
        r2 = r7.mPromise;	 Catch:{ Throwable -> 0x0032 }
        r3 = "E_NO_ALBUM";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0032 }
        r4.<init>();	 Catch:{ Throwable -> 0x0032 }
        r5 = "No album with id: ";
        r4.append(r5);	 Catch:{ Throwable -> 0x0032 }
        r5 = r7.mAlbumId;	 Catch:{ Throwable -> 0x0032 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0032 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0032 }
        r2.m25152a(r3, r4);	 Catch:{ Throwable -> 0x0032 }
        if (r0 == 0) goto L_0x0059;
    L_0x0056:
        r0.close();
    L_0x0059:
        return r1;
    L_0x005a:
        r0.moveToNext();	 Catch:{ Throwable -> 0x0032 }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0032 }
        r3 = "_data";
        r3 = r0.getColumnIndex(r3);	 Catch:{ Throwable -> 0x0032 }
        r3 = r0.getString(r3);	 Catch:{ Throwable -> 0x0032 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0032 }
        r3 = r2.isFile();	 Catch:{ Throwable -> 0x0032 }
        if (r3 != 0) goto L_0x0081;
    L_0x0072:
        r2 = r7.mPromise;	 Catch:{ Throwable -> 0x0032 }
        r3 = "E_MEDIA_LIBRARY_CORRUPTED";
        r4 = "Media library is corrupted";
        r2.m25152a(r3, r4);	 Catch:{ Throwable -> 0x0032 }
        if (r0 == 0) goto L_0x0080;
    L_0x007d:
        r0.close();
    L_0x0080:
        return r1;
    L_0x0081:
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x0032 }
        r2 = r2.getParent();	 Catch:{ Throwable -> 0x0032 }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x0032 }
        if (r0 == 0) goto L_0x008f;
    L_0x008c:
        r0.close();
    L_0x008f:
        return r3;
    L_0x0090:
        throw r1;	 Catch:{ all -> 0x0030 }
    L_0x0091:
        if (r0 == 0) goto L_0x00a1;
    L_0x0093:
        if (r1 == 0) goto L_0x009e;
    L_0x0095:
        r0.close();	 Catch:{ Throwable -> 0x0099 }
        goto L_0x00a1;
    L_0x0099:
        r0 = move-exception;
        r1.addSuppressed(r0);
        goto L_0x00a1;
    L_0x009e:
        r0.close();
    L_0x00a1:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.AddAssetsToAlbum.getAlbum():java.io.File");
    }

    protected Void doInBackground(Void... voidArr) {
        try {
            File album = getAlbum();
            if (album == null) {
                return null;
            }
            List<File> assetsById = MediaLibraryUtils.getAssetsById(this.mContext, this.mPromise, this.mAssetsId);
            if (assetsById == null) {
                return null;
            }
            List arrayList = new ArrayList();
            for (File apply : assetsById) {
                arrayList.add(this.mStrategy.apply(apply, album, this.mContext).getPath());
            }
            final AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
            MediaScannerConnection.scanFile(this.mContext, (String[]) arrayList.toArray(new String[0]), null, new OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    if (atomicInteger.decrementAndGet() == null) {
                        AddAssetsToAlbum.this.mPromise.mo5137a(Boolean.valueOf(true));
                    }
                }
            });
            return null;
        } catch (Throwable e) {
            this.mPromise.mo5138a("E_UNABLE_TO_SAVE_PERMISSION", "Could not get albums: need WRITE_EXTERNAL_STORAGE permission.", e);
        } catch (Throwable e2) {
            this.mPromise.mo5138a("E_IO_EXCEPTION", "Unable to read or save data", e2);
        }
    }
}
