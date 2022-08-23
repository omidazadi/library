package com.tosansoha.library.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tosansoha.library.models.Member;
import com.tosansoha.library.models.Ownership;
import com.tosansoha.library.repositories.MemberRepository;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public MemberService() {
    }

    public Member addMember(Map<String, String> attributes) {
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
        Member member = memberRepository.findById(id).get();
        memberRepository.delete(member);
    }

    public List<Member> getMemberById(Integer id) {
        List<Member> result = new ArrayList<Member>();
        result.add(memberRepository.findById(id).get());
        return result;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public List<Ownership> getAllOwnedBooks(Integer id) {
        Member member = memberRepository.findById(id).get();
        return new ArrayList<Ownership>(member.getOwnerships());
    }
}
