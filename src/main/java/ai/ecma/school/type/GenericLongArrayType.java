package ai.ecma.school.type;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class GenericLongArrayType<T extends Serializable> implements UserType<Long> {
    protected static final int[] SQL_TYPES = {Types.ARRAY};
    private Class<T> typeParameterClass;

    @Override
    public int getSqlType() {
        return Types.ARRAY;
    }

    @Override
    public Class returnedClass() {
        return typeParameterClass;
    }

    @Override
    public boolean equals(Long aLong, Long j1) {
        if (aLong == null) {
            return j1 == null;
        }
        return aLong.equals(j1);
    }

    @Override
    public int hashCode(Long aLong) {
        return aLong.hashCode();
    }

    @Override
    public Long nullSafeGet(ResultSet resultSet, int i, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws SQLException {
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Long aLong, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {

    }

    @Override
    public Long deepCopy(Long aLong) {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Long aLong) {
        return null;
    }

    @Override
    public Long assemble(Serializable serializable, Object o) {
        return null;
    }
}
