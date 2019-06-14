package okhttp3.internal.ws;

import com.facebook.stetho.websocket.CloseCodes;
import p286d.C5869f;
import p286d.C8037c.C5868a;

public final class WebSocketProtocol {
    static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    static final int B0_FLAG_FIN = 128;
    static final int B0_FLAG_RSV1 = 64;
    static final int B0_FLAG_RSV2 = 32;
    static final int B0_FLAG_RSV3 = 16;
    static final int B0_MASK_OPCODE = 15;
    static final int B1_FLAG_MASK = 128;
    static final int B1_MASK_LENGTH = 127;
    static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    static final long CLOSE_MESSAGE_MAX = 123;
    static final int CLOSE_NO_STATUS_CODE = 1005;
    static final int OPCODE_BINARY = 2;
    static final int OPCODE_CONTINUATION = 0;
    static final int OPCODE_CONTROL_CLOSE = 8;
    static final int OPCODE_CONTROL_PING = 9;
    static final int OPCODE_CONTROL_PONG = 10;
    static final int OPCODE_FLAG_CONTROL = 8;
    static final int OPCODE_TEXT = 1;
    static final long PAYLOAD_BYTE_MAX = 125;
    static final int PAYLOAD_LONG = 127;
    static final int PAYLOAD_SHORT = 126;
    static final long PAYLOAD_SHORT_MAX = 65535;

    static void toggleMask(C5868a c5868a, byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = c5868a.f19522d;
            int i2 = c5868a.f19523e;
            int i3 = c5868a.f19524f;
            while (i2 < i3) {
                i %= length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i]);
                i2++;
                i++;
            }
        } while (c5868a.m24692a() != -1);
    }

    static String closeCodeExceptionMessage(int i) {
        StringBuilder stringBuilder;
        if (i >= 1000) {
            if (i < 5000) {
                if ((i < 1004 || i > CloseCodes.CLOSED_ABNORMALLY) && (i < 1012 || i > 2999)) {
                    return 0;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Code ");
                stringBuilder.append(i);
                stringBuilder.append(" is reserved and may not be used.");
                return stringBuilder.toString();
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Code must be in range [1000,5000): ");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    static void validateCloseCode(int i) {
        i = closeCodeExceptionMessage(i);
        if (i != 0) {
            throw new IllegalArgumentException(i);
        }
    }

    public static String acceptHeader(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(ACCEPT_MAGIC);
        return C5869f.m24697a(stringBuilder.toString()).mo5105d().mo5103b();
    }

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }
}
