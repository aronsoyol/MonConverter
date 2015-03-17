package com.almas.mongol.encode;


import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class MongolianConverter {

	private static final char EXCLAM = '\u0021';
	private static final char M_EXCLAM_ISOL = '\uE81C';
	private static final char M_EXCLAM_QUESTION_ISOL = '\uE81B';

	private static final char COMMA = '\u002C';
	private static final char M_COMMA_ISOL1 = '\uE81F';

	private static final char QUESTION = '\u003F';
	private static final char M_QUESTION_ISOL = '\uE81D';
	private static final char M_QUESTION_EXCLAM_ISOL = '\uE81A';

	private static final char COLON = '\u003A';

	private static final char SEMICOLON = '\u003B';
	private static final char M_SEMICOLON_ISOL = '\uE81E';

	private static final char M_BIRGA = '\u1800';
	private static final char M_BIRGA1 = '\uEA24';
	private static final char M_BIRGA2 = '\uEA25';
	private static final char M_BIRGA3 = '\uEA26';
	// private static final char M_BIRGA4 = '\uEA27';

	private static final char M_ELLIPSIS = '\u1801';
	private static final char M_ELLIPSIS_ISOL = '\uE801';

	private static final char M_COMMA = '\u1802';
	private static final char M_COMMA_ISOL = '\uE802';

	private static final char M_FULL_STOP = '\u1803';
	private static final char M_FULL_STOP_ISOL = '\uE803';

	private static final char M_COLON = '\u1804';
	private static final char M_COLON_ISOL = '\uE804';

	private static final char M_FOUR_DOTS = '\u1805';
	private static final char M_FOUR_DOTS_ISOL = '\uE805';

	private static final char M_TODO_HYPHEN = '\u1806';
	private static final char M_TODO_HYPHEN_ISOL = '\uE806';

	private static final char M_SIBE_SBM = '\u1807';
	private static final char M_SIBE_SBM_ISOL = '\uE807';

	private static final char M_MANCHU_COMMA = '\u1808';
	private static final char M_MANCHU_COMMA_ISOL = '\u1808';

	private static final char M_MANCHU_FULL_STOP = '\u1809';
	private static final char M_MANCHU_FULL_STOP_ISOL = '\uE809';

	private static final char M_NIRUGU = '\u180A';
	private static final char M_NIRUGU_ISOL = '\uE80A';

	private static final char M_FVS1 = '\u180B';
	private static final char M_FVS1_ISOL = '\uE80B';

	private static final char M_FVS2 = '\u180C';
	private static final char M_FVS2_ISOL = '\uE80C';

	private static final char M_FVS3 = '\u180D';
	private static final char M_FVS3_ISOL = '\uE80D';

	private static final char M_MVS = '\u180E';
	private static final char M_MVS_ISOL = '\uE80E';

	private static final char M_DIGIT_ZERO = '\u1810';
	private static final char M_DIGIT_ZERO_ISOL = '\uE810';

	private static final char M_DIGIT_ONE = '\u1811';
	private static final char M_DIGIT_ONE_ISOL = '\uE811';

	private static final char M_DIGIT_TWO = '\u1812';
	private static final char M_DIGIT_TWO_ISOL = '\uE812';

	private static final char M_DIGIT_THREE = '\u1813';
	private static final char M_DIGIT_THREE_ISOL = '\uE813';

	private static final char M_DIGIT_FOUR = '\u1814';
	private static final char M_DIGIT_FOUR_ISOL = '\uE814';

	private static final char M_DIGIT_FIVE = '\u1815';
	private static final char M_DIGIT_FIVE_ISOL = '\uE815';

	private static final char M_DIGIT_SIX = '\u1816';
	private static final char M_DIGIT_SIX_ISOL = '\uE816';

	private static final char M_DIGIT_SEVEN = '\u1817';
	private static final char M_DIGIT_SEVEN_ISOL = '\uE817';

	private static final char M_DIGIT_EIGHT = '\u1818';
	private static final char M_DIGIT_EIGHT_ISOL = '\uE818';

	private static final char M_DIGIT_NINE = '\u1819';
	private static final char M_DIGIT_NINE_ISOL = '\uE819';

	private static final char ML_A = '\u1820';
	private static final char ML_A_ISOL = '\uE820';
	private static final char ML_A_ISOL1 = '\uE821';
	private static final char ML_A_INIT = '\uE822';
	private static final char ML_A_INIT1 = '\uEA21';
	private static final char ML_A_MEDI = '\uE823';
	private static final char ML_A_MEDI1 = '\uE824';
	private static final char ML_A_FINA = '\uE825';
	private static final char ML_A_FINA1 = '\uE826';
	private static final char ML_A_FINA2 = '\uE827';

	private static final char ML_E = '\u1821';
	private static final char ML_E_ISOL = '\uE828';
	private static final char ML_E_ISOL1 = '\uE829';
	private static final char ML_E_INIT = '\uE82A';
	private static final char ML_E_INIT1 = '\uE82B';
	private static final char ML_E_MEDI = '\uE82C';
	private static final char ML_E_FINA = '\uE82D';
	private static final char ML_E_FINA1 = '\uE82E';
	private static final char ML_E_FINA2 = '\uE82F';

	private static final char ML_I = '\u1822';
	private static final char ML_I_ISOL = '\uE830';
	private static final char ML_I_ISOL1 = '\uE831';
	private static final char ML_I_INIT = '\uE832';
	private static final char ML_I_INIT1 = '\uE833';
	private static final char ML_I_MEDI = '\uE834';
	private static final char ML_I_MEDI1 = '\uE835';
	private static final char ML_I_MEDI2 = '\uE836';
	private static final char ML_I_FINA = '\uE837';

	private static final char ML_O = '\u1823';
	private static final char ML_O_ISOL = '\uE838';
	private static final char ML_O_ISOL1 = '\uE839';
	private static final char ML_O_INIT = '\uE83A';
	private static final char ML_O_INIT1 = '\uE83B';
	private static final char ML_O_MEDI = '\uE83C';
	private static final char ML_O_MEDI1 = '\uE83D';
	private static final char ML_O_FINA = '\uE83E';
	private static final char ML_O_FINA1 = '\uE83F';

	private static final char ML_U = '\u1824';
	private static final char ML_U_ISOL = '\uE840';
	private static final char ML_U_ISOL1 = '\uE841';
	private static final char ML_U_INIT = '\uE842';
	private static final char ML_U_INIT1 = '\uE843';
	private static final char ML_U_MEDI = '\uE844';
	private static final char ML_U_MEDI1 = '\uE845';
	private static final char ML_U_FINA = '\uE846';
	private static final char ML_U_FINA1 = '\uE847';

	private static final char ML_OE = '\u1825';
	private static final char ML_OE_ISOL = '\uE848';
	private static final char ML_OE_ISOL1 = '\uE849';
	private static final char ML_OE_INIT = '\uE84A';
	private static final char ML_OE_INIT1 = '\uEA20';
	private static final char ML_OE_MEDI = '\uE84B';
	private static final char ML_OE_MEDI1 = '\uE84C';
	private static final char ML_OE_MEDI2 = '\uE84D';
	private static final char ML_OE_FINA = '\uE84E';
	private static final char ML_OE_FINA1 = '\uE84F';

	private static final char ML_UE = '\u1826';
	private static final char ML_UE_ISOL = '\uE850';
	private static final char ML_UE_ISOL1 = '\uE85F';
	private static final char ML_UE_ISOL2 = '\uE851';
	private static final char ML_UE_INIT = '\uE852';
	private static final char ML_UE_INIT1 = '\uE85E';
	private static final char ML_UE_MEDI = '\uE853';
	private static final char ML_UE_MEDI1 = '\uE854';
	private static final char ML_UE_MEDI2 = '\uE855';
	private static final char ML_UE_FINA = '\uE856';
	private static final char ML_UE_FINA1 = '\uE857';

	private static final char ML_EE = '\u1827';
	private static final char ML_EE_ISOL = '\uE858';
	private static final char ML_EE_ISOL1 = '\uE859';
	private static final char ML_EE_INIT = '\uE85A';
	private static final char ML_EE_INIT1 = '\uE85B';
	private static final char ML_EE_MEDI = '\uE85C';
	private static final char ML_EE_FINA = '\uE85D';

	private static final char ML_N = '\u1828';
	private static final char ML_N_ISOL = '\uE860';
	private static final char ML_N_ISOL1 = '\uE861';
	private static final char ML_N_INIT = '\uE862';
	private static final char ML_N_INIT1 = '\uE863';
	private static final char ML_N_MEDI = '\uE864';
	private static final char ML_N_MEDI1 = '\uE865';
	private static final char ML_N_FINA = '\uE866';
	private static final char ML_N_FINA1 = '\uE867';
	private static final char ML_N_FINA2 = '\uEA23';

	private static final char ML_NG = '\u1829';
	private static final char ML_NG_ISOL = '\uE868';
	private static final char ML_NG_INIT = '\uE869';
	private static final char ML_NG_MEDI = '\uE86A';
	private static final char ML_NG_FINA = '\uE86B';
	private static final char ML_NGN_MEDI = '\uE9E3';
	private static final char ML_NGH_MEDI = '\uE86C';
	private static final char ML_NGH_FINA = '\uE9E4';
	private static final char ML_NGG_MEDI = '\uE86D';
	private static final char ML_NGG_FINA = '\uE9E5';
	private static final char ML_NGM_MEDI = '\uE86E';
	private static final char ML_NGL_MEDI = '\uE86F';

	private static final char ML_B = '\u182A';
	private static final char ML_B_ISOL = '\uE870';
	private static final char ML_B_INIT = '\uE871';
	private static final char ML_B_MEDI = '\uE872';
	private static final char ML_B_FINA = '\uE873';
	private static final char ML_B_FINA1 = '\uE9CE';
	private static final char ML_BA_ISOL = '\uE874';
	private static final char ML_BA_INIT = '\uE875';
	private static final char ML_BA_MEDI = '\uE876';
	private static final char ML_BA_FINA = '\uE877';
	private static final char ML_BE_ISOL = '\uE878';
	private static final char ML_BE_INIT = '\uE879';
	private static final char ML_BE_MEDI = '\uE87A';
	private static final char ML_BE_FINA = '\uE87B';
	private static final char ML_BI_ISOL = '\uE87C';
	private static final char ML_BI_INIT = '\uE87D';
	private static final char ML_BI_MEDI = '\uE87E';
	private static final char ML_BI_FINA = '\uE87F';
	private static final char ML_BO_ISOL = '\uE880';
	private static final char ML_BO_INIT = '\uE881';
	private static final char ML_BO_MEDI = '\uE882';
	private static final char ML_BO_FINA = '\uE883';
	private static final char ML_BU_ISOL = '\uE884';
	private static final char ML_BU_INIT = '\uE885';
	private static final char ML_BU_MEDI = '\uE886';
	private static final char ML_BU_FINA = '\uE887';
	private static final char ML_BOE_ISOL = '\uE888';
	private static final char ML_BOE_INIT = '\uE889';
	private static final char ML_BOE_MEDI = '\uE88A';
	private static final char ML_BOE_MEDI1 = '\uE9D1';
	private static final char ML_BOE_FINA = '\uE88B';
	private static final char ML_BOE_FINA1 = '\uE88C';
	private static final char ML_BUE_ISOL = '\uE88D';
	private static final char ML_BUE_INIT = '\uE88E';
	private static final char ML_BUE_MEDI = '\uE88F';
	private static final char ML_BUE_MEDI1 = '\uE9D2';
	private static final char ML_BUE_FINA = '\uE890';
	private static final char ML_BUE_FINA1 = '\uE891';
	private static final char ML_BEE_ISOL = '\uE892';
	private static final char ML_BEE_INIT = '\uE893';
	private static final char ML_BEE_MEDI = '\uE894';
	private static final char ML_BEE_FINA = '\uE895';
	private static final char ML_BN_MEDI = '\uE9F0';
	private static final char ML_BH_MEDI = '\uE9E6';
	private static final char ML_BG_MEDI = '\uE9E7';
	private static final char ML_BM_MEDI = '\uE896';
	private static final char ML_BL_MEDI = '\uE897';

	private static final char ML_P = '\u182B';
	private static final char ML_P_ISOL = '\uE898';
	private static final char ML_P_INIT = '\uE899';
	private static final char ML_P_MEDI = '\uE89A';
	private static final char ML_P_FINA = '\uE89B';
	private static final char ML_PA_ISOL = '\uE89C';
	private static final char ML_PA_INIT = '\uE89D';
	private static final char ML_PA_MEDI = '\uE89E';
	private static final char ML_PA_FINA = '\uE89F';
	private static final char ML_PE_ISOL = '\uE8A0';
	private static final char ML_PE_INIT = '\uE8A1';
	private static final char ML_PE_MEDI = '\uE8A2';
	private static final char ML_PE_FINA = '\uE8A3';
	private static final char ML_PI_ISOL = '\uE8A4';
	private static final char ML_PI_INIT = '\uE8A5';
	private static final char ML_PI_MEDI = '\uE8A6';
	private static final char ML_PI_FINA = '\uE8A7';
	private static final char ML_PO_ISOL = '\uE8A8';
	private static final char ML_PO_INIT = '\uE8A9';
	private static final char ML_PO_MEDI = '\uE8AA';
	private static final char ML_PO_FINA = '\uE8AB';
	private static final char ML_PU_ISOL = '\uE8AC';
	private static final char ML_PU_INIT = '\uE8AD';
	private static final char ML_PU_MEDI = '\uE8AE';
	private static final char ML_PU_FINA = '\uE8AF';
	private static final char ML_POE_ISOL = '\uE8B0';
	private static final char ML_POE_INIT = '\uE8B1';
	private static final char ML_POE_MEDI = '\uE8B2';
	private static final char ML_POE_MEDI1 = '\uE9D3';
	private static final char ML_POE_FINA = '\uE8B3';
	private static final char ML_POE_FINA1 = '\uE8B4';
	private static final char ML_PUE_ISOL = '\uE8B5';
	private static final char ML_PUE_INIT = '\uE8B6';
	private static final char ML_PUE_MEDI = '\uE8B7';
	private static final char ML_PUE_MEDI1 = '\uE9D4';
	private static final char ML_PUE_FINA = '\uE8B8';
	private static final char ML_PUE_FINA1 = '\uE8B9';
	private static final char ML_PEE_ISOL = '\uE8BA';
	private static final char ML_PEE_INIT = '\uE8BB';
	private static final char ML_PEE_MEDI = '\uE8BC';
	private static final char ML_PEE_FINA = '\uE8BD';
	private static final char ML_PN_MEDI = '\uE9F1';
	private static final char ML_PH_MEDI = '\uE9E8';
	private static final char ML_PG_MEDI = '\uE9E9';
	private static final char ML_PM_MEDI = '\uE8BE';
	private static final char ML_PL_MEDI = '\uE8BF';

	private static final char ML_H = '\u182C';
	private static final char ML_H_ISOL = '\uE8C0';
	private static final char ML_H_ISOL1 = '\uE8C1';
	private static final char ML_H_ISOL2 = '\uEA00';
	private static final char ML_H_ISOL3 = '\uEA02';
	private static final char ML_H_INIT = '\uE8C2';
	private static final char ML_H_INIT1 = '\uE8C3';
	private static final char ML_H_INIT2 = '\uEA01';
	private static final char ML_H_INIT3 = '\uEA03';
	private static final char ML_H_MEDI = '\uE8C4';
	private static final char ML_H_MEDI1 = '\uE8C5';
	private static final char ML_H_MEDI2 = '\uE8C6';
	private static final char ML_H_MEDI3 = '\uEA04';
	private static final char ML_H_FINA = '\uE8C7';
	private static final char ML_H_FINA1 = '\uE8C8';
	private static final char ML_H_FINA2 = '\uE8C9';
	private static final char ML_HE_ISOL = '\uE8CA';
	private static final char ML_HE_ISOL1 = '\uEA05';
	private static final char ML_HE_INIT = '\uE8CB';
	private static final char ML_HE_INIT1 = '\uEA06';
	private static final char ML_HE_MEDI = '\uE8CC';
	private static final char ML_HE_MEDI1 = '\uEA07';
	private static final char ML_HE_FINA = '\uE8CD';
	private static final char ML_HE_FINA1 = '\uEA08';
	private static final char ML_HI_ISOL = '\uE8CE';
	private static final char ML_HI_ISOL1 = '\uEA09';
	private static final char ML_HI_INIT = '\uE8CF';
	private static final char ML_HI_INIT1 = '\uEA0A';
	private static final char ML_HI_MEDI = '\uE8D0';
	private static final char ML_HI_MEDI1 = '\uEA0B';
	private static final char ML_HI_FINA = '\uE8D1';
	private static final char ML_HI_FINA1 = '\uEA0C';
	private static final char ML_HOE_ISOL = '\uE8D2';
	private static final char ML_HOE_ISOL1 = '\uEA0D';
	private static final char ML_HOE_INIT = '\uE8D3';
	private static final char ML_HOE_INIT1 = '\uEA0E';
	private static final char ML_HOE_MEDI = '\uE8D4';
	private static final char ML_HOE_MEDI1 = '\uE9D5';
	private static final char ML_HOE_MEDI2 = '\uEA0F';
	private static final char ML_HOE_FINA = '\uE8D5';
	private static final char ML_HOE_FINA1 = '\uE8D6';
	private static final char ML_HOE_FINA2 = '\uEA10';
	private static final char ML_HOE_FINA3 = '\uEA11';
	private static final char ML_HUE_ISOL = '\uE8D7';
	private static final char ML_HUE_ISOL1 = '\uEA12';
	private static final char ML_HUE_INIT = '\uE8D8';
	private static final char ML_HUE_INIT1 = '\uEA13';
	private static final char ML_HUE_MEDI = '\uE8D9';
	private static final char ML_HUE_MEDI1 = '\uE9D6';
	private static final char ML_HUE_MEDI2 = '\uEA14';
	private static final char ML_HUE_FINA = '\uE8DA';
	private static final char ML_HUE_FINA1 = '\uE8DB';
	private static final char ML_HUE_FINA2 = '\uEA15';
	private static final char ML_HUE_FINA3 = '\uEA16';
	private static final char ML_HEE_ISOL = '\uE8DC';
	private static final char ML_HEE_ISOL1 = '\uEA17';
	private static final char ML_HEE_INIT = '\uE8DD';
	private static final char ML_HEE_INIT1 = '\uEA18';
	private static final char ML_HEE_MEDI = '\uE8DE';
	private static final char ML_HEE_MEDI1 = '\uEA19';
	private static final char ML_HEE_FINA = '\uE8DF';
	private static final char ML_HEE_FINA1 = '\uEA1A';

	private static final char ML_G = '\u182D';
	private static final char ML_G_ISOL = '\uE8E0';
	private static final char ML_G_ISOL1 = '\uE8E1';
	private static final char ML_G_ISOL2 = '\uEA1B';
	private static final char ML_G_ISOL3 = '\uEA1C';
	private static final char ML_G_INIT = '\uE8E2';
	private static final char ML_G_INIT1 = '\uE8E3';
	private static final char ML_G_INIT2 = '\uEA1D';
	private static final char ML_G_INIT3 = '\uEA1E';
	private static final char ML_G_MEDI = '\uE8E4';
	private static final char ML_G_MEDI1 = '\uE8E5';
	private static final char ML_G_MEDI2 = '\uE8E6';
	private static final char ML_G_MEDI3 = '\uEA1F';
//	private static final char ML_G_MEDI3 = '\uEA04';
	private static final char ML_G_FINA = '\uE8E7';
	private static final char ML_G_FINA1 = '\uE8E8';
	private static final char ML_G_FINA2 = '\uE8E9';
	private static final char ML_GE_ISOL = '\uE8EA';
	private static final char ML_GE_ISOL1 = '\uEA05';
	private static final char ML_GE_INIT = '\uE8EB';
	private static final char ML_GE_INIT1 = '\uEA06';
	private static final char ML_GE_MEDI = '\uE8EC';
	private static final char ML_GE_MEDI1 = '\uEA07';
	private static final char ML_GE_FINA = '\uE8ED';
	private static final char ML_GE_FINA1 = '\uEA08';
	private static final char ML_GI_ISOL = '\uE8EE';
	private static final char ML_GI_ISOL1 = '\uEA09';
	private static final char ML_GI_INIT = '\uE8EF';
	private static final char ML_GI_INIT1 = '\uEA0A';
	private static final char ML_GI_MEDI = '\uE8F0';
	private static final char ML_GI_MEDI1 = '\uEA0B';
	private static final char ML_GI_FINA = '\uE8F1';
	private static final char ML_GI_FINA1 = '\uEA0C';
	private static final char ML_GOE_ISOL = '\uE8F2';
	private static final char ML_GOE_ISOL1 = '\uEA0D';
	private static final char ML_GOE_INIT = '\uE8F3';
	private static final char ML_GOE_INIT1 = '\uEA0E';
	private static final char ML_GOE_MEDI = '\uE8F4';
	private static final char ML_GOE_MEDI1 = '\uE9D7';
	private static final char ML_GOE_MEDI2 = '\uEA0F';
	private static final char ML_GOE_FINA = '\uE8F5';
	private static final char ML_GOE_FINA1 = '\uE8F6';
	private static final char ML_GOE_FINA2 = '\uEA10';
	private static final char ML_GOE_FINA3 = '\uEA11';
	private static final char ML_GUE_ISOL = '\uE8F7';
	private static final char ML_GUE_ISOL1 = '\uEA12';
	private static final char ML_GUE_INIT = '\uE8F8';
	private static final char ML_GUE_INIT1 = '\uEA13';
	private static final char ML_GUE_MEDI = '\uE8F9';
	private static final char ML_GUE_MEDI1 = '\uE9D8';
	private static final char ML_GUE_MEDI2 = '\uEA14';
	private static final char ML_GUE_FINA = '\uE8FA';
	private static final char ML_GUE_FINA1 = '\uE8FB';
	private static final char ML_GUE_FINA2 = '\uEA15';
	private static final char ML_GUE_FINA3 = '\uEA16';
	private static final char ML_GEE_ISOL = '\uE8FC';
	private static final char ML_GEE_INIT = '\uE8FD';
	private static final char ML_GEE_MEDI = '\uE8FE';
	private static final char ML_GEE_FINA = '\uE8FF';
	private static final char ML_GN_MEDI = '\uE9F2';
	private static final char ML_GM_MEDI = '\uE900';
	private static final char ML_GL_MEDI = '\uE901';

	private static final char ML_M = '\u182E';
	private static final char ML_M_ISOL = '\uE902';
	private static final char ML_M_INIT = '\uE903';
	private static final char ML_M_MEDI = '\uE904';
	private static final char ML_M_FINA = '\uE905';
	private static final char ML_MM_MEDI = '\uE9E0';
	private static final char ML_ML_MEDI = '\uE9E1';

	private static final char ML_L = '\u182F';
	private static final char ML_L_ISOL = '\uE906';
	private static final char ML_L_INIT = '\uE907';
	private static final char ML_L_MEDI = '\uE908';
	private static final char ML_L_FINA = '\uE909';
	private static final char ML_LL_MEDI = '\uE9E2';

	private static final char ML_S = '\u1830';
	private static final char ML_S_ISOL = '\uE90A';
	private static final char ML_S_INIT = '\uE90B';
	private static final char ML_S_MEDI = '\uE90C';
	private static final char ML_S_FINA = '\uE90D';
	private static final char ML_S_FINA1 = '\uE9CC';
	private static final char ML_S_FINA2 = '\uE9CD';

	private static final char ML_SH = '\u1831';
	private static final char ML_SH_ISOL = '\uE90E';
	private static final char ML_SH_INIT = '\uE90F';
	private static final char ML_SH_MEDI = '\uE910';
	private static final char ML_SH_FINA = '\uE911';

	private static final char ML_T = '\u1832';
	private static final char ML_T_ISOL = '\uE912';
	private static final char ML_T_ISOL1 = '\uE913';
	private static final char ML_T_INIT = '\uE914';
	private static final char ML_T_MEDI = '\uE915';
	private static final char ML_T_MEDI1 = '\uE916';
	private static final char ML_T_MEDI2 = '\uE917';
	private static final char ML_T_FINA = '\uE918';

	private static final char ML_D = '\u1833';
	private static final char ML_D_ISOL = '\uE919';
	private static final char ML_D_INIT = '\uE91A';
	private static final char ML_D_INIT1 = '\uE91B';
	private static final char ML_D_MEDI = '\uE91C';
	private static final char ML_D_MEDI1 = '\uE91D';
	private static final char ML_D_FINA = '\uE91E';
	private static final char ML_D_FINA1 = '\uE91F';

	private static final char ML_CH = '\u1834';
	private static final char ML_CH_ISOL = '\uE920';
	private static final char ML_CH_INIT = '\uE921';
	private static final char ML_CH_MEDI = '\uE922';
	private static final char ML_CH_FINA = '\uE923';

	private static final char ML_J = '\u1835';
	private static final char ML_J_ISOL = '\uE924';
	private static final char ML_J_ISOL1 = '\uE925';
	private static final char ML_J_INIT = '\uE926';
	private static final char ML_J_MEDI = '\uE927';
	private static final char ML_J_FINA = '\uE928';

	private static final char ML_Y = '\u1836';
	private static final char ML_Y_ISOL = '\uE929';
	private static final char ML_Y_INIT = '\uE92A';
	private static final char ML_Y_INIT1 = '\uE92B';
	private static final char ML_Y_MEDI = '\uE92C';
	private static final char ML_Y_MEDI1 = '\uEA22';
	private static final char ML_Y_FINA = '\uE92D';

	private static final char ML_R = '\u1837';
	private static final char ML_R_ISOL = '\uE92E';
	private static final char ML_R_INIT = '\uE92F';
	private static final char ML_R_MEDI = '\uE930';
	private static final char ML_R_FINA = '\uE931';

	private static final char ML_W = '\u1838';
	private static final char ML_W_ISOL = '\uE932';
	private static final char ML_W_INIT = '\uE933';
	private static final char ML_W_INIT1 = '\uE934';
	private static final char ML_W_MEDI = '\uE935';
	private static final char ML_W_FINA = '\uE936';
	private static final char ML_W_FINA1 = '\uE937';

	private static final char ML_F = '\u1839';
	private static final char ML_F_ISOL = '\uE938';
	private static final char ML_F_INIT = '\uE939';
	private static final char ML_F_MEDI = '\uE93A';
	private static final char ML_F_FINA = '\uE93B';
	private static final char ML_FA_ISOL = '\uE93C';
	private static final char ML_FA_INIT = '\uE93D';
	private static final char ML_FA_MEDI = '\uE93E';
	private static final char ML_FA_FINA = '\uE93F';
	private static final char ML_FE_ISOL = '\uE940';
	private static final char ML_FE_INIT = '\uE941';
	private static final char ML_FE_MEDI = '\uE942';
	private static final char ML_FE_FINA = '\uE943';
	private static final char ML_FI_ISOL = '\uE944';
	private static final char ML_FI_INIT = '\uE945';
	private static final char ML_FI_MEDI = '\uE946';
	private static final char ML_FI_FINA = '\uE947';
	private static final char ML_FO_ISOL = '\uE948';
	private static final char ML_FO_INIT = '\uE949';
	private static final char ML_FO_MEDI = '\uE94A';
	private static final char ML_FO_FINA = '\uE94B';
	private static final char ML_FU_ISOL = '\uE94C';
	private static final char ML_FU_INIT = '\uE94D';
	private static final char ML_FU_MEDI = '\uE94E';
	private static final char ML_FU_FINA = '\uE94F';
	private static final char ML_FOE_ISOL = '\uE950';
	private static final char ML_FOE_INIT = '\uE951';
	private static final char ML_FOE_MEDI = '\uE952';
	private static final char ML_FOE_MEDI1 = '\uE9D9';
	private static final char ML_FOE_FINA = '\uE953';
	private static final char ML_FOE_FINA1 = '\uE954';
	private static final char ML_FUE_ISOL = '\uE955';
	private static final char ML_FUE_INIT = '\uE956';
	private static final char ML_FUE_MEDI = '\uE957';
	private static final char ML_FUE_MEDI1 = '\uE9DA';
	private static final char ML_FUE_FINA = '\uE958';
	private static final char ML_FUE_FINA1 = '\uE959';
	private static final char ML_FEE_ISOL = '\uE95A';
	private static final char ML_FEE_INIT = '\uE95B';
	private static final char ML_FEE_MEDI = '\uE95C';
	private static final char ML_FEE_FINA = '\uE95D';
	private static final char ML_FN_MEDI = '\uE9F3';
	private static final char ML_FH_MEDI = '\uE9EA';
	private static final char ML_FG_MEDI = '\uE9EB';
	private static final char ML_FM_MEDI = '\uE95E';
	private static final char ML_FL_MEDI = '\uE95F';

	private static final char ML_K = '\u183A';
	private static final char ML_K_ISOL = '\uE960';
	private static final char ML_K_INIT = '\uE961';
	private static final char ML_K_MEDI = '\uE962';
	private static final char ML_K_FINA = '\uE963';
	private static final char ML_KA_ISOL = '\uE964';
	private static final char ML_KA_INIT = '\uE965';
	private static final char ML_KA_MEDI = '\uE966';
	private static final char ML_KA_FINA = '\uE967';
	private static final char ML_KE_ISOL = '\uE968';
	private static final char ML_KE_INIT = '\uE969';
	private static final char ML_KE_MEDI = '\uE96A';
	private static final char ML_KE_FINA = '\uE96B';
	private static final char ML_KI_ISOL = '\uE96C';
	private static final char ML_KI_INIT = '\uE96D';
	private static final char ML_KI_MEDI = '\uE96E';
	private static final char ML_KI_FINA = '\uE96F';
	private static final char ML_KO_ISOL = '\uE970';
	private static final char ML_KO_INIT = '\uE971';
	private static final char ML_KO_MEDI = '\uE972';
	private static final char ML_KO_FINA = '\uE973';
	private static final char ML_KU_ISOL = '\uE974';
	private static final char ML_KU_INIT = '\uE975';
	private static final char ML_KU_MEDI = '\uE976';
	private static final char ML_KU_FINA = '\uE977';
	private static final char ML_KOE_ISOL = '\uE978';
	private static final char ML_KOE_INIT = '\uE979';
	private static final char ML_KOE_MEDI = '\uE97A';
	private static final char ML_KOE_MEDI1 = '\uE9DB';
	private static final char ML_KOE_FINA = '\uE97B';
	private static final char ML_KOE_FINA1 = '\uE97C';
	private static final char ML_KUE_ISOL = '\uE97D';
	private static final char ML_KUE_INIT = '\uE97E';
	private static final char ML_KUE_MEDI = '\uE97F';
	private static final char ML_KUE_MEDI1 = '\uE9DC';
	private static final char ML_KUE_FINA = '\uE980';
	private static final char ML_KUE_FINA1 = '\uE981';
	private static final char ML_KEE_ISOL = '\uE982';
	private static final char ML_KEE_INIT = '\uE983';
	private static final char ML_KEE_MEDI = '\uE984';
	private static final char ML_KEE_FINA = '\uE985';
	private static final char ML_KN_MEDI = '\uE9F4';
	private static final char ML_KH_MEDI_ = '\uE9EC';
	private static final char ML_KG_MEDI = '\uE9ED';
	private static final char ML_KM_MEDI = '\uE986';
	private static final char ML_KL_MEDI = '\uE987';

	private static final char ML_KH = '\u183B';
	private static final char ML_KH_ISOL = '\uE988';
	private static final char ML_KH_INIT = '\uE989';
	private static final char ML_KH_MEDI = '\uE98A';
	private static final char ML_KH_FINA = '\uE98B';
	private static final char ML_KHA_ISOL = '\uE98C';
	private static final char ML_KHA_INIT = '\uE98D';
	private static final char ML_KHA_MEDI = '\uE98E';
	private static final char ML_KHA_FINA = '\uE98F';
	private static final char ML_KHE_ISOL = '\uE990';
	private static final char ML_KHE_INIT = '\uE991';
	private static final char ML_KHE_MEDI = '\uE992';
	private static final char ML_KHE_FINA = '\uE993';
	private static final char ML_KHI_ISOL = '\uE994';
	private static final char ML_KHI_INIT = '\uE995';
	private static final char ML_KHI_MEDI = '\uE996';
	private static final char ML_KHI_FINA = '\uE997';
	private static final char ML_KHO_ISOL = '\uE998';
	private static final char ML_KHO_INIT = '\uE999';
	private static final char ML_KHO_MEDI = '\uE99A';
	private static final char ML_KHO_FINA = '\uE99B';
	private static final char ML_KHU_ISOL = '\uE99C';
	private static final char ML_KHU_INIT = '\uE99D';
	private static final char ML_KHU_MEDI = '\uE99E';
	private static final char ML_KHU_FINA = '\uE99F';
	private static final char ML_KHOE_ISOL = '\uE9A0';
	private static final char ML_KHOE_INIT = '\uE9A1';
	private static final char ML_KHOE_MEDI = '\uE9A2';
	private static final char ML_KHOE_MEDI1 = '\uE9DD';
	private static final char ML_KHOE_FINA = '\uE9A3';
	private static final char ML_KHOE_FINA1 = '\uE9A4';
	private static final char ML_KHUE_ISOL = '\uE9A5';
	private static final char ML_KHUE_INIT = '\uE9A6';
	private static final char ML_KHUE_MEDI = '\uE9A7';
	private static final char ML_KHUE_MEDI1 = '\uE9DE';
	private static final char ML_KHUE_FINA = '\uE9A8';
	private static final char ML_KHUE_FINA1 = '\uE9A9';
	private static final char ML_KHEE_ISOL = '\uE9AA';
	private static final char ML_KHEE_INIT = '\uE9AB';
	private static final char ML_KHEE_MEDI = '\uE9AC';
	private static final char ML_KHEE_FINA = '\uE9AD';
	private static final char ML_KHN_MEDI = '\uE9F5';
	private static final char ML_KHH_MEDI = '\uE9EE';
	private static final char ML_KHG_MEDI = '\uE9EF';
	private static final char ML_KHM_MEDI = '\uE9AE';
	private static final char ML_KHL_MEDI = '\uE9AF';

	private static final char ML_C = '\u183C';
	private static final char ML_C_ISOL = '\uE9B0';
	private static final char ML_C_INIT = '\uE9B1';
	private static final char ML_C_MEDI = '\uE9B2';
	private static final char ML_C_FINA = '\uE9B3';

	private static final char ML_Z = '\u183D';
	private static final char ML_Z_ISOL = '\uE9B4';
	private static final char ML_Z_INIT = '\uE9B5';
	private static final char ML_Z_MEDI = '\uE9B6';
	private static final char ML_Z_FINA = '\uE9B7';

	private static final char ML_HH = '\u183E';
	private static final char ML_HH_ISOL = '\uE9B8';
	private static final char ML_HH_INIT = '\uE9B9';
	private static final char ML_HH_MEDI = '\uE9BA';
	private static final char ML_HH_FINA = '\uE9BB';

	private static final char ML_RH = '\u183F';
	private static final char ML_RH_ISOL = '\uE9BC';
	private static final char ML_RH_INIT = '\uE9BD';
	private static final char ML_RH_MEDI = '\uE9BE';
	private static final char ML_RH_FINA = '\uE9BF';

	private static final char ML_LH = '\u1840';
	private static final char ML_LH_ISOL = '\uE9C0';
	private static final char ML_LH_INIT = '\uE9C1';
	private static final char ML_LH_MEDI = '\uE9C2';
	private static final char ML_LH_FINA = '\uE9C3';

	private static final char ML_ZHI = '\u1841';
	private static final char ML_ZHI_ISOL = '\uE9C4';
	private static final char ML_ZHI_INIT = '\uE9C5';
	private static final char ML_ZHI_MEDI = '\uE9C6';
	private static final char ML_ZHI_FINA = '\uE9C7';

	private static final char ML_CHI = '\u1842';
	private static final char ML_CHI_ISOL = '\uE9C8';
	private static final char ML_CHI_INIT = '\uE9C9';
	private static final char ML_CHI_MEDI = '\uE9CA';
	private static final char ML_CHI_FINA = '\uE9CB';

	private static final char ML_T_LVS = '\u1843';
	private static final char ML_T_LVS_ISOL = '\uEB00';
	private static final char ML_T_LVS_INIT = '\uEB01';
	private static final char ML_T_LVS_MEDI = '\uEB02';
	private static final char ML_T_LVS_FINA = '\uEB03';

	private static final char ML_T_LONG_A_ISOL = '\uEAFD';
	private static final char ML_T_LONG_A_INIT = '\uEAFE';
	private static final char ML_T_LONG_A_MEDI = '\uEAFF';
	private static final char ML_T_LONG_A_FINA = '\uEB55';

	private static final char ML_T_E = '\u1844';
	private static final char ML_T_E_ISOL = '\uEB04';
	private static final char ML_T_E_INIT = '\uEB05';
	private static final char ML_T_E_MEDI = '\uEB06';
	private static final char ML_T_E_MEDI1 = '\uEB07';
	private static final char ML_T_E_FINA = '\uEB08';

	private static final char ML_T_I = '\u1845';
	private static final char ML_T_I_ISOL = '\uEB09';
	private static final char ML_T_I_INIT = '\uEB0A';
	private static final char ML_T_I_MEDI = '\uEB0B';
	private static final char ML_T_I_MEDI1 = '\uEB0C';
	private static final char ML_T_I_FINA = '\uEB0D';

	private static final char ML_T_O = '\u1846';
	private static final char ML_T_O_ISOL = '\uEB0E';
	private static final char ML_T_O_INIT = '\uEB0F';
	private static final char ML_T_O_MEDI = '\uEB10';
	private static final char ML_T_O_MEDI1 = '\uEB11';
	private static final char ML_T_O_FINA = '\uEB12';
	private static final char ML_T_LONG_O_ISOL = '\uEB57';
	private static final char ML_T_LONG_O_INIT = '\uEB56';
	private static final char ML_T_LONG_O_MEDI = '\uEBFA';
	private static final char ML_T_LONG_O_FINA = '\uEBFB';

	private static final char ML_T_U = '\u1847';
	private static final char ML_T_U_ISOL = '\uEB13';
	private static final char ML_T_U_ISOL1 = '\uEB14';
	private static final char ML_T_U_INIT = '\uEB15';
	private static final char ML_T_U_MEDI = '\uEB16';
	private static final char ML_T_U_MEDI1 = '\uEB17';
	private static final char ML_T_U_MEDI2 = '\uEB18';
	private static final char ML_T_U_FINA = '\uEB19';
	private static final char ML_T_U_FINA1 = '\uEB1A';

	private static final char ML_T_OE = '\u1848';
	private static final char ML_T_OE_ISOL = '\uEB1B';
	private static final char ML_T_OE_INIT = '\uEB1C';
	private static final char ML_T_OE_MEDI = '\uEB1D';
	private static final char ML_T_OE_MEDI1 = '\uEB1E';
	private static final char ML_T_OE_FINA = '\uEB1F';
	private static final char ML_T_LONG_OE_ISOL = '\uEBFC';
	private static final char ML_T_LONG_OE_INIT = '\uEBFD';
	private static final char ML_T_LONG_OE_MEDI = '\uEBFE';
	private static final char ML_T_LONG_OE_FINA = '\uEBFF';

	private static final char ML_T_UE = '\u1849';
	private static final char ML_T_UE_ISOL = '\uEB20';
	private static final char ML_T_UE_ISOL1 = '\uEB21';
	private static final char ML_T_UE_INIT = '\uEB22';
	private static final char ML_T_UE_MEDI = '\uEB23';
	private static final char ML_T_UE_MEDI1 = '\uEB24';
	private static final char ML_T_UE_FINA = '\uEB25';

	private static final char ML_T_NG = '\u184A';
	private static final char ML_T_NG_ISOL = '\uEB26';
	private static final char ML_T_NG_INIT = '\uEB27';
	private static final char ML_T_NG_MEDI = '\uEB28';
	private static final char ML_T_NG_FINA = '\uEB29';
	private static final char ML_T_NGN_MEDI = '\uEB2A';
	private static final char ML_T_NGM_MEDI = '\uEB2B';
	private static final char ML_T_NGL_MEDI = '\uEB2C';
	private static final char ML_T_NGQ_MEDI = '\uEB2D';
	private static final char ML_T_NGG_MEDI = '\uEB2E';
	private static final char ML_T_NGG_FINA = '\uEB2F';

	private static final char ML_T_B = '\u184B';
	private static final char ML_T_B_ISOL = '\uEB30';
	private static final char ML_T_B_INIT = '\uEB31';
	private static final char ML_T_B_MEDI = '\uEB32';
	private static final char ML_T_B_FINA = '\uEB33';
	private static final char ML_T_BA_ISOL = '\uEB34';
	private static final char ML_T_BA_INIT = '\uEB35';
	private static final char ML_T_BA_MEDI = '\uEB36';
	private static final char ML_T_BA_FINA = '\uEB37';
	private static final char ML_T_BE_ISOL = '\uEB38';
	private static final char ML_T_BE_INIT = '\uEB39';
	private static final char ML_T_BE_MEDI = '\uEB3A';
	private static final char ML_T_BE_FINA = '\uEB3B';
	private static final char ML_T_BI_ISOL = '\uEB3C';
	private static final char ML_T_BI_INIT = '\uEB3D';
	private static final char ML_T_BI_MEDI = '\uEB3E';
	private static final char ML_T_BI_FINA = '\uEB3F';
	private static final char ML_T_BO_ISOL = '\uEB40';
	private static final char ML_T_BO_INIT = '\uEB41';
	private static final char ML_T_BO_MEDI = '\uEB42';
	private static final char ML_T_BO_FINA = '\uEB43';
	private static final char ML_T_BU_ISOL = '\uEB44';
	private static final char ML_T_BU_INIT = '\uEB45';
	private static final char ML_T_BU_MEDI = '\uEB46';
	private static final char ML_T_BU_FINA = '\uEB47';
	private static final char ML_T_BOE_ISOL = '\uEB48';
	private static final char ML_T_BOE_INIT = '\uEB49';
	private static final char ML_T_BOE_MEDI = '\uEB4A';
	private static final char ML_T_BOE_FINA = '\uEB4B';
	private static final char ML_T_BUE_ISOL = '\uEB4C';
	private static final char ML_T_BUE_INIT = '\uEB4D';
	private static final char ML_T_BUE_MEDI = '\uEB4E';
	private static final char ML_T_BUE_FINA = '\uEB4F';
	private static final char ML_T_BN_MEDI = '\uEB50';
	private static final char ML_T_BM_MEDI = '\uEB51';
	private static final char ML_T_BL_MEDI = '\uEB52';
	private static final char ML_T_BQ_MEDI = '\uEB53';
	private static final char ML_T_BG_MEDI = '\uEB54';

	private static final char ML_T_P = '\u184C';
	private static final char ML_T_P_ISOL = '\uEB58';
	private static final char ML_T_P_INIT = '\uEB59';
	private static final char ML_T_P_MEDI = '\uEB5A';
	private static final char ML_T_P_FINA = '\uEB5B';
	private static final char ML_T_PA_ISOL = '\uEB5C';
	private static final char ML_T_PA_INIT = '\uEB5D';
	private static final char ML_T_PA_MEDI = '\uEB5E';
	private static final char ML_T_PA_FINA = '\uEB5F';
	private static final char ML_T_PE_ISOL = '\uEB60';
	private static final char ML_T_PE_INIT = '\uEB61';
	private static final char ML_T_PE_MEDI = '\uEB62';
	private static final char ML_T_PE_FINA = '\uEB63';
	private static final char ML_T_PI_ISOL = '\uEB64';
	private static final char ML_T_PI_INIT = '\uEB65';
	private static final char ML_T_PI_MEDI = '\uEB66';
	private static final char ML_T_PI_FINA = '\uEB67';
	private static final char ML_T_PO_ISOL = '\uEB68';
	private static final char ML_T_PO_INIT = '\uEB69';
	private static final char ML_T_PO_MEDI = '\uEB6A';
	private static final char ML_T_PO_FINA = '\uEB6B';
	private static final char ML_T_PU_ISOL = '\uEB6C';
	private static final char ML_T_PU_INIT = '\uEB6D';
	private static final char ML_T_PU_MEDI = '\uEB6E';
	private static final char ML_T_PU_FINA = '\uEB6F';
	private static final char ML_T_POE_ISOL = '\uEB70';
	private static final char ML_T_POE_INIT = '\uEB71';
	private static final char ML_T_POE_MEDI = '\uEB72';
	private static final char ML_T_POE_FINA = '\uEB73';
	private static final char ML_T_PUE_ISOL = '\uEB74';
	private static final char ML_T_PUE_INIT = '\uEB75';
	private static final char ML_T_PUE_MEDI = '\uEB76';
	private static final char ML_T_PUE_FINA = '\uEB77';

	private static final char ML_T_Q = '\u184D';
	private static final char ML_T_Q_ISOL = '\uEB78';
	private static final char ML_T_Q_INIT = '\uEB79';
	private static final char ML_T_Q_INIT1 = '\uEB7A';
	private static final char ML_T_Q_MEDI = '\uEB7B';
	private static final char ML_T_Q_MEDI1 = '\uEB7C';
	private static final char ML_T_Q_FINA = '\uEB7D';
	private static final char ML_T_QE_ISOL = '\uEB7E';
	private static final char ML_T_QE_INIT = '\uEB7F';
	private static final char ML_T_QE_MEDI = '\uEB80';
	private static final char ML_T_QE_FINA = '\uEB81';
	private static final char ML_T_QI_ISOL = '\uEB82';
	private static final char ML_T_QI_INIT = '\uEB83';
	private static final char ML_T_QI_MEDI = '\uEB84';
	private static final char ML_T_QI_FINA = '\uEB85';
	private static final char ML_T_QOE_ISOL = '\uEB86';
	private static final char ML_T_QOE_INIT = '\uEB87';
	private static final char ML_T_QOE_MEDI = '\uEB88';
	private static final char ML_T_QOE_FINA = '\uEB89';
	private static final char ML_T_QUE_ISOL = '\uEB8A';
	private static final char ML_T_QUE_INIT = '\uEB8B';
	private static final char ML_T_QUE_MEDI = '\uEB8C';
	private static final char ML_T_QUE_FINA = '\uEB8D';

	private static final char ML_T_G = '\u184E';
	private static final char ML_T_G_ISOL = '\uEB8E';
	private static final char ML_T_G_ISOL1 = '\uEB8F';
	private static final char ML_T_G_INIT = '\uEB90';
	private static final char ML_T_G_INIT1 = '\uEB91';
	private static final char ML_T_G_MEDI = '\uEB92';
	private static final char ML_T_G_MEDI1 = '\uEB93';
	private static final char ML_T_G_FINA = '\uEB94';
	private static final char ML_T_GE_ISOL = '\uEB95';
	private static final char ML_T_GE_INIT = '\uEB96';
	private static final char ML_T_GE_MEDI = '\uEB97';
	private static final char ML_T_GE_FINA = '\uEB98';
	private static final char ML_T_GI_ISOL = '\uEB99';
	private static final char ML_T_GI_INIT = '\uEB9A';
	private static final char ML_T_GI_MEDI = '\uEB9B';
	private static final char ML_T_GI_FINA = '\uEB9C';
	private static final char ML_T_GOE_ISOL = '\uEB9D';
	private static final char ML_T_GOE_INIT = '\uEB9E';
	private static final char ML_T_GOE_MEDI = '\uEB9F';
	private static final char ML_T_GOE_FINA = '\uEBA0';
	private static final char ML_T_GUE_ISOL = '\uEBA1';
	private static final char ML_T_GUE_INIT = '\uEBA2';
	private static final char ML_T_GUE_MEDI = '\uEBA3';
	private static final char ML_T_GUE_FINA = '\uEBA4';
	private static final char ML_T_GN_MEDI = '\uEBA5';
	private static final char ML_T_GM_MEDI = '\uEBA6';
	private static final char ML_T_GL_MEDI = '\uEBA7';

	private static final char ML_T_M = '\u184F';
	private static final char ML_T_M_ISOL = '\uEBA8';
	private static final char ML_T_M_INIT = '\uEBA9';
	private static final char ML_T_M_MEDI = '\uEBAA';
	private static final char ML_T_M_FINA = '\uEBAB';
	private static final char ML_T_MM_MEDI = '\uEBAC';
	private static final char ML_T_ML_MEDI = '\uEBAD';

	private static final char ML_T_T = '\u1850';
	private static final char ML_T_T_ISOL = '\uEBAE';
	private static final char ML_T_T_INIT = '\uEBAF';
	private static final char ML_T_T_MEDI = '\uEBB0';
	private static final char ML_T_T_FINA = '\uEBB1';

	private static final char ML_T_D = '\u1851';
	private static final char ML_T_D_ISOL = '\uEBB2';
	private static final char ML_T_D_INIT = '\uEBB3';
	private static final char ML_T_D_MEDI = '\uEBB4';
	private static final char ML_T_D_FINA = '\uEBB5';

	private static final char ML_T_CH = '\u1852';
	private static final char ML_T_CH_ISOL = '\uEBB6';
	private static final char ML_T_CH_INIT = '\uEBB7';
	private static final char ML_T_CH_MEDI = '\uEBB8';
	private static final char ML_T_CH_FINA = '\uEBB9';

	private static final char ML_T_J = '\u1853';
	private static final char ML_T_J_ISOL = '\uEBBA';
	private static final char ML_T_J_INIT = '\uEBBB';
	private static final char ML_T_J_MEDI = '\uEBBC';
	private static final char ML_T_J_FINA = '\uEBBD';

	private static final char ML_T_TS = '\u1854';
	private static final char ML_T_TS_ISOL = '\uEBBE';
	private static final char ML_T_TS_INIT = '\uEBBF';
	private static final char ML_T_TS_MEDI = '\uEBC0';
	private static final char ML_T_TS_FINA = '\uEBC1';

	private static final char ML_T_Y = '\u1855';
	private static final char ML_T_Y_ISOL = '\uEBC2';
	private static final char ML_T_Y_INIT = '\uEBC3';
	private static final char ML_T_Y_MEDI = '\uEBC4';
	private static final char ML_T_Y_FINA = '\uEBC5';

	private static final char ML_T_W = '\u1856';
	private static final char ML_T_W_ISOL = '\uEBC6';
	private static final char ML_T_W_INIT = '\uEBC7';
	private static final char ML_T_W_MEDI = '\uEBC8';
	private static final char ML_T_W_FINA = '\uEBC9';

	private static final char ML_T_K = '\u1857';
	private static final char ML_T_K_ISOL = '\uEBCA';
	private static final char ML_T_K_INIT = '\uEBCB';
	private static final char ML_T_K_MEDI = '\uEBCC';
	private static final char ML_T_K_FINA = '\uEBCD';
	private static final char ML_T_KA_ISOL = '\uEBCE';
	private static final char ML_T_KA_INIT = '\uEBCF';
	private static final char ML_T_KA_MEDI = '\uEBD0';
	private static final char ML_T_KA_FINA = '\uEBD1';
	private static final char ML_T_KO_ISOL = '\uEBD2';
	private static final char ML_T_KO_INIT = '\uEBD3';
	private static final char ML_T_KO_MEDI = '\uEBD4';
	private static final char ML_T_KO_FINA = '\uEBD5';
	private static final char ML_T_KU_ISOL = '\uEBD6';
	private static final char ML_T_KU_INIT = '\uEBD7';
	private static final char ML_T_KU_MEDI = '\uEBD8';
	private static final char ML_T_KU_FINA = '\uEBD9';

	private static final char ML_T_GH = '\u1858';
	private static final char ML_T_GH_ISOL = '\uEBDA';
	private static final char ML_T_GH_INIT = '\uEBDB';
	private static final char ML_T_GH_MEDI = '\uEBDC';
	private static final char ML_T_GH_FINA = '\uEBDD';
	private static final char ML_T_GHA_ISOL = '\uEBDE';
	private static final char ML_T_GHA_INIT = '\uEBDF';
	private static final char ML_T_GHA_MEDI = '\uEBE0';
	private static final char ML_T_GHA_FINA = '\uEBE1';
	private static final char ML_T_GHO_ISOL = '\uEBE2';
	private static final char ML_T_GHO_INIT = '\uEBE3';
	private static final char ML_T_GHO_MEDI = '\uEBE4';
	private static final char ML_T_GHO_FINA = '\uEBE5';
	private static final char ML_T_GHU_ISOL = '\uEBE6';
	private static final char ML_T_GHU_INIT = '\uEBE7';
	private static final char ML_T_GHU_MEDI = '\uEBE8';
	private static final char ML_T_GHU_FINA = '\uEBE9';

	private static final char ML_T_HH = '\u1859';
	private static final char ML_T_HH_ISOL = '\uEBEA';
	private static final char ML_T_HH_INIT = '\uEBEB';
	private static final char ML_T_HH_MEDI = '\uEBEC';
	private static final char ML_T_HH_FINA = '\uEBED';

	private static final char ML_T_JI = '\u185A';
	private static final char ML_T_JI_ISOL = '\uEBEE';
	private static final char ML_T_JI_INIT = '\uEBEF';
	private static final char ML_T_JI_MEDI = '\uEBF0';
	private static final char ML_T_JI_FINA = '\uEBF1';

	private static final char ML_T_NIA = '\u185B';
	private static final char ML_T_NIA_ISOL = '\uEBF2';
	private static final char ML_T_NIA_INIT = '\uEBF3';
	private static final char ML_T_NIA_MEDI = '\uEBF4';
	private static final char ML_T_NIA_FINA = '\uEBF5';

	private static final char ML_T_DZ = '\u185C';
	private static final char ML_T_DZ_ISOL = '\uEBF6';
	private static final char ML_T_DZ_INIT = '\uEBF7';
	private static final char ML_T_DZ_MEDI = '\uEBF8';
	private static final char ML_T_DZ_FINA = '\uEBF9';

	private static final char ML_S_E = '\u185D';
	private static final char ML_S_E_ISOL = '\uEC00';
	private static final char ML_S_E_INIT = '\uEC01';
	private static final char ML_S_E_MEDI = '\uEC02';
	private static final char ML_S_E_MEDI1 = '\uEC03';
	private static final char ML_S_E_FINA = '\uEC04';
	private static final char ML_S_E_FINA1 = '\uEC05';
	private static final char ML_S_E_FINA2 = '\uEC06';
	private static final char ML_S_E_FINA3 = '\uEC07';

	private static final char ML_S_I = '\u185E';
	private static final char ML_S_I_ISOL = '\uEC08';
	private static final char ML_S_I_INIT = '\uEC09';
	private static final char ML_S_I_MEDI = '\uEC0A';
	private static final char ML_S_I_MEDI1 = '\uEC0B';
	private static final char ML_S_I_MEDI2 = '\uEC0C';
	private static final char ML_S_I_FINA = '\uEC0D';
	private static final char ML_S_I_FINA1 = '\uEC0E';
	private static final char ML_S_I_FINA2 = '\uEC0F';
	private static final char ML_S_I_FINA3 = '\uEC10';

	private static final char ML_S_IY = '\u185F';
	private static final char ML_S_IY_ISOL = '\uEC11';
	private static final char ML_S_IY_INIT = '\uEC12';
	private static final char ML_S_IY_MEDI = '\uEC13';
	private static final char ML_S_IY_FINA = '\uEC14';

	private static final char ML_S_UE = '\u1860';
	private static final char ML_S_UE_ISOL = '\uEC15';
	private static final char ML_S_UE_INIT = '\uEC16';
	private static final char ML_S_UE_MEDI = '\uEC17';
	private static final char ML_S_UE_MEDI1 = '\uEC18';
	private static final char ML_S_UE_MEDI2 = '\uEC19';
	private static final char ML_S_UE_FINA = '\uEC1A';
	private static final char ML_S_UE_FINA1 = '\uEC1B';
	private static final char ML_S_UE_FINA2 = '\uEC1C';
	private static final char ML_S_UE_FINA3 = '\uEC1D';

	private static final char ML_S_U = '\u1861';
	private static final char ML_S_U_ISOL = '\uEC1E';
	private static final char ML_S_U_INIT = '\uEC1F';
	private static final char ML_S_U_MEDI = '\uEC20';
	private static final char ML_S_U_FINA = '\uEC21';

	private static final char ML_S_NG = '\u1862';
	private static final char ML_S_NG_ISOL = '\uEC22';
	private static final char ML_S_NG_INIT = '\uEC23';
	private static final char ML_S_NG_MEDI = '\uEC24';
	private static final char ML_S_NG_FINA = '\uEC25';
	private static final char ML_S_NGN_MEDI = '\uEC26';
	private static final char ML_S_NGM_MEDI = '\uEC27';
	private static final char ML_S_NGL_MEDI = '\uEC28';
	private static final char ML_S_NGK_MEDI = '\uEC29';
	private static final char ML_S_NGK_MEDI1 = '\uEC2A';
	private static final char ML_S_NGG_MEDI = '\uEC2B';
	private static final char ML_S_NGH_MEDI = '\uEC2C';

	private static final char ML_S_K = '\u1863';
	private static final char ML_S_K_ISOL = '\uEC2D';
	private static final char ML_S_K_INIT = '\uEC2E';
	private static final char ML_S_K_MEDI = '\uEC2F';
	private static final char ML_S_K_MEDI1 = '\uEC30';
	private static final char ML_S_K_FINA = '\uEC31';
	private static final char ML_S_KE_ISOL = '\uEC32';
	private static final char ML_S_KE_INIT = '\uEC33';
	private static final char ML_S_KE_MEDI = '\uEC34';
	private static final char ML_S_KE_FINA = '\uEC35';
	private static final char ML_S_KI_ISOL = '\uEC36';
	private static final char ML_S_KI_INIT = '\uEC37';
	private static final char ML_S_KI_MEDI = '\uEC38';
	private static final char ML_S_KI_FINA = '\uEC39';
	private static final char ML_S_KUE_ISOL = '\uEC3A';
	private static final char ML_S_KUE_INIT = '\uEC3B';
	private static final char ML_S_KUE_MEDI = '\uEC3C';
	private static final char ML_S_KUE_FINA = '\uEC3D';

	private static final char ML_S_G = '\u1864';
	private static final char ML_S_G_ISOL = '\uEC3E';
	private static final char ML_S_G_ISOL1 = '\uEC3F';
	private static final char ML_S_G_INIT = '\uEC40';
	private static final char ML_S_G_INIT1 = '\uEC41';
	private static final char ML_S_G_MEDI = '\uEC42';
	private static final char ML_S_G_FINA = '\uEC43';
	private static final char ML_S_GE_ISOL = '\uEC44';
	private static final char ML_S_GE_INIT = '\uEC45';
	private static final char ML_S_GE_MEDI = '\uEC46';
	private static final char ML_S_GE_FINA = '\uEC47';
	private static final char ML_S_GI_ISOL = '\uEC48';
	private static final char ML_S_GI_INIT = '\uEC49';
	private static final char ML_S_GI_MEDI = '\uEC4A';
	private static final char ML_S_GI_FINA = '\uEC4B';
	private static final char ML_S_GUE_ISOL = '\uEC4C';
	private static final char ML_S_GUE_INIT = '\uEC4D';
	private static final char ML_S_GUE_MEDI = '\uEC4E';
	private static final char ML_S_GUE_FINA = '\uEC4F';

	private static final char ML_S_H = '\u1865';
	private static final char ML_S_H_ISOL = '\uEC50';
	private static final char ML_S_H_ISOL1 = '\uEC51';
	private static final char ML_S_H_INIT = '\uEC52';
	private static final char ML_S_H_INIT1 = '\uEC53';
	private static final char ML_S_H_MEDI = '\uEC54';
	private static final char ML_S_H_MEDI1 = '\uEC55';
	private static final char ML_S_H_FINA = '\uEC56';
	private static final char ML_S_HE_ISOL = '\uEC58';
	private static final char ML_S_HE_INIT = '\uEC59';
	private static final char ML_S_HE_MEDI = '\uEC5A';
	private static final char ML_S_HE_FINA = '\uEC5B';
	private static final char ML_S_HI_ISOL = '\uEC5C';
	private static final char ML_S_HI_INIT = '\uEC5D';
	private static final char ML_S_HI_MEDI = '\uEC5E';
	private static final char ML_S_HI_FINA = '\uEC5F';
	private static final char ML_S_HUE_ISOL = '\uEC60';
	private static final char ML_S_HUE_INIT = '\uEC61';
	private static final char ML_S_HUE_MEDI = '\uEC62';
	private static final char ML_S_HUE_FINA = '\uEC63';

	private static final char ML_S_BE_ISOL = '\uEC64';
	private static final char ML_S_BE_INIT = '\uEC65';
	private static final char ML_S_BE_MEDI = '\uEC66';
	private static final char ML_S_BE_FINA = '\uEC67';
	private static final char ML_S_BI_ISOL = '\uEC68';
	private static final char ML_S_BI_INIT = '\uEC69';
	private static final char ML_S_BI_MEDI = '\uEC6A';
	private static final char ML_S_BI_FINA = '\uEC6B';
	private static final char ML_S_BUE_ISOL = '\uEC6C';
	private static final char ML_S_BUE_INIT = '\uEC6D';
	private static final char ML_S_BUE_MEDI = '\uEC6E';
	private static final char ML_S_BUE_FINA = '\uEC6F';
	private static final char ML_S_BU_ISOL = '\uEC70';
	private static final char ML_S_BU_INIT = '\uEC71';
	private static final char ML_S_BU_MEDI = '\uEC72';
	private static final char ML_S_BU_FINA = '\uEC73';

	private static final char ML_S_P = '\u1866';
	private static final char ML_S_P_ISOL = '\uEC74';
	private static final char ML_S_P_INIT = '\uEC75';
	private static final char ML_S_P_MEDI = '\uEC76';
	private static final char ML_S_P_FINA = '\uEC77';
	private static final char ML_S_PA_ISOL = '\uEC78';
	private static final char ML_S_PA_INIT = '\uEC79';
	private static final char ML_S_PA_MEDI = '\uEC7A';
	private static final char ML_S_PA_FINA = '\uEC7B';
	private static final char ML_S_PE_ISOL = '\uEC7C';
	private static final char ML_S_PE_INIT = '\uEC7D';
	private static final char ML_S_PE_MEDI = '\uEC7E';
	private static final char ML_S_PE_FINA = '\uEC7F';
	private static final char ML_S_PI_ISOL = '\uEC80';
	private static final char ML_S_PI_INIT = '\uEC81';
	private static final char ML_S_PI_MEDI = '\uEC82';
	private static final char ML_S_PI_FINA = '\uEC83';
	private static final char ML_S_PO_ISOL = '\uEC84';
	private static final char ML_S_PO_INIT = '\uEC85';
	private static final char ML_S_PO_MEDI = '\uEC86';
	private static final char ML_S_PO_FINA = '\uEC87';
	private static final char ML_S_PUE_ISOL = '\uEC88';
	private static final char ML_S_PUE_INIT = '\uEC89';
	private static final char ML_S_PUE_MEDI = '\uEC8A';
	private static final char ML_S_PUE_FINA = '\uEC8B';
	private static final char ML_S_PU_ISOL = '\uEC8C';
	private static final char ML_S_PU_INIT = '\uEC8D';
	private static final char ML_S_PU_MEDI = '\uEC8E';
	private static final char ML_S_PU_FINA = '\uEC8F';

	private static final char ML_S_SH = '\u1867';
	private static final char ML_S_SH_ISOL = '\uEC90';
	private static final char ML_S_SH_INIT = '\uEC91';
	private static final char ML_S_SH_MEDI = '\uEC92';
	private static final char ML_S_SH_FINA = '\uEC93';

	private static final char ML_S_T = '\u1868';
	private static final char ML_S_T_ISOL = '\uEC94';
	private static final char ML_S_T_ISOL1 = '\uEC95';
	private static final char ML_S_T_INIT = '\uEC96';
	private static final char ML_S_T_INIT1 = '\uEC97';
	private static final char ML_S_T_MEDI = '\uEC98';
	private static final char ML_S_T_MEDI1 = '\uEC99';
	private static final char ML_S_T_MEDI2 = '\uEC9A';
	private static final char ML_S_T_FINA = '\uEC9B';

	private static final char ML_S_D = '\u1869';
	private static final char ML_S_D_ISOL = '\uEC9C';
	private static final char ML_S_D_INIT = '\uEC9D';
	private static final char ML_S_D_INIT1 = '\uEC9E';
	private static final char ML_S_D_MEDI = '\uEC9F';
	private static final char ML_S_D_MEDI1 = '\uECA0';
	private static final char ML_S_D_FINA = '\uECA1';

	private static final char ML_S_J = '\u186A';
	private static final char ML_S_J_ISOL = '\uECA2';
	private static final char ML_S_J_INIT = '\uECA3';
	private static final char ML_S_J_MEDI = '\uECA4';
	private static final char ML_S_J_FINA = '\uECA5';

	private static final char ML_S_F = '\u186B';
	private static final char ML_S_F_ISOL = '\uECA6';
	private static final char ML_S_F_INIT = '\uECA7';
	private static final char ML_S_F_MEDI = '\uECA8';
	private static final char ML_S_F_FINA = '\uECA9';

	private static final char ML_S_GH = '\u186C';
	private static final char ML_S_GH_ISOL = '\uECAA';
	private static final char ML_S_GH_INIT = '\uECAB';
	private static final char ML_S_GH_MEDI = '\uECAC';
	private static final char ML_S_GH_FINA = '\uECAD';
	private static final char ML_S_GHA_ISOL = '\uECAE';
	private static final char ML_S_GHA_INIT = '\uECAF';
	private static final char ML_S_GHA_MEDI = '\uECB0';
	private static final char ML_S_GHA_FINA = '\uECB1';
	private static final char ML_S_GHO_ISOL = '\uECB2';
	private static final char ML_S_GHO_INIT = '\uECB3';
	private static final char ML_S_GHO_MEDI = '\uECB4';
	private static final char ML_S_GHO_FINA = '\uECB5';
	// private static final char ML_S_GHE_ISOL = '\uECB6';
	// private static final char ML_S_GHE_INIT = '\uECB7';
	// private static final char ML_S_GHE_MEDI = '\uECB8';
	// private static final char ML_S_GHE_FINA = '\uECB9';
	// private static final char ML_S_GHI_ISOL = '\uECBA';
	// private static final char ML_S_GHI_INIT = '\uECBB';
	// private static final char ML_S_GHI_MEDI = '\uECBC';
	// private static final char ML_S_GHI_FINA = '\uECBD';
	// private static final char ML_S_GHUE_ISOL = '\uECBE';
	// private static final char ML_S_GHUE_INIT = '\uECBF';
	// private static final char ML_S_GHUE_MEDI = '\uECC0';
	// private static final char ML_S_GHUE_FINA = '\uECC1';

	private static final char ML_S_HH = '\u186D';
	private static final char ML_S_HH_ISOL = '\uECC2';
	private static final char ML_S_HH_INIT = '\uECC3';
	private static final char ML_S_HH_MEDI = '\uECC4';
	private static final char ML_S_HH_FINA = '\uECC5';
	private static final char ML_S_HHA_ISOL = '\uECC6';
	private static final char ML_S_HHA_INIT = '\uECC7';
	private static final char ML_S_HHA_MEDI = '\uECC8';
	private static final char ML_S_HHA_FINA = '\uECC9';
	private static final char ML_S_HHO_ISOL = '\uECCA';
	private static final char ML_S_HHO_INIT = '\uECCB';
	private static final char ML_S_HHO_MEDI = '\uECCC';
	private static final char ML_S_HHO_FINA = '\uECCD';
	// private static final char ML_S_HHE_ISOL = '\uECCE';
	// private static final char ML_S_HHE_INIT = '\uECCF';
	// private static final char ML_S_HHE_MEDI = '\uECD0';
	// private static final char ML_S_HHE_FINA = '\uECD1';
	// private static final char ML_S_HHI_ISOL = '\uECD2';
	// private static final char ML_S_HHI_INIT = '\uECD3';
	// private static final char ML_S_HHI_MEDI = '\uECD4';
	// private static final char ML_S_HHI_FINA = '\uECD5';
	// private static final char ML_S_HHUE_ISOL = '\uECD6';
	// private static final char ML_S_HHUE_INIT = '\uECD7';
	// private static final char ML_S_HHUE_MEDI = '\uECD8';
	// private static final char ML_S_HHUE_FINA = '\uECD9';

	private static final char ML_S_TS = '\u186E';
	private static final char ML_S_TS_ISOL = '\uECDA';
	private static final char ML_S_TS_INIT = '\uECDB';
	private static final char ML_S_TS_MEDI = '\uECDC';
	private static final char ML_S_TS_FINA = '\uECDD';

	private static final char ML_S_Z = '\u186F';
	private static final char ML_S_Z_ISOL = '\uECDE';
	private static final char ML_S_Z_INIT = '\uECDF';
	private static final char ML_S_Z_INIT1 = '\uECE0';
	private static final char ML_S_Z_MEDI = '\uECE1';
	private static final char ML_S_Z_MEDI1 = '\uECE2';
	private static final char ML_S_Z_FINA = '\uECE3';

	private static final char ML_S_RH = '\u1870';
	private static final char ML_S_RH_ISOL = '\uECE4';
	private static final char ML_S_RH_INIT = '\uECE5';
	private static final char ML_S_RH_MEDI = '\uECE6';
	private static final char ML_S_RH_FINA = '\uECE7';

	private static final char ML_S_CH = '\u1871';
	private static final char ML_S_CH_ISOL = '\uECE8';
	private static final char ML_S_CH_INIT = '\uECE9';
	private static final char ML_S_CH_MEDI = '\uECEA';
	private static final char ML_S_CH_FINA = '\uECEB';

	private static final char ML_S_ZH = '\u1872';
	private static final char ML_S_ZH_ISOL = '\uECEC';
	private static final char ML_S_ZH_INIT = '\uECED';
	private static final char ML_S_ZH_MEDI = '\uECEE';
	private static final char ML_S_ZH_FINA = '\uECEF';

	private static final char ML_M_I = '\u1873';
	private static final char ML_M_I_ISOL = '\uED00';
	private static final char ML_M_I_INIT = '\uED01';
	private static final char ML_M_I_MEDI = '\uED02';
	private static final char ML_M_I_MEDI1 = '\uED03';
	private static final char ML_M_I_MEDI2 = '\uED04';
	private static final char ML_M_I_MEDI3 = '\uED05';
	private static final char ML_M_I_FINA = '\uED06';
	private static final char ML_M_I_FINA1 = '\uED07';
	private static final char ML_M_I_FINA2 = '\uED08';
	private static final char ML_M_I_FINA3 = '\uED09';
	private static final char ML_M_I_FINA4 = '\uED0A';

	private static final char ML_M_K = '\u1874';
	private static final char ML_M_K_ISOL = '\uED0B';
	private static final char ML_M_K_INIT = '\uED0C';
	private static final char ML_M_K_MEDI = '\uED0D';
	private static final char ML_M_K_MEDI1 = '\uED0E';
	private static final char ML_M_K_MEDI2 = '\uED0F';
	private static final char ML_M_K_MEDI3 = '\uED10';
	private static final char ML_M_K_FINA = '\uED11';
	private static final char ML_M_K_FINA1 = '\uED12';
	private static final char ML_M_K_FINA2 = '\uED13';
	private static final char ML_M_KE_ISOL = '\uED14';
	private static final char ML_M_KE_INIT = '\uED15';
	private static final char ML_M_KE_MEDI = '\uED16';
	private static final char ML_M_KE_FINA = '\uED17';
	private static final char ML_M_KI_ISOL = '\uED18';
	private static final char ML_M_KI_INIT = '\uED19';
	private static final char ML_M_KI_MEDI = '\uED1A';
	private static final char ML_M_KI_FINA = '\uED1B';
	private static final char ML_M_KUE_ISOL = '\uED1C';
	private static final char ML_M_KUE_INIT = '\uED1D';
	private static final char ML_M_KUE_MEDI = '\uED1E';
	private static final char ML_M_KUE_FINA = '\uED1F';

	private static final char ML_M_GI_ISOL = '\uED20';
	private static final char ML_M_GI_INIT = '\uED21';
	private static final char ML_M_GI_MEDI = '\uED22';
	private static final char ML_M_GI_FINA = '\uED23';

	private static final char ML_M_BI_ISOL = '\uED24';
	private static final char ML_M_BI_INIT = '\uED25';
	private static final char ML_M_BI_MEDI = '\uED26';
	private static final char ML_M_BI_FINA = '\uED27';

	private static final char ML_M_PI_ISOL = '\uED28';
	private static final char ML_M_PI_INIT = '\uED29';
	private static final char ML_M_PI_MEDI = '\uED2A';
	private static final char ML_M_PI_FINA = '\uED2B';

	private static final char ML_M_R = '\u1875';
	private static final char ML_M_R_ISOL = '\uED2C';
	private static final char ML_M_R_INIT = '\uED2D';
	private static final char ML_M_R_MEDI = '\uED2E';
	private static final char ML_M_R_FINA = '\uED2F';

	private static final char ML_M_F = '\u1876';
	private static final char ML_M_F_ISOL = '\uED30';
	private static final char ML_M_F_INIT = '\uED31';
	private static final char ML_M_F_MEDI = '\uED32';
	private static final char ML_M_F_MEDI1 = '\uED33';
	private static final char ML_M_F_FINA = '\uED34';

	private static final char ML_M_ZH = '\u1877';
	private static final char ML_M_ZH_ISOL = '\uED35';
	private static final char ML_M_ZH_INIT = '\uED36';
	private static final char ML_M_ZH_MEDI = '\uED37';
	private static final char ML_M_ZH_FINA = '\uED38';

	// private static final char ML_ALI_GALI_ANUSVARA_ONE = '\u1880';
	// private static final char ML_ALI_GALI_VISARGA_ONE = '\u1881';
	// private static final char ML_ALI_GALI_DAMARU = '\u1882';
	// private static final char ML_ALI_GALI_UBADAMA = '\u1883';
	// private static final char ML_ALI_GALI_INVERTED_UBADAMA = '\u1884';
	// private static final char ML_ALI_GALI_BALUDA = '\u1885';
	// private static final char ML_ALI_GALI_THREE_BALUDA = '\u1886';
	// private static final char ML_ALI_GALI_A = '\u1887';
	// private static final char ML_ALI_GALI_I = '\u1888';
	// private static final char ML_ALI_GALI_KA = '\u1889';
	// private static final char ML_ALI_GALI_NGA = '\u188A';
	// private static final char ML_ALI_GALI_CA = '\u188B';
	// private static final char ML_ALI_GALI_TTA = '\u188C';
	// private static final char ML_ALI_GALI_TTHA = '\u188D';
	// private static final char ML_ALI_GALI_DDA = '\u188E';
	// private static final char ML_ALI_GALI_NNA = '\u188F';
	// private static final char ML_ALI_GALI_TA = '\u1890';
	// private static final char ML_ALI_GALI_DA = '\u1891';
	// private static final char ML_ALI_GALI_PA = '\u1892';
	// private static final char ML_ALI_GALI_PHA = '\u1893';
	// private static final char ML_ALI_GALI_SSA = '\u1894';
	// private static final char ML_ALI_GALI_ZHA = '\u1895';
	// private static final char ML_ALI_GALI_ZA = '\u1896';
	// private static final char ML_ALI_GALI_AH = '\u1897';
	// private static final char ML_T_ALI_GALI_TA = '\u1898';
	// private static final char ML_T_ALI_GALI_ZHA = '\u1899';
	// private static final char ML_M_ALI_GALI_GHA = '\u189A';
	// private static final char ML_M_ALI_GALI_NGA = '\u189B';
	// private static final char ML_M_ALI_GALI_CA = '\u189C';
	// private static final char ML_M_ALI_GALI_JHA = '\u189D';
	// private static final char ML_M_ALI_GALI_TTA = '\u189E';
	// private static final char ML_M_ALI_GALI_DDHA = '\u189F';
	// private static final char ML_M_ALI_GALI_TA = '\u18A0';
	// private static final char ML_M_ALI_GALI_DHA = '\u18A1';
	// private static final char ML_M_ALI_GALI_SSA = '\u18A2';
	// private static final char ML_M_ALI_GALI_CYA = '\u18A3';
	// private static final char ML_M_ALI_GALI_ZHA = '\u18A4';
	// private static final char ML_M_ALI_GALI_ZA = '\u18A5';
	// private static final char ML_ALI_GALI_HALF_U = '\u18A6';
	// private static final char ML_ALI_GALI_HALF_YA = '\u18A7';
	// private static final char ML_M_ALI_GALI_BHA = '\u18A8';
	// private static final char ML_ALI_GALI_DAGALGA = '\u18A9';
	// private static final char ML_M_ALI_GALI_LHA = '\u18AA';

	private static final char ML_ZWJ = '\u200D';
	private static final char ML_NNBS = '\u202F';

	private static final String ML_NO_BREAK = "" + ML_NNBS;

	private static final String MS_MVS_A = "" + M_MVS + ML_A;
	private static final String MS_MVS_E = "" + M_MVS + ML_E;

	private static final char PLACE_HOLDER = ML_ZWJ;

	@SuppressWarnings("serial")
	private static final Map<String, String> DGBR_MAP = new HashMap<String, String>() {
		{
			// A
			put("" + ML_A, "" + ML_A_FINA2);
			// ACHA
			put("" + ML_A + ML_CH + ML_A, "" + ML_A_INIT1 + ML_CH_MEDI + ML_A_FINA);
			// ACHAGAN
			put("" + ML_A + ML_CH + ML_A + ML_G + ML_A + ML_N, "" + ML_A_INIT1 + ML_CH_MEDI + ML_A_MEDI + ML_G_MEDI1 + ML_A_MEDI + ML_N_FINA);
			// E
			put("" + ML_E, "" + ML_E_FINA2);
			// ECHE
			put("" + ML_E + ML_CH + ML_E, "" + ML_E_INIT + ML_CH_MEDI + ML_E_FINA);
			// ECHEGEN
			put("" + ML_E + ML_CH + ML_E + ML_G + ML_E + ML_N, "" + ML_E_INIT + ML_CH_MEDI + ML_E_MEDI + ML_GE_MEDI + PLACE_HOLDER + ML_N_FINA);
			// I
			put("" + ML_I, "" + ML_I_ISOL1);
			// IYAN
			put("" + ML_I + ML_Y + ML_A + ML_N, "" + ML_I_INIT1 + ML_Y_MEDI1 + ML_A_MEDI + ML_N_FINA);
			// IYEN
			put("" + ML_I + ML_Y + ML_E + ML_N, "" + ML_I_INIT1 + ML_Y_MEDI1 + ML_E_MEDI + ML_N_FINA);
			// IYAR
			put("" + ML_I + ML_Y + ML_A + ML_R, "" + ML_I_INIT1 + ML_Y_MEDI1 + ML_A_MEDI + ML_R_FINA);
			// IYER
			put("" + ML_I + ML_Y + ML_E + ML_R, "" + ML_I_INIT1 + ML_Y_MEDI1 + ML_E_MEDI + ML_R_FINA);
			// YIAN
			put("" + ML_Y + ML_I + ML_A + ML_N, "" + ML_Y_INIT1 + ML_I_MEDI + ML_A_MEDI + ML_N_FINA);
			// YIEN
			put("" + ML_Y + ML_I + ML_E + ML_N, "" + ML_Y_INIT1 + ML_I_MEDI + ML_E_MEDI + ML_N_FINA);
			// YIAR
			put("" + ML_Y + ML_I + ML_A + ML_R, "" + ML_Y_INIT1 + ML_I_MEDI + ML_A_MEDI + ML_R_FINA);
			// YIER
			put("" + ML_Y + ML_I + ML_E + ML_R, "" + ML_Y_INIT1 + ML_I_MEDI + ML_E_MEDI + ML_R_FINA);
			// U
			put("" + ML_U, "" + ML_U_ISOL1);
			// UU
			put("" + ML_U + ML_U, "" + ML_U_INIT1 + ML_U_FINA);
			// UE
			put("" + ML_UE, "" + ML_UE_ISOL2);
			// UEUE
			put("" + ML_UE + ML_UE, "" + ML_UE_INIT1 + ML_UE_FINA);
			// UN
			put("" + ML_U + ML_N, "" + ML_U_INIT1 + ML_N_FINA);
			// UEN
			put("" + ML_UE + ML_N, "" + ML_UE_INIT1 + ML_N_FINA);
			// UD
			put("" + ML_U + ML_D, "" + ML_U_INIT1 + ML_D_FINA);
			// UED
			put("" + ML_UE + ML_D, "" + ML_UE_INIT1 + ML_D_FINA);
			// BAN
			put("" + ML_B + ML_A + ML_N, "" + ML_BA_INIT + PLACE_HOLDER + ML_N_FINA);
			// BEN
			put("" + ML_B + ML_E + ML_N, "" + ML_BA_INIT + PLACE_HOLDER + ML_N_FINA);
			// BAR
			put("" + ML_B + ML_A + ML_R, "" + ML_BA_INIT + PLACE_HOLDER + ML_R_FINA);
			// BER
			put("" + ML_B + ML_E + ML_R, "" + ML_BA_INIT + PLACE_HOLDER + ML_R_FINA);
			// NAR
			put("" + ML_N + ML_A + ML_R, "" + ML_N_INIT + ML_A_MEDI + ML_R_FINA);
			// NER
			put("" + ML_N + ML_E + ML_R, "" + ML_N_INIT + ML_E_MEDI + ML_R_FINA);
			// NUGAN
			put("" + ML_N + ML_U + ML_G + ML_A + ML_N, "" + ML_N_INIT + ML_U_MEDI + ML_G_MEDI1 + ML_A_MEDI + ML_N_FINA);
			// NUEGEN
			put("" + ML_N + ML_UE + ML_G + ML_E + ML_N, "" + ML_N_INIT + ML_UE_MEDI + ML_GE_MEDI + PLACE_HOLDER + ML_N_FINA);
			// NUGUD
			put("" + ML_N + ML_U + ML_G + ML_U + ML_D, "" + ML_N_INIT + ML_U_MEDI + ML_G_MEDI1 + ML_U_MEDI + ML_D_FINA);
			// NUEGUED
			put("" + ML_N + ML_UE + ML_G + ML_UE + ML_D, "" + ML_N_INIT + ML_UE_MEDI + ML_GUE_MEDI + PLACE_HOLDER + ML_D_FINA);
			// DA
			put("" + ML_D + ML_A, "" + ML_D_INIT1 + ML_A_FINA);
			// DAHI
			put("" + ML_D + ML_A + ML_H + ML_I, "" + ML_D_INIT1 + ML_A_MEDI + ML_HI_FINA);
			// DAGAN
			put("" + ML_D + ML_A + ML_G + ML_A + ML_N, "" + ML_D_INIT1 + ML_A_MEDI + ML_G_MEDI1 + ML_A_MEDI + ML_N_FINA);
			// DE
			put("" + ML_D + ML_E, "" + ML_D_INIT1 + ML_E_FINA);
			// DEHI
			put("" + ML_D + ML_E + ML_H + ML_I, "" + ML_D_INIT1 + ML_E_MEDI + ML_HI_FINA + PLACE_HOLDER);
			// DEGEN
			put("" + ML_D + ML_E + ML_G + ML_E + ML_N, "" + ML_D_INIT1 + ML_E_MEDI + ML_GE_MEDI + PLACE_HOLDER + ML_N_FINA);
			// DU
			put("" + ML_D + ML_U, "" + ML_D_INIT1 + ML_U_FINA);
			// DUE
			put("" + ML_D + ML_UE, "" + ML_D_INIT1 + ML_UE_FINA);
			// DUNI
			put("" + ML_D + ML_U + ML_N + ML_I, "" + ML_D_INIT1 + ML_U_MEDI + ML_N_MEDI1 + ML_I_FINA);
			// DUENI
			put("" + ML_D + ML_UE + ML_N + ML_I, "" + ML_D_INIT1 + ML_UE_MEDI + ML_N_MEDI1 + ML_I_FINA);
			// DUR
			put("" + ML_D + ML_U + ML_R, "" + ML_D_INIT1 + ML_U_MEDI + ML_R_FINA);
			// DUER
			put("" + ML_D + ML_UE + ML_R, "" + ML_D_INIT1 + ML_U_MEDI + ML_R_FINA);
			// MINI
			put("" + ML_M + ML_I + ML_N + ML_I, "" + ML_M_INIT + ML_I_MEDI + ML_N_MEDI1 + ML_I_FINA);
			// CHINI
			put("" + ML_CH + ML_I + ML_N + ML_I, "" + ML_CH_INIT + ML_I_MEDI + ML_N_MEDI1 + ML_I_FINA);
			// NI
			put("" + ML_N + ML_I, "" + ML_N_INIT + ML_I_FINA);
			// LUGA
			put("" + ML_L + ML_U + ML_G + M_MVS + ML_A, "" + ML_L_INIT + ML_U_MEDI + ML_G_FINA1 + M_MVS_ISOL + ML_A_FINA2);
			// LUEGE
			put("" + ML_L + ML_UE + ML_G + ML_E, "" + ML_L_INIT + ML_U_MEDI + ML_GE_FINA + PLACE_HOLDER);
			// TAI
			put("" + ML_T + ML_A + ML_I, "" + ML_T_INIT + ML_A_MEDI + ML_I_FINA);
			// TEI
			put("" + ML_T + ML_E + ML_I, "" + ML_T_INIT + ML_E_MEDI + ML_I_FINA);
			// TU
			put("" + ML_T + ML_U, "" + ML_T_INIT + ML_U_FINA);
			// TUNI
			put("" + ML_T + ML_U + ML_N + ML_I, "" + ML_T_INIT + ML_U_MEDI + ML_N_MEDI1 + ML_I_FINA);
			// TUE
			put("" + ML_T + ML_UE, "" + ML_T_INIT + ML_UE_FINA);
			// TUENI
			put("" + ML_T + ML_UE + ML_N + ML_I, "" + ML_T_INIT + ML_U_MEDI + ML_N_MEDI1 + ML_I_FINA);
			// TUR
			put("" + ML_T + ML_U + ML_R, "" + ML_T_INIT + ML_U_MEDI + ML_R_FINA);
			// TUER
			put("" + ML_T + ML_UE + ML_R, "" + ML_T_INIT + ML_U_MEDI + ML_R_FINA);
			// YI
			put("" + ML_Y + ML_I, "" + ML_Y_INIT1 + ML_I_FINA);
			// YIN
			put("" + ML_Y + ML_I + ML_N, "" + ML_Y_INIT1 + ML_I_MEDI + ML_N_FINA);
			// YUEGEN
			put("" + ML_Y + ML_UE + ML_G + ML_E + ML_N, "" + ML_Y_INIT + ML_U_MEDI + ML_GE_MEDI + PLACE_HOLDER + ML_N_FINA);
			// UEGEI
			put("" + ML_UE + ML_G + ML_E + ML_I, "" + ML_UE_INIT + ML_GE_MEDI + ML_I_FINA);
		}
	};

	private static Map<String, String> latinMongolianMap = new LinkedHashMap<String, String>() { 

		/** serialVersionUID */
		private static final long serialVersionUID = 1L;

		{
	        put("Q", "\u1801"); // ᠁
	        put(",", "\u1802"); // ᠂
	        put(".", "\u1803"); // ᠃
	        put(":", "\u1804"); // :
	        put("I", "\u180A"); // ᠊
	        put("&", "\u180A"); // ᠊
	        put("D", "\u180B"); // FVS1
	        put("'", "\u180B"); // FVS1
	        put("F", "\u180C"); // FVS2
	        put("\"", "\u180C"); // FVS2
	        put("G", "\u180D"); // FVS3
	        put("`", "\u180D"); // FVS3
	        put("A", "\u180E"); // MVS
	        put("_", "\u180E"); // MVS
//	        put("0", "\u1810"); // ᠐
//	        put("1", "\u1811"); // ᠑
//	        put("2", "\u1812"); // ᠒
//	        put("3", "\u1813"); // ᠓
//	        put("4", "\u1814"); // ᠔
//	        put("5", "\u1815"); // ᠕
//	        put("6", "\u1816"); // ᠖
//	        put("7", "\u1817"); // ᠗
//	        put("8", "\u1818"); // ᠘
//	        put("9", "\u1819"); // ᠙
	        put("a", "\u1820"); // ᠠ
	        put("e", "\u1821"); // ᠡ
	        put("i", "\u1822"); // ᠢ
	        put("w", "\u1823"); // ᠣ
	        put("v", "\u1824"); // ᠤ
	        put("o", "\u1825"); // ᠥ
	        put("u", "\u1826"); // ᠦ
	        put("E", "\u1827"); // ᠧ
	        put("n", "\u1828"); // ᠨ
	        put("N", "\u1829"); // ᠩ
	        put("b", "\u182A"); // ᠪ
	        put("p", "\u182B"); // ᠫ
	        put("h", "\u182C"); // ᠬ
	        put("g", "\u182D"); // ᠭ
	        put("m", "\u182E"); // ᠮ
	        put("l", "\u182F"); // ᠯ
	        put("s", "\u1830"); // ᠰ
	        put("^", "\u200C"); // 
	        put("*", "\u200D"); // 
	        put("S", "\u202F"); // 
	        put("-", "\u202F"); // 
	        put("x", "\u1831"); // ᠱ
	        put("t", "\u1832"); // ᠲ
	        put("d", "\u1833"); // ᠳ
	        put("q", "\u1834"); // ᠴ
	        put("j", "\u1835"); // ᠵ
	        put("y", "\u1836"); // ᠶ
	        put("r", "\u1837"); // ᠷ
	        put("W", "\u1838"); //  ᠸ
	        put("f", "\u1839"); // ᠹ
	        put("k", "\u183A"); // ᠺ
	        put("K", "\u183B"); // ᠻ
	        put("c", "\u183C"); // ᠼ
	        put("z", "\u183D"); // ᠽ
	        put("H", "\u183E"); // ᠾ
	        put("R", "\u183F"); // ᠿ
	        put("L", "\u1840"); // ᡀ
	        put("Z", "\u1841"); // ᡁ
	        put("C", "\u1842"); // ᡂ
	        put("/", "\u1805"); // 
	        put("!", "︕");
	        put("?", "︖");
	        put("<", "≪");
	        put(">", "≫");
	        put("[", "︿");
	        put("]", "﹀");
		}
	};

	private static Map<String, String> mongolianLatinMap = new LinkedHashMap<String, String>() { 

		/** serialVersionUID */
		private static final long serialVersionUID = 1L;

		{
			for (Map.Entry<String, String> entry : latinMongolianMap.entrySet()) {
		        put(entry.getValue(), entry.getKey());
			}
		}
	};

	private static final int ISOL = 0;
	private static final int INIT = 1;
	private static final int MEDI = 2;
	private static final int FINA = 3;

	public static String convert(String srcdoc) {
		Map<String, String> map = new HashMap<String, String>();
		StringBuffer sbConvertedDoc = new StringBuffer();
		StringBuffer sb = new StringBuffer();
		char nextChar = ' ';
		int len = srcdoc.length();
		for (int i = 0; i < len; i++) {
			char ch = srcdoc.charAt(i);
			if ( i< (len-1) ) {
				nextChar = srcdoc.charAt(i+1);
			}
			if (isMongolian(ch)) {
				sb.append(ch);
			} else {
				if (sb.length() > 0) {
					String words = sb.toString();
					if (map.containsKey(words)) {
						sbConvertedDoc.append(map.get(words));
					} else {
						String convertedWord = convertWords(words);
						sbConvertedDoc.append(convertedWord);
						map.put(words, convertedWord);
					}
					sb = new StringBuffer("");
				}
				switch( ch ) {
				case EXCLAM:
					if (nextChar == QUESTION) {
						sbConvertedDoc.append(M_EXCLAM_QUESTION_ISOL);
						sbConvertedDoc.append( PLACE_HOLDER );
						i++;
					} else {
						sbConvertedDoc.append(M_EXCLAM_ISOL);
					}
					break;

				case COMMA:
					sbConvertedDoc.append(M_COMMA_ISOL1);
					break;

				case QUESTION:
					if (nextChar == EXCLAM) {
						sbConvertedDoc.append(M_QUESTION_EXCLAM_ISOL);
						sbConvertedDoc.append( PLACE_HOLDER );
						i++;
					} else {
						sbConvertedDoc.append(M_QUESTION_ISOL);
					}
					break;

				case COLON:
					sbConvertedDoc.append(M_COLON_ISOL);
					break;

				case SEMICOLON:
					sbConvertedDoc.append(M_SEMICOLON_ISOL);
					break;

				case M_BIRGA:
					if (nextChar == M_FVS1) {
						sbConvertedDoc.append(M_BIRGA1);
					} else if (nextChar == M_FVS2) {
						sbConvertedDoc.append(M_BIRGA2);
					} else if (nextChar == M_FVS3) {
						sbConvertedDoc.append(M_BIRGA3);
					} else {
						sbConvertedDoc.append(M_BIRGA);
					}
					break;

				case M_ELLIPSIS:
					sbConvertedDoc.append(M_ELLIPSIS_ISOL);
					break;

				case M_COMMA:
					sbConvertedDoc.append(M_COMMA_ISOL);
					break;

				case M_FULL_STOP:
					sbConvertedDoc.append(M_FULL_STOP_ISOL);
					break;

				case M_COLON:
					sbConvertedDoc.append(M_COLON_ISOL);
					break;

				case M_FOUR_DOTS:
					sbConvertedDoc.append(M_FOUR_DOTS_ISOL);
					break;

				case M_TODO_HYPHEN:
					sbConvertedDoc.append(M_TODO_HYPHEN_ISOL);
					break;

				case M_SIBE_SBM:
					sbConvertedDoc.append(M_SIBE_SBM_ISOL);
					break;

				case M_MANCHU_COMMA:
					sbConvertedDoc.append(M_MANCHU_COMMA_ISOL);
					break;

				case M_MANCHU_FULL_STOP:
					sbConvertedDoc.append(M_MANCHU_FULL_STOP_ISOL);
					break;

				case M_DIGIT_ZERO:
					sbConvertedDoc.append(M_DIGIT_ZERO_ISOL);
					break;

				case M_DIGIT_ONE:
					sbConvertedDoc.append(M_DIGIT_ONE_ISOL);
					break;

				case M_DIGIT_TWO:
					sbConvertedDoc.append(M_DIGIT_TWO_ISOL);
					break;

				case M_DIGIT_THREE:
					sbConvertedDoc.append(M_DIGIT_THREE_ISOL);
					break;

				case M_DIGIT_FOUR:
					sbConvertedDoc.append(M_DIGIT_FOUR_ISOL);
					break;

				case M_DIGIT_FIVE:
					sbConvertedDoc.append(M_DIGIT_FIVE_ISOL);
					break;

				case M_DIGIT_SIX:
					sbConvertedDoc.append(M_DIGIT_SIX_ISOL);
					break;

				case M_DIGIT_SEVEN:
					sbConvertedDoc.append(M_DIGIT_SEVEN_ISOL);
					break;

				case M_DIGIT_EIGHT:
					sbConvertedDoc.append(M_DIGIT_EIGHT_ISOL);
					break;

				case M_DIGIT_NINE:
					sbConvertedDoc.append(M_DIGIT_NINE_ISOL);
					break;

				default :
					sbConvertedDoc.append(ch);
					break;
				}
			}
		}
		if (sb.length() > 0) {
			String words = sb.toString();
			if (map.containsKey(words)) {
				sbConvertedDoc.append(map.get(words));
			} else {
				String convertedWord = convertWords(words);
				sbConvertedDoc.append(convertedWord);
				map.put(words, convertedWord);
			}
			sb = new StringBuffer("");
		}
		map = null;

		return sbConvertedDoc.toString();

	}

	public static String TrimE8Word(String word)
	{
		word.replaceAll("\u202f", "");
		StringBuffer sb = new StringBuffer();
		char charArray[] = new char[word.length()];
		word.getChars(0, charArray.length, charArray, 0);
		for(int i = 0; i < charArray.length; i++)
		{
			if(charArray[i] > 0xE800 && charArray[i] < 0xE80B || charArray[i] > 0xe80e && charArray[i] < 0xECC0 && charArray[i] != 0xea2a)
				sb.append(charArray[i]);
		}
		return sb.toString();
	}
	private static String convertWords(String wordsString) {
		StringBuffer sb = new StringBuffer();
		String[] words = wordsString.split(ML_NO_BREAK);
		if (words.length == 0) {
			return wordsString;
		}
		for (int i = 0; i < words.length; i++) {
			if (i == 0) {
				if (wordsString.startsWith(ML_NO_BREAK)) {
					sb.append(ML_NO_BREAK);
					if (DGBR_MAP.containsKey(words[i])) {
						sb.append(DGBR_MAP.get(words[i]));
					} else {
						sb.append(convertWord(words[i]));
					}
				} else {
					sb.append(convertWord(words[i]));
				}
			} else {
				sb.append(ML_NO_BREAK);
				if (DGBR_MAP.containsKey(words[i])) {
					sb.append(DGBR_MAP.get(words[i]));
				} else {
					sb.append(convertWord(words[i]));
				}
			}
		}
		if (wordsString.endsWith(ML_NO_BREAK)) {
			sb.append(ML_NO_BREAK);
		}
		return sb.toString();
	}

	private static String convertWord(String word) {
		int lastIndex = word.length() - 1;
		String ae = "";
		if (word.endsWith(MS_MVS_A) || word.endsWith(MS_MVS_E)) {
			if (word.endsWith(MS_MVS_A)) {
				ae = "" + M_MVS_ISOL + ML_A_FINA2;
			} else {
				ae = "" + M_MVS_ISOL +ML_E_FINA2;
			}
			word = word.substring(0, lastIndex - 1);
			lastIndex -= 2;
		}
		boolean ISOLATE = isIsolate(word, lastIndex);
		StringBuffer result = new StringBuffer();
		for (int i = 0; i <= lastIndex; i++) {
			char currentChar = word.charAt(i);
			char nextChar = ' ';
			if (i < lastIndex) {
				nextChar = word.charAt(i + 1);
			}

			switch (currentChar) {
			case M_NIRUGU:
				result.append(M_NIRUGU_ISOL);
				break;

			case M_FVS1:
				result.append(M_FVS1_ISOL);
				break;

			case M_FVS2:
				result.append(M_FVS2_ISOL);
				break;

			case M_FVS3:
				result.append(M_FVS3_ISOL);
				break;

			case M_MVS:
				result.append(M_MVS_ISOL);
				break;

			case ML_A:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_A_ISOL1);
					} else {
						result.append(ML_A_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_A_INIT1);
					} else {
						if (nextChar == ML_T_LVS) {
							if (i == (lastIndex - 1)) { // ISOL
								result.append(ML_T_LONG_A_ISOL);
							} else { // INIT
								result.append(ML_T_LONG_A_INIT);
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_A_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_A_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_A_FINA2);
					} else {
						result.append(ML_A_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_A_MEDI1);
					} else {
						if (nextChar == ML_T_LVS) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(ML_T_LONG_A_FINA);
							} else { // MEDI
								result.append(ML_T_LONG_A_MEDI);
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_A_MEDI);
						}
					}
				}
				break;

			case ML_E:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_E_ISOL1);
					} else {
						result.append(ML_E_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_E_INIT1);
					} else {
						result.append(ML_E_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_E_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_E_FINA2);
					} else {
						result.append(ML_E_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_E_MEDI);
					} else {
						result.append(ML_E_MEDI);
					}
				}
				break;

			case ML_I:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_I_ISOL1);
					} else {
						result.append(ML_I_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_I_INIT1);
					} else {
						result.append(ML_I_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_I_FINA);
					} else {
						result.append(ML_I_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_I_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_I_MEDI2);
					} else if (nextChar == ML_I) {
						result.append(ML_I_MEDI);
					} else {
						char prevChar = ' ';
						if (i > 0) {
							prevChar = word.charAt(i - 1);
						}
						if (prevChar == ML_A || prevChar == ML_E || prevChar == ML_O || prevChar == ML_U || ((prevChar == ML_OE || prevChar == ML_UE) && i > 2) || prevChar == ML_EE ) {
							if (nextChar == ML_I) {
								result.append(ML_I_MEDI);
							} else {
								result.append(ML_I_MEDI2);
							}
						} else {
							result.append(ML_I_MEDI);
						}
					}
				}
				break;

			case ML_O:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_O_ISOL1);
					} else {
						result.append(ML_O_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_O_INIT1);
					} else {
						result.append(ML_O_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_O_FINA1);
					} else {
						result.append(ML_O_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_O_MEDI1);
					} else {
						result.append(ML_O_MEDI);
					}
				}
				break;

			case ML_U:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_U_ISOL1);
					} else {
						result.append(ML_U_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_U_INIT1);
					} else {
						result.append(ML_U_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_U_FINA1);
					} else {
						result.append(ML_U_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_U_MEDI1);
					} else {
						result.append(ML_U_MEDI);
					}
				}
				break;

			case ML_OE:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_OE_ISOL1);
					} else {
						result.append(ML_OE_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_OE_INIT1);
					} else {
						result.append(ML_OE_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_OE_FINA1);
					} else {
						result.append(ML_OE_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_OE_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_OE_MEDI2);
					} else {
						if (i == 1) {
							result.append(ML_OE_MEDI1);
						} else {
							result.append(ML_OE_MEDI);
						}
					}
				}
				break;

			case ML_UE:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_UE_ISOL1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_UE_ISOL2);
					} else {
						result.append(ML_UE_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_UE_INIT1);
					} else {
						result.append(ML_UE_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_UE_FINA1);
					} else {
						result.append(ML_UE_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_UE_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_UE_MEDI2);
					} else {
						if (i == 1) {
							result.append(ML_UE_MEDI1);
						} else {
							result.append(ML_UE_MEDI);
						}
					}
				}
				break;

			case ML_EE:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_EE_ISOL1);
					} else {
						result.append(ML_EE_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_EE_INIT1);
					} else {
						result.append(ML_EE_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_EE_FINA);
				} else { // MEDI
					result.append(ML_EE_MEDI);
				}
				break;

			case ML_N:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_N_ISOL1);
					} else {
						result.append(ML_N_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_N_INIT1);
					} else {
						result.append(ML_N_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_N_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_N_FINA2);
					} else {
						if (ae.length() > 0) {
							result.append(ML_N_FINA1);
						} else {
							result.append(ML_N_FINA);
						}
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_N_MEDI1);
					} else {
						if (isVowel(nextChar) || isTodoVowel(nextChar) || isSibeVowel(nextChar)) {
							result.append(ML_N_MEDI1);
						} else {
							result.append(ML_N_MEDI);
						}
					}
				}
				break;

			case ML_NG:
				if (ISOLATE) { // ISOL
					result.append(ML_NG_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_NG_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_NG_FINA);
				} else { // MEDI
					if (( isNML(nextChar) || nextChar == ML_M_K ||  nextChar == ML_S_G ||  nextChar == ML_S_H ) && i < (lastIndex - 1) && isMVowel(word.charAt(i + 2))) {
						result.append(getConCon(currentChar, nextChar, MEDI));
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_NG_MEDI);
					}
				}
				break;

			case ML_B:
				if (ISOLATE) { // ISOL
					result.append(ML_B_ISOL);
				} else if (i == 0) { // INIT
					if (isVowel(nextChar) || isSibeVowel(nextChar) || nextChar == ML_M_I) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1) { // ISOL1
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_B_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_B_FINA1);
					} else {
						result.append(ML_B_FINA);
					}
				} else { // MEDI
					if (isVowel(nextChar) || isSibeVowel(nextChar) || nextChar == ML_M_I) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // FINA1
							if (nextChar == ML_OE) {
								result.append(ML_BOE_FINA1);
							} else {
								result.append(ML_BUE_FINA1);
							}
						} else if (i < (lastIndex - 2) && word.charAt(i + 2) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // MEDI1
							if (nextChar == ML_OE) {
								result.append(ML_BOE_MEDI1);
							} else {
								result.append(ML_BUE_MEDI1);
							}
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						if (isNML(nextChar) && i < (lastIndex - 1)) {
							if ( ( nextChar == ML_H || nextChar == ML_G ) && ( word.charAt(i+2) == ML_E || word.charAt(i+2) == ML_I  || word.charAt(i+2) == ML_OE  || word.charAt(i+2) == ML_UE ) ) {
								result.append(ML_B_MEDI);
							} else {
								result.append(getConCon(currentChar, nextChar, MEDI));
								result.append( PLACE_HOLDER );
								i++;
							}
						} else {
							result.append(ML_B_MEDI);
						}
					}
				}
				break;

			case ML_P:
				if (ISOLATE) { // ISOL
					result.append(ML_P_ISOL);
				} else if (i == 0) { // INIT
					if (isVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1) { // ISOL1
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_P_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_P_FINA);
				} else { // MEDI
					if (isVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // FINA1
							if (nextChar == ML_OE) {
								result.append(ML_POE_FINA1);
							} else {
								result.append(ML_PUE_FINA1);
							}
						} else if (i < (lastIndex - 2) && word.charAt(i + 2) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // MEDI1
							if (nextChar == ML_OE) {
								result.append(ML_POE_MEDI1);
							} else {
								result.append(ML_PUE_MEDI1);
							}
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						if (isNML(nextChar) && i < (lastIndex - 1)) {
							result.append(getConCon(currentChar, nextChar, MEDI));
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_P_MEDI);
						}
					}
				}
				break;

			case ML_H:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_H_ISOL1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_H_ISOL2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_H_ISOL3);
					} else {
						result.append(ML_H_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_H_INIT1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_H_INIT2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_H_INIT3);
					} else {
						if (isFMVowel(nextChar) || nextChar == ML_I) {
							if (i == (lastIndex - 1)) { // ISOL
								result.append(getConVowel(currentChar, ISOL, nextChar));
							} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1) { // ISOL1
								result.append(getConVowel(currentChar, ISOL, nextChar));
							} else { // INIT
								result.append(getConVowel(currentChar, INIT, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_H_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_H_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_H_FINA2);
					} else {
						if (isNML(nextChar) && i == (lastIndex - 1)) {
							result.append(getConCon(currentChar, nextChar, FINA));
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_H_FINA);
						}
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_H_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_H_MEDI2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_H_MEDI3);
					} else {
						if (isFMVowel(nextChar) || nextChar == ML_I) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(getConVowel(currentChar, FINA, nextChar));
							} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // FINA1
								if (nextChar == ML_OE) {
									result.append(ML_HOE_FINA1);
								} else {
									result.append(ML_HUE_FINA1);
								}
							} else if (i < (lastIndex - 2) && word.charAt(i + 2) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // MEDI1
								if (nextChar == ML_OE) {
									result.append(ML_HOE_MEDI1);
								} else {
									result.append(ML_HUE_MEDI1);
								}
							} else { // MEDI
								result.append(getConVowel(currentChar, MEDI, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_H_MEDI);
						}
					}
				}
				break;

			case ML_G:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_G_ISOL1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_G_ISOL2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_G_ISOL3);
					} else {
						result.append(ML_G_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_G_INIT1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_G_INIT2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_G_INIT3);
					} else {
						if (isFMVowel(nextChar) || nextChar == ML_I) {
							if (i == (lastIndex - 1)) { // ISOL
								result.append(getConVowel(currentChar, ISOL, nextChar));
							} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1) { // ISOL1
								result.append(getConVowel(currentChar, ISOL, nextChar));
							} else { // INIT
								result.append(getConVowel(currentChar, INIT, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_G_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_G_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_G_FINA2);
					} else {
						if (ae.length() > 0) {
							result.append(ML_G_FINA1);
						} else {
							if (isNML(nextChar) && i == (lastIndex - 1)) {
								result.append(getConCon(currentChar, nextChar, FINA));
								result.append( PLACE_HOLDER );
								i++;
							} else {
								if (i > 0 && isFMVowel(word.charAt(i - 1))) {
									result.append(ML_G_FINA2);
								} else if (i > 0 && ML_I == word.charAt(i - 1)) {
									if (i > 2 && (isFMVowel(word.charAt(i - 3)) || ML_G_MEDI2 == word.charAt(i - 3))) {
										result.append(ML_G_FINA2);
									} else if (i > 3 && (isFMVowel(word.charAt(i - 4)) || ML_G_MEDI2 == word.charAt(i - 4))) {
										result.append(ML_G_FINA2);
									} else if (i > 4 && (isFMVowel(word.charAt(i - 5)) || ML_G_MEDI2 == word.charAt(i - 5))) {
										result.append(ML_G_FINA2);
									} else if (i > 5 && (isFMVowel(word.charAt(i - 6)) || ML_G_MEDI2 == word.charAt(i - 6))) {
										result.append(ML_G_FINA2);
									} else {
										result.append(ML_G_FINA);
									}
								} else {
									result.append(ML_G_FINA);
								}
							}
						}
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_G_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_G_MEDI2);
					} else if (nextChar == M_FVS3) {
						if (isNML(word.charAt(i + 2)) && i < (lastIndex - 1)) {
							result.append(getConCon(currentChar, word.charAt(i + 2), MEDI));
							result.append( PLACE_HOLDER );
							i++;
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_G_MEDI3);
						}
					} else {
						if (isMVowel(nextChar)) {
							if (i > 0 && ( word.charAt(i - 1) == ML_S || word.charAt(i - 1) == ML_D )) {
								result.append(ML_G_MEDI);
							} else {
								result.append(ML_G_MEDI1);
							}
						} else {
							if (isFMVowel(nextChar) || nextChar == ML_I) {
								if (i == (lastIndex - 1)) { // FINA
									result.append(getConVowel(currentChar, FINA, nextChar));
								} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // FINA1
									if (nextChar == ML_OE) {
										result.append(ML_GOE_FINA1);
									} else {
										result.append(ML_GUE_FINA1);
									}
								} else if (i < (lastIndex - 2) && word.charAt(i + 2) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // MEDI1
									if (nextChar == ML_OE) {
										result.append(ML_GOE_MEDI1);
									} else {
										result.append(ML_GUE_MEDI1);
									}
								} else { // MEDI
									result.append(getConVowel(currentChar, MEDI, nextChar));
								}
								result.append( PLACE_HOLDER );
								i++;
							} else {
								if (isNML(nextChar) && i < (lastIndex - 1) && word.charAt(i + 2) != ML_A && word.charAt(i + 2) != ML_O && word.charAt(i + 2) != ML_U) {
									if ( ( nextChar == ML_G || nextChar == ML_H ) && ( word.charAt(i + 2) == ML_E || word.charAt(i + 2) == ML_OE || word.charAt(i + 2) == ML_UE ) ) {
										result.append(ML_G_MEDI2);
									} else {
										result.append(getConCon(currentChar, nextChar, MEDI));
										result.append( PLACE_HOLDER );
										i++;
									}
								} else {
									if (i > 0 && isFMVowel(word.charAt(i - 1))) {
										result.append(ML_G_MEDI3);
									} else if (i > 0 && ML_I == word.charAt(i - 1)) {
										if (i > 2 && (isFMVowel(word.charAt(i - 3)) || ML_G_MEDI2 == word.charAt(i - 3))) {
											result.append(ML_G_MEDI2);
										} else if (i > 3 && (isFMVowel(word.charAt(i - 4)) || ML_G_MEDI2 == word.charAt(i - 4))) {
											result.append(ML_G_MEDI2);
										} else if (i > 4 && (isFMVowel(word.charAt(i - 5)) || ML_G_MEDI2 == word.charAt(i - 5))) {
											result.append(ML_G_MEDI2);
										} else if (i > 5 && (isFMVowel(word.charAt(i - 6)) || ML_G_MEDI2 == word.charAt(i - 6))) {
											result.append(ML_G_MEDI2);
										} else if (lastIndex >= (i + 2) && (isFMVowel(word.charAt(i + 2)) || ML_G_MEDI2 == word.charAt(i + 2))) {
											result.append(ML_G_MEDI2);
										} else if (lastIndex >= (i + 3) && (isFMVowel(word.charAt(i + 3)) || ML_G_MEDI2 == word.charAt(i + 3))) {
											result.append(ML_G_MEDI2);
										} else if (lastIndex >= (i + 4) && (isFMVowel(word.charAt(i + 4)) || ML_G_MEDI2 == word.charAt(i + 4))) {
											result.append(ML_G_MEDI2);
										} else {
											result.append(ML_G_MEDI);
										}
									} else {
										result.append(ML_G_MEDI);
									}
								}
							}
						}
					}
				}
				break;
			case ML_M:
				if (ISOLATE) { // ISOL
					result.append(ML_M_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_M_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_M_FINA);
				} else { // MEDI
					if (nextChar == ML_L && i < (lastIndex - 1)) {
						result.append(ML_ML_MEDI);
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_M_MEDI);
					}
				}
				break;

			case ML_L:
				if (ISOLATE) { // ISOL
					result.append(ML_L_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_L_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_L_FINA);
				} else { // MEDI
					if (nextChar == ML_L && i < (lastIndex - 1)) {
						result.append(ML_LL_MEDI);
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_L_MEDI);
					}
				}
				break;

			case ML_S:
				if (ISOLATE) { // ISOL
					result.append(ML_S_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_S_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_S_FINA2);
					} else {
						result.append(ML_S_FINA);
					}
				} else { // MEDI
					result.append(ML_S_MEDI);
				}
				break;

			case ML_SH:
				if (ISOLATE) { // ISOL
					result.append(ML_SH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_SH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_SH_FINA);
				} else { // MEDI
					result.append(ML_SH_MEDI);
				}
				break;

			case ML_T:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_T_ISOL1);
					} else {
						result.append(ML_T_ISOL);
					}
				} else if (i == 0) { // INIT
					result.append(ML_T_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_T_MEDI2);
					} else {
						result.append(ML_T_MEDI);
					}
				}
				break;

			case ML_D:
				if (ISOLATE) { // ISOL
					result.append(ML_D_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_D_INIT1);
					} else {
						result.append(ML_D_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_D_FINA1);
					} else {
						result.append(ML_D_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_D_MEDI1);
					} else {
						if (isVowel(nextChar)) {
							result.append(ML_D_MEDI1);
						} else {
							result.append(ML_D_MEDI);
						}
					}
				}
				break;

			case ML_CH:
				if (ISOLATE) { // ISOL
					result.append(ML_CH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_CH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_CH_FINA);
				} else { // MEDI
					result.append(ML_CH_MEDI);
				}
				break;

			case ML_J:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_J_ISOL1);
					} else if ( ae.length() > 0) {
							result.append(ML_J_ISOL1);
					} else {
						result.append(ML_J_ISOL);
					}
				} else if (i == 0) { // INIT
					result.append(ML_J_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_J_FINA);
				} else { // MEDI
					result.append(ML_J_MEDI);
				}
				break;

			case ML_Y:
				if (ISOLATE) { // ISOL
					result.append(ML_Y_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_Y_INIT1);
					} else {
						result.append(ML_Y_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_Y_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_Y_MEDI1);
					} else {
						char prevChar = ' ';
						if (i > 0) {
							prevChar = word.charAt(i - 1);
						}
						char nextNextChar = ' ';
						if ( i < (lastIndex-1) ) {
							nextNextChar = word.charAt( i+2 );
						}
						if (nextChar == ML_I && i<(lastIndex-1) && !isFVS(nextNextChar) && ( prevChar == ML_A || prevChar == ML_E || prevChar == ML_O || prevChar == ML_U || ((prevChar == ML_OE || prevChar == ML_UE) && i > 1) ) ) {
							result.append(ML_Y_MEDI1);
						} else {
							result.append(ML_Y_MEDI);
						}
					}
				}
				break;

			case ML_R:
				if (ISOLATE) { // ISOL
					result.append(ML_R_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_R_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_R_FINA);
				} else { // MEDI
					result.append(ML_R_MEDI);
				}
				break;

			case ML_W:
				if (ISOLATE) { // ISOL
					result.append(ML_W_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_W_INIT1);
					} else {
						result.append(ML_W_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_W_FINA1);
					} else if ( ae.length() > 0) {
						result.append(ML_W_FINA1);
					} else {
						result.append(ML_W_FINA);
					}
				} else { // MEDI
					result.append(ML_W_MEDI);
				}
				break;

			case ML_F:
				if (ISOLATE) { // ISOL
					result.append(ML_F_ISOL);
				} else if (i == 0) { // INIT
					if (isVowel(nextChar) || nextChar == ML_I) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1) { // ISOL1
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_F_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_F_FINA);
				} else { // MEDI
					if (isVowel(nextChar) || nextChar == ML_I) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // FINA1
							if (nextChar == ML_OE) {
								result.append(ML_FOE_FINA1);
							} else {
								result.append(ML_FUE_FINA1);
							}
						} else if (i < (lastIndex - 2) && word.charAt(i + 2) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // MEDI1
							if (nextChar == ML_OE) {
								result.append(ML_FOE_MEDI1);
							} else {
								result.append(ML_FUE_MEDI1);
							}
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						if (isNML(nextChar) && i < (lastIndex - 1)) {
							result.append(getConCon(currentChar, nextChar, MEDI));
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_F_MEDI);
						}
					}
				}
				break;

			case ML_K:
				if (ISOLATE) { // ISOL
					result.append(ML_K_ISOL);
				} else if (i == 0) { // INIT
					if (isVowel(nextChar) || nextChar == ML_I) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1) { // ISOL1
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_K_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_K_FINA);
				} else { // MEDI
					if (isVowel(nextChar) || nextChar == ML_I) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // FINA1
							if (nextChar == ML_OE) {
								result.append(ML_KOE_FINA1);
							} else {
								result.append(ML_KUE_FINA1);
							}
						} else if (i < (lastIndex - 2) && word.charAt(i + 2) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // MEDI1
							if (nextChar == ML_OE) {
								result.append(ML_KOE_MEDI1);
							} else {
								result.append(ML_KUE_MEDI1);
							}
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						if (isNML(nextChar) && i < (lastIndex - 1)) {
							result.append(getConCon(currentChar, nextChar, MEDI));
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_K_MEDI);
						}
					}
				}
				break;

			case ML_KH:
				if (ISOLATE) { // ISOL
					result.append(ML_KH_ISOL);
				} else if (i == 0) { // INIT
					if (isVowel(nextChar) || nextChar == ML_I) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1) { // ISOL1
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_KH_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_KH_FINA);
				} else { // MEDI
					if (isVowel(nextChar) || nextChar == ML_I) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else if (i == (lastIndex - 2) && word.charAt(lastIndex) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // FINA1
							if (nextChar == ML_OE) {
								result.append(ML_KHOE_FINA1);
							} else {
								result.append(ML_KHUE_FINA1);
							}
						} else if (i < (lastIndex - 2) && word.charAt(i + 2) == M_FVS1 && (nextChar == ML_OE || nextChar == ML_UE)) { // MEDI1
							if (nextChar == ML_OE) {
								result.append(ML_KHOE_MEDI1);
							} else {
								result.append(ML_KHUE_MEDI1);
							}
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						if (isNML(nextChar) && i < (lastIndex - 1)) {
							result.append(getConCon(currentChar, nextChar, MEDI));
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_KH_MEDI);
						}
					}
				}
				break;

			case ML_C:
				if (ISOLATE) { // ISOL
					result.append(ML_C_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_C_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_C_FINA);
				} else { // MEDI
					result.append(ML_C_MEDI);
				}
				break;

			case ML_Z:
				if (ISOLATE) { // ISOL
					result.append(ML_Z_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_Z_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_Z_FINA);
				} else { // MEDI
					result.append(ML_Z_MEDI);
				}
				break;

			case ML_HH:
				if (ISOLATE) { // ISOL
					result.append(ML_HH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_HH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_HH_FINA);
				} else { // MEDI
					result.append(ML_HH_MEDI);
				}
				break;

			case ML_RH:
				if (ISOLATE) { // ISOL
					result.append(ML_RH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_RH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_RH_FINA);
				} else { // MEDI
					result.append(ML_RH_MEDI);
				}
				break;

			case ML_LH:
				if (ISOLATE) { // ISOL
					result.append(ML_LH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_LH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_LH_FINA);
				} else { // MEDI
					result.append(ML_LH_MEDI);
				}
				break;

			case ML_ZHI:
				if (ISOLATE) { // ISOL
					result.append(ML_ZHI_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_ZHI_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_ZHI_FINA);
				} else { // MEDI
					result.append(ML_ZHI_MEDI);
				}
				break;

			case ML_CHI:
				if (ISOLATE) { // ISOL
					result.append(ML_CHI_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_CHI_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_CHI_FINA);
				} else { // MEDI
					result.append(ML_CHI_MEDI);
				}
				break;

			case ML_T_LVS:
				if (ISOLATE) { // ISOL
					result.append(ML_T_LVS_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_LVS_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_LVS_FINA);
				} else { // MEDI
					result.append(ML_T_LVS_MEDI);
				}
				break;

			case ML_T_E:
				if (ISOLATE) { // ISOL
					result.append(ML_T_E_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_E_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_E_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_E_MEDI1);
					} else {
						result.append(ML_T_E_MEDI);
					}
				}
				break;

			case ML_T_I:
				if (ISOLATE) { // ISOL
					result.append(ML_T_I_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_I_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_I_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_I_MEDI1);
					} else {
						char prevChar = ' ';
						if (i > 0) {
							prevChar = word.charAt(i - 1);
						}
						if (prevChar == ML_A || prevChar == ML_T_E || prevChar == ML_T_I || prevChar == ML_T_O || prevChar == ML_T_U || prevChar == ML_T_OE || prevChar == ML_T_UE ) {
							result.append(ML_T_I_MEDI1);
						} else {
							result.append(ML_T_I_MEDI);
						}
					}
				}
				break;

			case ML_T_O:
				if (ISOLATE) { // ISOL
					result.append(ML_T_O_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == ML_T_LVS) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(ML_T_LONG_O_ISOL);
						} else { // INIT
							result.append(ML_T_LONG_O_INIT);
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_O_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_O_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_O_MEDI1);
					} else {
						if (nextChar == ML_T_LVS) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(ML_T_LONG_O_FINA);
							} else { // MEDI
								result.append(ML_T_LONG_O_MEDI);
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_T_O_MEDI);
						}
					}
				}
				break;

			case ML_T_U:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_T_U_ISOL1);
					} else {
						result.append(ML_T_U_ISOL);
					}
				} else if (i == 0) { // INIT
					result.append(ML_T_U_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_T_U_FINA1);
					} else {
						result.append(ML_T_U_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_U_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_T_U_MEDI2);
					} else {
						result.append(ML_T_U_MEDI);
					}
				}
				break;

			case ML_T_OE:
				if (ISOLATE) { // ISOL
					result.append(ML_T_OE_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == ML_T_LVS) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(ML_T_LONG_OE_ISOL);
						} else { // INIT
							result.append(ML_T_LONG_OE_INIT);
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_OE_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_OE_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_OE_MEDI1);
					} else {
						if (nextChar == ML_T_LVS) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(ML_T_LONG_OE_FINA);
							} else { // MEDI
								result.append(ML_T_LONG_OE_MEDI);
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_T_OE_MEDI);
						}
					}
				}
				break;

			case ML_T_UE:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_T_UE_ISOL1);
					} else {
						result.append(ML_T_UE_ISOL);
					}
				} else if (i == 0) { // INIT
					result.append(ML_T_UE_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_UE_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_UE_MEDI1);
					} else {
						result.append(ML_T_UE_MEDI);
					}
				}
				break;

			case ML_T_NG:
				if (ISOLATE) { // ISOL
					result.append(ML_T_NG_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_NG_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if ((nextChar == ML_T_G) && i == (lastIndex - 1) && isTodoMVowel(word.charAt(lastIndex))) {
						result.append(getConCon(currentChar, nextChar, MEDI));
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_NG_FINA);
					}
				} else { // MEDI
					if (isTodoNMLQG(nextChar) && i < (lastIndex - 1) && isTodoMVowel(word.charAt(i + 2))) {
						result.append(getConCon(currentChar, nextChar, MEDI));
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_NG_MEDI);
					}
				}
				break;

			case ML_T_B:
				if (ISOLATE) { // ISOL
					result.append(ML_T_B_ISOL);
				} else if (i == 0) { // INIT
					if (isTodoVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_B_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_B_FINA);
				} else { // MEDI
					if (isTodoVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						if (isTodoNMLQG(nextChar) && i < (lastIndex - 1)) {
							result.append(getConCon(currentChar, nextChar, MEDI));
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_T_B_MEDI);
						}
					}
				}
				break;

			case ML_T_P:
				if (ISOLATE) { // ISOL
					result.append(ML_T_P_ISOL);
				} else if (i == 0) { // INIT
					if (isTodoVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_P_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_P_FINA);
				} else { // MEDI
					if (isTodoVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_P_MEDI);
					}
				}
				break;

			case ML_T_Q:
				if (ISOLATE) { // ISOL
					result.append(ML_T_Q_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_T_Q_INIT1);
					} else {
						if (isTodoFMVowel(nextChar) || nextChar == ML_T_I) {
							if (i == (lastIndex - 1)) { // ISOL
								result.append(getConVowel(currentChar, ISOL, nextChar));
							} else { // INIT
								result.append(getConVowel(currentChar, INIT, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_T_Q_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_Q_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_Q_MEDI1);
					} else {
						if (isTodoFMVowel(nextChar) || nextChar == ML_T_I) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(getConVowel(currentChar, FINA, nextChar));
							} else { // MEDI
								result.append(getConVowel(currentChar, MEDI, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_T_Q_MEDI);
						}
					}
				}
				break;

			case ML_T_G:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_T_G_ISOL1);
					} else {
						result.append(ML_T_G_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_T_G_INIT1);
					} else {
						if (isTodoFMVowel(nextChar) || nextChar == ML_T_I) {
							if (i == (lastIndex - 1)) { // ISOL
								result.append(getConVowel(currentChar, ISOL, nextChar));
							} else { // INIT
								result.append(getConVowel(currentChar, INIT, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_T_G_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_G_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_T_G_MEDI1);
					} else {
						if (isTodoFMVowel(nextChar) || nextChar == ML_T_I) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(getConVowel(currentChar, FINA, nextChar));
							} else { // MEDI
								result.append(getConVowel(currentChar, MEDI, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							if ((nextChar == ML_N || nextChar == ML_T_M || nextChar == ML_L) && i < (lastIndex - 1)) {
								result.append(getConCon(currentChar, nextChar, MEDI));
								result.append( PLACE_HOLDER );
								i++;
							} else {
								result.append(ML_T_G_MEDI);
							}
						}
					}
				}
				break;

			case ML_T_M:
				if (ISOLATE) { // ISOL
					result.append(ML_T_M_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_M_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_M_FINA);
				} else { // MEDI
					if ((nextChar == ML_T_M || nextChar == ML_L) && i < (lastIndex - 1)) {
						result.append(getConCon(currentChar, nextChar, MEDI));
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_M_MEDI);
					}
				}
				break;

			case ML_T_T:
				if (ISOLATE) { // ISOL
					result.append(ML_T_T_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_T_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_T_FINA);
				} else { // MEDI
					result.append(ML_T_T_MEDI);
				}
				break;

			case ML_T_D:
				if (ISOLATE) { // ISOL
					result.append(ML_T_D_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_D_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_D_FINA);
				} else { // MEDI
					result.append(ML_T_D_MEDI);
				}
				break;

			case ML_T_CH:
				if (ISOLATE) { // ISOL
					result.append(ML_T_CH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_CH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_CH_FINA);
				} else { // MEDI
					result.append(ML_T_CH_MEDI);
				}
				break;

			case ML_T_J:
				if (ISOLATE) { // ISOL
					result.append(ML_T_J_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_J_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_J_FINA);
				} else { // MEDI
					result.append(ML_T_J_MEDI);
				}
				break;

			case ML_T_TS:
				if (ISOLATE) { // ISOL
					result.append(ML_T_TS_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_TS_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_TS_FINA);
				} else { // MEDI
					result.append(ML_T_TS_MEDI);
				}
				break;

			case ML_T_Y:
				if (ISOLATE) { // ISOL
					result.append(ML_T_Y_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_Y_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_Y_FINA);
				} else { // MEDI
					result.append(ML_T_Y_MEDI);
				}
				break;

			case ML_T_W:
				if (ISOLATE) { // ISOL
					result.append(ML_T_W_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_W_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_W_FINA);
				} else { // MEDI
					result.append(ML_T_W_MEDI);
				}
				break;

			case ML_T_K:
				if (ISOLATE) { // ISOL
					result.append(ML_T_K_ISOL);
				} else if (i == 0) { // INIT
					if (isTodoMVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_K_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_K_FINA);
				} else { // MEDI
					if (isTodoMVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_K_MEDI);
					}
				}
				break;

			case ML_T_GH:
				if (ISOLATE) { // ISOL
					result.append(ML_T_GH_ISOL);
				} else if (i == 0) { // INIT
					if (isTodoMVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_GH_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_GH_FINA);
				} else { // MEDI
					if (isTodoMVowel(nextChar)) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_T_GH_MEDI);
					}
				}
				break;

			case ML_T_HH:
				if (ISOLATE) { // ISOL
					result.append(ML_T_HH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_HH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_HH_FINA);
				} else { // MEDI
					result.append(ML_T_HH_MEDI);
				}
				break;

			case ML_T_JI:
				if (ISOLATE) { // ISOL
					result.append(ML_T_JI_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_JI_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_JI_FINA);
				} else { // MEDI
					result.append(ML_T_JI_MEDI);
				}
				break;

			case ML_T_NIA:
				if (ISOLATE) { // ISOL
					result.append(ML_T_NIA_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_NIA_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_NIA_FINA);
				} else { // MEDI
					result.append(ML_T_NIA_MEDI);
				}
				break;

			case ML_T_DZ:
				if (ISOLATE) { // ISOL
					result.append(ML_T_DZ_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_T_DZ_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_T_DZ_FINA);
				} else { // MEDI
					result.append(ML_T_DZ_MEDI);
				}
				break;

			case ML_S_E:
				if (ISOLATE) { // ISOL
					result.append(ML_S_E_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_E_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_S_E_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_S_E_FINA2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_S_E_FINA3);
					} else {
						char prevChar = ' ';
						if (i > 0) {
							prevChar = word.charAt(i - 1);
						}
						if (prevChar == ML_S_T || prevChar == ML_S_D ) {
							result.append(ML_S_E_FINA1);
						} else {
							result.append(ML_S_E_FINA);
						}
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_S_E_MEDI1);
					} else {
						char prevChar = ' ';
						if (i > 0) {
							prevChar = word.charAt(i - 1);
						}
						if (prevChar == ML_S_T || prevChar == ML_S_D ) {
							result.append(ML_S_E_MEDI1);
						} else {
							result.append(ML_S_E_MEDI);
						}
					}
				}
				break;

			case ML_S_I:
				if (ISOLATE) { // ISOL
					result.append(ML_S_I_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_I_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_S_I_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_S_I_FINA2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_S_I_FINA3);
					} else {
						result.append(ML_S_I_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_S_I_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_S_I_MEDI2);
					} else {
						result.append(ML_S_I_MEDI);
					}
				}
				break;

			case ML_S_IY:
				if (ISOLATE) { // ISOL
					result.append(ML_S_IY_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_IY_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_IY_FINA);
				} else { // MEDI
					result.append(ML_S_IY_MEDI);
				}
				break;

			case ML_S_UE:
				if (ISOLATE) { // ISOL
					result.append(ML_S_UE_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_UE_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_S_UE_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_S_UE_FINA2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_S_UE_FINA3);
					} else {
						char prevChar = ' ';
						if (i > 0) {
							prevChar = word.charAt(i - 1);
						}
						if (prevChar == ML_S_T || prevChar == ML_S_D ) {
							result.append(ML_S_UE_FINA1);
						} else {
							result.append(ML_S_UE_FINA);
						}
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_S_UE_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_S_UE_MEDI2);
					} else {
						char prevChar = ' ';
						if (i > 0) {
							prevChar = word.charAt(i - 1);
						}
						if (prevChar == ML_S_T || prevChar == ML_S_D ) {
							result.append(ML_S_UE_MEDI1);
						} else {
							result.append(ML_S_UE_MEDI);
						}
					}
				}
				break;

			case ML_S_U:
				if (ISOLATE) { // ISOL
					result.append(ML_S_U_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_U_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_U_FINA);
				} else { // MEDI
					result.append(ML_S_U_MEDI);
				}
				break;

			case ML_S_NG:
				if (ISOLATE) { // ISOL
					result.append(ML_S_NG_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_NG_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_NG_FINA);
				} else { // MEDI
					if ((nextChar == ML_N || nextChar == ML_M || nextChar == ML_L || nextChar == ML_S_K || nextChar == ML_S_G || nextChar == ML_S_H) && i < (lastIndex - 1)
							&& isTodoMVowel(word.charAt(i + 2))) {
						switch (nextChar) {
						case ML_N:
							result.append(ML_S_NGN_MEDI);
							break;
						case ML_M:
							result.append(ML_S_NGM_MEDI);
							break;
						case ML_L:
							result.append(ML_S_NGL_MEDI);
							break;
						case ML_S_K:
							if (i < (lastIndex - 1) && word.charAt(i + 2) == M_FVS1) {
								result.append(ML_S_NGK_MEDI1);
							} else {
								result.append(ML_S_NGK_MEDI);
							}
							break;
						case ML_S_G:
							result.append(ML_S_NGG_MEDI);
							break;
						case ML_S_H:
							result.append(ML_S_NGH_MEDI);
							break;
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_NG_MEDI);
					}
				}
				break;

			case ML_S_K:
				if (ISOLATE) { // ISOL
					result.append(ML_S_K_ISOL);
				} else if (i == 0) { // INIT
					char nextNextChar = ' ';
					if ( i < (lastIndex -1) ) {
						nextNextChar = word.charAt( i+2 );
					}
					if ( ( nextChar == ML_S_E || nextChar == ML_S_I || nextChar == ML_S_UE) && !isFVS(nextNextChar)) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_K_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_K_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_S_K_MEDI1);
					} else {
						char nextNextChar = ' ';
						if ( i < (lastIndex -1) ) {
							nextNextChar = word.charAt( i+2 );
						}
						if ( ( nextChar == ML_S_E || nextChar == ML_S_I || nextChar == ML_S_UE) && !isFVS(nextNextChar)) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(getConVowel(currentChar, FINA, nextChar));
							} else { // MEDI
								result.append(getConVowel(currentChar, MEDI, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_S_K_MEDI);
						}
					}
				}
				break;

			case ML_S_G:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_S_G_ISOL1);
					} else {
						result.append(ML_S_G_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_S_G_INIT1);
					} else {
						char nextNextChar = ' ';
						if ( i < (lastIndex -1) ) {
							nextNextChar = word.charAt( i+2 );
						}
						if ( ( nextChar == ML_S_E || nextChar == ML_S_I || nextChar == ML_S_UE) && !isFVS(nextNextChar)) {
							if (i == (lastIndex - 1)) { // ISOL
								result.append(getConVowel(currentChar, ISOL, nextChar));
							} else { // INIT
								result.append(getConVowel(currentChar, INIT, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_S_G_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_G_FINA);
				} else { // MEDI
					char nextNextChar = ' ';
					if ( i < (lastIndex -1) ) {
						nextNextChar = word.charAt( i+2 );
					}
					if ( ( nextChar == ML_S_E || nextChar == ML_S_I || nextChar == ML_S_UE) && !isFVS(nextNextChar)) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_G_MEDI);
					}
				}
				break;

			case ML_S_H:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_S_H_ISOL1);
					} else {
						result.append(ML_S_H_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_S_H_INIT1);
					} else {
						char nextNextChar = ' ';
						if ( i < (lastIndex -1) ) {
							nextNextChar = word.charAt( i+2 );
						}
						if ( ( nextChar == ML_S_E || nextChar == ML_S_I || nextChar == ML_S_UE) && !isFVS(nextNextChar)) {
							if (i == (lastIndex - 1)) { // ISOL
								result.append(getConVowel(currentChar, ISOL, nextChar));
							} else { // INIT
								result.append(getConVowel(currentChar, INIT, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_S_H_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_H_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_S_H_MEDI1);
					} else {
						char nextNextChar = ' ';
						if ( i < (lastIndex -1) ) {
							nextNextChar = word.charAt( i+2 );
						}
						if ( ( nextChar == ML_S_E || nextChar == ML_S_I || nextChar == ML_S_UE) && !isFVS(nextNextChar)) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(getConVowel(currentChar, FINA, nextChar));
							} else { // MEDI
								result.append(getConVowel(currentChar, MEDI, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_S_H_MEDI);
						}
					}
				}
				break;

			case ML_S_P:
				if (ISOLATE) { // ISOL
					result.append(ML_S_P_ISOL);
				} else if (i == 0) { // INIT
					if (isSibeVowel(nextChar) || nextChar == ML_M_I) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_P_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_P_FINA);
				} else { // MEDI
					if (isSibeVowel(nextChar) || nextChar == ML_M_I) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_P_MEDI);
					}
				}
				break;

			case ML_S_SH:
				if (ISOLATE) { // ISOL
					result.append(ML_S_SH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_SH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_SH_FINA);
				} else { // MEDI
					result.append(ML_S_SH_MEDI);
				}
				break;

			case ML_S_T:
				if (ISOLATE) { // ISOL
					if (nextChar == M_FVS1) {
						result.append(ML_S_T_ISOL1);
					} else {
						result.append(ML_S_T_ISOL);
					}
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_S_T_INIT1);
					} else {
						if ( nextChar == ML_A ||  nextChar == ML_S_I ||  nextChar == ML_O  ) {
							result.append(ML_S_T_INIT1);
						} else {
							result.append(ML_S_T_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_T_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_S_T_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_S_T_MEDI2);
					} else {
						if ( nextChar == ML_A ||  nextChar == ML_S_I ||  nextChar == ML_O  ) {
							result.append(ML_S_T_MEDI1);
						} else {
							result.append(ML_S_T_MEDI);
						}
					}
				}
				break;

			case ML_S_D:
				if (ISOLATE) { // ISOL
					result.append(ML_S_D_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_S_D_INIT1);
					} else {
						if ( nextChar == ML_S_E || nextChar == ML_S_UE  ) {
							result.append(ML_S_D_INIT1);
						} else {
							result.append(ML_S_D_INIT);
						}
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_D_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_S_D_MEDI1);
					} else {
						if ( nextChar == ML_A ||  nextChar == ML_S_I ||  nextChar == ML_O  ) {
							result.append(ML_S_D_MEDI1);
						} else {
							result.append(ML_S_D_MEDI);
						}
					}
				}
				break;

			case ML_S_J:
				if (ISOLATE) { // ISOL
					result.append(ML_S_J_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_J_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_J_FINA);
				} else { // MEDI
					result.append(ML_S_J_MEDI);
				}
				break;

			case ML_S_F:
				if (ISOLATE) { // ISOL
					result.append(ML_S_F_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_F_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_F_FINA);
				} else { // MEDI
					result.append(ML_S_F_MEDI);
				}
				break;

			case ML_S_GH:
				if (ISOLATE) { // ISOL
					result.append(ML_S_GH_ISOL);
				} else if (i == 0) { // INIT
					if ((nextChar == ML_A || nextChar == ML_O)) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_GH_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_GH_FINA);
				} else { // MEDI
					if ((nextChar == ML_A || nextChar == ML_O)) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_GH_MEDI);
					}
				}
				break;

			case ML_S_HH:
				if (ISOLATE) { // ISOL
					result.append(ML_S_HH_ISOL);
				} else if (i == 0) { // INIT
					if ((nextChar == ML_A || nextChar == ML_O)) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_HH_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_HH_FINA);
				} else { // MEDI
					if ((nextChar == ML_A || nextChar == ML_O)) {
						if (i == (lastIndex - 1)) { // FINA
							result.append(getConVowel(currentChar, FINA, nextChar));
						} else { // MEDI
							result.append(getConVowel(currentChar, MEDI, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_S_HH_MEDI);
					}
				}
				break;

			case ML_S_TS:
				if (ISOLATE) { // ISOL
					result.append(ML_S_TS_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_TS_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_TS_FINA);
				} else { // MEDI
					result.append(ML_S_TS_MEDI);
				}
				break;

			case ML_S_Z:
				if (ISOLATE) { // ISOL
					result.append(ML_S_Z_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == M_FVS1) {
						result.append(ML_S_Z_INIT1);
					} else {
						result.append(ML_S_Z_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_Z_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_S_Z_MEDI1);
					} else {
						result.append(ML_S_Z_MEDI);
					}
				}
				break;

			case ML_S_RH:
				if (ISOLATE) { // ISOL
					result.append(ML_S_RH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_RH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_RH_FINA);
				} else { // MEDI
					result.append(ML_S_RH_MEDI);
				}
				break;

			case ML_S_CH:
				if (ISOLATE) { // ISOL
					result.append(ML_S_CH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_CH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_CH_FINA);
				} else { // MEDI
					result.append(ML_S_CH_MEDI);
				}
				break;

			case ML_S_ZH:
				if (ISOLATE) { // ISOL
					result.append(ML_S_ZH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_S_ZH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_S_ZH_FINA);
				} else { // MEDI
					result.append(ML_S_ZH_MEDI);
				}
				break;

			case ML_M_I:
				if (ISOLATE) { // ISOL
					result.append(ML_M_I_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_M_I_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_M_I_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_M_I_FINA2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_M_I_FINA3);
					} else if (nextChar == M_MVS) {
						result.append(ML_M_I_FINA4);
					} else {
						result.append(ML_M_I_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_M_I_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_M_I_MEDI2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_M_I_MEDI3);
					} else {
						result.append(ML_M_I_MEDI);
					}
				}
				break;

			case ML_M_K:
				if (ISOLATE) { // ISOL
					result.append(ML_M_K_ISOL);
				} else if (i == 0) { // INIT
					if (nextChar == ML_S_E || nextChar == ML_M_I || nextChar == ML_S_UE) {
						if (i == (lastIndex - 1)) { // ISOL
							result.append(getConVowel(currentChar, ISOL, nextChar));
						} else { // INIT
							result.append(getConVowel(currentChar, INIT, nextChar));
						}
						result.append( PLACE_HOLDER );
						i++;
					} else {
						result.append(ML_M_K_INIT);
					}
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					if (nextChar == M_FVS1) {
						result.append(ML_M_K_FINA1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_M_K_FINA2);
					} else {
						result.append(ML_M_K_FINA);
					}
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_M_K_MEDI1);
					} else if (nextChar == M_FVS2) {
						result.append(ML_M_K_MEDI2);
					} else if (nextChar == M_FVS3) {
						result.append(ML_M_K_MEDI3);
					} else {
						if (nextChar == ML_S_E || nextChar == ML_M_I || nextChar == ML_S_UE) {
							if (i == (lastIndex - 1)) { // FINA
								result.append(getConVowel(currentChar, FINA, nextChar));
							} else { // MEDI
								result.append(getConVowel(currentChar, MEDI, nextChar));
							}
							result.append( PLACE_HOLDER );
							i++;
						} else {
							result.append(ML_M_K_MEDI);
						}
					}
				}
				break;

			case ML_M_R:
				if (ISOLATE) { // ISOL
					result.append(ML_M_R_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_M_R_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_M_R_FINA);
				} else { // MEDI
					result.append(ML_M_R_MEDI);
				}
				break;

			case ML_M_F:
				if (ISOLATE) { // ISOL
					result.append(ML_M_F_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_M_F_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_M_F_FINA);
				} else { // MEDI
					if (nextChar == M_FVS1) {
						result.append(ML_M_F_MEDI1);
					} else {
						result.append(ML_M_F_MEDI);
					}
				}
				break;

			case ML_M_ZH:
				if (ISOLATE) { // ISOL
					result.append(ML_M_ZH_ISOL);
				} else if (i == 0) { // INIT
					result.append(ML_M_ZH_INIT);
				} else if (isFinal(nextChar, i, lastIndex)) { // FINA
					result.append(ML_M_ZH_FINA);
				} else { // MEDI
					result.append(ML_M_ZH_MEDI);
				}
				break;

			default:
				result.append(currentChar);
				break;
			}
		}

		if (ae.length() > 0) {
			result.append(ae);
		}

		return result.toString();
	}

	private static boolean isIsolate(String word, int lastIndex) {

		boolean result = false;
		if (lastIndex == 0 || (lastIndex == 1 && isFVS(word.charAt(lastIndex)))) {
			result = true;
		}
		return result;
	}

	private static boolean isFinal(char nextChar, int i, int lastIndex) {

		boolean result = false;
		if (i == lastIndex) {
			result = true;
		} else if ((i == (lastIndex - 1)) && isFVS(nextChar)) {
			result = true;
		}
		return result;
	}

	private static boolean isFVS(char ch) {
		boolean result = false;
		if (ch == M_FVS1 || ch == M_FVS2 || ch == M_FVS3) {
			result = true;
		}
		return result;
	}

	private static boolean isMongolian(char ch) {
		boolean result = false;

		if ((ch >= '\u180A') && (ch <= '\u180E')) {
			result = true;
		} else if ((ch >= '\u1820') && (ch <= '\u1877')) {
			result = true;
		} else if (ch == ML_NNBS) {
			result = true;
		} else if (ch == ML_ZWJ) {
			result = true;
		}

		return result;
	}

	private static boolean isTodoVowel(char ch) {
		boolean result = false;
		if (isTodoMVowel(ch) || isTodoFMVowel(ch) || ch == ML_T_I) {
			result = true;
		}
		return result;
	}

	public static boolean isTodoMVowel(char ch) {
		boolean result = false;
		if (ch == ML_A || ch == ML_T_O || ch == ML_T_U) {
			result = true;
		}
		return result;
	}

	private static boolean isTodoFMVowel(char ch) {
		boolean result = false;
		if (ch == ML_T_E || ch == ML_T_OE || ch == ML_T_UE) {
			result = true;
		}
		return result;
	}

	private static boolean isVowel(char ch) {
		boolean result = false;
		if (isMVowel(ch) || isFMVowel(ch) || ch == ML_I) {
			result = true;
		}
		return result;
	}

	public static boolean isMVowel(char ch) {
		boolean result = false;
		if (ch == ML_A || ch == ML_O || ch == ML_U) {
			result = true;
		}
		return result;
	}

	private static boolean isFMVowel(char ch) {
		boolean result = false;
		if (ch == ML_E || ch == ML_OE || ch == ML_UE || ch == ML_EE) {
			result = true;
		}
		return result;
	}

	private static boolean isSibeVowel(char ch) {
		boolean result = false;
		if (ch == ML_A || ch == ML_S_E || ch == ML_S_I || ch == ML_O || ch == ML_S_UE || ch == ML_S_U) {
			result = true;
		}
		return result;
	}

	private static boolean isNML(char ch) {
		boolean result = false;
		if (ch == ML_N || ch == ML_M || ch == ML_L) {
			result = true;
		}
		return result;
	}

	private static boolean isTodoNMLQG(char ch) {
		boolean result = false;
		if (ch == ML_N || ch == ML_T_M || ch == ML_L | ch == ML_T_Q || ch == ML_T_G) {
			result = true;
		}
		return result;
	}

	private static String getConVowel(char con, int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (con) {
		case ML_B:
			sb.append(getBVowel(form, vowel));
			break;
		case ML_P:
			sb.append(getPVowel(form, vowel));
			break;
		case ML_H:
			sb.append(getHVowel(form, vowel));
			break;
		case ML_G:
			sb.append(getGVowel(form, vowel));
			break;
		case ML_F:
			sb.append(getFVowel(form, vowel));
			break;
		case ML_K:
			sb.append(getKVowel(form, vowel));
			break;
		case ML_KH:
			sb.append(getKHVowel(form, vowel));
			break;
		case ML_T_B:
			sb.append(getTBVowel(form, vowel));
			break;
		case ML_T_P:
			sb.append(getTPVowel(form, vowel));
			break;
		case ML_T_Q:
			sb.append(getTQVowel(form, vowel));
			break;
		case ML_T_G:
			sb.append(getTGVowel(form, vowel));
			break;
		case ML_T_K:
			sb.append(getTKVowel(form, vowel));
			break;
		case ML_T_GH:
			sb.append(getTGHVowel(form, vowel));
			break;
		case ML_S_K:
			sb.append(getSKVowel(form, vowel));
			break;
		case ML_S_G:
			sb.append(getSGVowel(form, vowel));
			break;
		case ML_S_H:
			sb.append(getSHVowel(form, vowel));
			break;
		case ML_S_P:
			sb.append(getSPVowel(form, vowel));
			break;
		case ML_S_GH:
			sb.append(getSGHVowel(form, vowel));
			break;
		case ML_S_HH:
			sb.append(getSHHVowel(form, vowel));
			break;
		case ML_M_K:
			sb.append(getMKVowel(form, vowel));
			break;
		}
		return sb.toString();
	}

	private static String getBVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_BA_ISOL);
				break;
			case ML_E:
				sb.append(ML_BE_ISOL);
				break;
			case ML_I:
				sb.append(ML_BI_ISOL);
				break;
			case ML_O:
				sb.append(ML_BO_ISOL);
				break;
			case ML_U:
				sb.append(ML_BU_ISOL);
				break;
			case ML_OE:
				sb.append(ML_BOE_ISOL);
				break;
			case ML_UE:
				sb.append(ML_BUE_ISOL);
				break;
			case ML_EE:
				sb.append(ML_BEE_ISOL);
				break;
			case ML_S_E:
				sb.append(ML_S_BE_ISOL);
				break;
			case ML_S_I:
				sb.append(ML_S_BI_ISOL);
				break;
			case ML_S_UE:
				sb.append(ML_S_BUE_ISOL);
				break;
			case ML_S_U:
				sb.append(ML_S_BU_ISOL);
				break;
			case ML_M_I:
				sb.append(ML_M_BI_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_BA_INIT);
				break;
			case ML_E:
				sb.append(ML_BE_INIT);
				break;
			case ML_I:
				sb.append(ML_BI_INIT);
				break;
			case ML_O:
				sb.append(ML_BO_INIT);
				break;
			case ML_U:
				sb.append(ML_BU_INIT);
				break;
			case ML_OE:
				sb.append(ML_BOE_INIT);
				break;
			case ML_UE:
				sb.append(ML_BUE_INIT);
				break;
			case ML_EE:
				sb.append(ML_BEE_INIT);
				break;
			case ML_S_E:
				sb.append(ML_S_BE_INIT);
				break;
			case ML_S_I:
				sb.append(ML_S_BI_INIT);
				break;
			case ML_S_UE:
				sb.append(ML_S_BUE_INIT);
				break;
			case ML_S_U:
				sb.append(ML_S_BU_INIT);
				break;
			case ML_M_I:
				sb.append(ML_M_BI_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_BA_MEDI);
				break;
			case ML_E:
				sb.append(ML_BE_MEDI);
				break;
			case ML_I:
				sb.append(ML_BI_MEDI);
				break;
			case ML_O:
				sb.append(ML_BO_MEDI);
				break;
			case ML_U:
				sb.append(ML_BU_MEDI);
				break;
			case ML_OE:
				sb.append(ML_BOE_MEDI);
				break;
			case ML_UE:
				sb.append(ML_BUE_MEDI);
				break;
			case ML_EE:
				sb.append(ML_BEE_MEDI);
				break;
			case ML_S_E:
				sb.append(ML_S_BE_MEDI);
				break;
			case ML_S_I:
				sb.append(ML_S_BI_MEDI);
				break;
			case ML_S_UE:
				sb.append(ML_S_BUE_MEDI);
				break;
			case ML_S_U:
				sb.append(ML_S_BU_MEDI);
				break;
			case ML_M_I:
				sb.append(ML_M_BI_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_BA_FINA);
				break;
			case ML_E:
				sb.append(ML_BE_FINA);
				break;
			case ML_I:
				sb.append(ML_BI_FINA);
				break;
			case ML_O:
				sb.append(ML_BO_FINA);
				break;
			case ML_U:
				sb.append(ML_BU_FINA);
				break;
			case ML_OE:
				sb.append(ML_BOE_FINA);
				break;
			case ML_UE:
				sb.append(ML_BUE_FINA);
				break;
			case ML_EE:
				sb.append(ML_BEE_FINA);
				break;
			case ML_S_E:
				sb.append(ML_S_BE_FINA);
				break;
			case ML_S_I:
				sb.append(ML_S_BI_FINA);
				break;
			case ML_S_UE:
				sb.append(ML_S_BUE_FINA);
				break;
			case ML_S_U:
				sb.append(ML_S_BU_FINA);
				break;
			case ML_M_I:
				sb.append(ML_M_BI_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getPVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_PA_ISOL);
				break;
			case ML_E:
				sb.append(ML_PE_ISOL);
				break;
			case ML_I:
				sb.append(ML_PI_ISOL);
				break;
			case ML_O:
				sb.append(ML_PO_ISOL);
				break;
			case ML_U:
				sb.append(ML_PU_ISOL);
				break;
			case ML_OE:
				sb.append(ML_POE_ISOL);
				break;
			case ML_UE:
				sb.append(ML_PUE_ISOL);
				break;
			case ML_EE:
				sb.append(ML_PEE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_PA_INIT);
				break;
			case ML_E:
				sb.append(ML_PE_INIT);
				break;
			case ML_I:
				sb.append(ML_PI_INIT);
				break;
			case ML_O:
				sb.append(ML_PO_INIT);
				break;
			case ML_U:
				sb.append(ML_PU_INIT);
				break;
			case ML_OE:
				sb.append(ML_POE_INIT);
				break;
			case ML_UE:
				sb.append(ML_PUE_INIT);
				break;
			case ML_EE:
				sb.append(ML_PEE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_PA_MEDI);
				break;
			case ML_E:
				sb.append(ML_PE_MEDI);
				break;
			case ML_I:
				sb.append(ML_PI_MEDI);
				break;
			case ML_O:
				sb.append(ML_PO_MEDI);
				break;
			case ML_U:
				sb.append(ML_PU_MEDI);
				break;
			case ML_OE:
				sb.append(ML_POE_MEDI);
				break;
			case ML_UE:
				sb.append(ML_PUE_MEDI);
				break;
			case ML_EE:
				sb.append(ML_PEE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_PA_FINA);
				break;
			case ML_E:
				sb.append(ML_PE_FINA);
				break;
			case ML_I:
				sb.append(ML_PI_FINA);
				break;
			case ML_O:
				sb.append(ML_PO_FINA);
				break;
			case ML_U:
				sb.append(ML_PU_FINA);
				break;
			case ML_OE:
				sb.append(ML_POE_FINA);
				break;
			case ML_UE:
				sb.append(ML_PUE_FINA);
				break;
			case ML_EE:
				sb.append(ML_PEE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getHVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_E:
				sb.append(ML_HE_ISOL);
				break;
			case ML_I:
				sb.append(ML_HI_ISOL);
				break;
			case ML_OE:
				sb.append(ML_HOE_ISOL);
				break;
			case ML_UE:
				sb.append(ML_HUE_ISOL);
				break;
			case ML_EE:
				sb.append(ML_HEE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_E:
				sb.append(ML_HE_INIT);
				break;
			case ML_I:
				sb.append(ML_HI_INIT);
				break;
			case ML_OE:
				sb.append(ML_HOE_INIT);
				break;
			case ML_UE:
				sb.append(ML_HUE_INIT);
				break;
			case ML_EE:
				sb.append(ML_HEE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_E:
				sb.append(ML_HE_MEDI);
				break;
			case ML_I:
				sb.append(ML_HI_MEDI);
				break;
			case ML_OE:
				sb.append(ML_HOE_MEDI);
				break;
			case ML_UE:
				sb.append(ML_HUE_MEDI);
				break;
			case ML_EE:
				sb.append(ML_HEE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_E:
				sb.append(ML_HE_FINA);
				break;
			case ML_I:
				sb.append(ML_HI_FINA);
				break;
			case ML_OE:
				sb.append(ML_HOE_FINA);
				break;
			case ML_UE:
				sb.append(ML_HUE_FINA);
				break;
			case ML_EE:
				sb.append(ML_HEE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getGVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_E:
				sb.append(ML_GE_ISOL);
				break;
			case ML_I:
				sb.append(ML_GI_ISOL);
				break;
			case ML_OE:
				sb.append(ML_GOE_ISOL);
				break;
			case ML_UE:
				sb.append(ML_GUE_ISOL);
				break;
			case ML_EE:
				sb.append(ML_GEE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_E:
				sb.append(ML_GE_INIT);
				break;
			case ML_I:
				sb.append(ML_GI_INIT);
				break;
			case ML_OE:
				sb.append(ML_GOE_INIT);
				break;
			case ML_UE:
				sb.append(ML_GUE_INIT);
				break;
			case ML_EE:
				sb.append(ML_GEE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_E:
				sb.append(ML_GE_MEDI);
				break;
			case ML_I:
				sb.append(ML_GI_MEDI);
				break;
			case ML_OE:
				sb.append(ML_GOE_MEDI);
				break;
			case ML_UE:
				sb.append(ML_GUE_MEDI);
				break;
			case ML_EE:
				sb.append(ML_GEE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_E:
				sb.append(ML_GE_FINA);
				break;
			case ML_I:
				sb.append(ML_GI_FINA);
				break;
			case ML_OE:
				sb.append(ML_GOE_FINA);
				break;
			case ML_UE:
				sb.append(ML_GUE_FINA);
				break;
			case ML_EE:
				sb.append(ML_GEE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getFVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_FA_ISOL);
				break;
			case ML_E:
				sb.append(ML_FE_ISOL);
				break;
			case ML_I:
				sb.append(ML_FI_ISOL);
				break;
			case ML_O:
				sb.append(ML_FO_ISOL);
				break;
			case ML_U:
				sb.append(ML_FU_ISOL);
				break;
			case ML_OE:
				sb.append(ML_FOE_ISOL);
				break;
			case ML_UE:
				sb.append(ML_FUE_ISOL);
				break;
			case ML_EE:
				sb.append(ML_FEE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_FA_INIT);
				break;
			case ML_E:
				sb.append(ML_FE_INIT);
				break;
			case ML_I:
				sb.append(ML_FI_INIT);
				break;
			case ML_O:
				sb.append(ML_FO_INIT);
				break;
			case ML_U:
				sb.append(ML_FU_INIT);
				break;
			case ML_OE:
				sb.append(ML_FOE_INIT);
				break;
			case ML_UE:
				sb.append(ML_FUE_INIT);
				break;
			case ML_EE:
				sb.append(ML_FEE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_FA_MEDI);
				break;
			case ML_E:
				sb.append(ML_FE_MEDI);
				break;
			case ML_I:
				sb.append(ML_FI_MEDI);
				break;
			case ML_O:
				sb.append(ML_FO_MEDI);
				break;
			case ML_U:
				sb.append(ML_FU_MEDI);
				break;
			case ML_OE:
				sb.append(ML_FOE_MEDI);
				break;
			case ML_UE:
				sb.append(ML_FUE_MEDI);
				break;
			case ML_EE:
				sb.append(ML_FEE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_FA_FINA);
				break;
			case ML_E:
				sb.append(ML_FE_FINA);
				break;
			case ML_I:
				sb.append(ML_FI_FINA);
				break;
			case ML_O:
				sb.append(ML_FO_FINA);
				break;
			case ML_U:
				sb.append(ML_FU_FINA);
				break;
			case ML_OE:
				sb.append(ML_FOE_FINA);
				break;
			case ML_UE:
				sb.append(ML_FUE_FINA);
				break;
			case ML_EE:
				sb.append(ML_FEE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getKVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_KA_ISOL);
				break;
			case ML_E:
				sb.append(ML_KE_ISOL);
				break;
			case ML_I:
				sb.append(ML_KI_ISOL);
				break;
			case ML_O:
				sb.append(ML_KO_ISOL);
				break;
			case ML_U:
				sb.append(ML_KU_ISOL);
				break;
			case ML_OE:
				sb.append(ML_KOE_ISOL);
				break;
			case ML_UE:
				sb.append(ML_KUE_ISOL);
				break;
			case ML_EE:
				sb.append(ML_KEE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_KA_INIT);
				break;
			case ML_E:
				sb.append(ML_KE_INIT);
				break;
			case ML_I:
				sb.append(ML_KI_INIT);
				break;
			case ML_O:
				sb.append(ML_KO_INIT);
				break;
			case ML_U:
				sb.append(ML_KU_INIT);
				break;
			case ML_OE:
				sb.append(ML_KOE_INIT);
				break;
			case ML_UE:
				sb.append(ML_KUE_INIT);
				break;
			case ML_EE:
				sb.append(ML_KEE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_KA_MEDI);
				break;
			case ML_E:
				sb.append(ML_KE_MEDI);
				break;
			case ML_I:
				sb.append(ML_KI_MEDI);
				break;
			case ML_O:
				sb.append(ML_KO_MEDI);
				break;
			case ML_U:
				sb.append(ML_KU_MEDI);
				break;
			case ML_OE:
				sb.append(ML_KOE_MEDI);
				break;
			case ML_UE:
				sb.append(ML_KUE_MEDI);
				break;
			case ML_EE:
				sb.append(ML_KEE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_KA_FINA);
				break;
			case ML_E:
				sb.append(ML_KE_FINA);
				break;
			case ML_I:
				sb.append(ML_KI_FINA);
				break;
			case ML_O:
				sb.append(ML_KO_FINA);
				break;
			case ML_U:
				sb.append(ML_KU_FINA);
				break;
			case ML_OE:
				sb.append(ML_KOE_FINA);
				break;
			case ML_UE:
				sb.append(ML_KUE_FINA);
				break;
			case ML_EE:
				sb.append(ML_KEE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getKHVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_KHA_ISOL);
				break;
			case ML_E:
				sb.append(ML_KHE_ISOL);
				break;
			case ML_I:
				sb.append(ML_KHI_ISOL);
				break;
			case ML_O:
				sb.append(ML_KHO_ISOL);
				break;
			case ML_U:
				sb.append(ML_KHU_ISOL);
				break;
			case ML_OE:
				sb.append(ML_KHOE_ISOL);
				break;
			case ML_UE:
				sb.append(ML_KHUE_ISOL);
				break;
			case ML_EE:
				sb.append(ML_KHEE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_KHA_INIT);
				break;
			case ML_E:
				sb.append(ML_KHE_INIT);
				break;
			case ML_I:
				sb.append(ML_KHI_INIT);
				break;
			case ML_O:
				sb.append(ML_KHO_INIT);
				break;
			case ML_U:
				sb.append(ML_KHU_INIT);
				break;
			case ML_OE:
				sb.append(ML_KHOE_INIT);
				break;
			case ML_UE:
				sb.append(ML_KHUE_INIT);
				break;
			case ML_EE:
				sb.append(ML_KHEE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_KHA_MEDI);
				break;
			case ML_E:
				sb.append(ML_KHE_MEDI);
				break;
			case ML_I:
				sb.append(ML_KHI_MEDI);
				break;
			case ML_O:
				sb.append(ML_KHO_MEDI);
				break;
			case ML_U:
				sb.append(ML_KHU_MEDI);
				break;
			case ML_OE:
				sb.append(ML_KHOE_MEDI);
				break;
			case ML_UE:
				sb.append(ML_KHUE_MEDI);
				break;
			case ML_EE:
				sb.append(ML_KHEE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_KHA_FINA);
				break;
			case ML_E:
				sb.append(ML_KHE_FINA);
				break;
			case ML_I:
				sb.append(ML_KHI_FINA);
				break;
			case ML_O:
				sb.append(ML_KHO_FINA);
				break;
			case ML_U:
				sb.append(ML_KHU_FINA);
				break;
			case ML_OE:
				sb.append(ML_KHOE_FINA);
				break;
			case ML_UE:
				sb.append(ML_KHUE_FINA);
				break;
			case ML_EE:
				sb.append(ML_KHEE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getTBVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_BA_ISOL);
				break;
			case ML_T_E:
				sb.append(ML_T_BE_ISOL);
				break;
			case ML_T_I:
				sb.append(ML_T_BI_ISOL);
				break;
			case ML_T_O:
				sb.append(ML_T_BO_ISOL);
				break;
			case ML_T_U:
				sb.append(ML_T_BU_ISOL);
				break;
			case ML_T_OE:
				sb.append(ML_T_BOE_ISOL);
				break;
			case ML_T_UE:
				sb.append(ML_T_BUE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_BA_INIT);
				break;
			case ML_T_E:
				sb.append(ML_T_BE_INIT);
				break;
			case ML_T_I:
				sb.append(ML_T_BI_INIT);
				break;
			case ML_T_O:
				sb.append(ML_T_BO_INIT);
				break;
			case ML_T_U:
				sb.append(ML_T_BU_INIT);
				break;
			case ML_T_OE:
				sb.append(ML_T_BOE_INIT);
				break;
			case ML_T_UE:
				sb.append(ML_T_BUE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_BA_MEDI);
				break;
			case ML_T_E:
				sb.append(ML_T_BE_MEDI);
				break;
			case ML_T_I:
				sb.append(ML_T_BI_MEDI);
				break;
			case ML_T_O:
				sb.append(ML_T_BO_MEDI);
				break;
			case ML_T_U:
				sb.append(ML_T_BU_MEDI);
				break;
			case ML_T_OE:
				sb.append(ML_T_BOE_MEDI);
				break;
			case ML_T_UE:
				sb.append(ML_T_BUE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_BA_FINA);
				break;
			case ML_T_E:
				sb.append(ML_T_BE_FINA);
				break;
			case ML_T_I:
				sb.append(ML_T_BI_FINA);
				break;
			case ML_T_O:
				sb.append(ML_T_BO_FINA);
				break;
			case ML_T_U:
				sb.append(ML_T_BU_FINA);
				break;
			case ML_T_OE:
				sb.append(ML_T_BOE_FINA);
				break;
			case ML_T_UE:
				sb.append(ML_T_BUE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getTPVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_PA_ISOL);
				break;
			case ML_T_E:
				sb.append(ML_T_PE_ISOL);
				break;
			case ML_T_I:
				sb.append(ML_T_PI_ISOL);
				break;
			case ML_T_O:
				sb.append(ML_T_PO_ISOL);
				break;
			case ML_T_U:
				sb.append(ML_T_PU_ISOL);
				break;
			case ML_T_OE:
				sb.append(ML_T_POE_ISOL);
				break;
			case ML_T_UE:
				sb.append(ML_T_PUE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_PA_INIT);
				break;
			case ML_T_E:
				sb.append(ML_T_PE_INIT);
				break;
			case ML_T_I:
				sb.append(ML_T_PI_INIT);
				break;
			case ML_T_O:
				sb.append(ML_T_PO_INIT);
				break;
			case ML_T_U:
				sb.append(ML_T_PU_INIT);
				break;
			case ML_T_OE:
				sb.append(ML_T_POE_INIT);
				break;
			case ML_T_UE:
				sb.append(ML_T_PUE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_PA_MEDI);
				break;
			case ML_T_E:
				sb.append(ML_T_PE_MEDI);
				break;
			case ML_T_I:
				sb.append(ML_T_PI_MEDI);
				break;
			case ML_T_O:
				sb.append(ML_T_PO_MEDI);
				break;
			case ML_T_U:
				sb.append(ML_T_PU_MEDI);
				break;
			case ML_T_OE:
				sb.append(ML_T_POE_MEDI);
				break;
			case ML_T_UE:
				sb.append(ML_T_PUE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_PA_FINA);
				break;
			case ML_T_E:
				sb.append(ML_T_PE_FINA);
				break;
			case ML_T_I:
				sb.append(ML_T_PI_FINA);
				break;
			case ML_T_O:
				sb.append(ML_T_PO_FINA);
				break;
			case ML_T_U:
				sb.append(ML_T_PU_FINA);
				break;
			case ML_T_OE:
				sb.append(ML_T_POE_FINA);
				break;
			case ML_T_UE:
				sb.append(ML_T_PUE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getTQVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_T_E:
				sb.append(ML_T_QE_ISOL);
				break;
			case ML_T_I:
				sb.append(ML_T_QI_ISOL);
				break;
			case ML_T_OE:
				sb.append(ML_T_QOE_ISOL);
				break;
			case ML_T_UE:
				sb.append(ML_T_QUE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_T_E:
				sb.append(ML_T_QE_INIT);
				break;
			case ML_T_I:
				sb.append(ML_T_QI_INIT);
				break;
			case ML_T_OE:
				sb.append(ML_T_QOE_INIT);
				break;
			case ML_T_UE:
				sb.append(ML_T_QUE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_T_E:
				sb.append(ML_T_QE_MEDI);
				break;
			case ML_T_I:
				sb.append(ML_T_QI_MEDI);
				break;
			case ML_T_OE:
				sb.append(ML_T_QOE_MEDI);
				break;
			case ML_T_UE:
				sb.append(ML_T_QUE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_T_E:
				sb.append(ML_T_QE_FINA);
				break;
			case ML_T_I:
				sb.append(ML_T_QI_FINA);
				break;
			case ML_T_OE:
				sb.append(ML_T_QOE_FINA);
				break;
			case ML_T_UE:
				sb.append(ML_T_QUE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getTGVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_T_E:
				sb.append(ML_T_GE_ISOL);
				break;
			case ML_T_I:
				sb.append(ML_T_GI_ISOL);
				break;
			case ML_T_OE:
				sb.append(ML_T_GOE_ISOL);
				break;
			case ML_T_UE:
				sb.append(ML_T_GUE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_T_E:
				sb.append(ML_T_GE_INIT);
				break;
			case ML_T_I:
				sb.append(ML_T_GI_INIT);
				break;
			case ML_T_OE:
				sb.append(ML_T_GOE_INIT);
				break;
			case ML_T_UE:
				sb.append(ML_T_GUE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_T_E:
				sb.append(ML_T_GE_MEDI);
				break;
			case ML_T_I:
				sb.append(ML_T_GI_MEDI);
				break;
			case ML_T_OE:
				sb.append(ML_T_GOE_MEDI);
				break;
			case ML_T_UE:
				sb.append(ML_T_GUE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_T_E:
				sb.append(ML_T_GE_FINA);
				break;
			case ML_T_I:
				sb.append(ML_T_GI_FINA);
				break;
			case ML_T_OE:
				sb.append(ML_T_GOE_FINA);
				break;
			case ML_T_UE:
				sb.append(ML_T_GUE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getTKVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_KA_ISOL);
				break;
			case ML_T_O:
				sb.append(ML_T_KO_ISOL);
				break;
			case ML_T_U:
				sb.append(ML_T_KU_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_KA_INIT);
				break;
			case ML_T_O:
				sb.append(ML_T_KO_INIT);
				break;
			case ML_T_U:
				sb.append(ML_T_KU_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_KA_MEDI);
				break;
			case ML_T_O:
				sb.append(ML_T_KO_MEDI);
				break;
			case ML_T_U:
				sb.append(ML_T_KU_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_KA_FINA);
				break;
			case ML_T_O:
				sb.append(ML_T_KO_FINA);
				break;
			case ML_T_U:
				sb.append(ML_T_KU_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getTGHVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_GHA_ISOL);
				break;
			case ML_T_O:
				sb.append(ML_T_GHO_ISOL);
				break;
			case ML_T_U:
				sb.append(ML_T_GHU_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_GHA_INIT);
				break;
			case ML_T_O:
				sb.append(ML_T_GHO_INIT);
				break;
			case ML_T_U:
				sb.append(ML_T_GHU_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_GHA_MEDI);
				break;
			case ML_T_O:
				sb.append(ML_T_GHO_MEDI);
				break;
			case ML_T_U:
				sb.append(ML_T_GHU_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_T_GHA_FINA);
				break;
			case ML_T_O:
				sb.append(ML_T_GHO_FINA);
				break;
			case ML_T_U:
				sb.append(ML_T_GHU_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getSKVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_KE_ISOL);
				break;
			case ML_S_I:
				sb.append(ML_S_KI_ISOL);
				break;
			case ML_S_UE:
				sb.append(ML_S_KUE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_KE_INIT);
				break;
			case ML_S_I:
				sb.append(ML_S_KI_INIT);
				break;
			case ML_S_UE:
				sb.append(ML_S_KUE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_KE_MEDI);
				break;
			case ML_S_I:
				sb.append(ML_S_KI_MEDI);
				break;
			case ML_S_UE:
				sb.append(ML_S_KUE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_KE_FINA);
				break;
			case ML_S_I:
				sb.append(ML_S_KI_FINA);
				break;
			case ML_S_UE:
				sb.append(ML_S_KUE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getSGVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_GE_ISOL);
				break;
			case ML_S_I:
				sb.append(ML_S_GI_ISOL);
				break;
			case ML_M_I:
				sb.append(ML_M_GI_ISOL);
				break;
			case ML_S_UE:
				sb.append(ML_S_GUE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_GE_INIT);
				break;
			case ML_S_I:
				sb.append(ML_S_GI_INIT);
				break;
			case ML_M_I:
				sb.append(ML_M_GI_INIT);
				break;
			case ML_S_UE:
				sb.append(ML_S_GUE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_GE_MEDI);
				break;
			case ML_S_I:
				sb.append(ML_S_GI_MEDI);
				break;
			case ML_M_I:
				sb.append(ML_M_GI_MEDI);
				break;
			case ML_S_UE:
				sb.append(ML_S_GUE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_GE_FINA);
				break;
			case ML_S_I:
				sb.append(ML_S_GI_FINA);
				break;
			case ML_M_I:
				sb.append(ML_M_GI_FINA);
				break;
			case ML_S_UE:
				sb.append(ML_S_GUE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getSHVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_HE_ISOL);
				break;
			case ML_S_I:
			case ML_M_I:
				sb.append(ML_S_HI_ISOL);
				break;
			case ML_S_UE:
				sb.append(ML_S_HUE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_HE_INIT);
				break;
			case ML_S_I:
			case ML_M_I:
				sb.append(ML_S_HI_INIT);
				break;
			case ML_S_UE:
				sb.append(ML_S_HUE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_HE_MEDI);
				break;
			case ML_S_I:
			case ML_M_I:
				sb.append(ML_S_HI_MEDI);
				break;
			case ML_S_UE:
				sb.append(ML_S_HUE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_S_HE_FINA);
				break;
			case ML_S_I:
			case ML_M_I:
				sb.append(ML_S_HI_FINA);
				break;
			case ML_S_UE:
				sb.append(ML_S_HUE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getSPVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_PA_ISOL);
				break;
			case ML_S_E:
				sb.append(ML_S_PE_ISOL);
				break;
			case ML_S_I:
				sb.append(ML_S_PI_ISOL);
				break;
			case ML_O:
				sb.append(ML_S_PO_ISOL);
				break;
			case ML_S_UE:
				sb.append(ML_S_PUE_ISOL);
				break;
			case ML_S_U:
				sb.append(ML_S_PU_ISOL);
				break;
			case ML_M_I:
				sb.append(ML_M_PI_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_PA_INIT);
				break;
			case ML_S_E:
				sb.append(ML_S_PE_INIT);
				break;
			case ML_S_I:
				sb.append(ML_S_PI_INIT);
				break;
			case ML_O:
				sb.append(ML_S_PO_INIT);
				break;
			case ML_S_UE:
				sb.append(ML_S_PUE_INIT);
				break;
			case ML_S_U:
				sb.append(ML_S_PU_INIT);
				break;
			case ML_M_I:
				sb.append(ML_M_PI_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_PA_MEDI);
				break;
			case ML_S_E:
				sb.append(ML_S_PE_MEDI);
				break;
			case ML_S_I:
				sb.append(ML_S_PI_MEDI);
				break;
			case ML_O:
				sb.append(ML_S_PO_MEDI);
				break;
			case ML_S_UE:
				sb.append(ML_S_PUE_MEDI);
				break;
			case ML_S_U:
				sb.append(ML_S_PU_MEDI);
				break;
			case ML_M_I:
				sb.append(ML_M_PI_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_PA_FINA);
				break;
			case ML_S_E:
				sb.append(ML_S_PE_FINA);
				break;
			case ML_S_I:
				sb.append(ML_S_PI_FINA);
				break;
			case ML_O:
				sb.append(ML_S_PO_FINA);
				break;
			case ML_S_UE:
				sb.append(ML_S_PUE_FINA);
				break;
			case ML_S_U:
				sb.append(ML_S_PU_FINA);
				break;
			case ML_M_I:
				sb.append(ML_M_PI_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getSGHVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_GHA_ISOL);
				break;
			case ML_O:
				sb.append(ML_S_GHO_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_GHA_INIT);
				break;
			case ML_O:
				sb.append(ML_S_GHO_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_GHA_MEDI);
				break;
			case ML_O:
				sb.append(ML_S_GHO_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_GHA_FINA);
				break;
			case ML_O:
				sb.append(ML_S_GHO_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getSHHVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_HHA_ISOL);
				break;
			case ML_O:
				sb.append(ML_S_HHO_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_HHA_INIT);
				break;
			case ML_O:
				sb.append(ML_S_HHO_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_HHA_MEDI);
				break;
			case ML_O:
				sb.append(ML_S_HHO_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_A:
				sb.append(ML_S_HHA_FINA);
				break;
			case ML_O:
				sb.append(ML_S_HHO_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getMKVowel(int form, char vowel) {
		StringBuffer sb = new StringBuffer();
		switch (form) {
		case ISOL:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_M_KE_ISOL);
				break;
			case ML_M_I:
				sb.append(ML_M_KI_ISOL);
				break;
			case ML_S_UE:
				sb.append(ML_M_KUE_ISOL);
				break;
			}
			break;
		case INIT:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_M_KE_INIT);
				break;
			case ML_M_I:
				sb.append(ML_M_KI_INIT);
				break;
			case ML_S_UE:
				sb.append(ML_M_KUE_INIT);
				break;
			}
			break;
		case MEDI:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_M_KE_MEDI);
				break;
			case ML_M_I:
				sb.append(ML_M_KI_MEDI);
				break;
			case ML_S_UE:
				sb.append(ML_M_KUE_MEDI);
				break;
			}
			break;
		case FINA:
			switch (vowel) {
			case ML_S_E:
				sb.append(ML_M_KE_FINA);
				break;
			case ML_M_I:
				sb.append(ML_M_KI_FINA);
				break;
			case ML_S_UE:
				sb.append(ML_M_KUE_FINA);
				break;
			}
			break;
		}
		return sb.toString();
	}

	private static String getConCon(char currentChar, char nextChar, int form) {
		StringBuffer sb = new StringBuffer();
		switch (currentChar) {
		case ML_NG:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_NGN_MEDI);
				break;
			case ML_H:
				if (form == MEDI) {
					sb.append(ML_NGH_MEDI);
				} else {
					sb.append(ML_NGH_FINA);
				}
				break;
			case ML_G:
				if (form == MEDI) {
					sb.append(ML_NGG_MEDI);
				} else {
					sb.append(ML_NGG_FINA);
				}
				break;
			case ML_M:
				sb.append(ML_NGM_MEDI);
				break;
			case ML_L:
				sb.append(ML_NGL_MEDI);
				break;
			case ML_M_K:
				sb.append(ML_S_NGK_MEDI);
				break;
			case ML_S_G:
				sb.append(ML_S_NGG_MEDI);
				break;
			case ML_S_H:
				sb.append(ML_S_NGH_MEDI);
				break;
			}
			break;
		case ML_B:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_BN_MEDI);
				break;
			case ML_H:
				sb.append(ML_BH_MEDI);
				break;
			case ML_G:
				sb.append(ML_BG_MEDI);
				break;
			case ML_M:
				sb.append(ML_BM_MEDI);
				break;
			case ML_L:
				sb.append(ML_BL_MEDI);
				break;
			}
			break;
		case ML_P:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_PN_MEDI);
				break;
			case ML_H:
				sb.append(ML_PH_MEDI);
				break;
			case ML_G:
				sb.append(ML_PG_MEDI);
				break;
			case ML_M:
				sb.append(ML_PM_MEDI);
				break;
			case ML_L:
				sb.append(ML_PL_MEDI);
				break;
			}
			break;
		case ML_G:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_GN_MEDI);
				break;
			// case ML_G:
			// sb.append(ML_GG_MEDI);
			// break;
			case ML_M:
				sb.append(ML_GM_MEDI);
				break;
			case ML_L:
				sb.append(ML_GL_MEDI);
				break;
			}
			break;
		case ML_M:
			switch (nextChar) {
			case ML_M:
				sb.append(ML_MM_MEDI);
				break;
			case ML_L:
				sb.append(ML_ML_MEDI);
				break;
			default:
				sb.append(nextChar);
				break;
			}
			break;
		case ML_L:
			switch (nextChar) {
			case ML_L:
				sb.append(ML_LL_MEDI);
				break;
			default:
				sb.append(nextChar);
				break;
			}
			break;
		case ML_F:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_FN_MEDI);
				break;
			case ML_H:
				sb.append(ML_FH_MEDI);
				break;
			case ML_G:
				sb.append(ML_FG_MEDI);
				break;
			case ML_M:
				sb.append(ML_FM_MEDI);
				break;
			case ML_L:
				sb.append(ML_FL_MEDI);
				break;
			}
			break;
		case ML_K:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_KN_MEDI);
				break;
			case ML_H:
				sb.append(ML_KH_MEDI_);
				break;
			case ML_G:
				sb.append(ML_KG_MEDI);
				break;
			case ML_M:
				sb.append(ML_KM_MEDI);
				break;
			case ML_L:
				sb.append(ML_KL_MEDI);
				break;
			}
			break;
		case ML_KH:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_KHN_MEDI);
				break;
			case ML_H:
				sb.append(ML_KHH_MEDI);
				break;
			case ML_G:
				sb.append(ML_KHG_MEDI);
				break;
			case ML_M:
				sb.append(ML_KHM_MEDI);
				break;
			case ML_L:
				sb.append(ML_KHL_MEDI);
				break;
			}
			break;
		case ML_T_B:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_T_BN_MEDI);
				break;
			case ML_T_M:
				sb.append(ML_T_BM_MEDI);
				break;
			case ML_L:
				sb.append(ML_T_BL_MEDI);
				break;
			case ML_T_Q:
				sb.append(ML_T_BQ_MEDI);
				break;
			case ML_T_G:
				sb.append(ML_T_BG_MEDI);
				break;
			}
			break;
		case ML_T_NG:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_T_NGN_MEDI);
				break;
			case ML_T_M:
				sb.append(ML_T_NGM_MEDI);
				break;
			case ML_L:
				sb.append(ML_T_NGL_MEDI);
				break;
			case ML_T_Q:
				sb.append(ML_T_NGQ_MEDI);
				break;
			case ML_T_G:
				if (form == MEDI) {
					sb.append(ML_T_NGG_MEDI);
				} else {
					sb.append(ML_T_NGG_FINA);
				}
				break;
			}
			break;
		case ML_T_G:
			switch (nextChar) {
			case ML_N:
				sb.append(ML_T_GN_MEDI);
				break;
			case ML_T_M:
				sb.append(ML_T_GM_MEDI);
				break;
			case ML_L:
				sb.append(ML_T_GL_MEDI);
				break;
			}
			break;
		case ML_T_M:
			switch (nextChar) {
			case ML_T_M:
				sb.append(ML_T_MM_MEDI);
				break;
			case ML_L:
				sb.append(ML_T_ML_MEDI);
				break;
			default:
				sb.append(nextChar);
				break;
			}
			break;
		}
		return sb.toString();
	}



	public static String reverse( String text ) {
		StringBuffer sb = new StringBuffer();
		int len = text.length();
		for (int i = 0; i < len; i++) {
			char ch = text.charAt(i);
			switch( ch ) {
			case M_EXCLAM_ISOL:
				sb.append( EXCLAM );
				break;

			case M_EXCLAM_QUESTION_ISOL:
				sb.append( EXCLAM );
				sb.append( QUESTION );
				break;

			case M_COMMA_ISOL1:
				sb.append( COMMA );
				break;

			case M_QUESTION_ISOL:
				sb.append( QUESTION );
				break;

			case M_QUESTION_EXCLAM_ISOL:
				sb.append( QUESTION );
				sb.append( EXCLAM );
				break;

//				COLON = '\u003A';

			case M_SEMICOLON_ISOL:
				sb.append( SEMICOLON );
				break;

			case M_BIRGA1:
			case M_BIRGA2:
			case M_BIRGA3:
//			case M_BIRGA4:
				sb.append( M_BIRGA );
				break;

			case M_ELLIPSIS_ISOL:
				sb.append( M_ELLIPSIS );
				break;

			case M_COMMA_ISOL:
				sb.append( M_COMMA );
				break;

			case M_FULL_STOP_ISOL:
				sb.append( M_FULL_STOP );
				break;

			case M_COLON_ISOL:
				sb.append( M_COLON );
				break;

			case M_FOUR_DOTS_ISOL:
				sb.append( M_FOUR_DOTS );
				break;

			case M_TODO_HYPHEN_ISOL:
				sb.append( M_TODO_HYPHEN );
				break;

			case M_SIBE_SBM_ISOL:
				sb.append( M_SIBE_SBM );
				break;

			case M_MANCHU_COMMA_ISOL:
				sb.append( M_MANCHU_COMMA );
				break;

			case M_NIRUGU_ISOL:
				sb.append( M_NIRUGU );
				break;

			case M_MANCHU_FULL_STOP_ISOL:
				sb.append( M_MANCHU_FULL_STOP );
				break;

			case M_FVS1_ISOL:
				sb.append( M_FVS1 );
				break;

			case M_FVS2_ISOL:
				sb.append( M_FVS2 );
				break;

			case M_FVS3_ISOL:
				sb.append( M_FVS3 );
				break;

			case M_MVS_ISOL:
				sb.append( M_MVS );
				break;

			case M_DIGIT_ZERO_ISOL:
				sb.append( M_DIGIT_ZERO );
				break;

			case M_DIGIT_ONE_ISOL:
				sb.append( M_DIGIT_ONE );
				break;

			case M_DIGIT_TWO_ISOL:
				sb.append( M_DIGIT_TWO );
				break;

			case M_DIGIT_THREE_ISOL:
				sb.append( M_DIGIT_THREE );
				break;

			case M_DIGIT_FOUR_ISOL:
				sb.append( M_DIGIT_FOUR );
				break;

			case M_DIGIT_FIVE_ISOL:
				sb.append( M_DIGIT_FIVE );
				break;

			case M_DIGIT_SIX_ISOL:
				sb.append( M_DIGIT_SIX );
				break;

			case M_DIGIT_SEVEN_ISOL:
				sb.append( M_DIGIT_SEVEN );
				break;

			case M_DIGIT_EIGHT_ISOL:
				sb.append( M_DIGIT_EIGHT );
				break;

			case M_DIGIT_NINE_ISOL:
				sb.append( M_DIGIT_NINE );
				break;

			case ML_A_ISOL:
			case ML_A_ISOL1:
			case ML_A_INIT:
			case ML_A_INIT1:
			case ML_A_MEDI:
			case ML_A_MEDI1:
			case ML_A_FINA:
			case ML_A_FINA1:
			case ML_A_FINA2:
				sb.append( ML_A );
				break;

			case ML_E_ISOL:
			case ML_E_ISOL1:
			case ML_E_INIT:
			case ML_E_INIT1:
			case ML_E_MEDI:
			case ML_E_FINA:
			case ML_E_FINA1:
			case ML_E_FINA2:
				sb.append( ML_E );
				break;

			case ML_I_ISOL:
			case ML_I_ISOL1:
			case ML_I_INIT:
			case ML_I_INIT1:
			case ML_I_MEDI:
			case ML_I_MEDI1:
			case ML_I_MEDI2:
			case ML_I_FINA:
				sb.append( ML_I );
				break;

			case ML_O_ISOL:
			case ML_O_ISOL1:
			case ML_O_INIT:
			case ML_O_INIT1:
			case ML_O_MEDI:
			case ML_O_MEDI1:
			case ML_O_FINA:
			case ML_O_FINA1:
				sb.append( ML_O );
				break;

			case ML_U_ISOL:
			case ML_U_ISOL1:
			case ML_U_INIT:
			case ML_U_INIT1:
			case ML_U_MEDI:
			case ML_U_MEDI1:
			case ML_U_FINA:
			case ML_U_FINA1:
				sb.append( ML_U );
				break;

			case ML_OE_ISOL:
			case ML_OE_ISOL1:
			case ML_OE_INIT:
			case ML_OE_INIT1:
			case ML_OE_MEDI:
			case ML_OE_MEDI1:
			case ML_OE_MEDI2:
			case ML_OE_FINA:
			case ML_OE_FINA1:
				sb.append( ML_OE );
				break;

			case ML_UE_ISOL:
			case ML_UE_ISOL1:
			case ML_UE_ISOL2:
			case ML_UE_INIT:
			case ML_UE_INIT1:
			case ML_UE_MEDI:
			case ML_UE_MEDI1:
			case ML_UE_MEDI2:
			case ML_UE_FINA:
			case ML_UE_FINA1:
				sb.append( ML_UE );
				break;

			case ML_EE_ISOL:
			case ML_EE_ISOL1:
			case ML_EE_INIT:
			case ML_EE_INIT1:
			case ML_EE_MEDI:
			case ML_EE_FINA:
				sb.append( ML_EE );
				break;

			case ML_N_ISOL:
			case ML_N_ISOL1:
			case ML_N_INIT:
			case ML_N_INIT1:
			case ML_N_MEDI:
			case ML_N_MEDI1:
			case ML_N_FINA:
			case ML_N_FINA1:
			case ML_N_FINA2:
				sb.append( ML_N );
				break;

			case ML_NG_ISOL:
			case ML_NG_INIT:
			case ML_NG_MEDI:
			case ML_NG_FINA:
				sb.append( ML_NG );
				break;
			case ML_NGN_MEDI:
				sb.append( ML_NG + ML_N );
				break;
			case ML_NGH_MEDI:
			case ML_NGH_FINA:
				sb.append( ML_NG + ML_H );
				break;
			case ML_NGG_MEDI:
			case ML_NGG_FINA:
				sb.append( ML_NG + ML_G );
				break;
			case ML_NGM_MEDI:
				sb.append( ML_NG + ML_M );
				break;
			case ML_NGL_MEDI:
				sb.append( ML_NG + ML_L );
				break;

			case ML_B_ISOL:
			case ML_B_INIT:
			case ML_B_MEDI:
			case ML_B_FINA:
			case ML_B_FINA1:
				sb.append( ML_B );
				break;
			case ML_BA_ISOL:
			case ML_BA_INIT:
			case ML_BA_MEDI:
			case ML_BA_FINA:
				sb.append( ML_B + ML_A );
				break;
			case ML_BE_ISOL:
			case ML_BE_INIT:
			case ML_BE_MEDI:
			case ML_BE_FINA:
				sb.append( ML_B + ML_E );
				break;
			case ML_BI_ISOL:
			case ML_BI_INIT:
			case ML_BI_MEDI:
			case ML_BI_FINA:
				sb.append( ML_B + ML_I );
				break;
			case ML_BO_ISOL:
			case ML_BO_INIT:
			case ML_BO_MEDI:
			case ML_BO_FINA:
				sb.append( ML_B + ML_O );
				break;
			case ML_BU_ISOL:
			case ML_BU_INIT:
			case ML_BU_MEDI:
			case ML_BU_FINA:
				sb.append( ML_B + ML_U );
				break;
			case ML_BOE_ISOL:
			case ML_BOE_INIT:
			case ML_BOE_MEDI:
			case ML_BOE_MEDI1:
			case ML_BOE_FINA:
			case ML_BOE_FINA1:
				sb.append( ML_B + ML_OE );
				break;
			case ML_BUE_ISOL:
			case ML_BUE_INIT:
			case ML_BUE_MEDI:
			case ML_BUE_MEDI1:
			case ML_BUE_FINA:
			case ML_BUE_FINA1:
				sb.append( ML_B + ML_UE );
				break;
			case ML_BEE_ISOL:
			case ML_BEE_INIT:
			case ML_BEE_MEDI:
			case ML_BEE_FINA:
				sb.append( ML_B + ML_EE );
				break;
			case ML_BN_MEDI:
				sb.append( ML_B + ML_N );
				break;
			case ML_BH_MEDI:
				sb.append( ML_B + ML_H );
				break;
			case ML_BG_MEDI:
				sb.append( ML_B + ML_G );
				break;
			case ML_BM_MEDI:
				sb.append( ML_B + ML_M );
				break;
			case ML_BL_MEDI:
				sb.append( ML_B + ML_L );
				break;

			case ML_P_ISOL:
			case ML_P_INIT:
			case ML_P_MEDI:
			case ML_P_FINA:
				sb.append( ML_P );
				break;
			case ML_PA_ISOL:
			case ML_PA_INIT:
			case ML_PA_MEDI:
			case ML_PA_FINA:
				sb.append( ML_P + ML_A );
				break;
			case ML_PE_ISOL:
			case ML_PE_INIT:
			case ML_PE_MEDI:
			case ML_PE_FINA:
				sb.append( ML_P + ML_E );
				break;
			case ML_PI_ISOL:
			case ML_PI_INIT:
			case ML_PI_MEDI:
			case ML_PI_FINA:
				sb.append( ML_P + ML_I );
				break;
			case ML_PO_ISOL:
			case ML_PO_INIT:
			case ML_PO_MEDI:
			case ML_PO_FINA:
				sb.append( ML_P + ML_O );
				break;
			case ML_PU_ISOL:
			case ML_PU_INIT:
			case ML_PU_MEDI:
			case ML_PU_FINA:
				sb.append( ML_P + ML_U );
				break;
			case ML_POE_ISOL:
			case ML_POE_INIT:
			case ML_POE_MEDI:
			case ML_POE_MEDI1:
			case ML_POE_FINA:
			case ML_POE_FINA1:
				sb.append( ML_P + ML_OE );
				break;
			case ML_PUE_ISOL:
			case ML_PUE_INIT:
			case ML_PUE_MEDI:
			case ML_PUE_MEDI1:
			case ML_PUE_FINA:
			case ML_PUE_FINA1:
				sb.append( ML_P + ML_UE );
				break;
			case ML_PEE_ISOL:
			case ML_PEE_INIT:
			case ML_PEE_MEDI:
			case ML_PEE_FINA:
				sb.append( ML_P + ML_EE );
				break;
			case ML_PN_MEDI:
				sb.append( ML_P + ML_N );
				break;
			case ML_PH_MEDI:
				sb.append( ML_P + ML_H );
				break;
			case ML_PG_MEDI:
				sb.append( ML_P + ML_G );
				break;
			case ML_PM_MEDI:
				sb.append( ML_P + ML_M );
				break;
			case ML_PL_MEDI:
				sb.append( ML_P + ML_L );
				break;

			case ML_H_ISOL:
			case ML_H_ISOL1:
			case ML_H_ISOL2:
			case ML_H_ISOL3:
			case ML_H_INIT:
			case ML_H_INIT1:
			case ML_H_INIT2:
			case ML_H_INIT3:
			case ML_H_MEDI:
			case ML_H_MEDI1:
			case ML_H_MEDI2:
			case ML_H_MEDI3:
			case ML_H_FINA:
			case ML_H_FINA1:
			case ML_H_FINA2:
				sb.append( ML_H );
				break;
			case ML_HE_ISOL:
			case ML_HE_ISOL1:
			case ML_HE_INIT:
			case ML_HE_INIT1:
			case ML_HE_MEDI:
			case ML_HE_MEDI1:
			case ML_HE_FINA:
			case ML_HE_FINA1:
				sb.append( ML_H + ML_E );
				break;
			case ML_HI_ISOL:
			case ML_HI_ISOL1:
			case ML_HI_INIT:
			case ML_HI_INIT1:
			case ML_HI_MEDI:
			case ML_HI_MEDI1:
			case ML_HI_FINA:
			case ML_HI_FINA1:
				sb.append( ML_H + ML_I );
				break;
			case ML_HOE_ISOL:
			case ML_HOE_ISOL1:
			case ML_HOE_INIT:
			case ML_HOE_INIT1:
			case ML_HOE_MEDI:
			case ML_HOE_MEDI1:
			case ML_HOE_MEDI2:
			case ML_HOE_FINA:
			case ML_HOE_FINA1:
			case ML_HOE_FINA2:
			case ML_HOE_FINA3:
				sb.append( ML_H + ML_OE );
				break;
			case ML_HUE_ISOL:
			case ML_HUE_ISOL1:
			case ML_HUE_INIT:
			case ML_HUE_INIT1:
			case ML_HUE_MEDI:
			case ML_HUE_MEDI1:
			case ML_HUE_MEDI2:
			case ML_HUE_FINA:
			case ML_HUE_FINA1:
			case ML_HUE_FINA2:
			case ML_HUE_FINA3:
				sb.append( ML_H + ML_UE );
				break;
			case ML_HEE_ISOL:
			case ML_HEE_ISOL1:
			case ML_HEE_INIT:
			case ML_HEE_INIT1:
			case ML_HEE_MEDI:
			case ML_HEE_MEDI1:
			case ML_HEE_FINA:
			case ML_HEE_FINA1:
				sb.append( ML_H + ML_EE );
				break;

			case ML_G_ISOL:
			case ML_G_ISOL1:
//			case ML_G_ISOL2:
//			case ML_G_ISOL3:
			case ML_G_INIT:
			case ML_G_INIT1:
//			case ML_G_INIT2:
//			case ML_G_INIT3:
			case ML_G_MEDI:
			case ML_G_MEDI1:
			case ML_G_MEDI2:
//			case ML_G_MEDI3:
			case ML_G_FINA:
			case ML_G_FINA1:
			case ML_G_FINA2:
				sb.append( ML_G );
				break;
			case ML_GE_ISOL:
//			case ML_GE_ISOL1:
			case ML_GE_INIT:
//			case ML_GE_INIT1:
			case ML_GE_MEDI:
//			case ML_GE_MEDI1:
			case ML_GE_FINA:
//			case ML_GE_FINA1:
				sb.append( ML_G + ML_E );
				break;
			case ML_GI_ISOL:
//			case ML_GI_ISOL1:
			case ML_GI_INIT:
//			case ML_GI_INIT1:
			case ML_GI_MEDI:
//			case ML_GI_MEDI1:
			case ML_GI_FINA:
//			case ML_GI_FINA1:
				sb.append( ML_G + ML_I );
				break;
			case ML_GOE_ISOL:
//			case ML_GOE_ISOL1:
			case ML_GOE_INIT:
//			case ML_GOE_INIT1:
			case ML_GOE_MEDI:
			case ML_GOE_MEDI1:
//			case ML_GOE_MEDI2:
			case ML_GOE_FINA:
			case ML_GOE_FINA1:
//			case ML_GOE_FINA2:
//			case ML_GOE_FINA3:
				sb.append( ML_G + ML_OE );
				break;
			case ML_GUE_ISOL:
//			case ML_GUE_ISOL1:
			case ML_GUE_INIT:
//			case ML_GUE_INIT1:
			case ML_GUE_MEDI:
			case ML_GUE_MEDI1:
//			case ML_GUE_MEDI2:
			case ML_GUE_FINA:
			case ML_GUE_FINA1:
//			case ML_GUE_FINA2:
//			case ML_GUE_FINA3:
				sb.append( ML_G + ML_UE );
				break;
			case ML_GEE_ISOL:
			case ML_GEE_INIT:
			case ML_GEE_MEDI:
			case ML_GEE_FINA:
				sb.append( ML_G + ML_EE );
				break;
			case ML_GN_MEDI:
				sb.append( ML_G + ML_N );
				break;
			case ML_GM_MEDI:
				sb.append( ML_G + ML_M );
				break;
			case ML_GL_MEDI:
				sb.append( ML_G + ML_L );
				break;

			case ML_M_ISOL:
			case ML_M_INIT:
			case ML_M_MEDI:
			case ML_M_FINA:
				sb.append( ML_M );
				break;
			case ML_MM_MEDI:
				sb.append( ML_M + ML_M );
				break;
			case ML_ML_MEDI:
				sb.append( ML_M + ML_M );
				break;

			case ML_L_ISOL:
			case ML_L_INIT:
			case ML_L_MEDI:
			case ML_L_FINA:
				sb.append( ML_L );
				break;
			case ML_LL_MEDI:
				sb.append( ML_L + ML_L );
				break;

			case ML_S_ISOL:
			case ML_S_INIT:
			case ML_S_MEDI:
			case ML_S_FINA:
			case ML_S_FINA1:
			case ML_S_FINA2:
				sb.append( ML_S );
				break;

			case ML_SH_ISOL:
			case ML_SH_INIT:
			case ML_SH_MEDI:
			case ML_SH_FINA:
				sb.append( ML_SH );
				break;

			case ML_T_ISOL:
			case ML_T_ISOL1:
			case ML_T_INIT:
			case ML_T_MEDI:
			case ML_T_MEDI1:
			case ML_T_MEDI2:
			case ML_T_FINA:
				sb.append( ML_T );
				break;

			case ML_D_ISOL:
			case ML_D_INIT:
			case ML_D_INIT1:
			case ML_D_MEDI:
			case ML_D_MEDI1:
			case ML_D_FINA:
			case ML_D_FINA1:
				sb.append( ML_D );
				break;

			case ML_CH_ISOL:
			case ML_CH_INIT:
			case ML_CH_MEDI:
			case ML_CH_FINA:
				sb.append( ML_CH );
				break;

			case ML_J_ISOL:
			case ML_J_ISOL1:
			case ML_J_INIT:
			case ML_J_MEDI:
			case ML_J_FINA:
				sb.append( ML_J );
				break;

			case ML_Y_ISOL:
			case ML_Y_INIT:
			case ML_Y_INIT1:
			case ML_Y_MEDI:
			case ML_Y_MEDI1:
			case ML_Y_FINA:
				sb.append( ML_Y );
				break;

			case ML_R_ISOL:
			case ML_R_INIT:
			case ML_R_MEDI:
			case ML_R_FINA:
				sb.append( ML_R );
				break;

			case ML_W_ISOL:
			case ML_W_INIT:
			case ML_W_INIT1:
			case ML_W_MEDI:
			case ML_W_FINA:
			case ML_W_FINA1:
				sb.append( ML_W );
				break;

			case ML_F_ISOL:
			case ML_F_INIT:
			case ML_F_MEDI:
			case ML_F_FINA:
				sb.append( ML_F );
				break;
			case ML_FA_ISOL:
			case ML_FA_INIT:
			case ML_FA_MEDI:
			case ML_FA_FINA:
				sb.append( ML_F + ML_A );
				break;
			case ML_FE_ISOL:
			case ML_FE_INIT:
			case ML_FE_MEDI:
			case ML_FE_FINA:
				sb.append( ML_F + ML_E );
				break;
			case ML_FI_ISOL:
			case ML_FI_INIT:
			case ML_FI_MEDI:
			case ML_FI_FINA:
				sb.append( ML_F + ML_I );
				break;
			case ML_FO_ISOL:
			case ML_FO_INIT:
			case ML_FO_MEDI:
			case ML_FO_FINA:
				sb.append( ML_F + ML_O );
				break;
			case ML_FU_ISOL:
			case ML_FU_INIT:
			case ML_FU_MEDI:
			case ML_FU_FINA:
				sb.append( ML_F + ML_U );
				break;
			case ML_FOE_ISOL:
			case ML_FOE_INIT:
			case ML_FOE_MEDI:
			case ML_FOE_MEDI1:
			case ML_FOE_FINA:
			case ML_FOE_FINA1:
				sb.append( ML_F + ML_OE );
				break;
			case ML_FUE_ISOL:
			case ML_FUE_INIT:
			case ML_FUE_MEDI:
			case ML_FUE_MEDI1:
			case ML_FUE_FINA:
			case ML_FUE_FINA1:
				sb.append( ML_F + ML_UE );
				break;
			case ML_FEE_ISOL:
			case ML_FEE_INIT:
			case ML_FEE_MEDI:
			case ML_FEE_FINA:
				sb.append( ML_F + ML_EE );
				break;
			case ML_FN_MEDI:
				sb.append( ML_F + ML_N );
				break;
			case ML_FH_MEDI:
				sb.append( ML_F + ML_H );
				break;
			case ML_FG_MEDI:
				sb.append( ML_F + ML_G );
				break;
			case ML_FM_MEDI:
				sb.append( ML_F + ML_M );
				break;
			case ML_FL_MEDI:
				sb.append( ML_F + ML_L );
				break;

			case ML_K_ISOL:
			case ML_K_INIT:
			case ML_K_MEDI:
			case ML_K_FINA:
				sb.append( ML_K );
				break;
			case ML_KA_ISOL:
			case ML_KA_INIT:
			case ML_KA_MEDI:
			case ML_KA_FINA:
				sb.append( ML_K + ML_A );
				break;
			case ML_KE_ISOL:
			case ML_KE_INIT:
			case ML_KE_MEDI:
			case ML_KE_FINA:
				sb.append( ML_K + ML_E );
				break;
			case ML_KI_ISOL:
			case ML_KI_INIT:
			case ML_KI_MEDI:
			case ML_KI_FINA:
				sb.append( ML_K + ML_I );
				break;
			case ML_KO_ISOL:
			case ML_KO_INIT:
			case ML_KO_MEDI:
			case ML_KO_FINA:
				sb.append( ML_K + ML_O );
				break;
			case ML_KU_ISOL:
			case ML_KU_INIT:
			case ML_KU_MEDI:
			case ML_KU_FINA:
				sb.append( ML_K + ML_U );
				break;
			case ML_KOE_ISOL:
			case ML_KOE_INIT:
			case ML_KOE_MEDI:
			case ML_KOE_MEDI1:
			case ML_KOE_FINA:
			case ML_KOE_FINA1:
				sb.append( ML_K + ML_OE );
				break;
			case ML_KUE_ISOL:
			case ML_KUE_INIT:
			case ML_KUE_MEDI:
			case ML_KUE_MEDI1:
			case ML_KUE_FINA:
			case ML_KUE_FINA1:
				sb.append( ML_K + ML_UE );
				break;
			case ML_KEE_ISOL:
			case ML_KEE_INIT:
			case ML_KEE_MEDI:
			case ML_KEE_FINA:
				sb.append( ML_K + ML_EE );
				break;
			case ML_KN_MEDI:
				sb.append( ML_K + ML_N );
				break;
			case ML_KH_MEDI:
				sb.append( ML_K + ML_H );
				break;
			case ML_KG_MEDI:
				sb.append( ML_K + ML_G );
				break;
			case ML_KM_MEDI:
				sb.append( ML_K + ML_M );
				break;
			case ML_KL_MEDI:
				sb.append( ML_K + ML_L );
				break;

			case ML_KH_ISOL:
			case ML_KH_INIT:
			case ML_KHH_MEDI:
			case ML_KH_FINA:
				sb.append( ML_KH );
				break;
			case ML_KHA_ISOL:
			case ML_KHA_INIT:
			case ML_KHA_MEDI:
			case ML_KHA_FINA:
				sb.append( ML_H + ML_A );
				break;
			case ML_KHE_ISOL:
			case ML_KHE_INIT:
			case ML_KHE_MEDI:
			case ML_KHE_FINA:
				sb.append( ML_KH + ML_E );
				break;
			case ML_KHI_ISOL:
			case ML_KHI_INIT:
			case ML_KHI_MEDI:
			case ML_KHI_FINA:
				sb.append( ML_KH + ML_I );
				break;
			case ML_KHO_ISOL:
			case ML_KHO_INIT:
			case ML_KHO_MEDI:
			case ML_KHO_FINA:
				sb.append( ML_KH + ML_O );
				break;
			case ML_KHU_ISOL:
			case ML_KHU_INIT:
			case ML_KHU_MEDI:
			case ML_KHU_FINA:
				sb.append( ML_KH + ML_U );
				break;
			case ML_KHOE_ISOL:
			case ML_KHOE_INIT:
			case ML_KHOE_MEDI:
			case ML_KHOE_MEDI1:
			case ML_KHOE_FINA:
			case ML_KHOE_FINA1:
				sb.append( ML_KH + ML_OE );
				break;
			case ML_KHUE_ISOL:
			case ML_KHUE_INIT:
			case ML_KHUE_MEDI:
			case ML_KHUE_MEDI1:
			case ML_KHUE_FINA:
			case ML_KHUE_FINA1:
				sb.append( ML_KH + ML_UE );
				break;
			case ML_KHEE_ISOL:
			case ML_KHEE_INIT:
			case ML_KHEE_MEDI:
			case ML_KHEE_FINA:
				sb.append( ML_KH + ML_EE );
				break;
			case ML_KHN_MEDI:
				sb.append( ML_KH + ML_N );
				break;
			case ML_KH_MEDI_:
				sb.append( ML_KH + ML_H );
				break;
			case ML_KHG_MEDI:
				sb.append( ML_KH + ML_G );
				break;
			case ML_KHM_MEDI:
				sb.append( ML_KH + ML_M );
				break;
			case ML_KHL_MEDI:
				sb.append( ML_KH + ML_L );
				break;

			case ML_C_ISOL:
			case ML_C_INIT:
			case ML_C_MEDI:
			case ML_C_FINA:
				sb.append( ML_C );
				break;

			case ML_Z_ISOL:
			case ML_Z_INIT:
			case ML_Z_MEDI:
			case ML_Z_FINA:
				sb.append( ML_Z );
				break;

			case ML_HH_ISOL:
			case ML_HH_INIT:
			case ML_HH_MEDI:
			case ML_HH_FINA:
				sb.append( ML_HH );
				break;

			case ML_RH_ISOL:
			case ML_RH_INIT:
			case ML_RH_MEDI:
			case ML_RH_FINA:
				sb.append( ML_RH );
				break;

			case ML_LH_ISOL:
			case ML_LH_INIT:
			case ML_LH_MEDI:
			case ML_LH_FINA:
				sb.append( ML_LH );
				break;

			case ML_ZHI_ISOL:
			case ML_ZHI_INIT:
			case ML_ZHI_MEDI:
			case ML_ZHI_FINA:
				sb.append( ML_ZHI );
				break;

			case ML_CHI_ISOL:
			case ML_CHI_INIT:
			case ML_CHI_MEDI:
			case ML_CHI_FINA:
				sb.append( ML_CHI );
				break;

			case ML_T_LVS_ISOL:
			case ML_T_LVS_INIT:
			case ML_T_LVS_MEDI:
			case ML_T_LVS_FINA:
				sb.append( ML_T_LVS );
				break;

			case ML_T_LONG_A_ISOL:
			case ML_T_LONG_A_INIT:
			case ML_T_LONG_A_MEDI:
			case ML_T_LONG_A_FINA:
				sb.append( ML_A + ML_T_LVS );
				break;

			case ML_T_E_ISOL:
			case ML_T_E_INIT:
			case ML_T_E_MEDI:
			case ML_T_E_MEDI1:
			case ML_T_E_FINA:
				sb.append( ML_T_E );
				break;

			case ML_T_I_ISOL:
			case ML_T_I_INIT:
			case ML_T_I_MEDI:
			case ML_T_I_MEDI1:
			case ML_T_I_FINA:
				sb.append( ML_T_I );
				break;

			case ML_T_O_ISOL:
			case ML_T_O_INIT:
			case ML_T_O_MEDI:
			case ML_T_O_MEDI1:
			case ML_T_O_FINA:
				sb.append( ML_T_O );
				break;
			case ML_T_LONG_O_ISOL:
			case ML_T_LONG_O_INIT:
			case ML_T_LONG_O_MEDI:
			case ML_T_LONG_O_FINA:
				sb.append( ML_T_O + ML_T_LVS );
				break;

			case ML_T_U_ISOL:
			case ML_T_U_ISOL1:
			case ML_T_U_INIT:
			case ML_T_U_MEDI:
			case ML_T_U_MEDI1:
			case ML_T_U_MEDI2:
			case ML_T_U_FINA:
			case ML_T_U_FINA1:
				sb.append( ML_T_U );
				break;

			case ML_T_OE_ISOL:
			case ML_T_OE_INIT:
			case ML_T_OE_MEDI:
			case ML_T_OE_MEDI1:
			case ML_T_OE_FINA:
				sb.append( ML_T_OE );
				break;
			case ML_T_LONG_OE_ISOL:
			case ML_T_LONG_OE_INIT:
			case ML_T_LONG_OE_MEDI:
			case ML_T_LONG_OE_FINA:
				sb.append( ML_T_OE + ML_T_LVS );
				break;

			case ML_T_UE_ISOL:
			case ML_T_UE_ISOL1:
			case ML_T_UE_INIT:
			case ML_T_UE_MEDI:
			case ML_T_UE_MEDI1:
			case ML_T_UE_FINA:
				sb.append( ML_T_UE );
				break;

			case ML_T_NG_ISOL:
			case ML_T_NG_INIT:
			case ML_T_NG_MEDI:
			case ML_T_NG_FINA:
				sb.append( ML_T_NG );
				break;
			case ML_T_NGN_MEDI:
				sb.append( ML_T_NG + ML_N );
				break;
			case ML_T_NGM_MEDI:
				sb.append( ML_T_NG + ML_T_M );
				break;
			case ML_T_NGL_MEDI:
				sb.append( ML_T_NG + ML_L );
				break;
			case ML_T_NGQ_MEDI:
				sb.append( ML_T_NG + ML_T_Q );
				break;
			case ML_T_NGG_MEDI:
				sb.append( ML_T_NG + ML_T_G );
				break;
			case ML_T_NGG_FINA:
				sb.append( ML_T_NG + ML_T_G );
				break;

			case ML_T_B_ISOL:
			case ML_T_B_INIT:
			case ML_T_B_MEDI:
			case ML_T_B_FINA:
				sb.append( ML_T_B );
				break;
			case ML_T_BA_ISOL:
			case ML_T_BA_INIT:
			case ML_T_BA_MEDI:
			case ML_T_BA_FINA:
				sb.append( ML_T_B + ML_A );
				break;
			case ML_T_BE_ISOL:
			case ML_T_BE_INIT:
			case ML_T_BE_MEDI:
			case ML_T_BE_FINA:
				sb.append( ML_T_B + ML_T_E );
				break;
			case ML_T_BI_ISOL:
			case ML_T_BI_INIT:
			case ML_T_BI_MEDI:
			case ML_T_BI_FINA:
				sb.append( ML_T_B + ML_T_I);
				break;
			case ML_T_BO_ISOL:
			case ML_T_BO_INIT:
			case ML_T_BO_MEDI:
			case ML_T_BO_FINA:
				sb.append( ML_T_B + ML_T_O);
				break;
			case ML_T_BU_ISOL:
			case ML_T_BU_INIT:
			case ML_T_BU_MEDI:
			case ML_T_BU_FINA:
				sb.append( ML_T_B + ML_T_U);
				break;
			case ML_T_BOE_ISOL:
			case ML_T_BOE_INIT:
			case ML_T_BOE_MEDI:
			case ML_T_BOE_FINA:
				sb.append( ML_T_B + ML_T_OE);
				break;
			case ML_T_BUE_ISOL:
			case ML_T_BUE_INIT:
			case ML_T_BUE_MEDI:
			case ML_T_BUE_FINA:
				sb.append( ML_T_B + ML_T_UE);
				break;
			case ML_T_BN_MEDI:
				sb.append( ML_T_B + ML_N);
				break;
			case ML_T_BM_MEDI:
				sb.append( ML_T_B + ML_T_M);
				break;
			case ML_T_BL_MEDI:
				sb.append( ML_T_B + ML_L);
				break;
			case ML_T_BQ_MEDI:
				sb.append( ML_T_B + ML_T_Q);
				break;
			case ML_T_BG_MEDI:
				sb.append( ML_T_B + ML_T_G);
				break;

			case ML_T_P_ISOL:
			case ML_T_P_INIT:
			case ML_T_P_MEDI:
			case ML_T_P_FINA:
				sb.append( ML_T_P );
				break;
			case ML_T_PA_ISOL:
			case ML_T_PA_INIT:
			case ML_T_PA_MEDI:
			case ML_T_PA_FINA:
				sb.append( ML_T_P + ML_A );
				break;
			case ML_T_PE_ISOL:
			case ML_T_PE_INIT:
			case ML_T_PE_MEDI:
			case ML_T_PE_FINA:
				sb.append( ML_T_P + ML_T_E );
				break;
			case ML_T_PI_ISOL:
			case ML_T_PI_INIT:
			case ML_T_PI_MEDI:
			case ML_T_PI_FINA:
				sb.append( ML_T_P + ML_T_I);
				break;
			case ML_T_PO_ISOL:
			case ML_T_PO_INIT:
			case ML_T_PO_MEDI:
			case ML_T_PO_FINA:
				sb.append( ML_T_P + ML_T_O);
				break;
			case ML_T_PU_ISOL:
			case ML_T_PU_INIT:
			case ML_T_PU_MEDI:
			case ML_T_PU_FINA:
				sb.append( ML_T_P + ML_T_U);
				break;
			case ML_T_POE_ISOL:
			case ML_T_POE_INIT:
			case ML_T_POE_MEDI:
			case ML_T_POE_FINA:
				sb.append( ML_T_P + ML_T_OE);
				break;
			case ML_T_PUE_ISOL:
			case ML_T_PUE_INIT:
			case ML_T_PUE_MEDI:
			case ML_T_PUE_FINA:
				sb.append( ML_T_P + ML_T_UE);
				break;

			case ML_T_Q_ISOL:
			case ML_T_Q_INIT:
			case ML_T_Q_INIT1:
			case ML_T_Q_MEDI:
			case ML_T_Q_MEDI1:
			case ML_T_Q_FINA:
				sb.append( ML_T_Q );
				break;
			case ML_T_QE_ISOL:
			case ML_T_QE_INIT:
			case ML_T_QE_MEDI:
			case ML_T_QE_FINA:
				sb.append( ML_T_Q + ML_T_E);
				break;
			case ML_T_QI_ISOL:
			case ML_T_QI_INIT:
			case ML_T_QI_MEDI:
			case ML_T_QI_FINA:
				sb.append( ML_T_Q + ML_T_I);
				break;
			case ML_T_QOE_ISOL:
			case ML_T_QOE_INIT:
			case ML_T_QOE_MEDI:
			case ML_T_QOE_FINA:
				sb.append( ML_T_Q + ML_T_OE);
				break;
			case ML_T_QUE_ISOL:
			case ML_T_QUE_INIT:
			case ML_T_QUE_MEDI:
			case ML_T_QUE_FINA:
				sb.append( ML_T_Q + ML_T_UE);
				break;

			case ML_T_G_ISOL:
			case ML_T_G_ISOL1:
			case ML_T_G_INIT:
			case ML_T_G_INIT1:
			case ML_T_G_MEDI:
			case ML_T_G_MEDI1:
			case ML_T_G_FINA:
				sb.append( ML_T_G );
				break;
			case ML_T_GE_ISOL:
			case ML_T_GE_INIT:
			case ML_T_GE_MEDI:
			case ML_T_GE_FINA:
				sb.append( ML_T_G + ML_T_E);
				break;
			case ML_T_GI_ISOL:
			case ML_T_GI_INIT:
			case ML_T_GI_MEDI:
			case ML_T_GI_FINA:
				sb.append( ML_T_G + ML_T_I);
				break;
			case ML_T_GOE_ISOL:
			case ML_T_GOE_INIT:
			case ML_T_GOE_MEDI:
			case ML_T_GOE_FINA:
				sb.append( ML_T_G + ML_T_OE);
				break;
			case ML_T_GUE_ISOL:
			case ML_T_GUE_INIT:
			case ML_T_GUE_MEDI:
			case ML_T_GUE_FINA:
				sb.append( ML_T_G + ML_T_UE);
				break;
			case ML_T_GN_MEDI:
				sb.append( ML_T_G + ML_N);
				break;
			case ML_T_GM_MEDI:
				sb.append( ML_T_G + ML_T_M);
				break;
			case ML_T_GL_MEDI:
				sb.append( ML_T_G + ML_L);
				break;

			case ML_T_M_ISOL:
			case ML_T_M_INIT:
			case ML_T_M_MEDI:
			case ML_T_M_FINA:
				sb.append( ML_T_M );
				break;
			case ML_T_MM_MEDI:
				sb.append( ML_T_G + ML_T_M);
				break;
			case ML_T_ML_MEDI:
				sb.append( ML_T_G + ML_L);
				break;

			case ML_T_T_ISOL:
			case ML_T_T_INIT:
			case ML_T_T_MEDI:
			case ML_T_T_FINA:
				sb.append( ML_T_T );
				break;

			case ML_T_D_ISOL:
			case ML_T_D_INIT:
			case ML_T_D_MEDI:
			case ML_T_D_FINA:
				sb.append( ML_T_D );
				break;

			case ML_T_CH_ISOL:
			case ML_T_CH_INIT:
			case ML_T_CH_MEDI:
			case ML_T_CH_FINA:
				sb.append( ML_T_CH );
				break;

			case ML_T_J_ISOL:
			case ML_T_J_INIT:
			case ML_T_J_MEDI:
			case ML_T_J_FINA:
				sb.append( ML_T_J );
				break;

			case ML_T_TS_ISOL:
			case ML_T_TS_INIT:
			case ML_T_TS_MEDI:
			case ML_T_TS_FINA:
				sb.append( ML_T_TS );
				break;

			case ML_T_Y_ISOL:
			case ML_T_Y_INIT:
			case ML_T_Y_MEDI:
			case ML_T_Y_FINA:
				sb.append( ML_T_Y );
				break;

			case ML_T_W_ISOL:
			case ML_T_W_INIT:
			case ML_T_W_MEDI:
			case ML_T_W_FINA:
				sb.append( ML_T_W );
				break;

			case ML_T_K_ISOL:
			case ML_T_K_INIT:
			case ML_T_K_MEDI:
			case ML_T_K_FINA:
				sb.append( ML_T_K );
				break;
			case ML_T_KA_ISOL:
			case ML_T_KA_INIT:
			case ML_T_KA_MEDI:
			case ML_T_KA_FINA:
				sb.append( ML_T_W + ML_A );
				break;
			case ML_T_KO_ISOL:
			case ML_T_KO_INIT:
			case ML_T_KO_MEDI:
			case ML_T_KO_FINA:
				sb.append( ML_T_W + ML_T_O );
				break;
			case ML_T_KU_ISOL:
			case ML_T_KU_INIT:
			case ML_T_KU_MEDI:
			case ML_T_KU_FINA:
				sb.append( ML_T_W + ML_T_U );
				break;

			case ML_T_GH_ISOL:
			case ML_T_GH_INIT:
			case ML_T_GH_MEDI:
			case ML_T_GH_FINA:
				sb.append( ML_T_GH );
				break;
			case ML_T_GHA_ISOL:
			case ML_T_GHA_INIT:
			case ML_T_GHA_MEDI:
			case ML_T_GHA_FINA:
				sb.append( ML_T_GH + ML_A );
				break;
			case ML_T_GHO_ISOL:
			case ML_T_GHO_INIT:
			case ML_T_GHO_MEDI:
			case ML_T_GHO_FINA:
				sb.append( ML_T_GH + ML_T_O );
				break;
			case ML_T_GHU_ISOL:
			case ML_T_GHU_INIT:
			case ML_T_GHU_MEDI:
			case ML_T_GHU_FINA:
				sb.append( ML_T_GH + ML_T_U );
				break;

			case ML_T_HH_ISOL:
			case ML_T_HH_INIT:
			case ML_T_HH_MEDI:
			case ML_T_HH_FINA:
				sb.append( ML_T_HH );
				break;

			case ML_T_JI_ISOL:
			case ML_T_JI_INIT:
			case ML_T_JI_MEDI:
			case ML_T_JI_FINA:
				sb.append( ML_T_JI );
				break;

			case ML_T_NIA_ISOL:
			case ML_T_NIA_INIT:
			case ML_T_NIA_MEDI:
			case ML_T_NIA_FINA:
				sb.append( ML_T_NIA );
				break;

			case ML_T_DZ_ISOL:
			case ML_T_DZ_INIT:
			case ML_T_DZ_MEDI:
			case ML_T_DZ_FINA:
				sb.append( ML_T_DZ );
				break;

			case ML_S_E_ISOL:
			case ML_S_E_INIT:
			case ML_S_E_MEDI:
			case ML_S_E_MEDI1:
			case ML_S_E_FINA:
			case ML_S_E_FINA1:
			case ML_S_E_FINA2:
			case ML_S_E_FINA3:
				sb.append( ML_S_E );
				break;

			case ML_S_I_ISOL:
			case ML_S_I_INIT:
			case ML_S_I_MEDI:
			case ML_S_I_MEDI1:
			case ML_S_I_MEDI2:
			case ML_S_I_FINA:
			case ML_S_I_FINA1:
			case ML_S_I_FINA2:
			case ML_S_I_FINA3:
				sb.append( ML_S_I );
				break;

			case ML_S_IY_ISOL:
			case ML_S_IY_INIT:
			case ML_S_IY_MEDI:
			case ML_S_IY_FINA:
				sb.append( ML_S_IY );
				break;

			case ML_S_UE_ISOL:
			case ML_S_UE_INIT:
			case ML_S_UE_MEDI:
			case ML_S_UE_MEDI1:
			case ML_S_UE_MEDI2:
			case ML_S_UE_FINA:
			case ML_S_UE_FINA1:
			case ML_S_UE_FINA2:
			case ML_S_UE_FINA3:
				sb.append( ML_S_UE );
				break;

			case ML_S_U_ISOL:
			case ML_S_U_INIT:
			case ML_S_U_MEDI:
			case ML_S_U_FINA:
				sb.append( ML_S_U );
				break;

			case ML_S_NG_ISOL:
			case ML_S_NG_INIT:
			case ML_S_NG_MEDI:
			case ML_S_NG_FINA:
				sb.append( ML_S_NG );
				break;
			case ML_S_NGN_MEDI:
				sb.append( ML_S_NG + ML_N );
				break;
			case ML_S_NGM_MEDI:
				sb.append( ML_S_NG + ML_M );
				break;
			case ML_S_NGL_MEDI:
				sb.append( ML_S_NG + ML_L );
				break;
			case ML_S_NGK_MEDI:
			case ML_S_NGK_MEDI1:
				sb.append( ML_S_NG + ML_S_K );
				break;
			case ML_S_NGG_MEDI:
				sb.append( ML_S_NG + ML_S_G );
				break;
			case ML_S_NGH_MEDI:
				sb.append( ML_S_NG + ML_S_H );
				break;

			case ML_S_K_ISOL:
			case ML_S_K_INIT:
			case ML_S_K_MEDI:
			case ML_S_K_MEDI1:
			case ML_S_K_FINA:
				sb.append( ML_S_K );
				break;
			case ML_S_KE_ISOL:
			case ML_S_KE_INIT:
			case ML_S_KE_MEDI:
			case ML_S_KE_FINA:
				sb.append( ML_S_K + ML_S_E );
				break;
			case ML_S_KI_ISOL:
			case ML_S_KI_INIT:
			case ML_S_KI_MEDI:
			case ML_S_KI_FINA:
				sb.append( ML_S_K + ML_S_I );
				break;
			case ML_S_KUE_ISOL:
			case ML_S_KUE_INIT:
			case ML_S_KUE_MEDI:
			case ML_S_KUE_FINA:
				sb.append( ML_S_K + ML_S_UE );
				break;

			case ML_S_G_ISOL:
			case ML_S_G_ISOL1:
			case ML_S_G_INIT:
			case ML_S_G_INIT1:
			case ML_S_G_MEDI:
			case ML_S_G_FINA:
				sb.append( ML_S_G );
				break;
			case ML_S_GE_ISOL:
			case ML_S_GE_INIT:
			case ML_S_GE_MEDI:
			case ML_S_GE_FINA:
				sb.append( ML_S_G + ML_S_E );
				break;
			case ML_S_GI_ISOL:
			case ML_S_GI_INIT:
			case ML_S_GI_MEDI:
			case ML_S_GI_FINA:
				sb.append( ML_S_G + ML_S_I );
				break;
			case ML_S_GUE_ISOL:
			case ML_S_GUE_INIT:
			case ML_S_GUE_MEDI:
			case ML_S_GUE_FINA:
				sb.append( ML_S_G + ML_S_UE );
				break;

			case ML_S_H_ISOL:
			case ML_S_H_ISOL1:
			case ML_S_H_INIT:
			case ML_S_H_INIT1:
			case ML_S_H_MEDI:
			case ML_S_H_MEDI1:
			case ML_S_H_FINA:
				sb.append( ML_S_H );
				break;
			case ML_S_HE_ISOL:
			case ML_S_HE_INIT:
			case ML_S_HE_MEDI:
			case ML_S_HE_FINA:
				sb.append( ML_S_G + ML_S_E );
				break;
			case ML_S_HI_ISOL:
			case ML_S_HI_INIT:
			case ML_S_HI_MEDI:
			case ML_S_HI_FINA:
				sb.append( ML_S_H + ML_S_I );
				break;
			case ML_S_HUE_ISOL:
			case ML_S_HUE_INIT:
			case ML_S_HUE_MEDI:
			case ML_S_HUE_FINA:
				sb.append( ML_S_H + ML_S_UE );
				break;

			case ML_S_BE_ISOL:
			case ML_S_BE_INIT:
			case ML_S_BE_MEDI:
			case ML_S_BE_FINA:
				sb.append( ML_B + ML_S_E );
				break;
			case ML_S_BI_ISOL:
			case ML_S_BI_INIT:
			case ML_S_BI_MEDI:
			case ML_S_BI_FINA:
				sb.append( ML_B + ML_S_I );
				break;
			case ML_S_BUE_ISOL:
			case ML_S_BUE_INIT:
			case ML_S_BUE_MEDI:
			case ML_S_BUE_FINA:
				sb.append( ML_B + ML_S_UE );
				break;
			case ML_S_BU_ISOL:
			case ML_S_BU_INIT:
			case ML_S_BU_MEDI:
			case ML_S_BU_FINA:
				sb.append( ML_B + ML_S_UE );
				break;

			case ML_S_P_ISOL:
			case ML_S_P_INIT:
			case ML_S_P_MEDI:
			case ML_S_P_FINA:
				sb.append( ML_S_P );
				break;
			case ML_S_PA_ISOL:
			case ML_S_PA_INIT:
			case ML_S_PA_MEDI:
			case ML_S_PA_FINA:
				sb.append( ML_P + ML_A );
				break;
			case ML_S_PE_ISOL:
			case ML_S_PE_INIT:
			case ML_S_PE_MEDI:
			case ML_S_PE_FINA:
				sb.append( ML_P + ML_S_E );
				break;
			case ML_S_PI_ISOL:
			case ML_S_PI_INIT:
			case ML_S_PI_MEDI:
			case ML_S_PI_FINA:
				sb.append( ML_P + ML_S_I );
				break;
			case ML_S_PO_ISOL:
			case ML_S_PO_INIT:
			case ML_S_PO_MEDI:
			case ML_S_PO_FINA:
				sb.append( ML_P + ML_S_UE );
				break;
			case ML_S_PUE_ISOL:
			case ML_S_PUE_INIT:
			case ML_S_PUE_MEDI:
			case ML_S_PUE_FINA:
				sb.append( ML_P + ML_S_UE );
				break;
			case ML_S_PU_ISOL:
			case ML_S_PU_INIT:
			case ML_S_PU_MEDI:
			case ML_S_PU_FINA:
				sb.append( ML_P + ML_S_UE );
				break;

			case ML_S_SH_ISOL:
			case ML_S_SH_INIT:
			case ML_S_SH_MEDI:
			case ML_S_SH_FINA:
				sb.append( ML_S_SH );
				break;

			case ML_S_T_ISOL:
			case ML_S_T_ISOL1:
			case ML_S_T_INIT:
			case ML_S_T_INIT1:
			case ML_S_T_MEDI:
			case ML_S_T_MEDI1:
			case ML_S_T_MEDI2:
			case ML_S_T_FINA:
				sb.append( ML_S_T );
				break;

			case ML_S_D_ISOL:
			case ML_S_D_INIT:
			case ML_S_D_INIT1:
			case ML_S_D_MEDI:
			case ML_S_D_MEDI1:
			case ML_S_D_FINA:
				sb.append( ML_S_D );
				break;

			case ML_S_J_ISOL:
			case ML_S_J_INIT:
			case ML_S_J_MEDI:
			case ML_S_J_FINA:
				sb.append( ML_S_J );
				break;

			case ML_S_F_ISOL:
			case ML_S_F_INIT:
			case ML_S_F_MEDI:
			case ML_S_F_FINA:
				sb.append( ML_S_F );
				break;

			case ML_S_GH_ISOL:
			case ML_S_GH_INIT:
			case ML_S_GH_MEDI:
			case ML_S_GH_FINA:
				sb.append( ML_S_GH );
				break;
			case ML_S_GHA_ISOL:
			case ML_S_GHA_INIT:
			case ML_S_GHA_MEDI:
			case ML_S_GHA_FINA:
				sb.append( ML_S_GH + ML_A );
				break;
			case ML_S_GHO_ISOL:
			case ML_S_GHO_INIT:
			case ML_S_GHO_MEDI:
			case ML_S_GHO_FINA:
				sb.append( ML_S_GH + ML_O );
				break;
				// ML_S_GHE_ISOL = '\uECB6';
				// ML_S_GHE_INIT = '\uECB7';
				// ML_S_GHE_MEDI = '\uECB8';
				// ML_S_GHE_FINA = '\uECB9';
				// ML_S_GHI_ISOL = '\uECBA';
				// ML_S_GHI_INIT = '\uECBB';
				// ML_S_GHI_MEDI = '\uECBC';
				// ML_S_GHI_FINA = '\uECBD';
				// ML_S_GHUE_ISOL = '\uECBE';
				// ML_S_GHUE_INIT = '\uECBF';
				// ML_S_GHUE_MEDI = '\uECC0';
				// ML_S_GHUE_FINA = '\uECC1';

			case ML_S_HH_ISOL:
			case ML_S_HH_INIT:
			case ML_S_HH_MEDI:
			case ML_S_HH_FINA:
				sb.append( ML_S_HH );
				break;
			case ML_S_HHA_ISOL:
			case ML_S_HHA_INIT:
			case ML_S_HHA_MEDI:
			case ML_S_HHA_FINA:
				sb.append( ML_S_HH + ML_A );
				break;
			case ML_S_HHO_ISOL:
			case ML_S_HHO_INIT:
			case ML_S_HHO_MEDI:
			case ML_S_HHO_FINA:
				sb.append( ML_S_GH + ML_O );
				break;

				// ML_S_HHE_ISOL = '\uECCE';
				// ML_S_HHE_INIT = '\uECCF';
				// ML_S_HHE_MEDI = '\uECD0';
				// ML_S_HHE_FINA = '\uECD1';
				// ML_S_HHI_ISOL = '\uECD2';
				// ML_S_HHI_INIT = '\uECD3';
				// ML_S_HHI_MEDI = '\uECD4';
				// ML_S_HHI_FINA = '\uECD5';
				// ML_S_HHUE_ISOL = '\uECD6';
				// ML_S_HHUE_INIT = '\uECD7';
				// ML_S_HHUE_MEDI = '\uECD8';
				// ML_S_HHUE_FINA = '\uECD9';

			case ML_S_TS_ISOL:
			case ML_S_TS_INIT:
			case ML_S_TS_MEDI:
			case ML_S_TS_FINA:
				sb.append( ML_S_TS );
				break;

			case ML_S_Z_ISOL:
			case ML_S_Z_INIT:
			case ML_S_Z_INIT1:
			case ML_S_Z_MEDI:
			case ML_S_Z_MEDI1:
			case ML_S_Z_FINA:
				sb.append( ML_S_Z );
				break;

			case ML_S_RH_ISOL:
			case ML_S_RH_INIT:
			case ML_S_RH_MEDI:
			case ML_S_RH_FINA:
				sb.append( ML_S_RH );
				break;

			case ML_S_CH_ISOL:
			case ML_S_CH_INIT:
			case ML_S_CH_MEDI:
			case ML_S_CH_FINA:
				sb.append( ML_S_CH );
				break;

			case ML_S_ZH_ISOL:
			case ML_S_ZH_INIT:
			case ML_S_ZH_MEDI:
			case ML_S_ZH_FINA:
				sb.append( ML_S_ZH );
				break;

			case ML_M_I_ISOL:
			case ML_M_I_INIT:
			case ML_M_I_MEDI:
			case ML_M_I_MEDI1:
			case ML_M_I_MEDI2:
			case ML_M_I_MEDI3:
			case ML_M_I_FINA:
			case ML_M_I_FINA1:
			case ML_M_I_FINA2:
			case ML_M_I_FINA3:
			case ML_M_I_FINA4:
				sb.append( ML_M_I );
				break;

			case ML_M_K_ISOL:
			case ML_M_K_INIT:
			case ML_M_K_MEDI:
			case ML_M_K_MEDI1:
			case ML_M_K_MEDI2:
			case ML_M_K_MEDI3:
			case ML_M_K_FINA:
			case ML_M_K_FINA1:
			case ML_M_K_FINA2:
				sb.append( ML_M_K );
				break;
			case ML_M_KE_ISOL:
			case ML_M_KE_INIT:
			case ML_M_KE_MEDI:
			case ML_M_KE_FINA:
				sb.append( ML_M_K + ML_S_E );
				break;
			case ML_M_KI_ISOL:
			case ML_M_KI_INIT:
			case ML_M_KI_MEDI:
			case ML_M_KI_FINA:
				sb.append( ML_M_K + ML_M_I );
				break;
			case ML_M_KUE_ISOL:
			case ML_M_KUE_INIT:
			case ML_M_KUE_MEDI:
			case ML_M_KUE_FINA:
				sb.append( ML_M_K + ML_S_UE );
				break;

			case ML_M_GI_ISOL:
			case ML_M_GI_INIT:
			case ML_M_GI_MEDI:
			case ML_M_GI_FINA:
				sb.append( ML_S_G + ML_M_I );
				break;

			case ML_M_BI_ISOL:
			case ML_M_BI_INIT:
			case ML_M_BI_MEDI:
			case ML_M_BI_FINA:
				sb.append( ML_B + ML_M_I );
				break;

			case ML_M_PI_ISOL:
			case ML_M_PI_INIT:
			case ML_M_PI_MEDI:
			case ML_M_PI_FINA:
				sb.append( ML_P + ML_M_I );
				break;

			case ML_M_R_ISOL:
			case ML_M_R_INIT:
			case ML_M_R_MEDI:
			case ML_M_R_FINA:
				sb.append( ML_M_R );
				break;

			case ML_M_F_ISOL:
			case ML_M_F_INIT:
			case ML_M_F_MEDI:
			case ML_M_F_MEDI1:
			case ML_M_F_FINA:
				sb.append( ML_M_F );
				break;

			case ML_M_ZH_ISOL:
			case ML_M_ZH_INIT:
			case ML_M_ZH_MEDI:
			case ML_M_ZH_FINA:
				sb.append( ML_M_ZH );
				break;

				// ML_ALI_GALI_ANUSVARA_ONE = '\u1880';
				// ML_ALI_GALI_VISARGA_ONE = '\u1881';
				// ML_ALI_GALI_DAMARU = '\u1882';
				// ML_ALI_GALI_UBADAMA = '\u1883';
				// ML_ALI_GALI_INVERTED_UBADAMA = '\u1884';
				// ML_ALI_GALI_BALUDA = '\u1885';
				// ML_ALI_GALI_THREE_BALUDA = '\u1886';
				// ML_ALI_GALI_A = '\u1887';
				// ML_ALI_GALI_I = '\u1888';
				// ML_ALI_GALI_KA = '\u1889';
				// ML_ALI_GALI_NGA = '\u188A';
				// ML_ALI_GALI_CA = '\u188B';
				// ML_ALI_GALI_TTA = '\u188C';
				// ML_ALI_GALI_TTHA = '\u188D';
				// ML_ALI_GALI_DDA = '\u188E';
				// ML_ALI_GALI_NNA = '\u188F';
				// ML_ALI_GALI_TA = '\u1890';
				// ML_ALI_GALI_DA = '\u1891';
				// ML_ALI_GALI_PA = '\u1892';
				// ML_ALI_GALI_PHA = '\u1893';
				// ML_ALI_GALI_SSA = '\u1894';
				// ML_ALI_GALI_ZHA = '\u1895';
				// ML_ALI_GALI_ZA = '\u1896';
				// ML_ALI_GALI_AH = '\u1897';
				// ML_T_ALI_GALI_TA = '\u1898';
				// ML_T_ALI_GALI_ZHA = '\u1899';
				// ML_M_ALI_GALI_GHA = '\u189A';
				// ML_M_ALI_GALI_NGA = '\u189B';
				// ML_M_ALI_GALI_CA = '\u189C';
				// ML_M_ALI_GALI_JHA = '\u189D';
				// ML_M_ALI_GALI_TTA = '\u189E';
				// ML_M_ALI_GALI_DDHA = '\u189F';
				// ML_M_ALI_GALI_TA = '\u18A0';
				// ML_M_ALI_GALI_DHA = '\u18A1';
				// ML_M_ALI_GALI_SSA = '\u18A2';
				// ML_M_ALI_GALI_CYA = '\u18A3';
				// ML_M_ALI_GALI_ZHA = '\u18A4';
				// ML_M_ALI_GALI_ZA = '\u18A5';
				// ML_ALI_GALI_HALF_U = '\u18A6';
				// ML_ALI_GALI_HALF_YA = '\u18A7';
				// ML_M_ALI_GALI_BHA = '\u18A8';
				// ML_ALI_GALI_DAGALGA = '\u18A9';
				// ML_M_ALI_GALI_LHA = '\u18AA';

			default :
				sb.append(ch);
				break;
			}
		}
		
		return sb.toString();
	}

	public static boolean isMonglianCharacter( char character ) {
		boolean result = false;

		if ( ( character >= '\u180A' ) && ( character <= '\u180E' ) ) {
			result = true;
		} else if ( ( character >= '\u1820' ) && ( character <= '\u1842' ) ) {
			result = true;
		} else if ( character == '\u202F' || character == '\u200D' ) {
			result = true;
		}

		return result;
	}

	public static boolean isBreakPointCharacter( char character ) {
		boolean result = false;

		if ( character == '\u1801' ||
				character == '\u1802' ||
				character == '\u1803' ||
				character == '︖' ||
				character == '︕' ||
				character == '︔'  ) {
			result = true;
		}

		return result;
	}

	public static boolean isControlCharacter( char character ) {
		boolean result = false;

		if ( character == '\u180B' ||
				character == '\u180C' ||
				character == '\u180D' ||
				character == '\u180E' ||
				character == PLACE_HOLDER  ) {
			result = true;
		}

		return result;
	}

    public static String convertEnglishToMongolian(String text) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < text.length(); i++) {
			String ch = text.substring(i, i + 1);
			if (latinMongolianMap.containsKey( ch )) {
				sb.append(latinMongolianMap.get(ch));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static String convertMongolianToEnglish(String text) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < text.length(); i++) {
			String ch = text.substring(i, i + 1);
			if (mongolianLatinMap.containsKey( ch )) {
				sb.append(mongolianLatinMap.get(ch));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
