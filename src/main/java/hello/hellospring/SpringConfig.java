package hello.hellospring;
import hello.hellospring.repository.JdbcMemberRepository;
//import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;


/*자바코드로 직접 스프링 빈 등록하는 방법*/
@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em=em;
//    }
//    @Autowired
//    private final MemberRepository memberRepository;
//    public SpringConfig(MemberRepository memberRepository){
//        this.memberRepository=memberRepository;
//    }

    //springBean에 등록할거임
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());   //springbean에 등록돼있는 memberRepository를 memberService에 넣어줘
    }
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource); ->JDBCTemplateMemberRepository
        //return new JpaMemberRepository();

    }
}

