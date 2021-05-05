package edu.weber.cs.jacobgonzales.a2048.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Game {

        //_id: integer primary key auto-increment
        //name: text
        //score: text
        //array: text
        //finished: text


        @PrimaryKey(autoGenerate = true)
        private int _id;

        private String name;

        private String score;

        private String array;

        private String finished;

        @Ignore
        public Game(String name, String score, String array) {
            this.name = name;
            this.score = score;
            this.array = array;
        }

        public Game(int _id, String name, String score, String array, String finished) {
            this._id = _id;
            this.name = name;
            this.score = score;
            this.array = array;
            this.finished = finished;
        }

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getArray() {
            return array;
        }

        public void setArray(String array) {
            this.array = array;
        }

        public String getFinished() {
        return finished;
    }

        public void setFinished(String finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Course{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", array='" + array + '\'' +
                ", finished='" + finished + '\'' +
                '}';
    }
}
