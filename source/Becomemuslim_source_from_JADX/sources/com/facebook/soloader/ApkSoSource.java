package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import java.io.File;
import java.util.zip.ZipEntry;

public class ApkSoSource extends ExtractFromZipSoSource {
    private static final byte APK_SO_SOURCE_SIGNATURE_VERSION = (byte) 2;
    private static final byte LIBS_DIR_DOESNT_EXIST = (byte) 1;
    private static final byte LIBS_DIR_DONT_CARE = (byte) 0;
    private static final byte LIBS_DIR_SNAPSHOT = (byte) 2;
    public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
    private static final String TAG = "ApkSoSource";
    private final int mFlags;

    protected class ApkUnpacker extends ZipUnpacker {
        private final int mFlags;
        private File mLibDir;

        ApkUnpacker(ExtractFromZipSoSource extractFromZipSoSource) {
            super(extractFromZipSoSource);
            this.mLibDir = new File(ApkSoSource.this.mContext.getApplicationInfo().nativeLibraryDir);
            this.mFlags = ApkSoSource.this.mFlags;
        }

        protected boolean shouldExtract(ZipEntry zipEntry, String str) {
            String name = zipEntry.getName();
            boolean z = true;
            if (str.equals(ApkSoSource.this.mCorruptedLib)) {
                ApkSoSource.this.mCorruptedLib = null;
                zipEntry = String.format("allowing consideration of corrupted lib %s", new Object[]{str});
            } else if ((this.mFlags & 1) == 0) {
                zipEntry = new StringBuilder();
                zipEntry.append("allowing consideration of ");
                zipEntry.append(name);
                zipEntry.append(": self-extraction preferred");
                zipEntry = zipEntry.toString();
            } else {
                File file = new File(this.mLibDir, str);
                if (file.isFile()) {
                    if (file.length() != zipEntry.getSize()) {
                        zipEntry = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", new Object[]{file, Long.valueOf(file.length()), Long.valueOf(zipEntry.getSize())});
                    } else {
                        zipEntry = new StringBuilder();
                        zipEntry.append("not allowing consideration of ");
                        zipEntry.append(name);
                        zipEntry.append(": deferring to libdir");
                        zipEntry = zipEntry.toString();
                        z = false;
                    }
                } else {
                    zipEntry = String.format("allowing considering of %s: %s not in system lib dir", new Object[]{name, str});
                }
            }
            Log.d(ApkSoSource.TAG, zipEntry);
            return z;
        }
    }

    public ApkSoSource(Context context, String str, int i) {
        super(context, str, new File(context.getApplicationInfo().sourceDir), "^lib/([^/]+)/([^/]+\\.so)$");
        this.mFlags = i;
    }

    protected Unpacker makeUnpacker() {
        return new ApkUnpacker(this);
    }

    protected byte[] getDepsBlock() {
        File canonicalFile = this.mZipFileName.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(SysUtil.getAppVersionCode(this.mContext));
            byte[] marshall;
            if ((this.mFlags & 1) == 0) {
                obtain.writeByte(LIBS_DIR_DONT_CARE);
                marshall = obtain.marshall();
                return marshall;
            }
            String str = this.mContext.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                obtain.writeByte((byte) 1);
                marshall = obtain.marshall();
                obtain.recycle();
                return marshall;
            }
            canonicalFile = new File(str).getCanonicalFile();
            if (canonicalFile.exists()) {
                obtain.writeByte((byte) 2);
                obtain.writeString(canonicalFile.getPath());
                obtain.writeLong(canonicalFile.lastModified());
                marshall = obtain.marshall();
                obtain.recycle();
                return marshall;
            }
            obtain.writeByte((byte) 1);
            marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }
}
