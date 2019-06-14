package expo.modules.gl;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES30;
import expo.modules.gl.cpp.EXGL;
import expo.p307b.p309b.C6022a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GLCameraObject extends GLObject implements OnFrameAvailableListener {
    private static String fragmentShaderSource = "#extension GL_OES_EGL_image_external : require\nprecision highp float;uniform samplerExternalOES cameraTexture;varying vec2 coords;void main() {  gl_FragColor = texture2D(cameraTexture, coords);}";
    private static String vertexShaderSource = "precision highp float;attribute vec4 position;uniform mat4 transformMatrix;varying vec2 coords;void main() {  vec2 clipSpace = (1.0 - 2.0 * position.xy);  coords = (transformMatrix * position).xy;  gl_Position = vec4(clipSpace, 0.0, 1.0);}";
    private SurfaceTexture mCameraSurfaceTexture;
    private C6022a mCameraView;
    private int mDestTexture;
    private int mExtTexture;
    private int mFramebuffer;
    private GLContext mGLContext;
    private int mProgram;
    private int mTextureHeight = -1;
    private int mTextureWidth = -1;
    private int mVertexArray;
    private int mVertexBuffer;
    private float[] textureCoords = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    GLCameraObject(GLContext gLContext, C6022a c6022a) {
        super(gLContext.getContextId());
        this.mGLContext = gLContext;
        this.mCameraView = c6022a;
        c6022a = new int[2];
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        int glCreateProgram = GLES30.glCreateProgram();
        int glCreateShader = GLES30.glCreateShader(35633);
        int glCreateShader2 = GLES30.glCreateShader(35632);
        GLES30.glShaderSource(glCreateShader, vertexShaderSource);
        GLES30.glShaderSource(glCreateShader2, fragmentShaderSource);
        GLES30.glCompileShader(glCreateShader);
        GLES30.glCompileShader(glCreateShader2);
        GLES30.glAttachShader(glCreateProgram, glCreateShader);
        GLES30.glAttachShader(glCreateProgram, glCreateShader2);
        GLES30.glLinkProgram(glCreateProgram);
        GLES30.glGenTextures(2, c6022a, 0);
        GLES30.glGenFramebuffers(1, iArr, 0);
        GLES30.glGenBuffers(1, iArr2, 0);
        GLES30.glGenVertexArrays(1, iArr3, 0);
        this.mProgram = glCreateProgram;
        this.mExtTexture = c6022a[0];
        this.mDestTexture = c6022a[1];
        this.mFramebuffer = iArr[0];
        this.mVertexBuffer = iArr2[0];
        this.mVertexArray = iArr3[0];
        EXGL.EXGLContextMapObject(this.exglCtxId, this.exglObjId, this.mDestTexture);
        this.mCameraSurfaceTexture = new SurfaceTexture(this.mExtTexture);
        this.mCameraSurfaceTexture.setOnFrameAvailableListener(this);
        this.mCameraView.setPreviewTexture(this.mCameraSurfaceTexture);
    }

    private FloatBuffer setupVertexBuffer() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(this.textureCoords);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        surfaceTexture = this.mCameraView.getPreviewSizeAsArray();
        final int i = surfaceTexture[0];
        surfaceTexture = surfaceTexture[1];
        this.mGLContext.runAsync(new Runnable() {
            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r29 = this;
                r0 = r29;
                r1 = expo.modules.gl.GLCameraObject.this;
                r1 = r1.mCameraSurfaceTexture;
                if (r1 != 0) goto L_0x000b;
            L_0x000a:
                return;
            L_0x000b:
                r1 = 1;
                r2 = new int[r1];
                r3 = new int[r1];
                r4 = new int[r1];
                r5 = new int[r1];
                r6 = new int[r1];
                r7 = 4;
                r8 = new int[r7];
                r9 = 16;
                r9 = new float[r9];
                r10 = 36006; // 0x8ca6 float:5.0455E-41 double:1.77893E-319;
                r11 = 0;
                android.opengl.GLES30.glGetIntegerv(r10, r2, r11);
                r10 = 35725; // 0x8b8d float:5.0061E-41 double:1.76505E-319;
                android.opengl.GLES30.glGetIntegerv(r10, r3, r11);
                r10 = 34016; // 0x84e0 float:4.7667E-41 double:1.6806E-319;
                android.opengl.GLES30.glGetIntegerv(r10, r4, r11);
                r10 = 32873; // 0x8069 float:4.6065E-41 double:1.62414E-319;
                android.opengl.GLES30.glGetIntegerv(r10, r5, r11);
                r10 = 34229; // 0x85b5 float:4.7965E-41 double:1.69114E-319;
                android.opengl.GLES30.glGetIntegerv(r10, r6, r11);
                r10 = 2978; // 0xba2 float:4.173E-42 double:1.4713E-320;
                android.opengl.GLES30.glGetIntegerv(r10, r8, r11);
                r10 = expo.modules.gl.GLCameraObject.this;
                r10 = r10.mProgram;
                android.opengl.GLES30.glUseProgram(r10);
                r10 = expo.modules.gl.GLCameraObject.this;
                r10 = r10.mVertexArray;
                android.opengl.GLES30.glBindVertexArray(r10);
                r10 = expo.modules.gl.GLCameraObject.this;
                r10 = r10.mFramebuffer;
                r12 = 36009; // 0x8ca9 float:5.046E-41 double:1.7791E-319;
                android.opengl.GLES30.glBindFramebuffer(r12, r10);
                r10 = expo.modules.gl.GLCameraObject.this;
                r10 = r10.mProgram;
                r13 = "position";
                r14 = android.opengl.GLES30.glGetAttribLocation(r10, r13);
                r10 = expo.modules.gl.GLCameraObject.this;
                r10 = r10.mProgram;
                r13 = "transformMatrix";
                r10 = android.opengl.GLES30.glGetUniformLocation(r10, r13);
                r13 = expo.modules.gl.GLCameraObject.this;
                r13 = r13.mProgram;
                r15 = "cameraTexture";
                r13 = android.opengl.GLES30.glGetUniformLocation(r13, r15);
                r15 = expo.modules.gl.GLCameraObject.this;
                r15 = r15.mTextureWidth;
                r1 = -1;
                r7 = 36197; // 0x8d65 float:5.0723E-41 double:1.78837E-319;
                r11 = 3553; // 0xde1 float:4.979E-42 double:1.7554E-320;
                if (r15 != r1) goto L_0x010f;
            L_0x0091:
                r1 = expo.modules.gl.GLCameraObject.this;
                r1 = r1.mExtTexture;
                android.opengl.GLES30.glBindTexture(r7, r1);
                r1 = 10242; // 0x2802 float:1.4352E-41 double:5.06E-320;
                r15 = 33071; // 0x812f float:4.6342E-41 double:1.6339E-319;
                android.opengl.GLES30.glTexParameteri(r7, r1, r15);
                r12 = 10243; // 0x2803 float:1.4354E-41 double:5.0607E-320;
                android.opengl.GLES30.glTexParameteri(r7, r12, r15);
                r12 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
                r1 = 9729; // 0x2601 float:1.3633E-41 double:4.807E-320;
                android.opengl.GLES30.glTexParameteri(r7, r12, r1);
                r12 = 10241; // 0x2801 float:1.435E-41 double:5.0597E-320;
                android.opengl.GLES30.glTexParameteri(r7, r12, r1);
                r7 = expo.modules.gl.GLCameraObject.this;
                r7 = r7.mDestTexture;
                android.opengl.GLES30.glBindTexture(r11, r7);
                r7 = 10242; // 0x2802 float:1.4352E-41 double:5.06E-320;
                android.opengl.GLES30.glTexParameteri(r11, r7, r15);
                r7 = 10243; // 0x2803 float:1.4354E-41 double:5.0607E-320;
                android.opengl.GLES30.glTexParameteri(r11, r7, r15);
                r7 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
                android.opengl.GLES30.glTexParameteri(r11, r7, r1);
                android.opengl.GLES30.glTexParameteri(r11, r12, r1);
                r1 = 36064; // 0x8ce0 float:5.0536E-41 double:1.7818E-319;
                r7 = expo.modules.gl.GLCameraObject.this;
                r7 = r7.mDestTexture;
                r12 = 0;
                r15 = 36009; // 0x8ca9 float:5.046E-41 double:1.7791E-319;
                android.opengl.GLES30.glFramebufferTexture2D(r15, r1, r11, r7, r12);
                r1 = expo.modules.gl.GLCameraObject.this;
                r1 = r1.setupVertexBuffer();
                r7 = expo.modules.gl.GLCameraObject.this;
                r7 = r7.mVertexBuffer;
                r12 = 34962; // 0x8892 float:4.8992E-41 double:1.72735E-319;
                android.opengl.GLES30.glBindBuffer(r12, r7);
                r7 = expo.modules.gl.GLCameraObject.this;
                r7 = r7.textureCoords;
                r7 = r7.length;
                r15 = 4;
                r7 = r7 * 4;
                r15 = 35044; // 0x88e4 float:4.9107E-41 double:1.7314E-319;
                android.opengl.GLES30.glBufferData(r12, r7, r1, r15);
                android.opengl.GLES30.glEnableVertexAttribArray(r14);
                r15 = 2;
                r16 = 5126; // 0x1406 float:7.183E-42 double:2.5326E-320;
                r17 = 0;
                r18 = 8;
                r19 = 0;
                android.opengl.GLES30.glVertexAttribPointer(r14, r15, r16, r17, r18, r19);
            L_0x010f:
                r1 = expo.modules.gl.GLCameraObject.this;
                r1 = r1.mTextureWidth;
                r7 = r0;
                if (r1 != r7) goto L_0x0123;
            L_0x0119:
                r1 = expo.modules.gl.GLCameraObject.this;
                r1 = r1.mTextureHeight;
                r7 = r4;
                if (r1 == r7) goto L_0x0164;
            L_0x0123:
                r1 = expo.modules.gl.GLCameraObject.this;
                r7 = r0;
                r1.mTextureWidth = r7;
                r1 = expo.modules.gl.GLCameraObject.this;
                r7 = r4;
                r1.mTextureHeight = r7;
                r1 = expo.modules.gl.GLCameraObject.this;
                r1 = r1.mDestTexture;
                android.opengl.GLES30.glBindTexture(r11, r1);
                r20 = 3553; // 0xde1 float:4.979E-42 double:1.7554E-320;
                r21 = 0;
                r22 = 6408; // 0x1908 float:8.98E-42 double:3.166E-320;
                r1 = expo.modules.gl.GLCameraObject.this;
                r23 = r1.mTextureWidth;
                r1 = expo.modules.gl.GLCameraObject.this;
                r24 = r1.mTextureHeight;
                r25 = 0;
                r26 = 6408; // 0x1908 float:8.98E-42 double:3.166E-320;
                r27 = 5121; // 0x1401 float:7.176E-42 double:2.53E-320;
                r28 = 0;
                android.opengl.GLES30.glTexImage2D(r20, r21, r22, r23, r24, r25, r26, r27, r28);
                r1 = expo.modules.gl.GLCameraObject.this;
                r1 = r1.mCameraSurfaceTexture;
                r7 = r0;
                r12 = r4;
                r1.setDefaultBufferSize(r7, r12);
            L_0x0164:
                r1 = expo.modules.gl.GLCameraObject.this;	 Catch:{ IllegalStateException -> 0x01d0 }
                r1 = r1.mCameraSurfaceTexture;	 Catch:{ IllegalStateException -> 0x01d0 }
                r1.updateTexImage();	 Catch:{ IllegalStateException -> 0x01d0 }
                r1 = expo.modules.gl.GLCameraObject.this;	 Catch:{ IllegalStateException -> 0x01d0 }
                r1 = r1.mCameraSurfaceTexture;	 Catch:{ IllegalStateException -> 0x01d0 }
                r1.getTransformMatrix(r9);	 Catch:{ IllegalStateException -> 0x01d0 }
                r1 = expo.modules.gl.GLCameraObject.this;	 Catch:{ IllegalStateException -> 0x01d0 }
                r1 = r1.mExtTexture;	 Catch:{ IllegalStateException -> 0x01d0 }
                r7 = 36197; // 0x8d65 float:5.0723E-41 double:1.78837E-319;	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glBindTexture(r7, r1);	 Catch:{ IllegalStateException -> 0x01d0 }
                r1 = 0;	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = r4[r1];	 Catch:{ IllegalStateException -> 0x01d0 }
                r7 = 33984; // 0x84c0 float:4.7622E-41 double:1.67903E-319;	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = r4 - r7;	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glUniform1i(r13, r4);	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = 1;	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glUniformMatrix4fv(r10, r4, r1, r9, r1);	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = expo.modules.gl.GLCameraObject.this;	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = r4.mTextureWidth;	 Catch:{ IllegalStateException -> 0x01d0 }
                r7 = expo.modules.gl.GLCameraObject.this;	 Catch:{ IllegalStateException -> 0x01d0 }
                r7 = r7.mTextureHeight;	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glViewport(r1, r1, r4, r7);	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = expo.modules.gl.GLCameraObject.this;	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = r4.textureCoords;	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = r4.length;	 Catch:{ IllegalStateException -> 0x01d0 }
                r7 = 2;	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = r4 / r7;	 Catch:{ IllegalStateException -> 0x01d0 }
                r9 = 4;	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glDrawArrays(r9, r1, r4);	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = r8[r1];	 Catch:{ IllegalStateException -> 0x01d0 }
                r9 = 1;	 Catch:{ IllegalStateException -> 0x01d0 }
                r9 = r8[r9];	 Catch:{ IllegalStateException -> 0x01d0 }
                r7 = r8[r7];	 Catch:{ IllegalStateException -> 0x01d0 }
                r10 = 3;	 Catch:{ IllegalStateException -> 0x01d0 }
                r8 = r8[r10];	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glViewport(r4, r9, r7, r8);	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = r5[r1];	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glBindTexture(r11, r4);	 Catch:{ IllegalStateException -> 0x01d0 }
                r2 = r2[r1];	 Catch:{ IllegalStateException -> 0x01d0 }
                r4 = 36009; // 0x8ca9 float:5.046E-41 double:1.7791E-319;	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glBindFramebuffer(r4, r2);	 Catch:{ IllegalStateException -> 0x01d0 }
                r2 = r6[r1];	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glBindVertexArray(r2);	 Catch:{ IllegalStateException -> 0x01d0 }
                r1 = r3[r1];	 Catch:{ IllegalStateException -> 0x01d0 }
                android.opengl.GLES30.glUseProgram(r1);	 Catch:{ IllegalStateException -> 0x01d0 }
            L_0x01d0:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: expo.modules.gl.GLCameraObject.1.run():void");
            }
        });
    }

    void destroy() {
        if (this.mCameraView != null) {
            this.mCameraView.setPreviewTexture(null);
            this.mCameraView = null;
        }
        if (this.mCameraSurfaceTexture != null) {
            this.mCameraSurfaceTexture.release();
            this.mCameraSurfaceTexture = null;
        }
        super.destroy();
    }
}
