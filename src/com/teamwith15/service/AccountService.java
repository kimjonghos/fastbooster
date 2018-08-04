package com.teamwith15.service;

public class AccountService {
	private static AccountService accountService;
	private MemberService memberService;
	private PologService pologService;
	private ProfileService profileService;
	private ApplicationService applicationService;

	static {
		accountService = new AccountService();
	}

	private AccountService() {
		memberService = MemberService.getInstance();
		//pologService = PologService.getInstance();
		profileService = ProfileService.getInstance();
		//applicationService = ApplicationService.getInstance();
	}
	public static AccountService getInstance() {
		return accountService;
	}

}
