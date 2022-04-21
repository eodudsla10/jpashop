package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

//    //spring이 entitiymanager를 만들어서 해당 변수에 주입한다.
//    //원래 코드
//    @PersistenceContext
//    private EntityManager em;

    //springboot에서는 Autowired도 EntityManager를 생성할 수 있게 만들었다.
    //따라서 생성자 주입 사용 가능(@RequiredArgsConstructor)
    private final EntityManager em;

    //영속성 저장
    public void save(Member member) {
        em.persist(member);
    }

    //조회
    public Member findone(Long id) {
        return em.find(Member.class, id);
    }

    //리스트 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m ", Member.class).getResultList();
    }

    //이름 조회
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
