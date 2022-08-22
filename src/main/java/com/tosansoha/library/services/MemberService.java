package com.tosansoha.library.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tosansoha.library.models.Member;
import com.tosansoha.library.repositories.MemberRepository;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public MemberService() {
    }

    public Member addMember(Map<String, String> attributes) {
        /* Member newMember = new Member("Gholi", LocalDate.parse("1957-03-10"), LocalDate.parse("2001-11-09"), null); */
        Member member = MemberRepository.mapToModel(attributes);
        memberRepository.save(member);
        return member;
    }

    public Member updateMember(Integer id, Map<String, String> changes) {
        Member member = memberRepository.findById(id).get();
        member = MemberRepository.updateChanges(member, changes);
        memberRepository.save(member);
        return member;
    }

    public void deleteMember(Integer id) {
        Member book = memberRepository.findById(id).get();
        memberRepository.delete(book);
    }

    public List<Member> getMemberById(Integer id) {
        List<Member> result = new ArrayList<Member>();
        result.add(memberRepository.findById(id).get());
        return result;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
