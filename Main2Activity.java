package com.example.anik1.projectno2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Main2Activity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        final String key = "anshdyehfnrthgtrdewsas";

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }







    public String encrypt(String seed, String clearText) throws Exception {

        byte[] rawKey = getRawKey(seed);
        byte[] result = encrypt(rawKey, clearText.getBytes());
        String encrypted_message = toHex(result);
        return encrypted_message;
    }

    private byte[] getRawKey(String keyvalue) {
        byte[] key = Base64.decode(keyvalue.getBytes(), 0);
        return key;
    }

    public String toHex(byte[] buffer) {
        if (buffer == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buffer.length);
        for (int i = 0; i < buffer.length; i++) {
            appendHex(result, buffer[i]);
        }
        return result.toString();
    }

    private final String HEX = "0123456789ABCDEF";

    private void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }

    private byte[] encrypt(byte[] raw, byte[] clear) throws NoSuchPaddingException, NoSuchAlgorithmException, Exception {
        SecretKeySpec skeySpace = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpace);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }


    public String decrypt(String seed, String encrypted_message) throws Exception {
        byte[] rawKey = getRawKey(seed);
        byte[] enc = toByte(encrypted_message);
        byte[] result = decrypt(rawKey, enc);
        String decrypted_message = new String(result);
        return decrypted_message;
    }

    private byte[] decrypt(byte[] raw, byte[] enc) throws Exception {
        SecretKeySpec skeySpce = new SecretKeySpec(raw, "AES");
        Cipher ciper = Cipher.getInstance("AES");
        ciper.init(Cipher.DECRYPT_MODE, skeySpce);
        byte[] decrypted = ciper.doFinal(enc);
        return decrypted;
    }

    public byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        return result;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main2 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
