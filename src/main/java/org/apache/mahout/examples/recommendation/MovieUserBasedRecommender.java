package org.apache.mahout.examples.recommendation;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class MovieUserBasedRecommender {

	private MovieUserBasedRecommender() {
	}

	public static void main(String[] args) throws Exception {

		DataModel model = new FileDataModel(new File(
				"C:/Users/surenr/git/mahout-recommender/src/main/java/org/apache/mahout/examples/recommendation/MoviesList.csv"));


		/*
		 * Here we are using Pearson's Correlation it has limitations such as
		 * that it does not account for the NUMBER of items in which 2 users'
		 * preferences overlap. There are other options such as Euclidean
		 * Distance similarity.
		 */
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

		// First parameter - neighborhood size; capped at the number of users in
		// the data model
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);

		Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

		// First parameter is UserID, the second is the number of items to be
		// recommended
		List<RecommendedItem> recommendations = recommender.recommend(1, 2);

		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}

	}

}
