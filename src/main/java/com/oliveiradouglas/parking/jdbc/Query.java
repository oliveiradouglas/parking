package com.oliveiradouglas.parking.jdbc;

import java.util.ArrayList;
import java.util.List;

public class Query {
	private String fields = "*";
	private List<QueryCondition> andWhere = new ArrayList<>();
	private List<QueryCondition> orWhere = new ArrayList<>();
}
