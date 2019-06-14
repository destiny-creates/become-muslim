package com.bugsnag.android;

import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;

public enum BreadcrumbType {
    ERROR("error"),
    LOG("log"),
    MANUAL("manual"),
    NAVIGATION("navigation"),
    PROCESS("process"),
    REQUEST(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID),
    STATE(ServerProtocol.DIALOG_PARAM_STATE),
    USER("user");
    
    private final String type;

    private BreadcrumbType(String str) {
        this.type = str;
    }

    public String toString() {
        return this.type;
    }
}
