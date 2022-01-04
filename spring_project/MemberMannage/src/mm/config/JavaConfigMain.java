package mm.config;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

@configuration
@Import(JavaConfigSeb.class)
public class JavaConfigMain {

	// MemberDao
	@Bean(name = "dao")
	@Scope(value = "Singleton")
	public MemberDao memberDao() {
		return MemberDao();
	}

	// MemberRegService : dao주입
	@Bean
	public MemberRegService regService() {
		return new MemberRegService(memberDao());
	}

}
