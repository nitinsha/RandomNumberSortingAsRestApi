package com.nitin.demorandomsort;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.nitin.demorandomsort.business.domain.RandomNumberSort;
import com.nitin.demorandomsort.data.repository.RandomNumberSortingRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RandomNumberSortingRepositoryTests {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	RandomNumberSortingRepository randomNumberSortingRepository;

	@Test
	public void addRecordAndCountSuccess() {
		int[] origArray = { 2, 7, 9, 1, 6, 0, 1 };
		int[] sortArray = { 0, 1, 1, 2, 6, 7, 9 };
		int noOfExchange = 4;
		long time = 2222;
		RandomNumberSort randonNumberSort = new RandomNumberSort(origArray, sortArray, noOfExchange, time);
		entityManager.persist(randonNumberSort);
		entityManager.flush();
		
		long count = randomNumberSortingRepository.count();
		assertThat(count==1);
		
	}
}
