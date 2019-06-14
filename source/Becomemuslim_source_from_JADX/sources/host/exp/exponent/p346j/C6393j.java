package host.exp.exponent.p346j;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import host.exp.exponent.p334a.C6289b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScopedContext */
/* renamed from: host.exp.exponent.j.j */
public class C6393j extends Context {
    /* renamed from: a */
    private static final String f20688a = "j";
    /* renamed from: b */
    private Context f20689b;
    /* renamed from: c */
    private String f20690c;
    /* renamed from: d */
    private File f20691d;
    /* renamed from: e */
    private File f20692e;
    /* renamed from: f */
    private C6392i f20693f;

    public boolean moveDatabaseFrom(Context context, String str) {
        return false;
    }

    public C6393j(Context context, String str) {
        this.f20689b = context;
        context = new StringBuilder();
        context.append(str);
        context.append('-');
        this.f20690c = context.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20689b.getFilesDir());
        stringBuilder.append("/ExperienceData/");
        stringBuilder.append(str);
        this.f20691d = new File(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20689b.getCacheDir());
        stringBuilder.append("/ExperienceData/");
        stringBuilder.append(str);
        this.f20692e = new File(stringBuilder.toString());
    }

    public AssetManager getAssets() {
        return this.f20689b.getAssets();
    }

    public Resources getResources() {
        return this.f20689b.getResources();
    }

    public PackageManager getPackageManager() {
        return this.f20689b.getPackageManager();
    }

    public ContentResolver getContentResolver() {
        return this.f20689b.getContentResolver();
    }

    public Looper getMainLooper() {
        return this.f20689b.getMainLooper();
    }

    public Context getApplicationContext() {
        if (this.f20693f == null) {
            this.f20693f = new C6392i((Application) this.f20689b.getApplicationContext(), this);
        }
        return this.f20693f;
    }

    public void setTheme(int i) {
        this.f20689b.setTheme(i);
    }

    public Theme getTheme() {
        return this.f20689b.getTheme();
    }

    public ClassLoader getClassLoader() {
        return this.f20689b.getClassLoader();
    }

    public String getPackageName() {
        C6289b.m25949a(f20688a, "WARNING: getPackageName called on ScopedContext");
        return this.f20689b.getPackageName();
    }

    public ApplicationInfo getApplicationInfo() {
        return this.f20689b.getApplicationInfo();
    }

    public String getPackageResourcePath() {
        return this.f20689b.getPackageResourcePath();
    }

    public String getPackageCodePath() {
        return this.f20689b.getPackageCodePath();
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        Context context = this.f20689b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20690c);
        stringBuilder.append(str);
        return context.getSharedPreferences(stringBuilder.toString(), i);
    }

    public boolean moveSharedPreferencesFrom(Context context, String str) {
        Context context2 = this.f20689b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20690c);
        stringBuilder.append(str);
        return context2.moveSharedPreferencesFrom(context, stringBuilder.toString());
    }

    public boolean deleteSharedPreferences(String str) {
        Context context = this.f20689b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20690c);
        stringBuilder.append(str);
        return context.deleteSharedPreferences(stringBuilder.toString());
    }

    public FileInputStream openFileInput(String str) {
        return this.f20689b.openFileInput(str);
    }

    public FileOutputStream openFileOutput(String str, int i) {
        return this.f20689b.openFileOutput(str, i);
    }

    public boolean deleteFile(String str) {
        return this.f20689b.deleteFile(str);
    }

    public File getFileStreamPath(String str) {
        return this.f20689b.getFileStreamPath(str);
    }

    public File getDataDir() {
        return this.f20689b.getDataDir();
    }

    public File getFilesDir() {
        return this.f20691d;
    }

    public File getNoBackupFilesDir() {
        return this.f20689b.getNoBackupFilesDir();
    }

    public File getExternalFilesDir(String str) {
        return this.f20689b.getExternalFilesDir(str);
    }

    public File[] getExternalFilesDirs(String str) {
        return this.f20689b.getExternalFilesDirs(str);
    }

    public File getObbDir() {
        return this.f20689b.getObbDir();
    }

    public File[] getObbDirs() {
        return this.f20689b.getObbDirs();
    }

    public File getCacheDir() {
        return this.f20692e;
    }

    public File getCodeCacheDir() {
        return this.f20689b.getCodeCacheDir();
    }

    public File getExternalCacheDir() {
        return this.f20689b.getExternalCacheDir();
    }

    public File[] getExternalCacheDirs() {
        return this.f20689b.getExternalCacheDirs();
    }

    public File[] getExternalMediaDirs() {
        return this.f20689b.getExternalMediaDirs();
    }

    public String[] fileList() {
        return this.f20689b.fileList();
    }

    public File getDir(String str, int i) {
        return this.f20689b.getDir(str, i);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        Context context = this.f20689b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20690c);
        stringBuilder.append(str);
        return context.openOrCreateDatabase(stringBuilder.toString(), i, cursorFactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        Context context = this.f20689b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20690c);
        stringBuilder.append(str);
        return context.openOrCreateDatabase(stringBuilder.toString(), i, cursorFactory, databaseErrorHandler);
    }

    public boolean deleteDatabase(String str) {
        Context context = this.f20689b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20690c);
        stringBuilder.append(str);
        return context.deleteDatabase(stringBuilder.toString());
    }

    public File getDatabasePath(String str) {
        Context context = this.f20689b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20690c);
        stringBuilder.append(str);
        return context.getDatabasePath(stringBuilder.toString());
    }

    public String[] databaseList() {
        String[] databaseList = this.f20689b.databaseList();
        List arrayList = new ArrayList();
        for (int i = 0; i < databaseList.length; i++) {
            if (databaseList[i].startsWith(this.f20690c)) {
                arrayList.add(databaseList[i].substring(this.f20690c.length()));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Drawable getWallpaper() {
        return this.f20689b.getWallpaper();
    }

    public Drawable peekWallpaper() {
        return this.f20689b.peekWallpaper();
    }

    public int getWallpaperDesiredMinimumWidth() {
        return this.f20689b.getWallpaperDesiredMinimumWidth();
    }

    public int getWallpaperDesiredMinimumHeight() {
        return this.f20689b.getWallpaperDesiredMinimumHeight();
    }

    public void setWallpaper(Bitmap bitmap) {
        this.f20689b.setWallpaper(bitmap);
    }

    public void setWallpaper(InputStream inputStream) {
        this.f20689b.setWallpaper(inputStream);
    }

    public void clearWallpaper() {
        this.f20689b.clearWallpaper();
    }

    public void startActivity(Intent intent) {
        this.f20689b.startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        this.f20689b.startActivity(intent, bundle);
    }

    public void startActivities(Intent[] intentArr) {
        this.f20689b.startActivities(intentArr);
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.f20689b.startActivities(intentArr, bundle);
    }

    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        this.f20689b.startIntentSender(intentSender, intent, i, i2, i3);
    }

    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) {
        this.f20689b.startIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    public void sendBroadcast(Intent intent) {
        this.f20689b.sendBroadcast(intent);
    }

    public void sendBroadcast(Intent intent, String str) {
        this.f20689b.sendBroadcast(intent, str);
    }

    public void sendOrderedBroadcast(Intent intent, String str) {
        this.f20689b.sendOrderedBroadcast(intent, str);
    }

    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.f20689b.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i, str2, bundle);
    }

    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.f20689b.sendBroadcastAsUser(intent, userHandle);
    }

    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        this.f20689b.sendBroadcastAsUser(intent, userHandle, str);
    }

    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.f20689b.sendOrderedBroadcastAsUser(intent, userHandle, str, broadcastReceiver, handler, i, str2, bundle);
    }

    public void sendStickyBroadcast(Intent intent) {
        this.f20689b.sendStickyBroadcast(intent);
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.f20689b.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i, str, bundle);
    }

    public void removeStickyBroadcast(Intent intent) {
        this.f20689b.removeStickyBroadcast(intent);
    }

    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.f20689b.sendStickyBroadcastAsUser(intent, userHandle);
    }

    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.f20689b.sendStickyOrderedBroadcastAsUser(intent, userHandle, broadcastReceiver, handler, i, str, bundle);
    }

    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.f20689b.removeStickyBroadcastAsUser(intent, userHandle);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return this.f20689b.registerReceiver(broadcastReceiver, intentFilter);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return this.f20689b.registerReceiver(broadcastReceiver, intentFilter, i);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return this.f20689b.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        return this.f20689b.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.f20689b.unregisterReceiver(broadcastReceiver);
    }

    public ComponentName startService(Intent intent) {
        return this.f20689b.startService(intent);
    }

    public ComponentName startForegroundService(Intent intent) {
        return this.f20689b.startForegroundService(intent);
    }

    public boolean stopService(Intent intent) {
        return this.f20689b.stopService(intent);
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.f20689b.bindService(intent, serviceConnection, i);
    }

    public void unbindService(ServiceConnection serviceConnection) {
        this.f20689b.unbindService(serviceConnection);
    }

    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return this.f20689b.startInstrumentation(componentName, str, bundle);
    }

    public Object getSystemService(String str) {
        return this.f20689b.getSystemService(str);
    }

    public String getSystemServiceName(Class<?> cls) {
        return this.f20689b.getSystemServiceName(cls);
    }

    public int checkPermission(String str, int i, int i2) {
        return this.f20689b.checkPermission(str, i, i2);
    }

    public int checkCallingPermission(String str) {
        return this.f20689b.checkCallingPermission(str);
    }

    public int checkCallingOrSelfPermission(String str) {
        return this.f20689b.checkCallingOrSelfPermission(str);
    }

    public int checkSelfPermission(String str) {
        return this.f20689b.checkSelfPermission(str);
    }

    public void enforcePermission(String str, int i, int i2, String str2) {
        this.f20689b.enforcePermission(str, i, i2, str2);
    }

    public void enforceCallingPermission(String str, String str2) {
        this.f20689b.enforceCallingPermission(str, str2);
    }

    public void enforceCallingOrSelfPermission(String str, String str2) {
        this.f20689b.enforceCallingOrSelfPermission(str, str2);
    }

    public void grantUriPermission(String str, Uri uri, int i) {
        this.f20689b.grantUriPermission(str, uri, i);
    }

    public void revokeUriPermission(Uri uri, int i) {
        this.f20689b.revokeUriPermission(uri, i);
    }

    public void revokeUriPermission(String str, Uri uri, int i) {
        this.f20689b.revokeUriPermission(str, uri, i);
    }

    public int checkUriPermission(Uri uri, int i, int i2, int i3) {
        return this.f20689b.checkUriPermission(uri, i, i2, i3);
    }

    public int checkCallingUriPermission(Uri uri, int i) {
        return this.f20689b.checkCallingUriPermission(uri, i);
    }

    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        return this.f20689b.checkCallingOrSelfUriPermission(uri, i);
    }

    public int checkUriPermission(Uri uri, String str, String str2, int i, int i2, int i3) {
        return this.f20689b.checkUriPermission(uri, str, str2, i, i2, i3);
    }

    public void enforceUriPermission(Uri uri, int i, int i2, int i3, String str) {
        this.f20689b.enforceUriPermission(uri, i, i2, i3, str);
    }

    public void enforceCallingUriPermission(Uri uri, int i, String str) {
        this.f20689b.enforceCallingUriPermission(uri, i, str);
    }

    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String str) {
        this.f20689b.enforceCallingOrSelfUriPermission(uri, i, str);
    }

    public void enforceUriPermission(Uri uri, String str, String str2, int i, int i2, int i3, String str3) {
        this.f20689b.enforceUriPermission(uri, str, str2, i, i2, i3, str3);
    }

    public Context createPackageContext(String str, int i) {
        return this.f20689b.createPackageContext(str, i);
    }

    public Context createContextForSplit(String str) {
        return this.f20689b.createContextForSplit(str);
    }

    public Context createConfigurationContext(Configuration configuration) {
        return this.f20689b.createConfigurationContext(configuration);
    }

    public Context createDisplayContext(Display display) {
        return this.f20689b.createDisplayContext(display);
    }

    public Context createDeviceProtectedStorageContext() {
        return this.f20689b.createDeviceProtectedStorageContext();
    }

    public boolean isDeviceProtectedStorage() {
        return this.f20689b.isDeviceProtectedStorage();
    }

    /* renamed from: a */
    public Context m26224a() {
        return this.f20689b;
    }
}
