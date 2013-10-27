package org.apache.mahout.examples.recommendation;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.similarity.AbstractItemSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;

public class PromotionItemSimilarity extends AbstractItemSimilarity {

	protected PromotionItemSimilarity(DataModel dataModel) {
		super(dataModel);
	}

	public double itemSimilarity(long itemID1, long itemID2) throws TasteException {
		Promotion promo1 = lookupPromotion(itemID1);
		Promotion promo2 = lookupPromotion(itemID2);
		double similarity = 0.0;
		if (promo1.getPromoterName().equalsIgnoreCase(promo2.getPromoterName())) {
			similarity += 0.5;
		}
		if (promo1.getCity().equalsIgnoreCase(promo2.getCity())) {
			similarity += 0.3;
		}
		//Add any further custom logic
		return similarity;
	}

	public double[] itemSimilarities(long itemID1, long[] itemID2s) throws TasteException {
		double[] similarities = new double[itemID2s.length];
		int index = 0;
		for(long id : itemID2s) {
			similarities[index] = itemSimilarity(itemID1, id);
			index++;
		}
		return similarities;
	}

	private Promotion lookupPromotion(long itemID1) {
		// Implement your logic
		return new Promotion();
	}

}
