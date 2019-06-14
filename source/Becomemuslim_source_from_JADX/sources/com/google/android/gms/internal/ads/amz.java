package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class amz {

    /* renamed from: com.google.android.gms.internal.ads.amz$a */
    public static final class C8283a extends abq<C8283a, C8282a> implements acz {
        private static final C8283a zzakg = new C8283a();
        private static volatile adj<C8283a> zzakh;

        /* renamed from: com.google.android.gms.internal.ads.amz$a$b */
        public enum C6762b implements abt {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(AdError.NO_FILL_ERROR_CODE),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(1003),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(CloseCodes.CLOSED_ABNORMALLY),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001);
            
            /* renamed from: D */
            private static final abu<C6762b> f23731D = null;
            /* renamed from: E */
            private final int f23759E;

            static {
                f23731D = new anb();
            }

            private C6762b(int i) {
                this.f23759E = i;
            }

            /* renamed from: a */
            public static C6762b m30049a(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_EVENT_TYPE;
                    case 1:
                        return AD_REQUEST;
                    case 2:
                        return AD_LOADED;
                    case 3:
                        return AD_FAILED_TO_LOAD;
                    case 4:
                        return AD_FAILED_TO_LOAD_NO_FILL;
                    case 5:
                        return AD_IMPRESSION;
                    case 6:
                        return AD_FIRST_CLICK;
                    case 7:
                        return AD_SUBSEQUENT_CLICK;
                    case 8:
                        return REQUEST_WILL_START;
                    case 9:
                        return REQUEST_DID_END;
                    case 10:
                        return REQUEST_WILL_UPDATE_SIGNALS;
                    case 11:
                        return REQUEST_DID_UPDATE_SIGNALS;
                    case 12:
                        return REQUEST_WILL_BUILD_URL;
                    case 13:
                        return REQUEST_DID_BUILD_URL;
                    case 14:
                        return REQUEST_WILL_MAKE_NETWORK_REQUEST;
                    case 15:
                        return REQUEST_DID_RECEIVE_NETWORK_RESPONSE;
                    case 16:
                        return REQUEST_WILL_PROCESS_RESPONSE;
                    case 17:
                        return REQUEST_DID_PROCESS_RESPONSE;
                    case 18:
                        return REQUEST_WILL_RENDER;
                    case 19:
                        return REQUEST_DID_RENDER;
                    default:
                        switch (i) {
                            case 1000:
                                return REQUEST_WILL_UPDATE_GMS_SIGNALS;
                            case AdError.NO_FILL_ERROR_CODE /*1001*/:
                                return REQUEST_DID_UPDATE_GMS_SIGNALS;
                            case 1002:
                                return REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS;
                            case 1003:
                                return REQUEST_FAILED_TO_BUILD_URL;
                            case 1004:
                                return REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST;
                            case 1005:
                                return REQUEST_FAILED_TO_PROCESS_RESPONSE;
                            case CloseCodes.CLOSED_ABNORMALLY /*1006*/:
                                return REQUEST_FAILED_TO_UPDATE_SIGNALS;
                            default:
                                switch (i) {
                                    case 10000:
                                        return BANNER_SIZE_INVALID;
                                    case 10001:
                                        return BANNER_SIZE_VALID;
                                    default:
                                        return null;
                                }
                        }
                }
            }

            /* renamed from: a */
            public final int mo3849a() {
                return this.f23759E;
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.amz$a$a */
        public static final class C8282a extends C8211a<C8283a, C8282a> implements acz {
            private C8282a() {
                super(C8283a.zzakg);
            }
        }

        static {
            abq.m42174a(C8283a.class, zzakg);
        }

        private C8283a() {
        }

        /* renamed from: a */
        protected final Object mo6835a(int i, Object obj, Object obj2) {
            switch (ana.f14770a[i - 1]) {
                case 1:
                    return new C8283a();
                case 2:
                    return new C8282a();
                case 3:
                    return abq.m42172a(zzakg, "\u0001\u0000", null);
                case 4:
                    return zzakg;
                case 5:
                    Object obj3 = zzakh;
                    if (obj3 == null) {
                        synchronized (C8283a.class) {
                            obj3 = zzakh;
                            if (obj3 == null) {
                                obj3 = new C6757b(zzakg);
                                zzakh = obj3;
                            }
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf((byte) 1);
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
