package com.vish.vishal.tripmakers;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by vishal on 4/6/2017.
 */

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l){
        Toast.makeText(parent.getContext(),
                " on"+ parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}