/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sec1;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


/**
 *
 * @author hema
 */
public class numDiedMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
    
       private Text gender = new Text();
       private IntWritable age = new IntWritable();    
       @Override
       public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {
           String line = value.toString();
           String str[]=line.split(",");
           if(str.length>6){
               gender.set(str[4]);
           if((str[1].equals("0")) ){   
               if(str[5].matches("\\d+")){
                   int i=Integer.parseInt(str[5]);
                   age.set(i);

               }
        }
     }
     context.write(gender, age);

      } 
    
}
