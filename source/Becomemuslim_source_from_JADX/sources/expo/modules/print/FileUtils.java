package expo.modules.print;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
    public static Uri uriFromFile(File file) {
        return Uri.fromFile(file);
    }

    public static File ensureDirExists(File file) {
        if (!file.isDirectory()) {
            if (!file.mkdirs()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't create directory '");
                stringBuilder.append(file);
                stringBuilder.append("'");
                throw new IOException(stringBuilder.toString());
            }
        }
        return file;
    }

    public static String generateOutputPath(File file, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        File file2 = new File(stringBuilder.toString());
        ensureDirExists(file2);
        file = UUID.randomUUID().toString();
        str = new StringBuilder();
        str.append(file2);
        str.append(File.separator);
        str.append(file);
        str.append(str2);
        return str.toString();
    }
}
