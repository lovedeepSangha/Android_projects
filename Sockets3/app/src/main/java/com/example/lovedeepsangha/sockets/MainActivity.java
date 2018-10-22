package com.example.lovedeepsangha.sockets;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static android.os.StrictMode.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static Button Send;
    private static TextView TextArea;
    private static Socket socket;
    private static EditText MessageBox;

    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;
    private static String InputMessage;
    private static String OutputMessage;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextArea = (TextView) findViewById(R.id.TextArea);
        MessageBox = (EditText) findViewById(R.id.TextField);

        Send = (Button) findViewById(R.id.Send);



        Send.setOnClickListener(MainActivity.this);
/*
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        socket = new Socket("192.168.1.3", 1);
                        socket.setKeepAlive(true);
                        dataInputStream = new DataInputStream(socket.getInputStream());
                        while (socket.getKeepAlive() == true) {
                            InputMessage = dataInputStream.readUTF().toString();
                            if (InputMessage.equals("") == false) {
                                TextArea.setText(InputMessage);
                                InputMessage = "";

                            }
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }

            });
        }*/
     /*   Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

                    ThreadPolicy policy = new ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    processs(MainActivity.this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        thread.start();
    */

    }


    @Override
    public void onClick(View v) {
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            OutputMessage = MessageBox.getText().toString();
            if (OutputMessage.equals("") == false) {
                dataOutputStream.writeUTF(OutputMessage);
                TextArea.setText(OutputMessage.trim() + "");
                OutputMessage = "";
                MessageBox.setText("");


            }
        } catch (Exception e) {
        }
    }

}
