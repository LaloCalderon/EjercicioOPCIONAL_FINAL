package com.example.ejercicio2cm;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle;
        bundle = getIntent().getExtras();
        int[] array;
        int[] arrayn;
        int aux, auxn, counter;
        array = bundle.getIntArray("arreglo");
        arrayn = bundle.getIntArray("arreglon");

        int dim = bundle.getInt("dim");
        int dimn = bundle.getInt("dimn");
        int[] arrayt = new int[dim];
        int[] arraytn = new int[dimn];
        int[] arraytinv = new int[dimn];

        List<Integer>listallnum=new ArrayList<>();
        for (int a = 0; a < dim; a++) {
            arrayt[a]=array[a];
            listallnum.add(array[a]);
        }

        for (int a = 0; a < dimn; a++) {
            arraytn[a]=array[a];
            listallnum.add(arrayn[a]);
        }

        for(int c=0;c<arrayt.length-1;c++){
            for(int j=1;j<arrayt.length;j++){
                if(arrayt[j-1]>arrayt[j]){
                    aux=arrayt[j-1];
                    arrayt[j-1]=arrayt[j];
                    arrayt[j]=aux;
                }
            }
        }

        for(int c=0;c<arraytn.length-1;c++){
            for(int j=1;j<arraytn.length;j++){
                if(arraytn[j-1]>arraytn[j]){
                    auxn=arraytn[j-1];
                    arraytn[j-1]=arraytn[j];
                    arraytn[j]=auxn;
                }
            }
        }
        /*
        for(int c=2;c<arraytn.length;c++){
            for(int j=0;j<arraytn.length-c;j++){
                if(arraytn[j]>arraytn[j+1]){
                    auxn=arraytn[j];
                    arraytn[j]=arraytn[j+1];
                    arraytn[j+1]=auxn;
                }
            }
        }*/
        int inv;
        for(int d=0;d<arraytn.length;d++){
            inv=arraytn[d]; //Primera variable
            arraytinv[arraytn.length-1-d]=inv;  //
        }
        counter=arrayn.length;
        if(counter==0){
            for (int a = 0; a < dim; a++) {
                Toast.makeText(Main2Activity.this, getResources().getString(R.string.val)+(a+1)+getResources().getString(R.string.next)+arrayt[a], Toast.LENGTH_SHORT).show();
                //Toast.makeText(Main2Activity.this, getResources().getString(R.string.val)+(a+1)+getResources().getString(R.string.next)+arrayt[a], Toast.LENGTH_SHORT).show();
                //Toast.makeText(Main2Activity.this,"Valor"+(a+1)+": "+ arrayt[a], Toast.LENGTH_SHORT).show();
            }
        }else{
        for (int a = 0; a < dimn; a++) {
            Toast.makeText(Main2Activity.this, getResources().getString(R.string.val)+(a+1)+getResources().getString(R.string.next)+arraytinv[a], Toast.LENGTH_SHORT).show();
            //Toast.makeText(Main2Activity.this, "Valor "+(a+1)+": -"+ arraytinv[a], Toast.LENGTH_SHORT).show();
        }
            for (int a = 0; a < dim; a++) {
                Toast.makeText(Main2Activity.this, getResources().getString(R.string.val)+(a+1)+getResources().getString(R.string.next)+arrayt[a], Toast.LENGTH_SHORT).show();
            }
        }
    }
}
