/*  Calculadora de Anestesia Pediatrica
    Vista (REX)🦖 Dinamica de Calculos
    Autor: Johan Guillén
*/

package savealife.fivestar.app.com.savealife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class rex extends AppCompatActivity {

    private LinearLayout OpSP,Neo_Calc,MetBasalCalc,ReACalc,RHCalc,TranfuL;
    private LinearLayout MelmanT,ArmitageT,TakaT,FarmacosT, REPBT,REPST,REPCT,REPPT;
    private LinearLayout SuperT,SondaT,DistanciaT,BolT,PreHiperT,VOT,VIT,VNT,PALS,Adreno2,Adreno3;

    private TextView m10,M10,DI,DNeonato,DLactante,DM2anos,BolsaV;
    private TextView VSC_Pre, VSC_Term, VSC_Lact, VSC_M6, VSC_Hombre,VSC_Mujer,VSC_T;
    private TextView HTO_Pre, HTO_Term, HTO_Lact, HTO_M6, HTO_Hombre,HTO_Mujer,HTO_T;
    private TextView Neo_Prem,Neo_PreM,Neo_Term,Neo_TerM;
    private TextView IMCm101200,IMCM1200,IMCm101500,IMCM101500,IMCm101800,IMCM101800;
    private TextView ml120,ml150,Berrym3,BerryM3,TaR,hora1,hora2,hora3,mlkg5,mlkg10,mlkg20;
    private TextView Dosis5,Dosis10,Dosis15,Dosis20,DosisP5,DosisP10,DosisP15,Dosis5CP,Dosis10CP;
    private TextView Dosis5Crio,Dosis10Crio,TransfundirH,T2,T4,T10,T12;
    private TextView T2M02,T2M025,T2M03,T2M034,T2M04T4,T4M02,T4M025,T4M03,T4M034,T4M04T4,T10M02,T10M025,T10M03,T10M034,T10M04T4,T12M02,T12M025,T12M03,T12M034,T12M04T4;
    private TextView Toracico125,Lumbar1,Sacro05,Toracico02,Toracico025,Toracico03,Toracico035,Toracico04;
    private TextView Lumbar02,Lumbar025,Lumbar03,Lumbar035,Lumbar04,Sacro02,Sacro025,Sacro03,Sacro035,Sacro04;
    private TextView TDermatomas, Taka02,Taka025,Taka03,Taka035,Taka4,Toxico5mg,Toxico7mg,Bloqueo5,Bloqueo515,Bloqueo15,BloqueoA;
    private TextView Mm,MM,Fm,FM,Km,KM,Cm,CM,Dinam,DinaM,Donam,DonaM,Tm,TM,D50,D100,YID,I,SD,SI,MeqRb,hr8,hr16;
    private TextView MeqRS,hr8Rs,hr16RS,Cal30,Glu30,Cal50,Glu50,Cal100,Glu100,Deficit,P025,P05,Hiper3,Hiper5,Tema, proble;
    private TextView HSm10, HS1020,HSM20, ALb05, Alb0520, Alb0525, Alb1,Alb120, Alb125, MidaVO, MidaVI, MidaVN, KeVO, KeVI, KeVN;
    private TextView CloniVO, DexVN,PALS11,PALS12,PALS13,PALS21,PALS22,PALS23,PALS31,PALS32,PALS33,PALSTT,Adreno1T,Adreno2T,Adreno3T;

    private EditText Hto_text,Dias_Neonato,MB_text,HA_text;
    private EditText VSCH , HtoIH,HtoPGH,HtoRH,Dermatomas,DD1,EB,Nar,Nai,Por,Poi,Hipermld;

    private TableLayout ConcenET,PlamaConT,ConcenPT,CrioT,ToxicoT,BloqueoST,AdyuvantesT,PrepDT,DCVCT;

    private TableRow Level2, Level3;

    private float Peso,Talla, Hto,Edad,MB,HA, VSCHN , HtoIHN,HtoPGHN,HtoRHN, DermatomasN,DD10F,EBF;
    private float NarN,NaiN,PorN,PoiN,HipermldN,minHS1,minHs2, Alb20, Alb25;

    private int HTO_op,PALS_op;

    private boolean VSC_Porcent;

    private int[] VSE= new int[6];
    private int[] Htodiff= new int[3];

    private float[] Dif_hto= new float[3];
    private float[] Prom_hto= new float[3];

    private ImageButton back;


    private int code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rex);

        //VSE
        VSE[0]=100;
        VSE[1]=90;
        VSE[2]=80;
        VSE[3]=75;
        VSE[4]=70;
        VSE[5]=65;

        //Htodiff
        Htodiff[0]=25;
        Htodiff[1]=30;
        Htodiff[2]=35;

        //bools
        VSC_Porcent=false;

        //floats
        Peso=0;
        Talla=0;
        Edad=0;
        Hto=0;
        VSCHN=0;
        HtoIHN=0;
        HtoPGHN=0;
        HtoRHN=0;
        DermatomasN=0;
        DD10F=0;
        EBF=0;
        NarN=0;
        NaiN=0;
        PoiN=0;
        PorN=0;
        HipermldN=0;
        minHS1=0;
        minHs2=0;
        Alb20=0;
        Alb25=0;

        //ints
        HTO_op=0;
        PALS_op=0;


        code =getIntent().getIntExtra("code",0);
        Peso= getIntent().getFloatExtra("Peso",0);
        Edad= getIntent().getFloatExtra("Edad",0);
        Talla= getIntent().getFloatExtra("Talla",0);
        PALS_op=getIntent().getIntExtra("opPALS",0);

        HTO_Pre=(TextView) findViewById(R.id.PreterminoHto);
        HTO_Term=(TextView) findViewById(R.id.terminoHto);
        HTO_Lact=(TextView) findViewById(R.id.LactanteHto);
        HTO_M6=(TextView) findViewById(R.id.M6anosHto);
        HTO_Hombre=(TextView) findViewById(R.id.HombreHto);
        HTO_Mujer=(TextView) findViewById(R.id.MujerHto);
        m10= (TextView) findViewById(R.id.m10);
        M10= (TextView) findViewById(R.id.M10);
        DI= (TextView) findViewById(R.id.DI);
        DNeonato= (TextView) findViewById(R.id.Neonato);
        DLactante=(TextView) findViewById(R.id.Lactante);
        DM2anos=(TextView) findViewById(R.id.anos2);
        BolsaV=(TextView) findViewById(R.id.Bolsa);
        VSC_Pre=(TextView) findViewById(R.id.PreterminoVSC);
        VSC_Term=(TextView) findViewById(R.id.terminoVSC);
        VSC_Lact=(TextView) findViewById(R.id.LactanteVSC);
        VSC_M6=(TextView) findViewById(R.id.M6anosVSC);
        VSC_Hombre=(TextView) findViewById(R.id.HombreVSC);
        VSC_Mujer=(TextView) findViewById(R.id.MujerVSC);
        VSC_T=(TextView) findViewById(R.id.VscT);
        HTO_T=(TextView) findViewById(R.id.HtoTPorcent);
        Neo_Prem=(TextView) findViewById(R.id.NeonatoPrem);
        Neo_PreM=(TextView) findViewById(R.id.NeonatoPreM);
        Neo_Term=(TextView) findViewById(R.id.NeonatoTerm);
        Neo_TerM=(TextView) findViewById(R.id.NeonatoTerM);
        IMCm101200=(TextView) findViewById(R.id.IMCm101200);
        IMCM1200=(TextView) findViewById(R.id.IMCM101200);
        IMCm101500=(TextView) findViewById(R.id.IMCm101500);
        IMCM101500=(TextView) findViewById(R.id.IMCM101500);
        IMCm101800=(TextView) findViewById(R.id.IMCm101800);
        IMCM101800=(TextView) findViewById(R.id.IMCM101800);
        ml120=(TextView) findViewById(R.id.ml120);
        ml150=(TextView) findViewById(R.id.ml150);
        Berrym3=(TextView) findViewById(R.id.Berrym3);
        BerryM3=(TextView) findViewById(R.id.BerryM3);
        TaR=(TextView) findViewById(R.id.TaR);
        hora1=(TextView) findViewById(R.id.hora1);
        hora2=(TextView) findViewById(R.id.hora2);
        hora3=(TextView) findViewById(R.id.hora3);
        mlkg5=(TextView) findViewById(R.id.mlkg5);
        mlkg10=(TextView) findViewById(R.id.mlkg10);
        mlkg20=(TextView) findViewById(R.id.mlkg20);
        Dosis5=(TextView) findViewById(R.id.Dosis5);
        Dosis10=(TextView) findViewById(R.id.Dosis10);
        Dosis15=(TextView) findViewById(R.id.Dosis15);
        Dosis20=(TextView) findViewById(R.id.Dosis20);
        DosisP5=(TextView) findViewById(R.id.DosisP5);
        DosisP10=(TextView) findViewById(R.id.Dosis10P);
        DosisP15=(TextView) findViewById(R.id.Dosis15P);
        Dosis5CP=(TextView) findViewById(R.id.Dosis5CP);
        Dosis10CP=(TextView) findViewById(R.id.Dosis10CP);
        Dosis5Crio=(TextView) findViewById(R.id.Dosis5Crio);
        Dosis10Crio=(TextView) findViewById(R.id.Dosis10Crio);
        TransfundirH=(TextView) findViewById(R.id.TransfundirH);
        T2=(TextView) findViewById(R.id.T2M);
        T4=(TextView) findViewById(R.id.T4M);
        T10=(TextView) findViewById(R.id.T10M);
        T12=(TextView) findViewById(R.id.T12M);
        T2M02=(TextView) findViewById(R.id.T2M02);
        T2M025=(TextView) findViewById(R.id.T2M025);
        T2M03=(TextView) findViewById(R.id.T2M03);
        T2M034=(TextView) findViewById(R.id.T2M035);
        T2M04T4=(TextView) findViewById(R.id.T2M04);
        T4M02=(TextView) findViewById(R.id.T4M02);
        T4M025=(TextView) findViewById(R.id.T4M025);
        T4M03=(TextView) findViewById(R.id.T4M03);
        T4M034=(TextView) findViewById(R.id.T4M035);
        T4M04T4=(TextView) findViewById(R.id.T4M04);
        T10M02=(TextView) findViewById(R.id.T10M02);
        T10M025=(TextView) findViewById(R.id.T10M025);
        T10M03=(TextView) findViewById(R.id.T10M03);
        T10M034=(TextView) findViewById(R.id.T10M035);
        T10M04T4=(TextView) findViewById(R.id.T10M04);
        T12M02=(TextView) findViewById(R.id.T12M02);
        T12M025=(TextView) findViewById(R.id.T12M025);
        T12M03=(TextView) findViewById(R.id.T12M03);
        T12M034=(TextView) findViewById(R.id.T12M035);
        T12M04T4=(TextView) findViewById(R.id.T12M04);
        Toracico125=(TextView) findViewById(R.id.Toracico125);
        Lumbar1=(TextView) findViewById(R.id.Lumbar1);
        Sacro05=(TextView) findViewById(R.id.Sacro05);
        Toracico02=(TextView) findViewById(R.id.Toracico02);
        Toracico025=(TextView) findViewById(R.id.Toracico025);
        Toracico03=(TextView) findViewById(R.id.Toracico03);
        Toracico035=(TextView) findViewById(R.id.Toracico35);
        Toracico04=(TextView) findViewById(R.id.Toracico04);
        Lumbar02=(TextView) findViewById(R.id.Lumbar02);
        Lumbar025=(TextView) findViewById(R.id.Lumbar025);
        Lumbar03=(TextView) findViewById(R.id.Lumbar03);
        Lumbar035=(TextView) findViewById(R.id.Lumbar035);
        Lumbar04=(TextView) findViewById(R.id.Lumbar04);
        Sacro02=(TextView) findViewById(R.id.Sacro02);
        Sacro025=(TextView) findViewById(R.id.Sacro025);
        Sacro03=(TextView) findViewById(R.id.Sacro03);
        Sacro035=(TextView) findViewById(R.id.Sacro035);
        Sacro04=(TextView) findViewById(R.id.Sacro04);
        TDermatomas=(TextView) findViewById(R.id.TDermatom);
        Taka02=(TextView) findViewById(R.id.Taka02);
        Taka025=(TextView) findViewById(R.id.Taka025);
        Taka03=(TextView) findViewById(R.id.Taka03);
        Taka035=(TextView) findViewById(R.id.Taka35);
        Taka4=(TextView) findViewById(R.id.Taka04);
        Toxico5mg=(TextView) findViewById(R.id.Toxico5mg);
        Toxico7mg=(TextView) findViewById(R.id.Toxico7mg);
        Bloqueo5=(TextView) findViewById(R.id.Bloqueom5mg);
        Bloqueo515=(TextView) findViewById(R.id.Bloqueom515mg);
        Bloqueo15=(TextView) findViewById(R.id.BloqueomM15mg);
        BloqueoA=(TextView) findViewById(R.id.BloqueoAdultomg);
        Mm=(TextView) findViewById(R.id.Morfinam);
        MM=(TextView) findViewById(R.id.MorfinaM);
        Fm=(TextView) findViewById(R.id.Fentanilm);
        FM=(TextView) findViewById(R.id.FentanilM);
        Km=(TextView) findViewById(R.id.Ketaminam);
        KM=(TextView) findViewById(R.id.KetaminaM);
        Cm=(TextView) findViewById(R.id.Clonidinam);
        CM=(TextView) findViewById(R.id.ClonidinaM);
        Dinam=(TextView) findViewById(R.id.Dexmedetomidinam);
        DinaM=(TextView) findViewById(R.id.DexmedetomidinaM);
        Donam=(TextView) findViewById(R.id.Dexametasonam);
        DonaM=(TextView) findViewById(R.id.DexametasonaM);
        Tm=(TextView) findViewById(R.id.Tramadolm);
        TM=(TextView) findViewById(R.id.TramadolM);
        D50=(TextView) findViewById(R.id.D50ml);
        D100=(TextView) findViewById(R.id.D100ml);
        YID=(TextView) findViewById(R.id.YID);
        I=(TextView) findViewById(R.id.I);
        SD=(TextView) findViewById(R.id.SD);
        SI=(TextView) findViewById(R.id.SI);
        MeqRb=(TextView) findViewById(R.id.MeqRB);
        hr8=(TextView) findViewById(R.id.hr8RB);
        hr16=(TextView) findViewById(R.id.hr16RB);
        MeqRS=(TextView) findViewById(R.id.MeqRS);
        hr8Rs=(TextView) findViewById(R.id.hr8RS);
        hr16RS=(TextView) findViewById(R.id.hr16RS);
        Cal30=(TextView) findViewById(R.id.Cal30);
        Glu30=(TextView) findViewById(R.id.Glu30);
        Cal50=(TextView) findViewById(R.id.Cal50);
        Glu50=(TextView) findViewById(R.id.Glu50);
        Cal100=(TextView) findViewById(R.id.Cal100);
        Glu100=(TextView) findViewById(R.id.Glu100);
        Deficit=(TextView) findViewById(R.id.Deficit);
        P025=(TextView) findViewById(R.id.P025);
        P05=(TextView) findViewById(R.id.P05);
        Hiper3=(TextView) findViewById(R.id.Hiper3);
        Hiper5=(TextView) findViewById(R.id.Hiper5);
        HSm10=(TextView) findViewById(R.id.HSm10);
        HS1020=(TextView) findViewById(R.id.HS1020);
        HSM20=(TextView) findViewById(R.id.HSM20);
        ALb05=(TextView) findViewById(R.id.AlbD05);
        Alb1=(TextView) findViewById(R.id.AlbD1);
        Alb0520=(TextView) findViewById(R.id.AlbD0520);
        Alb0525=(TextView) findViewById(R.id.ALbD0525);
        Alb120=(TextView) findViewById(R.id.AlbD120);
        Alb125=(TextView) findViewById(R.id.ALb125);
        MidaVI=(TextView) findViewById(R.id.MidaVI);
        MidaVO=(TextView) findViewById(R.id.MidaVO);
        MidaVN=(TextView) findViewById(R.id.MidaVN);
        KeVI=(TextView) findViewById(R.id.KetaVI);
        KeVO=(TextView) findViewById(R.id.KetaVO);
        KeVN=(TextView) findViewById(R.id.KetaVN);
        CloniVO=(TextView) findViewById(R.id.CloniVO);
        DexVN=(TextView) findViewById(R.id.DexVN);
        PALS11=(TextView) findViewById(R.id.PALS11);
        PALS12=(TextView) findViewById(R.id.PALS12);
        PALS13=(TextView) findViewById(R.id.PALS13);
        PALS21=(TextView) findViewById(R.id.PALS21);
        PALS22=(TextView) findViewById(R.id.PALS22);
        PALS23=(TextView) findViewById(R.id.PALS23);
        PALS31=(TextView) findViewById(R.id.PALS31);
        PALS32=(TextView) findViewById(R.id.PALS32);
        PALS33=(TextView) findViewById(R.id.PALS33);
        PALSTT=(TextView) findViewById(R.id.PALSTT);
        Adreno1T=(TextView) findViewById(R.id.Adreno12);
        Adreno2T=(TextView) findViewById(R.id.Adreno22);
        Adreno3T=(TextView) findViewById(R.id.Adreno31);



        Hto_text=(EditText) findViewById(R.id.Hto);
        Dias_Neonato=(EditText) findViewById(R.id.DiaaNeonato2);
        MB_text=(EditText) findViewById(R.id.Mb);
        HA_text=(EditText) findViewById(R.id.HA);
        VSCH=(EditText) findViewById(R.id.VSCH);
        HtoIH=(EditText) findViewById(R.id.HtoIH);
        HtoPGH=(EditText) findViewById(R.id.HtoPGH);
        HtoRH=(EditText) findViewById(R.id.HtoRH);
        Dermatomas=(EditText) findViewById(R.id.Dermatomas);
        DD1= (EditText) findViewById(R.id.DD1ml);
        EB=(EditText) findViewById(R.id.EB);
        Nar=(EditText) findViewById(R.id.NAR);
        Nai=(EditText) findViewById(R.id.NAI);
        Por=(EditText) findViewById(R.id.PoR);
        Poi=(EditText) findViewById(R.id.PoI);
        Hipermld=(EditText) findViewById(R.id.Hipermld);


        OpSP=(LinearLayout) findViewById(R.id.opSP);
        Neo_Calc=(LinearLayout)findViewById(R.id.Neonato2Calc) ;
        MetBasalCalc=(LinearLayout)findViewById(R.id.MetBasalCalc) ;
        ReACalc=(LinearLayout)findViewById(R.id.RepAyunoCalc) ;
        RHCalc=(LinearLayout)findViewById(R.id.ReanimacionHCalc) ;
        TranfuL=(LinearLayout)findViewById(R.id.TransfuT) ;
        MelmanT=(LinearLayout) findViewById(R.id.MelmanT) ;
        ArmitageT=(LinearLayout) findViewById(R.id.ArmitageT) ;
        TakaT=(LinearLayout) findViewById(R.id.TakaT);
        FarmacosT=(LinearLayout) findViewById(R.id.FarmacosT);
        REPBT=(LinearLayout) findViewById(R.id.REPBT);
        REPST=(LinearLayout) findViewById(R.id.REPST) ;
        REPCT=(LinearLayout) findViewById(R.id.REPCT);
        REPPT=(LinearLayout) findViewById(R.id.REPPT);
        SuperT=(LinearLayout) findViewById(R.id.SuperT);
        SondaT=(LinearLayout) findViewById(R.id.SondaT);
        DistanciaT=(LinearLayout) findViewById(R.id.DistanciaT);
        BolT=(LinearLayout) findViewById(R.id.BolT);
        PreHiperT=(LinearLayout) findViewById(R.id.PrepHiperT) ;
        VOT=(LinearLayout) findViewById(R.id.VOL);
        VIT=(LinearLayout) findViewById(R.id.VIL);
        VNT=(LinearLayout) findViewById(R.id.VNL);
        PALS=(LinearLayout) findViewById(R.id.PALSDT);
        Adreno2=(LinearLayout) findViewById(R.id.Adrena2T);
        Adreno3=(LinearLayout) findViewById(R.id.Adrena3T);

        ConcenET=(TableLayout) findViewById(R.id.ConcenET) ;
        PlamaConT=(TableLayout) findViewById(R.id.PlamaConT) ;
        ConcenPT=(TableLayout) findViewById(R.id.ConcenPT) ;
        CrioT=(TableLayout) findViewById(R.id.CrioT) ;
        ToxicoT=(TableLayout) findViewById(R.id.ToxicoT);
        BloqueoST=(TableLayout) findViewById(R.id.BloqueoST);
        AdyuvantesT=(TableLayout) findViewById(R.id.AdyuvantesT);
        PrepDT=(TableLayout) findViewById(R.id.PrepDT);
        DCVCT=(TableLayout) findViewById(R.id.DCVCT);

        Level2=(TableRow) findViewById(R.id.L2PALS);
        Level3=(TableRow) findViewById(R.id.L3PALS);


        Tema=(TextView) findViewById(R.id.tema22);
        proble=(TextView) findViewById(R.id.proble);

        back=(ImageButton) findViewById(R.id.back);

        back.setBackground(null);

        Adreno2.setVisibility(View.GONE);
        Adreno3.setVisibility(View.GONE);

        //Inicializar
        CalculateALL();

        //TextWatchers
        //Cambios en el Texto
        Hipermld.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        HipermldN = Float.valueOf(charSequence.toString());
                    }catch (Exception e){

                    }

                }
                else{
                    HipermldN=0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Poi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        PoiN = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else{
                    PoiN=0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Por.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        PorN = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else{
                    PorN=0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Nai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        NaiN = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else{
                    NaiN=0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Nar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        NarN = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else{
                    NarN=0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        EB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        EBF = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else{
                    EBF=0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        //nDermatomas
        Dermatomas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        DermatomasN = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else{
                    DermatomasN=0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        Hto_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().isEmpty()) {
                    try {
                        Hto = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else{
                    Hto=0;

                }
                CalculateALL();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //dias
        Dias_Neonato.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().isEmpty()) {
                    CalculateALL();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //Mb
        MB_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        MB = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else {
                    MB = 0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //HA
        HA_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        HA = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else {
                    HA = 0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        VSCH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        VSCHN = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else {
                    VSCHN = 0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        HtoIH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        HtoIHN = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else {
                    HtoIHN = 0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        HtoPGH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().isEmpty()) {
                    try {
                        HtoPGHN = Float.valueOf(charSequence.toString());

                    }catch (Exception e){

                    }


                }
                else {
                    HtoPGHN = 0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        HtoRH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {

                    try {
                        HtoRHN = Float.valueOf(charSequence.toString());
                    }catch (Exception e){

                    }


                }
                else {
                    HtoRHN = 0;

                }
                CalculateALL();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        DD1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().isEmpty()) {
                    try {
                        DD10F = Float.valueOf(charSequence.toString());
                    }catch (Exception e){

                    }


                }
                else{
                    DD10F=0;

                }
                CalculateALL();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //Selector de Pantalla de Acuerdo a la opcion
        if(Condtional()) {
            if (code == 0) {
                SuperT.setVisibility(View.VISIBLE);
                Tema.setText("Superficie Corporal");
            }
            if (code == 1) {
                SondaT.setVisibility(View.VISIBLE);
                Tema.setText("Sonda Orotraqueal");
            }
            if (code == 2) {
                DistanciaT.setVisibility(View.VISIBLE);
                Tema.setText("Distancia de Inserción");
            }
            if (code == 3) {
                BolT.setVisibility(View.VISIBLE);
                Tema.setText("Bolsa de Ventilación");
            }
            if (code == 4) {
                OpSP.setVisibility(View.VISIBLE);
                Tema.setText("Sangrado Permisible");
            }

            if (code == 5) {
                Neo_Calc.setVisibility(View.VISIBLE);
                Tema.setText("Neonato");
            }

            if (code == 6) {
                MetBasalCalc.setVisibility(View.VISIBLE);
                Tema.setText("Metabolismo Basal");
            }

            if (code == 7) {
                ReACalc.setVisibility(View.VISIBLE);
                Tema.setText("Reposición Ayuno");
            }
            if (code == 8) {
                RHCalc.setVisibility(View.VISIBLE);
                Tema.setText("Reanimación Hídrica");
            }
            if (code == 9) {
                ConcenET.setVisibility(View.VISIBLE);
                Tema.setText("Concentrado Eritrocitario ");
            }
            if (code == 10) {
                PlamaConT.setVisibility(View.VISIBLE);
                Tema.setText("Plasma Congelado");
            }
            if (code == 11) {
                ConcenPT.setVisibility(View.VISIBLE);
                Tema.setText("Concentrado Plaquetario ");
            }
            if (code == 12) {
                CrioT.setVisibility(View.VISIBLE);
                Tema.setText("Crioprecipitados ");
            }
            if (code == 13) {
                TranfuL.setVisibility(View.VISIBLE);
                Tema.setText("Transfusión por Hematocrito");
            }
            if (code == 14) {
                MelmanT.setVisibility(View.VISIBLE);
                Tema.setText("Melman");
            }
            if (code == 15) {
                ArmitageT.setVisibility(View.VISIBLE);
                Tema.setText("Armitage");
            }
            if (code == 16) {
                TakaT.setVisibility(View.VISIBLE);
                Tema.setText("Takasaki");
            }
            if (code == 17) {
                ToxicoT.setVisibility(View.VISIBLE);
                Tema.setText("Dosis Tóxica Ropi / Lido");
            }
            if (code == 18) {
                BloqueoST.setVisibility(View.VISIBLE);
                Tema.setText("Bloqueo Subaracnoideo");
            }
            if (code == 19) {
                AdyuvantesT.setVisibility(View.VISIBLE);
                Tema.setText("Adyuvantes Epidurales");
            }
            if (code == 20) {
                PrepDT.setVisibility(View.VISIBLE);
                Tema.setText("Preparar Diluciones");
            }
            if (code == 21) {
                FarmacosT.setVisibility(View.VISIBLE);
                Tema.setText("Fármacos");
            }
            if (code == 22) {
                DCVCT.setVisibility(View.VISIBLE);
                Tema.setText("Distancia CVC por altura (cm)");
            }
            if (code == 23) {
                REPBT.setVisibility(View.VISIBLE);
                Tema.setText("Reposición de Bicarbonato");
            }
            if (code == 24) {
                REPST.setVisibility(View.VISIBLE);
                Tema.setText("Reposición de Sodio");
            }
            if (code == 25) {
                REPCT.setVisibility(View.VISIBLE);
                Tema.setText("Reposición de Calcio");
            }
            if (code == 26) {
                REPPT.setVisibility(View.VISIBLE);
                Tema.setText("Reposición de Potasio");
            }
            if (code == 27) {
                PreHiperT.setVisibility(View.VISIBLE);
                Tema.setText("Preparar Solución Hipertónica");

            }
            if (code == 28) {
                VOT.setVisibility(View.VISIBLE);
                Tema.setText("Vía oral");

            }
            if (code == 29) {
                VIT.setVisibility(View.VISIBLE);
                Tema.setText("Vía Intramuscular");

            }
            if (code == 30) {
                VNT.setVisibility(View.VISIBLE);
                Tema.setText("Vía Nasal");

            }
            if (code == 31) {
                PALS.setVisibility(View.VISIBLE);


            }
        }
        //problema con la pantalla
        else
            proble.setVisibility(View.VISIBLE);
    }

    //Proceso para calcular
    public  void CalculateALL(){

    //opciones de PALS
        if(PALS_op==1){
            PALSTT.setText("Indicación: TSV");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(0.1*Peso))));
            PALS13.setText("IV/IO");
            Tema.setText("Adenosina");
        }
        if(PALS_op==2){
            PALSTT.setText("Paro o bradicardia sintomática");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(0.01*Peso))));
            PALS13.setText("IV/IO cada 3 a 5 min");
            PALS21.setText("Dosis (mg)");
            PALS22.setText(""+(String.format("%.2f",(0.1*Peso))));
            PALS23.setText("ET cada 3 a 5 min");
            Adreno1T.setText(""+(String.format("%.2f",(0.01*Peso))));
            Adreno2T.setText(""+(String.format("%.2f",(0.01*Peso))));
            Adreno3T.setText(""+(String.format("%.2f",(0.01*Peso))));
            Level2.setVisibility(View.VISIBLE);
            Adreno2.setVisibility(View.VISIBLE);
            Adreno3.setVisibility(View.VISIBLE);
            Tema.setText("Adrenalina");
        }
        if(PALS_op==3){
            PALSTT.setText("Shock, traumatismo o quemaduras");
            PALS11.setText("Dosis (g)");
            PALS12.setText(""+(String.format("%.2f",(0.5*Peso))));
            PALS13.setText("A pasar de 10 a 20 ml/kg de solución");
            PALS21.setText("Dosis (g)");
            PALS22.setText(""+(String.format("%.2f",(1*Peso))));
            PALS23.setText("A pasar de 10 a 20 ml/kg de solución");
            Level2.setVisibility(View.VISIBLE);
            Tema.setText("Albúmina");
        }

        if(PALS_op==4){
            PALSTT.setText("TSV o TV (con pulso)");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(5*Peso))));
            PALS13.setText("Pasar en 20 a 60 min (max 300 mg)");
            Tema.setText("Amiodarona");

        }
        if(PALS_op==5){
            PALSTT.setText("Acidosis metabólica grave o hiperpotasemia");
            PALS11.setText("Dosis (mEq)");
            PALS12.setText(""+(String.format("%.2f",(1*Peso))));
            PALS13.setText("IV/IO bolo lento");
            Tema.setText("Bicabonato");

        }
        if(PALS_op==6){
            PALSTT.setText("Asma");
            PALS11.setText("Dosis (mcg)");
            PALS12.setText("250 a 500 ");
            PALS13.setText("3 dosis por inhalación");
            Tema.setText("B. de Ipratropio");

        }
        if(PALS_op==7){
            PALSTT.setText("Hipocalcemia, Hiperpotasemia, Hipermagnesemia");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(20*Peso))));
            PALS13.setText("IV/IO bolo lento");
            Tema.setText("Calcio");

        }
        if(PALS_op==8){
            PALSTT.setText("Hipoglicemia");
            PALS11.setText("ml de 10%");
            PALS12.setText(""+(String.format("%.2f",(5*Peso))));
            PALS13.setText("0.5 g por kg");
            PALS21.setText("ml de 10%");
            PALS22.setText(""+(String.format("%.2f",(10*Peso))));
            PALS23.setText("1 g por kg");
            Level2.setVisibility(View.VISIBLE);
            Tema.setText("Glucosa");

        }
        if(PALS_op==9){
            PALSTT.setText("Shock anafiláctico");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(1*Peso))));
            PALS13.setText("IV/IO/IM cada 4 a 6 hrs");
            PALS21.setText("Dosis (mg)");
            PALS22.setText(""+(String.format("%.2f",(2*Peso))));
            PALS23.setText("IV/IO/IM cada 4 a 6 hrs");
            Level2.setVisibility(View.VISIBLE);
            Tema.setText("Difenhidramina");

        }

        if(PALS_op==10){
            PALSTT.setText("Insuficiencia suprarrenal");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(2*Peso))));
            PALS13.setText("IV en bolo");
            Tema.setText("Hidrocortisona");


        }
        if(PALS_op==11){
            PALSTT.setText("FV/TV sin pulso, taquicardia complejo ancho con pulso");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(1*Peso))));
            PALS13.setText("IV/IO en bolo");
            PALS21.setText("Dosis (mg)");
            PALS22.setText(""+(String.format("%.2f",(2*Peso))));
            PALS23.setText("ET");
            Level2.setVisibility(View.VISIBLE);
            Tema.setText("Lidocaína");

        }
        if(PALS_op==12){
            PALSTT.setText("Asma o Shock anafiláctico");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(2*Peso))));
            PALS13.setText("IV/IO/IM (max 60)");
            Tema.setText("Metilprednisolona");


        }
        if(PALS_op==13){
            PALSTT.setText("Antagonismo opiáceos");
            PALS11.setText("Dosis (mcg)");
            PALS12.setText(""+(String.format("%.2f",(1*Peso))));
            PALS13.setText("IV/IO/IM/Sub (1 a 5 mcg hasta efecto)");
            PALS21.setText("Dosis (mcg)");
            PALS22.setText(""+(String.format("%.2f",(5*Peso))));
            PALS23.setText("IV/IO/IM/Sub (1 a 5 mcg hasta efecto)");
            Level2.setVisibility(View.VISIBLE);
            Tema.setText("Naloxona");
            PALS13.setTextSize(12);
            PALS23.setTextSize(12);


        }
        if(PALS_op==14){
            PALSTT.setText("TSV, fluter auricular o TV (con pulso)");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(15*Peso))));
            PALS13.setText("Carga en 30 a 60 min");
            Tema.setText("Procainamida");



        }
        if(PALS_op==15){
            PALSTT.setText("Asma, anafilaxia, hiperpotasemia");
            PALS11.setText("Spray");
            PALS12.setText("4 a 8 ");
            PALS13.setText("Inhalaciones cada 20 min");
            PALS21.setText(" Nebulizador (mg)");
            PALS22.setText(""+(String.format("%.2f",(2.5*Peso))));
            PALS23.setText("< 20 kg cada 20 min");
            PALS31.setText(" Nebulizador (mg)");
            PALS32.setText(""+(String.format("%.2f",(5*Peso))));
            PALS33.setText("> 20 kg cada 20 min");
            Level2.setVisibility(View.VISIBLE);
            Level3.setVisibility(View.VISIBLE);
            Tema.setText("Salbutamol");

        }

        if(PALS_op==16){
            PALSTT.setText("Bradicardia sintomática");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(0.02*Peso))));
            PALS13.setText("IV/IO (niños max 0.5 mg y adolescentes 1 mg)");
            PALS21.setText("Dosis (mg)");
            PALS22.setText(""+(String.format("%.2f",(0.04*Peso))));
            PALS23.setText("ET");
            Level2.setVisibility(View.VISIBLE);
            Tema.setText("S. Atropina");
            PALS13.setTextSize(12);
            PALS23.setTextSize(12);

        }
        if(PALS_op==17){
            PALSTT.setText("Asma, torsade de pointes e hipomagnesemia");
            PALS11.setText("Dosis (mg)");
            PALS12.setText(""+(String.format("%.2f",(25*Peso))));
            PALS13.setText("IV/IO bolo (TV sin pulso) 20 min (con pulso)");
            PALS21.setText("Dosis (mg)");
            PALS22.setText(""+(String.format("%.2f",(50*Peso))));
            PALS23.setText("o en 30 min en estado asmático");
            Level2.setVisibility(View.VISIBLE);
            Tema.setText("S. Magnesio");
            PALS13.setTextSize(10);
            PALS23.setTextSize(10);

        }

        MidaVO.setText(""+(String.format("%.1f",(0.5*Peso))));
        MidaVI.setText(""+(String.format("%.1f",(0.3*Peso))));
        MidaVN.setText(""+(String.format("%.1f",(0.3*Peso))));
        KeVO.setText(""+(String.format("%.1f",(5*Peso))));
        KeVI.setText(""+(String.format("%.1f",(5*Peso))));
        KeVN.setText(""+(String.format("%.1f",(3*Peso))));
        CloniVO.setText(""+(String.format("%.1f",(4*Peso))));
        DexVN.setText(""+(String.format("%.1f",(0.2*Peso))));




        ALb05.setText(""+(String.format("%.1f",(0.5*Peso))));
        Alb1.setText(""+(String.format("%.1f",(1*Peso))));
        Alb20= (Float.valueOf(ALb05.getText().toString())*50)/10;
        Alb25= (float) ((Float.valueOf(ALb05.getText().toString())*50)/12.5);
        Alb0520.setText(""+(String.format("%.1f",(Alb20*4))));
        Alb120.setText(""+(String.format("%.1f",((Float.valueOf(Alb0520.getText().toString()))*2))));
        Alb0525.setText(""+(String.format("%.1f",(Alb25*5))));
        Alb125.setText(""+(String.format("%.1f",((Float.valueOf(Alb0525.getText().toString()))*2))));


        minHS1=Peso-10;
        minHs2=Peso-20;
        HSm10.setText(""+(String.format("%.1f",(4*Peso)))+" ml");
        HS1020.setText(""+(String.format("%.1f",(40+(2*minHS1))))+" ml");
        HSM20.setText(""+(String.format("%.1f",(60+(1*minHs2))))+" ml");


        m10.setText(""+(String.format("%.2f",(((Peso*4)+9)/100))));
        M10.setText(""+(String.format("%.2f",((Peso*4)+7)/(Peso+90))));

        Hiper3.setText(""+String.format("%.1f",((HipermldN*((3-0.9)/(17.7-0.9))))));
        Hiper5.setText(""+String.format("%.1f",(HipermldN*((5-0.9)/(17.7-0.9)))));


        BolsaV.setText(""+(String.format("%.2f",(((Peso*100))))));


        DNeonato.setText(""+(String.format("%.1f",((Peso+6)))));


        VSC_Pre.setText(""+(String.format("%.1f",((Peso*VSE[0])))));
        VSC_Term.setText(""+(String.format("%.1f",((Peso*VSE[1])))));
        VSC_Lact.setText(""+(String.format("%.1f",((Peso*VSE[2])))));
        VSC_M6.setText(""+(String.format("%.1f",((Peso*VSE[3])))));
        VSC_Hombre.setText(""+(String.format("%.1f",((Peso*VSE[4])))));
        VSC_Mujer.setText(""+(String.format("%.1f",((Peso*VSE[5])))));

        if(VSC_Porcent==true){
            VSC_Pre.setText(""+(String.format("%.1f",((Peso*VSE[0]*0.15)))));
            VSC_Term.setText(""+(String.format("%.1f",((Peso*VSE[1]*0.15)))));
            VSC_Lact.setText(""+(String.format("%.1f",((Peso*VSE[2]*0.15)))));
            VSC_M6.setText(""+(String.format("%.1f",((Peso*VSE[3]*0.15)))));
            VSC_Hombre.setText(""+(String.format("%.1f",((Peso*VSE[4]*0.15)))));
            VSC_Mujer.setText(""+(String.format("%.1f",((Peso*VSE[5]*0.15)))));
        }


        try {
           if(!Dias_Neonato.getText().toString().isEmpty()) {
                if (Integer.valueOf(Dias_Neonato.getText().toString()) > 0
                        && Integer.valueOf(Dias_Neonato.getText().toString()) < 8) {

                    if (Integer.valueOf(Dias_Neonato.getText().toString()) == 1) {
                        Neo_Term.setText("" + (String.format("%.1f", Peso * 60 / 24)));
                        Neo_Prem.setText("" + (String.format("%.1f", Peso * 70 / 24)));
                        Neo_TerM.setText("" + (String.format("%.1f", Peso * 70 / 24)));
                        Neo_PreM.setText("" + (String.format("%.1f", Peso * 80 / 24)));
                    }
                    if (Integer.valueOf(Dias_Neonato.getText().toString()) == 2) {

                        Neo_Term.setText("" + String.format("%.1f", Peso * 70 / 24));
                        Neo_Prem.setText("" + String.format("%.1f", Peso * 80 / 24));
                        Neo_TerM.setText("" + String.format("%.1f", Peso * 80 / 24));
                        Neo_PreM.setText("" + String.format("%.1f", Peso * 90 / 24));
                    }
                    if (Integer.valueOf(Dias_Neonato.getText().toString()) == 3) {

                        Neo_Term.setText("" + String.format("%.1f", Peso * 80 / 24));
                        Neo_Prem.setText("" + String.format("%.1f", Peso * 90 / 24));
                        Neo_TerM.setText("" + String.format("%.1f", Peso * 90 / 24));
                        Neo_PreM.setText("" + String.format("%.1f", Peso * 100 / 24));
                    }
                    if (Integer.valueOf(Dias_Neonato.getText().toString()) == 4) {

                        Neo_Term.setText("" + String.format("%.1f", Peso * 90 / 24));
                        Neo_Prem.setText("" + String.format("%.1f", Peso * 100 / 24));
                        Neo_TerM.setText("" + String.format("%.1f", Peso * 100 / 24));
                        Neo_PreM.setText("" + String.format("%.1f", Peso * 100 / 24));
                    }
                    if (Integer.valueOf(Dias_Neonato.getText().toString()) == 5) {

                        Neo_Term.setText("" + String.format("%.1f", Peso * 100 / 24));
                        Neo_Prem.setText("" + String.format("%.1f", Peso * 110 / 24));
                        Neo_TerM.setText("" + String.format("%.1f", Peso * 120 / 24));
                        Neo_PreM.setText("" + String.format("%.1f", Peso * 120 / 24));
                    }

                    if (Integer.valueOf(Dias_Neonato.getText().toString()) == 6) {

                        Neo_Term.setText("" + String.format("%.1f", Peso * 120 / 24));
                        Neo_Prem.setText("" + String.format("%.1f", Peso * 120 / 24));
                        Neo_TerM.setText("" + String.format("%.1f", Peso * 140 / 24));
                        Neo_PreM.setText("" + String.format("%.1f", Peso * 130 / 24));
                    }
                    if (Integer.valueOf(Dias_Neonato.getText().toString()) == 7) {

                        Neo_Term.setText("" + String.format("%.1f", Peso * 140 / 24));
                        Neo_Prem.setText("" + String.format("%.1f", Peso * 130 / 24));
                        Neo_TerM.setText("" + String.format("%.1f", Peso * 150 / 24));
                        Neo_PreM.setText("" + String.format("%.1f", Peso * 150 / 24));
                    }

                } else {
                    Neo_Term.setText("0" );
                    Neo_Prem.setText("0" );
                    Neo_TerM.setText("0" );
                    Neo_PreM.setText("0" );
                }

            }
        }catch (Exception e){

        }


        IMCm101200.setText(""+String.format("%.1f",Float.valueOf(m10.getText().toString())*1200/24));
        IMCm101500.setText(""+String.format("%.1f",Float.valueOf(m10.getText().toString())*1500/24));
        IMCm101800.setText(""+String.format("%.1f",Float.valueOf(m10.getText().toString())*1800/24));
        IMCM1200.setText(""+String.format("%.1f",Float.valueOf(M10.getText().toString())*1200/24));
        IMCM101500.setText(""+String.format("%.1f",Float.valueOf(M10.getText().toString())*1500/24));
        IMCM101800.setText(""+String.format("%.1f",Float.valueOf(M10.getText().toString())*1800/24));


        ml120.setText(""+String.format("%.1f",Peso*120/24));
        ml150.setText(""+String.format("%.1f",150*Peso/24));

        Berrym3.setText(""+String.format("%.1f",Peso*25));
        BerryM3.setText(""+String.format("%.1f",Peso*15));


        mlkg5.setText(""+String.format("%.1f",Peso*5));
        mlkg10.setText(""+String.format("%.1f",Peso*10));
        mlkg20.setText(""+String.format("%.1f",Peso*20));


        Dosis5.setText(""+String.format("%.2f",Peso*5));
        Dosis10.setText(""+String.format("%.2f",Peso*10));
        Dosis15.setText(""+String.format("%.2f",Peso*15));
        Dosis20.setText(""+String.format("%.2f",Peso*20));

        DosisP5.setText(""+String.format("%.2f",Peso*5));
        DosisP10.setText(""+String.format("%.2f",Peso*10));
        DosisP15.setText(""+String.format("%.2f",Peso*15));

        Dosis5CP.setText(""+String.format("%.2f",Peso*5));
        Dosis10CP.setText(""+String.format("%.2f",Peso*10));

        Dosis5Crio.setText(""+String.format("%.2f",Peso*5));
        Dosis10Crio.setText(""+String.format("%.2f",Peso*10));

        T2.setText(""+String.format("%.1f",Peso*1.8));
        T4.setText(""+String.format("%.1f",Peso*1.6));
        T10.setText(""+String.format("%.1f",Peso*1.4));
        T12.setText(""+String.format("%.1f",Peso*1.2));

        T2M02.setText(""+String.format("%.1f",(Peso*1.8)*0.2/0.75));
        T2M025.setText(""+String.format("%.1f",(Peso*1.8)*0.25/0.75));
        T2M03.setText(""+String.format("%.1f",(Peso*1.8)*0.3/0.75));
        T2M034.setText(""+String.format("%.1f",(Peso*1.8)*0.35/0.75));
        T2M04T4.setText(""+String.format("%.1f",(Peso*1.8)*0.4/0.75));
        T4M02.setText(""+String.format("%.1f",(Peso*1.6)*0.2/0.75));
        T4M025.setText(""+String.format("%.1f",(Peso*1.6)*0.25/0.75));
        T4M03.setText(""+String.format("%.1f",(Peso*1.6)*0.3/0.75));
        T4M034.setText(""+String.format("%.1f",(Peso*1.6)*0.35/0.75));
        T4M04T4.setText(""+String.format("%.1f",(Peso*1.6)*0.4/0.75));
        T10M02.setText(""+String.format("%.1f",(Peso*1.4)*0.2/0.75));
        T10M025.setText(""+String.format("%.1f",(Peso*1.4)*0.25/0.75));
        T10M03.setText(""+String.format("%.1f",(Peso*1.4)*0.3/0.75));
        T10M034.setText(""+String.format("%.1f",(Peso*1.4)*0.35/0.75));
        T10M04T4.setText(""+String.format("%.1f",(Peso*1.4)*0.4/0.75));
        T12M02.setText(""+String.format("%.1f",(Peso*1.2)*0.2/0.75));
        T12M025.setText(""+String.format("%.1f",(Peso*1.2)*0.25/0.75));
        T12M03.setText(""+String.format("%.1f",(Peso*1.2)*0.3/0.75));
        T12M034.setText(""+String.format("%.1f",(Peso*1.2)*0.35/0.75));
        T12M04T4.setText(""+String.format("%.1f",(Peso*1.2)*0.4/0.75));

        Toracico125.setText(""+String.format("%.1f",(Peso*1.25)));
        Lumbar1.setText(""+String.format("%.1f",(Peso)));
        Sacro05.setText(""+String.format("%.1f",(Peso*0.5)));

        Toracico02.setText(""+String.format("%.1f",(Peso*1.25)*0.2/0.75));
        Toracico025.setText(""+String.format("%.1f",(Peso*1.25)*0.25/0.75));
        Toracico03.setText(""+String.format("%.1f",(Peso*1.25)*0.3/0.75));
        Toracico035.setText(""+String.format("%.1f",(Peso*1.25)*0.35/0.75));
        Toracico04.setText(""+String.format("%.1f",(Peso*1.25)*0.4/0.75));
        Lumbar02.setText(""+String.format("%.1f",(Peso*1)*0.2/0.75));
        Lumbar025.setText(""+String.format("%.1f",(Peso*1)*0.25/0.75));
        Lumbar03.setText(""+String.format("%.1f",(Peso*1)*0.3/0.75));
        Lumbar035.setText(""+String.format("%.1f",(Peso*1)*0.35/0.75));
        Lumbar04.setText(""+String.format("%.1f",(Peso*1)*0.4/0.75));
        Sacro02.setText(""+String.format("%.1f",(Peso*0.5)*0.2/0.75));
        Sacro025.setText(""+String.format("%.1f",(Peso*0.5)*0.25/0.75));
        Sacro03.setText(""+String.format("%.1f",(Peso*0.5)*0.3/0.75));
        Sacro035.setText(""+String.format("%.1f",(Peso*0.5)*0.35/0.75));
        Sacro04.setText(""+String.format("%.1f",(Peso*0.5)*0.4/0.75));


        TDermatomas.setText(""+String.format("%.1f",0.05*DermatomasN*Peso));
        Taka02.setText(""+String.format("%.1f",DermatomasN*0.2/0.75));
        Taka025.setText(""+String.format("%.1f",DermatomasN*0.25/0.75));
        Taka03.setText(""+String.format("%.1f",DermatomasN*0.3/0.75));
        Taka035.setText(""+String.format("%.1f",DermatomasN*0.35/0.75));
        Taka4.setText(""+String.format("%.1f",DermatomasN*0.4/0.75));

        Toxico5mg.setText(""+String.format("%.2f",Peso*5));
        Toxico7mg.setText(""+String.format("%.2f",Peso*7));

        Bloqueo5.setText(""+String.format("%.1f",Peso*0.5));
        Bloqueo515.setText(""+String.format("%.1f",Peso*0.4));
        Bloqueo15.setText(""+String.format("%.1f",Peso*0.3));
        BloqueoA.setText(""+String.format("%.1f",Peso*0.2));

        Mm.setText(""+String.format("%.1f",Peso*30));
        MM.setText(""+String.format("%.1f",Peso*50));
        Fm.setText(""+String.format("%.1f",Peso));
        FM.setText(""+String.format("%.1f",Peso*3));
        Km.setText(""+String.format("%.1f",Peso*0.5));
        KM.setText(""+String.format("%.1f",Peso));
        Cm.setText(""+String.format("%.1f",Peso));
        CM.setText(""+String.format("%.1f",Peso*2));
        Dinam.setText(""+String.format("%.1f",Peso*2));
        DinaM.setText(""+String.format("%.1f",Peso*3));
        Donam.setText(""+String.format("%.1f",Peso*0.1));
        DonaM.setText(""+String.format("%.1f",Peso*0.2));
        Tm.setText(""+String.format("%.1f",Peso*1));
        TM.setText(""+String.format("%.1f",Peso*2));

        D50.setText(""+String.format("%.2f",Peso*3*DD10F));
        D100.setText(""+String.format("%.2f",Peso*6*DD10F));

        MeqRb.setText(""+String.format("%.2f",Peso*0.3*EBF));
        hr8.setText(""+String.format("%.2f",((Peso*0.3*EBF)/2)/8.9*10));
        hr16.setText(""+String.format("%.2f",((Peso*0.3*EBF)/2)/8.9*10));

        MeqRS.setText(""+String.format("%.2f",(NaiN-NarN)*0.6*Peso));
        hr8Rs.setText(""+String.format("%.2f",(((NaiN-NarN)*0.6*Peso)/2)/3));
        hr16RS.setText(""+String.format("%.2f",(((NaiN-NarN)*0.6*Peso)/2)/3));

        Cal30.setText(""+String.format("%.2f",Peso*30));
        Cal50.setText(""+String.format("%.2f",Peso*50));
        Cal100.setText(""+String.format("%.2f",Peso*100));
        Glu30.setText(""+String.format("%.2f",(Peso*30)/100));
        Glu50.setText(""+String.format("%.2f",(Peso*50)/100));
        Glu100.setText(""+String.format("%.2f",(Peso*100)/100));

        Deficit.setText(""+String.format("%.2f",(PoiN-PorN)*0.3*Peso)+" mEq");
        P025.setText(""+String.format("%.2f",Peso*0.25/0.06));
        P05.setText(""+String.format("%.2f",Peso*0.5/0.06));

        YID.setText(""+String.format("%.2f",Talla/10));
        SI.setText(""+String.format("%.2f",(Talla/10)+2));
        SD.setText(""+String.format("%.2f",(Talla/10)-2));
        I.setText(""+String.format("%.2f",(Talla/10)+4));

        TransfundirH.setText(""+String.format("%.2f",VSCHN*((HtoIHN-HtoRHN)/HtoPGHN)));

        DI.setText(""+ (String.format("%.1f",(((Edad+16)/4)))));

        DLactante.setText(""+(String.format("%.1f",((Edad+10)))));

        DM2anos.setText(""+(String.format("%.1f",(((Edad/2)+12)))));

        Dif_hto[0]=(Hto-Htodiff[0]);
        Dif_hto[1]=Hto-Htodiff[1];
        Dif_hto[2]=Hto-Htodiff[2];

        Prom_hto[0]=(Hto+Htodiff[0])/2;
        Prom_hto[1]=(Hto+Htodiff[1])/2;
        Prom_hto[2]=(Hto+Htodiff[2])/2;

        HTO_Pre.setText(""+String.format("%.1f",(((Dif_hto[HTO_op]/100)/(Prom_hto[HTO_op]/100))*(Peso*VSE[0]))));
        HTO_Term.setText(""+String.format("%.1f",(((Dif_hto[HTO_op]/100)/(Prom_hto[HTO_op]/100))*(Peso*VSE[1]))));
        HTO_Lact.setText(""+String.format("%.1f",(((Dif_hto[HTO_op]/100)/(Prom_hto[HTO_op]/100))*(Peso*VSE[2]))));
        HTO_M6.setText(""+String.format("%.1f",(((Dif_hto[HTO_op]/100)/(Prom_hto[HTO_op]/100))*(Peso*VSE[3]))));
        HTO_Hombre.setText(""+String.format("%.1f",(((Dif_hto[HTO_op]/100)/(Prom_hto[HTO_op]/100))*(Peso*VSE[4]))));
        HTO_Mujer.setText(""+String.format("%.1f",(((Dif_hto[HTO_op]/100)/(Prom_hto[HTO_op]/100))*(Peso*VSE[5]))));

        TaR.setText(""+String.format("%.2f",MB*HA));
        hora1.setText(""+String.format("%.2f",MB*HA*0.5));
        hora2.setText(""+String.format("%.2f",MB*HA*0.25));
        hora3.setText(""+String.format("%.2f",MB*HA*0.25));

    }
    //Condicional no se ha puesto algun Dato base
    public boolean Condtional(){
        if(Peso==0  || Edad==0 || Talla==0){
            return false;
        }
        return true;
    }

    public void PorcentVSC(View view){
        if(!VSC_Porcent) {
            VSC_Porcent = true;
            CalculateALL();
            VSC_T.setText("VSC 15%");
        }

    }

    public void PorcentVSC_Normal(View view){
        if(VSC_Porcent) {
            VSC_Porcent = false;
            CalculateALL();
            VSC_T.setText("VSC");
        }

    }
    public void Hto25(View view){
        HTO_op=0;
        HTO_T.setText("Hto 25%");
        CalculateALL();
    }

    public void Hto30(View view){
        HTO_op=1;
        HTO_T.setText("Hto 30%");
        CalculateALL();
    }

    public void Hto35(View view){
        HTO_op=2;
        HTO_T.setText("Hto 35%");
        CalculateALL();
    }

    public void setBack(View view){
        finish();
    }
}
