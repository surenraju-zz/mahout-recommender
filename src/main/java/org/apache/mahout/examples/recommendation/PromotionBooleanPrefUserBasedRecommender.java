package org.apache.mahout.examples.recommendation;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.RMSRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class PromotionBooleanPrefUserBasedRecommender {

	public static void main(String[] args) throws Exception {

		DataModel model = new FileDataModel(new File(
				"C:/Users/surenr/git/mahout-recommender/src/main/java/org/apache/mahout/examples/recommendation/PromotionData.csv"));

		RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
			public Recommender buildRecommender(DataModel model) throws TasteException {
				UserSimilarity similarity = new LogLikelihoodSimilarity(model);
				UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
				Recommender recommender = new GenericBooleanPrefUserBasedRecommender(model, neighborhood, similarity);
				return recommender;
			}
		};

		Recommender recommender = recommenderBuilder.buildRecommender(model);

		List<RecommendedItem> recommendations = recommender.recommend(1, 2);

		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}

		RecommenderEvaluator rmsEvaluator = new RMSRecommenderEvaluator();
		double score = rmsEvaluator.evaluate(recommenderBuilder, null, model, 0.95, 0.05);
		System.out.println("RMS Evaluator Score: " + score);

		RecommenderEvaluator aadEvaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		score = aadEvaluator.evaluate(recommenderBuilder, null, model, 0.95, 0.05);
		System.out.println("Average Absolute Difference Evaluator Score: " + score);
		
		RecommenderIRStatsEvaluator statsEvaluator = new GenericRecommenderIRStatsEvaluator();
        IRStatistics stats = statsEvaluator.evaluate(recommenderBuilder, null, model, null, 2, GenericRecommenderIRStatsEvaluator.CHOOSE_THRESHOLD, 1.0);
 
        System.out.println("Precision: " + stats.getPrecision());
        System.out.println("Recall: "+stats.getRecall());  
       

	}

}
