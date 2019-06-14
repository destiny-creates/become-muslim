package org.spongycastle.util.encoders;

import com.facebook.stetho.dumpapp.Framer;

public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        this.a[this.a.length - 2] = Framer.STDIN_FRAME_PREFIX;
        this.a[this.a.length - 1] = Framer.STDIN_REQUEST_FRAME_PREFIX;
        this.b = (byte) 46;
        m36593a();
    }
}
