/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.job;

import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;


/**
 *
 * 
 * @author Ramadan Nasr
 */
public class Job2 {

    public static void main(String[] args) {
       // System.setProperty("hadoop.home.dir", "C:\\winutils\\bin");
        SparkConf c = new SparkConf().setAppName("Job 2").setMaster("local[*]");
        
        JavaSparkContext javaSparkContext = new JavaSparkContext(c);
        SQLContext sqlContext = new SQLContext(javaSparkContext);
        
        
        JavaRDD<Person> data = javaSparkContext.textFile("TitanicData.txt").map(
                  new Function<String, Person>() {
    @Override
    public Person call(String line) throws Exception {
      String[] parts = line.split(",");
      Person person = new Person();
      if(parts.length>6){
      person.setSex(parts[4]);
      person.setPassengerId(Integer.parseInt(parts[0]));
      if(parts[5].matches("\\d+")){
      person.setAge(Integer.parseInt(parts[5]));
      }
      
      }

      return person;
    }
  });
     
     DataFrame schemaPeople = sqlContext.createDataFrame(data, Person.class);
     schemaPeople.registerTempTable("people"); 
     //Job 1 :Find the average age of males and females who died in the Titanic tragedy
     DataFrame avgNumberSurvived = sqlContext.sql("SELECT sex,age,count(passengerId)  FROM people  Group by sex,age ");

List<String> ResultInformation = avgNumberSurvived.javaRDD().map(new Function<Row, String>() {
  @Override
  public String call(Row row) {
    return "Gender: " + row.getString(0)+"  Age: "+row.getInt(1)+"  Count: "+row.getLong(2);
  }
}).collect();
int i = 0;
System.out.println("\n\n***  number of people died or survived with their genders and ages. ***");
for(i =0 ; i<ResultInformation.size();i++)
{
    
    System.out.println("\n\n[*_*] "+ResultInformation.get(i));
}



       
    

}}
