package com.vish.vishal;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vish.vishal.tripmakers.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener {

    private Button btnFindPath;
    private EditText etOrigin;
    private EditText etDestination;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    public String origin;
    public String destination;
    public GoogleMap mMap;
    public int flag,yy=1;
    public  int numberOfNodes=0;
    public String result;
    public String result1;
    public int j=0;
    public int a=0;
    public int b1=0;
    public int b2=0;
    public int flag1=1;
    public int result_array[]=new int[10];
    static int mum[][]=null;
   static int pun[][]=null;
   static int shi[][]=null;
    static int vis[][]=null;
     static int beng[][]=null;
    static int del[][]=null;
    static int jai[][]=null;
    static int kol[][]=null;
    static int hyd[][]=null;

    static int goa[][]=null;
    public String goa_name[]={"Calangute Goa","Fort Aguada Goa","Deltin Royale Casino Goa","Chapora Fort Goa","Basilica Of BomJesus Goa","Pandava Caves Goa","Mangeshi Temple Goa","DudhsagarFalls Goa","Ashwem Beach Goa","NavalAviationMeusemGoa"};
    public String mum_name[]={"Gate way of India Mumbai","Elephanta caves Mumbai","Colaba causeway market Mumbai","juhu beach Mumbai","Victoria terminus Mumbai","Film city Mumbai","Haji ali  Mumbai","Banganga tank Mumbai","Marine drive Mumbai","Shri siddhavinayak ganpati temple Mumbai"};
       public String kol_name[]={"Dakshineswar Kolkata","Eden Gardens Kolkata","Victoria Memorial Queens way Kolkata","The Mother House Kolkata","The Howrah Bridge Kolkata","Eco Tourism Kolkata","Science city Kolkata"};
    public String beng_name[]={"Wonderla Amusement Park Banglore","ISKCON Temple Banglore","UB City Banglore","Visvesarya Technical Mueseum Banglore","Art of Living International centre Banglore","Lalbaugh Botonical Garden Banglore","Cubbon Park Banglore","Dodda Ganpati Temple Banglore","M Chinnaswamy Stadium Banglore","Bannerghatta National Park Banglore"};
    public String del_name[]={"Gurudwara Bangla Delhi","Akshardhamm Delhi","Humayum tomb Delhi","Qutub Minar Delhi","Lodi Gardens Delhi","India Gate Delhi","Rashtrapati Bhavan Delhi","Rajpath Delhi","Gandhi Smriti Delhi","Lotus Temple Delhi"};
   public String pun_name[]={"Dagdusheth Ganpati, Pune","darshan museum pune","Malshej Ghat, Pune","Sinhagad Fort, Thoptewadi, Pune","Saras Baug, Pune","Chattushringi, Pune","Pu La Deshpande / Okayama Friendship Garden, Pune","Lonavala Lake, Khondagewadi, Lonavala, Pune","Ranjangaon Ganpati, Pune","Shaniwar Wada Palace, Pune"};
    public String jai_name[]={"Elefantastic Jaipur","Amber fort Amer Jaipur","Sheesh Mahal Jaipur","Jantar Mantar Jaipur","Hawa Mahal Handicrafts Jaipur","Birla Mandir Jaipur","City palace Jaipur","Jaigarh fort Jaipur"};
    public String shi_name[]={"Viceregal Lodge & Botanical Gardens, Boileauganj, Shimla","Jakhu Temple, Jakhu, Shimla","Christ Church Shimla","Annadale, Shimla","Tara Devi Temple, Shimla","Green Valley, Shimla","Kali Bari Temple, Shimla","Scandal Point, The Mall, Shimla","Kufri, Himachal Pradesh","Shimla Heritage Museum"};
   public String hyd_name[]={"Birla Mandir Hyderabad","Ramoji Film City Hyderabad","Chilkur Balaji Temple Hyderabad","Golkonda Fort Hyderabad","Taj Falaknuma Palace Hyderabad","Salar Jung Palace Hyderabad","Shri Jagganath Temple Hyderabad","Char Minar Hyderabad","Buddha Temple Hyderabad","Eddamma temple Hyderabad"};

    public String vis_name[]={"Borra caves visakhapatnam","Simhachalam visakhapatnam","Kailasagiri visakhapatnam","Ramakrishna Beach visakhapatnam","Araku valley visakhapatnam","Dolphins nose light house visakhapatnam"};

    static {

beng = new int[10][];
        for (int i = 0; i < 10; i++)
        { beng[i] = new int[10]; }
shi = new int[10][];
        for (int i = 0; i < 10; i++)
        { shi[i] = new int[10]; }
jai = new int[10][];
        for (int i = 0; i < 10; i++)
        { jai[i] = new int[10]; }
kol = new int[10][];
        for (int i = 0; i < 10; i++)
        { kol[i] = new int[10]; }
pun = new int[10][];
        for (int i = 0; i < 10; i++)
        { pun[i] = new int[10]; }
hyd= new int[10][];
        for (int i = 0; i < 10; i++)
        { hyd[i] = new int[10]; }
del= new int[10][];
        for (int i = 0; i < 10; i++)
        { del[i] = new int[10]; }
 vis = new int[10][];
        for (int i = 0; i < 10; i++)
        { vis[i] = new int[10]; }

        goa = new int[10][];
        for (int i = 0; i < 10; i++)
        { goa[i] = new int[10]; }
        mum = new int[10][];
        for (int i = 0; i < 10; i++)
        { mum[i] = new int[10]; }

        goa[0][0] =0;
        goa[1][1] =0;
        goa[2][2] =0;
        goa[3][3] = 0;
        goa[4][4]=0;
        goa[5][5]=0;
        goa[6][6]=0;
        goa[7][7]=0;
        goa[8][8]=0;
        goa[9][9]=0;
       // goa[10][10]=0;

        goa[0][1] =goa[1][0]=7;
        goa[0][2] =goa[2][0]=14;
        goa[0][3] =goa[3][0]=10;
        goa[0][4] = goa[4][0]=23;
        goa[0][5] = goa[5][0]=47;
        goa[0][6] = goa[6][0]=32;
        goa[0][7] =goa[7][0]=83;
        goa[0][8] = goa[8][0]=21;
        goa[0][9] = goa[9][0]=38;
        goa[1][2] = goa[2][1]=11;
        goa[1][3] =goa[3][1]=17;
        goa[1][4] = goa[4][1]=24;
        goa[1][5] = goa[5][1]=48;
        goa[1][6] = goa[6][1]=34;
        goa[1][7] = goa[7][1]=84;
        goa[1][8] = goa[8][1]=27;
        goa[1][9] = goa[9][1]=40;
        goa[2][3] = goa[3][2]=20;
        goa[2][4] = goa[4][2]=13;
        goa[2][5] = goa[5][2]=30;
        goa[2][6] = goa[6][2]=22;
        goa[2][7] = goa[7][2]=72;
        goa[2][8] = goa[8][9]=29;
        goa[2][9] = goa[9][2]=27;
        goa[3][4] = goa[4][3]=28;
        goa[3][5] = goa[5][3]=53;
        goa[3][6] = goa[6][3]=39;
        goa[3][7] = goa[7][3]=89;
        goa[3][8] = goa[8][3]=15;
        goa[3][9] = goa[9][3]=45;

        goa[4][5] = goa[5][4]=33;
        goa[4][6] = goa[6][4]=11;
        goa[4][7] = goa[7][4]=61;
        goa[4][8] = goa[8][4]=30;
        goa[4][9] = goa[9][4]=25;

        goa[5][6] = goa[6][5]=26;
        goa[5][7] = goa[7][5]=49;
        goa[5][8] = goa[8][5]=62;
        goa[5][9] = goa[9][5]=26;
        goa[6][7] = goa[7][6]=50;
        goa[6][8] = goa[8][6]=48;
        goa[6][9] = goa[9][6]=34;
        goa[7][8] = goa[8][7]=94;
        goa[7][9] = goa[9][7]=70;
        goa[8][9] = goa[9][8]=54;

        beng[0][0] =0;
        beng[1][1] =0;
        beng[2][2] =0;
        beng[3][3] = 0;
        beng[4][4]=0;
        beng[5][5]=0;
        beng[6][6]=0;
        beng[7][7]=0;
        beng[8][8]=0;
        beng[9][9]=0;
        // beng[10][10]=0;

        beng[0][1] =beng[1][0]=40;
        beng[0][2] =beng[2][0]=29;
        beng[0][3] =beng[3][0]=29;
        beng[0][4] = beng[4][0]=26;
        beng[0][5] = beng[5][0]=30;
        beng[0][6] = beng[6][0]=29;
        beng[0][7] =beng[7][0]=30;
        beng[0][8] = beng[8][0]=29;
        beng[0][9] = beng[9][0]=33;
        beng[1][2] = beng[2][1]=5;
        beng[1][3] =beng[3][1]=6;
        beng[1][4] = beng[4][1]=28;
        beng[1][5] = beng[5][1]=9;
        beng[1][6] = beng[6][1]=4;
        beng[1][7] = beng[7][1]=7;
        beng[1][8] = beng[8][1]=5;
        beng[1][9] = beng[9][1]=36;
        beng[2][3] = beng[3][2]=1;
        beng[2][4] = beng[4][2]=27;
        beng[2][5] = beng[5][2]=4;
        beng[2][6] = beng[6][2]=1;
        beng[2][7] = beng[7][2]=6;
        beng[2][8] = beng[8][9]=1;
        beng[2][9] = beng[9][2]=21;
        beng[3][4] = beng[4][3]=28;
        beng[3][5] = beng[5][3]=4;
        beng[3][6] = beng[6][3]=1;
        beng[3][7] = beng[7][3]=7;
        beng[3][8] = beng[8][3]=1;
        beng[3][9] = beng[9][3]=37;

        beng[4][5] = beng[5][4]=27;
        beng[4][6] = beng[6][4]=26;
        beng[4][7] = beng[7][4]=18;
        beng[4][8] = beng[8][4]=27;
        beng[4][9] = beng[9][4]=17;

        beng[5][6] = beng[6][5]=2;
        beng[5][7] = beng[7][5]=3;
        beng[5][8] = beng[8][5]=5;
        beng[5][9] = beng[9][5]=35;
        beng[6][7] = beng[7][6]=4;
        beng[6][8] = beng[8][6]=1;
        beng[6][9] = beng[9][6]=33;
        beng[7][8] = beng[8][7]=7;
        beng[7][9] = beng[9][7]=20;
        beng[8][9] = beng[9][8]=23;












        del[0][0] =0;
        del[1][1] =0;
        del[2][2] =0;
        del[3][3] = 0;
        del[4][4]=0;
        del[5][5]=0;
        del[6][6]=0;
        del[7][7]=0;
        del[8][8]=0;
        del[9][9]=0;
       // del[10][10]=0;

        del[0][1] =del[1][0]=17;
        del[0][2] =del[2][0]=7;
        del[0][3] =del[3][0]=14;
        del[0][4] = del[4][0]=7;
        del[0][5] = del[5][0]=5;
        del[0][6] = del[6][0]=3;
        del[0][7] =del[7][0]=2;
        del[0][8] = del[8][0]=6;
        del[0][9] = del[9][0]=14;
        del[1][2] = del[2][1]=9;
        del[1][3] =del[3][1]=18;
        del[1][4] = del[4][1]=10;
        del[1][5] = del[5][1]=7;
        del[1][6] = del[6][1]=10;
        del[1][7] = del[7][1]=9;
        del[1][8] = del[8][1]=6;
        del[1][9] = del[9][1]=16;
        del[2][3] = del[3][2]=11;
        del[2][4] = del[4][2]=3;
        del[2][5] = del[5][2]=3;
        del[2][6] = del[6][2]=6;
        del[2][7] = del[7][2]=5;
        del[2][8] = del[8][9]=4;
        del[2][9] = del[9][2]=8;
        del[3][4] = del[4][3]=9;
        del[3][5] = del[5][3]=12;
        del[3][6] = del[6][3]=11;
        del[3][7] = del[7][3]=11;
        del[3][8] = del[8][3]=10;
        del[3][9] = del[9][3]=9;

        del[4][5] = del[5][4]=3;
        del[4][6] = del[6][4]=4;
        del[4][7] = del[7][4]=3;
        del[4][8] = del[8][4]=2;
        del[4][9] = del[9][4]=10;

        del[5][6] = del[6][5]=4;
        del[5][7] = del[7][5]=3;
        del[5][8] = del[8][5]=8;
        del[5][9] = del[9][5]=10;
        del[6][7] = del[7][6]=1;
        del[6][8] = del[8][6]=2;
        del[6][9] = del[9][6]=13;
        del[7][8] = del[8][7]=2;
        del[7][9] = del[9][7]=13;
        del[8][9] = del[9][8]=11;


        hyd[0][0] =0;
        hyd[1][1] =0;
        hyd[2][2] =0;
        hyd[3][3] = 0;
        hyd[4][4]=0;
        hyd[5][5]=0;
        hyd[6][6]=0;
        hyd[7][7]=0;
        hyd[8][8]=0;
        hyd[9][9]=0;
       // hyd[10][10]=0;

        hyd[0][1] =hyd[1][0]=28;
        hyd[0][2] =hyd[2][0]=27;
        hyd[0][3] =hyd[3][0]=10;
        hyd[0][4] = hyd[4][0]=11;
        hyd[0][5] = hyd[5][0]=5;
        hyd[0][6] = hyd[6][0]=7;
        hyd[0][7] =hyd[7][0]=6;
        hyd[0][8] = hyd[8][0]=9;
        hyd[0][9] = hyd[9][0]=24;
        hyd[1][2] = hyd[2][1]=50;
        hyd[1][3] =hyd[3][1]=65;
        hyd[1][4] = hyd[4][1]=26;
        hyd[1][5] = hyd[5][1]=25;
        hyd[1][6] = hyd[6][1]=7;
        hyd[1][7] = hyd[7][1]=24;
        hyd[1][8] = hyd[8][1]=60;
        hyd[1][9] = hyd[9][1]=24;
        hyd[2][3] = hyd[3][2]=20;
        hyd[2][4] = hyd[4][2]=30;
        hyd[2][5] = hyd[5][2]=27;
        hyd[2][6] = hyd[6][2]=25;
        hyd[2][7] = hyd[7][2]=23;
        hyd[2][8] = hyd[8][9]=32;
        hyd[2][9] = hyd[9][2]=37;
        hyd[3][4] = hyd[4][3]=15;
        hyd[3][5] = hyd[5][3]=11;
        hyd[3][6] = hyd[6][3]=7;
        hyd[3][7] = hyd[7][3]=11;
        hyd[3][8] = hyd[8][3]=18;
        hyd[3][9] = hyd[9][3]=13;

        hyd[4][5] = hyd[5][4]=6;
        hyd[4][6] = hyd[6][4]=16;
        hyd[4][7] = hyd[7][4]=4;
        hyd[4][8] = hyd[8][4]=19;
        hyd[4][9] = hyd[9][4]=15;

        hyd[5][6] = hyd[6][5]=11;
        hyd[5][7] = hyd[7][5]=1;
        hyd[5][8] = hyd[8][5]=13;
        hyd[5][9] = hyd[9][5]=19;
        hyd[6][7] = hyd[7][6]=10;
        goa[6][8] = hyd[8][6]=15;
        hyd[6][9] = hyd[9][6]=16;
        hyd[7][8] = hyd[8][7]=15;
        hyd[7][9] = hyd[9][7]=17;
        hyd[8][9] = hyd[9][8]=32;


        pun[0][0] =0;
        pun[1][1] =0;
        pun[2][2] =0;
        pun[3][3] = 0;
        pun[4][4]=0;
        pun[5][5]=0;
        pun[6][6]=0;
        pun[7][7]=0;
        pun[8][8]=0;
        pun[9][9]=0;
       // [10][10]=0;

        pun[0][1] =pun[1][0]=4;
        pun[0][2] =pun[2][0]=119 ;
        pun[0][3] =pun[3][0]=34;
         pun[0][4] = pun[4][0]=2;
         pun[0][5] = pun[5][0]=5;
         pun[0][6] = pun[6][0]=4;
         pun[0][7] =pun[7][0]=67;
         pun[0][8] = pun[8][0]=54;
         pun[0][9] = pun[9][0]=1;
         pun[1][2] = pun[2][1]=121;
         pun[1][3] =pun[3][1]=37;
         pun[1][4] = pun[4][1]=55;
        pun[1][5] = pun[5][1]=6;
        pun[1][6] = pun[6][1]=8;
        pun[1][7] = pun[7][1]=69;
        pun[1][8] = pun[8][1]=50;
        pun[1][9] = pun[9][1]=3;
        pun[2][3] = pun[3][2]=103;
        pun[2][4] = pun[4][2]=122;
        pun[2][5] = pun[5][2]=118;
        pun[2][6] = pun[6][2]=123;
        pun[2][7] = pun[7][2]=140;
        pun[2][8] =pun[8][9]=110;
        pun[2][9] = pun[9][2]=119;
        pun[3][4] = pun[4][3]=28;
        pun[3][5] = pun[5][3]=31;
        pun[3][6] = pun[6][3]=25;
        pun[3][7] = pun[7][3]=99;
        pun[3][8] = pun[8][3]=86;
        pun[3][9] = pun[9][3]=30;

         pun[4][5] =  pun[5][4]=6;
         pun[4][6] =  pun[6][4]=3;
         pun[4][7] =  pun[7][4]=69;
         pun[4][8] =  pun[8][4]=55;
         pun[4][9] =  pun[9][4]=2;

        pun[5][6] = pun[6][5]=6;
        pun[5][7] = pun[7][5]=62;
        pun[5][8] = pun[8][5]=58;
        pun[5][9] = pun[9][5]=4;
        pun[6][7] = pun[7][6]=73;
        pun[6][8] = pun[8][6]=58;
        pun[6][9] = pun[9][6]=5;
        pun[7][8] = pun[8][7]=102;
        pun[7][9] = pun[9][7]=67;
        pun[8][9] = pun[9][8]=55;


        shi[0][0] =0;
        shi[1][1] =0;
        shi[2][2] =0;
        shi[3][3] = 0;
        shi[4][4]=0;
        shi[5][5]=0;
        shi[6][6]=0;
        shi[7][7]=0;
        shi[8][8]=0;
        shi[9][9]=0;
       // shi[10][10]=0;

        shi[0][1] =shi[1][0]=10;
        shi[0][2] =shi[2][0]=11;
       shi[0][3] =shi[3][0]=4;
        shi[0][4] = shi[4][0]=5;
        shi[0][5] = shi[5][0]=11;
        shi[0][6] = shi[6][0]=3;
        shi[0][7] =shi[7][0]=4;
        shi[0][8] = shi[8][0]=18;
        shi[0][9] = shi[9][0]=11;
        shi[1][2] = shi[2][1]=1;
        shi[1][3] =shi[3][1]=8;
        shi[1][4] = shi[4][1]=12;
        shi[1][5] = shi[5][1]=5;
        shi[1][6] = shi[6][1]=6;
        shi[1][7] = shi[7][1]=8;
        shi[1][8] = shi[8][1]=13;
        shi[1][9] = shi[9][1]=1;
        shi[2][3] = shi[3][2]=9;
        shi[2][4] = shi[4][2]=13;
        shi[2][5] = shi[5][2]=7;
        shi[2][6] = shi[6][2]=7;
        shi[2][7] = shi[7][2]=1;
        shi[2][8] =shi[8][9]=14;
        shi[2][9] = shi[9][2]=1;
        shi[3][4] = shi[4][3]=8;
        shi[3][5] = shi[5][3]=9;
        shi[3][6] = shi[6][3]=2;
        shi[3][7] = shi[7][3]=4;
        shi[3][8] = shi[8][3]=16;
        shi[3][9] = shi[9][3]=9;

        shi[4][5] = shi[5][4]=13;
        shi[4][6] = shi[6][4]=7;
        shi[4][7] = shi[7][4]=7;
        shi[4][8] = shi[8][4]=21;
        shi[4][9] = shi[9][4]=4;

        shi[5][6] = shi[6][5]=7;
        shi[5][7] = shi[7][5]=8;
        shi[5][8] = shi[8][5]=11;
        shi[5][9] = shi[9][5]=7;
        shi[6][7] = shi[7][6]=1;
        shi[6][8] = shi[8][6]=15;
        shi[6][9] = shi[9][6]=8;
        shi[7][8] = shi[8][7]=17;
        shi[7][9] = shi[9][7]=1;
        shi[8][9] = shi[9][8]=14;


        mum[0][0] =0;
        mum[1][1] =0;
        mum[2][2] =0;
        mum[3][3] = 0;
        mum[4][4]=0;
        mum[5][5]=0;
        mum[6][6]=0;
        mum[7][7]=0;
        mum[8][8]=0;
        mum[9][9]=0;
        // shi[10][10]=0;

        mum[0][1] =mum[1][0]=170;
        mum[0][2] =mum[2][0]=1;
        mum[0][3] =mum[3][0]=30;
        mum[0][4] = mum[4][0]=20;
        mum[0][5] = mum[5][0]=37;
        mum[0][6] = mum[6][0]=8;
        mum[0][7] =mum[7][0]=8;
        mum[0][8] = mum[8][0]=3;
        mum[0][9] = mum[9][0]=12;
        mum[1][2] = mum[2][1]=1;
        mum[1][3] =mum[3][1]=28;
        mum[1][4] = mum[4][1]=19;
        mum[1][5] = mum[5][1]=36;
        mum[1][6] = mum[6][1]=7;
        mum[1][7] = mum[7][1]=7;
        mum[1][8] = mum[8][1]=3;
        mum[1][9] = mum[9][1]=12;
        mum[2][3] = mum[3][2]=30;
        mum[2][4] = mum[4][2]=19;
        mum[2][5] = mum[5][2]=37;
        mum[2][6] = mum[6][2]=8;
        mum[2][7] = mum[7][2]=8;
        mum[2][8] =mum[8][9]=3;
        mum[2][9] = mum[9][2]=13;
        mum[3][4] = mum[4][3]=11;
        mum[3][5] = mum[5][3]=15;
        mum[3][6] = mum[6][3]=21;
        mum[3][7] = mum[7][3]=26;
        mum[3][8] = mum[8][3]=29;
        mum[3][9] = mum[9][3]=14;

        mum[4][5] = mum[5][4]=19;
        mum[4][6] = mum[6][4]=18;
        mum[4][7] = mum[7][4]=24;
        mum[4][8] = mum[8][4]=25;
        mum[4][9] = mum[9][4]=12;

        mum[5][6] = mum[6][5]=31;
        mum[5][7] = mum[7][5]=35;
        mum[5][8] = mum[8][5]=35;
        mum[5][9] = mum[9][5]=24;
        mum[6][7] = mum[7][6]=5;
        mum[6][8] = mum[8][6]=6;
        mum[6][9] = mum[9][6]=6;
        mum[7][8] = mum[8][7]=5;
        mum[7][9] = mum[9][7]=11;
        mum[8][9] = mum[9][8]=11;

        jai[0][0] =0;
        jai[1][1] =0;
        jai[2][2] =0;
        jai[3][3] =0;
        jai[4][4]=0;
        jai[5][5]=0;
        jai[6][6]=0;
        jai[7][7]=0;


        jai[0][1] =jai[1][0]=9;
        jai[0][2] =jai[2][0]=9;
        jai[0][3] =jai[3][0]=1;
        jai[0][4] = jai[4][0]=1;
        jai[0][5] = jai[5][0]=4;
        jai[0][6] = jai[6][0]=1;
        jai[0][7] = jai[7][0]=11;
        jai[1][2] = jai[2][1]=1;
        jai[1][3] =jai[3][1]=8;
        jai[1][4] = jai[4][1]=8;
        jai[1][5] = jai[5][1]=12;
        jai[1][6] = jai[6][1]=9;
        jai[1][7] = jai[7][1]=7;
        jai[2][3] = jai[3][2]=10;
        jai[2][4] = jai[4][2]=8;
        jai[2][5] = jai[5][2]=13;
        jai[2][6] = jai[6][2]=9;
        jai[2][7] = jai[7][2]=8;
        jai[3][4] = jai[4][3]=1;
        jai[3][5] = jai[5][3]=4;
        jai[3][6] = jai[6][3]=1;
        jai[3][7] = jai[7][3]=10;


        jai[4][5] = jai[5][4]=4;
        jai[4][6] = jai[6][4]=1;
        jai[4][7] = jai[7][4]=10;


        jai[5][6] = jai[6][5]=5;
        jai[5][7] = jai[7][5]=15;

        jai[6][7] = jai[7][6]=10;


           kol[0][0] =0;
            kol[1][1] =0;
            kol[2][2] =0;
            kol[3][3] =0;
            kol[4][4]=0;
            kol[5][5]=0;
            kol[6][6]=0;



            kol[0][1] =kol[1][0]=14;
            kol[0][2] =kol[2][0]=15;
            kol[0][3] =kol[3][0]=13;
            kol[0][4] = kol[4][0]=12;
            kol[0][5] = kol[5][0]=16;
            kol[0][6] = kol[6][0]=17;

            kol[1][2] = kol[2][1]=4;
            kol[1][3] =kol[3][1]=7;
            kol[1][4] = kol[4][1]=2;
            kol[1][5] = kol[5][1]=19;
            kol[1][6] = kol[6][1]=12;

            kol[2][3] = kol[3][2]=3;
            kol[2][4] = kol[4][2]=6;
            kol[2][5] = kol[5][2]=20;
            kol[2][6] = kol[6][2]=8;

            kol[3][4] = kol[4][3]=5;
            kol[3][5] = kol[5][3]=18;
            kol[3][6] = kol[6][3]=9;



            kol[4][5] = kol[5][4]=18;
            kol[4][6] = kol[6][4]=11;



        kol[5][6] = kol[6][5]=15;



  vis[0][0] =0;
            vis[1][1] =0;
            vis[2][2] =0;
            vis[3][3] =0;
            vis[4][4]=0;
            vis[5][5]=0;




            vis[0][1] =vis[1][0]=78;
            vis[0][2] =vis[2][0]=88;
            vis[0][3] =vis[3][0]=87;
            vis[0][4] = vis[4][0]=31;
            vis[0][5] = vis[5][0]=95;


            vis[1][2] = vis[2][1]=19;
            vis[1][3] =vis[3][1]=21;
            vis[1][4] = vis[4][1]=108;
            vis[1][5] = vis[5][1]=31;


            vis[2][3] = vis[3][2]=9;
            vis[2][4] = vis[4][2]=118;
            vis[2][5] = vis[5][2]=29;


           vis[3][4] = vis[4][3]=117;
           vis[3][5] = vis[5][3]=16;




            vis[4][5] = vis[5][4]=125;





    }


    Stack stack=new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment3);
        mapFragment.getMapAsync(this);

        btnFindPath = (Button) findViewById(R.id.btnFindPath);
        etOrigin = (EditText) findViewById(R.id.etOrigin);
        etDestination = (EditText) findViewById(R.id.etDestination);

        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1=0;
                // while(i<4) {
                sendRequest1();

            }
        });


    }
    public void weblink(View view){
        Intent weblinkIntent=new Intent(MapsActivity.this,MainActivity.class);
        startActivity(weblinkIntent);

    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            result=extras.getString("Result");
            result1=extras.getString("Result1");
        }

         if (result.equals("Visakhapatnam") ) {
            // v1=extras.getString("getcity");
            flag=3;

            tsp();
            sendRequest();
        }
         if (result.equals("Bengaluru") ) {
            // v1=extras.getString("getcity");
            flag=4;

            tsp();
            sendRequest();
        }
         if (result.equals("Kolkata") ) {
            // v1=extras.getString("getcity");
            flag=5;

            tsp();
            sendRequest();
        }
         if (result.equals("Shimla") ) {
            // v1=extras.getString("getcity");
            flag=6;

            tsp();
            sendRequest();
        }
         if (result.equals("Pune") ) {
            // v1=extras.getString("getcity");
            flag=7;

            tsp();
            sendRequest();
        }
         if (result.equals("Jaipur") ) {
            // v1=extras.getString("getcity");
            flag=8;

            tsp();
            sendRequest();
        }
         if (result.equals("Hyderabad") ) {
            // v1=extras.getString("getcity");
            flag=9;

            tsp();
            sendRequest();
        }
         if (result.equals("Delhi") ) {
            // v1=extras.getString("getcity");
            flag=10;

            tsp();
            sendRequest();
        }

        if (result.equals("Mumbai") ) {
            // v1=extras.getString("getcity");
            flag=1;

            tsp();
            sendRequest();
        }

        else if (result.equals("Goa")) {
            flag=2;
     /*       LatLng vasco = new LatLng(15.386286, 73.843893);
            mMap.addMarker(new MarkerOptions().position(vasco).title("Marker in vasco 2"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vasco,9));

            LatLng calangute = new LatLng(15.530955, 73.763069);
            mMap.addMarker(new MarkerOptions().position(calangute).title("Marker in calungute 0"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(calangute));


            LatLng margoa = new LatLng(15.283216, 73.988057);
            mMap.addMarker(new MarkerOptions().position(margoa).title("Marker in margoa 1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(margoa));

            LatLng anjuna = new LatLng(15.581567, 73.743750);
            mMap.addMarker(new MarkerOptions().position(anjuna).title("Marker in anjuna 3"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(anjuna));
*/
            tsp();
            sendRequest();
        }


    }

    public void tsp(){


        if(result1.equals("1")){
            numberOfNodes = 2;
        }
        else  if(result1.equals("2")){
            numberOfNodes = 4;
        }
       else if(result1.equals("3")){
            numberOfNodes = 6;
        }
        else{
            numberOfNodes = 9;
        }

        int[] visited = new int[numberOfNodes + 1];
        visited[0] = 1;
        stack.push(0);
        int element, dst = 0, i;
        int min;
        boolean minFlag = false;
       // Toast.makeText(getApplicationContext()," "+0 ,Toast.LENGTH_LONG).show();

        while (!stack.isEmpty())
        {
            element = (int) stack.peek();
            i = 0;
            min = Integer.MAX_VALUE;
            if(flag==1)
            {
                while (i <= numberOfNodes)
                {
                    if (mum[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > mum[element][i])
                        {
                            min = mum[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }}

             if(flag==6)
            {
                while (i <= numberOfNodes)
                {
                    if (shi[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > shi[element][i])
                        {
                            min = shi[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }
             if(flag==5)
            {
                while (i <= numberOfNodes)
                {
                    if (kol[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > kol[element][i])
                        {
                            min = kol[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }
             if(flag==8)
            {
                while (i <= numberOfNodes)
                {
                    if (jai[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > jai[element][i])
                        {
                            min = jai[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }
             if(flag==10)
            {
                while (i <= numberOfNodes)
                {
                    if (del[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > del[element][i])
                        {
                            min = del[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }
             if(flag==9)
            {
                while (i <= numberOfNodes)
                {
                    if (hyd[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > hyd[element][i])
                        {
                            min = hyd[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }
             if(flag==7)
            {
                while (i <= numberOfNodes)
                {
                    if (pun[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > pun[element][i])
                        {
                            min = pun[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }
             if(flag==4)
            {
                while (i <= numberOfNodes)
                {
                    if (beng[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > beng[element][i])
                        {
                            min = beng[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }
             if(flag==3)
            {
                while (i <= numberOfNodes)
                {
                    if (vis[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > vis[element][i])
                        {
                            min = vis[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }

            if(flag==2)
            {
                while (i <= numberOfNodes)
                {
                    if (goa[element][i] > 1 && visited[i] == 0)
                    {
                        if (min > goa[element][i])
                        {
                            min = goa[element][i];
                            dst = i;

                            minFlag = true;
                        }
                    }
                    i++;
                }
            }

            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);

               // Toast.makeText(getApplicationContext(), " "+dst,Toast.LENGTH_LONG).show();
                result_array[j]=dst;
                j++;
                minFlag = false;
                continue;

            }
            stack.pop();
        }
    }

    private void sendRequest1(){
        String origin = etOrigin.getText().toString();
         String destination = etDestination.getText().toString();
        if (origin.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {

            new DirectionFinder(this, origin, destination).execute();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }




    private void sendRequest() {

        for(a=0;a<numberOfNodes;a++) {
            b1 = result_array[a];
            b2 = result_array[a + 1];

            if (flag == 2) {
                origin = goa_name[b1];
                destination = goa_name[b2];

            }

            else if (flag == 9) {
                origin = hyd_name[b1];
                destination = hyd_name[b2];

            }

            else if (flag == 10) {
                origin = del_name[b1];
                destination = del_name[b2];

            }

            else if (flag == 8) {
                origin = jai_name[b1];
                destination = jai_name[b2];

            }

            else if (flag == 7) {
                origin = pun_name[b1];
                destination = pun_name[b2];

            }

            else if (flag == 6) {
                origin = shi_name[b1];
                destination = shi_name[b2];

            }

            else if (flag == 5) {
                origin = kol_name[b1];
                destination = kol_name[b2];

            }

            else if (flag == 4) {
                origin = beng_name[b1];
                destination = beng_name[b2];

            }

            else if (flag == 3) {
                origin = vis_name[b1];
                destination = vis_name[b2];

            }

            else if (flag == 1) {
                origin = mum_name[b1];
                destination = mum_name[b2];

            }



            try {


                new DirectionFinder(this, origin, destination).execute();
                //yy++;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }


    }




@Override
public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Please wait.",
                "Finding direction..!", true);
        progressDialog.dismiss();

    }



@Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 11));
            if(flag1==0) {
                ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
                ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);
            }


            if(yy==1){
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.a))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.b))
                        .title(route.endAddress)
                        .position(route.endLocation)));
                //yy++;


            }


             if(yy==2) {
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.b))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.nc))
                        .title(route.endAddress)
                        .position(route.endLocation)));
//yy++;


            }

             if(yy==3) {
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.nc))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.df))
                        .title(route.endAddress)
                        .position(route.endLocation)));

//yy++;

            }

             if(yy==4) {
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.df))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ef))
                        .title(route.endAddress)
                        .position(route.endLocation)));
//yy++;

            }

             if(yy==5) {
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ef))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fg))
                        .title(route.endAddress)
                        .position(route.endLocation)));

//yy++;

            }

             if(yy==6) {
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fg))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ga))
                        .title(route.endAddress)
                        .position(route.endLocation)));
//yy++;
            }
             if(yy==7) {
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ga))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.hg))
                        .title(route.endAddress)
                        .position(route.endLocation)));
//yy++;

            }
             if(yy==8) {
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.hg))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.i))
                        .title(route.endAddress)
                        .position(route.endLocation)));
//yy++;

            }
             if(yy==9) {
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.i))
                        .title(route.startAddress)
                        .position(route.startLocation)));
                destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.j))
                        .title(route.endAddress)
                        .position(route.endLocation)));
//yy++;

            }
            yy++;
            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));

        }

    }

}
