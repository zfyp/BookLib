package com.example.BookCURD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.SQLiteInit.SQLiteInit_Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015-3-20.
 */
public class BookCURD {
    private SQLiteInit_Book helper;

    public BookCURD(Context context) {
        helper=new SQLiteInit_Book(context);
    }

    /**
     * 实现了书籍的添加功能
     * @param isbn ISBN号码
     * @param bookName 书籍名
     * @param auther 作者
     * @param inDay 入库时间
     * @param outDay 出库时间
     * @param status 默认为0,未借出,1 借出,2 入库中
     */
    public void AddBook(String isbn,String bookName,String auther,String inDay,String outDay,int status)
    {
        status=0;
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into books VALUES (null,?,?,?,?,?,?)",new Object[]{isbn,bookName,auther,inDay,outDay,status});
        db.close();
    }

    /**
     * 删除书籍
     * @param id
     */
    public void DelBook(int id)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("DELETE from "+SQLiteInit_Book.TABLENAME+" where id=?",new Object[]{id});
    }

    /**
     * 获取所有书籍数量
     * @return 返回所有书籍数量
     */
    public String sumBooksnum()
    {
        String num=null;
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select count(id) from "+SQLiteInit_Book.TABLENAME,null);
        if(cursor.moveToNext())
        {
             num=cursor.getString(0);
        }
        return num;
    }

    /**
     * 查询剩余图书数量
     * @return 返回剩余图书数量
     */
    public String balanceBooknum()
    {
        String num=null;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select count(id) from "+SQLiteInit_Book.TABLENAME+" where status=0",null);
        if (cursor.moveToNext())
        {
            num=cursor.getString(0);
        }
        return num;
    }

    public List<BookField> allBooks()
    {
        List<BookField> bookFields=new ArrayList<BookField>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor=db.query("books",null,null,null,null,null,null);
        while(cursor.moveToNext())
        {
            String id=cursor.getString(0);
            String isbn=cursor.getString(1);
            String bookName=cursor.getString(2);
            String auther=cursor.getString(3);
            String inDay=cursor.getString(4);
            String outDay=cursor.getString(5);
            String status=cursor.getString(6);

            BookField bookField=new BookField();
            bookField.setId(id);
            bookField.setIsbn(isbn);
            bookField.setBookName(bookName);
            bookField.setAuther(auther);
            bookField.setInDay(inDay);
            bookField.setOutDay(outDay);
            bookField.setStatus(status);

            bookFields.add(bookField);

            bookField=null;
        }
        return bookFields;
    }
}
