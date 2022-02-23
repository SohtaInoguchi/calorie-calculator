package com.example.polyglottal_calculator2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String COLUMN_ID = "id";
    public static final String TRAINEE_TABLE = "TRAINEE_TABLE";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_TARGET_WEIGHT = "target_weight";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_ACTIVE_LEVEL = "active_level";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "trainee.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("In oncreate databasehelper");
        String createTableStatement = "CREATE TABLE " + TRAINEE_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TARGET_WEIGHT + " INT, " + COLUMN_WEIGHT + " INT, " + COLUMN_NAME + " TEXT, " + COLUMN_HEIGHT + " INT, " + COLUMN_AGE + " INT, " + COLUMN_GENDER + " TEXT, " + COLUMN_ACTIVE_LEVEL + " TEXT)";
        db.execSQL(createTableStatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(TrainerrModel trainerrModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TARGET_WEIGHT, trainerrModel.getTargetWeight());
        cv.put(COLUMN_WEIGHT, trainerrModel.getWeight());
        cv.put(COLUMN_NAME, trainerrModel.getName());
        cv.put(COLUMN_HEIGHT, trainerrModel.getHeight());
        cv.put(COLUMN_AGE, trainerrModel.getAge());
        cv.put(COLUMN_GENDER, trainerrModel.getGender());
        cv.put(COLUMN_ACTIVE_LEVEL, trainerrModel.getActiveLevel());
        System.out.println(cv);

        long insert = db.insert(TRAINEE_TABLE, null, cv);
        System.out.println(insert);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
}
