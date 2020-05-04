package com.example.ejercicio2cm;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.Serializable;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etnumber;
    Button boton;
    ImageButton plus, limpiar;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnumber=findViewById(R.id.etnumber);
        plus=findViewById(R.id.plus);
        boton=findViewById(R.id.boton);
        limpiar=findViewById(R.id.limpiar);
        limpiar.setOnClickListener(this);
        plus.setOnClickListener(this);
        boton.setOnClickListener(this);
    }
    int[] array=new int[100];
    int[] arrayn=new int[100];
    int i=0;
    int n=0;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plus:
                if(etnumber.getText().length()>=5)
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.numm) , Toast.LENGTH_SHORT).show();
                else{
                   try{
                        int num= Integer.parseInt(etnumber.getText().toString());
                        String var=String.valueOf(num);

                        if(var.charAt(0)=='-'){
                            String vart=var.substring(1);
                            int ssig=Integer.parseInt(vart);
                            arrayn[n]=ssig;
                            n++;
                            counter++;
                            Toast.makeText(MainActivity.this, getResources().getString(R.string.val)+counter+getResources().getString(R.string.add), Toast.LENGTH_SHORT).show();
                            etnumber.setText("");
                        }else{
                            array[i]=num;
                            i++;
                            counter++;
                            Toast.makeText(MainActivity.this, getResources().getString(R.string.val)+counter+getResources().getString(R.string.add), Toast.LENGTH_SHORT).show();
                            etnumber.setText("");}
                    }catch (Exception e) {
                       Toast.makeText(MainActivity.this, getResources().getString(R.string.badadd), Toast.LENGTH_SHORT).show();
                   }}
                break;
            case R.id.boton:
                if(valida(i)){

                    Bundle bundle=new Bundle();
                    bundle.putIntArray("arreglo",array);
                    bundle.putIntArray("arreglon",arrayn);
                    bundle.putInt("dim",i);
                    bundle.putInt("dimn",n);

                    Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.arrnull), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, "Array vacío", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.limpiar:
                i=0;
                n=0;
                counter=0;

                break;
            default:
                break;
        }}
    private boolean valida(int i) {
        if(i==0){
            return false;
        }else{
            Toast.makeText(MainActivity.this,getResources().getString(R.string.ord), Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}