package org.karpukhin.springmvcdemo.service;

import org.karpukhin.springmvcdemo.model.Classification;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface ClassificationService {

	/**
	 *
	 * @return
	 */
	List<Classification> getAllClassifications();
}
