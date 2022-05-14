package co.kr.spring.mng.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import co.kr.spring.mng.service.inf.GlobalScheduler;

@Service
public class GlobalSchedulerImpl implements GlobalScheduler {
	
	private Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public void lawMaking() {
//		logger.info("정부/국회 입법현황 스케쥴러 시작");
//		lawMakingGov();
//		
//		lawMakingNsm();
//		logger.info("정부/국회 입법현황 스케쥴러 종료");
	}
	//정부
	private void lawMakingGov() {
//		logger.info("정부 입법현황 스케쥴러 시작");
//		logger.info("정부 입법현황 스케쥴러 종료");
	}
	//국회
	private void lawMakingNsm() {
//		logger.info("국회 입법현황 스케쥴러 시작");
//		logger.info("국회 입법현황 스케쥴러 종료");
	}

}
