package com.facebook.imageutils;

import android.util.Pair;
import java.io.IOException;
import java.io.InputStream;

public class WebpUtil {
    private static final String VP8L_HEADER = "VP8L";
    private static final String VP8X_HEADER = "VP8X";
    private static final String VP8_HEADER = "VP8 ";

    private WebpUtil() {
    }

    public static Pair<Integer, Integer> getSize(InputStream inputStream) {
        byte[] bArr = new byte[4];
        try {
            inputStream.read(bArr);
            if (compare(bArr, "RIFF")) {
                getInt(inputStream);
                inputStream.read(bArr);
                if (compare(bArr, "WEBP")) {
                    inputStream.read(bArr);
                    String header = getHeader(bArr);
                    Pair<Integer, Integer> vP8Dimension;
                    if (VP8_HEADER.equals(header)) {
                        vP8Dimension = getVP8Dimension(inputStream);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (InputStream inputStream2) {
                                inputStream2.printStackTrace();
                            }
                        }
                        return vP8Dimension;
                    } else if (VP8L_HEADER.equals(header)) {
                        vP8Dimension = getVP8LDimension(inputStream2);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (InputStream inputStream22) {
                                inputStream22.printStackTrace();
                            }
                        }
                        return vP8Dimension;
                    } else if (VP8X_HEADER.equals(header)) {
                        vP8Dimension = getVP8XDimension(inputStream22);
                        if (inputStream22 != null) {
                            try {
                                inputStream22.close();
                            } catch (InputStream inputStream222) {
                                inputStream222.printStackTrace();
                            }
                        }
                        return vP8Dimension;
                    } else {
                        if (inputStream222 != null) {
                            try {
                                inputStream222.close();
                            } catch (InputStream inputStream2222) {
                                inputStream2222.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                if (inputStream2222 != null) {
                    try {
                        inputStream2222.close();
                    } catch (InputStream inputStream22222) {
                        inputStream22222.printStackTrace();
                    }
                }
                return null;
            }
            if (inputStream22222 != null) {
                try {
                    inputStream22222.close();
                } catch (InputStream inputStream222222) {
                    inputStream222222.printStackTrace();
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            if (inputStream222222 != null) {
                inputStream222222.close();
            }
        } catch (Throwable th) {
            if (inputStream222222 != null) {
                try {
                    inputStream222222.close();
                } catch (InputStream inputStream2222222) {
                    inputStream2222222.printStackTrace();
                }
            }
        }
    }

    private static Pair<Integer, Integer> getVP8Dimension(InputStream inputStream) {
        inputStream.skip(7);
        short s = getShort(inputStream);
        short s2 = getShort(inputStream);
        short s3 = getShort(inputStream);
        if (s == (short) 157 && s2 == (short) 1) {
            if (s3 == (short) 42) {
                return new Pair(Integer.valueOf(get2BytesAsInt(inputStream)), Integer.valueOf(get2BytesAsInt(inputStream)));
            }
        }
        return null;
    }

    private static Pair<Integer, Integer> getVP8LDimension(InputStream inputStream) {
        getInt(inputStream);
        if (getByte(inputStream) != (byte) 47) {
            return null;
        }
        int read = ((byte) inputStream.read()) & JfifUtil.MARKER_FIRST_BYTE;
        return new Pair(Integer.valueOf(((((byte) inputStream.read()) & JfifUtil.MARKER_FIRST_BYTE) | ((read & 63) << 8)) + 1), Integer.valueOf((((((((byte) inputStream.read()) & JfifUtil.MARKER_FIRST_BYTE) & 15) << 10) | ((((byte) inputStream.read()) & JfifUtil.MARKER_FIRST_BYTE) << 2)) | ((read & JfifUtil.MARKER_SOFn) >> 6)) + 1));
    }

    private static Pair<Integer, Integer> getVP8XDimension(InputStream inputStream) {
        inputStream.skip(8);
        return new Pair(Integer.valueOf(read3Bytes(inputStream) + 1), Integer.valueOf(read3Bytes(inputStream) + 1));
    }

    private static boolean compare(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (str.charAt(i) != bArr[i]) {
                return false;
            }
        }
        return 1;
    }

    private static String getHeader(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append((char) b);
        }
        return stringBuilder.toString();
    }

    private static int getInt(InputStream inputStream) {
        return ((((((byte) inputStream.read()) << 24) & -16777216) | ((((byte) inputStream.read()) << 16) & 16711680)) | ((((byte) inputStream.read()) << 8) & 65280)) | (((byte) inputStream.read()) & JfifUtil.MARKER_FIRST_BYTE);
    }

    public static int get2BytesAsInt(InputStream inputStream) {
        return ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & JfifUtil.MARKER_FIRST_BYTE);
    }

    private static int read3Bytes(InputStream inputStream) {
        byte b = getByte(inputStream);
        return (((getByte(inputStream) << 16) & 16711680) | ((getByte(inputStream) << 8) & 65280)) | (b & JfifUtil.MARKER_FIRST_BYTE);
    }

    private static short getShort(InputStream inputStream) {
        return (short) (inputStream.read() & JfifUtil.MARKER_FIRST_BYTE);
    }

    private static byte getByte(InputStream inputStream) {
        return (byte) (inputStream.read() & JfifUtil.MARKER_FIRST_BYTE);
    }

    private static boolean isBitOne(byte b, int i) {
        return ((b >> (i % 8)) & (byte) 1) == (byte) 1;
    }
}
