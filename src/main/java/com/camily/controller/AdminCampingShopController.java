package com.camily.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camily.dto.GoodsDto;
import com.camily.service.AdminCampingShopService;

@Controller
public class AdminCampingShopController {
   
	@Autowired
	AdminCampingShopService acsvc;
	
	// 관리자 캠핑 용품 페이지 이동 요청 
	@RequestMapping(value="/adminCampingShop")
	public ModelAndView adminCampingShop(){
        
		ModelAndView mav = acsvc.adminCampingShop();
 
		return mav;
	}
	
	// 관리자 캠핑용품 상태 변경 ajax
	@RequestMapping(value="/campingShopState")
	public @ResponseBody String campingShopState(String gcode, String gstate) {
		System.out.println("gcode :"+ gcode);
		System.out.println("gstate :"+ gstate);
		
		String campingShopState = acsvc.campingShopState(gcode,gstate);
		
		return campingShopState;
	}
	
	// 관리자 캠핑용품 수정 페이지 
	@RequestMapping(value="/productmodify")
	public ModelAndView productmodify(String gcode) {
	     System.out.println("gcode :"+ gcode);
		 
	     ModelAndView mav = acsvc.productmodify(gcode);
	      	     
	     return mav;
	}
	
	// 관리자 캠핑 용품 수정
	@RequestMapping(value="/modifyUpdate")
	public ModelAndView modifyUpdate(RedirectAttributes ra, GoodsDto goods) throws IllegalStateException, IOException{
		System.out.println("goods :"+ goods);

		// 관리자 캠핑 용품 수정 서비스 이동
		ModelAndView mav = acsvc.modifyUpdate(ra,goods);	      		
		return mav;
	}
	
	// 관리자 캠핑 용품 등록 페이지 
	@RequestMapping(value="/AdminProductInsert")
	public String AdminProductInsert() {
		System.out.println("캠핑 용품 등록 페이지 이동!");
		
		return "admin/AdminProductInsert";
	}
	
	// 관리자 캠핑 용품 등록
	@RequestMapping(value="/produckAdd")
	public ModelAndView produckAdd(RedirectAttributes ra, GoodsDto goods) throws IllegalStateException, IOException {
		System.out.println("goods :"+ goods);

		// 관리자 캠핑 용품 등록 서비스 이동
		ModelAndView mav = acsvc.produckAdd(ra,goods);
		
		return mav;
	}
	
	// 관리자 캠핑 용품 배송 관리 
	@RequestMapping(value="/AdminCampingSendProduckt")
	public ModelAndView AdminCampingSendProduckt() {
		
		// 관리자 캠핑 용품 배송 관리 서비스 이동
		ModelAndView mav = acsvc.AdminCampingSendProduckt();
		
		return mav; 
		
	}
	
	// 관리자 캠핑 용품 배송중으로 변경 ajax 
	@RequestMapping(value="/send")
	public @ResponseBody String send(String gocode) {
		System.out.println("gocode :"+ gocode);
		
		// 관리자 캠핑 용품 배송중 서비스 이동
		String send = acsvc.send(gocode);
		
		return send;
	}
	
	// 관리자 캠핑 용품 배송완료 변경 ajax 
	@RequestMapping(value="/sendtake")
	public @ResponseBody String sendtake(String gocode) {
		System.out.println("gocode :"+ gocode);
		
		// 관리자 캠핑 용품 배송완료 서비스 이동
		String sendtake = acsvc.sendtake(gocode);
		
		return sendtake;
	}
	
	// 관리자 캠핑 용품 취소관리 페이지 이동요청
	@RequestMapping(value="AdminCampingCancel")
	public ModelAndView AdminCampingCancel() {
		
		// 관리자 캠핑 용품 취소관리 페이지 
		ModelAndView mav = acsvc.AdminCampingCancel();
		
		return mav;
	}
	
	// 관리자 취소승인 ajax
	@RequestMapping(value="/cancelOk")
	public @ResponseBody String cancelOk(String gocode) {
	    System.out.println("gocode :"+ gocode);
		
		// 관리자 캠핑 용품 취소승인 서비스 이동
		String cancelOk = acsvc.cancelOk(gocode);
		
		return cancelOk;
	}
	
	// 관리자 취소거절 ajax
	@RequestMapping(value="/cancelNo")
	public @ResponseBody String cancelNo(String gocode) {
	    System.out.println("gocode :"+ gocode);
		
		// 관리자 캠핑 용품 취소거절 서비스 이동
		String cancelNo = acsvc.cancelNo(gocode);
		
		return cancelNo;
	}
	
	// 관리자 취소목록 
	@RequestMapping(value="/AdminCampingCancelList")
	public ModelAndView AdminCampingCancelList() {
		
		// 관리자 취소목록
		ModelAndView mav = acsvc.AdminCampingCancelList();
				
		return mav;
	}
}
