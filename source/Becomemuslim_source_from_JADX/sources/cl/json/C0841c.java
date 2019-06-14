package cl.json;

import android.content.CursorLoader;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ShareFile */
/* renamed from: cl.json.c */
public class C0841c {
    /* renamed from: a */
    private final ReactApplicationContext f2335a;
    /* renamed from: b */
    private String f2336b;
    /* renamed from: c */
    private Uri f2337c;
    /* renamed from: d */
    private String f2338d;
    /* renamed from: e */
    private String f2339e;

    public C0841c(String str, String str2, ReactApplicationContext reactApplicationContext) {
        this(str, reactApplicationContext);
        this.f2338d = str2;
    }

    public C0841c(String str, ReactApplicationContext reactApplicationContext) {
        this.f2339e = "";
        this.f2336b = str;
        this.f2337c = Uri.parse(this.f2336b);
        this.f2335a = reactApplicationContext;
    }

    /* renamed from: a */
    private String m3032a(String str) {
        str = MimeTypeMap.getFileExtensionFromUrl(str);
        return str != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : null;
    }

    /* renamed from: a */
    public boolean m3033a() {
        if (!m3034b()) {
            if (!m3035c()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m3034b() {
        if (this.f2337c.getScheme() == null || !this.f2337c.getScheme().equals("data")) {
            return false;
        }
        this.f2338d = this.f2337c.getSchemeSpecificPart().substring(0, this.f2337c.getSchemeSpecificPart().indexOf(";"));
        return true;
    }

    /* renamed from: c */
    public boolean m3035c() {
        if (this.f2337c.getScheme() == null || (!this.f2337c.getScheme().equals(UriUtil.LOCAL_CONTENT_SCHEME) && !this.f2337c.getScheme().equals(UriUtil.LOCAL_FILE_SCHEME))) {
            return false;
        }
        if (this.f2338d != null) {
            return true;
        }
        this.f2338d = m3032a(this.f2337c.toString());
        if (this.f2338d == null) {
            String a = m3031a(this.f2337c);
            if (a == null) {
                return false;
            }
            this.f2338d = m3032a(a);
        }
        if (this.f2338d == null) {
            this.f2338d = "*/*";
        }
        return true;
    }

    /* renamed from: d */
    public String m3036d() {
        if (this.f2338d == null) {
            return "*/*";
        }
        return this.f2338d;
    }

    /* renamed from: a */
    private String m3031a(Uri uri) {
        uri = new CursorLoader(this.f2335a, uri, new String[]{"_data"}, null, null, null).loadInBackground();
        if (uri == null || !uri.moveToFirst()) {
            return null;
        }
        String string = uri.getString(uri.getColumnIndexOrThrow("_data"));
        uri.close();
        return string;
    }

    /* renamed from: e */
    public Uri m3037e() {
        this.f2339e = MimeTypeMap.getSingleton().getExtensionFromMimeType(m3036d());
        String a = ((C0840b) this.f2335a.getApplicationContext()).m3030a();
        if (m3034b()) {
            String substring = this.f2337c.getSchemeSpecificPart().substring(this.f2337c.getSchemeSpecificPart().indexOf(";base64,") + 8);
            try {
                File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DOWNLOADS);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(System.nanoTime());
                stringBuilder.append(".");
                stringBuilder.append(this.f2339e);
                File file2 = new File(file, stringBuilder.toString());
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(Base64.decode(substring, 0));
                fileOutputStream.flush();
                fileOutputStream.close();
                return FileProvider.m1053a(this.f2335a, a, file2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (m3035c()) {
                return FileProvider.m1053a(this.f2335a, a, new File(Uri.parse(this.f2336b).getPath()));
            }
            return null;
        }
    }
}
