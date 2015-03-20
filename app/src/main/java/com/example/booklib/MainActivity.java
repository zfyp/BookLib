package com.example.booklib;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.BookCURD.BookCURD;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    private BookCURD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new BookCURD(this);
        getAllBooks();

        Button addBooks=(Button)findViewById(R.id.addBooks);
        Button findAllBook=(Button)findViewById(R.id.findAllBook);
        Button findOutBook=(Button)findViewById(R.id.findOutBook);
        Button findTodayOut=(Button)findViewById(R.id.findTodayOut);

        addBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddBooks.class);
                startActivity(intent);
            }
        });

        findAllBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewBooks.class);
                startActivity(intent);
            }
        });

        findOutBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findTodayOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void getAllBooks()
    {
        TextView allBookNum=(TextView)findViewById(R.id.allBookNum);
        TextView balanceBookNum=(TextView)findViewById(R.id.balanceBookNum);
        Log.d("书籍总数",helper.sumBooksnum());
        Log.d("书籍剩余",helper.balanceBooknum());

        allBookNum.setText(helper.sumBooksnum());
        balanceBookNum.setText(helper.balanceBooknum());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
