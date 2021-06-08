/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 类型处理器
 * @author Clinton Begin
 */
public interface TypeHandler<T> {

  /**
   * 往Statement中设置参数，javaType 转 jdbcType
   * @param ps
   * @param i
   * @param parameter
   * @param jdbcType
   * @throws SQLException
   */
  void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

  /**
   * 返回值转换，jdbcType 转 javaType
   * @param rs
   * @param columnName 列名
   * @return
   * @throws SQLException
   */
  T getResult(ResultSet rs, String columnName) throws SQLException;

  /**
   * 返回值转换，jdbcType 转 javaType
   * @param rs
   * @param columnIndex 列索引
   * @return
   * @throws SQLException
   */
  T getResult(ResultSet rs, int columnIndex) throws SQLException;

  /**
   * 返回值转换，jdbcType 转 javaType（存储过程）
   * @param cs
   * @param columnIndex
   * @return
   * @throws SQLException
   */
  T getResult(CallableStatement cs, int columnIndex) throws SQLException;

}
