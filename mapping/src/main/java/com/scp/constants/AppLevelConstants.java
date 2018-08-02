package com.scp.constants;

public interface AppLevelConstants {
	String HQL_GET_ALL_PRODUCT = "from Product";
	String HQL_GET_PRICE_GREATER_THAN = "from Product where price >=:price";
	String HQL_GET_PRICE_GREATER_THAN_AND_NAME = "from Product where price>=?1 and name=?2";

	String SQL_GET_ALL_PRODUCT = "select * from Product";
	String SQL_GET_PRICE_GREATER_THAN = "select * from Product where price >=:price";
	String SQL_GET_PRICE_GREATER_THAN_AND_NAME = " select * from Product where price>=?1 and name=?2";
}
