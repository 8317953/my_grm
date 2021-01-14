package com.haut.grm.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haut.grm.bean.JwtTokenUtils;
import com.haut.grm.model.dto.AnaZbMb;
import com.haut.grm.model.meta.User;

@RestController
public class CeshiController {

	@RequestMapping(value={"/stock/out_finish11111"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public void outFinish(@RequestBody User user) {
		System.out.println(user.getTelephone());
		System.out.println(JwtTokenUtils.myjwt.getUsernameFromToken(user.getTelephone()));
	}
}
