package org.example.userslist.repo.sql;

public enum Queries {
    SELECT("SELECT * FROM "), INSERT("INSERT INTO "), COLUMNNAME("(name)"), VALUES(" VALUES (?)")
    , UPDATE("UPDATE "), WHERE(" WHERE id=?"), DELETE("DELETE FROM "), ENDQUERY(";")
    ;
    String q;
    Queries(String q) {

        this.q = q;
    }
    public String get(){
        return q;
    }
}
