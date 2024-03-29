package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.io.InputStream;

public class ProgressiveJpegParser {
    private static final int BUFFER_SIZE = 16384;
    private static final int NOT_A_JPEG = 6;
    private static final int READ_FIRST_JPEG_BYTE = 0;
    private static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
    private static final int READ_MARKER_SECOND_BYTE = 3;
    private static final int READ_SECOND_JPEG_BYTE = 1;
    private static final int READ_SIZE_FIRST_BYTE = 4;
    private static final int READ_SIZE_SECOND_BYTE = 5;
    private int mBestScanEndOffset = 0;
    private int mBestScanNumber = 0;
    private final ByteArrayPool mByteArrayPool;
    private int mBytesParsed = 0;
    private boolean mEndMarkerRead;
    private int mLastByteRead = 0;
    private int mNextFullScanNumber = 0;
    private int mParserState = 0;

    private static boolean doesMarkerStartSegment(int i) {
        boolean z = true;
        if (i == 1) {
            return false;
        }
        if (i >= JfifUtil.MARKER_RST0 && i <= JfifUtil.MARKER_RST7) {
            return false;
        }
        if (i == JfifUtil.MARKER_EOI || i == JfifUtil.MARKER_SOI) {
            z = false;
        }
        return z;
    }

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
    }

    public boolean parseMoreData(EncodedImage encodedImage) {
        if (this.mParserState == 6 || encodedImage.getSize() <= this.mBytesParsed) {
            return false;
        }
        InputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage.getInputStream(), (byte[]) this.mByteArrayPool.get(BUFFER_SIZE), this.mByteArrayPool);
        try {
            StreamUtil.skip(pooledByteArrayBufferedInputStream, (long) this.mBytesParsed);
            encodedImage = doParseMoreData(pooledByteArrayBufferedInputStream);
            return encodedImage;
        } catch (IOException e) {
            encodedImage = e;
            Throwables.propagate(encodedImage);
            return false;
        } finally {
            Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
        }
    }

    private boolean doParseMoreData(InputStream inputStream) {
        int i = this.mBestScanNumber;
        while (true) {
            boolean z = true;
            try {
                if (this.mParserState != 6) {
                    int read = inputStream.read();
                    if (read != -1) {
                        this.mBytesParsed++;
                        if (this.mEndMarkerRead) {
                            this.mParserState = 6;
                            this.mEndMarkerRead = false;
                            return false;
                        }
                        switch (this.mParserState) {
                            case 0:
                                if (read != JfifUtil.MARKER_FIRST_BYTE) {
                                    this.mParserState = 6;
                                    break;
                                }
                                this.mParserState = 1;
                                break;
                            case 1:
                                if (read != JfifUtil.MARKER_SOI) {
                                    this.mParserState = 6;
                                    break;
                                }
                                this.mParserState = 2;
                                break;
                            case 2:
                                if (read == JfifUtil.MARKER_FIRST_BYTE) {
                                    this.mParserState = 3;
                                    break;
                                }
                                break;
                            case 3:
                                if (read != JfifUtil.MARKER_FIRST_BYTE) {
                                    if (read != 0) {
                                        if (read != JfifUtil.MARKER_EOI) {
                                            if (read == JfifUtil.MARKER_SOS) {
                                                newScanOrImageEndFound(this.mBytesParsed - 2);
                                            }
                                            if (!doesMarkerStartSegment(read)) {
                                                this.mParserState = 2;
                                                break;
                                            }
                                            this.mParserState = 4;
                                            break;
                                        }
                                        this.mEndMarkerRead = true;
                                        newScanOrImageEndFound(this.mBytesParsed - 2);
                                        this.mParserState = 2;
                                        break;
                                    }
                                    this.mParserState = 2;
                                    break;
                                }
                                this.mParserState = 3;
                                break;
                            case 4:
                                this.mParserState = 5;
                                break;
                            case 5:
                                int i2 = ((this.mLastByteRead << 8) + read) - 2;
                                StreamUtil.skip(inputStream, (long) i2);
                                this.mBytesParsed += i2;
                                this.mParserState = 2;
                                break;
                            default:
                                Preconditions.checkState(false);
                                break;
                        }
                        this.mLastByteRead = read;
                    }
                }
            } catch (InputStream inputStream2) {
                Throwables.propagate(inputStream2);
            }
            if (this.mParserState == 6 || this.mBestScanNumber == i) {
                z = false;
            }
            return z;
        }
    }

    private void newScanOrImageEndFound(int i) {
        if (this.mNextFullScanNumber > 0) {
            this.mBestScanEndOffset = i;
        }
        i = this.mNextFullScanNumber;
        this.mNextFullScanNumber = i + 1;
        this.mBestScanNumber = i;
    }

    public boolean isJpeg() {
        return this.mBytesParsed > 1 && this.mParserState != 6;
    }

    public int getBestScanEndOffset() {
        return this.mBestScanEndOffset;
    }

    public int getBestScanNumber() {
        return this.mBestScanNumber;
    }

    public boolean isEndMarkerRead() {
        return this.mEndMarkerRead;
    }
}
