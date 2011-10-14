package org.karpukhin.springmvcdemo.service.impl;

import org.karpukhin.springmvcdemo.model.Classification;
import org.karpukhin.springmvcdemo.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Service
public class ClassificationServiceImpl implements ClassificationService {

	@Override
	public List<Classification> getAllClassifications() {
		List<Classification> result = new ArrayList<Classification>();
		result.add(new Classification(1, "Championship competition"));
		result.add(new Classification(2, "Open competition"));
		result.add(new Classification(2, "Regional competition"));
		return result;
	}
}
