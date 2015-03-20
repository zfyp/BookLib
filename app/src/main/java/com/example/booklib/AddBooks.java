package com.example.booklib;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.BookCURD.BookCURD;
import com.example.SQLiteInit.SQLiteInit_Book;


public class AddBooks extends ActionBarActivity {

    private BookCURD helper_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);

        helper_book=new BookCURD(this);

        Button addBook=(Button)findViewById(R.id.addBook);
        Button updateBook=(Button)findViewById(R.id.updateBook);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etisbn= (EditText) findViewById(R.id.editText);
                EditText etbookname= (EditText) findViewById(R.id.editText2);
                EditText etauther=(EditText)findViewById(R.id.editText3);

                String isbn= String.valueOf(etisbn.getText());
                String bookname=String.valueOf(etbookname.getText());
                String auther=String.valueOf(etauther.getText());

                helper_book.AddBook(isbn,bookname,auther,null,null,0);

            }
        });

        updateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_books, menu);
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
