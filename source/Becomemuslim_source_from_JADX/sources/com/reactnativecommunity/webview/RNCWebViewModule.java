package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v4.content.C0366b;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.widget.Toast;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;
import java.util.ArrayList;

@ReactModule(name = "RNCWebView")
public class RNCWebViewModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final int FILE_DOWNLOAD_PERMISSION_REQUEST = 1;
    public static final String MODULE_NAME = "RNCWebView";
    private static final int PICKER = 1;
    private static final int PICKER_LEGACY = 3;
    final String DEFAULT_MIME_TYPES = "*/*";
    private Request downloadRequest;
    private ValueCallback<Uri[]> filePathCallback;
    private ValueCallback<Uri> filePathCallbackLegacy;
    private Uri outputFileUri;
    private PermissionListener webviewFileDownloaderPermissionListener = new C71431(this);

    /* renamed from: com.reactnativecommunity.webview.RNCWebViewModule$1 */
    class C71431 implements PermissionListener {
        /* renamed from: a */
        final /* synthetic */ RNCWebViewModule f25291a;

        C71431(RNCWebViewModule rNCWebViewModule) {
            this.f25291a = rNCWebViewModule;
        }

        public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            if (i != 1) {
                return false;
            }
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this.f25291a.getCurrentActivity().getApplicationContext(), "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.", 1).show();
            } else if (this.f25291a.downloadRequest != 0) {
                this.f25291a.downloadFile();
            }
            return true;
        }
    }

    public String getName() {
        return MODULE_NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public RNCWebViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void isFileUploadSupported(Promise promise) {
        Object valueOf = Boolean.valueOf(false);
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            valueOf = Boolean.valueOf(true);
        }
        if (i >= 16 && i <= 18) {
            valueOf = Boolean.valueOf(true);
        }
        promise.resolve(valueOf);
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (this.filePathCallback != null || this.filePathCallbackLegacy != null) {
            if (i != 1) {
                if (i == 3) {
                    activity = i2 != -1 ? null : intent == null ? this.outputFileUri : intent.getData();
                    this.filePathCallbackLegacy.onReceiveValue(activity);
                }
            } else if (i2 == -1) {
                activity = getSelectedFiles(intent, i2);
                if (activity != null) {
                    this.filePathCallback.onReceiveValue(activity);
                } else {
                    this.filePathCallback.onReceiveValue(new Uri[]{this.outputFileUri});
                }
            } else if (this.filePathCallback != null) {
                this.filePathCallback.onReceiveValue(null);
            }
            this.filePathCallback = null;
            this.filePathCallbackLegacy = null;
            this.outputFileUri = null;
        }
    }

    private Uri[] getSelectedFiles(Intent intent, int i) {
        if (intent == null) {
            return null;
        }
        if (intent.getData() != null) {
            if (i != -1 || VERSION.SDK_INT < 21) {
                return null;
            }
            return FileChooserParams.parseResult(i, intent);
        } else if (intent.getClipData() == 0) {
            return null;
        } else {
            i = intent.getClipData().getItemCount();
            Uri[] uriArr = new Uri[i];
            for (int i2 = 0; i2 < i; i2++) {
                uriArr[i2] = intent.getClipData().getItemAt(i2).getUri();
            }
            return uriArr;
        }
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> valueCallback, String str) {
        this.filePathCallbackLegacy = valueCallback;
        valueCallback = Intent.createChooser(getFileChooserIntent(str), "");
        ArrayList arrayList = new ArrayList();
        if (acceptsImages(str).booleanValue()) {
            arrayList.add(getPhotoIntent());
        }
        if (acceptsVideo(str).booleanValue() != null) {
            arrayList.add(getVideoIntent());
        }
        valueCallback.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (valueCallback.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivityForResult(valueCallback, 3);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
    }

    public boolean startPhotoPickerIntent(ValueCallback<Uri[]> valueCallback, Intent intent, String[] strArr, boolean z) {
        this.filePathCallback = valueCallback;
        valueCallback = new ArrayList();
        if (acceptsImages(strArr).booleanValue() != null) {
            valueCallback.add(getPhotoIntent());
        }
        if (acceptsVideo(strArr).booleanValue() != null) {
            valueCallback.add(getVideoIntent());
        }
        intent = getFileChooserIntent(strArr, z);
        strArr = new Intent("android.intent.action.CHOOSER");
        strArr.putExtra("android.intent.extra.INTENT", intent);
        strArr.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) valueCallback.toArray(new Parcelable[false]));
        if (strArr.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivityForResult(strArr, 1);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
        return true;
    }

    public void setDownloadRequest(Request request) {
        this.downloadRequest = request;
    }

    public void downloadFile() {
        ((DownloadManager) getCurrentActivity().getBaseContext().getSystemService("download")).enqueue(this.downloadRequest);
        Toast.makeText(getCurrentActivity().getApplicationContext(), "Downloading", 1).show();
    }

    public boolean grantFileDownloaderPermissions() {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        boolean z = C0366b.b(getCurrentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        if (!z) {
            getPermissionAwareActivity().requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1, this.webviewFileDownloaderPermissionListener);
        }
        return z;
    }

    private Intent getPhotoIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.outputFileUri = getOutputUri("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", this.outputFileUri);
        return intent;
    }

    private Intent getVideoIntent() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", getOutputUri("android.media.action.VIDEO_CAPTURE"));
        return intent;
    }

    private Intent getFileChooserIntent(String str) {
        String str2 = str.isEmpty() ? "*/*" : str;
        if (str.matches("\\.\\w+")) {
            str2 = getMimeTypeFromExtension(str.replace(".", ""));
        }
        str = new Intent("android.intent.action.GET_CONTENT");
        str.addCategory("android.intent.category.OPENABLE");
        str.setType(str2);
        return str;
    }

    private Intent getFileChooserIntent(String[] strArr, boolean z) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", getAcceptedMimeType(strArr));
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        return intent;
    }

    private Boolean acceptsImages(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(".", ""));
        }
        if (!str.isEmpty()) {
            if (str.toLowerCase().contains(MessengerShareContentUtility.MEDIA_IMAGE) == null) {
                str = null;
                return Boolean.valueOf(str);
            }
        }
        str = true;
        return Boolean.valueOf(str);
    }

    private Boolean acceptsImages(String[] strArr) {
        strArr = getAcceptedMimeType(strArr);
        if (!isArrayEmpty(strArr).booleanValue()) {
            if (arrayContainsString(strArr, MessengerShareContentUtility.MEDIA_IMAGE).booleanValue() == null) {
                strArr = null;
                return Boolean.valueOf(strArr);
            }
        }
        strArr = 1;
        return Boolean.valueOf(strArr);
    }

    private Boolean acceptsVideo(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(".", ""));
        }
        if (!str.isEmpty()) {
            if (str.toLowerCase().contains("video") == null) {
                str = null;
                return Boolean.valueOf(str);
            }
        }
        str = true;
        return Boolean.valueOf(str);
    }

    private Boolean acceptsVideo(String[] strArr) {
        strArr = getAcceptedMimeType(strArr);
        if (!isArrayEmpty(strArr).booleanValue()) {
            if (arrayContainsString(strArr, "video").booleanValue() == null) {
                strArr = null;
                return Boolean.valueOf(strArr);
            }
        }
        strArr = 1;
        return Boolean.valueOf(strArr);
    }

    private Boolean arrayContainsString(String[] strArr, String str) {
        for (String contains : strArr) {
            if (contains.contains(str)) {
                return Boolean.valueOf(1);
            }
        }
        return Boolean.valueOf(false);
    }

    private String[] getAcceptedMimeType(String[] strArr) {
        if (isArrayEmpty(strArr).booleanValue()) {
            return new String[]{"*/*"};
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str.matches("\\.\\w+")) {
                strArr2[i] = getMimeTypeFromExtension(str.replace(".", ""));
            } else {
                strArr2[i] = str;
            }
        }
        return strArr2;
    }

    private String getMimeTypeFromExtension(String str) {
        return str != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : null;
    }

    private Uri getOutputUri(String str) {
        try {
            str = getCapturedFile(str);
        } catch (String str2) {
            Log.e("CREATE FILE", "Error occurred while creating the File", str2);
            str2.printStackTrace();
            str2 = null;
        }
        if (VERSION.SDK_INT < 23) {
            return Uri.fromFile(str2);
        }
        String packageName = getReactApplicationContext().getPackageName();
        Context reactApplicationContext = getReactApplicationContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName);
        stringBuilder.append(".fileprovider");
        return FileProvider.a(reactApplicationContext, stringBuilder.toString(), str2);
    }

    private File getCapturedFile(String str) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (str.equals("android.media.action.IMAGE_CAPTURE")) {
            str2 = "image-";
            str3 = ".jpg";
            str4 = Environment.DIRECTORY_PICTURES;
        } else if (str.equals("android.media.action.VIDEO_CAPTURE") != null) {
            str2 = "video-";
            str3 = ".mp4";
            str4 = Environment.DIRECTORY_MOVIES;
        }
        str = new StringBuilder();
        str.append(str2);
        str.append(String.valueOf(System.currentTimeMillis()));
        str.append(str3);
        str = str.toString();
        if (VERSION.SDK_INT < 23) {
            return new File(Environment.getExternalStoragePublicDirectory(str4), str);
        }
        return File.createTempFile(str, str3, getReactApplicationContext().getExternalFilesDir(null));
    }

    private Boolean isArrayEmpty(String[] strArr) {
        boolean z = false;
        if (strArr.length == 0 || (strArr.length == 1 && strArr[0].length() == null)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private PermissionAwareActivity getPermissionAwareActivity() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        } else if (currentActivity instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) currentActivity;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
    }
}
