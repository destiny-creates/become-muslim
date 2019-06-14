package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.File;
import java.util.Collection;

public class ApplicationSoSource extends SoSource {
    private Context applicationContext;
    private int flags;
    private DirectorySoSource soSource;

    public ApplicationSoSource(Context context, int i) {
        this.applicationContext = context.getApplicationContext();
        if (this.applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.applicationContext = context;
        }
        this.flags = i;
        this.soSource = new DirectorySoSource(new File(this.applicationContext.getApplicationInfo().nativeLibraryDir), i);
    }

    public boolean checkAndMaybeUpdate() {
        try {
            File file = this.soSource.soDirectory;
            Context createPackageContext = this.applicationContext.createPackageContext(this.applicationContext.getPackageName(), 0);
            File file2 = new File(createPackageContext.getApplicationInfo().nativeLibraryDir);
            if (file.equals(file2)) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Native library directory updated from ");
            stringBuilder.append(file);
            stringBuilder.append(" to ");
            stringBuilder.append(file2);
            Log.d("SoLoader", stringBuilder.toString());
            this.flags |= 1;
            this.soSource = new DirectorySoSource(file2, this.flags);
            this.soSource.prepare(this.flags);
            this.applicationContext = createPackageContext;
            return true;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int loadLibrary(String str, int i, ThreadPolicy threadPolicy) {
        return this.soSource.loadLibrary(str, i, threadPolicy);
    }

    public File unpackLibrary(String str) {
        return this.soSource.unpackLibrary(str);
    }

    protected void prepare(int i) {
        this.soSource.prepare(i);
    }

    public void addToLdLibraryPath(Collection<String> collection) {
        this.soSource.addToLdLibraryPath(collection);
    }

    public String toString() {
        return this.soSource.toString();
    }
}
