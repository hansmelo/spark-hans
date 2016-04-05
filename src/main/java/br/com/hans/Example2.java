package br.com.hans;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class Example2 {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("BusProcessor");
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

		JavaRDD<String> bus = sparkContext.textFile("stops.txt");

		JavaPairRDD<String, Integer> joinBus = bus
				.mapToPair(string -> new Tuple2<String, Integer>(string.split(",")[2], 1));
		
		JavaPairRDD<String, Integer> numberBus = joinBus.reduceByKey((x, y) -> x + y);
		List<Tuple2<String, Integer>> list = numberBus.collect();

		for (Tuple2<String, Integer> busNumber : list) {
			System.out.println("linha: " + busNumber._1());
			System.out.println("Número de ônibus: " + busNumber._2());
		}

		sparkContext.close();
	}

}
