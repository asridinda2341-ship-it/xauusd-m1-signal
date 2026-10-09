package com.example.xauusd;
import android.app.*; import android.os.*; import android.graphics.*; import android.view.*; import android.widget.*; import java.util.*;
public class MainActivity extends Activity {
 TableLayout table; Random r=new Random(); String[] m={"MODEL A","MODEL B","MODEL C","MODEL D","MODEL E"};
 public void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_main);table=findViewById(R.id.table);header();for(int i=0;i<18;i++)row(20,42+i);findViewById(R.id.refresh).setOnClickListener(v->{row(20,60);Toast.makeText(this,"Update simulasi",Toast.LENGTH_SHORT).show();});}
 TextView c(String s,int bg,int fg,boolean bold){TextView t=new TextView(this);t.setText(s);t.setTextColor(fg);t.setTextSize(13);t.setGravity(Gravity.CENTER);t.setPadding(12,12,12,12);t.setTypeface(null,bold?1:0);t.setBackgroundColor(bg);return t;}
 void header(){TableRow x=new TableRow(this);x.addView(c("TIME",Color.WHITE,Color.DKGRAY,true));for(String z:m)x.addView(c(z,Color.WHITE,Color.DKGRAY,true));table.addView(x);}
 void row(int h,int min){TableRow x=new TableRow(this);x.addView(c(String.format("%02d:%02d",h,min),Color.WHITE,Color.DKGRAY,true));for(int i=0;i<5;i++){double p=50+r.nextDouble()*16;boolean up=r.nextBoolean();String s=(up?"UP\n":"DOWN\n")+String.format(Locale.US,"%.1f%%",p);int bg=p>=58?(up?Color.rgb(184,235,205):Color.rgb(244,170,174)):p>=54?(up?Color.rgb(222,245,230):Color.rgb(250,216,218)):Color.WHITE;int fg=up?Color.rgb(32,105,67):Color.rgb(125,35,40);x.addView(c(s,bg,fg,p>=58));}table.addView(x);}
}