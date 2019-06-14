package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.protocol.module.Console.MessageLevel;
import com.facebook.stetho.inspector.protocol.module.Console.MessageSource;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;

public class DecompressionHelper {
    static final String DEFLATE_ENCODING = "deflate";
    static final String GZIP_ENCODING = "gzip";

    public static InputStream teeInputWithDecompression(NetworkPeerManager networkPeerManager, String str, InputStream inputStream, OutputStream outputStream, String str2, ResponseHandler responseHandler) {
        if (str2 != null) {
            boolean equals = GZIP_ENCODING.equals(str2);
            boolean equals2 = DEFLATE_ENCODING.equals(str2);
            if (!equals) {
                if (!equals2) {
                    MessageLevel messageLevel = MessageLevel.WARNING;
                    MessageSource messageSource = MessageSource.NETWORK;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported Content-Encoding in response for request #");
                    stringBuilder.append(str);
                    stringBuilder.append(": ");
                    stringBuilder.append(str2);
                    CLog.writeToConsole(networkPeerManager, messageLevel, messageSource, stringBuilder.toString());
                }
            }
            str2 = new CountingOutputStream(outputStream);
            if (equals) {
                outputStream = GunzippingOutputStream.create(str2);
            } else if (equals2) {
                outputStream = new InflaterOutputStream(str2);
            }
            return new ResponseHandlingInputStream(inputStream, str, outputStream, str2, networkPeerManager, responseHandler);
        }
        str2 = null;
        return new ResponseHandlingInputStream(inputStream, str, outputStream, str2, networkPeerManager, responseHandler);
    }
}
