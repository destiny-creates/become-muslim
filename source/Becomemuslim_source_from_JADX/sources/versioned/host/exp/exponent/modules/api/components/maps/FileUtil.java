package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.Clock;
import com.facebook.common.util.UriUtil;
import com.facebook.react.common.ReactConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileUtil extends AsyncTask<String, Void, InputStream> {
    private final String NAME = "FileUtil";
    private final String TEMP_FILE_SUFFIX = "temp";
    private Context context;
    private Exception exception;

    public FileUtil(Context context) {
        this.context = context;
    }

    protected InputStream doInBackground(String... strArr) {
        try {
            Uri parse = Uri.parse(strArr[0]);
            if (parse.getScheme().startsWith(UriUtil.HTTP_SCHEME)) {
                return getDownloadFileInputStream(this.context, parse);
            }
            return this.context.getContentResolver().openInputStream(parse);
        } catch (Throwable e) {
            this.exception = e;
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not retrieve file for contentUri ");
            stringBuilder.append(strArr[0]);
            FLog.e(str, stringBuilder.toString(), e);
            return null;
        }
    }

    private InputStream getDownloadFileInputStream(Context context, Uri uri) {
        FileOutputStream fileOutputStream;
        context = File.createTempFile("FileUtil", "temp", context.getApplicationContext().getCacheDir());
        context.deleteOnExit();
        InputStream url = new URL(uri.toString());
        uri = url.openStream();
        try {
            ReadableByteChannel newChannel = Channels.newChannel(uri);
            try {
                fileOutputStream = new FileOutputStream(context);
                fileOutputStream.getChannel().transferFrom(newChannel, 0, Clock.MAX_TIME);
                url = new FileInputStream(context);
                fileOutputStream.close();
                newChannel.close();
                return url;
            } catch (Throwable th) {
                newChannel.close();
            }
        } finally {
            uri.close();
        }
    }
}
