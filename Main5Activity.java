package com.example.anik1.projectno2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class Main5Activity extends AppCompatActivity {
    BigInteger binary_encrypted=null;
    final String key = "fghd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent = getIntent();
        TextView tv = (TextView) findViewById(R.id.textView6);
        tv.setText(intent.getStringExtra("Anik"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button Encrypt = (Button) findViewById(R.id.button8);
        Encrypt.setOnClickListener(new View.OnClickListener()

                                   {
                                       @Override
                                       public void onClick (View view){
                                           try {
                                               TextView tv = (TextView) findViewById(R.id.textView6);
                                               String plainText = tv.getText().toString();
                                               String cipherText = encrypt(key, plainText);
                                               TextView tv2 = (TextView) findViewById(R.id.textView8);
                                               tv2.setText(cipherText);
                                           } catch (Exception e) {
                                               System.out.println(e.getMessage());
                                           }
                                       }
                                   }

        );
        Button Decryption = (Button) findViewById(R.id.button9);
        Decryption.setOnClickListener(new View.OnClickListener()

                                      {
                                          @Override
                                          public void onClick (View view){
                                              try {
                                                  TextView tv = (TextView) findViewById(R.id.textView8);
                                                  String encryptedData = tv.getText().toString();
                                                  String decryptText = decrypt(key, encryptedData);
                                                  TextView tv1 = (TextView) findViewById(R.id.textView10);
                                                  tv1.setText(decryptText);
                                              } catch (Exception ex) {
                                                  System.out.println(ex.getMessage());
                                              }
                                          }
                                      }

        );


    }

    public String encrypt(String seed, String cleartext)throws Exception{

        BigInteger binary_original = new BigInteger(cleartext.getBytes());

        BigInteger binary_key = new BigInteger(seed.getBytes());

        binary_encrypted = binary_original.xor(binary_key);
        System.out.println(binary_encrypted.toString());
        return binary_encrypted.toString(2);
    }

    public String decrypt(String seed, String cleartext)throws Exception{

        BigInteger binary_key = new BigInteger(seed.getBytes());

        BigInteger binary_decrypted = binary_encrypted.xor(binary_key);
        System.out.println("Desimal: "+binary_decrypted.toString());
        System.out.println("Binary: "+binary_decrypted.toString(2));
        String ch = new String(binary_encrypted.toByteArray());

        System.out.println("String: "+ch.substring(0,ch.length()));
        return ch.substring(0,ch.length());
    }

}
