package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRrepository ;

    @BeforeEach
    public void BeforeEach() {
        memberRrepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRrepository);
    }

    @AfterEach
    public void afterEach() {
        memberRrepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");
        // when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findMone(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외 () {
        // given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = member1;
        member2.setName("spring");
        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/
        //then
    }

    @Test
    void findMembers() {
        // given

        // when

        //then
    }

    @Test
    void findMone() {
        // given

        // when

        //then
    }
}