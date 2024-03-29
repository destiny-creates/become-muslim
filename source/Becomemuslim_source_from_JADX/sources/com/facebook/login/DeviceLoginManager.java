package com.facebook.login;

import android.net.Uri;
import com.facebook.login.LoginClient.Request;
import java.util.Collection;

public class DeviceLoginManager extends LoginManager {
    private static volatile DeviceLoginManager instance;
    private String deviceAuthTargetUserId;
    private Uri deviceRedirectUri;

    public static DeviceLoginManager getInstance() {
        if (instance == null) {
            synchronized (DeviceLoginManager.class) {
                if (instance == null) {
                    instance = new DeviceLoginManager();
                }
            }
        }
        return instance;
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    public Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    public void setDeviceAuthTargetUserId(String str) {
        this.deviceAuthTargetUserId = str;
    }

    public String getDeviceAuthTargetUserId() {
        return this.deviceAuthTargetUserId;
    }

    protected Request createLoginRequest(Collection<String> collection) {
        collection = super.createLoginRequest(collection);
        Uri deviceRedirectUri = getDeviceRedirectUri();
        if (deviceRedirectUri != null) {
            collection.setDeviceRedirectUriString(deviceRedirectUri.toString());
        }
        String deviceAuthTargetUserId = getDeviceAuthTargetUserId();
        if (deviceAuthTargetUserId != null) {
            collection.setDeviceAuthTargetUserId(deviceAuthTargetUserId);
        }
        return collection;
    }
}
