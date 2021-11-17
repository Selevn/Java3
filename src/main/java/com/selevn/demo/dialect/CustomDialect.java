package com.selevn.demo.dialect;
import org.hibernate.dialect.PostgreSQL10Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class CustomDialect extends PostgreSQL10Dialect{
    public CustomDialect() {
        super();
        registerFunction("get_cookbooks"
                , new StandardSQLFunction("get_cookbooks",
                        new StringType()));
    }
}