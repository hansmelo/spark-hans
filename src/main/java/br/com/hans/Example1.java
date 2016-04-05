package br.com.hans;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class Example1 {

	public static void main(String[] args) {

		SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("BusProcessor");
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
		SQLContext sqlContext = new SQLContext(sparkContext);

		JavaRDD<String> linhas = sparkContext.textFile("stops.txt");
		JavaRDD<Bus> bus = linhas
				.map(x -> x.split(","))
				.map(o -> new Bus(o[0], o[1], o[2], o[3], o[4]));

		DataFrame busDataFrame = sqlContext.createDataFrame(bus, Bus.class);

		busDataFrame.show();
	}
}
