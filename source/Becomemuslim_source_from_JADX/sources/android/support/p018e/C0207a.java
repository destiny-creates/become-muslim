package android.support.p018e;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Log;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: ExifInterface */
/* renamed from: android.support.e.a */
public class C0207a {
    /* renamed from: A */
    private static final C0205c f476A = new C0205c("JPEGInterchangeFormatLength", 514, 4);
    /* renamed from: B */
    private static final HashMap<Integer, C0205c>[] f477B = new HashMap[f490g.length];
    /* renamed from: C */
    private static final HashMap<String, C0205c>[] f478C = new HashMap[f490g.length];
    /* renamed from: D */
    private static final HashSet<String> f479D = new HashSet(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    /* renamed from: E */
    private static final HashMap<Integer, Integer> f480E = new HashMap();
    /* renamed from: F */
    private static final Charset f481F = Charset.forName("US-ASCII");
    /* renamed from: W */
    private static final Pattern f482W = Pattern.compile(".*[1-9].*");
    /* renamed from: X */
    private static final Pattern f483X = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    /* renamed from: a */
    public static final int[] f484a = new int[]{8, 8, 8};
    /* renamed from: b */
    public static final int[] f485b = new int[]{4};
    /* renamed from: c */
    public static final int[] f486c = new int[]{8};
    /* renamed from: d */
    static final byte[] f487d = new byte[]{(byte) -1, (byte) -40, (byte) -1};
    /* renamed from: e */
    static final String[] f488e = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    /* renamed from: f */
    static final int[] f489f = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    /* renamed from: g */
    static final C0205c[][] f490g = new C0205c[][]{f498o, f499p, f500q, f501r, f502s, f498o, f504u, f505v, f506w, f507x};
    /* renamed from: h */
    static final byte[] f491h = "Exif\u0000\u0000".getBytes(f481F);
    /* renamed from: i */
    private static final List<Integer> f492i = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8)});
    /* renamed from: j */
    private static final List<Integer> f493j = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5)});
    /* renamed from: k */
    private static final byte[] f494k = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 0};
    /* renamed from: l */
    private static final byte[] f495l = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 85, (byte) 83, (byte) 0, (byte) 73, (byte) 73};
    /* renamed from: m */
    private static SimpleDateFormat f496m = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    /* renamed from: n */
    private static final byte[] f497n = new byte[]{(byte) 65, (byte) 83, (byte) 67, (byte) 73, (byte) 73, (byte) 0, (byte) 0, (byte) 0};
    /* renamed from: o */
    private static final C0205c[] f498o = new C0205c[]{new C0205c("NewSubfileType", 254, 4), new C0205c("SubfileType", (int) JfifUtil.MARKER_FIRST_BYTE, 4), new C0205c("ImageWidth", 256, 3, 4), new C0205c("ImageLength", 257, 3, 4), new C0205c("BitsPerSample", 258, 3), new C0205c("Compression", 259, 3), new C0205c("PhotometricInterpretation", 262, 3), new C0205c("ImageDescription", (int) RotationOptions.ROTATE_270, 2), new C0205c("Make", 271, 2), new C0205c("Model", 272, 2), new C0205c("StripOffsets", 273, 3, 4), new C0205c("Orientation", (int) TiffUtil.TIFF_TAG_ORIENTATION, 3), new C0205c("SamplesPerPixel", 277, 3), new C0205c("RowsPerStrip", 278, 3, 4), new C0205c("StripByteCounts", ModuleDescriptor.MODULE_VERSION, 3, 4), new C0205c("XResolution", 282, 5), new C0205c("YResolution", 283, 5), new C0205c("PlanarConfiguration", 284, 3), new C0205c("ResolutionUnit", 296, 3), new C0205c("TransferFunction", 301, 3), new C0205c("Software", 305, 2), new C0205c("DateTime", 306, 2), new C0205c("Artist", 315, 2), new C0205c("WhitePoint", 318, 5), new C0205c("PrimaryChromaticities", 319, 5), new C0205c("SubIFDPointer", 330, 4), new C0205c("JPEGInterchangeFormat", 513, 4), new C0205c("JPEGInterchangeFormatLength", 514, 4), new C0205c("YCbCrCoefficients", 529, 5), new C0205c("YCbCrSubSampling", 530, 3), new C0205c("YCbCrPositioning", 531, 3), new C0205c("ReferenceBlackWhite", 532, 5), new C0205c("Copyright", 33432, 2), new C0205c("ExifIFDPointer", 34665, 4), new C0205c("GPSInfoIFDPointer", 34853, 4), new C0205c("SensorTopBorder", 4, 4), new C0205c("SensorLeftBorder", 5, 4), new C0205c("SensorBottomBorder", 6, 4), new C0205c("SensorRightBorder", 7, 4), new C0205c("ISO", 23, 3), new C0205c("JpgFromRaw", 46, 7)};
    /* renamed from: p */
    private static final C0205c[] f499p = new C0205c[]{new C0205c("ExposureTime", 33434, 5), new C0205c("FNumber", 33437, 5), new C0205c("ExposureProgram", 34850, 3), new C0205c("SpectralSensitivity", 34852, 2), new C0205c("PhotographicSensitivity", 34855, 3), new C0205c("OECF", 34856, 7), new C0205c("ExifVersion", 36864, 2), new C0205c("DateTimeOriginal", 36867, 2), new C0205c("DateTimeDigitized", 36868, 2), new C0205c("ComponentsConfiguration", 37121, 7), new C0205c("CompressedBitsPerPixel", 37122, 5), new C0205c("ShutterSpeedValue", 37377, 10), new C0205c("ApertureValue", 37378, 5), new C0205c("BrightnessValue", 37379, 10), new C0205c("ExposureBiasValue", 37380, 10), new C0205c("MaxApertureValue", 37381, 5), new C0205c("SubjectDistance", 37382, 5), new C0205c("MeteringMode", 37383, 3), new C0205c("LightSource", 37384, 3), new C0205c("Flash", 37385, 3), new C0205c("FocalLength", 37386, 5), new C0205c("SubjectArea", 37396, 3), new C0205c("MakerNote", 37500, 7), new C0205c("UserComment", 37510, 7), new C0205c("SubSecTime", 37520, 2), new C0205c("SubSecTimeOriginal", 37521, 2), new C0205c("SubSecTimeDigitized", 37522, 2), new C0205c("FlashpixVersion", 40960, 7), new C0205c("ColorSpace", 40961, 3), new C0205c("PixelXDimension", 40962, 3, 4), new C0205c("PixelYDimension", 40963, 3, 4), new C0205c("RelatedSoundFile", 40964, 2), new C0205c("InteroperabilityIFDPointer", 40965, 4), new C0205c("FlashEnergy", 41483, 5), new C0205c("SpatialFrequencyResponse", 41484, 7), new C0205c("FocalPlaneXResolution", 41486, 5), new C0205c("FocalPlaneYResolution", 41487, 5), new C0205c("FocalPlaneResolutionUnit", 41488, 3), new C0205c("SubjectLocation", 41492, 3), new C0205c("ExposureIndex", 41493, 5), new C0205c("SensingMethod", 41495, 3), new C0205c("FileSource", 41728, 7), new C0205c("SceneType", 41729, 7), new C0205c("CFAPattern", 41730, 7), new C0205c("CustomRendered", 41985, 3), new C0205c("ExposureMode", 41986, 3), new C0205c("WhiteBalance", 41987, 3), new C0205c("DigitalZoomRatio", 41988, 5), new C0205c("FocalLengthIn35mmFilm", 41989, 3), new C0205c("SceneCaptureType", 41990, 3), new C0205c("GainControl", 41991, 3), new C0205c("Contrast", 41992, 3), new C0205c("Saturation", 41993, 3), new C0205c("Sharpness", 41994, 3), new C0205c("DeviceSettingDescription", 41995, 7), new C0205c("SubjectDistanceRange", 41996, 3), new C0205c("ImageUniqueID", 42016, 2), new C0205c("DNGVersion", 50706, 1), new C0205c("DefaultCropSize", 50720, 3, 4)};
    /* renamed from: q */
    private static final C0205c[] f500q = new C0205c[]{new C0205c("GPSVersionID", 0, 1), new C0205c("GPSLatitudeRef", 1, 2), new C0205c("GPSLatitude", 2, 5), new C0205c("GPSLongitudeRef", 3, 2), new C0205c("GPSLongitude", 4, 5), new C0205c("GPSAltitudeRef", 5, 1), new C0205c("GPSAltitude", 6, 5), new C0205c("GPSTimeStamp", 7, 5), new C0205c("GPSSatellites", 8, 2), new C0205c("GPSStatus", 9, 2), new C0205c("GPSMeasureMode", 10, 2), new C0205c("GPSDOP", 11, 5), new C0205c("GPSSpeedRef", 12, 2), new C0205c("GPSSpeed", 13, 5), new C0205c("GPSTrackRef", 14, 2), new C0205c("GPSTrack", 15, 5), new C0205c("GPSImgDirectionRef", 16, 2), new C0205c("GPSImgDirection", 17, 5), new C0205c("GPSMapDatum", 18, 2), new C0205c("GPSDestLatitudeRef", 19, 2), new C0205c("GPSDestLatitude", 20, 5), new C0205c("GPSDestLongitudeRef", 21, 2), new C0205c("GPSDestLongitude", 22, 5), new C0205c("GPSDestBearingRef", 23, 2), new C0205c("GPSDestBearing", 24, 5), new C0205c("GPSDestDistanceRef", 25, 2), new C0205c("GPSDestDistance", 26, 5), new C0205c("GPSProcessingMethod", 27, 7), new C0205c("GPSAreaInformation", 28, 7), new C0205c("GPSDateStamp", 29, 2), new C0205c("GPSDifferential", 30, 3)};
    /* renamed from: r */
    private static final C0205c[] f501r = new C0205c[]{new C0205c("InteroperabilityIndex", 1, 2)};
    /* renamed from: s */
    private static final C0205c[] f502s = new C0205c[]{new C0205c("NewSubfileType", 254, 4), new C0205c("SubfileType", (int) JfifUtil.MARKER_FIRST_BYTE, 4), new C0205c("ThumbnailImageWidth", 256, 3, 4), new C0205c("ThumbnailImageLength", 257, 3, 4), new C0205c("BitsPerSample", 258, 3), new C0205c("Compression", 259, 3), new C0205c("PhotometricInterpretation", 262, 3), new C0205c("ImageDescription", (int) RotationOptions.ROTATE_270, 2), new C0205c("Make", 271, 2), new C0205c("Model", 272, 2), new C0205c("StripOffsets", 273, 3, 4), new C0205c("Orientation", (int) TiffUtil.TIFF_TAG_ORIENTATION, 3), new C0205c("SamplesPerPixel", 277, 3), new C0205c("RowsPerStrip", 278, 3, 4), new C0205c("StripByteCounts", ModuleDescriptor.MODULE_VERSION, 3, 4), new C0205c("XResolution", 282, 5), new C0205c("YResolution", 283, 5), new C0205c("PlanarConfiguration", 284, 3), new C0205c("ResolutionUnit", 296, 3), new C0205c("TransferFunction", 301, 3), new C0205c("Software", 305, 2), new C0205c("DateTime", 306, 2), new C0205c("Artist", 315, 2), new C0205c("WhitePoint", 318, 5), new C0205c("PrimaryChromaticities", 319, 5), new C0205c("SubIFDPointer", 330, 4), new C0205c("JPEGInterchangeFormat", 513, 4), new C0205c("JPEGInterchangeFormatLength", 514, 4), new C0205c("YCbCrCoefficients", 529, 5), new C0205c("YCbCrSubSampling", 530, 3), new C0205c("YCbCrPositioning", 531, 3), new C0205c("ReferenceBlackWhite", 532, 5), new C0205c("Copyright", 33432, 2), new C0205c("ExifIFDPointer", 34665, 4), new C0205c("GPSInfoIFDPointer", 34853, 4), new C0205c("DNGVersion", 50706, 1), new C0205c("DefaultCropSize", 50720, 3, 4)};
    /* renamed from: t */
    private static final C0205c f503t = new C0205c("StripOffsets", 273, 3);
    /* renamed from: u */
    private static final C0205c[] f504u = new C0205c[]{new C0205c("ThumbnailImage", 256, 7), new C0205c("CameraSettingsIFDPointer", 8224, 4), new C0205c("ImageProcessingIFDPointer", 8256, 4)};
    /* renamed from: v */
    private static final C0205c[] f505v = new C0205c[]{new C0205c("PreviewImageStart", 257, 4), new C0205c("PreviewImageLength", 258, 4)};
    /* renamed from: w */
    private static final C0205c[] f506w = new C0205c[]{new C0205c("AspectFrame", 4371, 3)};
    /* renamed from: x */
    private static final C0205c[] f507x = new C0205c[]{new C0205c("ColorSpace", 55, 3)};
    /* renamed from: y */
    private static final C0205c[] f508y = new C0205c[]{new C0205c("SubIFDPointer", 330, 4), new C0205c("ExifIFDPointer", 34665, 4), new C0205c("GPSInfoIFDPointer", 34853, 4), new C0205c("InteroperabilityIFDPointer", 40965, 4), new C0205c("CameraSettingsIFDPointer", 8224, 1), new C0205c("ImageProcessingIFDPointer", 8256, 1)};
    /* renamed from: z */
    private static final C0205c f509z = new C0205c("JPEGInterchangeFormat", 513, 4);
    /* renamed from: G */
    private final String f510G;
    /* renamed from: H */
    private final AssetInputStream f511H;
    /* renamed from: I */
    private int f512I;
    /* renamed from: J */
    private final HashMap<String, C0204b>[] f513J;
    /* renamed from: K */
    private ByteOrder f514K;
    /* renamed from: L */
    private boolean f515L;
    /* renamed from: M */
    private int f516M;
    /* renamed from: N */
    private int f517N;
    /* renamed from: O */
    private byte[] f518O;
    /* renamed from: P */
    private int f519P;
    /* renamed from: Q */
    private int f520Q;
    /* renamed from: R */
    private int f521R;
    /* renamed from: S */
    private int f522S;
    /* renamed from: T */
    private int f523T;
    /* renamed from: U */
    private int f524U;
    /* renamed from: V */
    private boolean f525V;

    /* compiled from: ExifInterface */
    /* renamed from: android.support.e.a$a */
    private static class C0203a extends InputStream implements DataInput {
        /* renamed from: a */
        private static final ByteOrder f461a = ByteOrder.LITTLE_ENDIAN;
        /* renamed from: b */
        private static final ByteOrder f462b = ByteOrder.BIG_ENDIAN;
        /* renamed from: c */
        private DataInputStream f463c;
        /* renamed from: d */
        private ByteOrder f464d;
        /* renamed from: e */
        private final int f465e;
        /* renamed from: f */
        private int f466f;

        public C0203a(InputStream inputStream) {
            this.f464d = ByteOrder.BIG_ENDIAN;
            this.f463c = new DataInputStream(inputStream);
            this.f465e = this.f463c.available();
            this.f466f = null;
            this.f463c.mark(this.f465e);
        }

        public C0203a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        /* renamed from: a */
        public void m467a(ByteOrder byteOrder) {
            this.f464d = byteOrder;
        }

        /* renamed from: a */
        public void m466a(long j) {
            if (((long) this.f466f) > j) {
                this.f466f = 0;
                this.f463c.reset();
                this.f463c.mark(this.f465e);
            } else {
                j -= (long) this.f466f;
            }
            j = (int) j;
            if (skipBytes(j) != j) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        /* renamed from: a */
        public int m465a() {
            return this.f466f;
        }

        public int available() {
            return this.f463c.available();
        }

        public int read() {
            this.f466f++;
            return this.f463c.read();
        }

        public int read(byte[] bArr, int i, int i2) {
            bArr = this.f463c.read(bArr, i, i2);
            this.f466f += bArr;
            return bArr;
        }

        public int readUnsignedByte() {
            this.f466f++;
            return this.f463c.readUnsignedByte();
        }

        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public boolean readBoolean() {
            this.f466f++;
            return this.f463c.readBoolean();
        }

        public char readChar() {
            this.f466f += 2;
            return this.f463c.readChar();
        }

        public String readUTF() {
            this.f466f += 2;
            return this.f463c.readUTF();
        }

        public void readFully(byte[] bArr, int i, int i2) {
            this.f466f += i2;
            if (this.f466f > this.f465e) {
                throw new EOFException();
            } else if (this.f463c.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public void readFully(byte[] bArr) {
            this.f466f += bArr.length;
            if (this.f466f > this.f465e) {
                throw new EOFException();
            } else if (this.f463c.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public byte readByte() {
            this.f466f++;
            if (this.f466f <= this.f465e) {
                int read = this.f463c.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() {
            this.f466f += 2;
            if (this.f466f <= this.f465e) {
                int read = this.f463c.read();
                int read2 = this.f463c.read();
                if ((read | read2) < 0) {
                    throw new EOFException();
                } else if (this.f464d == f461a) {
                    return (short) ((read2 << 8) + read);
                } else {
                    if (this.f464d == f462b) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid byte order: ");
                    stringBuilder.append(this.f464d);
                    throw new IOException(stringBuilder.toString());
                }
            }
            throw new EOFException();
        }

        public int readInt() {
            this.f466f += 4;
            if (this.f466f <= this.f465e) {
                int read = this.f463c.read();
                int read2 = this.f463c.read();
                int read3 = this.f463c.read();
                int read4 = this.f463c.read();
                if ((((read | read2) | read3) | read4) < 0) {
                    throw new EOFException();
                } else if (this.f464d == f461a) {
                    return (((read4 << 24) + (read3 << 16)) + (read2 << 8)) + read;
                } else {
                    if (this.f464d == f462b) {
                        return (((read << 24) + (read2 << 16)) + (read3 << 8)) + read4;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid byte order: ");
                    stringBuilder.append(this.f464d);
                    throw new IOException(stringBuilder.toString());
                }
            }
            throw new EOFException();
        }

        public int skipBytes(int i) {
            i = Math.min(i, this.f465e - this.f466f);
            int i2 = 0;
            while (i2 < i) {
                i2 += this.f463c.skipBytes(i - i2);
            }
            this.f466f += i2;
            return i2;
        }

        public int readUnsignedShort() {
            this.f466f += 2;
            if (this.f466f <= this.f465e) {
                int read = this.f463c.read();
                int read2 = this.f463c.read();
                if ((read | read2) < 0) {
                    throw new EOFException();
                } else if (this.f464d == f461a) {
                    return (read2 << 8) + read;
                } else {
                    if (this.f464d == f462b) {
                        return (read << 8) + read2;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid byte order: ");
                    stringBuilder.append(this.f464d);
                    throw new IOException(stringBuilder.toString());
                }
            }
            throw new EOFException();
        }

        /* renamed from: b */
        public long m468b() {
            return ((long) readInt()) & 4294967295L;
        }

        public long readLong() {
            this.f466f += 8;
            if (this.f466f <= this.f465e) {
                int read = r0.f463c.read();
                int read2 = r0.f463c.read();
                int read3 = r0.f463c.read();
                int read4 = r0.f463c.read();
                int read5 = r0.f463c.read();
                int read6 = r0.f463c.read();
                int read7 = r0.f463c.read();
                int read8 = r0.f463c.read();
                if ((((((((read | read2) | read3) | read4) | read5) | read6) | read7) | read8) < 0) {
                    throw new EOFException();
                } else if (r0.f464d == f461a) {
                    return (((((((((long) read8) << 56) + (((long) read7) << 48)) + (((long) read6) << 40)) + (((long) read5) << 32)) + (((long) read4) << 24)) + (((long) read3) << 16)) + (((long) read2) << 8)) + ((long) read);
                } else {
                    int i = read2;
                    if (r0.f464d == f462b) {
                        return (((((((((long) read) << 56) + (((long) i) << 48)) + (((long) read3) << 40)) + (((long) read4) << 32)) + (((long) read5) << 24)) + (((long) read6) << 16)) + (((long) read7) << 8)) + ((long) read8);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid byte order: ");
                    stringBuilder.append(r0.f464d);
                    throw new IOException(stringBuilder.toString());
                }
            }
            throw new EOFException();
        }

        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }
    }

    /* compiled from: ExifInterface */
    /* renamed from: android.support.e.a$b */
    private static class C0204b {
        /* renamed from: a */
        public final int f467a;
        /* renamed from: b */
        public final int f468b;
        /* renamed from: c */
        public final byte[] f469c;

        private C0204b(int i, int i2, byte[] bArr) {
            this.f467a = i;
            this.f468b = i2;
            this.f469c = bArr;
        }

        /* renamed from: a */
        public static C0204b m473a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0207a.f489f[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new C0204b(3, iArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C0204b m469a(int i, ByteOrder byteOrder) {
            return C0204b.m473a(new int[]{i}, byteOrder);
        }

        /* renamed from: a */
        public static C0204b m474a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0207a.f489f[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new C0204b(4, jArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C0204b m470a(long j, ByteOrder byteOrder) {
            return C0204b.m474a(new long[]{j}, byteOrder);
        }

        /* renamed from: a */
        public static C0204b m472a(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(null);
            str = stringBuilder.toString().getBytes(C0207a.f481F);
            return new C0204b(2, str.length, str);
        }

        /* renamed from: a */
        public static C0204b m475a(C0206d[] c0206dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C0207a.f489f[5] * c0206dArr.length)]);
            wrap.order(byteOrder);
            for (C0206d c0206d : c0206dArr) {
                wrap.putInt((int) c0206d.f474a);
                wrap.putInt((int) c0206d.f475b);
            }
            return new C0204b(5, c0206dArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C0204b m471a(C0206d c0206d, ByteOrder byteOrder) {
            return C0204b.m475a(new C0206d[]{c0206d}, byteOrder);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            stringBuilder.append(C0207a.f488e[this.f467a]);
            stringBuilder.append(", data length:");
            stringBuilder.append(this.f469c.length);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        /* renamed from: d */
        private Object m477d(ByteOrder byteOrder) {
            C0203a c0203a;
            try {
                c0203a = new C0203a(this.f469c);
                try {
                    c0203a.m467a(byteOrder);
                    int i = 1;
                    int i2 = 0;
                    switch (this.f467a) {
                        case 1:
                        case 6:
                            if (this.f469c.length != 1 || this.f469c[0] < null || this.f469c[0] > 1) {
                                byteOrder = new String(this.f469c, C0207a.f481F);
                                try {
                                    c0203a.close();
                                } catch (Throwable e) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                }
                                return byteOrder;
                            }
                            byteOrder = new String(new char[]{(char) (this.f469c[0] + 48)});
                            try {
                                c0203a.close();
                            } catch (Throwable e2) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                            }
                            return byteOrder;
                        case 2:
                        case 7:
                            if (this.f468b >= C0207a.f497n.length) {
                                byteOrder = null;
                                while (byteOrder < C0207a.f497n.length) {
                                    if (this.f469c[byteOrder] != C0207a.f497n[byteOrder]) {
                                        i = 0;
                                        if (i != 0) {
                                            i2 = C0207a.f497n.length;
                                        }
                                    } else {
                                        byteOrder++;
                                    }
                                }
                                if (i != 0) {
                                    i2 = C0207a.f497n.length;
                                }
                            }
                            byteOrder = new StringBuilder();
                            for (i2 = 
/*
Method generation error in method: android.support.e.a.b.d(java.nio.ByteOrder):java.lang.Object, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r3_18 'i2' int) = (r3_0 'i2' int), (r3_0 'i2' int), (r3_17 'i2' int) binds: {(r3_0 'i2' int)=B:104:0x0124, (r3_0 'i2' int)=B:112:0x013f, (r3_17 'i2' int)=B:113:0x0141} in method: android.support.e.a.b.d(java.nio.ByteOrder):java.lang.Object, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:266)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:279)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:279)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:233)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:219)
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
	... 34 more

*/

                            /* renamed from: a */
                            public double m478a(ByteOrder byteOrder) {
                                byteOrder = m477d(byteOrder);
                                if (byteOrder == null) {
                                    throw new NumberFormatException("NULL can't be converted to a double value");
                                } else if (byteOrder instanceof String) {
                                    return Double.parseDouble((String) byteOrder);
                                } else {
                                    if (byteOrder instanceof long[]) {
                                        long[] jArr = (long[]) byteOrder;
                                        if (jArr.length == 1) {
                                            return (double) jArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else if (byteOrder instanceof int[]) {
                                        int[] iArr = (int[]) byteOrder;
                                        if (iArr.length == 1) {
                                            return (double) iArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else if (byteOrder instanceof double[]) {
                                        double[] dArr = (double[]) byteOrder;
                                        if (dArr.length == 1) {
                                            return dArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else if (byteOrder instanceof C0206d[]) {
                                        C0206d[] c0206dArr = (C0206d[]) byteOrder;
                                        if (c0206dArr.length == 1) {
                                            return c0206dArr[0].m483a();
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else {
                                        throw new NumberFormatException("Couldn't find a double value");
                                    }
                                }
                            }

                            /* renamed from: b */
                            public int m479b(ByteOrder byteOrder) {
                                byteOrder = m477d(byteOrder);
                                if (byteOrder == null) {
                                    throw new NumberFormatException("NULL can't be converted to a integer value");
                                } else if (byteOrder instanceof String) {
                                    return Integer.parseInt((String) byteOrder);
                                } else {
                                    if (byteOrder instanceof long[]) {
                                        long[] jArr = (long[]) byteOrder;
                                        if (jArr.length == 1) {
                                            return (int) jArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else if (byteOrder instanceof int[]) {
                                        int[] iArr = (int[]) byteOrder;
                                        if (iArr.length == 1) {
                                            return iArr[0];
                                        }
                                        throw new NumberFormatException("There are more than one component");
                                    } else {
                                        throw new NumberFormatException("Couldn't find a integer value");
                                    }
                                }
                            }

                            /* renamed from: c */
                            public String m480c(ByteOrder byteOrder) {
                                byteOrder = m477d(byteOrder);
                                if (byteOrder == null) {
                                    return null;
                                }
                                if (byteOrder instanceof String) {
                                    return (String) byteOrder;
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                int i = 0;
                                if (byteOrder instanceof long[]) {
                                    long[] jArr = (long[]) byteOrder;
                                    while (i < jArr.length) {
                                        stringBuilder.append(jArr[i]);
                                        i++;
                                        if (i != jArr.length) {
                                            stringBuilder.append(",");
                                        }
                                    }
                                    return stringBuilder.toString();
                                } else if (byteOrder instanceof int[]) {
                                    int[] iArr = (int[]) byteOrder;
                                    while (i < iArr.length) {
                                        stringBuilder.append(iArr[i]);
                                        i++;
                                        if (i != iArr.length) {
                                            stringBuilder.append(",");
                                        }
                                    }
                                    return stringBuilder.toString();
                                } else if (byteOrder instanceof double[]) {
                                    double[] dArr = (double[]) byteOrder;
                                    while (i < dArr.length) {
                                        stringBuilder.append(dArr[i]);
                                        i++;
                                        if (i != dArr.length) {
                                            stringBuilder.append(",");
                                        }
                                    }
                                    return stringBuilder.toString();
                                } else if (!(byteOrder instanceof C0206d[])) {
                                    return null;
                                } else {
                                    C0206d[] c0206dArr = (C0206d[]) byteOrder;
                                    while (i < c0206dArr.length) {
                                        stringBuilder.append(c0206dArr[i].f474a);
                                        stringBuilder.append('/');
                                        stringBuilder.append(c0206dArr[i].f475b);
                                        i++;
                                        if (i != c0206dArr.length) {
                                            stringBuilder.append(",");
                                        }
                                    }
                                    return stringBuilder.toString();
                                }
                            }
                        }

                        /* compiled from: ExifInterface */
                        /* renamed from: android.support.e.a$c */
                        static class C0205c {
                            /* renamed from: a */
                            public final int f470a;
                            /* renamed from: b */
                            public final String f471b;
                            /* renamed from: c */
                            public final int f472c;
                            /* renamed from: d */
                            public final int f473d;

                            private C0205c(String str, int i, int i2) {
                                this.f471b = str;
                                this.f470a = i;
                                this.f472c = i2;
                                this.f473d = -1;
                            }

                            private C0205c(String str, int i, int i2, int i3) {
                                this.f471b = str;
                                this.f470a = i;
                                this.f472c = i2;
                                this.f473d = i3;
                            }

                            /* renamed from: a */
                            private boolean m481a(int i) {
                                if (this.f472c != 7) {
                                    if (i != 7) {
                                        if (this.f472c != i) {
                                            if (this.f473d != i) {
                                                if ((this.f472c == 4 || this.f473d == 4) && i == 3) {
                                                    return true;
                                                }
                                                if ((this.f472c == 9 || this.f473d == 9) && i == 8) {
                                                    return true;
                                                }
                                                if ((this.f472c == 12 || this.f473d == 12) && i == 11) {
                                                    return true;
                                                }
                                                return false;
                                            }
                                        }
                                        return true;
                                    }
                                }
                                return true;
                            }
                        }

                        /* compiled from: ExifInterface */
                        /* renamed from: android.support.e.a$d */
                        private static class C0206d {
                            /* renamed from: a */
                            public final long f474a;
                            /* renamed from: b */
                            public final long f475b;

                            private C0206d(long j, long j2) {
                                if (j2 == 0) {
                                    this.f474a = 0;
                                    this.f475b = 1;
                                    return;
                                }
                                this.f474a = j;
                                this.f475b = j2;
                            }

                            public String toString() {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(this.f474a);
                                stringBuilder.append("/");
                                stringBuilder.append(this.f475b);
                                return stringBuilder.toString();
                            }

                            /* renamed from: a */
                            public double m483a() {
                                return ((double) this.f474a) / ((double) this.f475b);
                            }
                        }

                        static {
                            f496m.setTimeZone(TimeZone.getTimeZone("UTC"));
                            for (int i = 0; i < f490g.length; i++) {
                                f477B[i] = new HashMap();
                                f478C[i] = new HashMap();
                                for (C0205c c0205c : f490g[i]) {
                                    f477B[i].put(Integer.valueOf(c0205c.f470a), c0205c);
                                    f478C[i].put(c0205c.f471b, c0205c);
                                }
                            }
                            f480E.put(Integer.valueOf(f508y[0].f470a), Integer.valueOf(5));
                            f480E.put(Integer.valueOf(f508y[1].f470a), Integer.valueOf(1));
                            f480E.put(Integer.valueOf(f508y[2].f470a), Integer.valueOf(2));
                            f480E.put(Integer.valueOf(f508y[3].f470a), Integer.valueOf(3));
                            f480E.put(Integer.valueOf(f508y[4].f470a), Integer.valueOf(7));
                            f480E.put(Integer.valueOf(f508y[5].f470a), Integer.valueOf(8));
                        }

                        public C0207a(String str) {
                            this.f513J = new HashMap[f490g.length];
                            this.f514K = ByteOrder.BIG_ENDIAN;
                            if (str != null) {
                                Closeable closeable = null;
                                this.f511H = null;
                                this.f510G = str;
                                try {
                                    Closeable fileInputStream = new FileInputStream(str);
                                    try {
                                        m492a((InputStream) fileInputStream);
                                        C0207a.m491a(fileInputStream);
                                        return;
                                    } catch (Throwable th) {
                                        str = th;
                                        closeable = fileInputStream;
                                        C0207a.m491a(closeable);
                                        throw str;
                                    }
                                } catch (Throwable th2) {
                                    str = th2;
                                    C0207a.m491a(closeable);
                                    throw str;
                                }
                            }
                            throw new IllegalArgumentException("filename cannot be null");
                        }

                        public C0207a(InputStream inputStream) {
                            this.f513J = new HashMap[f490g.length];
                            this.f514K = ByteOrder.BIG_ENDIAN;
                            if (inputStream != null) {
                                this.f510G = null;
                                if (inputStream instanceof AssetInputStream) {
                                    this.f511H = (AssetInputStream) inputStream;
                                } else {
                                    this.f511H = null;
                                }
                                m492a(inputStream);
                                return;
                            }
                            throw new IllegalArgumentException("inputStream cannot be null");
                        }

                        /* renamed from: b */
                        private C0204b m497b(String str) {
                            if ("ISOSpeedRatings".equals(str)) {
                                str = "PhotographicSensitivity";
                            }
                            for (int i = 0; i < f490g.length; i++) {
                                C0204b c0204b = (C0204b) this.f513J[i].get(str);
                                if (c0204b != null) {
                                    return c0204b;
                                }
                            }
                            return null;
                        }

                        /* renamed from: a */
                        public java.lang.String m518a(java.lang.String r7) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                            /*
                            r6 = this;
                            r0 = r6.m497b(r7);
                            r1 = 0;
                            if (r0 == 0) goto L_0x00ba;
                        L_0x0007:
                            r2 = f479D;
                            r2 = r2.contains(r7);
                            if (r2 != 0) goto L_0x0016;
                        L_0x000f:
                            r7 = r6.f514K;
                            r7 = r0.m480c(r7);
                            return r7;
                        L_0x0016:
                            r2 = "GPSTimeStamp";
                            r7 = r7.equals(r2);
                            if (r7 == 0) goto L_0x00ae;
                        L_0x001e:
                            r7 = r0.f467a;
                            r2 = 5;
                            if (r7 == r2) goto L_0x0042;
                        L_0x0023:
                            r7 = r0.f467a;
                            r2 = 10;
                            if (r7 == r2) goto L_0x0042;
                        L_0x0029:
                            r7 = "ExifInterface";
                            r2 = new java.lang.StringBuilder;
                            r2.<init>();
                            r3 = "GPS Timestamp format is not rational. format=";
                            r2.append(r3);
                            r0 = r0.f467a;
                            r2.append(r0);
                            r0 = r2.toString();
                            android.util.Log.w(r7, r0);
                            return r1;
                        L_0x0042:
                            r7 = r6.f514K;
                            r7 = r0.m477d(r7);
                            r7 = (android.support.p018e.C0207a.C0206d[]) r7;
                            if (r7 == 0) goto L_0x0093;
                        L_0x004c:
                            r0 = r7.length;
                            r2 = 3;
                            if (r0 == r2) goto L_0x0051;
                        L_0x0050:
                            goto L_0x0093;
                        L_0x0051:
                            r0 = "%02d:%02d:%02d";
                            r1 = new java.lang.Object[r2];
                            r2 = 0;
                            r3 = r7[r2];
                            r3 = r3.f474a;
                            r3 = (float) r3;
                            r4 = r7[r2];
                            r4 = r4.f475b;
                            r4 = (float) r4;
                            r3 = r3 / r4;
                            r3 = (int) r3;
                            r3 = java.lang.Integer.valueOf(r3);
                            r1[r2] = r3;
                            r2 = 1;
                            r3 = r7[r2];
                            r3 = r3.f474a;
                            r3 = (float) r3;
                            r4 = r7[r2];
                            r4 = r4.f475b;
                            r4 = (float) r4;
                            r3 = r3 / r4;
                            r3 = (int) r3;
                            r3 = java.lang.Integer.valueOf(r3);
                            r1[r2] = r3;
                            r2 = 2;
                            r3 = r7[r2];
                            r3 = r3.f474a;
                            r3 = (float) r3;
                            r7 = r7[r2];
                            r4 = r7.f475b;
                            r7 = (float) r4;
                            r3 = r3 / r7;
                            r7 = (int) r3;
                            r7 = java.lang.Integer.valueOf(r7);
                            r1[r2] = r7;
                            r7 = java.lang.String.format(r0, r1);
                            return r7;
                        L_0x0093:
                            r0 = "ExifInterface";
                            r2 = new java.lang.StringBuilder;
                            r2.<init>();
                            r3 = "Invalid GPS Timestamp array. array=";
                            r2.append(r3);
                            r7 = java.util.Arrays.toString(r7);
                            r2.append(r7);
                            r7 = r2.toString();
                            android.util.Log.w(r0, r7);
                            return r1;
                        L_0x00ae:
                            r7 = r6.f514K;	 Catch:{ NumberFormatException -> 0x00b9 }
                            r2 = r0.m478a(r7);	 Catch:{ NumberFormatException -> 0x00b9 }
                            r7 = java.lang.Double.toString(r2);	 Catch:{ NumberFormatException -> 0x00b9 }
                            return r7;
                        L_0x00b9:
                            return r1;
                        L_0x00ba:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.a(java.lang.String):java.lang.String");
                        }

                        /* renamed from: a */
                        public int m517a(java.lang.String r2, int r3) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                            /*
                            r1 = this;
                            r2 = r1.m497b(r2);
                            if (r2 != 0) goto L_0x0007;
                        L_0x0006:
                            return r3;
                        L_0x0007:
                            r0 = r1.f514K;	 Catch:{ NumberFormatException -> 0x000e }
                            r2 = r2.m479b(r0);	 Catch:{ NumberFormatException -> 0x000e }
                            return r2;
                        L_0x000e:
                            return r3;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.a(java.lang.String, int):int");
                        }

                        /* renamed from: a */
                        public double m516a(java.lang.String r3, double r4) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                            /*
                            r2 = this;
                            r3 = r2.m497b(r3);
                            if (r3 != 0) goto L_0x0007;
                        L_0x0006:
                            return r4;
                        L_0x0007:
                            r0 = r2.f514K;	 Catch:{ NumberFormatException -> 0x000e }
                            r0 = r3.m478a(r0);	 Catch:{ NumberFormatException -> 0x000e }
                            return r0;
                        L_0x000e:
                            return r4;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.a(java.lang.String, double):double");
                        }

                        /* renamed from: a */
                        private void m492a(java.io.InputStream r5) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                            /*
                            r4 = this;
                            r0 = 0;
                            r1 = 0;
                        L_0x0002:
                            r2 = f490g;	 Catch:{ IOException -> 0x004a }
                            r2 = r2.length;	 Catch:{ IOException -> 0x004a }
                            if (r1 >= r2) goto L_0x0013;	 Catch:{ IOException -> 0x004a }
                        L_0x0007:
                            r2 = r4.f513J;	 Catch:{ IOException -> 0x004a }
                            r3 = new java.util.HashMap;	 Catch:{ IOException -> 0x004a }
                            r3.<init>();	 Catch:{ IOException -> 0x004a }
                            r2[r1] = r3;	 Catch:{ IOException -> 0x004a }
                            r1 = r1 + 1;	 Catch:{ IOException -> 0x004a }
                            goto L_0x0002;	 Catch:{ IOException -> 0x004a }
                        L_0x0013:
                            r1 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x004a }
                            r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ IOException -> 0x004a }
                            r1.<init>(r5, r2);	 Catch:{ IOException -> 0x004a }
                            r5 = r1;	 Catch:{ IOException -> 0x004a }
                            r5 = (java.io.BufferedInputStream) r5;	 Catch:{ IOException -> 0x004a }
                            r5 = r4.m485a(r5);	 Catch:{ IOException -> 0x004a }
                            r4.f512I = r5;	 Catch:{ IOException -> 0x004a }
                            r5 = new android.support.e.a$a;	 Catch:{ IOException -> 0x004a }
                            r5.<init>(r1);	 Catch:{ IOException -> 0x004a }
                            r1 = r4.f512I;	 Catch:{ IOException -> 0x004a }
                            switch(r1) {
                                case 0: goto L_0x003e;
                                case 1: goto L_0x003e;
                                case 2: goto L_0x003e;
                                case 3: goto L_0x003e;
                                case 4: goto L_0x003a;
                                case 5: goto L_0x003e;
                                case 6: goto L_0x003e;
                                case 7: goto L_0x0036;
                                case 8: goto L_0x003e;
                                case 9: goto L_0x0032;
                                case 10: goto L_0x002e;
                                case 11: goto L_0x003e;
                                default: goto L_0x002d;
                            };	 Catch:{ IOException -> 0x004a }
                        L_0x002d:
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x002e:
                            r4.m510d(r5);	 Catch:{ IOException -> 0x004a }
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x0032:
                            r4.m499b(r5);	 Catch:{ IOException -> 0x004a }
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x0036:
                            r4.m505c(r5);	 Catch:{ IOException -> 0x004a }
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x003a:
                            r4.m489a(r5, r0, r0);	 Catch:{ IOException -> 0x004a }
                            goto L_0x0041;	 Catch:{ IOException -> 0x004a }
                        L_0x003e:
                            r4.m487a(r5);	 Catch:{ IOException -> 0x004a }
                        L_0x0041:
                            r4.m514f(r5);	 Catch:{ IOException -> 0x004a }
                            r5 = 1;	 Catch:{ IOException -> 0x004a }
                            r4.f525V = r5;	 Catch:{ IOException -> 0x004a }
                            goto L_0x004c;
                        L_0x0048:
                            r5 = move-exception;
                            goto L_0x0050;
                        L_0x004a:
                            r4.f525V = r0;	 Catch:{ all -> 0x0048 }
                        L_0x004c:
                            r4.m509d();
                            return;
                        L_0x0050:
                            r4.m509d();
                            throw r5;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.a(java.io.InputStream):void");
                        }

                        /* renamed from: a */
                        public double[] m519a() {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                            /*
                            r12 = this;
                            r0 = "GPSLatitude";
                            r0 = r12.m518a(r0);
                            r1 = "GPSLatitudeRef";
                            r1 = r12.m518a(r1);
                            r2 = "GPSLongitude";
                            r2 = r12.m518a(r2);
                            r3 = "GPSLongitudeRef";
                            r3 = r12.m518a(r3);
                            if (r0 == 0) goto L_0x005a;
                        L_0x001a:
                            if (r1 == 0) goto L_0x005a;
                        L_0x001c:
                            if (r2 == 0) goto L_0x005a;
                        L_0x001e:
                            if (r3 == 0) goto L_0x005a;
                        L_0x0020:
                            r4 = 2;
                            r5 = 1;
                            r6 = 0;
                            r7 = android.support.p018e.C0207a.m484a(r0, r1);	 Catch:{ IllegalArgumentException -> 0x0032 }
                            r9 = android.support.p018e.C0207a.m484a(r2, r3);	 Catch:{ IllegalArgumentException -> 0x0032 }
                            r11 = new double[r4];	 Catch:{ IllegalArgumentException -> 0x0032 }
                            r11[r6] = r7;	 Catch:{ IllegalArgumentException -> 0x0032 }
                            r11[r5] = r9;	 Catch:{ IllegalArgumentException -> 0x0032 }
                            return r11;
                        L_0x0032:
                            r7 = "ExifInterface";
                            r8 = new java.lang.StringBuilder;
                            r8.<init>();
                            r9 = "Latitude/longitude values are not parseable. ";
                            r8.append(r9);
                            r9 = "latValue=%s, latRef=%s, lngValue=%s, lngRef=%s";
                            r10 = 4;
                            r10 = new java.lang.Object[r10];
                            r10[r6] = r0;
                            r10[r5] = r1;
                            r10[r4] = r2;
                            r0 = 3;
                            r10[r0] = r3;
                            r0 = java.lang.String.format(r9, r10);
                            r8.append(r0);
                            r0 = r8.toString();
                            android.util.Log.w(r7, r0);
                        L_0x005a:
                            r0 = 0;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.a():double[]");
                        }

                        /* renamed from: a */
                        public double m515a(double d) {
                            double a = m516a("GPSAltitude", -1.0d);
                            int a2 = m517a("GPSAltitudeRef", -1);
                            if (a < 0.0d || a2 < 0) {
                                return d;
                            }
                            d = 1;
                            if (a2 == 1) {
                                d = -1;
                            }
                            return a * ((double) d);
                        }

                        /* renamed from: a */
                        private static double m484a(java.lang.String r9, java.lang.String r10) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                            /*
                            r0 = ",";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9.split(r0);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = 0;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r9[r0];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = "/";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1.split(r2);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r1[r0];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r2.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = java.lang.Double.parseDouble(r2);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r4 = 1;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1[r4];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = java.lang.Double.parseDouble(r1);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r2 / r5;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r9[r4];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = "/";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1.split(r5);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = r1[r0];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = r5.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = java.lang.Double.parseDouble(r5);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1[r4];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = r1.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r7 = java.lang.Double.parseDouble(r1);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = r5 / r7;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = 2;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9[r1];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r1 = "/";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9.split(r1);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = r9[r0];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = r0.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = java.lang.Double.parseDouble(r0);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9[r4];	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r9.trim();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r7 = java.lang.Double.parseDouble(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = r0 / r7;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r7 = 4633641066610819072; // 0x404e000000000000 float:0.0 double:60.0;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r5 = r5 / r7;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r2 + r5;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r4 = 4660134898793709568; // 0x40ac200000000000 float:0.0 double:3600.0;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r0 = r0 / r4;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r2 = r2 + r0;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = "S";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r10.equals(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            if (r9 != 0) goto L_0x0094;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x0073:
                            r9 = "W";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r10.equals(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            if (r9 == 0) goto L_0x007c;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x007b:
                            goto L_0x0094;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x007c:
                            r9 = "N";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r10.equals(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            if (r9 != 0) goto L_0x0093;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x0084:
                            r9 = "E";	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9 = r10.equals(r9);	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            if (r9 == 0) goto L_0x008d;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x008c:
                            goto L_0x0093;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x008d:
                            r9 = new java.lang.IllegalArgumentException;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            r9.<init>();	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                            throw r9;	 Catch:{ NumberFormatException -> 0x0096, NumberFormatException -> 0x0096 }
                        L_0x0093:
                            return r2;
                        L_0x0094:
                            r9 = -r2;
                            return r9;
                        L_0x0096:
                            r9 = new java.lang.IllegalArgumentException;
                            r9.<init>();
                            throw r9;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.a(java.lang.String, java.lang.String):double");
                        }

                        /* renamed from: a */
                        private int m485a(BufferedInputStream bufferedInputStream) {
                            bufferedInputStream.mark(5000);
                            byte[] bArr = new byte[5000];
                            bufferedInputStream.read(bArr);
                            bufferedInputStream.reset();
                            if (C0207a.m495a(bArr) != null) {
                                return 4;
                            }
                            if (m504b(bArr) != null) {
                                return 9;
                            }
                            if (m507c(bArr) != null) {
                                return 7;
                            }
                            return m512d(bArr) != null ? 10 : null;
                        }

                        /* renamed from: a */
                        private static boolean m495a(byte[] bArr) {
                            for (int i = 0; i < f487d.length; i++) {
                                if (bArr[i] != f487d[i]) {
                                    return false;
                                }
                            }
                            return 1;
                        }

                        /* renamed from: b */
                        private boolean m504b(byte[] bArr) {
                            byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                            for (int i = 0; i < bytes.length; i++) {
                                if (bArr[i] != bytes[i]) {
                                    return false;
                                }
                            }
                            return 1;
                        }

                        /* renamed from: c */
                        private boolean m507c(byte[] bArr) {
                            C0203a c0203a = new C0203a(bArr);
                            this.f514K = m513e(c0203a);
                            c0203a.m467a(this.f514K);
                            bArr = c0203a.readShort();
                            c0203a.close();
                            if (bArr != 20306) {
                                if (bArr != 21330) {
                                    return null;
                                }
                            }
                            return 1;
                        }

                        /* renamed from: d */
                        private boolean m512d(byte[] bArr) {
                            C0203a c0203a = new C0203a(bArr);
                            this.f514K = m513e(c0203a);
                            c0203a.m467a(this.f514K);
                            bArr = c0203a.readShort();
                            c0203a.close();
                            return bArr == 85 ? 1 : null;
                        }

                        /* renamed from: a */
                        private void m489a(C0203a c0203a, int i, int i2) {
                            c0203a.m467a(ByteOrder.BIG_ENDIAN);
                            c0203a.m466a((long) i);
                            byte readByte = c0203a.readByte();
                            if (readByte == (byte) -1) {
                                i++;
                                if (c0203a.readByte() == (byte) -40) {
                                    i++;
                                    while (true) {
                                        readByte = c0203a.readByte();
                                        if (readByte == (byte) -1) {
                                            i++;
                                            readByte = c0203a.readByte();
                                            i++;
                                            if (readByte != (byte) -39) {
                                                if (readByte != (byte) -38) {
                                                    int readUnsignedShort = c0203a.readUnsignedShort() - 2;
                                                    i += 2;
                                                    if (readUnsignedShort >= 0) {
                                                        byte[] bArr;
                                                        if (readByte == (byte) -31) {
                                                            if (readUnsignedShort >= 6) {
                                                                byte[] bArr2 = new byte[6];
                                                                if (c0203a.read(bArr2) == 6) {
                                                                    i += 6;
                                                                    readUnsignedShort -= 6;
                                                                    if (Arrays.equals(bArr2, f491h)) {
                                                                        if (readUnsignedShort > 0) {
                                                                            this.f520Q = i;
                                                                            bArr = new byte[readUnsignedShort];
                                                                            if (c0203a.read(bArr) == readUnsignedShort) {
                                                                                i += readUnsignedShort;
                                                                                m493a(bArr, i2);
                                                                            } else {
                                                                                throw new IOException("Invalid exif");
                                                                            }
                                                                        }
                                                                        throw new IOException("Invalid exif");
                                                                    }
                                                                } else {
                                                                    throw new IOException("Invalid exif");
                                                                }
                                                            }
                                                            if (readUnsignedShort >= 0) {
                                                                throw new IOException("Invalid length");
                                                            } else if (c0203a.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                                                throw new IOException("Invalid JPEG segment");
                                                            } else {
                                                                i += readUnsignedShort;
                                                            }
                                                        } else if (readByte != (byte) -2) {
                                                            switch (readByte) {
                                                                case (byte) -64:
                                                                case (byte) -63:
                                                                case (byte) -62:
                                                                case (byte) -61:
                                                                    if (c0203a.skipBytes(1) == 1) {
                                                                        this.f513J[i2].put("ImageLength", C0204b.m470a((long) c0203a.readUnsignedShort(), this.f514K));
                                                                        this.f513J[i2].put("ImageWidth", C0204b.m470a((long) c0203a.readUnsignedShort(), this.f514K));
                                                                        readUnsignedShort -= 5;
                                                                        break;
                                                                    }
                                                                    throw new IOException("Invalid SOFx");
                                                                default:
                                                                    switch (readByte) {
                                                                        case (byte) -59:
                                                                        case (byte) -58:
                                                                        case (byte) -57:
                                                                            break;
                                                                        default:
                                                                            switch (readByte) {
                                                                                case (byte) -55:
                                                                                case (byte) -54:
                                                                                case (byte) -53:
                                                                                    break;
                                                                                default:
                                                                                    switch (readByte) {
                                                                                        case (byte) -51:
                                                                                        case (byte) -50:
                                                                                        case (byte) -49:
                                                                                            break;
                                                                                        default:
                                                                                            break;
                                                                                    }
                                                                            }
                                                                    }
                                                                    if (c0203a.skipBytes(1) == 1) {
                                                                        this.f513J[i2].put("ImageLength", C0204b.m470a((long) c0203a.readUnsignedShort(), this.f514K));
                                                                        this.f513J[i2].put("ImageWidth", C0204b.m470a((long) c0203a.readUnsignedShort(), this.f514K));
                                                                        readUnsignedShort -= 5;
                                                                        break;
                                                                    }
                                                                    throw new IOException("Invalid SOFx");
                                                            }
                                                            if (readUnsignedShort >= 0) {
                                                                throw new IOException("Invalid length");
                                                            } else if (c0203a.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                                                i += readUnsignedShort;
                                                            } else {
                                                                throw new IOException("Invalid JPEG segment");
                                                            }
                                                        } else {
                                                            bArr = new byte[readUnsignedShort];
                                                            if (c0203a.read(bArr) != readUnsignedShort) {
                                                                throw new IOException("Invalid exif");
                                                            } else if (m518a("UserComment") == null) {
                                                                this.f513J[1].put("UserComment", C0204b.m472a(new String(bArr, f481F)));
                                                            }
                                                        }
                                                        readUnsignedShort = 0;
                                                        if (readUnsignedShort >= 0) {
                                                            throw new IOException("Invalid length");
                                                        } else if (c0203a.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                                            i += readUnsignedShort;
                                                        } else {
                                                            throw new IOException("Invalid JPEG segment");
                                                        }
                                                    }
                                                    throw new IOException("Invalid length");
                                                }
                                            }
                                            c0203a.m467a(this.f514K);
                                            return;
                                        }
                                        i = new StringBuilder();
                                        i.append("Invalid marker:");
                                        i.append(Integer.toHexString(readByte & JfifUtil.MARKER_FIRST_BYTE));
                                        throw new IOException(i.toString());
                                    }
                                }
                                i = new StringBuilder();
                                i.append("Invalid marker: ");
                                i.append(Integer.toHexString(readByte & JfifUtil.MARKER_FIRST_BYTE));
                                throw new IOException(i.toString());
                            }
                            i = new StringBuilder();
                            i.append("Invalid marker: ");
                            i.append(Integer.toHexString(readByte & JfifUtil.MARKER_FIRST_BYTE));
                            throw new IOException(i.toString());
                        }

                        /* renamed from: a */
                        private void m487a(C0203a c0203a) {
                            m488a(c0203a, c0203a.available());
                            m500b(c0203a, 0);
                            m511d(c0203a, 0);
                            m511d(c0203a, 5);
                            m511d(c0203a, 4);
                            m502b((InputStream) c0203a);
                            if (this.f512I == 8) {
                                C0204b c0204b = (C0204b) this.f513J[1].get("MakerNote");
                                if (c0204b != null) {
                                    C0203a c0203a2 = new C0203a(c0204b.f469c);
                                    c0203a2.m467a(this.f514K);
                                    c0203a2.m466a(6);
                                    m500b(c0203a2, 9);
                                    c0204b = (C0204b) this.f513J[9].get("ColorSpace");
                                    if (c0204b != null) {
                                        this.f513J[1].put("ColorSpace", c0204b);
                                    }
                                }
                            }
                        }

                        /* renamed from: b */
                        private void m499b(C0203a c0203a) {
                            c0203a.skipBytes(84);
                            byte[] bArr = new byte[4];
                            byte[] bArr2 = new byte[4];
                            c0203a.read(bArr);
                            c0203a.skipBytes(4);
                            c0203a.read(bArr2);
                            int i = ByteBuffer.wrap(bArr).getInt();
                            int i2 = ByteBuffer.wrap(bArr2).getInt();
                            m489a(c0203a, i, 5);
                            c0203a.m466a((long) i2);
                            c0203a.m467a(ByteOrder.BIG_ENDIAN);
                            i = c0203a.readInt();
                            for (int i3 = 0; i3 < i; i3++) {
                                int readUnsignedShort = c0203a.readUnsignedShort();
                                int readUnsignedShort2 = c0203a.readUnsignedShort();
                                if (readUnsignedShort == f503t.f470a) {
                                    i = c0203a.readShort();
                                    int readShort = c0203a.readShort();
                                    C0204b a = C0204b.m469a(i, this.f514K);
                                    c0203a = C0204b.m469a(readShort, this.f514K);
                                    this.f513J[0].put("ImageLength", a);
                                    this.f513J[0].put("ImageWidth", c0203a);
                                    return;
                                }
                                c0203a.skipBytes(readUnsignedShort2);
                            }
                        }

                        /* renamed from: c */
                        private void m505c(C0203a c0203a) {
                            m487a(c0203a);
                            C0204b c0204b = (C0204b) this.f513J[1].get("MakerNote");
                            if (c0204b != null) {
                                C0203a c0203a2 = new C0203a(c0204b.f469c);
                                c0203a2.m467a(this.f514K);
                                c0203a = new byte[f494k.length];
                                c0203a2.readFully(c0203a);
                                c0203a2.m466a(0);
                                byte[] bArr = new byte[f495l.length];
                                c0203a2.readFully(bArr);
                                if (Arrays.equals(c0203a, f494k) != null) {
                                    c0203a2.m466a(8);
                                } else if (Arrays.equals(bArr, f495l) != null) {
                                    c0203a2.m466a(12);
                                }
                                m500b(c0203a2, 6);
                                c0204b = (C0204b) this.f513J[7].get("PreviewImageStart");
                                C0204b c0204b2 = (C0204b) this.f513J[7].get("PreviewImageLength");
                                if (!(c0204b == null || c0204b2 == null)) {
                                    this.f513J[5].put("JPEGInterchangeFormat", c0204b);
                                    this.f513J[5].put("JPEGInterchangeFormatLength", c0204b2);
                                }
                                c0204b = (C0204b) this.f513J[8].get("AspectFrame");
                                if (c0204b != null) {
                                    int[] iArr = (int[]) c0204b.m477d(this.f514K);
                                    if (iArr != null) {
                                        if (iArr.length == 4) {
                                            if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                                                int i = (iArr[2] - iArr[0]) + 1;
                                                int i2 = (iArr[3] - iArr[1]) + 1;
                                                if (i < i2) {
                                                    i += i2;
                                                    i2 = i - i2;
                                                    i -= i2;
                                                }
                                                c0203a = C0204b.m469a(i, this.f514K);
                                                C0204b a = C0204b.m469a(i2, this.f514K);
                                                this.f513J[0].put("ImageWidth", c0203a);
                                                this.f513J[0].put("ImageLength", a);
                                            }
                                        }
                                    }
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid aspect frame values. frame=");
                                    stringBuilder.append(Arrays.toString(iArr));
                                    Log.w("ExifInterface", stringBuilder.toString());
                                }
                            }
                        }

                        /* renamed from: d */
                        private void m510d(C0203a c0203a) {
                            m487a(c0203a);
                            if (((C0204b) this.f513J[0].get("JpgFromRaw")) != null) {
                                m489a(c0203a, this.f524U, 5);
                            }
                            C0204b c0204b = (C0204b) this.f513J[0].get("ISO");
                            C0204b c0204b2 = (C0204b) this.f513J[1].get("PhotographicSensitivity");
                            if (c0204b != null && c0204b2 == null) {
                                this.f513J[1].put("PhotographicSensitivity", c0204b);
                            }
                        }

                        /* renamed from: a */
                        private void m493a(byte[] bArr, int i) {
                            C0203a c0203a = new C0203a(bArr);
                            m488a(c0203a, bArr.length);
                            m500b(c0203a, i);
                        }

                        /* renamed from: d */
                        private void m509d() {
                            String a = m518a("DateTimeOriginal");
                            if (a != null && m518a("DateTime") == null) {
                                this.f513J[0].put("DateTime", C0204b.m472a(a));
                            }
                            if (m518a("ImageWidth") == null) {
                                this.f513J[0].put("ImageWidth", C0204b.m470a(0, this.f514K));
                            }
                            if (m518a("ImageLength") == null) {
                                this.f513J[0].put("ImageLength", C0204b.m470a(0, this.f514K));
                            }
                            if (m518a("Orientation") == null) {
                                this.f513J[0].put("Orientation", C0204b.m470a(0, this.f514K));
                            }
                            if (m518a("LightSource") == null) {
                                this.f513J[1].put("LightSource", C0204b.m470a(0, this.f514K));
                            }
                        }

                        /* renamed from: e */
                        private ByteOrder m513e(C0203a c0203a) {
                            c0203a = c0203a.readShort();
                            if (c0203a == 18761) {
                                return ByteOrder.LITTLE_ENDIAN;
                            }
                            if (c0203a == 19789) {
                                return ByteOrder.BIG_ENDIAN;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid byte order: ");
                            stringBuilder.append(Integer.toHexString(c0203a));
                            throw new IOException(stringBuilder.toString());
                        }

                        /* renamed from: a */
                        private void m488a(C0203a c0203a, int i) {
                            this.f514K = m513e(c0203a);
                            c0203a.m467a(this.f514K);
                            int readUnsignedShort = c0203a.readUnsignedShort();
                            if (!(this.f512I == 7 || this.f512I == 10)) {
                                if (readUnsignedShort != 42) {
                                    i = new StringBuilder();
                                    i.append("Invalid start code: ");
                                    i.append(Integer.toHexString(readUnsignedShort));
                                    throw new IOException(i.toString());
                                }
                            }
                            readUnsignedShort = c0203a.readInt();
                            if (readUnsignedShort < 8 || readUnsignedShort >= i) {
                                i = new StringBuilder();
                                i.append("Invalid first Ifd offset: ");
                                i.append(readUnsignedShort);
                                throw new IOException(i.toString());
                            }
                            readUnsignedShort -= 8;
                            if (readUnsignedShort <= 0) {
                                return;
                            }
                            if (c0203a.skipBytes(readUnsignedShort) != readUnsignedShort) {
                                i = new StringBuilder();
                                i.append("Couldn't jump to first Ifd: ");
                                i.append(readUnsignedShort);
                                throw new IOException(i.toString());
                            }
                        }

                        /* renamed from: b */
                        private void m500b(C0203a c0203a, int i) {
                            C0207a c0207a = this;
                            C0203a c0203a2 = c0203a;
                            int i2 = i;
                            if (c0203a.f466f + 2 <= c0203a.f465e) {
                                short readShort = c0203a.readShort();
                                if (c0203a.f466f + (readShort * 12) <= c0203a.f465e) {
                                    short s = (short) 0;
                                    while (s < readShort) {
                                        long j;
                                        Object obj;
                                        int i3;
                                        short s2;
                                        int readInt;
                                        C0204b a;
                                        C0204b a2;
                                        int i4;
                                        int i5;
                                        C0204b a3;
                                        long j2;
                                        Integer num;
                                        long j3;
                                        StringBuilder stringBuilder;
                                        byte[] bArr;
                                        StringBuilder stringBuilder2;
                                        int readUnsignedShort = c0203a.readUnsignedShort();
                                        int readUnsignedShort2 = c0203a.readUnsignedShort();
                                        int readInt2 = c0203a.readInt();
                                        long a4 = ((long) c0203a.m465a()) + 4;
                                        C0205c c0205c = (C0205c) f477B[i2].get(Integer.valueOf(readUnsignedShort));
                                        StringBuilder stringBuilder3;
                                        if (c0205c == null) {
                                            stringBuilder3 = new StringBuilder();
                                            stringBuilder3.append("Skip the tag entry since tag number is not defined: ");
                                            stringBuilder3.append(readUnsignedShort);
                                            Log.w("ExifInterface", stringBuilder3.toString());
                                        } else {
                                            if (readUnsignedShort2 > 0) {
                                                if (readUnsignedShort2 < f489f.length) {
                                                    if (c0205c.m481a(readUnsignedShort2)) {
                                                        if (readUnsignedShort2 == 7) {
                                                            readUnsignedShort2 = c0205c.f472c;
                                                        }
                                                        j = ((long) readInt2) * ((long) f489f[readUnsignedShort2]);
                                                        if (j >= 0) {
                                                            if (j <= 2147483647L) {
                                                                obj = 1;
                                                                if (obj == null) {
                                                                    c0203a2.m466a(a4);
                                                                    i3 = i2;
                                                                    s2 = readShort;
                                                                } else {
                                                                    if (j > 4) {
                                                                        readInt = c0203a.readInt();
                                                                        if (c0207a.f512I == 7) {
                                                                            if ("MakerNote".equals(c0205c.f471b)) {
                                                                                c0207a.f521R = readInt;
                                                                            } else if (i2 == 6 && "ThumbnailImage".equals(c0205c.f471b)) {
                                                                                c0207a.f522S = readInt;
                                                                                c0207a.f523T = readInt2;
                                                                                a = C0204b.m469a(6, c0207a.f514K);
                                                                                s2 = readShort;
                                                                                a2 = C0204b.m470a((long) c0207a.f522S, c0207a.f514K);
                                                                                i4 = readUnsignedShort2;
                                                                                i5 = readInt2;
                                                                                a3 = C0204b.m470a((long) c0207a.f523T, c0207a.f514K);
                                                                                c0207a.f513J[4].put("Compression", a);
                                                                                c0207a.f513J[4].put("JPEGInterchangeFormat", a2);
                                                                                c0207a.f513J[4].put("JPEGInterchangeFormatLength", a3);
                                                                            }
                                                                            s2 = readShort;
                                                                            i4 = readUnsignedShort2;
                                                                            i5 = readInt2;
                                                                        } else {
                                                                            s2 = readShort;
                                                                            i4 = readUnsignedShort2;
                                                                            i5 = readInt2;
                                                                            if (c0207a.f512I == 10 && "JpgFromRaw".equals(c0205c.f471b)) {
                                                                                c0207a.f524U = readInt;
                                                                            }
                                                                        }
                                                                        j2 = (long) readInt;
                                                                        if (j2 + j <= ((long) c0203a.f465e)) {
                                                                            c0203a2.m466a(j2);
                                                                            num = (Integer) f480E.get(Integer.valueOf(readUnsignedShort));
                                                                            if (num == null) {
                                                                                j3 = -1;
                                                                                switch (i4) {
                                                                                    case 3:
                                                                                        j3 = (long) c0203a.readUnsignedShort();
                                                                                        break;
                                                                                    case 4:
                                                                                        j3 = c0203a.m468b();
                                                                                        break;
                                                                                    case 8:
                                                                                        j3 = (long) c0203a.readShort();
                                                                                        break;
                                                                                    case 9:
                                                                                    case 13:
                                                                                        j3 = (long) c0203a.readInt();
                                                                                        break;
                                                                                    default:
                                                                                        break;
                                                                                }
                                                                                if (j3 > 0 || j3 >= ((long) c0203a.f465e)) {
                                                                                    stringBuilder = new StringBuilder();
                                                                                    stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                                                    stringBuilder.append(j3);
                                                                                    Log.w("ExifInterface", stringBuilder.toString());
                                                                                } else {
                                                                                    c0203a2.m466a(j3);
                                                                                    m500b(c0203a2, num.intValue());
                                                                                }
                                                                                c0203a2.m466a(a4);
                                                                            } else {
                                                                                bArr = new byte[((int) j)];
                                                                                c0203a2.readFully(bArr);
                                                                                a3 = new C0204b(i4, i5, bArr);
                                                                                i3 = i;
                                                                                c0207a.f513J[i3].put(c0205c.f471b, a3);
                                                                                if ("DNGVersion".equals(c0205c.f471b)) {
                                                                                    c0207a.f512I = 3;
                                                                                }
                                                                                if ((("Make".equals(c0205c.f471b) || "Model".equals(c0205c.f471b)) && a3.m480c(c0207a.f514K).contains("PENTAX")) || ("Compression".equals(c0205c.f471b) && a3.m479b(c0207a.f514K) == MinElf.PN_XNUM)) {
                                                                                    c0207a.f512I = 8;
                                                                                }
                                                                                if (((long) c0203a.m465a()) != a4) {
                                                                                    c0203a2.m466a(a4);
                                                                                }
                                                                            }
                                                                        } else {
                                                                            stringBuilder2 = new StringBuilder();
                                                                            stringBuilder2.append("Skip the tag entry since data offset is invalid: ");
                                                                            stringBuilder2.append(readInt);
                                                                            Log.w("ExifInterface", stringBuilder2.toString());
                                                                            c0203a2.m466a(a4);
                                                                        }
                                                                    } else {
                                                                        s2 = readShort;
                                                                        i4 = readUnsignedShort2;
                                                                        i5 = readInt2;
                                                                        num = (Integer) f480E.get(Integer.valueOf(readUnsignedShort));
                                                                        if (num == null) {
                                                                            bArr = new byte[((int) j)];
                                                                            c0203a2.readFully(bArr);
                                                                            a3 = new C0204b(i4, i5, bArr);
                                                                            i3 = i;
                                                                            c0207a.f513J[i3].put(c0205c.f471b, a3);
                                                                            if ("DNGVersion".equals(c0205c.f471b)) {
                                                                                c0207a.f512I = 3;
                                                                            }
                                                                            c0207a.f512I = 8;
                                                                            if (((long) c0203a.m465a()) != a4) {
                                                                                c0203a2.m466a(a4);
                                                                            }
                                                                        } else {
                                                                            j3 = -1;
                                                                            switch (i4) {
                                                                                case 3:
                                                                                    j3 = (long) c0203a.readUnsignedShort();
                                                                                    break;
                                                                                case 4:
                                                                                    j3 = c0203a.m468b();
                                                                                    break;
                                                                                case 8:
                                                                                    j3 = (long) c0203a.readShort();
                                                                                    break;
                                                                                case 9:
                                                                                case 13:
                                                                                    j3 = (long) c0203a.readInt();
                                                                                    break;
                                                                                default:
                                                                                    break;
                                                                            }
                                                                            if (j3 > 0) {
                                                                            }
                                                                            stringBuilder = new StringBuilder();
                                                                            stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                                            stringBuilder.append(j3);
                                                                            Log.w("ExifInterface", stringBuilder.toString());
                                                                            c0203a2.m466a(a4);
                                                                        }
                                                                    }
                                                                    i3 = i;
                                                                }
                                                                s = (short) (s + 1);
                                                                i2 = i3;
                                                                readShort = s2;
                                                            }
                                                        }
                                                        StringBuilder stringBuilder4 = new StringBuilder();
                                                        stringBuilder4.append("Skip the tag entry since the number of components is invalid: ");
                                                        stringBuilder4.append(readInt2);
                                                        Log.w("ExifInterface", stringBuilder4.toString());
                                                        obj = null;
                                                        if (obj == null) {
                                                            if (j > 4) {
                                                                s2 = readShort;
                                                                i4 = readUnsignedShort2;
                                                                i5 = readInt2;
                                                                num = (Integer) f480E.get(Integer.valueOf(readUnsignedShort));
                                                                if (num == null) {
                                                                    j3 = -1;
                                                                    switch (i4) {
                                                                        case 3:
                                                                            j3 = (long) c0203a.readUnsignedShort();
                                                                            break;
                                                                        case 4:
                                                                            j3 = c0203a.m468b();
                                                                            break;
                                                                        case 8:
                                                                            j3 = (long) c0203a.readShort();
                                                                            break;
                                                                        case 9:
                                                                        case 13:
                                                                            j3 = (long) c0203a.readInt();
                                                                            break;
                                                                        default:
                                                                            break;
                                                                    }
                                                                    if (j3 > 0) {
                                                                    }
                                                                    stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                                    stringBuilder.append(j3);
                                                                    Log.w("ExifInterface", stringBuilder.toString());
                                                                    c0203a2.m466a(a4);
                                                                } else {
                                                                    bArr = new byte[((int) j)];
                                                                    c0203a2.readFully(bArr);
                                                                    a3 = new C0204b(i4, i5, bArr);
                                                                    i3 = i;
                                                                    c0207a.f513J[i3].put(c0205c.f471b, a3);
                                                                    if ("DNGVersion".equals(c0205c.f471b)) {
                                                                        c0207a.f512I = 3;
                                                                    }
                                                                    c0207a.f512I = 8;
                                                                    if (((long) c0203a.m465a()) != a4) {
                                                                        c0203a2.m466a(a4);
                                                                    }
                                                                }
                                                            } else {
                                                                readInt = c0203a.readInt();
                                                                if (c0207a.f512I == 7) {
                                                                    s2 = readShort;
                                                                    i4 = readUnsignedShort2;
                                                                    i5 = readInt2;
                                                                    c0207a.f524U = readInt;
                                                                } else {
                                                                    if ("MakerNote".equals(c0205c.f471b)) {
                                                                        c0207a.f522S = readInt;
                                                                        c0207a.f523T = readInt2;
                                                                        a = C0204b.m469a(6, c0207a.f514K);
                                                                        s2 = readShort;
                                                                        a2 = C0204b.m470a((long) c0207a.f522S, c0207a.f514K);
                                                                        i4 = readUnsignedShort2;
                                                                        i5 = readInt2;
                                                                        a3 = C0204b.m470a((long) c0207a.f523T, c0207a.f514K);
                                                                        c0207a.f513J[4].put("Compression", a);
                                                                        c0207a.f513J[4].put("JPEGInterchangeFormat", a2);
                                                                        c0207a.f513J[4].put("JPEGInterchangeFormatLength", a3);
                                                                    } else {
                                                                        c0207a.f521R = readInt;
                                                                    }
                                                                    s2 = readShort;
                                                                    i4 = readUnsignedShort2;
                                                                    i5 = readInt2;
                                                                }
                                                                j2 = (long) readInt;
                                                                if (j2 + j <= ((long) c0203a.f465e)) {
                                                                    stringBuilder2 = new StringBuilder();
                                                                    stringBuilder2.append("Skip the tag entry since data offset is invalid: ");
                                                                    stringBuilder2.append(readInt);
                                                                    Log.w("ExifInterface", stringBuilder2.toString());
                                                                    c0203a2.m466a(a4);
                                                                } else {
                                                                    c0203a2.m466a(j2);
                                                                    num = (Integer) f480E.get(Integer.valueOf(readUnsignedShort));
                                                                    if (num == null) {
                                                                        bArr = new byte[((int) j)];
                                                                        c0203a2.readFully(bArr);
                                                                        a3 = new C0204b(i4, i5, bArr);
                                                                        i3 = i;
                                                                        c0207a.f513J[i3].put(c0205c.f471b, a3);
                                                                        if ("DNGVersion".equals(c0205c.f471b)) {
                                                                            c0207a.f512I = 3;
                                                                        }
                                                                        c0207a.f512I = 8;
                                                                        if (((long) c0203a.m465a()) != a4) {
                                                                            c0203a2.m466a(a4);
                                                                        }
                                                                    } else {
                                                                        j3 = -1;
                                                                        switch (i4) {
                                                                            case 3:
                                                                                j3 = (long) c0203a.readUnsignedShort();
                                                                                break;
                                                                            case 4:
                                                                                j3 = c0203a.m468b();
                                                                                break;
                                                                            case 8:
                                                                                j3 = (long) c0203a.readShort();
                                                                                break;
                                                                            case 9:
                                                                            case 13:
                                                                                j3 = (long) c0203a.readInt();
                                                                                break;
                                                                            default:
                                                                                break;
                                                                        }
                                                                        if (j3 > 0) {
                                                                        }
                                                                        stringBuilder = new StringBuilder();
                                                                        stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                                        stringBuilder.append(j3);
                                                                        Log.w("ExifInterface", stringBuilder.toString());
                                                                        c0203a2.m466a(a4);
                                                                    }
                                                                }
                                                            }
                                                            i3 = i;
                                                        } else {
                                                            c0203a2.m466a(a4);
                                                            i3 = i2;
                                                            s2 = readShort;
                                                        }
                                                        s = (short) (s + 1);
                                                        i2 = i3;
                                                        readShort = s2;
                                                    } else {
                                                        stringBuilder3 = new StringBuilder();
                                                        stringBuilder3.append("Skip the tag entry since data format (");
                                                        stringBuilder3.append(f488e[readUnsignedShort2]);
                                                        stringBuilder3.append(") is unexpected for tag: ");
                                                        stringBuilder3.append(c0205c.f471b);
                                                        Log.w("ExifInterface", stringBuilder3.toString());
                                                    }
                                                }
                                            }
                                            stringBuilder3 = new StringBuilder();
                                            stringBuilder3.append("Skip the tag entry since data format is invalid: ");
                                            stringBuilder3.append(readUnsignedShort2);
                                            Log.w("ExifInterface", stringBuilder3.toString());
                                        }
                                        j = 0;
                                        obj = null;
                                        if (obj == null) {
                                            c0203a2.m466a(a4);
                                            i3 = i2;
                                            s2 = readShort;
                                        } else {
                                            if (j > 4) {
                                                readInt = c0203a.readInt();
                                                if (c0207a.f512I == 7) {
                                                    if ("MakerNote".equals(c0205c.f471b)) {
                                                        c0207a.f521R = readInt;
                                                    } else {
                                                        c0207a.f522S = readInt;
                                                        c0207a.f523T = readInt2;
                                                        a = C0204b.m469a(6, c0207a.f514K);
                                                        s2 = readShort;
                                                        a2 = C0204b.m470a((long) c0207a.f522S, c0207a.f514K);
                                                        i4 = readUnsignedShort2;
                                                        i5 = readInt2;
                                                        a3 = C0204b.m470a((long) c0207a.f523T, c0207a.f514K);
                                                        c0207a.f513J[4].put("Compression", a);
                                                        c0207a.f513J[4].put("JPEGInterchangeFormat", a2);
                                                        c0207a.f513J[4].put("JPEGInterchangeFormatLength", a3);
                                                    }
                                                    s2 = readShort;
                                                    i4 = readUnsignedShort2;
                                                    i5 = readInt2;
                                                } else {
                                                    s2 = readShort;
                                                    i4 = readUnsignedShort2;
                                                    i5 = readInt2;
                                                    c0207a.f524U = readInt;
                                                }
                                                j2 = (long) readInt;
                                                if (j2 + j <= ((long) c0203a.f465e)) {
                                                    c0203a2.m466a(j2);
                                                    num = (Integer) f480E.get(Integer.valueOf(readUnsignedShort));
                                                    if (num == null) {
                                                        j3 = -1;
                                                        switch (i4) {
                                                            case 3:
                                                                j3 = (long) c0203a.readUnsignedShort();
                                                                break;
                                                            case 4:
                                                                j3 = c0203a.m468b();
                                                                break;
                                                            case 8:
                                                                j3 = (long) c0203a.readShort();
                                                                break;
                                                            case 9:
                                                            case 13:
                                                                j3 = (long) c0203a.readInt();
                                                                break;
                                                            default:
                                                                break;
                                                        }
                                                        if (j3 > 0) {
                                                        }
                                                        stringBuilder = new StringBuilder();
                                                        stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                        stringBuilder.append(j3);
                                                        Log.w("ExifInterface", stringBuilder.toString());
                                                        c0203a2.m466a(a4);
                                                    } else {
                                                        bArr = new byte[((int) j)];
                                                        c0203a2.readFully(bArr);
                                                        a3 = new C0204b(i4, i5, bArr);
                                                        i3 = i;
                                                        c0207a.f513J[i3].put(c0205c.f471b, a3);
                                                        if ("DNGVersion".equals(c0205c.f471b)) {
                                                            c0207a.f512I = 3;
                                                        }
                                                        c0207a.f512I = 8;
                                                        if (((long) c0203a.m465a()) != a4) {
                                                            c0203a2.m466a(a4);
                                                        }
                                                    }
                                                } else {
                                                    stringBuilder2 = new StringBuilder();
                                                    stringBuilder2.append("Skip the tag entry since data offset is invalid: ");
                                                    stringBuilder2.append(readInt);
                                                    Log.w("ExifInterface", stringBuilder2.toString());
                                                    c0203a2.m466a(a4);
                                                }
                                            } else {
                                                s2 = readShort;
                                                i4 = readUnsignedShort2;
                                                i5 = readInt2;
                                                num = (Integer) f480E.get(Integer.valueOf(readUnsignedShort));
                                                if (num == null) {
                                                    bArr = new byte[((int) j)];
                                                    c0203a2.readFully(bArr);
                                                    a3 = new C0204b(i4, i5, bArr);
                                                    i3 = i;
                                                    c0207a.f513J[i3].put(c0205c.f471b, a3);
                                                    if ("DNGVersion".equals(c0205c.f471b)) {
                                                        c0207a.f512I = 3;
                                                    }
                                                    c0207a.f512I = 8;
                                                    if (((long) c0203a.m465a()) != a4) {
                                                        c0203a2.m466a(a4);
                                                    }
                                                } else {
                                                    j3 = -1;
                                                    switch (i4) {
                                                        case 3:
                                                            j3 = (long) c0203a.readUnsignedShort();
                                                            break;
                                                        case 4:
                                                            j3 = c0203a.m468b();
                                                            break;
                                                        case 8:
                                                            j3 = (long) c0203a.readShort();
                                                            break;
                                                        case 9:
                                                        case 13:
                                                            j3 = (long) c0203a.readInt();
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                    if (j3 > 0) {
                                                    }
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append("Skip jump into the IFD since its offset is invalid: ");
                                                    stringBuilder.append(j3);
                                                    Log.w("ExifInterface", stringBuilder.toString());
                                                    c0203a2.m466a(a4);
                                                }
                                            }
                                            i3 = i;
                                        }
                                        s = (short) (s + 1);
                                        i2 = i3;
                                        readShort = s2;
                                    }
                                    if (c0203a.m465a() + 4 <= c0203a.f465e) {
                                        i2 = c0203a.readInt();
                                        if (i2 > 8 && i2 < c0203a.f465e) {
                                            c0203a2.m466a((long) i2);
                                            if (c0207a.f513J[4].isEmpty()) {
                                                m500b(c0203a2, 4);
                                            } else if (c0207a.f513J[5].isEmpty()) {
                                                m500b(c0203a2, 5);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        /* renamed from: c */
                        private void m506c(C0203a c0203a, int i) {
                            C0204b c0204b = (C0204b) this.f513J[i].get("ImageWidth");
                            if (((C0204b) this.f513J[i].get("ImageLength")) == null || c0204b == null) {
                                C0204b c0204b2 = (C0204b) this.f513J[i].get("JPEGInterchangeFormat");
                                if (c0204b2 != null) {
                                    m489a(c0203a, c0204b2.m479b(this.f514K), i);
                                }
                            }
                        }

                        /* renamed from: f */
                        private void m514f(C0203a c0203a) {
                            HashMap hashMap = this.f513J[4];
                            C0204b c0204b = (C0204b) hashMap.get("Compression");
                            if (c0204b != null) {
                                this.f519P = c0204b.m479b(this.f514K);
                                int i = this.f519P;
                                if (i != 1) {
                                    switch (i) {
                                        case 6:
                                            m490a(c0203a, hashMap);
                                            return;
                                        case 7:
                                            break;
                                        default:
                                            return;
                                    }
                                }
                                if (m494a(hashMap)) {
                                    m501b(c0203a, hashMap);
                                    return;
                                }
                                return;
                            }
                            this.f519P = 6;
                            m490a(c0203a, hashMap);
                        }

                        /* renamed from: a */
                        private void m490a(C0203a c0203a, HashMap hashMap) {
                            C0204b c0204b = (C0204b) hashMap.get("JPEGInterchangeFormat");
                            C0204b c0204b2 = (C0204b) hashMap.get("JPEGInterchangeFormatLength");
                            if (c0204b != null && c0204b2 != null) {
                                int b = c0204b.m479b(this.f514K);
                                hashMap = Math.min(c0204b2.m479b(this.f514K), c0203a.available() - b);
                                if (!(this.f512I == 4 || this.f512I == 9)) {
                                    if (this.f512I != 10) {
                                        if (this.f512I == 7) {
                                            b += this.f521R;
                                        }
                                        if (b > 0 && hashMap > null) {
                                            this.f515L = true;
                                            this.f516M = b;
                                            this.f517N = hashMap;
                                            if (this.f510G == null && this.f511H == null) {
                                                hashMap = new byte[hashMap];
                                                c0203a.m466a((long) b);
                                                c0203a.readFully(hashMap);
                                                this.f518O = hashMap;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                b += this.f520Q;
                                if (b > 0) {
                                }
                            }
                        }

                        /* renamed from: b */
                        private void m501b(C0203a c0203a, HashMap hashMap) {
                            C0204b c0204b = (C0204b) hashMap.get("StripOffsets");
                            C0204b c0204b2 = (C0204b) hashMap.get("StripByteCounts");
                            if (!(c0204b == null || c0204b2 == null)) {
                                long[] a = C0207a.m496a(c0204b.m477d(this.f514K));
                                hashMap = C0207a.m496a(c0204b2.m477d(this.f514K));
                                if (a == null) {
                                    Log.w("ExifInterface", "stripOffsets should not be null.");
                                } else if (hashMap == null) {
                                    Log.w("ExifInterface", "stripByteCounts should not be null.");
                                } else {
                                    long j = 0;
                                    for (long j2 : hashMap) {
                                        j += j2;
                                    }
                                    Object obj = new byte[((int) j)];
                                    int i = 0;
                                    int i2 = 0;
                                    for (int i3 = 0; i3 < a.length; i3++) {
                                        int i4 = (int) hashMap[i3];
                                        int i5 = ((int) a[i3]) - i;
                                        if (i5 < 0) {
                                            Log.d("ExifInterface", "Invalid strip offset value");
                                        }
                                        c0203a.m466a((long) i5);
                                        i += i5;
                                        Object obj2 = new byte[i4];
                                        c0203a.read(obj2);
                                        i += i4;
                                        System.arraycopy(obj2, 0, obj, i2, obj2.length);
                                        i2 += obj2.length;
                                    }
                                    this.f515L = true;
                                    this.f518O = obj;
                                    this.f517N = obj.length;
                                }
                            }
                        }

                        /* renamed from: a */
                        private boolean m494a(HashMap hashMap) {
                            C0204b c0204b = (C0204b) hashMap.get("BitsPerSample");
                            if (c0204b != null) {
                                int[] iArr = (int[]) c0204b.m477d(this.f514K);
                                if (Arrays.equals(f484a, iArr)) {
                                    return true;
                                }
                                if (this.f512I == 3) {
                                    C0204b c0204b2 = (C0204b) hashMap.get("PhotometricInterpretation");
                                    if (c0204b2 != null) {
                                        hashMap = c0204b2.m479b(this.f514K);
                                        if ((hashMap == 1 && Arrays.equals(iArr, f486c)) || (hashMap == 6 && Arrays.equals(iArr, f484a) != null)) {
                                            return true;
                                        }
                                    }
                                }
                            }
                            return null;
                        }

                        /* renamed from: b */
                        private boolean m503b(HashMap hashMap) {
                            C0204b c0204b = (C0204b) hashMap.get("ImageLength");
                            C0204b c0204b2 = (C0204b) hashMap.get("ImageWidth");
                            if (!(c0204b == null || c0204b2 == null)) {
                                int b = c0204b.m479b(this.f514K);
                                hashMap = c0204b2.m479b(this.f514K);
                                if (b <= 512 && hashMap <= 512) {
                                    return true;
                                }
                            }
                            return null;
                        }

                        /* renamed from: b */
                        private void m502b(InputStream inputStream) {
                            m486a(0, 5);
                            m486a(0, 4);
                            m486a(5, 4);
                            C0204b c0204b = (C0204b) this.f513J[1].get("PixelXDimension");
                            C0204b c0204b2 = (C0204b) this.f513J[1].get("PixelYDimension");
                            if (!(c0204b == null || c0204b2 == null)) {
                                this.f513J[0].put("ImageWidth", c0204b);
                                this.f513J[0].put("ImageLength", c0204b2);
                            }
                            if (!(this.f513J[4].isEmpty() == null || m503b(this.f513J[5]) == null)) {
                                this.f513J[4] = this.f513J[5];
                                this.f513J[5] = new HashMap();
                            }
                            if (m503b(this.f513J[4]) == null) {
                                Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
                            }
                        }

                        /* renamed from: d */
                        private void m511d(C0203a c0203a, int i) {
                            C0204b c0204b = (C0204b) this.f513J[i].get("DefaultCropSize");
                            C0204b c0204b2 = (C0204b) this.f513J[i].get("SensorTopBorder");
                            C0204b c0204b3 = (C0204b) this.f513J[i].get("SensorLeftBorder");
                            C0204b c0204b4 = (C0204b) this.f513J[i].get("SensorBottomBorder");
                            C0204b c0204b5 = (C0204b) this.f513J[i].get("SensorRightBorder");
                            if (c0204b != null) {
                                Object a;
                                StringBuilder stringBuilder;
                                if (c0204b.f467a == 5) {
                                    C0206d[] c0206dArr = (C0206d[]) c0204b.m477d(this.f514K);
                                    if (c0206dArr != null) {
                                        if (c0206dArr.length == 2) {
                                            a = C0204b.m471a(c0206dArr[0], this.f514K);
                                            c0203a = C0204b.m471a(c0206dArr[1], this.f514K);
                                        }
                                    }
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid crop size values. cropSize=");
                                    stringBuilder.append(Arrays.toString(c0206dArr));
                                    Log.w("ExifInterface", stringBuilder.toString());
                                    return;
                                }
                                int[] iArr = (int[]) c0204b.m477d(this.f514K);
                                if (iArr != null) {
                                    if (iArr.length == 2) {
                                        a = C0204b.m469a(iArr[0], this.f514K);
                                        c0203a = C0204b.m469a(iArr[1], this.f514K);
                                    }
                                }
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Invalid crop size values. cropSize=");
                                stringBuilder.append(Arrays.toString(iArr));
                                Log.w("ExifInterface", stringBuilder.toString());
                                return;
                                this.f513J[i].put("ImageWidth", a);
                                this.f513J[i].put("ImageLength", c0203a);
                            } else if (c0204b2 == null || c0204b3 == null || c0204b4 == null || c0204b5 == null) {
                                m506c(c0203a, i);
                            } else {
                                c0203a = c0204b2.m479b(this.f514K);
                                int b = c0204b4.m479b(this.f514K);
                                int b2 = c0204b5.m479b(this.f514K);
                                int b3 = c0204b3.m479b(this.f514K);
                                if (b > c0203a && b2 > b3) {
                                    b2 -= b3;
                                    c0203a = C0204b.m469a(b - c0203a, this.f514K);
                                    c0204b = C0204b.m469a(b2, this.f514K);
                                    this.f513J[i].put("ImageLength", c0203a);
                                    this.f513J[i].put("ImageWidth", c0204b);
                                }
                            }
                        }

                        /* renamed from: a */
                        private void m486a(int i, int i2) {
                            if (!this.f513J[i].isEmpty()) {
                                if (!this.f513J[i2].isEmpty()) {
                                    C0204b c0204b = (C0204b) this.f513J[i].get("ImageLength");
                                    C0204b c0204b2 = (C0204b) this.f513J[i].get("ImageWidth");
                                    C0204b c0204b3 = (C0204b) this.f513J[i2].get("ImageLength");
                                    C0204b c0204b4 = (C0204b) this.f513J[i2].get("ImageWidth");
                                    if (c0204b != null) {
                                        if (c0204b2 != null) {
                                            if (c0204b3 != null) {
                                                if (c0204b4 != null) {
                                                    int b = c0204b.m479b(this.f514K);
                                                    int b2 = c0204b2.m479b(this.f514K);
                                                    int b3 = c0204b3.m479b(this.f514K);
                                                    int b4 = c0204b4.m479b(this.f514K);
                                                    if (b < b3 && b2 < b4) {
                                                        HashMap hashMap = this.f513J[i];
                                                        this.f513J[i] = this.f513J[i2];
                                                        this.f513J[i2] = hashMap;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        /* renamed from: a */
                        private static void m491a(java.io.Closeable r0) {
                            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                            /*
                            if (r0 == 0) goto L_0x0008;
                        L_0x0002:
                            r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
                            goto L_0x0008;
                        L_0x0006:
                            r0 = move-exception;
                            throw r0;
                        L_0x0008:
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.e.a.a(java.io.Closeable):void");
                        }

                        /* renamed from: a */
                        private static long[] m496a(Object obj) {
                            if (!(obj instanceof int[])) {
                                return obj instanceof long[] ? (long[]) obj : null;
                            } else {
                                int[] iArr = (int[]) obj;
                                long[] jArr = new long[iArr.length];
                                for (int i = 0; i < iArr.length; i++) {
                                    jArr[i] = (long) iArr[i];
                                }
                                return jArr;
                            }
                        }
                    }
