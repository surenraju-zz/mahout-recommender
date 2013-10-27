package org.apache.mahout.examples.recommendation;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class MovieItemBasedRecommender {

	public static void main(String a[]) {
		DataModel model;
		try {
			model = new FileDataModel(new File(
					"C:/Users/surenr/git/mahout-recommender/src/main/java/org/apache/mahout/examples/recommendation/MoviesList.csv"));

			ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);

			Recommender recommender = new GenericItemBasedRecommender(model, similarity);

			List<RecommendedItem> recommendations = recommender.recommend(1, 2);

			for (RecommendedItem recommendation : recommendations) {
				System.out.println(recommendation);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
