package com.arslanka.backend.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;

public abstract class DatabaseStorage {

    public static final String DB_TYPE_POSTGRESQL = "Postgres";

    public static DatabaseStorage initialize(final Config configDb, final HikariPoolCfg hikariConfig) throws SQLException {
        if (configDb.database().type().equalsIgnoreCase(DB_TYPE_POSTGRESQL)) {
            return new SimpleRepository(configDb, hikariConfig);
        }
        throw new SQLException();
    }

    public abstract <T> T withConnection(Action<T> action, SQLDialect sqlDialect) throws SQLException;

    public abstract DataSource dataSource() throws SQLException;

    public abstract void disconnect() throws SQLException;

    @FunctionalInterface
    interface Action<T> {
        T execute(DSLContext dslContext) throws SQLException;
    }
}

