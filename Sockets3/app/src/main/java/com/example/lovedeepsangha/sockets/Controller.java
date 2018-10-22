package com.example.lovedeepsangha.sockets;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by Lovedeep sangha on 9/19/2016.
 */
public class Controller {
    private static Button Send;
    private static TextView TextArea;
    private static Socket socket;
    private static EditText MessageBox;

    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;
    private static String InputMessage;
    private static String OutputMessage;
   protected Controller(Bundle savedInstanceState){
       Send = (Button) Send.findViewById(R.id.Send);
   }
}
