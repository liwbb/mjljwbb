package com.it.instrument;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface JieKou<T> {
  T build(ResultSet rs) throws Exception;
}
