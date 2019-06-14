package cl.json;

import android.content.CursorLoader;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ShareFiles */
/* renamed from: cl.json.d */
public class C0842d {
    /* renamed from: a */
    private final ReactApplicationContext f2340a;
    /* renamed from: b */
    private ReadableArray f2341b;
    /* renamed from: c */
    private ArrayList<Uri> f2342c;
    /* renamed from: d */
    private String f2343d;

    public C0842d(ReadableArray readableArray, String str, ReactApplicationContext reactApplicationContext) {
        this(readableArray, reactApplicationContext);
        this.f2343d = str;
    }

    public C0842d(ReadableArray readableArray, ReactApplicationContext reactApplicationContext) {
        this.f2341b = readableArray;
        this.f2342c = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                this.f2342c.add(Uri.parse(string));
            }
        }
        this.f2340a = reactApplicationContext;
    }

    /* renamed from: a */
    private String m3038a(String str) {
        str = MimeTypeMap.getFileExtensionFromUrl(str);
        return str != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : null;
    }

    /* renamed from: a */
    public boolean m3042a() {
        Iterator it = this.f2342c.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!m3039a(uri)) {
                if (!m3040b(uri)) {
                    z = false;
                    continue;
                    if (!z) {
                        break;
                    }
                }
            }
            z = true;
            continue;
            if (z) {
                break;
            }
        }
        return z;
    }

    /* renamed from: a */
    private boolean m3039a(Uri uri) {
        if (uri.getScheme() == null || !uri.getScheme().equals("data")) {
            return false;
        }
        uri = uri.getSchemeSpecificPart().substring(0, uri.getSchemeSpecificPart().indexOf(";"));
        if (this.f2343d == null) {
            this.f2343d = uri;
        } else if (uri != null && !this.f2343d.equalsIgnoreCase(uri) && this.f2343d.split("/")[0].equalsIgnoreCase(uri.split("/")[0])) {
            this.f2343d = this.f2343d.split("/")[0].concat("/*");
        } else if (this.f2343d.equalsIgnoreCase(uri) == null) {
            this.f2343d = "*/*";
        }
        return true;
    }

    /* renamed from: b */
    private boolean m3040b(Uri uri) {
        if ((uri.getScheme() == null || !uri.getScheme().equals(UriUtil.LOCAL_CONTENT_SCHEME)) && !uri.getScheme().equals(UriUtil.LOCAL_FILE_SCHEME)) {
            return false;
        }
        String a = m3038a(uri.toString());
        if (a == null) {
            a = m3038a(m3041c(uri));
        }
        if (a == null) {
            a = "*/*";
        }
        if (this.f2343d == null) {
            this.f2343d = a;
        } else if (a != null && this.f2343d.equalsIgnoreCase(a) == null && this.f2343d.split("/")[0].equalsIgnoreCase(a.split("/")[0]) != null) {
            this.f2343d = this.f2343d.split("/")[0].concat("/*");
        } else if (this.f2343d.equalsIgnoreCase(a) == null) {
            this.f2343d = "*/*";
        }
        return true;
    }

    /* renamed from: b */
    public String m3043b() {
        if (this.f2343d == null) {
            return "*/*";
        }
        return this.f2343d;
    }

    /* renamed from: c */
    private String m3041c(Uri uri) {
        uri = new CursorLoader(this.f2340a, uri, new String[]{"_data"}, null, null, null).loadInBackground();
        int columnIndexOrThrow = uri.getColumnIndexOrThrow("_data");
        uri.moveToFirst();
        String string = uri.getString(columnIndexOrThrow);
        uri.close();
        return string;
    }

    /* renamed from: c */
    public ArrayList<Uri> m3044c() {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        ArrayList<Uri> arrayList = new ArrayList();
        String a = ((C0840b) this.f2340a.getApplicationContext()).m3030a();
        Iterator it = this.f2342c.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (m3039a(uri)) {
                String extensionFromMimeType = singleton.getExtensionFromMimeType(uri.getSchemeSpecificPart().substring(0, uri.getSchemeSpecificPart().indexOf(";")));
                String substring = uri.getSchemeSpecificPart().substring(uri.getSchemeSpecificPart().indexOf(";base64,") + 8);
                try {
                    File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DOWNLOADS);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(System.currentTimeMillis());
                    stringBuilder.append(".");
                    stringBuilder.append(extensionFromMimeType);
                    File file2 = new File(file, stringBuilder.toString());
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    fileOutputStream.write(Base64.decode(substring, 0));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    arrayList.add(FileProvider.m1053a(this.f2340a, a, file2));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (m3040b(uri)) {
                arrayList.add(FileProvider.m1053a(this.f2340a, a, new File(uri.getPath())));
            }
        }
        return arrayList;
    }
}
