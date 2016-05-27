package com.example.x09_dialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    
    public void click1(View v){
    	//�½�һ���Ի���Ĵ�����
    	AlertDialog.Builder builder = new Builder(this);
    	
    	builder.setIcon(android.R.drawable.arrow_down_float);
    	builder.setTitle("ɾ������");
    	builder.setMessage("�Ƿ�ȷ��������ݣ��ò��������棬���ܻᵼ�¸�Ӧ�ö�ȡ���ݷ����쳣");
    	//����ȷ����ť
    	builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "ɾ�����ݳɹ�", Toast.LENGTH_SHORT).show();
			}
		});
    	//����ȡ����ť
    	builder.setNegativeButton("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "ȡ��ɾ������", Toast.LENGTH_SHORT).show();
			}
		});
    	
    	//���������ɶԻ���
    	AlertDialog ad = builder.create();
    	ad.show();
    	
    	
    }
    
    
    public void click2(View v){
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setIcon(android.R.drawable.arrow_down_float);
    	builder.setTitle("ѡ���Ա�");
    	
    	final String[] items = new String[]{
    			"��",
    			"Ů"
    	};
    	
    	//���õ�ѡѡ����                                                     //ѡ��      //Ĭ��ѡ��      //ѡ������¼�
    	builder.setSingleChoiceItems(items, -1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "��ѡ���ˣ�" + items[which], Toast.LENGTH_SHORT).show();
				//ʹ�Ի�����ʧ
				dialog.dismiss();
			}
		});
    	
    	builder.show();
    }
    
    
    public void click3(View v){
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setIcon(android.R.drawable.arrow_down_float);
    	builder.setTitle("ѡ�������ĳ��У�");
    	
    	final String[] items = new String[]{
    		"����",
    		"�Ϻ�",
    		"����",
    		"֣��"
    	};
    	
    	final boolean[] checkedItems = new boolean[]{
    			true,
    			false,
    			true,
    			false
    	};
    	
    	builder.setMultiChoiceItems(items, checkedItems,new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// ʹcheckedItems�����Ӧ���ֵ
				checkedItems[which] = isChecked;
			}
		});
    	
    	builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String text = "";
				for(int i=0;i<items.length;i++){
					text += checkedItems[i] ? items[i] +"," : "" ;
				}
				if("".equals(text)){
					text = "��û��ѡ���κγ���";
				}
				Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
			}
		});
    	
    	builder.show();
    }
    
    
    
    
    
    
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
