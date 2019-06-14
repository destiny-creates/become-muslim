package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class RijndaelEngine implements BlockCipher {
    /* renamed from: a */
    static byte[][] f26747a = new byte[][]{new byte[]{(byte) 0, (byte) 8, (byte) 16, (byte) 24}, new byte[]{(byte) 0, (byte) 8, (byte) 16, (byte) 24}, new byte[]{(byte) 0, (byte) 8, (byte) 16, (byte) 24}, new byte[]{(byte) 0, (byte) 8, (byte) 16, (byte) 32}, new byte[]{(byte) 0, (byte) 8, (byte) 24, (byte) 32}};
    /* renamed from: b */
    static byte[][] f26748b = new byte[][]{new byte[]{(byte) 0, (byte) 24, (byte) 16, (byte) 8}, new byte[]{(byte) 0, (byte) 32, (byte) 24, (byte) 16}, new byte[]{(byte) 0, (byte) 40, (byte) 32, (byte) 24}, new byte[]{(byte) 0, (byte) 48, (byte) 40, (byte) 24}, new byte[]{(byte) 0, (byte) 56, (byte) 40, (byte) 32}};
    /* renamed from: c */
    private static final byte[] f26749c = new byte[]{(byte) 0, (byte) 0, (byte) 25, (byte) 1, Framer.STDERR_FRAME_PREFIX, (byte) 2, (byte) 26, (byte) -58, (byte) 75, (byte) -57, (byte) 27, (byte) 104, (byte) 51, (byte) -18, (byte) -33, (byte) 3, (byte) 100, (byte) 4, (byte) -32, (byte) 14, (byte) 52, (byte) -115, (byte) -127, (byte) -17, (byte) 76, (byte) 113, (byte) 8, (byte) -56, (byte) -8, (byte) 105, (byte) 28, (byte) -63, (byte) 125, (byte) -62, (byte) 29, (byte) -75, (byte) -7, (byte) -71, (byte) 39, (byte) 106, (byte) 77, (byte) -28, (byte) -90, (byte) 114, (byte) -102, (byte) -55, (byte) 9, Framer.EXIT_FRAME_PREFIX, (byte) 101, (byte) 47, (byte) -118, (byte) 5, Framer.ENTER_FRAME_PREFIX, (byte) 15, (byte) -31, (byte) 36, (byte) 18, (byte) -16, (byte) -126, (byte) 69, (byte) 53, (byte) -109, (byte) -38, (byte) -114, (byte) -106, (byte) -113, (byte) -37, (byte) -67, (byte) 54, (byte) -48, (byte) -50, (byte) -108, (byte) 19, (byte) 92, (byte) -46, (byte) -15, (byte) 64, (byte) 70, (byte) -125, (byte) 56, (byte) 102, (byte) -35, (byte) -3, (byte) 48, (byte) -65, (byte) 6, (byte) -117, (byte) 98, (byte) -77, (byte) 37, (byte) -30, (byte) -104, (byte) 34, (byte) -120, (byte) -111, (byte) 16, (byte) 126, (byte) 110, (byte) 72, (byte) -61, (byte) -93, (byte) -74, (byte) 30, (byte) 66, (byte) 58, (byte) 107, (byte) 40, (byte) 84, (byte) -6, (byte) -123, (byte) 61, (byte) -70, (byte) 43, (byte) 121, (byte) 10, (byte) 21, (byte) -101, (byte) -97, (byte) 94, (byte) -54, (byte) 78, (byte) -44, (byte) -84, (byte) -27, (byte) -13, (byte) 115, (byte) -89, (byte) 87, (byte) -81, (byte) 88, (byte) -88, (byte) 80, (byte) -12, (byte) -22, (byte) -42, (byte) 116, (byte) 79, (byte) -82, (byte) -23, (byte) -43, (byte) -25, (byte) -26, (byte) -83, (byte) -24, (byte) 44, (byte) -41, (byte) 117, (byte) 122, (byte) -21, (byte) 22, (byte) 11, (byte) -11, (byte) 89, (byte) -53, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -80, (byte) -100, (byte) -87, (byte) 81, (byte) -96, Byte.MAX_VALUE, (byte) 12, (byte) -10, (byte) 111, (byte) 23, (byte) -60, (byte) 73, (byte) -20, (byte) -40, (byte) 67, (byte) 31, Framer.STDIN_FRAME_PREFIX, (byte) -92, (byte) 118, (byte) 123, (byte) -73, (byte) -52, (byte) -69, (byte) 62, (byte) 90, (byte) -5, (byte) 96, (byte) -79, (byte) -122, (byte) 59, (byte) 82, (byte) -95, (byte) 108, (byte) -86, (byte) 85, (byte) 41, (byte) -99, (byte) -105, (byte) -78, (byte) -121, (byte) -112, (byte) 97, (byte) -66, (byte) -36, (byte) -4, (byte) -68, (byte) -107, (byte) -49, (byte) -51, (byte) 55, (byte) 63, (byte) 91, (byte) -47, (byte) 83, (byte) 57, (byte) -124, (byte) 60, (byte) 65, (byte) -94, (byte) 109, (byte) 71, (byte) 20, (byte) 42, (byte) -98, (byte) 93, (byte) 86, (byte) -14, (byte) -45, (byte) -85, (byte) 68, (byte) 17, (byte) -110, (byte) -39, (byte) 35, (byte) 32, (byte) 46, (byte) -119, (byte) -76, (byte) 124, (byte) -72, (byte) 38, (byte) 119, (byte) -103, (byte) -29, (byte) -91, (byte) 103, (byte) 74, (byte) -19, (byte) -34, (byte) -59, Framer.STDOUT_FRAME_PREFIX, (byte) -2, (byte) 24, (byte) 13, (byte) 99, (byte) -116, Byte.MIN_VALUE, (byte) -64, (byte) -9, (byte) 112, (byte) 7};
    /* renamed from: d */
    private static final byte[] f26750d = new byte[]{(byte) 0, (byte) 3, (byte) 5, (byte) 15, (byte) 17, (byte) 51, (byte) 85, (byte) -1, (byte) 26, (byte) 46, (byte) 114, (byte) -106, (byte) -95, (byte) -8, (byte) 19, (byte) 53, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -31, (byte) 56, (byte) 72, (byte) -40, (byte) 115, (byte) -107, (byte) -92, (byte) -9, (byte) 2, (byte) 6, (byte) 10, (byte) 30, (byte) 34, (byte) 102, (byte) -86, (byte) -27, (byte) 52, (byte) 92, (byte) -28, (byte) 55, (byte) 89, (byte) -21, (byte) 38, (byte) 106, (byte) -66, (byte) -39, (byte) 112, (byte) -112, (byte) -85, (byte) -26, Framer.STDOUT_FRAME_PREFIX, (byte) 83, (byte) -11, (byte) 4, (byte) 12, (byte) 20, (byte) 60, (byte) 68, (byte) -52, (byte) 79, (byte) -47, (byte) 104, (byte) -72, (byte) -45, (byte) 110, (byte) -78, (byte) -51, (byte) 76, (byte) -44, (byte) 103, (byte) -87, (byte) -32, (byte) 59, (byte) 77, (byte) -41, (byte) 98, (byte) -90, (byte) -15, (byte) 8, (byte) 24, (byte) 40, Framer.EXIT_FRAME_PREFIX, (byte) -120, (byte) -125, (byte) -98, (byte) -71, (byte) -48, (byte) 107, (byte) -67, (byte) -36, Byte.MAX_VALUE, (byte) -127, (byte) -104, (byte) -77, (byte) -50, (byte) 73, (byte) -37, (byte) 118, (byte) -102, (byte) -75, (byte) -60, (byte) 87, (byte) -7, (byte) 16, (byte) 48, (byte) 80, (byte) -16, (byte) 11, (byte) 29, (byte) 39, (byte) 105, (byte) -69, (byte) -42, (byte) 97, (byte) -93, (byte) -2, (byte) 25, (byte) 43, (byte) 125, (byte) -121, (byte) -110, (byte) -83, (byte) -20, (byte) 47, (byte) 113, (byte) -109, (byte) -82, (byte) -23, (byte) 32, (byte) 96, (byte) -96, (byte) -5, (byte) 22, (byte) 58, (byte) 78, (byte) -46, (byte) 109, (byte) -73, (byte) -62, (byte) 93, (byte) -25, Framer.STDERR_FRAME_PREFIX, (byte) 86, (byte) -6, (byte) 21, (byte) 63, (byte) 65, (byte) -61, (byte) 94, (byte) -30, (byte) 61, (byte) 71, (byte) -55, (byte) 64, (byte) -64, (byte) 91, (byte) -19, (byte) 44, (byte) 116, (byte) -100, (byte) -65, (byte) -38, (byte) 117, (byte) -97, (byte) -70, (byte) -43, (byte) 100, (byte) -84, (byte) -17, (byte) 42, (byte) 126, (byte) -126, (byte) -99, (byte) -68, (byte) -33, (byte) 122, (byte) -114, (byte) -119, Byte.MIN_VALUE, (byte) -101, (byte) -74, (byte) -63, (byte) 88, (byte) -24, (byte) 35, (byte) 101, (byte) -81, (byte) -22, (byte) 37, (byte) 111, (byte) -79, (byte) -56, (byte) 67, (byte) -59, (byte) 84, (byte) -4, (byte) 31, Framer.ENTER_FRAME_PREFIX, (byte) 99, (byte) -91, (byte) -12, (byte) 7, (byte) 9, (byte) 27, Framer.STDIN_FRAME_PREFIX, (byte) 119, (byte) -103, (byte) -80, (byte) -53, (byte) 70, (byte) -54, (byte) 69, (byte) -49, (byte) 74, (byte) -34, (byte) 121, (byte) -117, (byte) -122, (byte) -111, (byte) -88, (byte) -29, (byte) 62, (byte) 66, (byte) -58, (byte) 81, (byte) -13, (byte) 14, (byte) 18, (byte) 54, (byte) 90, (byte) -18, (byte) 41, (byte) 123, (byte) -115, (byte) -116, (byte) -113, (byte) -118, (byte) -123, (byte) -108, (byte) -89, (byte) -14, (byte) 13, (byte) 23, (byte) 57, (byte) 75, (byte) -35, (byte) 124, (byte) -124, (byte) -105, (byte) -94, (byte) -3, (byte) 28, (byte) 36, (byte) 108, (byte) -76, (byte) -57, (byte) 82, (byte) -10, (byte) 1, (byte) 3, (byte) 5, (byte) 15, (byte) 17, (byte) 51, (byte) 85, (byte) -1, (byte) 26, (byte) 46, (byte) 114, (byte) -106, (byte) -95, (byte) -8, (byte) 19, (byte) 53, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -31, (byte) 56, (byte) 72, (byte) -40, (byte) 115, (byte) -107, (byte) -92, (byte) -9, (byte) 2, (byte) 6, (byte) 10, (byte) 30, (byte) 34, (byte) 102, (byte) -86, (byte) -27, (byte) 52, (byte) 92, (byte) -28, (byte) 55, (byte) 89, (byte) -21, (byte) 38, (byte) 106, (byte) -66, (byte) -39, (byte) 112, (byte) -112, (byte) -85, (byte) -26, Framer.STDOUT_FRAME_PREFIX, (byte) 83, (byte) -11, (byte) 4, (byte) 12, (byte) 20, (byte) 60, (byte) 68, (byte) -52, (byte) 79, (byte) -47, (byte) 104, (byte) -72, (byte) -45, (byte) 110, (byte) -78, (byte) -51, (byte) 76, (byte) -44, (byte) 103, (byte) -87, (byte) -32, (byte) 59, (byte) 77, (byte) -41, (byte) 98, (byte) -90, (byte) -15, (byte) 8, (byte) 24, (byte) 40, Framer.EXIT_FRAME_PREFIX, (byte) -120, (byte) -125, (byte) -98, (byte) -71, (byte) -48, (byte) 107, (byte) -67, (byte) -36, Byte.MAX_VALUE, (byte) -127, (byte) -104, (byte) -77, (byte) -50, (byte) 73, (byte) -37, (byte) 118, (byte) -102, (byte) -75, (byte) -60, (byte) 87, (byte) -7, (byte) 16, (byte) 48, (byte) 80, (byte) -16, (byte) 11, (byte) 29, (byte) 39, (byte) 105, (byte) -69, (byte) -42, (byte) 97, (byte) -93, (byte) -2, (byte) 25, (byte) 43, (byte) 125, (byte) -121, (byte) -110, (byte) -83, (byte) -20, (byte) 47, (byte) 113, (byte) -109, (byte) -82, (byte) -23, (byte) 32, (byte) 96, (byte) -96, (byte) -5, (byte) 22, (byte) 58, (byte) 78, (byte) -46, (byte) 109, (byte) -73, (byte) -62, (byte) 93, (byte) -25, Framer.STDERR_FRAME_PREFIX, (byte) 86, (byte) -6, (byte) 21, (byte) 63, (byte) 65, (byte) -61, (byte) 94, (byte) -30, (byte) 61, (byte) 71, (byte) -55, (byte) 64, (byte) -64, (byte) 91, (byte) -19, (byte) 44, (byte) 116, (byte) -100, (byte) -65, (byte) -38, (byte) 117, (byte) -97, (byte) -70, (byte) -43, (byte) 100, (byte) -84, (byte) -17, (byte) 42, (byte) 126, (byte) -126, (byte) -99, (byte) -68, (byte) -33, (byte) 122, (byte) -114, (byte) -119, Byte.MIN_VALUE, (byte) -101, (byte) -74, (byte) -63, (byte) 88, (byte) -24, (byte) 35, (byte) 101, (byte) -81, (byte) -22, (byte) 37, (byte) 111, (byte) -79, (byte) -56, (byte) 67, (byte) -59, (byte) 84, (byte) -4, (byte) 31, Framer.ENTER_FRAME_PREFIX, (byte) 99, (byte) -91, (byte) -12, (byte) 7, (byte) 9, (byte) 27, Framer.STDIN_FRAME_PREFIX, (byte) 119, (byte) -103, (byte) -80, (byte) -53, (byte) 70, (byte) -54, (byte) 69, (byte) -49, (byte) 74, (byte) -34, (byte) 121, (byte) -117, (byte) -122, (byte) -111, (byte) -88, (byte) -29, (byte) 62, (byte) 66, (byte) -58, (byte) 81, (byte) -13, (byte) 14, (byte) 18, (byte) 54, (byte) 90, (byte) -18, (byte) 41, (byte) 123, (byte) -115, (byte) -116, (byte) -113, (byte) -118, (byte) -123, (byte) -108, (byte) -89, (byte) -14, (byte) 13, (byte) 23, (byte) 57, (byte) 75, (byte) -35, (byte) 124, (byte) -124, (byte) -105, (byte) -94, (byte) -3, (byte) 28, (byte) 36, (byte) 108, (byte) -76, (byte) -57, (byte) 82, (byte) -10, (byte) 1};
    /* renamed from: e */
    private static final byte[] f26751e = new byte[]{(byte) 99, (byte) 124, (byte) 119, (byte) 123, (byte) -14, (byte) 107, (byte) 111, (byte) -59, (byte) 48, (byte) 1, (byte) 103, (byte) 43, (byte) -2, (byte) -41, (byte) -85, (byte) 118, (byte) -54, (byte) -126, (byte) -55, (byte) 125, (byte) -6, (byte) 89, (byte) 71, (byte) -16, (byte) -83, (byte) -44, (byte) -94, (byte) -81, (byte) -100, (byte) -92, (byte) 114, (byte) -64, (byte) -73, (byte) -3, (byte) -109, (byte) 38, (byte) 54, (byte) 63, (byte) -9, (byte) -52, (byte) 52, (byte) -91, (byte) -27, (byte) -15, (byte) 113, (byte) -40, Framer.STDOUT_FRAME_PREFIX, (byte) 21, (byte) 4, (byte) -57, (byte) 35, (byte) -61, (byte) 24, (byte) -106, (byte) 5, (byte) -102, (byte) 7, (byte) 18, Byte.MIN_VALUE, (byte) -30, (byte) -21, (byte) 39, (byte) -78, (byte) 117, (byte) 9, (byte) -125, (byte) 44, (byte) 26, (byte) 27, (byte) 110, (byte) 90, (byte) -96, (byte) 82, (byte) 59, (byte) -42, (byte) -77, (byte) 41, (byte) -29, (byte) 47, (byte) -124, (byte) 83, (byte) -47, (byte) 0, (byte) -19, (byte) 32, (byte) -4, (byte) -79, (byte) 91, (byte) 106, (byte) -53, (byte) -66, (byte) 57, (byte) 74, (byte) 76, (byte) 88, (byte) -49, (byte) -48, (byte) -17, (byte) -86, (byte) -5, (byte) 67, (byte) 77, (byte) 51, (byte) -123, (byte) 69, (byte) -7, (byte) 2, Byte.MAX_VALUE, (byte) 80, (byte) 60, (byte) -97, (byte) -88, (byte) 81, (byte) -93, (byte) 64, (byte) -113, (byte) -110, (byte) -99, (byte) 56, (byte) -11, (byte) -68, (byte) -74, (byte) -38, Framer.ENTER_FRAME_PREFIX, (byte) 16, (byte) -1, (byte) -13, (byte) -46, (byte) -51, (byte) 12, (byte) 19, (byte) -20, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -105, (byte) 68, (byte) 23, (byte) -60, (byte) -89, (byte) 126, (byte) 61, (byte) 100, (byte) 93, (byte) 25, (byte) 115, (byte) 96, (byte) -127, (byte) 79, (byte) -36, (byte) 34, (byte) 42, (byte) -112, (byte) -120, (byte) 70, (byte) -18, (byte) -72, (byte) 20, (byte) -34, (byte) 94, (byte) 11, (byte) -37, (byte) -32, Framer.STDERR_FRAME_PREFIX, (byte) 58, (byte) 10, (byte) 73, (byte) 6, (byte) 36, (byte) 92, (byte) -62, (byte) -45, (byte) -84, (byte) 98, (byte) -111, (byte) -107, (byte) -28, (byte) 121, (byte) -25, (byte) -56, (byte) 55, (byte) 109, (byte) -115, (byte) -43, (byte) 78, (byte) -87, (byte) 108, (byte) 86, (byte) -12, (byte) -22, (byte) 101, (byte) 122, (byte) -82, (byte) 8, (byte) -70, Framer.EXIT_FRAME_PREFIX, (byte) 37, (byte) 46, (byte) 28, (byte) -90, (byte) -76, (byte) -58, (byte) -24, (byte) -35, (byte) 116, (byte) 31, (byte) 75, (byte) -67, (byte) -117, (byte) -118, (byte) 112, (byte) 62, (byte) -75, (byte) 102, (byte) 72, (byte) 3, (byte) -10, (byte) 14, (byte) 97, (byte) 53, (byte) 87, (byte) -71, (byte) -122, (byte) -63, (byte) 29, (byte) -98, (byte) -31, (byte) -8, (byte) -104, (byte) 17, (byte) 105, (byte) -39, (byte) -114, (byte) -108, (byte) -101, (byte) 30, (byte) -121, (byte) -23, (byte) -50, (byte) 85, (byte) 40, (byte) -33, (byte) -116, (byte) -95, (byte) -119, (byte) 13, (byte) -65, (byte) -26, (byte) 66, (byte) 104, (byte) 65, (byte) -103, Framer.STDIN_FRAME_PREFIX, (byte) 15, (byte) -80, (byte) 84, (byte) -69, (byte) 22};
    /* renamed from: f */
    private static final byte[] f26752f = new byte[]{(byte) 82, (byte) 9, (byte) 106, (byte) -43, (byte) 48, (byte) 54, (byte) -91, (byte) 56, (byte) -65, (byte) 64, (byte) -93, (byte) -98, (byte) -127, (byte) -13, (byte) -41, (byte) -5, (byte) 124, (byte) -29, (byte) 57, (byte) -126, (byte) -101, (byte) 47, (byte) -1, (byte) -121, (byte) 52, (byte) -114, (byte) 67, (byte) 68, (byte) -60, (byte) -34, (byte) -23, (byte) -53, (byte) 84, (byte) 123, (byte) -108, Framer.STDERR_FRAME_PREFIX, (byte) -90, (byte) -62, (byte) 35, (byte) 61, (byte) -18, (byte) 76, (byte) -107, (byte) 11, (byte) 66, (byte) -6, (byte) -61, (byte) 78, (byte) 8, (byte) 46, (byte) -95, (byte) 102, (byte) 40, (byte) -39, (byte) 36, (byte) -78, (byte) 118, (byte) 91, (byte) -94, (byte) 73, (byte) 109, (byte) -117, (byte) -47, (byte) 37, (byte) 114, (byte) -8, (byte) -10, (byte) 100, (byte) -122, (byte) 104, (byte) -104, (byte) 22, (byte) -44, (byte) -92, (byte) 92, (byte) -52, (byte) 93, (byte) 101, (byte) -74, (byte) -110, (byte) 108, (byte) 112, (byte) 72, (byte) 80, (byte) -3, (byte) -19, (byte) -71, (byte) -38, (byte) 94, (byte) 21, (byte) 70, (byte) 87, (byte) -89, (byte) -115, (byte) -99, (byte) -124, (byte) -112, (byte) -40, (byte) -85, (byte) 0, (byte) -116, (byte) -68, (byte) -45, (byte) 10, (byte) -9, (byte) -28, (byte) 88, (byte) 5, (byte) -72, (byte) -77, (byte) 69, (byte) 6, (byte) -48, (byte) 44, (byte) 30, (byte) -113, (byte) -54, (byte) 63, (byte) 15, (byte) 2, (byte) -63, (byte) -81, (byte) -67, (byte) 3, (byte) 1, (byte) 19, (byte) -118, (byte) 107, (byte) 58, (byte) -111, (byte) 17, (byte) 65, (byte) 79, (byte) 103, (byte) -36, (byte) -22, (byte) -105, (byte) -14, (byte) -49, (byte) -50, (byte) -16, (byte) -76, (byte) -26, (byte) 115, (byte) -106, (byte) -84, (byte) 116, (byte) 34, (byte) -25, (byte) -83, (byte) 53, (byte) -123, (byte) -30, (byte) -7, (byte) 55, (byte) -24, (byte) 28, (byte) 117, (byte) -33, (byte) 110, (byte) 71, (byte) -15, (byte) 26, (byte) 113, (byte) 29, (byte) 41, (byte) -59, (byte) -119, (byte) 111, (byte) -73, (byte) 98, (byte) 14, (byte) -86, (byte) 24, (byte) -66, (byte) 27, (byte) -4, (byte) 86, (byte) 62, (byte) 75, (byte) -58, (byte) -46, (byte) 121, (byte) 32, (byte) -102, (byte) -37, (byte) -64, (byte) -2, Framer.EXIT_FRAME_PREFIX, (byte) -51, (byte) 90, (byte) -12, (byte) 31, (byte) -35, (byte) -88, (byte) 51, (byte) -120, (byte) 7, (byte) -57, Framer.STDOUT_FRAME_PREFIX, (byte) -79, (byte) 18, (byte) 16, (byte) 89, (byte) 39, Byte.MIN_VALUE, (byte) -20, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) 96, (byte) 81, Byte.MAX_VALUE, (byte) -87, (byte) 25, (byte) -75, (byte) 74, (byte) 13, Framer.STDIN_FRAME_PREFIX, (byte) -27, (byte) 122, (byte) -97, (byte) -109, (byte) -55, (byte) -100, (byte) -17, (byte) -96, (byte) -32, (byte) 59, (byte) 77, (byte) -82, (byte) 42, (byte) -11, (byte) -80, (byte) -56, (byte) -21, (byte) -69, (byte) 60, (byte) -125, (byte) 83, (byte) -103, (byte) 97, (byte) 23, (byte) 43, (byte) 4, (byte) 126, (byte) -70, (byte) 119, (byte) -42, (byte) 38, (byte) -31, (byte) 105, (byte) 20, (byte) 99, (byte) 85, Framer.ENTER_FRAME_PREFIX, (byte) 12, (byte) 125};
    /* renamed from: g */
    private static final int[] f26753g = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, JfifUtil.MARKER_SOI, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    /* renamed from: h */
    private int f26754h;
    /* renamed from: i */
    private long f26755i;
    /* renamed from: j */
    private int f26756j;
    /* renamed from: k */
    private int f26757k;
    /* renamed from: l */
    private long[][] f26758l;
    /* renamed from: m */
    private long f26759m;
    /* renamed from: n */
    private long f26760n;
    /* renamed from: o */
    private long f26761o;
    /* renamed from: p */
    private long f26762p;
    /* renamed from: q */
    private boolean f26763q;
    /* renamed from: r */
    private byte[] f26764r;
    /* renamed from: s */
    private byte[] f26765s;

    /* renamed from: a */
    public String mo5741a() {
        return "Rijndael";
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    private byte m35139a(int i) {
        return i != 0 ? f26750d[(f26749c[i] & JfifUtil.MARKER_FIRST_BYTE) + 25] : (byte) 0;
    }

    /* renamed from: b */
    private byte m35146b(int i) {
        return i != 0 ? f26750d[(f26749c[i] & JfifUtil.MARKER_FIRST_BYTE) + 1] : (byte) 0;
    }

    /* renamed from: c */
    private byte m35150c(int i) {
        return i >= 0 ? f26750d[i + 199] : (byte) 0;
    }

    /* renamed from: d */
    private byte m35152d(int i) {
        return i >= 0 ? f26750d[i + 104] : (byte) 0;
    }

    /* renamed from: e */
    private byte m35154e(int i) {
        return i >= 0 ? f26750d[i + 238] : (byte) 0;
    }

    /* renamed from: f */
    private byte m35156f(int i) {
        return i >= 0 ? f26750d[i + 223] : (byte) 0;
    }

    /* renamed from: a */
    private void m35144a(long[] jArr) {
        this.f26759m ^= jArr[0];
        this.f26760n ^= jArr[1];
        this.f26761o ^= jArr[2];
        this.f26762p ^= jArr[3];
    }

    /* renamed from: a */
    private long m35140a(long j, int i) {
        return ((j << (this.f26754h - i)) | (j >>> i)) & this.f26755i;
    }

    /* renamed from: a */
    private void m35142a(byte[] bArr) {
        this.f26760n = m35140a(this.f26760n, bArr[1]);
        this.f26761o = m35140a(this.f26761o, bArr[2]);
        this.f26762p = m35140a(this.f26762p, bArr[3]);
    }

    /* renamed from: a */
    private long m35141a(long j, byte[] bArr) {
        long j2 = 0;
        for (int i = 0; i < this.f26754h; i += 8) {
            j2 |= ((long) (bArr[(int) ((j >> i) & 255)] & JfifUtil.MARKER_FIRST_BYTE)) << i;
        }
        return j2;
    }

    /* renamed from: b */
    private void m35147b(byte[] bArr) {
        this.f26759m = m35141a(this.f26759m, bArr);
        this.f26760n = m35141a(this.f26760n, bArr);
        this.f26761o = m35141a(this.f26761o, bArr);
        this.f26762p = m35141a(this.f26762p, bArr);
    }

    /* renamed from: d */
    private void m35153d() {
        long j;
        long j2 = 0;
        long j3 = 0;
        long j4 = j3;
        long j5 = j4;
        for (int i = 0; i < this.f26754h; i += 8) {
            int i2 = (int) ((r0.f26759m >> i) & 255);
            int i3 = (int) ((r0.f26760n >> i) & 255);
            int i4 = (int) ((r0.f26761o >> i) & 255);
            j = j5;
            int i5 = (int) ((r0.f26762p >> i) & 255);
            j2 |= ((long) ((((m35139a(i2) ^ m35146b(i3)) ^ i4) ^ i5) & JfifUtil.MARKER_FIRST_BYTE)) << i;
            j3 |= ((long) ((((m35139a(i3) ^ m35146b(i4)) ^ i5) ^ i2) & JfifUtil.MARKER_FIRST_BYTE)) << i;
            j4 |= ((long) ((((m35139a(i4) ^ m35146b(i5)) ^ i2) ^ i3) & JfifUtil.MARKER_FIRST_BYTE)) << i;
            j5 = j | (((long) ((((m35139a(i5) ^ m35146b(i2)) ^ i3) ^ i4) & JfifUtil.MARKER_FIRST_BYTE)) << i);
        }
        j = j5;
        r0.f26759m = j2;
        r0.f26760n = j3;
        r0.f26761o = j4;
        r0.f26762p = j;
    }

    /* renamed from: e */
    private void m35155e() {
        long j;
        RijndaelEngine rijndaelEngine = this;
        long j2 = 0;
        long j3 = 0;
        long j4 = j3;
        long j5 = j4;
        for (int i = 0; i < rijndaelEngine.f26754h; i += 8) {
            int i2 = (int) ((rijndaelEngine.f26759m >> i) & 255);
            int i3 = (int) ((rijndaelEngine.f26760n >> i) & 255);
            int i4 = (int) ((rijndaelEngine.f26761o >> i) & 255);
            j = j5;
            int i5 = (int) ((rijndaelEngine.f26762p >> i) & 255);
            int i6 = -1;
            i2 = i2 != 0 ? f26749c[i2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE : -1;
            i3 = i3 != 0 ? f26749c[i3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE : -1;
            int i7 = i4 != 0 ? f26749c[i4 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE : -1;
            if (i5 != 0) {
                i6 = f26749c[i5 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE;
            }
            j2 |= ((long) ((((m35156f(i2) ^ m35152d(i3)) ^ m35154e(i7)) ^ m35150c(i6)) & JfifUtil.MARKER_FIRST_BYTE)) << i;
            j3 |= ((long) ((((m35156f(i3) ^ m35152d(i7)) ^ m35154e(i6)) ^ m35150c(i2)) & JfifUtil.MARKER_FIRST_BYTE)) << i;
            j4 |= ((long) ((((m35156f(i7) ^ m35152d(i6)) ^ m35154e(i2)) ^ m35150c(i3)) & JfifUtil.MARKER_FIRST_BYTE)) << i;
            j5 = j | (((long) ((((m35156f(i6) ^ m35152d(i2)) ^ m35154e(i3)) ^ m35150c(i7)) & JfifUtil.MARKER_FIRST_BYTE)) << i);
        }
        j = j5;
        rijndaelEngine.f26759m = j2;
        rijndaelEngine.f26760n = j3;
        rijndaelEngine.f26761o = j4;
        rijndaelEngine.f26762p = j;
    }

    /* renamed from: c */
    private long[][] m35151c(byte[] bArr) {
        int i;
        RijndaelEngine rijndaelEngine = this;
        byte[] bArr2 = bArr;
        int i2 = 8;
        int length = bArr2.length * 8;
        int i3 = 4;
        byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, new int[]{4, 64});
        long[][] jArr = (long[][]) Array.newInstance(long.class, new int[]{15, 4});
        if (length == 128) {
            i = 4;
        } else if (length == 160) {
            i = 5;
        } else if (length == JfifUtil.MARKER_SOFn) {
            i = 6;
        } else if (length == 224) {
            i = 7;
        } else if (length == 256) {
            i = 8;
        } else {
            throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
        }
        if (length >= rijndaelEngine.f26757k) {
            rijndaelEngine.f26756j = i + 6;
        } else {
            rijndaelEngine.f26756j = (rijndaelEngine.f26754h / 8) + 6;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr2.length) {
            int i6 = i5 + 1;
            bArr3[i4 % 4][i4 / 4] = bArr2[i5];
            i4++;
            i5 = i6;
        }
        int i7 = 0;
        i4 = 0;
        while (true) {
            i5 = 1;
            if (i7 >= i || i4 >= (rijndaelEngine.f26756j + 1) * (rijndaelEngine.f26754h / 8)) {
                i7 = 0;
            } else {
                for (i5 = 0; i5 < 4; i5++) {
                    long[] jArr2 = jArr[i4 / (rijndaelEngine.f26754h / 8)];
                    jArr2[i5] = (((long) (bArr3[i5][i7] & JfifUtil.MARKER_FIRST_BYTE)) << ((i4 * 8) % rijndaelEngine.f26754h)) | jArr2[i5];
                }
                i7++;
                i4++;
            }
        }
        i7 = 0;
        while (i4 < (rijndaelEngine.f26756j + i5) * (rijndaelEngine.f26754h / i2)) {
            int i8;
            length = 0;
            while (length < i3) {
                byte[] bArr4 = bArr3[length];
                length++;
                bArr4[0] = (byte) (f26751e[bArr3[length % 4][i - 1] & JfifUtil.MARKER_FIRST_BYTE] ^ bArr4[0]);
            }
            byte[] bArr5 = bArr3[0];
            int i9 = i7 + 1;
            bArr5[0] = (byte) (f26753g[i7] ^ bArr5[0]);
            byte[] bArr6;
            if (i <= 6) {
                for (length = 1; length < i; length++) {
                    for (i8 = 0; i8 < i3; i8++) {
                        bArr6 = bArr3[i8];
                        bArr6[length] = (byte) (bArr6[length] ^ bArr3[i8][length - 1]);
                    }
                }
            } else {
                for (length = 1; length < i3; length++) {
                    for (i8 = 0; i8 < i3; i8++) {
                        bArr6 = bArr3[i8];
                        bArr6[length] = (byte) (bArr6[length] ^ bArr3[i8][length - 1]);
                    }
                }
                for (length = 0; length < i3; length++) {
                    bArr4 = bArr3[length];
                    bArr4[i3] = (byte) (bArr4[i3] ^ f26751e[bArr3[length][3] & JfifUtil.MARKER_FIRST_BYTE]);
                }
                for (length = 5; length < i; length++) {
                    for (i8 = 0; i8 < i3; i8++) {
                        bArr6 = bArr3[i8];
                        bArr6[length] = (byte) (bArr6[length] ^ bArr3[i8][length - 1]);
                    }
                }
            }
            length = 0;
            while (length < i && i4 < (rijndaelEngine.f26756j + r11) * (rijndaelEngine.f26754h / r3)) {
                i8 = 0;
                for (i3 = 
/*
Method generation error in method: org.spongycastle.crypto.engines.RijndaelEngine.c(byte[]):long[][], dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r4_2 'i3' int) = (r4_1 'i3' int), (r4_5 'i3' int) binds: {(r4_5 'i3' int)=B:70:0x017a, (r4_1 'i3' int)=B:63:0x0149} in method: org.spongycastle.crypto.engines.RijndaelEngine.c(byte[]):long[][], dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 26 more

*/

                public RijndaelEngine() {
                    this(128);
                }

                public RijndaelEngine(int i) {
                    if (i == 128) {
                        this.f26754h = 32;
                        this.f26755i = 4294967295L;
                        this.f26764r = f26747a[0];
                        this.f26765s = f26748b[0];
                    } else if (i == 160) {
                        this.f26754h = 40;
                        this.f26755i = 1099511627775L;
                        this.f26764r = f26747a[1];
                        this.f26765s = f26748b[1];
                    } else if (i == JfifUtil.MARKER_SOFn) {
                        this.f26754h = 48;
                        this.f26755i = 281474976710655L;
                        this.f26764r = f26747a[2];
                        this.f26765s = f26748b[2];
                    } else if (i == 224) {
                        this.f26754h = 56;
                        this.f26755i = 72057594037927935L;
                        this.f26764r = f26747a[3];
                        this.f26765s = f26748b[3];
                    } else if (i == 256) {
                        this.f26754h = 64;
                        this.f26755i = -1;
                        this.f26764r = f26747a[4];
                        this.f26765s = f26748b[4];
                    } else {
                        throw new IllegalArgumentException("unknown blocksize to Rijndael");
                    }
                    this.f26757k = i;
                }

                /* renamed from: a */
                public void mo5742a(boolean z, CipherParameters cipherParameters) {
                    if (cipherParameters instanceof KeyParameter) {
                        this.f26758l = m35151c(((KeyParameter) cipherParameters).m35685a());
                        this.f26763q = z;
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid parameter passed to Rijndael init - ");
                    stringBuilder.append(cipherParameters.getClass().getName());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }

                /* renamed from: b */
                public int mo5743b() {
                    return this.f26754h / 2;
                }

                /* renamed from: a */
                public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
                    if (this.f26758l == null) {
                        throw new IllegalStateException("Rijndael engine not initialised");
                    } else if ((this.f26754h / 2) + i > bArr.length) {
                        throw new DataLengthException("input buffer too short");
                    } else if ((this.f26754h / 2) + i2 <= bArr2.length) {
                        if (this.f26763q) {
                            m35143a(bArr, i);
                            m35145a(this.f26758l);
                            m35148b(bArr2, i2);
                        } else {
                            m35143a(bArr, i);
                            m35149b(this.f26758l);
                            m35148b(bArr2, i2);
                        }
                        return this.f26754h / 2;
                    } else {
                        throw new OutputLengthException("output buffer too short");
                    }
                }

                /* renamed from: a */
                private void m35143a(byte[] bArr, int i) {
                    int i2 = i + 1;
                    this.f26759m = (long) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
                    i = i2 + 1;
                    this.f26760n = (long) (bArr[i2] & JfifUtil.MARKER_FIRST_BYTE);
                    i2 = i + 1;
                    this.f26761o = (long) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
                    i = i2 + 1;
                    this.f26762p = (long) (bArr[i2] & JfifUtil.MARKER_FIRST_BYTE);
                    for (i2 = 8; i2 != this.f26754h; i2 += 8) {
                        int i3 = i + 1;
                        this.f26759m |= ((long) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE)) << i2;
                        i = i3 + 1;
                        this.f26760n |= ((long) (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE)) << i2;
                        i3 = i + 1;
                        this.f26761o |= ((long) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE)) << i2;
                        i = i3 + 1;
                        this.f26762p |= ((long) (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE)) << i2;
                    }
                }

                /* renamed from: b */
                private void m35148b(byte[] bArr, int i) {
                    for (int i2 = 0; i2 != this.f26754h; i2 += 8) {
                        int i3 = i + 1;
                        bArr[i] = (byte) ((int) (this.f26759m >> i2));
                        i = i3 + 1;
                        bArr[i3] = (byte) ((int) (this.f26760n >> i2));
                        i3 = i + 1;
                        bArr[i] = (byte) ((int) (this.f26761o >> i2));
                        i = i3 + 1;
                        bArr[i3] = (byte) ((int) (this.f26762p >> i2));
                    }
                }

                /* renamed from: a */
                private void m35145a(long[][] jArr) {
                    m35144a(jArr[0]);
                    for (int i = 1; i < this.f26756j; i++) {
                        m35147b(f26751e);
                        m35142a(this.f26764r);
                        m35153d();
                        m35144a(jArr[i]);
                    }
                    m35147b(f26751e);
                    m35142a(this.f26764r);
                    m35144a(jArr[this.f26756j]);
                }

                /* renamed from: b */
                private void m35149b(long[][] jArr) {
                    m35144a(jArr[this.f26756j]);
                    m35147b(f26752f);
                    m35142a(this.f26765s);
                    for (int i = this.f26756j - 1; i > 0; i--) {
                        m35144a(jArr[i]);
                        m35155e();
                        m35147b(f26752f);
                        m35142a(this.f26765s);
                    }
                    m35144a(jArr[0]);
                }
            }
