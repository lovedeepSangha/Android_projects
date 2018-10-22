package com.example.lovedeepsangha.filedownload;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
 public Button button;
public TextView textView;
String filedownloadpath="https://www.dropbox.com/s/qlbv3jdihzog1od/2016-03-30%2018.01.29.jpg?dl=0";
String savefilepath="/sdcard/2016-03-30%2018.01.29.jpg";
 ProgressDialog Dialog=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);

        textView=(TextView)findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      Dialog = ProgressDialog.show(MainActivity.this, "", "File is downloaded", true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                    downloadfile(filedownloadpath,savefilepath);
                    }
                });
            }
        });}
        public void downloadfile(String filedownload,String Savefilepath){
            try {
                File savefile = new File(Savefilepath);
                URL url=new URL(filedownload);
                URLConnection con=url.openConnection();
                int lengthofcontent=con.getContentLength();
                DataInputStream dataInputStream=new DataInputStream(url.openStream());
                byte[] buffer=new byte[lengthofcontent];
                dataInputStream.readFully(buffer);
                dataInputStream.close();


                DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream(Savefilepath));
                dataOutputStream.write(buffer);
                dataOutputStream.flush();
                dataOutputStream.close();
hidePogressDialog();
              Toast.makeText(this.getBaseContext(), "ho gia done", Toast.LENGTH_LONG).show();

            }catch(FileNotFoundException exception){hidePogressDialog();}
            catch (IOException e){hidePogressDialog();} catch (Exception e){hidePogressDialog();}
            catch (ExceptionInInitializerError error ){hidePogressDialog();}
        }
    public void hidePogressDialog(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Dialog.dismiss();
            }
        });
    }
        }





