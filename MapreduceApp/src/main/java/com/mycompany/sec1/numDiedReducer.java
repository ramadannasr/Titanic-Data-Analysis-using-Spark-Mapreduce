/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sec1;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author hema
 */
public class numDiedReducer extends Reducer<Text,IntWritable, Text, IntWritable>{
    public void reduce(Text key, Iterable<IntWritable> values, Context context) 
         throws IOException, InterruptedException {
           int sum = 0;
           int l=0;
           for (IntWritable val : values) {
               l+=1;
               sum += val.get();
           }
           sum=sum/l;
           context.write(key, new IntWritable(sum));
       }
    
}
