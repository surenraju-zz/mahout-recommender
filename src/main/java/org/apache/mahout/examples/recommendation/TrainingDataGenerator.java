package org.apache.mahout.examples.recommendation;

import java.io.FileWriter;
import java.util.Random;

public class TrainingDataGenerator {

	public static void main(String a[]) {

		try {

			FileWriter writer = new FileWriter("PromotionData.csv");

			for (int i = 1; i <= 100; i++) {
				for (int likesCount = 1; likesCount <= 25; likesCount++) {
					Random rand = new Random();
					writer.append(i + "," + rand.nextInt(200));
					if (likesCount != 25) {
						writer.append('\n');
					}
				}
				writer.append('\n');
			}
			
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Completed");
	}

}
