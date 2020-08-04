/*  Calculadora de Anestesia Pediatrica
    Menú Principal, Bibliografia y Contacto
    Autor: Johan Guillén
*/

package savealife.fivestar.app.com.savealife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {

    private EditText Edad_text,Peso_text,Talla_text;

    private TextView Tema;

    private LinearLayout Datos_P,OpF,OpHD,DatosT,OpPreMe,OpPALS,OpAN,OpAminas, OpEL;

    private ScrollView Calculo, Biblio, Contacto;

    private ImageButton BCalc, BBiblio,BContac;

    private float Peso,Talla,Edad;

    private boolean CG_b,VSC_Porcent,OpF_b,OpHd_b,OpAN_b,OpAminas_b,OpEL_b,DatosT_b,PreMe_b,PALS_b;

    private Intent toRex;

    private SharedPreferences myPreferences;
    private SharedPreferences.Editor myEditor;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bools
        CG_b=false;
        VSC_Porcent=false;
        OpF_b=false;
        OpHd_b=false;
        OpAN_b=false;
        OpAminas_b=false;
        OpEL_b=false;
        DatosT_b=false;
        PreMe_b=false;
        PALS_b=false;

        //floats
        Peso=0;
        Talla=0;
        Edad=0;

        //Intent
        toRex=new Intent(this, rex.class);

        //Preferences
        myPreferences = PreferenceManager.getDefaultSharedPreferences( MainActivity.this);
        myEditor = myPreferences.edit();

        //Id
         //Calculo General
        Edad_text=(EditText) findViewById(R.id.Edad);
        Peso_text=(EditText) findViewById(R.id.Peso);
        Talla_text=(EditText) findViewById(R.id.Talla);

        Tema=(TextView) findViewById(R.id.tema);

        Datos_P= (LinearLayout) findViewById(R.id.DatosdelPaciente);
        OpF=(LinearLayout) findViewById(R.id.opF);
        OpHD=(LinearLayout)findViewById(R.id.opHD) ;
        OpAN=(LinearLayout)findViewById(R.id.opAN) ;
        OpAminas=(LinearLayout) findViewById(R.id.opAMINAS);
        OpEL=(LinearLayout) findViewById(R.id.opEL);
        DatosT=(LinearLayout) findViewById(R.id.DatosT);
        OpPreMe=(LinearLayout) findViewById(R.id.opPreMe);
        OpPALS=(LinearLayout) findViewById(R.id.opPALS);

        Calculo=(ScrollView) findViewById(R.id.Calculos);
        Biblio=(ScrollView) findViewById(R.id.Bibliografia);
        Contacto=(ScrollView) findViewById(R.id.Contacto);

        BCalc=(ImageButton) findViewById(R.id.BCalculo);
        BBiblio=(ImageButton) findViewById(R.id.BBiblio);
        BContac=(ImageButton) findViewById(R.id.BContac);

        Calculo.setVisibility(View.VISIBLE);
        Biblio.setVisibility(View.GONE);
        Contacto.setVisibility(View.GONE);
        BCalc.setBackground(getDrawable(R.drawable.recip));
        BBiblio.setBackground(null);
        BContac.setBackground(null);
        DatosT.setVisibility(View.VISIBLE);
        Tema.setVisibility(View.GONE);


        //load
        if(!myPreferences.contains("Edad")){
            myEditor.putString("Edad",null);
            myEditor.commit();
        }

        else {
            Edad_text.setText("" + myPreferences.getString("Edad", null));
            try{
                Edad=Float.valueOf(myPreferences.getString("Edad",null));
            }catch (Exception e){

            }
        }


        if(!myPreferences.contains("Peso")){
            myEditor.putString("Peso",null);
            myEditor.commit();
        }

        else {
            Peso_text.setText("" + myPreferences.getString("Peso", null));
            try{
                Peso=Float.valueOf(myPreferences.getString("Peso",null));
            }catch (Exception e){

            }
        }

        if(!myPreferences.contains("Talla")){
            myEditor.putString("Talla",null);
            myEditor.commit();
        }


        else {
            Talla_text.setText("" + myPreferences.getString("Talla", null));
            try{
                Talla=Float.valueOf(myPreferences.getString("Talla",null));
            }catch (Exception e){

            }
        }

        //Text Watcher

        Talla_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        Talla = Float.valueOf(charSequence.toString());
                        toRex.putExtra("Talla",Talla);
                        myEditor.putString("Talla",charSequence.toString());


                    }catch (Exception e){

                    }

                }
                else{
                    Talla=0;
                    toRex.putExtra("Talla",Talla);
                    myEditor.putString("Talla","");

                }
                myEditor.commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        //EDAD
        Edad_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    try {
                        Edad = Float.valueOf(charSequence.toString());
                        toRex.putExtra("Edad", Edad);
                        myEditor.putString("Edad",charSequence.toString());

                    }catch (Exception e){

                    }
                }
                else{
                    Edad=0;
                    toRex.putExtra("Edad",Edad);
                    myEditor.putString("Edad","");

                }
                myEditor.commit();

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        //Peso
        Peso_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().isEmpty()) {
                    try {
                        Peso = Float.valueOf(charSequence.toString());
                        toRex.putExtra("Peso", Peso);
                        myEditor.putString("Peso",charSequence.toString());

                    }catch (Exception e){}
                }
                else{
                    Peso=0;
                    toRex.putExtra("Peso",Peso);
                    myEditor.putString("Peso","");

                }
                myEditor.commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    }
    //Calculos
    /*
    B3=Peso
    B2=Edad
    B4=talla
    B5 S<10
    B6 S>10
    B15 MB
    B16 HG
    F2=Hb
    F3=hto
    AB2=Htodiff 0
    AB3=Htodiff 1
    AB4=Htodiff 3
    AC2 diff hto 0
    AC3 diff hto 1
    AC4 diff hto 2
    AD2..4 Pro_hto
    C15...20 VsC 0 ... 5
*/

    //Botones
    public void D_CG(View view){
        if(!CG_b){
            Datos_P.setVisibility(View.VISIBLE);
            CG_b=true;
        }
        else{
            Datos_P.setVisibility(View.GONE);
            CG_b=false;
        }

    }
//**************OP2*******
    public void D_SP(View view){
        toRex.putExtra("code",4);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }
//*****************************

    public void D_F(View view){
        if(!OpF_b){
            OpF.setVisibility(View.VISIBLE);
            OpF_b=true;
        }
        else{
            OpF.setVisibility(View.GONE);
            OpF_b=false;
        }

    }
//********************op3*********************
    public void D_CNEO(View view){
        toRex.putExtra("code",5);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
    public void D_CMETB(View view){
        toRex.putExtra("code",6);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
    public void D_CREA(View view){
        toRex.putExtra("code",7);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
    public void D_CRH(View view){
        toRex.putExtra("code",8);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
//************************************************
    }
    public void D_CHD(View view){
        if(!OpHd_b){
            OpHD.setVisibility(View.VISIBLE);
            OpHd_b=true;
        }
        else{
            OpHD.setVisibility(View.GONE);
            OpHd_b=false;
        }

    }

//************op4********
    public void D_CCont(View view){
        toRex.putExtra("code",9);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_CPlama(View view){
        toRex.putExtra("code",10);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
    public void D_CConPt(View view){
        toRex.putExtra("code",11);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_CCrio(View view) {
        toRex.putExtra("code",12);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_CTransfu(View view){
        toRex.putExtra("code",13);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
    //******************************************

    public void D_COPAN(View view){
        if(!OpAN_b){
            OpAN.setVisibility(View.VISIBLE);
            OpAN_b=true;
        }
        else{
            OpAN.setVisibility(View.GONE);
            OpAN_b=false;
        }

    }
    //*******************op5*******************
    public void D_CMelman(View view){

        toRex.putExtra("code",14);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }


    public void D_CArmi(View view){
        toRex.putExtra("code",15);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_CTaka(View view){
        toRex.putExtra("code",16);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_CTox(View view){
        toRex.putExtra("code",17);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_CBloq(View view){
        toRex.putExtra("code",18);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_Adyu(View view){
        toRex.putExtra("code",19);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
//*********************************
    public void D_OPA(View view){
        if(!OpAminas_b){
            OpAminas.setVisibility(View.VISIBLE);
            OpAminas_b=true;
        }
        else{
            OpAminas.setVisibility(View.GONE);
            OpAminas_b=false;
        }

    }
////op7****************************************
    public void D_PREpD(View view){
        toRex.putExtra("code",20);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_FArma(View view){
        toRex.putExtra("code",21);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_DCVC(View view){
        toRex.putExtra("code",22);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
    //***********************************
    public void D_OPel(View view){
        if(!OpEL_b){
            OpEL.setVisibility(View.VISIBLE);
            OpEL_b=true;
        }
        else{
            OpEL.setVisibility(View.GONE);
            OpEL_b=false;
        }

    }
    //************op8*******************
    public void D_Repb(View view){
        toRex.putExtra("code",23);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_Reps(View view){
        toRex.putExtra("code",24);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_Repc(View view){
        toRex.putExtra("code",25);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_Repp(View view){
        toRex.putExtra("code",26);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
    //***********************************
    public void D_DAtos(View view){
        if(!DatosT_b){
            DatosT.setVisibility(View.VISIBLE);
            DatosT_b=true;
        }
        else{
            DatosT.setVisibility(View.GONE);
            DatosT_b=false;
        }

    }


    public void D_PreMe(View view){
        if(!PreMe_b){
            OpPreMe.setVisibility(View.VISIBLE);
            PreMe_b=true;
        }
        else{
            OpPreMe.setVisibility(View.GONE);
            PreMe_b=false;
        }

    }

    public void D_PALS(View view){
        if(!PALS_b){
            OpPALS.setVisibility(View.VISIBLE);
            PALS_b=true;
        }
        else{
            OpPALS.setVisibility(View.GONE);
            PALS_b=false;
        }

    }
    //*****************************PALS********

    public void D_adeno(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",1);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_adre(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",2);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_albu(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",3);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_ami(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",4);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_bica(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",5);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_ipra(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",6);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_cal(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",7);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_gluco(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",8);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_difen(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",9);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_hidro(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",10);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_lido(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",11);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }
    public void D_Metil(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",12);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }
    public void D_nalo(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",13);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }
    public void D_proca(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",14);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }
    public void D_sabu(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",15);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_atro(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",16);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }
    public void D_mag(View view){
        toRex.putExtra("code",31);
        toRex.putExtra("opPALS",17);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }


    //*********************************

    //**************OPPreme**********************
    public void D_VO(View view){
        toRex.putExtra("code",28);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_VI(View view){
        toRex.putExtra("code",29);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);


    }

    public void D_VN(View view){
        toRex.putExtra("code",30);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);


    }


    //*************************************

    /***************Op1*********/
    public void D_SUpe(View view){
        toRex.putExtra("code",0);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);


    }

    public void D_Sonda(View view){
        toRex.putExtra("code",1);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    public void D_Dis(View view){
        toRex.putExtra("code",2);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);
    }

    public void D_Bol(View view){
        toRex.putExtra("code",3);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }
    /************************/

    public void D_PreH(View view){
        toRex.putExtra("code",27);
        toRex.putExtra("opPALS",0);
        toRex.putExtra("Edad",Edad);
        toRex.putExtra("Talla",Talla);
        toRex.putExtra("Peso",Peso);
        startActivity(toRex);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void ChangeCalc(View view){
        Calculo.setVisibility(View.VISIBLE);
        Biblio.setVisibility(View.GONE);
        Contacto.setVisibility(View.GONE);
        BCalc.setBackground(getDrawable(R.drawable.recip));
        BBiblio.setBackground(null);
        BContac.setBackground(null);
        DatosT.setVisibility(View.VISIBLE);
        Tema.setVisibility(View.GONE);
        Tema.setText("");

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void ChangeBiblio(View view){
        Calculo.setVisibility(View.GONE);
        Biblio.setVisibility(View.VISIBLE);
        Contacto.setVisibility(View.GONE);
        BBiblio.setBackground(getDrawable(R.drawable.recip));
        BCalc.setBackground(null);
        BContac.setBackground(null);
        DatosT.setVisibility(View.GONE);
        Tema.setVisibility(View.VISIBLE);
        Tema.setText("Bibliografía");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void ChangeContac(View view){
        Calculo.setVisibility(View.GONE);
        Biblio.setVisibility(View.GONE);
        Contacto.setVisibility(View.VISIBLE);
        BContac.setBackground(getDrawable(R.drawable.recip));
        BBiblio.setBackground(null);
        BCalc.setBackground(null);
        DatosT.setVisibility(View.GONE);
        Tema.setVisibility(View.VISIBLE);
        Tema.setText("Contacto");
    }
}
