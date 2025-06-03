package hello.mvc.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository memberRepository = new MemberRepository();

    public static MemberRepository getInstance() {
        return memberRepository;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Member findByName(String name) {
        for (Member member : store.values()) {
            if (member.getUsername().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<Member> findByAll() {
        return new ArrayList<>(store.values());
    }

    public void delete(Long id) {
        store.remove(id);
    }

    public void update(Long id, Member updatedMember) {
        Member member = store.get(id);
        if (member != null) {
            member.setUsername(updatedMember.getUsername());
            member.setAge(updatedMember.getAge());
        }
    }

    public void clearStore() {
        store.clear();
    }

}
