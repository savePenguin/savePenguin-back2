package com.cos.photogramstart.web;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.dao.QRcodeRepository;
import com.cos.photogramstart.domain.point.PointRepository;
import com.cos.photogramstart.domain.qr.QRcode;

@RestController
//@ResponseBody
public class PointListController {
    PointRepository pointRepository;
    
    public PointListController(PointRepository pointRepository) {
		super();
		this.pointRepository = pointRepository;
	}
    
    
	
	@RequestMapping(value = "/user/pointlist/{userid}")
	public void PointList(@PathVariable("userid") String userid) {
		
		
		//@SuppressWarnings("null")
		int count = pointRepository.countByUserid(userid);
		
		System.out.println(pointRepository.sellectAllPoint(userid).toString());
		System.out.println(pointRepository.sellectAllPoint(userid).size());
		
		
		List<Object[]> results = pointRepository.sellectAllPoint(userid);
		
		for(Object[] result : results ) {
			System.out.println(result[0]);
			System.out.println(result[1]);

		}
		
		//HashMap<String,byte[]> hashmap = new HashMap<>();
		for(int i = 0 ; i < count; i++) {
			System.out.println("hello");
		}
	}

}