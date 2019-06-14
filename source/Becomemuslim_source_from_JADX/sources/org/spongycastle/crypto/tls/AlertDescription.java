package org.spongycastle.crypto.tls;

public class AlertDescription {
    /* renamed from: a */
    public static String m27533a(short s) {
        switch (s) {
            case (short) 20:
                return "bad_record_mac";
            case (short) 21:
                return "decryption_failed";
            case (short) 22:
                return "record_overflow";
            default:
                switch (s) {
                    case (short) 40:
                        return "handshake_failure";
                    case (short) 41:
                        return "no_certificate";
                    case (short) 42:
                        return "bad_certificate";
                    case (short) 43:
                        return "unsupported_certificate";
                    case (short) 44:
                        return "certificate_revoked";
                    case (short) 45:
                        return "certificate_expired";
                    case (short) 46:
                        return "certificate_unknown";
                    case (short) 47:
                        return "illegal_parameter";
                    case (short) 48:
                        return "unknown_ca";
                    case (short) 49:
                        return "access_denied";
                    case (short) 50:
                        return "decode_error";
                    case (short) 51:
                        return "decrypt_error";
                    default:
                        switch (s) {
                            case (short) 70:
                                return "protocol_version";
                            case (short) 71:
                                return "insufficient_security";
                            default:
                                switch (s) {
                                    case (short) 110:
                                        return "unsupported_extension";
                                    case (short) 111:
                                        return "certificate_unobtainable";
                                    case (short) 112:
                                        return "unrecognized_name";
                                    case (short) 113:
                                        return "bad_certificate_status_response";
                                    case (short) 114:
                                        return "bad_certificate_hash_value";
                                    case (short) 115:
                                        return "unknown_psk_identity";
                                    default:
                                        switch (s) {
                                            case (short) 0:
                                                return "close_notify";
                                            case (short) 10:
                                                return "unexpected_message";
                                            case (short) 30:
                                                return "decompression_failure";
                                            case (short) 60:
                                                return "export_restriction";
                                            case (short) 80:
                                                return "internal_error";
                                            case (short) 86:
                                                return "inappropriate_fallback";
                                            case (short) 90:
                                                return "user_canceled";
                                            case (short) 100:
                                                return "no_renegotiation";
                                            default:
                                                return "UNKNOWN";
                                        }
                                }
                        }
                }
        }
    }

    /* renamed from: b */
    public static String m27534b(short s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m27533a(s));
        stringBuilder.append("(");
        stringBuilder.append(s);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
