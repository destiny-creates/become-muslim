package com.google.ads;

@Deprecated
/* renamed from: com.google.ads.a */
public final class C2172a {

    /* renamed from: com.google.ads.a$a */
    public enum C2170a {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        /* renamed from: e */
        private final String f5208e;

        private C2170a(String str) {
            this.f5208e = str;
        }

        public final String toString() {
            return this.f5208e;
        }
    }

    /* renamed from: com.google.ads.a$b */
    public enum C2171b {
        UNKNOWN,
        MALE,
        FEMALE
    }
}
