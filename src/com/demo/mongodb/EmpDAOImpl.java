package com.demo.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.bulk.WriteRequest;
import com.mongodb.client.MongoDatabase;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public void save(List<EmployeeDetails> empDetailsList) {
		// MongoDatabase db = ConnectionProvider.getInstance().getDBConnection();
		// System.out.println("Collection name
		// is:"+db.getCollection("employee_details").getNamespace().getCollectionName());
		// DB table = (DB) db.getCollection("employee_details");

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("employee");
		DBCollection items = db.getCollection("employee_details");
		List<BasicDBObject> docList = new ArrayList<BasicDBObject>();

		for (int i = 0; i < empDetailsList.size(); i++) {
			BasicDBObject doc = new BasicDBObject();
			doc.put("empId", empDetailsList.get(i).getEmpID());
			doc.put("empName", empDetailsList.get(i).getEmpName());
			doc.put("empSalary", empDetailsList.get(i).getEmpSalary());
			docList.add(doc);

		}
		items.insert(docList);

	}

	@Override
	public void update(List<EmployeeDetails> empDetailsList) {

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("employee");
		DBCollection items = db.getCollection("employee_details");
		
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("empName", "Shalini Pandey:"));

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("empName", "Sumit kumar");

		items.updateMulti(searchQuery, updateQuery);
		
		printAllDocuments(empDetailsList);

	}

	@Override
	public void printAllDocuments(List<EmployeeDetails> empDetailsList) {

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("employee");
		DBCollection items = db.getCollection("employee_details");
		DBCursor cursor = items.find();
		while (cursor.hasNext()) {
			System.out.println("Print Documents ..." + cursor.next());
		}

	}

	@Override
	public void deleteDocuments(List<EmployeeDetails> empDetailsList) {
		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("employee");
		DBCollection items = db.getCollection("employee_details");
		//BasicDBObject searchQuery = new BasicDBObject();
		//searchQuery.append("empName", "Shalini Pandey");
		
		
		printAllDocuments(empDetailsList);
	}

}


