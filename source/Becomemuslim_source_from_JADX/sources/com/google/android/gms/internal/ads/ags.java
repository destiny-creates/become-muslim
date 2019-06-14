package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.server.http.HttpStatus;

final class ags implements ago {
    /* renamed from: a */
    private final /* synthetic */ agm f23579a;

    private ags(agm agm) {
        this.f23579a = agm;
    }

    /* renamed from: a */
    public final void mo3809a(byte[] bArr, byte[] bArr2) {
        this.f23579a.aj = this.f23579a.bK & (~this.f23579a.aP);
        this.f23579a.ci = this.f23579a.bK & (~this.f23579a.aj);
        this.f23579a.f14491m = this.f23579a.bs | this.f23579a.ci;
        this.f23579a.f14491m &= ~this.f23579a.be;
        this.f23579a.bU = this.f23579a.aj ^ this.f23579a.bU;
        this.f23579a.f14491m = this.f23579a.bU ^ this.f23579a.f14491m;
        this.f23579a.cp = this.f23579a.f14491m ^ this.f23579a.cp;
        this.f23579a.cA = this.f23579a.bU ^ this.f23579a.cA;
        this.f23579a.cA = this.f23579a.bC & this.f23579a.cA;
        this.f23579a.cA = this.f23579a.aR ^ this.f23579a.cA;
        this.f23579a.aR = this.f23579a.aj ^ this.f23579a.bs;
        this.f23579a.aR = this.f23579a.be & this.f23579a.aR;
        this.f23579a.aR = this.f23579a.aC ^ this.f23579a.aR;
        this.f23579a.aC = this.f23579a.bC & this.f23579a.aR;
        this.f23579a.aC = this.f23579a.aR ^ this.f23579a.aC;
        this.f23579a.aC = this.f23579a.am | this.f23579a.aC;
        this.f23579a.aC = this.f23579a.cA ^ this.f23579a.aC;
        this.f23579a.f14502x = this.f23579a.aC ^ this.f23579a.f14502x;
        this.f23579a.aC = this.f23579a.bs | this.f23579a.aj;
        this.f23579a.aC = this.f23579a.bK ^ this.f23579a.aC;
        this.f23579a.at = this.f23579a.aC ^ this.f23579a.at;
        this.f23579a.at = this.f23579a.bC & (~this.f23579a.at);
        this.f23579a.at = this.f23579a.aN ^ this.f23579a.at;
        this.f23579a.at &= ~this.f23579a.am;
        this.f23579a.aN = this.f23579a.aj & (~this.f23579a.bs);
        this.f23579a.aN = this.f23579a.aP ^ this.f23579a.aN;
        this.f23579a.aN = this.f23579a.be & (~this.f23579a.aN);
        this.f23579a.aC = this.f23579a.bs | this.f23579a.aj;
        this.f23579a.aC = this.f23579a.f14458F ^ this.f23579a.aC;
        this.f23579a.aC = this.f23579a.be & (~this.f23579a.aC);
        this.f23579a.f14455C &= ~this.f23579a.bK;
        this.f23579a.f14455C = this.f23579a.ar ^ this.f23579a.f14455C;
        this.f23579a.f14462J = this.f23579a.f14455C ^ this.f23579a.f14462J;
        this.f23579a.bG = this.f23579a.f14462J ^ this.f23579a.bG;
        this.f23579a.f14462J = this.f23579a.bu | this.f23579a.bG;
        this.f23579a.f14462J = this.f23579a.bV ^ this.f23579a.f14462J;
        this.f23579a.al = this.f23579a.f14462J ^ this.f23579a.al;
        this.f23579a.bG = this.f23579a.bu & this.f23579a.bG;
        this.f23579a.bG = this.f23579a.bV ^ this.f23579a.bG;
        this.f23579a.ab = this.f23579a.bG ^ this.f23579a.ab;
        this.f23579a.bK = this.f23579a.aP ^ this.f23579a.bK;
        this.f23579a.bG = this.f23579a.bK & (~this.f23579a.bs);
        this.f23579a.bG = this.f23579a.aj ^ this.f23579a.bG;
        this.f23579a.aN = this.f23579a.bG ^ this.f23579a.aN;
        this.f23579a.aN = this.f23579a.bC & (~this.f23579a.aN);
        this.f23579a.bG = this.f23579a.bs | this.f23579a.bK;
        this.f23579a.bG = this.f23579a.bK ^ this.f23579a.bG;
        this.f23579a.aC = this.f23579a.bG ^ this.f23579a.aC;
        this.f23579a.aC = this.f23579a.bC & this.f23579a.aC;
        this.f23579a.cc = this.f23579a.bK ^ this.f23579a.cc;
        this.f23579a.cc = this.f23579a.be & this.f23579a.cc;
        this.f23579a.cc = this.f23579a.bC & this.f23579a.cc;
        this.f23579a.cc = this.f23579a.ci ^ this.f23579a.cc;
        this.f23579a.cc = this.f23579a.am | this.f23579a.cc;
        this.f23579a.cc = this.f23579a.cp ^ this.f23579a.cc;
        this.f23579a.f14484f = this.f23579a.cc ^ this.f23579a.f14484f;
        this.f23579a.bs = this.f23579a.bK ^ this.f23579a.bs;
        this.f23579a.f14494p = this.f23579a.bs ^ this.f23579a.f14494p;
        this.f23579a.aN = this.f23579a.f14494p ^ this.f23579a.aN;
        this.f23579a.cC = this.f23579a.aN ^ this.f23579a.cC;
        this.f23579a.bn = this.f23579a.cC ^ this.f23579a.bn;
        this.f23579a.bn = ~this.f23579a.bn;
        this.f23579a.an = this.f23579a.bK ^ this.f23579a.an;
        this.f23579a.an = this.f23579a.be & this.f23579a.an;
        this.f23579a.an = this.f23579a.bs ^ this.f23579a.an;
        this.f23579a.aC = this.f23579a.an ^ this.f23579a.aC;
        this.f23579a.at = this.f23579a.aC ^ this.f23579a.at;
        this.f23579a.bl = this.f23579a.at ^ this.f23579a.bl;
        bArr2[0] = (byte) this.f23579a.aL;
        bArr2[1] = (byte) (this.f23579a.aL >>> 8);
        bArr2[2] = (byte) (this.f23579a.aL >>> 16);
        bArr2[3] = this.f23579a.aL >> (byte) 24;
        bArr2[4] = (byte) this.f23579a.ce;
        bArr2[5] = (byte) (this.f23579a.ce >>> 8);
        bArr2[6] = (byte) (this.f23579a.ce >>> 16);
        bArr2[7] = this.f23579a.ce >> (byte) 24;
        bArr2[8] = (byte) this.f23579a.bn;
        bArr2[9] = (byte) (this.f23579a.bn >>> 8);
        bArr2[10] = (byte) (this.f23579a.bn >>> 16);
        bArr2[11] = this.f23579a.bn >> (byte) 24;
        bArr2[12] = (byte) this.f23579a.bd;
        bArr2[13] = (byte) (this.f23579a.bd >>> 8);
        bArr2[14] = (byte) (this.f23579a.bd >>> 16);
        bArr2[15] = this.f23579a.bd >> (byte) 24;
        bArr2[16] = (byte) this.f23579a.f14484f;
        bArr2[17] = (byte) (this.f23579a.f14484f >>> 8);
        bArr2[18] = (byte) (this.f23579a.f14484f >>> 16);
        bArr2[19] = this.f23579a.f14484f >> (byte) 24;
        bArr2[20] = (byte) this.f23579a.f14483e;
        bArr2[21] = (byte) (this.f23579a.f14483e >>> 8);
        bArr2[22] = (byte) (this.f23579a.f14483e >>> 16);
        bArr2[23] = this.f23579a.f14483e >> (byte) 24;
        bArr2[24] = (byte) this.f23579a.f14486h;
        bArr2[25] = (byte) (this.f23579a.f14486h >>> 8);
        bArr2[26] = (byte) (this.f23579a.f14486h >>> 16);
        bArr2[27] = this.f23579a.f14486h >> (byte) 24;
        bArr2[28] = (byte) this.f23579a.bC;
        bArr2[29] = (byte) (this.f23579a.bC >>> 8);
        bArr2[30] = (byte) (this.f23579a.bC >>> 16);
        bArr2[31] = this.f23579a.bC >> (byte) 24;
        bArr2[32] = (byte) this.f23579a.f14488j;
        bArr2[33] = (byte) (this.f23579a.f14488j >>> 8);
        bArr2[34] = (byte) (this.f23579a.f14488j >>> 16);
        bArr2[35] = this.f23579a.f14488j >> (byte) 24;
        bArr2[36] = (byte) this.f23579a.cw;
        bArr2[37] = (byte) (this.f23579a.cw >>> 8);
        bArr2[38] = (byte) (this.f23579a.cw >>> 16);
        bArr2[39] = this.f23579a.cw >> (byte) 24;
        bArr2[40] = (byte) this.f23579a.bz;
        bArr2[41] = (byte) (this.f23579a.bz >>> 8);
        bArr2[42] = (byte) (this.f23579a.bz >>> 16);
        bArr2[43] = this.f23579a.bz >> (byte) 24;
        bArr2[44] = (byte) this.f23579a.f14489k;
        bArr2[45] = (byte) (this.f23579a.f14489k >>> 8);
        bArr2[46] = (byte) (this.f23579a.f14489k >>> 16);
        bArr2[47] = this.f23579a.f14489k >> (byte) 24;
        bArr2[48] = (byte) this.f23579a.aG;
        bArr2[49] = (byte) (this.f23579a.aG >>> 8);
        bArr2[50] = (byte) (this.f23579a.aG >>> 16);
        bArr2[51] = this.f23579a.aG >> (byte) 24;
        bArr2[52] = (byte) this.f23579a.bD;
        bArr2[53] = (byte) (this.f23579a.bD >>> 8);
        bArr2[54] = (byte) (this.f23579a.bD >>> 16);
        bArr2[55] = this.f23579a.bD >> (byte) 24;
        bArr2[56] = (byte) this.f23579a.aX;
        bArr2[57] = (byte) (this.f23579a.aX >>> 8);
        bArr2[58] = (byte) (this.f23579a.aX >>> 16);
        bArr2[59] = this.f23579a.aX >> (byte) 24;
        bArr2[60] = (byte) this.f23579a.f14493o;
        bArr2[61] = (byte) (this.f23579a.f14493o >>> 8);
        bArr2[62] = (byte) (this.f23579a.f14493o >>> 16);
        bArr2[63] = this.f23579a.f14493o >> (byte) 24;
        bArr2[64] = (byte) this.f23579a.bl;
        bArr2[65] = (byte) (this.f23579a.bl >>> 8);
        bArr2[66] = (byte) (this.f23579a.bl >>> 16);
        bArr2[67] = this.f23579a.bl >> (byte) 24;
        bArr2[68] = (byte) this.f23579a.bc;
        bArr2[69] = (byte) (this.f23579a.bc >>> 8);
        bArr2[70] = (byte) (this.f23579a.bc >>> 16);
        bArr2[71] = this.f23579a.bc >> (byte) 24;
        bArr2[72] = (byte) this.f23579a.ap;
        bArr2[73] = (byte) (this.f23579a.ap >>> 8);
        bArr2[74] = (byte) (this.f23579a.ap >>> 16);
        bArr2[75] = this.f23579a.ap >> (byte) 24;
        bArr2[76] = (byte) this.f23579a.bb;
        bArr2[77] = (byte) (this.f23579a.bb >>> 8);
        bArr2[78] = (byte) (this.f23579a.bb >>> 16);
        bArr2[79] = this.f23579a.bb >> (byte) 24;
        bArr2[80] = (byte) this.f23579a.f14500v;
        bArr2[81] = (byte) (this.f23579a.f14500v >>> 8);
        bArr2[82] = (byte) (this.f23579a.f14500v >>> 16);
        bArr2[83] = this.f23579a.f14500v >> (byte) 24;
        bArr2[84] = (byte) this.f23579a.f14499u;
        bArr2[85] = (byte) (this.f23579a.f14499u >>> 8);
        bArr2[86] = (byte) (this.f23579a.f14499u >>> 16);
        bArr2[87] = this.f23579a.f14499u >> (byte) 24;
        bArr2[88] = (byte) this.f23579a.f14502x;
        bArr2[89] = (byte) (this.f23579a.f14502x >>> 8);
        bArr2[90] = (byte) (this.f23579a.f14502x >>> 16);
        bArr2[91] = this.f23579a.f14502x >> (byte) 24;
        bArr2[92] = (byte) this.f23579a.f14501w;
        bArr2[93] = (byte) (this.f23579a.f14501w >>> 8);
        bArr2[94] = (byte) (this.f23579a.f14501w >>> 16);
        bArr2[95] = this.f23579a.f14501w >> (byte) 24;
        bArr2[96] = (byte) this.f23579a.bE;
        bArr2[97] = (byte) (this.f23579a.bE >>> 8);
        bArr2[98] = (byte) (this.f23579a.bE >>> 16);
        bArr2[99] = this.f23579a.bE >> (byte) 24;
        bArr2[100] = (byte) this.f23579a.bN;
        bArr2[101] = (byte) (this.f23579a.bN >>> 8);
        bArr2[102] = (byte) (this.f23579a.bN >>> 16);
        bArr2[103] = this.f23579a.bN >> (byte) 24;
        bArr2[104] = (byte) this.f23579a.aF;
        bArr2[105] = (byte) (this.f23579a.aF >>> 8);
        bArr2[106] = (byte) (this.f23579a.aF >>> 16);
        bArr2[107] = this.f23579a.aF >> (byte) 24;
        bArr2[108] = (byte) this.f23579a.f14453A;
        bArr2[109] = (byte) (this.f23579a.f14453A >>> 8);
        bArr2[110] = (byte) (this.f23579a.f14453A >>> 16);
        bArr2[111] = this.f23579a.f14453A >> (byte) 24;
        bArr2[112] = (byte) this.f23579a.f14456D;
        bArr2[113] = (byte) (this.f23579a.f14456D >>> 8);
        bArr2[114] = (byte) (this.f23579a.f14456D >>> 16);
        bArr2[115] = this.f23579a.f14456D >> (byte) 24;
        bArr2[116] = (byte) this.f23579a.f14473U;
        bArr2[117] = (byte) (this.f23579a.f14473U >>> 8);
        bArr2[118] = (byte) (this.f23579a.f14473U >>> 16);
        bArr2[119] = this.f23579a.f14473U >> (byte) 24;
        bArr2[120] = (byte) this.f23579a.bH;
        bArr2[121] = (byte) (this.f23579a.bH >>> 8);
        bArr2[122] = (byte) (this.f23579a.bH >>> 16);
        bArr2[123] = this.f23579a.bH >> (byte) 24;
        bArr2[124] = (byte) this.f23579a.bh;
        bArr2[125] = (byte) (this.f23579a.bh >>> 8);
        bArr2[126] = (byte) (this.f23579a.bh >>> 16);
        bArr2[127] = this.f23579a.bh >> (byte) 24;
        bArr2[128] = (byte) this.f23579a.bi;
        bArr2[129] = (byte) (this.f23579a.bi >>> 8);
        bArr2[130] = (byte) (this.f23579a.bi >>> 16);
        bArr2[131] = this.f23579a.bi >> (byte) 24;
        bArr2[132] = (byte) this.f23579a.f14459G;
        bArr2[133] = (byte) (this.f23579a.f14459G >>> 8);
        bArr2[134] = (byte) (this.f23579a.f14459G >>> 16);
        bArr2[135] = this.f23579a.f14459G >> (byte) 24;
        bArr2[136] = (byte) this.f23579a.aT;
        bArr2[137] = (byte) (this.f23579a.aT >>> 8);
        bArr2[138] = (byte) (this.f23579a.aT >>> 16);
        bArr2[139] = this.f23579a.aT >> (byte) 24;
        bArr2[140] = (byte) this.f23579a.cm;
        bArr2[141] = (byte) (this.f23579a.cm >>> 8);
        bArr2[142] = (byte) (this.f23579a.cm >>> 16);
        bArr2[143] = this.f23579a.cm >> (byte) 24;
        bArr2[144] = (byte) this.f23579a.f14464L;
        bArr2[145] = (byte) (this.f23579a.f14464L >>> 8);
        bArr2[146] = (byte) (this.f23579a.f14464L >>> 16);
        bArr2[147] = this.f23579a.f14464L >> (byte) 24;
        bArr2[148] = (byte) this.f23579a.cl;
        bArr2[149] = (byte) (this.f23579a.cl >>> 8);
        bArr2[150] = (byte) (this.f23579a.cl >>> 16);
        bArr2[151] = this.f23579a.cl >> (byte) 24;
        bArr2[152] = (byte) this.f23579a.bR;
        bArr2[153] = (byte) (this.f23579a.bR >>> 8);
        bArr2[154] = (byte) (this.f23579a.bR >>> 16);
        bArr2[155] = this.f23579a.bR >> (byte) 24;
        bArr2[156] = (byte) this.f23579a.f14476X;
        bArr2[157] = (byte) (this.f23579a.f14476X >>> 8);
        bArr2[158] = (byte) (this.f23579a.f14476X >>> 16);
        bArr2[159] = this.f23579a.f14476X >> (byte) 24;
        bArr2[160] = (byte) this.f23579a.f14468P;
        bArr2[161] = (byte) (this.f23579a.f14468P >>> 8);
        bArr2[162] = (byte) (this.f23579a.f14468P >>> 16);
        bArr2[163] = this.f23579a.f14468P >> (byte) 24;
        bArr2[164] = (byte) this.f23579a.f14487i;
        bArr2[165] = (byte) (this.f23579a.f14487i >>> 8);
        bArr2[166] = (byte) (this.f23579a.f14487i >>> 16);
        bArr2[167] = this.f23579a.f14487i >> (byte) 24;
        bArr2[168] = (byte) this.f23579a.ae;
        bArr2[169] = (byte) (this.f23579a.ae >>> 8);
        bArr2[170] = (byte) (this.f23579a.ae >>> 16);
        bArr2[171] = this.f23579a.ae >> (byte) 24;
        bArr2[172] = (byte) this.f23579a.aa;
        bArr2[173] = (byte) (this.f23579a.aa >>> 8);
        bArr2[174] = (byte) (this.f23579a.aa >>> 16);
        bArr2[175] = this.f23579a.aa >> (byte) 24;
        bArr2[176] = (byte) this.f23579a.f14472T;
        bArr2[177] = (byte) (this.f23579a.f14472T >>> 8);
        bArr2[178] = (byte) (this.f23579a.f14472T >>> 16);
        bArr2[179] = this.f23579a.f14472T >> (byte) 24;
        bArr2[RotationOptions.ROTATE_180] = (byte) this.f23579a.aP;
        bArr2[181] = (byte) (this.f23579a.aP >>> 8);
        bArr2[182] = (byte) (this.f23579a.aP >>> 16);
        bArr2[183] = this.f23579a.aP >> (byte) 24;
        bArr2[184] = (byte) this.f23579a.f14474V;
        bArr2[185] = (byte) (this.f23579a.f14474V >>> 8);
        bArr2[186] = (byte) (this.f23579a.f14474V >>> 16);
        bArr2[187] = this.f23579a.f14474V >> (byte) 24;
        bArr2[188] = (byte) this.f23579a.as;
        bArr2[189] = (byte) (this.f23579a.as >>> 8);
        bArr2[FacebookRequestErrorClassification.EC_INVALID_TOKEN] = (byte) (this.f23579a.as >>> 16);
        bArr2[191] = this.f23579a.as >> (byte) 24;
        bArr2[JfifUtil.MARKER_SOFn] = (byte) this.f23579a.f14490l;
        bArr2[193] = (byte) (this.f23579a.f14490l >>> 8);
        bArr2[194] = (byte) (this.f23579a.f14490l >>> 16);
        bArr2[195] = this.f23579a.f14490l >> (byte) 24;
        bArr2[196] = (byte) this.f23579a.aJ;
        bArr2[197] = (byte) (this.f23579a.aJ >>> 8);
        bArr2[198] = (byte) (this.f23579a.aJ >>> 16);
        bArr2[199] = this.f23579a.aJ >> (byte) 24;
        bArr2[HttpStatus.HTTP_OK] = (byte) this.f23579a.f14478Z;
        bArr2[201] = (byte) (this.f23579a.f14478Z >>> 8);
        bArr2[202] = (byte) (this.f23579a.f14478Z >>> 16);
        bArr2[203] = this.f23579a.f14478Z >> (byte) 24;
        bArr2[204] = (byte) this.f23579a.aD;
        bArr2[205] = (byte) (this.f23579a.aD >>> 8);
        bArr2[206] = (byte) (this.f23579a.aD >>> 16);
        bArr2[207] = this.f23579a.aD >> (byte) 24;
        bArr2[JfifUtil.MARKER_RST0] = (byte) this.f23579a.ab;
        bArr2[209] = (byte) (this.f23579a.ab >>> 8);
        bArr2[210] = (byte) (this.f23579a.ab >>> 16);
        bArr2[211] = this.f23579a.ab >> (byte) 24;
        bArr2[212] = (byte) this.f23579a.be;
        bArr2[213] = (byte) (this.f23579a.be >>> 8);
        bArr2[214] = (byte) (this.f23579a.be >>> 16);
        bArr2[JfifUtil.MARKER_RST7] = this.f23579a.be >> (byte) 24;
        bArr2[JfifUtil.MARKER_SOI] = (byte) this.f23579a.ad;
        bArr2[JfifUtil.MARKER_EOI] = (byte) (this.f23579a.ad >>> 8);
        bArr2[JfifUtil.MARKER_SOS] = (byte) (this.f23579a.ad >>> 16);
        bArr2[219] = this.f23579a.ad >> (byte) 24;
        bArr2[220] = (byte) this.f23579a.f14471S;
        bArr2[221] = (byte) (this.f23579a.f14471S >>> 8);
        bArr2[222] = (byte) (this.f23579a.f14471S >>> 16);
        bArr2[223] = this.f23579a.f14471S >> (byte) 24;
        bArr2[224] = (byte) this.f23579a.cf;
        bArr2[JfifUtil.MARKER_APP1] = (byte) (this.f23579a.cf >>> 8);
        bArr2[226] = (byte) (this.f23579a.cf >>> 16);
        bArr2[227] = this.f23579a.cf >> (byte) 24;
        bArr2[228] = (byte) this.f23579a.bF;
        bArr2[229] = (byte) (this.f23579a.bF >>> 8);
        bArr2[230] = (byte) (this.f23579a.bF >>> 16);
        bArr2[231] = this.f23579a.bF >> (byte) 24;
        bArr2[232] = (byte) this.f23579a.br;
        bArr2[233] = (byte) (this.f23579a.br >>> 8);
        bArr2[234] = (byte) (this.f23579a.br >>> 16);
        bArr2[235] = this.f23579a.br >> (byte) 24;
        bArr2[236] = (byte) this.f23579a.cs;
        bArr2[237] = (byte) (this.f23579a.cs >>> 8);
        bArr2[238] = (byte) (this.f23579a.cs >>> 16);
        bArr2[239] = this.f23579a.cs >> (byte) 24;
        bArr2[240] = (byte) this.f23579a.cb;
        bArr2[241] = (byte) (this.f23579a.cb >>> 8);
        bArr2[242] = (byte) (this.f23579a.cb >>> 16);
        bArr2[243] = this.f23579a.cb >> (byte) 24;
        bArr2[244] = (byte) this.f23579a.aE;
        bArr2[245] = (byte) (this.f23579a.aE >>> 8);
        bArr2[246] = (byte) (this.f23579a.aE >>> 16);
        bArr2[247] = this.f23579a.aE >> (byte) 24;
        bArr2[248] = (byte) this.f23579a.al;
        bArr2[249] = (byte) (this.f23579a.al >>> 8);
        bArr2[250] = (byte) (this.f23579a.al >>> 16);
        bArr2[251] = this.f23579a.al >> (byte) 24;
        bArr2[252] = (byte) this.f23579a.aK;
        bArr2[253] = (byte) (this.f23579a.aK >>> 8);
        bArr2[254] = (byte) (this.f23579a.aK >>> 16);
        bArr2[JfifUtil.MARKER_FIRST_BYTE] = this.f23579a.aK >> (byte) 24;
    }
}
