package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Button btnaddInput, btnAddition,btnSubtract,btnDivision,btnMultipy,btnClear;
    private LinearLayout LinearLayoutInput;
    private TextView txtResult;

    ArrayList<EditText> arrEditTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        btnaddInput.setOnClickListener(new BtnAddEdTxt());
        btnAddition.setOnClickListener(new btnAdditionListner());
        btnSubtract.setOnClickListener(new btnSubtractListner());
        btnDivision.setOnClickListener(new btnDivisionListener());
        btnMultipy.setOnClickListener(new btnMultiplyListner());
        btnClear.setOnClickListener(new btnClearListner());

    }

    private class BtnAddEdTxt implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            EditText AddEdtTxt=new EditText(MainActivity.this);
            AddEdtTxt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            AddEdtTxt.setTextSize(20);
            AddEdtTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
            LinearLayoutInput.addView(AddEdtTxt);
            arrEditTexts.add(AddEdtTxt);
        }
    }

    private class btnAdditionListner implements View.OnClickListener{
        @Override
        public void onClick(View view){

            int sum=0;
            for (int i=0; i< arrEditTexts.size();i++){

                sum=sum + Integer.parseInt(arrEditTexts.get(i).getText().toString());
        }
            txtResult.setText(sum+"");
    }
}
    private class btnSubtractListner implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int sum= Integer.parseInt(arrEditTexts.get(0).getText().toString());
            for (int i=1; i< arrEditTexts.size(); i++){

                sum= sum - Integer.parseInt(arrEditTexts.get(i).getText().toString());

            }
            txtResult.setText(sum+"");
        }
    }

   private class btnDivisionListener implements View.OnClickListener{

       @Override
       public void onClick(View view) {
           float sum=sum=Float.parseFloat(arrEditTexts.get(0).getText().toString());
           for (int i=1; i< arrEditTexts.size();i++)
           {
               sum=sum /Float.parseFloat(arrEditTexts.get(i).getText().toString());

           }
           txtResult.setText(sum+"");
       }
   }

    private class btnMultiplyListner implements View.OnClickListener{

        @Override
        public void onClick(View view){

            double sum=sum=Double.parseDouble(arrEditTexts.get(0).getText().toString());
            for (int i=1; i<arrEditTexts.size(); i++) {


                sum=sum * Double.parseDouble(arrEditTexts.get(0).getText().toString());

            }

            txtResult.setText(sum+"");
        }
    }

    private class btnClearListner implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            EditText removEdtTxt=new EditText(MainActivity.this);
            for(int i=0; i<arrEditTexts.size();i++){
                LinearLayoutInput.removeView(arrEditTexts.get(i));
            }

            arrEditTexts.clear();
            txtResult.setText("plese Enter Inputs");
        }
    }

    private void init(){
        btnaddInput=findViewById(R.id.btnaddinput);
        btnAddition=findViewById(R.id.btnadd);
        btnDivision=findViewById(R.id.btn_divide);
        btnMultipy=findViewById(R.id.btnmultiply);
        btnSubtract=findViewById(R.id.btnsubtract);
        LinearLayoutInput=findViewById(R.id.containerInputs);
        txtResult=findViewById(R.id.txtResult);
        btnClear=findViewById(R.id.btnClear);


    }
}
