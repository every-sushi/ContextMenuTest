package rlaskfud0515.kr.hs.emirim.contextmenutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button but1,but2;
    ImageView imgV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         but1=(Button)findViewById(R.id.but1);
         but2=(Button)findViewById(R.id.but2);
        linear=(LinearLayout)findViewById(R.id.linear);//이게 있어야 백그라운드 컬러를 바꾸져
        imgV=(ImageView)findViewById(R.id.img1);
        registerForContextMenu(but1);
        registerForContextMenu(but2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        if (v.getId()==R.id.but1){
            menu.setHeaderTitle("배경색 변경");
            //menu.setHeaderIcon(R.drawable.icon1);
            menuInflater.inflate(R.menu.menu1, menu);
        }
        if(v.getId()==R.id.but2)
            menuInflater.inflate(R.menu.menu2, menu);
    }
//메소드 바깥에서 선언된 변수를 필드
    @Override
    public boolean onContextItemSelected(MenuItem item){
        super.onContextItemSelected(item);
        switch(item.getItemId()){
            case R.id.menu1_item_red:
                linear.setBackgroundColor(Color.RED);

                return true;
            case R.id.menu1_item_blue:
                linear.setBackgroundColor(Color.RED);
                return true;

            case R.id.menu1_item_pink:
                linear.setBackgroundColor(Color.rgb(255,0,127));

                return true;

            case R.id.menu2_item_size:
                imgV.setScaleX(imgV.getRotation()+90);
                return true;

            case R.id.menu2_item_rotation:
                imgV.setRotation(imgV.getScaleX()*2);
                return true;

        }

        return false;
    }

}
