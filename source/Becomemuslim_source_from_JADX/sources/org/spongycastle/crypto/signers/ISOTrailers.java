package org.spongycastle.crypto.signers;

import com.imagepicker.ImagePickerModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Integers;

public class ISOTrailers {
    /* renamed from: a */
    private static final Map<String, Integer> f22460a;

    static {
        Map hashMap = new HashMap();
        hashMap.put("RIPEMD128", Integers.m29396a(ImagePickerModule.REQUEST_LAUNCH_VIDEO_CAPTURE));
        hashMap.put("RIPEMD160", Integers.m29396a(12748));
        hashMap.put("SHA-1", Integers.m29396a(13260));
        hashMap.put("SHA-224", Integers.m29396a(14540));
        hashMap.put("SHA-256", Integers.m29396a(13516));
        hashMap.put("SHA-384", Integers.m29396a(14028));
        hashMap.put("SHA-512", Integers.m29396a(13772));
        hashMap.put("SHA-512/224", Integers.m29396a(14796));
        hashMap.put("SHA-512/256", Integers.m29396a(16588));
        hashMap.put("Whirlpool", Integers.m29396a(14284));
        f22460a = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static Integer m27532a(Digest digest) {
        return (Integer) f22460a.get(digest.mo5729a());
    }
}
