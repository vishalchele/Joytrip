package com.vish.vishal.tripmakers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.vish.vishal.MainActivity;
import com.vish.vishal.MapsActivity;

public class Main2Activity extends AppCompatActivity {
    public Button b1;
    private Spinner spinner1;
    public EditText editText;

    public void init(){
        b1=(Button) findViewById(R.id.b1);
        editText= (EditText) findViewById(R.id.editText);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nb=null;
                nb= String.valueOf(editText.getText());
                String nb1 = String.valueOf(editText.getText());

                if( nb1.compareTo("1")==0 || nb1.compareTo("2")==0 || nb1.compareTo("3")==0 || nb1.compareTo("4")==0 || nb1.compareTo("5")==0 || nb1.compareTo("6")==0 || nb1.compareTo("7")==0 || nb1.compareTo("8")==0 || nb1.compareTo("9")==0){
                //String a = editText.getText().toString();

                Intent m1 = new Intent(Main2Activity.this, MapsActivity.class);
                // Intent m2=new Intent(Activity2.this,MapsActivity.class);
                m1.putExtra("Result",String.valueOf(spinner1.getSelectedItem()));
                m1.putExtra("Result1",String.valueOf(editText.getText()));
               /* Toast.makeText(getApplicationContext(),
                        " " + "\nspinner 1 :" + String.valueOf(spinner1.getSelectedItem()) + " nn "+ String.valueOf(editText.getText()),
                        Toast.LENGTH_LONG).show();*/

                startActivity(m1);
            }else if(nb==null)
                {
                    Toast.makeText(getApplicationContext(),"Enter Days",Toast.LENGTH_LONG).show();
                }
             else{
                    Toast.makeText(getApplicationContext(),"Enter Valid Days",Toast.LENGTH_LONG).show();
                }
            }
        });
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main2);
        init();

        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }
    public void weblink1(View view) {
        Intent weblinkIntent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(weblinkIntent);
    }


    public void addListenerOnSpinnerItemSelection(){
            spinner1= (Spinner) findViewById(R.id.spinner1);
            spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        }
        public void addListenerOnButton(){
            spinner1= (Spinner) findViewById(R.id.spinner1);
            //spinner2= (Spinner) findViewById(R.id.spinner2);
            b1= (Button) findViewById(R.id.b1);
        }
    }

