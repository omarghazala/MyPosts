package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Statement;

public class V2__insertUsers extends BaseJavaMigration {

    private static final BCryptPasswordEncoder B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Override
    public void migrate(Context context) throws Exception {
        Statement statement = context.getConnection().createStatement();

        statement.execute(
                "insert into users (user_name,user_password,full_name) values ('user1','" + B_CRYPT_PASSWORD_ENCODER.encode("111") + "','user 1')");

        statement.execute(
                "insert into users (user_name,user_password,full_name) values ('user2','" + B_CRYPT_PASSWORD_ENCODER.encode("222") + "','user 2')");
        statement.execute(
                "insert into users (user_name,user_password,full_name) values ('user3','" + B_CRYPT_PASSWORD_ENCODER.encode("333") + "','user 3')");
    }
}
