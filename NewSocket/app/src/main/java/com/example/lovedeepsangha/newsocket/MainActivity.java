package com.example.lovedeepsangha.newsocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static TextView textView;
    public static Socket socket;
    public static DataInputStream dataInputStream;

    public static DataOutputStream dataOutputStream;
    public static Button button;
    public static EditText editText;

    public static int a;
    public static String s;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.Send);
        editText = (EditText) findViewById(R.id.MessageBox);
        textView = (TextView) findViewById(R.id.TextArea);





        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {socket = new Socket("192.168.1.3", 1);
                    socket.setKeepAlive(true);
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    while (socket.getKeepAlive()==true) {
                        try {
                            s = dataInputStream.readUTF().toString().trim();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (s.equals("") == false) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setMovementMethod(new ScrollingMovementMethod());
                                    textView.append(s+"\n");
                                    s = "";
                                }
                            });
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (editText.getText().toString().trim().equals("") == false) {
                        dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        textView.setMovementMethod(new ScrollingMovementMethod());
                        textView.append(editText.getText().toString().trim() + "\n");
                        dataOutputStream.writeUTF(editText.getText().toString().trim());
                   editText.setText(""); }


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}