package edu.weber.cs.jacobgonzales.a2048.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GameDAO {

        @Query("select * from game")
        LiveData<List<Game>> getAll();

        @Query("select * from game where _id = :id")
        List<Game> loadByID(int id);

        @Insert
        void insert(Game game);

        @Update
        void update(Game game);

        @Delete
        void delete(Game game);

}

