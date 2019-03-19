package com.example.tarpapp

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.widget.Toast
import java.security.AccessControlContext

val DB_NAME="MyDB"
val USER_TABLE="student"
val FORUM_TABLE="forum"
val REPLY_TABLE="reply"
val COL_NAME="name"
val COL_REG="reg"
val COL_PWD="pwd"
val COL_FID = "id"
val COL_POST = "post"
val COL_REPLY = "reply"

class DataBase(var context: Context) : SQLiteOpenHelper(context, DB_NAME,null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createUserTable =
            "CREATE TABLE " + USER_TABLE + " (" + COL_NAME + " VARCHAR(256)," + COL_REG + " VARCHAR(256)," +
                    COL_PWD + " VARCHAR(256));"
        val createForumTable =
            "CREATE TABLE " + FORUM_TABLE + " (" + COL_FID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_POST + " TEXT);"
        val createReplyTable =
            "CREATE TABLE " + REPLY_TABLE + " (" + COL_FID + " INTEGER, " + COL_REPLY + " TEXT ,FOREIGN KEY(" + COL_FID + ") REFERENCES " + FORUM_TABLE + "(" + COL_FID + ") );"

        db?.execSQL(createUserTable)
        db?.execSQL(createForumTable)
        db?.execSQL(createReplyTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertUser(user: student): Boolean {

        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_REG, user.reg)
        cv.put(COL_PWD, user.pwd1)

        var result = db.insert(USER_TABLE, null, cv)

        return result != -1.toLong()
    }

    fun insertPost(post: String): Boolean {

        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_POST, post)

        var result = db.insert(FORUM_TABLE, null, cv)

        return result != -1.toLong()
    }

    fun insertReply(post: String, id:Int): Boolean {

        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_REPLY, post)
        cv.put(COL_FID,id)

        var result = db.insert(REPLY_TABLE, null, cv)

        return result != -1.toLong()
    }

    fun readPosts(): MutableList<String>? {
        val db = this.readableDatabase
        val cur = db.query(FORUM_TABLE, arrayOf(COL_POST), null, null, null, null, null)
        var posts = mutableListOf<String>()

        with(cur) {
            while (moveToNext()) {
                posts.add(getString(0))
            }
        }

        return posts
    }

    fun readPostIds(): MutableList<Int>? {
        val db = this.readableDatabase
        val cur = db.query(FORUM_TABLE, arrayOf(COL_FID), null, null, null, null, null)
        var ids = mutableListOf<Int>()

        with(cur) {
            while (moveToNext()) {
                ids.add(getInt(0))
            }
        }

        return ids
    }

    fun readUserPassword(uname: String): String? {
        val db = this.readableDatabase
        val cur = db.query(USER_TABLE, arrayOf(COL_PWD), COL_REG + " = '" + uname + "'", null, null, null, null)
        var pswd: String? = null

        with(cur) {
            while (moveToNext()) {
                pswd = getString(0)
            }
        }

        return pswd
    }

    fun retrievePost(postID: Int): String? {

        //fetch post content from db from post ID
        val db = this.readableDatabase
        val cur = db.query(FORUM_TABLE, arrayOf(COL_POST), COL_FID + "= '" + postID + "'", null, null, null, null)
        var fid: String? = null
        with(cur) {
            while (moveToNext()) {
                fid = getString(0)
            }

            return fid
        }
    }


        fun retrievePostReplies(postID: Int): MutableList<String>? {

            // fetch each post, in the form of (user id) : (reply) and a line break
            val db = this.readableDatabase
            val cur = db.query(REPLY_TABLE, arrayOf(COL_REPLY), COL_FID + "= '" + postID + "'", null, null, null, null)
            var reply= mutableListOf<String>()
            with(cur) {
                while (moveToNext()) {
                    reply.add(getString(0))
                }

                return reply
            }
        }

}