package com.employeeapp.service;

import org.springframework.stereotype.Service;
import com.employeeapp.model.Benefits;
import com.employeeapp.repository.IBenefitsRepository;

@Service
public class BenefitsServiceImpl implements IBenefitService{
		IBenefitsRepository benefitRepository;
		public void BenefitServiceImpl(IBenefitsRepository benefitRepository) {
			this.benefitRepository = benefitRepository;
		}
	@Override
	public void addBenefits(Benefits benefits) {
		this.benefitRepository.addBenefits(benefits);
	}

}
