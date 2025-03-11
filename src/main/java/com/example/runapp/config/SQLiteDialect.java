package com.example.runapp.config;

import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.dialect.pagination.LimitOffsetLimitHandler;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StandardBasicTypes;

import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;


public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super(DatabaseVersion.make(3));

        // Register basic SQLite column types

        registerColumnType(java.sql.Types.INTEGER, "integer");
        registerColumnType(java.sql.Types.FLOAT, "float");
        registerColumnType(java.sql.Types.DOUBLE, "double");
        registerColumnType(java.sql.Types.VARCHAR, "varchar");
        registerColumnType(java.sql.Types.BLOB, "blob");
        registerColumnType(java.sql.Types.CLOB, "clob");
        registerColumnType(java.sql.Types.BOOLEAN, "integer");

        // Register basic functions
        registerFunction("concat", new VarArgsSQLFunction(StringType.INSTANCE, "", "||", ""));
        registerFunction("mod", new SQLFunctionTemplate(IntegerType.INSTANCE, "?1 % ?2"));
        registerFunction("substr", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
        registerFunction("substring", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
    }



    @Override
    public LimitHandler getLimitHandler() {
        return LimitOffsetLimitHandler.INSTANCE;
    }

    @Override
    public NameQualifierSupport getNameQualifierSupport() {
        return NameQualifierSupport.NONE;
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl();
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsCascadeDelete() {
        return false;
    }

    @Override
    public boolean doesReadCommittedCauseWritersToBlockReaders() {
        return false;
    }

    @Override
    public boolean supportsLockTimeouts() {
        return false;
    }

    @Override
    public boolean isJdbcLogWarningsEnabledByDefault() {
        return false;
    }
}
