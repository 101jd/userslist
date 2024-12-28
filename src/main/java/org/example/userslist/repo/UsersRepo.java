package org.example.userslist.repo;

import lombok.AllArgsConstructor;
import org.example.userslist.model.User;
import org.example.userslist.repo.sql.Queries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UsersRepo {
    private final JdbcTemplate template;

    private final String TABLE = "users";
    private final String columnId = "id";
    private final String columnName = "name";
    private final String GETALL = Queries.SELECT.get() + TABLE + Queries.ENDQUERY.get();
    private final String INSERTUSER = Queries.INSERT.get() + TABLE + Queries.COLUMNNAME.get() + Queries.VALUES.get() + Queries.ENDQUERY.get();
    private final String DELETEUSER = String.format(Queries.DELETE.get() + TABLE + Queries.WHERE.get() + Queries.ENDQUERY.get());

    public List<User> getUsers(){
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObj = new User();
            rowObj.setId(r.getInt(columnId));
            rowObj.setName(r.getString(columnName));
            return rowObj;
        };
        return template.query(GETALL, userRowMapper);
    }

    public User addUser(User user){
        template.update(INSERTUSER, user.getName());
        return user;
    }

    public User delete(User user){
        template.update(DELETEUSER, user.getId());
        return user;
    }
}
