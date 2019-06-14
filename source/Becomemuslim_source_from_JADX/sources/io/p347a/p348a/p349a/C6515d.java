package io.p347a.p348a.p349a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* compiled from: FabricContext */
/* renamed from: io.a.a.a.d */
class C6515d extends ContextWrapper {
    /* renamed from: a */
    private final String f21013a;
    /* renamed from: b */
    private final String f21014b;

    public C6515d(Context context, String str, String str2) {
        super(context);
        this.f21014b = str;
        this.f21013a = str2;
    }

    public File getDatabasePath(String str) {
        File file = new File(super.getDatabasePath(str).getParentFile(), this.f21013a);
        file.mkdirs();
        return new File(file, str);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    @TargetApi(11)
    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getPath(), cursorFactory, databaseErrorHandler);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.f21013a);
    }

    @TargetApi(8)
    public File getExternalFilesDir(String str) {
        return new File(super.getExternalFilesDir(str), this.f21013a);
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.f21013a);
    }

    @TargetApi(8)
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.f21013a);
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f21014b);
        stringBuilder.append(":");
        stringBuilder.append(str);
        return super.getSharedPreferences(stringBuilder.toString(), i);
    }
}
