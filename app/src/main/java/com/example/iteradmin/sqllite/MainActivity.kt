package com.example.iteradmin.sqllite

import android.content.Context
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database=openOrCreateDatabase("database", Context.MODE_PRIVATE,null)
        database.execSQL("CREATE TABLE IF NOT EXISTS student(id number,name VARCHAR,marks number)")

        database.rawQuery("insert into student values(1,'Bibek',100)",null)
        database.rawQuery("insert into student values(2,'Abhijeet',90)",null)
        database.rawQuery("insert into student values(3,'Ankit',80)",null)
        database.rawQuery("insert into student values(4,'Pranit',70)",null)

        val curser: Cursor =database.rawQuery("select * from student",null)



        //curser.moveToFirst();


        Toast.makeText(this,"COL COUNT = "+curser.columnCount,Toast.LENGTH_LONG).show()
        Toast.makeText(this,"Row = "+curser.count,Toast.LENGTH_LONG).show()
        Toast.makeText(this,"NAME OF COLUMN AT POSITION = "
                +curser.columnNames[1],Toast.LENGTH_LONG).show()
        Toast.makeText(this,"COLUMN INDEX = "+curser.getColumnIndex("name"),Toast.LENGTH_LONG).show()
        Toast.makeText(this,"COLUMN NAME = "+curser.getColumnName(1),Toast.LENGTH_LONG).show()


    }
}
