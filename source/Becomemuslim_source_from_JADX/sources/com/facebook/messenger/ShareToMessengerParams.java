package com.facebook.messenger;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ShareToMessengerParams {
    public static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
    public static final Set<String> VALID_MIME_TYPES;
    public static final Set<String> VALID_URI_SCHEMES;
    public final Uri externalUri;
    public final String metaData;
    public final String mimeType;
    public final Uri uri;

    static {
        Set hashSet = new HashSet();
        hashSet.add("image/*");
        hashSet.add("image/jpeg");
        hashSet.add("image/png");
        hashSet.add("image/gif");
        hashSet.add("image/webp");
        hashSet.add("video/*");
        hashSet.add("video/mp4");
        hashSet.add("audio/*");
        hashSet.add("audio/mpeg");
        VALID_MIME_TYPES = Collections.unmodifiableSet(hashSet);
        hashSet = new HashSet();
        hashSet.add(UriUtil.LOCAL_CONTENT_SCHEME);
        hashSet.add(UriUtil.QUALIFIED_RESOURCE_SCHEME);
        hashSet.add(UriUtil.LOCAL_FILE_SCHEME);
        VALID_URI_SCHEMES = Collections.unmodifiableSet(hashSet);
        hashSet = new HashSet();
        hashSet.add(UriUtil.HTTP_SCHEME);
        hashSet.add(UriUtil.HTTPS_SCHEME);
        VALID_EXTERNAL_URI_SCHEMES = Collections.unmodifiableSet(hashSet);
    }

    ShareToMessengerParams(ShareToMessengerParamsBuilder shareToMessengerParamsBuilder) {
        this.uri = shareToMessengerParamsBuilder.getUri();
        this.mimeType = shareToMessengerParamsBuilder.getMimeType();
        this.metaData = shareToMessengerParamsBuilder.getMetaData();
        this.externalUri = shareToMessengerParamsBuilder.getExternalUri();
        if (this.uri == null) {
            throw new NullPointerException("Must provide non-null uri");
        } else if (this.mimeType == null) {
            throw new NullPointerException("Must provide mimeType");
        } else if (VALID_URI_SCHEMES.contains(this.uri.getScheme()) == null) {
            r0 = new StringBuilder();
            r0.append("Unsupported URI scheme: ");
            r0.append(this.uri.getScheme());
            throw new IllegalArgumentException(r0.toString());
        } else if (VALID_MIME_TYPES.contains(this.mimeType) == null) {
            r0 = new StringBuilder();
            r0.append("Unsupported mime-type: ");
            r0.append(this.mimeType);
            throw new IllegalArgumentException(r0.toString());
        } else if (this.externalUri == null) {
        } else {
            if (VALID_EXTERNAL_URI_SCHEMES.contains(this.externalUri.getScheme()) == null) {
                r0 = new StringBuilder();
                r0.append("Unsupported external uri scheme: ");
                r0.append(this.externalUri.getScheme());
                throw new IllegalArgumentException(r0.toString());
            }
        }
    }

    public static ShareToMessengerParamsBuilder newBuilder(Uri uri, String str) {
        return new ShareToMessengerParamsBuilder(uri, str);
    }
}
